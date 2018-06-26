package com.umanis.jean.poc_jsf.poc_projet_jsf.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;

import com.umanis.jean.poc_jsf.poc_projet_jsf.Utils.PersonneUtils;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Jean
 */

@Entity
@Getter
@Setter
public class Personne implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String prenom;
    private LocalDate ddn;

    @Transient
    private int age;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.prenom);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Personne other = (Personne) obj;
        return prenom.equalsIgnoreCase(other.prenom);
    }

    @PrePersist
    @PreUpdate
    @PostLoad
    private void initDatas() {
        age = PersonneUtils.calculAge(ddn);
        prenom = PersonneUtils.capitalize(prenom);
    }

}