package bn;

import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[][] f14281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14283c;

    public b(int i11, int i12) {
        this.f14281a = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i12, i11);
        this.f14282b = i11;
        this.f14283c = i12;
    }

    public void a(byte b11) {
        for (byte[] bArr : this.f14281a) {
            Arrays.fill(bArr, b11);
        }
    }

    public byte b(int i11, int i12) {
        return this.f14281a[i12][i11];
    }

    public byte[][] c() {
        return this.f14281a;
    }

    public int d() {
        return this.f14283c;
    }

    public int e() {
        return this.f14282b;
    }

    public void f(int i11, int i12, int i13) {
        this.f14281a[i12][i11] = (byte) i13;
    }

    public void g(int i11, int i12, boolean z11) {
        this.f14281a[i12][i11] = z11 ? (byte) 1 : (byte) 0;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder((this.f14282b * 2 * this.f14283c) + 2);
        for (int i11 = 0; i11 < this.f14283c; i11++) {
            byte[] bArr = this.f14281a[i11];
            for (int i12 = 0; i12 < this.f14282b; i12++) {
                byte b11 = bArr[i12];
                if (b11 == 0) {
                    sb2.append(" 0");
                } else if (b11 != 1) {
                    sb2.append("  ");
                } else {
                    sb2.append(" 1");
                }
            }
            sb2.append('\n');
        }
        return sb2.toString();
    }
}
