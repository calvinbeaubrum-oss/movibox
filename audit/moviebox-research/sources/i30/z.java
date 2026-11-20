package i30;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f67117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f67118b;

    public z(byte[] bArr, int i11) {
        this.f67117a = bArr;
        this.f67118b = i11;
    }

    public static void d(z zVar, d dVar) {
        if (zVar == null) {
            dVar.g(0);
            return;
        }
        byte[] bArr = zVar.f67117a;
        int i11 = zVar.f67118b;
        dVar.h(bArr, i11, (bArr[i11] * 2) + 1);
    }

    public int a() {
        return this.f67117a[this.f67118b];
    }

    public int b(int i11) {
        return this.f67117a[this.f67118b + (i11 * 2) + 1];
    }

    public int c(int i11) {
        return this.f67117a[this.f67118b + (i11 * 2) + 2];
    }

    public String toString() {
        int iA = a();
        StringBuilder sb2 = new StringBuilder(iA * 2);
        for (int i11 = 0; i11 < iA; i11++) {
            int iB = b(i11);
            if (iB == 0) {
                sb2.append('[');
            } else if (iB == 1) {
                sb2.append('.');
            } else if (iB == 2) {
                sb2.append('*');
            } else {
                if (iB != 3) {
                    throw new AssertionError();
                }
                sb2.append(c(i11));
                sb2.append(';');
            }
        }
        return sb2.toString();
    }
}
