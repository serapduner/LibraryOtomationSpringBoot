package com.libraryspringboot.libraryspringboot.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class BookWriter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    Book book;

    @ManyToOne
    @JoinColumn(name = "writer_id")
    Writer writer;
}
