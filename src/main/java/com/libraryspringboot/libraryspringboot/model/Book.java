package com.libraryspringboot.libraryspringboot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;


@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@EqualsAndHashCode(exclude = {"bookCategories", "borrow"})

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique=true)
    @NonNull
    private String name;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date publishDate;


    @ManyToOne
    @NonNull
    @JsonIgnoreProperties("book")
    Publisher publisher;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="book")
    @JsonIgnoreProperties("book")
    private Set<Borrow> borrow;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="book")
    @JsonIgnoreProperties("book")
    private Set<BookCategory> bookCategories;




}
