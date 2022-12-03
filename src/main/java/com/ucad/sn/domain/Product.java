package com.ucad.sn.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "product")
@AllArgsConstructor @NoArgsConstructor
@ToString
@Data
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private  Double prix;

    private LocalDate dateCreation;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}