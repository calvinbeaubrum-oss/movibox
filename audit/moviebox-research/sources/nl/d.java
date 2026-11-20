package nl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class d extends u<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static d f72040a;

    public static synchronized d e() {
        try {
            if (f72040a == null) {
                f72040a = new d();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f72040a;
    }

    @Override // nl.u
    public String a() {
        return "com.google.firebase.perf.ExperimentTTID";
    }

    @Override // nl.u
    public String b() {
        return "experiment_app_start_ttid";
    }

    @Override // nl.u
    public String c() {
        return "fpr_experiment_app_start_ttid";
    }

    public Boolean d() {
        return Boolean.FALSE;
    }
}
