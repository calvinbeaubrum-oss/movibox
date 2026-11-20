package nl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class c extends u<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static c f72039a;

    public static synchronized c d() {
        try {
            if (f72039a == null) {
                f72039a = new c();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f72039a;
    }

    @Override // nl.u
    public String a() {
        return "isEnabled";
    }

    @Override // nl.u
    public String b() {
        return "firebase_performance_collection_enabled";
    }
}
