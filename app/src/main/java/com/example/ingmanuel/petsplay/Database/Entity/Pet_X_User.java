package com.example.ingmanuel.petsplay.Database.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;

import com.example.ingmanuel.petsplay.Utils.Utils;

@Entity(tableName = Utils.TABLE_USER_X_PET,
    primaryKeys = {"idPetFk", "idUserFk"},
    foreignKeys = {@ForeignKey(entity = User.class,
                        parentColumns = "idUser",
                        childColumns = "idUserFk"),
                    @ForeignKey(entity = Pet.class,
                        parentColumns = "idPet",
                        childColumns = "idPetFk")
    })
public class Pet_X_User {

    @ColumnInfo(name = "idPetFk")
    public int idPetFk;

    @ColumnInfo(name = "idUserFk")
    public int idUserFk;

    public int getIdPetFk() {
        return idPetFk;
    }

    public void setIdPetFk(int idPetFk) {
        this.idPetFk = idPetFk;
    }

    public int getIdUserFk() {
        return idUserFk;
    }

    public void setIdUserFk(int idUserFk) {
        this.idUserFk = idUserFk;
    }
}
