package com.google.zxing;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f41523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f41524b;

    public e(int i11, int i12) {
        this.f41523a = i11;
        this.f41524b = i12;
    }

    public final int a() {
        return this.f41524b;
    }

    public abstract byte[] b();

    public abstract byte[] c(int i11, byte[] bArr);

    public final int d() {
        return this.f41523a;
    }

    public e e() {
        return new d(this);
    }

    public boolean f() {
        return false;
    }

    public e g() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public final String toString() {
        char c11;
        int i11 = this.f41523a;
        byte[] bArrC = new byte[i11];
        StringBuilder sb2 = new StringBuilder(this.f41524b * (i11 + 1));
        for (int i12 = 0; i12 < this.f41524b; i12++) {
            bArrC = c(i12, bArrC);
            for (int i13 = 0; i13 < this.f41523a; i13++) {
                int i14 = bArrC[i13] & 255;
                if (i14 < 64) {
                    c11 = '#';
                } else if (i14 < 128) {
                    c11 = '+';
                } else {
                    c11 = i14 < 192 ? '.' : ' ';
                }
                sb2.append(c11);
            }
            sb2.append('\n');
        }
        return sb2.toString();
    }
}
