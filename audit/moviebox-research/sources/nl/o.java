package nl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class o extends u<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static o f72051a;

    public static synchronized o e() {
        try {
            if (f72051a == null) {
                f72051a = new o();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f72051a;
    }

    @Override // nl.u
    public String a() {
        return "com.google.firebase.perf.SessionsMemoryCaptureFrequencyBackgroundMs";
    }

    @Override // nl.u
    public String b() {
        return "sessions_memory_capture_frequency_bg_ms";
    }

    @Override // nl.u
    public String c() {
        return "fpr_session_gauge_memory_capture_frequency_bg_ms";
    }

    public Long d() {
        return 0L;
    }
}
