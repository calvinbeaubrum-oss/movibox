package androidx.core.text;

import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f7875a = new e(null, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t f7876b = new e(null, true);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final t f7877c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final t f7878d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final t f7879e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final t f7880f;

    /* JADX INFO: compiled from: source.java */
    public static class a implements c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f7881b = new a(true);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f7882a;

        public a(boolean z11) {
            this.f7882a = z11;
        }

        @Override // androidx.core.text.u.c
        public int a(CharSequence charSequence, int i11, int i12) {
            int i13 = i12 + i11;
            boolean z11 = false;
            while (i11 < i13) {
                int iA = u.a(Character.getDirectionality(charSequence.charAt(i11)));
                if (iA != 0) {
                    if (iA != 1) {
                        continue;
                    } else if (!this.f7882a) {
                        return 1;
                    }
                    i11++;
                } else if (this.f7882a) {
                    return 0;
                }
                z11 = true;
                i11++;
            }
            if (z11) {
                return this.f7882a ? 1 : 0;
            }
            return 2;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f7883a = new b();

        @Override // androidx.core.text.u.c
        public int a(CharSequence charSequence, int i11, int i12) {
            int i13 = i12 + i11;
            int iB = 2;
            while (i11 < i13 && iB == 2) {
                iB = u.b(Character.getDirectionality(charSequence.charAt(i11)));
                i11++;
            }
            return iB;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        int a(CharSequence charSequence, int i11, int i12);
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class d implements t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f7884a;

        public d(c cVar) {
            this.f7884a = cVar;
        }

        @Override // androidx.core.text.t
        public boolean a(CharSequence charSequence, int i11, int i12) {
            if (charSequence == null || i11 < 0 || i12 < 0 || charSequence.length() - i12 < i11) {
                throw new IllegalArgumentException();
            }
            return this.f7884a == null ? b() : c(charSequence, i11, i12);
        }

        public abstract boolean b();

        public final boolean c(CharSequence charSequence, int i11, int i12) {
            int iA = this.f7884a.a(charSequence, i11, i12);
            if (iA == 0) {
                return true;
            }
            if (iA != 1) {
                return b();
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e extends d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f7885b;

        public e(c cVar, boolean z11) {
            super(cVar);
            this.f7885b = z11;
        }

        @Override // androidx.core.text.u.d
        public boolean b() {
            return this.f7885b;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class f extends d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final f f7886b = new f();

        public f() {
            super(null);
        }

        @Override // androidx.core.text.u.d
        public boolean b() {
            return v.a(Locale.getDefault()) == 1;
        }
    }

    static {
        b bVar = b.f7883a;
        f7877c = new e(bVar, false);
        f7878d = new e(bVar, true);
        f7879e = new e(a.f7881b, false);
        f7880f = f.f7886b;
    }

    public static int a(int i11) {
        if (i11 != 0) {
            return (i11 == 1 || i11 == 2) ? 0 : 2;
        }
        return 1;
    }

    public static int b(int i11) {
        if (i11 != 0) {
            if (i11 == 1 || i11 == 2) {
                return 0;
            }
            switch (i11) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}
