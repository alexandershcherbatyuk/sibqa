package org.sibqa;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.io.entity.StringEntity;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.http.HttpResponse;

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
