package marketpulse.com.marketpulse.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import marketpulse.com.marketpulse.R;
import marketpulse.com.marketpulse.adapter.ValueAdapter;
import marketpulse.com.marketpulse.helper.Constants;
import marketpulse.com.marketpulse.pojo.Variable;

/**
 * Created by tanmay on 08/06/19.
 */

public class ValueActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Double> valuesList = new ArrayList<>();
    private ValueAdapter valueAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_values);
        setTitle(getResources().getString(R.string.text_value_title));
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_values);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(mLayoutManager);

        if (getIntent() != null) {
            Variable variable = (Variable) getIntent().getSerializableExtra(Constants.INTENT_VARIABLE_OBJECT);
            valuesList = variable.getValues();
            Collections.sort(valuesList);
            valueAdapter = new ValueAdapter(valuesList, ValueActivity.this);
            recyclerView.setAdapter(valueAdapter);
        }
    }
}
