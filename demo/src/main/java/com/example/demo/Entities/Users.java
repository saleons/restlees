package com.example.demo.Entities;

import javax.persistence.*;
//**********************************************************************************************************************
//__________________________________________QUE ES UN ENTIDAD__________________________________________________________*
//_____________________________________________________________________________________________________________________*
//_________________UNA ENTIDAD ES UNA CLASE (PLANTILLA) DONDE SE CREAN ATRIBUTOS Y FUNCIONES O METODOS_________________*
//_________________QUE SERAN HERADADON POR VARIBALES QUE TOMAN  ESTAN FUNCIONES COMO PROPIAS __________________________*
//**********************************************************************************************************************


//SECCION 1__________________________________________CREA TABLA EN BASE DE DATOS_________________________________________________________________


//(BD)@Entity :CREA LA TABLA (Users) EN BASE EN LA CLASE  (Users)
@Entity
//@Table:CREO LA ENTIDAD (Users) EN LA BASE DE DATOS
@Table(name="Users")


public class Users {

    //SECCION 2__________________________________________ATRIBUTOS_________________________________________________________________

    //@Id :SEÑALA QUE EL ATRIBUTO DESPUES ES LA PRIMARY KEY
    @Id
    //@GeneratedValue :LE DA UN VALOR AUTOMATICO AL ATRIBUTO DEACUERDO A UN FUNCION EN ESTA CASO AUTO INCREMENTANDO
    @GeneratedValue(strategy = GenerationType.AUTO )
    //id :CONTIENE LO DEFINIDO EN @Id Y @GeneratedValue
    private long id;
    @Column(name = "nombre" , unique = true)
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "correo", unique = true)
    private String correo;
    @Column(name = "telefono")
    private long telefono;
    @Column(name = "contraseña")
    private String contraseña;

    //SECCION 3________________________________CARDINALIDA O LLAVES FORENAEAS________________________________________________________________




    //SECCION 4__________________________________________CONTRUCTOR_______________________________________________________________


    //CONTRUCTOR VACIO: SE CREA PARA CUANDO EL USUARIO NO SABE QUE DATOS INGRESA ,SE LLENA SE ENVIA AL CONTRUCTOR Y SE HACE UNA OPERAION DETERMINADA
    //CONTRUCTOR VACIO: BUENA PRACTICA
    public Users(String s){}
    public Users(String nombre,String apellido,String correo,long telefono,String contraseña){
        this.nombre=nombre;
        this.apellido=apellido;
        this.correo= correo;
        this.telefono=telefono;
        this.contraseña=contraseña;
    }


    //SECCION 5__________________________________________GETTER AND SETTER_________________________________________________________________


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }


}
