package nl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class j extends u<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static j f72046a;

    public static synchronized j e() {
        try {
            if (f72046a == null) {
                f72046a = new j();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f72046a;
    }

    @Override // nl.u
    public String a() {
        return "com.google.firebase.perf.SdkDisabledVersions";
    }

    @Override // nl.u
    public String c() {
        return "fpr_disabled_android_versions";
    }

    public String d() {
        return "";
    }
}
