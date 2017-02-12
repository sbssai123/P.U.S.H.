package com.example.schou.push;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;

import java.io.IOException;

import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;

public class BsyncTask extends AsyncTask {

    private static String userId = "u-6kaarnu3kfgeodbaawdyaxi";
    private static String apiToken = "t-hwwtdcfowaddpuc6z6jhj5q";
    private static String apiSecret = "nhjghkxdfaxvoic4puc5iufbibpca56hipznfha";


    @Override
    protected Object doInBackground(Object[] objects) {
        String url = "https://api.catapult.inetwork.com/v1/users/" + userId + "/messages";
        String creds = String.format("%s:%s", apiToken, apiSecret);
        final String auth = "Basic " + Base64.encodeToString(creds.getBytes(), Base64.DEFAULT);

        final MediaType JSON
                = MediaType.parse("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();

        client = new OkHttpClient.Builder()
                .authenticator(new Authenticator() {
                    @Override public Request authenticate(Route route, Response response) throws IOException {
                        System.out.println("Authenticating for response: " + response);
                        System.out.println("Challenges: " + response.challenges());
                        String credential = Credentials.basic(apiToken, apiSecret);
                        return response.request().newBuilder()
                                .header("Authorization", credential)
                                .build();
                    }
                })
                .build();

        String json = "[{\"from\":\"+num0\","
                + "\"to\":\"+num1\","
                + "\"text\":\"wooork\"" + "},"
                + "{\"from\":\"+num0\","
                + "\"to\":\"+num2\","
                + "\"text\":\"wooork\"" + "},"
                + "{\"from\":\"+num0\","
                + "\"to\":\"+num3\","
                + "\"text\":\"wooork\"" + "}"
                + "]";

        String resp = "";
        try {
            //String post(String url, String json) throws IOException {
            RequestBody body = RequestBody.create(JSON, json);
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();
            Response response = client.newCall(request).execute();
            resp = response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(resp);
        return null;
    }
}
