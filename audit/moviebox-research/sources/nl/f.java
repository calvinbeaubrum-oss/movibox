package nl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class f extends u<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static f f72042a;

    public static synchronized f e() {
        try {
            if (f72042a == null) {
                f72042a = new f();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f72042a;
    }

    @Override // nl.u
    public String a() {
        return "com.google.firebase.perf.NetworkEventCountBackground";
    }

    @Override // nl.u
    public String c() {
        return "fpr_rl_network_event_count_bg";
    }

    public Long d() {
        return 70L;
    }
}
