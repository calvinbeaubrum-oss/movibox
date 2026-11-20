package nm;

import com.google.android.gms.common.api.Api;
import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class j {
    public static int a(CharSequence charSequence, int i11) {
        int length = charSequence.length();
        int i12 = i11;
        while (i12 < length && f(charSequence.charAt(i12))) {
            i12++;
        }
        return i12 - i11;
    }

    public static String b(String str, SymbolShapeHint symbolShapeHint, com.google.zxing.c cVar, com.google.zxing.c cVar2, boolean z11) {
        c cVar3 = new c();
        int iE = 0;
        g[] gVarArr = {new a(), cVar3, new l(), new m(), new f(), new b()};
        h hVar = new h(str);
        hVar.n(symbolShapeHint);
        hVar.l(cVar, cVar2);
        if (str.startsWith("[)>\u001e05\u001d") && str.endsWith("\u001e\u0004")) {
            hVar.r((char) 236);
            hVar.m(2);
            hVar.f72074f += 7;
        } else if (str.startsWith("[)>\u001e06\u001d") && str.endsWith("\u001e\u0004")) {
            hVar.r((char) 237);
            hVar.m(2);
            hVar.f72074f += 7;
        }
        if (z11) {
            cVar3.d(hVar);
            iE = hVar.e();
            hVar.j();
        }
        while (hVar.i()) {
            gVarArr[iE].a(hVar);
            if (hVar.e() >= 0) {
                iE = hVar.e();
                hVar.j();
            }
        }
        int iA = hVar.a();
        hVar.p();
        int iA2 = hVar.g().a();
        if (iA < iA2 && iE != 0 && iE != 5 && iE != 4) {
            hVar.r((char) 254);
        }
        StringBuilder sbB = hVar.b();
        if (sbB.length() < iA2) {
            sbB.append((char) 129);
        }
        while (sbB.length() < iA2) {
            sbB.append(r(sbB.length() + 1));
        }
        return hVar.b().toString();
    }

    public static int c(float[] fArr, int[] iArr, int i11, byte[] bArr) {
        for (int i12 = 0; i12 < 6; i12++) {
            int iCeil = (int) Math.ceil(fArr[i12]);
            iArr[i12] = iCeil;
            if (i11 > iCeil) {
                Arrays.fill(bArr, (byte) 0);
                i11 = iCeil;
            }
            if (i11 == iCeil) {
                bArr[i12] = (byte) (bArr[i12] + 1);
            }
        }
        return i11;
    }

    public static int d(byte[] bArr) {
        int i11 = 0;
        for (int i12 = 0; i12 < 6; i12++) {
            i11 += bArr[i12];
        }
        return i11;
    }

    public static void e(char c11) {
        String hexString = Integer.toHexString(c11);
        throw new IllegalArgumentException("Illegal character: " + c11 + " (0x" + ("0000".substring(0, 4 - hexString.length()) + hexString) + ')');
    }

    public static boolean f(char c11) {
        return c11 >= '0' && c11 <= '9';
    }

    public static boolean g(char c11) {
        return c11 >= 128 && c11 <= 255;
    }

    public static boolean h(char c11) {
        return c11 == ' ' || (c11 >= '0' && c11 <= '9') || (c11 >= 'A' && c11 <= 'Z');
    }

    public static boolean i(char c11) {
        return c11 >= ' ' && c11 <= '^';
    }

    public static boolean j(char c11) {
        return c11 == ' ' || (c11 >= '0' && c11 <= '9') || (c11 >= 'a' && c11 <= 'z');
    }

    public static boolean k(char c11) {
        return m(c11) || c11 == ' ' || (c11 >= '0' && c11 <= '9') || (c11 >= 'A' && c11 <= 'Z');
    }

    public static boolean l(char c11) {
        return false;
    }

    public static boolean m(char c11) {
        return c11 == '\r' || c11 == '*' || c11 == '>';
    }

    public static int n(CharSequence charSequence, int i11, int i12) {
        int iO = o(charSequence, i11, i12);
        if (i12 == 3 && iO == 3) {
            int iMin = Math.min(i11 + 3, charSequence.length());
            while (i11 < iMin) {
                if (!k(charSequence.charAt(i11))) {
                    return 0;
                }
                i11++;
            }
        } else if (i12 == 4 && iO == 4) {
            int iMin2 = Math.min(i11 + 4, charSequence.length());
            while (i11 < iMin2) {
                if (!i(charSequence.charAt(i11))) {
                    return 0;
                }
                i11++;
            }
        }
        return iO;
    }

    public static int o(CharSequence charSequence, int i11, int i12) {
        float[] fArr;
        char c11;
        if (i11 >= charSequence.length()) {
            return i12;
        }
        if (i12 == 0) {
            fArr = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.25f};
        } else {
            fArr = new float[]{1.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.25f};
            fArr[i12] = 0.0f;
        }
        byte[] bArr = new byte[6];
        int[] iArr = new int[6];
        int i13 = 0;
        while (true) {
            int i14 = i11 + i13;
            if (i14 == charSequence.length()) {
                Arrays.fill(bArr, (byte) 0);
                Arrays.fill(iArr, 0);
                int iC = c(fArr, iArr, Api.BaseClientBuilder.API_PRIORITY_OTHER, bArr);
                int iD = d(bArr);
                if (iArr[0] == iC) {
                    return 0;
                }
                if (iD == 1) {
                    if (bArr[5] > 0) {
                        return 5;
                    }
                    if (bArr[4] > 0) {
                        return 4;
                    }
                    if (bArr[2] > 0) {
                        return 2;
                    }
                    if (bArr[3] > 0) {
                        return 3;
                    }
                }
                return 1;
            }
            char cCharAt = charSequence.charAt(i14);
            i13++;
            if (f(cCharAt)) {
                fArr[0] = fArr[0] + 0.5f;
            } else if (g(cCharAt)) {
                float fCeil = (float) Math.ceil(fArr[0]);
                fArr[0] = fCeil;
                fArr[0] = fCeil + 2.0f;
            } else {
                float fCeil2 = (float) Math.ceil(fArr[0]);
                fArr[0] = fCeil2;
                fArr[0] = fCeil2 + 1.0f;
            }
            if (h(cCharAt)) {
                fArr[1] = fArr[1] + 0.6666667f;
            } else if (g(cCharAt)) {
                fArr[1] = fArr[1] + 2.6666667f;
            } else {
                fArr[1] = fArr[1] + 1.3333334f;
            }
            if (j(cCharAt)) {
                fArr[2] = fArr[2] + 0.6666667f;
            } else if (g(cCharAt)) {
                fArr[2] = fArr[2] + 2.6666667f;
            } else {
                fArr[2] = fArr[2] + 1.3333334f;
            }
            if (k(cCharAt)) {
                fArr[3] = fArr[3] + 0.6666667f;
            } else if (g(cCharAt)) {
                fArr[3] = fArr[3] + 4.3333335f;
            } else {
                fArr[3] = fArr[3] + 3.3333333f;
            }
            if (i(cCharAt)) {
                fArr[4] = fArr[4] + 0.75f;
            } else if (g(cCharAt)) {
                fArr[4] = fArr[4] + 4.25f;
            } else {
                fArr[4] = fArr[4] + 3.25f;
            }
            if (l(cCharAt)) {
                c11 = 5;
                fArr[5] = fArr[5] + 4.0f;
            } else {
                c11 = 5;
                fArr[5] = fArr[5] + 1.0f;
            }
            if (i13 >= 4) {
                Arrays.fill(bArr, (byte) 0);
                Arrays.fill(iArr, 0);
                c(fArr, iArr, Api.BaseClientBuilder.API_PRIORITY_OTHER, bArr);
                if (iArr[0] < q(iArr[c11], iArr[1], iArr[2], iArr[3], iArr[4])) {
                    return 0;
                }
                int i15 = iArr[c11];
                if (i15 < iArr[0] || i15 + 1 < p(iArr[1], iArr[2], iArr[3], iArr[4])) {
                    return 5;
                }
                if (iArr[4] + 1 < q(iArr[5], iArr[1], iArr[2], iArr[3], iArr[0])) {
                    return 4;
                }
                if (iArr[2] + 1 < q(iArr[5], iArr[1], iArr[4], iArr[3], iArr[0])) {
                    return 2;
                }
                if (iArr[3] + 1 < q(iArr[5], iArr[1], iArr[4], iArr[2], iArr[0])) {
                    return 3;
                }
                if (iArr[1] + 1 >= p(iArr[0], iArr[5], iArr[4], iArr[2])) {
                    continue;
                } else {
                    int i16 = iArr[1];
                    int i17 = iArr[3];
                    if (i16 < i17) {
                        return 1;
                    }
                    if (i16 == i17) {
                        for (int i18 = i11 + i13 + 1; i18 < charSequence.length(); i18++) {
                            char cCharAt2 = charSequence.charAt(i18);
                            if (m(cCharAt2)) {
                                return 3;
                            }
                            if (!k(cCharAt2)) {
                                break;
                            }
                        }
                        return 1;
                    }
                }
            }
        }
    }

    public static int p(int i11, int i12, int i13, int i14) {
        return Math.min(i11, Math.min(i12, Math.min(i13, i14)));
    }

    public static int q(int i11, int i12, int i13, int i14, int i15) {
        return Math.min(p(i11, i12, i13, i14), i15);
    }

    public static char r(int i11) {
        int i12 = (i11 * 149) % 253;
        int i13 = i12 + TsExtractor.TS_STREAM_TYPE_HDMV_DTS;
        if (i13 > 254) {
            i13 = i12 - 124;
        }
        return (char) i13;
    }
}
