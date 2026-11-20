package oj;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f72444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final nj.a.b f72445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppMeasurementSdk f72446c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f72447d;

    public d(AppMeasurementSdk appMeasurementSdk, nj.a.b bVar) {
        this.f72445b = bVar;
        this.f72446c = appMeasurementSdk;
        c cVar = new c(this);
        this.f72447d = cVar;
        appMeasurementSdk.registerOnMeasurementEventListener(cVar);
        this.f72444a = new HashSet();
    }
}
