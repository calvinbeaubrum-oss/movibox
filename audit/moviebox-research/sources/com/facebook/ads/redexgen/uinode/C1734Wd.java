package com.facebook.ads.redexgen.uinode;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.Metadata;
import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.id3.ApicFrame;
import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.id3.BinaryFrame;
import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.id3.ChapterFrame;
import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.id3.ChapterTocFrame;
import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.id3.CommentFrame;
import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.id3.GeobFrame;
import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.id3.Id3Frame;
import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.id3.PrivFrame;
import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.id3.TextInformationFrame;
import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.id3.UrlLinkFrame;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import okhttp3.internal.ws.WebSocketProtocol;
import okio.Utf8;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Wd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1734Wd implements DW {
    public static byte[] A01;
    public static String[] A02 = {"mDpfQ0Mg1qMGU0sRUyB4w0yHI9AflFxL", "HrWFAZbBmLlJHBGWXoy88PVYdiXTIEfW", "ZQEIpFlmPj9dChjEJf3cuXBCToBvQGIn", "RQPpjxLwn1F2LqLyPS6YhTLdMSPVP9VK", "XPMzSAYF2Koz19PEH34p5", "swwfqTWHhic8XQtgs9vSQ", "6JbQXNgGm6Rlu9UTMBxnLLi5Rd7F6qFb", "jePmV9Iz"};
    public static final int A03;
    public static final InterfaceC1266Di A04;
    public final InterfaceC1266Di A00;

    static {
        A0L();
        A04 = new C1735We();
        A03 = IF.A08(A0I(166, 3, 12));
    }

    public C1734Wd() {
        this(null);
    }

    public C1734Wd(InterfaceC1266Di interfaceC1266Di) {
        this.A00 = interfaceC1266Di;
    }

    public static int A00(int i11) {
        return (i11 == 0 || i11 == 3) ? 1 : 2;
    }

    public static int A01(C1376Hz c1376Hz, int i11) {
        byte[] bArr = c1376Hz.A00;
        for (int iA06 = c1376Hz.A06(); iA06 + 1 < i11; iA06++) {
            if ((bArr[iA06] & 255) == 255 && bArr[iA06 + 1] == 0) {
                int i12 = iA06 + 2;
                int i13 = iA06 + 1;
                int i14 = (i11 - iA06) - 2;
                String[] strArr = A02;
                if (strArr[0].charAt(4) == strArr[6].charAt(4)) {
                    throw new RuntimeException();
                }
                A02[1] = "GmDFLtMXmPbGQOJzrAUGcq8JFdShu0kr";
                System.arraycopy(bArr, i12, bArr, i13, i14);
                i11--;
            }
        }
        return i11;
    }

    public static int A02(byte[] bArr, int i11) {
        while (i11 < bArr.length) {
            if (bArr[i11] == 0) {
                return i11;
            }
            i11++;
        }
        return bArr.length;
    }

    public static int A03(byte[] bArr, int i11, int i12) {
        int iA02 = A02(bArr, i11);
        if (i12 == 0 || i12 == 3) {
            return iA02;
        }
        while (iA02 < bArr.length - 1) {
            if (iA02 % 2 == 0 && bArr[iA02 + 1] == 0) {
                return iA02;
            }
            iA02 = A02(bArr, iA02 + 1);
        }
        return bArr.length;
    }

    public static ApicFrame A04(C1376Hz c1376Hz, int i11, int i12) throws UnsupportedEncodingException {
        int iA02;
        String strA0M;
        int iA0E = c1376Hz.A0E();
        String strA0H = A0H(iA0E);
        byte[] bArr = new byte[i11 - 1];
        c1376Hz.A0c(bArr, 0, i11 - 1);
        String strA0I = A0I(458, 6, 45);
        String strA0I2 = A0I(169, 10, 32);
        if (i12 == 2) {
            iA02 = 2;
            strA0M = strA0I + IF.A0M(new String(bArr, 0, 3, strA0I2));
            if (A0I(474, 9, 58).equals(strA0M)) {
                strA0M = A0I(464, 10, WebSocketProtocol.PAYLOAD_SHORT);
            }
        } else {
            iA02 = A02(bArr, 0);
            strA0M = IF.A0M(new String(bArr, 0, iA02, strA0I2));
            if (strA0M.indexOf(47) == -1) {
                strA0M = strA0I + strA0M;
            }
        }
        int i13 = bArr[iA02 + 1] & 255;
        int i14 = iA02 + 2;
        int iA03 = A03(bArr, i14, iA0E);
        return new ApicFrame(strA0M, new String(bArr, i14, iA03 - i14, strA0H), i13, A0N(bArr, A00(iA0E) + iA03, bArr.length));
    }

    public static BinaryFrame A05(C1376Hz c1376Hz, int i11, String str) {
        byte[] bArr = new byte[i11];
        c1376Hz.A0c(bArr, 0, i11);
        return new BinaryFrame(str, bArr);
    }

    public static ChapterFrame A06(C1376Hz c1376Hz, int i11, int i12, boolean z11, int i13, InterfaceC1266Di interfaceC1266Di) throws UnsupportedEncodingException {
        int iA06 = c1376Hz.A06();
        int iA02 = A02(c1376Hz.A00, iA06);
        String str = new String(c1376Hz.A00, iA06, iA02 - iA06, A0I(169, 10, 32));
        c1376Hz.A0Y(iA02 + 1);
        int iA08 = c1376Hz.A08();
        int iA09 = c1376Hz.A08();
        long jA0M = c1376Hz.A0M();
        if (jA0M == 4294967295L) {
            jA0M = -1;
        }
        long jA0M2 = c1376Hz.A0M();
        if (jA0M2 == 4294967295L) {
            jA0M2 = -1;
        }
        ArrayList arrayList = new ArrayList();
        int i14 = iA06 + i11;
        while (c1376Hz.A06() < i14) {
            Id3Frame id3FrameA0B = A0B(i12, c1376Hz, z11, i13, interfaceC1266Di);
            if (id3FrameA0B != null) {
                arrayList.add(id3FrameA0B);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new ChapterFrame(str, iA08, iA09, jA0M, jA0M2, id3FrameArr);
    }

    public static ChapterTocFrame A07(C1376Hz c1376Hz, int i11, int i12, boolean z11, int i13, InterfaceC1266Di interfaceC1266Di) throws UnsupportedEncodingException {
        int iA06 = c1376Hz.A06();
        int iA02 = A02(c1376Hz.A00, iA06);
        String strA0I = A0I(169, 10, 32);
        String str = new String(c1376Hz.A00, iA06, iA02 - iA06, strA0I);
        c1376Hz.A0Y(iA02 + 1);
        int iA0E = c1376Hz.A0E();
        boolean z12 = (iA0E & 2) != 0;
        boolean z13 = (iA0E & 1) != 0;
        int iA0E2 = c1376Hz.A0E();
        String[] strArr = new String[iA0E2];
        for (int i14 = 0; i14 < iA0E2; i14++) {
            int iA07 = c1376Hz.A06();
            int iA03 = A02(c1376Hz.A00, iA07);
            strArr[i14] = new String(c1376Hz.A00, iA07, iA03 - iA07, strA0I);
            c1376Hz.A0Y(iA03 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i15 = iA06 + i11;
        while (c1376Hz.A06() < i15) {
            String[] strArr2 = A02;
            if (strArr2[4].length() != strArr2[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr3 = A02;
            strArr3[4] = "YQsr0udxa6AlS4ZOrNFlw";
            strArr3[5] = "dBU8ocTiI6WLc8wZTOIXb";
            Id3Frame id3FrameA0B = A0B(i12, c1376Hz, z11, i13, interfaceC1266Di);
            if (id3FrameA0B != null) {
                arrayList.add(id3FrameA0B);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new ChapterTocFrame(str, z12, z13, strArr, id3FrameArr);
    }

    public static CommentFrame A08(C1376Hz c1376Hz, int i11) throws UnsupportedEncodingException {
        if (i11 < 4) {
            return null;
        }
        int iA0E = c1376Hz.A0E();
        String strA0H = A0H(iA0E);
        byte[] bArr = new byte[3];
        c1376Hz.A0c(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        byte[] bArr2 = new byte[i11 - 4];
        c1376Hz.A0c(bArr2, 0, i11 - 4);
        int iA03 = A03(bArr2, 0, iA0E);
        String str2 = new String(bArr2, 0, iA03, strA0H);
        int iA00 = A00(iA0E) + iA03;
        return new CommentFrame(str, str2, A0K(bArr2, iA00, A03(bArr2, iA00, iA0E), strA0H));
    }

    public static GeobFrame A09(C1376Hz c1376Hz, int i11) throws UnsupportedEncodingException {
        int iA0E = c1376Hz.A0E();
        String strA0H = A0H(iA0E);
        byte[] bArr = new byte[i11 - 1];
        c1376Hz.A0c(bArr, 0, i11 - 1);
        int iA02 = A02(bArr, 0);
        String str = new String(bArr, 0, iA02, A0I(169, 10, 32));
        int i12 = iA02 + 1;
        int iA03 = A03(bArr, i12, iA0E);
        String strA0K = A0K(bArr, i12, iA03, strA0H);
        int iA00 = A00(iA0E) + iA03;
        int iA04 = A03(bArr, iA00, iA0E);
        return new GeobFrame(str, strA0K, A0K(bArr, iA00, iA04, strA0H), A0N(bArr, A00(iA0E) + iA04, bArr.length));
    }

    public static Dj A0A(C1376Hz c1376Hz) {
        int iA04 = c1376Hz.A04();
        String strA0I = A0I(179, 10, 19);
        if (iA04 < 10) {
            Log.w(strA0I, A0I(26, 31, 29));
            return null;
        }
        int iA0G = c1376Hz.A0G();
        if (iA0G != A03) {
            Log.w(strA0I, A0I(376, 48, 19) + iA0G);
            return null;
        }
        int iA0E = c1376Hz.A0E();
        c1376Hz.A0Z(1);
        int iA0E2 = c1376Hz.A0E();
        int iA0D = c1376Hz.A0D();
        if (iA0E == 2) {
            if ((iA0E2 & 64) != 0) {
                Log.w(strA0I, A0I(PsExtractor.PRIVATE_STREAM_1, 68, 48));
                return null;
            }
        } else if (iA0E == 3) {
            if ((iA0E2 & 64) != 0) {
                int iA08 = c1376Hz.A08();
                c1376Hz.A0Z(iA08);
                iA0D -= iA08 + 4;
            }
        } else {
            if (iA0E != 4) {
                Log.w(strA0I, A0I(InputDeviceCompat.SOURCE_KEYBOARD, 46, 37) + iA0E);
                return null;
            }
            if ((iA0E2 & 64) != 0) {
                int iA0D2 = c1376Hz.A0D();
                c1376Hz.A0Z(iA0D2 - 4);
                iA0D -= iA0D2;
            }
            if ((iA0E2 & 16) != 0) {
                iA0D -= 10;
            }
        }
        return new Dj(iA0E, iA0E < 4 && (iA0E2 & 128) != 0, iA0D);
    }

    /* JADX WARN: Code duplicated, block: B:119:0x01c1 A[Catch: UnsupportedEncodingException -> 0x02c8, all -> 0x02d9, Merged into TryCatch #1 {all -> 0x02d9, UnsupportedEncodingException -> 0x02c8, blocks: (B:95:0x015f, B:166:0x026b, B:173:0x02c8, B:98:0x0169, B:105:0x017f, B:107:0x0187, B:119:0x01c1, B:128:0x01d9, B:142:0x0219, B:149:0x022a, B:157:0x023d, B:163:0x0254, B:164:0x0261), top: B:183:0x0155 }, TRY_ENTER] */
    /* JADX WARN: Code duplicated, block: B:120:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:122:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:129:0x01df  */
    /* JADX WARN: Code duplicated, block: B:131:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:133:0x0208 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:137:0x020f  */
    /* JADX WARN: Code duplicated, block: B:144:0x0220 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:150:0x022f  */
    /* JADX WARN: Code duplicated, block: B:152:0x0233  */
    /* JADX WARN: Code duplicated, block: B:158:0x024a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:159:0x024c  */
    /* JADX WARN: Code duplicated, block: B:164:0x0261 A[Catch: UnsupportedEncodingException -> 0x02c8, all -> 0x02d9, Merged into TryCatch #1 {all -> 0x02d9, UnsupportedEncodingException -> 0x02c8, blocks: (B:95:0x015f, B:166:0x026b, B:173:0x02c8, B:98:0x0169, B:105:0x017f, B:107:0x0187, B:119:0x01c1, B:128:0x01d9, B:142:0x0219, B:149:0x022a, B:157:0x023d, B:163:0x0254, B:164:0x0261), top: B:183:0x0155 }] */
    public static Id3Frame A0B(int i11, C1376Hz c1376Hz, boolean z11, int i12, InterfaceC1266Di interfaceC1266Di) {
        int iA0H;
        String[] strArr;
        Id3Frame id3FrameA05;
        int iA0E = c1376Hz.A0E();
        int iA0E2 = c1376Hz.A0E();
        int iA0E3 = c1376Hz.A0E();
        int iA0E4 = i11 >= 3 ? c1376Hz.A0E() : 0;
        if (i11 == 4) {
            int iA0H2 = c1376Hz.A0H();
            iA0H = !z11 ? (iA0H2 & 255) | (((iA0H2 >> 8) & 255) << 7) | (((iA0H2 >> 16) & 255) << 14) | (((iA0H2 >> 24) & 255) << 21) : iA0H2;
        } else {
            iA0H = i11 == 3 ? c1376Hz.A0H() : c1376Hz.A0G();
        }
        int iA0I = i11 >= 3 ? c1376Hz.A0I() : 0;
        if (iA0E == 0 && iA0E2 == 0 && iA0E3 == 0 && iA0E4 == 0 && iA0H == 0 && iA0I == 0) {
            c1376Hz.A0Y(c1376Hz.A07());
            return null;
        }
        int iA06 = c1376Hz.A06() + iA0H;
        int iA07 = c1376Hz.A07();
        String strA0I = A0I(179, 10, 19);
        if (iA06 > iA07) {
            Log.w(strA0I, A0I(TsExtractor.TS_STREAM_TYPE_AC3, 37, 64));
            c1376Hz.A0Y(c1376Hz.A07());
            return null;
        }
        if (interfaceC1266Di != null && !interfaceC1266Di.A5a(i11, iA0E, iA0E2, iA0E3, iA0E4)) {
            c1376Hz.A0Y(iA06);
            return null;
        }
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        boolean z15 = false;
        boolean z16 = false;
        if (i11 != 3) {
            if (i11 == 4) {
                z16 = (iA0I & 64) != 0;
                int i13 = iA0I & 8;
                if (A02[7].length() != 9) {
                    A02[1] = "HxLFBObUGoObUPku8sA9h7LrWEHKW34t";
                    z12 = i13 != 0;
                    z13 = (iA0I & 4) != 0;
                    z14 = (iA0I & 2) != 0;
                    z15 = (iA0I & 1) != 0;
                    if (A02[7].length() == 9) {
                        throw new RuntimeException();
                    }
                    A02[1] = "76YFuh7tw8gcxzUEh5emTmdExIUmXPMQ";
                }
            }
            throw new RuntimeException();
        }
        z15 = (iA0I & 128) != 0;
        z13 = (iA0I & 64) != 0;
        z16 = (iA0I & 32) != 0;
        z12 = z15;
        if (z12 || z13) {
            Log.w(strA0I, A0I(303, 50, 77));
            c1376Hz.A0Y(iA06);
            return null;
        }
        if (z16) {
            iA0H--;
            c1376Hz.A0Z(1);
        }
        if (z15) {
            iA0H -= 4;
            c1376Hz.A0Z(4);
        }
        if (z14) {
            iA0H = A01(c1376Hz, iA0H);
        }
        try {
            if (iA0E == 84 && iA0E2 == 88 && iA0E3 == 88 && (i11 == 2 || iA0E4 == 88)) {
                id3FrameA05 = A0D(c1376Hz, iA0H);
            } else if (iA0E == 84) {
                id3FrameA05 = A0E(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
            } else if (iA0E == 87 && iA0E2 == 88 && iA0E3 == 88 && (i11 == 2 || iA0E4 == 88)) {
                id3FrameA05 = A0F(c1376Hz, iA0H);
            } else if (iA0E == 87) {
                id3FrameA05 = A0G(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
            } else if (iA0E == 80 && iA0E2 == 82 && iA0E3 == 73) {
                String[] strArr2 = A02;
                if (strArr2[3].charAt(18) != strArr2[2].charAt(18)) {
                    A02[7] = "TpWBQOHSHz";
                    if (iA0E4 != 86) {
                        if (iA0E == 71) {
                            strArr = A02;
                            if (strArr[3].charAt(18) != strArr[2].charAt(18)) {
                                A02[1] = "1pyFPk3tXqgthrOgLBh9Cc6ujVWwqIgx";
                                if (i11 == 2) {
                                    if (iA0E != 67) {
                                        if (iA0E != 67) {
                                            if (iA0E != 67) {
                                                id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                            } else {
                                                id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                            }
                                        } else if (iA0E != 67) {
                                            id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                        } else {
                                            id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                        }
                                    } else if (iA0E != 67) {
                                        if (iA0E != 67) {
                                            id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                        } else {
                                            id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                        }
                                    } else if (iA0E != 67) {
                                        id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                    } else {
                                        id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                    }
                                } else if (iA0E != 67) {
                                    if (iA0E != 67) {
                                        if (iA0E != 67) {
                                            id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                        } else {
                                            id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                        }
                                    } else if (iA0E != 67) {
                                        id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                    } else {
                                        id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                    }
                                } else if (iA0E != 67) {
                                    if (iA0E != 67) {
                                        id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                    } else {
                                        id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                    }
                                } else if (iA0E != 67) {
                                    id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                } else {
                                    id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                }
                            }
                            throw new RuntimeException();
                        }
                        strArr = A02;
                        if (strArr[3].charAt(18) != strArr[2].charAt(18)) {
                            A02[1] = "1pyFPk3tXqgthrOgLBh9Cc6ujVWwqIgx";
                            if (i11 == 2) {
                                if (iA0E != 67) {
                                    if (iA0E != 67) {
                                        if (iA0E != 67) {
                                            id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                        } else {
                                            id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                        }
                                    } else if (iA0E != 67) {
                                        id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                    } else {
                                        id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                    }
                                } else if (iA0E != 67) {
                                    if (iA0E != 67) {
                                        id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                    } else {
                                        id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                    }
                                } else if (iA0E != 67) {
                                    id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                } else {
                                    id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                }
                            } else if (iA0E != 67) {
                                if (iA0E != 67) {
                                    if (iA0E != 67) {
                                        id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                    } else {
                                        id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                    }
                                } else if (iA0E != 67) {
                                    id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                } else {
                                    id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                }
                            } else if (iA0E != 67) {
                                if (iA0E != 67) {
                                    id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                } else {
                                    id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                }
                            } else if (iA0E != 67) {
                                id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                            } else {
                                id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                            }
                        }
                        throw new RuntimeException();
                    }
                    id3FrameA05 = A0C(c1376Hz, iA0H);
                } else {
                    if (iA0E4 != 86) {
                        if (iA0E == 71) {
                            strArr = A02;
                            if (strArr[3].charAt(18) != strArr[2].charAt(18)) {
                                A02[1] = "1pyFPk3tXqgthrOgLBh9Cc6ujVWwqIgx";
                                if (i11 == 2) {
                                    if (iA0E != 67) {
                                        if (iA0E != 67) {
                                            if (iA0E != 67) {
                                                id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                            } else {
                                                id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                            }
                                        } else if (iA0E != 67) {
                                            id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                        } else {
                                            id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                        }
                                    } else if (iA0E != 67) {
                                        if (iA0E != 67) {
                                            id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                        } else {
                                            id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                        }
                                    } else if (iA0E != 67) {
                                        id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                    } else {
                                        id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                    }
                                } else if (iA0E != 67) {
                                    if (iA0E != 67) {
                                        if (iA0E != 67) {
                                            id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                        } else {
                                            id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                        }
                                    } else if (iA0E != 67) {
                                        id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                    } else {
                                        id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                    }
                                } else if (iA0E != 67) {
                                    if (iA0E != 67) {
                                        id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                    } else {
                                        id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                    }
                                } else if (iA0E != 67) {
                                    id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                } else {
                                    id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                }
                            }
                            throw new RuntimeException();
                        }
                        strArr = A02;
                        if (strArr[3].charAt(18) != strArr[2].charAt(18)) {
                            A02[1] = "1pyFPk3tXqgthrOgLBh9Cc6ujVWwqIgx";
                            if (i11 == 2) {
                                if (iA0E != 67) {
                                    if (iA0E != 67) {
                                        if (iA0E != 67) {
                                            id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                        } else {
                                            id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                        }
                                    } else if (iA0E != 67) {
                                        id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                    } else {
                                        id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                    }
                                } else if (iA0E != 67) {
                                    if (iA0E != 67) {
                                        id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                    } else {
                                        id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                    }
                                } else if (iA0E != 67) {
                                    id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                } else {
                                    id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                }
                            } else if (iA0E != 67) {
                                if (iA0E != 67) {
                                    if (iA0E != 67) {
                                        id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                    } else {
                                        id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                    }
                                } else if (iA0E != 67) {
                                    id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                } else {
                                    id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                }
                            } else if (iA0E != 67) {
                                if (iA0E != 67) {
                                    id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                } else {
                                    id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                                }
                            } else if (iA0E != 67) {
                                id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                            } else {
                                id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                            }
                        }
                        throw new RuntimeException();
                    }
                    id3FrameA05 = A0C(c1376Hz, iA0H);
                }
            } else {
                if (iA0E == 71 || iA0E2 != 69 || iA0E3 != 79 || (iA0E4 != 66 && i11 != 2)) {
                    strArr = A02;
                    if (strArr[3].charAt(18) != strArr[2].charAt(18)) {
                        A02[1] = "1pyFPk3tXqgthrOgLBh9Cc6ujVWwqIgx";
                        if (i11 == 2 ? iA0E == 65 && iA0E2 == 80 && iA0E3 == 73 && iA0E4 == 67 : iA0E == 80 && iA0E2 == 73 && iA0E3 == 67) {
                            id3FrameA05 = A04(c1376Hz, iA0H, i11);
                        } else if (iA0E != 67 && iA0E2 == 79 && iA0E3 == 77 && (iA0E4 == 77 || i11 == 2)) {
                            id3FrameA05 = A08(c1376Hz, iA0H);
                        } else if (iA0E != 67 && iA0E2 == 72 && iA0E3 == 65 && iA0E4 == 80) {
                            id3FrameA05 = A06(c1376Hz, iA0H, i11, z11, i12, interfaceC1266Di);
                        } else if (iA0E != 67 && iA0E2 == 84 && iA0E3 == 79 && iA0E4 == 67) {
                            id3FrameA05 = A07(c1376Hz, iA0H, i11, z11, i12, interfaceC1266Di);
                        } else {
                            id3FrameA05 = A05(c1376Hz, iA0H, A0J(i11, iA0E, iA0E2, iA0E3, iA0E4));
                        }
                    }
                    throw new RuntimeException();
                }
                id3FrameA05 = A09(c1376Hz, iA0H);
            }
            if (id3FrameA05 == null) {
                Log.w(strA0I, A0I(57, 27, 82) + A0J(i11, iA0E, iA0E2, iA0E3, iA0E4) + A0I(14, 12, 119) + iA0H);
            }
            c1376Hz.A0Y(iA06);
            String[] strArr3 = A02;
            if (strArr3[0].charAt(4) == strArr3[6].charAt(4)) {
                throw new RuntimeException();
            }
            String[] strArr4 = A02;
            strArr4[0] = "Dtpy20dKfpjr6GTNw3SVg8ra0l6IUEaG";
            strArr4[6] = "adhGTkdPtMJ1tGydAzIftpfQfU5S2oNR";
            return id3FrameA05;
        } catch (UnsupportedEncodingException unused) {
            Log.w(strA0I, A0I(424, 30, 68));
            return null;
        } finally {
            c1376Hz.A0Y(iA06);
        }
    }

    public static PrivFrame A0C(C1376Hz c1376Hz, int i11) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i11];
        c1376Hz.A0c(bArr, 0, i11);
        int iA02 = A02(bArr, 0);
        return new PrivFrame(new String(bArr, 0, iA02, A0I(169, 10, 32)), A0N(bArr, iA02 + 1, bArr.length));
    }

    public static TextInformationFrame A0D(C1376Hz c1376Hz, int i11) throws UnsupportedEncodingException {
        if (i11 < 1) {
            return null;
        }
        int iA0E = c1376Hz.A0E();
        String strA0H = A0H(iA0E);
        byte[] bArr = new byte[i11 - 1];
        c1376Hz.A0c(bArr, 0, i11 - 1);
        int iA03 = A03(bArr, 0, iA0E);
        String str = new String(bArr, 0, iA03, strA0H);
        int iA00 = A00(iA0E) + iA03;
        return new TextInformationFrame(A0I(353, 4, 104), str, A0K(bArr, iA00, A03(bArr, iA00, iA0E), strA0H));
    }

    public static TextInformationFrame A0E(C1376Hz c1376Hz, int i11, String str) throws UnsupportedEncodingException {
        if (i11 < 1) {
            return null;
        }
        int iA0E = c1376Hz.A0E();
        String strA0H = A0H(iA0E);
        byte[] bArr = new byte[i11 - 1];
        c1376Hz.A0c(bArr, 0, i11 - 1);
        return new TextInformationFrame(str, null, new String(bArr, 0, A03(bArr, 0, iA0E), strA0H));
    }

    public static UrlLinkFrame A0F(C1376Hz c1376Hz, int i11) throws UnsupportedEncodingException {
        if (i11 < 1) {
            return null;
        }
        int iA0E = c1376Hz.A0E();
        String strA0H = A0H(iA0E);
        byte[] bArr = new byte[i11 - 1];
        c1376Hz.A0c(bArr, 0, i11 - 1);
        int iA03 = A03(bArr, 0, iA0E);
        String str = new String(bArr, 0, iA03, strA0H);
        int iA00 = A00(iA0E) + iA03;
        return new UrlLinkFrame(A0I(454, 4, 52), str, A0K(bArr, iA00, A02(bArr, iA00), A0I(169, 10, 32)));
    }

    public static UrlLinkFrame A0G(C1376Hz c1376Hz, int i11, String str) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i11];
        c1376Hz.A0c(bArr, 0, i11);
        return new UrlLinkFrame(str, null, new String(bArr, 0, A02(bArr, 0), A0I(169, 10, 32)));
    }

    public static String A0H(int i11) {
        String strA0I = A0I(169, 10, 32);
        switch (i11) {
            case 0:
                return strA0I;
            case 1:
                return A0I(357, 6, 72);
            case 2:
                return A0I(363, 8, 105);
            case 3:
                String strA0I2 = A0I(371, 5, 97);
                String[] strArr = A02;
                if (strArr[0].charAt(4) == strArr[6].charAt(4)) {
                    throw new RuntimeException();
                }
                A02[7] = "WB3CnC";
                return strA0I2;
            default:
                return strA0I;
        }
    }

    public static String A0I(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 2);
        }
        return new String(bArrCopyOfRange);
    }

    public static String A0J(int i11, int i12, int i13, int i14, int i15) {
        return i11 == 2 ? String.format(Locale.US, A0I(0, 6, 105), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14)) : String.format(Locale.US, A0I(6, 8, 11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14), Integer.valueOf(i15));
    }

    public static String A0K(byte[] bArr, int i11, int i12, String str) throws UnsupportedEncodingException {
        if (i12 > i11 && i12 <= bArr.length) {
            return new String(bArr, i11, i12 - i11, str);
        }
        String[] strArr = A02;
        if (strArr[4].length() != strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[0] = "r4Qi0WBzOYfLLA4UC9s9DAK76ksjAQPp";
        strArr2[6] = "c5jPrSHyFK7RFs6Pjjym9ojkSMFCl1O5";
        return A0I(0, 0, 121);
    }

    public static void A0L() {
        A01 = new byte[]{78, 8, 78, 8, 78, 8, 44, 106, 44, 106, 44, 106, 44, 106, 89, 85, 19, 7, Ascii.DC4, Ascii.CAN, Ascii.DLE, 38, Ascii.FS, Ascii.SI, Ascii.DLE, 72, 91, 126, 107, 126, Utf8.REPLACEMENT_BYTE, 107, 112, 112, Utf8.REPLACEMENT_BYTE, 108, 119, 112, 109, 107, Utf8.REPLACEMENT_BYTE, 107, 112, Utf8.REPLACEMENT_BYTE, 125, 122, Utf8.REPLACEMENT_BYTE, 126, 113, Utf8.REPLACEMENT_BYTE, 86, 91, 44, Utf8.REPLACEMENT_BYTE, 107, 126, 120, Ascii.SYN, 49, 57, 60, 53, 52, 112, 36, Utf8.REPLACEMENT_BYTE, 112, 52, 53, 51, Utf8.REPLACEMENT_BYTE, 52, 53, 112, 54, 34, 49, 61, 53, 106, 112, 57, 52, 109, 119, 80, 88, 93, 84, 85, 17, 69, 94, 17, 71, 80, 93, 88, 85, 80, 69, 84, 17, 120, 117, 2, 17, 69, 80, 86, 17, 70, 88, 69, 89, 17, 92, 80, 91, 94, 67, 103, 84, 67, 66, 88, 94, 95, Ascii.FF, 4, 48, 35, 47, 39, 98, 49, 43, 56, 39, 98, 39, 58, 33, 39, 39, 38, 49, 98, 48, 39, 47, 35, 43, 44, 43, 44, 37, 98, 54, 35, 37, 98, 38, 35, 54, 35, 71, 74, 61, 107, 113, 109, Ascii.SI, Ascii.SUB, Ascii.SUB, Ascii.ETB, Ascii.ESC, Ascii.SI, 19, 88, 117, 34, 85, 116, 114, 126, 117, 116, 99, 97, 89, 91, 66, 66, 87, 86, Ascii.DC2, 123, 118, 1, Ascii.DC2, 70, 83, 85, Ascii.DC2, 69, 91, 70, 90, Ascii.DC2, 95, 83, 88, 93, 64, 100, 87, 64, 65, 91, 93, 92, Ascii.SI, 0, Ascii.DC2, 83, 92, 86, Ascii.DC2, 71, 92, 86, 87, 84, 91, 92, 87, 86, Ascii.DC2, 81, 93, 95, 66, 64, 87, 65, 65, 91, 93, 92, Ascii.DC2, 65, 81, 90, 87, 95, 87, 116, 76, 78, 87, 87, 66, 67, 7, 110, 99, Ascii.DC4, 7, 83, 70, 64, 7, 80, 78, 83, 79, 7, 82, 73, 84, 82, 87, 87, 72, 85, 83, 66, 67, 7, 74, 70, 77, 72, 85, 113, 66, 85, 84, 78, 72, 73, Ascii.SUB, Ascii.FS, 36, 38, Utf8.REPLACEMENT_BYTE, Utf8.REPLACEMENT_BYTE, 38, 33, 40, 111, 58, 33, 60, 58, Utf8.REPLACEMENT_BYTE, Utf8.REPLACEMENT_BYTE, 32, 61, 59, 42, 43, 111, 44, 32, 34, Utf8.REPLACEMENT_BYTE, 61, 42, 60, 60, 42, 43, 111, 32, 61, 111, 42, 33, 44, 61, 54, Utf8.REPLACEMENT_BYTE, 59, 42, 43, 111, 41, 61, 46, 34, 42, 62, 50, 50, 50, Ascii.US, Ascii.RS, Ascii.FF, 103, 123, 124, 62, Utf8.REPLACEMENT_BYTE, 45, 70, 90, 93, 41, 46, 54, 55, 37, 78, 91, 68, Ascii.DEL, 116, 105, 97, 116, 114, 101, 116, 117, 49, 119, 120, 99, 98, 101, 49, 101, 121, 99, 116, 116, 49, 115, 104, 101, 116, 98, 49, 126, 119, 49, 88, 85, 34, 49, 101, 112, 118, 49, 121, 116, 112, 117, 116, 99, 43, 49, 19, 40, 53, 51, 54, 54, 41, 52, 50, 35, 34, 102, 37, 46, 39, 52, 39, 37, 50, 35, 52, 102, 35, 40, 37, 41, 34, 47, 40, 33, 97, 110, 110, 110, 70, 66, 78, 72, 74, 0, Ascii.NAK, 17, Ascii.GS, Ascii.ESC, Ascii.EM, 83, Ascii.SYN, Ascii.FF, Ascii.EM, Ascii.ESC, 81, 85, 89, 95, 93, Ascii.ETB, 82, 72, 95};
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00b1  */
    public static boolean A0M(C1376Hz c1376Hz, int i11, int i12, boolean z11) throws Throwable {
        int iA08;
        long jA0M;
        int iA0I;
        int iA06 = c1376Hz.A06();
        while (true) {
            try {
                if (c1376Hz.A04() < i12) {
                    c1376Hz.A0Y(iA06);
                    return true;
                }
                if (i11 >= 3) {
                    try {
                        iA08 = c1376Hz.A08();
                        jA0M = c1376Hz.A0M();
                        iA0I = c1376Hz.A0I();
                    } catch (Throwable th2) {
                        th = th2;
                        c1376Hz.A0Y(iA06);
                        throw th;
                    }
                } else {
                    iA08 = c1376Hz.A0G();
                    jA0M = c1376Hz.A0G();
                    iA0I = 0;
                }
                if (iA08 == 0 && jA0M == 0 && iA0I == 0) {
                    c1376Hz.A0Y(iA06);
                    return true;
                }
                if (i11 == 4 && !z11) {
                    if ((8421504 & jA0M) != 0) {
                        c1376Hz.A0Y(iA06);
                        return false;
                    }
                    long j11 = (jA0M & 255) | (((jA0M >> 8) & 255) << 7);
                    String[] strArr = A02;
                    if (strArr[4].length() != strArr[5].length()) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A02;
                    strArr2[0] = "WW8harr0n1WVcE671SufvW5i3HFI8G3E";
                    strArr2[6] = "cs8JhXohJ41Zu2keAfctBKv0IiLyHEBA";
                    jA0M = (((jA0M >> 24) & 255) << 21) | j11 | (((jA0M >> 16) & 255) << 14);
                }
                boolean z12 = false;
                boolean z13 = false;
                if (i11 == 4) {
                    z12 = (iA0I & 64) != 0;
                    z13 = (iA0I & 1) != 0;
                } else if (i11 == 3) {
                    z12 = (iA0I & 32) != 0;
                    z13 = (iA0I & 128) != 0;
                }
                int i13 = 0;
                String[] strArr3 = A02;
                if (strArr3[4].length() == strArr3[5].length()) {
                    String[] strArr4 = A02;
                    strArr4[3] = "otGI0hsmNkIa4sbMlKQFq5zev1M8Vgvr";
                    strArr4[2] = "hsxwZKJ37TLGlj6U8xTCexdOCMrqimac";
                    if (z12) {
                        i13 = 0 + 1;
                    }
                } else if (z12) {
                    i13 = 0 + 1;
                }
                if (z13) {
                    i13 += 4;
                }
                if (jA0M < i13) {
                    c1376Hz.A0Y(iA06);
                    return false;
                }
                if (c1376Hz.A04() < jA0M) {
                    c1376Hz.A0Y(iA06);
                    return false;
                }
                c1376Hz.A0Z((int) jA0M);
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    public static byte[] A0N(byte[] bArr, int i11, int i12) {
        return i12 <= i11 ? new byte[0] : Arrays.copyOfRange(bArr, i11, i12);
    }

    public final Metadata A0O(byte[] bArr, int i11) {
        ArrayList arrayList = new ArrayList();
        C1376Hz c1376Hz = new C1376Hz(bArr, i11);
        Dj djA0A = A0A(c1376Hz);
        if (djA0A == null) {
            return null;
        }
        int iA06 = c1376Hz.A06();
        int i12 = djA0A.A01 == 2 ? 6 : 10;
        int iA01 = djA0A.A00;
        if (djA0A.A02) {
            iA01 = A01(c1376Hz, djA0A.A00);
        }
        c1376Hz.A0X(iA06 + iA01);
        boolean z11 = false;
        if (!A0M(c1376Hz, djA0A.A01, i12, false)) {
            if (djA0A.A01 != 4 || !A0M(c1376Hz, 4, i12, true)) {
                Log.w(A0I(179, 10, 19), A0I(84, 45, 51) + djA0A.A01);
                return null;
            }
            z11 = true;
        }
        while (c1376Hz.A04() >= i12) {
            Id3Frame id3FrameA0B = A0B(djA0A.A01, c1376Hz, z11, i12, this.A00);
            if (id3FrameA0B != null) {
                arrayList.add(id3FrameA0B);
            }
        }
        return new Metadata(arrayList);
    }

    @Override // com.facebook.ads.redexgen.uinode.DW
    public final Metadata A51(E3 e11) {
        ByteBuffer byteBuffer = e11.A01;
        return A0O(byteBuffer.array(), byteBuffer.limit());
    }
}
