package com.klgroup.connectify.model;

import jakarta.persistence.Entity;
import lombok.*;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Admin extends BaseUser {
    @Override
    protected Role getRole() {
        return Role.ROLE_ADMIN;
    }
}
