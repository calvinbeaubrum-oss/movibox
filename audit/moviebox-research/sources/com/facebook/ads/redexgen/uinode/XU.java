package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.Metadata;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class XU implements InterfaceC1233Bs {
    public static byte[] A0E;
    public static String[] A0F = {"FKupPKXcsIkycQ3l5ptAH5wluEqc6YoI", "RW", "ogqWAOna8QODFLIqijT7vOYnhApvYyU7", "UAOUtvFDqNmRNLgZ1GU6DrNnbPesxUgh", "z4WGtVpeHmr0jWMfeyoB2cmDzFByDj9w", "gdGWUcFUabEj8aTRXEAi5amp", "tmhvTid", "WDNv6R6VbALBmvSk6DCmHF7NFi0i9puO"};
    public static final InterfaceC1236Bv A0G;
    public static final int A0H;
    public static final int A0I;
    public static final int A0J;
    public int A00;
    public int A01;
    public long A02;
    public long A03;
    public InterfaceC1235Bu A04;
    public C4 A05;
    public XV A06;
    public Metadata A07;
    public final int A08;
    public final long A09;
    public final C1237Bw A0A;
    public final Bx A0B;
    public final By A0C;
    public final C1376Hz A0D;

    static {
        A05();
        A0G = new XW();
        A0J = IF.A08(A04(32, 4, 37));
        A0H = IF.A08(A04(0, 4, 58));
        A0I = IF.A08(A04(28, 4, 24));
    }

    public XU() {
        this(0);
    }

    public XU(int i11) {
        this(i11, C.TIME_UNSET);
    }

    public XU(int i11, long j11) {
        this.A08 = i11;
        this.A09 = j11;
        this.A0D = new C1376Hz(10);
        this.A0C = new By();
        this.A0A = new C1237Bw();
        this.A02 = C.TIME_UNSET;
        this.A0B = new Bx();
    }

    private int A00(InterfaceC1234Bt interfaceC1234Bt) throws InterruptedException, IOException {
        if (this.A00 == 0) {
            interfaceC1234Bt.AFM();
            if (!interfaceC1234Bt.ADw(this.A0D.A00, 0, 4, true)) {
                return -1;
            }
            this.A0D.A0Y(0);
            int iA08 = this.A0D.A08();
            if (!A06(iA08, this.A01) || By.A00(iA08) == -1) {
                interfaceC1234Bt.AGP(1);
                this.A01 = 0;
                return 0;
            }
            By.A04(iA08, this.A0C);
            if (this.A02 == C.TIME_UNSET) {
                XV xv2 = this.A06;
                long jA7i = interfaceC1234Bt.A7i();
                if (A0F[0].charAt(7) == '2') {
                    throw new RuntimeException();
                }
                A0F[5] = "uwsYCHPiCgNXlhDD9rc7dT19";
                this.A02 = xv2.A88(jA7i);
                if (this.A09 != C.TIME_UNSET) {
                    this.A02 += this.A09 - this.A06.A88(0L);
                }
            }
            this.A00 = this.A0C.A02;
        }
        int iAFQ = this.A05.AFQ(interfaceC1234Bt, this.A00, true);
        if (iAFQ == -1) {
            return -1;
        }
        int i11 = this.A00 - iAFQ;
        this.A00 = i11;
        if (i11 > 0) {
            return 0;
        }
        this.A05.AFS(this.A02 + ((this.A03 * 1000000) / ((long) this.A0C.A03)), 1, this.A0C.A02, 0, null);
        this.A03 += (long) this.A0C.A04;
        this.A00 = 0;
        return 0;
    }

    public static int A01(C1376Hz c1376Hz, int i11) {
        if (c1376Hz.A07() >= i11 + 4) {
            c1376Hz.A0Y(i11);
            int iA08 = c1376Hz.A08();
            String[] strArr = A0F;
            if (strArr[4].charAt(21) == strArr[3].charAt(21)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0F;
            strArr2[4] = "RZ9mFeyNnV0sPgPCsPCuasZg37Uzdp17";
            strArr2[3] = "fK9CAyTZYj28knSP6u8xHPIK1qnXYcxa";
            if (iA08 == A0J || iA08 == A0H) {
                return iA08;
            }
        }
        if (c1376Hz.A07() < 40) {
            return 0;
        }
        c1376Hz.A0Y(36);
        int iA09 = c1376Hz.A08();
        int i12 = A0I;
        if (iA09 == i12) {
            return i12;
        }
        return 0;
    }

    private EE A02(InterfaceC1234Bt interfaceC1234Bt) throws InterruptedException, IOException {
        interfaceC1234Bt.ADv(this.A0D.A00, 0, 4);
        this.A0D.A0Y(0);
        By.A04(this.A0D.A08(), this.A0C);
        return new EE(interfaceC1234Bt.A7I(), interfaceC1234Bt.A7i(), this.A0C);
    }

    private XV A03(InterfaceC1234Bt interfaceC1234Bt) throws InterruptedException, IOException {
        C1376Hz c1376Hz = new C1376Hz(this.A0C.A02);
        interfaceC1234Bt.ADv(c1376Hz.A00, 0, this.A0C.A02);
        int i11 = 21;
        if ((this.A0C.A05 & 1) != 0) {
            int i12 = this.A0C.A01;
            if (A0F[5].length() != 24) {
                throw new RuntimeException();
            }
            String[] strArr = A0F;
            strArr[6] = "1a7oiXE";
            strArr[1] = "rh";
            if (i12 != 1) {
                i11 = 36;
            }
        } else if (this.A0C.A01 == 1) {
            i11 = 13;
        }
        int iA01 = A01(c1376Hz, i11);
        if (iA01 != A0J && iA01 != A0H) {
            if (iA01 != A0I) {
                interfaceC1234Bt.AFM();
                return null;
            }
            EC ecA00 = EC.A00(interfaceC1234Bt.A7I(), interfaceC1234Bt.A7i(), this.A0C, c1376Hz);
            interfaceC1234Bt.AGP(this.A0C.A02);
            return ecA00;
        }
        E4 e4A01 = E4.A01(interfaceC1234Bt.A7I(), interfaceC1234Bt.A7i(), this.A0C, c1376Hz);
        if (e4A01 != null && !this.A0A.A03()) {
            interfaceC1234Bt.AFM();
            interfaceC1234Bt.A3W(i11 + 141);
            interfaceC1234Bt.ADv(this.A0D.A00, 0, 3);
            this.A0D.A0Y(0);
            this.A0A.A04(this.A0D.A0G());
        }
        interfaceC1234Bt.AGP(this.A0C.A02);
        return (e4A01 == null || e4A01.A9I() || iA01 != A0H) ? e4A01 : A02(interfaceC1234Bt);
    }

    public static String A04(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0E, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 31);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A0E = new byte[]{-94, -57, -65, -56, -110, -92, -96, -79, -94, -89, -92, -93, 95, -77, -82, -82, 95, -84, -96, -83, -72, 95, -95, -72, -77, -92, -78, 109, -115, 121, -119, -128, -100, -83, -78, -85};
    }

    public static boolean A06(int i11, long j11) {
        return ((long) ((-128000) & i11)) == ((-128000) & j11);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x007a  */
    /* JADX WARN: Code duplicated, block: B:27:0x0090  */
    /* JADX WARN: Code duplicated, block: B:30:0x009f  */
    /* JADX WARN: Code duplicated, block: B:33:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:35:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:36:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:39:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:41:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:43:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:56:0x0105  */
    /* JADX WARN: Code duplicated, block: B:58:0x0112 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:60:0x0115  */
    /* JADX WARN: Code duplicated, block: B:69:0x009d A[EDGE_INSN: B:69:0x009d->B:29:0x009d BREAK  A[LOOP:0: B:22:0x0074->B:76:0x0074], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:0x009d A[EDGE_INSN: B:72:0x009d->B:29:0x009d BREAK  A[LOOP:0: B:22:0x0074->B:76:0x0074], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:0x009d A[EDGE_INSN: B:75:0x009d->B:29:0x009d BREAK  A[LOOP:0: B:22:0x0074->B:76:0x0074], SYNTHETIC] */
    private boolean A07(InterfaceC1234Bt interfaceC1234Bt, boolean z11) throws InterruptedException, IOException {
        byte[] bArr;
        boolean z12;
        String[] strArr;
        String[] strArr2;
        int iA08;
        int iA00;
        int i11 = 0;
        int i12 = 0;
        int iA7d = 0;
        int i13 = 0;
        int i14 = z11 ? 16384 : 131072;
        interfaceC1234Bt.AFM();
        if (interfaceC1234Bt.A7i() == 0) {
            int i15 = this.A08;
            String[] strArr3 = A0F;
            if (strArr3[4].charAt(21) != strArr3[3].charAt(21)) {
                String[] strArr4 = A0F;
                strArr4[6] = "aodgJ9F";
                strArr4[1] = "Mh";
                Metadata metadataA00 = this.A0B.A00(interfaceC1234Bt, (i15 & 2) != 0 ? C1237Bw.A04 : null);
                this.A07 = metadataA00;
                if (metadataA00 != null) {
                    C1237Bw c1237Bw = this.A0A;
                    if (A0F[5].length() != 24) {
                        String[] strArr5 = A0F;
                        strArr5[2] = "kwUpXSrSJ0NLH72x1DIQc8Fq054MCj03";
                        strArr5[7] = "uritoxjB27zl8eiC6KQaQvgdEg1vP6Ps";
                        c1237Bw.A05(metadataA00);
                    } else {
                        A0F[0] = "W2SW3glva3ohlkheP4GgDHO6E3mNlxjo";
                        c1237Bw.A05(metadataA00);
                    }
                }
                iA7d = (int) interfaceC1234Bt.A7d();
                if (!z11) {
                    interfaceC1234Bt.AGP(iA7d);
                }
                while (true) {
                    bArr = this.A0D.A00;
                    if (i11 > 0) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    strArr = A0F;
                    if (strArr[4].charAt(21) != strArr[3].charAt(21)) {
                        A0F[0] = "F41ajW8QxYjYysO7QQhMOwz5jLXMzQYc";
                        if (!interfaceC1234Bt.ADw(bArr, 0, 4, z12)) {
                            break;
                        }
                        this.A0D.A0Y(0);
                        iA08 = this.A0D.A08();
                        if ((i12 != 0 || A06(iA08, i12)) && (iA00 = By.A00(iA08)) != -1) {
                            i11++;
                            if (i11 != 1) {
                                if (i11 == 4) {
                                    break;
                                }
                            } else {
                                By.A04(iA08, this.A0C);
                                i12 = iA08;
                            }
                            interfaceC1234Bt.A3W(iA00 - 4);
                        } else {
                            int i16 = i13 + 1;
                            if (i13 == i14) {
                                if (z11) {
                                    return false;
                                }
                                throw new C11849v(A04(4, 24, 32));
                            }
                            i11 = 0;
                            i12 = 0;
                            if (z11) {
                                interfaceC1234Bt.AFM();
                                interfaceC1234Bt.A3W(iA7d + i16);
                            } else {
                                interfaceC1234Bt.AGP(1);
                            }
                            i13 = i16;
                        }
                    } else {
                        if (!interfaceC1234Bt.ADw(bArr, 0, 4, z12)) {
                            break;
                        }
                        this.A0D.A0Y(0);
                        iA08 = this.A0D.A08();
                        if (i12 != 0) {
                            i11++;
                            if (i11 != 1) {
                                if (i11 == 4) {
                                    break;
                                    break;
                                }
                            } else {
                                By.A04(iA08, this.A0C);
                                i12 = iA08;
                            }
                            interfaceC1234Bt.A3W(iA00 - 4);
                        } else {
                            i11++;
                            if (i11 != 1) {
                                if (i11 == 4) {
                                    break;
                                    break;
                                }
                            } else {
                                By.A04(iA08, this.A0C);
                                i12 = iA08;
                            }
                            interfaceC1234Bt.A3W(iA00 - 4);
                        }
                    }
                }
                if (z11) {
                    interfaceC1234Bt.AGP(iA7d + i13);
                } else {
                    interfaceC1234Bt.AFM();
                }
                this.A01 = i12;
                strArr2 = A0F;
                if (strArr2[2].charAt(28) != strArr2[7].charAt(28)) {
                    A0F[0] = "JRrUIGwZBJczcB1fqhgNVGoVSbza2n0c";
                    return true;
                }
            }
        } else {
            while (true) {
                bArr = this.A0D.A00;
                if (i11 > 0) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                strArr = A0F;
                if (strArr[4].charAt(21) != strArr[3].charAt(21)) {
                    A0F[0] = "F41ajW8QxYjYysO7QQhMOwz5jLXMzQYc";
                    if (!interfaceC1234Bt.ADw(bArr, 0, 4, z12)) {
                        break;
                        break;
                    }
                    this.A0D.A0Y(0);
                    iA08 = this.A0D.A08();
                    if (i12 != 0) {
                        i11++;
                        if (i11 != 1) {
                            if (i11 == 4) {
                                break;
                                break;
                            }
                        } else {
                            By.A04(iA08, this.A0C);
                            i12 = iA08;
                        }
                        interfaceC1234Bt.A3W(iA00 - 4);
                    } else {
                        i11++;
                        if (i11 != 1) {
                            if (i11 == 4) {
                                break;
                                break;
                            }
                        } else {
                            By.A04(iA08, this.A0C);
                            i12 = iA08;
                        }
                        interfaceC1234Bt.A3W(iA00 - 4);
                    }
                } else {
                    if (!interfaceC1234Bt.ADw(bArr, 0, 4, z12)) {
                        break;
                        break;
                    }
                    this.A0D.A0Y(0);
                    iA08 = this.A0D.A08();
                    if (i12 != 0) {
                        i11++;
                        if (i11 != 1) {
                            if (i11 == 4) {
                                break;
                                break;
                            }
                        } else {
                            By.A04(iA08, this.A0C);
                            i12 = iA08;
                        }
                        interfaceC1234Bt.A3W(iA00 - 4);
                    } else {
                        i11++;
                        if (i11 != 1) {
                            if (i11 == 4) {
                                break;
                                break;
                            }
                        } else {
                            By.A04(iA08, this.A0C);
                            i12 = iA08;
                        }
                        interfaceC1234Bt.A3W(iA00 - 4);
                    }
                }
            }
            if (z11) {
                interfaceC1234Bt.AGP(iA7d + i13);
            } else {
                interfaceC1234Bt.AFM();
            }
            this.A01 = i12;
            strArr2 = A0F;
            if (strArr2[2].charAt(28) != strArr2[7].charAt(28)) {
                A0F[0] = "JRrUIGwZBJczcB1fqhgNVGoVSbza2n0c";
                return true;
            }
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1233Bs
    public final void A8o(InterfaceC1235Bu interfaceC1235Bu) {
        this.A04 = interfaceC1235Bu;
        this.A05 = interfaceC1235Bu.AGi(0, 1);
        this.A04.A5Y();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1233Bs
    public final int AEH(InterfaceC1234Bt interfaceC1234Bt, C1238Bz c1238Bz) throws InterruptedException, IOException {
        if (this.A01 == 0) {
            try {
                A07(interfaceC1234Bt, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.A06 == null) {
            XV xvA03 = A03(interfaceC1234Bt);
            this.A06 = xvA03;
            if (xvA03 == null || (!xvA03.A9I() && (this.A08 & 1) != 0)) {
                this.A06 = A02(interfaceC1234Bt);
            }
            this.A04.AFi(this.A06);
            this.A05.A5n(Format.A05(null, this.A0C.A06, null, -1, 4096, this.A0C.A01, this.A0C.A03, -1, this.A0A.A00, this.A0A.A01, null, null, 0, null, (this.A08 & 2) != 0 ? null : this.A07));
        }
        return A00(interfaceC1234Bt);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1233Bs
    public final void AFh(long j11, long j12) {
        this.A01 = 0;
        this.A02 = C.TIME_UNSET;
        this.A03 = 0L;
        this.A00 = 0;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1233Bs
    public final boolean AGR(InterfaceC1234Bt interfaceC1234Bt) throws InterruptedException, IOException {
        return A07(interfaceC1234Bt, true);
    }
}
