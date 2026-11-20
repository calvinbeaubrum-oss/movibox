package nl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class t extends u<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static t f72056a;

    public static synchronized t e() {
        try {
            if (f72056a == null) {
                f72056a = new t();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f72056a;
    }

    @Override // nl.u
    public String a() {
        return "com.google.firebase.perf.TraceSamplingRate";
    }

    @Override // nl.u
    public String c() {
        return "fpr_vc_trace_sampling_rate";
    }

    public Float d() {
        return Float.valueOf(1.0f);
    }
}
