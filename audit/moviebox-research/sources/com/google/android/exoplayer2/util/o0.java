package com.google.android.exoplayer2.util;

import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.sdk.AppLovinMediationProvider;
import com.cloud.tmc.integration.core.TmcEngineFactory;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.n2;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.transsion.gslb.Worker;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import okhttp3.internal.ws.WebSocketProtocol;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f35608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f35609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f35610c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f35611d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f35612e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final byte[] f35613f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Pattern f35614g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Pattern f35615h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Pattern f35616i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Pattern f35617j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public static HashMap<String, String> f35618k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String[] f35619l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String[] f35620m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int[] f35621n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int[] f35622o;

    static {
        int i11 = Build.VERSION.SDK_INT;
        f35608a = i11;
        String str = Build.DEVICE;
        f35609b = str;
        String str2 = Build.MANUFACTURER;
        f35610c = str2;
        String str3 = Build.MODEL;
        f35611d = str3;
        f35612e = str + ", " + str3 + ", " + str2 + ", " + i11;
        f35613f = new byte[0];
        f35614g = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
        f35615h = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
        f35616i = Pattern.compile("%([A-Fa-f0-9]{2})");
        f35617j = Pattern.compile("(?:.*\\.)?isml?(?:/(manifest(.*))?)?", 2);
        f35619l = new String[]{"alb", "sq", "arm", "hy", "baq", "eu", "bur", "my", "tib", "bo", "chi", "zh", "cze", "cs", "dut", "nl", "ger", DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_ERROR, "gre", "el", "fre", "fr", "geo", "ka", "ice", "is", "mac", "mk", "mao", "mi", "may", "ms", "per", "fa", "rum", "ro", "scc", "hbs-srp", "slo", "sk", "wel", "cy", "id", "ms-ind", "iw", "he", "heb", "he", "ji", "yi", "arb", "ar-arb", "in", "ms-ind", "ind", "ms-ind", "nb", "no-nob", "nob", "no-nob", "nn", "no-nno", "nno", "no-nno", "tw", "ak-twi", "twi", "ak-twi", "bs", "hbs-bos", "bos", "hbs-bos", "hr", "hbs-hrv", "hrv", "hbs-hrv", "sr", "hbs-srp", "srp", "hbs-srp", "cmn", "zh-cmn", "hak", "zh-hak", "nan", "zh-nan", "hsn", "zh-hsn"};
        f35620m = new String[]{"i-lux", "lb", "i-hak", "zh-hak", "i-navajo", "nv", "no-bok", "no-nob", "no-nyn", "no-nno", "zh-guoyu", "zh-cmn", "zh-hakka", "zh-hak", "zh-min-nan", "zh-nan", "zh-xiang", "zh-hsn"};
        f35621n = new int[]{0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};
        f35622o = new int[]{0, 7, 14, 9, 28, 27, 18, 21, 56, 63, 54, 49, 36, 35, 42, 45, 112, 119, WebSocketProtocol.PAYLOAD_SHORT, 121, 108, 107, 98, 101, 72, 79, 70, 65, 84, 83, 90, 93, 224, 231, 238, 233, 252, 251, 242, 245, 216, 223, 214, 209, 196, 195, 202, 205, 144, 151, 158, 153, 140, 139, TsExtractor.TS_STREAM_TYPE_HDMV_DTS, 133, 168, 175, 166, 161, 180, 179, 186, PsExtractor.PRIVATE_STREAM_1, 199, PsExtractor.AUDIO_STREAM, 201, 206, 219, 220, 213, 210, 255, 248, 241, 246, 227, 228, 237, 234, 183, 176, 185, 190, 171, 172, 165, 162, 143, 136, TsExtractor.TS_STREAM_TYPE_AC3, TsExtractor.TS_STREAM_TYPE_SPLICE_INFO, 147, 148, 157, 154, 39, 32, 41, 46, 59, 60, 53, 50, 31, 24, 17, 22, 3, 4, 13, 10, 87, 80, 89, 94, 75, 76, 69, 66, 111, 104, 97, 102, 115, 116, 125, 122, 137, 142, TsExtractor.TS_STREAM_TYPE_E_AC3, 128, 149, 146, 155, 156, 177, 182, 191, 184, 173, 170, 163, 164, 249, 254, 247, 240, 229, 226, 235, 236, 193, 198, 207, 200, 221, 218, 211, 212, 105, Worker.WHAT_QUIT, Worker.WHAT_SYNC_DATA, 96, 117, 114, 123, 124, 81, 86, 95, 88, 77, 74, 67, 68, 25, 30, 23, 16, 5, 2, 11, 12, 33, 38, 47, 40, 61, 58, 51, 52, 78, 73, 64, 71, 82, 85, 92, 91, 118, 113, 120, 127, 106, 109, 100, 99, 62, 57, 48, 55, 34, 37, 44, 43, 6, 1, 8, 15, 26, 29, 20, 19, 174, 169, 160, 167, 178, 181, 188, 187, 150, 145, 152, 159, TsExtractor.TS_STREAM_TYPE_DTS, 141, 132, 131, 222, 217, 208, 215, 194, 197, 204, 203, 230, 225, 232, 239, 250, 253, 244, 243};
    }

    public static HashMap<String, String> A() {
        String[] iSOLanguages = Locale.getISOLanguages();
        HashMap<String, String> map = new HashMap<>(iSOLanguages.length + f35619l.length);
        int i11 = 0;
        for (String str : iSOLanguages) {
            try {
                String iSO3Language = new Locale(str).getISO3Language();
                if (!TextUtils.isEmpty(iSO3Language)) {
                    map.put(iSO3Language, str);
                }
            } catch (MissingResourceException unused) {
            }
        }
        while (true) {
            String[] strArr = f35619l;
            if (i11 >= strArr.length) {
                return map;
            }
            map.put(strArr[i11], strArr[i11 + 1]);
            i11 += 2;
        }
    }

    public static String A0(String str) {
        int i11 = 0;
        while (true) {
            String[] strArr = f35620m;
            if (i11 >= strArr.length) {
                return str;
            }
            if (str.startsWith(strArr[i11])) {
                return strArr[i11 + 1] + str.substring(strArr[i11].length());
            }
            i11 += 2;
        }
    }

    public static Uri B(Uri uri) {
        String path = uri.getPath();
        if (path == null) {
            return uri;
        }
        Matcher matcher = f35617j.matcher(path);
        return (matcher.matches() && matcher.group(1) == null) ? Uri.withAppendedPath(uri, "Manifest") : uri;
    }

    public static <T> void B0(List<T> list, int i11, int i12, int i13) {
        ArrayDeque arrayDeque = new ArrayDeque();
        for (int i14 = (i12 - i11) - 1; i14 >= 0; i14--) {
            arrayDeque.addFirst(list.remove(i11 + i14));
        }
        list.addAll(Math.min(i13, list.size()), arrayDeque);
    }

    public static String C(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static long C0(long j11) {
        return (j11 == C.TIME_UNSET || j11 == Long.MIN_VALUE) ? j11 : j11 * 1000;
    }

    public static String D(byte[] bArr) {
        return new String(bArr, com.google.common.base.c.f38165c);
    }

    public static ExecutorService D0(final String str) {
        return Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.google.android.exoplayer2.util.n0
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return o0.y0(str, runnable);
            }
        });
    }

    public static String E(byte[] bArr, int i11, int i12) {
        return new String(bArr, i11, i12, com.google.common.base.c.f38165c);
    }

    public static String E0(String str) {
        if (str == null) {
            return null;
        }
        String strReplace = str.replace('_', '-');
        if (!strReplace.isEmpty() && !strReplace.equals(C.LANGUAGE_UNDETERMINED)) {
            str = strReplace;
        }
        String strE = com.google.common.base.a.e(str);
        String str2 = U0(strE, "-")[0];
        if (f35618k == null) {
            f35618k = A();
        }
        String str3 = f35618k.get(str2);
        if (str3 != null) {
            strE = str3 + strE.substring(str2.length());
            str2 = str3;
        }
        return ("no".equals(str2) || "i".equals(str2) || "zh".equals(str2)) ? A0(strE) : strE;
    }

    @RequiresApi(21)
    public static int F(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        if (audioManager == null) {
            return -1;
        }
        return audioManager.generateAudioSessionId();
    }

    public static <T> T[] F0(T[] tArr, T t11) {
        Object[] objArrCopyOf = Arrays.copyOf(tArr, tArr.length + 1);
        objArrCopyOf[tArr.length] = t11;
        return (T[]) k(objArrCopyOf);
    }

    public static int G(int i11) {
        if (i11 == 12) {
            return f35608a >= 32 ? 743676 : 0;
        }
        switch (i11) {
            case 1:
                return 4;
            case 2:
                return 12;
            case 3:
                return 28;
            case 4:
                return 204;
            case 5:
                return 220;
            case 6:
                return 252;
            case 7:
                return 1276;
            case 8:
                int i12 = f35608a;
                return (i12 < 23 && i12 < 21) ? 0 : 6396;
            default:
                return 0;
        }
    }

    public static <T> T[] G0(T[] tArr, T[] tArr2) {
        T[] tArr3 = (T[]) Arrays.copyOf(tArr, tArr.length + tArr2.length);
        System.arraycopy(tArr2, 0, tArr3, tArr.length, tArr2.length);
        return tArr3;
    }

    public static n2.b H(n2 n2Var, n2.b bVar) {
        boolean zIsPlayingAd = n2Var.isPlayingAd();
        boolean zT = n2Var.t();
        boolean zR = n2Var.r();
        boolean zG = n2Var.g();
        boolean zA = n2Var.A();
        boolean zJ = n2Var.j();
        boolean zU = n2Var.getCurrentTimeline().u();
        boolean z11 = false;
        n2.b.a aVarD = new n2.b.a().b(bVar).d(4, !zIsPlayingAd).d(5, zT && !zIsPlayingAd).d(6, zR && !zIsPlayingAd).d(7, !zU && (zR || !zA || zT) && !zIsPlayingAd).d(8, zG && !zIsPlayingAd).d(9, !zU && (zG || (zA && zJ)) && !zIsPlayingAd).d(10, !zIsPlayingAd).d(11, zT && !zIsPlayingAd);
        if (zT && !zIsPlayingAd) {
            z11 = true;
        }
        return aVarD.d(12, z11).e();
    }

    public static <T> T[] H0(T[] tArr, int i11) {
        a.a(i11 <= tArr.length);
        return (T[]) Arrays.copyOf(tArr, i11);
    }

    public static int I(ByteBuffer byteBuffer, int i11) {
        int i12 = byteBuffer.getInt(i11);
        return byteBuffer.order() == ByteOrder.BIG_ENDIAN ? i12 : Integer.reverseBytes(i12);
    }

    public static <T> T[] I0(T[] tArr, int i11, int i12) {
        a.a(i11 >= 0);
        a.a(i12 <= tArr.length);
        return (T[]) Arrays.copyOfRange(tArr, i11, i12);
    }

    public static byte[] J(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i11 = 0; i11 < length; i11++) {
            int i12 = i11 * 2;
            bArr[i11] = (byte) ((Character.digit(str.charAt(i12), 16) << 4) + Character.digit(str.charAt(i12 + 1), 16));
        }
        return bArr;
    }

    public static long J0(String str) throws ParserException {
        Matcher matcher = f35614g.matcher(str);
        if (!matcher.matches()) {
            throw ParserException.createForMalformedContainer("Invalid date/time format: " + str, null);
        }
        int i11 = 0;
        if (matcher.group(9) != null && !matcher.group(9).equalsIgnoreCase("Z")) {
            i11 = (Integer.parseInt(matcher.group(12)) * 60) + Integer.parseInt(matcher.group(13));
            if ("-".equals(matcher.group(11))) {
                i11 *= -1;
            }
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        gregorianCalendar.clear();
        gregorianCalendar.set(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)) - 1, Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
        if (!TextUtils.isEmpty(matcher.group(8))) {
            gregorianCalendar.set(14, new BigDecimal("0." + matcher.group(8)).movePointRight(3).intValue());
        }
        long timeInMillis = gregorianCalendar.getTimeInMillis();
        return i11 != 0 ? timeInMillis - (((long) i11) * ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS) : timeInMillis;
    }

    public static int K(@Nullable String str, int i11) {
        int i12 = 0;
        for (String str2 : V0(str)) {
            if (i11 == w.m(str2)) {
                i12++;
            }
        }
        return i12;
    }

    public static long K0(String str) {
        Matcher matcher = f35615h.matcher(str);
        if (!matcher.matches()) {
            return (long) (Double.parseDouble(str) * 3600.0d * 1000.0d);
        }
        boolean zIsEmpty = true ^ TextUtils.isEmpty(matcher.group(1));
        String strGroup = matcher.group(3);
        double d11 = strGroup != null ? Double.parseDouble(strGroup) * 3.1556908E7d : 0.0d;
        String strGroup2 = matcher.group(5);
        double d12 = d11 + (strGroup2 != null ? Double.parseDouble(strGroup2) * 2629739.0d : 0.0d);
        String strGroup3 = matcher.group(7);
        double d13 = d12 + (strGroup3 != null ? Double.parseDouble(strGroup3) * 86400.0d : 0.0d);
        String strGroup4 = matcher.group(10);
        double d14 = d13 + (strGroup4 != null ? Double.parseDouble(strGroup4) * 3600.0d : 0.0d);
        String strGroup5 = matcher.group(12);
        double d15 = d14 + (strGroup5 != null ? Double.parseDouble(strGroup5) * 60.0d : 0.0d);
        String strGroup6 = matcher.group(14);
        long j11 = (long) ((d15 + (strGroup6 != null ? Double.parseDouble(strGroup6) : 0.0d)) * 1000.0d);
        return zIsEmpty ? -j11 : j11;
    }

    @Nullable
    public static String L(@Nullable String str, int i11) {
        String[] strArrV0 = V0(str);
        if (strArrV0.length == 0) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        for (String str2 : strArrV0) {
            if (i11 == w.m(str2)) {
                if (sb2.length() > 0) {
                    sb2.append(",");
                }
                sb2.append(str2);
            }
        }
        if (sb2.length() > 0) {
            return sb2.toString();
        }
        return null;
    }

    public static boolean L0(Handler handler, Runnable runnable) {
        if (!handler.getLooper().getThread().isAlive()) {
            return false;
        }
        if (handler.getLooper() != Looper.myLooper()) {
            return handler.post(runnable);
        }
        runnable.run();
        return true;
    }

    public static String M(Object[] objArr) {
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < objArr.length; i11++) {
            sb2.append(objArr[i11].getClass().getSimpleName());
            if (i11 < objArr.length - 1) {
                sb2.append(", ");
            }
        }
        return sb2.toString();
    }

    public static boolean M0(Parcel parcel) {
        return parcel.readInt() != 0;
    }

    public static String N(@Nullable Context context) {
        TelephonyManager telephonyManager;
        if (context != null && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (!TextUtils.isEmpty(networkCountryIso)) {
                return com.google.common.base.a.g(networkCountryIso);
            }
        }
        return com.google.common.base.a.g(Locale.getDefault().getCountry());
    }

    public static <T> void N0(List<T> list, int i11, int i12) {
        if (i11 < 0 || i12 > list.size() || i11 > i12) {
            throw new IllegalArgumentException();
        }
        if (i11 != i12) {
            list.subList(i11, i12).clear();
        }
    }

    public static Point O(Context context) {
        DisplayManager displayManager;
        Display display = (f35608a < 17 || (displayManager = (DisplayManager) context.getSystemService("display")) == null) ? null : displayManager.getDisplay(0);
        if (display == null) {
            display = ((WindowManager) a.e((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
        }
        return P(context, display);
    }

    public static long O0(long j11, long j12, long j13) {
        if (j13 >= j12 && j13 % j12 == 0) {
            return j11 / (j13 / j12);
        }
        if (j13 < j12 && j12 % j13 == 0) {
            return j11 * (j12 / j13);
        }
        return (long) (j11 * (j12 / j13));
    }

    public static Point P(Context context, Display display) {
        if (display.getDisplayId() == 0 && x0(context)) {
            String strL0 = f35608a < 28 ? l0("sys.display-size") : l0("vendor.display-size");
            if (!TextUtils.isEmpty(strL0)) {
                try {
                    String[] strArrT0 = T0(strL0.trim(), "x");
                    if (strArrT0.length == 2) {
                        int i11 = Integer.parseInt(strArrT0[0]);
                        int i12 = Integer.parseInt(strArrT0[1]);
                        if (i11 > 0 && i12 > 0) {
                            return new Point(i11, i12);
                        }
                    }
                } catch (NumberFormatException unused) {
                }
                s.c("Util", "Invalid display size: " + strL0);
            }
            if ("Sony".equals(f35610c) && f35611d.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                return new Point(3840, 2160);
            }
        }
        Point point = new Point();
        int i13 = f35608a;
        if (i13 >= 23) {
            U(display, point);
        } else if (i13 >= 17) {
            T(display, point);
        } else {
            S(display, point);
        }
        return point;
    }

    public static long[] P0(List<Long> list, long j11, long j12) {
        int size = list.size();
        long[] jArr = new long[size];
        int i11 = 0;
        if (j12 >= j11 && j12 % j11 == 0) {
            long j13 = j12 / j11;
            while (i11 < size) {
                jArr[i11] = list.get(i11).longValue() / j13;
                i11++;
            }
        } else if (j12 >= j11 || j11 % j12 != 0) {
            double d11 = j11 / j12;
            while (i11 < size) {
                jArr[i11] = (long) (list.get(i11).longValue() * d11);
                i11++;
            }
        } else {
            long j14 = j11 / j12;
            while (i11 < size) {
                jArr[i11] = list.get(i11).longValue() * j14;
                i11++;
            }
        }
        return jArr;
    }

    public static Looper Q() {
        Looper looperMyLooper = Looper.myLooper();
        return looperMyLooper != null ? looperMyLooper : Looper.getMainLooper();
    }

    public static void Q0(long[] jArr, long j11, long j12) {
        int i11 = 0;
        if (j12 >= j11 && j12 % j11 == 0) {
            long j13 = j12 / j11;
            while (i11 < jArr.length) {
                jArr[i11] = jArr[i11] / j13;
                i11++;
            }
            return;
        }
        if (j12 >= j11 || j11 % j12 != 0) {
            double d11 = j11 / j12;
            while (i11 < jArr.length) {
                jArr[i11] = (long) (jArr[i11] * d11);
                i11++;
            }
            return;
        }
        long j14 = j11 / j12;
        while (i11 < jArr.length) {
            jArr[i11] = jArr[i11] * j14;
            i11++;
        }
    }

    public static Locale R() {
        return f35608a >= 24 ? Locale.getDefault(Locale.Category.DISPLAY) : Locale.getDefault();
    }

    public static void R0(Throwable th2) throws Throwable {
        S0(th2);
    }

    public static void S(Display display, Point point) {
        display.getSize(point);
    }

    public static <T extends Throwable> void S0(Throwable th2) throws Throwable {
        throw th2;
    }

    @RequiresApi(17)
    public static void T(Display display, Point point) {
        display.getRealSize(point);
    }

    public static String[] T0(String str, String str2) {
        return str.split(str2, -1);
    }

    @RequiresApi(23)
    public static void U(Display display, Point point) {
        Display.Mode mode = display.getMode();
        point.x = mode.getPhysicalWidth();
        point.y = mode.getPhysicalHeight();
    }

    public static String[] U0(String str, String str2) {
        return str.split(str2, 2);
    }

    public static int V(int i11) {
        if (i11 == 2 || i11 == 4) {
            return 6005;
        }
        if (i11 == 10) {
            return 6004;
        }
        if (i11 == 7) {
            return 6005;
        }
        if (i11 == 8) {
            return 6003;
        }
        switch (i11) {
            case 15:
                return 6003;
            case 16:
            case 18:
                return 6005;
            case 17:
            case 19:
            case 20:
            case 21:
            case 22:
                return 6004;
            default:
                switch (i11) {
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                        return 6002;
                    default:
                        return 6006;
                }
        }
    }

    public static String[] V0(@Nullable String str) {
        return TextUtils.isEmpty(str) ? new String[0] : T0(str.trim(), "(\\s*,\\s*)");
    }

    public static int W(@Nullable String str) {
        String[] strArrT0;
        int length;
        if (str == null || (length = (strArrT0 = T0(str, "_")).length) < 2) {
            return 0;
        }
        String str2 = strArrT0[length - 1];
        boolean z11 = length >= 3 && "neg".equals(strArrT0[length - 2]);
        try {
            int i11 = Integer.parseInt((String) a.e(str2));
            return z11 ? -i11 : i11;
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    @Nullable
    public static ComponentName W0(Context context, Intent intent) {
        return f35608a >= 26 ? context.startForegroundService(intent) : context.startService(intent);
    }

    public static String X(int i11) {
        if (i11 == 0) {
            return "NO";
        }
        if (i11 == 1) {
            return "NO_UNSUPPORTED_TYPE";
        }
        if (i11 == 2) {
            return "NO_UNSUPPORTED_DRM";
        }
        if (i11 == 3) {
            return "NO_EXCEEDS_CAPABILITIES";
        }
        if (i11 == 4) {
            return "YES";
        }
        throw new IllegalStateException();
    }

    public static long X0(long j11, long j12, long j13) {
        long j14 = j11 - j12;
        return ((j11 ^ j14) & (j12 ^ j11)) < 0 ? j13 : j14;
    }

    public static String Y(Locale locale) {
        return f35608a >= 21 ? Z(locale) : locale.toString();
    }

    public static boolean Y0(SQLiteDatabase sQLiteDatabase, String str) {
        return DatabaseUtils.queryNumEntries(sQLiteDatabase, "sqlite_master", "tbl_name = ?", new String[]{str}) > 0;
    }

    @RequiresApi(21)
    public static String Z(Locale locale) {
        return locale.toLanguageTag();
    }

    public static byte[] Z0(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int i11 = inputStream.read(bArr);
            if (i11 == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i11);
        }
    }

    public static long a0(long j11, float f11) {
        return f11 == 1.0f ? j11 : Math.round(j11 * ((double) f11));
    }

    public static String a1(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (int i11 = 0; i11 < bArr.length; i11++) {
            sb2.append(Character.forDigit((bArr[i11] >> 4) & 15, 16));
            sb2.append(Character.forDigit(bArr[i11] & Ascii.SI, 16));
        }
        return sb2.toString();
    }

    public static long b(long j11, long j12, long j13) {
        long j14 = j11 + j12;
        return ((j11 ^ j14) & (j12 ^ j14)) < 0 ? j13 : j14;
    }

    public static long b0(long j11) {
        return j11 == C.TIME_UNSET ? System.currentTimeMillis() : j11 + SystemClock.elapsedRealtime();
    }

    public static long b1(int i11, int i12) {
        return c1(i12) | (c1(i11) << 32);
    }

    public static boolean c(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static int c0(int i11) {
        if (i11 == 8) {
            return 3;
        }
        if (i11 == 16) {
            return 2;
        }
        if (i11 != 24) {
            return i11 != 32 ? 0 : 805306368;
        }
        return ASTNode.DISCARD;
    }

    public static long c1(int i11) {
        return ((long) i11) & 4294967295L;
    }

    public static <T extends Comparable<? super T>> int d(List<? extends Comparable<? super T>> list, T t11, boolean z11, boolean z12) {
        int i11;
        int i12;
        int iBinarySearch = Collections.binarySearch(list, t11);
        if (iBinarySearch < 0) {
            i12 = ~iBinarySearch;
        } else {
            int size = list.size();
            while (true) {
                i11 = iBinarySearch + 1;
                if (i11 >= size || list.get(i11).compareTo(t11) != 0) {
                    break;
                }
                iBinarySearch = i11;
            }
            i12 = z11 ? iBinarySearch : i11;
        }
        return z12 ? Math.min(list.size() - 1, i12) : i12;
    }

    public static m1 d0(int i11, int i12, int i13) {
        return new m1.b().e0(MimeTypes.AUDIO_RAW).H(i12).f0(i13).Y(i11).E();
    }

    public static CharSequence d1(CharSequence charSequence, int i11) {
        return charSequence.length() <= i11 ? charSequence : charSequence.subSequence(0, i11);
    }

    public static int e(long[] jArr, long j11, boolean z11, boolean z12) {
        int i11;
        int i12;
        int iBinarySearch = Arrays.binarySearch(jArr, j11);
        if (iBinarySearch < 0) {
            i12 = ~iBinarySearch;
        } else {
            while (true) {
                i11 = iBinarySearch + 1;
                if (i11 >= jArr.length || jArr[i11] != j11) {
                    break;
                }
                iBinarySearch = i11;
            }
            i12 = z11 ? iBinarySearch : i11;
        }
        return z12 ? Math.min(jArr.length - 1, i12) : i12;
    }

    public static int e0(int i11, int i12) {
        if (i11 != 2) {
            if (i11 == 3) {
                return i12;
            }
            if (i11 != 4) {
                if (i11 != 268435456) {
                    if (i11 == 536870912) {
                        return i12 * 3;
                    }
                    if (i11 != 805306368) {
                        throw new IllegalArgumentException();
                    }
                }
            }
            return i12 * 4;
        }
        return i12 * 2;
    }

    @Nullable
    public static String e1(String str) {
        int length = str.length();
        int iEnd = 0;
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
        Matcher matcher = f35616i.matcher(str);
        while (i11 > 0 && matcher.find()) {
            char c11 = (char) Integer.parseInt((String) a.e(matcher.group(1)), 16);
            sb2.append((CharSequence) str, iEnd, matcher.start());
            sb2.append(c11);
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

    public static int f(t tVar, long j11, boolean z11, boolean z12) {
        int i11;
        int iC = tVar.c() - 1;
        int i12 = 0;
        while (i12 <= iC) {
            int i13 = (i12 + iC) >>> 1;
            if (tVar.b(i13) < j11) {
                i12 = i13 + 1;
            } else {
                iC = i13 - 1;
            }
        }
        if (z11 && (i11 = iC + 1) < tVar.c() && tVar.b(i11) == j11) {
            return i11;
        }
        if (z12 && iC == -1) {
            return 0;
        }
        return iC;
    }

    public static long f0(long j11, float f11) {
        return f11 == 1.0f ? j11 : Math.round(j11 / ((double) f11));
    }

    public static long f1(long j11) {
        return (j11 == C.TIME_UNSET || j11 == Long.MIN_VALUE) ? j11 : j11 / 1000;
    }

    public static <T extends Comparable<? super T>> int g(List<? extends Comparable<? super T>> list, T t11, boolean z11, boolean z12) {
        int i11;
        int i12;
        int iBinarySearch = Collections.binarySearch(list, t11);
        if (iBinarySearch < 0) {
            i12 = -(iBinarySearch + 2);
        } else {
            while (true) {
                i11 = iBinarySearch - 1;
                if (i11 < 0 || list.get(i11).compareTo(t11) != 0) {
                    break;
                }
                iBinarySearch = i11;
            }
            i12 = z11 ? iBinarySearch : i11;
        }
        return z12 ? Math.max(0, i12) : i12;
    }

    public static int g0(int i11) {
        if (i11 == 13) {
            return 1;
        }
        switch (i11) {
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
            default:
                return 3;
        }
    }

    public static void g1(Parcel parcel, boolean z11) {
        parcel.writeInt(z11 ? 1 : 0);
    }

    public static int h(int[] iArr, int i11, boolean z11, boolean z12) {
        int i12;
        int i13;
        int iBinarySearch = Arrays.binarySearch(iArr, i11);
        if (iBinarySearch < 0) {
            i13 = -(iBinarySearch + 2);
        } else {
            while (true) {
                i12 = iBinarySearch - 1;
                if (i12 < 0 || iArr[i12] != i11) {
                    break;
                }
                iBinarySearch = i12;
            }
            i13 = z11 ? iBinarySearch : i12;
        }
        return z12 ? Math.max(0, i13) : i13;
    }

    public static String h0(StringBuilder sb2, Formatter formatter, long j11) {
        if (j11 == C.TIME_UNSET) {
            j11 = 0;
        }
        String str = j11 < 0 ? "-" : "";
        long jAbs = (Math.abs(j11) + 500) / 1000;
        long j12 = jAbs % 60;
        long j13 = (jAbs / 60) % 60;
        long j14 = jAbs / 3600;
        sb2.setLength(0);
        return j14 > 0 ? formatter.format("%s%d:%02d:%02d", str, Long.valueOf(j14), Long.valueOf(j13), Long.valueOf(j12)).toString() : formatter.format("%s%02d:%02d", str, Long.valueOf(j13), Long.valueOf(j12)).toString();
    }

    public static int i(long[] jArr, long j11, boolean z11, boolean z12) {
        int i11;
        int i12;
        int iBinarySearch = Arrays.binarySearch(jArr, j11);
        if (iBinarySearch < 0) {
            i12 = -(iBinarySearch + 2);
        } else {
            while (true) {
                i11 = iBinarySearch - 1;
                if (i11 < 0 || jArr[i11] != j11) {
                    break;
                }
                iBinarySearch = i11;
            }
            i12 = z11 ? iBinarySearch : i11;
        }
        return z12 ? Math.max(0, i12) : i12;
    }

    public static String[] i0() {
        String[] strArrJ0 = j0();
        for (int i11 = 0; i11 < strArrJ0.length; i11++) {
            strArrJ0[i11] = E0(strArrJ0[i11]);
        }
        return strArrJ0;
    }

    public static <T> T j(@Nullable T t11) {
        return t11;
    }

    public static String[] j0() {
        Configuration configuration = Resources.getSystem().getConfiguration();
        return f35608a >= 24 ? k0(configuration) : new String[]{Y(configuration.locale)};
    }

    public static <T> T[] k(T[] tArr) {
        return tArr;
    }

    @RequiresApi(24)
    public static String[] k0(Configuration configuration) {
        return T0(configuration.getLocales().toLanguageTags(), ",");
    }

    public static int l(int i11, int i12) {
        return ((i11 + i12) - 1) / i12;
    }

    @Nullable
    public static String l0(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (Exception e11) {
            s.d("Util", "Failed to read system property " + str, e11);
            return null;
        }
    }

    public static long m(long j11, long j12) {
        return ((j11 + j12) - 1) / j12;
    }

    public static String m0(int i11) {
        switch (i11) {
            case -2:
                return DevicePublicKeyStringDef.NONE;
            case -1:
                return AppLovinMediationProvider.UNKNOWN;
            case 0:
                return TmcEngineFactory.ENGINE_TYPE_DEFAULT;
            case 1:
                return MimeTypes.BASE_TYPE_AUDIO;
            case 2:
                return "video";
            case 3:
                return MimeTypes.BASE_TYPE_TEXT;
            case 4:
                return "image";
            case 5:
                return TtmlNode.TAG_METADATA;
            case 6:
                return "camera motion";
            default:
                if (i11 < 10000) {
                    return "?";
                }
                return "custom (" + i11 + ")";
        }
    }

    public static void n(@Nullable Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static byte[] n0(String str) {
        return str.getBytes(com.google.common.base.c.f38165c);
    }

    public static int o(long j11, long j12) {
        if (j11 < j12) {
            return -1;
        }
        return j11 == j12 ? 0 : 1;
    }

    public static int o0(Uri uri) {
        int iP0;
        String scheme = uri.getScheme();
        if (scheme != null && com.google.common.base.a.a("rtsp", scheme)) {
            return 3;
        }
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return 4;
        }
        int iLastIndexOf = lastPathSegment.lastIndexOf(46);
        if (iLastIndexOf >= 0 && (iP0 = p0(lastPathSegment.substring(iLastIndexOf + 1))) != 4) {
            return iP0;
        }
        Matcher matcher = f35617j.matcher((CharSequence) a.e(uri.getPath()));
        if (!matcher.matches()) {
            return 4;
        }
        String strGroup = matcher.group(2);
        if (strGroup != null) {
            if (strGroup.contains("format=mpd-time-csf")) {
                return 0;
            }
            if (strGroup.contains("format=m3u8-aapl")) {
                return 2;
            }
        }
        return 1;
    }

    public static float p(float f11, float f12, float f13) {
        return Math.max(f12, Math.min(f11, f13));
    }

    public static int p0(String str) {
        String strE = com.google.common.base.a.e(str);
        strE.hashCode();
        switch (strE) {
            case "ism":
            case "isml":
                return 1;
            case "mpd":
                return 0;
            case "m3u8":
                return 2;
            default:
                return 4;
        }
    }

    public static int q(int i11, int i12, int i13) {
        return Math.max(i12, Math.min(i11, i13));
    }

    public static int q0(Uri uri, @Nullable String str) {
        if (str == null) {
            return o0(uri);
        }
        switch (str) {
            case "application/x-mpegURL":
                return 2;
            case "application/vnd.ms-sstr+xml":
                return 1;
            case "application/dash+xml":
                return 0;
            case "application/x-rtsp":
                return 3;
            default:
                return 4;
        }
    }

    public static long r(long j11, long j12, long j13) {
        return Math.max(j12, Math.min(j11, j13));
    }

    public static boolean r0(c0 c0Var, c0 c0Var2, @Nullable Inflater inflater) {
        if (c0Var.a() <= 0) {
            return false;
        }
        if (c0Var2.b() < c0Var.a()) {
            c0Var2.c(c0Var.a() * 2);
        }
        if (inflater == null) {
            inflater = new Inflater();
        }
        inflater.setInput(c0Var.d(), c0Var.e(), c0Var.a());
        int iInflate = 0;
        while (true) {
            try {
                iInflate += inflater.inflate(c0Var2.d(), iInflate, c0Var2.b() - iInflate);
                if (inflater.finished()) {
                    c0Var2.O(iInflate);
                    inflater.reset();
                    return true;
                }
                if (!inflater.needsDictionary() && !inflater.needsInput()) {
                    if (iInflate == c0Var2.b()) {
                        c0Var2.c(c0Var2.b() * 2);
                    }
                }
                inflater.reset();
                return false;
            } catch (DataFormatException unused) {
                inflater.reset();
                return false;
            } catch (Throwable th2) {
                inflater.reset();
                throw th2;
            }
        }
    }

    public static boolean s(Object[] objArr, @Nullable Object obj) {
        for (Object obj2 : objArr) {
            if (c(obj2, obj)) {
                return true;
            }
        }
        return false;
    }

    public static boolean s0(Context context) {
        return f35608a >= 23 && context.getPackageManager().hasSystemFeature("android.hardware.type.automotive");
    }

    public static int t(byte[] bArr, int i11, int i12, int i13) {
        while (i11 < i12) {
            i13 = f35621n[((i13 >>> 24) ^ (bArr[i11] & 255)) & 255] ^ (i13 << 8);
            i11++;
        }
        return i13;
    }

    public static boolean t0(int i11) {
        return i11 == 536870912 || i11 == 805306368 || i11 == 4;
    }

    public static int u(byte[] bArr, int i11, int i12, int i13) {
        while (i11 < i12) {
            i13 = f35622o[i13 ^ (bArr[i11] & 255)];
            i11++;
        }
        return i13;
    }

    public static boolean u0(int i11) {
        return i11 == 3 || i11 == 2 || i11 == 268435456 || i11 == 536870912 || i11 == 805306368 || i11 == 4;
    }

    public static Handler v(Looper looper, @Nullable Handler.Callback callback) {
        return new Handler(looper, callback);
    }

    public static boolean v0(int i11) {
        return i11 == 10 || i11 == 13;
    }

    public static Handler w() {
        return x(null);
    }

    public static boolean w0(Uri uri) {
        String scheme = uri.getScheme();
        return TextUtils.isEmpty(scheme) || "file".equals(scheme);
    }

    public static Handler x(@Nullable Handler.Callback callback) {
        return v((Looper) a.i(Looper.myLooper()), callback);
    }

    public static boolean x0(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getApplicationContext().getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    public static Handler y() {
        return z(null);
    }

    public static /* synthetic */ Thread y0(String str, Runnable runnable) {
        return new Thread(runnable, str);
    }

    public static Handler z(@Nullable Handler.Callback callback) {
        return v(Q(), callback);
    }

    public static int z0(int[] iArr, int i11) {
        for (int i12 = 0; i12 < iArr.length; i12++) {
            if (iArr[i12] == i11) {
                return i12;
            }
        }
        return -1;
    }
}
