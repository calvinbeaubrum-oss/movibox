package com.transsnet.downloader.core;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class ForegroundService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f60481a = "ForegroundService";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f60482b = false;

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        Log.e(f60481a, "onBind");
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.e(f60481a, "onCreate");
    }

    @Override // android.app.Service
    public void onDestroy() {
        Log.e(f60481a, "onDestroy");
        f60482b = false;
        stopForeground(true);
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i11, int i12) {
        Log.e(f60481a, "onStartCommand");
        f60482b = true;
        try {
            Toast.makeText(this, intent.getStringExtra("Foreground"), 0).show();
        } catch (Throwable unused) {
        }
        return super.onStartCommand(intent, i11, i12);
    }
}
