package nl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class b extends u<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f72038a;

    public static synchronized b e() {
        try {
            if (f72038a == null) {
                f72038a = new b();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f72038a;
    }

    @Override // nl.u
    public String b() {
        return "firebase_performance_collection_deactivated";
    }

    public Boolean d() {
        return Boolean.FALSE;
    }
}
