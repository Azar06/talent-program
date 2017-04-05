package com.valtech.gifter.domain.model.partner;

import com.valtech.gifter.domain.model.commun.DomainEntity;
import org.hibernate.annotations.NaturalId;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(
        indexes = {
                @Index(name = "I_Partner_name", columnList = "name")
        }
)
public class Partner extends DomainEntity {

    @Id
    @GeneratedValue
    private Long id;

    @NaturalId
    @NotBlank
    @Size(min = 9, max = 9)
    private String duns;

    @NotBlank
    @Size(max = 64)
    private String name;

    private Partner() {
    }

    public Partner(Long id) {
        this.id = id;
    }

    public Partner(String duns) {
        this.duns = duns;
    }

    public Long getId() {
        return id;
    }

    public String getDuns() {
        return duns;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Object getNaturalId() {
        return getDuns();
    }
}
