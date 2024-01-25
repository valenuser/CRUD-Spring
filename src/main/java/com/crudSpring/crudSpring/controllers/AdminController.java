package com.crudSpring.crudSpring.controllers;

import com.crudSpring.crudSpring.models.AdminModel;
import com.crudSpring.crudSpring.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping(path = "/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping
    public ArrayList<AdminModel> getAllAdmin(){
        return adminService.getAllAdmin();
    }

    @GetMapping(path = "/{id}")
    public Optional<AdminModel>  getAdminById(@PathVariable Long id){
        return adminService.getAdminById(id);
    }

    @PostMapping
    public String postAdmin(@RequestBody AdminModel adminModel){
        boolean response = adminService.postAdmin(adminModel);

        if(response){
            return "El administrador ha sido registrado con exito";
        }else{
            return "El administrador no ha podido ser registrado con exito";
        }
    }

    @PutMapping
    public String putAdmin(@RequestBody AdminModel adminModel){
        boolean response = adminService.putAdmin(adminModel);

        if(response){
            return String.format("El administrador con id : %s ha sido actualizado ",adminModel.getId());
        }else{
            return String.format("El administrador con id : %s no esta registrado ",adminModel.getId());
        }
    }

    @DeleteMapping(path = "/{id}")
    public String deleteAdmin(@PathVariable Long id){
        boolean response = adminService.deleteAdmin(id);

        if(response){
            return  "The user has been deleted.";
        }else{
            return "The user has not been deleted.";
        }
    }
}
