package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.compose.animation.core.j0;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TRI {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static final AtomicReference<Boolean> f28756sc = new AtomicReference<>(null);
    private static final AtomicReference<String> pFF = new AtomicReference<>(null);

    public static String ExN(Context context) {
        try {
            AtomicReference<String> atomicReference = pFF;
            String str = atomicReference.get();
            if (str != null) {
                return str;
            }
            PackageInfo packageInfoTRI = TRI(context);
            String str2 = packageInfoTRI != null ? packageInfoTRI.versionName : "";
            j0.a(atomicReference, null, str2);
            return str2;
        } catch (Throwable unused) {
            j0.a(pFF, null, "");
            return "";
        }
    }

    private static boolean ExN() {
        if (Qj()) {
            return true;
        }
        String[] strArr = {"M2011J18C", "22061218C", "2308CPXD0C", "24072PX77C", "2405CPX3DC", "2405CPX3DG"};
        try {
            String lowerCase = Build.MODEL.toLowerCase();
            if (!TextUtils.isEmpty(lowerCase)) {
                for (int i11 = 0; i11 < 6; i11++) {
                    if (lowerCase.contains(strArr[i11])) {
                        return true;
                    }
                }
                if (pFF()) {
                    String strZY = zY();
                    if (TextUtils.isEmpty(strZY)) {
                        return false;
                    }
                    for (String str : strZY.split(",")) {
                        if (lowerCase.contains(str)) {
                            return true;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static boolean Ol() {
        if (WH()) {
            return true;
        }
        String[] strArr = {"CPH2439", "CPH2437", "CPH2499", "CPH2519", "PEUM00", "PGU110", "PGT110", "PHN110", "PHT110"};
        try {
            String lowerCase = Build.MODEL.toLowerCase();
            if (!TextUtils.isEmpty(lowerCase)) {
                for (int i11 = 0; i11 < 9; i11++) {
                    if (lowerCase.contains(strArr[i11].toLowerCase())) {
                        return true;
                    }
                }
                if (pFF()) {
                    String strZY = zY();
                    if (TextUtils.isEmpty(strZY)) {
                        return false;
                    }
                    for (String str : strZY.split(",")) {
                        if (lowerCase.contains(str.toLowerCase())) {
                            return true;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static boolean Ol(Context context) {
        try {
            Class.forName("io.flutter.embedding.android.FlutterActivity");
            return true;
        } catch (ClassNotFoundException unused) {
            if (context == null) {
                return false;
            }
            try {
                return new File(context.getApplicationInfo().nativeLibraryDir + "/libflutter.so").exists();
            } catch (Throwable unused2) {
                return false;
            }
        }
    }

    private static boolean Qj() {
        try {
            return ((Integer) Class.forName("android.os.SystemProperties").getMethod("getInt", String.class, Integer.TYPE).invoke(null, "persist.sys.muiltdisplay_type", 0)).intValue() == 2;
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("BED", "isXiaomiFold return false " + th2.getMessage());
            return false;
        }
    }

    private static boolean Qj(Context context) {
        try {
            Class.forName("com.unity3d.player.UnityPlayerActivity");
            return true;
        } catch (ClassNotFoundException unused) {
            if (context == null) {
                return false;
            }
            try {
                return new File(context.getApplicationInfo().nativeLibraryDir + "/libunity.so").exists();
            } catch (Throwable unused2) {
                return false;
            }
        }
    }

    public static PackageInfo TRI(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                return WebView.getCurrentWebViewPackage();
            }
            PackageInfo packageInfo = (PackageInfo) Class.forName("android.webkit.WebViewFactory").getMethod("getLoadedPackageInfo", new Class[0]).invoke(null, new Object[0]);
            return packageInfo != null ? packageInfo : UFX(context);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    private static boolean TRI() {
        if (qr()) {
            return true;
        }
        String[] strArr = {"V2330", "V2178A", "V2229A", "V2303A", "V2337A", "V2256A", "V2266A"};
        try {
            String lowerCase = Build.MODEL.toLowerCase();
            if (!TextUtils.isEmpty(lowerCase)) {
                for (int i11 = 0; i11 < 7; i11++) {
                    if (lowerCase.contains(strArr[i11].toLowerCase())) {
                        return true;
                    }
                }
                if (pFF()) {
                    String strZY = zY();
                    if (TextUtils.isEmpty(strZY)) {
                        return false;
                    }
                    for (String str : strZY.split(",")) {
                        if (lowerCase.contains(str.toLowerCase())) {
                            return true;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static PackageInfo UFX(Context context) {
        try {
            String str = Build.VERSION.SDK_INT <= 23 ? (String) Class.forName("android.webkit.WebViewFactory").getMethod("getWebViewPackageName", new Class[0]).invoke(null, new Object[0]) : (String) Class.forName("android.webkit.WebViewUpdateService").getMethod("getCurrentWebViewPackageName", new Class[0]).invoke(null, new Object[0]);
            if (str == null) {
                return null;
            }
            return context.getPackageManager().getPackageInfo(str, 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean UFX() {
        try {
            Class<?> cls = Class.forName("com.samsung.android.feature.SemFloatingFeature");
            Object objInvoke = cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            Method declaredMethod = cls.getDeclaredMethod("getString", String.class);
            return "TRUE".equalsIgnoreCase((String) declaredMethod.invoke(objInvoke, "SEC_FLOATING_FEATURE_FRAMEWORK_SUPPORT_FOLDABLE_TYPE_FOLD")) || "TRUE".equalsIgnoreCase((String) declaredMethod.invoke(objInvoke, "SEC_FLOATING_FEATURE_FRAMEWORK_SUPPORT_FOLDABLE_TYPE_FLIP"));
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e11) {
            com.bytedance.sdk.component.utils.Tf.sc("PAG_BANNER", "get ss fold device error: " + e11.getMessage());
            return false;
        }
    }

    private static boolean WH() {
        try {
            Class<?> cls = Class.forName("com.oplus.content.OplusFeatureConfigManager");
            Object objInvoke = cls.getDeclaredMethod("hasFeature", String.class).invoke(cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), "oplus.hardware.type.fold");
            if (objInvoke instanceof Boolean) {
                return ((Boolean) objInvoke).booleanValue();
            }
            return false;
        } catch (ClassNotFoundException e11) {
            e = e11;
            com.bytedance.sdk.component.utils.Tf.sc("BED", "get oppo fold properties error, msg: " + e.getMessage());
            return false;
        } catch (IllegalAccessException e12) {
            e = e12;
            com.bytedance.sdk.component.utils.Tf.sc("BED", "get oppo fold properties error, msg: " + e.getMessage());
            return false;
        } catch (NoSuchMethodException e13) {
            e = e13;
            com.bytedance.sdk.component.utils.Tf.sc("BED", "get oppo fold properties error, msg: " + e.getMessage());
            return false;
        } catch (InvocationTargetException e14) {
            e = e14;
            com.bytedance.sdk.component.utils.Tf.sc("BED", "get oppo fold properties error, msg: " + e.getMessage());
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean WH(Context context) {
        try {
            Class.forName("com.facebook.react.ReactActivity");
            return true;
        } catch (ClassNotFoundException unused) {
            if (context == null) {
                return false;
            }
            try {
                return new File(context.getApplicationInfo().nativeLibraryDir + "/libreactnativejni.so").exists();
            } catch (Throwable unused2) {
                return false;
            }
        }
    }

    public static int We(Context context) {
        try {
            Class.forName("com.google.android.play.core.splitinstall.SplitInstallManager");
            return 1;
        } catch (ClassNotFoundException unused) {
            return 0;
        }
    }

    private static boolean We() {
        if (UFX()) {
            return true;
        }
        String[] strArr = {"sm-f9000", "sm-f9160", "sm-f9260", "sm-f9360", "sm-f9460", "sm-f9560", "sm-f7000", "sm-f7070", "sm-f7110", "sm-f7210", "sm-f7310", "sm-f7410"};
        String[] strArr2 = {"winner", "f2q", "q2q", "q4q", "q5q", "q6q", "bloomq", "bloomxq", "b2q", "b4q", "b5q", "b6q"};
        try {
            String lowerCase = Build.DEVICE.toLowerCase();
            if (!TextUtils.isEmpty(lowerCase)) {
                for (int i11 = 0; i11 < 12; i11++) {
                    if (lowerCase.contains(strArr2[i11])) {
                        return true;
                    }
                }
            }
            String lowerCase2 = Build.MODEL.toLowerCase();
            if (TextUtils.isEmpty(lowerCase2)) {
                return false;
            }
            for (int i12 = 0; i12 < 12; i12++) {
                if (lowerCase2.contains(strArr[i12])) {
                    return true;
                }
            }
            if (pFF()) {
                String strSc = com.bytedance.sdk.openadsdk.YIK.sc.sc("fold_config", "fold_samung", "");
                if (TextUtils.isEmpty(strSc)) {
                    return false;
                }
                for (String str : strSc.split(",")) {
                    if (lowerCase2.contains(str)) {
                        return true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static int pFF(Context context) {
        if (Qj(context)) {
            return 1;
        }
        if (Ol(context)) {
            return 2;
        }
        return WH(context) ? 3 : 4;
    }

    public static boolean pFF() {
        return com.bytedance.sdk.openadsdk.YIK.sc.sc("fold_config", "enable", 0) == 1;
    }

    private static boolean qr() {
        try {
            return "foldable".equals(Class.forName("android.util.FtDeviceInfo").getMethod("getDeviceType", new Class[0]).invoke(null, new Object[0]));
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("BED", "isVIVOFoldDevice return false " + th2.getMessage());
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0075  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a7 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:55:0x00a8 A[Catch: all -> 0x00ec, TryCatch #0 {all -> 0x00ec, blocks: (B:3:0x0002, B:5:0x000c, B:7:0x0011, B:9:0x0019, B:10:0x001d, B:12:0x0025, B:13:0x0029, B:15:0x002f, B:17:0x0035, B:19:0x003b, B:22:0x004d, B:23:0x0051, B:50:0x009a, B:52:0x00a0, B:53:0x00a4, B:72:0x00d1, B:73:0x00d6, B:74:0x00db, B:75:0x00e0, B:55:0x00a8, B:58:0x00b0, B:61:0x00b8, B:64:0x00c0, B:76:0x00e4, B:43:0x0081, B:45:0x0087, B:46:0x008c, B:47:0x0091, B:25:0x0055, B:28:0x005d, B:31:0x0065, B:34:0x006d), top: B:80:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:58:0x00b0 A[Catch: all -> 0x00ec, TryCatch #0 {all -> 0x00ec, blocks: (B:3:0x0002, B:5:0x000c, B:7:0x0011, B:9:0x0019, B:10:0x001d, B:12:0x0025, B:13:0x0029, B:15:0x002f, B:17:0x0035, B:19:0x003b, B:22:0x004d, B:23:0x0051, B:50:0x009a, B:52:0x00a0, B:53:0x00a4, B:72:0x00d1, B:73:0x00d6, B:74:0x00db, B:75:0x00e0, B:55:0x00a8, B:58:0x00b0, B:61:0x00b8, B:64:0x00c0, B:76:0x00e4, B:43:0x0081, B:45:0x0087, B:46:0x008c, B:47:0x0091, B:25:0x0055, B:28:0x005d, B:31:0x0065, B:34:0x006d), top: B:80:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b8 A[Catch: all -> 0x00ec, TryCatch #0 {all -> 0x00ec, blocks: (B:3:0x0002, B:5:0x000c, B:7:0x0011, B:9:0x0019, B:10:0x001d, B:12:0x0025, B:13:0x0029, B:15:0x002f, B:17:0x0035, B:19:0x003b, B:22:0x004d, B:23:0x0051, B:50:0x009a, B:52:0x00a0, B:53:0x00a4, B:72:0x00d1, B:73:0x00d6, B:74:0x00db, B:75:0x00e0, B:55:0x00a8, B:58:0x00b0, B:61:0x00b8, B:64:0x00c0, B:76:0x00e4, B:43:0x0081, B:45:0x0087, B:46:0x008c, B:47:0x0091, B:25:0x0055, B:28:0x005d, B:31:0x0065, B:34:0x006d), top: B:80:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x00be  */
    /* JADX WARN: Code duplicated, block: B:64:0x00c0 A[Catch: all -> 0x00ec, TryCatch #0 {all -> 0x00ec, blocks: (B:3:0x0002, B:5:0x000c, B:7:0x0011, B:9:0x0019, B:10:0x001d, B:12:0x0025, B:13:0x0029, B:15:0x002f, B:17:0x0035, B:19:0x003b, B:22:0x004d, B:23:0x0051, B:50:0x009a, B:52:0x00a0, B:53:0x00a4, B:72:0x00d1, B:73:0x00d6, B:74:0x00db, B:75:0x00e0, B:55:0x00a8, B:58:0x00b0, B:61:0x00b8, B:64:0x00c0, B:76:0x00e4, B:43:0x0081, B:45:0x0087, B:46:0x008c, B:47:0x0091, B:25:0x0055, B:28:0x005d, B:31:0x0065, B:34:0x006d), top: B:80:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:69:0x00cb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:70:0x00cd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:71:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d1 A[Catch: all -> 0x00ec, TryCatch #0 {all -> 0x00ec, blocks: (B:3:0x0002, B:5:0x000c, B:7:0x0011, B:9:0x0019, B:10:0x001d, B:12:0x0025, B:13:0x0029, B:15:0x002f, B:17:0x0035, B:19:0x003b, B:22:0x004d, B:23:0x0051, B:50:0x009a, B:52:0x00a0, B:53:0x00a4, B:72:0x00d1, B:73:0x00d6, B:74:0x00db, B:75:0x00e0, B:55:0x00a8, B:58:0x00b0, B:61:0x00b8, B:64:0x00c0, B:76:0x00e4, B:43:0x0081, B:45:0x0087, B:46:0x008c, B:47:0x0091, B:25:0x0055, B:28:0x005d, B:31:0x0065, B:34:0x006d), top: B:80:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x00d6 A[Catch: all -> 0x00ec, TryCatch #0 {all -> 0x00ec, blocks: (B:3:0x0002, B:5:0x000c, B:7:0x0011, B:9:0x0019, B:10:0x001d, B:12:0x0025, B:13:0x0029, B:15:0x002f, B:17:0x0035, B:19:0x003b, B:22:0x004d, B:23:0x0051, B:50:0x009a, B:52:0x00a0, B:53:0x00a4, B:72:0x00d1, B:73:0x00d6, B:74:0x00db, B:75:0x00e0, B:55:0x00a8, B:58:0x00b0, B:61:0x00b8, B:64:0x00c0, B:76:0x00e4, B:43:0x0081, B:45:0x0087, B:46:0x008c, B:47:0x0091, B:25:0x0055, B:28:0x005d, B:31:0x0065, B:34:0x006d), top: B:80:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x00db A[Catch: all -> 0x00ec, TryCatch #0 {all -> 0x00ec, blocks: (B:3:0x0002, B:5:0x000c, B:7:0x0011, B:9:0x0019, B:10:0x001d, B:12:0x0025, B:13:0x0029, B:15:0x002f, B:17:0x0035, B:19:0x003b, B:22:0x004d, B:23:0x0051, B:50:0x009a, B:52:0x00a0, B:53:0x00a4, B:72:0x00d1, B:73:0x00d6, B:74:0x00db, B:75:0x00e0, B:55:0x00a8, B:58:0x00b0, B:61:0x00b8, B:64:0x00c0, B:76:0x00e4, B:43:0x0081, B:45:0x0087, B:46:0x008c, B:47:0x0091, B:25:0x0055, B:28:0x005d, B:31:0x0065, B:34:0x006d), top: B:80:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x00e0 A[Catch: all -> 0x00ec, TryCatch #0 {all -> 0x00ec, blocks: (B:3:0x0002, B:5:0x000c, B:7:0x0011, B:9:0x0019, B:10:0x001d, B:12:0x0025, B:13:0x0029, B:15:0x002f, B:17:0x0035, B:19:0x003b, B:22:0x004d, B:23:0x0051, B:50:0x009a, B:52:0x00a0, B:53:0x00a4, B:72:0x00d1, B:73:0x00d6, B:74:0x00db, B:75:0x00e0, B:55:0x00a8, B:58:0x00b0, B:61:0x00b8, B:64:0x00c0, B:76:0x00e4, B:43:0x0081, B:45:0x0087, B:46:0x008c, B:47:0x0091, B:25:0x0055, B:28:0x005d, B:31:0x0065, B:34:0x006d), top: B:80:0x0002 }] */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static boolean qr(Context context) {
        boolean zOl;
        boolean z11;
        byte b11;
        try {
            AtomicReference<Boolean> atomicReference = f28756sc;
            Boolean bool = atomicReference.get();
            if (bool != null) {
                return bool.booleanValue();
            }
            String lowerCase = Build.BRAND;
            if (!TextUtils.isEmpty(lowerCase)) {
                lowerCase = lowerCase.toLowerCase();
            }
            String lowerCase2 = Build.MANUFACTURER;
            if (!TextUtils.isEmpty(lowerCase2)) {
                lowerCase2 = lowerCase2.toLowerCase();
            }
            if (TextUtils.isEmpty(lowerCase) && TextUtils.isEmpty(lowerCase2)) {
                j0.a(atomicReference, null, Boolean.FALSE);
                return false;
            }
            byte b12 = -1;
            if (TextUtils.isEmpty(lowerCase)) {
                zOl = false;
            } else {
                switch (lowerCase.hashCode()) {
                    case -759499589:
                        if (!lowerCase.equals("xiaomi")) {
                            b11 = -1;
                        } else {
                            b11 = 2;
                        }
                        break;
                    case 3418016:
                        if (!lowerCase.equals("oppo")) {
                            b11 = -1;
                        } else {
                            b11 = 0;
                        }
                        break;
                    case 3620012:
                        if (!lowerCase.equals("vivo")) {
                            b11 = -1;
                        } else {
                            b11 = 1;
                        }
                        break;
                    case 1864941562:
                        if (!lowerCase.equals("samsung")) {
                            b11 = -1;
                        } else {
                            b11 = 3;
                        }
                        break;
                    default:
                        b11 = -1;
                        break;
                }
                if (b11 == 0) {
                    zOl = Ol();
                } else if (b11 == 1) {
                    zOl = TRI();
                } else {
                    if (b11 != 2) {
                        if (b11 != 3) {
                            zOl = false;
                            z11 = true;
                        } else {
                            zOl = We();
                        }
                        if (z11 && !TextUtils.isEmpty(lowerCase2)) {
                            switch (lowerCase2.hashCode()) {
                                case -759499589:
                                    if (lowerCase2.equals("xiaomi")) {
                                        b12 = 2;
                                    }
                                    break;
                                case 3418016:
                                    if (lowerCase2.equals("oppo")) {
                                        b12 = 0;
                                    }
                                    break;
                                case 3620012:
                                    if (lowerCase2.equals("vivo")) {
                                        b12 = 1;
                                    }
                                    break;
                                case 1864941562:
                                    if (lowerCase2.equals("samsung")) {
                                        b12 = 3;
                                    }
                                    break;
                            }
                            if (b12 != 0) {
                                zOl = Ol();
                            } else if (b12 != 1) {
                                zOl = TRI();
                            } else if (b12 != 2) {
                                zOl = ExN();
                            } else if (b12 != 3) {
                                zOl = false;
                            } else {
                                zOl = We();
                            }
                        }
                        j0.a(atomicReference, null, Boolean.valueOf(zOl));
                        return zOl;
                    }
                    zOl = ExN();
                }
            }
            z11 = false;
            if (z11) {
                switch (lowerCase2.hashCode()) {
                    case -759499589:
                        if (lowerCase2.equals("xiaomi")) {
                            b12 = 2;
                        }
                        break;
                    case 3418016:
                        if (lowerCase2.equals("oppo")) {
                            b12 = 0;
                        }
                        break;
                    case 3620012:
                        if (lowerCase2.equals("vivo")) {
                            b12 = 1;
                        }
                        break;
                    case 1864941562:
                        if (lowerCase2.equals("samsung")) {
                            b12 = 3;
                        }
                        break;
                }
                if (b12 != 0) {
                    zOl = Ol();
                } else if (b12 != 1) {
                    zOl = TRI();
                } else if (b12 != 2) {
                    zOl = ExN();
                } else if (b12 != 3) {
                    zOl = false;
                } else {
                    zOl = We();
                }
            }
            j0.a(atomicReference, null, Boolean.valueOf(zOl));
            return zOl;
        } catch (Throwable unused) {
            j0.a(f28756sc, null, Boolean.FALSE);
            return false;
        }
    }

    public static String sc() {
        try {
            return Build.SUPPORTED_ABIS[0];
        } catch (Exception unused) {
            return "";
        }
    }

    public static void sc(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (pFF()) {
                com.bytedance.sdk.openadsdk.core.zY zYVarSc = com.bytedance.sdk.openadsdk.core.zY.sc(context);
                zYVarSc.sc("w_ver", ExN(context));
                zYVarSc.sc("bp", pFF(context));
                zYVarSc.sc("is_fold", qr(context) ? 1 : 0);
                zYVarSc.sc("abi", sc());
                zYVarSc.sc("t_ver", zY(context));
                zYVarSc.sc(CampaignEx.JSON_KEY_AAB, We(context));
            }
        } catch (Throwable unused) {
        }
    }

    public static void sc(JSONObject jSONObject, Context context) {
        if (context == null) {
            return;
        }
        try {
            if (pFF()) {
                com.bytedance.sdk.openadsdk.core.zY zYVarSc = com.bytedance.sdk.openadsdk.core.zY.sc(context);
                String strPFF = zYVarSc.pFF("md", com.bytedance.sdk.openadsdk.core.Ol.pFF().ExN());
                if (!TextUtils.isEmpty(strPFF)) {
                    jSONObject.put("md", strPFF);
                }
                int iPFF = zYVarSc.pFF("bp", pFF(context));
                if (iPFF != 4) {
                    jSONObject.put("bp", iPFF);
                }
                String strPFF2 = zYVarSc.pFF("t_ver", zY(context));
                if (!TextUtils.isEmpty(strPFF2)) {
                    jSONObject.put("t_ver", strPFF2);
                }
                jSONObject.put("is_fold", zYVarSc.pFF("is_fold", qr(context) ? 1 : 0));
                jSONObject.put(CampaignEx.JSON_KEY_AAB, zYVarSc.pFF(CampaignEx.JSON_KEY_AAB, We(context)));
                String strPFF3 = zYVarSc.pFF("w_ver", ExN(context));
                if (!TextUtils.isEmpty(strPFF3)) {
                    jSONObject.put("w_ver", strPFF3);
                }
                String strPFF4 = zYVarSc.pFF("abi", sc());
                if (TextUtils.isEmpty(strPFF4)) {
                    return;
                }
                jSONObject.put("abi", strPFF4);
            }
        } catch (Throwable unused) {
        }
    }

    public static String zY() {
        return com.bytedance.sdk.openadsdk.YIK.sc.sc("fold_config", "fold_default", "");
    }

    public static String zY(Context context) {
        try {
            return String.valueOf(context.getApplicationInfo().targetSdkVersion);
        } catch (Throwable unused) {
            return "";
        }
    }
}
