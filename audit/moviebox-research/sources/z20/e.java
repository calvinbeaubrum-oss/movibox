package z20;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f81737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f81738b;

    public static void a(e eVar, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            int[] iArr = eVar.f81738b;
            byte[] bArr = eVar.f81737a;
            int i13 = i12 * 4;
            iArr[i12] = ((bArr[i13 + 3] & 255) << 24) | (bArr[i13] & 255) | ((bArr[i13 + 1] & 255) << 8) | ((bArr[i13 + 2] & 255) << 16);
        }
    }

    public static void b(e eVar, byte[] bArr, int[] iArr) {
        eVar.f81737a = bArr;
        eVar.f81738b = iArr;
    }
}
