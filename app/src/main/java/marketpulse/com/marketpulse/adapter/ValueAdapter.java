package marketpulse.com.marketpulse.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import marketpulse.com.marketpulse.R;
import marketpulse.com.marketpulse.helper.ClickListner;

/**
 * Created by tanmay on 08/06/19.
 */

public class ValueAdapter extends RecyclerView.Adapter<ValueAdapter.CustomViewHolder> {
    private List<Double> itemsList;
    private ClickListner clickListner;
    private Context context;

    public ValueAdapter(List<Double> itemsList, Context context) {
        this.itemsList = itemsList;
        this.context = context;
    }

    @Override
    public ValueAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.value_row, parent, false);

        return new ValueAdapter.CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ValueAdapter.CustomViewHolder holder, int position) {

        holder.textView_item_value.setText(itemsList.get(holder.getAdapterPosition()).toString());
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public void setClickListner(ClickListner clickListner) {
        this.clickListner = clickListner;
    }


    public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textView_item_value;

        public CustomViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            this.textView_item_value = (TextView) itemView.findViewById(R.id.textView_value);
        }

        @Override
        public void onClick(View v) {
            if (clickListner != null) {
                clickListner.onItemClicked(v, getPosition());
            }
        }
    }
}