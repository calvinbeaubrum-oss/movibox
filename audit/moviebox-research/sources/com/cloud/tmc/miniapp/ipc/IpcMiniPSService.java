package com.cloud.tmc.miniapp.ipc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.cloud.tmc.kernel.log.TmcLogger;
import k.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class IpcMiniPSService extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        TmcLogger.c(":IpcTaskManagerService", "onBind");
        return new b();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        TmcLogger.c(":IpcTaskManagerService", "onCreate");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        TmcLogger.c(":IpcTaskManagerService", "onDestroy");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i11, int i12) {
        TmcLogger.c(":IpcTaskManagerService", "onStartCommand");
        return super.onStartCommand(intent, i11, i12);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        TmcLogger.c(":IpcTaskManagerService", "onUnbind");
        return super.onUnbind(intent);
    }
}
