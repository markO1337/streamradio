package com.bm.streamradio.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Radio extends Station implements Serializable {
    private String freq;
}
