package com.bm.streamradio.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String description;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Station> stations;

    public void addStation(Station station) {
        if(stations == null)
            stations = new ArrayList<>();
        stations.add(station);
    }
}
