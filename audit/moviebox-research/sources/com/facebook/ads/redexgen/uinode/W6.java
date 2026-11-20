package com.facebook.ads.redexgen.uinode;

import android.util.Pair;
import com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroup;
import com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroupArray;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class W6 extends AbstractC1335Gj {
    public static String[] A01 = {"JXADnguvwbjBsYgslHoSHgr2xxMnawNn", "", "jNEAQ3UZ70aM1hHDYV2CS20ieNSkmYbb", "bnkACY5tQbsoiCdyBJgaOjSRI0w0kmrQ", "gVGuKveDeddXJzh5PaouiQlIwgfOoZnh", "qzMEUGGJ0FpDLYRljtzJ24rj8XT6rBKz", "LijUR", "ZVB7ZDT4TSe2rtQPBLBW6RwhtV59NTLq"};
    public C1330Ge A00;

    public static int A0Q(AA[] aaArr, TrackGroup trackGroup) throws C11669c {
        int length = aaArr.length;
        int i11 = 0;
        for (int i12 = 0; i12 < aaArr.length; i12++) {
            AA aa2 = aaArr[i12];
            for (int i13 = 0; i13 < trackGroup.A01; i13++) {
                int iAGe = aa2.AGe(trackGroup.A01(i13)) & 7;
                if (iAGe > i11) {
                    length = i12;
                    i11 = iAGe;
                    if (i11 == 4) {
                        return length;
                    }
                }
            }
        }
        return length;
    }

    public static int[] A0R(AA aa2, TrackGroup trackGroup) throws C11669c {
        int[] iArr = new int[trackGroup.A01];
        for (int i11 = 0; i11 < trackGroup.A01; i11++) {
            iArr[i11] = aa2.AGe(trackGroup.A01(i11));
        }
        return iArr;
    }

    public static int[] A0S(AA[] aaArr) throws C11669c {
        int[] iArr = new int[aaArr.length];
        for (int i11 = 0; i11 < iArr.length; i11++) {
            iArr[i11] = aaArr[i11].AGg();
        }
        return iArr;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0067  */
    /* JADX WARN: Code duplicated, block: B:22:0x008d  */
    /* JADX WARN: Code duplicated, block: B:24:0x009d  */
    /* JADX WARN: Code duplicated, block: B:25:0x00a2  */
    @Override // com.facebook.ads.redexgen.uinode.AbstractC1335Gj
    public final C1336Gk A0T(AA[] aaArr, TrackGroupArray trackGroupArray) throws C11669c {
        AA aa2;
        int[] iArrA0R;
        int[] iArr = new int[aaArr.length + 1];
        TrackGroup[][] trackGroupArr = new TrackGroup[aaArr.length + 1][];
        int[][][] iArr2 = new int[aaArr.length + 1][][];
        for (int i11 = 0; i11 < trackGroupArr.length; i11++) {
            trackGroupArr[i11] = new TrackGroup[trackGroupArray.A01];
            iArr2[i11] = new int[trackGroupArray.A01][];
            if (A01[2].charAt(17) != 'V') {
                throw new RuntimeException();
            }
            A01[1] = "";
        }
        int[] iArrA0S = A0S(aaArr);
        for (int i12 = 0; i12 < trackGroupArray.A01; i12++) {
            TrackGroup trackGroupA01 = trackGroupArray.A01(i12);
            int iA0Q = A0Q(aaArr, trackGroupA01);
            int length = aaArr.length;
            if (A01[4].charAt(3) != 'u') {
                A01[6] = "flHuZy9qfiSfYNp536tqdaojA4";
                if (iA0Q == length) {
                    iArrA0R = new int[trackGroupA01.A01];
                } else {
                    aa2 = aaArr[iA0Q];
                    if (A01[4].charAt(3) != 'u') {
                        iArrA0R = A0R(aa2, trackGroupA01);
                    } else {
                        A01[1] = "";
                        iArrA0R = A0R(aa2, trackGroupA01);
                    }
                }
            } else {
                String[] strArr = A01;
                strArr[7] = "D4rc1OneeydPNAn3BWDV4yQ6n9XdhHzA";
                strArr[3] = "1lNTPVAxZlA71NpHB66K3LVNnVnwQcNq";
                if (iA0Q == length) {
                    iArrA0R = new int[trackGroupA01.A01];
                } else {
                    aa2 = aaArr[iA0Q];
                    if (A01[4].charAt(3) != 'u') {
                        iArrA0R = A0R(aa2, trackGroupA01);
                    } else {
                        A01[1] = "";
                        iArrA0R = A0R(aa2, trackGroupA01);
                    }
                }
            }
            int i13 = iArr[iA0Q];
            trackGroupArr[iA0Q][i13] = trackGroupA01;
            iArr2[iA0Q][i13] = iArrA0R;
            iArr[iA0Q] = iArr[iA0Q] + 1;
        }
        TrackGroupArray[] trackGroupArrayArr = new TrackGroupArray[aaArr.length];
        int[] iArr3 = new int[aaArr.length];
        for (int i14 = 0; i14 < aaArr.length; i14++) {
            int i15 = iArr[i14];
            trackGroupArrayArr[i14] = new TrackGroupArray((TrackGroup[]) IF.A0k(trackGroupArr[i14], i15));
            iArr2[i14] = (int[][]) IF.A0k(iArr2[i14], i15);
            iArr3[i14] = aaArr[i14].A8C();
        }
        C1330Ge c1330Ge = new C1330Ge(iArr3, trackGroupArrayArr, iArrA0S, iArr2, new TrackGroupArray((TrackGroup[]) IF.A0k(trackGroupArr[aaArr.length], iArr[aaArr.length])));
        Pair<AB[], InterfaceC1332Gg[]> pairA0V = A0V(c1330Ge, iArr2, iArrA0S);
        return new C1336Gk((AB[]) pairA0V.first, (InterfaceC1332Gg[]) pairA0V.second, c1330Ge);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1335Gj
    public final void A0U(Object obj) {
        this.A00 = (C1330Ge) obj;
    }

    public abstract Pair<AB[], InterfaceC1332Gg[]> A0V(C1330Ge c1330Ge, int[][][] iArr, int[] iArr2) throws C11669c;
}
