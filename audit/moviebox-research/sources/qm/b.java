package qm;

import com.google.zxing.BarcodeFormat;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class b extends r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char[] f74809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final char[] f74810c = {'T', 'N', '*', 'E'};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final char[] f74811d = {'/', ':', '+', '.'};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final char f74812e;

    static {
        char[] cArr = {'A', 'B', 'C', 'D'};
        f74809b = cArr;
        f74812e = cArr[0];
    }

    @Override // qm.r
    public boolean[] d(String str) {
        int i11;
        if (str.length() < 2) {
            StringBuilder sb2 = new StringBuilder();
            char c11 = f74812e;
            sb2.append(c11);
            sb2.append(str);
            sb2.append(c11);
            str = sb2.toString();
        } else {
            char upperCase = Character.toUpperCase(str.charAt(0));
            char upperCase2 = Character.toUpperCase(str.charAt(str.length() - 1));
            char[] cArr = f74809b;
            boolean zH = a.h(cArr, upperCase);
            boolean zH2 = a.h(cArr, upperCase2);
            char[] cArr2 = f74810c;
            boolean zH3 = a.h(cArr2, upperCase);
            boolean zH4 = a.h(cArr2, upperCase2);
            if (zH) {
                if (!zH2) {
                    throw new IllegalArgumentException("Invalid start/end guards: " + str);
                }
            } else if (!zH3) {
                if (zH2 || zH4) {
                    throw new IllegalArgumentException("Invalid start/end guards: " + str);
                }
                StringBuilder sb3 = new StringBuilder();
                char c12 = f74812e;
                sb3.append(c12);
                sb3.append(str);
                sb3.append(c12);
                str = sb3.toString();
            } else if (!zH4) {
                throw new IllegalArgumentException("Invalid start/end guards: " + str);
            }
        }
        int i12 = 20;
        for (int i13 = 1; i13 < str.length() - 1; i13++) {
            if (Character.isDigit(str.charAt(i13)) || str.charAt(i13) == '-' || str.charAt(i13) == '$') {
                i12 += 9;
            } else {
                if (!a.h(f74811d, str.charAt(i13))) {
                    throw new IllegalArgumentException("Cannot encode : '" + str.charAt(i13) + '\'');
                }
                i12 += 10;
            }
        }
        boolean[] zArr = new boolean[i12 + (str.length() - 1)];
        int i14 = 0;
        for (int i15 = 0; i15 < str.length(); i15++) {
            char upperCase3 = Character.toUpperCase(str.charAt(i15));
            if (i15 == 0 || i15 == str.length() - 1) {
                if (upperCase3 == '*') {
                    upperCase3 = 'C';
                } else if (upperCase3 == 'E') {
                    upperCase3 = 'D';
                } else if (upperCase3 == 'N') {
                    upperCase3 = 'B';
                } else if (upperCase3 == 'T') {
                    upperCase3 = 'A';
                }
            }
            int i16 = 0;
            while (true) {
                char[] cArr3 = a.f74803d;
                if (i16 >= cArr3.length) {
                    i11 = 0;
                    break;
                }
                if (upperCase3 == cArr3[i16]) {
                    i11 = a.f74804e[i16];
                    break;
                }
                i16++;
            }
            int i17 = 0;
            boolean z11 = true;
            while (true) {
                int i18 = 0;
                while (i17 < 7) {
                    zArr[i14] = z11;
                    i14++;
                    if (((i11 >> (6 - i17)) & 1) == 0 || i18 == 1) {
                        z11 = !z11;
                        i17++;
                    } else {
                        i18++;
                    }
                }
                break;
            }
            if (i15 < str.length() - 1) {
                zArr[i14] = false;
                i14++;
            }
        }
        return zArr;
    }

    @Override // qm.r
    public Collection<BarcodeFormat> g() {
        return Collections.singleton(BarcodeFormat.CODABAR);
    }
}
