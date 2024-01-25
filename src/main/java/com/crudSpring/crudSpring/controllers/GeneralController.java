package com.crudSpring.crudSpring.controllers;

import com.crudSpring.crudSpring.models.AdminModel;
import com.crudSpring.crudSpring.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;

@RestController
@RequestMapping(path = "/")
public class GeneralController {

    @Autowired
    private AdminService adminService;

    @GetMapping
    public String info(){
        ArrayList<AdminModel> admin = adminService.getAllAdmin();
        return "Bienvenidos al crud de prueba, para ver todos los administradores usar /admin en la url.";
    }


}
