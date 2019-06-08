package marketpulse.com.marketpulse.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.List;

import marketpulse.com.marketpulse.R;
import marketpulse.com.marketpulse.helper.ClickListner;
import marketpulse.com.marketpulse.helper.Constants;
import marketpulse.com.marketpulse.pojo.Scan;

/**
 * Created by tanmay on 07/06/19.
 */

public class ScanAdapter extends RecyclerView.Adapter<ScanAdapter.CustomViewHolder> {
    private List<Scan> itemsList;
    private ClickListner clickListner;
    private Context context;
    private int lastPosition = -1;

    public ScanAdapter(List<Scan> itemsList, Context context) {
        this.itemsList = itemsList;
        this.context = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.scan_row, parent, false);

        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {

        Scan item = itemsList.get(holder.getAdapterPosition());

        holder.textView_item_name.setText(item.getName());
        holder.textView_item_tag.setText(item.getTag());

        if (item.getColor().equals(Constants.COLOR_RED)) {
            holder.textView_item_tag.setTextColor(Color.RED);
        }

        setAnimationBottom(holder.itemView, holder.getAdapterPosition());
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public void setClickListner(ClickListner clickListner) {
        this.clickListner = clickListner;
    }


    public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textView_item_name, textView_item_tag;

        public CustomViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            this.textView_item_name = (TextView) itemView.findViewById(R.id.textView_name);
            this.textView_item_tag = (TextView) itemView.findViewById(R.id.textView_tag);

        }

        @Override
        public void onClick(View v) {
            if (clickListner != null) {
                clickListner.onItemClicked(v, getPosition());
            }
        }
    }

    public void setAnimationBottom(View viewToAnimate, int position) {
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(context, R.anim.up_from_bottom);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }
}
