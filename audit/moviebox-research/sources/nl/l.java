package nl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class l extends u<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static l f72048a;

    public static synchronized l e() {
        try {
            if (f72048a == null) {
                f72048a = new l();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f72048a;
    }

    @Override // nl.u
    public String a() {
        return "com.google.firebase.perf.SessionsCpuCaptureFrequencyBackgroundMs";
    }

    @Override // nl.u
    public String b() {
        return "sessions_cpu_capture_frequency_bg_ms";
    }

    @Override // nl.u
    public String c() {
        return "fpr_session_gauge_cpu_capture_frequency_bg_ms";
    }

    public Long d() {
        return 0L;
    }
}
