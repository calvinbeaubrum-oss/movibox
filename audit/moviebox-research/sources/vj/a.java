package vj;

import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.common.api.Api;
import okio.Utf8;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class a extends b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final byte[] f78919l = {Ascii.CR, 10};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final byte[] f78920m = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final byte[] f78921n = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final byte[] f78922o = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Ascii.VT, Ascii.FF, Ascii.CR, Ascii.SO, Ascii.SI, Ascii.DLE, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, -1, -1, -1, -1, Utf8.REPLACEMENT_BYTE, -1, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final byte[] f78923g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final byte[] f78924h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final byte[] f78925i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f78926j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f78927k;

    public a(int i11) {
        this(i11, f78919l);
    }

    public a(int i11, byte[] bArr) {
        this(i11, bArr, false);
    }

    public a(int i11, byte[] bArr, boolean z11) {
        super(3, 4, i11, bArr == null ? 0 : bArr.length);
        this.f78924h = f78922o;
        if (bArr == null) {
            this.f78927k = 4;
            this.f78925i = null;
        } else {
            if (b(bArr)) {
                throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + c.b(bArr) + "]");
            }
            if (i11 > 0) {
                this.f78927k = bArr.length + 4;
                byte[] bArr2 = new byte[bArr.length];
                this.f78925i = bArr2;
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            } else {
                this.f78927k = 4;
                this.f78925i = null;
            }
        }
        this.f78926j = this.f78927k - 1;
        this.f78923g = z11 ? f78921n : f78920m;
    }

    public a(boolean z11) {
        this(76, f78919l, z11);
    }

    public static byte[] k(byte[] bArr, boolean z11) {
        return l(bArr, z11, false);
    }

    public static byte[] l(byte[] bArr, boolean z11, boolean z12) {
        return m(bArr, z11, z12, Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    public static byte[] m(byte[] bArr, boolean z11, boolean z12, int i11) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        a aVar = z11 ? new a(z12) : new a(0, f78919l, z12);
        long jG = aVar.g(bArr);
        if (jG <= i11) {
            return aVar.d(bArr);
        }
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + jG + ") than the specified maximum size of " + i11);
    }

    @Override // vj.b
    public void c(byte[] bArr, int i11, int i12, b.a aVar) {
        if (aVar.f78939f) {
            return;
        }
        if (i12 >= 0) {
            int i13 = 0;
            while (i13 < i12) {
                byte[] bArrE = e(this.f78927k, aVar);
                int i14 = (aVar.f78941h + 1) % 3;
                aVar.f78941h = i14;
                int i15 = i11 + 1;
                int i16 = bArr[i11];
                if (i16 < 0) {
                    i16 += 256;
                }
                int i17 = (aVar.f78934a << 8) + i16;
                aVar.f78934a = i17;
                if (i14 == 0) {
                    int i18 = aVar.f78937d;
                    byte[] bArr2 = this.f78923g;
                    bArrE[i18] = bArr2[(i17 >> 18) & 63];
                    bArrE[i18 + 1] = bArr2[(i17 >> 12) & 63];
                    int i19 = i18 + 3;
                    bArrE[i18 + 2] = bArr2[(i17 >> 6) & 63];
                    int i21 = i18 + 4;
                    aVar.f78937d = i21;
                    bArrE[i19] = bArr2[i17 & 63];
                    int i22 = aVar.f78940g + 4;
                    aVar.f78940g = i22;
                    int i23 = this.f78932e;
                    if (i23 > 0 && i23 <= i22) {
                        byte[] bArr3 = this.f78925i;
                        System.arraycopy(bArr3, 0, bArrE, i21, bArr3.length);
                        aVar.f78937d += this.f78925i.length;
                        aVar.f78940g = 0;
                    }
                }
                i13++;
                i11 = i15;
            }
            return;
        }
        aVar.f78939f = true;
        if (aVar.f78941h == 0 && this.f78932e == 0) {
            return;
        }
        byte[] bArrE2 = e(this.f78927k, aVar);
        int i24 = aVar.f78937d;
        int i25 = aVar.f78941h;
        if (i25 != 0) {
            if (i25 == 1) {
                byte[] bArr4 = this.f78923g;
                int i26 = aVar.f78934a;
                bArrE2[i24] = bArr4[(i26 >> 2) & 63];
                int i27 = i24 + 2;
                aVar.f78937d = i27;
                bArrE2[i24 + 1] = bArr4[(i26 << 4) & 63];
                if (bArr4 == f78920m) {
                    byte b11 = this.f78929b;
                    bArrE2[i27] = b11;
                    aVar.f78937d = i24 + 4;
                    bArrE2[i24 + 3] = b11;
                }
            } else {
                if (i25 != 2) {
                    throw new IllegalStateException("Impossible modulus " + aVar.f78941h);
                }
                byte[] bArr5 = this.f78923g;
                int i28 = aVar.f78934a;
                bArrE2[i24] = bArr5[(i28 >> 10) & 63];
                bArrE2[i24 + 1] = bArr5[(i28 >> 4) & 63];
                int i29 = i24 + 3;
                aVar.f78937d = i29;
                bArrE2[i24 + 2] = bArr5[(i28 << 2) & 63];
                if (bArr5 == f78920m) {
                    aVar.f78937d = i24 + 4;
                    bArrE2[i29] = this.f78929b;
                }
            }
        }
        int i31 = aVar.f78940g;
        int i32 = aVar.f78937d;
        int i33 = i31 + (i32 - i24);
        aVar.f78940g = i33;
        if (this.f78932e <= 0 || i33 <= 0) {
            return;
        }
        byte[] bArr6 = this.f78925i;
        System.arraycopy(bArr6, 0, bArrE2, i32, bArr6.length);
        aVar.f78937d += this.f78925i.length;
    }

    @Override // vj.b
    public boolean h(byte b11) {
        if (b11 >= 0) {
            byte[] bArr = this.f78924h;
            if (b11 < bArr.length && bArr[b11] != -1) {
                return true;
            }
        }
        return false;
    }
}
