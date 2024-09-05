package com.sachin.data

import com.sachin.data.db.DatabaseHelper
import com.sachin.data.http.ApiHelper

interface DataHelper {
    val databaseHelper: DatabaseHelper
    val apiHelper: ApiHelper
}