package marketpulse.com.marketpulse.pojo;

import java.util.List;

/**
 * Created by tanmay on 06/06/19.
 */

//Last entity in the hierarchy
public class Variable {

    private String type;
    private String study_type;
    private String parameter_name;
    private int min_value;
    private int max_value;
    private int default_value;
    private List<Integer> values;

    public Variable(String type, String study_type, String parameter_name, int min_value, int max_value, int default_value, List<Integer> values) {
        this.type = type;
        this.study_type = study_type;
        this.parameter_name = parameter_name;
        this.min_value = min_value;
        this.max_value = max_value;
        this.default_value = default_value;
        this.values = values;
    }

    public Variable() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStudy_type() {
        return study_type;
    }

    public void setStudy_type(String study_type) {
        this.study_type = study_type;
    }

    public String getParameter_name() {
        return parameter_name;
    }

    public void setParameter_name(String parameter_name) {
        this.parameter_name = parameter_name;
    }

    public int getMin_value() {
        return min_value;
    }

    public void setMin_value(int min_value) {
        this.min_value = min_value;
    }

    public int getMax_value() {
        return max_value;
    }

    public void setMax_value(int max_value) {
        this.max_value = max_value;
    }

    public int getDefault_value() {
        return default_value;
    }

    public void setDefault_value(int default_value) {
        this.default_value = default_value;
    }

    public List<Integer> getValues() {
        return values;
    }

    public void setValues(List<Integer> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "Variable{" +
                "type='" + type + '\'' +
                ", study_type='" + study_type + '\'' +
                ", parameter_name='" + parameter_name + '\'' +
                ", min_value=" + min_value +
                ", max_value=" + max_value +
                ", default_value=" + default_value +
                ", values=" + values +
                '}';
    }
}
