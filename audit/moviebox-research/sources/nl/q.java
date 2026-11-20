package nl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class q extends u<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static q f72053a;

    public static synchronized q e() {
        try {
            if (f72053a == null) {
                f72053a = new q();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f72053a;
    }

    @Override // nl.u
    public String a() {
        return "com.google.firebase.perf.SessionSamplingRate";
    }

    @Override // nl.u
    public String b() {
        return "sessions_sampling_percentage";
    }

    @Override // nl.u
    public String c() {
        return "fpr_vc_session_sampling_rate";
    }

    public Float d() {
        return Float.valueOf(0.01f);
    }
}
