package it.contrader.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Device.
 */
@Entity
@Table(name = "device")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Device implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "devtype")
    private String devtype;

    @Column(name = "descr")
    private String descr;

    @Column(name = "mp")
    private Integer mp;

    @Column(name = "mpr")
    private Integer mpr;

    @Column(name = "mc")
    private Integer mc;

    @Column(name = "mci")
    private Integer mci;

    @Column(name = "mb")
    private Integer mb;

    @Column(name = "mbr")
    private Integer mbr;

    @Column(name = "mt")
    private Float mt;

    @Column(name = "mte")
    private Float mte;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDevtype() {
        return devtype;
    }

    public Device devtype(String devtype) {
        this.devtype = devtype;
        return this;
    }

    public void setDevtype(String devtype) {
        this.devtype = devtype;
    }

    public String getDescr() {
        return descr;
    }

    public Device descr(String descr) {
        this.descr = descr;
        return this;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Integer getMp() {
        return mp;
    }

    public Device mp(Integer mp) {
        this.mp = mp;
        return this;
    }

    public void setMp(Integer mp) {
        this.mp = mp;
    }

    public Integer getMpr() {
        return mpr;
    }

    public Device mpr(Integer mpr) {
        this.mpr = mpr;
        return this;
    }

    public void setMpr(Integer mpr) {
        this.mpr = mpr;
    }

    public Integer getMc() {
        return mc;
    }

    public Device mc(Integer mc) {
        this.mc = mc;
        return this;
    }

    public void setMc(Integer mc) {
        this.mc = mc;
    }

    public Integer getMci() {
        return mci;
    }

    public Device mci(Integer mci) {
        this.mci = mci;
        return this;
    }

    public void setMci(Integer mci) {
        this.mci = mci;
    }

    public Integer getMb() {
        return mb;
    }

    public Device mb(Integer mb) {
        this.mb = mb;
        return this;
    }

    public void setMb(Integer mb) {
        this.mb = mb;
    }

    public Integer getMbr() {
        return mbr;
    }

    public Device mbr(Integer mbr) {
        this.mbr = mbr;
        return this;
    }

    public void setMbr(Integer mbr) {
        this.mbr = mbr;
    }

    public Float getMt() {
        return mt;
    }

    public Device mt(Float mt) {
        this.mt = mt;
        return this;
    }

    public void setMt(Float mt) {
        this.mt = mt;
    }

    public Float getMte() {
        return mte;
    }

    public Device mte(Float mte) {
        this.mte = mte;
        return this;
    }

    public void setMte(Float mte) {
        this.mte = mte;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Device device = (Device) o;
        if (device.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), device.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Device{" +
            "id=" + getId() +
            ", devtype='" + getDevtype() + "'" +
            ", descr='" + getDescr() + "'" +
            ", mp=" + getMp() +
            ", mpr=" + getMpr() +
            ", mc=" + getMc() +
            ", mci=" + getMci() +
            ", mb=" + getMb() +
            ", mbr=" + getMbr() +
            ", mt=" + getMt() +
            ", mte=" + getMte() +
            "}";
    }
}
