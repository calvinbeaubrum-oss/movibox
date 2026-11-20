package com.bytedance.sdk.openadsdk.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import com.bytedance.JProtect;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class DeviceUtils {
    private static int Ol = 0;
    private static int Qj = 0;
    private static int Ql = 0;
    private static int Tf = 0;
    private static int UFX = 0;
    private static int WH = 0;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static String f28722sc = "";
    private static volatile long pFF = System.currentTimeMillis();
    private static volatile boolean zY = false;
    private static volatile boolean We = false;
    private static volatile boolean ExN = false;
    private static volatile boolean TRI = true;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private static long f28721qr = 0;
    private static AtomicBoolean SR = new AtomicBoolean(false);

    /* JADX INFO: compiled from: source.java */
    public static class AudioInfoReceiver extends BroadcastReceiver {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        static final CopyOnWriteArrayList<com.bytedance.sdk.openadsdk.Tf.qr> f28725sc = new CopyOnWriteArrayList<>();

        /* JADX INFO: Access modifiers changed from: private */
        public static void pFF(Context context) {
            if (DeviceUtils.We || context == null) {
                return;
            }
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
                intentFilter.addAction("android.intent.action.HEADSET_PLUG");
                context.registerReceiver(new AudioInfoReceiver(), intentFilter, null, com.bytedance.sdk.component.utils.qr.sc());
                boolean unused = DeviceUtils.We = true;
            } catch (Throwable unused2) {
            }
        }

        public static void pFF(com.bytedance.sdk.openadsdk.Tf.qr qrVar) {
            if (qrVar == null) {
                return;
            }
            f28725sc.remove(qrVar);
        }

        public static void sc(com.bytedance.sdk.openadsdk.Tf.qr qrVar) {
            if (qrVar != null) {
                CopyOnWriteArrayList<com.bytedance.sdk.openadsdk.Tf.qr> copyOnWriteArrayList = f28725sc;
                if (copyOnWriteArrayList.contains(qrVar)) {
                    return;
                }
                copyOnWriteArrayList.add(qrVar);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            try {
                if (!"android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction())) {
                    if ("android.intent.action.HEADSET_PLUG".equals(intent.getAction())) {
                        int unused = DeviceUtils.Tf = intent.getIntExtra("state", 0);
                    }
                } else if (intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                    int unused2 = DeviceUtils.WH = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_VALUE", 0);
                    if (!f28725sc.isEmpty()) {
                        Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.utils.DeviceUtils.AudioInfoReceiver.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Iterator<com.bytedance.sdk.openadsdk.Tf.qr> it = AudioInfoReceiver.f28725sc.iterator();
                                while (it.hasNext()) {
                                    it.next().sc(DeviceUtils.WH);
                                }
                            }
                        });
                    }
                    if (DeviceUtils.Ol != 0) {
                        int unused3 = DeviceUtils.UFX = (int) ((((double) DeviceUtils.WH) / ((double) DeviceUtils.Ol)) * 100.0d);
                    }
                }
            } catch (Exception unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class pFF extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                boolean unused = DeviceUtils.TRI = true;
            } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                boolean unused2 = DeviceUtils.TRI = false;
            } else if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                long unused3 = DeviceUtils.pFF = System.currentTimeMillis();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class sc extends BroadcastReceiver {
        private sc() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void pFF(Context context) {
            int i11 = Build.VERSION.SDK_INT;
            if (context != null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
                intentFilter.addAction("huawei.intent.action.POWER_MODE_CHANGED_ACTION");
                if (i11 >= 33) {
                    context.registerReceiver(new sc(), intentFilter, 2);
                } else {
                    context.registerReceiver(new sc(), intentFilter);
                }
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || context == null) {
                return;
            }
            if ("android.os.action.POWER_SAVE_MODE_CHANGED".equals(intent.getAction())) {
                DeviceUtils.Sfl(context);
            } else if ("huawei.intent.action.POWER_MODE_CHANGED_ACTION".equals(intent.getAction())) {
                int unused = DeviceUtils.Ql = intent.getIntExtra("state", 0) == 1 ? 1 : 0;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class zY extends com.bytedance.sdk.component.Qj.Qj {
        public zY() {
            super("gaid_task");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v6, types: [com.bytedance.sdk.openadsdk.core.zY] */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [int] */
        /* JADX WARN: Type inference failed for: r3v3 */
        @Override // java.lang.Runnable
        public void run() {
            ?? r11;
            boolean zIsLimitAdTrackingEnabled;
            try {
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(com.bytedance.sdk.openadsdk.core.Xc.sc());
                if (advertisingIdInfo != null) {
                    zIsLimitAdTrackingEnabled = advertisingIdInfo.isLimitAdTrackingEnabled();
                    DeviceUtils.pFF(advertisingIdInfo, zIsLimitAdTrackingEnabled);
                } else {
                    r11 = -1;
                }
                if (r11 == -1) {
                    r11 = zIsLimitAdTrackingEnabled;
                    return;
                } else {
                    r11 = zIsLimitAdTrackingEnabled;
                    com.bytedance.sdk.openadsdk.core.zY.sc(com.bytedance.sdk.openadsdk.core.Xc.sc()).sc("limit_ad_track", r11);
                }
            } catch (IOException e11) {
                com.bytedance.sdk.component.utils.Tf.sc("TTAD.DeviceUtils", "getLmtTask error : signaling connection to Google Play Services failed.", e11);
            } catch (Throwable th2) {
                com.bytedance.sdk.component.utils.Tf.sc("TTAD.DeviceUtils", th2.getMessage());
            }
        }
    }

    private static int BT(Context context) {
        return Tf;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    private static int Dl(Context context) {
        try {
            String str = Build.MANUFACTURER;
            int i11 = 1;
            if (str.equalsIgnoreCase("XIAOMI")) {
                if (Settings.System.getInt(context.getContentResolver(), "POWER_SAVE_MODE_OPEN") != 1) {
                    i11 = 0;
                }
            } else {
                if (!str.equalsIgnoreCase("HUAWEI")) {
                    return 0;
                }
                if (Settings.System.getInt(context.getContentResolver(), "SmartModeStatus") != 4) {
                    i11 = 0;
                }
            }
            return i11;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static float ExN() {
        int i11 = -1;
        try {
            Context contextSc = com.bytedance.sdk.openadsdk.core.Xc.sc();
            if (contextSc != null) {
                i11 = Settings.System.getInt(contextSc.getContentResolver(), "screen_brightness", -1);
            }
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("TTAD.DeviceUtils", th2.getMessage());
        }
        if (i11 < 0) {
            return -1.0f;
        }
        return Math.round((i11 / 255.0f) * 10.0f) / 10.0f;
    }

    public static JSONObject ExN(Context context) {
        return sc(context, false);
    }

    public static int Ol() {
        return Ol;
    }

    public static String Ol(Context context) {
        if (TextUtils.isEmpty(f28722sc)) {
            f28722sc = com.bytedance.sdk.openadsdk.core.zY.sc(context).pFF("framework_name", "");
        }
        return f28722sc;
    }

    public static int Qj() {
        return UFX;
    }

    public static int Qj(Context context) {
        return Qj;
    }

    private static int SR(Context context) {
        try {
            int i11 = context.getApplicationContext().getResources().getConfiguration().uiMode & 48;
            if (i11 == 32) {
                return 1;
            }
            return i11 == 16 ? 0 : -1;
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Sfl(Context context) {
        if (context == null) {
            return;
        }
        final Context applicationContext = context.getApplicationContext();
        Cb.pFF(new com.bytedance.sdk.component.Qj.Qj("DeviceUtils_get_low_power_mode") { // from class: com.bytedance.sdk.openadsdk.utils.DeviceUtils.2
            @Override // java.lang.Runnable
            public void run() {
                int unused = DeviceUtils.Ql = DeviceUtils.YIK(applicationContext);
            }
        });
    }

    public static int TRI() {
        AccessibilityManager accessibilityManager = (AccessibilityManager) com.bytedance.sdk.openadsdk.core.Xc.sc().getSystemService("accessibility");
        if (accessibilityManager == null) {
            return -1;
        }
        return accessibilityManager.isEnabled() ? 1 : 0;
    }

    public static int TRI(Context context) {
        if (context == null) {
            return -1;
        }
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", -1);
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.Tf.sc("TTAD.DeviceUtils", th2.getMessage());
            return -1;
        }
    }

    public static void UFX() {
        try {
            int ringerMode = ((AudioManager) com.bytedance.sdk.openadsdk.core.Xc.sc().getSystemService(MimeTypes.BASE_TYPE_AUDIO)).getRingerMode();
            if (ringerMode == 2) {
                Qj = 1;
            } else if (ringerMode == 1) {
                Qj = 2;
            } else {
                Qj = 0;
            }
        } catch (Throwable unused) {
        }
    }

    public static void UFX(Context context) {
        Context applicationContext;
        if (ExN || context == null || (applicationContext = context.getApplicationContext()) == null) {
            return;
        }
        try {
            if (Build.MANUFACTURER.equalsIgnoreCase("XIAOMI")) {
                uEA(applicationContext);
            } else {
                sc.pFF(applicationContext);
            }
            ExN = true;
        } catch (Throwable unused) {
        }
    }

    @JProtect
    public static void WH() {
        Cb.sc((com.bytedance.sdk.component.Qj.Qj) new zY());
        com.bytedance.sdk.openadsdk.core.settings.dE.sc(new com.bytedance.sdk.openadsdk.core.settings.BT.sc() { // from class: com.bytedance.sdk.openadsdk.utils.DeviceUtils.1
            @Override // com.bytedance.sdk.openadsdk.core.settings.BT.sc
            public void pFF() {
                Cb.sc((com.bytedance.sdk.component.Qj.Qj) new zY());
            }

            @Override // com.bytedance.sdk.openadsdk.core.settings.BT.sc
            public void sc() {
                Cb.sc((com.bytedance.sdk.component.Qj.Qj) new zY());
            }
        });
        Context contextSc = com.bytedance.sdk.openadsdk.core.Xc.sc();
        if (contextSc != null) {
            com.bytedance.sdk.openadsdk.core.zY.sc(contextSc).sc("cpu_count", Qj.sc());
            com.bytedance.sdk.openadsdk.core.zY.sc(contextSc).sc("cpu_max_frequency", Qj.sc(Qj.sc()));
            com.bytedance.sdk.openadsdk.core.zY.sc(contextSc).sc("cpu_min_frequency", Qj.pFF(Qj.sc()));
            String strOl = cJ.Ol();
            if (strOl != null) {
                com.bytedance.sdk.openadsdk.core.zY.sc(contextSc).sc("total_memory", strOl);
            }
            com.bytedance.sdk.openadsdk.core.zY.sc(contextSc).sc("total_internal_storage", cJ.WH());
            com.bytedance.sdk.openadsdk.core.zY.sc(contextSc).sc("free_internal_storage", com.bytedance.sdk.component.utils.Ql.sc());
            com.bytedance.sdk.openadsdk.core.zY.sc(contextSc).sc("total_sdcard_storage", cJ.UFX());
            com.bytedance.sdk.openadsdk.core.zY.sc(contextSc).sc("is_root", cJ.Tf() ? 1 : 0);
            if (TextUtils.isEmpty(Ol(contextSc))) {
                try {
                    Class.forName("com.unity3d.player.UnityPlayer");
                    f28722sc = "unity";
                } catch (ClassNotFoundException unused) {
                    f28722sc = "native";
                }
                com.bytedance.sdk.openadsdk.core.zY.sc(contextSc).sc("framework_name", f28722sc);
            }
            UFX();
            wjp(contextSc);
            Ql = YIK(contextSc);
            TRI.sc(contextSc);
        }
    }

    public static void WH(Context context) {
        AudioInfoReceiver.pFF(context);
    }

    public static int We(Context context) {
        if (zY(context)) {
            return 3;
        }
        return pFF(context) ? 2 : 1;
    }

    public static String We() {
        String languageTag = Locale.getDefault().toLanguageTag();
        return !TextUtils.isEmpty(languageTag) ? languageTag : "";
    }

    private static int Xc(Context context) {
        return Ql;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int YIK(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            String str = Build.MANUFACTURER;
            if (!str.equalsIgnoreCase("XIAOMI") && !str.equalsIgnoreCase("HUAWEI")) {
                return ((PowerManager) context.getSystemService("power")).isPowerSaveMode() ? 1 : 0;
            }
            return Dl(context);
        } catch (Throwable unused) {
            return 0;
        }
    }

    private static float dE(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void pFF(AdvertisingIdClient.Info info, boolean z11) {
        if (z11 || !com.bytedance.sdk.openadsdk.core.Xc.We().McK("gaid")) {
            return;
        }
        String id2 = info.getId();
        String strPFF = com.bytedance.sdk.openadsdk.wjp.sc.pFF.sc.sc().pFF();
        if (!TextUtils.isEmpty(id2)) {
            com.bytedance.sdk.openadsdk.wjp.sc.pFF.sc.sc().sc(id2);
            com.bytedance.sdk.openadsdk.core.Ol.zY.sc(id2);
        }
        if (strPFF.equals(id2)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.Tf.sc();
    }

    private static void pFF(JSONObject jSONObject) throws JSONException {
        jSONObject.put("model", Build.MODEL);
        if (com.bytedance.sdk.openadsdk.core.Xc.We().McK("gaid")) {
            jSONObject.put("gaid", com.bytedance.sdk.openadsdk.wjp.sc.pFF.sc.sc().pFF());
        }
    }

    @JProtect
    public static boolean pFF() {
        if (SystemClock.elapsedRealtime() - f28721qr >= DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT) {
            f28721qr = SystemClock.elapsedRealtime();
            try {
                PowerManager powerManager = (PowerManager) com.bytedance.sdk.openadsdk.core.Xc.sc().getSystemService("power");
                if (powerManager != null) {
                    TRI = powerManager.isInteractive();
                }
            } catch (Throwable th2) {
                com.bytedance.sdk.component.utils.Tf.sc("TTAD.DeviceUtils", th2.getMessage());
            }
        }
        return TRI;
    }

    public static boolean pFF(Context context) {
        try {
            return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int qr() {
        return WH;
    }

    public static int qr(Context context) {
        try {
            return Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0 ? 1 : 0;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static long sc() {
        return pFF;
    }

    @JProtect
    public static JSONObject sc(Context context, boolean z11) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sys_adb_status", TRI(context));
            sc(jSONObject);
            jSONObject.put("type", We(context));
            jSONObject.put("os", 1);
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("conn_type", cJ.Tf(context));
            jSONObject.put("app_set_id", com.bytedance.sdk.openadsdk.core.settings.We.zY());
            jSONObject.put("app_set_id_scope", com.bytedance.sdk.openadsdk.core.settings.We.pFF());
            jSONObject.put("installed_source", com.bytedance.sdk.openadsdk.core.settings.We.We());
            jSONObject.put("screen_width", kX.zY(context));
            jSONObject.put("screen_height", kX.We(context));
            jSONObject.put("sec_did", com.bytedance.sdk.openadsdk.core.Ol.zY.TRI());
            com.bytedance.sdk.openadsdk.core.settings.TRI triWe = com.bytedance.sdk.openadsdk.core.Xc.We();
            if (triWe.McK("boot")) {
                jSONObject.put("boot", String.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()));
                jSONObject.put("power_on_time", String.valueOf(SystemClock.elapsedRealtime()));
            }
            jSONObject.put("uuid", com.bytedance.sdk.openadsdk.core.Tf.zY(context));
            jSONObject.put("rom_version", WP.sc());
            jSONObject.put("sys_compiling_time", com.bytedance.sdk.openadsdk.core.Tf.pFF(context));
            jSONObject.put("timezone", cJ.wjp());
            jSONObject.put("language", com.bytedance.sdk.openadsdk.core.Tf.pFF());
            jSONObject.put("carrier_name", II.sc());
            jSONObject.put("total_mem", String.valueOf(Long.parseLong(z11 ? cJ.sc(context) : cJ.pFF(context)) * 1024));
            jSONObject.put("locale_language", We());
            jSONObject.put("screen_bright", Math.ceil(ExN() * 10.0f) / 10.0d);
            jSONObject.put("is_screen_off", 1 ^ (pFF() ? 1 : 0));
            jSONObject.put("cpu_num", Qj.sc(context));
            jSONObject.put("cpu_max_freq", Qj.pFF(context));
            jSONObject.put("cpu_min_freq", Qj.zY(context));
            ExN.sc scVarSc = ExN.sc();
            jSONObject.put("battery_remaining_pct", (int) scVarSc.pFF);
            jSONObject.put("is_charging", scVarSc.f28729sc);
            jSONObject.put("total_space", String.valueOf(cJ.zY(context)));
            jSONObject.put("free_space_in", String.valueOf(cJ.We(context)));
            jSONObject.put("sdcard_size", String.valueOf(cJ.ExN(context)));
            jSONObject.put("rooted", cJ.TRI(context));
            jSONObject.put("enable_assisted_clicking", TRI());
            jSONObject.put("force_language", com.bytedance.sdk.component.utils.Sfl.sc(context, "tt_choose_language"));
            jSONObject.put("airplane", qr(context));
            jSONObject.put("darkmode", SR(context));
            jSONObject.put("headset", BT(context));
            jSONObject.put("ringmute", Qj(context));
            jSONObject.put("screenscale", dE(context));
            jSONObject.put("volume", Qj());
            jSONObject.put("low_power_mode", Xc(context));
            if (z11) {
                TRI.sc(jSONObject, context);
            }
            if (triWe.McK("mnc")) {
                jSONObject.put("mnc", II.zY());
            }
            if (triWe.McK("mcc")) {
                jSONObject.put("mcc", II.pFF());
            }
            jSONObject.put("act", com.bytedance.sdk.openadsdk.core.act.sc.pFF(context));
            jSONObject.put("act_event", com.bytedance.sdk.openadsdk.core.act.sc.sc());
            String strZY = com.bytedance.sdk.openadsdk.core.Ol.zY.zY();
            com.bytedance.sdk.openadsdk.core.Ol.zY.We();
            if (!TextUtils.isEmpty(strZY)) {
                jSONObject.put("sof_chara", strZY);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static void sc(Context context) {
        if (zY) {
            return;
        }
        try {
            pFF pff = new pFF();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            context.getApplicationContext().registerReceiver(pff, intentFilter);
            zY = true;
        } catch (Throwable unused) {
        }
    }

    private static void sc(JSONObject jSONObject) throws JSONException {
        pFF(jSONObject);
    }

    private static void uEA(Context context) {
        final Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            return;
        }
        context.getContentResolver().registerContentObserver(Uri.parse("content://settings/system/POWER_SAVE_MODE_OPEN"), false, new ContentObserver(null) { // from class: com.bytedance.sdk.openadsdk.utils.DeviceUtils.3
            @Override // android.database.ContentObserver
            public void onChange(boolean z11) {
                super.onChange(z11);
                DeviceUtils.Sfl(applicationContext);
            }
        });
    }

    private static void wjp(Context context) {
        try {
            AudioManager audioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
            Ol = audioManager.getStreamMaxVolume(3);
            int streamVolume = audioManager.getStreamVolume(3);
            WH = streamVolume;
            UFX = (int) ((((double) streamVolume) / ((double) Ol)) * 100.0d);
        } catch (Throwable unused) {
        }
    }

    public static int zY() {
        return com.bytedance.sdk.openadsdk.core.zY.sc(com.bytedance.sdk.openadsdk.core.Xc.sc()).pFF("limit_ad_track", -1);
    }

    public static boolean zY(Context context) {
        try {
            return (context.getResources().getConfiguration().uiMode & 15) == 4;
        } catch (Throwable unused) {
            return false;
        }
    }
}
