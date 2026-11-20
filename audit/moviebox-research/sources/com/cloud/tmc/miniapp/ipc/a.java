package com.cloud.tmc.miniapp.ipc;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.cloud.tmc.kernel.log.TmcLogger;
import hd.g;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f31546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f31547b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ i.a f31548c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f31549d;

    public a(String str, Context context, i.a aVar, String str2) {
        this.f31546a = str;
        this.f31547b = context;
        this.f31548c = aVar;
        this.f31549d = str2;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            TmcLogger.c(":IpcTaskManagerService", "warmupWebview iMiniLauncherChannel");
            g gVarE0 = g.a.e0(iBinder);
            Bundle bundle = new Bundle();
            String str = this.f31549d;
            if (str == null) {
                str = "";
            }
            bundle.putString("keyMiniAppSyncData", str);
            if (gVarE0 != null) {
                gVarE0.b0(this.f31546a, bundle);
            }
            try {
                this.f31547b.unbindService(this);
            } catch (Throwable th2) {
                TmcLogger.h(":IpcTaskManagerService", th2);
            }
        } catch (Throwable th3) {
            TmcLogger.g(":IpcTaskManagerService", "Exception startService", th3);
            i.a aVar = this.f31548c;
            if (aVar != null) {
                aVar.a(0, th3);
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        System.out.println((Object) "connect fail");
    }
}
