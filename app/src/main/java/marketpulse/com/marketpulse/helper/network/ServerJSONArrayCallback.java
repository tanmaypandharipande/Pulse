package marketpulse.com.marketpulse.helper.network;

import com.google.gson.JsonArray;

/**
 * Created by tanmay on 06/06/19.
 */

public interface ServerJSONArrayCallback {
    void onSuccess(JsonArray result);
}
