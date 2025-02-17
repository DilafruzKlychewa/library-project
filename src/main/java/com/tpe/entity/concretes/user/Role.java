package com.tpe.entity.concretes.user;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tpe.entity.concretes.user.User;
import com.tpe.entity.enums.RoleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @JsonIgnore // JSON üretimi sırasında bu alanı göz ardı etmek için
    @OneToMany(mappedBy = "role")
    private List<User> users;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private RoleType roleType;
}
