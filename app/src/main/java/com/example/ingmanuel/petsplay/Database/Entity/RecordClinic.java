package com.example.ingmanuel.petsplay.Database.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.example.ingmanuel.petsplay.Utils.Utils;

@Entity(tableName = Utils.TABLE_CLINIC_RECORD)
public class RecordClinic {

    @ColumnInfo(name = "idClinicRecord")
    @PrimaryKey(autoGenerate = true)
    String idClinicRecord;

    @ColumnInfo(name = "consultation")
    @NonNull
    String consultation;

    @ColumnInfo(name = "prescription")
    @NonNull
    String prescription;

}
