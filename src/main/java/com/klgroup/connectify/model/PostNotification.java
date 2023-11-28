package com.klgroup.connectify.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class PostNotification extends BaseNotification{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private Post postNotification;

    @Override
    protected Notification getType(){return Notification.POST_NOTI;};
}
