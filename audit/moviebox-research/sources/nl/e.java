package nl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class e extends u<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static e f72041a;

    public static synchronized e e() {
        try {
            if (f72041a == null) {
                f72041a = new e();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f72041a;
    }

    @Override // nl.u
    public String a() {
        return "com.google.firebase.perf.FragmentSamplingRate";
    }

    @Override // nl.u
    public String b() {
        return "fragment_sampling_percentage";
    }

    @Override // nl.u
    public String c() {
        return "fpr_vc_fragment_sampling_rate";
    }

    public Float d() {
        return Float.valueOf(0.0f);
    }
}
