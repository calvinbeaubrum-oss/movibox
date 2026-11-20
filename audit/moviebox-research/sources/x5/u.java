package x5;

import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f80238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f80239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f80240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f80241d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f80242e;

    public u(int i11, int i12) {
        this.f80238a = i11;
        byte[] bArr = new byte[i12 + 3];
        this.f80241d = bArr;
        bArr[2] = 1;
    }

    public void a(byte[] bArr, int i11, int i12) {
        if (this.f80239b) {
            int i13 = i12 - i11;
            byte[] bArr2 = this.f80241d;
            int length = bArr2.length;
            int i14 = this.f80242e;
            if (length < i14 + i13) {
                this.f80241d = Arrays.copyOf(bArr2, (i14 + i13) * 2);
            }
            System.arraycopy(bArr, i11, this.f80241d, this.f80242e, i13);
            this.f80242e += i13;
        }
    }

    public boolean b(int i11) {
        if (!this.f80239b) {
            return false;
        }
        this.f80242e -= i11;
        this.f80239b = false;
        this.f80240c = true;
        return true;
    }

    public boolean c() {
        return this.f80240c;
    }

    public void d() {
        this.f80239b = false;
        this.f80240c = false;
    }

    public void e(int i11) {
        z3.a.g(!this.f80239b);
        boolean z11 = i11 == this.f80238a;
        this.f80239b = z11;
        if (z11) {
            this.f80242e = 3;
            this.f80240c = false;
        }
    }
}
