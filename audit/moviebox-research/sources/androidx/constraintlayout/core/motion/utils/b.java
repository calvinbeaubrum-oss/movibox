package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: compiled from: source.java */
    public static class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public double f6438a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public double[] f6439b;

        public a(double d11, double[] dArr) {
            this.f6438a = d11;
            this.f6439b = dArr;
        }

        @Override // androidx.constraintlayout.core.motion.utils.b
        public double c(double d11, int i11) {
            return this.f6439b[i11];
        }

        @Override // androidx.constraintlayout.core.motion.utils.b
        public void d(double d11, double[] dArr) {
            double[] dArr2 = this.f6439b;
            System.arraycopy(dArr2, 0, dArr, 0, dArr2.length);
        }

        @Override // androidx.constraintlayout.core.motion.utils.b
        public void e(double d11, float[] fArr) {
            int i11 = 0;
            while (true) {
                double[] dArr = this.f6439b;
                if (i11 >= dArr.length) {
                    return;
                }
                fArr[i11] = (float) dArr[i11];
                i11++;
            }
        }

        @Override // androidx.constraintlayout.core.motion.utils.b
        public double f(double d11, int i11) {
            return 0.0d;
        }

        @Override // androidx.constraintlayout.core.motion.utils.b
        public void g(double d11, double[] dArr) {
            for (int i11 = 0; i11 < this.f6439b.length; i11++) {
                dArr[i11] = 0.0d;
            }
        }

        @Override // androidx.constraintlayout.core.motion.utils.b
        public double[] h() {
            return new double[]{this.f6438a};
        }
    }

    public static b a(int i11, double[] dArr, double[][] dArr2) {
        if (dArr.length == 1) {
            i11 = 2;
        }
        if (i11 != 0) {
            return i11 != 2 ? new e(dArr, dArr2) : new a(dArr[0], dArr2[0]);
        }
        return new f(dArr, dArr2);
    }

    public static b b(int[] iArr, double[] dArr, double[][] dArr2) {
        return new androidx.constraintlayout.core.motion.utils.a(iArr, dArr, dArr2);
    }

    public abstract double c(double d11, int i11);

    public abstract void d(double d11, double[] dArr);

    public abstract void e(double d11, float[] fArr);

    public abstract double f(double d11, int i11);

    public abstract void g(double d11, double[] dArr);

    public abstract double[] h();
}
