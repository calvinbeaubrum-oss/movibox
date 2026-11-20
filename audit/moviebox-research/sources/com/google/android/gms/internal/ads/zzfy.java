package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.app.UiModeManager;
import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.media.AudioFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.applovin.sdk.AppLovinMediationProvider;
import com.cloud.tmc.integration.core.TmcEngineFactory;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.transsion.gslb.Worker;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfy {
    public static final int zza;
    public static final String zzb;
    public static final String zzc;
    public static final String zzd;
    public static final String zze;
    public static final byte[] zzf;
    private static final Pattern zzg;
    private static final Pattern zzh;
    private static final Pattern zzi;
    private static final Pattern zzj;

    @Nullable
    private static HashMap zzk;
    private static final String[] zzl;
    private static final String[] zzm;
    private static final int[] zzn;
    private static final int[] zzo;

    static {
        int i11 = Build.VERSION.SDK_INT;
        zza = i11;
        String str = Build.DEVICE;
        zzb = str;
        String str2 = Build.MANUFACTURER;
        zzc = str2;
        String str3 = Build.MODEL;
        zzd = str3;
        zze = str + ", " + str3 + ", " + str2 + ", " + i11;
        zzf = new byte[0];
        zzg = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
        zzh = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
        zzi = Pattern.compile("%([A-Fa-f0-9]{2})");
        zzj = Pattern.compile("(?:.*\\.)?isml?(?:/(manifest(.*))?)?", 2);
        zzl = new String[]{"alb", "sq", "arm", "hy", "baq", "eu", "bur", "my", "tib", "bo", "chi", "zh", "cze", "cs", "dut", "nl", "ger", DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_ERROR, "gre", "el", "fre", "fr", "geo", "ka", "ice", "is", "mac", "mk", "mao", "mi", "may", "ms", "per", "fa", "rum", "ro", "scc", "hbs-srp", "slo", "sk", "wel", "cy", "id", "ms-ind", "iw", "he", "heb", "he", "ji", "yi", "arb", "ar-arb", "in", "ms-ind", "ind", "ms-ind", "nb", "no-nob", "nob", "no-nob", "nn", "no-nno", "nno", "no-nno", "tw", "ak-twi", "twi", "ak-twi", "bs", "hbs-bos", "bos", "hbs-bos", "hr", "hbs-hrv", "hrv", "hbs-hrv", "sr", "hbs-srp", "srp", "hbs-srp", "cmn", "zh-cmn", "hak", "zh-hak", "nan", "zh-nan", "hsn", "zh-hsn"};
        zzm = new String[]{"i-lux", "lb", "i-hak", "zh-hak", "i-navajo", "nv", "no-bok", "no-nob", "no-nyn", "no-nno", "zh-guoyu", "zh-cmn", "zh-hakka", "zh-hak", "zh-min-nan", "zh-nan", "zh-xiang", "zh-hsn"};
        zzn = new int[]{0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};
        zzo = new int[]{0, 7, 14, 9, 28, 27, 18, 21, 56, 63, 54, 49, 36, 35, 42, 45, 112, 119, WebSocketProtocol.PAYLOAD_SHORT, 121, 108, 107, 98, 101, 72, 79, 70, 65, 84, 83, 90, 93, 224, 231, 238, 233, 252, 251, 242, 245, 216, 223, 214, 209, 196, 195, 202, 205, 144, 151, 158, 153, 140, 139, TsExtractor.TS_STREAM_TYPE_HDMV_DTS, 133, 168, 175, 166, 161, 180, 179, 186, PsExtractor.PRIVATE_STREAM_1, 199, PsExtractor.AUDIO_STREAM, 201, 206, 219, 220, 213, 210, 255, 248, 241, 246, 227, 228, 237, 234, 183, 176, 185, 190, 171, 172, 165, 162, 143, 136, TsExtractor.TS_STREAM_TYPE_AC3, TsExtractor.TS_STREAM_TYPE_SPLICE_INFO, 147, 148, 157, 154, 39, 32, 41, 46, 59, 60, 53, 50, 31, 24, 17, 22, 3, 4, 13, 10, 87, 80, 89, 94, 75, 76, 69, 66, 111, 104, 97, 102, 115, 116, 125, 122, 137, 142, TsExtractor.TS_STREAM_TYPE_E_AC3, 128, 149, 146, 155, 156, 177, 182, 191, 184, 173, 170, 163, 164, 249, 254, 247, 240, 229, 226, 235, 236, 193, 198, 207, 200, 221, 218, 211, 212, 105, Worker.WHAT_QUIT, Worker.WHAT_SYNC_DATA, 96, 117, 114, 123, 124, 81, 86, 95, 88, 77, 74, 67, 68, 25, 30, 23, 16, 5, 2, 11, 12, 33, 38, 47, 40, 61, 58, 51, 52, 78, 73, 64, 71, 82, 85, 92, 91, 118, 113, 120, 127, 106, 109, 100, 99, 62, 57, 48, 55, 34, 37, 44, 43, 6, 1, 8, 15, 26, 29, 20, 19, 174, 169, 160, 167, 178, 181, 188, 187, 150, 145, 152, 159, TsExtractor.TS_STREAM_TYPE_DTS, 141, 132, 131, 222, 217, 208, 215, 194, 197, 204, 203, 230, 225, 232, 239, 250, 253, 244, 243};
    }

    public static String zzA(byte[] bArr, int i11, int i12) {
        return new String(bArr, i11, i12, zzfwq.zzc);
    }

    public static String zzB(int i11) {
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
            default:
                return "camera motion";
        }
    }

    public static String zzC(String str) {
        if (str == null) {
            return null;
        }
        String strReplace = str.replace('_', '-');
        if (!strReplace.isEmpty() && !strReplace.equals(C.LANGUAGE_UNDETERMINED)) {
            str = strReplace;
        }
        String strZza = zzfwk.zza(str);
        int i11 = 0;
        String str2 = strZza.split("-", 2)[0];
        if (zzk == null) {
            zzk = zzO();
        }
        String str3 = (String) zzk.get(str2);
        if (str3 != null) {
            strZza = str3.concat(String.valueOf(strZza.substring(str2.length())));
            str2 = str3;
        }
        if (!"no".equals(str2) && !"i".equals(str2) && !"zh".equals(str2)) {
            return strZza;
        }
        while (true) {
            String[] strArr = zzm;
            int length = strArr.length;
            if (i11 >= 18) {
                return strZza;
            }
            if (strZza.startsWith(strArr[i11])) {
                return String.valueOf(strArr[i11 + 1]).concat(String.valueOf(strZza.substring(strArr[i11].length())));
            }
            i11 += 2;
        }
    }

    public static ExecutorService zzD(final String str) {
        return Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.google.android.gms.internal.ads.zzfx
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, str);
            }
        });
    }

    public static void zzE(long[] jArr, long j11, long j12) {
        int i11 = 0;
        RoundingMode roundingMode = RoundingMode.FLOOR;
        if (j12 >= 1000000 && j12 % 1000000 == 0) {
            long jZza = zzgcq.zza(j12, 1000000L, RoundingMode.UNNECESSARY);
            while (i11 < jArr.length) {
                jArr[i11] = zzgcq.zza(jArr[i11], jZza, roundingMode);
                i11++;
            }
            return;
        }
        if (j12 < 1000000 && 1000000 % j12 == 0) {
            long jZza2 = zzgcq.zza(1000000L, j12, RoundingMode.UNNECESSARY);
            while (i11 < jArr.length) {
                jArr[i11] = zzgcq.zzc(jArr[i11], jZza2);
                i11++;
            }
            return;
        }
        for (int i12 = 0; i12 < jArr.length; i12++) {
            long j13 = jArr[i12];
            if (j13 != 0) {
                if (j12 >= j13 && j12 % j13 == 0) {
                    jArr[i12] = zzgcq.zza(1000000L, zzgcq.zza(j12, j13, RoundingMode.UNNECESSARY), roundingMode);
                } else if (j12 >= j13 || j13 % j12 != 0) {
                    jArr[i12] = zzM(j13, 1000000L, j12, roundingMode);
                } else {
                    jArr[i12] = zzgcq.zzc(1000000L, zzgcq.zza(j13, j12, RoundingMode.UNNECESSARY));
                }
            }
        }
    }

    public static boolean zzF(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static boolean zzG(zzfp zzfpVar, zzfp zzfpVar2, @Nullable Inflater inflater) {
        boolean z11 = false;
        if (zzfpVar.zzb() <= 0) {
            return false;
        }
        if (zzfpVar2.zzc() < zzfpVar.zzb()) {
            int iZzb = zzfpVar.zzb();
            zzfpVar2.zzE(iZzb + iZzb);
        }
        if (inflater == null) {
            inflater = new Inflater();
        }
        inflater.setInput(zzfpVar.zzM(), zzfpVar.zzd(), zzfpVar.zzb());
        int iInflate = 0;
        while (true) {
            try {
                iInflate += inflater.inflate(zzfpVar2.zzM(), iInflate, zzfpVar2.zzc() - iInflate);
                if (!inflater.finished()) {
                    if (inflater.needsDictionary() || inflater.needsInput()) {
                        break;
                        break;
                    }
                    if (iInflate == zzfpVar2.zzc()) {
                        int iZzc = zzfpVar2.zzc();
                        zzfpVar2.zzE(iZzc + iZzc);
                    }
                } else {
                    zzfpVar2.zzJ(iInflate);
                    z11 = true;
                    break;
                }
            } catch (DataFormatException unused) {
            } catch (Throwable th2) {
                inflater.reset();
                throw th2;
            }
        }
        inflater.reset();
        return z11;
    }

    public static boolean zzH(int i11) {
        return i11 == 3 || i11 == 2 || i11 == 268435456 || i11 == 21 || i11 == 1342177280 || i11 == 22 || i11 == 1610612736 || i11 == 4;
    }

    public static boolean zzI(int i11) {
        return i11 == 10 || i11 == 13;
    }

    public static boolean zzJ(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getApplicationContext().getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    public static boolean zzK(Handler handler, Runnable runnable) {
        if (!handler.getLooper().getThread().isAlive()) {
            return false;
        }
        if (handler.getLooper() != Looper.myLooper()) {
            return handler.post(runnable);
        }
        runnable.run();
        return true;
    }

    public static Object[] zzL(Object[] objArr, int i11) {
        zzek.zzd(i11 <= objArr.length);
        return Arrays.copyOf(objArr, i11);
    }

    private static long zzM(long j11, long j12, long j13, RoundingMode roundingMode) {
        long jZzc = zzgcq.zzc(j11, j12);
        if (jZzc != Long.MAX_VALUE && jZzc != Long.MIN_VALUE) {
            return zzgcq.zza(jZzc, j13, roundingMode);
        }
        long jZzb = zzgcq.zzb(Math.abs(j12), Math.abs(j13));
        RoundingMode roundingMode2 = RoundingMode.UNNECESSARY;
        long jZza = zzgcq.zza(j12, jZzb, roundingMode2);
        long jZza2 = zzgcq.zza(j13, jZzb, roundingMode2);
        long jZzb2 = zzgcq.zzb(Math.abs(j11), Math.abs(jZza2));
        long jZza3 = zzgcq.zza(j11, jZzb2, roundingMode2);
        long jZza4 = zzgcq.zza(jZza2, jZzb2, roundingMode2);
        long jZzc2 = zzgcq.zzc(jZza3, jZza);
        if (jZzc2 != Long.MAX_VALUE && jZzc2 != Long.MIN_VALUE) {
            return zzgcq.zza(jZzc2, jZza4, roundingMode);
        }
        double d11 = jZza3 * (jZza / jZza4);
        if (d11 > 9.223372036854776E18d) {
            return Long.MAX_VALUE;
        }
        if (d11 < -9.223372036854776E18d) {
            return Long.MIN_VALUE;
        }
        return zzgcl.zza(d11, roundingMode);
    }

    @Nullable
    private static String zzN(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (Exception e11) {
            zzff.zzd("Util", "Failed to read system property ".concat(str), e11);
            return null;
        }
    }

    private static HashMap zzO() {
        String[] iSOLanguages = Locale.getISOLanguages();
        int length = iSOLanguages.length;
        int length2 = zzl.length;
        HashMap map = new HashMap(length + 88);
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
            String[] strArr = zzl;
            int length3 = strArr.length;
            if (i11 >= 88) {
                return map;
            }
            map.put(strArr[i11], strArr[i11 + 1]);
            i11 += 2;
        }
    }

    public static int zza(long[] jArr, long j11, boolean z11, boolean z12) {
        int i11;
        int iBinarySearch = Arrays.binarySearch(jArr, j11);
        if (iBinarySearch < 0) {
            return ~iBinarySearch;
        }
        while (true) {
            i11 = iBinarySearch + 1;
            if (i11 >= jArr.length || jArr[i11] != j11) {
                break;
            }
            iBinarySearch = i11;
        }
        return !z11 ? i11 : iBinarySearch;
    }

    public static int zzb(int[] iArr, int i11, boolean z11, boolean z12) {
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

    public static int zzc(long[] jArr, long j11, boolean z11, boolean z12) {
        int i11;
        int iBinarySearch = Arrays.binarySearch(jArr, j11);
        if (iBinarySearch < 0) {
            i11 = -(iBinarySearch + 2);
        } else {
            while (true) {
                int i12 = iBinarySearch - 1;
                if (i12 < 0 || jArr[i12] != j11) {
                    break;
                }
                iBinarySearch = i12;
            }
            i11 = iBinarySearch;
        }
        return z12 ? Math.max(0, i11) : i11;
    }

    public static int zzd(byte[] bArr, int i11, int i12, int i13) {
        while (i11 < i12) {
            i13 = zzn[(i13 >>> 24) ^ (bArr[i11] & 255)] ^ (i13 << 8);
            i11++;
        }
        return i13;
    }

    public static int zze(byte[] bArr, int i11, int i12, int i13) {
        int i14 = 0;
        while (i11 < i12) {
            i14 = zzo[i14 ^ (bArr[i11] & 255)];
            i11++;
        }
        return i14;
    }

    public static int zzf(int i11) {
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:12:0x0015 A[RETURN] */
    @SuppressLint({"InlinedApi"})
    public static int zzg(int i11) {
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
                if (zza >= 32) {
                    return 737532;
                }
                return 6396;
            case 12:
                return 743676;
        }
    }

    public static int zzh(ByteBuffer byteBuffer, int i11) {
        int i12 = byteBuffer.getInt(i11);
        return byteBuffer.order() == ByteOrder.BIG_ENDIAN ? i12 : Integer.reverseBytes(i12);
    }

    public static int zzi(int i11) {
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

    public static int zzj(@Nullable String str) {
        String[] strArrSplit;
        int length;
        int i11 = 0;
        if (str == null || (length = (strArrSplit = str.split("_", -1)).length) < 2) {
            return 0;
        }
        String str2 = strArrSplit[length - 1];
        boolean z11 = length >= 3 && "neg".equals(strArrSplit[length + (-2)]);
        str2.getClass();
        try {
            i11 = Integer.parseInt(str2);
            if (z11) {
                return -i11;
            }
        } catch (NumberFormatException unused) {
        }
        return i11;
    }

    public static int zzk(int i11) {
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

    public static int zzl(int i11, int i12) {
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
        return i12 + i12;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:28:0x005d  */
    public static int zzm(Uri uri) {
        byte b11;
        int i11;
        String scheme = uri.getScheme();
        if (scheme != null && zzfwk.zzc("rtsp", scheme)) {
            return 3;
        }
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return 4;
        }
        int iLastIndexOf = lastPathSegment.lastIndexOf(46);
        if (iLastIndexOf >= 0) {
            switch (zzfwk.zza(lastPathSegment.substring(iLastIndexOf + 1))) {
                case "ism":
                    b11 = 2;
                    break;
                case "mpd":
                    b11 = 0;
                    break;
                case "isml":
                    b11 = 3;
                    break;
                case "m3u8":
                    b11 = 1;
                    break;
                default:
                    b11 = -1;
                    break;
            }
            if (b11 == 0) {
                i11 = 0;
            } else if (b11 != 1) {
                i11 = (b11 == 2 || b11 == 3) ? 1 : 4;
            } else {
                i11 = 2;
            }
            if (i11 != 4) {
                return i11;
            }
        }
        Pattern pattern = zzj;
        String path = uri.getPath();
        path.getClass();
        Matcher matcher = pattern.matcher(path);
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

    public static long zzn(long j11, int i11) {
        return zzs(j11, i11, 1000000L, RoundingMode.CEILING);
    }

    public static long zzo(long j11, float f11) {
        return f11 == 1.0f ? j11 : Math.round(j11 * ((double) f11));
    }

    public static long zzp(long j11, float f11) {
        return f11 == 1.0f ? j11 : Math.round(j11 / ((double) f11));
    }

    public static long zzq(long j11) {
        return (j11 == C.TIME_UNSET || j11 == Long.MIN_VALUE) ? j11 : j11 * 1000;
    }

    public static long zzr(long j11, int i11) {
        return zzs(j11, 1000000L, i11, RoundingMode.FLOOR);
    }

    public static long zzs(long j11, long j12, long j13, RoundingMode roundingMode) {
        if (j11 == 0 || j12 == 0) {
            return 0L;
        }
        if (j13 >= j12 && j13 % j12 == 0) {
            return zzgcq.zza(j11, zzgcq.zza(j13, j12, RoundingMode.UNNECESSARY), roundingMode);
        }
        if (j13 < j12 && j12 % j13 == 0) {
            return zzgcq.zzc(j11, zzgcq.zza(j12, j13, RoundingMode.UNNECESSARY));
        }
        if (j13 < j11 || j13 % j11 != 0) {
            return (j13 >= j11 || j11 % j13 != 0) ? zzM(j11, j12, j13, roundingMode) : zzgcq.zzc(j12, zzgcq.zza(j11, j13, RoundingMode.UNNECESSARY));
        }
        return zzgcq.zza(j12, zzgcq.zza(j13, j11, RoundingMode.UNNECESSARY), roundingMode);
    }

    public static long zzt(long j11) {
        return (j11 == C.TIME_UNSET || j11 == Long.MIN_VALUE) ? j11 : j11 / 1000;
    }

    public static Point zzu(Context context) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        Display display = displayManager != null ? displayManager.getDisplay(0) : null;
        if (display == null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            windowManager.getClass();
            display = windowManager.getDefaultDisplay();
        }
        if (display.getDisplayId() == 0 && zzJ(context)) {
            String strZzN = zza < 28 ? zzN("sys.display-size") : zzN("vendor.display-size");
            if (!TextUtils.isEmpty(strZzN)) {
                try {
                    String[] strArrSplit = strZzN.trim().split("x", -1);
                    if (strArrSplit.length == 2) {
                        int i11 = Integer.parseInt(strArrSplit[0]);
                        int i12 = Integer.parseInt(strArrSplit[1]);
                        if (i11 > 0 && i12 > 0) {
                            return new Point(i11, i12);
                        }
                    }
                } catch (NumberFormatException unused) {
                }
                zzff.zzc("Util", "Invalid display size: ".concat(String.valueOf(strZzN)));
            }
            if ("Sony".equals(zzc) && zzd.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                return new Point(3840, 2160);
            }
        }
        Point point = new Point();
        if (zza < 23) {
            display.getRealSize(point);
            return point;
        }
        Display.Mode mode = display.getMode();
        point.x = mode.getPhysicalWidth();
        point.y = mode.getPhysicalHeight();
        return point;
    }

    @RequiresApi(21)
    public static AudioFormat zzv(int i11, int i12, int i13) {
        return new AudioFormat.Builder().setSampleRate(i11).setChannelMask(i12).setEncoding(i13).build();
    }

    public static Handler zzw(@Nullable Handler.Callback callback) {
        Looper looperMyLooper = Looper.myLooper();
        zzek.zzb(looperMyLooper);
        return new Handler(looperMyLooper, null);
    }

    public static Looper zzx() {
        Looper looperMyLooper = Looper.myLooper();
        return looperMyLooper != null ? looperMyLooper : Looper.getMainLooper();
    }

    public static zzam zzy(int i11, int i12, int i13) {
        zzak zzakVar = new zzak();
        zzakVar.zzW(MimeTypes.AUDIO_RAW);
        zzakVar.zzy(i12);
        zzakVar.zzX(i13);
        zzakVar.zzQ(i11);
        return zzakVar.zzac();
    }

    public static String zzz(byte[] bArr) {
        return new String(bArr, zzfwq.zzc);
    }
}
