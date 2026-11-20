package com.facebook.ads.redexgen.uinode;

import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Wz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1755Wz implements InterfaceC1259Cy {
    public static byte[] A06;
    public static String[] A07 = {"3GVDuA8wFVUyMgpUpbIewfrR9H99KrEk", "JlICi14zqaUcthBIG11pWTw91wh2yVCw", "SCc1nWfYKQsHAUfYf8T5wZndFViKre8j", "glAeXwJzdtWksZ9B0aFClAzpFAfPstjY", "", "MoUOfVVsEVomZ5Pq9PB", "UtG2kZW99inEJ5Gw9pPEuhVI3SuCWANI", "WpnQHVSEOc3lam6iocwMhSGypVEKzNDF"};
    public int A00;
    public int A01;
    public long A02;
    public C4 A03;
    public boolean A04;
    public final C1376Hz A05 = new C1376Hz(10);

    static {
        A01();
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i11, i11 + i12);
        int i14 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A07[3].charAt(3) == 'p') {
                throw new RuntimeException();
            }
            A07[3] = "8BWuaIrledIbOr1Vvmzlm7GxjPqtlOKX";
            if (i14 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 54);
            i14++;
        }
    }

    public static void A01() {
        A06 = new byte[]{121, 84, 78, 94, 92, 79, 89, 84, 83, 90, Ascii.GS, 84, 83, 75, 92, 81, 84, 89, Ascii.GS, 116, 121, Ascii.SO, Ascii.GS, 73, 92, 90, Ascii.SYN, 59, 108, Ascii.CR, 58, 62, 59, 58, 45, 43, 58, 58, 38, 35, 41, 43, 62, 35, 37, 36, 101, 35, 46, 121};
    }

    /* JADX WARN: Code duplicated, block: B:21:0x009e  */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0078, code lost:
    
        if (51 != r7) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00af, code lost:
    
        if (51 != r7) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b8, code lost:
    
        r8.A05.A0Z(3);
        r8.A01 = r8.A05.A0D() + 10;
     */
    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1259Cy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A4R(C1376Hz c1376Hz) {
        if (this.A04) {
            int iA04 = c1376Hz.A04();
            int i11 = this.A00;
            if (i11 < 10) {
                int iMin = Math.min(iA04, 10 - i11);
                System.arraycopy(c1376Hz.A00, c1376Hz.A06(), this.A05.A00, this.A00, iMin);
                if (this.A00 + iMin == 10) {
                    this.A05.A0Y(0);
                    if (73 == this.A05.A0E()) {
                        int iA0E = this.A05.A0E();
                        if (A07[5].length() != 16) {
                            String[] strArr = A07;
                            strArr[0] = "eZdoRYLyKv4toCemxkiKJA2d6NIzFwiE";
                            strArr[1] = "sPPG97pGznW8OkCUNxQD0xF7olrTR4ou";
                            if (68 == iA0E) {
                                int iA0E2 = this.A05.A0E();
                                if (A07[5].length() != 16) {
                                    A07[3] = "eu3l96gSDWZf4lrXAqzHcIk6PJ9QX6gD";
                                } else {
                                    A07[3] = "3RA5HWh0kmfEwFj0aBurDCdRc5WBxEPn";
                                }
                            }
                            Log.w(A00(26, 9, 105), A00(0, 26, 11));
                            if (A07[3].charAt(3) != 'p') {
                                A07[6] = "G5eroEsu98sAd5xO02g5FkX9fDMbEAxT";
                                this.A04 = false;
                                return;
                            }
                        }
                    } else {
                        Log.w(A00(26, 9, 105), A00(0, 26, 11));
                        if (A07[3].charAt(3) != 'p') {
                            A07[6] = "G5eroEsu98sAd5xO02g5FkX9fDMbEAxT";
                            this.A04 = false;
                            return;
                        }
                    }
                    throw new RuntimeException();
                }
            }
            int iMin2 = Math.min(iA04, this.A01 - this.A00);
            this.A03.AFR(c1376Hz, iMin2);
            this.A00 += iMin2;
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1259Cy
    public final void A4p(InterfaceC1235Bu interfaceC1235Bu, DC dc2) {
        dc2.A05();
        C4 c4AGi = interfaceC1235Bu.AGi(dc2.A03(), 4);
        this.A03 = c4AGi;
        c4AGi.A5n(Format.A0B(dc2.A04(), A00(35, 15, 124), null, -1, null));
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1259Cy
    public final void ADs() {
        int i11;
        if (this.A04 && (i11 = this.A01) != 0 && this.A00 == i11) {
            this.A03.AFS(this.A02, 1, i11, 0, null);
            this.A04 = false;
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1259Cy
    public final void ADt(long j11, boolean z11) {
        if (z11) {
            this.A04 = true;
            this.A02 = j11;
            this.A01 = 0;
            this.A00 = 0;
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1259Cy
    public final void AFg() {
        this.A04 = false;
    }
}
