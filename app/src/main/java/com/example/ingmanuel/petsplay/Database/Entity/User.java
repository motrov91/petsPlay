package com.example.ingmanuel.petsplay.Database.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import com.example.ingmanuel.petsplay.Utils.Utils;

@Entity(tableName = Utils.TABLE_USER)
public class User {

    @PrimaryKey()
    @ColumnInfo(name = "idUser")
    int idUser;

    @ColumnInfo(name = "nameUser")
    @NonNull
    String nameUser;

    @ColumnInfo(name = "fullNameUser")
    String fullNameUser;

    @ColumnInfo(name = "AddressUser")
    String AddressUser;

    @ColumnInfo(name = "emailUser")
    String emailUser;

    @ColumnInfo(name = "phoneNumber")
    String phoneNumber;



}
