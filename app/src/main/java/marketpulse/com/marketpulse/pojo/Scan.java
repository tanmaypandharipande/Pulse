package marketpulse.com.marketpulse.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tanmay on 06/06/19.
 */

public class Scan implements Serializable{
    private int id;
    private String name;
    private String tag;
    private String color;
    private List<Criteria> criteria;

    public Scan(int id, String name, String tag, String color, List<Criteria> criteria) {
        this.id = id;
        this.name = name;
        this.tag = tag;
        this.color = color;
        this.criteria = criteria;
    }

    public Scan() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Criteria> getCriteria() {
        return criteria;
    }

    public void setCriteria(List<Criteria> criteria) {
        this.criteria = criteria;
    }

    @Override
    public String toString() {
        return "Scan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tag='" + tag + '\'' +
                ", color='" + color + '\'' +
                ", criteria=" + criteria +
                '}';
    }
}
