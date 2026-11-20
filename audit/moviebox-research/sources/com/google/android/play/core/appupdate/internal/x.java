package com.google.android.play.core.appupdate.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class x implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f38067a;

    public /* synthetic */ x(y yVar, w wVar) {
        this.f38067a = yVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f38067a.f38070b.d("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        this.f38067a.c().post(new zzt(this, iBinder));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f38067a.f38070b.d("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        this.f38067a.c().post(new zzu(this));
    }
}
