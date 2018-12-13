package com.example.okejon.insideout;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class Widgetku extends AppWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for(int appWidgetID:appWidgetIds){
            Intent  intent = new Intent(context, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context,0, intent,0);

            Intent  intent2 = new Intent(context, MediaPlayback.class);
            PendingIntent pendingIntent2 = PendingIntent.getActivity(context,0, intent2,0);

            RemoteViews views=new RemoteViews(context.getPackageName(),R.layout.widgetku);
            views.setOnClickPendingIntent(R.id.button_widget,pendingIntent);

            RemoteViews views2=new RemoteViews(context.getPackageName(),R.layout.widgetku);
            views.setOnClickPendingIntent(R.id.button_widget2,pendingIntent2);

            appWidgetManager.updateAppWidget(appWidgetID,views);
            appWidgetManager.updateAppWidget(appWidgetID,views2);
        }
    }
}
