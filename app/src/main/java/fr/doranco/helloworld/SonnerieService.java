package fr.doranco.helloworld;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;

public class SonnerieService extends Service {

    private final static String TAG = SonnerieService.class.getSimpleName();

    private MediaPlayer sonnerie;

    public SonnerieService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        sonnerie = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        sonnerie.setLooping(true);
        sonnerie.start();
        Log.i(TAG, "Sonnerie en cours...");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        sonnerie.stop();
        Log.i(TAG, "Sonnerie arrêtée.");
    }
}