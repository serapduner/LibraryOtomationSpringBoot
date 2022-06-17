package com.libraryspringboot.libraryspringboot.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Data
@Entity
@Table(name = "bookCategory")
@NoArgsConstructor
@AllArgsConstructor

public class BookCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    Book book;

    @ManyToOne
    @JoinColumn(name="category_id")
    Category category;
}
