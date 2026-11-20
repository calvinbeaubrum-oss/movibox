package nl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class h extends u<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static h f72044a;

    public static synchronized h e() {
        try {
            if (f72044a == null) {
                f72044a = new h();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f72044a;
    }

    @Override // nl.u
    public String a() {
        return "com.google.firebase.perf.NetworkRequestSamplingRate";
    }

    @Override // nl.u
    public String c() {
        return "fpr_vc_network_request_sampling_rate";
    }

    public Float d() {
        return Float.valueOf(1.0f);
    }
}
