package kg;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class g implements gg.b<SchedulerConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u10.a<og.a> f68563a;

    public g(u10.a<og.a> aVar) {
        this.f68563a = aVar;
    }

    public static SchedulerConfig a(og.a aVar) {
        return (SchedulerConfig) gg.d.d(f.a(aVar));
    }

    public static g b(u10.a<og.a> aVar) {
        return new g(aVar);
    }

    @Override // u10.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public SchedulerConfig get() {
        return a(this.f68563a.get());
    }
}
