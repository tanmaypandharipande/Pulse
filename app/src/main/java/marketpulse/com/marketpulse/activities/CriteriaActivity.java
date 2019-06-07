package marketpulse.com.marketpulse.activities;

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
import java.util.List;

import marketpulse.com.marketpulse.R;
import marketpulse.com.marketpulse.adapter.CriteriaAdapter;
import marketpulse.com.marketpulse.helper.Constants;
import marketpulse.com.marketpulse.helper.network.ClickListner;
import marketpulse.com.marketpulse.pojo.Criteria;
import marketpulse.com.marketpulse.pojo.Scan;

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
            for(int i =0;i<scan.getCriteria().size();i++){
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
}
