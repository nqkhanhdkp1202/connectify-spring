package com.klgroup.connectify.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class EndUser extends BaseUser {
    @Column(nullable = false)
    protected String firstName;
    @Column(nullable = false)
    protected String lastName;
    @Column(nullable = true)
    protected String email;
    @Column(nullable = true)
    protected String phone;
    @Column(nullable = true)
    protected String address;
    @Column(nullable = true)


    @ManyToMany
    protected List<EndUser> friends;

    @Override
    protected Role getRole() {
        return Role.ROLE_END_USER;
    }
}
