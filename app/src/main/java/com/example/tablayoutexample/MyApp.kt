package com.example.tablayoutexample

import android.app.Application
import android.widget.Toast
import com.moengage.cards.core.MoECardHelper
import com.moengage.cards.ui.MoECardUiHelper
import com.moengage.cards.ui.listener.OnCardClickListener
import com.moengage.cards.ui.model.ClickData
import com.moengage.core.LogLevel
import com.moengage.core.MoEngage
import com.moengage.core.config.LogConfig
import com.moengage.core.config.NotificationConfig

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        val moEngage = MoEngage.Builder(this, "your app id")
            .configureLogs(LogConfig(LogLevel.VERBOSE, true))
            .configureNotificationMetaData(NotificationConfig(R.mipmap.ic_launcher, R.mipmap.ic_launcher))
            .build()
        MoEngage.initialiseDefaultInstance(moEngage)

        MoECardUiHelper.setClickListener(object : OnCardClickListener{
            override fun onCardClick(clickData: ClickData): Boolean {
                Toast.makeText(applicationContext, clickData.card.cardId.toString(), Toast.LENGTH_SHORT).show()
                return true
            }

        })
    }
}