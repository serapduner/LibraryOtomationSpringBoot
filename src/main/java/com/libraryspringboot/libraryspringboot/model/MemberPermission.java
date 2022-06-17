package com.libraryspringboot.libraryspringboot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Data
@Entity
@Table(name = "memberPermission")
@NoArgsConstructor
@AllArgsConstructor
public class MemberPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @ManyToOne
    @NonNull
    @JsonIgnoreProperties("personnel")
    Personnel personnel;

    @ManyToOne
    @JoinColumn(name = "permission_id")
    Permission permission;

   /* @ManyToOne
    @NonNull
    @JsonIgnoreProperties("user")
    User user;
*/
}
