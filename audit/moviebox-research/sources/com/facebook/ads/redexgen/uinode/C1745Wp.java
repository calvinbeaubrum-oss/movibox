package com.facebook.ads.redexgen.uinode;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Wp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1745Wp implements D6 {
    public static String[] A05 = {"ZoOhGYHP8SNfCMTpI8hB8esJvCxQNk4a", "iCY0vtQk2BMTn8YKksXnllwhxYcEMWPa", "FRJmrfeKqiG8dvU06WzW6", "wyGcQq4l", "", "l2", "ODNaIWitniiqKmZchEPotBtPtmPon6SS", "r1S7VBlY5d2QYAsiLWImTDUS2fBhu4wR"};
    public final int A00;
    public final /* synthetic */ C1744Wo A04;
    public final C1375Hy A03 = new C1375Hy(new byte[5]);
    public final SparseArray<DD> A01 = new SparseArray<>();
    public final SparseIntArray A02 = new SparseIntArray();

    public C1745Wp(C1744Wo c1744Wo, int i11) {
        this.A04 = c1744Wo;
        this.A00 = i11;
    }

    private DA A00(C1376Hz c1376Hz, int i11) {
        int iA06 = c1376Hz.A06();
        int i12 = iA06 + i11;
        int i13 = -1;
        String strTrim = null;
        ArrayList arrayList = null;
        while (c1376Hz.A06() < i12) {
            int iA0E = c1376Hz.A0E();
            int iA07 = c1376Hz.A06() + c1376Hz.A0E();
            if (iA0E == 5) {
                long jA0M = c1376Hz.A0M();
                if (jA0M == C1744Wo.A0F) {
                    i13 = TsExtractor.TS_STREAM_TYPE_AC3;
                } else {
                    long j11 = C1744Wo.A0G;
                    if (A05[0].charAt(13) == 'l') {
                        throw new RuntimeException();
                    }
                    String[] strArr = A05;
                    strArr[5] = "OX";
                    strArr[4] = "";
                    if (jA0M == j11) {
                        i13 = TsExtractor.TS_STREAM_TYPE_E_AC3;
                    } else if (jA0M == C1744Wo.A0H) {
                        i13 = 36;
                    }
                }
            } else if (iA0E == 106) {
                i13 = TsExtractor.TS_STREAM_TYPE_AC3;
            } else if (iA0E == 122) {
                i13 = TsExtractor.TS_STREAM_TYPE_E_AC3;
            } else if (iA0E == 123) {
                i13 = TsExtractor.TS_STREAM_TYPE_DTS;
            } else if (iA0E == 10) {
                strTrim = c1376Hz.A0S(3).trim();
            } else if (iA0E == 89) {
                i13 = 89;
                arrayList = new ArrayList();
                while (c1376Hz.A06() < iA07) {
                    String strTrim2 = c1376Hz.A0S(3).trim();
                    int iA0E2 = c1376Hz.A0E();
                    byte[] bArr = new byte[4];
                    c1376Hz.A0c(bArr, 0, 4);
                    arrayList.add(new D9(strTrim2, iA0E2, bArr));
                }
            }
            c1376Hz.A0Z(iA07 - c1376Hz.A06());
        }
        c1376Hz.A0Y(i12);
        return new DA(i13, strTrim, arrayList, Arrays.copyOfRange(c1376Hz.A00, iA06, i12));
    }

    @Override // com.facebook.ads.redexgen.uinode.D6
    public final void A4R(C1376Hz c1376Hz) {
        IB ib2;
        DD ddA4j;
        if (c1376Hz.A0E() != 2) {
            return;
        }
        if (this.A04.A05 == 1 || this.A04.A05 == 2 || this.A04.A01 == 1) {
            ib2 = (IB) this.A04.A0B.get(0);
        } else {
            ib2 = new IB(((IB) this.A04.A0B.get(0)).A03());
            this.A04.A0B.add(ib2);
        }
        c1376Hz.A0Z(2);
        int iA0I = c1376Hz.A0I();
        int i11 = 5;
        c1376Hz.A0Z(5);
        c1376Hz.A0a(this.A03, 2);
        int i12 = 4;
        this.A03.A08(4);
        int i13 = 12;
        c1376Hz.A0Z(this.A03.A04(12));
        int i14 = 21;
        if (this.A04.A05 == 2 && this.A04.A03 == null) {
            DA da2 = new DA(21, null, null, new byte[0]);
            C1744Wo c1744Wo = this.A04;
            c1744Wo.A03 = c1744Wo.A09.A4j(21, da2);
            this.A04.A03.A8q(ib2, this.A04.A02, new DC(iA0I, 21, 8192));
        }
        this.A01.clear();
        this.A02.clear();
        int iA04 = c1376Hz.A04();
        while (iA04 > 0) {
            c1376Hz.A0a(this.A03, i11);
            int iA05 = this.A03.A04(8);
            this.A03.A08(3);
            int iA06 = this.A03.A04(13);
            this.A03.A08(i12);
            int iA07 = this.A03.A04(i13);
            DA daA00 = A00(c1376Hz, iA07);
            if (iA05 == 6) {
                iA05 = daA00.A00;
            }
            iA04 -= iA07 + 5;
            int i15 = this.A04.A05 == 2 ? iA05 : iA06;
            if (!this.A04.A07.get(i15)) {
                if (this.A04.A05 == 2 && iA05 == i14) {
                    C1744Wo c1744Wo2 = this.A04;
                    String[] strArr = A05;
                    if (strArr[2].length() == strArr[3].length()) {
                        throw new RuntimeException();
                    }
                    A05[0] = "McoDKrxcl9g055s4tJZatQwjzcY0TxoH";
                    ddA4j = c1744Wo2.A03;
                } else {
                    ddA4j = this.A04.A09.A4j(iA05, daA00);
                }
                if (this.A04.A05 != 2 || iA06 < this.A02.get(i15, 8192)) {
                    this.A02.put(i15, iA06);
                    this.A01.put(i15, ddA4j);
                }
            }
            i11 = 5;
            i12 = 4;
            i13 = 12;
            i14 = 21;
        }
        int size = this.A02.size();
        for (int i16 = 0; i16 < size; i16++) {
            int iKeyAt = this.A02.keyAt(i16);
            this.A04.A07.put(iKeyAt, true);
            DD ddValueAt = this.A01.valueAt(i16);
            if (ddValueAt != null) {
                C1744Wo c1744Wo3 = this.A04;
                String[] strArr2 = A05;
                if (strArr2[5].length() == strArr2[4].length()) {
                    throw new RuntimeException();
                }
                A05[0] = "prZScD3eoAfWT6wNb9RUJeZXyBQ1ma5M";
                if (ddValueAt != c1744Wo3.A03) {
                    ddValueAt.A8q(ib2, this.A04.A02, new DC(iA0I, iKeyAt, 8192));
                }
                this.A04.A06.put(this.A02.valueAt(i16), ddValueAt);
            }
        }
        if (this.A04.A05 == 2) {
            if (this.A04.A04) {
                return;
            }
            this.A04.A02.A5Y();
            this.A04.A01 = 0;
            this.A04.A04 = true;
            return;
        }
        this.A04.A06.remove(this.A00);
        C1744Wo c1744Wo4 = this.A04;
        c1744Wo4.A01 = c1744Wo4.A05 != 1 ? this.A04.A01 - 1 : 0;
        if (this.A04.A01 == 0) {
            this.A04.A02.A5Y();
            this.A04.A04 = true;
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.D6
    public final void A8q(IB ib2, InterfaceC1235Bu interfaceC1235Bu, DC dc2) {
    }
}
