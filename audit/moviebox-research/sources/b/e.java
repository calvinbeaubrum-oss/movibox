package b;

import android.os.Bundle;
import com.cloud.tmc.integration.performance.innerwebview.IInnerH5WebviewPool;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f13864a = new e();

    public static final void b(String str, String str2, Bundle bundle) {
        int i11;
        try {
            if (Intrinsics.b(str, "miniappWarmup")) {
                if (bundle != null) {
                    try {
                        i11 = bundle.getInt("warmupType");
                    } catch (Throwable th2) {
                        TmcLogger.h("MiniAppPerformanceHelper", th2);
                        return;
                    }
                } else {
                    i11 = 0;
                }
                try {
                    if (i11 == 0) {
                        MiniAppLaunch miniAppLaunch = MiniAppLaunch.f31784a;
                        miniAppLaunch.q0();
                        miniAppLaunch.s0();
                    } else if (i11 != 1) {
                    } else {
                        ((IInnerH5WebviewPool) tc.a.a(IInnerH5WebviewPool.class)).createWebview();
                    }
                } catch (Throwable th3) {
                    TmcLogger.h("MiniAppPerformanceHelper", th3);
                }
            }
        } catch (Throwable th4) {
            TmcLogger.g("MiniAppPerformanceHelper", "protocolInvoke", th4);
        }
    }

    public void a(final String str, final String str2, final Bundle bundle) {
        try {
            com.cloud.tmc.kernel.utils.e.a(ExecutorType.IO, new Runnable() { // from class: b.a
                @Override // java.lang.Runnable
                public final void run() {
                    e.b(str, str2, bundle);
                }
            });
        } catch (Throwable th2) {
            TmcLogger.g("MiniAppPerformanceHelper", "protocolInvoke", th2);
        }
    }
}
