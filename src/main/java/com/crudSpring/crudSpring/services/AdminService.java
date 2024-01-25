package com.crudSpring.crudSpring.services;

import com.crudSpring.crudSpring.models.AdminModel;
import com.crudSpring.crudSpring.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public ArrayList<AdminModel> getAllAdmin(){
        return (ArrayList<AdminModel>) adminRepository.findAll();
    }

    public Optional<AdminModel> getAdminById(Long id){
        return adminRepository.findById(id);
    }

    public boolean postAdmin(AdminModel adminModel){
        try{
            adminRepository.save(adminModel);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean putAdmin(AdminModel adminModel){
        Optional<AdminModel> verify = adminRepository.findById(adminModel.getId());
        if (verify.isPresent()){
            try{
                adminRepository.save(adminModel);
                return true;
            }catch (Exception e){
                return false;
            }
        }else{
            return false;
        }

    }



    public boolean deleteAdmin(Long id){
        try{
            adminRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
