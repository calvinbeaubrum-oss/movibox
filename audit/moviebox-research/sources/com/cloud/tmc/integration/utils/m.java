package com.cloud.tmc.integration.utils;

import android.content.Context;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.model.ConfigCdnBean;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.network.INetWorkProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cookie;

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
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f31071a = new m();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f31072b = "CloudConfigUtils";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Boolean> f31073c = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f31074d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f31075e;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements wc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f31076a;

        public a(Context context) {
            this.f31076a = context;
        }

        @Override // wc.b
        public void a(int i11, String str, Map<String, String> map, List<Cookie> list, String str2) {
            try {
                m mVar = m.f31071a;
                TmcLogger.c(mVar.g(), "getMyByteAppRecommendList onSuccess: " + str);
                if (str != null && str.length() != 0) {
                    ConfigCdnBean configCdnBean = (ConfigCdnBean) com.cloud.tmc.miniutils.util.k.d(str, ConfigCdnBean.class);
                    String s11 = configCdnBean.getS();
                    String str3 = "";
                    if (s11 == null) {
                        s11 = "";
                    }
                    boolean z11 = Intrinsics.b(s11, "0") || !Intrinsics.b(s11, "1");
                    String a11 = configCdnBean.getA();
                    if (a11 != null) {
                        str3 = a11;
                    }
                    mVar.j(this.f31076a, z11, !Intrinsics.b(str3, "0") && Intrinsics.b(str3, "1"));
                    ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putLong(this.f31076a, "miniLauncherGlobal", "laterestRequestCdnTime", System.currentTimeMillis());
                    m.f31075e = false;
                }
            } catch (Throwable th2) {
                m.f31075e = false;
                TmcLogger.c(m.f31071a.g(), "getCloudConfig error " + th2);
            }
        }

        @Override // wc.b
        public void b(String str, String str2, String str3) {
            m.f31075e = false;
            if (MiniAppConfigHelper.f30370a.b("cdnConfigsuccess", false)) {
                return;
            }
            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putLong(this.f31076a, "miniLauncherGlobal", "laterestRequestCdnTime", System.currentTimeMillis());
        }
    }

    public final boolean c(Context context) {
        try {
            h(context);
            return ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getBoolean(context, "miniLauncherGlobal", "enableRequestConfig", true);
        } catch (Throwable th2) {
            TmcLogger.g(f31072b, "checkAllowCloudConfigRequest", th2);
            return true;
        }
    }

    public final boolean d(Context context, String str) {
        try {
            f31074d = MiniAppConfigHelper.f30370a.d("ccrInterval", 43200000L);
            long j11 = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getLong(context, "miniLauncherGlobal", "latestRequestTime_" + str);
            if (System.currentTimeMillis() - j11 >= f31074d) {
                TmcLogger.c(f31072b, "cloud config request interval is over,latestReuestTime->" + j11 + ",cloudConfigRequestInterval->" + f31074d);
                return true;
            }
            TmcLogger.c(f31072b, "cloud config request interval is not over,currentTime->" + System.currentTimeMillis() + ",latestReuestTime->" + j11 + ",cloudConfigRequestInterval->" + f31074d);
            return false;
        } catch (Throwable th2) {
            TmcLogger.g(f31072b, "checkCloudConfigRequestInterval error", th2);
            return true;
        }
    }

    public final boolean e(Context context, String str, Function1<? super Boolean, Unit> function1) {
        Intrinsics.g(context, "context");
        if (str != null) {
            try {
                if (str.length() == 0) {
                    str = "defaultKey";
                }
            } catch (Throwable th2) {
                TmcLogger.g(f31072b, "checkEnableConfigRequest", th2);
                return true;
            }
        } else {
            str = "defaultKey";
        }
        ConcurrentHashMap<String, Boolean> concurrentHashMap = f31073c;
        Boolean bool = concurrentHashMap.get(str);
        if (bool == null) {
            bool = Boolean.FALSE;
        }
        if (bool.booleanValue()) {
            TmcLogger.c(f31072b, "cloud config request is requesting, key: " + str);
            if (function1 != null) {
                function1.invoke(Boolean.TRUE);
            }
            return false;
        }
        Boolean bool2 = Boolean.TRUE;
        concurrentHashMap.put(str, bool2);
        if (!c(context)) {
            TmcLogger.c(f31072b, "cloud config request is not enable");
            concurrentHashMap.put(str, Boolean.FALSE);
            if (function1 != null) {
                function1.invoke(bool2);
            }
            return false;
        }
        if (d(context, str)) {
            return true;
        }
        concurrentHashMap.put(str, Boolean.FALSE);
        if (function1 != null) {
            function1.invoke(bool2);
        }
        return false;
    }

    public final boolean f(Context context) {
        try {
            return ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getBoolean(context, "miniLauncherGlobal", "requestIntervalBySuccess", true);
        } catch (Throwable th2) {
            TmcLogger.g(f31072b, "updateCloudConfigStatus", th2);
            return false;
        }
    }

    public final String g() {
        return f31072b;
    }

    public final void h(Context context) {
        if (f31075e) {
            TmcLogger.c(f31072b, "updateCdnConfig isRequesting->" + f31075e);
            return;
        }
        f31075e = true;
        if (System.currentTimeMillis() - ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getLong(context, "miniLauncherGlobal", "laterestRequestCdnTime") >= MiniAppConfigHelper.f30370a.d("cdnrInterval", 43200000L)) {
            ((INetWorkProxy) tc.a.a(INetWorkProxy.class)).get("https://cloud-config-oss.shalltry.com/cloudconfig/config/onoff/miniapp_cloudconfig_onoff.json", new LinkedHashMap(), new LinkedHashMap(), Boolean.FALSE, new a(context));
            return;
        }
        TmcLogger.c(f31072b, "updateCdnConfig isRequesting->" + f31075e);
        f31075e = false;
    }

    public final void i(Context context, String requestKey, boolean z11) {
        Intrinsics.g(context, "context");
        Intrinsics.g(requestKey, "requestKey");
        try {
            f31073c.put(requestKey, Boolean.FALSE);
            if (!z11 && !f(context)) {
                return;
            }
            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putLong(context, "miniLauncherGlobal", "latestRequestTime_" + requestKey, System.currentTimeMillis());
            TmcLogger.c(f31072b, "updateCloudConfigRequestStatus requestKey: " + requestKey);
        } catch (Throwable th2) {
            TmcLogger.g(f31072b, "updateCloudConfigRequestStatus error: ", th2);
        }
    }

    public final void j(Context context, boolean z11, boolean z12) {
        try {
            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putBoolean(context, "miniLauncherGlobal", "enableRequestConfig", z11);
        } catch (Throwable th2) {
            TmcLogger.g(f31072b, "updateCloudConfigStatus", th2);
        }
        try {
            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putBoolean(context, "miniLauncherGlobal", "requestIntervalBySuccess", z12);
        } catch (Throwable th3) {
            TmcLogger.g(f31072b, "updateCloudConfigStatus", th3);
        }
    }
}
