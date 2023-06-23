package lk.uva.uvateafactory.report.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TeaCropSummary {

    @Id
    private Integer id;

    public Integer getMaxtotal() {
        return maxtotal;
    }

    public void setMaxtotal(Integer maxtotal) {
        this.maxtotal = maxtotal;
    }

    public Integer getPrevmonth() {
        return prevmonth;
    }

    public void setPrevmonth(Integer prevmonth) {
        this.prevmonth = prevmonth;
    }

    private String area;
    private Long currenttotal;
    private Long prevtotal;
    private String status;
    private Integer maxtotal;
    private Integer prevmonth;


    public TeaCropSummary() {}

    public TeaCropSummary( Long current, Long prev) {
//        this.area = area;
        this.currenttotal = current;
        this.prevtotal = prev;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Long getCurrenttotal() {
        return currenttotal;
    }

    public void setCurrenttotal(Long currenttotal) {
        this.currenttotal = currenttotal;
    }

    public Long getPrevtotal() {
        return prevtotal;
    }

    public void setPrevtotal(Long prevtotal) {
        this.prevtotal = prevtotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
