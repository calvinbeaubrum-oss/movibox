package OooOoo;

import android.app.Application;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.miniapp.ByteAppManager;
import com.cloud.tmc.miniapp.prestrategy.PrefetchConfigModel;
import com.cloud.tmc.offline.download.OfflineManager;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import tc.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o0OoOo0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PrefetchConfigModel f199a;

    /* JADX INFO: compiled from: source.java */
    public static final class OooO00o extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ CountDownLatch OooO00o;
        public final /* synthetic */ Application OooO0O0;
        public final /* synthetic */ String OooO0OO;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooO00o(CountDownLatch countDownLatch, Application application, String str) {
            super(1);
            this.OooO00o = countDownLatch;
            this.OooO0O0 = application;
            this.OooO0OO = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            boolean zBooleanValue = bool.booleanValue();
            this.OooO00o.countDown();
            if (zBooleanValue) {
                ((KVStorageProxy) a.a(KVStorageProxy.class)).putLong(this.OooO0O0, this.OooO0OO, this.OooO0OO + "_offline_time", System.currentTimeMillis());
            }
            TmcLogger.f("Prefetch:OfflinePackageTask", "PrefetchOfflinePackageTask task finish. success =" + zBooleanValue);
            return Unit.f68710a;
        }
    }

    public o0OoOo0(PrefetchConfigModel data) {
        Intrinsics.g(data, "data");
        this.f199a = data;
    }

    public final void a() {
        String appId;
        try {
            TmcLogger.c("Prefetch:OfflinePackageTask", "request start appId=" + this.f199a.getAppId() + '.');
            long jCurrentTimeMillis = System.currentTimeMillis();
            Application application$com_cloud_tmc_miniapp_sdk = ByteAppManager.INSTANCE.getApplication$com_cloud_tmc_miniapp_sdk();
            if (application$com_cloud_tmc_miniapp_sdk == null || (appId = this.f199a.getAppId()) == null) {
                return;
            }
            long j11 = ((KVStorageProxy) a.a(KVStorageProxy.class)).getLong(application$com_cloud_tmc_miniapp_sdk, appId, appId + "_offline_time");
            if (j11 <= 0 || this.f199a.getExecuteTime() != 0) {
                if (jCurrentTimeMillis - j11 >= this.f199a.getExecuteTime() * ((long) 1000)) {
                    CountDownLatch countDownLatch = new CountDownLatch(1);
                    OfflineManager.u(appId, false, new OooO00o(countDownLatch, application$com_cloud_tmc_miniapp_sdk, appId));
                    countDownLatch.await(60L, TimeUnit.SECONDS);
                    return;
                }
            }
            TmcLogger.f("Prefetch:OfflinePackageTask", "No need to make repeated requests during the validity period");
        } catch (Throwable th2) {
            TmcLogger.h("Prefetch:OfflinePackageTask", th2);
        }
    }
}
