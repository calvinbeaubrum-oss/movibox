package nl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class r extends u<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static r f72054a;

    public static synchronized r e() {
        try {
            if (f72054a == null) {
                f72054a = new r();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f72054a;
    }

    @Override // nl.u
    public String a() {
        return "com.google.firebase.perf.TraceEventCountBackground";
    }

    @Override // nl.u
    public String c() {
        return "fpr_rl_trace_event_count_bg";
    }

    public Long d() {
        return 30L;
    }
}
