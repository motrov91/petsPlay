package com.example.ingmanuel.petsplay.Database.DataBase;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.ingmanuel.petsplay.Database.DAO.PetDAO;
import com.example.ingmanuel.petsplay.Database.Entity.Pet;
import com.example.ingmanuel.petsplay.Utils.Utils;

@Database(entities = {Pet.class}, version = 1)
public abstract class AppDB extends RoomDatabase {

    private static AppDB INSTANCE;
    public abstract PetDAO petDAO();

    public static AppDB getAppDB(Context context){
        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDB.class, Utils.NAME_DATABASE)
                    .build();
        }
        return INSTANCE;
    }

}
