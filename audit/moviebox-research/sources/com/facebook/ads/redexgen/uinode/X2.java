package com.facebook.ads.redexgen.uinode;

import android.util.Pair;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class X2 implements InterfaceC1259Cy {
    public static byte[] A0D;
    public static final double[] A0E;
    public long A00;
    public long A01;
    public long A02;
    public long A03;
    public long A04;
    public C4 A05;
    public String A06;
    public boolean A07;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public final boolean[] A0C = new boolean[4];
    public final Cz A0B = new Cz(128);

    static {
        A02();
        A0E = new double[]{23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    }

    public static Pair<Format, Long> A00(Cz cz2, String str) {
        byte[] bArrCopyOf = Arrays.copyOf(cz2.A02, cz2.A00);
        int i11 = bArrCopyOf[4] & 255;
        int i12 = bArrCopyOf[5] & 255;
        int i13 = (i11 << 4) | (i12 >> 4);
        int i14 = ((i12 & 15) << 8) | (bArrCopyOf[6] & 255);
        float f11 = 1.0f;
        switch ((bArrCopyOf[7] & 240) >> 4) {
            case 2:
                f11 = (i14 * 4) / (i13 * 3);
                break;
            case 3:
                f11 = (i14 * 16) / (i13 * 9);
                break;
            case 4:
                f11 = (i14 * 121) / (i13 * 100);
                break;
        }
        Format formatA03 = Format.A03(str, A01(0, 11, 121), null, -1, -1, i13, i14, -1.0f, Collections.singletonList(bArrCopyOf), -1, f11, null);
        long j11 = 0;
        int i15 = (bArrCopyOf[7] & Ascii.SI) - 1;
        if (i15 >= 0) {
            double[] dArr = A0E;
            if (i15 < dArr.length) {
                double d11 = dArr[i15];
                int i16 = cz2.A01;
                int i17 = (bArrCopyOf[i16 + 9] & 96) >> 5;
                int i18 = bArrCopyOf[i16 + 9] & Ascii.US;
                if (i17 != i18) {
                    d11 *= (((double) i17) + 1.0d) / ((double) (i18 + 1));
                }
                j11 = (long) (1000000.0d / d11);
            }
        }
        return Pair.create(formatA03, Long.valueOf(j11));
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0D, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 8);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A0D = new byte[]{7, Ascii.CAN, Ascii.NAK, Ascii.DC4, Ascii.RS, 94, Ascii.FS, 1, Ascii.DC4, Ascii.SYN, 67};
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1259Cy
    public final void A4R(C1376Hz c1376Hz) {
        int iA06 = c1376Hz.A06();
        int iA07 = c1376Hz.A07();
        byte[] bArr = c1376Hz.A00;
        this.A04 += (long) c1376Hz.A04();
        this.A05.AFR(c1376Hz, c1376Hz.A04());
        while (true) {
            int iA04 = AbstractC1372Hv.A04(bArr, iA06, iA07, this.A0C);
            if (iA04 == iA07) {
                break;
            }
            int i11 = c1376Hz.A00[iA04 + 3] & 255;
            if (!this.A07) {
                int i12 = iA04 - iA06;
                if (i12 > 0) {
                    this.A0B.A01(bArr, iA06, iA04);
                }
                if (this.A0B.A02(i11, i12 < 0 ? -i12 : 0)) {
                    Pair<Format, Long> pairA00 = A00(this.A0B, this.A06);
                    this.A05.A5n((Format) pairA00.first);
                    this.A00 = ((Long) pairA00.second).longValue();
                    this.A07 = true;
                }
            }
            if (i11 == 0 || i11 == 179) {
                int i13 = iA07 - iA04;
                if (this.A0A && this.A08 && this.A07) {
                    this.A05.AFS(this.A03, this.A09 ? 1 : 0, ((int) (this.A04 - this.A02)) - i13, i13, null);
                }
                boolean z11 = this.A0A;
                if (!z11 || this.A08) {
                    this.A02 = this.A04 - ((long) i13);
                    long j11 = this.A01;
                    if (j11 == C.TIME_UNSET) {
                        j11 = z11 ? this.A03 + this.A00 : 0L;
                    }
                    this.A03 = j11;
                    this.A09 = false;
                    this.A01 = C.TIME_UNSET;
                    this.A0A = true;
                }
                this.A08 = i11 == 0;
            } else if (i11 == 184) {
                this.A09 = true;
            }
            iA06 = iA04 + 3;
        }
        if (this.A07) {
            return;
        }
        this.A0B.A01(bArr, iA06, iA07);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1259Cy
    public final void A4p(InterfaceC1235Bu interfaceC1235Bu, DC dc2) {
        dc2.A05();
        this.A06 = dc2.A04();
        this.A05 = interfaceC1235Bu.AGi(dc2.A03(), 2);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1259Cy
    public final void ADs() {
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1259Cy
    public final void ADt(long j11, boolean z11) {
        this.A01 = j11;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1259Cy
    public final void AFg() {
        AbstractC1372Hv.A0B(this.A0C);
        this.A0B.A00();
        this.A04 = 0L;
        this.A0A = false;
    }
}
