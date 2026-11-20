package com.facebook.ads.redexgen.uinode;

import android.util.Pair;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AH {
    public static String[] A00 = {"PM7DSx0y0lrec1UT4WPnkT9xVE7xO4Q3", "BEgdeY8scYjWDgLVGs4ZUut3Hirr2MX3", "ZAPPhI63uMybzXuqxrZ5dKdt3S18BPE9", "MM2rXOZDxF7k2VlV9Dcr24aSmfbMyxXV", "eywYp4IUfN7s09w4sjk3CdaIEMxiykZ2", "eISkZjTp9yJ8vcJJgc2cD29HnvZjEHrc", "bxIeMq2jLgGDMU", "MX4WpiU2EnoJ87vmil9r758WOfjNIsLN"};
    public static final AH A01 = new Y3();

    public abstract int A00();

    public abstract int A01();

    public int A02(int i11, int i12, boolean z11) {
        switch (i12) {
            case 0:
                if (i11 == A06(z11)) {
                    return -1;
                }
                return i11 + 1;
            case 1:
                return i11;
            case 2:
                return i11 == A06(z11) ? A05(z11) : i11 + 1;
            default:
                throw new IllegalStateException();
        }
    }

    public final int A03(int i11, AF af2, AG ag2, int i12, boolean z11) {
        int i13 = A09(i11, af2).A00;
        if (A0B(i13, ag2).A01 != i11) {
            return i11 + 1;
        }
        int iA02 = A02(i13, i12, z11);
        if (A00[1].charAt(27) != 'r') {
            throw new RuntimeException();
        }
        A00[5] = "vHlQRfGLACzPc9SqhGGMQS9yx8mDrtQw";
        if (iA02 == -1) {
            return -1;
        }
        AG agA0B = A0B(iA02, ag2);
        if (A00[6].length() == 14) {
            A00[5] = "g3EvwHO3x67yk3ScCmOHXM9FC4inpbOU";
            return agA0B.A00;
        }
        String[] strArr = A00;
        strArr[4] = "oJT8BcC7iC9ashzghnGVZpN5rOviRVye";
        strArr[3] = "BXJ5tQfk704SS2XTm0iOlKfvNFhc4WVf";
        return agA0B.A00;
    }

    public abstract int A04(Object obj);

    public int A05(boolean z11) {
        return A0E() ? -1 : 0;
    }

    public int A06(boolean z11) {
        if (A0E()) {
            return -1;
        }
        return A01() - 1;
    }

    public final Pair<Integer, Long> A07(AG ag2, AF af2, int i11, long j11) {
        return A08(ag2, af2, i11, j11, 0L);
    }

    public final Pair<Integer, Long> A08(AG ag2, AF af2, int i11, long j11, long j12) {
        AbstractC1351Ha.A00(i11, 0, A01());
        A0D(i11, ag2, false, j12);
        if (j11 == C.TIME_UNSET) {
            j11 = ag2.A01();
            if (A00[5].charAt(22) != '9') {
                throw new RuntimeException();
            }
            A00[0] = "jYNh2aRlntxjcST03zipQODHWrcZ3Q9N";
            if (j11 == C.TIME_UNSET) {
                return null;
            }
        }
        int i12 = ag2.A00;
        long jA03 = ag2.A03() + j11;
        long jA07 = A09(i12, af2).A07();
        while (jA07 != C.TIME_UNSET && jA03 >= jA07) {
            int i13 = ag2.A01;
            if (A00[1].charAt(27) == 'r') {
                String[] strArr = A00;
                strArr[7] = "IuvzXoPM3cIs3JU7ThgGmV6LQ39mYtz4";
                strArr[2] = "DGRaGmTIVAXEwTC12jYPgBDTgoVWDlIc";
                if (i12 >= i13) {
                    break;
                }
                jA03 -= jA07;
                i12++;
                jA07 = A09(i12, af2).A07();
            } else {
                throw new RuntimeException();
            }
        }
        return Pair.create(Integer.valueOf(i12), Long.valueOf(jA03));
    }

    public final AF A09(int i11, AF af2) {
        return A0A(i11, af2, false);
    }

    public abstract AF A0A(int i11, AF af2, boolean z11);

    public final AG A0B(int i11, AG ag2) {
        return A0C(i11, ag2, false);
    }

    public final AG A0C(int i11, AG ag2, boolean z11) {
        return A0D(i11, ag2, z11, 0L);
    }

    public abstract AG A0D(int i11, AG ag2, boolean z11, long j11);

    public final boolean A0E() {
        return A01() == 0;
    }

    public final boolean A0F(int i11, AF af2, AG ag2, int i12, boolean z11) {
        return A03(i11, af2, ag2, i12, z11) == -1;
    }
}
