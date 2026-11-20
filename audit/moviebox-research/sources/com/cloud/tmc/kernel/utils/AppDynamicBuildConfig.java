package com.cloud.tmc.kernel.utils;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.cloud.tmc.kernel.constants.SdkBuildVariantType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.network.IChangeUrlProxy;
import com.cloud.tmc.miniutils.util.e0;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class AppDynamicBuildConfig {
    public static final Lazy A;
    public static final Lazy B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppDynamicBuildConfig f31242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Bundle f31243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f31244c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f31245d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final boolean f31246e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f31247f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f31248g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final boolean f31249h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f31250i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Lazy f31251j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Lazy f31252k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Lazy f31253l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Lazy f31254m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Lazy f31255n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Lazy f31256o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Lazy f31257p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Lazy f31258q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Lazy f31259r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Lazy f31260s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f31261t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Lazy f31262u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Lazy f31263v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Lazy f31264w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Lazy f31265x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Lazy f31266y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final Lazy f31267z;

    static {
        ApplicationInfo applicationInfo;
        ApplicationInfo applicationInfo2;
        AppDynamicBuildConfig appDynamicBuildConfig = new AppDynamicBuildConfig();
        f31242a = appDynamicBuildConfig;
        try {
            Application applicationB = appDynamicBuildConfig.b();
            if (applicationB != null) {
                PackageManager packageManager = applicationB.getPackageManager();
                f31243b = (packageManager == null || (applicationInfo2 = packageManager.getApplicationInfo(applicationB.getPackageName(), 128)) == null) ? null : applicationInfo2.metaData;
            }
        } catch (Throwable th2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("not found ");
            Application applicationB2 = f31242a.b();
            sb2.append(applicationB2 != null ? applicationB2.getPackageName() : null);
            TmcLogger.g("TmcKernel:AppDynamicBuildConfig", sb2.toString(), th2);
        }
        Application applicationB3 = f31242a.b();
        f31244c = !((applicationB3 == null || (applicationInfo = applicationB3.getApplicationInfo()) == null || (applicationInfo.flags & 2) != 0) ? false : true);
        Bundle bundle = f31243b;
        Object obj = bundle != null ? bundle.get("miniProcess") : null;
        String str = obj instanceof String ? (String) obj : null;
        if (str == null) {
            str = ":mini";
        }
        f31245d = str;
        Bundle bundle2 = f31243b;
        Object obj2 = bundle2 != null ? bundle2.get("layerHardware") : null;
        Boolean bool = obj2 instanceof Boolean ? (Boolean) obj2 : null;
        f31246e = bool != null ? bool.booleanValue() : false;
        Bundle bundle3 = f31243b;
        Object obj3 = bundle3 != null ? bundle3.get("WORKER_TYPE") : null;
        String str2 = obj3 instanceof String ? (String) obj3 : null;
        if (str2 == null) {
            str2 = "webview";
        }
        f31247f = str2;
        Bundle bundle4 = f31243b;
        Object obj4 = bundle4 != null ? bundle4.get("DEV") : null;
        Boolean bool2 = obj4 instanceof Boolean ? (Boolean) obj4 : null;
        f31248g = bool2 != null ? bool2.booleanValue() : false;
        Bundle bundle5 = f31243b;
        Object obj5 = bundle5 != null ? bundle5.get("TCTP") : null;
        Boolean bool3 = obj5 instanceof Boolean ? (Boolean) obj5 : null;
        f31249h = bool3 != null ? bool3.booleanValue() : false;
        Bundle bundle6 = f31243b;
        Object obj6 = bundle6 != null ? bundle6.get("SDK_BUILD_VARIANT_TYPE") : null;
        String type = obj6 instanceof String ? (String) obj6 : null;
        if (type == null) {
            type = SdkBuildVariantType.ONLINE.getType();
        }
        f31250i = type;
        f31251j = LazyKt__LazyJVMKt.b(new Function0<String>() { // from class: com.cloud.tmc.kernel.utils.AppDynamicBuildConfig$CONFIG_BASE_API_HOST$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Object objI = AppDynamicBuildConfig.f31242a.i("MINI_CONFIG_BASE_API_HOST");
                String str3 = objI instanceof String ? (String) objI : null;
                return str3 == null ? "" : str3;
            }
        });
        f31252k = LazyKt__LazyJVMKt.b(new Function0<String>() { // from class: com.cloud.tmc.kernel.utils.AppDynamicBuildConfig$CONFIG_BASE_URL$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Object objI = AppDynamicBuildConfig.f31242a.i("MINI_CONFIG_BASE_URL");
                String str3 = objI instanceof String ? (String) objI : null;
                return str3 == null ? "" : str3;
            }
        });
        f31253l = LazyKt__LazyJVMKt.b(new Function0<String>() { // from class: com.cloud.tmc.kernel.utils.AppDynamicBuildConfig$MINI_APP_BASE_URL$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Object objI = AppDynamicBuildConfig.f31242a.i("MINI_APP_BASE_URL");
                String str3 = objI instanceof String ? (String) objI : null;
                return str3 == null ? "" : str3;
            }
        });
        f31254m = LazyKt__LazyJVMKt.b(new Function0<String>() { // from class: com.cloud.tmc.kernel.utils.AppDynamicBuildConfig$MINI_APP_HOST_URL$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Object objI = AppDynamicBuildConfig.f31242a.i("MINI_APP_HOST_URL");
                String str3 = objI instanceof String ? (String) objI : null;
                return str3 == null ? "" : str3;
            }
        });
        f31255n = LazyKt__LazyJVMKt.b(new Function0<String>() { // from class: com.cloud.tmc.kernel.utils.AppDynamicBuildConfig$BASE_V8_URL$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Object objI = AppDynamicBuildConfig.f31242a.i("MINI_BASE_V8_URL");
                String str3 = objI instanceof String ? (String) objI : null;
                return str3 == null ? "" : str3;
            }
        });
        f31256o = LazyKt__LazyJVMKt.b(new Function0<String>() { // from class: com.cloud.tmc.kernel.utils.AppDynamicBuildConfig$BASE_LOGIN_API_HOST$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Object objI = AppDynamicBuildConfig.f31242a.i("MINI_BASE_LOGIN_API_HOST");
                String str3 = objI instanceof String ? (String) objI : null;
                return str3 == null ? "" : str3;
            }
        });
        f31257p = LazyKt__LazyJVMKt.b(new Function0<String>() { // from class: com.cloud.tmc.kernel.utils.AppDynamicBuildConfig$BASE_LOGIN_API_URL$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Object objI = AppDynamicBuildConfig.f31242a.i("MINI_BASE_LOGIN_API_URL");
                String str3 = objI instanceof String ? (String) objI : null;
                return str3 == null ? "" : str3;
            }
        });
        f31258q = LazyKt__LazyJVMKt.b(new Function0<String>() { // from class: com.cloud.tmc.kernel.utils.AppDynamicBuildConfig$BASE_UPLOAD_URL$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Object objI = AppDynamicBuildConfig.f31242a.i("MINI_BASE_UPLOAD_URL");
                String str3 = objI instanceof String ? (String) objI : null;
                return str3 == null ? "" : str3;
            }
        });
        f31259r = LazyKt__LazyJVMKt.b(new Function0<String>() { // from class: com.cloud.tmc.kernel.utils.AppDynamicBuildConfig$BASE_OSS_URL$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Object objI = AppDynamicBuildConfig.f31242a.i("MINI_BASE_OSS_URL");
                String str3 = objI instanceof String ? (String) objI : null;
                return str3 == null ? "" : str3;
            }
        });
        f31260s = LazyKt__LazyJVMKt.b(new Function0<String>() { // from class: com.cloud.tmc.kernel.utils.AppDynamicBuildConfig$MINI_CDN_URL$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Object objI = AppDynamicBuildConfig.f31242a.i("MINI_CDN_URL");
                String str3 = objI instanceof String ? (String) objI : null;
                return str3 == null ? "" : str3;
            }
        });
        Bundle bundle7 = f31243b;
        Object obj7 = bundle7 != null ? bundle7.get("AD_SUBMIT_FORM") : null;
        String str3 = obj7 instanceof String ? (String) obj7 : null;
        if (str3 == null) {
            str3 = "";
        }
        f31261t = str3;
        f31262u = LazyKt__LazyJVMKt.b(new Function0<Boolean>() { // from class: com.cloud.tmc.kernel.utils.AppDynamicBuildConfig$DEV_MODE$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                Object objI = AppDynamicBuildConfig.f31242a.i("DEV_MODE");
                Boolean bool4 = objI instanceof Boolean ? (Boolean) objI : null;
                return Boolean.valueOf(bool4 != null ? bool4.booleanValue() : false);
            }
        });
        f31263v = LazyKt__LazyJVMKt.b(new Function0<String>() { // from class: com.cloud.tmc.kernel.utils.AppDynamicBuildConfig$MINI_API_WORK_MODE$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Object objI = AppDynamicBuildConfig.f31242a.i("MINI_API_WORK_MODE");
                String str4 = objI instanceof String ? (String) objI : null;
                return str4 == null ? "" : str4;
            }
        });
        f31264w = LazyKt__LazyJVMKt.b(new Function0<String>() { // from class: com.cloud.tmc.kernel.utils.AppDynamicBuildConfig$SDK_VERSION$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Object objI = AppDynamicBuildConfig.f31242a.i("SDK_VERSION");
                String str4 = objI instanceof String ? (String) objI : null;
                return str4 == null ? "9.3.2-mb" : str4;
            }
        });
        f31265x = LazyKt__LazyJVMKt.b(new Function0<String>() { // from class: com.cloud.tmc.kernel.utils.AppDynamicBuildConfig$MINI_APP_STATIC_URL$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Object objI = AppDynamicBuildConfig.f31242a.i("MINI_APP_STATIC_URL");
                String str4 = objI instanceof String ? (String) objI : null;
                return str4 == null ? "" : str4;
            }
        });
        f31266y = LazyKt__LazyJVMKt.b(new Function0<String>() { // from class: com.cloud.tmc.kernel.utils.AppDynamicBuildConfig$OFFLINE_DOWNLOAD_MODE$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Object objI = AppDynamicBuildConfig.f31242a.i("OFFLINE_DOWNLOAD_MODE");
                String str4 = objI instanceof String ? (String) objI : null;
                return str4 == null ? androidx.browser.customtabs.c.ONLINE_EXTRAS_KEY : str4;
            }
        });
        f31267z = LazyKt__LazyJVMKt.b(new Function0<String>() { // from class: com.cloud.tmc.kernel.utils.AppDynamicBuildConfig$MINI_APPINFO_CDN_URL$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Object objI = AppDynamicBuildConfig.f31242a.i("MINI_APPINFO_CDN_URL");
                String str4 = objI instanceof String ? (String) objI : null;
                return str4 == null ? "9.3.2-mb" : str4;
            }
        });
        A = LazyKt__LazyJVMKt.b(new Function0<Boolean>() { // from class: com.cloud.tmc.kernel.utils.AppDynamicBuildConfig$CONFIG_DEV_MODE$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                Object objI = AppDynamicBuildConfig.f31242a.i("CONFIG_DEV_MODE");
                Boolean bool4 = objI instanceof Boolean ? (Boolean) objI : null;
                return Boolean.valueOf(bool4 != null ? bool4.booleanValue() : false);
            }
        });
        B = LazyKt__LazyJVMKt.b(new Function0<String>() { // from class: com.cloud.tmc.kernel.utils.AppDynamicBuildConfig$SDK_VERSION_NUM$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "90302";
            }
        });
    }

    public static final String c() {
        return (String) f31259r.getValue();
    }

    public static final String d() {
        return f31261t;
    }

    public static final String e() {
        return (String) f31258q.getValue();
    }

    public static final String f() {
        return (String) f31255n.getValue();
    }

    public static final String g() {
        return (String) f31252k.getValue();
    }

    public static final boolean h() {
        return ((Boolean) A.getValue()).booleanValue();
    }

    public static final boolean j() {
        return f31248g;
    }

    public static final boolean k() {
        return ((Boolean) f31262u.getValue()).booleanValue();
    }

    public static final String l() {
        return (String) f31263v.getValue();
    }

    public static final String m() {
        return (String) f31267z.getValue();
    }

    public static final String n() {
        return (String) f31253l.getValue();
    }

    public static final String o() {
        return (String) f31265x.getValue();
    }

    public static final String p() {
        return (String) f31260s.getValue();
    }

    public static final String q() {
        return (String) f31266y.getValue();
    }

    public static final String r() {
        return f31250i;
    }

    public static final String s() {
        return (String) f31264w.getValue();
    }

    public static final String t() {
        return (String) B.getValue();
    }

    public static final boolean u() {
        return f31249h;
    }

    public static final boolean v() {
        return f31244c;
    }

    public final Application b() {
        try {
            return e0.a();
        } catch (Throwable th2) {
            TmcLogger.h("TmcKernel:AppDynamicBuildConfig", th2);
            return null;
        }
    }

    public final Object i(String str) {
        return ((IChangeUrlProxy) tc.a.a(IChangeUrlProxy.class)).getConfigValue(f31243b, str);
    }
}
