package k7;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f68427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f68428b;

    public a() {
        this.f68427a = new byte[64];
    }

    public a(int i11) {
        this.f68427a = new byte[i11];
    }

    public final void a(int i11) {
        byte[] bArr = this.f68427a;
        int length = bArr.length * 2;
        int i12 = this.f68428b;
        int i13 = i11 + i12;
        if (length <= i13) {
            length = i13;
        }
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, i12);
        this.f68427a = bArr2;
    }

    public a b(int i11, int i12) {
        int i13 = this.f68428b;
        if (i13 + 2 > this.f68427a.length) {
            a(2);
        }
        byte[] bArr = this.f68427a;
        bArr[i13] = (byte) i11;
        bArr[i13 + 1] = (byte) i12;
        this.f68428b = i13 + 2;
        return this;
    }

    public a c(int i11, int i12) {
        int i13 = this.f68428b;
        if (i13 + 3 > this.f68427a.length) {
            a(3);
        }
        byte[] bArr = this.f68427a;
        bArr[i13] = (byte) i11;
        bArr[i13 + 1] = (byte) (i12 >>> 8);
        bArr[i13 + 2] = (byte) i12;
        this.f68428b = i13 + 3;
        return this;
    }

    public a d(int i11) {
        int i12 = this.f68428b;
        int i13 = i12 + 1;
        if (i13 > this.f68427a.length) {
            a(1);
        }
        this.f68427a[i12] = (byte) i11;
        this.f68428b = i13;
        return this;
    }

    public a e(byte[] bArr, int i11, int i12) {
        if (this.f68428b + i12 > this.f68427a.length) {
            a(i12);
        }
        if (bArr != null) {
            System.arraycopy(bArr, i11, this.f68427a, this.f68428b, i12);
        }
        this.f68428b += i12;
        return this;
    }

    public a f(int i11) {
        int i12 = this.f68428b;
        if (i12 + 4 > this.f68427a.length) {
            a(4);
        }
        byte[] bArr = this.f68427a;
        bArr[i12] = (byte) (i11 >>> 24);
        bArr[i12 + 1] = (byte) (i11 >>> 16);
        bArr[i12 + 2] = (byte) (i11 >>> 8);
        bArr[i12 + 3] = (byte) i11;
        this.f68428b = i12 + 4;
        return this;
    }

    public a g(int i11) {
        int i12 = this.f68428b;
        if (i12 + 2 > this.f68427a.length) {
            a(2);
        }
        byte[] bArr = this.f68427a;
        bArr[i12] = (byte) (i11 >>> 8);
        bArr[i12 + 1] = (byte) i11;
        this.f68428b = i12 + 2;
        return this;
    }

    public a h(String str) {
        int length = str.length();
        int i11 = this.f68428b;
        if (i11 + 2 + length > this.f68427a.length) {
            a(length + 2);
        }
        byte[] bArr = this.f68427a;
        int i12 = i11 + 1;
        bArr[i11] = (byte) (length >>> 8);
        int i13 = i11 + 2;
        bArr[i12] = (byte) length;
        int i14 = 0;
        while (i14 < length) {
            char cCharAt = str.charAt(i14);
            if ((cCharAt < 1 || cCharAt > 127) && (cCharAt < 19968 || cCharAt > 40959)) {
                throw new UnsupportedOperationException();
            }
            bArr[i13] = (byte) cCharAt;
            i14++;
            i13++;
        }
        this.f68428b = i13;
        return this;
    }
}
