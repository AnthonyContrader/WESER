package it.contrader.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Patology.
 */
@Entity
@Table(name = "patology")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Patology implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pato")
    private String pato;

    @Column(name = "carename")
    private String carename;

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

    @Column(name = "notes")
    private String notes;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPato() {
        return pato;
    }

    public Patology pato(String pato) {
        this.pato = pato;
        return this;
    }

    public void setPato(String pato) {
        this.pato = pato;
    }

    public String getCarename() {
        return carename;
    }

    public Patology carename(String carename) {
        this.carename = carename;
        return this;
    }

    public void setCarename(String carename) {
        this.carename = carename;
    }

    public Integer getMp() {
        return mp;
    }

    public Patology mp(Integer mp) {
        this.mp = mp;
        return this;
    }

    public void setMp(Integer mp) {
        this.mp = mp;
    }

    public Integer getMpr() {
        return mpr;
    }

    public Patology mpr(Integer mpr) {
        this.mpr = mpr;
        return this;
    }

    public void setMpr(Integer mpr) {
        this.mpr = mpr;
    }

    public Integer getMc() {
        return mc;
    }

    public Patology mc(Integer mc) {
        this.mc = mc;
        return this;
    }

    public void setMc(Integer mc) {
        this.mc = mc;
    }

    public Integer getMci() {
        return mci;
    }

    public Patology mci(Integer mci) {
        this.mci = mci;
        return this;
    }

    public void setMci(Integer mci) {
        this.mci = mci;
    }

    public Integer getMb() {
        return mb;
    }

    public Patology mb(Integer mb) {
        this.mb = mb;
        return this;
    }

    public void setMb(Integer mb) {
        this.mb = mb;
    }

    public Integer getMbr() {
        return mbr;
    }

    public Patology mbr(Integer mbr) {
        this.mbr = mbr;
        return this;
    }

    public void setMbr(Integer mbr) {
        this.mbr = mbr;
    }

    public Float getMt() {
        return mt;
    }

    public Patology mt(Float mt) {
        this.mt = mt;
        return this;
    }

    public void setMt(Float mt) {
        this.mt = mt;
    }

    public Float getMte() {
        return mte;
    }

    public Patology mte(Float mte) {
        this.mte = mte;
        return this;
    }

    public void setMte(Float mte) {
        this.mte = mte;
    }

    public String getNotes() {
        return notes;
    }

    public Patology notes(String notes) {
        this.notes = notes;
        return this;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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
        Patology patology = (Patology) o;
        if (patology.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), patology.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Patology{" +
            "id=" + getId() +
            ", pato='" + getPato() + "'" +
            ", carename='" + getCarename() + "'" +
            ", mp=" + getMp() +
            ", mpr=" + getMpr() +
            ", mc=" + getMc() +
            ", mci=" + getMci() +
            ", mb=" + getMb() +
            ", mbr=" + getMbr() +
            ", mt=" + getMt() +
            ", mte=" + getMte() +
            ", notes='" + getNotes() + "'" +
            "}";
    }
}
