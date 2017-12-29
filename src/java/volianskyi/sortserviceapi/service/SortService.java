/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volianskyi.sortserviceapi.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author tarasvolianskyi
 */
public class SortService implements Callable<JSONObject> {

    public static final int ASC = 1;
    public static final int DESK = 2;

    private int[] myListSort;

    public SortService(int[] myListSort) {
        this.myListSort = myListSort;
    }

    public int[] sortServ(int typeOfSort) {
        //Arrays.sort(myListSort);
        if (typeOfSort == ASC) {
            SortingMethods se = new SortingMethods();
            se.sort(myListSort);
        } else if (typeOfSort == DESK) {
            SortingMethods se = new SortingMethods();
            se.sort(myListSort);
            reverseArray(myListSort);
        }
        return myListSort;
    }

    public void printArray() {
        for (int i = 0; i < myListSort.length; i++) {
            System.out.println(myListSort[i]);
        }
    }

    public static int[] createNewArray(int length, int delta) {
        int[] resultArray = new int[length];
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = (int) (Math.random() * delta);
        }

        return resultArray;
    }

    @Override
    public JSONObject call() throws Exception {
        JSONObject result = new JSONObject();
        //Thread.sleep(60000);
        result.put("result", myListSort);
        return result;
    }

    public static void reverseArray(int[] arrayForReverse) {
        for (int i = 0; i < arrayForReverse.length / 2; i++) {
            int temp = arrayForReverse[i];
            arrayForReverse[i] = arrayForReverse[arrayForReverse.length - 1 - i];
            arrayForReverse[arrayForReverse.length - 1 - i] = temp;
        }
    }
}
