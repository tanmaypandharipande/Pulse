package marketpulse.com.marketpulse.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import marketpulse.com.marketpulse.R;
import marketpulse.com.marketpulse.adapter.ScanAdapter;
import marketpulse.com.marketpulse.helper.Constants;
import marketpulse.com.marketpulse.helper.Utilities;
import marketpulse.com.marketpulse.helper.network.ClickListner;
import marketpulse.com.marketpulse.helper.network.ServerErrorCallback;
import marketpulse.com.marketpulse.helper.network.ServerJSONArrayCallback;
import marketpulse.com.marketpulse.pojo.Scan;
import marketpulse.com.marketpulse.service.ApiService;

public class ScanActivity extends AppCompatActivity implements ClickListner {
    private RequestQueue requestQueue;
    private RecyclerView recyclerView;
    private List<Scan> scanList;
    private ScanAdapter scanAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        requestQueue = Volley.newRequestQueue(ScanActivity.this);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(mLayoutManager);

        getData(ScanActivity.this, requestQueue);

    }

    //Get json data from URL
    private void getData(Context context, RequestQueue requestQueue) {
        final ProgressDialog progressDialog = Utilities.showProgressDialog(context, context.getString(R.string.please_wait), context.getString(R.string.loading));
        progressDialog.show();
        new ApiService().getData(context, requestQueue, null, new ServerJSONArrayCallback() {
            @Override
            public void onSuccess(JsonArray result) {
                parseJson(result);
                progressDialog.dismiss();
            }
        }, new ServerErrorCallback() {
            @Override
            public void onFailure(VolleyError error) {
                progressDialog.dismiss();
            }
        });
    }

    //Parse json data using gson
    private void parseJson(JsonArray jsonArray) {
        scanList = new ArrayList<>();
        //Using gson for parsing
        Gson gson = new Gson();
        for (int i = 0; i < jsonArray.size(); i++) {
            String object = String.valueOf(jsonArray.get(i));
            Scan scan = gson.fromJson(object, Scan.class);
            scanList.add(scan);
        }
        scanAdapter = new ScanAdapter(scanList, this);
        recyclerView.setAdapter(scanAdapter);
        scanAdapter.setClickListner(this);
    }

    @Override
    public void onItemClicked(View view, int position) {

    }
}
