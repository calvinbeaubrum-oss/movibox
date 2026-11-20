package gl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f65571a;

    public static b a() {
        if (f65571a == null) {
            f65571a = new b();
        }
        return f65571a;
    }

    @Override // gl.a
    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }
}
