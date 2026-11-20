package com.google.zxing.oned;

import com.google.android.gms.common.api.Api;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.transsion.gslb.Worker;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import qm.c;
import qm.r;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class Code128Writer extends r {

    /* JADX INFO: compiled from: source.java */
    public enum CType {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    /* JADX INFO: compiled from: source.java */
    public static final class MinimalEncoder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int[][] f41543a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Latch[][] f41544b;

        /* JADX INFO: compiled from: source.java */
        public enum Charset {
            A,
            B,
            C,
            NONE
        }

        /* JADX INFO: compiled from: source.java */
        public enum Latch {
            A,
            B,
            C,
            SHIFT,
            NONE
        }

        public MinimalEncoder() {
        }

        public /* synthetic */ MinimalEncoder(a aVar) {
            this();
        }

        public static void b(Collection<int[]> collection, int i11, int[] iArr, int[] iArr2, int i12) {
            collection.add(c.f74813a[i11]);
            if (i12 != 0) {
                iArr2[0] = iArr2[0] + 1;
            }
            iArr[0] = iArr[0] + (i11 * iArr2[0]);
        }

        public static boolean f(char c11) {
            return c11 >= '0' && c11 <= '9';
        }

        public final boolean c(CharSequence charSequence, Charset charset, int i11) {
            int i12;
            char cCharAt = charSequence.charAt(i11);
            int i13 = a.f41546b[charset.ordinal()];
            if (i13 == 1) {
                return cCharAt == 241 || cCharAt == 242 || cCharAt == 243 || cCharAt == 244 || " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001fÿ".indexOf(cCharAt) >= 0;
            }
            if (i13 == 2) {
                return cCharAt == 241 || cCharAt == 242 || cCharAt == 243 || cCharAt == 244 || " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u007fÿ".indexOf(cCharAt) >= 0;
            }
            if (i13 != 3) {
                return false;
            }
            return cCharAt == 241 || ((i12 = i11 + 1) < charSequence.length() && f(cCharAt) && f(charSequence.charAt(i12)));
        }

        public final int d(CharSequence charSequence, Charset charset, int i11) {
            int iD;
            int iD2;
            int i12 = this.f41543a[charset.ordinal()][i11];
            if (i12 > 0) {
                return i12;
            }
            Latch latch = Latch.NONE;
            int i13 = i11 + 1;
            boolean z11 = i13 >= charSequence.length();
            Charset[] charsetArr = {Charset.A, Charset.B};
            int i14 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            for (int i15 = 0; i15 <= 1; i15++) {
                if (c(charSequence, charsetArr[i15], i11)) {
                    Latch latchValueOf = Latch.NONE;
                    Charset charset2 = charsetArr[i15];
                    if (charset != charset2) {
                        latchValueOf = Latch.valueOf(charset2.toString());
                        iD2 = 2;
                    } else {
                        iD2 = 1;
                    }
                    if (!z11) {
                        iD2 += d(charSequence, charsetArr[i15], i13);
                    }
                    if (iD2 < i14) {
                        latch = latchValueOf;
                        i14 = iD2;
                    }
                    if (charset == charsetArr[(i15 + 1) % 2]) {
                        Latch latch2 = Latch.SHIFT;
                        int iD3 = !z11 ? d(charSequence, charset, i13) + 2 : 2;
                        if (iD3 < i14) {
                            latch = latch2;
                            i14 = iD3;
                        }
                    }
                }
            }
            Charset charset3 = Charset.C;
            if (c(charSequence, charset3, i11)) {
                Latch latch3 = Latch.NONE;
                if (charset != charset3) {
                    latch3 = Latch.C;
                    iD = 2;
                } else {
                    iD = 1;
                }
                int i16 = (charSequence.charAt(i11) != 241 ? 2 : 1) + i11;
                if (i16 < charSequence.length()) {
                    iD += d(charSequence, charset3, i16);
                }
                if (iD < i14) {
                    latch = latch3;
                    i14 = iD;
                }
            }
            if (i14 != Integer.MAX_VALUE) {
                this.f41543a[charset.ordinal()][i11] = i14;
                this.f41544b[charset.ordinal()][i11] = latch;
                return i14;
            }
            throw new IllegalArgumentException("Bad character in input: ASCII value=" + ((int) charSequence.charAt(i11)));
        }

        public final boolean[] e(String str) {
            this.f41543a = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 4, str.length());
            this.f41544b = (Latch[][]) Array.newInstance((Class<?>) Latch.class, 4, str.length());
            Charset charset = Charset.NONE;
            d(str, charset, 0);
            ArrayList arrayList = new ArrayList();
            int[] iArr = {0};
            int[] iArr2 = {1};
            int length = str.length();
            int i11 = 0;
            while (i11 < length) {
                Latch latch = this.f41544b[charset.ordinal()][i11];
                int i12 = a.f41545a[latch.ordinal()];
                int iCharAt = 101;
                if (i12 == 1) {
                    charset = Charset.A;
                    b(arrayList, i11 == 0 ? Worker.WHAT_SYNC_DATA : 101, iArr, iArr2, i11);
                } else if (i12 == 2) {
                    charset = Charset.B;
                    b(arrayList, i11 == 0 ? 104 : 100, iArr, iArr2, i11);
                } else if (i12 == 3) {
                    charset = Charset.C;
                    b(arrayList, i11 == 0 ? 105 : 99, iArr, iArr2, i11);
                } else if (i12 == 4) {
                    b(arrayList, 98, iArr, iArr2, i11);
                }
                if (charset != Charset.C) {
                    switch (str.charAt(i11)) {
                        case 241:
                            iCharAt = 102;
                            break;
                        case 242:
                            iCharAt = 97;
                            break;
                        case 243:
                            iCharAt = 96;
                            break;
                        case 244:
                            if ((charset != Charset.A || latch == Latch.SHIFT) && (charset != Charset.B || latch != Latch.SHIFT)) {
                                iCharAt = 100;
                            }
                            break;
                        default:
                            iCharAt = str.charAt(i11) - ' ';
                            break;
                    }
                    if (((charset == Charset.A && latch != Latch.SHIFT) || (charset == Charset.B && latch == Latch.SHIFT)) && iCharAt < 0) {
                        iCharAt += 96;
                    }
                    b(arrayList, iCharAt, iArr, iArr2, i11);
                } else if (str.charAt(i11) == 241) {
                    b(arrayList, 102, iArr, iArr2, i11);
                } else {
                    b(arrayList, Integer.parseInt(str.substring(i11, i11 + 2)), iArr, iArr2, i11);
                    int i13 = i11 + 1;
                    if (i13 < length) {
                        i11 = i13;
                    }
                }
                i11++;
            }
            this.f41543a = null;
            this.f41544b = null;
            return Code128Writer.m(arrayList, iArr[0]);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f41545a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f41546b;

        static {
            int[] iArr = new int[MinimalEncoder.Charset.values().length];
            f41546b = iArr;
            try {
                iArr[MinimalEncoder.Charset.A.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41546b[MinimalEncoder.Charset.B.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f41546b[MinimalEncoder.Charset.C.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[MinimalEncoder.Latch.values().length];
            f41545a = iArr2;
            try {
                iArr2[MinimalEncoder.Latch.A.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f41545a[MinimalEncoder.Latch.B.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f41545a[MinimalEncoder.Latch.C.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f41545a[MinimalEncoder.Latch.SHIFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:12:0x0029  */
    public static int i(String str, Map<EncodeHintType, ?> map) {
        int length = str.length();
        if (length < 1 || length > 80) {
            throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got " + length);
        }
        int i11 = -1;
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.FORCE_CODE_SET;
            if (map.containsKey(encodeHintType)) {
                String string = map.get(encodeHintType).toString();
                string.hashCode();
                switch (string) {
                    case "A":
                        i11 = 101;
                        break;
                    case "B":
                        i11 = 100;
                        break;
                    case "C":
                        i11 = 99;
                        break;
                    default:
                        throw new IllegalArgumentException("Unsupported code set hint: " + string);
                }
            }
        }
        for (int i12 = 0; i12 < length; i12++) {
            char cCharAt = str.charAt(i12);
            switch (cCharAt) {
                case 241:
                case 242:
                case 243:
                case 244:
                    break;
                default:
                    if (cCharAt > 127) {
                        throw new IllegalArgumentException("Bad character in input: ASCII value=" + ((int) cCharAt));
                    }
                    break;
            }
            switch (i11) {
                case 99:
                    if (cCharAt < '0' || ((cCharAt > '9' && cCharAt <= 127) || cCharAt == 242 || cCharAt == 243 || cCharAt == 244)) {
                        throw new IllegalArgumentException("Bad character in input for forced code set C: ASCII value=" + ((int) cCharAt));
                    }
                    break;
                    break;
                case 100:
                    if (cCharAt < ' ') {
                        throw new IllegalArgumentException("Bad character in input for forced code set B: ASCII value=" + ((int) cCharAt));
                    }
                    break;
                    break;
                case 101:
                    if (cCharAt > '_' && cCharAt <= 127) {
                        throw new IllegalArgumentException("Bad character in input for forced code set A: ASCII value=" + ((int) cCharAt));
                    }
                    break;
                    break;
            }
        }
        return i11;
    }

    public static int j(CharSequence charSequence, int i11, int i12) {
        CType cTypeL;
        CType cTypeL2;
        char cCharAt;
        CType cTypeL3 = l(charSequence, i11);
        CType cType = CType.ONE_DIGIT;
        if (cTypeL3 == cType) {
            return i12 == 101 ? 101 : 100;
        }
        CType cType2 = CType.UNCODABLE;
        if (cTypeL3 == cType2) {
            return (i11 >= charSequence.length() || ((cCharAt = charSequence.charAt(i11)) >= ' ' && (i12 != 101 || (cCharAt >= '`' && (cCharAt < 241 || cCharAt > 244))))) ? 100 : 101;
        }
        if (i12 == 101 && cTypeL3 == CType.FNC_1) {
            return 101;
        }
        if (i12 == 99) {
            return 99;
        }
        if (i12 != 100) {
            if (cTypeL3 == CType.FNC_1) {
                cTypeL3 = l(charSequence, i11 + 1);
            }
            return cTypeL3 == CType.TWO_DIGITS ? 99 : 100;
        }
        CType cType3 = CType.FNC_1;
        if (cTypeL3 == cType3 || (cTypeL = l(charSequence, i11 + 2)) == cType2 || cTypeL == cType) {
            return 100;
        }
        if (cTypeL == cType3) {
            return l(charSequence, i11 + 3) == CType.TWO_DIGITS ? 99 : 100;
        }
        int i13 = i11 + 4;
        while (true) {
            cTypeL2 = l(charSequence, i13);
            if (cTypeL2 != CType.TWO_DIGITS) {
                break;
            }
            i13 += 2;
        }
        return cTypeL2 == CType.ONE_DIGIT ? 100 : 99;
    }

    public static boolean[] k(String str, int i11) {
        int length = str.length();
        ArrayList arrayList = new ArrayList();
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 1;
        while (i12 < length) {
            int iJ = i11 == -1 ? j(str, i12, i14) : i11;
            int iCharAt = 100;
            if (iJ == i14) {
                switch (str.charAt(i12)) {
                    case 241:
                        iCharAt = 102;
                        break;
                    case 242:
                        iCharAt = 97;
                        break;
                    case 243:
                        iCharAt = 96;
                        break;
                    case 244:
                        if (i14 == 101) {
                            iCharAt = 101;
                        }
                        break;
                    default:
                        if (i14 == 100) {
                            iCharAt = str.charAt(i12) - ' ';
                        } else if (i14 == 101) {
                            char cCharAt = str.charAt(i12);
                            iCharAt = cCharAt - ' ';
                            if (iCharAt < 0) {
                                iCharAt = cCharAt + '@';
                            }
                        } else {
                            int i16 = i12 + 1;
                            if (i16 == length) {
                                throw new IllegalArgumentException("Bad number of characters for digit only encoding.");
                            }
                            iCharAt = Integer.parseInt(str.substring(i12, i12 + 2));
                            i12 = i16;
                        }
                        break;
                }
                i12++;
            } else {
                if (i14 != 0) {
                    iCharAt = iJ;
                } else if (iJ != 100) {
                    iCharAt = iJ != 101 ? 105 : Worker.WHAT_SYNC_DATA;
                } else {
                    iCharAt = 104;
                }
                i14 = iJ;
            }
            arrayList.add(c.f74813a[iCharAt]);
            i13 += iCharAt * i15;
            if (i12 != 0) {
                i15++;
            }
        }
        return m(arrayList, i13);
    }

    public static CType l(CharSequence charSequence, int i11) {
        int length = charSequence.length();
        if (i11 >= length) {
            return CType.UNCODABLE;
        }
        char cCharAt = charSequence.charAt(i11);
        if (cCharAt == 241) {
            return CType.FNC_1;
        }
        if (cCharAt < '0' || cCharAt > '9') {
            return CType.UNCODABLE;
        }
        int i12 = i11 + 1;
        if (i12 >= length) {
            return CType.ONE_DIGIT;
        }
        char cCharAt2 = charSequence.charAt(i12);
        return (cCharAt2 < '0' || cCharAt2 > '9') ? CType.ONE_DIGIT : CType.TWO_DIGITS;
    }

    public static boolean[] m(Collection<int[]> collection, int i11) {
        int i12 = i11 % Worker.WHAT_SYNC_DATA;
        int[][] iArr = c.f74813a;
        collection.add(iArr[i12]);
        collection.add(iArr[106]);
        int iB = 0;
        int i13 = 0;
        for (int[] iArr2 : collection) {
            for (int i14 : iArr2) {
                i13 += i14;
            }
        }
        boolean[] zArr = new boolean[i13];
        Iterator<int[]> it = collection.iterator();
        while (it.hasNext()) {
            iB += r.b(zArr, iB, it.next(), true);
        }
        return zArr;
    }

    @Override // qm.r
    public boolean[] d(String str) {
        return e(str, null);
    }

    @Override // qm.r
    public boolean[] e(String str, Map<EncodeHintType, ?> map) {
        int i11 = i(str, map);
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.CODE128_COMPACT;
            if (map.containsKey(encodeHintType) && Boolean.parseBoolean(map.get(encodeHintType).toString())) {
                return new MinimalEncoder(null).e(str);
            }
        }
        return k(str, i11);
    }

    @Override // qm.r
    public Collection<BarcodeFormat> g() {
        return Collections.singleton(BarcodeFormat.CODE_128);
    }
}
