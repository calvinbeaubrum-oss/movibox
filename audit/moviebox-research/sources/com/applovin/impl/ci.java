package com.applovin.impl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class ci {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f18192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f18193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f18194c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f18195d;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b[] f18196a;

        public a(b... bVarArr) {
            this.f18196a = bVarArr;
        }

        public int a() {
            return this.f18196a.length;
        }

        public b a(int i11) {
            return this.f18196a[i11];
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f18197a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f18198b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float[] f18199c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float[] f18200d;

        public b(int i11, float[] fArr, float[] fArr2, int i12) {
            this.f18197a = i11;
            b1.a(((long) fArr.length) * 2 == ((long) fArr2.length) * 3);
            this.f18199c = fArr;
            this.f18200d = fArr2;
            this.f18198b = i12;
        }

        public int a() {
            return this.f18199c.length / 3;
        }
    }

    public ci(a aVar, int i11) {
        this(aVar, aVar, i11);
    }

    public ci(a aVar, a aVar2, int i11) {
        this.f18192a = aVar;
        this.f18193b = aVar2;
        this.f18194c = i11;
        this.f18195d = aVar == aVar2;
    }

    public static ci a(float f11, int i11, int i12, float f12, float f13, int i13) {
        int i14;
        int i15;
        int i16;
        float[] fArr;
        int i17 = i11;
        int i18 = i12;
        b1.a(f11 > 0.0f);
        b1.a(i17 >= 1);
        b1.a(i18 >= 1);
        b1.a(f12 > 0.0f && f12 <= 180.0f);
        b1.a(f13 > 0.0f && f13 <= 360.0f);
        float radians = (float) Math.toRadians(f12);
        float radians2 = (float) Math.toRadians(f13);
        float f14 = radians / i17;
        float f15 = radians2 / i18;
        int i19 = i18 + 1;
        int i21 = ((i19 * 2) + 2) * i17;
        float[] fArr2 = new float[i21 * 3];
        float[] fArr3 = new float[i21 * 2];
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        while (i22 < i17) {
            float f16 = radians / 2.0f;
            float f17 = (i22 * f14) - f16;
            int i25 = i22 + 1;
            float f18 = (i25 * f14) - f16;
            int i26 = 0;
            while (i26 < i19) {
                float f19 = f17;
                int i27 = i25;
                int i28 = 2;
                int i29 = 0;
                while (i29 < i28) {
                    float f21 = i26 * f15;
                    float f22 = f15;
                    int i31 = i26;
                    double d11 = f11;
                    float f23 = f14;
                    double d12 = (f21 + 3.1415927f) - (radians2 / 2.0f);
                    int i32 = i29;
                    double d13 = i29 == 0 ? f19 : f18;
                    float[] fArr4 = fArr3;
                    float f24 = f18;
                    fArr2[i23] = -((float) (Math.sin(d12) * d11 * Math.cos(d13)));
                    float f25 = radians;
                    float f26 = radians2;
                    fArr2[i23 + 1] = (float) (d11 * Math.sin(d13));
                    int i33 = i23 + 3;
                    fArr2[i23 + 2] = (float) (d11 * Math.cos(d12) * Math.cos(d13));
                    fArr4[i24] = f21 / f26;
                    int i34 = i24 + 2;
                    fArr4[i24 + 1] = ((i22 + i32) * f23) / f25;
                    if (i31 == 0 && i32 == 0) {
                        i14 = i12;
                        i15 = i31;
                        i16 = i32;
                    } else {
                        i14 = i12;
                        i15 = i31;
                        i16 = i32;
                        if (i15 != i14 || i16 != 1) {
                            fArr = fArr4;
                            i28 = 2;
                            i24 = i34;
                            i23 = i33;
                        }
                        i29 = i16 + 1;
                        i18 = i14;
                        i26 = i15;
                        fArr3 = fArr;
                        radians = f25;
                        i19 = i19;
                        f15 = f22;
                        f14 = f23;
                        radians2 = f26;
                        f18 = f24;
                    }
                    System.arraycopy(fArr2, i23, fArr2, i33, 3);
                    i23 += 6;
                    fArr = fArr4;
                    i28 = 2;
                    System.arraycopy(fArr, i24, fArr, i34, 2);
                    i24 += 4;
                    i29 = i16 + 1;
                    i18 = i14;
                    i26 = i15;
                    fArr3 = fArr;
                    radians = f25;
                    i19 = i19;
                    f15 = f22;
                    f14 = f23;
                    radians2 = f26;
                    f18 = f24;
                }
                float f27 = radians2;
                int i35 = i26;
                int i36 = i18;
                int i37 = i35 + 1;
                f17 = f19;
                i25 = i27;
                f14 = f14;
                radians2 = f27;
                f18 = f18;
                i18 = i36;
                i26 = i37;
            }
            i17 = i11;
            i22 = i25;
        }
        return new ci(new a(new b(0, fArr2, fArr3, 1)), i13);
    }

    public static ci a(int i11) {
        return a(50.0f, 36, 72, 180.0f, 360.0f, i11);
    }
}
