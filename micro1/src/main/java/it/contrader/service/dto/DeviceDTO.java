package it.contrader.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Device entity.
 */
public class DeviceDTO implements Serializable {

    private Long id;

    private String devtype;

    private String descr;

    private Integer mp;

    private Integer mpr;

    private Integer mc;

    private Integer mci;

    private Integer mb;

    private Integer mbr;

    private Float mt;

    private Float mte;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDevtype() {
        return devtype;
    }

    public void setDevtype(String devtype) {
        this.devtype = devtype;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DeviceDTO deviceDTO = (DeviceDTO) o;
        if (deviceDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), deviceDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "DeviceDTO{" +
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
