package com.libraryspringboot.libraryspringboot.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"bookCategory"})
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    @NonNull
    private String name;

    @OneToMany(mappedBy = "category")
    Set <BookCategory> bookCategory;
}
