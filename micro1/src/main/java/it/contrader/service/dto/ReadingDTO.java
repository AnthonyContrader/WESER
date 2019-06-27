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

    private String rd;

    private Integer mp;

    private Integer mpr;

    private Integer cir;

    private Integer bre;

    private Float temp;

    private LocalDate date;

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

    public String getRd() {
        return rd;
    }

    public void setRd(String rd) {
        this.rd = rd;
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

    public Integer getCir() {
        return cir;
    }

    public void setCir(Integer cir) {
        this.cir = cir;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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
            ", rd='" + getRd() + "'" +
            ", mp=" + getMp() +
            ", mpr=" + getMpr() +
            ", cir=" + getCir() +
            ", bre=" + getBre() +
            ", temp=" + getTemp() +
            ", date='" + getDate() + "'" +
            "}";
    }
}
