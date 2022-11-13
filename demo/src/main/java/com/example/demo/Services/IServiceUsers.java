package com.example.demo.Services;

import com.example.demo.Entities.Users;

import java.util.List;
import java.util.Map;

public interface IServiceUsers {
//**********************************************************************************************************************
    //____________________________________QUE ES UN SERVICIO_INTERFACE_________________________________________

    //__________________SERVICIO: SON LO QUE VOY A HACER CUANDO ME LLEGUE UN PETICION DEL CONTROLADOR __________________________________
    //_________________INTERFACE: ES A UN MEDIADOR ENTRE LA LOGICA DE EL CONTROLADOR Y LA LOGICA DEL SERVICIO__________________________
    //____________¿QUE HAY AQUI?: DEFINIMOS MENSAJES(METODOS SIN CUERPO) O FUNCIONES QUE NO TINEN CUERPO_________________________

    //_____________ESO QUIERE DECIR Q SI ALGUIEN ENTRA NO PUEDE ACCDER A LAS FUNCIONES U OPERACIONES(BUENA PRATICA)
    //________LA LOGICA ESTARA EN LA CLASE QUE IMPLEMENTA LAS FUNCIONES DE AQUI EN ESTE CASO EN :(ImpleServiceUsers)
//**********************************************************************************************************************
    //GET:FUNCION PARA BUSCAR TODOS LOS USUARIOS
    public List<Users> findall();

    //GET:FUNCION PARA BUSCAR POR ID
    public Users findByid(long id);

    //POST:FUNCION PARA AGREGAR NUEVO USUARIO
    public Users postUser(Users users);

    //PATCH:FUNCION PARA EDITAR UN USUARIO
    public Users patchUser (long id,Users users);

    //DELETE :FUNCION PARA ELIMINAR POR ID
    public boolean delet (long id);

    public Users buscaryguardar(Map<String,Object> USERDATA);


    Users buscar(String email);
}
