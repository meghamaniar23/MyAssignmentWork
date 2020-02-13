package com.parity.assignment.Room;

import com.parity.assignment.model.DealsData;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface DealsDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(DealsEntity dealsEntity);

    @Query("DELETE FROM deals_table")
    void clearTable();

    @Query("SELECT * from deals_table WHERE category = (:categoryType)")
    List<DealsEntity> getDeals(String categoryType);

}
