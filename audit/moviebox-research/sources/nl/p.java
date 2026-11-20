package nl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class p extends u<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static p f72052a;

    public static synchronized p e() {
        try {
            if (f72052a == null) {
                f72052a = new p();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f72052a;
    }

    @Override // nl.u
    public String a() {
        return "com.google.firebase.perf.SessionsMemoryCaptureFrequencyForegroundMs";
    }

    @Override // nl.u
    public String b() {
        return "sessions_memory_capture_frequency_fg_ms";
    }

    @Override // nl.u
    public String c() {
        return "fpr_session_gauge_memory_capture_frequency_fg_ms";
    }

    public Long d() {
        return 100L;
    }
}
