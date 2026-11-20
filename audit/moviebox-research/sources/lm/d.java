package lm;

import com.google.zxing.FormatException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final d[] f70330h = a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f70331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f70332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f70333c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f70334d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f70335e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f70336f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f70337g;

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f70338a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f70339b;

        public b(int i11, int i12) {
            this.f70338a = i11;
            this.f70339b = i12;
        }

        public int a() {
            return this.f70338a;
        }

        public int b() {
            return this.f70339b;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f70340a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b[] f70341b;

        public c(int i11, b bVar) {
            this.f70340a = i11;
            this.f70341b = new b[]{bVar};
        }

        public c(int i11, b bVar, b bVar2) {
            this.f70340a = i11;
            this.f70341b = new b[]{bVar, bVar2};
        }

        public b[] a() {
            return this.f70341b;
        }

        public int b() {
            return this.f70340a;
        }
    }

    public d(int i11, int i12, int i13, int i14, int i15, c cVar) {
        this.f70331a = i11;
        this.f70332b = i12;
        this.f70333c = i13;
        this.f70334d = i14;
        this.f70335e = i15;
        this.f70336f = cVar;
        int iB = cVar.b();
        int iA = 0;
        for (b bVar : cVar.a()) {
            iA += bVar.a() * (bVar.b() + iB);
        }
        this.f70337g = iA;
    }

    public static d[] a() {
        int i11 = 48;
        int i12 = 8;
        int i13 = 1;
        int i14 = 5;
        int i15 = 7;
        int i16 = 12;
        int i17 = 18;
        int i18 = 36;
        int i19 = 62;
        int i21 = 42;
        int i22 = 56;
        b bVar = new b(i13, 10);
        b bVar2 = new b(i13, 16);
        int i23 = 32;
        int i24 = 38;
        return new d[]{new d(1, 10, 10, 8, 8, new c(i14, new b(i13, 3))), new d(2, 12, 12, 10, 10, new c(i15, new b(i13, i14))), new d(3, 14, 14, 12, 12, new c(10, new b(i13, i12))), new d(4, 16, 16, 14, 14, new c(i16, new b(i13, i16))), new d(5, 18, 18, 16, 16, new c(14, new b(i13, 18))), new d(6, 20, 20, 18, 18, new c(i17, new b(i13, 22))), new d(7, 22, 22, 20, 20, new c(20, new b(i13, 30))), new d(8, 24, 24, 22, 22, new c(24, new b(i13, i18))), new d(9, 26, 26, 24, 24, new c(28, new b(i13, 44))), new d(10, 32, 32, 14, 14, new c(i18, new b(i13, i19))), new d(11, 36, 36, 16, 16, new c(i21, new b(i13, 86))), new d(12, 40, 40, 18, 18, new c(i11, new b(i13, 114))), new d(13, 44, 44, 20, 20, new c(i22, new b(i13, 144))), new d(14, 48, 48, 22, 22, new c(68, new b(i13, 174))), new d(15, 52, 52, 24, 24, new c(i21, new b(2, 102))), new d(16, 64, 64, 14, 14, new c(i22, new b(2, 140))), new d(17, 72, 72, 16, 16, new c(i18, new b(4, 92))), new d(18, 80, 80, 18, 18, new c(i11, new b(4, 114))), new d(19, 88, 88, 20, 20, new c(i22, new b(4, 144))), new d(20, 96, 96, 22, 22, new c(68, new b(4, 174))), new d(21, 104, 104, 24, 24, new c(i22, new b(6, 136))), new d(22, 120, 120, 18, 18, new c(68, new b(6, 175))), new d(23, 132, 132, 20, 20, new c(i19, new b(i12, 163))), new d(24, 144, 144, 22, 22, new c(i19, new b(i12, 156), new b(2, 155))), new d(25, 8, 18, 6, 16, new c(i15, new b(i13, 5))), new d(26, 8, 32, 6, 14, new c(11, bVar)), new d(27, 12, 26, 10, 24, new c(14, bVar2)), new d(28, 12, 36, 10, 16, new c(i17, new b(i13, 22))), new d(29, 16, 36, 14, 16, new c(24, new b(i13, i23))), new d(30, 16, 48, 14, 22, new c(28, new b(i13, 49))), new d(31, 8, 48, 6, 22, new c(15, new b(i13, i17))), new d(32, 8, 64, 6, 14, new c(i17, new b(i13, 24))), new d(33, 8, 80, 6, 18, new c(22, new b(i13, i23))), new d(34, 8, 96, 6, 22, new c(28, new b(i13, i24))), new d(35, 8, 120, 6, 18, new c(i23, new b(i13, 49))), new d(36, 8, 144, 6, 22, new c(i18, new b(i13, 63))), new d(37, 12, 64, 10, 14, new c(27, new b(i13, 43))), new d(38, 12, 88, 10, 20, new c(i18, new b(i13, 64))), new d(39, 16, 64, 14, 14, new c(i18, new b(i13, i19))), new d(40, 20, 36, 18, 16, new c(28, new b(i13, 44))), new d(41, 20, 44, 18, 20, new c(34, new b(i13, i22))), new d(42, 20, 64, 18, 14, new c(i21, new b(i13, 84))), new d(43, 22, 48, 20, 22, new c(i24, new b(i13, 72))), new d(44, 24, 48, 22, 22, new c(41, new b(i13, 80))), new d(45, 24, 64, 22, 14, new c(46, new b(i13, 108))), new d(46, 26, 40, 24, 18, new c(i24, new b(i13, 70))), new d(47, 26, 48, 24, 22, new c(i21, new b(i13, 90))), new d(48, 26, 64, 24, 14, new c(50, new b(i13, 118)))};
    }

    public static d h(int i11, int i12) throws FormatException {
        if ((i11 & 1) != 0 || (i12 & 1) != 0) {
            throw FormatException.getFormatInstance();
        }
        for (d dVar : f70330h) {
            if (dVar.f70332b == i11 && dVar.f70333c == i12) {
                return dVar;
            }
        }
        throw FormatException.getFormatInstance();
    }

    public int b() {
        return this.f70335e;
    }

    public int c() {
        return this.f70334d;
    }

    public c d() {
        return this.f70336f;
    }

    public int e() {
        return this.f70333c;
    }

    public int f() {
        return this.f70332b;
    }

    public int g() {
        return this.f70337g;
    }

    public int i() {
        return this.f70331a;
    }

    public String toString() {
        return String.valueOf(this.f70331a);
    }
}
