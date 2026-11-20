package k;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.cloud.tmc.integration.utils.h;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.env.IApplicationContextGetter;
import com.cloud.tmc.miniapp.ByteAppManager;
import com.cloud.tmc.miniapp.ipc.multiprogress.IpcMainProcessClientService;
import com.cloud.tmc.miniapp.prestrategy.PreStrategyManager;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import hd.g;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f68192a = "IpcMiniLauncherChannelImpl";

    @Override // hd.g
    public boolean A(String str, Bundle bundle) {
        Unit unit;
        Application application$com_cloud_tmc_miniapp_sdk = ByteAppManager.INSTANCE.getApplication$com_cloud_tmc_miniapp_sdk();
        if (application$com_cloud_tmc_miniapp_sdk != null) {
            MiniAppLaunch.d0(application$com_cloud_tmc_miniapp_sdk, str, bundle);
            unit = Unit.f68710a;
        } else {
            unit = null;
        }
        if (unit != null) {
            return true;
        }
        TmcLogger.f("IpcMiniLauncherChannelImpl", "Launcher Failed Application is null");
        return true;
    }

    @Override // hd.g
    public boolean F(String str, Bundle bundle) {
        try {
            TmcLogger.c(this.f68192a, "syncLauncherNewsData");
            return true;
        } catch (Throwable th2) {
            TmcLogger.h(this.f68192a, th2);
            return true;
        }
    }

    @Override // hd.g
    public boolean I(String str, String str2) {
        if (str != null) {
            try {
                if (str.length() != 0 && str2 != null && str2.length() != 0) {
                    TmcLogger.c(this.f68192a, "updateLauncherData key=" + str + " data=" + str2);
                    Application application$com_cloud_tmc_miniapp_sdk = ByteAppManager.INSTANCE.getApplication$com_cloud_tmc_miniapp_sdk();
                    if (application$com_cloud_tmc_miniapp_sdk != null) {
                        PreStrategyManager.d(PreStrategyManager.f31651a, application$com_cloud_tmc_miniapp_sdk, str, str2, null, 8);
                    }
                }
            } catch (Throwable th2) {
                TmcLogger.h("IpcMiniLauncherChannelImpl", th2);
            }
        }
        return true;
    }

    @Override // hd.g
    public boolean U() {
        try {
            IpcMainProcessClientService.a aVar = IpcMainProcessClientService.f31550b;
            Context applicationContext = ((IApplicationContextGetter) tc.a.a(IApplicationContextGetter.class)).getApplicationContext();
            if (applicationContext == null) {
                return true;
            }
            try {
                Intent intent = new Intent(applicationContext, (Class<?>) IpcMainProcessClientService.class);
                h.f31061a.a(intent, applicationContext);
                applicationContext.startService(intent);
                return true;
            } catch (Throwable th2) {
                TmcLogger.g("IpcMainProcessClientService", "Exception startService", th2);
                return true;
            }
        } catch (Throwable th3) {
            TmcLogger.g(this.f68192a, "", th3);
            return true;
        }
    }

    @Override // hd.g
    public boolean b0(String type, Bundle bundle) {
        Intrinsics.g(type, "type");
        Intrinsics.g(bundle, "bundle");
        try {
            TmcLogger.c("IpcMiniLauncherChannelImpl", "preLauncherData");
            Application application$com_cloud_tmc_miniapp_sdk = ByteAppManager.INSTANCE.getApplication$com_cloud_tmc_miniapp_sdk();
            if (application$com_cloud_tmc_miniapp_sdk == null) {
                return true;
            }
            PreStrategyManager.f31651a.a(application$com_cloud_tmc_miniapp_sdk, type, bundle.getString("keyMiniAppSyncData"), null);
            return true;
        } catch (Throwable th2) {
            TmcLogger.h("IpcMiniLauncherChannelImpl", th2);
            return true;
        }
    }

    @Override // hd.g
    public boolean n(int i11, int i12) {
        try {
            TmcLogger.c(this.f68192a, "syncLauncherLifecycletoMiniapp type=" + i11 + " requestSize=" + i12);
            return true;
        } catch (Throwable th2) {
            TmcLogger.h("IpcMiniLauncherChannelImpl", th2);
            return true;
        }
    }

    @Override // hd.g
    public boolean p(boolean z11) {
        TmcLogger.c("IpcMiniLauncherChannelImpl", "warmupWebview");
        try {
            Application application$com_cloud_tmc_miniapp_sdk = ByteAppManager.INSTANCE.getApplication$com_cloud_tmc_miniapp_sdk();
            if (application$com_cloud_tmc_miniapp_sdk == null) {
                return true;
            }
            MiniAppLaunch.f31784a.r0(application$com_cloud_tmc_miniapp_sdk, z11);
            return true;
        } catch (Throwable th2) {
            TmcLogger.h("IpcMiniLauncherChannelImpl", th2);
            return true;
        }
    }
}
