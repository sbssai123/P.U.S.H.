package com.example.code.push;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

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

    private SharedPreferences shared = MainActivity.shared;


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

        //shared = getSharedPreferences(MainActivity.PREF_NAME, Context.MODE_PRIVATE);
        String defaultGroup = shared.getString(MainActivity.DEFAULT_GROUP, "");
        String defaultMessage = shared.getString(MainActivity.DEFAULT_MESSAGE, "");

        Log.d("ERR", defaultMessage);
        Set<String> names = shared.getStringSet(defaultGroup, new HashSet<String>());
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (String name : names) {
            sb.append("{\"from\":\"+14158510835\",");
            sb.append("\"to\":\"+");
            sb.append(shared.getString(name,"")); // the number
            sb.append("\",\"text\":\"");
            sb.append(defaultMessage);
            sb.append("\"},");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");

        String json = sb.toString();
        System.out.println(json);
                /*"[{\"from\":\"+num0\","
                + "\"to\":\"+num1\","
                + "\"text\":\"wooork\"" + "},"
                + "{\"from\":\"+num0\","
                + "\"to\":\"+num2\","
                + "\"text\":\"wooork\"" + "},"
                + "{\"from\":\"+num0\","
                + "\"to\":\"+num3\","
                + "\"text\":\"wooork\"" + "}"
                + "]";*/

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
