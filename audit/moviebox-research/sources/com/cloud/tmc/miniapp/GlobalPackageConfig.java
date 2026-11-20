package com.cloud.tmc.miniapp;

import android.app.Application;
import com.cloud.tmc.kernel.intf.IPackageConfig;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.utils.AppDynamicBuildConfig;
import com.cloud.tmc.miniutils.util.e0;
import hd.j;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class GlobalPackageConfig implements IPackageConfig {
    public static final a Companion = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f31296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f31297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f31298c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f31299d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f31300e;

    /* JADX INFO: compiled from: source.java */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return GlobalPackageConfig.f31296a;
        }

        public final String b() {
            return GlobalPackageConfig.f31297b;
        }
    }

    static {
        StringBuilder sbA = j.a("1.");
        sbA.append(AppDynamicBuildConfig.s());
        f31296a = sbA.toString();
        f31297b = AppDynamicBuildConfig.s();
        f31298c = AppDynamicBuildConfig.r();
    }

    public final void a(String str, String str2) {
        try {
            KVStorageProxy kVStorageProxy = (KVStorageProxy) tc.a.a(KVStorageProxy.class);
            Application applicationA = e0.a();
            if (str2 == null) {
                str2 = "";
            }
            kVStorageProxy.putString(applicationA, "miniLauncherGlobal", str, str2);
        } catch (Throwable th2) {
            TmcLogger.h("[GlobalPackageConfig] saveValueForLauncher", th2);
        }
    }

    @Override // com.cloud.tmc.kernel.intf.IPackageConfig
    public String getAppId() {
        String str = f31300e;
        return str == null ? "" : str;
    }

    @Override // com.cloud.tmc.kernel.intf.IPackageConfig
    public String getDevSDKVersion() {
        return f31297b;
    }

    @Override // com.cloud.tmc.kernel.intf.IPackageConfig
    public String getFrameworkVersion() {
        return f31299d;
    }

    @Override // com.cloud.tmc.kernel.intf.IPackageConfig
    public boolean getOpenMutipleTask() {
        try {
            return ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getBoolean(e0.a(), "miniLauncherGlobal", "miniMutipleTask", true);
        } catch (Throwable th2) {
            TmcLogger.h("[GlobalPackageConfig] getMutipleTaskStatus", th2);
            return false;
        }
    }

    @Override // com.cloud.tmc.kernel.intf.IPackageConfig
    public String getSDKVersion() {
        return f31296a;
    }

    @Override // com.cloud.tmc.kernel.intf.IPackageConfig
    public void setAppId(String id2) {
        Intrinsics.g(id2, "id");
        a("miniHostAppId", id2);
        f31300e = id2;
    }

    @Override // com.cloud.tmc.kernel.intf.IPackageConfig
    public void setFrameworkVersion(String str) {
        a("miniHostFwVersion", str);
        f31299d = str;
    }

    @Override // com.cloud.tmc.kernel.intf.IPackageConfig
    public void setOpenMutipleTask(boolean z11) {
        try {
            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putBoolean(e0.a(), "miniLauncherGlobal", "miniMutipleTask", z11);
        } catch (Throwable th2) {
            TmcLogger.h("[GlobalPackageConfig] setOpenMutipleTask", th2);
        }
    }
}
