package z20;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f81751a = new byte[1024];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f81752b = new int[1024];

    public static void a(byte[] bArr, int i11, int i12) {
        int i13 = 0;
        while (i13 < i12) {
            int iMin = Math.min(i13 + 1024, i12) - i13;
            System.arraycopy(f81751a, 0, bArr, i11 + i13, iMin);
            i13 += iMin;
        }
    }

    public static void b(int[] iArr, int i11, int i12) {
        int i13 = 0;
        while (i13 < i12) {
            int iMin = Math.min(i13 + 1024, i12) - i13;
            System.arraycopy(f81752b, 0, iArr, i11 + i13, iMin);
            i13 += iMin;
        }
    }
}
