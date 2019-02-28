package com.example.ingmanuel.petsplay.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.ingmanuel.petsplay.Database.Entity.Pet;
import com.example.ingmanuel.petsplay.Database.RepositoryData.RepositoryPet;

import java.util.List;

public class PetsViewModel extends AndroidViewModel {

    private RepositoryPet mRepositoryPet;
    private LiveData<List<Pet>> mAllPets;

    public PetsViewModel(Application application) {
        super(application);
        mRepositoryPet = new RepositoryPet(application);
        mAllPets = mRepositoryPet.getAllPets();
    }

    public LiveData<List<Pet>> getAllPets(){
        return mAllPets;
    }

    public void insert(Pet pet){
        mRepositoryPet.insert(pet);
    }


}
