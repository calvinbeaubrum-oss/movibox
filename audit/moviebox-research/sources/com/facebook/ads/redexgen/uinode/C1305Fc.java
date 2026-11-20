package com.facebook.ads.redexgen.uinode;

import android.net.Uri;
import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Fc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1305Fc extends AbstractC1677Tv {
    public static byte[] A02;
    public static String[] A03 = {"RkD1OJxt7Cm", "85G", "rOg3VWXB3SEY3xQpEJ0sm9sa", "k8A4i4hEDbRwTbJ7ZqirbVmRMdyhqYao", "w8o7PtZgo3USKQqv4zP9Jz4sqmraE2my", "KkDuTncCOt8", "W5AvxWS2W", "p0drNpcb1k1QxXuNf36gE6"};
    public final /* synthetic */ C1916bN A00;
    public final /* synthetic */ C1906bD A01;

    static {
        A01();
    }

    public C1305Fc(C1916bN c1916bN, C1906bD c1906bD) {
        this.A00 = c1916bN;
        this.A01 = c1906bD;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 74);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{-113, -68, -68, -71, -68, 106, -81, -62, -81, -83, -65, -66, -77, -72, -79, 106, -85, -83, -66, -77, -71, -72, -1, -3, 8, 8, 1, Ascii.SO, -16, Ascii.NAK, Ascii.FF, 1, -25, -29, -30, -27, 17, Ascii.DC4, Ascii.ETB, Ascii.US, Ascii.DLE, Ascii.GS, Ascii.DLE, Ascii.SI, 10, Ascii.SO, Ascii.ETB, Ascii.DC4, Ascii.SO, Ascii.SYN, 10, Ascii.SI, Ascii.DLE, Ascii.ETB, Ascii.FF, 36, 10, Ascii.CAN, Ascii.RS, Ascii.SI, Ascii.EM, 5, 9, Ascii.CAN, Ascii.VT, 7, Ascii.SUB, Ascii.SI, Ascii.FS, Ascii.VT, 5, 7, Ascii.EM, 5, 9, Ascii.SUB, 7, 5, Ascii.FS, -40, -60, -67, -72, -64, -60, -76, -104, -77};
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1501Nb
    public final void AAn() {
        this.A00.A0F = true;
        if (this.A00.A0G) {
            this.A00.A0A();
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1677Tv, com.facebook.ads.redexgen.uinode.InterfaceC1501Nb
    public final void AB4(String str, Map<String, String> map) {
        this.A00.A04.A0E().A3j();
        Uri uriA00 = AbstractC1446Ky.A00(str);
        map.put(A00(22, 10, 82), AdPlacementType.BANNER.name());
        map.put(A00(80, 8, 5), this.A00.A0H);
        if (this.A00.A03 != null) {
            map.put(A00(59, 21, 92), String.valueOf(this.A00.A03.A0l()));
            map.put(A00(36, 23, 97), String.valueOf(this.A00.A03.A0H()));
        }
        AbstractC09520h abstractC09520hA00 = C09530i.A00(this.A00.A04, this.A00.A05, this.A01.A6T(), uriA00, map, this.A00.A03 == null ? null : this.A00.A03.A0y());
        EnumC09510g enumC09510gA0C = EnumC09510g.A08;
        if (abstractC09520hA00 != null) {
            try {
                this.A00.A04.A0E().A3g();
                enumC09510gA0C = abstractC09520hA00.A0C();
            } catch (Exception e11) {
                Log.e(C1916bN.A0K, A00(0, 22, 0), e11);
            }
        }
        boolean z11 = abstractC09520hA00 instanceof C1307Fe;
        String[] strArr = A03;
        if (strArr[0].length() != strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A03;
        strArr2[1] = "yKt";
        strArr2[2] = "O3cmN93hsB9jwoMarcV7SE5e";
        boolean z12 = (z11 || (abstractC09520hA00 instanceof C1309Fg)) && AbstractC1462Lo.A0e(this.A00.A04, enumC09510gA0C, map);
        if (A00(32, 4, 55).equals(uriA00.getScheme()) && C09530i.A04(uriA00.getAuthority())) {
            C1916bN c1916bN = this.A00;
            String[] strArr3 = A03;
            if (strArr3[1].length() != strArr3[2].length()) {
                String[] strArr4 = A03;
                strArr4[3] = "M83eNTNa8vARqiZhiytfGHWaWQaZAWG6";
                strArr4[4] = "l8FjrIknJvxUrl7LWCsoLe7lR5i3NNwU";
                if (c1916bN.A00 == null) {
                    return;
                }
            } else {
                String[] strArr5 = A03;
                strArr5[0] = "riyOH90vrbS";
                strArr5[5] = "IRnMxNmFGTn";
                if (c1916bN.A00 == null) {
                    return;
                }
            }
            if (z12 || enumC09510gA0C == EnumC09510g.A05) {
                return;
            }
            this.A00.A00.AAx(this.A00);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1501Nb
    public final void ABj() {
        this.A00.A04.A0E().A3k(this.A00.A02 != null);
        if (this.A00.A02 != null) {
            this.A00.A02.A02();
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1677Tv, com.facebook.ads.redexgen.uinode.InterfaceC1501Nb
    public final void ACU() {
        this.A00.A04.A0E().A3m();
        this.A00.A02.A07();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1501Nb
    public final void ADj() {
    }
}
