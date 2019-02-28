package com.example.ingmanuel.petsplay.Database.RepositoryData;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.ingmanuel.petsplay.Database.DAO.PetDAO;
import com.example.ingmanuel.petsplay.Database.DataBase.AppDB;
import com.example.ingmanuel.petsplay.Database.Entity.Pet;

import java.util.List;

public class RepositoryPet {

    private PetDAO petDAO;
    private LiveData<List<Pet>> mAllPets;

    public RepositoryPet(Application application){
        AppDB db = AppDB.getAppDB(application);
        petDAO = db.petDAO();
        mAllPets = petDAO.allPets();
    }

    public LiveData<List<Pet>>getAllPets(){
        return mAllPets;
    }

    public void insert(Pet pet){
        new insertAsyncTask(petDAO).execute(pet);
    }


    private static class insertAsyncTask extends AsyncTask<Pet, Void, Void>{

        private PetDAO AsyncTaskpetDAO;

        insertAsyncTask(PetDAO dao){
            AsyncTaskpetDAO = dao;
        }

        @Override
        protected Void doInBackground(Pet... pets) {

            AsyncTaskpetDAO.insertPet(pets[0]);

            return null;
        }
    }
}
