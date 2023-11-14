package com.klgroup.connectify.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class EndUser extends BaseUser {
    @Column(nullable = false)
    protected String firstName;
    @Column(nullable = false)
    protected String lastName;
    @Override
    protected Role getRole() {
        return Role.ROLE_END_USER;
    }
}
