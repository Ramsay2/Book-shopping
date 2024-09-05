package com.sachin.data

import com.sachin.data.db.DatabaseHelper
import com.sachin.data.http.ApiHelper
import javax.inject.Inject

class DataHelperImpl @Inject
constructor(
    override val databaseHelper: DatabaseHelper,
    override val apiHelper: ApiHelper
) : DataHelper