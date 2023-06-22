package lk.uva.uvateafactory.report.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CountByArea {

    private Integer id;
    private String area;
    private Long count;
    private double percentage;

    public CountByArea() {  }

    public CountByArea(String area, Long count) {
        this.area = area;
        this.count = count;
    }

    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }
    public Long getCount() {
        return count;
    }
    public void setCount(Long count) {
        this.count = count;
    }
    public double getPercentage() {
        return percentage;
    }
    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    public Integer getId() {
        return id;
    }

}
