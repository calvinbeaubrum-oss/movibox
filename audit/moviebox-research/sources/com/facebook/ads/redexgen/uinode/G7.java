package com.facebook.ads.redexgen.uinode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Region;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.view.ViewCompat;
import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import okio.Utf8;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class G7 {
    public static byte[] A07;
    public static String[] A08 = {"qcU5l5rVDanZ0IBZnB67EILhI18GgdFe", "32XpuNghlFeF4zyqPL948gmCUNCGk", "bftD5DkqR73p2Uf2yBhEF5T9UOvyv9s", "0", "qryxRa4yOsFNWhLtu25s3YxhDLRy", "", "tLr9RBWs5E21", "UeFN6nMF8sjHvHxScJIKm37Ehl9oCVg2"};
    public static final byte[] A09;
    public static final byte[] A0A;
    public static final byte[] A0B;
    public Bitmap A00;
    public final Canvas A01;
    public final Paint A02;
    public final Paint A03;
    public final C1326Fz A04;
    public final G0 A05;
    public final G6 A06;

    static {
        A0A();
        A09 = new byte[]{0, 7, 8, Ascii.SI};
        A0A = new byte[]{0, 119, -120, -1};
        A0B = new byte[]{0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    }

    public G7(int i11, int i12) {
        Paint paint = new Paint();
        this.A02 = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.A03 = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.A01 = new Canvas();
        this.A05 = new G0(719, 575, 0, 719, 0, 575);
        this.A04 = new C1326Fz(0, A0F(), A0G(), A0H());
        this.A06 = new G6(i11, i12);
    }

    public static int A00(int i11, int i12, int i13, int i14) {
        return (i11 << 24) | (i12 << 16) | (i13 << 8) | i14;
    }

    public static int A01(C1375Hy c1375Hy, int[] iArr, byte[] bArr, int i11, int i12, Paint paint, Canvas canvas) {
        int i13 = i11;
        boolean z11 = false;
        do {
            int iA04 = 0;
            int iA05 = 0;
            iA05 = 0;
            iA05 = 0;
            iA05 = 0;
            int iA06 = c1375Hy.A04(2);
            if (iA06 != 0) {
                iA04 = 1;
                if (A08[1].length() != 29) {
                    throw new RuntimeException();
                }
                A08[6] = "cKDkKJCaTP5Z";
                iA05 = iA06;
            } else if (c1375Hy.A0F()) {
                iA04 = c1375Hy.A04(3) + 3;
                iA05 = c1375Hy.A04(2);
                if (A08[1].length() == 29) {
                    A08[1] = "Xe5wyvwrL1rxQiCfD8ENREY9AaRUH";
                }
            } else if (!c1375Hy.A0F()) {
                switch (c1375Hy.A04(2)) {
                    case 0:
                        z11 = true;
                        break;
                    case 1:
                        iA04 = 2;
                        break;
                    case 2:
                        iA04 = c1375Hy.A04(4) + 12;
                        iA05 = c1375Hy.A04(2);
                        break;
                    case 3:
                        iA04 = c1375Hy.A04(8) + 29;
                        if (A08[1].length() != 29) {
                            throw new RuntimeException();
                        }
                        A08[5] = "eZC8v48u";
                        iA05 = c1375Hy.A04(2);
                        break;
                }
            } else {
                iA04 = 1;
            }
            if (iA04 != 0 && paint != null) {
                if (bArr != null) {
                    iA05 = bArr[iA05];
                }
                paint.setColor(iArr[iA05]);
                canvas.drawRect(i13, i12, i13 + iA04, i12 + 1, paint);
            }
            i13 += iA04;
        } while (!z11);
        return i13;
    }

    public static int A02(C1375Hy c1375Hy, int[] iArr, byte[] bArr, int i11, int i12, Paint paint, Canvas canvas) {
        int i13 = i11;
        boolean z11 = false;
        do {
            int iA04 = 0;
            int iA05 = c1375Hy.A04(4);
            if (iA05 != 0) {
                iA04 = 1;
            } else if (!c1375Hy.A0F()) {
                int iA06 = c1375Hy.A04(3);
                if (iA06 != 0) {
                    iA04 = iA06 + 2;
                    iA05 = 0;
                } else {
                    z11 = true;
                    iA05 = 0;
                }
            } else if (c1375Hy.A0F()) {
                switch (c1375Hy.A04(2)) {
                    case 0:
                        iA04 = 1;
                        if (A08[1].length() == 29) {
                            String[] strArr = A08;
                            strArr[3] = DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B;
                            strArr[4] = "RKCQrML1KI9i2rbeBXbE06C32ORX";
                            iA05 = 0;
                        } else {
                            iA05 = 0;
                        }
                        break;
                    case 1:
                        iA04 = 2;
                        iA05 = 0;
                        break;
                    case 2:
                        iA04 = c1375Hy.A04(4) + 9;
                        iA05 = c1375Hy.A04(4);
                        break;
                    case 3:
                        iA04 = c1375Hy.A04(8) + 25;
                        String[] strArr2 = A08;
                        if (strArr2[3].length() == strArr2[4].length()) {
                            throw new RuntimeException();
                        }
                        A08[6] = "tDVEwF5JbpPt";
                        iA05 = c1375Hy.A04(4);
                        break;
                        break;
                    default:
                        iA05 = 0;
                        break;
                }
            } else {
                iA04 = c1375Hy.A04(2) + 4;
                iA05 = c1375Hy.A04(4);
            }
            if (iA04 != 0 && paint != null) {
                if (bArr != null) {
                    iA05 = bArr[iA05];
                }
                paint.setColor(iArr[iA05]);
                float f11 = i13;
                float f12 = i12;
                if (A08[6].length() != 12) {
                    throw new RuntimeException();
                }
                A08[1] = "PxagUxU0Gd3Wd2jZQY5J7se2mW8fT";
                canvas.drawRect(f11, f12, i13 + iA04, i12 + 1, paint);
            }
            i13 += iA04;
        } while (!z11);
        return i13;
    }

    public static int A03(C1375Hy c1375Hy, int[] iArr, byte[] bArr, int i11, int i12, Paint paint, Canvas canvas) {
        int iA04;
        int i13 = i11;
        boolean z11 = false;
        do {
            int iA05 = c1375Hy.A04(8);
            if (iA05 != 0) {
                iA04 = 1;
            } else if (c1375Hy.A0F()) {
                iA04 = c1375Hy.A04(7);
                iA05 = c1375Hy.A04(8);
            } else {
                iA04 = c1375Hy.A04(7);
                if (A08[6].length() != 12) {
                    throw new RuntimeException();
                }
                A08[1] = "SuejjuLnG0h9t9VMaryqiTg33Oi2Z";
                if (iA04 != 0) {
                    iA05 = 0;
                } else {
                    z11 = true;
                    iA04 = 0;
                    iA05 = 0;
                }
            }
            if (iA04 != 0 && paint != null) {
                if (bArr != null) {
                    iA05 = bArr[iA05];
                }
                paint.setColor(iArr[iA05]);
                canvas.drawRect(i13, i12, i13 + iA04, i12 + 1, paint);
            }
            i13 += iA04;
        } while (!z11);
        return i13;
    }

    public static C1326Fz A04(C1375Hy c1375Hy, int i11) {
        int[] iArr;
        int iA04;
        int iA05;
        int iA06;
        int iA07;
        int i12 = 8;
        int iA08 = c1375Hy.A04(8);
        c1375Hy.A08(8);
        int i13 = i11 - 2;
        int[] iArrA0F = A0F();
        int[] iArrA0G = A0G();
        int[] iArrA0H = A0H();
        while (i13 > 0) {
            int iA09 = c1375Hy.A04(i12);
            int iA010 = c1375Hy.A04(i12);
            int i14 = i13 - 2;
            if ((iA010 & 128) != 0) {
                iArr = iArrA0F;
            } else {
                iArr = (iA010 & 64) != 0 ? iArrA0G : iArrA0H;
            }
            if ((iA010 & 1) != 0) {
                iA04 = c1375Hy.A04(i12);
                iA05 = c1375Hy.A04(i12);
                iA06 = c1375Hy.A04(i12);
                iA07 = c1375Hy.A04(i12);
                i13 = i14 - 4;
            } else {
                iA04 = c1375Hy.A04(6) << 2;
                iA05 = c1375Hy.A04(4) << 4;
                iA06 = c1375Hy.A04(4) << 4;
                iA07 = c1375Hy.A04(2) << 6;
                i13 = i14 - 2;
            }
            if (iA04 == 0) {
                iA05 = 0;
                iA06 = 0;
                iA07 = 255;
            }
            iArr[iA09] = A00((byte) (255 - (iA07 & 255)), IF.A06((int) (((double) iA04) + (((double) (iA05 - 128)) * 1.402d)), 0, 255), IF.A06((int) ((((double) iA04) - (((double) (iA06 - 128)) * 0.34414d)) - (((double) (iA05 - 128)) * 0.71414d)), 0, 255), IF.A06((int) (((double) iA04) + (((double) (iA06 - 128)) * 1.772d)), 0, 255));
            i12 = 8;
        }
        return new C1326Fz(iA08, iArrA0F, iArrA0G, iArrA0H);
    }

    public static G0 A05(C1375Hy c1375Hy) {
        int iA04;
        int iA05;
        int iA06;
        int iA07;
        c1375Hy.A08(4);
        boolean zA0F = c1375Hy.A0F();
        c1375Hy.A08(3);
        int iA08 = c1375Hy.A04(16);
        int iA09 = c1375Hy.A04(16);
        if (zA0F) {
            iA04 = c1375Hy.A04(16);
            iA07 = c1375Hy.A04(16);
            iA05 = c1375Hy.A04(16);
            iA06 = c1375Hy.A04(16);
        } else {
            iA04 = 0;
            iA05 = 0;
            iA06 = iA09;
            iA07 = iA08;
        }
        return new G0(iA08, iA09, iA04, iA07, iA05, iA06);
    }

    public static G1 A06(C1375Hy c1375Hy) {
        int iA04 = c1375Hy.A04(16);
        c1375Hy.A08(4);
        int iA05 = c1375Hy.A04(2);
        boolean zA0F = c1375Hy.A0F();
        c1375Hy.A08(1);
        byte[] bArr = null;
        byte[] bArr2 = null;
        if (iA05 == 1) {
            c1375Hy.A08(c1375Hy.A04(8) * 16);
        } else if (iA05 == 0) {
            int iA06 = c1375Hy.A04(16);
            int iA07 = c1375Hy.A04(16);
            if (iA06 > 0) {
                bArr = new byte[iA06];
                c1375Hy.A0E(bArr, 0, iA06);
            }
            if (iA07 > 0) {
                bArr2 = new byte[iA07];
                c1375Hy.A0E(bArr2, 0, iA07);
            } else {
                bArr2 = bArr;
            }
        }
        return new G1(iA04, zA0F, bArr, bArr2);
    }

    public static G2 A07(C1375Hy c1375Hy, int i11) {
        int iA04 = c1375Hy.A04(8);
        int iA05 = c1375Hy.A04(4);
        int iA06 = c1375Hy.A04(2);
        c1375Hy.A08(2);
        int i12 = i11 - 2;
        SparseArray sparseArray = new SparseArray();
        while (i12 > 0) {
            int iA07 = c1375Hy.A04(8);
            c1375Hy.A08(8);
            i12 -= 6;
            sparseArray.put(iA07, new G3(c1375Hy.A04(16), c1375Hy.A04(16)));
        }
        return new G2(iA04, iA05, iA06, sparseArray);
    }

    public static G4 A08(C1375Hy c1375Hy, int i11) {
        int i12 = 8;
        int iA04 = c1375Hy.A04(8);
        c1375Hy.A08(4);
        boolean zA0F = c1375Hy.A0F();
        c1375Hy.A08(3);
        int iA05 = c1375Hy.A04(16);
        int iA06 = c1375Hy.A04(16);
        int iA07 = c1375Hy.A04(3);
        int iA08 = c1375Hy.A04(3);
        c1375Hy.A08(2);
        int iA09 = c1375Hy.A04(8);
        int iA010 = c1375Hy.A04(8);
        int iA011 = c1375Hy.A04(4);
        int iA012 = c1375Hy.A04(2);
        c1375Hy.A08(2);
        int i13 = i11 - 10;
        SparseArray sparseArray = new SparseArray();
        while (i13 > 0) {
            int iA013 = c1375Hy.A04(16);
            int iA014 = c1375Hy.A04(2);
            int iA015 = c1375Hy.A04(2);
            int iA016 = c1375Hy.A04(12);
            c1375Hy.A08(4);
            int iA017 = c1375Hy.A04(12);
            i13 -= 6;
            int iA018 = 0;
            int iA019 = 0;
            if (iA014 == 1 || iA014 == 2) {
                iA018 = c1375Hy.A04(i12);
                iA019 = c1375Hy.A04(i12);
                i13 -= 2;
            }
            sparseArray.put(iA013, new G5(iA014, iA015, iA016, iA017, iA018, iA019));
            i12 = 8;
        }
        return new G4(iA04, zA0F, iA05, iA06, iA07, iA08, iA09, iA010, iA011, iA012, sparseArray);
    }

    public static String A09(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 17);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0A() {
        A07 = new byte[]{Ascii.DC2, 55, 34, 55, 118, 48, Utf8.REPLACEMENT_BYTE, 51, 58, 50, 118, 58, 51, 56, 49, 34, 62, 118, 51, 46, 53, 51, 51, 50, 37, 118, 58, Utf8.REPLACEMENT_BYTE, 59, Utf8.REPLACEMENT_BYTE, 34, 106, 88, 76, 126, 79, 92, 93, 75, 92};
    }

    public static void A0B(G1 g11, C1326Fz c1326Fz, int i11, int i12, int i13, Paint paint, Canvas canvas) {
        int[] iArr;
        if (i11 == 3) {
            iArr = c1326Fz.A03;
        } else {
            if (A08[2].length() == 20) {
                throw new RuntimeException();
            }
            A08[1] = "74G7JuTvJBV0INH1XI3DUfK6d2EWZ";
            iArr = i11 == 2 ? c1326Fz.A02 : c1326Fz.A01;
        }
        A0D(g11.A03, iArr, i11, i12, i13, paint, canvas);
        A0D(g11.A02, iArr, i11, i12, i13 + 1, paint, canvas);
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:43:0x0117  */
    public static void A0C(C1375Hy c1375Hy, G6 g11) {
        int iA04 = c1375Hy.A04(8);
        int iA05 = c1375Hy.A04(16);
        int iA06 = c1375Hy.A04(16);
        int iA02 = c1375Hy.A02() + iA06;
        if (iA06 * 8 > c1375Hy.A01()) {
            Log.w(A09(31, 9, 63), A09(0, 31, 71));
            c1375Hy.A08(c1375Hy.A01());
            return;
        }
        switch (iA04) {
            case 16:
                if (iA05 == g11.A03) {
                    G2 g12 = g11.A01;
                    G2 g2A07 = A07(c1375Hy, iA06);
                    if (A08[2].length() == 20) {
                        A08[5] = "eHaCLq5ayPLh";
                        if (g2A07.A00 != 0) {
                            g11.A01 = g2A07;
                            g11.A08.clear();
                            g11.A06.clear();
                            g11.A07.clear();
                        } else if (g12 != null) {
                            g11.A01 = g2A07;
                        }
                    } else {
                        String[] strArr = A08;
                        strArr[0] = "SOWWurFjCTsQ5JKY9OnGZdezCI3KtXYI";
                        strArr[7] = "V4dNvY88haURe4qy074bHXOdfnJc7iQY";
                        if (g2A07.A00 != 0) {
                            g11.A01 = g2A07;
                            g11.A08.clear();
                            g11.A06.clear();
                            g11.A07.clear();
                        } else if (g12 != null && g12.A02 != g2A07.A02) {
                            g11.A01 = g2A07;
                        }
                    }
                }
                break;
            case 17:
                G2 g13 = g11.A01;
                if (iA05 == g11.A03 && g13 != null) {
                    G4 g4A08 = A08(c1375Hy, iA06);
                    if (g13.A00 == 0) {
                        g4A08.A00(g11.A08.get(g4A08.A03));
                    }
                    SparseArray<G4> sparseArray = g11.A08;
                    String[] strArr2 = A08;
                    if (strArr2[3].length() == strArr2[4].length()) {
                        throw new RuntimeException();
                    }
                    A08[6] = "mahKYWCII7kQ";
                    sparseArray.put(g4A08.A03, g4A08);
                }
                break;
            case 18:
                if (iA05 == g11.A03) {
                    C1326Fz c1326FzA04 = A04(c1375Hy, iA06);
                    g11.A06.put(c1326FzA04.A00, c1326FzA04);
                } else if (iA05 == g11.A02) {
                    C1326Fz c1326FzA05 = A04(c1375Hy, iA06);
                    g11.A04.put(c1326FzA05.A00, c1326FzA05);
                }
                break;
            case 19:
                if (iA05 == g11.A03) {
                    G1 g1A06 = A06(c1375Hy);
                    g11.A07.put(g1A06.A00, g1A06);
                } else if (iA05 == g11.A02) {
                    G1 g1A07 = A06(c1375Hy);
                    g11.A05.put(g1A07.A00, g1A07);
                }
                break;
            case 20:
                if (iA05 == g11.A03) {
                    g11.A00 = A05(c1375Hy);
                }
                break;
        }
        c1375Hy.A09(iA02 - c1375Hy.A02());
    }

    public static void A0D(byte[] bArr, int[] iArr, int i11, int i12, int i13, Paint paint, Canvas canvas) {
        byte[] bArr2;
        byte[] bArr3;
        int i14 = i13;
        C1375Hy c1375Hy = new C1375Hy(bArr);
        byte[] bArrA0E = null;
        byte[] bArrA0E2 = null;
        int iA01 = i12;
        while (c1375Hy.A01() != 0) {
            switch (c1375Hy.A04(8)) {
                case 16:
                    if (i11 == 3) {
                        bArr2 = bArrA0E2 == null ? A0A : bArrA0E2;
                    } else if (i11 == 2) {
                        bArr2 = bArrA0E == null ? A09 : bArrA0E;
                    } else {
                        bArr2 = null;
                        if (A08[5].length() == 5) {
                            throw new RuntimeException();
                        }
                        String[] strArr = A08;
                        strArr[0] = "aCQdDxqS2bkmSWw219FL9FrVQLNlGxjh";
                        strArr[7] = "CXVqOrR1KNECyNPiemwICdwFVxmD3XsB";
                    }
                    if (A08[5].length() == 5) {
                        throw new RuntimeException();
                    }
                    A08[1] = "sxwfPuAvCy0meNXm9qprXKFgJpDmZ";
                    iA01 = A01(c1375Hy, iArr, bArr2, iA01, i14, paint, canvas);
                    c1375Hy.A05();
                    break;
                    break;
                case 17:
                    if (i11 == 3) {
                        bArr3 = 0 == 0 ? A0B : null;
                    } else {
                        bArr3 = null;
                    }
                    iA01 = A02(c1375Hy, iArr, bArr3, iA01, i14, paint, canvas);
                    c1375Hy.A05();
                    break;
                case 18:
                    iA01 = A03(c1375Hy, iArr, null, iA01, i14, paint, canvas);
                    break;
                case 32:
                    bArrA0E = A0E(4, 4, c1375Hy);
                    break;
                case 33:
                    bArrA0E2 = A0E(4, 8, c1375Hy);
                    break;
                case 34:
                    bArrA0E2 = A0E(16, 8, c1375Hy);
                    break;
                case 240:
                    i14 += 2;
                    iA01 = i12;
                    break;
            }
        }
    }

    public static byte[] A0E(int i11, int i12, C1375Hy c1375Hy) {
        byte[] bArr = new byte[i11];
        for (int i13 = 0; i13 < i11; i13++) {
            bArr[i13] = (byte) c1375Hy.A04(i12);
        }
        return bArr;
    }

    public static int[] A0F() {
        return new int[]{0, -1, ViewCompat.MEASURED_STATE_MASK, -8421505};
    }

    public static int[] A0G() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i11 = 1; i11 < iArr.length; i11++) {
            if (i11 < 8) {
                int i12 = i11 & 1;
                if (A08[1].length() != 29) {
                    throw new RuntimeException();
                }
                A08[6] = "OBOqbcJ5TVgi";
                iArr[i11] = A00(255, i12 != 0 ? 255 : 0, (i11 & 2) != 0 ? 255 : 0, (i11 & 4) != 0 ? 255 : 0);
            } else {
                iArr[i11] = A00(255, (i11 & 1) != 0 ? 127 : 0, (i11 & 2) != 0 ? 127 : 0, (i11 & 4) == 0 ? 0 : 127);
            }
        }
        return iArr;
    }

    /* JADX WARN: Code duplicated, block: B:107:0x0163  */
    /* JADX WARN: Code duplicated, block: B:128:0x01b6  */
    public static int[] A0H() {
        int i11;
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i12 = 0; i12 < iArr.length; i12++) {
            if (A08[5].length() != 5) {
                A08[5] = "yMmopDV0PROTT6iUygdI9MoWuRB";
                if (i12 >= 8) {
                    switch (i12 & 136) {
                        case 0:
                            int i13 = (i12 & 1) != 0 ? 85 : 0;
                            int i14 = i12 & 16;
                            if (A08[6].length() != 12) {
                                A08[6] = "5kFBsD3TZCPr";
                                if (i14 != 0) {
                                    i11 = 170;
                                } else {
                                    i11 = 0;
                                }
                            } else {
                                A08[5] = "e5fZNa";
                                if (i14 != 0) {
                                    i11 = 170;
                                } else {
                                    i11 = 0;
                                }
                            }
                            int i15 = i13 + i11;
                            int i16 = ((i12 & 2) != 0 ? 85 : 0) + ((i12 & 32) != 0 ? 170 : 0);
                            int i17 = ((i12 & 4) == 0 ? 0 : 85) + ((i12 & 64) == 0 ? 0 : 170);
                            String[] strArr = A08;
                            if (strArr[0].charAt(24) == strArr[7].charAt(24)) {
                                throw new RuntimeException();
                            }
                            String[] strArr2 = A08;
                            strArr2[3] = "N";
                            strArr2[4] = "KgCT6FPPbQR5Gt38AZY6Kgkq0L3q";
                            iArr[i12] = A00(255, i15, i16, i17);
                            continue;
                            break;
                        case 8:
                            iArr[i12] = A00(127, ((i12 & 1) != 0 ? 85 : 0) + ((i12 & 16) != 0 ? 170 : 0), ((i12 & 2) != 0 ? 85 : 0) + ((i12 & 32) != 0 ? 170 : 0), ((i12 & 4) == 0 ? 0 : 85) + ((i12 & 64) == 0 ? 0 : 170));
                            continue;
                        case 128:
                            int iA00 = A00(255, ((i12 & 1) != 0 ? 43 : 0) + 127 + ((i12 & 16) != 0 ? 85 : 0), ((i12 & 2) != 0 ? 43 : 0) + 127 + ((i12 & 32) != 0 ? 85 : 0), ((i12 & 4) == 0 ? 0 : 43) + 127 + ((i12 & 64) == 0 ? 0 : 85));
                            String[] strArr3 = A08;
                            if (strArr3[3].length() == strArr3[4].length()) {
                                throw new RuntimeException();
                            }
                            String[] strArr4 = A08;
                            strArr4[0] = "aybqBWwtY0DT9MvKUrSszXiCsWNuAoGt";
                            strArr4[7] = "n5OaccyWXsmPzT0g59BcvtkeBPKtga8v";
                            iArr[i12] = iA00;
                            continue;
                            break;
                        case 136:
                            int i18 = ((i12 & 1) != 0 ? 43 : 0) + ((i12 & 16) != 0 ? 85 : 0);
                            int i19 = ((i12 & 2) != 0 ? 43 : 0) + ((i12 & 32) != 0 ? 85 : 0);
                            if (A08[2].length() != 20) {
                                A08[5] = "gSUXJnsqi";
                                int i21 = (i12 & 4) == 0 ? 0 : 43;
                                int i22 = i12 & 64;
                                if (A08[2].length() != 20) {
                                    String[] strArr5 = A08;
                                    strArr5[0] = "whmrMiK0u12tANJBqhusYeSDK3rkmMFj";
                                    strArr5[7] = "x13RVeSrZB6JEJa4BQjiEaMCBMX5qcSw";
                                    iArr[i12] = A00(255, i18, i19, i21 + (i22 == 0 ? 0 : 85));
                                }
                            }
                            break;
                        default:
                            continue;
                    }
                } else {
                    iArr[i12] = A00(63, (i12 & 1) != 0 ? 255 : 0, (i12 & 2) != 0 ? 255 : 0, (i12 & 4) == 0 ? 0 : 255);
                }
            }
            throw new RuntimeException();
        }
        return iArr;
    }

    public final List<C1314Fn> A0I(byte[] bArr, int i11) {
        C1375Hy c1375Hy = new C1375Hy(bArr, i11);
        while (c1375Hy.A01() >= 48 && c1375Hy.A04(8) == 15) {
            A0C(c1375Hy, this.A06);
        }
        if (this.A06.A01 == null) {
            return Collections.emptyList();
        }
        G0 g11 = this.A06.A00 != null ? this.A06.A00 : this.A05;
        if (this.A00 == null || g11.A05 + 1 != this.A00.getWidth() || g11.A00 + 1 != this.A00.getHeight()) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(g11.A05 + 1, g11.A00 + 1, Bitmap.Config.ARGB_8888);
            this.A00 = bitmapCreateBitmap;
            this.A01.setBitmap(bitmapCreateBitmap);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray<G3> sparseArray = this.A06.A01.A03;
        for (int i12 = 0; i12 < sparseArray.size(); i12++) {
            G3 g3ValueAt = sparseArray.valueAt(i12);
            G4 g12 = this.A06.A08.get(sparseArray.keyAt(i12));
            int i13 = g3ValueAt.A00 + g11.A02;
            int i14 = g3ValueAt.A01 + g11.A04;
            this.A01.clipRect(i13, i14, Math.min(g12.A08 + i13, g11.A01), Math.min(g12.A02 + i14, g11.A03), Region.Op.REPLACE);
            C1326Fz c1326Fz = this.A06.A06.get(g12.A00);
            if (c1326Fz == null && (c1326Fz = this.A06.A04.get(g12.A00)) == null) {
                c1326Fz = this.A04;
            }
            SparseArray<G5> sparseArray2 = g12.A09;
            for (int i15 = 0; i15 < sparseArray2.size(); i15++) {
                int iKeyAt = sparseArray2.keyAt(i15);
                G5 g5ValueAt = sparseArray2.valueAt(i15);
                G1 g13 = this.A06.A07.get(iKeyAt);
                String[] strArr = A08;
                if (strArr[0].charAt(24) == strArr[7].charAt(24)) {
                    throw new RuntimeException();
                }
                A08[1] = "0wDldquZfVkccfOmGfzJ1HL0d6oT0";
                if (g13 == null) {
                    g13 = this.A06.A05.get(iKeyAt);
                }
                if (g13 != null) {
                    A0B(g13, c1326Fz, g12.A01, i13 + g5ValueAt.A02, i14 + g5ValueAt.A05, g13.A01 ? null : this.A02, this.A01);
                }
            }
            if (g12.A0A) {
                this.A03.setColor(g12.A01 == 3 ? c1326Fz.A03[g12.A07] : g12.A01 == 2 ? c1326Fz.A02[g12.A06] : c1326Fz.A01[g12.A05]);
                this.A01.drawRect(i13, i14, g12.A08 + i13, g12.A02 + i14, this.A03);
            }
            arrayList.add(new C1314Fn(Bitmap.createBitmap(this.A00, i13, i14, g12.A08, g12.A02), i13 / g11.A05, 0, i14 / g11.A00, 0, g12.A08 / g11.A05, g12.A02 / g11.A00));
            this.A01.drawColor(0, PorterDuff.Mode.CLEAR);
        }
        return arrayList;
    }

    public final void A0J() {
        this.A06.A00();
    }
}
