package it.contrader.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Patology entity.
 */
public class PatologyDTO implements Serializable {

    private Long id;

    private String pato;

    private String carename;

    private Integer mp;

    private Integer mpr;

    private Integer mc;

    private Integer mci;

    private Integer mb;

    private Integer mbr;

    private Float mt;

    private Float mte;

    private String notes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPato() {
        return pato;
    }

    public void setPato(String pato) {
        this.pato = pato;
    }

    public String getCarename() {
        return carename;
    }

    public void setCarename(String carename) {
        this.carename = carename;
    }

    public Integer getMp() {
        return mp;
    }

    public void setMp(Integer mp) {
        this.mp = mp;
    }

    public Integer getMpr() {
        return mpr;
    }

    public void setMpr(Integer mpr) {
        this.mpr = mpr;
    }

    public Integer getMc() {
        return mc;
    }

    public void setMc(Integer mc) {
        this.mc = mc;
    }

    public Integer getMci() {
        return mci;
    }

    public void setMci(Integer mci) {
        this.mci = mci;
    }

    public Integer getMb() {
        return mb;
    }

    public void setMb(Integer mb) {
        this.mb = mb;
    }

    public Integer getMbr() {
        return mbr;
    }

    public void setMbr(Integer mbr) {
        this.mbr = mbr;
    }

    public Float getMt() {
        return mt;
    }

    public void setMt(Float mt) {
        this.mt = mt;
    }

    public Float getMte() {
        return mte;
    }

    public void setMte(Float mte) {
        this.mte = mte;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PatologyDTO patologyDTO = (PatologyDTO) o;
        if (patologyDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), patologyDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PatologyDTO{" +
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
