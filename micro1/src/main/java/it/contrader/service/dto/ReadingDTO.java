package it.contrader.service.dto;

import java.time.LocalDate;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Reading entity.
 */
public class ReadingDTO implements Serializable {

    private Long id;

    private String cf;

    private String regdev;

    private Integer mp;

    private Integer cir;

    private Integer mpr;

    private Integer bre;

    private Float temp;

    private LocalDate dataora;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public String getRegdev() {
        return regdev;
    }

    public void setRegdev(String regdev) {
        this.regdev = regdev;
    }

    public Integer getMp() {
        return mp;
    }

    public void setMp(Integer mp) {
        this.mp = mp;
    }

    public Integer getCir() {
        return cir;
    }

    public void setCir(Integer cir) {
        this.cir = cir;
    }

    public Integer getMpr() {
        return mpr;
    }

    public void setMpr(Integer mpr) {
        this.mpr = mpr;
    }

    public Integer getBre() {
        return bre;
    }

    public void setBre(Integer bre) {
        this.bre = bre;
    }

    public Float getTemp() {
        return temp;
    }

    public void setTemp(Float temp) {
        this.temp = temp;
    }

    public LocalDate getDataora() {
        return dataora;
    }

    public void setDataora(LocalDate dataora) {
        this.dataora = dataora;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ReadingDTO readingDTO = (ReadingDTO) o;
        if (readingDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), readingDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ReadingDTO{" +
            "id=" + getId() +
            ", cf='" + getCf() + "'" +
            ", regdev='" + getRegdev() + "'" +
            ", mp=" + getMp() +
            ", cir=" + getCir() +
            ", mpr=" + getMpr() +
            ", bre=" + getBre() +
            ", temp=" + getTemp() +
            ", dataora='" + getDataora() + "'" +
            "}";
    }
}
