package marketpulse.com.marketpulse.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

import marketpulse.com.marketpulse.R;
import marketpulse.com.marketpulse.helper.Constants;
import marketpulse.com.marketpulse.helper.network.ClickListner;
import marketpulse.com.marketpulse.pojo.Criteria;
import marketpulse.com.marketpulse.pojo.Variable;

/**
 * Created by tanmay on 07/06/19.
 */

public class CriteriaAdapter extends RecyclerView.Adapter<CriteriaAdapter.CustomViewHolder> {
    private List<Criteria> itemsList;
    ClickListner clickListner;
    Context context;

    public CriteriaAdapter(List<Criteria> itemsList, Context context) {
        this.itemsList = itemsList;
        this.context = context;
    }

    @Override
    public CriteriaAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.criteria_row, parent, false);

        return new CriteriaAdapter.CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CriteriaAdapter.CustomViewHolder holder, int position) {

        Criteria item = itemsList.get(holder.getAdapterPosition());
        String value = item.getText();
        if (item.getType().equals(Constants.CRITERIA_VARIABLE)) {
            for (Map.Entry<String, Variable> entry : item.getVariable().entrySet()) {
                if (value.contains(entry.getKey())) {
                    if (item.getVariable().get(entry.getKey()).getType().equals(Constants.VARIABLE_INDICATOR)) {
                        value = value.replace(entry.getKey().toString(), "(" + String.valueOf(item.getVariable().get(entry.getKey()).getDefault_value()) + ")");
                    } else if (item.getVariable().get(entry.getKey()).getType().equals(Constants.VARIABLE_VALUE)) {
                        value = value.replace(entry.getKey().toString(), "(" + item.getVariable().get(entry.getKey()).getValues().get(0).toString() + ")");
                    }

                }
            }
        }
        holder.textView_item_criteria.setText(value);
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public void setClickListner(ClickListner clickListner) {
        this.clickListner = clickListner;
    }


    public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textView_item_criteria;

        public CustomViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            this.textView_item_criteria = (TextView) itemView.findViewById(R.id.textView_criteria);

        }

        @Override
        public void onClick(View v) {
            if (clickListner != null) {
                clickListner.onItemClicked(v, getPosition());
            }
        }
    }
}