package org.sibqa;

import java.io.FileNotFoundException;
import java.io.FileReader;

public final class SBQHelper {

    //Public functions
    public static FileReader loadData(String fileName)
    {
        FileReader frReturn = null;

        try {
            frReturn = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return frReturn;
    }
}
