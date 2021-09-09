package com.revature.ghiblihub.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="roles")
@Getter
@Setter
@NoArgsConstructor
public class Role {

    @Id
    @Column(name="role_id")
    private int roleId;

    @Column(name="role", nullable = false)
    private String role;
}
