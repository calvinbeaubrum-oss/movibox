package com.facebook.ads.redexgen.uinode;

import android.graphics.Point;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroup;
import com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroupArray;
import com.facebook.ads.internal.exoplayer2.thirdparty.trackselection.DefaultTrackSelector$Parameters;
import com.facebook.ads.internal.exoplayer2.thirdparty.trackselection.DefaultTrackSelector$SelectionOverride;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Bo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1229Bo extends W6 {
    public static byte[] A02;
    public static String[] A03 = {"x6AsNgj7kZHrnoNYywGy3amTsD0l", "S34B6ywREx44pNmlWPMRcx17PIA7Fyf2", "1XorlyLpztZAXiZGzmiFCBwFfMWU", "T5Z409y2ECpb8uf8T6KWShvwgb", "8Qiq8HU85lCoFhvN1dBY3zigvCratExc", "EyxqnSMNDXwhS4zpORn6ov", "S8xh7faol6xkg145s9aDIWkyvYFJ4njt", "Q6jD8cwEOZ"};
    public static final int[] A04;
    public final InterfaceC1331Gf A00;
    public final AtomicReference<DefaultTrackSelector$Parameters> A01;

    static {
        A0E();
        A04 = new int[0];
    }

    public C1229Bo() {
        this(null);
    }

    public C1229Bo(InterfaceC1331Gf interfaceC1331Gf) {
        this.A00 = interfaceC1331Gf;
        this.A01 = new AtomicReference<>(DefaultTrackSelector$Parameters.A0J);
    }

    public static int A00(int i11, int i12) {
        if (i11 == -1) {
            return i12 == -1 ? 0 : -1;
        }
        if (i12 == -1) {
            return 1;
        }
        return i11 - i12;
    }

    public static int A01(int i11, int i12) {
        if (i11 > i12) {
            return 1;
        }
        return i12 > i11 ? -1 : 0;
    }

    public static int A03(TrackGroup trackGroup, int[] iArr, int i11, String str, int i12, int i13, int i14, List<Integer> list) {
        int i15 = 0;
        for (int i16 = 0; i16 < list.size(); i16++) {
            int iIntValue = list.get(i16).intValue();
            if (A0L(trackGroup.A01(iIntValue), str, iArr[iIntValue], i11, i12, i13, i14)) {
                i15++;
            }
        }
        return i15;
    }

    public static int A04(TrackGroup trackGroup, int[] iArr, GW gw2) {
        int i11 = 0;
        for (int i12 = 0; i12 < trackGroup.A01; i12++) {
            if (A0J(trackGroup.A01(i12), iArr[i12], gw2)) {
                i11++;
            }
        }
        return i11;
    }

    public static Point A05(boolean z11, int i11, int i12, int i13, int i14) {
        if (z11) {
            if ((i13 > i14) != (i11 > i12)) {
                i11 = i12;
                i12 = i11;
            }
        }
        return i13 * i12 >= i14 * i11 ? new Point(i11, IF.A04(i11 * i14, i13)) : new Point(IF.A04(i12 * i13, i14), i12);
    }

    private final C1228Bn A06(int i11, TrackGroupArray trackGroupArray, int[][] iArr, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters) throws C11669c {
        TrackGroup trackGroup = null;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < trackGroupArray.A01; i14++) {
            TrackGroup trackGroupA01 = trackGroupArray.A01(i14);
            if (A03[1].charAt(28) != 'F') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[2] = "1NYDqnXuXqFwXvhmhx1oqfe5tY82";
            strArr[5] = "WKIyqdfHfHQHhajlNNxex4";
            int[] iArr2 = iArr[i14];
            for (int i15 = 0; i15 < trackGroupA01.A01; i15++) {
                if (A0H(iArr2[i15], defaultTrackSelector$Parameters.A0B)) {
                    int i16 = (trackGroupA01.A01(i15).A0D & 1) != 0 ? 2 : 1;
                    if (A0H(iArr2[i15], false)) {
                        i16 += 1000;
                    }
                    if (i16 > i13) {
                        trackGroup = trackGroupA01;
                        i12 = i15;
                        i13 = i16;
                    }
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return new C1228Bn(trackGroup, i12);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x006d  */
    /* JADX WARN: Code duplicated, block: B:18:0x0081  */
    /* JADX WARN: Code duplicated, block: B:32:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:35:0x00b0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:36:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:39:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:41:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:43:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:47:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:49:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:50:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:51:0x00de  */
    /* JADX WARN: Code duplicated, block: B:53:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:55:0x00ea A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:58:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:60:0x00f9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:61:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:62:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:64:0x0101  */
    /* JADX WARN: Code duplicated, block: B:78:0x0119 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:82:0x00ac A[SYNTHETIC] */
    public static C1228Bn A07(TrackGroupArray trackGroupArray, int[][] iArr, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters) {
        boolean z11;
        int i11;
        boolean zA0H;
        boolean z12;
        int iA0E;
        int iA00;
        int i12;
        String[] strArr;
        TrackGroup trackGroup = null;
        int i13 = 0;
        int i14 = 0;
        int i15 = -1;
        int iA0E2 = -1;
        for (int i16 = 0; i16 < trackGroupArray.A01; i16++) {
            TrackGroup trackGroupA01 = trackGroupArray.A01(i16);
            List<Integer> listA0D = A0D(trackGroupA01, defaultTrackSelector$Parameters.A06, defaultTrackSelector$Parameters.A05, defaultTrackSelector$Parameters.A0F);
            int[] iArr2 = iArr[i16];
            int i17 = 0;
            while (true) {
                int i18 = trackGroupA01.A01;
                String[] strArr2 = A03;
                if (strArr2[2].length() != strArr2[5].length()) {
                    A03[0] = "lwqQHO";
                    if (i17 < i18) {
                        if (A0H(iArr2[i17], defaultTrackSelector$Parameters.A0B)) {
                            Format formatA01 = trackGroupA01.A01(i17);
                            boolean zContains = listA0D.contains(Integer.valueOf(i17));
                            String[] strArr3 = A03;
                            if (strArr3[2].length() != strArr3[5].length()) {
                                A03[6] = "SiU1QSN6MQFkL93X4OOrhG4pGOhEurBM";
                                if (zContains) {
                                    i12 = formatA01.A0F;
                                    strArr = A03;
                                    if (strArr[3].length() != strArr[7].length()) {
                                        A03[1] = "4KlbdBkqrnIgKSOErHym9NPyt3h5FUou";
                                        z11 = (i12 != -1 || formatA01.A0F <= defaultTrackSelector$Parameters.A03) && (formatA01.A08 == -1 || formatA01.A08 <= defaultTrackSelector$Parameters.A02) && (formatA01.A04 == -1 || formatA01.A04 <= defaultTrackSelector$Parameters.A01);
                                    }
                                }
                                if (z11 || defaultTrackSelector$Parameters.A0C) {
                                    if (z11) {
                                        i11 = 2;
                                    } else {
                                        i11 = 1;
                                    }
                                    zA0H = A0H(iArr2[i17], false);
                                    if (zA0H) {
                                        i11 += 1000;
                                    }
                                    if (i11 > i14) {
                                        z12 = true;
                                    } else {
                                        z12 = false;
                                    }
                                    if (i11 == i14) {
                                        if (!defaultTrackSelector$Parameters.A0D) {
                                            iA0E = formatA01.A0E();
                                            if (iA0E != iA0E2) {
                                                iA00 = A00(iA0E, iA0E2);
                                            } else {
                                                iA00 = A00(formatA01.A04, i15);
                                            }
                                            if (!zA0H && z11) {
                                                z12 = iA00 > 0;
                                            } else if (iA00 < 0) {
                                                z12 = true;
                                            } else {
                                                z12 = false;
                                            }
                                        } else if (A00(formatA01.A04, i15) < 0) {
                                            z12 = true;
                                        } else {
                                            z12 = false;
                                        }
                                    }
                                    if (z12) {
                                        trackGroup = trackGroupA01;
                                        i13 = i17;
                                        i14 = i11;
                                        i15 = formatA01.A04;
                                        iA0E2 = formatA01.A0E();
                                    }
                                }
                            } else {
                                String[] strArr4 = A03;
                                strArr4[2] = "DpIh5EonHVTuVHRer6KDIMhApdM7";
                                strArr4[5] = "CmkW9iHHxPPPILgrY4olMD";
                                if (zContains) {
                                    i12 = formatA01.A0F;
                                    strArr = A03;
                                    if (strArr[3].length() != strArr[7].length()) {
                                        A03[1] = "4KlbdBkqrnIgKSOErHym9NPyt3h5FUou";
                                        if (i12 != -1) {
                                        }
                                    }
                                }
                                if (z11) {
                                    if (z11) {
                                        i11 = 2;
                                    } else {
                                        i11 = 1;
                                    }
                                    zA0H = A0H(iArr2[i17], false);
                                    if (zA0H) {
                                        i11 += 1000;
                                    }
                                    if (i11 > i14) {
                                        z12 = true;
                                    } else {
                                        z12 = false;
                                    }
                                    if (i11 == i14) {
                                        if (!defaultTrackSelector$Parameters.A0D) {
                                            iA0E = formatA01.A0E();
                                            if (iA0E != iA0E2) {
                                                iA00 = A00(iA0E, iA0E2);
                                            } else {
                                                iA00 = A00(formatA01.A04, i15);
                                            }
                                            if (!zA0H) {
                                                if (iA00 < 0) {
                                                    z12 = true;
                                                } else {
                                                    z12 = false;
                                                }
                                            } else if (iA00 < 0) {
                                                z12 = true;
                                            } else {
                                                z12 = false;
                                            }
                                        } else if (A00(formatA01.A04, i15) < 0) {
                                            z12 = true;
                                        } else {
                                            z12 = false;
                                        }
                                    }
                                    if (z12) {
                                        trackGroup = trackGroupA01;
                                        i13 = i17;
                                        i14 = i11;
                                        i15 = formatA01.A04;
                                        iA0E2 = formatA01.A0E();
                                    }
                                } else {
                                    if (z11) {
                                        i11 = 2;
                                    } else {
                                        i11 = 1;
                                    }
                                    zA0H = A0H(iArr2[i17], false);
                                    if (zA0H) {
                                        i11 += 1000;
                                    }
                                    if (i11 > i14) {
                                        z12 = true;
                                    } else {
                                        z12 = false;
                                    }
                                    if (i11 == i14) {
                                        if (!defaultTrackSelector$Parameters.A0D) {
                                            iA0E = formatA01.A0E();
                                            if (iA0E != iA0E2) {
                                                iA00 = A00(iA0E, iA0E2);
                                            } else {
                                                iA00 = A00(formatA01.A04, i15);
                                            }
                                            if (!zA0H) {
                                                if (iA00 < 0) {
                                                    z12 = true;
                                                } else {
                                                    z12 = false;
                                                }
                                            } else if (iA00 < 0) {
                                                z12 = true;
                                            } else {
                                                z12 = false;
                                            }
                                        } else if (A00(formatA01.A04, i15) < 0) {
                                            z12 = true;
                                        } else {
                                            z12 = false;
                                        }
                                    }
                                    if (z12) {
                                        trackGroup = trackGroupA01;
                                        i13 = i17;
                                        i14 = i11;
                                        i15 = formatA01.A04;
                                        iA0E2 = formatA01.A0E();
                                    }
                                }
                            }
                            if (z11) {
                                if (z11) {
                                    i11 = 2;
                                } else {
                                    i11 = 1;
                                }
                                zA0H = A0H(iArr2[i17], false);
                                if (zA0H) {
                                    i11 += 1000;
                                }
                                if (i11 > i14) {
                                    z12 = true;
                                } else {
                                    z12 = false;
                                }
                                if (i11 == i14) {
                                    if (!defaultTrackSelector$Parameters.A0D) {
                                        iA0E = formatA01.A0E();
                                        if (iA0E != iA0E2) {
                                            iA00 = A00(iA0E, iA0E2);
                                        } else {
                                            iA00 = A00(formatA01.A04, i15);
                                        }
                                        if (!zA0H) {
                                            if (iA00 < 0) {
                                                z12 = true;
                                            } else {
                                                z12 = false;
                                            }
                                        } else if (iA00 < 0) {
                                            z12 = true;
                                        } else {
                                            z12 = false;
                                        }
                                    } else if (A00(formatA01.A04, i15) < 0) {
                                        z12 = true;
                                    } else {
                                        z12 = false;
                                    }
                                }
                                if (z12) {
                                    trackGroup = trackGroupA01;
                                    i13 = i17;
                                    i14 = i11;
                                    i15 = formatA01.A04;
                                    iA0E2 = formatA01.A0E();
                                }
                            } else {
                                if (z11) {
                                    i11 = 2;
                                } else {
                                    i11 = 1;
                                }
                                zA0H = A0H(iArr2[i17], false);
                                if (zA0H) {
                                    i11 += 1000;
                                }
                                if (i11 > i14) {
                                    z12 = true;
                                } else {
                                    z12 = false;
                                }
                                if (i11 == i14) {
                                    if (!defaultTrackSelector$Parameters.A0D) {
                                        iA0E = formatA01.A0E();
                                        if (iA0E != iA0E2) {
                                            iA00 = A00(iA0E, iA0E2);
                                        } else {
                                            iA00 = A00(formatA01.A04, i15);
                                        }
                                        if (!zA0H) {
                                            if (iA00 < 0) {
                                                z12 = true;
                                            } else {
                                                z12 = false;
                                            }
                                        } else if (iA00 < 0) {
                                            z12 = true;
                                        } else {
                                            z12 = false;
                                        }
                                    } else if (A00(formatA01.A04, i15) < 0) {
                                        z12 = true;
                                    } else {
                                        z12 = false;
                                    }
                                }
                                if (z12) {
                                    trackGroup = trackGroupA01;
                                    i13 = i17;
                                    i14 = i11;
                                    i15 = formatA01.A04;
                                    iA0E2 = formatA01.A0E();
                                }
                            }
                        }
                        i17++;
                    }
                }
                throw new RuntimeException();
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return new C1228Bn(trackGroup, i13);
    }

    private final C1228Bn A08(TrackGroupArray trackGroupArray, int[][] iArr, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters) throws C11669c {
        int i11;
        TrackGroup trackGroup = null;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < trackGroupArray.A01; i14++) {
            TrackGroup trackGroupA01 = trackGroupArray.A01(i14);
            int[] iArr2 = iArr[i14];
            for (int i15 = 0; i15 < trackGroupA01.A01; i15++) {
                if (A0H(iArr2[i15], defaultTrackSelector$Parameters.A0B)) {
                    Format formatA01 = trackGroupA01.A01(i15);
                    int i16 = formatA01.A0D & (defaultTrackSelector$Parameters.A00 ^ (-1));
                    boolean z11 = (i16 & 1) != 0;
                    boolean z12 = (i16 & 2) != 0;
                    boolean zA0K = A0K(formatA01, defaultTrackSelector$Parameters.A08);
                    if (zA0K || (defaultTrackSelector$Parameters.A0E && A0I(formatA01))) {
                        i11 = (z11 ? 8 : !z12 ? 6 : 4) + (zA0K ? 1 : 0);
                    } else if (z11) {
                        i11 = 3;
                    } else if (z12) {
                        i11 = A0K(formatA01, defaultTrackSelector$Parameters.A07) ? 2 : 1;
                    }
                    if (A0H(iArr2[i15], false)) {
                        i11 += 1000;
                    }
                    if (i11 > i13) {
                        trackGroup = trackGroupA01;
                        i12 = i15;
                        i13 = i11;
                    }
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return new C1228Bn(trackGroup, i12);
    }

    public static InterfaceC1332Gg A09(TrackGroupArray trackGroupArray, int[][] iArr, int i11, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters, InterfaceC1331Gf interfaceC1331Gf) throws C11669c {
        int i12 = defaultTrackSelector$Parameters.A0A ? 24 : 16;
        boolean z11 = defaultTrackSelector$Parameters.A09 && (i11 & i12) != 0;
        for (int i13 = 0; i13 < trackGroupArray.A01; i13++) {
            TrackGroup trackGroupA01 = trackGroupArray.A01(i13);
            int[] iArrA0O = A0O(trackGroupA01, iArr[i13], z11, i12, defaultTrackSelector$Parameters.A03, defaultTrackSelector$Parameters.A02, defaultTrackSelector$Parameters.A01, defaultTrackSelector$Parameters.A06, defaultTrackSelector$Parameters.A05, defaultTrackSelector$Parameters.A0F);
            if (iArrA0O.length > 0) {
                return ((InterfaceC1331Gf) AbstractC1351Ha.A01(interfaceC1331Gf)).A4o(trackGroupA01, iArrA0O);
            }
        }
        return null;
    }

    private final InterfaceC1332Gg A0A(TrackGroupArray trackGroupArray, int[][] iArr, int i11, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters, InterfaceC1331Gf interfaceC1331Gf) throws C11669c {
        int i12 = -1;
        int i13 = -1;
        GX gx2 = null;
        for (int i14 = 0; i14 < trackGroupArray.A01; i14++) {
            TrackGroup trackGroupA01 = trackGroupArray.A01(i14);
            int[] iArr2 = iArr[i14];
            for (int i15 = 0; i15 < trackGroupA01.A01; i15++) {
                if (A0H(iArr2[i15], defaultTrackSelector$Parameters.A0B)) {
                    GX gx3 = new GX(trackGroupA01.A01(i15), defaultTrackSelector$Parameters, iArr2[i15]);
                    if (gx2 == null || gx3.A00(gx2) > 0) {
                        i13 = i14;
                        i12 = i15;
                        gx2 = gx3;
                    }
                }
            }
        }
        if (i13 == -1) {
            return null;
        }
        TrackGroup trackGroupA02 = trackGroupArray.A01(i13);
        if (!defaultTrackSelector$Parameters.A0D && interfaceC1331Gf != null) {
            int[] iArrA0N = A0N(trackGroupA02, iArr[i13], defaultTrackSelector$Parameters.A09);
            if (iArrA0N.length > 0) {
                return interfaceC1331Gf.A4o(trackGroupA02, iArrA0N);
            }
        }
        return new C1228Bn(trackGroupA02, i12);
    }

    private final InterfaceC1332Gg A0B(TrackGroupArray trackGroupArray, int[][] iArr, int i11, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters, InterfaceC1331Gf interfaceC1331Gf) throws C11669c {
        InterfaceC1332Gg interfaceC1332GgA09 = null;
        if (!defaultTrackSelector$Parameters.A0D && interfaceC1331Gf != null) {
            interfaceC1332GgA09 = A09(trackGroupArray, iArr, i11, defaultTrackSelector$Parameters, interfaceC1331Gf);
        }
        return interfaceC1332GgA09 == null ? A07(trackGroupArray, iArr, defaultTrackSelector$Parameters) : interfaceC1332GgA09;
    }

    public static String A0C(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 116);
        }
        return new String(bArrCopyOfRange);
    }

    public static List<Integer> A0D(TrackGroup trackGroup, int i11, int i12, boolean z11) {
        ArrayList arrayList = new ArrayList(trackGroup.A01);
        for (int i13 = 0; i13 < trackGroup.A01; i13++) {
            arrayList.add(Integer.valueOf(i13));
        }
        if (i11 == Integer.MAX_VALUE || i12 == Integer.MAX_VALUE) {
            return arrayList;
        }
        int i14 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        for (int i15 = 0; i15 < trackGroup.A01; i15++) {
            Format formatA01 = trackGroup.A01(i15);
            if (formatA01.A0F > 0 && formatA01.A08 > 0) {
                Point pointA05 = A05(z11, i11, i12, formatA01.A0F, formatA01.A08);
                int i16 = formatA01.A0F * formatA01.A08;
                if (formatA01.A0F >= ((int) (pointA05.x * 0.98f)) && formatA01.A08 >= ((int) (pointA05.y * 0.98f)) && i16 < i14) {
                    i14 = i16;
                }
            }
        }
        if (i14 != Integer.MAX_VALUE) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                int iA0E = trackGroup.A01(((Integer) arrayList.get(size)).intValue()).A0E();
                if (iA0E == -1 || iA0E > i14) {
                    arrayList.remove(size);
                }
            }
        }
        return arrayList;
    }

    public static void A0E() {
        A02 = new byte[]{96, 123, 113};
    }

    public static void A0F(TrackGroup trackGroup, int[] iArr, int i11, String str, int i12, int i13, int i14, List<Integer> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            int iIntValue = list.get(size).intValue();
            if (!A0L(trackGroup.A01(iIntValue), str, iArr[iIntValue], i11, i12, i13, i14)) {
                list.remove(size);
            }
        }
    }

    public static void A0G(C1330Ge c1330Ge, int[][][] iArr, AB[] abArr, InterfaceC1332Gg[] interfaceC1332GgArr, int i11) {
        if (i11 == 0) {
            return;
        }
        int i12 = -1;
        int i13 = -1;
        boolean z11 = true;
        int i14 = 0;
        while (true) {
            if (i14 >= c1330Ge.A00()) {
                break;
            }
            int iA01 = c1330Ge.A01(i14);
            InterfaceC1332Gg interfaceC1332Gg = interfaceC1332GgArr[i14];
            if ((iA01 == 1 || iA01 == 2) && interfaceC1332Gg != null && A0M(iArr[i14], c1330Ge.A02(i14), interfaceC1332Gg)) {
                if (iA01 == 1) {
                    if (i12 != -1) {
                        z11 = false;
                        break;
                    }
                    i12 = i14;
                } else {
                    if (i13 != -1) {
                        z11 = false;
                        break;
                    }
                    i13 = i14;
                }
            }
            i14++;
        }
        if (z11 && ((i12 == -1 || i13 == -1) ? false : true)) {
            AB ab2 = new AB(i11);
            abArr[i12] = ab2;
            abArr[i13] = ab2;
        }
    }

    public static boolean A0H(int i11, boolean z11) {
        int i12 = i11 & 7;
        return i12 == 4 || (z11 && i12 == 3);
    }

    public static boolean A0I(Format format) {
        return TextUtils.isEmpty(format.A0N) || A0K(format, A0C(0, 3, 97));
    }

    public static boolean A0J(Format format, int i11, GW gw2) {
        if (!A0H(i11, false) || format.A05 != gw2.A00 || format.A0C != gw2.A01) {
            return false;
        }
        String str = gw2.A02;
        String[] strArr = A03;
        if (strArr[3].length() == strArr[7].length()) {
            throw new RuntimeException();
        }
        A03[4] = "Z4TnxuroRrU42RhZWOmYjmwLcPTU1MVO";
        return str == null || TextUtils.equals(gw2.A02, format.A0O);
    }

    public static boolean A0K(Format format, String str) {
        if (str != null) {
            boolean zEquals = TextUtils.equals(str, IF.A0L(format.A0N));
            if (A03[1].charAt(28) != 'F') {
                throw new RuntimeException();
            }
            A03[6] = "X09dGmvImKzkjml92Go2OBGPrO7s8ElS";
            if (zEquals) {
                return true;
            }
        }
        return false;
    }

    public static boolean A0L(Format format, String str, int i11, int i12, int i13, int i14, int i15) {
        if (!A0H(i11, false) || (i11 & i12) == 0) {
            return false;
        }
        if (str != null && !IF.A0g(format.A0O, str)) {
            return false;
        }
        if (format.A0F != -1 && format.A0F > i13) {
            return false;
        }
        int i16 = format.A08;
        String[] strArr = A03;
        if (strArr[2].length() == strArr[5].length()) {
            throw new RuntimeException();
        }
        A03[4] = "SWfcLm8XXzRqeXuobK6MjvAJ3gvDaDv7";
        if (i16 == -1 || format.A08 <= i14) {
            return format.A04 == -1 || format.A04 <= i15;
        }
        return false;
    }

    public static boolean A0M(int[][] iArr, TrackGroupArray trackGroupArray, InterfaceC1332Gg interfaceC1332Gg) {
        if (interfaceC1332Gg == null) {
            return false;
        }
        int iA00 = trackGroupArray.A00(interfaceC1332Gg.A8A());
        for (int i11 = 0; i11 < interfaceC1332Gg.length(); i11++) {
            if ((iArr[iA00][interfaceC1332Gg.A7C(i11)] & 32) != 32) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0052  */
    public static int[] A0N(TrackGroup trackGroup, int[] iArr, boolean z11) {
        int i11;
        int i12 = 0;
        GW gw2 = null;
        HashSet hashSet = new HashSet();
        int i13 = 0;
        while (true) {
            int i14 = trackGroup.A01;
            if (A03[4].charAt(23) == 'I') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[2] = "meGLfV23Rzl9igGpAxJQFKheW1LS";
            strArr[5] = "FiWVyQMXAFPncybwnc3GZ7";
            if (i13 >= i14) {
                if (i12 <= 1) {
                    return A04;
                }
                int[] iArr2 = new int[i12];
                int i15 = 0;
                if (A03[4].charAt(23) != 'I') {
                    String[] strArr2 = A03;
                    strArr2[2] = "4LRww03tsnXN2lDzEbKe5Z8dH5qv";
                    strArr2[5] = "mlJWR4ilrpKl1KfE3NcYmb";
                    i11 = 0;
                } else {
                    i11 = 0;
                }
                while (i11 < trackGroup.A01) {
                    Format formatA01 = trackGroup.A01(i11);
                    int i16 = iArr[i11];
                    Object objA01 = AbstractC1351Ha.A01(gw2);
                    if (A03[1].charAt(28) != 'F') {
                        throw new RuntimeException();
                    }
                    A03[4] = "nSxM8ZPkvfs0IWAG7eseSPBOLfK4wpcw";
                    if (A0J(formatA01, i16, (GW) objA01)) {
                        iArr2[i15] = i11;
                        i15++;
                    }
                    i11++;
                }
                return iArr2;
            }
            Format formatA02 = trackGroup.A01(i13);
            GW gw3 = new GW(formatA02.A05, formatA02.A0C, z11 ? null : formatA02.A0O);
            if (hashSet.add(gw3)) {
                int iA04 = A04(trackGroup, iArr, gw3);
                if (A03[1].charAt(28) == 'F') {
                    A03[1] = "qbEeyg8BdzMApnixm7aM3K2w4BJzFZ2Y";
                    if (iA04 > i12) {
                        gw2 = gw3;
                        i12 = iA04;
                    }
                } else if (iA04 > i12) {
                    gw2 = gw3;
                    i12 = iA04;
                }
            }
            i13++;
        }
    }

    public static int[] A0O(TrackGroup trackGroup, int[] iArr, boolean z11, int i11, int i12, int i13, int i14, int i15, int i16, boolean z12) {
        int iA03;
        if (trackGroup.A01 < 2) {
            return A04;
        }
        List<Integer> listA0D = A0D(trackGroup, i15, i16, z12);
        if (listA0D.size() < 2) {
            return A04;
        }
        String str = null;
        if (!z11) {
            HashSet hashSet = new HashSet();
            int i17 = 0;
            for (int i18 = 0; i18 < listA0D.size(); i18++) {
                String str2 = trackGroup.A01(listA0D.get(i18).intValue()).A0O;
                if (hashSet.add(str2) && (iA03 = A03(trackGroup, iArr, i11, str2, i12, i13, i14, listA0D)) > i17) {
                    str = str2;
                    i17 = iA03;
                }
            }
        }
        A0F(trackGroup, iArr, i11, str, i12, i13, i14, listA0D);
        return listA0D.size() < 2 ? A04 : IF.A0j(listA0D);
    }

    private final InterfaceC1332Gg[] A0P(C1330Ge c1330Ge, int[][][] iArr, int[] iArr2, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters) throws C11669c {
        int iA00 = c1330Ge.A00();
        InterfaceC1332Gg[] interfaceC1332GgArr = new InterfaceC1332Gg[iA00];
        boolean z11 = false;
        boolean z12 = false;
        for (int i11 = 0; i11 < iA00; i11++) {
            if (2 == c1330Ge.A01(i11)) {
                if (!z12) {
                    interfaceC1332GgArr[i11] = A0B(c1330Ge.A02(i11), iArr[i11], iArr2[i11], defaultTrackSelector$Parameters, this.A00);
                    z12 = interfaceC1332GgArr[i11] != null;
                }
                z11 |= c1330Ge.A02(i11).A01 > 0;
            }
        }
        boolean z13 = false;
        boolean z14 = false;
        for (int i12 = 0; i12 < iA00; i12++) {
            int iA01 = c1330Ge.A01(i12);
            switch (iA01) {
                case 1:
                    if (!z13) {
                        interfaceC1332GgArr[i12] = A0A(c1330Ge.A02(i12), iArr[i12], iArr2[i12], defaultTrackSelector$Parameters, z11 ? null : this.A00);
                        z13 = interfaceC1332GgArr[i12] != null;
                    }
                    break;
                case 2:
                    break;
                case 3:
                    if (z14) {
                        continue;
                    } else {
                        interfaceC1332GgArr[i12] = A08(c1330Ge.A02(i12), iArr[i12], defaultTrackSelector$Parameters);
                        z14 = interfaceC1332GgArr[i12] != null;
                        if (A03[1].charAt(28) != 'F') {
                            throw new RuntimeException();
                        }
                        String[] strArr = A03;
                        strArr[2] = "QJl7DztNVPNycYqDWlGKy9194VAG";
                        strArr[5] = "9kW2zRUIc2UhcVCPTVcu4Y";
                    }
                    break;
                default:
                    interfaceC1332GgArr[i12] = A06(iA01, c1330Ge.A02(i12), iArr[i12], defaultTrackSelector$Parameters);
                    break;
            }
        }
        return interfaceC1332GgArr;
    }

    @Override // com.facebook.ads.redexgen.uinode.W6
    public final Pair<AB[], InterfaceC1332Gg[]> A0V(C1330Ge c1330Ge, int[][][] iArr, int[] iArr2) throws C11669c {
        DefaultTrackSelector$Parameters defaultTrackSelector$Parameters = this.A01.get();
        int iA00 = c1330Ge.A00();
        InterfaceC1332Gg[] interfaceC1332GgArrA0P = A0P(c1330Ge, iArr, iArr2, defaultTrackSelector$Parameters);
        for (int i11 = 0; i11 < iA00; i11++) {
            if (defaultTrackSelector$Parameters.A06(i11)) {
                interfaceC1332GgArrA0P[i11] = null;
            } else {
                TrackGroupArray trackGroupArrayA02 = c1330Ge.A02(i11);
                if (defaultTrackSelector$Parameters.A07(i11, trackGroupArrayA02)) {
                    DefaultTrackSelector$SelectionOverride defaultTrackSelector$SelectionOverrideA05 = defaultTrackSelector$Parameters.A05(i11, trackGroupArrayA02);
                    if (defaultTrackSelector$SelectionOverrideA05 == null) {
                        interfaceC1332GgArrA0P[i11] = null;
                    } else if (defaultTrackSelector$SelectionOverrideA05.A01 == 1) {
                        interfaceC1332GgArrA0P[i11] = new C1228Bn(trackGroupArrayA02.A01(defaultTrackSelector$SelectionOverrideA05.A00), defaultTrackSelector$SelectionOverrideA05.A02[0]);
                    } else {
                        interfaceC1332GgArrA0P[i11] = ((InterfaceC1331Gf) AbstractC1351Ha.A01(this.A00)).A4o(trackGroupArrayA02.A01(defaultTrackSelector$SelectionOverrideA05.A00), defaultTrackSelector$SelectionOverrideA05.A02);
                    }
                }
            }
        }
        AB[] abArr = new AB[iA00];
        for (int i12 = 0; i12 < iA00; i12++) {
            abArr[i12] = !defaultTrackSelector$Parameters.A06(i12) && (c1330Ge.A01(i12) == 5 || interfaceC1332GgArrA0P[i12] != null) ? AB.A01 : null;
        }
        A0G(c1330Ge, iArr, abArr, interfaceC1332GgArrA0P, defaultTrackSelector$Parameters.A04);
        return Pair.create(abArr, interfaceC1332GgArrA0P);
    }
}
