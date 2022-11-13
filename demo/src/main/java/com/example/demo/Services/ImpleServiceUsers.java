package com.example.demo.Services;

import com.example.demo.Entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.IRepositoryUsers;

import java.util.List;
import java.util.Map;
//**********************************************************************************************************************
//____________________________________QUE ES UN SERVICIO_CLASE_________________________________________________________*
//_____________________________________________________________________________________________________________________*
//SERVICIO:LO QUE VOY A HACER CUANDO ME LLEGUE UN PETICION DEL CONTROLADOR y HALLA PASADO POR LA INTERFACE SERVICIO____*
//_________CLASE: LOGICA DEL SERVICIO _________________________________________________________________________________*
//¿QUE HAY AQUI?: AQUI ES DONDE SE HARAN LAS OPERACIONES CON LOS DATOS QUE SE EXTRAIGAN DE LA BASE DE DATOS____________*
//_____________________________________________________________________________________________________________________*
//_________ImpleServiceUsers: AQUI IMPLEMENTAMOS LOS SERVICIONS DE IServiceUsers O GENRAMOS LA LOGICA__________________*
//**********************************************************************************************************************

//@Service RECONOCE QUE ESTO ES UN SERVICIO
@Service
//implements: TRAEMOS LAS FUNCIONES DE LA INTERFAZ IServiceUsers
public class ImpleServiceUsers implements IServiceUsers{

    //@Autowired: TRAE INTERFAZ DEL BASE DE DATOS IRepositoryUsers (BASE DE DATOS) con el nombre RepositoryUsers
    @Autowired
    IRepositoryUsers RepositoryUsers;

    //@Override:INDICE QUE INDICA QUE ESTA IMPLEMENTADO
    @Override
    //FUNCION BUSCAR
    public List<Users> findall() {
        //UTILIZANDO LA INTERFAZ Y EL METEDO CrudRepository BUSCO TODOS LOS DATOS
        return (List<Users>) RepositoryUsers.findAll();
    }

    @Override
    public Users findByid(long id) {
        //al evaluar si el id esta o si no , si no esta devuelve un null
        Users nuevoUser= RepositoryUsers.findById(id).orElse(null);
        //retorno el resultado de la condicion
        return nuevoUser;
    }

    @Override
    //postUser:TRAE UN OBJETO TIPO Users Y SE LO ENVIO A OTRO TIPO Users para ser enviado a RepositoryUsers con metod save
    public Users postUser(Users users) {

        // SE GURADA ATRAVEZ DE LA INTERFAE RepositoryUsers QUE UTILIZA LA FUNCION save()
        return RepositoryUsers.save(users);
    }

    @Override
    public Users patchUser(long id, Users users) {
        //al evaluar si el id esta o si no , si no esta devuelve un null
        Users nuevoUser= RepositoryUsers.findById(id).orElse(null);
        //modifico el nuevoUser con los datos que me psaron
        nuevoUser.setNombre(users.getNombre());
        nuevoUser.setApellido(users.getApellido());
        nuevoUser.setCorreo(users.getCorreo());
        nuevoUser.setTelefono(users.getTelefono());
        nuevoUser.setContraseña(users.getContraseña());
        //GUARDO LA VARIABLE
        RepositoryUsers.save(nuevoUser);
        return  nuevoUser;

    }

    @Override
    public boolean delet(long id) {
        //al evaluar si el id esta o si no , si no esta devuelve un null
        Users nuevoUser= RepositoryUsers.findById(id).orElse(null);
        boolean condicion=true;
        if (nuevoUser==null){
            condicion=false;
        }else {
            // ELIMINO EL ID SI SE ENCONTRO EL ID
            RepositoryUsers.deleteById(id);
            condicion=true;
        }
        return condicion;
    }

    @Override
    public Users buscaryguardar(Map<String,Object> USERDATA) {
        String email= (String)USERDATA.get("email");
        Users user =buscar(email);
        if (user==null){
            String name= (String)USERDATA.get("nickmname");
            String image= (String)USERDATA.get("picture");
            String auth0= (String)USERDATA.get("sub");
            Users user1= new Users(name=name,email=email,image=image,0,auth0=auth0);
            return postUser(user1);

        }


        return user;
    }

    @Override
    public Users buscar(String email) {

        return this.RepositoryUsers.findBycorreo(email);
    }




}
