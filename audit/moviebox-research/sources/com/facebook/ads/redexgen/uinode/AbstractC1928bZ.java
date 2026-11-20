package com.facebook.ads.redexgen.uinode;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.mvel2.ast.ASTNode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bZ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1928bZ extends AbstractC09520h {
    public static String A03;
    public static String A04;
    public static String A05;
    public static byte[] A06;
    public static String[] A07 = {"1", "OJ2IOsbUnCKybSqk53zM3JXcifahO", "e4RldewFXKwYCBzcZ5CwWZ5XjhlRHNiJ", "729G42gqUNiz5ZAUAxRhvFZ2YWMhTd0L", "J1Ql0tv9onNfDvsMKNTgjNyaDa6Pnzub", "9fBm", "mbPUpspz4Nj5AFGqwEe2w9x9WWs", "2uSYGuFAJgr"};
    public final boolean A00;
    public final C09580o A01;
    public final boolean A02;

    static {
        A0B();
        A03 = A0A(64, 7, 72);
        A04 = A0A(85, 24, 50);
        A05 = A0A(109, 16, 34);
    }

    public AbstractC1928bZ(C1795Yn c1795Yn, J2 j11, String str, C09580o c09580o, boolean z11) {
        this(c1795Yn, j11, str, c09580o, z11, false);
    }

    public AbstractC1928bZ(C1795Yn c1795Yn, J2 j11, String str, C09580o c09580o, boolean z11, boolean z12) {
        super(c1795Yn, j11, str);
        this.A01 = c09580o;
        this.A02 = z11;
        this.A00 = z12;
    }

    public static String A0A(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 30);
            if (A07[3].charAt(0) != '7') {
                throw new RuntimeException();
            }
            A07[5] = "PWjD";
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0B() {
        A06 = new byte[]{93, 114, 119, 125, 117, 62, 114, 113, 121, 121, 123, 122, 68, 75, 65, 87, 74, 76, 65, Ascii.VT, 76, 75, 81, 64, 75, 81, Ascii.VT, 68, 70, 81, 76, 74, 75, Ascii.VT, 115, 108, 96, 114, Ascii.CAN, Ascii.ESC, Ascii.EM, 17, 37, Ascii.SO, 19, Ascii.ETB, Ascii.US, 46, 39, 35, 52, 39, Ascii.GS, 54, 43, 47, 39, Ascii.VT, 17, Ascii.DLE, 7, Ascii.VT, 9, 1, 37, 35, 53, 53, 51, 37, 37, 76, 87, 80, 79, 92, 75, 74, 88, 85, 102, 85, 80, 87, 82, 89, 95, 73, 94, 115, 88, 94, 77, 79, 71, 73, 94, 115, 69, 95, 115, 66, 67, 88, 115, 66, 89, 64, 64, 75, 93, 72, 95, 84, 99, 93, 82, 88, 99, 94, 78, 83, 75, 79, 89};
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC09520h
    public final EnumC09510g A0C() {
        C09580o c09580o = this.A01;
        if (c09580o != null) {
            c09580o.A07(super.A02);
        }
        return C1517Nr.A03(super.A00) ? EnumC09510g.A05 : A0D();
    }

    public abstract EnumC09510g A0D();

    /* JADX WARN: Code duplicated, block: B:21:0x0080  */
    /* JADX WARN: Code duplicated, block: B:23:0x008f  */
    /* JADX WARN: Code duplicated, block: B:26:0x00ac  */
    public final void A0E(Map<String, String> map, EnumC09510g enumC09510g) {
        C09580o c09580o;
        if (!TextUtils.isEmpty(super.A02)) {
            if (this instanceof C1309Fg) {
                super.A01.AA8(super.A02, map);
            } else {
                J2 j11 = super.A01;
                String str = super.A02;
                if (A07[6].length() != 8) {
                    A07[5] = "D2ZF";
                    j11.A9j(str, map);
                } else {
                    j11.A9j(str, map);
                }
            }
            boolean zA02 = EnumC09510g.A02(enumC09510g);
            if (A07[1].length() == 32) {
                throw new RuntimeException();
            }
            A07[0] = "X";
            boolean z11 = this.A01 != null;
            if (C1384Ih.A20(super.A00)) {
                HashMap map2 = new HashMap();
                map2.put(A03, Boolean.toString(!zA02));
                map2.put(A04, Boolean.toString(z11));
                map2.put(A05, Boolean.toString(this.A00));
                super.A01.A9s(super.A02, map2);
            }
            C09580o c09580o2 = this.A01;
            if (c09580o2 != null) {
                c09580o2.A06(enumC09510g);
                if (A07[6].length() != 8) {
                    A07[6] = "4hYdj7INWre5bef3R1byHGHBMmQCX";
                    if (zA02) {
                        c09580o = this.A01;
                        if (A07[6].length() != 8) {
                            String[] strArr = A07;
                            strArr[2] = "42brCgECckKxVuTsLxKp6fXlInYi7mUj";
                            strArr[4] = "SJ7s8Rg0tKhfkKPQamVQVBa2w2xrx0QV";
                            c09580o.A05();
                        } else {
                            c09580o.A05();
                        }
                    }
                } else {
                    A07[5] = "IMSq";
                    if (zA02) {
                        c09580o = this.A01;
                        if (A07[6].length() != 8) {
                            String[] strArr2 = A07;
                            strArr2[2] = "42brCgECckKxVuTsLxKp6fXlInYi7mUj";
                            strArr2[4] = "SJ7s8Rg0tKhfkKPQamVQVBa2w2xrx0QV";
                            c09580o.A05();
                        } else {
                            c09580o.A05();
                        }
                    }
                }
            } else {
                HashMap map3 = new HashMap();
                map3.put(A0A(47, 10, 92), Long.toString(-1L));
                map3.put(A0A(38, 9, 100), Long.toString(-1L));
                map3.put(A0A(57, 7, 122), EnumC09510g.A04.name());
                super.A01.AA9(super.A02, map3);
            }
        }
        L4.A02(super.A00, A0A(0, 12, 0));
    }

    public final boolean A0F(Uri uri) {
        try {
            String queryParameter = uri.getQueryParameter(A0A(71, 14, 39));
            if (TextUtils.isEmpty(queryParameter)) {
                return false;
            }
            Intent intent = new Intent(A0A(12, 26, 59), AbstractC1446Ky.A00(queryParameter));
            intent.addFlags(ASTNode.DEOP);
            if (Build.VERSION.SDK_INT >= 30) {
                intent.addFlags(1024);
            }
            return C1433Kj.A0C(super.A00, intent);
        } catch (C1431Kh unused) {
            return false;
        }
    }
}
