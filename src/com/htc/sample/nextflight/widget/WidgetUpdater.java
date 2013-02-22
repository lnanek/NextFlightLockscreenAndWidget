
package com.htc.sample.nextflight.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.widget.RemoteViews;

import com.htc.sample.nextflight.Prefs;
import com.htc.sample.nextflight.R;

public class WidgetUpdater {

    public static void update(final Context context) {
        final Prefs prefs = new Prefs(context);

        ComponentName thisWidget = new ComponentName(context, WidgetProvider.class);
        updateWidgets(context, thisWidget, prefs.getNextFlightName(), prefs.getNextFlightDetails());
    }

    public static void updateWidgets(final Context context, final ComponentName thisWidget,
            final String fligtName, final String flightDetails) {
    	final AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context
                .getApplicationContext());
        final int[] allWidgetIds2 = appWidgetManager.getAppWidgetIds(thisWidget);
        for (final int widgetId : allWidgetIds2) {

            final RemoteViews remoteViews = new RemoteViews(context
                    .getApplicationContext().getPackageName(),
                    R.layout.widget_layout);

            remoteViews.setTextViewText(R.id.next_flight_name, fligtName);

            final PackageManager pm = context.getPackageManager();
            final Intent clickIntent = pm.getLaunchIntentForPackage(context.getPackageName());

            clickIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            final PendingIntent clickPI = PendingIntent.getActivity(context, 0,
                    clickIntent,
                    PendingIntent.FLAG_UPDATE_CURRENT);

            remoteViews.setOnClickPendingIntent(R.id.widget_content, clickPI);

            appWidgetManager.updateAppWidget(widgetId, remoteViews);
        }
    }
}
