package marketpulse.com.marketpulse.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import marketpulse.com.marketpulse.R;
import marketpulse.com.marketpulse.adapter.CriteriaAdapter;
import marketpulse.com.marketpulse.helper.ClickListner;
import marketpulse.com.marketpulse.helper.Constants;
import marketpulse.com.marketpulse.pojo.Criteria;
import marketpulse.com.marketpulse.pojo.Scan;
import marketpulse.com.marketpulse.pojo.Variable;

/**
 * Created by tanmay on 07/06/19.
 */

public class CriteriaActivity extends AppCompatActivity implements ClickListner {
    private RecyclerView recyclerView;
    private List<Criteria> criteriaList = new ArrayList<>();
    private CriteriaAdapter criteriaAdapter;
    private TextView textView_tag, textView_text;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criteria);
        setTitle(getResources().getString(R.string.text_criteria_title));
        textView_tag = (TextView) findViewById(R.id.textView_criteria_tag);
        textView_text = (TextView) findViewById(R.id.textView_criteria_text);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_criteria);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(mLayoutManager);

        //If the data is assumed to changed in between the page transition
        //then we can hit the API to get the data by passing the ID of
        //scan object thought intent
        if (getIntent() != null) {
            Scan scan = (Scan) getIntent().getSerializableExtra(Constants.INTENT_SCAN_OBJECT);
            for (int i = 0; i < scan.getCriteria().size(); i++) {
                criteriaList.add(scan.getCriteria().get(i));
            }
            if (scan.getName() != null) {
                textView_text.setText(scan.getName());
            }
            if (scan.getTag() != null) {
                textView_tag.setText(scan.getTag());
            }
            if (scan.getColor().equals(Constants.COLOR_RED)) {
                textView_tag.setTextColor(Color.RED);
            }
            criteriaAdapter = new CriteriaAdapter(criteriaList, this);
            recyclerView.setAdapter(criteriaAdapter);
            criteriaAdapter.setClickListner(this);

        }
    }

    @Override
    public void onItemClicked(View view, int position) {

    }

    @Override
    public void onCriteriaItemClicked(View view, int position, HashMap<String, Variable> hashMap, String selected) {
        for (Map.Entry<String, Variable> entry : hashMap.entrySet()) {
            //It is inserted in same way in HashMap
            String[] test = entry.getKey().split(",");
            //The index value of split array
            int selectedValue = 2, variableValue = 1;

            if (test[selectedValue].toString().equals(selected)) {
                if (test[variableValue].toString().equals(Constants.VARIABLE_INDICATOR)) {
                    if (selected.equals(String.valueOf(entry.getValue().getDefault_value()))) {
                        Intent intent = new Intent(CriteriaActivity.this, IndicatorActivity.class);
                        intent.putExtra(Constants.INTENT_INDICATOR_OBJECT, entry.getValue());
                        startActivity(intent);
                    }
                } else {
                    if (selected.equals(entry.getValue().getValues().get(0).toString())) {
                        Intent intent = new Intent(CriteriaActivity.this, ValueActivity.class);
                        intent.putExtra(Constants.INTENT_VARIABLE_OBJECT, entry.getValue());
                        startActivity(intent);
                    }
                }
            }
        }
    }
}
