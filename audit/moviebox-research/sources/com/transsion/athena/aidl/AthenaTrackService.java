package com.transsion.athena.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import athena.a0;
import com.transsion.athena.data.TrackData;
import com.transsion.ga.AthenaAnalytics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class AthenaTrackService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final athena.a.AbstractBinderC0131a f50746a = new a(this);

    /* JADX INFO: compiled from: source.java */
    public class a extends athena.a.AbstractBinderC0131a {
        public a(AthenaTrackService athenaTrackService) {
        }

        @Override // athena.a
        public void V(String str, TrackData trackData, long j11) throws RemoteException {
            a0.b("AthenaTrackService receive appId : %d, eventName : %s", Long.valueOf(j11), str);
            AthenaAnalytics.A(j11).R(str, trackData, j11);
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        a0.a("AthenaTrackService onBind");
        return this.f50746a;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        a0.a("AthenaTrackService onUnbind");
        return super.onUnbind(intent);
    }
}
