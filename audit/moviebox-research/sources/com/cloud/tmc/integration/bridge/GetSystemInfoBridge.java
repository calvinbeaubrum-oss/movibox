package com.cloud.tmc.integration.bridge;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.model.UniqueIdBean;
import com.cloud.tmc.integration.net.BaseResponse;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.utils.MiniRequestUtils;
import com.cloud.tmc.integration.utils.c0;
import com.cloud.tmc.integration.utils.e0;
import com.cloud.tmc.integration.utils.z;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.intf.IPackageConfig;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.MBridgeConstans;
import com.transsion.push.PushConstants;
import java.lang.reflect.Type;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class GetSystemInfoBridge implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f30467a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f30468b;

    /* JADX INFO: compiled from: source.java */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int iE = GetSystemInfoBridge.this.e(intent);
            if (iE > 0) {
                GetSystemInfoBridge.this.f30468b = iE;
            }
            GetSystemInfoBridge.this.f30467a = false;
            context.unregisterReceiver(this);
            TmcLogger.c("GetSystemInfoBridge", "ACTION_BATTERY_CHANGED..." + GetSystemInfoBridge.this.f30468b);
        }
    }

    public static String c() {
        return com.cloud.tmc.miniutils.util.e.a(com.cloud.tmc.miniutils.util.v.d(), 2);
    }

    public final int a(Context context) {
        if (this.f30467a) {
            return this.f30468b;
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            Intent intentRegisterReceiver = context.registerReceiver(new a(), intentFilter);
            this.f30467a = true;
            int iE = e(intentRegisterReceiver);
            if (iE > 0) {
                this.f30468b = iE;
            }
            return this.f30468b;
        } catch (Exception e11) {
            TmcLogger.e("getCurrentBatteryPercentage...e=" + e11);
            return this.f30468b;
        }
    }

    public final int b(Page page, Activity activity, float f11, DisplayMetrics displayMetrics) {
        zc.i render;
        int iRound = displayMetrics != null ? Math.round((displayMetrics.heightPixels - com.cloud.tmc.integration.utils.s.c(activity)) / f11) : 0;
        if (page == null || (render = page.getRender()) == null || render.getView() == null) {
            return iRound;
        }
        int iRound2 = render.getView() != null ? Math.round(render.getView().getHeight() / f11) : 0;
        return iRound2 > 0 ? iRound2 : iRound;
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(bc.a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public void clearSharpNewsCommonData(@cc.f(App.class) App app, @cc.c bc.a aVar) {
        try {
            if (app == null) {
                if (aVar != null) {
                    aVar.b();
                    return;
                }
                return;
            }
            tb.b appContext = app.getAppContext();
            if (appContext == null) {
                if (aVar != null) {
                    aVar.b();
                    return;
                }
                return;
            }
            Context context = appContext.getContext();
            if (context == null) {
                if (aVar != null) {
                    aVar.b();
                }
            } else {
                TmcLogger.c("GetSystemInfoBridge", "clearSharpNewsSyncData");
                ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).clear(context, "snSyncDataWebStorage");
                if (aVar != null) {
                    aVar.g();
                }
            }
        } catch (Throwable th2) {
            TmcLogger.g("GetSystemInfoBridge", "clearSharpNewsSyncData error", th2);
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    public final JsonObject d(Context context, App app, Page page) {
        float f11;
        int iRound;
        JsonObject jsonObject = new JsonObject();
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Activity activity = (Activity) app.getAppContext().getContext();
        if (displayMetrics != null) {
            f11 = displayMetrics.density;
            iRound = Math.round(displayMetrics.widthPixels / f11);
            jsonObject.addProperty("screenWidth", Integer.valueOf(displayMetrics.widthPixels));
            jsonObject.addProperty("screenHeight", Integer.valueOf(displayMetrics.heightPixels));
        } else {
            f11 = 0.0f;
            iRound = 0;
        }
        jsonObject.addProperty("language", Locale.getDefault().getLanguage());
        jsonObject.addProperty("model", Build.MANUFACTURER + " " + Build.MODEL);
        jsonObject.addProperty("pixelRatio", Float.valueOf(f11));
        jsonObject.addProperty("windowWidth", Integer.valueOf(iRound));
        jsonObject.addProperty("windowHeight", Integer.valueOf(b(page, activity, f11, displayMetrics)));
        jsonObject.addProperty("system", Build.VERSION.RELEASE);
        jsonObject.addProperty(TrackingKey.PLATFORM, "Android");
        jsonObject.addProperty("apiLevel", Integer.valueOf(Build.VERSION.SDK_INT));
        jsonObject.addProperty(PlaceTypes.STORAGE, c());
        jsonObject.addProperty("currentBattery", a(context) + "%");
        jsonObject.addProperty("brand", Build.BRAND);
        String frameworkVersion = ((IPackageConfig) tc.a.a(IPackageConfig.class)).getFrameworkVersion();
        if (!TextUtils.isEmpty(frameworkVersion)) {
            jsonObject.addProperty("frameworkversion", frameworkVersion);
        }
        jsonObject.addProperty("packageName", context.getPackageName());
        jsonObject.addProperty("gaId", com.cloud.tmc.integration.utils.q.d());
        jsonObject.addProperty("GAId", com.cloud.tmc.integration.utils.q.d());
        jsonObject.addProperty("mcc", c0.g(context));
        jsonObject.addProperty(PlaceTypes.COUNTRY, Locale.getDefault().getCountry());
        jsonObject.addProperty(PushConstants.PROVIDER_FIELD_SDK_VERSION, ((IPackageConfig) tc.a.a(IPackageConfig.class)).getSDKVersion());
        jsonObject.addProperty("brandVersion", ((IPackageConfig) tc.a.a(IPackageConfig.class)).getSDKVersion());
        try {
            jsonObject.addProperty("statusBarHeight", Integer.valueOf(e0.a()));
        } catch (Throwable th2) {
            TmcLogger.h("GetSystemInfoBridge", th2);
        }
        try {
            jsonObject.addProperty("isRtl", Boolean.valueOf(resources.getConfiguration().getLayoutDirection() == 1));
        } catch (Throwable th3) {
            TmcLogger.h("GetSystemInfoBridge", th3);
        }
        jsonObject.addProperty("capsuleHeight", Integer.valueOf(page.getIntValue("capsuleHeight")));
        jsonObject.addProperty("capsuleWidth", Integer.valueOf(page.getIntValue("capsuleWidth")));
        jsonObject.addProperty("capsuleTranslationX", Integer.valueOf(page.getIntValue("capsuleTranslationX")));
        jsonObject.addProperty("capsuleTranslationY", Integer.valueOf(page.getIntValue("capsuleTranslationY")));
        return jsonObject;
    }

    public final int e(Intent intent) {
        if (!"android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
            return -1;
        }
        return (intent.getIntExtra("level", 0) * 100) / intent.getIntExtra("scale", 100);
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public void getByteAppRecommendList(@cc.f(App.class) App app, @cc.c bc.a aVar) {
        if (app == null || app.getAppContext() == null || app.getAppContext().getContext() == null) {
            if (aVar != null) {
                aVar.b();
            }
        } else if (aVar != null) {
            aVar.d(z.a().d("recommendList", "").e());
        }
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public void getCountryByIso(@cc.f(App.class) App app, @cc.c bc.a aVar) {
        if (app == null || app.getAppContext() == null || app.getAppContext().getContext() == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        String strC = c0.c(app.getAppContext().getContext());
        TmcLogger.c("GetSystemInfoBridge", "countryCode:  " + strC);
        if (aVar != null) {
            aVar.d(z.a().d("countryCode", strC).e());
        }
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public void getCountryInfo(@cc.f(App.class) App app, @cc.g({"type"}) String str, @cc.c bc.a aVar) {
        String strB;
        if (app == null || app.getAppContext() == null || app.getAppContext().getContext() == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        Context context = app.getAppContext().getContext();
        String strG = c0.g(context);
        String strH = c0.h(context);
        String str2 = "sim";
        if ("sim".equalsIgnoreCase(str)) {
            strB = c0.c(context);
        } else {
            if ("language".equalsIgnoreCase(str)) {
                strB = c0.b(context);
            } else {
                String strC = c0.c(context);
                if (TextUtils.isEmpty(strC)) {
                    strB = c0.b(context);
                } else {
                    strB = strC;
                }
            }
            str2 = "language";
        }
        TmcLogger.c("GetSystemInfoBridge", "CountryCode: " + strB + " Mcc: " + strG + " Mnc: " + strH);
        if (aVar != null) {
            aVar.d(z.a().d("countryCode", strB).d("mcc", strG).d("mnc", strH).d("source", str2).e());
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0051 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x0053 A[Catch: all -> 0x004b, TRY_LEAVE, TryCatch #0 {all -> 0x004b, blocks: (B:4:0x0004, B:6:0x000a, B:9:0x0015, B:12:0x001d, B:15:0x004d, B:17:0x0053), top: B:22:0x0004 }] */
    @zb.a
    @zb.e(ExecutorType.IO)
    public void getMiniappResumedStatus(@cc.f(App.class) App app, @cc.c bc.a aVar) {
        if (app != null) {
            try {
                if (app.getAppContext() != null && app.getAppContext().getContext() != null) {
                    ua.f appLifecycleCallback = app.getAppLifecycleCallback();
                    if (appLifecycleCallback == null) {
                        aVar.b();
                    } else if (aVar != null) {
                        boolean zB = appLifecycleCallback.B();
                        TmcLogger.c("GetSystemInfoBridge", "isResumed -> " + zB);
                        aVar.d(z.a().b("isResumed", Boolean.valueOf(zB)).e());
                    }
                } else if (aVar != null) {
                    aVar.b();
                }
            } catch (Throwable th2) {
                TmcLogger.h("GetSystemInfoBridge", th2);
                aVar.b();
            }
        } else if (aVar != null) {
            aVar.b();
        }
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public void getNewsOptionPopShow(@cc.f(App.class) App app, @cc.c bc.a aVar) {
        if (app == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        tb.b appContext = app.getAppContext();
        if (appContext == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        if (appContext.getContext() == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        com.cloud.tmc.integration.c cVar = com.cloud.tmc.integration.c.f30661a;
        boolean zB = cVar.b();
        TmcLogger.c("GetSystemInfoBridge", "getNewsOptionPopShow:" + zB);
        String strC = cVar.c();
        TmcLogger.c("GetSystemInfoBridge", "getSelectLanguage:" + strC);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("isShow", Boolean.valueOf(zB));
        jsonObject.addProperty("selectLanguage", strC);
        if (aVar != null) {
            aVar.d(jsonObject);
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0027 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:13:0x0029 A[Catch: all -> 0x0025, TRY_LEAVE, TryCatch #0 {all -> 0x0025, blocks: (B:3:0x0002, B:5:0x0008, B:8:0x0013, B:10:0x0021, B:13:0x0029), top: B:19:0x0002 }] */
    @zb.a
    @zb.e(ExecutorType.IO)
    public void getOdId(@cc.f(App.class) App app, @cc.c bc.a aVar) {
        if (app != null) {
            try {
                if (app.getAppContext() != null && app.getAppContext().getContext() != null) {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("odId", "");
                    if (aVar != null) {
                        aVar.d(jsonObject);
                    }
                } else if (aVar != null) {
                    aVar.b();
                }
            } catch (Throwable unused) {
                if (aVar != null) {
                    aVar.b();
                }
            }
        } else if (aVar != null) {
            aVar.b();
        }
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public void getOneId(@cc.f(App.class) App app, @cc.c bc.a aVar) {
        if (app == null || app.getAppContext() == null || app.getAppContext().getContext() == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        String string = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(app.getAppContext().getContext(), "miniLauncherGlobal", "athenaVaid");
        if (TextUtils.isEmpty(string)) {
            if (aVar != null) {
                aVar.b();
            }
        } else {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("oneId", string);
            if (aVar != null) {
                aVar.d(jsonObject);
            }
        }
    }

    @zb.a
    @zb.e(ExecutorType.NORMAL)
    public void getSdCardDownloadPath(@cc.c bc.a aVar) {
        String strD = com.cloud.tmc.miniutils.util.r.d();
        TmcLogger.c("GetSystemInfoBridge", "getSdCardDownloadPath: " + strD);
        if (aVar != null) {
            aVar.d(z.a().d("sdCardPath", strD).e());
        }
    }

    @zb.a
    @zb.e(ExecutorType.NORMAL)
    public void getSdCardPath(@cc.c bc.a aVar) {
        String strE = com.cloud.tmc.miniutils.util.r.e();
        TmcLogger.c("GetSystemInfoBridge", "getSdCardPath: " + strE);
        if (aVar != null) {
            aVar.d(z.a().d("sdCardPath", strE).e());
        }
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public void getSelectLanguage(@cc.f(App.class) App app, @cc.c bc.a aVar) {
        if (app == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        tb.b appContext = app.getAppContext();
        if (appContext == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        if (appContext.getContext() == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        String strC = com.cloud.tmc.integration.c.f30661a.c();
        TmcLogger.c("GetSystemInfoBridge", "from selectLanguage:" + strC);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("selectLanguage", strC);
        if (aVar != null) {
            aVar.d(jsonObject);
        }
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public void getSharpNewsCommonData(@cc.f(App.class) App app, @cc.g({"syncKey"}) String str, @cc.c bc.a aVar) {
        try {
            if (app == null) {
                if (aVar != null) {
                    aVar.b();
                    return;
                }
                return;
            }
            tb.b appContext = app.getAppContext();
            if (appContext == null) {
                if (aVar != null) {
                    aVar.b();
                    return;
                }
                return;
            }
            Context context = appContext.getContext();
            if (context == null) {
                if (aVar != null) {
                    aVar.b();
                    return;
                }
                return;
            }
            JsonObject jsonObjectE = z.a().d("syncData", ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(context, "snSyncDataWebStorage", str)).e();
            TmcLogger.c("GetSystemInfoBridge", "getSharpNewsSyncData" + jsonObjectE.toString());
            if (aVar != null) {
                aVar.d(jsonObjectE);
            }
        } catch (Throwable th2) {
            TmcLogger.g("GetSystemInfoBridge", "getSharpNewsSyncData error", th2);
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public void getSharpNewsConfigToH5(@cc.f(App.class) App app, @cc.c bc.a aVar) {
        if (app == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        tb.b appContext = app.getAppContext();
        if (appContext == null) {
            if (aVar != null) {
                aVar.b();
            }
        } else if (appContext.getContext() == null) {
            if (aVar != null) {
                aVar.b();
            }
        } else {
            boolean zB = MiniAppConfigHelper.f30370a.b("enableSharpNewsVideo", true);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(MBridgeConstans.NATIVE_VIDEO_SUPPORT, Boolean.valueOf(zB));
            if (aVar != null) {
                aVar.d(jsonObject);
            }
        }
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public void getSystemInfo(@cc.f(App.class) App app, @cc.f(Page.class) Page page, @cc.c bc.a aVar, @cc.g(booleanDefault = true, value = {"needCache"}) boolean z11) {
        TmcLogger.c("GetSystemInfoBridge", "getSystemInfo");
        if (app == null || app.getAppContext() == null || app.getAppContext().getContext() == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        JsonObject jsonObjectD = d(app.getAppContext().getContext(), app, page);
        TmcLogger.f("GetSystemInfoBridge", "getSystemInfo  " + com.cloud.tmc.miniutils.util.k.j(jsonObjectD));
        if (aVar != null) {
            aVar.d(jsonObjectD);
        }
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public void getSystemInfoAsync(@cc.f(App.class) App app, @cc.f(Page.class) Page page, @cc.c bc.a aVar, @cc.g(booleanDefault = true, value = {"needCache"}) boolean z11) {
        getSystemInfo(app, page, aVar, z11);
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public void getUniqueId(@cc.f(App.class) App app, @cc.c final bc.a aVar) {
        if (app != null) {
            try {
                if (app.getAppContext() != null && app.getAppContext().getContext() != null) {
                    String strD = com.cloud.tmc.integration.utils.q.d();
                    if (!TextUtils.isEmpty(strD)) {
                        MiniRequestUtils.a(strD, app.getAppId(), new mb.c<UniqueIdBean>() { // from class: com.cloud.tmc.integration.bridge.GetSystemInfoBridge.1
                            @Override // mb.c
                            @NonNull
                            public Type d() {
                                return new TypeToken<BaseResponse<UniqueIdBean>>() { // from class: com.cloud.tmc.integration.bridge.GetSystemInfoBridge.1.1
                                }.getType();
                            }

                            @Override // mb.c
                            public void e(@NonNull BaseResponse<?> baseResponse, @Nullable Map<String, String> map) {
                                bc.a aVar2 = aVar;
                                if (aVar2 != null) {
                                    aVar2.b();
                                }
                            }

                            @Override // mb.c
                            public void g(@NonNull BaseResponse<? extends UniqueIdBean> baseResponse, @Nullable Map<String, String> map) {
                                String uniqueId = baseResponse.getData().getUniqueId();
                                if (TextUtils.isEmpty(uniqueId)) {
                                    bc.a aVar2 = aVar;
                                    if (aVar2 != null) {
                                        aVar2.b();
                                        return;
                                    }
                                    return;
                                }
                                JsonObject jsonObject = new JsonObject();
                                jsonObject.addProperty("uniqueId", uniqueId);
                                TmcLogger.f("GetSystemInfoBridge", "bridiegAPI getUniqueId success: " + uniqueId);
                                bc.a aVar3 = aVar;
                                if (aVar3 != null) {
                                    aVar3.d(jsonObject);
                                }
                            }
                        });
                        return;
                    }
                    TmcLogger.f("GetSystemInfoBridge", "bridiegAPI getUniqueId fail: gaid is empty");
                    if (aVar != null) {
                        aVar.b();
                        return;
                    }
                    return;
                }
            } catch (Throwable unused) {
                if (aVar != null) {
                    aVar.b();
                    return;
                }
                return;
            }
        }
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, dd.e
    public dd.f permit() {
        return null;
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public void putNewsOptionPopShow(@cc.f(App.class) App app, @cc.g(booleanDefault = true, value = {"showStatus"}) boolean z11, @cc.c bc.a aVar) {
        if (app == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        tb.b appContext = app.getAppContext();
        if (appContext == null) {
            if (aVar != null) {
                aVar.b();
            }
        } else {
            if (appContext.getContext() == null) {
                if (aVar != null) {
                    aVar.b();
                    return;
                }
                return;
            }
            com.cloud.tmc.integration.c.f30661a.d(z11);
            TmcLogger.c("GetSystemInfoBridge", "putNewsOptionPopShow:" + z11);
            JsonObject jsonObject = new JsonObject();
            if (aVar != null) {
                aVar.d(jsonObject);
            }
        }
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public void putSelectLanguage(@cc.f(App.class) App app, @cc.g(stringDefault = "", value = {"selectLanguage"}) String str, @cc.c bc.a aVar) {
        if (app == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        tb.b appContext = app.getAppContext();
        if (appContext == null) {
            if (aVar != null) {
                aVar.b();
            }
        } else {
            if (appContext.getContext() == null) {
                if (aVar != null) {
                    aVar.b();
                    return;
                }
                return;
            }
            com.cloud.tmc.integration.c.f30661a.e(str);
            TmcLogger.c("GetSystemInfoBridge", "from putSelectLanguage:" + str);
            JsonObject jsonObject = new JsonObject();
            if (aVar != null) {
                aVar.d(jsonObject);
            }
        }
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public void removeSharpNewsCommonData(@cc.f(App.class) App app, @cc.g({"syncKey"}) String str, @cc.c bc.a aVar) {
        try {
            if (app == null) {
                if (aVar != null) {
                    aVar.b();
                    return;
                }
                return;
            }
            tb.b appContext = app.getAppContext();
            if (appContext == null) {
                if (aVar != null) {
                    aVar.b();
                    return;
                }
                return;
            }
            Context context = appContext.getContext();
            if (context == null) {
                if (aVar != null) {
                    aVar.b();
                    return;
                }
                return;
            }
            TmcLogger.c("GetSystemInfoBridge", "removeSharpNewsSyncDatakey:-> " + str);
            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).remove(context, "snSyncDataWebStorage", str);
            if (aVar != null) {
                aVar.g();
            }
        } catch (Throwable th2) {
            TmcLogger.g("GetSystemInfoBridge", "removeSharpNewsSyncData error", th2);
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    @zb.a
    @zb.e(ExecutorType.IO)
    public void updateSharpNewsCommonData(@cc.f(App.class) App app, @cc.g({"syncKey"}) String str, @cc.g({"syncData"}) String str2, @cc.c bc.a aVar) {
        try {
            if (app == null) {
                if (aVar != null) {
                    aVar.b();
                    return;
                }
                return;
            }
            tb.b appContext = app.getAppContext();
            if (appContext == null) {
                if (aVar != null) {
                    aVar.b();
                    return;
                }
                return;
            }
            Context context = appContext.getContext();
            if (context == null) {
                if (aVar != null) {
                    aVar.b();
                    return;
                }
                return;
            }
            TmcLogger.c("GetSystemInfoBridge", "updateSharpNewsSyncDatakey:-> " + str + "syncData:-> " + str2);
            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putString(context, "snSyncDataWebStorage", str, str2);
            if (aVar != null) {
                aVar.g();
            }
        } catch (Throwable th2) {
            TmcLogger.g("GetSystemInfoBridge", "updateSharpNewsSyncData error", th2);
            if (aVar != null) {
                aVar.b();
            }
        }
    }
}
