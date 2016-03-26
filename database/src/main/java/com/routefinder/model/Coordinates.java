package com.routefinder.model;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;

/**
 * Created by karpukdm on 26.03.16.
 */
@Entity
@Table(name = "coordinates")
public class Coordinates implements Persistable<Integer> {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coordinates_gen")
    @SequenceGenerator(name = "coordinates_gen", sequenceName = "coordinates_id_sec", allocationSize = 1)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @OneToOne(optional = false)
    @JoinColumn(name="coordinates_id", unique = true, nullable = false, updatable = false)
    private Point point;

    @Column
    private Double lat;

    @Column
    private Double lng;

    public Coordinates(){
        super();
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Integer getId() {
        return null;
    }

    public boolean isNew() {
        return false;
    }
}
