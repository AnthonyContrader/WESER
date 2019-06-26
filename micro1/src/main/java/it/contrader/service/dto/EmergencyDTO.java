package it.contrader.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Emergency entity.
 */
public class EmergencyDTO implements Serializable {

    private Long id;

    private String num;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EmergencyDTO emergencyDTO = (EmergencyDTO) o;
        if (emergencyDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), emergencyDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "EmergencyDTO{" +
            "id=" + getId() +
            ", num='" + getNum() + "'" +
            "}";
    }
}
