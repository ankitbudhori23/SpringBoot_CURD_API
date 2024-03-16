package com.decodenow.crud.service;

import com.decodenow.crud.model.PersonalDetails;
import com.decodenow.crud.repository.PersonalDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalDetailsService {
    @Autowired
    private PersonalDetailsRepo personalDetailsRepo;

    public PersonalDetails addDetails(PersonalDetails personalDetails){
        return personalDetailsRepo.save(personalDetails);
    }

  public List<PersonalDetails> getAll(){
        List<PersonalDetails> personalDetailsList = null;
        personalDetailsList = personalDetailsRepo.findAll();
        return personalDetailsList;
  }

  public PersonalDetails edit(PersonalDetails personalDetailsReq,Integer id) {

      PersonalDetails personalDetails = personalDetailsRepo.getById(id);
      if(personalDetailsReq.getFname() != null) {
          personalDetails.setFname(personalDetailsReq.getFname());
      }
      if(personalDetailsReq.getLname() != null) {
          personalDetails.setLname(personalDetailsReq.getLname());
      }
      if(personalDetailsReq.getAddress() != null){
      personalDetails.setAddress(personalDetailsReq.getAddress());
         }
      return personalDetailsRepo.save(personalDetails);
  }

     public String delete(PersonalDetails pd){
        Integer id = pd.getId();
        PersonalDetails personalDetails = personalDetailsRepo.getById(id);
        if(personalDetails == null){
            return "user does not exist";
        }else{
             personalDetailsRepo.deleteById(id);
             return "data deleted";
        }

     }
}
