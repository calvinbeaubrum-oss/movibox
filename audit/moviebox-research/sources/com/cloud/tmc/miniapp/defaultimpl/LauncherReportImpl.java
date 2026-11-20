package com.cloud.tmc.miniapp.defaultimpl;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import com.cloud.tmc.integration.model.CacheReportBean;
import com.cloud.tmc.integration.proxy.LauncherReportProxy;
import com.cloud.tmc.integration.utils.f0;
import com.cloud.tmc.integration.utils.q;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.utils.e;
import com.cloud.tmc.miniapp.ByteAppManager;
import com.cloud.tmc.miniapp.defaultimpl.LauncherReportImpl;
import i0.g;
import kotlin.jvm.internal.Intrinsics;
import p009OooO0oo.OooOo00;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class LauncherReportImpl implements LauncherReportProxy {
    public final String OooO00o = "LauncherReport";

    public static final void OooO00o(int i11, LauncherReportImpl this$0) {
        Intrinsics.g(this$0, "this$0");
        try {
            Bundle bundle = new Bundle();
            OooOo00.a aVar = OooOo00.f166a;
            bundle.putInt("miniProcessId", i11);
            if (q.f31091a.j()) {
                TmcLogger.c(this$0.OooO00o, "reportCache ->reportMiniProcessId");
                g.f66814a.a(new CacheReportBean("", "com.cloud.tmc.miniapp.process_id", false, bundle));
                return;
            }
            TmcLogger.c(this$0.OooO00o, "reportMiniProcessId -> pid ->" + i11);
            Application application$com_cloud_tmc_miniapp_sdk = ByteAppManager.INSTANCE.getApplication$com_cloud_tmc_miniapp_sdk();
            if (application$com_cloud_tmc_miniapp_sdk != null) {
                Intent intent = new Intent("com.cloud.tmc.miniapp.process_id");
                bundle.putString("miniGaid", q.d());
                intent.putExtras(bundle);
                intent.setPackage(application$com_cloud_tmc_miniapp_sdk.getPackageName());
                application$com_cloud_tmc_miniapp_sdk.sendBroadcast(intent);
            }
        } catch (Throwable th2) {
            TmcLogger.g(this$0.OooO00o, "reportMiniProcessId", th2);
        }
    }

    public static final void OooO00o(String str, long j11, LauncherReportImpl this$0) {
        Intrinsics.g(this$0, "this$0");
        try {
            Bundle bundle = new Bundle();
            OooOo00.a aVar = OooOo00.f166a;
            bundle.putString("miniAppId", str);
            bundle.putLong("usageTime", j11);
            f0 f0Var = f0.f31050a;
            boolean zG = f0Var.g(str);
            if (!q.f31091a.j() && !zG) {
                TmcLogger.c(this$0.OooO00o, "reportMiniAppUseTime -> usageTime ->" + j11);
                Application application$com_cloud_tmc_miniapp_sdk = ByteAppManager.INSTANCE.getApplication$com_cloud_tmc_miniapp_sdk();
                if (application$com_cloud_tmc_miniapp_sdk != null) {
                    Intent intent = new Intent("com.cloud.tmc.miniapp.use_time");
                    bundle.putString("miniGaid", q.d());
                    intent.putExtras(bundle);
                    intent.setPackage(application$com_cloud_tmc_miniapp_sdk.getPackageName());
                    application$com_cloud_tmc_miniapp_sdk.sendBroadcast(intent);
                    return;
                }
                return;
            }
            TmcLogger.c(this$0.OooO00o, "reportCache ->reportMiniAppUseTime " + str);
            CacheReportBean cacheReportBean = new CacheReportBean(str == null ? "" : str, "com.cloud.tmc.miniapp.use_time", f0Var.f(str), bundle);
            if (!Intrinsics.b(f0Var.i().get(str), Boolean.TRUE)) {
                g.f66814a.a(cacheReportBean);
                return;
            }
            TmcLogger.c(this$0.OooO00o, "reportCache ->mfah reportMiniAppUseTime");
            g gVar = g.f66814a;
            if (str == null) {
                str = "";
            }
            gVar.c(str, cacheReportBean);
        } catch (Throwable th2) {
            TmcLogger.g(this$0.OooO00o, "reportMiniAppUseTime", th2);
        }
    }

    public static final void OooO00o(String appId, LauncherReportImpl this$0) {
        Intrinsics.g(appId, "$appId");
        Intrinsics.g(this$0, "this$0");
        try {
            Bundle bundle = new Bundle();
            OooOo00.a aVar = OooOo00.f166a;
            bundle.putString("miniAppId", appId);
            if (q.f31091a.j()) {
                TmcLogger.c(this$0.OooO00o, "reportCache ->reportMiniAddhomeSuccess");
                g.f66814a.a(new CacheReportBean(appId, "com.cloud.tmc.miniapp.addhome_success", false, bundle));
                return;
            }
            TmcLogger.c(this$0.OooO00o, "reportMiniAddhomeSuccess -> appId ->" + appId);
            Application application$com_cloud_tmc_miniapp_sdk = ByteAppManager.INSTANCE.getApplication$com_cloud_tmc_miniapp_sdk();
            if (application$com_cloud_tmc_miniapp_sdk != null) {
                Intent intent = new Intent("com.cloud.tmc.miniapp.addhome_success");
                bundle.putString("miniGaid", q.d());
                intent.putExtras(bundle);
                intent.setPackage(application$com_cloud_tmc_miniapp_sdk.getPackageName());
                application$com_cloud_tmc_miniapp_sdk.sendBroadcast(intent);
            }
        } catch (Throwable th2) {
            TmcLogger.g(this$0.OooO00o, "reportMiniAddhomeSuccess", th2);
        }
    }

    @Override // com.cloud.tmc.integration.proxy.LauncherReportProxy
    public void report(String str, Bundle bundle) {
        try {
            String str2 = this.OooO00o;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("tag:");
            sb2.append(str);
            sb2.append(",bundle:");
            sb2.append(bundle != null ? bundle.toString() : null);
            TmcLogger.c(str2, sb2.toString());
        } catch (Throwable th2) {
            TmcLogger.h(this.OooO00o, th2);
        }
    }

    @Override // com.cloud.tmc.integration.proxy.LauncherReportProxy
    public void reportAllCacheData(String str) {
        try {
            g.f66814a.b(str);
        } catch (Throwable unused) {
        }
    }

    @Override // com.cloud.tmc.integration.proxy.LauncherReportProxy
    public void reportCacheData(String str) {
        try {
            g.f66814a.e(str);
        } catch (Throwable unused) {
        }
    }

    @Override // com.cloud.tmc.integration.proxy.LauncherReportProxy
    public void reportMiniAddhomeSuccess(final String appId) {
        Intrinsics.g(appId, "appId");
        try {
            e.a(ExecutorType.IO, new Runnable() { // from class: md.g
                @Override // java.lang.Runnable
                public final void run() {
                    LauncherReportImpl.OooO00o(appId, this);
                }
            });
        } catch (Throwable th2) {
            TmcLogger.g(this.OooO00o, "reportMiniAddhomeSuccess", th2);
        }
    }

    @Override // com.cloud.tmc.integration.proxy.LauncherReportProxy
    public void reportMiniAppStartRecord(String str, String str2, String str3) {
    }

    @Override // com.cloud.tmc.integration.proxy.LauncherReportProxy
    public void reportMiniAppStartTime(String str, long j11, String startType) {
        Intrinsics.g(startType, "startType");
        try {
            Bundle bundle = new Bundle();
            OooOo00.a aVar = OooOo00.f166a;
            bundle.putString("miniAppId", str);
            bundle.putLong("startTime", j11);
            bundle.putString("startType", startType);
            f0 f0Var = f0.f31050a;
            boolean zG = f0Var.g(str);
            if (!q.f31091a.j() && !zG) {
                TmcLogger.c(this.OooO00o, "reportMiniAppStartTime -> startTime ->" + j11);
                Application application$com_cloud_tmc_miniapp_sdk = ByteAppManager.INSTANCE.getApplication$com_cloud_tmc_miniapp_sdk();
                if (application$com_cloud_tmc_miniapp_sdk != null) {
                    Intent intent = new Intent("com.cloud.tmc.miniapp.start_time");
                    bundle.putString("miniGaid", q.d());
                    intent.putExtras(bundle);
                    intent.setPackage(application$com_cloud_tmc_miniapp_sdk.getPackageName());
                    application$com_cloud_tmc_miniapp_sdk.sendBroadcast(intent);
                    return;
                }
                return;
            }
            TmcLogger.c(this.OooO00o, "reportCache ->reportMiniAppStartTime " + str);
            CacheReportBean cacheReportBean = new CacheReportBean(str == null ? "" : str, "com.cloud.tmc.miniapp.start_time", false, bundle);
            if (!Intrinsics.b(f0Var.i().get(str), Boolean.TRUE)) {
                g.f66814a.a(cacheReportBean);
                return;
            }
            TmcLogger.c(this.OooO00o, "reportCache ->mfah startTime");
            g gVar = g.f66814a;
            if (str == null) {
                str = "";
            }
            gVar.c(str, cacheReportBean);
        } catch (Throwable th2) {
            TmcLogger.g(this.OooO00o, "reportMiniAppStartTime", th2);
        }
    }

    @Override // com.cloud.tmc.integration.proxy.LauncherReportProxy
    public void reportMiniAppUseTime(final String str, final long j11) {
        try {
            e.a(ExecutorType.IO, new Runnable() { // from class: md.i
                @Override // java.lang.Runnable
                public final void run() {
                    LauncherReportImpl.OooO00o(str, j11, this);
                }
            });
        } catch (Throwable unused) {
        }
    }

    @Override // com.cloud.tmc.integration.proxy.LauncherReportProxy
    public void reportMiniProcessId(final int i11) {
        try {
            e.a(ExecutorType.IO, new Runnable() { // from class: md.h
                @Override // java.lang.Runnable
                public final void run() {
                    LauncherReportImpl.OooO00o(i11, this);
                }
            });
        } catch (Throwable th2) {
            TmcLogger.g(this.OooO00o, "reportMiniProcessId", th2);
        }
    }
}
