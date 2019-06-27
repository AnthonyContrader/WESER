package it.contrader.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A Reading.
 */
@Entity
@Table(name = "reading")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Reading implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cf")
    private String cf;

    @Column(name = "rd")
    private String rd;

    @Column(name = "mp")
    private Integer mp;

    @Column(name = "mpr")
    private Integer mpr;

    @Column(name = "cir")
    private Integer cir;

    @Column(name = "bre")
    private Integer bre;

    @Column(name = "temp")
    private Float temp;

    @Column(name = "jhi_date")
    private LocalDate date;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCf() {
        return cf;
    }

    public Reading cf(String cf) {
        this.cf = cf;
        return this;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public String getRd() {
        return rd;
    }

    public Reading rd(String rd) {
        this.rd = rd;
        return this;
    }

    public void setRd(String rd) {
        this.rd = rd;
    }

    public Integer getMp() {
        return mp;
    }

    public Reading mp(Integer mp) {
        this.mp = mp;
        return this;
    }

    public void setMp(Integer mp) {
        this.mp = mp;
    }

    public Integer getMpr() {
        return mpr;
    }

    public Reading mpr(Integer mpr) {
        this.mpr = mpr;
        return this;
    }

    public void setMpr(Integer mpr) {
        this.mpr = mpr;
    }

    public Integer getCir() {
        return cir;
    }

    public Reading cir(Integer cir) {
        this.cir = cir;
        return this;
    }

    public void setCir(Integer cir) {
        this.cir = cir;
    }

    public Integer getBre() {
        return bre;
    }

    public Reading bre(Integer bre) {
        this.bre = bre;
        return this;
    }

    public void setBre(Integer bre) {
        this.bre = bre;
    }

    public Float getTemp() {
        return temp;
    }

    public Reading temp(Float temp) {
        this.temp = temp;
        return this;
    }

    public void setTemp(Float temp) {
        this.temp = temp;
    }

    public LocalDate getDate() {
        return date;
    }

    public Reading date(LocalDate date) {
        this.date = date;
        return this;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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
        Reading reading = (Reading) o;
        if (reading.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), reading.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Reading{" +
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
