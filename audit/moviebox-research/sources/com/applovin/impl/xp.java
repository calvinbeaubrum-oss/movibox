package com.applovin.impl;

import android.app.UiModeManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
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
import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.exoplayer2.common.base.Charsets;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.transsion.gslb.Worker;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import okhttp3.internal.ws.WebSocketProtocol;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class xp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f24372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f24373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f24374c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f24375d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f24376e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final byte[] f24377f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Pattern f24378g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Pattern f24379h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Pattern f24380i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Pattern f24381j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static HashMap f24382k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String[] f24383l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String[] f24384m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int[] f24385n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int[] f24386o;

    static {
        int i11 = Build.VERSION.SDK_INT;
        f24372a = i11;
        String str = Build.DEVICE;
        f24373b = str;
        String str2 = Build.MANUFACTURER;
        f24374c = str2;
        String str3 = Build.MODEL;
        f24375d = str3;
        f24376e = str + ", " + str3 + ", " + str2 + ", " + i11;
        f24377f = new byte[0];
        f24378g = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
        f24379h = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
        f24380i = Pattern.compile("%([A-Fa-f0-9]{2})");
        f24381j = Pattern.compile(".*\\.isml?(?:/(manifest(.*))?)?");
        f24383l = new String[]{"alb", "sq", "arm", "hy", "baq", "eu", "bur", "my", "tib", "bo", "chi", "zh", "cze", "cs", "dut", "nl", "ger", DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_ERROR, "gre", "el", "fre", "fr", "geo", "ka", "ice", "is", "mac", "mk", "mao", "mi", "may", "ms", "per", "fa", "rum", "ro", "scc", "hbs-srp", "slo", "sk", "wel", "cy", "id", "ms-ind", "iw", "he", "heb", "he", "ji", "yi", "in", "ms-ind", "ind", "ms-ind", "nb", "no-nob", "nob", "no-nob", "nn", "no-nno", "nno", "no-nno", "tw", "ak-twi", "twi", "ak-twi", "bs", "hbs-bos", "bos", "hbs-bos", "hr", "hbs-hrv", "hrv", "hbs-hrv", "sr", "hbs-srp", "srp", "hbs-srp", "cmn", "zh-cmn", "hak", "zh-hak", "nan", "zh-nan", "hsn", "zh-hsn"};
        f24384m = new String[]{"i-lux", "lb", "i-hak", "zh-hak", "i-navajo", "nv", "no-bok", "no-nob", "no-nyn", "no-nno", "zh-guoyu", "zh-cmn", "zh-hakka", "zh-hak", "zh-min-nan", "zh-nan", "zh-xiang", "zh-hsn"};
        f24385n = new int[]{0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};
        f24386o = new int[]{0, 7, 14, 9, 28, 27, 18, 21, 56, 63, 54, 49, 36, 35, 42, 45, 112, 119, WebSocketProtocol.PAYLOAD_SHORT, 121, 108, 107, 98, 101, 72, 79, 70, 65, 84, 83, 90, 93, 224, 231, 238, 233, 252, 251, 242, 245, 216, 223, 214, 209, 196, 195, 202, 205, 144, 151, 158, 153, 140, 139, TsExtractor.TS_STREAM_TYPE_HDMV_DTS, 133, 168, 175, 166, 161, 180, 179, 186, PsExtractor.PRIVATE_STREAM_1, 199, PsExtractor.AUDIO_STREAM, 201, 206, 219, 220, 213, 210, 255, 248, 241, 246, 227, 228, 237, 234, 183, 176, 185, 190, 171, 172, 165, 162, 143, 136, TsExtractor.TS_STREAM_TYPE_AC3, TsExtractor.TS_STREAM_TYPE_SPLICE_INFO, 147, 148, 157, 154, 39, 32, 41, 46, 59, 60, 53, 50, 31, 24, 17, 22, 3, 4, 13, 10, 87, 80, 89, 94, 75, 76, 69, 66, 111, 104, 97, 102, 115, 116, 125, 122, 137, 142, TsExtractor.TS_STREAM_TYPE_E_AC3, 128, 149, 146, 155, 156, 177, 182, 191, 184, 173, 170, 163, 164, 249, 254, 247, 240, 229, 226, 235, 236, 193, 198, 207, 200, 221, 218, 211, 212, 105, Worker.WHAT_QUIT, Worker.WHAT_SYNC_DATA, 96, 117, 114, 123, 124, 81, 86, 95, 88, 77, 74, 67, 68, 25, 30, 23, 16, 5, 2, 11, 12, 33, 38, 47, 40, 61, 58, 51, 52, 78, 73, 64, 71, 82, 85, 92, 91, 118, 113, 120, 127, 106, 109, 100, 99, 62, 57, 48, 55, 34, 37, 44, 43, 6, 1, 8, 15, 26, 29, 20, 19, 174, 169, 160, 167, 178, 181, 188, 187, 150, 145, 152, 159, TsExtractor.TS_STREAM_TYPE_DTS, 141, 132, 131, 222, 217, 208, 215, 194, 197, 204, 203, 230, 225, 232, 239, 250, 253, 244, 243};
    }

    public static float a(float f11, float f12, float f13) {
        return Math.max(f12, Math.min(f11, f13));
    }

    public static int a(int i11) {
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
                int i12 = f24372a;
                return (i12 < 23 && i12 < 21) ? 0 : 6396;
            default:
                return 0;
        }
    }

    public static int a(int i11, int i12) {
        return ((i11 + i12) - 1) / i12;
    }

    public static int a(int i11, int i12, int i13) {
        return Math.max(i12, Math.min(i11, i13));
    }

    public static int a(long j11, long j12) {
        if (j11 < j12) {
            return -1;
        }
        return j11 == j12 ? 0 : 1;
    }

    public static int a(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        if (audioManager == null) {
            return -1;
        }
        return audioManager.generateAudioSessionId();
    }

    public static int a(rc rcVar, long j11, boolean z11, boolean z12) {
        int i11;
        int iA = rcVar.a() - 1;
        int i12 = 0;
        while (i12 <= iA) {
            int i13 = (i12 + iA) >>> 1;
            if (rcVar.a(i13) < j11) {
                i12 = i13 + 1;
            } else {
                iA = i13 - 1;
            }
        }
        if (z11 && (i11 = iA + 1) < rcVar.a() && rcVar.a(i11) == j11) {
            return i11;
        }
        if (z12 && iA == -1) {
            return 0;
        }
        return iA;
    }

    public static int a(String str) {
        String[] strArrA;
        int length;
        if (str == null || (length = (strArrA = a(str, "_")).length) < 2) {
            return 0;
        }
        String str2 = strArrA[length - 1];
        boolean z11 = length >= 3 && "neg".equals(strArrA[length - 2]);
        try {
            int i11 = Integer.parseInt((String) b1.a((Object) str2));
            return z11 ? -i11 : i11;
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public static int a(ByteBuffer byteBuffer, int i11) {
        int i12 = byteBuffer.getInt(i11);
        return byteBuffer.order() == ByteOrder.BIG_ENDIAN ? i12 : Integer.reverseBytes(i12);
    }

    public static int a(List list, Comparable comparable, boolean z11, boolean z12) {
        int i11;
        int i12;
        int iBinarySearch = Collections.binarySearch(list, comparable);
        if (iBinarySearch < 0) {
            i12 = ~iBinarySearch;
        } else {
            int size = list.size();
            while (true) {
                i11 = iBinarySearch + 1;
                if (i11 >= size || ((Comparable) list.get(i11)).compareTo(comparable) != 0) {
                    break;
                }
                iBinarySearch = i11;
            }
            i12 = z11 ? iBinarySearch : i11;
        }
        return z12 ? Math.min(list.size() - 1, i12) : i12;
    }

    public static int a(byte[] bArr, int i11, int i12, int i13) {
        while (i11 < i12) {
            i13 = f24385n[((i13 >>> 24) ^ (bArr[i11] & 255)) & 255] ^ (i13 << 8);
            i11++;
        }
        return i13;
    }

    public static int a(int[] iArr, int i11) {
        for (int i12 = 0; i12 < iArr.length; i12++) {
            if (iArr[i12] == i11) {
                return i12;
            }
        }
        return -1;
    }

    public static int a(int[] iArr, int i11, boolean z11, boolean z12) {
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

    public static int a(long[] jArr, long j11, boolean z11, boolean z12) {
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

    public static long a(long j11) {
        return j11 == C.TIME_UNSET ? System.currentTimeMillis() : j11 + SystemClock.elapsedRealtime();
    }

    public static long a(long j11, float f11) {
        return f11 == 1.0f ? j11 : Math.round(j11 * ((double) f11));
    }

    public static long a(long j11, long j12, long j13) {
        long j14 = j11 + j12;
        return ((j11 ^ j14) & (j12 ^ j14)) < 0 ? j13 : j14;
    }

    public static Point a(Context context, Display display) {
        if (display.getDisplayId() == 0 && d(context)) {
            String strB = f24372a < 28 ? b("sys.display-size") : b("vendor.display-size");
            if (!TextUtils.isEmpty(strB)) {
                try {
                    String[] strArrA = a(strB.trim(), "x");
                    if (strArrA.length == 2) {
                        int i11 = Integer.parseInt(strArrA[0]);
                        int i12 = Integer.parseInt(strArrA[1]);
                        if (i11 > 0 && i12 > 0) {
                            return new Point(i11, i12);
                        }
                    }
                } catch (NumberFormatException unused) {
                }
                pc.b("Util", "Invalid display size: " + strB);
            }
            if ("Sony".equals(f24374c) && f24375d.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                return new Point(3840, 2160);
            }
        }
        Point point = new Point();
        int i13 = f24372a;
        if (i13 >= 23) {
            c(display, point);
        } else if (i13 >= 17) {
            b(display, point);
        } else {
            a(display, point);
        }
        return point;
    }

    public static Handler a() {
        return a((Handler.Callback) null);
    }

    public static Handler a(Handler.Callback callback) {
        return a((Looper) b1.b(Looper.myLooper()), callback);
    }

    public static Handler a(Looper looper, Handler.Callback callback) {
        return new Handler(looper, callback);
    }

    public static CharSequence a(CharSequence charSequence, int i11) {
        return charSequence.length() <= i11 ? charSequence : charSequence.subSequence(0, i11);
    }

    public static Object a(Object obj) {
        return obj;
    }

    public static String a(Context context, String str) {
        String str2;
        try {
            str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            str2 = "?";
        }
        return str + "/" + str2 + " (Linux;Android " + Build.VERSION.RELEASE + ") ExoPlayerLib/2.15.1";
    }

    public static String a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static String a(StringBuilder sb2, Formatter formatter, long j11) {
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

    public static String a(Locale locale) {
        return f24372a >= 21 ? b(locale) : locale.toString();
    }

    public static String a(byte[] bArr) {
        return new String(bArr, Charsets.UTF_8);
    }

    public static String a(byte[] bArr, int i11, int i12) {
        return new String(bArr, i11, i12, Charsets.UTF_8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Thread a(String str, Runnable runnable) {
        return new Thread(runnable, str);
    }

    public static void a(Parcel parcel, boolean z11) {
        parcel.writeInt(z11 ? 1 : 0);
    }

    private static void a(Display display, Point point) {
        display.getSize(point);
    }

    public static void a(i5 i5Var) {
        if (i5Var != null) {
            try {
                i5Var.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void a(long[] jArr, long j11, long j12) {
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

    public static boolean a(Uri uri) {
        String scheme = uri.getScheme();
        return TextUtils.isEmpty(scheme) || "file".equals(scheme);
    }

    public static boolean a(Handler handler, Runnable runnable) {
        if (!handler.getLooper().getThread().isAlive()) {
            return false;
        }
        if (handler.getLooper() != Looper.myLooper()) {
            return handler.post(runnable);
        }
        runnable.run();
        return true;
    }

    public static boolean a(Parcel parcel) {
        return parcel.readInt() != 0;
    }

    public static boolean a(bh bhVar, bh bhVar2, Inflater inflater) {
        if (bhVar.a() <= 0) {
            return false;
        }
        if (bhVar2.b() < bhVar.a()) {
            bhVar2.a(bhVar.a() * 2);
        }
        if (inflater == null) {
            inflater = new Inflater();
        }
        inflater.setInput(bhVar.c(), bhVar.d(), bhVar.a());
        int iInflate = 0;
        while (true) {
            try {
                iInflate += inflater.inflate(bhVar2.c(), iInflate, bhVar2.b() - iInflate);
                if (inflater.finished()) {
                    bhVar2.e(iInflate);
                    inflater.reset();
                    return true;
                }
                if (!inflater.needsDictionary() && !inflater.needsInput()) {
                    if (iInflate == bhVar2.b()) {
                        bhVar2.a(bhVar2.b() * 2);
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

    public static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static byte[] a(InputStream inputStream) throws IOException {
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

    public static Object[] a(Object[] objArr) {
        return objArr;
    }

    public static Object[] a(Object[] objArr, int i11) {
        b1.a(i11 <= objArr.length);
        return Arrays.copyOf(objArr, i11);
    }

    public static Object[] a(Object[] objArr, int i11, int i12) {
        b1.a(i11 >= 0);
        b1.a(i12 <= objArr.length);
        return Arrays.copyOfRange(objArr, i11, i12);
    }

    public static Object[] a(Object[] objArr, Object[] objArr2) {
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length + objArr2.length);
        System.arraycopy(objArr2, 0, objArrCopyOf, objArr.length, objArr2.length);
        return objArrCopyOf;
    }

    private static String[] a(Configuration configuration) {
        return a(configuration.getLocales().toLanguageTags(), ",");
    }

    public static String[] a(String str, String str2) {
        return str.split(str2, -1);
    }

    public static int b(int i11) {
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

    public static int b(int i11, int i12) {
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

    public static int b(List list, Comparable comparable, boolean z11, boolean z12) {
        int i11;
        int i12;
        int iBinarySearch = Collections.binarySearch(list, comparable);
        if (iBinarySearch < 0) {
            i12 = -(iBinarySearch + 2);
        } else {
            while (true) {
                i11 = iBinarySearch - 1;
                if (i11 < 0 || ((Comparable) list.get(i11)).compareTo(comparable) != 0) {
                    break;
                }
                iBinarySearch = i11;
            }
            i12 = z11 ? iBinarySearch : i11;
        }
        return z12 ? Math.max(0, i12) : i12;
    }

    public static int b(byte[] bArr, int i11, int i12, int i13) {
        while (i11 < i12) {
            i13 = f24386o[i13 ^ (bArr[i11] & 255)];
            i11++;
        }
        return i13;
    }

    public static int b(long[] jArr, long j11, boolean z11, boolean z12) {
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

    public static long b(long j11) {
        return (j11 == C.TIME_UNSET || j11 == Long.MIN_VALUE) ? j11 : j11 * 1000;
    }

    public static long b(long j11, float f11) {
        return f11 == 1.0f ? j11 : Math.round(j11 / ((double) f11));
    }

    public static long b(long j11, long j12, long j13) {
        return Math.max(j12, Math.min(j11, j13));
    }

    public static Handler b() {
        return b((Handler.Callback) null);
    }

    public static Handler b(Handler.Callback callback) {
        return a(d(), callback);
    }

    public static f9 b(int i11, int i12, int i13) {
        return new f9.b().f(MimeTypes.AUDIO_RAW).c(i12).n(i13).j(i11).a();
    }

    public static String b(Context context) {
        TelephonyManager telephonyManager;
        if (context != null && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (!TextUtils.isEmpty(networkCountryIso)) {
                return Ascii.toUpperCase(networkCountryIso);
            }
        }
        return Ascii.toUpperCase(Locale.getDefault().getCountry());
    }

    private static String b(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (Exception e11) {
            pc.a("Util", "Failed to read system property " + str, e11);
            return null;
        }
    }

    private static String b(Locale locale) {
        return locale.toLanguageTag();
    }

    public static String b(Object[] objArr) {
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < objArr.length; i11++) {
            sb2.append(objArr[i11].getClass().getSimpleName());
            if (i11 < objArr.length - 1) {
                sb2.append(", ");
            }
        }
        return sb2.toString();
    }

    private static void b(Display display, Point point) {
        display.getRealSize(point);
    }

    public static String[] b(String str, String str2) {
        return str.split(str2, 2);
    }

    public static long c(int i11, int i12) {
        return i(i12) | (i(i11) << 32);
    }

    public static long c(long j11) {
        return (j11 == C.TIME_UNSET || j11 == Long.MIN_VALUE) ? j11 : j11 / 1000;
    }

    public static long c(long j11, long j12, long j13) {
        if (j13 >= j12 && j13 % j12 == 0) {
            return j11 / (j13 / j12);
        }
        if (j13 < j12 && j12 % j13 == 0) {
            return j11 * (j12 / j13);
        }
        return (long) (j11 * (j12 / j13));
    }

    public static Point c(Context context) {
        DisplayManager displayManager;
        Display display = (f24372a < 17 || (displayManager = (DisplayManager) context.getSystemService("display")) == null) ? null : displayManager.getDisplay(0);
        if (display == null) {
            display = ((WindowManager) b1.a((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
        }
        return a(context, display);
    }

    public static String c(int i11) {
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

    private static HashMap c() {
        String[] iSOLanguages = Locale.getISOLanguages();
        HashMap map = new HashMap(iSOLanguages.length + f24383l.length);
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
            String[] strArr = f24383l;
            if (i11 >= strArr.length) {
                return map;
            }
            map.put(strArr[i11], strArr[i11 + 1]);
            i11 += 2;
        }
    }

    private static void c(Display display, Point point) {
        Display.Mode mode = display.getMode();
        point.x = mode.getPhysicalWidth();
        point.y = mode.getPhysicalHeight();
    }

    public static byte[] c(String str) {
        return str.getBytes(Charsets.UTF_8);
    }

    public static int d(int i11) {
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

    public static long d(long j11, long j12, long j13) {
        long j14 = j11 - j12;
        return ((j11 ^ j14) & (j12 ^ j11)) < 0 ? j13 : j14;
    }

    public static Looper d() {
        Looper looperMyLooper = Looper.myLooper();
        return looperMyLooper != null ? looperMyLooper : Looper.getMainLooper();
    }

    private static String d(String str) {
        int i11 = 0;
        while (true) {
            String[] strArr = f24384m;
            if (i11 >= strArr.length) {
                return str;
            }
            if (str.startsWith(strArr[i11])) {
                return strArr[i11 + 1] + str.substring(strArr[i11].length());
            }
            i11 += 2;
        }
    }

    public static boolean d(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getApplicationContext().getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    public static int e(int i11) {
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

    public static ExecutorService e(final String str) {
        return Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.applovin.impl.i90
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return xp.a(str, runnable);
            }
        });
    }

    public static String[] e() {
        String[] strArrF = f();
        for (int i11 = 0; i11 < strArrF.length; i11++) {
            strArrF[i11] = f(strArrF[i11]);
        }
        return strArrF;
    }

    public static String f(String str) {
        if (str == null) {
            return null;
        }
        String strReplace = str.replace('_', '-');
        if (!strReplace.isEmpty() && !strReplace.equals(C.LANGUAGE_UNDETERMINED)) {
            str = strReplace;
        }
        String lowerCase = Ascii.toLowerCase(str);
        String str2 = b(lowerCase, "-")[0];
        if (f24382k == null) {
            f24382k = c();
        }
        String str3 = (String) f24382k.get(str2);
        if (str3 != null) {
            lowerCase = str3 + lowerCase.substring(str2.length());
            str2 = str3;
        }
        return ("no".equals(str2) || "i".equals(str2) || "zh".equals(str2)) ? d(lowerCase) : lowerCase;
    }

    public static boolean f(int i11) {
        return i11 == 536870912 || i11 == 805306368 || i11 == 4;
    }

    private static String[] f() {
        Configuration configuration = Resources.getSystem().getConfiguration();
        return f24372a >= 24 ? a(configuration) : new String[]{a(configuration.locale)};
    }

    public static boolean g(int i11) {
        return i11 == 3 || i11 == 2 || i11 == 268435456 || i11 == 536870912 || i11 == 805306368 || i11 == 4;
    }

    public static boolean h(int i11) {
        return i11 == 10 || i11 == 13;
    }

    public static long i(int i11) {
        return ((long) i11) & 4294967295L;
    }
}
