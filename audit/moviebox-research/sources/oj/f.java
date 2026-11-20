package oj;

import com.google.android.gms.measurement.api.AppMeasurementSdk;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final nj.a.b f72449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppMeasurementSdk f72450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f72451c;

    public f(AppMeasurementSdk appMeasurementSdk, nj.a.b bVar) {
        this.f72449a = bVar;
        this.f72450b = appMeasurementSdk;
        e eVar = new e(this);
        this.f72451c = eVar;
        appMeasurementSdk.registerOnMeasurementEventListener(eVar);
    }
}
