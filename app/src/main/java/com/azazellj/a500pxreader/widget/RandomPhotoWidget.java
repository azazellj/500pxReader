package com.azazellj.a500pxreader.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.RemoteViews;

import com.azazellj.a500pxreader.R;
import com.azazellj.a500pxreader.data.Api;
import com.azazellj.a500pxreader.model.ResponseObject;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by azazellj on 20.03.16.
 */
public class RandomPhotoWidget extends AppWidgetProvider {
    private Context context;
    private AppWidgetManager appWidgetManager;
    private int[] appWidgetIds;

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        this.context = context;
        this.appWidgetManager = appWidgetManager;
        this.appWidgetIds = appWidgetIds;

        makeUpdate();
    }

    private void makeUpdate() {
        new Api().getRandomPhoto(new Callback<ResponseObject>() {
            @Override
            public void onResponse(Call<ResponseObject> call, Response<ResponseObject> response) {
                updatePhotoWidget(response.body().photos.get(0).image_url);
            }

            @Override
            public void onFailure(Call<ResponseObject> call, Throwable t) {
            }
        });
    }

    private void updatePhotoWidget(String imageUrl) {
        new LoadPhotoTask(imageUrl).execute();
    }

    private RemoteViews buildUpdate(Context context, int[] appWidgetIds, Bitmap bitmap) {
        final RemoteViews updateViews = new RemoteViews(context.getPackageName(), R.layout.random_photo_widget);

        Intent intent = new Intent(context, RandomPhotoWidget.class);
        intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        updateViews.setImageViewBitmap(R.id.randomPhotoView, bitmap);
        updateViews.setOnClickPendingIntent(R.id.background, pendingIntent);

        return updateViews;
    }


    class LoadPhotoTask extends AsyncTask<Void, Void, Void> {
        private Bitmap bitmap;
        private String imageUrl;

        public LoadPhotoTask(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                bitmap = Picasso.with(context).load(imageUrl).get();
            } catch (IOException ioEx) {
                ioEx.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            ComponentName componentName = new ComponentName(context, RandomPhotoWidget.class);
            appWidgetManager.updateAppWidget(componentName, buildUpdate(context, appWidgetIds, bitmap));
        }
    }
}
