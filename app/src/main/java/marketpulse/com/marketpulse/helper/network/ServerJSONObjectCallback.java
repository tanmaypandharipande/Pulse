package marketpulse.com.marketpulse.helper.network;

import com.google.gson.JsonObject;

/**
 * Created by tanmay on 06/06/19.
 */

public interface ServerJSONObjectCallback {
    void onSuccess(JsonObject result);
}
