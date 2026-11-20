package nl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class n extends u<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static n f72050a;

    public static synchronized n e() {
        try {
            if (f72050a == null) {
                f72050a = new n();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f72050a;
    }

    @Override // nl.u
    public String a() {
        return "com.google.firebase.perf.SessionsMaxDurationMinutes";
    }

    @Override // nl.u
    public String b() {
        return "sessions_max_length_minutes";
    }

    @Override // nl.u
    public String c() {
        return "fpr_session_max_duration_min";
    }

    public Long d() {
        return 240L;
    }
}
