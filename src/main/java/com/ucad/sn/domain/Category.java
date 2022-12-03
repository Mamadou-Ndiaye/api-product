package com.ucad.sn.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
@ToString
public class Category  implements Serializable {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private  String nom;

    private  String description;

    @JsonIgnore
    @OneToMany(mappedBy = "category", orphanRemoval = true)
    private Set<Product> products = new HashSet<>();


}
