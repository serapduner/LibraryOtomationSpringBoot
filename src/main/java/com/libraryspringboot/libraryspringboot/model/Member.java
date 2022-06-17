package com.libraryspringboot.libraryspringboot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@EqualsAndHashCode(exclude = {"borrow"})
public class Member {
    @Id
    @GeneratedValue (strategy =  GenerationType.AUTO)
    private long id;

    @Column(unique=true)
    @NonNull
    private String name;

    @Column
    @NonNull
    private String surname;

    @Column
    @NonNull
    private long identityNumber;

    @Column
    @NonNull
    private String gender;

    @Column
    @NonNull
    private long phoneNumber;

    @Column
    @NonNull
    private String email;

    @OneToMany(cascade = CascadeType.ALL,  fetch = FetchType.LAZY, mappedBy = "member")
    @JsonIgnoreProperties({"member"})
    @ToString.Exclude
    private Set<Borrow> borrow;



}
