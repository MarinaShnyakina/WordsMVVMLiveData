package ru.synergy.wordsmvvmlivedata.data.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WordDao {

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    public LiveData<List<Word>> getAlphabetizedWords();

    @Insert(onConflict = OnConflictStrategy.IGNORE) // если БД боевая, то необходимо делать ABORT
    public void insert(Word word);

    @Query("DELETE FROM word_table")
    public void deleteAll();
}
