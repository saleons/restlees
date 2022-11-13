package com.example.demo.Controler;


import com.example.demo.Entities.Users;
import com.example.demo.Services.IServiceUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController:anotacion que indica que esto es un   controlador
@RestController

//@RequestMapping: define le URL donde se hara la peticion (http://localhost:8080/Users/(end poit al que deseo ingresar))
@RequestMapping("Users")
public class UserController {
    ////@Autowired: TRAE INTERFAZ DEL IserviceUsers  (BASE DE DATOS) y pordebajo toda la logica de ImpleServicesUsers
    @Autowired
    IServiceUsers ServicioUser;


    //GET_______________________________________________________________________________________________________________
    //@RequestMapping: end point de peticion
    //method:ES EL VERBO CON EL QUE ACCESO POST GET DELET PATCH
    //value:UBICACION ENDPOINT
    // URL DE ACCESSO DEL ENDPOIT:http://localhost:8080/Users/public/login
    @RequestMapping(method = RequestMethod.GET,value="/public/login")
    //@ResponseBody para indicar que el resultado del método lo vuelque en el cuerpo de la respuesta.
    public @ResponseBody List<Users> findall(){
        //ServicioUser SE UTILIZA LOS SERVICIOS DE LA INTERFAZ PARA ACCEDER A LOS METODOS DEL SERVICIO
        return (List<Users>)ServicioUser.findall();
    }

    //POST______________________________________________________________________________________________________________
    //@RequestMapping: end point de peticion
    //method:ES EL VERBO CON EL QUE ACCESO POST GET DELET PATCH
    //value:UBICACION ENDPOINT
    //produces: TARE EL JSON
    // URL DE ACCESSO DEL ENDPOIT:http://localhost:8080/Users/public/login
    @RequestMapping(method = RequestMethod.POST,value="/public/login",produces="application/json")
    //@ResponseBody para indicar que el resultado del método lo vuelque en el cuerpo de la respuesta.


    //@RequestBody convierte los datos json enviado por http de user en formato objeto para poder manipularlo
    public @ResponseBody Users create(@RequestBody Users users) {
        //ServicioUser SE UTILIZA LOS SERVICIOS DE LA INTERFAZ PARA ACCEDER A LOS METODOS DEL SERVICIO0
        return ServicioUser.postUser(users);
     }

    //POST______________________________________________________________________________________________________________
    //@RequestMapping: anotacion para iniciar (end point)
    //method:ES EL VERBO CON EL QUE ACCESO (POST GET DELET PATCH)
    //value:URL DONDE SE VA LLAMR EL ENDPOINT
    //produces: SE ESPECIFICA QUE LA INFORMACION A TRAER ES JSON
    // URL DE ACCESSO DEL ENDPOIT:http://localhost:8080/Users/public/login/{id}
    // donde {id}=http://localhost:8080/Users/public/login/1  el 1 es el id
    @RequestMapping(value = "/public/login/{id}",method = RequestMethod.POST,produces="application/json")
//@ResponseBody para indicar que el resultado del método lo vuelque en el cuerpo de la respuesta.

    //@RequestBody convierte los datos json enviado por http de ID en formato variable para poder manipularlo
    //@PathVariable busca en la url el [id] y lo transforma en el tipo long ej: http://localhost:8080/Users/public/login/1
    public @ResponseBody Users findById (@PathVariable long id) {

        //ServicioUser SE UTILIZA LOS SERVICIOS DE LA INTERFAZ PARA ACCEDER A LOS METODOS DEL SERVICIO
        return ServicioUser.findByid(id);
    }




    //PATH______________________________________________________________________________________________________________
    //@RequestMapping: anotacion para iniciar (end point)
    //method:ES EL VERBO CON EL QUE ACCESO (POST GET DELET PATCH)
    //value:URL DONDE SE VA LLAMR EL ENDPOINT
    //produces: SE ESPECIFICA QUE LA INFORMACION A TRAER ES JSON
    // URL DE ACCESSO DEL ENDPOIT:http://localhost:8080/Users/public/login/{id}
    // donde {id}=http://localhost:8080/Users/public/login/1  el 1 es el id
    @RequestMapping(value = "/public/login/{id}",method = RequestMethod.PATCH,produces="application/json")
    //@ExceptionHandler se encarga de anotar un método como el encargado de realizar acciones en caso de que se lance una excepción.
    @ExceptionHandler
    //@ResponseBody para indicar que el resultado del método lo vuelque en el cuerpo de la respuesta.
    @ResponseBody
    //@RequestBody convierte los datos json enviado por http de ID en formato variable para poder manipularlo
    //@PathVariable busca en la url el [id] y lo transforma en el tipo long ej: http://localhost:8080/Users/public/login/1
    public Users Update (@PathVariable long id,@RequestBody Users users) {

        //ServicioUser SE UTILIZA LOS SERVICIOS DE LA INTERFAZ PARA ACCEDER A LOS METODOS DEL SERVICIO
        return ServicioUser.patchUser(id,users);
    }

    //DELETE______________________________________________________________________________________________________________
    //@RequestMapping: end point de peticion ,RequestMethod.POST: metodo utilizado ,enlace de llamada
    @RequestMapping(value = "/public/login/{id}",method = RequestMethod.DELETE,produces = "apliacacion/Users")

    //@ResponseBody para indicar que el resultado del método lo vuelque en el cuerpo de la respuesta.
    @ResponseBody
    //@RequestBody convierte los datos json enviado por http de ID en formato variable para poder manipularlo
    //@ResponseStatus SI NO ENCUENTRA EL DATO A ELIMINAR

    public boolean DELETE (@PathVariable long id) {

        //ServicioUser SE UTILIZA LOS SERVICIOS DE LA INTERFAZ PARA ACCEDER A LOS METODOS DEL SERVICIO
        return ServicioUser.delet(id);
    }


}
