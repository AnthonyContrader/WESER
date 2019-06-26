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

    @Column(name = "regdev")
    private String regdev;

    @Column(name = "mp")
    private Integer mp;

    @Column(name = "cir")
    private Integer cir;

    @Column(name = "mpr")
    private Integer mpr;

    @Column(name = "bre")
    private Integer bre;

    @Column(name = "temp")
    private Float temp;

    @Column(name = "dataora")
    private LocalDate dataora;

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

    public String getRegdev() {
        return regdev;
    }

    public Reading regdev(String regdev) {
        this.regdev = regdev;
        return this;
    }

    public void setRegdev(String regdev) {
        this.regdev = regdev;
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

    public LocalDate getDataora() {
        return dataora;
    }

    public Reading dataora(LocalDate dataora) {
        this.dataora = dataora;
        return this;
    }

    public void setDataora(LocalDate dataora) {
        this.dataora = dataora;
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
