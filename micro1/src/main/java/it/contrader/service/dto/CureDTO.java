package it.contrader.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Cure entity.
 */
public class CureDTO implements Serializable {

    private Long id;

    private String cf;

    private Integer age;

    private String pato;

    private String name;

    private String dosage;

    private String posology;

    private String notes;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPato() {
        return pato;
    }

    public void setPato(String pato) {
        this.pato = pato;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getPosology() {
        return posology;
    }

    public void setPosology(String posology) {
        this.posology = posology;
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

        CureDTO cureDTO = (CureDTO) o;
        if (cureDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), cureDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CureDTO{" +
            "id=" + getId() +
            ", cf='" + getCf() + "'" +
            ", age=" + getAge() +
            ", pato='" + getPato() + "'" +
            ", name='" + getName() + "'" +
            ", dosage='" + getDosage() + "'" +
            ", posology='" + getPosology() + "'" +
            ", notes='" + getNotes() + "'" +
            "}";
    }
}
