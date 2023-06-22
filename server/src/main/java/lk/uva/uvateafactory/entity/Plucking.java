package lk.uva.uvateafactory.entity;

import lk.uva.uvateafactory.util.RegexPattern;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

@Entity
public class Plucking {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "date")
    @RegexPattern(reg = "^\\d{2}-\\d{2}-\\d{2}$", msg = "Invalid Date Format")
    private Date date;

    @Basic
    @Column(name = "time")
    private Time time;
    @Basic
    @Column(name = "qty")
    private Integer qty;
    @Basic
    @Column(name = "bonus")
    private Integer bonus;

    @ManyToOne
    @JoinColumn(name = "area_id", referencedColumnName = "id", nullable = false)
    private Area area;

    @ManyToOne
    @JoinColumn(name = "plucker_id", referencedColumnName = "id", nullable = false)
    private Employee empplucker;

    @ManyToOne
    @JoinColumn(name = "pluckingseesion_id", referencedColumnName = "id", nullable = false)
    private Pluckingseesion pluckingseesion;

    @ManyToOne
    @JoinColumn(name = "leaftype_id", referencedColumnName = "id", nullable = false)
    private Leaftype leaftype;

    @ManyToOne
    @JoinColumn(name = "kankani_id", referencedColumnName = "id", nullable = false)
    private Employee empkankani;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plucking plucking = (Plucking) o;
        return Objects.equals(id, plucking.id) && Objects.equals(date, plucking.date) && Objects.equals(time, plucking.time) && Objects.equals(qty, plucking.qty) && Objects.equals(bonus, plucking.bonus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, time, qty, bonus);
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Employee getEmpplucker() {
        return empplucker;
    }

    public void setEmpplucker(Employee empplucker) {
        this.empplucker = empplucker;
    }

    public Pluckingseesion getPluckingseesion() {
        return pluckingseesion;
    }

    public void setPluckingseesion(Pluckingseesion pluckingseesion) {
        this.pluckingseesion = pluckingseesion;
    }

    public Leaftype getLeaftype() {
        return leaftype;
    }

    public void setLeaftype(Leaftype leaftype) {
        this.leaftype = leaftype;
    }

    public Employee getEmpkankani() {
        return empkankani;
    }

    public void setEmpkankani(Employee empkankani) {
        this.empkankani = empkankani;
    }
}
