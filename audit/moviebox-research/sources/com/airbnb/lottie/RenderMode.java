package com.airbnb.lottie;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public enum RenderMode {
    AUTOMATIC,
    HARDWARE,
    SOFTWARE;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15072a;

        static {
            int[] iArr = new int[RenderMode.values().length];
            f15072a = iArr;
            try {
                iArr[RenderMode.HARDWARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15072a[RenderMode.SOFTWARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15072a[RenderMode.AUTOMATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public boolean useSoftwareRendering(int i11, boolean z11, int i12) {
        int i13 = a.f15072a[ordinal()];
        if (i13 == 1) {
            return false;
        }
        if (i13 != 2) {
            return (z11 && i11 < 28) || i12 > 4 || i11 <= 25;
        }
        return true;
    }
}
