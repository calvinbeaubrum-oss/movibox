package com.facebook.ads.redexgen.uinode;

import android.media.MediaCodecInfo;
import android.util.Log;
import android.util.Pair;
import android.util.SparseIntArray;
import androidx.core.view.PointerIconCompat;
import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.transsion.gslb.Worker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okio.Utf8;
import org.mvel2.ast.ASTNode;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class DR {
    public static int A00;
    public static byte[] A01;
    public static String[] A02 = {"BAY", "ymxL57jYYv0jjQRcHQbZ4WAbO", "V4mYndI5uaXc7arEQ3TceizUtwuJpZsP", "bZ", "bvLsrur7DOWvoKolroRaEPylJxsC8CBw", "pPHP1LRPBsm50pfT1", "f9saOCuwOfCGSEN51CDIZYerwD3UjJFW", "NB4ZEOXNx"};
    public static final SparseIntArray A03;
    public static final SparseIntArray A04;
    public static final DG A05;
    public static final HashMap<DO, List<DG>> A06;
    public static final Map<String, Integer> A07;
    public static final Pattern A08;

    static {
        A0A();
        A05 = DG.A01(A07(657, 22, 61));
        A08 = Pattern.compile(A07(899, 10, 19));
        A06 = new HashMap<>();
        A00 = -1;
        SparseIntArray sparseIntArray = new SparseIntArray();
        A04 = sparseIntArray;
        sparseIntArray.put(66, 1);
        sparseIntArray.put(77, 2);
        sparseIntArray.put(88, 4);
        sparseIntArray.put(100, 8);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        A03 = sparseIntArray2;
        sparseIntArray2.put(10, 1);
        sparseIntArray2.put(11, 4);
        sparseIntArray2.put(12, 8);
        sparseIntArray2.put(13, 16);
        sparseIntArray2.put(20, 32);
        sparseIntArray2.put(21, 64);
        sparseIntArray2.put(22, 128);
        sparseIntArray2.put(30, 256);
        sparseIntArray2.put(31, 512);
        sparseIntArray2.put(32, 1024);
        sparseIntArray2.put(40, 2048);
        sparseIntArray2.put(41, 4096);
        sparseIntArray2.put(42, 8192);
        sparseIntArray2.put(50, 16384);
        sparseIntArray2.put(51, 32768);
        sparseIntArray2.put(52, 65536);
        HashMap map = new HashMap();
        A07 = map;
        map.put(A07(345, 3, 76), 1);
        map.put(A07(352, 3, 65), 4);
        map.put(A07(355, 3, 9), 16);
        map.put(A07(358, 3, 99), 64);
        map.put(A07(361, 3, 70), 256);
        map.put(A07(313, 4, 79), 1024);
        map.put(A07(317, 4, 36), 4096);
        map.put(A07(321, 4, 54), 16384);
        map.put(A07(325, 4, 77), 65536);
        map.put(A07(329, 4, 74), 262144);
        map.put(A07(333, 4, 10), 1048576);
        map.put(A07(337, 4, 66), 4194304);
        map.put(A07(341, 4, 21), 16777216);
        map.put(A07(221, 3, 72), 2);
        map.put(A07(224, 3, 70), 8);
        map.put(A07(227, 3, 119), 32);
        map.put(A07(230, 3, 0), 128);
        map.put(A07(233, 3, 93), 512);
        map.put(A07(PsExtractor.PRIVATE_STREAM_1, 4, 8), 2048);
        map.put(A07(193, 4, 124), 8192);
        map.put(A07(197, 4, 100), 32768);
        map.put(A07(201, 4, 123), 131072);
        map.put(A07(205, 4, 44), 524288);
        map.put(A07(209, 4, 11), 2097152);
        map.put(A07(213, 4, 15), 8388608);
        map.put(A07(217, 4, 93), Integer.valueOf(ASTNode.PCTX_STORED));
    }

    public static int A00() throws DP {
        if (A00 == -1) {
            int iMax = 0;
            DG dgA06 = A06(A07(PointerIconCompat.TYPE_CELL, 9, 38), false);
            if (dgA06 != null) {
                for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : dgA06.A0J()) {
                    iMax = Math.max(A01(codecProfileLevel.level), iMax);
                }
                iMax = Math.max(iMax, IF.A02 >= 21 ? 345600 : 172800);
            }
            A00 = iMax;
        }
        return A00;
    }

    public static int A01(int i11) {
        switch (i11) {
            case 1:
                return 25344;
            case 2:
                return 25344;
            case 8:
                return 101376;
            case 16:
                return 101376;
            case 32:
                return 101376;
            case 64:
                return 202752;
            case 128:
                return 414720;
            case 256:
                return 414720;
            case 512:
                return 921600;
            case 1024:
                return 1310720;
            case 2048:
                return 2097152;
            case 4096:
                return 2097152;
            case 8192:
                return 2228224;
            case 16384:
                return 5652480;
            case 32768:
                return 9437184;
            case 65536:
                return 9437184;
            default:
                return -1;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:26:0x0084  */
    /* JADX WARN: Code duplicated, block: B:28:0x0089  */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    /* JADX WARN: Code duplicated, block: B:9:0x001f A[RETURN] */
    public static Pair<Integer, Integer> A02(String str) {
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split(A07(897, 2, 85));
        byte b11 = 0;
        String str2 = strArrSplit[0];
        switch (str2.hashCode()) {
            case 3006243:
                if (str2.equals(A07(936, 4, 25))) {
                    b11 = 2;
                } else {
                    b11 = -1;
                }
                switch (b11) {
                    case 0:
                    case 1:
                        return A04(str, strArrSplit);
                    case 2:
                    case 3:
                        return A03(str, strArrSplit);
                    default:
                        return null;
                }
            case 3006244:
                if (str2.equals(A07(940, 4, 116))) {
                    b11 = 3;
                } else {
                    b11 = -1;
                }
                switch (b11) {
                    case 0:
                    case 1:
                        return A04(str, strArrSplit);
                    case 2:
                    case 3:
                        return A03(str, strArrSplit);
                    default:
                        return null;
                }
            case 3199032:
                if (!str2.equals(A07(953, 4, 25))) {
                    b11 = -1;
                }
                switch (b11) {
                    case 0:
                    case 1:
                        return A04(str, strArrSplit);
                    case 2:
                    case 3:
                        return A03(str, strArrSplit);
                    default:
                        return null;
                }
            case 3214780:
                if (A02[4].charAt(9) != 'O') {
                    throw new RuntimeException();
                }
                String[] strArr = A02;
                strArr[2] = "MmTCu4eMbW5HStPFtCsv7ZFMn3CvoIap";
                strArr[6] = "LZKP0I4cIbW5T2P3pagUWnAfz2n8Y4ic";
                if (str2.equals(A07(957, 4, 34))) {
                    b11 = 1;
                } else {
                    b11 = -1;
                }
                switch (b11) {
                    case 0:
                    case 1:
                        return A04(str, strArrSplit);
                    case 2:
                    case 3:
                        return A03(str, strArrSplit);
                    default:
                        return null;
                }
            default:
                b11 = -1;
                switch (b11) {
                    case 0:
                    case 1:
                        return A04(str, strArrSplit);
                    case 2:
                    case 3:
                        return A03(str, strArrSplit);
                    default:
                        return null;
                }
        }
    }

    public static Pair<Integer, Integer> A03(String str, String[] strArr) {
        Integer numValueOf;
        Integer numValueOf2;
        int length = strArr.length;
        String strA07 = A07(238, 37, 54);
        String strA08 = A07(425, 14, 38);
        if (length < 2) {
            Log.w(strA08, strA07 + str);
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                numValueOf = Integer.valueOf(Integer.parseInt(strArr[1].substring(0, 2), 16));
                numValueOf2 = Integer.valueOf(Integer.parseInt(strArr[1].substring(4), 16));
            } else {
                if (strArr.length < 3) {
                    Log.w(strA08, strA07 + str);
                    return null;
                }
                numValueOf = Integer.valueOf(Integer.parseInt(strArr[1]));
                numValueOf2 = Integer.valueOf(Integer.parseInt(strArr[2]));
            }
            int i11 = A04.get(numValueOf.intValue(), -1);
            if (i11 == -1) {
                Log.w(strA08, A07(814, 21, 106) + numValueOf);
                return null;
            }
            int i12 = A03.get(numValueOf2.intValue(), -1);
            if (i12 != -1) {
                return new Pair<>(Integer.valueOf(i11), Integer.valueOf(i12));
            }
            Log.w(strA08, A07(795, 19, 39) + numValueOf2);
            return null;
        } catch (NumberFormatException unused) {
            Log.w(strA08, strA07 + str);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00a9, code lost:
    
        if (r6 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00ab, code lost:
    
        android.util.Log.w(r5, A07(835, 27, 74) + r3.group(1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00cd, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00d7, code lost:
    
        if (r6 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00f4, code lost:
    
        return new android.util.Pair<>(java.lang.Integer.valueOf(r7), r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair<Integer, Integer> A04(String str, String[] strArr) {
        int i11;
        Integer num;
        int length = strArr.length;
        String strA07 = A07(275, 38, 56);
        String strA08 = A07(425, 14, 38);
        if (length < 4) {
            Log.w(strA08, strA07 + str);
            return null;
        }
        Pattern pattern = A08;
        String str2 = strArr[1];
        if (A02[7].length() != 9) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[3] = "2f";
        strArr2[0] = "5sj";
        Matcher matcher = pattern.matcher(str2);
        if (!matcher.matches()) {
            Log.w(strA08, strA07 + str);
            return null;
        }
        String strGroup = matcher.group(1);
        if (A07(53, 1, 97).equals(strGroup)) {
            i11 = 1;
        } else {
            if (!A07(54, 1, 69).equals(strGroup)) {
                Log.w(strA08, A07(862, 29, 112) + strGroup);
                return null;
            }
            i11 = 2;
        }
        Integer num2 = A07.get(strArr[3]);
        if (A02[5].length() != 17) {
            String[] strArr3 = A02;
            strArr3[2] = "NDllh4Gk9AYylWORiKA9sy5i8NPghk70";
            strArr3[6] = "TYaXTXlX2Wnboxk1WLU2nbrnETYd3GkV";
            num = num2;
        } else {
            A02[4] = "pDNfPE2mBOJDzsLiT7ZaRh6hSLEh4IuG";
            num = num2;
        }
    }

    public static DG A05() {
        return A05;
    }

    public static DG A06(String str, boolean z11) throws DP {
        List<DG> listA09 = A09(str, z11);
        if (listA09.isEmpty()) {
            return null;
        }
        return listA09.get(0);
    }

    public static String A07(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 109);
        }
        return new String(bArrCopyOfRange);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0061 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:23:0x0067  */
    /* JADX WARN: Code duplicated, block: B:42:0x00d8 A[Catch: Exception -> 0x014e, TRY_ENTER, TryCatch #0 {Exception -> 0x014e, blocks: (B:6:0x0022, B:8:0x002a, B:11:0x0036, B:39:0x00c8, B:42:0x00d8, B:44:0x00de, B:48:0x0112, B:49:0x014d, B:45:0x0109, B:46:0x010d), top: B:56:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:0x0112 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    public static ArrayList<DG> A08(DO r18, DQ dq2, String str) throws DP {
        int i11;
        String strA07;
        try {
            ArrayList<DG> arrayList = new ArrayList<>();
            String str2 = r18.A00;
            int iA6U = dq2.A6U();
            boolean zAFf = dq2.AFf();
            for (int i12 = 0; i12 < iA6U; i12++) {
                MediaCodecInfo mediaCodecInfoA6V = dq2.A6V(i12);
                String name = mediaCodecInfoA6V.getName();
                try {
                    if (A0C(mediaCodecInfoA6V, name, zAFf, str)) {
                        for (String str3 : mediaCodecInfoA6V.getSupportedTypes()) {
                            if (str3.equalsIgnoreCase(str2)) {
                                try {
                                    MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfoA6V.getCapabilitiesForType(str3);
                                    boolean zA9H = dq2.A9H(str2, capabilitiesForType);
                                    boolean zA0D = A0D(name);
                                    if (zAFf) {
                                        try {
                                            boolean z11 = r18.A01;
                                            if (A02[7].length() == 9) {
                                                String[] strArr = A02;
                                                strArr[3] = "CD";
                                                strArr[0] = "ZBY";
                                                if (z11 != zA9H) {
                                                    if (!zAFf) {
                                                        try {
                                                            if (!r18.A01) {
                                                                try {
                                                                    arrayList.add(DG.A02(name, str2, capabilitiesForType, zA0D, false));
                                                                } catch (Exception e11) {
                                                                    e = e11;
                                                                    i11 = IF.A02;
                                                                    strA07 = A07(425, 14, 38);
                                                                    if (i11 <= 23) {
                                                                    }
                                                                    Log.e(strA07, A07(167, 22, 9) + name + A07(0, 2, 58) + str3 + A07(33, 1, 97));
                                                                    throw e;
                                                                }
                                                            }
                                                        } catch (Exception e12) {
                                                            e = e12;
                                                            String[] strArr2 = A02;
                                                            if (strArr2[3].length() == strArr2[0].length()) {
                                                                throw new RuntimeException();
                                                            }
                                                            A02[5] = "MyzIrPx41nvhJUnfD";
                                                            i11 = IF.A02;
                                                            strA07 = A07(425, 14, 38);
                                                            if (i11 <= 23 || arrayList.isEmpty()) {
                                                                Log.e(strA07, A07(167, 22, 9) + name + A07(0, 2, 58) + str3 + A07(33, 1, 97));
                                                                throw e;
                                                            }
                                                            Log.e(strA07, A07(780, 15, 115) + name + A07(2, 31, 118));
                                                        }
                                                    }
                                                    if (!zAFf && zA9H) {
                                                        arrayList.add(DG.A02(name + A07(46, 7, 0), str2, capabilitiesForType, zA0D, true));
                                                        return arrayList;
                                                    }
                                                } else {
                                                    arrayList.add(DG.A02(name, str2, capabilitiesForType, zA0D, false));
                                                }
                                            }
                                            throw new RuntimeException();
                                        } catch (Exception e13) {
                                            e = e13;
                                            i11 = IF.A02;
                                            strA07 = A07(425, 14, 38);
                                            if (i11 <= 23) {
                                            }
                                            Log.e(strA07, A07(167, 22, 9) + name + A07(0, 2, 58) + str3 + A07(33, 1, 97));
                                            throw e;
                                        }
                                    }
                                    if (!zAFf) {
                                        if (!r18.A01) {
                                            arrayList.add(DG.A02(name, str2, capabilitiesForType, zA0D, false));
                                        }
                                    }
                                    if (!zAFf) {
                                        continue;
                                    }
                                } catch (Exception e14) {
                                    e = e14;
                                }
                            }
                        }
                    }
                } catch (Exception e15) {
                    e = e15;
                    throw new DP(e);
                }
            }
            return arrayList;
        } catch (Exception e16) {
            e = e16;
        }
    }

    public static synchronized List<DG> A09(String str, boolean z11) throws DP {
        DO r11 = new DO(str, z11);
        HashMap<DO, List<DG>> map = A06;
        List<DG> list = map.get(r11);
        if (list != null) {
            return list;
        }
        DQ c1738Wi = IF.A02 >= 21 ? new C1738Wi(z11) : new C1739Wj();
        ArrayList<DG> arrayListA08 = A08(r11, c1738Wi, str);
        if (z11 && arrayListA08.isEmpty() && 21 <= IF.A02 && IF.A02 <= 23) {
            c1738Wi = new C1739Wj();
            arrayListA08 = A08(r11, c1738Wi, str);
            if (!arrayListA08.isEmpty()) {
                Log.w(A07(425, 14, 38), A07(374, 51, 80) + str + A07(34, 12, 9) + arrayListA08.get(0).A02);
            }
        }
        if (A07(922, 14, 50).equals(str)) {
            arrayListA08.addAll(A08(new DO(A07(912, 10, 75), r11.A01), c1738Wi, str));
        }
        A0B(arrayListA08);
        List<DG> listUnmodifiableList = Collections.unmodifiableList(arrayListA08);
        map.put(r11, listUnmodifiableList);
        return listUnmodifiableList;
    }

    public static void A0A() {
        if (A02[4].charAt(9) != 'O') {
            throw new RuntimeException();
        }
        A02[1] = "WfhNiOeVQzQSnYcncz46tqnXb";
        A01 = new byte[]{-57, -49, 3, Ascii.VT, 73, 68, 76, 79, 72, 71, 3, 87, 82, 3, 84, 88, 72, 85, 92, 3, 70, 68, 83, 68, 69, 76, 79, 76, 87, 76, 72, 86, Ascii.FF, -9, -92, -106, -73, -23, -23, -21, -29, -33, -28, -35, -80, -106, -101, -32, -46, -48, -30, -33, -46, -1, -28, Ascii.RS, Ascii.SUB, Ascii.RS, 61, 45, Ascii.CR, Ascii.CR, Ascii.SI, Ascii.DLE, 49, 47, 59, 48, 49, 62, -29, -47, -43, -48, -44, 10, -8, -4, -9, -4, -44, -62, -57, -63, -59, -31, -49, -44, -50, -45, -73, -86, -86, -92, -90, -65, -78, -78, -84, -81, -13, -26, -26, -32, -26, -72, -85, -85, -90, -85, -61, -55, -48, -63, -63, -61, -60, -27, -29, -17, -28, -27, -14, -45, -39, -32, -47, -35, -30, -34, -46, -44, -11, -13, -1, -12, -11, 2, 43, 49, 56, 53, 56, Ascii.ESC, 44, 77, 75, 87, 76, 77, 90, -36, -30, -23, -17, 8, Ascii.VT, -5, 2, Ascii.FF, -35, -2, -4, 8, -3, -2, Ascii.VT, -68, -41, -33, -30, -37, -38, -106, -22, -27, -106, -25, -21, -37, -24, -17, -106, -39, -27, -38, -37, -39, -106, -67, -90, -89, -91, 49, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.EM, 2, 6, 1, 48, Ascii.EM, Ascii.GS, Ascii.ESC, -31, -54, -50, -49, -64, -87, -80, -88, -60, -83, -76, -81, Ascii.DC2, -5, 2, 0, -3, -24, -27, -5, -23, -29, 44, Ascii.SUB, Ascii.ETB, -75, -90, -99, Ascii.DC2, 3, -3, 19, Ascii.CAN, -20, 10, 17, Ascii.DC2, Ascii.NAK, Ascii.FF, 17, 10, -61, Ascii.DLE, 4, Ascii.SI, 9, Ascii.DC2, Ascii.NAK, Ascii.DLE, 8, 7, -61, -28, -7, -26, -61, 6, Ascii.DC2, 7, 8, 6, -61, Ascii.SYN, Ascii.ETB, Ascii.NAK, Ascii.FF, 17, 10, -35, -61, -18, Ascii.FF, 19, Ascii.DC4, Ascii.ETB, Ascii.SO, 19, Ascii.FF, -59, Ascii.DC2, 6, 17, Ascii.VT, Ascii.DC4, Ascii.ETB, Ascii.DC2, 10, 9, -59, -19, -22, -5, -24, -59, 8, Ascii.DC4, 9, 10, 8, -59, Ascii.CAN, Ascii.EM, Ascii.ETB, Ascii.SO, 19, Ascii.FF, -33, -59, 8, -19, -18, -20, -35, -62, -61, -60, -17, -44, -40, -45, 6, -21, -17, -19, 3, -24, -20, -19, -61, -88, -81, -89, -5, -32, -25, -30, -50, -77, -70, -72, 5, -20, -23, -20, -45, -42, 8, -6, -28, -34, -62, -84, -87, Ascii.FS, 9, 0, -1, -20, -26, 32, 35, 6, Ascii.ETB, 56, 54, 66, 55, 56, 69, 10, 34, 33, 38, Ascii.RS, 0, 44, 33, 34, 32, 9, 38, 48, 49, -35, -2, Ascii.CR, 6, -35, 33, 38, 33, 43, -28, 49, -35, 41, 38, 48, 49, -35, 48, 34, 32, 50, 47, 34, -35, 33, 34, 32, 44, 33, 34, 47, -35, 35, 44, 47, -9, -35, -32, -8, -9, -4, -12, -42, 2, -9, -8, -10, -24, 7, -4, -1, -58, -35, -16, -19, -21, -104, -87, -88, 48, 37, 51, 48, 42, 37, Ascii.SO, 57, 54, Ascii.DC4, 6, 4, Ascii.SI, -27, -4, 47, 48, 37, 38, 42, -27, -8, -8, -6, -27, -5, Ascii.FS, Ascii.SUB, 38, Ascii.ESC, Ascii.FS, 41, 1, -1, 10, -32, -9, 42, 43, 32, 33, 37, -32, -13, 8, -11, -32, -10, Ascii.ETB, Ascii.NAK, 33, Ascii.SYN, Ascii.ETB, 36, Ascii.FF, 10, Ascii.NAK, -21, 2, 53, 54, 43, 44, 48, -21, -2, 19, 0, -21, 1, 34, 32, 44, 33, 34, 47, -21, 48, 34, 32, 50, 47, 34, -54, -56, -45, -87, -56, -49, -58, -87, -68, -48, -65, -60, -54, -87, -65, -64, -66, -54, -65, -64, -51, -87, -68, -68, -66, 8, 6, 17, -25, 6, Ascii.CR, 4, -25, -6, Ascii.SO, -3, 2, 8, -25, -3, -2, -4, 8, -3, -2, Ascii.VT, -25, -3, Ascii.FF, 9, -6, -4, -20, 43, 41, 52, 10, 41, 48, 39, 10, Ascii.GS, 49, 32, 37, 43, 10, 32, 33, Ascii.US, 43, 32, 33, 46, 10, 46, Ascii.GS, 51, -38, -40, -29, -71, -34, -48, -50, -71, -40, -37, -66, -71, -49, -16, -18, -6, -17, -16, -3, -15, -17, -6, -48, -11, -25, -27, -48, 3, 3, 5, -48, 6, 7, 5, -62, -64, -53, -95, -58, -72, -74, -95, -23, -29, -85, -95, -41, -40, -42, -7, -9, 2, -40, 17, Ascii.EM, Ascii.EM, 17, Ascii.SYN, Ascii.SI, -40, Ascii.FS, Ascii.VT, 33, -40, Ascii.SO, Ascii.SI, Ascii.CR, Ascii.EM, Ascii.SO, Ascii.SI, Ascii.FS, Ascii.VT, 9, Ascii.DC4, -22, 45, Ascii.US, 43, 41, -22, Ascii.GS, 49, 32, 37, 43, -22, 32, 33, Ascii.US, 43, 32, 33, 46, -22, Ascii.GS, Ascii.GS, Ascii.US, Ascii.SO, Ascii.FF, Ascii.ETB, -19, 48, 34, 46, 44, -19, 32, 52, 35, 40, 46, -19, 35, 36, 34, 46, 35, 36, 49, -19, 44, 47, -14, Ascii.CAN, Ascii.SYN, 33, -9, 58, 44, 56, 54, -9, Utf8.REPLACEMENT_BYTE, 50, 45, 46, 56, -9, 45, 46, 44, 56, 45, 46, 59, -9, Utf8.REPLACEMENT_BYTE, 57, 1, Utf8.REPLACEMENT_BYTE, 47, Ascii.EM, Ascii.FS, 32, 51, -32, -48, -70, -67, -62, -44, 49, 33, 52, 17, Ascii.SI, 56, 52, Ascii.DC2, Ascii.NAK, Ascii.ETB, 42, 51, 75, 73, 80, 80, 73, 78, 71, 0, 67, 79, 68, 69, 67, 0, -23, 2, -1, 2, 3, Ascii.VT, 2, -76, -43, -22, -41, -76, 0, -7, 10, -7, 0, -50, -76, 44, 69, 66, 69, 70, 78, 69, -9, Ascii.CAN, 45, Ascii.SUB, -9, 71, 73, 70, 61, 64, 67, 60, 17, -9, Ascii.FF, 37, 34, 37, 38, 46, 37, -41, -1, -4, Ascii.CR, -6, -41, 35, Ascii.FS, 45, Ascii.FS, 35, -41, 42, 43, 41, 32, 37, Ascii.RS, -15, -41, 50, 75, 72, 75, 76, 84, 75, -3, 37, 34, 51, 32, -3, 77, 79, 76, 67, 70, 73, 66, -3, 80, 81, 79, 70, 75, 68, Ascii.ETB, -3, -7, 10, 2, Ascii.DLE, Ascii.SO, 10, Ascii.RS, -16, -34, -36, -60, -65, -88, -36, -28, -85, -87, -92, 62, Ascii.DC4, Ascii.CR, Ascii.EM, 45, Ascii.FS, 33, 39, -25, Ascii.GS, Ascii.EM, Ascii.ESC, -21, 0, Ascii.DC4, 3, 8, Ascii.SO, -50, 4, 0, 2, -46, -52, 9, Ascii.SO, 2, -25, -4, -23, -73, 66, 87, 68, 19, 73, Ascii.ETB, 4, Ascii.FF, Ascii.CAN, Ascii.NAK, 42, 40, 40, -18, -21, -4, -73, -9, 5, -14, -64, 17, Ascii.CR, 19, Ascii.ESC, Ascii.FF, -8, -20, -3, -12, -7, -16, -9, -1, -16, -20, -1, -1, Ascii.FF, Ascii.SO, Ascii.VT, Ascii.DLE, Ascii.VT, 17, -20, -38, -26, -20, -18, -25, -32, -29, -47, -34, -28, -33, -29, -6, -20, -7, 
        -7, -24, -11, -10, -3, -71, 9, -4, -9, -8, 2, -62, -12, 9, -10, 43, Ascii.RS, 33, 33, Ascii.SUB, 42, Ascii.GS, 32, 32, Ascii.EM, Ascii.ETB, -26, 53, 40, 43, 43, 36, 47, 43, 52, 50, 2, -19, -10, -12, -4, -19, 96, 75, 88, 85, 76, 82, 90, 75, 2, -19, -6, -9, -12, -4, -19};
    }

    public static void A0B(List<DG> list) {
        if (IF.A02 >= 26 || list.size() <= 1) {
            return;
        }
        if (A07(583, 25, 111).equals(list.get(0).A02)) {
            for (int i11 = 1; i11 < list.size(); i11++) {
                DG dg2 = list.get(i11);
                if (A07(657, 22, 61).equals(dg2.A02)) {
                    list.remove(i11);
                    list.add(0, dg2);
                    return;
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:116:0x0329  */
    /* JADX WARN: Code duplicated, block: B:122:0x034e  */
    /* JADX WARN: Code duplicated, block: B:130:0x0393  */
    /* JADX WARN: Code duplicated, block: B:132:0x03a5  */
    /* JADX WARN: Code duplicated, block: B:134:0x03b6  */
    /* JADX WARN: Code duplicated, block: B:136:0x03c7  */
    /* JADX WARN: Code duplicated, block: B:153:0x0426  */
    /* JADX WARN: Code duplicated, block: B:24:0x0087  */
    /* JADX WARN: Code duplicated, block: B:26:0x0097  */
    /* JADX WARN: Code duplicated, block: B:43:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:45:0x010f  */
    /* JADX WARN: Code duplicated, block: B:47:0x012b  */
    /* JADX WARN: Code duplicated, block: B:52:0x013f  */
    /* JADX WARN: Code duplicated, block: B:54:0x0148  */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x02c1, code lost:
    
        if (A07(85, 5, 49).equals(com.facebook.ads.redexgen.uinode.IF.A03) != false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x03d6, code lost:
    
        if (A07(769, 5, 113).equals(com.facebook.ads.redexgen.uinode.IF.A03) != false) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a5, code lost:
    
        if (A07(364, 10, 102).equals(r8) == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0157, code lost:
    
        if (com.facebook.ads.redexgen.uinode.IF.A03.startsWith(A07(236, 2, 94)) != false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x023a, code lost:
    
        if (A07(774, 6, 120).equals(com.facebook.ads.redexgen.uinode.IF.A03) != false) goto L85;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean A0C(MediaCodecInfo mediaCodecInfo, String str, boolean z11, String str2) {
        boolean zEquals;
        if (mediaCodecInfo.isEncoder() || (!z11 && str.endsWith(A07(46, 7, 0)))) {
            return false;
        }
        if (IF.A02 >= 21) {
            if (IF.A02 < 18 && A07(608, 19, 30).equals(str)) {
                return false;
            }
            if (IF.A02 < 18) {
                String strA07 = A07(530, 25, 14);
                if (A02[5].length() != 17) {
                    A02[1] = "I2XnTXPHshEGYaXC6U4zicLut";
                    if (strA07.equals(str)) {
                        if (!A07(909, 3, 112).equals(IF.A03)) {
                            zEquals = A07(891, 6, 52).equals(IF.A05);
                            if (A02[7].length() != 9) {
                                throw new RuntimeException();
                            }
                            A02[1] = "ikTWzPZnBqNKNF5U8hE3rEiIh";
                            if (zEquals) {
                            }
                        }
                        return false;
                    }
                } else {
                    A02[1] = "WA2DMfsAb4qPRbwhTckvxt3Oj";
                    if (strA07.equals(str)) {
                        if (!A07(909, 3, 112).equals(IF.A03)) {
                            zEquals = A07(891, 6, 52).equals(IF.A05);
                            if (A02[7].length() != 9) {
                                throw new RuntimeException();
                            }
                            A02[1] = "ikTWzPZnBqNKNF5U8hE3rEiIh";
                            if (zEquals) {
                            }
                        }
                        return false;
                    }
                }
            }
            if (IF.A02 == 16 && A07(705, 26, 82).equals(str)) {
                if (!A07(946, 4, 51).equals(IF.A03)) {
                    if (!A07(978, 6, 47).equals(IF.A03)) {
                        if (!A07(PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW, 5, 72).equals(IF.A03)) {
                            if (!A07(1027, 9, 82).equals(IF.A03)) {
                                if (!A07(PointerIconCompat.TYPE_GRAB, 7, 71).equals(IF.A03) && !IF.A03.startsWith(A07(950, 3, 86))) {
                                    if (!A07(90, 5, 7).equals(IF.A03)) {
                                        if (!A07(95, 5, 15).equals(IF.A03)) {
                                            if (!A07(100, 5, 67).equals(IF.A03)) {
                                                if (!A07(105, 5, 8).equals(IF.A03)) {
                                                    if (!A07(348, 4, 51).equals(IF.A03)) {
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return false;
            }
            int i11 = IF.A02;
            if (A02[1].length() == 25) {
                A02[7] = "tnRGvETTi";
                if (i11 == 16 && A07(679, 26, 79).equals(str)) {
                    if (!A07(70, 5, 51).equals(IF.A03)) {
                        if (!A07(75, 5, 90).equals(IF.A03)) {
                            String str3 = IF.A03;
                            if (A02[5].length() != 17) {
                                String[] strArr = A02;
                                strArr[3] = "Sr";
                                strArr[0] = "zUD";
                                if (!A07(80, 3, 3).equals(str3)) {
                                }
                            } else {
                                A02[1] = "DeHWw2fWCjgMmVyUN9OyqRVSX";
                                if (!A07(80, 5, 36).equals(str3)) {
                                }
                            }
                        }
                    }
                    return false;
                }
                int i12 = IF.A02;
                if (A02[4].charAt(9) == 'O') {
                    String[] strArr2 = A02;
                    strArr2[3] = "Ia";
                    strArr2[0] = "P3O";
                    String strA08 = A07(984, 7, 12);
                    if (i12 < 24) {
                        boolean zEquals2 = A07(627, 15, 53).equals(str);
                        if (A02[1].length() != 25) {
                            A02[7] = "KiHLQPnXR";
                            if (!zEquals2) {
                                if (A07(457, 22, 74).equals(str)) {
                                }
                            }
                        } else {
                            A02[1] = "37Lb1d6thx8YO69UbmwcSx6lm";
                            if (!zEquals2) {
                                if (A07(457, 22, 74).equals(str)) {
                                }
                            }
                        }
                        String str4 = IF.A05;
                        if (A02[1].length() == 25) {
                            A02[7] = "xnGQuYocR";
                            if (strA08.equals(str4)) {
                                if (!IF.A03.startsWith(A07(1042, 8, 121))) {
                                    if (!A07(763, 6, 32).equals(IF.A03)) {
                                        if (!A07(966, 12, 30).equals(IF.A03)) {
                                            if (!A07(55, 5, 125).equals(IF.A03)) {
                                                if (!A07(757, 6, 127).equals(IF.A03)) {
                                                }
                                            }
                                        }
                                    }
                                }
                                return false;
                            }
                        } else if (strA08.equals(str4)) {
                            if (!IF.A03.startsWith(A07(1042, 8, 121)) && !IF.A03.startsWith(A07(1050, 7, 27)) && !IF.A03.startsWith(A07(1036, 6, 27))) {
                                if (!A07(763, 6, 32).equals(IF.A03)) {
                                    if (!A07(966, 12, 30).equals(IF.A03)) {
                                        if (!A07(55, 5, 125).equals(IF.A03)) {
                                            if (!A07(757, 6, 127).equals(IF.A03)) {
                                            }
                                        }
                                    }
                                }
                            }
                            return false;
                        }
                    }
                    int i13 = IF.A02;
                    String strA09 = A07(961, 5, 58);
                    if (i13 <= 19 && A07(642, 15, 6).equals(str)) {
                        String str5 = IF.A05;
                        if (A02[1].length() == 25) {
                            A02[5] = "blvbufqIPxoQJr0fY";
                            if (strA08.equals(str5)) {
                                if (!IF.A03.startsWith(A07(944, 2, 120))) {
                                }
                                return false;
                            }
                        } else if (strA08.equals(str5)) {
                            if (!IF.A03.startsWith(A07(944, 2, 120)) || IF.A03.startsWith(A07(997, 7, 26)) || IF.A03.startsWith(strA09) || IF.A03.startsWith(A07(991, 6, 3)) || IF.A03.startsWith(A07(1004, 2, 28))) {
                                return false;
                            }
                        }
                    }
                    if (IF.A02 <= 19 && IF.A03.startsWith(strA09) && A07(731, 26, 92).equals(str)) {
                        return false;
                    }
                    return (A07(922, 14, 50).equals(str2) && A07(555, 28, 76).equals(str)) ? false : true;
                }
            }
        } else if (A02[7].length() == 9) {
            A02[7] = "hakUGYeRw";
            if (!A07(Worker.WHAT_QUIT, 13, 19).equals(str) && !A07(TsExtractor.TS_STREAM_TYPE_DTS, 13, 123).equals(str) && !A07(151, 16, 44).equals(str)) {
                if (A02[4].charAt(9) == 'O') {
                    String[] strArr3 = A02;
                    strArr3[2] = "EEwaDdP6hCUFsSlrf0IgL40CqnGWtmyD";
                    strArr3[6] = "0sHU723LRgirr3xWcDqxLM5fqrJixtiS";
                    if (!A07(123, 15, 35).equals(str)) {
                        if (!A07(60, 10, 95).equals(str)) {
                        }
                    }
                } else if (!A07(123, 15, 35).equals(str)) {
                    if (!A07(60, 10, 95).equals(str)) {
                    }
                }
            }
            return false;
        }
        throw new RuntimeException();
    }

    public static boolean A0D(String str) {
        if (IF.A02 <= 22) {
            if ((A07(447, 10, 116).equals(IF.A06) || A07(439, 8, 11).equals(IF.A06)) && (A07(479, 22, 69).equals(str) || A07(501, 29, 80).equals(str))) {
                return true;
            }
        }
        return false;
    }
}
