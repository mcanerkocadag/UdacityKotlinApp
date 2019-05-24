/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.apparchitecturepersistence.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SleepDatabaseDao {
    @Insert
    fun insert(night: SleepNight)

    @Update
    fun update(night: SleepNight)

    @Query("SELECT * from daily_sleep_quality_table WHERE nightID = :key")
    fun get(key: Long): SleepNight

    @Delete
    fun deleteAllNights(nights: List<SleepNight>): Int

    @Query("DELETE FROM daily_sleep_quality_table")
    fun clear()

    @Query("Select * from daily_sleep_quality_table Order by nightID desc")
    fun getAllNights(): LiveData<List<SleepNight>>

    @Query("SELECT * from daily_sleep_quality_table order by nightID desc LIMIT 1")
    fun getTonight(): SleepNight?

}
