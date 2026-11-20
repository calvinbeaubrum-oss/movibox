package com.facebook.ads.redexgen.uinode;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1942bn implements AnonymousClass00 {
    public static byte[] A09;
    public static String[] A0A = {"2hmAfzTadn", "1uDqsMr9wv4o5ZghfCOZg4FuDp7sllqp", "nT1KYDstdBBAZ5nN", "UVqk4rMzzgqbiyaJgpoGMOUy0jQCoEBq", "ewXxsmpHr", "rT44HeCpkJQ", "C3kiv90mrVS0BL1BSM5Dfu9lHf0n3Csl", "grgxNBq6hb"};
    public static final String A0B;
    public final int A00;
    public final int A01;
    public final AnonymousClass08 A02;
    public final C0L A04;
    public final C11237f A05;
    public final boolean A08;
    public final Map<String, File> A06 = Collections.synchronizedMap(new HashMap());
    public final Map<String, Semaphore> A07 = new HashMap();
    public final C0A A03 = new C0A();

    static {
        A04();
        A0B = C1942bn.class.getSimpleName();
    }

    public C1942bn(C11237f c11237f, AnonymousClass08 anonymousClass08, C0L c0l) {
        this.A05 = c11237f;
        this.A08 = anonymousClass08.A02();
        this.A00 = anonymousClass08.A00();
        this.A04 = c0l;
        this.A01 = anonymousClass08.A01();
        this.A02 = anonymousClass08;
    }

    public static C1940bl A00(Context context, String str) throws C0H {
        try {
            InputStream inputStreamOpen = context.getAssets().open(str);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i11 = inputStreamOpen.read(bArr, 0, bArr.length);
                if (i11 == -1) {
                    return new C1940bl(byteArrayOutputStream.toByteArray());
                }
                byteArrayOutputStream.write(bArr, 0, i11);
            }
        } catch (IOException e11) {
            throw new C0H(A03(131, 18, 33), e11);
        }
    }

    public static File A01(Context context) {
        return new File(context.getCacheDir(), A03(318, 15, 10));
    }

    /* JADX WARN: Not initialized variable reg: 10, insn: 0x0106: INVOKE 
  (r9v1 ?? I:com.facebook.ads.redexgen.X.0L)
  (r10 I:java.lang.String)
  (r11 I:int)
  (r12 I:java.lang.String)
  (r13 I:java.lang.Long)
  (r14 I:java.lang.Long)
  (r15 I:com.facebook.ads.redexgen.X.06)
 INTERFACE call: com.facebook.ads.redexgen.X.0L.AEP(java.lang.String, int, java.lang.String, java.lang.Long, java.lang.Long, com.facebook.ads.redexgen.X.06):void A[MD:(java.lang.String, int, java.lang.String, java.lang.Long, java.lang.Long, com.facebook.ads.redexgen.X.06):void (m)], block:B:40:0x00fb */
    /* JADX WARN: Not initialized variable reg: 10, insn: 0x0120: INVOKE 
  (r9v0 ?? I:com.facebook.ads.redexgen.X.0L)
  (r10 I:java.lang.String)
  (r11 I:int)
  (r12 I:java.lang.String)
  (r13 I:java.lang.Long)
  (r14 I:java.lang.Long)
  (r15 I:com.facebook.ads.redexgen.X.06)
 INTERFACE call: com.facebook.ads.redexgen.X.0L.AEP(java.lang.String, int, java.lang.String, java.lang.Long, java.lang.Long, com.facebook.ads.redexgen.X.06):void A[MD:(java.lang.String, int, java.lang.String, java.lang.Long, java.lang.Long, com.facebook.ads.redexgen.X.06):void (m)], block:B:46:0x0115 */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0105: MOVE (r15 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:40:0x00fb */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x011f: MOVE (r15 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:46:0x0115 */
    private File A02(AnonymousClass06 anonymousClass06, String str, String str2, int i11, AnonymousClass09 anonymousClass09) throws Throwable {
        AnonymousClass06 anonymousClass07;
        String strAEP;
        AnonymousClass06 anonymousClass08;
        String strAEP2;
        C1938bj c1938bj;
        String strA03 = A03(222, 22, 68);
        try {
            String str3 = str;
            long jCurrentTimeMillis = System.currentTimeMillis();
            File file = new File(A01(this.A05), str2);
            C1938bj c1938bj2 = new C1938bj(file, new GG(C1384Ih.A0N(this.A05)));
            if (c1938bj2.A09()) {
                if (this.A08) {
                    String str4 = A03(49, 22, 106) + c1938bj2.A00.getName();
                }
                this.A06.put(str3, file);
                c1938bj2.A06();
                this.A04.AEQ(str3, true, anonymousClass06);
                return file;
            }
            if (this.A08) {
                String str5 = A03(71, 26, 117) + c1938bj2.A00.getName();
            }
            if (!anonymousClass09.A04()) {
                return null;
            }
            this.A04.AEQ(str3, false, anonymousClass06);
            int i12 = 0;
            while (i12 < this.A00) {
                try {
                    str3 = str3;
                    c1938bj = c1938bj2;
                    try {
                        A05(this.A05, c1938bj2, str3, i11, i12, jCurrentTimeMillis);
                        int iA03 = c1938bj.A03();
                        c1938bj.A06();
                        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                        anonymousClass09.A00().A4U(file, this.A04);
                        this.A06.put(str3, file);
                        this.A04.AEP(str3, 2112, null, Long.valueOf(iA03), Long.valueOf(jCurrentTimeMillis2), anonymousClass06);
                        return file;
                    } catch (C0H e11) {
                        e = e11;
                        if (i12 == this.A00 - 1) {
                            A06(c1938bj);
                            if (e instanceof C1939bk) {
                                throw ((C1939bk) e);
                            }
                            if (e instanceof C1936bh) {
                                throw ((C1936bh) e);
                            }
                        }
                        i12++;
                        c1938bj2 = c1938bj;
                    }
                } catch (C0H e12) {
                    e = e12;
                    c1938bj = c1938bj2;
                }
            }
            c1938bj = c1938bj2;
            int iA04 = c1938bj.A03();
            c1938bj.A06();
            long jCurrentTimeMillis3 = System.currentTimeMillis() - jCurrentTimeMillis;
            anonymousClass09.A00().A4U(file, this.A04);
            this.A06.put(str3, file);
            this.A04.AEP(str3, 2112, null, Long.valueOf(iA04), Long.valueOf(jCurrentTimeMillis3), anonymousClass06);
            return file;
        } catch (C1936bh e13) {
            this.A04.AEP(strAEP2, 2113, e13.toString(), null, null, anonymousClass08);
            if (!this.A08) {
                return null;
            }
            Log.e(A0B, strA03, e13);
            return null;
        } catch (C1939bk e14) {
            this.A04.AEP(strAEP, 2119, e14.toString(), null, null, anonymousClass07);
            if (!this.A08) {
                return null;
            }
            Log.e(A0B, strA03, e14);
            return null;
        }
    }

    public static String A03(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A09, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            int i15 = bArrCopyOfRange[i14] - i13;
            String[] strArr = A0A;
            if (strArr[5].length() == strArr[7].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0A;
            strArr2[5] = "m9U6X0moZlc";
            strArr2[7] = "IfCNkNm6kG";
            bArrCopyOfRange[i14] = (byte) (i15 - 76);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A09 = new byte[]{-105, -33, -40, -22, -105, -39, -36, -36, -27, -105, -32, -27, -21, -36, -23, -23, -20, -25, -21, -36, -37, -91, -63, -75, -5, -2, 1, -6, -75, -8, 1, -6, -10, 3, -6, -7, -49, -75, -125, 117, -106, -55, -55, -70, -62, -59, -55, -113, 117, -7, Ascii.ETB, Ascii.EM, Ascii.RS, Ascii.US, 36, Ascii.GS, -42, Ascii.FS, Ascii.US, 34, Ascii.ESC, -42, Ascii.EM, 37, 35, 38, 34, Ascii.ESC, 42, Ascii.ESC, -42, 4, 34, 36, 41, 42, 47, 40, -31, 39, 42, 45, 38, -31, 47, 48, 53, -31, 36, 48, 46, 49, 45, 38, 53, 38, -31, -91, -61, -59, -54, -53, -48, -55, -126, -47, -56, -126, -32, -2, Ascii.VT, -60, 17, -67, 0, 9, Ascii.FF, Ascii.DLE, 2, -67, 0, -2, 0, 5, 2, -67, 3, 6, 9, 2, -53, -80, -50, -37, -108, -31, -115, -33, -46, -50, -47, -115, -50, -32, -32, -46, -31, -32, -101, -69, -39, -26, -97, -20, -104, -22, -35, -39, -36, -104, -28, -35, -26, -33, -20, -32, -104, -25, -34, -104, -72, -39, -32, -39, -24, -35, -30, -37, -108, -41, -43, -41, -36, -39, -108, -38, -35, -32, -39, -108, -43, -38, -24, -39, -26, -108, -39, -20, -41, -39, -39, -40, -35, -30, -37, -108, -26, -39, -24, -26, -19, -108, -43, -24, -24, -39, -31, -28, -24, -25, -82, -108, -43, 2, 2, -1, 2, -80, -13, -15, -13, -8, -7, -2, -9, -80, 4, -8, -11, -80, -10, -7, -4, -11, -54, -9, -9, -12, -9, -91, -24, -15, -22, -26, -13, -18, -13, -20, -91, -21, -18, -15, -22, -72, -27, -27, -30, -27, -109, -42, -33, -30, -26, -36, -31, -38, -109, -26, -30, -24, -27, -42, -40, -72, -35, -46, -34, -36, -33, -37, -44, -29, -44, -113, -31, -44, -30, -33, -34, -35, -30, -44, -99, -65, -35, -28, -44, -39, -46, -117, -33, -38, -117, -35, -48, -52, -49, -117, -73, -70, -60, -51, -125, -68, -65, -62, -69, -125, -71, -73, -71, -66, -69, -18, 0, 0, -14, 1, -57, -68, -68, -68, 5, 8, Ascii.VT, 4, -39, -50, -50, -50, 0, Ascii.CR, 3, 17, Ascii.SO, 8, 3, -2, 0, Ascii.DC2, Ascii.DC2, 4, 19, -50};
        String[] strArr = A0A;
        if (strArr[1].charAt(5) == strArr[3].charAt(5)) {
            throw new RuntimeException();
        }
        A0A[6] = "1YrvosXM8zHw8wsMUb3ulJ8Xgx5scBHO";
    }

    /* JADX WARN: Code duplicated, block: B:106:0x023c  */
    /* JADX WARN: Code duplicated, block: B:112:0x01a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:20:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:22:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:24:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:27:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:28:0x00bd A[Catch: all -> 0x0124, 0H -> 0x016b, TRY_ENTER, TryCatch #14 {0H -> 0x016b, blocks: (B:12:0x007c, B:38:0x0109, B:44:0x011c, B:36:0x0103, B:28:0x00bd, B:30:0x00c5), top: B:115:0x007c }] */
    /* JADX WARN: Code duplicated, block: B:30:0x00c5 A[Catch: all -> 0x0124, 0H -> 0x016b, TryCatch #14 {0H -> 0x016b, blocks: (B:12:0x007c, B:38:0x0109, B:44:0x011c, B:36:0x0103, B:28:0x00bd, B:30:0x00c5), top: B:115:0x007c }] */
    /* JADX WARN: Code duplicated, block: B:33:0x00f5 A[Catch: all -> 0x0166, 0H -> 0x0169, TRY_ENTER, TryCatch #11 {0H -> 0x0169, blocks: (B:9:0x0051, B:17:0x008c, B:42:0x0116, B:47:0x0127, B:39:0x010d, B:41:0x0113, B:33:0x00f5, B:34:0x00fc), top: B:121:0x0051 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x0103 A[Catch: all -> 0x0124, 0H -> 0x016b, LOOP:0: B:34:0x00fc->B:36:0x0103, LOOP_END, TRY_ENTER, TryCatch #14 {0H -> 0x016b, blocks: (B:12:0x007c, B:38:0x0109, B:44:0x011c, B:36:0x0103, B:28:0x00bd, B:30:0x00c5), top: B:115:0x007c }] */
    /* JADX WARN: Code duplicated, block: B:38:0x0109 A[ADDED_TO_REGION, Catch: all -> 0x0124, 0H -> 0x016b, REMOVE, TRY_LEAVE, TryCatch #14 {0H -> 0x016b, blocks: (B:12:0x007c, B:38:0x0109, B:44:0x011c, B:36:0x0103, B:28:0x00bd, B:30:0x00c5), top: B:115:0x007c }] */
    /* JADX WARN: Code duplicated, block: B:39:0x010d A[Catch: all -> 0x0166, 0H -> 0x0169, TRY_ENTER, TryCatch #11 {0H -> 0x0169, blocks: (B:9:0x0051, B:17:0x008c, B:42:0x0116, B:47:0x0127, B:39:0x010d, B:41:0x0113, B:33:0x00f5, B:34:0x00fc), top: B:121:0x0051 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x011c A[Catch: all -> 0x0124, 0H -> 0x016b, TRY_ENTER, TRY_LEAVE, TryCatch #14 {0H -> 0x016b, blocks: (B:12:0x007c, B:38:0x0109, B:44:0x011c, B:36:0x0103, B:28:0x00bd, B:30:0x00c5), top: B:115:0x007c }] */
    /* JADX WARN: Code duplicated, block: B:70:0x017f  */
    /* JADX WARN: Code duplicated, block: B:73:0x019a  */
    /* JADX WARN: Code duplicated, block: B:86:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:87:0x01fe  */
    private void A05(Context context, C1938bj c1938bj, String str, int i11, int i12, long j11) throws Throwable {
        C0K c0kA00;
        String[] strArr;
        String[] strArr2;
        String[] strArr3;
        int iA03;
        int length;
        boolean z11;
        boolean zA07;
        byte[] bArr;
        int i13;
        String strA03 = A03(263, 20, 39);
        String strA04 = A03(342, 22, 83);
        if (str.startsWith(strA04)) {
            c0kA00 = A00(context, str.substring(strA04.length()));
        } else {
            String strA05 = A03(333, 9, 65);
            c0kA00 = str.startsWith(strA05) ? A00(context, str.substring(strA05.length())) : new C1937bi(str, i11);
        }
        try {
            if (!this.A08) {
                iA03 = c1938bj.A03();
                length = c0kA00.length();
                if (A0A[2].length() != 16) {
                    throw new RuntimeException();
                }
                String[] strArr4 = A0A;
                strArr4[1] = "eTbeym3Ey2TfwhNFyBG6ZkfAKtzQxWab";
                strArr4[3] = "sd4JUTjhNLXLgefrlj4RQDt9w4Pjz5Uj";
                if (length < 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    zA07 = A07(c1938bj);
                    if (this.A08) {
                        String str2 = A03(149, 21, 44) + str + A03(22, 16, 73) + zA07;
                    }
                }
                if (z11) {
                    c0kA00.ADm(iA03);
                    bArr = new byte[8192];
                    while (true) {
                        i13 = c0kA00.read(bArr);
                        if (i13 == -1) {
                            break;
                        } else {
                            c1938bj.A08(bArr, i13);
                        }
                    }
                    if (z11) {
                        throw new C1939bk(A03(283, 20, 35));
                    }
                    c1938bj.A07();
                    this.A05.A07().A9t(j11, System.currentTimeMillis() - j11, c1938bj.A03(), 0L, c0kA00 instanceof C1937bi ? ((C1937bi) c0kA00).A06() : 0, null);
                    c0kA00.close();
                    return;
                }
                c0kA00.ADm(iA03);
                bArr = new byte[8192];
                while (true) {
                    i13 = c0kA00.read(bArr);
                    if (i13 == -1) {
                        break;
                    } else {
                        c1938bj.A08(bArr, i13);
                    }
                }
                if (z11) {
                    throw new C1939bk(A03(283, 20, 35));
                }
                c1938bj.A07();
                this.A05.A07().A9t(j11, System.currentTimeMillis() - j11, c1938bj.A03(), 0L, c0kA00 instanceof C1937bi ? ((C1937bi) c0kA00).A06() : 0, null);
                c0kA00.close();
                return;
                if (z11) {
                    throw new C1939bk(A03(283, 20, 35));
                }
                c1938bj.A07();
                this.A05.A07().A9t(j11, System.currentTimeMillis() - j11, c1938bj.A03(), 0L, c0kA00 instanceof C1937bi ? ((C1937bi) c0kA00).A06() : 0, null);
                c0kA00.close();
                return;
                strArr = A0A;
                if (strArr[5].length() != strArr[7].length()) {
                    A0A[6] = "T9HhHUPHmRtDRYih6csTBmWckuigXZik";
                }
                int iA06 = c0kA00 instanceof C1937bi ? ((C1937bi) c0kA00).A06() : 0;
                AnonymousClass89 anonymousClass89A07 = this.A05.A07();
                long jCurrentTimeMillis = System.currentTimeMillis() - j11;
                strArr2 = A0A;
                if (strArr2[0].length() != strArr2[4].length()) {
                    String[] strArr5 = A0A;
                    strArr5[0] = "1ebbv6sZsY";
                    strArr5[4] = "jsueFKzO4";
                } else {
                    A0A[6] = "KSAyepUp6Lv8t3ZYZ0KE3Pcqgz9Tryir";
                }
                anonymousClass89A07.A9t(j11, jCurrentTimeMillis, 0L, 0L, iA06, null);
                throw e;
            }
            try {
                try {
                    String str3 = A03(303, 15, 31) + str + A03(38, 11, 9) + i12;
                    iA03 = c1938bj.A03();
                    length = c0kA00.length();
                    if (A0A[2].length() != 16) {
                        throw new RuntimeException();
                    }
                    String[] strArr6 = A0A;
                    strArr6[1] = "eTbeym3Ey2TfwhNFyBG6ZkfAKtzQxWab";
                    strArr6[3] = "sd4JUTjhNLXLgefrlj4RQDt9w4Pjz5Uj";
                    if (length < 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (z11) {
                        zA07 = A07(c1938bj);
                        if (this.A08) {
                            String str4 = A03(149, 21, 44) + str + A03(22, 16, 73) + zA07;
                        }
                    }
                    try {
                        try {
                            if (z11 || iA03 < length) {
                                c0kA00.ADm(iA03);
                                bArr = new byte[8192];
                                while (true) {
                                    i13 = c0kA00.read(bArr);
                                    if (i13 == -1) {
                                        break;
                                    } else {
                                        c1938bj.A08(bArr, i13);
                                    }
                                }
                                if (z11 && c1938bj.A03() != length) {
                                    throw new C1939bk(A03(283, 20, 35));
                                }
                                c1938bj.A07();
                                this.A05.A07().A9t(j11, System.currentTimeMillis() - j11, c1938bj.A03(), 0L, c0kA00 instanceof C1937bi ? ((C1937bi) c0kA00).A06() : 0, null);
                                c0kA00.close();
                                return;
                            }
                            c0kA00.close();
                            return;
                        } catch (C0H | IllegalArgumentException e11) {
                            if (this.A08) {
                                Log.e(A0B, strA03, e11);
                                return;
                            }
                            return;
                        }
                        if (z11) {
                            throw new C1939bk(A03(283, 20, 35));
                        }
                        c1938bj.A07();
                        this.A05.A07().A9t(j11, System.currentTimeMillis() - j11, c1938bj.A03(), 0L, c0kA00 instanceof C1937bi ? ((C1937bi) c0kA00).A06() : 0, null);
                    } catch (C0H e12) {
                        e = e12;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (C0H e13) {
                    e = e13;
                    strArr3 = A0A;
                    if (strArr3[1].charAt(5) != strArr3[3].charAt(5)) {
                        throw new RuntimeException();
                    }
                    A0A[2] = "FEvgLDxHgmJHNXql";
                }
            } catch (C0H e14) {
                e = e14;
                strArr3 = A0A;
                if (strArr3[1].charAt(5) != strArr3[3].charAt(5)) {
                    throw new RuntimeException();
                }
                A0A[2] = "FEvgLDxHgmJHNXql";
            } catch (Throwable th3) {
                th = th3;
            }
            strArr = A0A;
            if (strArr[5].length() != strArr[7].length()) {
                A0A[6] = "T9HhHUPHmRtDRYih6csTBmWckuigXZik";
            }
            try {
                if (c0kA00 instanceof C1937bi) {
                    try {
                    } catch (Throwable th4) {
                        th = th4;
                        String[] strArr7 = A0A;
                        if (strArr7[0].length() == strArr7[4].length()) {
                            throw new RuntimeException();
                        }
                        A0A[6] = "ImVXE49sB20dM2EoLXCVvjDoDOKBzvDP";
                    }
                }
                AnonymousClass89 anonymousClass89A08 = this.A05.A07();
                long jCurrentTimeMillis2 = System.currentTimeMillis() - j11;
                strArr2 = A0A;
                if (strArr2[0].length() != strArr2[4].length()) {
                    String[] strArr8 = A0A;
                    strArr8[0] = "1ebbv6sZsY";
                    strArr8[4] = "jsueFKzO4";
                } else {
                    A0A[6] = "KSAyepUp6Lv8t3ZYZ0KE3Pcqgz9Tryir";
                }
                try {
                    anonymousClass89A08.A9t(j11, jCurrentTimeMillis2, 0L, 0L, iA06, null);
                    throw e;
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (Throwable th6) {
                th = th6;
                if (A0A[2].length() != 16) {
                    throw new RuntimeException();
                }
                String[] strArr9 = A0A;
                strArr9[1] = "6fSXCo91bn6LAd9tVoL5ppajSHGCeKrb";
                strArr9[3] = "7b6W6Np6OlCq8n45whdvZaRJ0dkqNrQI";
            }
        } catch (C0H e15) {
            e = e15;
        }
        try {
            c0kA00.close();
        } catch (C0H | IllegalArgumentException e16) {
            if (this.A08) {
                Log.e(A0B, strA03, e16);
            }
        }
        throw th;
    }

    private void A06(C1938bj c1938bj) {
        try {
            File fileA04 = c1938bj.A04();
            if (fileA04.exists()) {
                c1938bj.A06();
                boolean zDelete = fileA04.delete();
                if (this.A08) {
                    Log.i(A0B, A03(170, 52, 40) + zDelete);
                }
            }
        } catch (Exception e11) {
            if (this.A08) {
                Log.e(A0B, A03(108, 23, 81), e11);
            }
        }
    }

    private boolean A07(C1938bj c1938bj) {
        try {
            c1938bj.A05();
            return true;
        } catch (C1936bh e11) {
            boolean z11 = this.A08;
            if (A0A[6].charAt(7) == 'U') {
                throw new RuntimeException();
            }
            A0A[6] = "AEs2mSbxTVyMZvMH4XlDgcN9VznTkYzp";
            if (!z11) {
                return false;
            }
            Log.e(A0B, A03(244, 19, 57), e11);
            return false;
        }
    }

    public final <T> AnonymousClass02<T> A08(AnonymousClass06 anonymousClass06, AnonymousClass09<T> anonymousClass09) {
        Semaphore semaphore;
        if (anonymousClass09.A03()) {
            File file = this.A06.get(anonymousClass06.A09);
            if (file != null) {
                this.A04.AEQ(anonymousClass06.A09, true, anonymousClass06);
                return anonymousClass09.A00().A3M(file, this.A04);
            }
            this.A04.AEQ(anonymousClass06.A09, false, anonymousClass06);
            return new AnonymousClass02<>(false, null);
        }
        String str = anonymousClass06.A09;
        String str2 = this.A03.A03(str) + anonymousClass06.A04;
        synchronized (this.A07) {
            semaphore = this.A07.get(str2);
            if (semaphore == null) {
                semaphore = new Semaphore(1);
                this.A07.put(str2, semaphore);
            }
            try {
            } catch (Throwable th2) {
                semaphore.release();
                synchronized (this.A07) {
                    this.A07.remove(str2);
                    throw th2;
                }
            }
        }
        try {
            semaphore.acquire();
            File fileA02 = A02(anonymousClass06, str, str2, this.A01, anonymousClass09);
            if (fileA02 != null) {
                AnonymousClass02<T> anonymousClass02A3M = anonymousClass09.A00().A3M(fileA02, this.A04);
                semaphore.release();
                synchronized (this.A07) {
                    this.A07.remove(str2);
                }
                return anonymousClass02A3M;
            }
            AnonymousClass02<T> anonymousClass02 = new AnonymousClass02<>(false, null);
            semaphore.release();
            synchronized (this.A07) {
                this.A07.remove(str2);
            }
            return anonymousClass02;
        } catch (InterruptedException unused) {
            if (this.A08) {
                String str3 = A03(97, 11, 22) + str + A03(0, 22, 43);
            }
            AnonymousClass02<T> anonymousClass03 = new AnonymousClass02<>(false, null);
            semaphore.release();
            synchronized (this.A07) {
                this.A07.remove(str2);
                return anonymousClass03;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass00
    public final AnonymousClass02<Bitmap> AFH(AnonymousClass06 anonymousClass06, boolean z11) {
        return A08(anonymousClass06, new AnonymousClass09(new C1945bq(anonymousClass06.A01, anonymousClass06.A00, this.A02.A04(), this.A02.A03(), z11)));
    }

    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass00
    public final File AFI(AnonymousClass06 anonymousClass06) {
        AnonymousClass09 anonymousClass09 = new AnonymousClass09(new C1944bp());
        anonymousClass09.A01(true);
        anonymousClass09.A02(false);
        return (File) A08(anonymousClass06, anonymousClass09).A00();
    }

    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass00
    public final String AFJ(AnonymousClass06 anonymousClass06) {
        return (String) A08(anonymousClass06, new AnonymousClass09(new C1943bo())).A00();
    }

    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass00
    public final String AFK(AnonymousClass06 anonymousClass06) {
        AnonymousClass09 anonymousClass09 = new AnonymousClass09(new C1943bo());
        anonymousClass09.A01(true);
        anonymousClass09.A02(false);
        return (String) A08(anonymousClass06, anonymousClass09).A00();
    }
}
