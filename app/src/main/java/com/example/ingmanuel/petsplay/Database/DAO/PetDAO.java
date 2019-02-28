package com.example.ingmanuel.petsplay.Database.DAO;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.ingmanuel.petsplay.Database.Entity.Pet;

import java.util.List;

@Dao
public interface PetDAO {

    @Insert
    void insertPet(Pet pet);

    @Query("SELECT * FROM pet")
    LiveData<List<Pet>> allPets();

    @Update
    void updatePetById(Pet pet);

    @Delete
    void deletePetById(Pet pet);

}
