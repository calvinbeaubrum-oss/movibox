package com.facebook.ads.redexgen.uinode;

import android.graphics.Rect;
import android.view.View;
import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okio.Utf8;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.cU, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1973cU {
    public InterfaceC1974cV A00;
    public C1960cH A01;
    public final InterfaceC1982ce A03;
    public final InterfaceC1975cW A04;
    public final LinkedHashMap<Integer, Runnable> A05 = new LinkedHashMap<>();
    public final InterfaceC1974cV A02 = new HD(this);

    public C1973cU(InterfaceC1982ce interfaceC1982ce, InterfaceC1975cW interfaceC1975cW) {
        this.A03 = interfaceC1982ce;
        this.A04 = interfaceC1975cW;
    }

    public static C1973cU A01() {
        return new C1973cU(new HH(), null);
    }

    private void A03(AbstractC1976cY abstractC1976cY, InterfaceC1980cc interfaceC1980cc, HB hb2) {
        C1960cH c1960cHA00 = C1960cH.A00(abstractC1976cY, interfaceC1980cc, hb2);
        this.A01 = c1960cHA00;
        if (0 != 0) {
            c1960cHA00.A01(null);
        }
        this.A01.A02(this.A02);
    }

    private final void A04(DspViewableNode dspViewableNode) {
        C1960cH c1960cH = this.A01;
        if (c1960cH == null || dspViewableNode == null) {
            return;
        }
        c1960cH.A03(dspViewableNode);
    }

    private final void A05(DspViewableNode dspViewableNode, C1978ca c1978ca) {
        C1960cH c1960cH = this.A01;
        if (c1960cH == null || dspViewableNode == null || c1978ca == null) {
            return;
        }
        c1960cH.A04(dspViewableNode, c1978ca);
    }

    public final void A06(View view) {
        A04(view != null ? ViewpointViewNode.A00(view) : null);
    }

    public final void A07(View view, C1978ca c1978ca) {
        A05(view != null ? ViewpointViewNode.A00(view) : null, c1978ca);
    }

    public final void A08(AbstractC1976cY abstractC1976cY, View view) {
        if (abstractC1976cY == null || view == null) {
            return;
        }
        final InterfaceC1975cW interfaceC1975cW = null;
        A03(abstractC1976cY, new HE(view, this.A03), new HB(interfaceC1975cW) { // from class: com.facebook.ads.redexgen.X.6w
            public static byte[] A09;
            public static String[] A0A = {"okBgSYhQGmV0QyU32992deBLR6XrdaZQ", "E", "ZDdZ5rthnspWTI3gzSJHBR7aYCyAxUsq", "EsXM2pc2I6J3hYC1V9OQRTCtALa8wmqB", "DKA0ex9266tXplnV6PUb8C0vdYHWYjG4", "tBgdKBpc94v7LWesC8aTGIaQqZdJYwjy", "iZindrm9v6DBRttH7DMzAa7", "d9237vu9oQoOcpvZwewcjFUDz74P7MIA"};
            public static final String A0B;
            public long A00;
            public cX A01;
            public final InterfaceC1975cW A02;
            public final Map<String, C1965cM> A06 = new HashMap();
            public final C1966cN A04 = new C1966cN();
            public final C1966cN A03 = new C1966cN();
            public final List<Rect> A05 = new ArrayList(1);
            public final boolean A08 = false;
            public final boolean A07 = false;

            static {
                A03();
                A0B = C11156w.class.getSimpleName();
            }

            {
                this.A02 = interfaceC1975cW;
            }

            public static Rect A00(C1965cM c1965cM) {
                if (c1965cM != null && c1965cM.A02.top != Integer.MIN_VALUE && c1965cM.A02.left != Integer.MIN_VALUE) {
                    Rect rect = c1965cM.A02;
                    String[] strArr = A0A;
                    if (strArr[1].length() == strArr[6].length()) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A0A;
                    strArr2[1] = TtmlNode.TAG_P;
                    strArr2[6] = "Kr6mbDoiLKwWSgNyXDF2oJW";
                    if (rect.right != Integer.MIN_VALUE && c1965cM.A02.bottom != Integer.MIN_VALUE) {
                        return c1965cM.A02;
                    }
                }
                throw new IllegalStateException(A02(0, 143, 38));
            }

            private C1965cM A01(C1978ca c1978ca, Rect rect, Rect rect2) {
                C1965cM c1965cMA03 = this.A06.get(c1978ca.A04);
                if (this.A04.A06(c1978ca)) {
                    if (c1965cMA03 == null) {
                        c1965cMA03 = C1965cM.A03(this.A00);
                        this.A06.put(c1978ca.A04, c1965cMA03);
                    } else {
                        c1965cMA03.A01 = EnumC1969cQ.A04;
                    }
                }
                c1965cMA03.A02.set(rect2);
                c1965cMA03.A03.add(new Rect(rect));
                return c1965cMA03;
            }

            public static String A02(int i11, int i12, int i13) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(A09, i11, i11 + i12);
                for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
                    bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 91);
                }
                return new String(bArrCopyOfRange);
            }

            public static void A03() {
                A09 = new byte[]{41, Ascii.NAK, Ascii.DC4, Ascii.SO, 93, Ascii.VT, Ascii.DC4, Ascii.CAN, 10, Ascii.CR, Ascii.DC2, Ascii.DC4, 19, 9, 93, Ascii.NAK, Ascii.FS, Ascii.SO, 93, 19, Ascii.DC2, 9, 93, Ascii.US, Ascii.CAN, Ascii.CAN, 19, 93, Ascii.DLE, Ascii.CAN, Ascii.FS, Ascii.SO, 8, Ascii.SI, Ascii.CAN, Ascii.EM, 93, Ascii.DC2, Ascii.SI, 93, Ascii.DC4, Ascii.SO, 93, Ascii.FS, 93, Ascii.SUB, Ascii.SI, Ascii.DC2, 8, Ascii.CR, 93, 10, Ascii.NAK, Ascii.DC4, Ascii.RS, Ascii.NAK, 93, 10, Ascii.DC4, 17, 17, 93, 19, Ascii.CAN, Ascii.VT, Ascii.CAN, Ascii.SI, 93, Ascii.SI, Ascii.CAN, 9, 8, Ascii.SI, 19, 93, Ascii.FS, 93, Ascii.DLE, Ascii.CAN, Ascii.FS, Ascii.SO, 8, Ascii.SI, Ascii.CAN, Ascii.DLE, Ascii.CAN, 19, 9, 93, Ascii.SO, Ascii.DC4, 19, Ascii.RS, Ascii.CAN, 93, Ascii.DC4, 9, 90, Ascii.SO, 93, Ascii.DLE, Ascii.FS, Ascii.EM, Ascii.CAN, 93, 8, Ascii.CR, 93, Ascii.DC2, Ascii.ESC, 93, Ascii.SO, 8, Ascii.US, Ascii.VT, Ascii.DC4, Ascii.CAN, 10, Ascii.SO, 93, 9, Ascii.NAK, Ascii.FS, 9, 93, Ascii.RS, Ascii.DC2, 8, 17, Ascii.EM, 93, Ascii.US, Ascii.CAN, 93, Ascii.DC2, Ascii.ESC, Ascii.ESC, Ascii.SO, Ascii.RS, Ascii.SI, Ascii.CAN, Ascii.CAN, 19, 118, 125, 111, 75, 123, 121, 118, Utf8.REPLACEMENT_BYTE, 36, 61, 61, 113, 39, 56, 52, 38, 113, 33, 35, 62, 33, 52, 35, 37, 40, 113, 55, 62, 35, 113, 35, 52, 60, 62, 39, 52, 53, 113, 56, 37, 52, 60, 113, 125, 97, 104, 122, 92, 107, 126, 97, 124, 122};
            }

            private void A04(C1966cN c1966cN) {
                for (C1978ca c1978ca : c1966cN.A01()) {
                    C1965cM c1965cM = this.A06.get(c1978ca.A04);
                    if (c1965cM != null) {
                        c1965cM.A01 = EnumC1969cQ.A03;
                        c1965cM.A03.clear();
                        c1978ca.A03(this);
                        if (this.A08) {
                            Map<String, C1965cM> map = this.A06;
                            String[] strArr = A0A;
                            if (strArr[0].charAt(8) == strArr[2].charAt(8)) {
                                throw new RuntimeException();
                            }
                            String[] strArr2 = A0A;
                            strArr2[0] = "dCpYPRypiVOHB4OlkAqBqk8EySqTLE1k";
                            strArr2[2] = "r3sjB169HJX8vOmMpko73ANLsggTEmi2";
                            map.remove(c1965cM);
                        } else {
                            continue;
                        }
                    } else if (0 != 0) {
                        String str = A02(150, 36, 10) + c1978ca.A04;
                        throw new NullPointerException(A02(186, 10, 85));
                    }
                }
            }

            private void A05(C1966cN c1966cN) {
                Iterator it = c1966cN.A00().iterator();
                while (it.hasNext()) {
                    ((C1978ca) it.next()).A03(this);
                }
            }

            @Override // com.facebook.ads.redexgen.uinode.HB
            public final void A3V(C1978ca c1978ca, Rect rect, Rect rect2) {
                A01(c1978ca, rect, rect2);
                C1978ca c1978ca2 = c1978ca.A01;
                if (c1978ca2 != C1978ca.A08) {
                    boolean zA06 = this.A03.A06(c1978ca2);
                    C1965cM c1965cMA03 = this.A06.get(c1978ca2.A04);
                    if (zA06) {
                        if (c1965cMA03 != null) {
                            c1965cMA03.A03.clear();
                            if (!this.A07 || c1978ca2.A04()) {
                                c1965cMA03.A01 = EnumC1969cQ.A04;
                            }
                        } else {
                            c1965cMA03 = C1965cM.A03(this.A00);
                            c1965cMA03.A02.set(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
                            this.A06.put(c1978ca2.A04, c1965cMA03);
                        }
                    }
                    c1965cMA03.A03.add(new Rect(rect));
                }
            }

            @Override // com.facebook.ads.redexgen.uinode.HB
            public final void A41(long j11, List<Rect> list) {
                this.A00 = j11;
                this.A05.clear();
                Iterator<Rect> it = list.iterator();
                while (it.hasNext()) {
                    this.A05.add(new Rect(it.next()));
                }
                Iterator it2 = this.A04.A01().iterator();
                while (it2.hasNext()) {
                    this.A06.remove(((C1978ca) it2.next()).A04);
                }
                Iterator it3 = this.A03.A01().iterator();
                while (it3.hasNext()) {
                    this.A06.remove(((C1978ca) it3.next()).A04);
                }
                Iterator<C1965cM> it4 = this.A06.values().iterator();
                while (it4.hasNext()) {
                    it4.next().A03.clear();
                }
                this.A04.A04();
                this.A03.A04();
            }

            @Override // com.facebook.ads.redexgen.uinode.HB
            public final void A5Z() {
                A05(this.A04);
                A04(this.A04);
                A05(this.A03);
                A04(this.A03);
                if (0 != 0) {
                    new C1964cL(toString(), this, this.A05, this.A04.A00(), this.A03.A00());
                    throw new NullPointerException(A02(143, 7, 67));
                }
            }

            @Override // com.facebook.ads.redexgen.uinode.InterfaceC1968cP
            public final void A78(C1978ca c1978ca, Rect rect) {
                rect.setEmpty();
                Iterator it = this.A06.get(c1978ca.A04).A03.iterator();
                while (it.hasNext()) {
                    rect.union((Rect) it.next());
                }
            }

            @Override // com.facebook.ads.redexgen.uinode.InterfaceC1968cP
            public final EnumC1969cQ A8J(C1978ca c1978ca) {
                return this.A06.get(c1978ca.A04).A01;
            }

            @Override // com.facebook.ads.redexgen.uinode.InterfaceC1968cP
            public final void A8L(Rect rect) {
                rect.setEmpty();
                Iterator<Rect> it = this.A05.iterator();
                while (it.hasNext()) {
                    rect.union(it.next());
                }
            }

            @Override // com.facebook.ads.redexgen.uinode.InterfaceC1968cP
            public final float A8M(C1978ca c1978ca) {
                C1965cM c1965cM = this.A06.get(c1978ca.A04);
                if (c1965cM == null) {
                    return 0.0f;
                }
                Rect rectA00 = A00(c1965cM);
                int iHeight = rectA00.height() * rectA00.width();
                int iHeight2 = 0;
                for (Rect rect : c1965cM.A03) {
                    iHeight2 += rect.height() * rect.width();
                }
                return iHeight2 / iHeight;
            }

            @Override // com.facebook.ads.redexgen.uinode.HB
            public final void AGH(cX cXVar) {
                this.A01 = cXVar;
            }
        });
    }
}
