package com.transsion.ga;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import athena.a0;
import com.transsion.athena.data.TrackDataWrapper;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class j implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AthenaAnalytics f51966a;

    public j(AthenaAnalytics athenaAnalytics) {
        this.f51966a = athenaAnalytics;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.f51966a.f51934b = athena.a.AbstractBinderC0131a.e0(iBinder);
            this.f51966a.f51935c = true;
            a0.e("AthenaTrackService onServiceConnected");
            for (TrackDataWrapper trackDataWrapper : this.f51966a.f51936d) {
                if (trackDataWrapper.c().b() < 524288) {
                    this.f51966a.o(trackDataWrapper.a(), trackDataWrapper.c(), trackDataWrapper.b());
                } else {
                    a0.c("TrackData size is too large, ignored !!");
                }
            }
            this.f51966a.f51936d.clear();
        } catch (Exception e11) {
            a0.c(Log.getStackTraceString(e11));
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f51966a.f51935c = false;
        a0.e("AthenaTrackService onServiceDisconnected");
    }
}
