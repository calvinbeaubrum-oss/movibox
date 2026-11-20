package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'A05' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.1d, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class EnumC09731d {
    public static byte[] A01;
    public static final /* synthetic */ EnumC09731d[] A02;
    public static final EnumC09731d A03;
    public static final EnumC09731d A04;
    public static final EnumC09731d A05;
    public final String A00;

    static {
        A02();
        String strA01 = A01(27, 16, 0);
        EnumC09731d enumC09731d = new EnumC09731d(strA01, 0, strA01);
        A05 = enumC09731d;
        String strA02 = A01(13, 14, 115);
        EnumC09731d enumC09731d2 = new EnumC09731d(strA02, 1, strA02);
        A04 = enumC09731d2;
        String strA03 = A01(0, 13, WebSocketProtocol.PAYLOAD_SHORT);
        EnumC09731d enumC09731d3 = new EnumC09731d(strA03, 2, strA03);
        A03 = enumC09731d3;
        A02 = new EnumC09731d[]{enumC09731d, enumC09731d2, enumC09731d3};
    }

    public EnumC09731d(String str, int i11, String str2) {
        super(str, i11);
        this.A00 = str2;
    }

    public static EnumC09731d A00(String str) {
        for (EnumC09731d enumC09731d : values()) {
            if (enumC09731d.A00.equalsIgnoreCase(str)) {
                return enumC09731d;
            }
        }
        return A03;
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 32);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{Ascii.CAN, Ascii.ETB, Ascii.DC2, Ascii.ESC, 1, Ascii.SO, Ascii.FF, Ascii.ESC, Ascii.GS, Ascii.US, Ascii.GS, Ascii.SYN, Ascii.ESC, 3, 1, Ascii.FS, Ascii.VT, 10, Ascii.FF, 3, 1, Ascii.SYN, Ascii.DLE, Ascii.DC2, Ascii.DLE, Ascii.ESC, Ascii.SYN, 119, 101, 98, 118, 105, 101, 119, Ascii.DEL, 112, 114, 101, 99, 97, 99, 104, 101};
    }

    public static EnumC09731d valueOf(String str) {
        return (EnumC09731d) Enum.valueOf(EnumC09731d.class, str);
    }

    public static EnumC09731d[] values() {
        return (EnumC09731d[]) A02.clone();
    }
}
