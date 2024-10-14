package com.shvetsov.quetion2.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * model Team
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "team")
public class Team {
    /**
     * field id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    /**
     * field name
     */
    @Column(name = "name")
    private String name;

    /**
     * constructor for Team
     * @param name
     */
    public Team(String name) {
        this.name = name;
    }
}
