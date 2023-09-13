package com.example.td1_kotlin_project.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.td1_kotlin_project.data.model.ChuckNorrisEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ChuckNorrisDao {


    @Query("SELECT * FROM chuck_norris_table ORDER BY quote ASC")
    fun selectAll(): Flow<List<ChuckNorrisEntity>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(chuckNorrisEntity: ChuckNorrisEntity)


    @Query("DELETE FROM chuck_norris_table")
    fun deleteAll()
}

