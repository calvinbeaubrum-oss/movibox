package oj;

import android.os.Bundle;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class c implements AppMeasurementSdk.OnEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f72443a;

    public c(d dVar) {
        this.f72443a = dVar;
    }

    @Override // com.google.android.gms.measurement.api.AppMeasurementSdk.OnEventListener, com.google.android.gms.measurement.internal.zzgs
    public final void onEvent(String str, String str2, Bundle bundle, long j11) {
        if (this.f72443a.f72444a.contains(str2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("events", b.c(str2));
            this.f72443a.f72445b.a(2, bundle2);
        }
    }
}
