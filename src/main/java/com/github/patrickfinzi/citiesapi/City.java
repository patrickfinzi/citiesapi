package com.github.patrickfinzi.citiesapi;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.geo.Point;


@Entity
@Table(name = "cidade")
@TypeDefs(value = {@TypeDef(name = "point", typeClass = PointType.class)})
@AllArgsConstructor
@NoArgsConstructor
@Data
public class City {

    @Id
    private Long id;

    @Column(name = "nome")
    private String name;

    private Integer uf;

    private Integer ibge;

    // 1st
    @Column(name = "lat_lon")
    private String geolocation;

    // 2nd
    @Type(type = "point")
    @Column(name = "lat_lon", updatable = false, insertable = false)
    private Point location;

}