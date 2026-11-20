package nl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class g extends u<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static g f72043a;

    public static synchronized g e() {
        try {
            if (f72043a == null) {
                f72043a = new g();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f72043a;
    }

    @Override // nl.u
    public String a() {
        return "com.google.firebase.perf.NetworkEventCountForeground";
    }

    @Override // nl.u
    public String c() {
        return "fpr_rl_network_event_count_fg";
    }

    public Long d() {
        return 700L;
    }
}
