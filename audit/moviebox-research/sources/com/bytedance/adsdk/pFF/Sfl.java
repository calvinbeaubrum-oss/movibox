package com.bytedance.adsdk.pFF;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public enum Sfl {
    AUTOMATIC,
    HARDWARE,
    SOFTWARE;

    /* JADX INFO: renamed from: com.bytedance.adsdk.pFF.Sfl$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        static final /* synthetic */ int[] f26131sc;

        static {
            int[] iArr = new int[Sfl.values().length];
            f26131sc = iArr;
            try {
                iArr[Sfl.HARDWARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26131sc[Sfl.SOFTWARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f26131sc[Sfl.AUTOMATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public boolean sc(int i11, boolean z11, int i12) {
        int i13 = AnonymousClass1.f26131sc[ordinal()];
        if (i13 == 1) {
            return false;
        }
        if (i13 != 2) {
            return (z11 && i11 < 28) || i12 > 4 || i11 <= 25;
        }
        return true;
    }
}
