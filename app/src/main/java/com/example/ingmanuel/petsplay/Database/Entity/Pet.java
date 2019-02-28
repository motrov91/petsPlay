package com.example.ingmanuel.petsplay.Database.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.example.ingmanuel.petsplay.Utils.Utils;

import java.io.Serializable;

@Entity(tableName = Utils.TABLE_PET)
public class Pet implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idPet")
    int idPet;

    @ColumnInfo(name = "namePet")
    @NonNull
    String namePet;

    @ColumnInfo(name = "kindOfPet")
    String KindOfPet;

    @ColumnInfo(name = "breedPet")
    String breedPet;

    @ColumnInfo(name = "agePet")
    String AgePet;

    @ColumnInfo(name = "lastControlPet")
    String lastControl;


    public String getAgePet() {
        return AgePet;
    }

    public void setAgePet(String agePet) {
        AgePet = agePet;
    }

    public String getKindOfPet() {
        return KindOfPet;
    }

    public void setKindOfPet(String kindOfPet) {
        KindOfPet = kindOfPet;
    }

    public String getLastControl() {
        return lastControl;
    }

    public void setLastControl(String lastControl) {
        this.lastControl = lastControl;
    }

    public int getIdPet() {
        return idPet;
    }

    public void setIdPet(int idPet) {
        this.idPet = idPet;
    }

    @NonNull
    public String getNamePet() {
        return namePet;
    }

    public void setNamePet(@NonNull String namePet) {
        this.namePet = namePet;
    }

    @NonNull
    public String getBreedPet() {
        return breedPet;
    }

    public void setBreedPet(@NonNull String breedPet) {
        this.breedPet = breedPet;
    }
}
