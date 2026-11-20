package q9;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class d {

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f74466a = new a();

        /* JADX INFO: compiled from: source.java */
        public class a extends d {
            public a() {
                super();
            }

            @Override // q9.d
            public boolean b() {
                return true;
            }

            @Override // q9.d
            public int c() {
                return 16;
            }
        }
    }

    public d() {
    }

    public static d a() {
        return b.f74466a;
    }

    public abstract boolean b();

    public abstract int c();
}
