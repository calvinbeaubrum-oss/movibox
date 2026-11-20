package com.bytedance.sdk.openadsdk.utils;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class WP {
    private static String ExN = null;
    private static int TRI = Integer.MAX_VALUE;
    public static boolean pFF = false;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static boolean f28759sc = false;
    private static final CharSequence zY = "amigo";
    private static final CharSequence We = "funtouch";

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private static final ConcurrentHashMap<String, String> f28758qr = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: source.java */
    public static class sc implements Callable<String> {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private final String f28761sc;

        public sc(String str) {
            this.f28761sc = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
        public String call() throws Exception {
            String str = (String) WP.f28758qr.get(this.f28761sc);
            if (str != null) {
                return str;
            }
            System.currentTimeMillis();
            String strZY = WP.zY(this.f28761sc);
            System.currentTimeMillis();
            if (strZY != null) {
                WP.f28758qr.put(this.f28761sc, strZY);
            }
            return strZY;
        }
    }

    public static boolean BT() {
        return "smartisan".equalsIgnoreCase(Build.MANUFACTURER) || "smartisan".equalsIgnoreCase(Build.BRAND);
    }

    public static boolean ExN() {
        if (!pFF) {
            try {
                Class.forName("miui.os.Build");
                f28759sc = true;
                pFF = true;
                return true;
            } catch (Exception unused) {
                pFF = true;
            }
        }
        return f28759sc;
    }

    public static String Ol() {
        return Build.DISPLAY + "_" + We("ro.gn.sv.version");
    }

    public static boolean Qj() {
        String str = Build.DISPLAY;
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains(zY);
    }

    public static String Ql() {
        String strSR = SR();
        if (strSR == null || !strSR.toLowerCase().contains("emotionui")) {
            return "";
        }
        return strSR + "_" + Build.DISPLAY;
    }

    public static String SR() {
        return We("ro.build.version.emui");
    }

    public static String Sfl() {
        if (!wjp()) {
            return "";
        }
        return "coloros_" + We(cJ.qr("ro.build.version.kllkrom")) + "_" + Build.DISPLAY;
    }

    public static String TRI() {
        return We("ro.vivo.os.build.display.id") + "_" + We("ro.vivo.product.version");
    }

    public static String Tf() {
        if (!ExN()) {
            return "";
        }
        return "miui_" + We("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
    }

    public static boolean UFX() {
        return !TextUtils.isEmpty(We("ro.letv.release.version"));
    }

    public static String WH() {
        if (!UFX()) {
            return "";
        }
        return "eui_" + We("ro.letv.release.version") + "_" + Build.DISPLAY;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static String We(String str) {
        String str2;
        String str3 = f28758qr.get(str);
        if (str3 != null) {
            return str3;
        }
        try {
            if (TextUtils.isEmpty("")) {
                final com.bytedance.sdk.component.Qj.qr qrVar = new com.bytedance.sdk.component.Qj.qr(new sc(str), 5, 2);
                Cb.pFF(new com.bytedance.sdk.component.Qj.Qj("_getSystemPropertyTask") { // from class: com.bytedance.sdk.openadsdk.utils.WP.1
                    @Override // java.lang.Runnable
                    public void run() {
                        qrVar.run();
                    }
                });
                str2 = (String) qrVar.get(1L, TimeUnit.SECONDS);
            } else {
                str2 = "";
            }
        } catch (Throwable unused) {
        }
        return str2 == null ? "" : str2;
    }

    public static boolean We() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static String Xc() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase().contains("flyme")) ? "" : str;
    }

    public static boolean YIK() {
        try {
            String str = Build.BRAND;
            if (TextUtils.isEmpty(str) || !str.toLowerCase().startsWith("huawei")) {
                String str2 = Build.MANUFACTURER;
                if (TextUtils.isEmpty(str2) || !str2.toLowerCase().startsWith("huawei")) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String dE() {
        if (BT()) {
            try {
                return "smartisan_".concat(String.valueOf(We("ro.smartisan.version")));
            } catch (Throwable unused) {
            }
        }
        return Build.DISPLAY;
    }

    public static boolean pFF() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    public static boolean qr() {
        String strWe = We("ro.vivo.os.build.display.id");
        return !TextUtils.isEmpty(strWe) && strWe.toLowerCase().contains(We);
    }

    public static String sc() {
        if (!TextUtils.isEmpty(ExN)) {
            return ExN;
        }
        String strSc = com.bytedance.sdk.openadsdk.core.Ol.sc("sdk_local_rom_info", 604800000L);
        ExN = strSc;
        if (TextUtils.isEmpty(strSc)) {
            String strUEA = uEA();
            ExN = strUEA;
            com.bytedance.sdk.openadsdk.core.Ol.sc("sdk_local_rom_info", strUEA);
        }
        return ExN;
    }

    public static boolean sc(String str) {
        if (TextUtils.isEmpty(str)) {
            str = SR();
        }
        return (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("emotionui")) || YIK();
    }

    private static String uEA() {
        if (BT()) {
            return dE();
        }
        if (ExN()) {
            return Tf();
        }
        if (pFF()) {
            return Xc();
        }
        if (wjp()) {
            return Sfl();
        }
        String strQl = Ql();
        if (!TextUtils.isEmpty(strQl)) {
            return strQl;
        }
        if (qr()) {
            return TRI();
        }
        if (Qj()) {
            return Ol();
        }
        if (We()) {
            return zY();
        }
        String strWH = WH();
        return !TextUtils.isEmpty(strWH) ? strWH : Build.DISPLAY;
    }

    public static boolean wjp() {
        if (TRI == Integer.MAX_VALUE) {
            String str = Build.MANUFACTURER;
            String strQr = cJ.qr("kllk");
            if (TextUtils.isEmpty(str) || !str.toLowerCase().contains(strQr)) {
                TRI = 0;
            } else {
                TRI = 1;
            }
        }
        return TRI == 1;
    }

    public static String zY() {
        return We("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String zY(String str) {
        BufferedReader bufferedReader;
        Throwable th2;
        String line = "";
        Process process = null;
        try {
            try {
                try {
                    Process processExec = Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str)));
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()), 1024);
                        try {
                            line = bufferedReader.readLine();
                            processExec.exitValue();
                            bufferedReader.close();
                        } catch (IllegalThreadStateException unused) {
                            process = processExec;
                            try {
                                process.destroy();
                            } catch (Throwable unused2) {
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return line;
                        } catch (Throwable th3) {
                            th2 = th3;
                            try {
                                com.bytedance.sdk.component.utils.Tf.sc("ToolUtils", "Unable to read sysprop ".concat(String.valueOf(str)), th2);
                                return line;
                            } finally {
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e11) {
                                        com.bytedance.sdk.component.utils.Tf.sc("ToolUtils", "Exception while closing InputStream", e11);
                                    }
                                }
                            }
                        }
                    } catch (IllegalThreadStateException unused3) {
                        bufferedReader = null;
                    }
                } catch (IOException e12) {
                    com.bytedance.sdk.component.utils.Tf.sc("ToolUtils", "Exception while closing InputStream", e12);
                }
            } catch (Throwable th4) {
                bufferedReader = null;
                th2 = th4;
            }
        } catch (IllegalThreadStateException unused4) {
            bufferedReader = null;
        }
        return line;
    }
}
