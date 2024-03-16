package com.decodenow.crud.controller;
import com.decodenow.crud.dto.CustomResponse;
import com.decodenow.crud.model.PersonalDetails;
import com.decodenow.crud.service.PersonalDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/details")
public class PersonalDetailsController {

    @Autowired
    public PersonalDetailsService personalDetailsService;

    @PostMapping("/add")
    public ResponseEntity<?> addDetails(@RequestBody PersonalDetails personalDetails) {
        try {
            PersonalDetails pd = personalDetailsService.addDetails(personalDetails);
            CustomResponse cs = new CustomResponse("success",pd);
            return ResponseEntity.ok(cs);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred: " + e.getMessage());
        }
    }
    @GetMapping("/getAll")
    public List<PersonalDetails> getAll(){
        List<PersonalDetails> personalDetailsList = null;
        personalDetailsList = personalDetailsService.getAll();
        return personalDetailsList;
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<?> edit(@RequestBody PersonalDetails personalDetails,@PathVariable Integer id){
        PersonalDetails pd = personalDetailsService.edit(personalDetails,id);
        CustomResponse cs = new CustomResponse("data edited successfully",pd);
        return ResponseEntity.ok(cs);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody PersonalDetails getPersonal){
        try {
            String s = personalDetailsService.delete(getPersonal);
            CustomResponse cs = new CustomResponse(s);
            return ResponseEntity.ok(cs);
        }catch (Exception e ){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error"+e.getMessage());
        }
    }

}
