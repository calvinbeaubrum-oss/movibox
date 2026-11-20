package com.hisavana.mediation.config;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import ca.d;
import com.cloud.hisavana.sdk.manager.NetStateManager;
import com.cloud.sdk.commonutil.util.MitNetUtil;
import com.cloud.sdk.commonutil.util.Preconditions;
import com.cloud.sdk.commonutil.util.f;
import com.cloud.sdk.commonutil.util.i;
import com.cloud.sdk.commonutil.util.n;
import com.hisavana.common.base.LogSwitch;
import com.hisavana.common.bean.AdMuteStatus;
import com.hisavana.common.bean.AppStartInfo;
import com.hisavana.common.constant.ComConstants;
import com.hisavana.common.tracking.TrackingKey;
import com.hisavana.common.tracking.TrackingManager;
import com.hisavana.common.utils.AdLogUtil;
import com.transsion.ga.AthenaAnalytics;
import da.a;
import hn.o;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import w9.y;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public final class TAdManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AdConfig f41910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f41911b;

    /* JADX INFO: compiled from: source.java */
    public static final class AdConfig {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f41912a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f41913b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f41914c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f41915d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f41916e = false;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f41917f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List<String> f41918g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f41919h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f41920i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public OnCloudCompleteListener f41921j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f41922k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f41923l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public long f41924m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f41925n;

        public AdConfig(AdConfigBuilder adConfigBuilder) {
            this.f41912a = false;
            this.f41914c = false;
            this.f41919h = true;
            this.f41922k = false;
            this.f41925n = false;
            this.f41912a = adConfigBuilder.f41928c;
            this.f41913b = adConfigBuilder.f41926a;
            this.f41914c = adConfigBuilder.f41929d;
            this.f41915d = adConfigBuilder.f41940o;
            this.f41917f = adConfigBuilder.f41931f;
            this.f41919h = adConfigBuilder.f41930e;
            this.f41918g = adConfigBuilder.f41932g;
            this.f41920i = adConfigBuilder.f41927b;
            this.f41921j = adConfigBuilder.f41935j;
            this.f41922k = adConfigBuilder.f41936k;
            this.f41923l = adConfigBuilder.f41938m;
            this.f41924m = adConfigBuilder.f41939n;
            this.f41925n = adConfigBuilder.f41941p;
            AppStartInfo.channel = adConfigBuilder.f41933h;
            AppStartInfo.extInfo = adConfigBuilder.f41934i;
            AdMuteStatus.MUTE_ALL = adConfigBuilder.f41937l;
        }

        public int getAppIconId() {
            return this.f41920i;
        }

        public String getAppId() {
            return this.f41913b;
        }

        public List<String> getCodeSeatIds() {
            return this.f41918g;
        }

        public int getDefaultMaterialMaxSize() {
            return this.f41923l;
        }

        public long getDefaultVersion() {
            return this.f41924m;
        }

        public boolean getShouldOptimizeImageLoading() {
            return this.f41925n;
        }

        public boolean isDebug() {
            return this.f41912a;
        }

        public boolean isEnableGDPR() {
            return this.f41915d;
        }

        public boolean isInitAdmob() {
            return this.f41922k;
        }

        public boolean isInitAlliance() {
            return this.f41919h;
        }

        public boolean isLite() {
            return this.f41916e;
        }

        public boolean isTestDevice() {
            return this.f41914c;
        }

        public void releaseCloudListener() {
            this.f41921j = null;
        }

        public void setCodeSeatIds(List<String> list) {
            if (this.f41918g == null) {
                this.f41918g = new ArrayList();
            }
            this.f41918g.clear();
            HashSet hashSet = new HashSet(list);
            list.clear();
            list.addAll(hashSet);
            this.f41918g.addAll(list);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class AdConfigBuilder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f41927b;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f41931f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List<String> f41932g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Map<String, String> f41934i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public OnCloudCompleteListener f41935j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f41936k;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f41938m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public long f41939n;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f41926a = "";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f41928c = false;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f41929d = false;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f41930e = true;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f41933h = "";

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f41937l = true;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f41940o = true;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f41941p = false;

        public AdConfig build() {
            return new AdConfig(this);
        }

        public AdConfigBuilder initAlliance(boolean z11) {
            this.f41930e = z11;
            return this;
        }

        public AdConfigBuilder isInitAdMob(boolean z11) {
            this.f41936k = z11;
            return this;
        }

        public AdConfigBuilder setAhaChannel(String str) {
            this.f41931f = str;
            return this;
        }

        public AdConfigBuilder setAppIconId(int i11) {
            this.f41927b = i11;
            return this;
        }

        public AdConfigBuilder setAppId(String str) {
            Preconditions.c(str, "appId can not be null");
            this.f41926a = str;
            return this;
        }

        public AdConfigBuilder setChannel(String str) {
            this.f41933h = str;
            return this;
        }

        public AdConfigBuilder setCloudCompleteListener(OnCloudCompleteListener onCloudCompleteListener) {
            this.f41935j = onCloudCompleteListener;
            return this;
        }

        public AdConfigBuilder setCodeSeatIds(List<String> list) {
            this.f41932g = list;
            return this;
        }

        public AdConfigBuilder setCustomParams(Map<String, String> map) {
            if (map != null && !map.isEmpty()) {
                this.f41934i = new HashMap();
                if (map.size() <= 10) {
                    this.f41934i.putAll(map);
                } else {
                    int i11 = 0;
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        if (i11 >= 10) {
                            break;
                        }
                        if (entry != null) {
                            i11++;
                            this.f41934i.put(entry.getKey(), entry.getValue());
                        }
                    }
                }
            }
            return this;
        }

        public AdConfigBuilder setDebug(boolean z11) {
            this.f41928c = z11;
            return this;
        }

        public AdConfigBuilder setDefaultMaterialCacheSize(int i11) {
            this.f41938m = i11;
            return this;
        }

        public AdConfigBuilder setInternalDefaultAdVersion(long j11) {
            this.f41939n = j11;
            return this;
        }

        public AdConfigBuilder setMuteVideo(boolean z11) {
            this.f41937l = z11;
            AdLogUtil.Log().d("TAdManager", "SDK init , muteAllAd = " + z11);
            return this;
        }

        public AdConfigBuilder setShouldOptimizeImageLoading(boolean z11) {
            this.f41941p = z11;
            return this;
        }

        public AdConfigBuilder testDevice(boolean z11) {
            this.f41929d = z11;
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface OnCloudCompleteListener {
        void onCloudComplete(int i11, String str);
    }

    public static void a() {
        if (f41910a != null) {
            AthenaAnalytics.F(f.a(), "Mediation", TrackingManager.TID, f41910a.isDebug(), false);
            AthenaAnalytics.t(true);
            AthenaAnalytics.l(ComConstants.HS_APPID, getAppId());
            AthenaAnalytics.l(ComConstants.HS_VER, d.l());
        }
    }

    public static void a(@NonNull AdConfig adConfig) {
        if (f41910a != null) {
            return;
        }
        if (!adConfig.f41912a) {
            adConfig.f41912a = Log.isLoggable("ADSDK", 3);
        }
        AdLogUtil.Log().setLogSwitch(adConfig.f41912a);
        LogSwitch.isDebug = adConfig.f41912a;
        f41910a = adConfig;
        f.i(adConfig.f41912a);
        ComConstants.LITE = false;
        f41910a.f41916e = false;
        a();
        b();
        n.d((Application) f.a().getApplicationContext());
        d();
    }

    public static void b() {
        o.a().d(f.a(), f41910a);
    }

    public static void c() {
        boolean z11;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jH = a.d().h(ComConstants.APP_ACTIVE_TIME, 0L);
        long jH2 = a.d().h(ComConstants.FIRST_START_FOR_ONE_DAY, 0L);
        long jC = y.c(jCurrentTimeMillis);
        if (jH == 0) {
            a.d().o(ComConstants.APP_ACTIVE_TIME, jCurrentTimeMillis);
        } else {
            jCurrentTimeMillis = jH;
        }
        if (jH2 != jC) {
            a.d().o(ComConstants.FIRST_START_FOR_ONE_DAY, jC);
            z11 = true;
        } else {
            z11 = false;
        }
        AppStartInfo.activeTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS Z").format(new Date(jCurrentTimeMillis));
        AppStartInfo.isFirstStartToday = z11;
    }

    public static void d() {
        Bundle bundle = new Bundle();
        bundle.putLong(TrackingKey.INIT_TS, System.currentTimeMillis());
        bundle.putString(TrackingKey.CLD_APP_ID, getAppId());
        TrackingManager.trackInit(bundle);
    }

    public static String getAhaChannel() {
        AdConfig adConfig = f41910a;
        if (adConfig != null) {
            return adConfig.f41917f;
        }
        return null;
    }

    public static String getAppId() {
        AdConfig adConfig = f41910a;
        if (adConfig != null) {
            return adConfig.f41913b;
        }
        return null;
    }

    public static OnCloudCompleteListener getCloudCompleteListener() {
        AdConfig adConfig = f41910a;
        if (adConfig != null) {
            return adConfig.f41921j;
        }
        return null;
    }

    public static List<String> getCodeSeatIds() {
        AdConfig adConfig = f41910a;
        if (adConfig == null || adConfig.f41918g == null) {
            return null;
        }
        return new ArrayList(f41910a.f41918g);
    }

    public static void init(final Context context, @NonNull AdConfig adConfig) {
        AdLogUtil.Log().e(ComConstants.SDK_INIT, "========================== HiSavana SDk init ========================== ");
        f.f(context);
        c();
        i.f30292a.e(new Runnable() { // from class: com.hisavana.mediation.config.TAdManager.1
            @Override // java.lang.Runnable
            public void run() {
                NetStateManager.setIsNetAvailable(MitNetUtil.c(context));
                CloudControlConfigSync.q();
            }
        });
        a(adConfig);
        f41911b = true;
    }

    public static boolean isDebug() {
        AdConfig adConfig = f41910a;
        if (adConfig != null) {
            return adConfig.f41912a;
        }
        return false;
    }

    public static boolean isTestDevice() {
        AdConfig adConfig = f41910a;
        if (adConfig != null) {
            return adConfig.isTestDevice();
        }
        return false;
    }

    public static void releaseCloudListener() {
        AdConfig adConfig = f41910a;
        if (adConfig != null) {
            adConfig.releaseCloudListener();
        }
    }

    public static void setAgeRestrictedUser(boolean z11) {
        AppStartInfo.ageRestrictedUser = z11;
    }

    public static void setCodeSeatIds(List<String> list) {
        if (list == null || list.size() == 0 || !f41911b) {
            AdLogUtil.Log().e(ComConstants.SDK_INIT, "setCodeSeatIds codeSeatIds is null or empty");
            return;
        }
        AdConfig adConfig = f41910a;
        if (adConfig == null) {
            AdLogUtil.Log().e(ComConstants.SDK_INIT, "setCodeSeatIds u must init first");
        } else {
            adConfig.setCodeSeatIds(list);
            CloudControlConfigSync.b(5);
        }
    }

    public static void setUserConsent(boolean z11) {
        AppStartInfo.userConsent = z11;
    }
}
