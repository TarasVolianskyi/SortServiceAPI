/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volianskyi.sortserviceapi.service;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author tarasvolianskyi
 */
public class SortServiceHelper {

    private ExecutorService executorService;

    public SortServiceHelper() {
        executorService = Executors.newFixedThreadPool(1);//Number of threads
    }

    public JSONObject startService(String jsonString) {
        JSONObject resultJSONObject = null;
        try {
            SortService sortService = new SortService(getIntArrayFromJsonString(jsonString));
            if (getBooleanFromJsonString(jsonString) == false) {
                sortService.sortServ(SortService.ASC);
            } else {
                sortService.sortServ(SortService.DESK);
            }

            Future<JSONObject> futureJsonObj = executorService.submit(sortService);
            resultJSONObject = futureJsonObj.get();
        } catch (InterruptedException ex) {
            Logger.getLogger(SortServiceHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(SortServiceHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultJSONObject;
    }

    private static int[] getIntArrayFromJsonString(final String source) {
        JSONObject jSONObject = null;
        String dataForArray = "";
        try {
            jSONObject = new JSONObject(source);
            String dataFromJson = jSONObject.getJSONArray("array").toString();
            dataForArray = dataFromJson.substring(1, dataFromJson.length() - 1);
        } catch (JSONException ex) {

        }
        String[] integersAsText = dataForArray.split(",");
        int[] results = new int[integersAsText.length];
        int i = 0;
        for (String textValue : integersAsText) {
            results[i] = Integer.parseInt(textValue);
            i++;
        }
        return results;
    }

    private static boolean getBooleanFromJsonString(final String source) {
        JSONObject jSONObject = null;
        boolean booleanDataFromJson = false;
        try {
            jSONObject = new JSONObject(source);
            booleanDataFromJson = jSONObject.getBoolean("descending");
        } catch (JSONException ex) {

        }
        return booleanDataFromJson;
    }

}
