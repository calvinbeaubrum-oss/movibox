package nl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class s extends u<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static s f72055a;

    public static synchronized s e() {
        try {
            if (f72055a == null) {
                f72055a = new s();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f72055a;
    }

    @Override // nl.u
    public String a() {
        return "com.google.firebase.perf.TraceEventCountForeground";
    }

    @Override // nl.u
    public String c() {
        return "fpr_rl_trace_event_count_fg";
    }

    public Long d() {
        return 300L;
    }
}
