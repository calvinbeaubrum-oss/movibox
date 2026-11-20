package nl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class k extends u<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static k f72047a;

    public static synchronized k e() {
        try {
            if (f72047a == null) {
                f72047a = new k();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f72047a;
    }

    @Override // nl.u
    public String a() {
        return "com.google.firebase.perf.SdkEnabled";
    }

    @Override // nl.u
    public String c() {
        return "fpr_enabled";
    }

    public Boolean d() {
        return Boolean.TRUE;
    }
}
