package com.example.ingmanuel.petsplay.Database.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.example.ingmanuel.petsplay.Database.Entity.Pet;

import java.util.List;

@Dao
public interface User_x_Pet_DAO {

    @Query("SELECT * FROM pet INNER JOIN userXpet ON pet.idPet = userXpet.idPetFk WHERE userXpet.idUserFk = :idUser")
    List<Pet> getPetForRepository(int idUser);


}
