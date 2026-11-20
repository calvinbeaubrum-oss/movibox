package pl;

import com.google.firebase.perf.config.RemoteConfigManager;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class f implements u10.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f73942a;

    public f(a aVar) {
        this.f73942a = aVar;
    }

    public static f a(a aVar) {
        return new f(aVar);
    }

    public static RemoteConfigManager c(a aVar) {
        return (RemoteConfigManager) e10.b.c(aVar.e(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // u10.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RemoteConfigManager get() {
        return c(this.f73942a);
    }
}
