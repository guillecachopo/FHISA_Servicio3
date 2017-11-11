package com.example.guill.fhisa_servicio3.Objetos;

import java.util.List;

/**
 * Created by guill on 11/11/2017.
 */


public class Camion {

    String id;
    Posicion posicion;
    String telefono;

    List<Posicion> posicionesList;

    public Camion() {
    }

    public Camion(String id, Posicion posicion) {
        this.id = id;
        this.posicion = posicion;
    }

    public Camion(String id, List<Posicion> posicionesList) {
        this.id = id;
        this.posicionesList = posicionesList;
    }

    public Camion(String id, List<Posicion> posicionesList, String telefono) {
        this.id = id;
        this.posicionesList = posicionesList;
        this.telefono = telefono;
    }

    public Camion(Posicion posicion) {

        this.posicion = posicion;
    }

    public Camion(String id) {

        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public List<Posicion> getPosicionesList() {
        return posicionesList;
    }

    public void setPosicionesList(List<Posicion> posicionesList) {
        this.posicionesList = posicionesList;
    }

}