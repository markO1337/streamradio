package com.bm.streamradio.entity;

import lombok.Data;

import javax.persistence.*;
import java.net.URL;
import java.util.UUID;

@Data
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String description;
    private URL url;
    @ManyToOne(cascade = CascadeType.ALL)
    private Category collection;
}
