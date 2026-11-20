package com.mbridge.msdk.system;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.MBridgeSDK;
import com.mbridge.msdk.foundation.controller.authoritycontroller.AuthorityInfoBean;
import com.mbridge.msdk.foundation.controller.authoritycontroller.CallBackForDeveloper;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.controller.d;
import com.mbridge.msdk.foundation.same.report.k;
import com.mbridge.msdk.foundation.same.report.l;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.MIMManager;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.e;
import com.mbridge.msdk.out.DeveloperTransferIdInfo;
import com.mbridge.msdk.out.OnCompletionListener;
import com.mbridge.msdk.out.SDKInitStatusListener;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public abstract class a implements MBridgeSDK {
    protected static final String LOG_TAG = "com.mbridge.msdk";
    public static Map<String, String> map;
    private b mBridgeSDKImplDiff;
    protected volatile Context mContext;
    protected SDKInitStatusListener mStatusListener;
    protected volatile AtomicBoolean sdkInited;
    public boolean isCoolStart = true;
    protected volatile MBridgeSDK.PLUGIN_LOAD_STATUS STATUS = MBridgeSDK.PLUGIN_LOAD_STATUS.INITIAL;
    protected boolean initCallbacked = false;
    protected boolean isRegisteredLifeCycle = false;
    protected volatile boolean isMIMinited = false;
    private final Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: com.mbridge.msdk.system.a.1
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            if (a.this.isMIMinited) {
                MIMManager.a().e();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            if (a.this.isMIMinited) {
                MIMManager.a().f();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            ad.b("com.mbridge.msdk", "onActivityPaused currentActivityNum:" + c.m().f());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            int iF = c.m().f();
            ad.b("com.mbridge.msdk", "onActivityStarted currentActivityNum:" + iF);
            ad.b("com.mbridge.msdk", "onActivityStarted isCoolStart:" + a.this.isCoolStart);
            if (!a.this.isCoolStart && iF == 0) {
                q.a("1");
            }
            if (a.this.mBridgeSDKImplDiff != null) {
                b unused = a.this.mBridgeSDKImplDiff;
                a aVar = a.this;
                boolean z11 = aVar.isCoolStart;
                Context context = aVar.mContext;
            }
            a.this.isCoolStart = false;
            c.m().a(iF + 1);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            int iF = c.m().f();
            ad.b("com.mbridge.msdk", "onActivityStopped currentActivityNum:" + iF);
            if (iF == 1 || iF == 0) {
                q.a("2");
            }
            c.m().a(iF - 1);
        }
    };

    private void init() {
        SDKInitStatusListener sDKInitStatusListener;
        SDKInitStatusListener sDKInitStatusListener2;
        if (this.sdkInited == null) {
            this.sdkInited = new AtomicBoolean(false);
        }
        this.initCallbacked = false;
        try {
            if (this.sdkInited.get() && (sDKInitStatusListener2 = this.mStatusListener) != null && !this.initCallbacked) {
                this.initCallbacked = true;
                sDKInitStatusListener2.onInitSuccess();
                return;
            }
        } catch (Exception e11) {
            ad.b("com.mbridge.msdk", e11.getMessage());
        }
        if (this.mContext == null && (sDKInitStatusListener = this.mStatusListener) != null) {
            sDKInitStatusListener.onInitFail("Context can not be null.");
            this.initCallbacked = true;
            return;
        }
        try {
            this.mBridgeSDKImplDiff = new b();
            d.a().a(map, this.mContext);
            this.STATUS = MBridgeSDK.PLUGIN_LOAD_STATUS.COMPLETED;
            startTrackManager();
            ai.j();
            initMIMManager();
            if (this.mContext instanceof Application) {
                registerActivityLifecycleListener((Application) this.mContext);
            }
            this.sdkInited.set(true);
        } catch (Exception e12) {
            ad.a("com.mbridge.msdk", "INIT FAIL", e12);
            if (this.sdkInited != null) {
                this.sdkInited.set(false);
            }
            SDKInitStatusListener sDKInitStatusListener3 = this.mStatusListener;
            if (sDKInitStatusListener3 != null && !this.initCallbacked) {
                this.initCallbacked = true;
                sDKInitStatusListener3.onInitFail(e12.getMessage());
            }
        }
        try {
            k.a().b();
            HashMap map2 = new HashMap();
            if (this.sdkInited != null) {
                map2.put(NotificationCompat.CATEGORY_STATUS, this.sdkInited.get() ? "1" : "2");
                map2.put("is_allow_crash", c.m().d().b() ? "1" : "2");
                map2.put("is_allow_anr", c.m().d().a() ? "1" : "2");
            }
            l.a().a("m_init_sdk", "InitSDK", "", "", map2);
        } catch (Throwable th2) {
            ad.b("com.mbridge.msdk", th2.getMessage());
        }
        SDKInitStatusListener sDKInitStatusListener4 = this.mStatusListener;
        if (sDKInitStatusListener4 == null || this.initCallbacked) {
            return;
        }
        this.initCallbacked = true;
        sDKInitStatusListener4.onInitSuccess();
    }

    private void initMIMManager() {
        try {
            String str = Build.MANUFACTURER;
            if (TextUtils.isEmpty(str) || !str.equals("Xiaomi")) {
                return;
            }
            this.isMIMinited = true;
            MIMManager.a().a(this.mContext.getApplicationContext());
        } catch (Throwable th2) {
            ad.b("com.mbridge.msdk", th2.getMessage());
        }
    }

    private void startTrackManager() {
        l.a().c();
    }

    private void unregisterActivityLifecycleListener(Application application) {
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks;
        if (!this.isRegisteredLifeCycle || (activityLifecycleCallbacks = this.activityLifecycleCallbacks) == null) {
            return;
        }
        application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    public void checkAliveContext(Context context) {
        if (c.m().c() != null || context == null) {
            return;
        }
        c.m().b(context);
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public boolean getConsentStatus(Context context) {
        checkAliveContext(context);
        return com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().e();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public Map<String, String> getMBConfigurationMap(String str, String str2) {
        return getMBConfigurationMap(str, str2, "");
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public Map<String, String> getMBConfigurationMap(String str, String str2, String str3) {
        HashMap map2 = new HashMap();
        map2.put(MBridgeConstans.ID_MBRIDGE_APPID, str);
        map2.put(MBridgeConstans.ID_MBRIDGE_APPKEY, str2);
        map2.put(MBridgeConstans.ID_MBRIDGE_WX_APPID, str3);
        map2.put(MBridgeConstans.ID_MBRIDGE_STARTUPCRASH, String.valueOf(1));
        return map2;
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public Map<String, String> getMBConfigurationMap(String str, String str2, String str3, boolean z11) {
        return getMBConfigurationMap(str, str2, "");
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public Map<String, String> getMBConfigurationMap(String str, String str2, boolean z11) {
        return getMBConfigurationMap(str, str2, "");
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public MBridgeSDK.PLUGIN_LOAD_STATUS getStatus() {
        return this.STATUS;
    }

    public void init(Application application) {
        this.mContext = application.getApplicationContext();
        init();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public void init(Map<String, String> map2, Application application) {
        this.mContext = application.getApplicationContext();
        map = map2;
        init();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public void init(Map<String, String> map2, Application application, SDKInitStatusListener sDKInitStatusListener) {
        this.mContext = application;
        this.mStatusListener = sDKInitStatusListener;
        map = map2;
        init();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public void init(Map<String, String> map2, Context context) {
        this.mContext = context.getApplicationContext();
        map = map2;
        init();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public void init(Map<String, String> map2, Context context, SDKInitStatusListener sDKInitStatusListener) {
        this.mContext = context.getApplicationContext();
        this.mStatusListener = sDKInitStatusListener;
        map = map2;
        init();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public void initAsync(Map<String, String> map2, Application application) {
        this.mContext = application.getApplicationContext();
        map = map2;
        init();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public void initAsync(Map<String, String> map2, Application application, SDKInitStatusListener sDKInitStatusListener) {
        this.mContext = application;
        this.mStatusListener = sDKInitStatusListener;
        map = map2;
        init();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public void initAsync(Map<String, String> map2, Context context) {
        this.mContext = context.getApplicationContext();
        map = map2;
        init();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public void initAsync(Map<String, String> map2, Context context, SDKInitStatusListener sDKInitStatusListener) {
        this.mContext = context.getApplicationContext();
        this.mStatusListener = sDKInitStatusListener;
        map = map2;
        init();
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public void preload(Map<String, Object> map2) {
        if (this.STATUS == MBridgeSDK.PLUGIN_LOAD_STATUS.COMPLETED) {
            d.a().a(map2, 0);
        }
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public void preloadFrame(Map<String, Object> map2) {
        d.a().a(map2, 1);
    }

    public void registerActivityLifecycleListener(Application application) {
        boolean z11;
        try {
            z11 = af.a().a("c_r_a_l_c", 0) == 0;
        } catch (Exception e11) {
            ad.b("com.mbridge.msdk", e11.getMessage());
        }
        if (application == null || !z11) {
            return;
        }
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.activityLifecycleCallbacks;
        if (activityLifecycleCallbacks != null) {
            application.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
        this.isRegisteredLifeCycle = true;
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public void release() {
        if (this.STATUS == MBridgeSDK.PLUGIN_LOAD_STATUS.COMPLETED) {
            d.a().c();
        }
        if (this.mContext instanceof Application) {
            unregisterActivityLifecycleListener((Application) this.mContext);
        }
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public void setAllowAcquireIds(boolean z11) {
        com.mbridge.msdk.foundation.controller.authoritycontroller.b.a(z11);
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public void setAllowTransferIdsIfLimit(boolean z11) {
        com.mbridge.msdk.foundation.controller.authoritycontroller.b.b(z11);
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public void setConsentStatus(Context context) {
        checkAliveContext(context);
        com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().a(context, (OnCompletionListener) null);
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public void setConsentStatus(Context context, int i11) {
        checkAliveContext(context);
        com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().a(i11);
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public void setConsentStatus(Context context, OnCompletionListener onCompletionListener) {
        checkAliveContext(context);
        com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().a(context, onCompletionListener);
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public void setCoppaStatus(Context context, boolean z11) {
        checkAliveContext(context);
        com.mbridge.msdk.foundation.controller.authoritycontroller.c.j();
        com.mbridge.msdk.foundation.a.a.a.a().b(MBridgeConstans.AUTHORITY_COPPA, z11 ? 1 : 2);
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public void setDeveloperIds(DeveloperTransferIdInfo developerTransferIdInfo) {
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.b.a() || developerTransferIdInfo == null || TextUtils.isEmpty(developerTransferIdInfo.getGaid())) {
            return;
        }
        e.a(developerTransferIdInfo.getGaid());
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public void setDoNotTrackStatus(Context context, boolean z11) {
        checkAliveContext(context);
        com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().b(z11 ? 1 : 0);
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public void setDoNotTrackStatus(boolean z11) {
        com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().b(z11 ? 1 : 0);
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public void setPlayVideoMute(int i11, int i12) {
        if (i11 == 94) {
            com.mbridge.msdk.foundation.same.a.V = i12;
        } else if (i11 == 287) {
            com.mbridge.msdk.foundation.same.a.W = i12;
        }
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public void setThirdPartyFeatures(Map<String, Object> map2) {
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public void setUserPrivateInfoType(Context context, String str, int i11) {
        checkAliveContext(context);
        com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().a(str, i11);
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public void showUserPrivateInfoTips(Context context, CallBackForDeveloper callBackForDeveloper) {
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public void updateDialogWeakActivity(WeakReference<Activity> weakReference) {
        c.m().a(weakReference);
    }

    @Override // com.mbridge.msdk.MBridgeSDK
    public AuthorityInfoBean userPrivateInfo(Context context) {
        checkAliveContext(context);
        return com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().d();
    }
}
