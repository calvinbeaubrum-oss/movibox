package com.facebook.ads.redexgen.uinode;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Parcel;
import android.text.TextUtils;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okio.Utf8;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class IF {
    public static byte[] A00;
    public static String[] A01 = {"JF8j3t1HwJT5EX7h2jp0j9eMtppSOce9", "bVB", "ltH01aD2TBhyeSmW2ET0a07tTk5QkmFr", "AMMPHbHSbjritPLyUoLBmXYgXqsBcTWc", "Cd17kVbH8oozZtTedkioqyMXzNiJv0jO", "AlRpG3C8qavF3k0fHF7MzZY1YCESWA0o", "tU2sByQXaXHMLRkvLgWzE699OjFwn00c", "PTr"};
    public static final int A02;
    public static final String A03;
    public static final String A04;
    public static final String A05;
    public static final String A06;
    public static final Pattern A07;
    public static final Pattern A08;
    public static final Pattern A09;
    public static final int[] A0A;

    static {
        A0U();
        int i11 = (Build.VERSION.SDK_INT == 25 && Build.VERSION.CODENAME.charAt(0) == 'O') ? 26 : Build.VERSION.SDK_INT;
        A02 = i11;
        String str = Build.DEVICE;
        A03 = str;
        String str2 = Build.MANUFACTURER;
        A05 = str2;
        String str3 = Build.MODEL;
        A06 = str3;
        StringBuilder sbAppend = new StringBuilder().append(str);
        String strA0J = A0J(TsExtractor.TS_STREAM_TYPE_HDMV_DTS, 2, 19);
        A04 = sbAppend.append(strA0J).append(str3).append(strA0J).append(str2).append(strA0J).append(i11).toString();
        A08 = Pattern.compile(A0J(33, 95, 17));
        A09 = Pattern.compile(A0J(157, 84, 77));
        A07 = Pattern.compile(A0J(16, 17, 82));
        A0A = new int[]{0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};
    }

    public static float A00(float f11, float f12, float f13) {
        return Math.max(f12, Math.min(f11, f13));
    }

    public static int A01(int i11) {
        switch (i11) {
            case 0:
                return 16777216;
            case 1:
                return C.DEFAULT_AUDIO_BUFFER_SIZE;
            case 2:
                return C.DEFAULT_VIDEO_BUFFER_SIZE;
            case 3:
                return 131072;
            case 4:
                return 131072;
            default:
                throw new IllegalStateException();
        }
    }

    public static int A02(int i11) {
        switch (i11) {
            case 8:
                return 3;
            case 16:
                return 2;
            case 24:
                return Integer.MIN_VALUE;
            case 32:
                return 1073741824;
            default:
                return 0;
        }
    }

    public static int A03(int i11) {
        switch (i11) {
            case 1:
            case 12:
            case 14:
                return 3;
            case 2:
                return 0;
            case 3:
                return 8;
            case 4:
                return 4;
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
                return 5;
            case 6:
                return 2;
            case 11:
            default:
                return 3;
            case 13:
                return 1;
        }
    }

    public static int A04(int i11, int i12) {
        return ((i11 + i12) - 1) / i12;
    }

    public static int A05(int i11, int i12) {
        switch (i11) {
            case Integer.MIN_VALUE:
                return i12 * 3;
            case 2:
                return i12 * 2;
            case 3:
                return i12;
            case 4:
            case 1073741824:
                return i12 * 4;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static int A06(int i11, int i12, int i13) {
        return Math.max(i12, Math.min(i11, i13));
    }

    public static int A07(long j11, long j12) {
        if (j11 < j12) {
            return -1;
        }
        return j11 == j12 ? 0 : 1;
    }

    public static int A08(String str) {
        int length = str.length();
        AbstractC1351Ha.A03(length <= 4);
        int i11 = 0;
        String[] strArr = A01;
        if (strArr[0].charAt(23) == strArr[2].charAt(23)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[5] = "RAd5UdX59OQjNDT3JxhhOApVs8jjNxSn";
        strArr2[6] = "KQUp7Xf1mOR3tMOGflwFtA5yHXTPdbTM";
        for (int i12 = 0; i12 < length; i12++) {
            int i13 = i11 << 8;
            char cCharAt = str.charAt(i12);
            String[] strArr3 = A01;
            if (strArr3[7].length() != strArr3[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr4 = A01;
            strArr4[4] = "RubBwm4biJuQNNR1z7eA1TQZZC1gzQpZ";
            strArr4[3] = "Oqa0pFNkPWKQn3TTOi550MgIWhVzCj9Y";
            i11 = i13 | cCharAt;
        }
        return i11;
    }

    public static int A09(byte[] bArr, int i11, int i12, int i13) {
        while (i11 < i12) {
            i13 = (i13 << 8) ^ A0A[((i13 >>> 24) ^ (bArr[i11] & 255)) & 255];
            i11++;
        }
        return i13;
    }

    public static int A0A(long[] jArr, long j11, boolean z11, boolean z12) {
        int iBinarySearch = Arrays.binarySearch(jArr, j11);
        if (iBinarySearch < 0) {
            iBinarySearch ^= -1;
        } else {
            do {
                iBinarySearch++;
                if (iBinarySearch >= jArr.length) {
                    break;
                }
            } while (jArr[iBinarySearch] == j11);
            if (z11) {
                iBinarySearch--;
            }
        }
        return z12 ? Math.min(jArr.length - 1, iBinarySearch) : iBinarySearch;
    }

    public static int A0B(long[] jArr, long j11, boolean z11, boolean z12) {
        int iBinarySearch = Arrays.binarySearch(jArr, j11);
        if (iBinarySearch < 0) {
            iBinarySearch = -(iBinarySearch + 2);
        } else {
            do {
                iBinarySearch--;
                if (iBinarySearch < 0) {
                    break;
                }
            } while (jArr[iBinarySearch] == j11);
            if (z11) {
                iBinarySearch++;
            }
        }
        return z12 ? Math.max(0, iBinarySearch) : iBinarySearch;
    }

    public static long A0C(long j11, float f11) {
        if (f11 == 1.0f) {
            return j11;
        }
        double d11 = j11 * ((double) f11);
        String[] strArr = A01;
        if (strArr[5].charAt(4) == strArr[6].charAt(4)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[5] = "1ZOMuTiEMhtbRIz5bKadqRaXKsoHHbRP";
        strArr2[6] = "QnTjrxDrjRZtyDORwGSzxuPKKeihXfTh";
        return Math.round(d11);
    }

    public static long A0D(long j11, float f11) {
        return f11 == 1.0f ? j11 : Math.round(j11 / ((double) f11));
    }

    public static long A0E(long j11, long j12, long j13) {
        return Math.max(j12, Math.min(j11, j13));
    }

    public static long A0F(long j11, long j12, long j13) {
        if (j13 >= j12 && j13 % j12 == 0) {
            return j11 / (j13 / j12);
        }
        if (j13 >= j12 || j12 % j13 != 0) {
            return (long) (j11 * (j12 / j13));
        }
        long j14 = j11 * (j12 / j13);
        String[] strArr = A01;
        if (strArr[0].charAt(23) == strArr[2].charAt(23)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[4] = "59M0YOVKrDavuRzBNhchXtbiUTOLY6ct";
        strArr2[3] = "nv0qDcEpgEd8nCO6bp9kjANCF9utEQKg";
        return j14;
    }

    public static long A0G(long j11, long j12, long j13) {
        long j14 = j11 + j12;
        return ((j11 ^ j14) & (j12 ^ j14)) < 0 ? j13 : j14;
    }

    public static long A0H(long j11, long j12, long j13) {
        long j14 = j11 - j12;
        return ((j11 ^ j12) & (j11 ^ j14)) < 0 ? j13 : j14;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0048  */
    public static long A0I(long j11, AD ad2, long j12, long j13) {
        boolean z11;
        if (AD.A04.equals(ad2)) {
            return j11;
        }
        long jA0H = A0H(j11, ad2.A01, Long.MIN_VALUE);
        long jA0G = A0G(j11, ad2.A00, Long.MAX_VALUE);
        boolean z12 = jA0H <= j12 && j12 <= jA0G;
        if (jA0H <= j13) {
            String[] strArr = A01;
            if (strArr[7].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[4] = "rOtRm6QuRPH8qi2SZzi47vWl29tMYhIG";
            strArr2[3] = "R6btjf1RMRc5keSJHvpqh3VTGKeww4Yd";
            z11 = j13 <= jA0G;
        }
        if (z12 && z11) {
            return Math.abs(j12 - j11) <= Math.abs(j13 - j11) ? j12 : j13;
        }
        if (z12) {
            return j12;
        }
        return z11 ? j13 : jA0H;
    }

    public static String A0J(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 3);
        }
        return new String(bArrCopyOfRange);
    }

    public static String A0K(Context context, String str) {
        String strA0J;
        try {
            strA0J = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            strA0J = A0J(133, 1, 76);
        }
        return str + A0J(132, 1, 12) + strA0J + A0J(0, 16, 111) + Build.VERSION.RELEASE + A0J(128, 2, 68) + A0J(TsExtractor.TS_STREAM_TYPE_SPLICE_INFO, 18, 116);
    }

    public static String A0L(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new Locale(str).getISO3Language();
        } catch (MissingResourceException unused) {
            return A0M(str);
        }
    }

    public static String A0M(String str) {
        if (str == null) {
            return null;
        }
        return str.toLowerCase(Locale.US);
    }

    public static String A0N(String str) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase(Locale.US);
    }

    public static String A0O(String str) {
        int length = str.length();
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            if (str.charAt(i12) == '%') {
                i11++;
            }
        }
        if (i11 == 0) {
            return str;
        }
        int i13 = length - (i11 * 2);
        StringBuilder sb2 = new StringBuilder(i13);
        Matcher matcher = A07.matcher(str);
        int iEnd = 0;
        while (i11 > 0 && matcher.find()) {
            sb2.append((CharSequence) str, iEnd, matcher.start()).append((char) Integer.parseInt(matcher.group(1), 16));
            iEnd = matcher.end();
            i11--;
        }
        if (iEnd < length) {
            sb2.append((CharSequence) str, iEnd, length);
        }
        if (sb2.length() != i13) {
            return null;
        }
        return sb2.toString();
    }

    public static String A0P(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static String A0Q(byte[] bArr) {
        return new String(bArr, Charset.forName(A0J(152, 5, 94)));
    }

    public static String A0R(byte[] bArr, int i11, int i12) {
        return new String(bArr, i11, i12, Charset.forName(A0J(152, 5, 94)));
    }

    public static String A0S(Object[] objArr) {
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < objArr.length; i11++) {
            sb2.append(objArr[i11].getClass().getSimpleName());
            if (i11 < objArr.length - 1) {
                sb2.append(A0J(TsExtractor.TS_STREAM_TYPE_HDMV_DTS, 2, 19));
            }
        }
        return sb2.toString();
    }

    public static ExecutorService A0T(String str) {
        return Executors.newSingleThreadExecutor(new IE(str));
    }

    public static void A0U() {
        A00 = new byte[]{-110, -102, -66, -37, -32, -25, -22, -83, -77, -32, -42, -28, -31, -37, -42, -110, 122, 125, -80, -106, -126, -101, -74, -126, -69, -123, -126, -114, -78, -48, -121, -46, 126, 60, 112, 120, 112, 120, 112, 120, 112, 120, 61, 112, 65, 60, 112, 120, 112, 120, 61, 112, 65, 60, 112, 120, 112, 120, 61, 111, 104, -120, 113, 60, 112, 120, 112, 120, 61, 78, 60, 112, 120, 112, 120, 61, 78, 60, 112, 120, 112, 120, 61, 60, 111, 112, 66, 64, 113, 60, 112, 120, Utf8.REPLACEMENT_BYTE, 61, 61, 83, 60, 111, 110, -114, 113, -112, 60, 60, 112, Utf8.REPLACEMENT_BYTE, -112, 112, 65, 61, 60, 112, 120, 83, 112, 120, 61, 78, 83, 60, 112, 120, 112, 120, 61, 61, 61, 83, 112, 103, 66, 54, 62, -114, -68, -17, -26, -57, -29, -40, -16, -36, -23, -61, -32, -39, -90, -87, -91, -81, -91, -85, -74, -75, -89, -114, -103, -82, 120, 125, 121, -113, -96, 120, 120, -85, -128, 125, -119, -83, 122, 121, -87, 121, -113, 120, 120, -85, -128, 125, -119, -83, 122, 121, -99, 121, -113, 120, 120, -85, -128, 125, -119, -83, 122, 121, -108, 121, -113, 120, -92, 120, 120, -85, -128, 125, -119, -83, 122, 121, -104, 121, -113, 120, 120, -85, -128, 125, -119, -83, 122, 121, -99, 121, -113, 120, 120, -85, -128, 125, -119, 126, -83, 122, 121, -93, 121, -113, 121, -113, 116, -45, -42, -39, -46};
    }

    public static void A0V(Parcel parcel, boolean z11) {
        parcel.writeInt(z11 ? 1 : 0);
    }

    public static void A0W(InterfaceC1346Gu interfaceC1346Gu) {
        if (interfaceC1346Gu != null) {
            try {
                interfaceC1346Gu.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void A0X(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void A0Y(Throwable th2) throws Throwable {
        A0Z(th2);
        throw null;
    }

    public static <T extends Throwable> void A0Z(Throwable th2) throws Throwable {
        throw th2;
    }

    public static void A0a(long[] jArr, long j11, long j12) {
        if (j12 >= j11) {
            long j13 = j12 % j11;
            String[] strArr = A01;
            if (strArr[7].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[4] = "aDtdh5JcBBaWJ0l36IU12unkzAom61WH";
            strArr2[3] = "TKBn8eeBX9HT0995eIbPxApcyozCTpSm";
            if (j13 == 0) {
                long j14 = j12 / j11;
                for (int i11 = 0; i11 < jArr.length; i11++) {
                    jArr[i11] = jArr[i11] / j14;
                }
                return;
            }
        }
        if (j12 < j11 && j11 % j12 == 0) {
            long j15 = j11 / j12;
            for (int i12 = 0; i12 < jArr.length; i12++) {
                jArr[i12] = jArr[i12] * j15;
            }
            return;
        }
        double d11 = j11 / j12;
        int i13 = 0;
        while (true) {
            int length = jArr.length;
            String[] strArr3 = A01;
            if (strArr3[7].length() != strArr3[1].length()) {
                String[] strArr4 = A01;
                strArr4[5] = "z2P3U6eAjWkNd94QbMv3FZH2cw2CwROX";
                strArr4[6] = "fla9XWK4U9FolyznFRaDI9c5wGrhI32q";
                if (i13 >= length) {
                    return;
                }
            } else {
                String[] strArr5 = A01;
                strArr5[7] = "FjF";
                strArr5[1] = "mVF";
                if (i13 >= length) {
                    return;
                }
            }
            jArr[i13] = (long) (jArr[i13] * d11);
            i13++;
        }
    }

    public static boolean A0b(int i11) {
        return i11 == Integer.MIN_VALUE || i11 == 1073741824;
    }

    public static boolean A0c(int i11) {
        return i11 == 3 || i11 == 2 || i11 == Integer.MIN_VALUE || i11 == 1073741824 || i11 == 4;
    }

    public static boolean A0d(int i11) {
        return i11 == 10 || i11 == 13;
    }

    public static boolean A0e(Uri uri) {
        String scheme = uri.getScheme();
        return TextUtils.isEmpty(scheme) || A0J(241, 4, 106).equals(scheme);
    }

    public static boolean A0f(Parcel parcel) {
        return parcel.readInt() != 0;
    }

    public static boolean A0g(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static byte[] A0h(String str) {
        byte[] bArr = new byte[str.length() / 2];
        for (int i11 = 0; i11 < bArr.length; i11++) {
            int i12 = i11 * 2;
            bArr[i11] = (byte) ((Character.digit(str.charAt(i12), 16) << 4) + Character.digit(str.charAt(i12 + 1), 16));
        }
        return bArr;
    }

    public static byte[] A0i(String str) {
        return str.getBytes(Charset.forName(A0J(152, 5, 94)));
    }

    public static int[] A0j(List<Integer> list) {
        if (list == null) {
            return null;
        }
        int size = list.size();
        int[] iArr = new int[size];
        String[] strArr = A01;
        if (strArr[5].charAt(4) == strArr[6].charAt(4)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[4] = "qkJvasGIgi3zbdcmDWONWoV42QfeFSN8";
        strArr2[3] = "LbB8o9ruE6ZWqRf815tKqiwznPIX7mJm";
        for (int i11 = 0; i11 < size; i11++) {
            iArr[i11] = list.get(i11).intValue();
        }
        return iArr;
    }

    public static <T> T[] A0k(T[] tArr, int i11) {
        AbstractC1351Ha.A03(i11 <= tArr.length);
        return (T[]) Arrays.copyOf(tArr, i11);
    }

    public static String[] A0l(String str, String str2) {
        return str.split(str2, -1);
    }

    public static String[] A0m(String str, String str2) {
        return str.split(str2, 2);
    }
}
