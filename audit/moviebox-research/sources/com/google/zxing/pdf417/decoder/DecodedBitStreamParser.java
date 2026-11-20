package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import com.vungle.warren.error.VungleException;
import hm.d;
import hm.i;
import java.math.BigInteger;
import java.util.Arrays;
import um.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class DecodedBitStreamParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f41549a = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char[] f41550b = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final BigInteger[] f41551c;

    /* JADX INFO: compiled from: source.java */
    public enum Mode {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f41552a;

        static {
            int[] iArr = new int[Mode.values().length];
            f41552a = iArr;
            try {
                iArr[Mode.ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41552a[Mode.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f41552a[Mode.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f41552a[Mode.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f41552a[Mode.ALPHA_SHIFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f41552a[Mode.PUNCT_SHIFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        f41551c = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger bigIntegerValueOf = BigInteger.valueOf(900L);
        bigIntegerArr[1] = bigIntegerValueOf;
        int i11 = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = f41551c;
            if (i11 >= bigIntegerArr2.length) {
                return;
            }
            bigIntegerArr2[i11] = bigIntegerArr2[i11 - 1].multiply(bigIntegerValueOf);
            i11++;
        }
    }

    public static int a(int i11, int[] iArr, int i12, i iVar) throws FormatException {
        int i13;
        int i14;
        boolean z11 = false;
        while (i12 < iArr[0] && !z11) {
            while (true) {
                i13 = iArr[0];
                if (i12 >= i13 || iArr[i12] != 927) {
                    break;
                }
                iVar.f(iArr[i12 + 1]);
                i12 += 2;
            }
            if (i12 >= i13 || iArr[i12] >= 900) {
                z11 = true;
            } else {
                long j11 = 0;
                int i15 = 0;
                while (true) {
                    i14 = i12 + 1;
                    j11 = (j11 * 900) + ((long) iArr[i12]);
                    i15++;
                    if (i15 >= 5 || i14 >= iArr[0] || iArr[i14] >= 900) {
                        break;
                    }
                    i12 = i14;
                }
                if (i15 != 5 || (i11 != 924 && (i14 >= iArr[0] || iArr[i14] >= 900))) {
                    i14 -= i15;
                    while (i14 < iArr[0] && !z11) {
                        int i16 = i14 + 1;
                        int i17 = iArr[i14];
                        if (i17 < 900) {
                            iVar.a((byte) i17);
                            i14 = i16;
                        } else if (i17 == 927) {
                            i14 += 2;
                            iVar.f(iArr[i16]);
                        } else {
                            z11 = true;
                        }
                    }
                } else {
                    for (int i18 = 0; i18 < 6; i18++) {
                        iVar.a((byte) (j11 >> ((5 - i18) * 8)));
                    }
                }
                i12 = i14;
            }
        }
        return i12;
    }

    public static d b(int[] iArr, String str) throws FormatException {
        i iVar = new i(iArr.length * 2);
        int iG = g(iArr, 1, iVar);
        c cVar = new c();
        while (iG < iArr[0]) {
            int i11 = iG + 1;
            int i12 = iArr[iG];
            if (i12 != 913) {
                switch (i12) {
                    case 900:
                        iG = g(iArr, i11, iVar);
                        continue;
                    case 901:
                        break;
                    case 902:
                        iG = f(iArr, i11, iVar);
                        continue;
                    default:
                        switch (i12) {
                            case 922:
                            case 923:
                                throw FormatException.getFormatInstance();
                            case 924:
                                break;
                            case 925:
                                iG += 2;
                                continue;
                            case 926:
                                iG += 3;
                                continue;
                            case 927:
                                iG += 2;
                                iVar.f(iArr[i11]);
                                continue;
                            case 928:
                                iG = d(iArr, i11, cVar);
                                continue;
                            default:
                                iG = g(iArr, iG, iVar);
                                continue;
                        }
                        break;
                }
                iG = a(i12, iArr, i11, iVar);
            } else {
                iG += 2;
                iVar.b((char) iArr[i11]);
            }
        }
        if (iVar.h() && cVar.a() == null) {
            throw FormatException.getFormatInstance();
        }
        d dVar = new d(null, iVar.toString(), null, str);
        dVar.p(cVar);
        return dVar;
    }

    public static String c(int[] iArr, int i11) throws FormatException {
        BigInteger bigIntegerAdd = BigInteger.ZERO;
        for (int i12 = 0; i12 < i11; i12++) {
            bigIntegerAdd = bigIntegerAdd.add(f41551c[(i11 - i12) - 1].multiply(BigInteger.valueOf(iArr[i12])));
        }
        String string = bigIntegerAdd.toString();
        if (string.charAt(0) == '1') {
            return string.substring(1);
        }
        throw FormatException.getFormatInstance();
    }

    public static int d(int[] iArr, int i11, c cVar) throws FormatException {
        int i12;
        if (i11 + 2 > iArr[0]) {
            throw FormatException.getFormatInstance();
        }
        int[] iArr2 = new int[2];
        int i13 = 0;
        while (i13 < 2) {
            iArr2[i13] = iArr[i11];
            i13++;
            i11++;
        }
        String strC = c(iArr2, 2);
        if (strC.isEmpty()) {
            cVar.k(0);
        } else {
            try {
                cVar.k(Integer.parseInt(strC));
            } catch (NumberFormatException unused) {
                throw FormatException.getFormatInstance();
            }
        }
        StringBuilder sb2 = new StringBuilder();
        while (i11 < iArr[0] && i11 < iArr.length && (i12 = iArr[i11]) != 922 && i12 != 923) {
            sb2.append(String.format("%03d", Integer.valueOf(i12)));
            i11++;
        }
        if (sb2.length() == 0) {
            throw FormatException.getFormatInstance();
        }
        cVar.e(sb2.toString());
        int i14 = iArr[i11] == 923 ? i11 + 1 : -1;
        while (i11 < iArr[0]) {
            int i15 = iArr[i11];
            if (i15 == 922) {
                i11++;
                cVar.h(true);
            } else {
                if (i15 != 923) {
                    throw FormatException.getFormatInstance();
                }
                switch (iArr[i11 + 1]) {
                    case 0:
                        i iVar = new i();
                        i11 = g(iArr, i11 + 2, iVar);
                        cVar.f(iVar.toString());
                        break;
                    case 1:
                        i iVar2 = new i();
                        i11 = f(iArr, i11 + 2, iVar2);
                        try {
                            cVar.j(Integer.parseInt(iVar2.toString()));
                        } catch (NumberFormatException unused2) {
                            throw FormatException.getFormatInstance();
                        }
                        break;
                    case 2:
                        i iVar3 = new i();
                        i11 = f(iArr, i11 + 2, iVar3);
                        try {
                            cVar.m(Long.parseLong(iVar3.toString()));
                        } catch (NumberFormatException unused3) {
                            throw FormatException.getFormatInstance();
                        }
                        break;
                    case 3:
                        i iVar4 = new i();
                        i11 = g(iArr, i11 + 2, iVar4);
                        cVar.l(iVar4.toString());
                        break;
                    case 4:
                        i iVar5 = new i();
                        i11 = g(iArr, i11 + 2, iVar5);
                        cVar.c(iVar5.toString());
                        break;
                    case 5:
                        i iVar6 = new i();
                        i11 = f(iArr, i11 + 2, iVar6);
                        try {
                            cVar.g(Long.parseLong(iVar6.toString()));
                        } catch (NumberFormatException unused4) {
                            throw FormatException.getFormatInstance();
                        }
                        break;
                    case 6:
                        i iVar7 = new i();
                        i11 = f(iArr, i11 + 2, iVar7);
                        try {
                            cVar.d(Integer.parseInt(iVar7.toString()));
                        } catch (NumberFormatException unused5) {
                            throw FormatException.getFormatInstance();
                        }
                        break;
                    default:
                        throw FormatException.getFormatInstance();
                }
            }
        }
        if (i14 != -1) {
            int i16 = i11 - i14;
            if (cVar.b()) {
                i16--;
            }
            if (i16 > 0) {
                cVar.i(Arrays.copyOfRange(iArr, i14, i16 + i14));
            }
        }
        return i11;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:49:0x009d  */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0020. Please report as an issue. */
    public static Mode e(int[] iArr, int[] iArr2, int i11, i iVar, Mode mode) {
        Mode mode2;
        int i12;
        char c11;
        char c12;
        Mode mode3 = mode;
        Mode mode4 = mode3;
        Mode mode5 = mode4;
        int i13 = 0;
        while (i13 < i11) {
            int i14 = iArr[i13];
            char c13 = ' ';
            switch (a.f41552a[mode4.ordinal()]) {
                case 1:
                    if (i14 >= 26) {
                        if (i14 != 900) {
                            if (i14 != 913) {
                                switch (i14) {
                                    case 27:
                                        mode3 = Mode.LOWER;
                                        break;
                                    case 28:
                                        mode3 = Mode.MIXED;
                                        break;
                                    case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                                        mode2 = Mode.PUNCT_SHIFT;
                                        c13 = 0;
                                        Mode mode6 = mode2;
                                        mode5 = mode4;
                                        mode4 = mode6;
                                        break;
                                }
                                mode5 = mode5;
                                mode5 = mode4;
                                c12 = c13;
                            } else {
                                iVar.b((char) iArr2[i13]);
                            }
                            c13 = 0;
                            mode5 = mode5;
                            mode5 = mode4;
                            c12 = c13;
                        } else {
                            mode3 = Mode.ALPHA;
                        }
                        mode4 = mode3;
                        c13 = 0;
                        mode5 = mode5;
                        mode5 = mode4;
                        c12 = c13;
                    } else {
                        i12 = i14 + 65;
                        c11 = (char) i12;
                        Mode mode7 = mode5;
                        mode5 = mode4;
                        c12 = c11;
                        mode5 = mode7;
                    }
                    break;
                case 2:
                    if (i14 >= 26) {
                        if (i14 != 900) {
                            if (i14 != 913) {
                                switch (i14) {
                                    case 27:
                                        mode2 = Mode.ALPHA_SHIFT;
                                        c13 = 0;
                                        Mode mode8 = mode2;
                                        mode5 = mode4;
                                        mode4 = mode8;
                                        break;
                                    case 28:
                                        mode3 = Mode.MIXED;
                                        break;
                                    case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                                        mode2 = Mode.PUNCT_SHIFT;
                                        c13 = 0;
                                        Mode mode9 = mode2;
                                        mode5 = mode4;
                                        mode4 = mode9;
                                        break;
                                }
                                mode5 = mode5;
                                mode5 = mode4;
                                c12 = c13;
                            } else {
                                iVar.b((char) iArr2[i13]);
                            }
                            c13 = 0;
                            mode5 = mode5;
                            mode5 = mode4;
                            c12 = c13;
                        } else {
                            mode3 = Mode.ALPHA;
                        }
                        mode4 = mode3;
                        c13 = 0;
                        mode5 = mode5;
                        mode5 = mode4;
                        c12 = c13;
                    } else {
                        i12 = i14 + 97;
                        c11 = (char) i12;
                        Mode mode10 = mode5;
                        mode5 = mode4;
                        c12 = c11;
                        mode5 = mode10;
                    }
                    break;
                case 3:
                    if (i14 >= 25) {
                        if (i14 == 900) {
                            mode3 = Mode.ALPHA;
                            mode4 = mode3;
                            c13 = 0;
                        } else {
                            if (i14 != 913) {
                                switch (i14) {
                                    case 25:
                                        mode3 = Mode.PUNCT;
                                        mode4 = mode3;
                                        break;
                                    case 27:
                                        mode3 = Mode.LOWER;
                                        mode4 = mode3;
                                        break;
                                    case 28:
                                        mode3 = Mode.ALPHA;
                                        mode4 = mode3;
                                        break;
                                    case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                                        mode2 = Mode.PUNCT_SHIFT;
                                        c13 = 0;
                                        Mode mode11 = mode2;
                                        mode5 = mode4;
                                        mode4 = mode11;
                                        break;
                                }
                            } else {
                                iVar.b((char) iArr2[i13]);
                            }
                            c13 = 0;
                        }
                        mode5 = mode5;
                        mode5 = mode4;
                        c12 = c13;
                    } else {
                        c11 = f41550b[i14];
                        Mode mode12 = mode5;
                        mode5 = mode4;
                        c12 = c11;
                        mode5 = mode12;
                    }
                    break;
                case 4:
                    if (i14 >= 29) {
                        if (i14 == 29 || i14 == 900) {
                            mode3 = Mode.ALPHA;
                            mode4 = mode3;
                        } else if (i14 == 913) {
                            iVar.b((char) iArr2[i13]);
                        }
                        mode5 = mode4;
                        c12 = 0;
                    } else {
                        c11 = f41549a[i14];
                        Mode mode13 = mode5;
                        mode5 = mode4;
                        c12 = c11;
                        mode5 = mode13;
                    }
                    break;
                case 5:
                    if (i14 >= 26) {
                        if (i14 != 26) {
                            mode4 = i14 != 900 ? mode5 : Mode.ALPHA;
                            c13 = 0;
                        } else {
                            mode4 = mode5;
                        }
                        mode5 = mode5;
                        mode5 = mode4;
                        c12 = c13;
                    } else {
                        c12 = (char) (i14 + 65);
                        mode5 = mode5;
                    }
                    break;
                case 6:
                    if (i14 >= 29) {
                        if (i14 == 29 || i14 == 900) {
                            mode4 = Mode.ALPHA;
                            mode5 = mode4;
                        } else if (i14 == 913) {
                            iVar.b((char) iArr2[i13]);
                        }
                        c12 = 0;
                    } else {
                        c12 = f41549a[i14];
                        mode5 = mode5;
                    }
                    break;
                default:
                    mode5 = mode4;
                    c12 = 0;
                    break;
            }
            if (c12 != 0) {
                iVar.b(c12);
            }
            i13++;
            mode4 = mode5;
            mode5 = mode5;
        }
        return mode3;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0036  */
    /* JADX WARN: Code duplicated, block: B:34:0x003c A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x0007 A[SYNTHETIC] */
    public static int f(int[] iArr, int i11, i iVar) throws FormatException {
        int[] iArr2 = new int[15];
        boolean z11 = false;
        while (true) {
            int i12 = 0;
            while (true) {
                int i13 = iArr[0];
                if (i11 < i13 && !z11) {
                    int i14 = i11 + 1;
                    int i15 = iArr[i11];
                    if (i14 == i13) {
                        z11 = true;
                    }
                    if (i15 < 900) {
                        iArr2[i12] = i15;
                        i12++;
                    } else {
                        if (i15 != 900 && i15 != 901 && i15 != 927 && i15 != 928) {
                            switch (i15) {
                            }
                            if (i12 % 15 != 0 || i15 == 902 || z11) {
                                if (i12 > 0) {
                                    break;
                                }
                            }
                        }
                        z11 = true;
                        if (i12 % 15 != 0) {
                        }
                        if (i12 > 0) {
                            break;
                        }
                    }
                    i11 = i14;
                    if (i12 % 15 != 0) {
                    }
                    if (i12 > 0) {
                        break;
                    }
                }
            }
            iVar.d(c(iArr2, i12));
        }
        return i11;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x003a. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:17:0x003d. Please report as an issue. */
    public static int g(int[] iArr, int i11, i iVar) throws FormatException {
        int i12 = iArr[0];
        int[] iArr2 = new int[(i12 - i11) * 2];
        int[] iArr3 = new int[(i12 - i11) * 2];
        Mode mode = Mode.ALPHA;
        boolean z11 = false;
        int i13 = 0;
        while (i11 < iArr[0] && !z11) {
            int i14 = i11 + 1;
            int i15 = iArr[i11];
            if (i15 < 900) {
                iArr2[i13] = i15 / 30;
                iArr2[i13 + 1] = i15 % 30;
                i13 += 2;
            } else if (i15 == 913) {
                iArr2[i13] = 913;
                i11 += 2;
                iArr3[i13] = iArr[i14];
                i13++;
            } else if (i15 != 927) {
                if (i15 != 928) {
                    switch (i15) {
                        case 900:
                            iArr2[i13] = 900;
                            i13++;
                            break;
                        case 901:
                        case 902:
                            break;
                        default:
                            switch (i15) {
                                case 922:
                                case 923:
                                case 924:
                                    break;
                                default:
                                    break;
                            }
                            break;
                    }
                }
                z11 = true;
            } else {
                Mode modeE = e(iArr2, iArr3, i13, iVar, mode);
                i11 += 2;
                iVar.f(iArr[i14]);
                int i16 = iArr[0];
                if (i11 > i16) {
                    throw FormatException.getFormatInstance();
                }
                i13 = 0;
                mode = modeE;
                iArr3 = new int[(i16 - i11) * 2];
                iArr2 = new int[(i16 - i11) * 2];
            }
            i11 = i14;
        }
        e(iArr2, iArr3, i13, iVar, mode);
        return i11;
    }
}
