package com.bodyweight.fitness

import android.app.Application
import android.content.Context

import com.bodyweight.fitness.repository.SchemaMigration

import net.danlew.android.joda.JodaTimeAndroid

class App : Application() {
    companion object {
        @JvmStatic
        var context: Context? = null
    }

    override fun onCreate() {
        super.onCreate()

        JodaTimeAndroid.init(applicationContext)

        context = applicationContext

        SchemaMigration().apply {
            migrateSchemaIfNeeded()
        }
    }
}
