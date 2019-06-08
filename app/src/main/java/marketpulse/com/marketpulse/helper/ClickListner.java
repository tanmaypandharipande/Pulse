package marketpulse.com.marketpulse.helper;

import android.view.View;

import java.util.HashMap;

import marketpulse.com.marketpulse.pojo.Variable;

/**
 * Created by tanmay on 06/06/19.
 */

public interface ClickListner {

    void onItemClicked(View view, int position);

    void onCriteriaItemClicked(View view, int position, HashMap<String, Variable> hashMap, String selected);
}
