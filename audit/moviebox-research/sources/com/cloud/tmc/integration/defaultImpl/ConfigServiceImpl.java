package com.cloud.tmc.integration.defaultImpl;

import android.content.Context;
import com.cloud.tmc.fps.data.ConfigData;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.defaultImpl.ConfigServiceImpl;
import com.cloud.tmc.integration.model.AppInfoModel;
import com.cloud.tmc.integration.model.LogEBean;
import com.cloud.tmc.integration.model.MiniAppInfoConfigBean;
import com.cloud.tmc.integration.model.WhiteScreen;
import com.cloud.tmc.integration.performanceanalyse.screen.IScreenInspectProxy;
import com.cloud.tmc.integration.utils.m;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.performanceanalyse.LogEProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.service.ConfigService;
import com.cloud.tmc.kernel.utils.e;
import com.cloud.tmc.kernel.utils.o;
import com.cloud.tmc.miniutils.util.k;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.tmc.network.NetworkConfig;
import j9.s;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.HttpUrl;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@SourceDebugExtension
public final class ConfigServiceImpl implements ConfigService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f30688a = "ConfigServiceImpl";

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f30689a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f30690b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function1<Boolean, Unit> f30691c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ConfigServiceImpl f30692d;

        /* JADX WARN: Multi-variable type inference failed */
        public a(String str, Context context, Function1<? super Boolean, Unit> function1, ConfigServiceImpl configServiceImpl) {
            this.f30690b = context;
            this.f30691c = function1;
            this.f30692d = configServiceImpl;
            this.f30689a = (str == null || str.length() == 0) ? "defaultKey" : str;
        }

        @Override // j9.s
        public void a(int i11, String message) {
            Intrinsics.g(message, "message");
            m.f31071a.i(this.f30690b, this.f30689a, false);
            Function1<Boolean, Unit> function1 = this.f30691c;
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
            }
        }

        @Override // j9.s
        public void b() {
            m.f31071a.i(this.f30690b, this.f30689a, true);
            boolean configBoolean = this.f30692d.getConfigBoolean("closeMiniAppSDK", false);
            TmcLogger.f(this.f30692d.f30688a, "loadPreService closeSDK = " + configBoolean);
            Function1<Boolean, Unit> function1 = this.f30691c;
            if (function1 != null) {
                function1.invoke(Boolean.TRUE);
            }
            this.f30692d.f(this.f30690b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f30693a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f30694b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function1<Boolean, Unit> f30695c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ConfigServiceImpl f30696d;

        /* JADX WARN: Multi-variable type inference failed */
        public b(String str, Context context, Function1<? super Boolean, Unit> function1, ConfigServiceImpl configServiceImpl) {
            this.f30694b = context;
            this.f30695c = function1;
            this.f30696d = configServiceImpl;
            this.f30693a = (str == null || str.length() == 0) ? "defaultKey" : str;
        }

        @Override // j9.s
        public void a(int i11, String message) {
            Intrinsics.g(message, "message");
            m.f31071a.i(this.f30694b, this.f30693a, false);
            Function1<Boolean, Unit> function1 = this.f30695c;
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
            }
        }

        @Override // j9.s
        public void b() {
            m.f31071a.i(this.f30694b, this.f30693a, true);
            MiniAppConfigHelper miniAppConfigHelper = MiniAppConfigHelper.f30370a;
            String strE = miniAppConfigHelper.e("whiteScreen", "{\"grayScale\": 0,\"checkNowDelay\": 1000,\"checkIntervalArray\": [5, 10, 15, 20]}");
            String strE2 = miniAppConfigHelper.e("fps", "{\"grayScale\": 0,\"jankThreshold\": 200,\"traceInterval\": 50}");
            try {
                WhiteScreen whiteScreen = (WhiteScreen) new Gson().fromJson(strE, WhiteScreen.class);
                ((IScreenInspectProxy) tc.a.a(IScreenInspectProxy.class)).initConfig(whiteScreen.getGrayScale(), Long.valueOf(whiteScreen.getCheckNowDelay()), whiteScreen.getCheckIntervalArray());
                com.cloud.tmc.fps.b bVar = com.cloud.tmc.fps.b.f30367a;
                Object objFromJson = new Gson().fromJson(strE2, (Class<Object>) ConfigData.class);
                Intrinsics.f(objFromJson, "Gson().fromJson(\n       …                        )");
                bVar.b((ConfigData) objFromJson);
            } catch (Exception e11) {
                TmcLogger.e(e11.getMessage());
            }
            MiniAppConfigHelper miniAppConfigHelper2 = MiniAppConfigHelper.f30370a;
            ((LogEProxy) tc.a.a(LogEProxy.class)).saveConfig(((LogEBean) new Gson().fromJson(miniAppConfigHelper2.e("logEReport", "{\"grayScale\": 0}"), LogEBean.class)).getGrayScale());
            TmcLogger.f("ConfigService", "loadService closeSDK = " + this.f30696d.getConfigBoolean("closeMiniAppSDK", false));
            Function1<Boolean, Unit> function1 = this.f30695c;
            if (function1 != null) {
                function1.invoke(Boolean.TRUE);
            }
            int iC = miniAppConfigHelper2.c("networkImproveNumV2", 0);
            int i11 = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getInt(this.f30694b, "miniLauncherGlobal", "network_improve_key");
            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putInt(this.f30694b, "miniLauncherGlobal", "network_improve_key", iC);
            if (i11 != iC) {
                NetworkConfig.INSTANCE.setNetworkImproveEnable(System.currentTimeMillis() % ((long) 10) < ((long) iC));
            }
            this.f30696d.f(this.f30694b);
        }
    }

    public static final void d(Context context, String str, Function1 function1, ConfigServiceImpl this$0) {
        Intrinsics.g(context, "$context");
        Intrinsics.g(this$0, "this$0");
        try {
            if (!m.f31071a.e(context, str, function1)) {
                TmcLogger.c(this$0.f30688a, "[loadPreService]:" + str + " -> Config is not enabled");
                return;
            }
            TmcLogger.c(this$0.f30688a, "[loadPreService]:" + str + " -> Config is enabled");
            MiniAppConfigHelper.f30370a.a(context).m(str, new a(str, context, function1, this$0));
        } catch (Throwable th2) {
            TmcLogger.g(this$0.f30688a, "[ConfigService]: Failed to loadPreService config ", th2);
        }
    }

    public static final void e(Context context, String str, Function1 function1, ConfigServiceImpl this$0) {
        Intrinsics.g(context, "$context");
        Intrinsics.g(this$0, "this$0");
        if (!m.f31071a.e(context, str, function1)) {
            TmcLogger.c(this$0.f30688a, "[loadService]: " + str + " ->Config is not enabled");
            return;
        }
        TmcLogger.c(this$0.f30688a, "[loadService]: " + str + " -> Config is enabled");
        try {
            MiniAppConfigHelper.f30370a.a(context).m(str, new b(str, context, function1, this$0));
        } catch (Throwable th2) {
            TmcLogger.g(this$0.f30688a, "[ConfigService]: Failed to loadPreService config ", th2);
        }
    }

    public static final void g(ConfigServiceImpl this$0, Context context) {
        String strA;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(context, "$context");
        try {
            Object objE = k.e(this$0.getConfigString("appInfoConfig", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI), new TypeToken<ArrayList<MiniAppInfoConfigBean>>() { // from class: com.cloud.tmc.integration.defaultImpl.ConfigServiceImpl$updateConfigAppinfo$1$list$1$1
            }.getType());
            List<MiniAppInfoConfigBean> arrayList = objE instanceof List ? (List) objE : null;
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            for (MiniAppInfoConfigBean miniAppInfoConfigBean : arrayList) {
                String appId = miniAppInfoConfigBean.getAppId();
                try {
                    AppInfoModel appInfo = miniAppInfoConfigBean.getAppInfo();
                    if (appInfo == null || (strA = o.a(appInfo)) == null) {
                        strA = "";
                    }
                } catch (Throwable th2) {
                    TmcLogger.g(this$0.f30688a, "loadPreService", th2);
                }
                if (appId != null) {
                    TmcLogger.c(this$0.f30688a, "appid->" + appId + ",appinfo->" + strA);
                    KVStorageProxy kVStorageProxy = (KVStorageProxy) tc.a.a(KVStorageProxy.class);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(appId);
                    sb2.append("_config");
                    kVStorageProxy.putString(context, appId, sb2.toString(), strA);
                }
            }
        } catch (Throwable th3) {
            TmcLogger.g(this$0.f30688a, "Failed to parse config", th3);
        }
    }

    @Override // com.cloud.tmc.kernel.service.ConfigService
    public void clearProcessCache() {
    }

    public final void f(final Context context) {
        try {
            e.a(ExecutorType.IO, new Runnable() { // from class: fb.c
                @Override // java.lang.Runnable
                public final void run() {
                    ConfigServiceImpl.g(this.f64758a, context);
                }
            });
        } catch (Throwable th2) {
            TmcLogger.g(this.f30688a, "updateConfigAppinfo", th2);
        }
    }

    @Override // com.cloud.tmc.kernel.service.ConfigService
    public String getConfig(String str, String str2) {
        return "";
    }

    @Override // com.cloud.tmc.kernel.service.ConfigService
    public <T> void getConfig(String key, String str, ConfigService.a aVar) {
        Intrinsics.g(key, "key");
    }

    @Override // com.cloud.tmc.kernel.service.ConfigService
    public boolean getConfigBoolean(String str, boolean z11) {
        return MiniAppConfigHelper.f30370a.b(str, z11);
    }

    @Override // com.cloud.tmc.kernel.service.ConfigService
    public int getConfigInt(String str, int i11) {
        return MiniAppConfigHelper.f30370a.c(str, i11);
    }

    @Override // com.cloud.tmc.kernel.service.ConfigService
    public JsonArray getConfigJsonArray(String key) {
        JsonElement string;
        Intrinsics.g(key, "key");
        String configString = getConfigString(key, "");
        try {
            if (configString.length() == 0 || (string = JsonParser.parseString(configString)) == null) {
                return null;
            }
            return string.getAsJsonArray();
        } catch (Throwable th2) {
            TmcLogger.g(this.f30688a, "[ConfigService]: Failed to parse config", th2);
            return null;
        }
    }

    @Override // com.cloud.tmc.kernel.service.ConfigService
    public JsonObject getConfigJsonObject(String key) {
        JsonElement string;
        Intrinsics.g(key, "key");
        String configString = getConfigString(key, "");
        try {
            if (configString.length() == 0 || (string = JsonParser.parseString(configString)) == null) {
                return null;
            }
            return string.getAsJsonObject();
        } catch (Throwable th2) {
            TmcLogger.g(this.f30688a, "[ConfigService]: Failed to parse config", th2);
            return null;
        }
    }

    @Override // com.cloud.tmc.kernel.service.ConfigService
    public String getConfigString(String key, String defaultValue) {
        Intrinsics.g(key, "key");
        Intrinsics.g(defaultValue, "defaultValue");
        return MiniAppConfigHelper.f30370a.e(key, defaultValue);
    }

    @Override // com.cloud.tmc.kernel.service.ConfigService
    public String getConfigWithProcessCache(String str, String str2) {
        return "";
    }

    @Override // com.cloud.tmc.kernel.service.ConfigService
    public void loadPreService(Context context) {
        Intrinsics.g(context, "context");
        loadPreService(context, "");
    }

    @Override // com.cloud.tmc.kernel.service.ConfigService
    public void loadPreService(Context context, String str) {
        Intrinsics.g(context, "context");
        loadPreService(context, str, null);
    }

    @Override // com.cloud.tmc.kernel.service.ConfigService
    public void loadPreService(final Context context, final String str, final Function1<? super Boolean, Unit> function1) {
        Intrinsics.g(context, "context");
        try {
            e.a(ExecutorType.IO, new Runnable() { // from class: fb.b
                @Override // java.lang.Runnable
                public final void run() {
                    ConfigServiceImpl.d(context, str, function1, this);
                }
            });
        } catch (Throwable th2) {
            TmcLogger.h(this.f30688a, th2);
        }
    }

    @Override // com.cloud.tmc.kernel.service.ConfigService
    public void loadService(Context context) {
        Intrinsics.g(context, "context");
        loadService(context, "");
    }

    @Override // com.cloud.tmc.kernel.service.ConfigService
    public void loadService(Context context, String str) {
        Intrinsics.g(context, "context");
        loadService(context, str, null);
    }

    @Override // com.cloud.tmc.kernel.service.ConfigService
    public void loadService(final Context context, final String str, final Function1<? super Boolean, Unit> function1) {
        Intrinsics.g(context, "context");
        try {
            e.a(ExecutorType.IO, new Runnable() { // from class: fb.a
                @Override // java.lang.Runnable
                public final void run() {
                    ConfigServiceImpl.e(context, str, function1, this);
                }
            });
        } catch (Throwable th2) {
            TmcLogger.g(this.f30688a, "loadService", th2);
        }
    }

    @Override // com.cloud.tmc.kernel.service.ConfigService
    public void putConfigCache(String str, String str2) {
    }
}
