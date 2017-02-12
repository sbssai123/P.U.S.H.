package com.example.schou.push;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/**
 * Main page with buttons for navigating to Groups and Messages.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button groupButton;
    Button messagesButton;

    private static String userId = "u-6kaarnu3kfgeodbaawdyaxi";
    private static String apiToken = "t-hwwtdcfowaddpuc6z6jhj5q";
    private static String apiSecret = "nhjghkxdfaxvoic4puc5iufbibpca56hipznfha";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new BsyncTask().execute();
        //RequestQueue queue = Volley.newRequestQueue(this);  // this = context


        //
        /*
        final JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("from", "+14158510835");
            jsonBody.put("to", "+13473592198");
            jsonBody.put("text", "plz work");
        } catch (Exception e) {
            e.printStackTrace();
        }

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, jsonBody,
                new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("response", response.toString());
            }
        },
        new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // error
                Log.d("Error.Response", new String(error.networkResponse.data));  //, response);
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                //headers.put("Accept", "applicaton/json");
                //headers.put("Content-Type", "application/json");
                headers.put("Authorization", auth);
                return headers;
            }

            @Override
            public String getBodyContentType() {
                System.out.println("I WAS HERE");
                return "application/json";
            }
        };

        Log.d("json", request.toString());
        queue.add(request);
        */

        /*
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.d("Response", response);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Log.d("Error.Response", new String(error.networkResponse.data));  //, response);
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("from", "+14158510835");
                params.put("to", "+13473592198");
                params.put("text", "work werk");
                //params.put("Authorization", auth);

                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                //headers.put("Content-Type", "application/json");
                headers.put("Authorization", auth);
                return headers;
            }

            @Override
            public String getBodyContentType() {
                System.out.println("I WAS HERE");
                return "application/json";
            }

            @Override
            public byte[] getBody() {
                return new String("{\"from\":\"14158510835\", \"to\":\"+13473592198\",\"text\":\"testText\"}").getBytes();
            }

            @Override
            public byte[] getPostBody() {
                return getBody();
            }
        };
        */
        //queue.add(postRequest);

        /*
        try {
            BandwidthClient.getInstance().setCredentials(userId, apiToken, apiSecret);
        } catch (Exception e) {
            System.out.println("ERROR;;;");
        }
        // put your numbers in here
        //String toNumber = "+13473592198";// your phone number here
        String[] toNums = {"+13473592198", "+14156806162", "+19148606633"};
        String fromNumber = "+14158510835";// this is a number that is allocated on the AppPlatform. You can do this

        try {
            for (String toNumber : toNums) {
                Message message = Message.create(toNumber, fromNumber, "Hi ur kinda kool");

                System.out.println("message:" + message);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        */
        groupButton = (Button)findViewById(R.id.groupButton);
        groupButton.setOnClickListener(this);

        messagesButton = (Button)findViewById(R.id.messagesButton);

    }

    //When the button is clicked, go to the right page
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.groupButton) {
            Intent intent = new Intent(this, GroupActivity.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.messagesButton) {
            Intent intent = new Intent(this, MessageActivity.class);
            startActivity(intent);
        }
    }


}



