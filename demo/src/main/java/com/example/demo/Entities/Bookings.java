package com.example.demo.Entities;

import javax.persistence.*;

//(BD)@Entity :CREA LA TABLA (Users) EN BASE EN LA CLASE  (Users)
@Entity
//@Table:CREO LA ENTIDAD (Users) EN LA BASE DE DATOS
@Table(name="Booking")
public class Bookings {

    //SECCION 2__________________________________________ATRIBUTOS_________________________________________________________________

    //@Id :SEÑALA QUE EL ATRIBUTO DESPUES ES LA PRIMARY KEY
    @Id
    //@GeneratedValue :LE DA UN VALOR AUTOMATICO AL ATRIBUTO DEACUERDO A UN FUNCION EN ESTA CASO AUTO INCREMENTANDO
    @GeneratedValue(strategy = GenerationType.AUTO )
    //id :CONTIENE LO DEFINIDO EN @Id Y @GeneratedValue
    private long id;
    @Column(name = "fecha")
    private String fecha;
    @Column(name = "descripcion")
    private String descripcion;

    //SECCION 3________________________________CARDINALIDA O LLAVES FORENAEAS________________________________________________________________

    //ManyToOne: DEFINICION
    //ManyToOne: DEFINICION  Many: muchas facturas (la clase facturas)
    //ManyToOne: DEFINICION  One: un Usuario (la variable Users)
    @ManyToOne
    //COLUMNA LLAVE FORANES (FK)
    @JoinColumn(name="Booking_Users")
    //UNIDO AL OBJETO Users que es una entidad
    Users user;
    //SECCION 4__________________________________________CONTRUCTOR_______________________________________________________________









    //SECCION 5__________________________________________GETTER AND SETTER_________________________________________________________________

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }






}
