package com.facebook.ads.redexgen.uinode;

import android.net.Uri;
import com.applovin.exoplayer2.common.base.Ascii;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ek, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1287Ek {
    public static byte[] A03;
    public static String[] A04 = {"UShKNNFg87kJKFq9zZ4MXrM1TZqBqByP", "bNbNgwYs44UALuoZhh", "UOZFjFwmfZ6Uk9K0z0C", "pvrkJysKsIVU", "ICsDSmeasSqv6BvMkmxncpzNQ0k3b5KN", "yTEFvUo2j", "amPx4bchTjSSxZ8pJApIWlQt7YwmxhXF", "zL4iYMzloDmr1aHfk19k2KMtR5ocnLoy"};
    public InterfaceC1233Bs A00;
    public final InterfaceC1235Bu A01;
    public final InterfaceC1233Bs[] A02;

    static {
        A01();
    }

    public C1287Ek(InterfaceC1233Bs[] interfaceC1233BsArr, InterfaceC1235Bu interfaceC1235Bu) {
        this.A02 = interfaceC1233BsArr;
        this.A01 = interfaceC1235Bu;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 47);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        String[] strArr = A04;
        if (strArr[6].charAt(23) != strArr[7].charAt(23)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A04;
        strArr2[2] = "BFR1v4rNBeEaqGbowcf";
        strArr2[5] = "QYASgTnFJ";
        A03 = new byte[]{-52, -61, 6, Ascii.DC2, Ascii.CAN, Ascii.SI, 7, -61, Ascii.NAK, 8, 4, 7, -61, Ascii.ETB, Ascii.VT, 8, -61, Ascii.SYN, Ascii.ETB, Ascii.NAK, 8, 4, Ascii.DLE, -47, -17, Ascii.DLE, Ascii.SI, 6, -63, Ascii.DLE, 7, -63, Ascii.NAK, 9, 6, -63, 2, Ascii.ETB, 2, 10, Ascii.CR, 2, 3, Ascii.CR, 6, -63, 6, Ascii.EM, Ascii.NAK, 19, 2, 4, Ascii.NAK, Ascii.DLE, 19, Ascii.DC4, -63, -55};
    }

    public final InterfaceC1233Bs A02(InterfaceC1234Bt interfaceC1234Bt, Uri uri) throws InterruptedException, IOException {
        InterfaceC1233Bs interfaceC1233Bs = this.A00;
        if (interfaceC1233Bs != null) {
            return interfaceC1233Bs;
        }
        for (InterfaceC1233Bs interfaceC1233Bs2 : this.A02) {
            try {
                if (interfaceC1233Bs2.AGR(interfaceC1234Bt)) {
                    this.A00 = interfaceC1233Bs2;
                    interfaceC1234Bt.AFM();
                    break;
                }
                continue;
            } catch (EOFException unused) {
            } catch (Throwable th2) {
                interfaceC1234Bt.AFM();
                throw th2;
            }
            interfaceC1234Bt.AFM();
        }
        InterfaceC1233Bs interfaceC1233Bs3 = this.A00;
        if (interfaceC1233Bs3 == null) {
            throw new WM(A00(24, 34, 114) + IF.A0S(this.A02) + A00(0, 24, 116), uri);
        }
        interfaceC1233Bs3.A8o(this.A01);
        return this.A00;
    }

    public final void A03() {
        if (this.A00 != null) {
            this.A00 = null;
        }
    }
}
