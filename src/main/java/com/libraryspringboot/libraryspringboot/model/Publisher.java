package com.libraryspringboot.libraryspringboot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"book"})

public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    @NonNull
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="publisher")
    @JsonIgnoreProperties("publisher")
    private Set<Book> book;



}
