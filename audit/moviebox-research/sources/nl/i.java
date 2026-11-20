package nl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class i extends u<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static i f72045a;

    public static synchronized i e() {
        try {
            if (f72045a == null) {
                f72045a = new i();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f72045a;
    }

    @Override // nl.u
    public String a() {
        return "com.google.firebase.perf.TimeLimitSec";
    }

    @Override // nl.u
    public String c() {
        return "fpr_rl_time_limit_sec";
    }

    public Long d() {
        return 600L;
    }
}
