package lk.uva.uvateafactory.entity.userprivilage;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Privilage {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "sel")
    private Integer sel;
    @Basic
    @Column(name = "ins")
    private Integer ins;
    @Basic
    @Column(name = "upd")
    private Integer upd;
    @Basic
    @Column(name = "del")
    private Integer del;
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    private Role role;
    @ManyToOne
    @JoinColumn(name = "module_id", referencedColumnName = "id", nullable = false)
    private Module module;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSel() {
        return sel;
    }

    public void setSel(Integer sel) {
        this.sel = sel;
    }

    public Integer getIns() {
        return ins;
    }

    public void setIns(Integer ins) {
        this.ins = ins;
    }

    public Integer getUpd() {
        return upd;
    }

    public void setUpd(Integer upd) {
        this.upd = upd;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Privilage privilage = (Privilage) o;
        return Objects.equals(id, privilage.id) && Objects.equals(sel, privilage.sel) && Objects.equals(ins, privilage.ins) && Objects.equals(upd, privilage.upd) && Objects.equals(del, privilage.del);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sel, ins, upd, del);
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }
}
