package k7;

import com.alibaba.fastjson.asm.TypeCollector;
import com.applovin.exoplayer2.common.base.Ascii;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okio.Utf8;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f68429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f68430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String[] f68431c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f68432d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f68433e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f68434f;

    /* JADX WARN: Code duplicated, block: B:21:0x005d  */
    public b(InputStream inputStream, boolean z11) throws IOException {
        int i11;
        this.f68434f = z11;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i12 = inputStream.read(bArr);
            i11 = 0;
            if (i12 == -1) {
                break;
            } else if (i12 > 0) {
                byteArrayOutputStream.write(bArr, 0, i12);
            }
        }
        inputStream.close();
        this.f68429a = byteArrayOutputStream.toByteArray();
        int[] iArr = new int[g(8)];
        this.f68430b = iArr;
        int length = iArr.length;
        this.f68431c = new String[length];
        int i13 = 10;
        int i14 = 1;
        while (i14 < length) {
            int i15 = i13 + 1;
            this.f68430b[i14] = i15;
            byte b11 = this.f68429a[i13];
            int iG = 3;
            if (b11 == 1) {
                iG = 3 + g(i15);
                if (iG > i11) {
                    i11 = iG;
                }
            } else if (b11 == 15) {
                iG = 4;
            } else if (b11 != 18 && b11 != 3 && b11 != 4) {
                if (b11 != 5 && b11 != 6) {
                    switch (b11) {
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                            iG = 5;
                            break;
                    }
                } else {
                    i14++;
                    iG = 9;
                }
            } else {
                iG = 5;
            }
            i13 += iG;
            i14++;
        }
        this.f68432d = i11;
        this.f68433e = i13;
    }

    public void a(TypeCollector typeCollector) {
        int i11;
        char[] cArr = new char[this.f68432d];
        if (!this.f68434f) {
            i11 = 0;
            break;
        }
        int iB = b();
        int iG = g(iB);
        while (true) {
            if (iG <= 0) {
                i11 = 0;
                break;
            } else if ("RuntimeVisibleAnnotations".equals(f(iB + 2, cArr))) {
                i11 = iB + 8;
                break;
            } else {
                iB += c(iB + 4) + 6;
                iG--;
            }
        }
        int i12 = this.f68433e;
        int iG2 = g(i12 + 6);
        int i13 = i12 + 8;
        for (int i14 = 0; i14 < iG2; i14++) {
            i13 += 2;
        }
        int iC = i13 + 2;
        int iC2 = iC;
        for (int iG3 = g(i13); iG3 > 0; iG3--) {
            iC2 += 8;
            for (int iG4 = g(iC2 + 6); iG4 > 0; iG4--) {
                iC2 += c(iC2 + 2) + 6;
            }
        }
        int iC3 = iC2 + 2;
        for (int iG5 = g(iC2); iG5 > 0; iG5--) {
            iC3 += 8;
            for (int iG6 = g(iC3 + 6); iG6 > 0; iG6--) {
                iC3 += c(iC3 + 2) + 6;
            }
        }
        int iC4 = iC3 + 2;
        for (int iG7 = g(iC3); iG7 > 0; iG7--) {
            iC4 += c(iC4 + 2) + 6;
        }
        if (i11 != 0) {
            int i15 = i11 + 2;
            for (int iG8 = g(i11); iG8 > 0; iG8--) {
                typeCollector.d(f(i15, cArr));
            }
        }
        for (int iG9 = g(i13); iG9 > 0; iG9--) {
            iC += 8;
            for (int iG10 = g(iC + 6); iG10 > 0; iG10--) {
                iC += c(iC + 2) + 6;
            }
        }
        int iD = iC + 2;
        for (int iG11 = g(iC); iG11 > 0; iG11--) {
            iD = d(typeCollector, cArr, iD);
        }
    }

    public final int b() {
        int i11 = this.f68433e;
        int iG = i11 + 8 + (g(i11 + 6) * 2);
        for (int iG2 = g(iG); iG2 > 0; iG2--) {
            for (int iG3 = g(iG + 8); iG3 > 0; iG3--) {
                iG += c(iG + 12) + 6;
            }
            iG += 8;
        }
        int iC = iG + 2;
        for (int iG4 = g(iC); iG4 > 0; iG4--) {
            for (int iG5 = g(iC + 8); iG5 > 0; iG5--) {
                iC += c(iC + 12) + 6;
            }
            iC += 8;
        }
        return iC + 2;
    }

    public final int c(int i11) {
        byte[] bArr = this.f68429a;
        return (bArr[i11 + 3] & 255) | ((bArr[i11] & 255) << 24) | ((bArr[i11 + 1] & 255) << 16) | ((bArr[i11 + 2] & 255) << 8);
    }

    public final int d(TypeCollector typeCollector, char[] cArr, int i11) {
        int iG = g(i11);
        String strF = f(i11 + 2, cArr);
        String strF2 = f(i11 + 4, cArr);
        int i12 = i11 + 8;
        int i13 = 0;
        int i14 = 0;
        for (int iG2 = g(i11 + 6); iG2 > 0; iG2--) {
            String strF3 = f(i12, cArr);
            int iC = c(i12 + 2);
            int i15 = i12 + 6;
            if (strF3.equals("Code")) {
                i14 = i15;
            }
            i12 = i15 + iC;
        }
        g gVarE = typeCollector.e(iG, strF, strF2);
        if (gVarE != null && i14 != 0) {
            int iC2 = i14 + 8 + c(i14 + 4);
            int i16 = iC2 + 2;
            for (int iG3 = g(iC2); iG3 > 0; iG3--) {
                i16 += 8;
            }
            int iC3 = i16 + 2;
            int i17 = 0;
            for (int iG4 = g(i16); iG4 > 0; iG4--) {
                String strF4 = f(iC3, cArr);
                if (strF4.equals("LocalVariableTable")) {
                    i13 = iC3 + 6;
                } else if (strF4.equals("LocalVariableTypeTable")) {
                    i17 = iC3 + 6;
                }
                iC3 += c(iC3 + 2) + 6;
            }
            if (i13 != 0) {
                if (i17 != 0) {
                    int iG5 = g(i17) * 3;
                    int i18 = i17 + 2;
                    int[] iArr = new int[iG5];
                    while (iG5 > 0) {
                        iArr[iG5 - 1] = i18 + 6;
                        iArr[iG5 - 2] = g(i18 + 8);
                        iG5 -= 3;
                        iArr[iG5] = g(i18);
                        i18 += 10;
                    }
                }
                int i19 = i13 + 2;
                for (int iG6 = g(i13); iG6 > 0; iG6--) {
                    gVarE.b(f(i19 + 4, cArr), g(i19 + 8));
                    i19 += 10;
                }
            }
        }
        return i12;
    }

    public final String e(int i11, int i12, char[] cArr) {
        int i13;
        int i14 = i12 + i11;
        byte[] bArr = this.f68429a;
        int i15 = 0;
        char c11 = 0;
        char c12 = 0;
        while (i11 < i14) {
            int i16 = i11 + 1;
            byte b11 = bArr[i11];
            if (c11 == 0) {
                int i17 = b11 & 255;
                if (i17 < 128) {
                    cArr[i15] = (char) i17;
                    i15++;
                } else if (i17 >= 224 || i17 <= 191) {
                    c12 = (char) (b11 & Ascii.SI);
                    c11 = 2;
                } else {
                    i13 = b11 & Ascii.US;
                    c12 = (char) i13;
                    c11 = 1;
                }
            } else if (c11 == 1) {
                cArr[i15] = (char) ((b11 & Utf8.REPLACEMENT_BYTE) | (c12 << 6));
                i15++;
                c11 = 0;
            } else if (c11 == 2) {
                i13 = (b11 & Utf8.REPLACEMENT_BYTE) | (c12 << 6);
                c12 = (char) i13;
                c11 = 1;
            }
            i11 = i16;
        }
        return new String(cArr, 0, i15);
    }

    public final String f(int i11, char[] cArr) {
        int iG = g(i11);
        String[] strArr = this.f68431c;
        String str = strArr[iG];
        if (str != null) {
            return str;
        }
        int i12 = this.f68430b[iG];
        String strE = e(i12 + 2, g(i12), cArr);
        strArr[iG] = strE;
        return strE;
    }

    public final int g(int i11) {
        byte[] bArr = this.f68429a;
        return (bArr[i11 + 1] & 255) | ((bArr[i11] & 255) << 8);
    }
}
