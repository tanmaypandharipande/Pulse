package marketpulse.com.marketpulse.pojo;

import java.util.List;

/**
 * Created by tanmay on 06/06/19.
 */

public class Criteria {
    private String type;
    private String text;
    private List<Variable> variable;

    public Criteria(String type, String text, List<Variable> variable) {
        this.type = type;
        this.text = text;
        this.variable = variable;
    }

    public Criteria() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Variable> getVariable() {
        return variable;
    }

    public void setVariable(List<Variable> variable) {
        this.variable = variable;
    }

    @Override
    public String toString() {
        return "Criteria{" +
                "type='" + type + '\'' +
                ", text='" + text + '\'' +
                ", variable=" + variable +
                '}';
    }
}
