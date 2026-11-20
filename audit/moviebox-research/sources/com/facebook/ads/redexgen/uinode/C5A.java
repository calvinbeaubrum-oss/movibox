package com.facebook.ads.redexgen.uinode;

import androidx.core.view.InputDeviceCompat;
import androidx.core.view.MotionEventCompat;
import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.tn.lib.view.FlowLayout;
import com.transsion.gslb.Worker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5A, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C5A extends AbstractC1231Bq {
    public static byte[] A0C;
    public static String[] A0D = {"", "UOqHcTLtEs7RiTmy1QusyMeFEB23VRO4", "RTk1kBX5PmCwF3vSKDHM5RpxSToEVllh", "JV0f3puRHBuDT0TwlUq0wFp", "x2su64Hvd39hRMCT3aa5nJ2s0reV8jFq", "Uq5EuILG8kpYquwld9Hd2RiG7wrTKtDW", "n7d5UKOeFpSokQbO2p0B5", "QmvZ7EzKQdyrN87iPZyE0qt0G2nn9i3V"};
    public static final int[] A0E;
    public static final int[] A0F;
    public static final int[] A0G;
    public static final int[] A0H;
    public static final int[] A0I;
    public static final int[] A0J;
    public static final int[] A0K;
    public byte A00;
    public byte A01;
    public int A02;
    public int A03;
    public List<C1314Fn> A05;
    public List<C1314Fn> A06;
    public boolean A07;
    public final int A08;
    public final int A09;
    public final C1376Hz A0A = new C1376Hz();
    public final ArrayList<C1321Fu> A0B = new ArrayList<>();
    public C1321Fu A04 = new C1321Fu(0, 4);

    static {
        A07();
        A0G = new int[]{11, 1, 3, 12, 14, 5, 7, 9};
        A0F = new int[]{0, 4, 8, 12, 16, 20, 24, 28};
        A0K = new int[]{-1, -16711936, -16776961, -16711681, FlowLayout.SPACING_AUTO, InputDeviceCompat.SOURCE_ANY, -65281};
        A0E = new int[]{32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, Worker.WHAT_SYNC_DATA, 104, 105, 106, 107, 108, 109, Worker.WHAT_QUIT, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632};
        A0H = new int[]{174, 176, PsExtractor.PRIVATE_STREAM_1, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251};
        A0I = new int[]{193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, PsExtractor.AUDIO_STREAM, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187};
        A0J = new int[]{195, 227, 205, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, WebSocketProtocol.PAYLOAD_SHORT, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};
    }

    public C5A(String str, int i11) {
        this.A08 = A04(0, 25, 86).equals(str) ? 2 : 3;
        switch (i11) {
            case 3:
            case 4:
                this.A09 = 2;
                break;
            default:
                this.A09 = 1;
                break;
        }
        A0B(0);
        A06();
    }

    public static char A00(byte b11) {
        return (char) A0E[(b11 & Ascii.DEL) - 32];
    }

    public static char A01(byte b11) {
        return (char) A0I[b11 & Ascii.US];
    }

    public static char A02(byte b11) {
        return (char) A0J[b11 & Ascii.US];
    }

    public static char A03(byte b11) {
        return (char) A0H[b11 & Ascii.SI];
    }

    public static String A04(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0C, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 55);
        }
        return new String(bArrCopyOfRange);
    }

    private List<C1314Fn> A05() {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < this.A0B.size(); i11++) {
            C1314Fn c1314FnA05 = this.A0B.get(i11).A05();
            if (c1314FnA05 != null) {
                arrayList.add(c1314FnA05);
            }
        }
        return arrayList;
    }

    private void A06() {
        this.A04.A09(this.A02);
        this.A0B.clear();
        this.A0B.add(this.A04);
    }

    public static void A07() {
        byte[] bArr = {-18, -3, -3, -7, -10, -16, -18, 1, -10, -4, -5, -68, 5, -70, -6, -3, -63, -70, -16, -14, -18, -70, -61, -67, -59};
        if (A0D[3].length() == 21) {
            throw new RuntimeException();
        }
        A0D[5] = "Dii1DZOZQfkEzXA6fYCCVz7kQ8ZnR11r";
        A0C = bArr;
    }

    private void A08(byte b11) {
        this.A04.A08(' ');
        this.A04.A0E((b11 >> 1) & 7, (b11 & 1) == 1);
    }

    private void A09(byte b11) {
        switch (b11) {
            case 32:
                A0B(2);
                return;
            case 33:
            case 34:
            case 35:
            case 36:
            case 40:
            default:
                int i11 = this.A02;
                if (i11 == 0) {
                    return;
                }
                switch (b11) {
                    case 33:
                        this.A04.A06();
                        return;
                    case 36:
                    default:
                        return;
                    case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                        this.A05 = null;
                        if (i11 == 1 || i11 == 3) {
                            A06();
                            return;
                        }
                        return;
                    case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                        if (i11 != 1 || this.A04.A0F()) {
                            return;
                        }
                        this.A04.A07();
                        return;
                    case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                        A06();
                        return;
                    case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                        this.A05 = A05();
                        A06();
                        return;
                }
            case 37:
                A0B(1);
                A0C(2);
                return;
            case 38:
                A0B(1);
                String[] strArr = A0D;
                if (strArr[7].charAt(23) != strArr[1].charAt(23)) {
                    A0D[3] = "7AFdC54jnBMcb1fQALYn1FmxfK";
                    A0C(3);
                    return;
                } else {
                    String[] strArr2 = A0D;
                    strArr2[6] = "j0BFBVzEby1MIwgBQMEQk";
                    strArr2[0] = "";
                    A0C(3);
                    return;
                }
            case 39:
                A0B(1);
                A0C(4);
                return;
            case 41:
                A0B(3);
                if (A0D[5].charAt(21) == 'k') {
                    throw new RuntimeException();
                }
                A0D[3] = "pIRkBqgh";
                return;
        }
    }

    private void A0A(byte b11, byte b12) {
        int i11 = A0G[b11 & 7];
        if ((b12 & 32) != 0) {
            i11++;
        }
        if (i11 != this.A04.A04()) {
            if (this.A02 != 1 && !this.A04.A0F()) {
                C1321Fu c1321Fu = new C1321Fu(this.A02, this.A03);
                this.A04 = c1321Fu;
                this.A0B.add(c1321Fu);
            }
            this.A04.A0C(i11);
        }
        boolean z11 = (b12 & Ascii.DLE) == 16;
        int i12 = (b12 >> 1) & 7;
        this.A04.A0E(z11 ? 8 : i12, (b12 & 1) == 1);
        if (z11) {
            this.A04.A0B(A0F[i12]);
        }
    }

    private void A0B(int i11) {
        if (this.A02 == i11) {
            return;
        }
        int i12 = this.A02;
        this.A02 = i11;
        A06();
        String[] strArr = A0D;
        if (strArr[6].length() == strArr[0].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0D;
        strArr2[7] = "ABJBOr9tpuOfw3WTn1dkaeDCVhgUjFFd";
        strArr2[1] = "d4G6TzBMILcpXDpqIyaB8VlXWHVbvB7r";
        if (i12 == 3 || i11 == 1 || i11 == 0) {
            this.A05 = null;
        }
    }

    private void A0C(int i11) {
        this.A03 = i11;
        this.A04.A0A(i11);
    }

    public static boolean A0D(byte b11) {
        return (b11 & 240) == 16;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x007d  */
    private boolean A0E(byte b11, byte b12) {
        boolean zA0D = A0D(b11);
        if (zA0D) {
            if (this.A07 && this.A00 == b11 && this.A01 == b12) {
                this.A07 = false;
                if (A0D[3].length() == 21) {
                    throw new RuntimeException();
                }
                String[] strArr = A0D;
                strArr[7] = "tLHt8UhnxX3deh7O9w8vVVmAo0sQxALm";
                strArr[1] = "EbP4Ke60ENtBy2kbmKo88ltRhFojrrj9";
                return true;
            }
            this.A07 = true;
            this.A00 = b11;
            this.A01 = b12;
        }
        if (A0F(b11, b12)) {
            A08(b12);
        } else if (A0H(b11, b12)) {
            A0A(b11, b12);
        } else if (A0I(b11, b12)) {
            this.A04.A0D(b12 - 32);
        } else {
            boolean zA0G = A0G(b11, b12);
            String[] strArr2 = A0D;
            if (strArr2[6].length() != strArr2[0].length()) {
                A0D[5] = "swbvKOmcGgaLmVTPPwnrE4ARixZyKCFo";
                if (zA0G) {
                    A09(b12);
                }
            } else {
                String[] strArr3 = A0D;
                strArr3[7] = "bB00fVvIMETGp28QmAgSrtQi1elcPeSe";
                strArr3[1] = "LRx4WR8VImivhrBFvPxZGhVFm5yp8QMB";
                if (zA0G) {
                    A09(b12);
                }
            }
        }
        return zA0D;
    }

    public static boolean A0F(byte b11, byte b12) {
        return (b11 & 247) == 17 && (b12 & 240) == 32;
    }

    public static boolean A0G(byte b11, byte b12) {
        return (b11 & 247) == 20 && (b12 & 240) == 32;
    }

    public static boolean A0H(byte b11, byte b12) {
        return (b11 & 240) == 16 && (b12 & 192) == 64;
    }

    public static boolean A0I(byte b11, byte b12) {
        return (b11 & 247) == 23 && b12 >= 33 && b12 <= 35;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1231Bq
    /* JADX INFO: renamed from: A0L */
    public final /* bridge */ /* synthetic */ C5 A54() throws C1316Fp {
        return super.A54();
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1231Bq
    /* JADX INFO: renamed from: A0M */
    public final /* bridge */ /* synthetic */ AbstractC1232Br A55() throws C1316Fp {
        return super.A55();
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1231Bq
    public final WI A0N() {
        List<C1314Fn> list = this.A05;
        this.A06 = list;
        return new WI(list);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1231Bq
    /* JADX INFO: renamed from: A0O */
    public final /* bridge */ /* synthetic */ void AEG(C5 c11) throws C1316Fp {
        super.AEG(c11);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1231Bq
    public final void A0P(C5 c11) {
        int i11;
        this.A0A.A0b(c11.A01.array(), c11.A01.limit());
        boolean z11 = false;
        boolean zA0E = false;
        while (true) {
            int iA04 = this.A0A.A04();
            int i12 = this.A08;
            if (iA04 < i12) {
                if (z11) {
                    if (!zA0E) {
                        this.A07 = false;
                    }
                    int i13 = this.A02;
                    if (i13 == 1 || i13 == 3) {
                        this.A05 = A05();
                        return;
                    }
                    return;
                }
                return;
            }
            byte bA0E = i12 == 2 ? (byte) -4 : (byte) this.A0A.A0E();
            byte bA0E2 = (byte) (this.A0A.A0E() & 127);
            byte bA0E3 = (byte) (this.A0A.A0E() & 127);
            if ((bA0E & 6) == 4 && ((i11 = this.A09) != 1 || (bA0E & 1) == 0)) {
                if (i11 != 2 || (bA0E & 1) == 1) {
                    if (bA0E2 != 0 || bA0E3 != 0) {
                        z11 = true;
                        if ((bA0E2 & 247) == 17) {
                            int i14 = bA0E3 & 240;
                            if (A0D[3].length() != 21) {
                                A0D[5] = "eaZSvvtKQ377g5qz65V0guECH3aHDc35";
                                if (i14 == 48) {
                                    this.A04.A08(A03(bA0E3));
                                }
                            }
                            throw new RuntimeException();
                        }
                        if ((bA0E2 & 246) == 18 && (bA0E3 & 224) == 32) {
                            C1321Fu c1321Fu = this.A04;
                            if (A0D[3].length() == 21) {
                                throw new RuntimeException();
                            }
                            String[] strArr = A0D;
                            strArr[6] = "seUeLqtTdSBoap5Vmsj4c";
                            strArr[0] = "";
                            c1321Fu.A06();
                            if ((bA0E2 & 1) == 0) {
                                this.A04.A08(A01(bA0E3));
                            } else {
                                this.A04.A08(A02(bA0E3));
                            }
                        } else if ((bA0E2 & 224) == 0) {
                            zA0E = A0E(bA0E2, bA0E3);
                        } else {
                            this.A04.A08(A00(bA0E2));
                            if ((bA0E3 & 224) != 0) {
                                this.A04.A08(A00(bA0E3));
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1231Bq
    public final boolean A0R() {
        return this.A05 != this.A06;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1231Bq, com.facebook.ads.redexgen.uinode.BB
    public final void AEV() {
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1231Bq, com.facebook.ads.redexgen.uinode.WL
    public final /* bridge */ /* synthetic */ void AGB(long j11) {
        super.AGB(j11);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1231Bq, com.facebook.ads.redexgen.uinode.BB
    public final void flush() {
        super.flush();
        this.A05 = null;
        this.A06 = null;
        A0B(0);
        A0C(4);
        A06();
        this.A07 = false;
        this.A00 = (byte) 0;
        this.A01 = (byte) 0;
    }
}
