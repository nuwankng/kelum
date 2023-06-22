package lk.uva.uvateafactory.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lk.uva.uvateafactory.util.RegexPattern;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Area {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "code")
    @Pattern(regexp = "^[A-Z]-\\d{3}$", message = "Invalid Area Code")
    private String code;

    @Basic
    @Column(name = "acres")
//    @Pattern(regexp = "^\\d{1,3}(\\.\\d{1,2})?$", message = "Invalid Acres Number")
    private BigDecimal acres;

    @Basic
    @Column(name = "map")
    private byte[] map;

    @Basic
    @Column(name = "doattached")
    @RegexPattern(reg = "^\\d{2}-\\d{2}-\\d{2}$", msg = "Invalid Date Format For Attaching")
    private Date doattached;

    @Basic
    @Column(name = "plantcount")
    private Integer plantcount;

    @Basic
    @Column(name = "doproofing")
    @RegexPattern(reg = "^\\d{2}-\\d{2}-\\d{2}$", msg = "Invalid Date Format For Proofing")
    private Date doproofing;

    @ManyToOne
    @JoinColumn(name = "root_id", referencedColumnName = "id", nullable = false)
    private Root root;
    @ManyToOne
    @JoinColumn(name = "areastatus_id", referencedColumnName = "id", nullable = false)
    private Areastatus areastatus;
    @ManyToOne
    @JoinColumn(name = "empsupervis_id", referencedColumnName = "id", nullable = true)
    private Employee empsupervisor;
    @ManyToOne
    @JoinColumn(name = "empfieldoffic_id", referencedColumnName = "id", nullable = true)
    private Employee empfieldofficer;
    @ManyToOne
    @JoinColumn(name = "areacategory_id", referencedColumnName = "id", nullable = false)
    private Areacategory areacategory;

    @JsonIgnore
    @OneToMany(mappedBy = "area")
    private Collection<Plucking> pluckings;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getAcres() {
        return acres;
    }

    public void setAcres(BigDecimal acres) {
        this.acres = acres;
    }

    public byte[] getMap() {
        return map;
    }

    public void setMap(byte[] map) {
        this.map = map;
    }

    public Date getDoattached() {
        return doattached;
    }

    public void setDoattached(Date doattached) {
        this.doattached = doattached;
    }

    public Integer getPlantcount() {
        return plantcount;
    }

    public void setPlantcount(Integer plantcount) {
        this.plantcount = plantcount;
    }

    public Date getDoproofing() {
        return doproofing;
    }

    public void setDoproofing(Date doproofing) {
        this.doproofing = doproofing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Area area = (Area) o;
        return Objects.equals(id, area.id) && Objects.equals(code, area.code) && Objects.equals(acres, area.acres) && Arrays.equals(map, area.map) && Objects.equals(doattached, area.doattached) && Objects.equals(plantcount, area.plantcount) && Objects.equals(doproofing, area.doproofing);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, code, acres, doattached, plantcount, doproofing);
        result = 31 * result + Arrays.hashCode(map);
        return result;
    }

    public Root getRoot() {
        return root;
    }

    public void setRoot(Root root) {
        this.root = root;
    }

    public Areastatus getAreastatus() {
        return areastatus;
    }

    public void setAreastatus(Areastatus areastatus) {
        this.areastatus = areastatus;
    }

    public Employee getEmpsupervisor() {
        return empsupervisor;
    }

    public void setEmpsupervisor(Employee empsupervisor) {
        this.empsupervisor = empsupervisor;
    }

    public Employee getEmpfieldofficer() {
        return empfieldofficer;
    }

    public void setEmpfieldofficer(Employee empfieldofficer) {
        this.empfieldofficer = empfieldofficer;
    }

    public Areacategory getAreacategory() {
        return areacategory;
    }

    public void setAreacategory(Areacategory areacategory) {
        this.areacategory = areacategory;
    }

    public Collection<Plucking> getPluckings() {
        return pluckings;
    }

    public void setPluckings(Collection<Plucking> pluckings) {
        this.pluckings = pluckings;
    }
}
