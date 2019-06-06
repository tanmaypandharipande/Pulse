package marketpulse.com.marketpulse.service;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import marketpulse.com.marketpulse.helper.Constants;
import marketpulse.com.marketpulse.helper.Utilities;
import marketpulse.com.marketpulse.helper.network.CustomRequest;
import marketpulse.com.marketpulse.helper.network.ServerErrorCallback;
import marketpulse.com.marketpulse.helper.network.ServerJSONArrayCallback;
import marketpulse.com.marketpulse.helper.network.ServerJSONObjectCallback;

/**
 * Created by tanmay on 06/06/19.
 */

public class ApiService {

    //Custom request service
    public void getData(final Context context, RequestQueue requestQueue, final ServerJSONObjectCallback serverJSONObjectCallback, final ServerJSONArrayCallback serverJSONArrayCallback, final ServerErrorCallback serverErrorCallback) {
        CustomRequest customRequest = new CustomRequest(context, Request.Method.GET, Constants.DATA_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //Parse from the fetched format
                JsonParser jsonParser = new JsonParser();
                JsonElement jsonElement = jsonParser.parse(response);
                //In case of json object
                if (jsonElement.isJsonObject()) {
                    JsonObject object = jsonElement.getAsJsonObject();
                    Log.d("JSON OBJECT", String.valueOf(object));
                    serverJSONObjectCallback.onSuccess(object);
                    //in case of json Array
                } else if (jsonElement.isJsonArray()) {
                    JsonArray array = jsonElement.getAsJsonArray();
                    serverJSONArrayCallback.onSuccess(array);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    //Status code in case of error
                    int statusCode = error.networkResponse.statusCode;
                    serverErrorCallback.onFailure(error);
                    Utilities.statusCode(statusCode, context);
                } catch (Exception e) {
                    Log.e("error", Log.getStackTraceString(e));
                }
            }
        });
        //add request to queue
        requestQueue.add(customRequest);
    }
}

