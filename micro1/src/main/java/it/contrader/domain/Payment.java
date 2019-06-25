package it.contrader.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Payment.
 */
@Entity
@Table(name = "payment")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ct")
    private String ct;

    @Column(name = "cn")
    private String cn;

    @Column(name = "co")
    private String co;

    @Column(name = "ce")
    private String ce;

    @Column(name = "cvv")
    private Integer cvv;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCt() {
        return ct;
    }

    public Payment ct(String ct) {
        this.ct = ct;
        return this;
    }

    public void setCt(String ct) {
        this.ct = ct;
    }

    public String getCn() {
        return cn;
    }

    public Payment cn(String cn) {
        this.cn = cn;
        return this;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    public String getCo() {
        return co;
    }

    public Payment co(String co) {
        this.co = co;
        return this;
    }

    public void setCo(String co) {
        this.co = co;
    }

    public String getCe() {
        return ce;
    }

    public Payment ce(String ce) {
        this.ce = ce;
        return this;
    }

    public void setCe(String ce) {
        this.ce = ce;
    }

    public Integer getCvv() {
        return cvv;
    }

    public Payment cvv(Integer cvv) {
        this.cvv = cvv;
        return this;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
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
        Payment payment = (Payment) o;
        if (payment.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), payment.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Payment{" +
            "id=" + getId() +
            ", ct='" + getCt() + "'" +
            ", cn='" + getCn() + "'" +
            ", co='" + getCo() + "'" +
            ", ce='" + getCe() + "'" +
            ", cvv=" + getCvv() +
            "}";
    }
}
