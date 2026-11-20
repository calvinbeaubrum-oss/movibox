package kg;

import android.content.Context;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import lg.u;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class i implements gg.b<u> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u10.a<Context> f68564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u10.a<mg.d> f68565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u10.a<SchedulerConfig> f68566c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u10.a<og.a> f68567d;

    public i(u10.a<Context> aVar, u10.a<mg.d> aVar2, u10.a<SchedulerConfig> aVar3, u10.a<og.a> aVar4) {
        this.f68564a = aVar;
        this.f68565b = aVar2;
        this.f68566c = aVar3;
        this.f68567d = aVar4;
    }

    public static i a(u10.a<Context> aVar, u10.a<mg.d> aVar2, u10.a<SchedulerConfig> aVar3, u10.a<og.a> aVar4) {
        return new i(aVar, aVar2, aVar3, aVar4);
    }

    public static u c(Context context, mg.d dVar, SchedulerConfig schedulerConfig, og.a aVar) {
        return (u) gg.d.d(h.a(context, dVar, schedulerConfig, aVar));
    }

    @Override // u10.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public u get() {
        return c(this.f68564a.get(), this.f68565b.get(), this.f68566c.get(), this.f68567d.get());
    }
}
