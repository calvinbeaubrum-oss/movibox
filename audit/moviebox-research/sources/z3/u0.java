package z3;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.Service;
import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.hardware.display.DisplayManager;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.ParserException;
import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.sdk.AppLovinMediationProvider;
import com.cloud.tmc.integration.core.TmcEngineFactory;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.transsion.gslb.Worker;
import com.vungle.warren.error.VungleException;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import okhttp3.internal.http2.Settings;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f81838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f81839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f81840c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f81841d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f81842e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final byte[] f81843f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long[] f81844g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Pattern f81845h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Pattern f81846i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Pattern f81847j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Pattern f81848k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public static HashMap<String, String> f81849l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String[] f81850m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String[] f81851n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int[] f81852o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int[] f81853p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int[] f81854q;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(21)
    public static final class a {
        public static Drawable a(Context context, Resources resources, int i11) {
            return resources.getDrawable(i11, context.getTheme());
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public static class b {
        public static void a(Service service, int i11, Notification notification, int i12, String str) {
            try {
                service.startForeground(i11, notification, i12);
            } catch (RuntimeException e11) {
                o.c("Util", "The service must be declared with a foregroundServiceType that includes " + str);
                throw e11;
            }
        }
    }

    static {
        int i11 = Build.VERSION.SDK_INT;
        f81838a = i11;
        String str = Build.DEVICE;
        f81839b = str;
        String str2 = Build.MANUFACTURER;
        f81840c = str2;
        String str3 = Build.MODEL;
        f81841d = str3;
        f81842e = str + ", " + str3 + ", " + str2 + ", " + i11;
        f81843f = new byte[0];
        f81844g = new long[0];
        f81845h = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
        f81846i = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
        f81847j = Pattern.compile("%([A-Fa-f0-9]{2})");
        f81848k = Pattern.compile("(?:.*\\.)?isml?(?:/(manifest(.*))?)?", 2);
        f81850m = new String[]{"alb", "sq", "arm", "hy", "baq", "eu", "bur", "my", "tib", "bo", "chi", "zh", "cze", "cs", "dut", "nl", "ger", DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_ERROR, "gre", "el", "fre", "fr", "geo", "ka", "ice", "is", "mac", "mk", "mao", "mi", "may", "ms", "per", "fa", "rum", "ro", "scc", "hbs-srp", "slo", "sk", "wel", "cy", "id", "ms-ind", "iw", "he", "heb", "he", "ji", "yi", "arb", "ar-arb", "in", "ms-ind", "ind", "ms-ind", "nb", "no-nob", "nob", "no-nob", "nn", "no-nno", "nno", "no-nno", "tw", "ak-twi", "twi", "ak-twi", "bs", "hbs-bos", "bos", "hbs-bos", "hr", "hbs-hrv", "hrv", "hbs-hrv", "sr", "hbs-srp", "srp", "hbs-srp", "cmn", "zh-cmn", "hak", "zh-hak", "nan", "zh-nan", "hsn", "zh-hsn"};
        f81851n = new String[]{"i-lux", "lb", "i-hak", "zh-hak", "i-navajo", "nv", "no-bok", "no-nob", "no-nyn", "no-nno", "zh-guoyu", "zh-cmn", "zh-hakka", "zh-hak", "zh-min-nan", "zh-nan", "zh-xiang", "zh-hsn"};
        f81852o = new int[]{0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};
        f81853p = new int[]{0, 4129, 8258, 12387, 16516, 20645, 24774, 28903, 33032, 37161, 41290, 45419, 49548, 53677, 57806, 61935};
        f81854q = new int[]{0, 7, 14, 9, 28, 27, 18, 21, 56, 63, 54, 49, 36, 35, 42, 45, 112, 119, WebSocketProtocol.PAYLOAD_SHORT, 121, 108, 107, 98, 101, 72, 79, 70, 65, 84, 83, 90, 93, 224, 231, 238, 233, 252, 251, 242, 245, 216, 223, 214, 209, 196, 195, 202, 205, 144, 151, 158, 153, 140, 139, TsExtractor.TS_STREAM_TYPE_HDMV_DTS, 133, 168, 175, 166, 161, 180, 179, 186, PsExtractor.PRIVATE_STREAM_1, 199, PsExtractor.AUDIO_STREAM, 201, 206, 219, 220, 213, 210, 255, 248, 241, 246, 227, 228, 237, 234, 183, 176, 185, 190, 171, 172, 165, 162, 143, 136, TsExtractor.TS_STREAM_TYPE_AC3, TsExtractor.TS_STREAM_TYPE_SPLICE_INFO, 147, 148, 157, 154, 39, 32, 41, 46, 59, 60, 53, 50, 31, 24, 17, 22, 3, 4, 13, 10, 87, 80, 89, 94, 75, 76, 69, 66, 111, 104, 97, 102, 115, 116, 125, 122, 137, 142, TsExtractor.TS_STREAM_TYPE_E_AC3, 128, 149, 146, 155, 156, 177, 182, 191, 184, 173, 170, 163, 164, 249, 254, 247, 240, 229, 226, 235, 236, 193, 198, 207, 200, 221, 218, 211, 212, 105, Worker.WHAT_QUIT, Worker.WHAT_SYNC_DATA, 96, 117, 114, 123, 124, 81, 86, 95, 88, 77, 74, 67, 68, 25, 30, 23, 16, 5, 2, 11, 12, 33, 38, 47, 40, 61, 58, 51, 52, 78, 73, 64, 71, 82, 85, 92, 91, 118, 113, 120, 127, 106, 109, 100, 99, 62, 57, 48, 55, 34, 37, 44, 43, 6, 1, 8, 15, 26, 29, 20, 19, 174, 169, 160, 167, 178, 181, 188, 187, 150, 145, 152, 159, TsExtractor.TS_STREAM_TYPE_DTS, 141, 132, 131, 222, 217, 208, 215, 194, 197, 204, 203, 230, 225, 232, 239, 250, 253, 244, 243};
    }

    public static Handler A() {
        return B(null);
    }

    public static int A0(Uri uri) {
        int iB0;
        String scheme = uri.getScheme();
        if (scheme != null && com.google.common.base.a.a("rtsp", scheme)) {
            return 3;
        }
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return 4;
        }
        int iLastIndexOf = lastPathSegment.lastIndexOf(46);
        if (iLastIndexOf >= 0 && (iB0 = B0(lastPathSegment.substring(iLastIndexOf + 1))) != 4) {
            return iB0;
        }
        Matcher matcher = f81848k.matcher((CharSequence) z3.a.e(uri.getPath()));
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

    @Nullable
    public static String A1(String str) {
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
        Matcher matcher = f81847j.matcher(str);
        while (i11 > 0 && matcher.find()) {
            char c11 = (char) Integer.parseInt((String) z3.a.e(matcher.group(1)), 16);
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

    public static Handler B(@Nullable Handler.Callback callback) {
        return z((Looper) z3.a.i(Looper.myLooper()), callback);
    }

    public static int B0(String str) {
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

    public static long B1(long j11) {
        return (j11 == C.TIME_UNSET || j11 == Long.MIN_VALUE) ? j11 : j11 / 1000;
    }

    public static Handler C() {
        return D(null);
    }

    public static int C0(Uri uri, @Nullable String str) {
        if (str == null) {
            return A0(uri);
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

    public static void C1(Parcel parcel, boolean z11) {
        parcel.writeInt(z11 ? 1 : 0);
    }

    public static Handler D(@Nullable Handler.Callback callback) {
        return z(V(), callback);
    }

    public static boolean D0(c0 c0Var, c0 c0Var2, @Nullable Inflater inflater) {
        if (c0Var.a() <= 0) {
            return false;
        }
        if (c0Var2.b() < c0Var.a()) {
            c0Var2.c(c0Var.a() * 2);
        }
        if (inflater == null) {
            inflater = new Inflater();
        }
        inflater.setInput(c0Var.e(), c0Var.f(), c0Var.a());
        int iInflate = 0;
        while (true) {
            try {
                iInflate += inflater.inflate(c0Var2.e(), iInflate, c0Var2.b() - iInflate);
                if (inflater.finished()) {
                    c0Var2.T(iInflate);
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

    public static HashMap<String, String> E() {
        String[] iSOLanguages = Locale.getISOLanguages();
        HashMap<String, String> map = new HashMap<>(iSOLanguages.length + f81850m.length);
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
            String[] strArr = f81850m;
            if (i11 >= strArr.length) {
                return map;
            }
            map.put(strArr[i11], strArr[i11 + 1]);
            i11 += 2;
        }
    }

    public static String E0(int i11) {
        return Integer.toString(i11, 36);
    }

    public static long F(long j11, int i11) {
        return h1(j11, i11, 1000000L, RoundingMode.CEILING);
    }

    public static boolean F0(Context context) {
        return f81838a >= 23 && context.getPackageManager().hasSystemFeature("android.hardware.type.automotive");
    }

    public static String G(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static boolean G0(String str) {
        str.hashCode();
        switch (str) {
            case "image/heif":
                return f81838a >= 26;
            case "image/jpeg":
            case "image/webp":
            case "image/bmp":
            case "image/png":
                return true;
            default:
                return false;
        }
    }

    public static String H(byte[] bArr) {
        return new String(bArr, com.google.common.base.c.f38165c);
    }

    public static boolean H0(int i11) {
        return i11 == 21 || i11 == 1342177280 || i11 == 22 || i11 == 1610612736 || i11 == 4;
    }

    public static String I(byte[] bArr, int i11, int i12) {
        return new String(bArr, i11, i12, com.google.common.base.c.f38165c);
    }

    public static boolean I0(int i11) {
        return i11 == 3 || i11 == 2 || i11 == 268435456 || i11 == 21 || i11 == 1342177280 || i11 == 22 || i11 == 1610612736 || i11 == 4;
    }

    @RequiresApi(21)
    public static int J(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        if (audioManager == null) {
            return -1;
        }
        return audioManager.generateAudioSessionId();
    }

    public static boolean J0(Context context) {
        int i11 = f81838a;
        if (i11 >= 29 && context.getApplicationInfo().targetSdkVersion >= 29) {
            if (i11 == 30) {
                String str = f81841d;
                if (com.google.common.base.a.a(str, "moto g(20)") || com.google.common.base.a.a(str, "rmx3231")) {
                }
            }
            return false;
        }
        return true;
    }

    public static int K(int i11) {
        if (i11 == 20) {
            return 30;
        }
        if (i11 == 22) {
            return 31;
        }
        if (i11 == 30) {
            return 34;
        }
        switch (i11) {
            case 2:
            case 3:
                return 3;
            case 4:
            case 5:
            case 6:
                return 21;
            case 7:
            case 8:
                return 23;
            case 9:
            case 10:
            case 11:
            case 12:
                return 28;
            default:
                switch (i11) {
                    case 14:
                        return 25;
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                        return 28;
                    default:
                        return Api.BaseClientBuilder.API_PRIORITY_OTHER;
                }
        }
    }

    public static boolean K0(int i11) {
        return i11 == 10 || i11 == 13;
    }

    @RequiresApi(21)
    public static AudioFormat L(int i11, int i12, int i13) {
        return new AudioFormat.Builder().setSampleRate(i11).setChannelMask(i12).setEncoding(i13).build();
    }

    public static boolean L0(Uri uri) {
        String scheme = uri.getScheme();
        return TextUtils.isEmpty(scheme) || "file".equals(scheme);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:12:0x0015 A[RETURN] */
    @SuppressLint({"InlinedApi"})
    public static int M(int i11) {
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
                return 6396;
            case 9:
            case 11:
            default:
                return 0;
            case 10:
                if (f81838a >= 32) {
                    return 737532;
                }
                return 6396;
            case 12:
                return 743676;
        }
    }

    public static boolean M0(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getApplicationContext().getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    public static androidx.media3.common.h0.b N(androidx.media3.common.h0 h0Var, androidx.media3.common.h0.b bVar) {
        boolean zIsPlayingAd = h0Var.isPlayingAd();
        boolean zT = h0Var.t();
        boolean zR = h0Var.r();
        boolean zG = h0Var.g();
        boolean zA = h0Var.A();
        boolean zJ = h0Var.j();
        boolean zQ = h0Var.getCurrentTimeline().q();
        boolean z11 = false;
        androidx.media3.common.h0.b.a aVarD = new androidx.media3.common.h0.b.a().b(bVar).d(4, !zIsPlayingAd).d(5, zT && !zIsPlayingAd).d(6, zR && !zIsPlayingAd).d(7, !zQ && (zR || !zA || zT) && !zIsPlayingAd).d(8, zG && !zIsPlayingAd).d(9, !zQ && (zG || (zA && zJ)) && !zIsPlayingAd).d(10, !zIsPlayingAd).d(11, zT && !zIsPlayingAd);
        if (zT && !zIsPlayingAd) {
            z11 = true;
        }
        return aVarD.d(12, z11).e();
    }

    public static boolean N0(Context context) {
        return f81838a >= 20 && context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
    }

    public static int O(ByteBuffer byteBuffer, int i11) {
        int i12 = byteBuffer.getInt(i11);
        return byteBuffer.order() == ByteOrder.BIG_ENDIAN ? i12 : Integer.reverseBytes(i12);
    }

    public static /* synthetic */ Thread O0(String str, Runnable runnable) {
        return new Thread(runnable, str);
    }

    public static int P(@Nullable String str, int i11) {
        int i12 = 0;
        for (String str2 : q1(str)) {
            if (i11 == androidx.media3.common.f0.m(str2)) {
                i12++;
            }
        }
        return i12;
    }

    public static int P0(int[] iArr, int i11) {
        for (int i12 = 0; i12 < iArr.length; i12++) {
            if (iArr[i12] == i11) {
                return i12;
            }
        }
        return -1;
    }

    @Nullable
    public static String Q(@Nullable String str, int i11) {
        String[] strArrQ1 = q1(str);
        if (strArrQ1.length == 0) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        for (String str2 : strArrQ1) {
            if (i11 == androidx.media3.common.f0.m(str2)) {
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

    public static String Q0(String str) {
        int i11 = 0;
        while (true) {
            String[] strArr = f81851n;
            if (i11 >= strArr.length) {
                return str;
            }
            if (str.startsWith(strArr[i11])) {
                return strArr[i11 + 1] + str.substring(strArr[i11].length());
            }
            i11 += 2;
        }
    }

    public static String R(Object[] objArr) {
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < objArr.length; i11++) {
            sb2.append(objArr[i11].getClass().getSimpleName());
            if (i11 < objArr.length - 1) {
                sb2.append(", ");
            }
        }
        return sb2.toString();
    }

    public static <T> void R0(List<T> list, int i11, int i12, int i13) {
        ArrayDeque arrayDeque = new ArrayDeque();
        for (int i14 = (i12 - i11) - 1; i14 >= 0; i14--) {
            arrayDeque.addFirst(list.remove(i11 + i14));
        }
        list.addAll(Math.min(i13, list.size()), arrayDeque);
    }

    public static String S(@Nullable Context context) {
        TelephonyManager telephonyManager;
        if (context != null && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (!TextUtils.isEmpty(networkCountryIso)) {
                return com.google.common.base.a.g(networkCountryIso);
            }
        }
        return com.google.common.base.a.g(Locale.getDefault().getCountry());
    }

    public static long S0(long j11) {
        return (j11 == C.TIME_UNSET || j11 == Long.MIN_VALUE) ? j11 : j11 * 1000;
    }

    public static Point T(Context context) {
        DisplayManager displayManager;
        Display display = (f81838a < 17 || (displayManager = (DisplayManager) context.getSystemService("display")) == null) ? null : displayManager.getDisplay(0);
        if (display == null) {
            display = ((WindowManager) z3.a.e((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
        }
        return U(context, display);
    }

    public static ExecutorService T0(final String str) {
        return Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: z3.t0
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return u0.O0(str, runnable);
            }
        });
    }

    public static Point U(Context context, Display display) {
        if (display.getDisplayId() == 0 && M0(context)) {
            String strU0 = f81838a < 28 ? u0("sys.display-size") : u0("vendor.display-size");
            if (!TextUtils.isEmpty(strU0)) {
                try {
                    String[] strArrO1 = o1(strU0.trim(), "x");
                    if (strArrO1.length == 2) {
                        int i11 = Integer.parseInt(strArrO1[0]);
                        int i12 = Integer.parseInt(strArrO1[1]);
                        if (i11 > 0 && i12 > 0) {
                            return new Point(i11, i12);
                        }
                    }
                } catch (NumberFormatException unused) {
                }
                o.c("Util", "Invalid display size: " + strU0);
            }
            if ("Sony".equals(f81840c) && f81841d.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                return new Point(3840, 2160);
            }
        }
        Point point = new Point();
        int i13 = f81838a;
        if (i13 >= 23) {
            Z(display, point);
        } else if (i13 >= 17) {
            Y(display, point);
        } else {
            X(display, point);
        }
        return point;
    }

    public static String U0(String str) {
        if (str == null) {
            return null;
        }
        String strReplace = str.replace('_', '-');
        if (!strReplace.isEmpty() && !strReplace.equals(C.LANGUAGE_UNDETERMINED)) {
            str = strReplace;
        }
        String strE = com.google.common.base.a.e(str);
        String str2 = p1(strE, "-")[0];
        if (f81849l == null) {
            f81849l = E();
        }
        String str3 = f81849l.get(str2);
        if (str3 != null) {
            strE = str3 + strE.substring(str2.length());
            str2 = str3;
        }
        return ("no".equals(str2) || "i".equals(str2) || "zh".equals(str2)) ? Q0(strE) : strE;
    }

    public static Looper V() {
        Looper looperMyLooper = Looper.myLooper();
        return looperMyLooper != null ? looperMyLooper : Looper.getMainLooper();
    }

    public static <T> T[] V0(T[] tArr, T t11) {
        Object[] objArrCopyOf = Arrays.copyOf(tArr, tArr.length + 1);
        objArrCopyOf[tArr.length] = t11;
        return (T[]) j(objArrCopyOf);
    }

    public static Locale W() {
        return f81838a >= 24 ? Locale.getDefault(Locale.Category.DISPLAY) : Locale.getDefault();
    }

    public static <T> T[] W0(T[] tArr, T[] tArr2) {
        T[] tArr3 = (T[]) Arrays.copyOf(tArr, tArr.length + tArr2.length);
        System.arraycopy(tArr2, 0, tArr3, tArr.length, tArr2.length);
        return tArr3;
    }

    public static void X(Display display, Point point) {
        display.getSize(point);
    }

    public static <T> T[] X0(T[] tArr, int i11) {
        z3.a.a(i11 <= tArr.length);
        return (T[]) Arrays.copyOf(tArr, i11);
    }

    @RequiresApi(17)
    public static void Y(Display display, Point point) {
        display.getRealSize(point);
    }

    public static <T> T[] Y0(T[] tArr, int i11, int i12) {
        z3.a.a(i11 >= 0);
        z3.a.a(i12 <= tArr.length);
        return (T[]) Arrays.copyOfRange(tArr, i11, i12);
    }

    @RequiresApi(23)
    public static void Z(Display display, Point point) {
        Display.Mode mode = display.getMode();
        point.x = mode.getPhysicalWidth();
        point.y = mode.getPhysicalHeight();
    }

    public static long Z0(String str) throws ParserException {
        Matcher matcher = f81845h.matcher(str);
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

    public static Drawable a0(Context context, Resources resources, int i11) {
        return f81838a >= 21 ? a.a(context, resources, i11) : resources.getDrawable(i11);
    }

    public static long a1(String str) {
        Matcher matcher = f81846i.matcher(str);
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

    public static long b(long j11, long j12, long j13) {
        long j14 = j11 + j12;
        return ((j11 ^ j14) & (j12 ^ j14)) < 0 ? j13 : j14;
    }

    public static int b0(int i11) {
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

    public static boolean b1(Handler handler, Runnable runnable) {
        if (!handler.getLooper().getThread().isAlive()) {
            return false;
        }
        if (handler.getLooper() != Looper.myLooper()) {
            return handler.post(runnable);
        }
        runnable.run();
        return true;
    }

    public static boolean c(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static int c0(@Nullable String str) {
        String[] strArrO1;
        int length;
        if (str == null || (length = (strArrO1 = o1(str, "_")).length) < 2) {
            return 0;
        }
        String str2 = strArrO1[length - 1];
        boolean z11 = length >= 3 && "neg".equals(strArrO1[length - 2]);
        try {
            int i11 = Integer.parseInt((String) z3.a.e(str2));
            return z11 ? -i11 : i11;
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public static boolean c1(Parcel parcel) {
        return parcel.readInt() != 0;
    }

    public static int d(long[] jArr, long j11, boolean z11, boolean z12) {
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

    public static String d0(int i11) {
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

    public static <T> void d1(List<T> list, int i11, int i12) {
        if (i11 < 0 || i12 > list.size() || i11 > i12) {
            throw new IllegalArgumentException();
        }
        if (i11 != i12) {
            list.subList(i11, i12).clear();
        }
    }

    public static <T extends Comparable<? super T>> int e(List<? extends Comparable<? super T>> list, T t11, boolean z11, boolean z12) {
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

    public static String e0(Locale locale) {
        return f81838a >= 21 ? f0(locale) : locale.toString();
    }

    public static long e1(long j11, int i11) {
        return h1(j11, 1000000L, i11, RoundingMode.FLOOR);
    }

    public static int f(p pVar, long j11, boolean z11, boolean z12) {
        int i11;
        int iC = pVar.c() - 1;
        int i12 = 0;
        while (i12 <= iC) {
            int i13 = (i12 + iC) >>> 1;
            if (pVar.b(i13) < j11) {
                i12 = i13 + 1;
            } else {
                iC = i13 - 1;
            }
        }
        if (z11 && (i11 = iC + 1) < pVar.c() && pVar.b(i11) == j11) {
            return i11;
        }
        if (z12 && iC == -1) {
            return 0;
        }
        return iC;
    }

    @RequiresApi(21)
    public static String f0(Locale locale) {
        return locale.toLanguageTag();
    }

    public static long f1(long j11, long j12, long j13) {
        return h1(j11, j12, j13, RoundingMode.FLOOR);
    }

    public static int g(int[] iArr, int i11, boolean z11, boolean z12) {
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

    public static int g0(Context context) {
        return J0(context) ? 1 : 5;
    }

    public static void g1(long[] jArr, long j11, long j12) {
        j1(jArr, j11, j12, RoundingMode.FLOOR);
    }

    public static int h(long[] jArr, long j11, boolean z11, boolean z12) {
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

    public static long h0(long j11, float f11) {
        return f11 == 1.0f ? j11 : Math.round(j11 * ((double) f11));
    }

    public static long h1(long j11, long j12, long j13, RoundingMode roundingMode) {
        if (j11 == 0 || j12 == 0) {
            return 0L;
        }
        if (j13 >= j12 && j13 % j12 == 0) {
            return com.google.common.math.f.b(j11, com.google.common.math.f.b(j13, j12, RoundingMode.UNNECESSARY), roundingMode);
        }
        if (j13 < j12 && j12 % j13 == 0) {
            return com.google.common.math.f.d(j11, com.google.common.math.f.b(j12, j13, RoundingMode.UNNECESSARY));
        }
        if (j13 < j11 || j13 % j11 != 0) {
            return (j13 >= j11 || j11 % j13 != 0) ? i1(j11, j12, j13, roundingMode) : com.google.common.math.f.d(j12, com.google.common.math.f.b(j11, j13, RoundingMode.UNNECESSARY));
        }
        return com.google.common.math.f.b(j12, com.google.common.math.f.b(j13, j11, RoundingMode.UNNECESSARY), roundingMode);
    }

    public static <T> T i(@Nullable T t11) {
        return t11;
    }

    public static long i0(long j11) {
        return j11 == C.TIME_UNSET ? System.currentTimeMillis() : j11 + SystemClock.elapsedRealtime();
    }

    public static long i1(long j11, long j12, long j13, RoundingMode roundingMode) {
        long jD = com.google.common.math.f.d(j11, j12);
        if (jD != Long.MAX_VALUE && jD != Long.MIN_VALUE) {
            return com.google.common.math.f.b(jD, j13, roundingMode);
        }
        long jC = com.google.common.math.f.c(Math.abs(j12), Math.abs(j13));
        RoundingMode roundingMode2 = RoundingMode.UNNECESSARY;
        long jB = com.google.common.math.f.b(j12, jC, roundingMode2);
        long jB2 = com.google.common.math.f.b(j13, jC, roundingMode2);
        long jC2 = com.google.common.math.f.c(Math.abs(j11), Math.abs(jB2));
        long jB3 = com.google.common.math.f.b(j11, jC2, roundingMode2);
        long jB4 = com.google.common.math.f.b(jB2, jC2, roundingMode2);
        long jD2 = com.google.common.math.f.d(jB3, jB);
        if (jD2 != Long.MAX_VALUE && jD2 != Long.MIN_VALUE) {
            return com.google.common.math.f.b(jD2, jB4, roundingMode);
        }
        double d11 = jB3 * (jB / jB4);
        if (d11 > 9.223372036854776E18d) {
            return Long.MAX_VALUE;
        }
        if (d11 < -9.223372036854776E18d) {
            return Long.MIN_VALUE;
        }
        return com.google.common.math.b.c(d11, roundingMode);
    }

    public static <T> T[] j(T[] tArr) {
        return tArr;
    }

    public static int j0(int i11) {
        if (i11 == 8) {
            return 3;
        }
        if (i11 == 16) {
            return 2;
        }
        if (i11 != 24) {
            return i11 != 32 ? 0 : 22;
        }
        return 21;
    }

    public static void j1(long[] jArr, long j11, long j12, RoundingMode roundingMode) {
        if (j11 == 0) {
            Arrays.fill(jArr, 0L);
            return;
        }
        int i11 = 0;
        if (j12 >= j11 && j12 % j11 == 0) {
            long jB = com.google.common.math.f.b(j12, j11, RoundingMode.UNNECESSARY);
            while (i11 < jArr.length) {
                jArr[i11] = com.google.common.math.f.b(jArr[i11], jB, roundingMode);
                i11++;
            }
            return;
        }
        if (j12 < j11 && j11 % j12 == 0) {
            long jB2 = com.google.common.math.f.b(j11, j12, RoundingMode.UNNECESSARY);
            while (i11 < jArr.length) {
                jArr[i11] = com.google.common.math.f.d(jArr[i11], jB2);
                i11++;
            }
            return;
        }
        for (int i12 = 0; i12 < jArr.length; i12++) {
            long j13 = jArr[i12];
            if (j13 != 0) {
                if (j12 >= j13 && j12 % j13 == 0) {
                    jArr[i12] = com.google.common.math.f.b(j11, com.google.common.math.f.b(j12, j13, RoundingMode.UNNECESSARY), roundingMode);
                } else if (j12 >= j13 || j13 % j12 != 0) {
                    jArr[i12] = i1(j13, j11, j12, roundingMode);
                } else {
                    jArr[i12] = com.google.common.math.f.d(j11, com.google.common.math.f.b(j13, j12, RoundingMode.UNNECESSARY));
                }
            }
        }
    }

    public static int k(int i11, int i12) {
        return ((i11 + i12) - 1) / i12;
    }

    public static androidx.media3.common.y k0(int i11, int i12, int i13) {
        return new androidx.media3.common.y.b().k0(MimeTypes.AUDIO_RAW).L(i12).l0(i13).e0(i11).I();
    }

    public static void k1(Service service, int i11, Notification notification, int i12, String str) {
        if (f81838a >= 29) {
            b.a(service, i11, notification, i12, str);
        } else {
            service.startForeground(i11, notification);
        }
    }

    public static long l(long j11, long j12) {
        return ((j11 + j12) - 1) / j12;
    }

    public static int l0(int i11, int i12) {
        if (i11 != 2) {
            if (i11 == 3) {
                return i12;
            }
            if (i11 != 4) {
                if (i11 != 21) {
                    if (i11 != 22) {
                        if (i11 != 268435456) {
                            if (i11 != 1342177280) {
                                if (i11 != 1610612736) {
                                    throw new IllegalArgumentException();
                                }
                            }
                        }
                    }
                }
                return i12 * 3;
            }
            return i12 * 4;
        }
        return i12 * 2;
    }

    public static boolean l1(@Nullable androidx.media3.common.h0 h0Var, boolean z11) {
        if (h0Var == null || !h0Var.getPlayWhenReady() || h0Var.getPlaybackState() == 1 || h0Var.getPlaybackState() == 4) {
            return true;
        }
        return z11 && h0Var.k() != 0;
    }

    public static void m(@Nullable Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static long m0(long j11, float f11) {
        return f11 == 1.0f ? j11 : Math.round(j11 / ((double) f11));
    }

    public static void m1(Throwable th2) throws Throwable {
        n1(th2);
    }

    public static int n(long j11, long j12) {
        if (j11 < j12) {
            return -1;
        }
        return j11 == j12 ? 0 : 1;
    }

    public static List<String> n0(int i11) {
        ArrayList arrayList = new ArrayList();
        if ((i11 & 1) != 0) {
            arrayList.add("main");
        }
        if ((i11 & 2) != 0) {
            arrayList.add("alt");
        }
        if ((i11 & 4) != 0) {
            arrayList.add("supplementary");
        }
        if ((i11 & 8) != 0) {
            arrayList.add("commentary");
        }
        if ((i11 & 16) != 0) {
            arrayList.add("dub");
        }
        if ((i11 & 32) != 0) {
            arrayList.add("emergency");
        }
        if ((i11 & 64) != 0) {
            arrayList.add("caption");
        }
        if ((i11 & 128) != 0) {
            arrayList.add("subtitle");
        }
        if ((i11 & 256) != 0) {
            arrayList.add("sign");
        }
        if ((i11 & 512) != 0) {
            arrayList.add("describes-video");
        }
        if ((i11 & 1024) != 0) {
            arrayList.add("describes-music");
        }
        if ((i11 & 2048) != 0) {
            arrayList.add("enhanced-intelligibility");
        }
        if ((i11 & 4096) != 0) {
            arrayList.add("transcribes-dialog");
        }
        if ((i11 & 8192) != 0) {
            arrayList.add("easy-read");
        }
        if ((i11 & 16384) != 0) {
            arrayList.add("trick-play");
        }
        return arrayList;
    }

    public static <T extends Throwable> void n1(Throwable th2) throws Throwable {
        throw th2;
    }

    public static float o(float f11, float f12, float f13) {
        return Math.max(f12, Math.min(f11, f13));
    }

    public static List<String> o0(int i11) {
        ArrayList arrayList = new ArrayList();
        if ((i11 & 4) != 0) {
            arrayList.add("auto");
        }
        if ((i11 & 1) != 0) {
            arrayList.add(TmcEngineFactory.ENGINE_TYPE_DEFAULT);
        }
        if ((i11 & 2) != 0) {
            arrayList.add("forced");
        }
        return arrayList;
    }

    public static String[] o1(String str, String str2) {
        return str.split(str2, -1);
    }

    public static int p(int i11, int i12, int i13) {
        return Math.max(i12, Math.min(i11, i13));
    }

    public static int p0(int i11) {
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

    public static String[] p1(String str, String str2) {
        return str.split(str2, 2);
    }

    public static long q(long j11, long j12, long j13) {
        return Math.max(j12, Math.min(j11, j13));
    }

    public static String q0(StringBuilder sb2, Formatter formatter, long j11) {
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

    public static String[] q1(@Nullable String str) {
        return TextUtils.isEmpty(str) ? new String[0] : o1(str.trim(), "(\\s*,\\s*)");
    }

    public static <T> boolean r(SparseArray<T> sparseArray, int i11) {
        return sparseArray.indexOfKey(i11) >= 0;
    }

    public static String[] r0() {
        String[] strArrS0 = s0();
        for (int i11 = 0; i11 < strArrS0.length; i11++) {
            strArrS0[i11] = U0(strArrS0[i11]);
        }
        return strArrS0;
    }

    @Nullable
    public static ComponentName r1(Context context, Intent intent) {
        return f81838a >= 26 ? context.startForegroundService(intent) : context.startService(intent);
    }

    public static boolean s(Object[] objArr, @Nullable Object obj) {
        for (Object obj2 : objArr) {
            if (c(obj2, obj)) {
                return true;
            }
        }
        return false;
    }

    public static String[] s0() {
        Configuration configuration = Resources.getSystem().getConfiguration();
        return f81838a >= 24 ? t0(configuration) : new String[]{e0(configuration.locale)};
    }

    public static long s1(long j11, long j12, long j13) {
        long j14 = j11 - j12;
        return ((j11 ^ j14) & (j12 ^ j11)) < 0 ? j13 : j14;
    }

    public static <T> boolean t(@Nullable SparseArray<T> sparseArray, @Nullable SparseArray<T> sparseArray2) {
        if (sparseArray == null) {
            return sparseArray2 == null;
        }
        if (sparseArray2 == null) {
            return false;
        }
        if (f81838a >= 31) {
            return sparseArray.contentEquals(sparseArray2);
        }
        int size = sparseArray.size();
        if (size != sparseArray2.size()) {
            return false;
        }
        for (int i11 = 0; i11 < size; i11++) {
            if (!Objects.equals(sparseArray.valueAt(i11), sparseArray2.get(sparseArray.keyAt(i11)))) {
                return false;
            }
        }
        return true;
    }

    @RequiresApi(24)
    public static String[] t0(Configuration configuration) {
        return o1(configuration.getLocales().toLanguageTags(), ",");
    }

    public static boolean t1(SQLiteDatabase sQLiteDatabase, String str) {
        return DatabaseUtils.queryNumEntries(sQLiteDatabase, "sqlite_master", "tbl_name = ?", new String[]{str}) > 0;
    }

    public static <T> int u(SparseArray<T> sparseArray) {
        if (f81838a >= 31) {
            return sparseArray.contentHashCode();
        }
        int iKeyAt = 17;
        for (int i11 = 0; i11 < sparseArray.size(); i11++) {
            iKeyAt = (((iKeyAt * 31) + sparseArray.keyAt(i11)) * 31) + Objects.hashCode(sparseArray.valueAt(i11));
        }
        return iKeyAt;
    }

    @Nullable
    public static String u0(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (Exception e11) {
            o.d("Util", "Failed to read system property " + str, e11);
            return null;
        }
    }

    public static byte[] u1(InputStream inputStream) throws IOException {
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

    public static int v(byte[] bArr, int i11, int i12, int i13) {
        while (i11 < i12) {
            int iC = com.google.common.primitives.g.c(bArr[i11]);
            i13 = w(iC & 15, w(iC >> 4, i13));
            i11++;
        }
        return i13;
    }

    public static String v0(int i11) {
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

    public static float v1(byte[] bArr) {
        z3.a.a(bArr.length == 4);
        return Float.intBitsToFloat((bArr[3] & 255) | (bArr[0] << Ascii.CAN) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8));
    }

    public static int w(int i11, int i12) {
        int i13 = (i11 ^ ((i12 >> 12) & 255)) & 255;
        return (f81853p[i13] ^ ((i12 << 4) & Settings.DEFAULT_INITIAL_WINDOW_SIZE)) & Settings.DEFAULT_INITIAL_WINDOW_SIZE;
    }

    public static byte[] w0(String str) {
        return str.getBytes(com.google.common.base.c.f38165c);
    }

    public static String w1(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (int i11 = 0; i11 < bArr.length; i11++) {
            sb2.append(Character.forDigit((bArr[i11] >> 4) & 15, 16));
            sb2.append(Character.forDigit(bArr[i11] & Ascii.SI, 16));
        }
        return sb2.toString();
    }

    public static int x(byte[] bArr, int i11, int i12, int i13) {
        while (i11 < i12) {
            i13 = f81852o[((i13 >>> 24) ^ (bArr[i11] & 255)) & 255] ^ (i13 << 8);
            i11++;
        }
        return i13;
    }

    public static boolean x0(@Nullable androidx.media3.common.h0 h0Var) {
        if (h0Var == null || !h0Var.i(1)) {
            return false;
        }
        h0Var.pause();
        return true;
    }

    public static int x1(byte[] bArr) {
        z3.a.a(bArr.length == 4);
        return bArr[3] | (bArr[0] << Ascii.CAN) | (bArr[1] << Ascii.DLE) | (bArr[2] << 8);
    }

    public static int y(byte[] bArr, int i11, int i12, int i13) {
        while (i11 < i12) {
            i13 = f81854q[i13 ^ (bArr[i11] & 255)];
            i11++;
        }
        return i13;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x002a  */
    /* JADX WARN: Code duplicated, block: B:19:0x002e  */
    public static boolean y0(@Nullable androidx.media3.common.h0 h0Var) {
        boolean z11 = false;
        if (h0Var == null) {
            return false;
        }
        int playbackState = h0Var.getPlaybackState();
        if (playbackState != 1 || !h0Var.i(2)) {
            if (playbackState == 4 && h0Var.i(4)) {
                h0Var.seekToDefaultPosition();
            }
            if (h0Var.i(1)) {
                return z11;
            }
            h0Var.play();
            return true;
        }
        h0Var.prepare();
        z11 = true;
        if (h0Var.i(1)) {
            return z11;
        }
        h0Var.play();
        return true;
    }

    public static long y1(int i11, int i12) {
        return z1(i12) | (z1(i11) << 32);
    }

    public static Handler z(Looper looper, @Nullable Handler.Callback callback) {
        return new Handler(looper, callback);
    }

    public static boolean z0(@Nullable androidx.media3.common.h0 h0Var, boolean z11) {
        return l1(h0Var, z11) ? y0(h0Var) : x0(h0Var);
    }

    public static long z1(int i11) {
        return ((long) i11) & 4294967295L;
    }
}
