package com.littlekakao.travelblahblah.data

import com.littlekakao.travelblahblah.data.local.db.DbHelper
import com.littlekakao.travelblahblah.data.local.prefs.PreferencesHelper
import com.littlekakao.travelblahblah.data.remote.ApiHelper

interface DataManager: DbHelper, PreferencesHelper, ApiHelper {
}