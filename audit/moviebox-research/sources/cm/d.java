package cm;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class d {

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f14981a = new a();

        /* JADX INFO: compiled from: source.java */
        public class a extends d {
            public a() {
                super();
            }

            @Override // cm.d
            public boolean b() {
                return true;
            }

            @Override // cm.d
            public int c() {
                return 16;
            }
        }
    }

    public d() {
    }

    public static d a() {
        return b.f14981a;
    }

    public abstract boolean b();

    public abstract int c();
}
