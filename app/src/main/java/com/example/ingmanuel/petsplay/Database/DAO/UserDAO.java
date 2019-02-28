package com.example.ingmanuel.petsplay.Database.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.ingmanuel.petsplay.Database.Entity.User;

import java.util.List;

@Dao
public interface UserDAO {

    @Insert
    void insertUser(User user);

    @Query("SELECT * FROM user")
    List<User> findAllUsers();

    @Update
    void updateById(User user);

    @Delete
    void deleteById(User user);
}
