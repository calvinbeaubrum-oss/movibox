package com.applovin.impl.sdk;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.hardware.SensorManager;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Environment;
import android.os.LocaleList;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.v4.media.session.PlaybackStateCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import androidx.core.app.NotificationCompat;
import com.applovin.impl.a4;
import com.applovin.impl.ca;
import com.applovin.impl.d4;
import com.applovin.impl.da;
import com.applovin.impl.e4;
import com.applovin.impl.em;
import com.applovin.impl.gc;
import com.applovin.impl.jn;
import com.applovin.impl.sdk.array.ArrayService;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sj;
import com.applovin.impl.sr;
import com.applovin.impl.tm;
import com.applovin.impl.uj;
import com.applovin.impl.vi;
import com.applovin.impl.wh;
import com.applovin.impl.wp;
import com.applovin.impl.yl;
import com.applovin.impl.yp;
import com.applovin.impl.z3;
import com.applovin.sdk.AppLovinBidTokenCollectionListener;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.File;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class k {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final AtomicReference f22625i = new AtomicReference();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final AtomicReference f22626j = new AtomicReference();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f22627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n f22628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f22629c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f22630d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map f22632f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f22633g;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f22631e = new Object();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AtomicReference f22634h = new AtomicReference();

    /* JADX INFO: compiled from: source.java */
    public class a implements em.a {
        public a() {
        }

        @Override // com.applovin.impl.em.a
        public void a(com.applovin.impl.l0.a aVar) {
            k.f22625i.set(aVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f22636a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f22637b;

        public b(String str, int i11) {
            this.f22636a = str;
            this.f22637b = i11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f22638a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f22639b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Boolean f22640c = null;
    }

    public k(j jVar) {
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f22627a = jVar;
        this.f22628b = jVar.J();
        this.f22629c = j.l();
        this.f22630d = y();
        this.f22632f = x();
    }

    private Map E() {
        return yp.a(a(null, true, false));
    }

    private JSONArray H() {
        if (z3.f()) {
            return CollectionUtils.toJSONArray(Build.SUPPORTED_ABIS);
        }
        JSONArray jSONArray = new JSONArray();
        JsonUtils.putStringIfValid(jSONArray, Build.CPU_ABI);
        JsonUtils.putStringIfValid(jSONArray, Build.CPU_ABI2);
        return jSONArray;
    }

    private boolean I() {
        try {
            return b() || c();
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean J() {
        ConnectivityManager connectivityManager;
        if (z3.h() && (connectivityManager = (ConnectivityManager) this.f22629c.getSystemService("connectivity")) != null) {
            try {
                return connectivityManager.getRestrictBackgroundStatus() == 3;
            } catch (Throwable th2) {
                this.f22627a.J();
                if (n.a()) {
                    this.f22627a.J().a("DataCollector", "Unable to collect constrained network info.", th2);
                }
            }
        }
        return false;
    }

    private Boolean K() {
        if (z3.i()) {
            return Boolean.valueOf(this.f22629c.getResources().getConfiguration().isScreenHdr());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M() {
        this.f22634h.set(n());
    }

    private Map a(Map map, boolean z11) {
        com.applovin.impl.l0.a aVarF;
        PowerManager powerManager;
        Map map2 = CollectionUtils.map(map);
        Point pointB = z3.b(this.f22629c);
        map2.put("dx", Integer.valueOf(pointB.x));
        map2.put("dy", Integer.valueOf(pointB.y));
        if (z11) {
            aVarF = (com.applovin.impl.l0.a) f22625i.get();
            if (aVarF != null) {
                N();
            } else if (yp.h()) {
                aVarF = new com.applovin.impl.l0.a();
                map2.put("inc", Boolean.TRUE);
            } else {
                aVarF = f();
            }
        } else {
            aVarF = f();
        }
        String strA = aVarF.a();
        if (StringUtils.isValidString(strA)) {
            map2.put("idfa", strA);
        }
        map2.put("dnt", Boolean.valueOf(aVarF.c()));
        map2.put("dnt_code", aVarF.b().b());
        b bVar = (b) f22626j.get();
        if (((Boolean) this.f22627a.a(sj.J3)).booleanValue() && bVar != null) {
            map2.put("idfv", bVar.f22636a);
            map2.put("idfv_scope", Integer.valueOf(bVar.f22637b));
        }
        Boolean boolB = a4.b().b(this.f22629c);
        if (boolB != null) {
            map2.put("huc", boolB);
        }
        Boolean boolB2 = a4.c().b(this.f22629c);
        if (boolB2 != null) {
            map2.put("aru", boolB2);
        }
        Boolean boolB3 = a4.a().b(this.f22629c);
        if (boolB3 != null) {
            map2.put("dns", boolB3);
        }
        if (((Boolean) this.f22627a.a(sj.W3)).booleanValue()) {
            c cVarH = h();
            CollectionUtils.putIntegerIfValid("act", Integer.valueOf(cVarH.f22638a), map2);
            CollectionUtils.putIntegerIfValid("acm", Integer.valueOf(cVarH.f22639b), map2);
            CollectionUtils.putBooleanIfValid("sowpie", cVarH.f22640c, map2);
        }
        if (((Boolean) this.f22627a.a(sj.f22945e4)).booleanValue()) {
            map2.put("mtl", Integer.valueOf(this.f22627a.f0().getLastTrimMemoryLevel()));
        }
        if (((Boolean) this.f22627a.a(sj.f22969h4)).booleanValue()) {
            map2.put("adr", Boolean.valueOf(I()));
        }
        Integer numN = z11 ? (Integer) this.f22634h.get() : n();
        if (numN != null) {
            map2.put("volume", numN);
        }
        CollectionUtils.putBooleanIfValid("ma", r(), map2);
        CollectionUtils.putBooleanIfValid("spo", s(), map2);
        CollectionUtils.putBooleanIfValid("aif", Boolean.valueOf(!this.f22627a.f0().isApplicationPaused()), map2);
        CollectionUtils.putLongIfValid("af_ts_ms", Long.valueOf(this.f22627a.f0().getAppEnteredForegroundTimeMillis()), map2);
        CollectionUtils.putLongIfValid("ab_ts_ms", Long.valueOf(this.f22627a.f0().getAppEnteredBackgroundTimeMillis()), map2);
        try {
            map2.put("sb", Integer.valueOf((int) ((Settings.System.getInt(this.f22629c.getContentResolver(), "screen_brightness") / 255.0f) * 100.0f)));
        } catch (Settings.SettingNotFoundException e11) {
            if (n.a()) {
                this.f22628b.a("DataCollector", "Unable to collect screen brightness", e11);
            }
        }
        if (((Boolean) this.f22627a.a(sj.f22993k4)).booleanValue() && yp.d(this.f22627a)) {
            sr.a(this.f22627a);
            String strA2 = sr.a();
            if (StringUtils.isValidString(strA2)) {
                map2.put("ua", strA2);
            }
        }
        if (((Boolean) this.f22627a.a(sj.f23097x4)).booleanValue()) {
            sr.b(this.f22627a);
            CollectionUtils.putIntegerIfValid("wvvc", Integer.valueOf(sr.d()), map2);
            CollectionUtils.putStringIfValid("wvv", sr.c(), map2);
            CollectionUtils.putStringIfValid("wvpn", sr.b(), map2);
        }
        if (((Boolean) this.f22627a.a(sj.Y3)).booleanValue()) {
            try {
                map2.put("fs", Long.valueOf(Environment.getDataDirectory().getFreeSpace()));
                map2.put("tds", Long.valueOf(Environment.getDataDirectory().getTotalSpace()));
            } catch (Throwable th2) {
                map2.put("fs", -1);
                map2.put("tds", -1);
                if (n.a()) {
                    this.f22628b.a("DataCollector", "Unable to collect total & free space.", th2);
                }
            }
        }
        if (((Boolean) this.f22627a.a(sj.Z3)).booleanValue()) {
            ActivityManager.MemoryInfo memoryInfoA = yp.a((ActivityManager) this.f22629c.getSystemService("activity"));
            if (memoryInfoA != null) {
                map2.put("fm", Long.valueOf(memoryInfoA.availMem));
                map2.put("tm", Long.valueOf(memoryInfoA.totalMem));
                map2.put("lmt", Long.valueOf(memoryInfoA.threshold));
                map2.put("lm", Boolean.valueOf(memoryInfoA.lowMemory));
            } else {
                map2.put("fm", -1);
                map2.put("tm", -1);
                map2.put("lmt", -1);
            }
        }
        if (((Boolean) this.f22627a.a(sj.f22915a4)).booleanValue() && z3.a("android.permission.READ_PHONE_STATE", this.f22629c) && z3.h()) {
            map2.put("rat", Integer.valueOf(((TelephonyManager) this.f22629c.getSystemService("phone")).getDataNetworkType()));
        }
        if (((Boolean) this.f22627a.a(sj.X3)).booleanValue()) {
            String strW = w();
            if (!TextUtils.isEmpty(strW)) {
                map2.put("so", strW);
            }
        }
        map2.put("orientation_lock", g());
        if (((Boolean) this.f22627a.a(sj.f22922b4)).booleanValue()) {
            map2.put("vs", Boolean.valueOf(yp.j()));
        }
        if (z3.f() && (powerManager = (PowerManager) this.f22629c.getSystemService("power")) != null) {
            map2.put("lpm", Integer.valueOf(powerManager.isPowerSaveMode() ? 1 : 0));
        }
        if (((Boolean) this.f22627a.a(sj.f23001l4)).booleanValue() && this.f22627a.e0() != null) {
            map2.put("da", Float.valueOf(this.f22627a.e0().a()));
        }
        if (((Boolean) this.f22627a.a(sj.f23009m4)).booleanValue() && this.f22627a.e0() != null) {
            map2.put("dm", Float.valueOf(this.f22627a.e0().b()));
        }
        map2.put("mute_switch", Integer.valueOf(this.f22627a.n().a()));
        map2.put("network", e4.g(this.f22627a));
        String strM = m();
        if (StringUtils.isValidString(strM)) {
            map2.put("kb", strM);
        }
        ArrayService arrayServiceM = this.f22627a.m();
        if (arrayServiceM.isAppHubInstalled()) {
            if (arrayServiceM.getIsDirectDownloadEnabled() != null) {
                map2.put("ah_dd_enabled", arrayServiceM.getIsDirectDownloadEnabled());
            }
            map2.put("ah_sdk_version_code", Long.valueOf(arrayServiceM.getAppHubVersionCode()));
            map2.put("ah_random_user_token", StringUtils.emptyIfNull(arrayServiceM.getRandomUserToken()));
            map2.put("ah_sdk_package_name", StringUtils.emptyIfNull(arrayServiceM.getAppHubPackageName()));
        }
        return map2;
    }

    public static void a(com.applovin.impl.l0.a aVar) {
        f22625i.set(aVar);
    }

    public static void a(b bVar) {
        f22626j.set(bVar);
    }

    private void a(Map map) {
        if (((Boolean) this.f22627a.a(sj.f22930c4)).booleanValue() && !map.containsKey("af")) {
            map.put("af", Long.valueOf(d()));
        }
        if (((Boolean) this.f22627a.a(sj.f22938d4)).booleanValue() && !map.containsKey("font")) {
            map.put("font", Float.valueOf(o()));
        }
        if (((Boolean) this.f22627a.a(sj.f22993k4)).booleanValue() && yp.d(this.f22627a)) {
            sr.a(this.f22627a);
        }
        if (((Boolean) this.f22627a.a(sj.f23097x4)).booleanValue()) {
            sr.b(this.f22627a);
        }
        if (((Boolean) this.f22627a.a(sj.f22985j4)).booleanValue() && !map.containsKey("sua")) {
            map.put("sua", System.getProperty("http.agent"));
        }
        if (((Boolean) this.f22627a.a(sj.f22953f4)).booleanValue() && !map.containsKey("network_restricted")) {
            map.put("network_restricted", Boolean.valueOf(J()));
        }
        if (((Boolean) this.f22627a.a(sj.f23017n4)).booleanValue()) {
            boolean z11 = false;
            boolean z12 = this.f22629c.getResources().getConfiguration().keyboard == 2;
            boolean zHasSystemFeature = this.f22629c.getPackageManager().hasSystemFeature("com.google.android.play.feature.HPE_EXPERIENCE");
            boolean zHasSystemFeature2 = this.f22629c.getPackageManager().hasSystemFeature("android.hardware.type.pc");
            if (z12 && (zHasSystemFeature || zHasSystemFeature2)) {
                z11 = true;
            }
            map.put("is_pc", Boolean.valueOf(z11));
        }
        if (((Boolean) this.f22627a.a(sj.f23113z4)).booleanValue()) {
            CollectionUtils.putStringIfValid("oglv", D(), map);
        }
    }

    private boolean a(String str) {
        return b(str) == 1;
    }

    private int b(String str) {
        try {
            return Settings.Secure.getInt(this.f22629c.getContentResolver(), str);
        } catch (Throwable unused) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(AppLovinBidTokenCollectionListener appLovinBidTokenCollectionListener) {
        try {
            String strC = C();
            if (StringUtils.isValidString(strC)) {
                this.f22627a.J();
                if (n.a()) {
                    this.f22627a.J().a("DataCollector", "Successfully retrieved bid token");
                }
                gc.a(appLovinBidTokenCollectionListener, strC);
                return;
            }
            this.f22627a.J();
            if (n.a()) {
                this.f22627a.J().b("DataCollector", "Empty bid token");
            }
            gc.b(appLovinBidTokenCollectionListener, "Empty bid token");
        } catch (Throwable th2) {
            if (n.a()) {
                this.f22628b.a("DataCollector", "Failed to collect bid token", th2);
            }
            this.f22627a.E().a("DataCollector", "collectBidToken", th2);
            gc.b(appLovinBidTokenCollectionListener, "Failed to collect bid token");
        }
    }

    private boolean b() {
        String str = Build.TAGS;
        return str != null && str.contains(c("lz}$blpz"));
    }

    private String c(String str) {
        int length = str.length();
        int[] iArr = {11, 12, 10, 3, 2, 1, 15, 10, 15, 14};
        char[] cArr = new char[length];
        for (int i11 = 0; i11 < length; i11++) {
            cArr[i11] = str.charAt(i11);
            for (int i12 = 9; i12 >= 0; i12--) {
                cArr[i11] = (char) (cArr[i11] ^ iArr[i12]);
            }
        }
        return new String(cArr);
    }

    private boolean c() {
        String[] strArr = {"&zpz}ld&hyy&Z|yl{|zl{'hyb", "&zk`g&z|", "&zpz}ld&k`g&z|", "&zpz}ld&qk`g&z|", "&mh}h&efjhe&qk`g&z|", "&mh}h&efjhe&k`g&z|", "&zpz}ld&zm&qk`g&z|", "&zpz}ld&k`g&oh`ezhol&z|", "&mh}h&efjhe&z|"};
        for (int i11 = 0; i11 < 9; i11++) {
            if (new File(c(strArr[i11])).exists()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:106:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:108:0x01b1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:109:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:112:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:114:0x01c8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:115:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:118:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:120:0x01df A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:121:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:123:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:106:0x01aa, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:112:0x01c1, please report this as an issue */
    private long d() {
        long j11;
        int iB;
        int iB2;
        int iB3;
        long j12;
        long j13;
        long j14;
        List listAsList = Arrays.asList(StringUtils.emptyIfNull(Settings.Secure.getString(this.f22629c.getContentResolver(), "enabled_accessibility_services")).split(":"));
        long j15 = listAsList.contains("AccessibilityMenuService") ? 256L : 0L;
        if (listAsList.contains("SelectToSpeakService")) {
            j15 |= 512;
        }
        if (listAsList.contains("SoundAmplifierService")) {
            j15 |= 2;
        }
        if (listAsList.contains("SpeechToTextAccessibilityService")) {
            j15 |= 128;
        }
        if (listAsList.contains("SwitchAccessService")) {
            j15 |= 4;
        }
        if ((this.f22629c.getResources().getConfiguration().uiMode & 48) == 32) {
            j15 |= 1024;
        }
        if (a("accessibility_enabled")) {
            j15 |= 8;
        }
        if (a("touch_exploration_enabled")) {
            j15 |= 16;
        }
        if (z3.f()) {
            if (a("accessibility_display_inversion_enabled")) {
                j15 |= 32;
            }
            if (a("skip_first_use_hints")) {
                j15 |= 64;
            }
        }
        if (a("lock_screen_allow_remote_input")) {
            j15 |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        if (a("enabled_accessibility_audio_description_by_default")) {
            j15 |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        if (a("accessibility_shortcut_on_lock_screen")) {
            j15 |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        }
        if (a("wear_talkback_enabled")) {
            j15 |= 16384;
        }
        if (a("hush_gesture_used")) {
            j15 |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
        }
        if (a("high_text_contrast_enabled")) {
            j15 |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
        }
        if (a("accessibility_display_magnification_enabled")) {
            j15 |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
        }
        if (a("accessibility_display_magnification_navbar_enabled")) {
            j15 |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
        }
        if (a("accessibility_captioning_enabled")) {
            j15 |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
        }
        if (a("accessibility_display_daltonizer_enabled")) {
            j15 |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        }
        if (a("accessibility_autoclick_enabled")) {
            j15 |= 2097152;
        }
        if (a("accessibility_large_pointer_icon")) {
            j15 |= PlaybackStateCompat.ACTION_SET_PLAYBACK_SPEED;
        }
        if (a("reduce_bright_colors_activated")) {
            j15 |= 8388608;
        }
        if (a("reduce_bright_colors_persist_across_reboots")) {
            j15 |= 16777216;
        }
        if (a("tty_mode_enabled")) {
            j15 |= 33554432;
        }
        if (a("rtt_calling_mode")) {
            j15 |= 67108864;
        }
        if (a("accessibility_floating_menu_fade_enabled")) {
            j15 |= 134217728;
        }
        if (a("accessibility_show_window_magnification_prompt")) {
            j15 |= 268435456;
        }
        if (a("accessibility_floating_menu_migration_tooltip_prompt")) {
            j15 |= 536870912;
        }
        int iB4 = b("accessibility_magnification_mode");
        if (iB4 == 0) {
            j11 = 1073741824;
        } else if (iB4 == 1) {
            j11 = 2147483648L;
        } else {
            if (iB4 != 2) {
                if (iB4 == 3) {
                    j11 = 8589934592L;
                }
                iB = b("accessibility_button_mode");
                if (iB == 0) {
                    j14 = iB == 1 ? 34359738368L : 17179869184L;
                    iB2 = b("accessibility_floating_menu_size");
                    if (iB2 == 0) {
                        j13 = iB2 == 1 ? 137438953472L : 68719476736L;
                        iB3 = b("accessibility_floating_menu_icon_type");
                        if (iB3 == 0) {
                            j12 = 274877906944L;
                        } else {
                            if (iB3 == 1) {
                                return j15;
                            }
                            j12 = 549755813888L;
                        }
                        return j15 | j12;
                    }
                    j15 |= j13;
                    iB3 = b("accessibility_floating_menu_icon_type");
                    if (iB3 == 0) {
                        j12 = 274877906944L;
                    } else {
                        if (iB3 == 1) {
                            return j15;
                        }
                        j12 = 549755813888L;
                    }
                    return j15 | j12;
                }
                j15 |= j14;
                iB2 = b("accessibility_floating_menu_size");
                if (iB2 == 0) {
                    if (iB2 == 1) {
                    }
                    iB3 = b("accessibility_floating_menu_icon_type");
                    if (iB3 == 0) {
                        j12 = 274877906944L;
                    } else {
                        if (iB3 == 1) {
                            return j15;
                        }
                        j12 = 549755813888L;
                    }
                    return j15 | j12;
                }
                j15 |= j13;
                iB3 = b("accessibility_floating_menu_icon_type");
                if (iB3 == 0) {
                    j12 = 274877906944L;
                } else {
                    if (iB3 == 1) {
                        return j15;
                    }
                    j12 = 549755813888L;
                }
                return j15 | j12;
            }
            j11 = 4294967296L;
        }
        j15 |= j11;
        iB = b("accessibility_button_mode");
        if (iB == 0) {
            if (iB == 1) {
            }
            iB2 = b("accessibility_floating_menu_size");
            if (iB2 == 0) {
                if (iB2 == 1) {
                }
                iB3 = b("accessibility_floating_menu_icon_type");
                if (iB3 == 0) {
                    j12 = 274877906944L;
                } else {
                    if (iB3 == 1) {
                        return j15;
                    }
                    j12 = 549755813888L;
                }
                return j15 | j12;
            }
            j15 |= j13;
            iB3 = b("accessibility_floating_menu_icon_type");
            if (iB3 == 0) {
                j12 = 274877906944L;
            } else {
                if (iB3 == 1) {
                    return j15;
                }
                j12 = 549755813888L;
            }
            return j15 | j12;
        }
        j15 |= j14;
        iB2 = b("accessibility_floating_menu_size");
        if (iB2 == 0) {
            if (iB2 == 1) {
            }
            iB3 = b("accessibility_floating_menu_icon_type");
            if (iB3 == 0) {
                j12 = 274877906944L;
            } else {
                if (iB3 == 1) {
                    return j15;
                }
                j12 = 549755813888L;
            }
            return j15 | j12;
        }
        j15 |= j13;
        iB3 = b("accessibility_floating_menu_icon_type");
        if (iB3 == 0) {
            j12 = 274877906944L;
        } else {
            if (iB3 == 1) {
                return j15;
            }
            j12 = 549755813888L;
        }
        return j15 | j12;
    }

    private String g() {
        int orientation = AppLovinSdkUtils.getOrientation(this.f22629c);
        if (orientation == 1) {
            return "portrait";
        }
        return orientation == 2 ? "landscape" : DevicePublicKeyStringDef.NONE;
    }

    private c h() {
        c cVar = new c();
        Intent intentRegisterReceiver = this.f22629c.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int intExtra = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("level", -1) : -1;
        int intExtra2 = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("scale", -1) : -1;
        if (intExtra <= 0 || intExtra2 <= 0) {
            cVar.f22639b = -1;
        } else {
            cVar.f22639b = (int) ((intExtra / intExtra2) * 100.0f);
        }
        cVar.f22638a = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1) : -1;
        if (z3.d()) {
            cVar.f22640c = Boolean.valueOf(Settings.Global.getInt(this.f22629c.getContentResolver(), "stay_on_while_plugged_in", -1) > 0);
        } else {
            cVar.f22640c = Boolean.valueOf(((intentRegisterReceiver.getIntExtra("plugged", -1) & 1) | 14) > 0);
        }
        return cVar;
    }

    private String i() {
        TelephonyManager telephonyManager = (TelephonyManager) this.f22629c.getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        try {
            return telephonyManager.getNetworkOperatorName();
        } catch (Throwable th2) {
            if (!n.a()) {
                return "";
            }
            this.f22628b.a("DataCollector", "Unable to collect carrier", th2);
            return "";
        }
    }

    private String k() {
        TelephonyManager telephonyManager = (TelephonyManager) this.f22629c.getSystemService("phone");
        return telephonyManager != null ? telephonyManager.getSimCountryIso().toUpperCase(Locale.ENGLISH) : "";
    }

    private String m() {
        if (!z3.h()) {
            return null;
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            LocaleList locales = this.f22629c.getResources().getConfiguration().getLocales();
            for (int i11 = 0; i11 < locales.size(); i11++) {
                sb2.append(locales.get(i11));
                sb2.append(",");
            }
            if (sb2.length() > 0 && sb2.charAt(sb2.length() - 1) == ',') {
                sb2.deleteCharAt(sb2.length() - 1);
            }
            return sb2.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    private Integer n() {
        AudioManager audioManager = (AudioManager) this.f22629c.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        if (audioManager == null) {
            return null;
        }
        try {
            return Integer.valueOf((int) (audioManager.getStreamVolume(3) * ((Float) this.f22627a.a(sj.f22977i4)).floatValue()));
        } catch (Throwable th2) {
            this.f22627a.J();
            if (n.a()) {
                this.f22627a.J().a("DataCollector", "Unable to collect device volume", th2);
            }
            return null;
        }
    }

    private float o() {
        try {
            return Settings.System.getFloat(this.f22629c.getContentResolver(), "font_scale");
        } catch (Settings.SettingNotFoundException e11) {
            if (!n.a()) {
                return -1.0f;
            }
            this.f22628b.a("DataCollector", "Error collecting font scale", e11);
            return -1.0f;
        }
    }

    private boolean p() {
        SensorManager sensorManager = (SensorManager) this.f22629c.getSystemService("sensor");
        return (sensorManager == null || sensorManager.getDefaultSensor(4) == null) ? false : true;
    }

    private Map q() {
        HashMap map = new HashMap();
        CollectionUtils.putIntegerIfValid("IABTCF_gdprApplies", this.f22627a.k0().g(), map);
        CollectionUtils.putStringIfValid("IABTCF_TCString", this.f22627a.k0().k(), map);
        CollectionUtils.putStringIfValid("IABTCF_AddtlConsent", this.f22627a.k0().c(), map);
        return map;
    }

    private Boolean r() {
        AudioManager audioManager = (AudioManager) this.f22629c.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        if (audioManager == null) {
            return null;
        }
        return Boolean.valueOf(audioManager.isMusicActive());
    }

    private Boolean s() {
        AudioManager audioManager = (AudioManager) this.f22629c.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        if (audioManager == null) {
            return null;
        }
        return Boolean.valueOf(audioManager.isSpeakerphoneOn());
    }

    private String t() {
        TelephonyManager telephonyManager = (TelephonyManager) this.f22629c.getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        try {
            String networkOperator = telephonyManager.getNetworkOperator();
            return networkOperator.substring(0, Math.min(3, networkOperator.length()));
        } catch (Throwable th2) {
            if (!n.a()) {
                return "";
            }
            this.f22628b.a("DataCollector", "Unable to collect mobile country code", th2);
            return "";
        }
    }

    private String u() {
        TelephonyManager telephonyManager = (TelephonyManager) this.f22629c.getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        try {
            String networkOperator = telephonyManager.getNetworkOperator();
            return networkOperator.substring(Math.min(3, networkOperator.length()));
        } catch (Throwable th2) {
            if (!n.a()) {
                return "";
            }
            this.f22628b.a("DataCollector", "Unable to collect mobile network code", th2);
            return "";
        }
    }

    private String w() {
        AudioManager audioManager = (AudioManager) this.f22629c.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        if (audioManager == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        if (z3.g()) {
            for (AudioDeviceInfo audioDeviceInfo : audioManager.getDevices(2)) {
                sb2.append(audioDeviceInfo.getType());
                sb2.append(",");
            }
        } else {
            if (audioManager.isWiredHeadsetOn()) {
                sb2.append(3);
                sb2.append(",");
            }
            if (audioManager.isBluetoothScoOn()) {
                sb2.append(7);
                sb2.append(",");
            }
            if (audioManager.isBluetoothA2dpOn()) {
                sb2.append(8);
            }
        }
        if (sb2.length() > 0 && sb2.charAt(sb2.length() - 1) == ',') {
            sb2.deleteCharAt(sb2.length() - 1);
        }
        String string = sb2.toString();
        if (TextUtils.isEmpty(string) && n.a()) {
            this.f22628b.a("DataCollector", "No sound outputs detected");
        }
        return string;
    }

    private Map x() {
        PackageInfo packageInfo;
        HashMap map = new HashMap();
        PackageManager packageManager = this.f22629c.getPackageManager();
        ApplicationInfo applicationInfo = this.f22629c.getApplicationInfo();
        long jLastModified = new File(applicationInfo.sourceDir).lastModified();
        String installerPackageName = null;
        try {
            packageInfo = packageManager.getPackageInfo(this.f22629c.getPackageName(), 0);
            try {
                installerPackageName = packageManager.getInstallerPackageName(applicationInfo.packageName);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            packageInfo = null;
        }
        map.put("app_name", packageManager.getApplicationLabel(applicationInfo));
        map.put("app_version", packageInfo != null ? packageInfo.versionName : "");
        map.put("app_version_code", Integer.valueOf(packageInfo != null ? packageInfo.versionCode : -1));
        map.put("package_name", applicationInfo.packageName);
        map.put("vz", StringUtils.toShortSHA1Hash(applicationInfo.packageName));
        if (installerPackageName == null) {
            installerPackageName = "";
        }
        map.put("installer_name", installerPackageName);
        map.put("tg", wp.a(this.f22627a));
        map.put("debug", Boolean.valueOf(yp.c(this.f22627a)));
        map.put("ia", Long.valueOf(jLastModified));
        map.put("alts_ms", Long.valueOf(j.k()));
        map.put("j8", Boolean.valueOf(j.y0()));
        map.put("ps_tpg", Boolean.valueOf(wh.d(this.f22629c)));
        map.put("ps_apg", Boolean.valueOf(wh.b(this.f22629c)));
        map.put("ps_capg", Boolean.valueOf(wh.c(this.f22629c)));
        map.put("ps_aipg", Boolean.valueOf(wh.a(this.f22629c)));
        j jVar = this.f22627a;
        uj ujVar = uj.f23589f;
        Long l11 = (Long) jVar.a(ujVar);
        if (l11 != null) {
            map.put("ia_v2", l11);
        } else {
            this.f22627a.b(ujVar, Long.valueOf(jLastModified));
        }
        map.put("sdk_version", AppLovinSdk.VERSION);
        map.put("omid_sdk_version", this.f22627a.W().c());
        CollectionUtils.putStringIfValid("ad_review_sdk_version", com.applovin.impl.v.b(), map);
        map.put("api_did", this.f22627a.a(sj.f22956g));
        map.put("first_install_v3_ms", packageInfo != null ? Long.valueOf(packageInfo.firstInstallTime) : "");
        map.put("target_sdk", Integer.valueOf(applicationInfo.targetSdkVersion));
        if (z3.h()) {
            map.put("min_sdk", Integer.valueOf(applicationInfo.minSdkVersion));
        }
        map.put("epv", Integer.valueOf(yp.f()));
        if (this.f22627a.B0()) {
            map.put("unity_version", yp.a(this.f22627a.g0()));
        }
        return map;
    }

    private Map y() {
        HashMap map = new HashMap(34);
        map.put("api_level", Integer.valueOf(Build.VERSION.SDK_INT));
        map.put("brand", Build.MANUFACTURER);
        map.put("brand_name", Build.BRAND);
        map.put("hardware", Build.HARDWARE);
        map.put("sim", Boolean.valueOf(AppLovinSdkUtils.isEmulator()));
        map.put("aida", Boolean.valueOf(com.applovin.impl.l0.a()));
        map.put("locale", Locale.getDefault().toString());
        map.put("model", Build.MODEL);
        map.put("os", Build.VERSION.RELEASE);
        map.put(TrackingKey.PLATFORM, v());
        map.put("revision", Build.DEVICE);
        map.put("tz_offset", Double.valueOf(z()));
        map.put("gy", Boolean.valueOf(p()));
        map.put("country_code", k());
        map.put("mcc", t());
        map.put("mnc", u());
        map.put("carrier", i());
        map.put("is_tablet", Boolean.valueOf(AppLovinSdkUtils.isTablet(this.f22629c)));
        map.put("tv", Boolean.valueOf(AppLovinSdkUtils.isTv(this.f22629c)));
        map.put("pc", Integer.valueOf(Runtime.getRuntime().availableProcessors()));
        map.put("hdr", K());
        map.put("supported_abis", H());
        DisplayMetrics displayMetrics = this.f22629c.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            map.put("adns", Float.valueOf(displayMetrics.density));
            map.put("adnsd", Integer.valueOf(displayMetrics.densityDpi));
            map.put("xdpi", Float.valueOf(displayMetrics.xdpi));
            map.put("ydpi", Float.valueOf(displayMetrics.ydpi));
            Point pointB = z3.b(this.f22629c);
            map.put("screen_size_in", Double.valueOf(Math.sqrt(Math.pow(pointB.x, 2.0d) + Math.pow(pointB.y, 2.0d)) / ((double) displayMetrics.xdpi)));
            z3.a aVarA = z3.a(this.f22629c, this.f22627a);
            if (aVarA != null) {
                map.put("tl_cr", Integer.valueOf(aVarA.c()));
                map.put("tr_cr", Integer.valueOf(aVarA.d()));
                map.put("bl_cr", Integer.valueOf(aVarA.a()));
                map.put("br_cr", Integer.valueOf(aVarA.b()));
            }
        }
        map.put("bt_ms", Long.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()));
        map.put("tbalsi_ms", Long.valueOf(this.f22627a.I() - j.k()));
        CollectionUtils.putBooleanIfValid("psase", Boolean.valueOf(wh.e(this.f22629c)), map);
        CollectionUtils.putStringIfValid("process_name", yp.b(this.f22629c), map);
        CollectionUtils.putBooleanIfValid("is_main_process", yp.g(this.f22629c), map);
        try {
            PackageInfo packageInfo = this.f22629c.getPackageManager().getPackageInfo("com.android.vending", 0);
            map.put("ps_version", packageInfo.versionName);
            map.put("ps_version_code", Integer.valueOf(packageInfo.versionCode));
        } catch (Throwable unused) {
            map.put("ps_version", "");
            map.put("ps_version_code", -1);
        }
        a(map);
        return map;
    }

    private double z() {
        return Math.round((((double) TimeZone.getDefault().getOffset(new Date().getTime())) * 10.0d) / 3600000.0d) / 10.0d;
    }

    public Map A() {
        Map map = CollectionUtils.map(this.f22632f);
        map.put("first_install", Boolean.valueOf(this.f22627a.v0()));
        map.put("first_install_v2", Boolean.valueOf(!this.f22627a.t0()));
        map.put("test_ads", Boolean.valueOf(this.f22633g));
        map.put("muted", Boolean.valueOf(this.f22627a.g0().isMuted()));
        if (((Boolean) this.f22627a.a(sj.K3)).booleanValue()) {
            CollectionUtils.putStringIfValid("cuid", this.f22627a.q0().c(), map);
        }
        if (((Boolean) this.f22627a.a(sj.N3)).booleanValue()) {
            map.put("compass_random_token", this.f22627a.q());
        }
        if (((Boolean) this.f22627a.a(sj.P3)).booleanValue()) {
            map.put("applovin_random_token", this.f22627a.a0());
        }
        map.putAll(q());
        if (this.f22627a.Z() != null) {
            CollectionUtils.putJsonArrayIfValid("ps_topics", this.f22627a.Z().a(), map);
        }
        return map;
    }

    public b B() {
        return (b) f22626j.get();
    }

    public String C() {
        String strEncodeToString = Base64.encodeToString(new JSONObject(E()).toString().getBytes(Charset.defaultCharset()), 2);
        return ((Boolean) this.f22627a.a(sj.f22986j5)).booleanValue() ? vi.b(strEncodeToString, yp.a(this.f22627a), vi.a.a(((Integer) this.f22627a.a(sj.f22994k5)).intValue()), this.f22627a.b0(), this.f22627a) : strEncodeToString;
    }

    public String D() {
        ActivityManager activityManager = (ActivityManager) this.f22629c.getSystemService("activity");
        if (activityManager == null) {
            return null;
        }
        return activityManager.getDeviceConfigurationInfo().getGlEsVersion();
    }

    public Map F() {
        return CollectionUtils.map(this.f22632f);
    }

    public Map G() {
        return CollectionUtils.map(this.f22630d);
    }

    public boolean L() {
        return this.f22633g;
    }

    public void N() {
        tm tmVarJ0 = this.f22627a.j0();
        em emVar = new em(this.f22627a, new a());
        tm.b bVar = tm.b.OTHER;
        tmVarJ0.a((yl) emVar, bVar);
        this.f22627a.j0().a((yl) new jn(this.f22627a, true, "setDeviceVolume", new Runnable() { // from class: com.applovin.impl.sdk.e1
            @Override // java.lang.Runnable
            public final void run() {
                this.f22517a.M();
            }
        }), bVar);
    }

    public void O() {
        synchronized (this.f22631e) {
            a(this.f22630d);
        }
    }

    public Map a(Map map, boolean z11, boolean z12) {
        HashMap map2 = new HashMap(64);
        Map mapA = a(z11);
        Map mapA2 = A();
        Map mapJ = j();
        Map mapD0 = this.f22627a.d0();
        if (z12) {
            map2.put("device_info", mapA);
            map2.put("app_info", mapA2);
            if (mapJ != null) {
                map2.put("connection_info", mapJ);
            }
            if (map != null) {
                map2.put("ad_info", map);
            }
            if (!CollectionUtils.isEmpty(mapD0)) {
                map2.put("segments", mapD0);
            }
        } else {
            map2.putAll(mapA);
            map2.putAll(mapA2);
            if (mapJ != null) {
                map2.putAll(mapJ);
            }
            if (map != null) {
                map2.putAll(map);
            }
            if (!CollectionUtils.isEmpty(mapD0)) {
                map2.putAll(mapD0);
            }
        }
        map2.put("accept", "custom_size,launch_app,video");
        map2.put("format", "json");
        CollectionUtils.putStringIfValid("mediation_provider", this.f22627a.O(), map2);
        CollectionUtils.putStringIfValid("mediation_provider_v2", this.f22627a.z(), map2);
        CollectionUtils.putStringIfValid("plugin_version", (String) this.f22627a.a(sj.U3), map2);
        CollectionUtils.putLongIfValid("tssf_ms", Long.valueOf(this.f22627a.m0()), map2);
        if (!((Boolean) this.f22627a.a(sj.f22970h5)).booleanValue()) {
            map2.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f22627a.b0());
        }
        map2.putAll(e());
        if (((Boolean) this.f22627a.a(sj.I4)).booleanValue()) {
            da daVarD = this.f22627a.D();
            map2.put("li", Long.valueOf(daVarD.b(ca.f18148e)));
            map2.put("si", Long.valueOf(daVarD.b(ca.f18151h)));
            map2.put("mad", Long.valueOf(daVarD.b(ca.f18149f)));
            map2.put("msad", Long.valueOf(daVarD.b(ca.f18152i)));
            map2.put("pf", Long.valueOf(daVarD.b(ca.f18156m)));
            map2.put("mpf", Long.valueOf(daVarD.b(ca.f18163t)));
            map2.put("gpf", Long.valueOf(daVarD.b(ca.f18157n)));
            map2.put("asoac", Long.valueOf(daVarD.b(ca.f18161r)));
        }
        map2.put("rid", UUID.randomUUID().toString());
        return map2;
    }

    public Map a(boolean z11) {
        Map map;
        synchronized (this.f22631e) {
            map = CollectionUtils.map(this.f22630d);
        }
        return a(map, z11);
    }

    public void a(final AppLovinBidTokenCollectionListener appLovinBidTokenCollectionListener) {
        this.f22627a.j0().a((yl) new jn(this.f22627a, ((Boolean) this.f22627a.a(sj.V3)).booleanValue(), "DataCollector", new Runnable() { // from class: com.applovin.impl.sdk.f1
            @Override // java.lang.Runnable
            public final void run() {
                this.f22527a.b(appLovinBidTokenCollectionListener);
            }
        }), tm.b.CORE);
    }

    public Map e() {
        HashMap map = new HashMap();
        map.put("sc", this.f22627a.a(sj.f23004m));
        map.put("sc2", this.f22627a.a(sj.f23012n));
        map.put("sc3", this.f22627a.a(sj.f23020o));
        map.put("server_installed_at", this.f22627a.a(sj.f23028p));
        CollectionUtils.putStringIfValid("persisted_data", (String) this.f22627a.a(uj.G), map);
        return map;
    }

    public com.applovin.impl.l0.a f() {
        List<String> testDeviceAdvertisingIds;
        com.applovin.impl.l0.a aVarB = com.applovin.impl.l0.b(this.f22629c);
        if (aVarB == null) {
            return new com.applovin.impl.l0.a();
        }
        if (((Boolean) this.f22627a.a(sj.I3)).booleanValue()) {
            if (aVarB.c() && !((Boolean) this.f22627a.a(sj.H3)).booleanValue()) {
                aVarB.a("");
            }
            f22625i.set(aVarB);
        } else {
            aVarB = new com.applovin.impl.l0.a();
        }
        if (this.f22627a.z0().get()) {
            testDeviceAdvertisingIds = this.f22627a.g0().getTestDeviceAdvertisingIds();
        } else {
            testDeviceAdvertisingIds = this.f22627a.H() != null ? this.f22627a.H().getTestDeviceAdvertisingIds() : null;
        }
        if (testDeviceAdvertisingIds != null) {
            String strA = aVarB.a();
            if (StringUtils.isValidString(strA)) {
                this.f22633g = testDeviceAdvertisingIds.contains(strA);
            }
            b bVarB = B();
            String str = bVarB != null ? bVarB.f22636a : null;
            if (StringUtils.isValidString(str)) {
                this.f22633g = testDeviceAdvertisingIds.contains(str) | this.f22633g;
            }
        } else {
            this.f22633g = false;
        }
        return aVarB;
    }

    public Map j() {
        d4.d dVarA = this.f22627a.s().a();
        if (dVarA == null) {
            return null;
        }
        HashMap map = new HashMap(4);
        map.put("lrm_ts_ms", String.valueOf(dVarA.c()));
        map.put("lrm_url", dVarA.d());
        map.put("lrm_ct_ms", String.valueOf(dVarA.a()));
        map.put("lrm_rs", String.valueOf(dVarA.b()));
        return map;
    }

    public Map l() {
        return a(false);
    }

    public String v() {
        return AppLovinSdkUtils.isFireOS(this.f22629c) ? "fireos" : "android";
    }
}
