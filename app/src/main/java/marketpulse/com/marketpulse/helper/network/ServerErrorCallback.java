package marketpulse.com.marketpulse.helper.network;

import com.android.volley.VolleyError;

/**
 * Created by tanmay on 06/06/19.
 */

public interface ServerErrorCallback {
    void onFailure(VolleyError error);
}
