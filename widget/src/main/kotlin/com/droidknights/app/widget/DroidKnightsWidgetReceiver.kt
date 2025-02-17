package com.droidknights.app.widget

import android.appwidget.AppWidgetManager
import android.content.Context
import android.content.Intent
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetManager
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.appwidget.state.updateAppWidgetState
import androidx.glance.appwidget.updateAll
import androidx.glance.state.PreferencesGlanceStateDefinition
import com.droidknights.app.core.domain.usecase.GetBookmarkedSessionsUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.getKoin

internal class DroidKnightsWidgetReceiver : GlanceAppWidgetReceiver() {

    override val glanceAppWidget: GlanceAppWidget = DroidKnightsWidget()

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        getBookmarkedSessionAndUpdateWidget(context, glanceAppWidget)
        super.onUpdate(context, appWidgetManager, appWidgetIds)
    }

    override fun onReceive(context: Context, intent: Intent) {
        getBookmarkedSessionAndUpdateWidget(context, glanceAppWidget)
        super.onReceive(context, intent)
    }

    companion object {
        const val KEY_SESSION_IDS = "SESSION_IDS"
    }
}

private fun getBookmarkedSessionAndUpdateWidget(
    context: Context,
    glanceAppWidget: GlanceAppWidget
) {
    val getBookmarkedSessionsUseCase = getKoin().get<GetBookmarkedSessionsUseCase>()

    CoroutineScope(Dispatchers.IO).launch {
        val glanceIds = GlanceAppWidgetManager(context).getGlanceIds(DroidKnightsWidget::class.java)
        getBookmarkedSessionsUseCase().collect { list ->
            glanceIds.forEach { glanceId ->
                updateAppWidgetState(
                    context = context,
                    definition = PreferencesGlanceStateDefinition,
                    glanceId = glanceId
                ) {
                    val set: Set<String> = mutableSetOf<String>().apply {
                        list.forEach { session ->
                            this.add(session.id)
                        }
                    }
                    it.toMutablePreferences().apply {
                        this[stringSetPreferencesKey(DroidKnightsWidgetReceiver.KEY_SESSION_IDS)] =
                            set
                    }
                }
            }
            glanceAppWidget.updateAll(context)
        }
    }
}