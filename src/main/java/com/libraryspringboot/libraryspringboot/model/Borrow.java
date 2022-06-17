package com.libraryspringboot.libraryspringboot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
@Data
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@EqualsAndHashCode(exclude = {"member", "book"})
public class Borrow {
    @Id
    @GeneratedValue (strategy =  GenerationType.AUTO)
    private long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date borrowDate;


    @ManyToOne
    @NonNull
    @JsonIgnoreProperties("borrow")
    Member member;

    @ManyToOne
    @NonNull
    @JsonIgnoreProperties("borrow")
    Book book;


}
