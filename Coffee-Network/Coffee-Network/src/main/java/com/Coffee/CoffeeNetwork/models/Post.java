package com.Coffee.CoffeeNetwork.models;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private int id;

    @Column(name = "content") //No necesario si la propiedad tiene el mismo nombre de la columna
    @Getter
    @Setter
    private String content;

    @Column(name = "created_at", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Getter
    private Date createdAt;

}
