package com.decodenow.crud.repository;

import com.decodenow.crud.model.PersonalDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalDetailsRepo extends JpaRepository<PersonalDetails,Integer> {
    @Query("select personalDetails from PersonalDetails personalDetails where personalDetails.id =?1")
    public PersonalDetails getById(Integer id);
}
