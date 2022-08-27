package com.example.bookstoreonline.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tbl_users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @Column(name = "user_email", unique = true)
    private String email;
    @Column(name = "user_password")
    private String password;
    @Column(name = "user_verification_code")
    private String verificationCode;
    @Column(name = "user_enable")
    private Boolean enable;
    @Column(name = "user_role")
    private String role;
    @Column(name = "user_full_name")
    private String fullName;
    @Column(name = "user_address")
    private String address;
    @Column(name = "user_phone")
    private String phone;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
