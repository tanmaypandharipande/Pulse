package marketpulse.com.marketpulse.helper;

/**
 * Created by tanmay on 06/06/19.
 */

public interface Constants {

    String DATA_URL = "https://mp-android-challenge.herokuapp.com/data";

    String COLOR_RED = "red";

    //Pattern match for generated dynamic link
    String PATTERN = "\\((.*?)\\)";

    //Intent
    String INTENT_SCAN_OBJECT = "scan_object";
    String INTENT_VARIABLE_OBJECT = "variable_object";
    String INTENT_INDICATOR_OBJECT = "indicator_object";

    //Parsing
    String CRITERIA_VARIABLE = "variable";
    String VARIABLE_INDICATOR = "indicator";
    String VARIABLE_VALUE = "value";
}
