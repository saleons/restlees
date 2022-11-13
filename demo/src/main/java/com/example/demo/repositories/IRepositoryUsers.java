package com.example.demo.repositories;

import com.example.demo.Entities.Users;
import org.springframework.data.repository.CrudRepository;
//**********************************************************************************************************************
//__________________________________________QUE ES UN REPOSITORIO?_____________________________________________________*

//_________________ES UNA INTERFACE QUE CONSULTA DIRECTAMNETE EN LA BASE DE DATOS______________________________________*
//_____________*___AL ACCEDER A LOS METODO EXTENDIDOS CrudRepository __________________________________________________*
//_________________ACCEDEMOS A FUNCION DEL CRUD , COMO ELIMINAR , BUSCAR , EDITAR Q____________________________________*
//_________________ YA ESTAN PROGRAMADAS EN ESA FUNCION (CrudRepository)_______________________________________________*
//_____________*____AL ACCEDER A LOS METODO EXTENDIDOS  JPARepository__________________________________________________*
//_________________ACCEDEMOS A FUNCION DEL CRUD , COMO ELIMINAR , BUSCAR , EDITAR _____________________________________*
//_________________PERO TAMBIEN NOS DEJA HACER CONSULTAS SQL CON @query________________________________________________*
//__________CrudRepository <Users,Long> Users: ES LA ENTIDAD DONDE SE HARA EL CRUD_____________________________________*
//__________CrudRepository <Users,Long> Long: ES EL TIPO DE DATO DE LA LLAVE PRIMARIA _________________________________*
//**********************************************************************************************************************

public interface IRepositoryUsers extends CrudRepository <Users,Long> {
    //METODO CREADO PARA BUSCAR EMIL
 Users findBycorreo(String email);
}
