package marketpulse.com.marketpulse.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import marketpulse.com.marketpulse.R;
import marketpulse.com.marketpulse.helper.Constants;
import marketpulse.com.marketpulse.pojo.Variable;

/**
 * Created by tanmay on 08/06/19.
 */

public class IndicatorActivity extends AppCompatActivity {
    EditText editText_period;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indicator);
        editText_period = (EditText) findViewById(R.id.editText);
        if (getIntent() != null) {
            Variable variable = (Variable) getIntent().getSerializableExtra(Constants.INTENT_INDICATOR_OBJECT);
            editText_period.setText(String.valueOf(variable.getDefault_value()));
            setTitle(variable.getStudy_type().toUpperCase());
        }
    }
}
