package com.libraryspringboot.libraryspringboot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Data
@Entity
@Table(name = "personnel")
@NoArgsConstructor
@AllArgsConstructor
public class Personnel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    @NonNull
    private String name;

    @Column
    @NonNull
    private String surname;

    @Column
    @NonNull
    private String gender;

    @Column
    @NonNull
    private long phoneNumber;

    @Email
    @NonNull
    private String email;

    @Column
    @NonNull
    private String foreignLanguage;

    @Column
    @NonNull
    private String permission;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "personnel")
    @JsonIgnoreProperties("personnel")
    private Set<MemberPermission> memberPermission;
}

