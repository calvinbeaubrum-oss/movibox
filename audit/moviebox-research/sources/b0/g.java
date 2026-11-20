package b0;

import android.app.Application;
import android.content.Context;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.model.FocusUpdatePreConfig;
import com.cloud.tmc.integration.model.LauncherPreStrategyBaseModel;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.network.IConfigStrategyProxy;
import com.cloud.tmc.kernel.proxy.network.INetWorkProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.miniapp.ByteAppManager;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import com.cloud.tmc.miniutils.util.u;
import hd.k;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cookie;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f13878a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f13879b = new AtomicBoolean(false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static LauncherPreStrategyBaseModel f13880c;

    /* JADX INFO: compiled from: source.java */
    public static final class a implements wc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f13881a;

        public a(Context context) {
            this.f13881a = context;
        }

        @Override // wc.b
        public void a(int i11, String str, Map<String, String> map, List<Cookie> list, String str2) {
            g.f13879b.set(false);
            k.a("requestStrategyConfig -> ", str, "PreStrategyConfigManager");
            if (i11 == 200) {
                try {
                    Application application$com_cloud_tmc_miniapp_sdk = ByteAppManager.INSTANCE.getApplication$com_cloud_tmc_miniapp_sdk();
                    if (application$com_cloud_tmc_miniapp_sdk != null) {
                        Context context = this.f13881a;
                        KVStorageProxy kVStorageProxy = (KVStorageProxy) tc.a.a(KVStorageProxy.class);
                        if (str == null) {
                            str = "";
                        }
                        kVStorageProxy.putString(application$com_cloud_tmc_miniapp_sdk, "miniPreStrategyConfig", "miniPreCdnConfig", str);
                        ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putLong(context, "miniPreStrategyConfig", "miniRequestConfigDiff", System.currentTimeMillis());
                        g.f13880c = g.f13878a.a(application$com_cloud_tmc_miniapp_sdk);
                    }
                } catch (Throwable th2) {
                    g gVar = g.f13878a;
                    TmcLogger.h("PreStrategyConfigManager", th2);
                }
            }
        }

        @Override // wc.b
        public void b(String str, String str2, String str3) {
            g.f13879b.set(false);
            TmcLogger.f("PreStrategyConfigManager", "errorcode ->" + str + " , errMsg -> " + str2);
        }
    }

    public final LauncherPreStrategyBaseModel a(Context context) {
        LauncherPreStrategyBaseModel launcherPreStrategyBaseModel = null;
        try {
            String string = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(context, "miniPreStrategyConfig", "miniPreCdnConfig");
            String str = "";
            if (string == null) {
                string = "";
            }
            if (string.length() != 0 || (string = u.b("preStrategyConfig.json")) != null) {
                str = string;
            }
            if (str.length() <= 0) {
                return null;
            }
            LauncherPreStrategyBaseModel launcherPreStrategyBaseModel2 = (LauncherPreStrategyBaseModel) com.cloud.tmc.miniutils.util.k.d(str, LauncherPreStrategyBaseModel.class);
            try {
                ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putLong(context, "miniPreStrategyConfig", "miniRefreshConfigDiff", System.currentTimeMillis());
                return launcherPreStrategyBaseModel2;
            } catch (Throwable th2) {
                th = th2;
                launcherPreStrategyBaseModel = launcherPreStrategyBaseModel2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
        TmcLogger.h("PreStrategyConfigManager", th);
        return launcherPreStrategyBaseModel;
    }

    public final LauncherPreStrategyBaseModel b(Context context) {
        if (context == null) {
            TmcLogger.f("PreStrategyConfigManager", "getPreStrategyConfig context is null ");
            return null;
        }
        if (f13880c == null) {
            f13880c = a(context);
        } else {
            if (System.currentTimeMillis() - ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getLong(context, "miniPreStrategyConfig", "miniRefreshConfigDiff") > 43200000) {
                f13880c = a(context);
            }
        }
        try {
            if (MiniAppConfigHelper.f30370a.b("enablePreZeroScreenUpdate", false)) {
                c(context);
                TmcLogger.c("PreStrategyConfigManager", "getPreStrategyConfig enableStatus is true");
            }
        } catch (Throwable th2) {
            TmcLogger.h("PreStrategyConfigManager", th2);
        }
        return f13880c;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0097  */
    /* JADX WARN: Code duplicated, block: B:37:0x00a0  */
    /* JADX WARN: Instruction removed from duplicated block: B:37:0x00a0, please report this as an issue */
    public final void c(Context context) {
        int iC;
        String configVerion;
        Intrinsics.g(context, "context");
        if (f.f13872a.d()) {
            TmcLogger.f("PreStrategyConfigManager", "execute new prefetch strategy.");
            return;
        }
        AtomicBoolean atomicBoolean = f13879b;
        if (atomicBoolean.get()) {
            TmcLogger.c("PreStrategyConfigManager", "requestStrategyConfig is refreshing");
            return;
        }
        atomicBoolean.set(true);
        long j11 = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getLong(context, "miniPreStrategyConfig", "miniRequestConfigDiff");
        try {
            iC = MiniAppConfigHelper.f30370a.c("updatePreConfigInterval", 24) * 3600;
        } catch (Throwable unused) {
            iC = 86400;
        }
        long j12 = ((long) iC) * 1000;
        try {
            if (f13880c != null) {
                FocusUpdatePreConfig focusUpdatePreConfig = (FocusUpdatePreConfig) com.cloud.tmc.miniutils.util.k.f().fromJson(MiniAppConfigHelper.f30370a.e("forceUpdatePreConfig", "{\"enable\":false,\"version\":\"0.0.1\"}"), FocusUpdatePreConfig.class);
                if (focusUpdatePreConfig == null) {
                    focusUpdatePreConfig = new FocusUpdatePreConfig(false, "0.0.0");
                }
                if (focusUpdatePreConfig.getEnable()) {
                    MiniAppLaunch miniAppLaunch = MiniAppLaunch.f31784a;
                    String version = focusUpdatePreConfig.getVersion();
                    LauncherPreStrategyBaseModel launcherPreStrategyBaseModel = f13880c;
                    if (launcherPreStrategyBaseModel == null || (configVerion = launcherPreStrategyBaseModel.getConfigVerion()) == null) {
                        configVerion = "";
                    }
                    if (!miniAppLaunch.D(version, configVerion)) {
                        if (System.currentTimeMillis() - j11 < j12) {
                            f13879b.set(false);
                            TmcLogger.f("PreStrategyConfigManager", "requestStrategyConfig diff < " + j12 + ",latestRequest ->" + j11);
                            return;
                        }
                    }
                } else if (System.currentTimeMillis() - j11 < j12) {
                    f13879b.set(false);
                    TmcLogger.f("PreStrategyConfigManager", "requestStrategyConfig diff < " + j12 + ",latestRequest ->" + j11);
                    return;
                }
            }
        } catch (Throwable th2) {
            TmcLogger.h("PreStrategyConfigManager", th2);
        }
        String preStrategyCdnUrl = ((IConfigStrategyProxy) tc.a.a(IConfigStrategyProxy.class)).getPreStrategyCdnUrl();
        TmcLogger.f("PreStrategyConfigManager", preStrategyCdnUrl);
        ((INetWorkProxy) tc.a.a(INetWorkProxy.class)).get(preStrategyCdnUrl, null, null, Boolean.FALSE, new a(context));
    }
}
