package com.libraryspringboot.libraryspringboot.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Data
@Entity
@Table(name="writer")
@NoArgsConstructor
@AllArgsConstructor
public class Writer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    @NonNull
    private String name;

    @Column
    @NonNull
    private String surname;

    @OneToMany(mappedBy = "writer")
    Set<BookWriter> bookWriter;

}
