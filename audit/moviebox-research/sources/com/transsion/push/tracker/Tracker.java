package com.transsion.push.tracker;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.entity.b;
import com.transsion.api.gateway.utils.SafeStringUtils;
import com.transsion.core.utils.a;
import com.transsion.push.PushConstants;
import com.transsion.push.config.PushRepository;
import d.x;
import java.util.HashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public final class Tracker {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Tracker f57020c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static HashMap<String, Integer> f57021d = new HashMap<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static HashMap<String, Integer> f57022e = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f57023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f57024b;

    /* JADX INFO: compiled from: source.java */
    public enum KEY {
        ATHENA_TID_FOR_APP_INIT(10410001, "init"),
        ATHENA_TID_FOR_APP_TOKEN(10410002, "token"),
        ATHENA_TID_FOR_APP_TRIG(10410003, "trig"),
        ATHENA_TID_FOR_APP_REPORT(10410004, "report"),
        ATHENA_TID_FOR_APP_CFG(10410005, "cfg"),
        ATHENA_TID_FOR_APP_MSG(10410006, NotificationCompat.CATEGORY_MESSAGE),
        ATHENA_TID_FOR_APP_TARGET(10410007, PushConstants.PUSH_SERVICE_TYPE_ARRIVE),
        ATHENA_TID_FOR_APP_SHOW(10410008, PushConstants.PUSH_SERVICE_TYPE_SHOW),
        ATHENA_TID_FOR_APP_CLICK(10410009, "click"),
        ATHENA_TID_FOR_APP_IMG_DOWNLOAD(10410010, "img"),
        ATHENA_TID_FOR_APP_TRACE(10410011, "trace"),
        ATHENA_TID_FOR_APP_UNINSTALL(10410012, "uninstall"),
        ATHENA_TID_FOR_APP_CONVERSION(10410013, PushConstants.PUSH_SERVICE_TYPE_CONVERSION),
        ATHENA_TID_FOR_APP_INSTALL(10410014, "install");

        public String event;
        public int tid;

        KEY(int i11, String str) {
            this.event = str;
            this.tid = i11;
        }
    }

    public Tracker() {
        try {
            this.f57023a = a.a();
            this.f57024b = a.c();
        } catch (Exception unused) {
        }
        f57021d.put("all", 0);
        f57021d.put("success", 1);
        f57021d.put("fail", 2);
        f57022e.put("success", 3);
        f57022e.put("handled", 4);
    }

    public static Tracker getInstance() {
        if (f57020c == null) {
            f57020c = new Tracker();
        }
        return f57020c;
    }

    public final Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString(PushConstants.PROVIDER_FIELD_PKG, this.f57023a);
        bundle.putString("ver", this.f57024b);
        bundle.putString("sdk", "1.8.5.02");
        bundle.putString(SafeStringUtils.SP_APPID, x.d());
        return bundle;
    }

    public void init() {
        AthenaTracker.getInstance().b();
    }

    public void trackClick(long j11) {
        Bundle bundleA = a();
        bundleA.putLong("id", j11);
        AthenaTracker.getInstance().d(KEY.ATHENA_TID_FOR_APP_CLICK, bundleA);
    }

    public void trackConfig(int i11, int i12) {
        Bundle bundleA = a();
        bundleA.putInt("cfgv", i11);
        bundleA.putInt("cfgt", i12);
        AthenaTracker athenaTracker = AthenaTracker.getInstance();
        KEY key = KEY.ATHENA_TID_FOR_APP_CFG;
        athenaTracker.d(key, bundleA);
        FirebaseTracker.getInstance().a(key, bundleA);
    }

    public void trackConversion(long j11) {
        Bundle bundleA = a();
        bundleA.putLong("id", j11);
        AthenaTracker athenaTracker = AthenaTracker.getInstance();
        KEY key = KEY.ATHENA_TID_FOR_APP_CONVERSION;
        athenaTracker.d(key, bundleA);
        FirebaseTracker.getInstance().a(key, bundleA);
    }

    public void trackImg(String str, int i11) {
        Bundle bundleA = a();
        bundleA.putString("url", str);
        bundleA.putInt("result", i11);
        AthenaTracker athenaTracker = AthenaTracker.getInstance();
        KEY key = KEY.ATHENA_TID_FOR_APP_IMG_DOWNLOAD;
        athenaTracker.d(key, bundleA);
        FirebaseTracker.getInstance().a(key, bundleA);
    }

    public void trackInit() {
        if (((Boolean) PushRepository.getInstance().getSpValue("init", Boolean.FALSE)).booleanValue()) {
            return;
        }
        Bundle bundleA = a();
        AthenaTracker athenaTracker = AthenaTracker.getInstance();
        KEY key = KEY.ATHENA_TID_FOR_APP_INIT;
        athenaTracker.d(key, bundleA);
        FirebaseTracker.getInstance().a(key, bundleA);
        PushRepository.getInstance().putSpValue("init", Boolean.TRUE);
    }

    public void trackInstall() {
        if (((Boolean) PushRepository.getInstance().getSpValue(PushConstants.SP_KEY_TRACK_INSTALL, Boolean.FALSE)).booleanValue()) {
            return;
        }
        PushRepository.getInstance().putSpValue(PushConstants.SP_KEY_TRACK_INSTALL, Boolean.TRUE);
        PushTracker.getInstance().i(KEY.ATHENA_TID_FOR_APP_INSTALL, null);
    }

    public void trackMessage(long j11, int i11, String str, String str2, int i12) {
        Bundle bundleA = a();
        bundleA.putLong("id", j11);
        bundleA.putLong("type", i11);
        bundleA.putLong(b.JSON_KEY_DO, i12);
        bundleA.putString("pts", str);
        bundleA.putString("result", str2);
        AthenaTracker athenaTracker = AthenaTracker.getInstance();
        KEY key = KEY.ATHENA_TID_FOR_APP_MSG;
        athenaTracker.d(key, bundleA);
        FirebaseTracker.getInstance().a(key, bundleA);
    }

    public void trackReport() {
        Bundle bundleA = a();
        bundleA.putString(PushConstants.PROVIDER_FIELD_PKG, this.f57023a);
        bundleA.putString("ver", this.f57024b);
        bundleA.putString("sdk", "1.8.5.02");
        AthenaTracker athenaTracker = AthenaTracker.getInstance();
        KEY key = KEY.ATHENA_TID_FOR_APP_REPORT;
        athenaTracker.d(key, bundleA);
        FirebaseTracker.getInstance().a(key, bundleA);
        try {
            PushTracker.getInstance().i(key, null);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void trackShow(long j11, int i11, String str, boolean z11, int i12) {
        Bundle bundleA = a();
        bundleA.putLong("id", j11);
        bundleA.putInt("type", i11);
        bundleA.putBoolean("able", z11);
        bundleA.putString("pts", str);
        bundleA.putInt(NotificationCompat.CATEGORY_STATUS, i12);
        AthenaTracker.getInstance().d(KEY.ATHENA_TID_FOR_APP_SHOW, bundleA);
    }

    public void trackTarget(long j11, int i11, String str, String str2, String str3) {
        Bundle bundleA = a();
        bundleA.putLong("id", j11);
        bundleA.putLong("type", i11);
        bundleA.putString("pts", str);
        bundleA.putString("rpkg", str2);
        bundleA.putString("result", str3);
        AthenaTracker athenaTracker = AthenaTracker.getInstance();
        KEY key = KEY.ATHENA_TID_FOR_APP_TARGET;
        athenaTracker.d(key, bundleA);
        FirebaseTracker.getInstance().a(key, bundleA);
    }

    public void trackToken(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        } else if (str.length() > 8) {
            str = str.substring(0, 8);
        }
        Bundle bundleA = a();
        bundleA.putString("token", str);
        AthenaTracker athenaTracker = AthenaTracker.getInstance();
        KEY key = KEY.ATHENA_TID_FOR_APP_TOKEN;
        athenaTracker.d(key, bundleA);
        FirebaseTracker.getInstance().a(key, bundleA);
    }

    public void trackTrace(int i11, String str) {
        Bundle bundleA = a();
        bundleA.putInt("type", i11);
        bundleA.putInt("osV", Build.VERSION.SDK_INT);
        bundleA.putString("data", str);
        AthenaTracker athenaTracker = AthenaTracker.getInstance();
        KEY key = KEY.ATHENA_TID_FOR_APP_TRACE;
        athenaTracker.d(key, bundleA);
        FirebaseTracker.getInstance().a(key, bundleA);
    }

    public void trackTrigger(int i11) {
        Bundle bundleA = a();
        bundleA.putInt("reason", i11);
        AthenaTracker athenaTracker = AthenaTracker.getInstance();
        KEY key = KEY.ATHENA_TID_FOR_APP_TRIG;
        athenaTracker.d(key, bundleA);
        FirebaseTracker.getInstance().a(key, bundleA);
    }

    public void trackUninstall(long j11, String str) {
        Bundle bundleA = a();
        bundleA.putLong("id", j11);
        bundleA.putString("tpkg", str);
        AthenaTracker athenaTracker = AthenaTracker.getInstance();
        KEY key = KEY.ATHENA_TID_FOR_APP_UNINSTALL;
        athenaTracker.d(key, bundleA);
        FirebaseTracker.getInstance().a(key, bundleA);
    }

    public void tracks() {
        PushTracker.getInstance().tracks();
    }
}
