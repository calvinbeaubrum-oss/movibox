package nl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class m extends u<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static m f72049a;

    public static synchronized m e() {
        try {
            if (f72049a == null) {
                f72049a = new m();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f72049a;
    }

    @Override // nl.u
    public String a() {
        return "com.google.firebase.perf.SessionsCpuCaptureFrequencyForegroundMs";
    }

    @Override // nl.u
    public String b() {
        return "sessions_cpu_capture_frequency_fg_ms";
    }

    @Override // nl.u
    public String c() {
        return "fpr_session_gauge_cpu_capture_frequency_fg_ms";
    }

    public Long d() {
        return 100L;
    }
}
