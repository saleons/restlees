package com.example.demo.Controler;

import com.example.demo.Entities.Users;
import com.example.demo.Services.IServiceUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class FrontController {
    ////@Autowired: TRAE INTERFAZ DEL IserviceUsers  (BASE DE DATOS) y pordebajo toda la logica de ImpleServicesUsers
    @Autowired
    IServiceUsers ServicioUser;

    @RequestMapping(method = RequestMethod.GET,value="/")
    //@ResponseBody para indicar que el resultado del método lo vuelque en el cuerpo de la respuesta.
    public String home(Model model, @AuthenticationPrincipal OidcUser principal){
        if (principal != null){

            ServicioUser.buscaryguardar(principal.getClaims());
        }

        return "index";
    }

    @RequestMapping(method = RequestMethod.GET,value="/logear")
    //@ResponseBody para indicar que el resultado del método lo vuelque en el cuerpo de la respuesta.
    public String home(){
        //ServicioUser SE UTILIZA LOS SERVICIOS DE LA INTERFAZ PARA ACCEDER A LOS METODOS DEL SERVICIO
        return "localizacion";
    }

}
