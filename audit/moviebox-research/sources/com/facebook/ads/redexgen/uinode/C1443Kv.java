package com.facebook.ads.redexgen.uinode;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.facebook.ads.internal.util.activity.AdActivityIntent;
import com.facebook.ads.internal.util.process.ProcessUtils;
import com.transsion.baselib.db.download.DownloadException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import okhttp3.internal.ws.WebSocketProtocol;
import org.mvel2.ast.ASTNode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Kv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1443Kv {
    public static byte[] A00;
    public static String[] A01 = {"HfGv3264Bq2TQ34NqRtE4P30TXR", "AZVpgJ8fi5FDz5AiC", "FCmmf0GU", "NGZF99o8OEHjBvmOxlLxN", "MEp80XUn5zKurDhCJ73", "hVp2plT6ulDLwck", "CErebgOhZelO8plRL7vU3", "v0a34uu5Y8rm3tpqkSr554RtUBdvL4ru"};

    static {
        A08();
    }

    private int A00(C1795Yn c1795Yn) {
        PackageInfo packageInfo;
        try {
            PackageManager packageManager = c1795Yn.getPackageManager();
            if (packageManager == null || (packageInfo = packageManager.getPackageInfo(A06(TTAdConstant.IMAGE_URL_CODE, 19, 121), 0)) == null || TextUtils.isEmpty(packageInfo.versionName)) {
                return -1;
            }
            return Integer.parseInt(packageInfo.versionName.split(A06(166, 2, 74), 2)[0]);
        } catch (PackageManager.NameNotFoundException | NumberFormatException unused) {
            return -1;
        }
    }

    public static Intent A01(Uri uri) {
        Intent intent = new Intent(A06(186, 26, 50), uri);
        intent.setComponent(null);
        if (Build.VERSION.SDK_INT >= 15) {
            intent.setSelector(null);
        }
        return intent;
    }

    public static Intent A02(C1795Yn c1795Yn, Uri uri) {
        Intent intentA01 = A01(uri);
        intentA01.addCategory(A06(212, 33, 67));
        intentA01.addFlags(ASTNode.DEOP);
        intentA01.putExtra(A06(288, 34, 25), c1795Yn.getPackageName());
        intentA01.putExtra(A06(494, 14, 75), false);
        if (C1384Ih.A1b(c1795Yn)) {
            if (A06(DownloadException.EXCEPTION_IO_MALFORMED_URL, 2, 21).equals(uri.getScheme())) {
                intentA01.setPackage(A06(TTAdConstant.IMAGE_URL_CODE, 19, 121));
            }
        }
        return intentA01;
    }

    public static Intent A03(C1795Yn c1795Yn, Uri uri) {
        Intent intentA01 = A01(uri);
        intentA01.setPackage(A06(322, 19, 20));
        intentA01.putExtra(A06(259, 8, 22), c1795Yn.getPackageName());
        intentA01.putExtra(A06(614, 7, 91), true);
        return intentA01;
    }

    private final EnumC09510g A04(C1795Yn c1795Yn, Uri uri, String str, Map<String, String> map) throws C1431Kh {
        boolean zA05 = AbstractC1385Ii.A05(c1795Yn);
        if (A0E(uri) && zA05) {
            A0B(c1795Yn, uri, str, map);
            return EnumC09510g.A07;
        }
        c1795Yn.A0E().A8f(zA05);
        A09(c1795Yn, uri);
        return EnumC09510g.A06;
    }

    public static EnumC09510g A05(C1443Kv c1443Kv, C1795Yn c1795Yn, Uri uri, String str, Map<String, String> map) throws C1431Kh {
        boolean z11 = A0E(uri) && A06(621, 15, 11).equals(uri.getHost());
        if (!A06(608, 6, 85).equals(uri.getScheme()) && !z11) {
            return c1443Kv.A04(c1795Yn, uri, str, map);
        }
        try {
            c1443Kv.A0A(c1795Yn, uri, str);
            return EnumC09510g.A02;
        } catch (C1441Kt unused) {
            return c1443Kv.A04(c1795Yn, uri, str, map);
        }
    }

    public static String A06(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 60);
        }
        return new String(bArrCopyOfRange);
    }

    private String A07(String str) {
        return Base64.encodeToString(str.getBytes(), 0);
    }

    public static void A08() {
        A00 = new byte[]{-49, -36, -19, -44, -48, -62, -49, -19, -31, -45, -47, -29, -32, -45, -19, -30, -35, -39, -45, -36, -20, -7, 10, -14, -5, -2, 10, -20, -17, 10, -18, -6, -7, -1, -16, -7, -1, -56, -58, -47, -47, -54, -41, -28, -55, -44, -46, -58, -50, -45, -6, Ascii.CAN, 37, -34, 43, -41, 42, 43, Ascii.CAN, 41, 43, -41, -8, 44, Ascii.ESC, 32, Ascii.FS, 37, Ascii.SUB, Ascii.FS, 5, Ascii.FS, 43, 46, 38, 41, 34, -8, Ascii.SUB, 43, 32, 45, 32, 43, 48, -27, -41, 4, Ascii.CAN, 34, Ascii.FS, -41, 42, 44, 41, Ascii.FS, -41, 43, Ascii.US, Ascii.CAN, 43, -41, 32, 43, -34, 42, -41, 32, 37, -41, 48, 38, 44, 41, -41, -8, 37, Ascii.ESC, 41, 38, 32, Ascii.ESC, 4, Ascii.CAN, 37, 32, Ascii.GS, Ascii.FS, 42, 43, -27, 47, 36, 35, -41, Ascii.GS, 32, 35, Ascii.FS, -27, -88, -69, -73, -75, -92, -62, -72, -75, -81, -60, -64, -65, -13, -30, -25, -29, -20, -31, -29, -52, -29, -14, -11, -19, -16, -23, -30, -76, -84, -71, -86, -84, -82, -65, -76, -63, -76, -65, -60, -58, -45, -55, -41, -44, -50, -55, -49, -36, -46, -32, -35, -41, -46, -100, -41, -36, -30, -45, -36, -30, -100, -49, -47, -30, -41, -35, -36, -100, -60, -73, -77, -59, -32, -19, -29, -15, -18, -24, -29, -83, -24, -19, -13, -28, -19, -13, -83, -30, -32, -13, -28, -26, -18, -15, -8, -83, -63, -47, -50, -42, -46, -64, -63, -53, -60, -90, -77, -77, -80, -17, -1, -4, 4, 0, -14, -1, -30, -33, -39, -75, -77, -66, -66, -73, -60, -101, -74, -78, -80, -69, -69, -76, -63, -93, -56, -65, -76, -39, -30, -33, -37, -28, -22, -54, -27, -31, -37, -28, -72, -60, -62, -125, -74, -61, -71, -57, -60, -66, -71, -125, -73, -57, -60, -52, -56, -70, -57, -125, -74, -59, -59, -63, -66, -72, -74, -55, -66, -60, -61, -76, -66, -71, -77, -65, -67, 126, -79, -66, -76, -62, -65, -71, -76, 126, -58, -75, -66, -76, -71, -66, -73, -66, -54, -56, -119, -63, -68, -66, -64, -67, -54, -54, -58, -119, -62, -54, -54, -62, -57, -64, -53, -57, -68, -44, -50, -49, -54, -51, -64, -68, -55, -119, -94, -54, -54, -62, -57, -64, -85, -57, -68, -44, -82, -49, -54, -51, -64, -100, -87, -86, -47, -64, -51, -57, -68, -44, -96, -45, -49, -64, -51, -55, -68, -57, -100, -66, -49, -60, -47, -60, -49, -44, Ascii.CAN, 36, 34, -29, Ascii.ESC, Ascii.SYN, Ascii.CAN, Ascii.SUB, Ascii.ETB, 36, 36, 32, -29, 32, Ascii.SYN, 41, Ascii.SYN, 35, Ascii.SYN, -7, 5, 4, -4, -1, -3, -11, 9, Ascii.VT, 6, 6, 5, 8, 10, 9, -29, Ascii.VT, 2, 10, -1, -19, -1, 4, -6, 5, Ascii.CR, -88, -76, -77, -85, -82, -84, -92, -72, -70, -75, -75, -76, -73, -71, -72, -104, -75, -79, -82, -71, -104, -88, -73, -86, -86, -77, -110, -70, -79, -71, -82, -100, -82, -77, -87, -76, -68, -22, -7, -20, -24, -5, -20, -26, -11, -20, -2, -26, -5, -24, -23, -73, -77, -22, -19, -16, -8, -23, -10, -23, -24, -29, -25, -16, -19, -25, -17, -29, -24, -23, -16, -27, -3, -29, -15, -9, -27, -34, -21, -31, -23, -30, -17, -47, -26, -22, -30, Ascii.SO, Ascii.SUB, Ascii.SUB, Ascii.SYN, -5, 7, 7, 3, -51, -62, -62, 3, -1, -12, Ascii.FF, -63, -6, 2, 2, -6, -1, -8, -63, -10, 2, 0, -62, 6, 7, 2, 5, -8, -62, -12, 3, 3, 6, -62, -53, -41, -41, -45, -42, -74, -64, -84, -80, -65, -78, -82, -63, -74, -61, -78, -84, -82, -64, -84, -80, -63, -82, -84, -61, Ascii.DEL, -2, -14, 3, -4, -10, 5, 6, Ascii.CR, -4, 9, 3, -8, Ascii.DLE, -73, -77, -88, -64, 117, -82, -74, -74, -82, -77, -84, 117, -86, -74, -76, -51, -64, -50, -60, -43, -64, -88, -54, -65, -64, -51, -58, -63, -55, -51, -67, -95, -68, 48, 35, Ascii.US, 49, Ascii.SO, 51, 42, Ascii.US};
    }

    private void A09(C1795Yn c1795Yn, Uri uri) throws C1431Kh {
        C1433Kj.A0C(c1795Yn, A02(c1795Yn, uri));
    }

    private final void A0A(C1795Yn c1795Yn, Uri uri, String str) throws C1441Kt, C1431Kh {
        if (!A0G(c1795Yn)) {
            throw new C1441Kt();
        }
        boolean z11 = (c1795Yn.A0F().A01() && C1384Ih.A1F(c1795Yn)) || (C1384Ih.A1c(c1795Yn) && A0H(c1795Yn));
        if ((!z11 && C1384Ih.A1y(c1795Yn) && C1433Kj.A0D(c1795Yn, A03(c1795Yn, uri))) || A0K(c1795Yn, uri, str)) {
            return;
        }
        Intent intentA02 = A02(c1795Yn, uri);
        intentA02.setPackage(A06(322, 19, 20));
        if (Build.VERSION.SDK_INT >= 24 && z11) {
            intentA02.addFlags(268472320);
        }
        C1433Kj.A0C(c1795Yn, intentA02);
    }

    private void A0B(C1795Yn c1795Yn, Uri uri, String str, Map<String, String> map) {
        AdActivityIntent adActivityIntentA04 = C1433Kj.A04(c1795Yn);
        if (!ProcessUtils.isRemoteRenderingProcess()) {
            adActivityIntentA04.addFlags(ASTNode.DEOP);
        }
        adActivityIntentA04.putExtra(A06(654, 8, WebSocketProtocol.PAYLOAD_SHORT), KB.A03);
        adActivityIntentA04.putExtra(A06(249, 10, 81), uri.toString());
        adActivityIntentA04.putExtra(A06(277, 11, 58), str);
        adActivityIntentA04.putExtra(A06(533, 11, 65), System.currentTimeMillis());
        if (map != null) {
            String strA06 = A06(267, 10, 19);
            adActivityIntentA04.putExtra(strA06, map.get(strA06));
            String strA07 = A06(587, 21, 17);
            adActivityIntentA04.putExtra(strA07, map.get(strA07));
            String strA08 = A06(DownloadException.EXCEPTION_IO_SSL_HANDSHAKE, 23, 72);
            adActivityIntentA04.putExtra(strA08, map.get(strA08));
            String strA09 = A06(646, 8, 28);
            String str2 = map.get(strA09);
            if (str2 != null) {
                adActivityIntentA04.putExtra(strA09, str2);
            }
        }
        try {
            C1433Kj.A0A(c1795Yn, adActivityIntentA04);
        } catch (C1431Kh e11) {
            Throwable cause = e11.getCause();
            C1431Kh cause2 = e11;
            if (cause != null) {
                cause2 = e11.getCause();
            }
            c1795Yn.A07().A9a(A06(168, 11, 15), C8A.A0D, new C8B(cause2));
            Log.e(A06(149, 17, 66), A06(50, 90, 123), cause2);
        }
    }

    public static void A0C(C1443Kv c1443Kv, C1795Yn c1795Yn, Uri uri, String str) {
        c1443Kv.A0L(c1795Yn, uri, str);
    }

    public static void A0D(C1443Kv c1443Kv, C1795Yn c1795Yn, Uri uri, String str) throws C1431Kh {
        A05(c1443Kv, c1795Yn, uri, str, null);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0038  */
    public static boolean A0E(Uri uri) {
        boolean z11;
        if (Build.VERSION.SDK_INT >= 24) {
            boolean zIsCleartextTrafficPermitted = NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
            String[] strArr = A01;
            if (strArr[1].length() == strArr[4].length()) {
                throw new RuntimeException();
            }
            A01[7] = "9DaYNTGnU6m41BFJKxw5hEDOoLHVmNBK";
            if (zIsCleartextTrafficPermitted || NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(uri.getHost())) {
                z11 = true;
            } else {
                z11 = false;
            }
        } else {
            z11 = true;
        }
        String scheme = uri.getScheme();
        return (z11 && A06(544, 4, 106).equalsIgnoreCase(scheme)) || A06(582, 5, 39).equalsIgnoreCase(scheme);
    }

    private boolean A0F(C1795Yn c1795Yn) {
        if (!C1384Ih.A14(c1795Yn)) {
            return false;
        }
        int iA0D = C1384Ih.A0D(c1795Yn);
        if (A01[7].charAt(2) != 'a') {
            throw new RuntimeException();
        }
        A01[2] = "JMUKVK1n";
        int iA00 = A00(c1795Yn);
        return iA0D != -1 && iA00 != -1 && iA0D <= iA00 && Build.VERSION.SDK_INT >= 28;
    }

    private boolean A0G(C1795Yn c1795Yn) {
        Iterator<ResolveInfo> it = c1795Yn.getPackageManager().queryIntentActivities(new Intent(A06(186, 26, 50), AbstractC1446Ky.A00(A06(548, 34, 87))), 0).iterator();
        while (it.hasNext()) {
            if (it.next().activityInfo.applicationInfo.packageName.equals(A06(322, 19, 20))) {
                return true;
            }
        }
        return false;
    }

    public static boolean A0H(C1795Yn c1795Yn) {
        boolean z11 = Build.VERSION.SDK_INT >= 24;
        boolean zA0I = A0I(c1795Yn);
        boolean z12 = z11 && zA0I;
        boolean z13 = true;
        boolean z14 = true;
        boolean zA0C = true;
        if (C1384Ih.A1l(c1795Yn)) {
            Resources system = Resources.getSystem();
            String strA06 = A06(431, 26, 90);
            String strA07 = A06(245, 4, 8);
            String strA08 = A06(179, 7, 41);
            int identifier = system.getIdentifier(strA06, strA07, strA08);
            z13 = identifier != 0 ? Resources.getSystem().getBoolean(identifier) : true;
            String[] strArr = A01;
            if (strArr[6].length() == strArr[3].length()) {
                A01[5] = "0rfBgNygkjU7mub";
                int identifier2 = system.getIdentifier(A06(457, 37, 9), strA07, strA08);
                z14 = identifier2 != 0 ? Resources.getSystem().getBoolean(identifier2) : true;
                zA0C = L6.A0C(c1795Yn);
                z12 &= z13 && z14 && zA0C;
                String[] strArr2 = A01;
                if (strArr2[6].length() == strArr2[3].length()) {
                    A01[5] = "kny6086MT0ulmqJ";
                }
            }
            throw new RuntimeException();
        }
        c1795Yn.A0E().AA7(zA0I, z12, z13, z14, zA0C);
        return z12;
    }

    public static boolean A0I(C1795Yn c1795Yn) {
        try {
            Activity activityA0D = c1795Yn.A0D();
            PackageManager packageManager = c1795Yn.getPackageManager();
            if (activityA0D == null || packageManager == null) {
                return false;
            }
            ActivityInfo activityInfo = Build.VERSION.SDK_INT > 32 ? packageManager.getActivityInfo(activityA0D.getComponentName(), PackageManager.ComponentInfoFlags.of(0L)) : packageManager.getActivityInfo(activityA0D.getComponentName(), 128);
            Field declaredField = ActivityInfo.class.getDeclaredField(A06(636, 10, 31));
            declaredField.setAccessible(true);
            Object obj = declaredField.get(activityInfo);
            return (obj instanceof Integer) && ((Integer) obj).intValue() != 0;
        } catch (PackageManager.NameNotFoundException | IllegalAccessException | NoSuchFieldException e11) {
            c1795Yn.A0E().AA5(e11.getMessage());
        }
        return false;
    }

    private boolean A0J(C1795Yn c1795Yn, Uri uri, String str) throws C1431Kh {
        try {
            Activity activityA0D = c1795Yn.A0D();
            String string = uri.toString();
            if (activityA0D != null && !TextUtils.isEmpty(string)) {
                Intent intent = new Intent();
                if (C1384Ih.A15(c1795Yn)) {
                    String strA06 = AbstractC1898b5.A06(str);
                    if (TextUtils.isEmpty(strA06)) {
                        return false;
                    }
                    intent.putExtra(A06(0, 20, 82), A07(strA06));
                }
                intent.setComponent(new ComponentName(A06(TTAdConstant.IMAGE_URL_CODE, 19, 121), A06(341, 71, 31)));
                intent.putExtra(A06(140, 9, 39), string);
                intent.putExtra(A06(37, 13, 73), A07(A06(20, 17, 111)));
                if (C1433Kj.A0D(c1795Yn, intent)) {
                    return true;
                }
                activityA0D.startActivityForResult(intent, 2);
                return true;
            }
            return false;
        } catch (ActivityNotFoundException | IllegalStateException e11) {
            c1795Yn.A0E().A9e(e11.getMessage());
            return false;
        }
    }

    private boolean A0K(C1795Yn c1795Yn, Uri uri, String str) throws C1431Kh {
        return A0F(c1795Yn) && A0J(c1795Yn, uri, str);
    }

    private final boolean A0L(C1795Yn c1795Yn, Uri uri, String str) {
        return C1433Kj.A0H(c1795Yn, uri, str);
    }

    public static boolean A0M(C1443Kv c1443Kv, C1795Yn c1795Yn, Uri uri, String str) {
        try {
            A0D(c1443Kv, c1795Yn, uri, str);
            return true;
        } catch (C1431Kh e11) {
            Throwable cause = e11.getCause();
            C1431Kh cause2 = e11;
            if (cause != null) {
                cause2 = e11.getCause();
            }
            c1795Yn.A07().A9a(A06(168, 11, 15), C8A.A05, new C8B(cause2));
            return false;
        }
    }
}
