package com.example.okejon.insideout;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.RemoteViews;

import java.text.DateFormat;
import java.util.Date;

/**
 * Implementation of App Widget functionality.
 */
public class NewWidget extends AppWidgetProvider {

    private static final String SHARE_PREF_FILE = "appwidgetku";
    private static final String COUNT_KEY = "count";
    private static final int lala =0;
    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        SharedPreferences prefs = context.getSharedPreferences(SHARE_PREF_FILE,0);
        int count = prefs.getInt(COUNT_KEY + appWidgetId,0);
        count ++;
        String dateString = DateFormat.getTimeInstance(DateFormat.SHORT).format(new Date());
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_widget);
        views.setTextViewText(R.id.appwidget_id, String.valueOf(appWidgetId));
        views.setTextViewText(R.id.appwidget_update,context.getResources().getString(R.string.date_count_format,count,dateString));
        views.setImageViewResource(R.id.icon,R.drawable.example_appwidget_preview);
        //menyimpan kembali ke sharedpred
        SharedPreferences.Editor predEditor = prefs.edit();
        predEditor.putInt(COUNT_KEY + appWidgetId,count);
        predEditor.apply();

        //setup button update
        Intent intentUpdate = new Intent(context,NewWidget.class);
        //action intent harus sebagai app widget update
        intentUpdate.setAction(appWidgetManager.ACTION_APPWIDGET_UPDATE);

        //masukkan id dari widget yang akan diupdate
        int[] idArray =new int[]{appWidgetId};
        intentUpdate.putExtra(appWidgetManager.EXTRA_APPWIDGET_IDS,idArray);

        PendingIntent pendingUpdate = PendingIntent.getBroadcast(context,appWidgetId,intentUpdate,PendingIntent.FLAG_UPDATE_CURRENT);
        views.setOnClickPendingIntent(R.id.button_update,pendingUpdate);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}