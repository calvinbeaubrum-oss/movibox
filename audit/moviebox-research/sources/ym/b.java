package ym;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f81546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f81547b = 0;

    public b(int i11) {
        this.f81546a = new byte[i11];
    }

    public void a(boolean z11, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = this.f81547b;
            this.f81547b = i13 + 1;
            c(i13, z11);
        }
    }

    public byte[] b(int i11) {
        int length = this.f81546a.length * i11;
        byte[] bArr = new byte[length];
        for (int i12 = 0; i12 < length; i12++) {
            bArr[i12] = this.f81546a[i12 / i11];
        }
        return bArr;
    }

    public final void c(int i11, boolean z11) {
        this.f81546a[i11] = z11 ? (byte) 1 : (byte) 0;
    }
}
