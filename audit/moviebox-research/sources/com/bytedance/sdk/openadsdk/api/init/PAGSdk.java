package com.bytedance.sdk.openadsdk.api.init;

import android.app.Application;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutManager;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.WebView;
import com.bytedance.sdk.component.Ol.We;
import com.bytedance.sdk.component.Ol.zY;
import com.bytedance.sdk.component.Qj.ExN;
import com.bytedance.sdk.component.Qj.Ol;
import com.bytedance.sdk.component.Qj.Qj;
import com.bytedance.sdk.component.Qj.TRI;
import com.bytedance.sdk.component.Qj.WH;
import com.bytedance.sdk.component.pFF;
import com.bytedance.sdk.component.qr.zY.sc;
import com.bytedance.sdk.component.utils.Sfl;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.InitConfig;
import com.bytedance.sdk.openadsdk.JPJ.pFF.qr;
import com.bytedance.sdk.openadsdk.api.factory.IADTypeLoaderFactory;
import com.bytedance.sdk.openadsdk.api.factory.ISDKTypeFactory;
import com.bytedance.sdk.openadsdk.api.factory.SDKTypeConfig;
import com.bytedance.sdk.openadsdk.core.BT;
import com.bytedance.sdk.openadsdk.core.II;
import com.bytedance.sdk.openadsdk.core.Ql;
import com.bytedance.sdk.openadsdk.core.SR;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.settings.Tf;
import com.bytedance.sdk.openadsdk.core.settings.dE;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.cJ;
import com.bytedance.sdk.openadsdk.utils.wjp;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class PAGSdk {
    public static final int INIT_LOCAL_FAIL_CODE = 4000;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static long f27661sc;

    /* JADX INFO: compiled from: source.java */
    public interface PAGInitCallback {
        void fail(int i11, String str);

        void success();
    }

    static {
        try {
            pFF.sc(new pFF.sc() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.1
                @Override // com.bytedance.sdk.component.pFF.sc
                public ExecutorService getExecutorService() {
                    return Cb.We();
                }
            });
            Cb.sc(new Qj("tt_init_memory_data") { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.2
                @Override // java.lang.Runnable
                public void run() {
                    PAGInitHelper.initAPM();
                    PAGInitHelper.initMemoryData();
                }
            });
            SR.sc(System.currentTimeMillis());
            SR.pFF();
            We.setWebViewProvider(new We.zY() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.3
                @Override // com.bytedance.sdk.component.Ol.We.zY
                public WebView createWebView(Context context, AttributeSet attributeSet, int i11) {
                    if (!(context instanceof MutableContextWrapper)) {
                        context = context.getApplicationContext();
                    }
                    try {
                        return i11 == 0 ? new zY(context, attributeSet) : new zY(context, attributeSet, i11);
                    } catch (Exception unused) {
                        return i11 == 0 ? new zY(context, attributeSet) : new zY(context, attributeSet, i11);
                    }
                }
            });
        } catch (Throwable th2) {
            th2.getMessage();
        }
        f27661sc = 0L;
    }

    private static void ExN(Context context, InitConfig initConfig) {
        if (Tf.sc()) {
            TRI.zY(-1);
            ExN.sc(new WH() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.7
                @Override // com.bytedance.sdk.component.Qj.WH
                public Ol createThreadFactory(int i11, String str) {
                    return new Ol(i11, str) { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.7.1
                        @Override // com.bytedance.sdk.component.Qj.Ol, java.util.concurrent.ThreadFactory
                        public Thread newThread(Runnable runnable) {
                            int iKDg = dE.ef().kDg();
                            if (iKDg < -524288 || iKDg >= 0) {
                                return super.newThread(runnable);
                            }
                            Thread thread = new Thread(this.f26554sc, runnable, this.pFF, iKDg);
                            if (thread.isDaemon()) {
                                thread.setDaemon(false);
                            }
                            int i12 = this.zY;
                            if (i12 > 10 || i12 <= 0) {
                                this.zY = 5;
                            }
                            thread.setPriority(this.zY);
                            return thread;
                        }
                    };
                }
            });
            com.bytedance.sdk.openadsdk.multipro.zY.sc(context);
            sc.sc(new com.bytedance.sdk.component.qr.zY.zY() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.8
                @Override // com.bytedance.sdk.component.qr.zY.zY
                public ExecutorService getThreadPool() {
                    return Cb.We();
                }
            });
            com.bytedance.sdk.openadsdk.qr.pFF.zY();
            SR.pFF.set(true);
            try {
                com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().sc(new com.bytedance.sdk.openadsdk.Ol.sc());
            } catch (Exception e11) {
                com.bytedance.sdk.component.utils.Tf.sc("TTAD.PAGSdk", e11.getMessage());
            }
            zY(initConfig);
            zY(context, initConfig);
            q8.c.g(context, null);
            q8.c.f(2);
            q8.c.i(initConfig.isSupportMultiProcess());
            q8.c.h(com.bytedance.sdk.openadsdk.Xc.zY.sc().pFF().ExN());
            if (Build.VERSION.SDK_INT < 23) {
                j8.a.e(context);
            }
        }
    }

    private static void TRI(final Context context, final InitConfig initConfig) {
        SystemClock.elapsedRealtime();
        Cb.sc(new Qj("init_sync") { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.9
            @Override // java.lang.Runnable
            public void run() {
                SR.sc(initConfig.getData());
                com.bytedance.sdk.openadsdk.YIK.sc.sc(context, initConfig.getAppId());
                com.bytedance.sdk.openadsdk.YIK.sc.sc();
                com.bytedance.sdk.openadsdk.dE.zY.sc();
                com.bytedance.sdk.openadsdk.dE.zY.pFF();
                new com.bytedance.sdk.openadsdk.utils.SR();
                com.bytedance.sdk.component.adexpress.sc.pFF.TRI.sc(wjp.sc() * 10);
                com.bytedance.sdk.openadsdk.We.sc.We.sc(context, initConfig.isSupportMultiProcess());
                BT.sc().pFF();
                com.bytedance.sdk.openadsdk.core.Ol.zY.sc();
                com.bytedance.sdk.openadsdk.uEA.sc.sc(new com.bytedance.sdk.openadsdk.uEA.sc.InterfaceC0316sc() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.9.1
                    public void onGdprChanged(int i11) {
                        PAGConfig.setGDPRConsent(i11);
                    }
                });
                dE.We = dE.zY(context);
                qr.pFF();
                j8.a.f(Xc.We().fT());
                j8.a.g(CacheDirFactory.getICacheDir(0));
                com.bytedance.sdk.openadsdk.core.settings.TRI triWe = Xc.We();
                if (!triWe.Yhz()) {
                    synchronized (triWe) {
                        try {
                            if (!triWe.Yhz()) {
                                triWe.pFF();
                                triWe.HJN();
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
                DeviceUtils.WH();
                PAGInitHelper.maybeAsyncInitTask(context);
                PAGSdk.getBiddingToken();
                TRI.sc(true);
                TRI.sc(new com.bytedance.sdk.openadsdk.SR.pFF.sc());
                DeviceUtils.sc(context);
                DeviceUtils.WH(context);
                DeviceUtils.UFX(context);
                com.bytedance.sdk.openadsdk.SR.sc.sc();
                com.bytedance.sdk.openadsdk.core.settings.We.sc();
                com.bytedance.sdk.openadsdk.SR.zY.We();
                cJ.Ql(context);
                com.bytedance.sdk.openadsdk.We.zY.sc();
                PAGSdk.zY();
                com.bytedance.sdk.openadsdk.core.Ol.zY.pFF();
                com.bytedance.sdk.openadsdk.core.We.sc.sc().pFF();
                com.bytedance.sdk.component.Qj.zY.zY.sc(SR.pFF());
                com.bytedance.sdk.component.utils.pFF.sc(new com.bytedance.sdk.component.utils.pFF.sc() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.9.2
                    @Override // com.bytedance.sdk.component.utils.pFF.sc
                    public ExecutorService getAsyncStartActivityThreadPool() {
                        return Cb.Qj();
                    }

                    @Override // com.bytedance.sdk.component.utils.pFF.sc
                    public boolean isEnableAsyncStartActivity() {
                        return com.bytedance.sdk.openadsdk.YIK.sc.sc("start_activity_async", 0) == 1;
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void We() {
        SR.sc(1);
        try {
            List<PAGInitCallback> list = PAGInitHelper.CALLBACK_LIST;
            synchronized (list) {
                try {
                    Iterator<PAGInitCallback> it = list.iterator();
                    while (it.hasNext()) {
                        PAGInitCallback next = it.next();
                        if (next != null) {
                            it.remove();
                            next.success();
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            com.bytedance.sdk.openadsdk.dE.zY.pFF(new com.bytedance.sdk.openadsdk.dE.We() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.11
                @Override // com.bytedance.sdk.openadsdk.dE.We
                public com.bytedance.sdk.openadsdk.dE.pFF.sc generatorModel() {
                    com.bytedance.sdk.openadsdk.dE.pFF.sc scVar = new com.bytedance.sdk.openadsdk.dE.pFF.sc();
                    scVar.pFF("init");
                    return scVar;
                }
            });
        } catch (Throwable th3) {
            com.bytedance.sdk.component.utils.Tf.pFF(th3.getMessage());
        }
    }

    private static void We(Context context, InitConfig initConfig) {
        if (TextUtils.isEmpty(initConfig.getPackageName())) {
            Sfl.sc((String) null);
            com.bytedance.adsdk.ugeno.qr.We.sc((String) null);
        } else {
            Sfl.sc(initConfig.getPackageName());
            com.bytedance.adsdk.ugeno.qr.We.sc(initConfig.getPackageName());
        }
        Xc.pFF(context);
        if (initConfig.isSupportMultiProcess()) {
            com.bytedance.sdk.openadsdk.multipro.pFF.sc();
        } else {
            com.bytedance.sdk.openadsdk.multipro.pFF.pFF();
        }
        com.bytedance.sdk.openadsdk.core.Qj.Tf.sc();
        com.bytedance.sdk.openadsdk.core.UFX.pFF.sc(context);
    }

    public static void addPAGInitCallback(PAGInitCallback pAGInitCallback) {
        if (pAGInitCallback != null && SR.We() == 0) {
            PAGInitHelper.CALLBACK_LIST.add(pAGInitCallback);
        }
    }

    public static void closeMultiWebViewFileLock() {
        com.bytedance.sdk.openadsdk.multipro.zY.sc();
    }

    public static String getApplicationName(Context context) {
        try {
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            return (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 128));
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static String getBiddingToken() {
        if (com.bytedance.sdk.openadsdk.common.ExN.sc()) {
            return null;
        }
        return (Xc.sc() == null || II.sc() == null) ? "" : II.sc().ExN();
    }

    public static String getBiddingToken(Context context) {
        if (com.bytedance.sdk.openadsdk.common.ExN.sc()) {
            return null;
        }
        Xc.pFF(context);
        return getBiddingToken();
    }

    public static String getBiddingToken(Context context, String str) {
        if (com.bytedance.sdk.openadsdk.common.ExN.sc()) {
            return null;
        }
        Xc.pFF(context);
        return getBiddingToken(str);
    }

    public static String getBiddingToken(String str) {
        if (com.bytedance.sdk.openadsdk.common.ExN.sc()) {
            return null;
        }
        return (Xc.sc() == null || II.sc() == null) ? "" : II.sc().zY(str);
    }

    public static void getBiddingToken(final BiddingTokenCallback biddingTokenCallback) {
        if (biddingTokenCallback == null) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.common.ExN.sc()) {
            biddingTokenCallback.onBiddingTokenCollected(null);
        } else {
            Cb.ExN(new Qj("getBiddingToken") { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.14
                @Override // java.lang.Runnable
                public void run() {
                    biddingTokenCallback.onBiddingTokenCollected(PAGSdk.getBiddingToken());
                }
            });
        }
    }

    public static void getBiddingToken(final String str, final BiddingTokenCallback biddingTokenCallback) {
        if (biddingTokenCallback == null) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.common.ExN.sc()) {
            biddingTokenCallback.onBiddingTokenCollected(null);
        } else {
            Cb.ExN(new Qj("getBiddingToken") { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.15
                @Override // java.lang.Runnable
                public void run() {
                    biddingTokenCallback.onBiddingTokenCollected(PAGSdk.getBiddingToken(str));
                }
            });
        }
    }

    public static String getSDKVersion() {
        return II.sc() != null ? II.sc().We() : "";
    }

    public static void init(final Context context, final PAGConfig pAGConfig, final PAGInitCallback pAGInitCallback) {
        SR.pFF().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.13
            @Override // java.lang.Runnable
            public void run() {
                PAGSdk.pFF(context, pAGConfig, pAGInitCallback);
            }
        });
        SR.Qj();
    }

    public static boolean isInitSuccess() {
        return SR.We() == 1;
    }

    public static boolean onlyVerityPlayable(String str, int i11, String str2, String str3, String str4) {
        if (II.sc() != null) {
            return II.sc().sc(str, i11, str2, str3, str4);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void pFF(int i11, String str) {
        SR.sc(2);
        try {
            List<PAGInitCallback> list = PAGInitHelper.CALLBACK_LIST;
            synchronized (list) {
                try {
                    Iterator<PAGInitCallback> it = list.iterator();
                    while (it.hasNext()) {
                        PAGInitCallback next = it.next();
                        if (next != null) {
                            it.remove();
                            next.fail(i11, str);
                        }
                    }
                    com.bytedance.sdk.openadsdk.dE.zY.zY(new com.bytedance.sdk.openadsdk.dE.We() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.12
                        @Override // com.bytedance.sdk.openadsdk.dE.We
                        public com.bytedance.sdk.openadsdk.dE.pFF.sc generatorModel() {
                            com.bytedance.sdk.openadsdk.dE.pFF.sc scVar = new com.bytedance.sdk.openadsdk.dE.pFF.sc();
                            scVar.pFF("init");
                            return scVar;
                        }
                    });
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            com.bytedance.sdk.component.utils.Tf.pFF(th3.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void pFF(Context context, InitConfig initConfig) {
        long j11;
        try {
            if (isInitSuccess()) {
                We();
                return;
            }
            ExN(context, initConfig);
            dE.ef().Dl();
            long jElapsedRealtime = SystemClock.elapsedRealtime() - f27661sc;
            We();
            TRI(context, initConfig);
            j11 = jElapsedRealtime;
            sc(context, isInitSuccess(), initConfig, SystemClock.elapsedRealtime() - f27661sc, j11);
        } catch (Throwable th2) {
            th2.getMessage();
            com.bytedance.sdk.component.utils.Tf.sc("TTAD.PAGSdk", th2.getMessage());
            long jElapsedRealtime2 = SystemClock.elapsedRealtime() - f27661sc;
            pFF(4000, th2.getMessage());
            j11 = jElapsedRealtime2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void pFF(final Context context, final InitConfig initConfig, PAGInitCallback pAGInitCallback) {
        Context applicationContext;
        f27661sc = SystemClock.elapsedRealtime();
        Xc.pFF(context);
        if (pAGInitCallback != null) {
            List<PAGInitCallback> list = PAGInitHelper.CALLBACK_LIST;
            synchronized (list) {
                if (!list.contains(pAGInitCallback)) {
                    list.add(pAGInitCallback);
                    if (SR.We() == 3) {
                        return;
                    }
                }
            }
        }
        if (com.bytedance.sdk.openadsdk.common.ExN.sc()) {
            pFF(-1, "DisableSDK is called, interrupt initialization");
            return;
        }
        if (isInitSuccess()) {
            We();
            return;
        }
        SR.sc(3);
        if (context == null) {
            pFF(4000, "Context is null, please check. ");
            return;
        }
        if (!(context instanceof Application) && (applicationContext = context.getApplicationContext()) != null) {
            context = applicationContext;
        }
        if (initConfig == null) {
            pFF(4000, "PAGConfig is null, please check.");
            return;
        }
        We(context, initConfig);
        ApmHelper.initApm(context, initConfig);
        try {
            com.bytedance.sdk.openadsdk.core.Ol.sc(new Ql() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.4
                @Override // com.bytedance.sdk.openadsdk.core.Ql
                public void fail(int i11, String str) {
                    PAGSdk.pFF(i11, str);
                }

                public void success() {
                    PAGSdk.We();
                }
            });
            try {
                Sfl.sc(Xc.sc(), "tt_ad_logo_txt");
                if (Sfl.We(context, "tt_ad_logo") == 0) {
                    sc(initConfig, pAGInitCallback);
                    return;
                }
                if (isInitSuccess()) {
                    if (pAGInitCallback != null) {
                        We();
                        return;
                    }
                    return;
                }
                final com.bytedance.sdk.openadsdk.ExN.sc scVar = new com.bytedance.sdk.openadsdk.ExN.sc();
                SDKTypeConfig.setSdkTypeFactory(new ISDKTypeFactory() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.5
                    @Override // com.bytedance.sdk.openadsdk.api.factory.ISDKTypeFactory
                    public IADTypeLoaderFactory createADTypeLoaderFactory(String str) {
                        return scVar;
                    }
                });
                if (!initConfig.isSupportMultiProcess()) {
                    pFF(context, initConfig);
                } else {
                    com.bytedance.sdk.openadsdk.multipro.aidl.sc.sc().sc(new com.bytedance.sdk.openadsdk.multipro.aidl.pFF() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.6
                        @Override // com.bytedance.sdk.openadsdk.multipro.aidl.pFF
                        public void onServiceConnected() {
                            SR.pFF().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.6.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                                    PAGSdk.pFF(context, initConfig);
                                }
                            });
                        }
                    });
                    com.bytedance.sdk.openadsdk.multipro.aidl.sc.sc().zY();
                }
            } catch (Throwable unused) {
                sc(initConfig, pAGInitCallback);
            }
        } catch (Throwable unused2) {
            pFF(4000, "Internal Error, setting exception. ");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean pFF(InitConfig initConfig) {
        return ((PAGConfig) initConfig).getDebugLog();
    }

    private static void sc(final Context context, final boolean z11, final InitConfig initConfig, final long j11, final long j12) {
        com.bytedance.sdk.openadsdk.SR.zY.sc();
        com.bytedance.sdk.openadsdk.SR.zY.sc("pangle_sdk_init", false, new com.bytedance.sdk.openadsdk.SR.pFF() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.10
            @Override // com.bytedance.sdk.openadsdk.SR.pFF
            public com.bytedance.sdk.openadsdk.SR.sc.zY getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    boolean zZY = com.bytedance.sdk.openadsdk.core.Ol.pFF().zY();
                    jSONObject.put("duration", j11);
                    jSONObject.put("sdk_init_time", j12);
                    jSONObject.put("is_async", true);
                    jSONObject.put("is_multi_process", initConfig.isSupportMultiProcess());
                    jSONObject.put("is_debug", PAGSdk.pFF(initConfig));
                    jSONObject.put("is_use_texture_view", initConfig.isUseTextureView());
                    jSONObject.put("is_activate_init", zZY);
                    jSONObject.put("minSdkVersion", cJ.UFX(context));
                    jSONObject.put("targetSdkVersion", cJ.WH(context));
                    jSONObject.put("apm_is_init", ApmHelper.isIsInit());
                    jSONObject.put("is_success", z11);
                    com.bytedance.sdk.openadsdk.core.Ol.pFF().pFF(false);
                } catch (Exception e11) {
                    com.bytedance.sdk.component.utils.Tf.sc("TTAD.PAGSdk", "run: ", e11);
                }
                return com.bytedance.sdk.openadsdk.SR.sc.We.pFF().sc("pangle_sdk_init").pFF(jSONObject.toString());
            }
        });
    }

    private static void sc(InitConfig initConfig, PAGInitCallback pAGInitCallback) {
        SR.sc(2);
        if (pAGInitCallback != null) {
            if (initConfig instanceof PAGConfig) {
                pFF(4000, "resources not found, if you use aab please call PAGConfig.setPackageName");
            } else {
                pFF(4000, "resources not found, if you use aab please call TTAdConfig.setPackageName");
            }
        }
    }

    public static void setAabPackageName(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Sfl.sc(str);
        com.bytedance.adsdk.ugeno.qr.We.sc(str);
    }

    public static void setAdRevenue(JSONObject jSONObject) {
        if (jSONObject != null && Xc.We().wjp() && isInitSuccess()) {
            com.bytedance.sdk.openadsdk.SR.zY.sc().sc(jSONObject);
        }
    }

    private static void setSdkDisable(boolean z11) {
        com.bytedance.sdk.openadsdk.common.ExN.sc(z11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zY() {
        ShortcutManager shortcutManagerA;
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                Context contextSc = Xc.sc();
                if (contextSc == null || (shortcutManagerA = b.a(contextSc.getSystemService(a.a()))) == null) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.Ol.pFF().sc(shortcutManagerA.isRequestPinShortcutSupported());
            } catch (Throwable unused) {
            }
        }
    }

    private static void zY(Context context, InitConfig initConfig) {
        SR.f28193sc = true;
        II.sc().sc(initConfig.getAppId()).pFF(initConfig.getCoppa()).zY(initConfig.getGdpr()).We(initConfig.getCcpa()).TRI(initConfig.getAppIconId()).sc(initConfig.getTitleBarTheme());
        com.bytedance.sdk.openadsdk.core.Ol.JPJ();
        if (initConfig instanceof PAGConfig) {
            II.sc().ExN(((PAGConfig) initConfig).getDebugLog() ? 1 : 0);
        }
        try {
            if (pFF(initConfig)) {
                II.sc().sc();
                com.bytedance.sdk.openadsdk.utils.dE.sc();
            }
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.component.utils.qr.sc();
    }

    private static void zY(InitConfig initConfig) {
        if (!TextUtils.isEmpty(initConfig.getData())) {
            com.bytedance.sdk.openadsdk.core.Ol.pFF().zY(initConfig.getData());
        }
        com.bytedance.sdk.openadsdk.core.Ol.pFF().zY(pFF(initConfig));
    }
}
