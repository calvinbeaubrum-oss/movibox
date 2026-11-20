package dh;

import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f63382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f63383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f63384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f63385d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f63386e;

    public u(int i11, int i12) {
        this.f63382a = i11;
        byte[] bArr = new byte[i12 + 3];
        this.f63385d = bArr;
        bArr[2] = 1;
    }

    public void a(byte[] bArr, int i11, int i12) {
        if (this.f63383b) {
            int i13 = i12 - i11;
            byte[] bArr2 = this.f63385d;
            int length = bArr2.length;
            int i14 = this.f63386e;
            if (length < i14 + i13) {
                this.f63385d = Arrays.copyOf(bArr2, (i14 + i13) * 2);
            }
            System.arraycopy(bArr, i11, this.f63385d, this.f63386e, i13);
            this.f63386e += i13;
        }
    }

    public boolean b(int i11) {
        if (!this.f63383b) {
            return false;
        }
        this.f63386e -= i11;
        this.f63383b = false;
        this.f63384c = true;
        return true;
    }

    public boolean c() {
        return this.f63384c;
    }

    public void d() {
        this.f63383b = false;
        this.f63384c = false;
    }

    public void e(int i11) {
        com.google.android.exoplayer2.util.a.g(!this.f63383b);
        boolean z11 = i11 == this.f63382a;
        this.f63383b = z11;
        if (z11) {
            this.f63386e = 3;
            this.f63384c = false;
        }
    }
}
