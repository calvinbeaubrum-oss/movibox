package OooOoo;

import android.app.Application;
import com.cloud.tmc.integration.proxy.PreHtmStrategyProxy;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.miniapp.ByteAppManager;
import com.cloud.tmc.miniapp.prestrategy.PrefetchConfigModel;
import com.cloud.tmc.miniutils.util.h;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import tc.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension
public final class o000oOoO {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PrefetchConfigModel f195a;

    /* JADX INFO: compiled from: source.java */
    public static final class OooO00o extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ CountDownLatch OooO00o;
        public final /* synthetic */ Application OooO0O0;
        public final /* synthetic */ String OooO0OO;

        /* JADX INFO: renamed from: OooO0Oo, reason: collision with root package name */
        public final /* synthetic */ String f196OooO0Oo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooO00o(CountDownLatch countDownLatch, Application application, String str, String str2) {
            super(1);
            this.OooO00o = countDownLatch;
            this.OooO0O0 = application;
            this.OooO0OO = str;
            this.f196OooO0Oo = str2;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            boolean zBooleanValue = bool.booleanValue();
            this.OooO00o.countDown();
            TmcLogger.c("Prefetch:H5Task", "request success=" + zBooleanValue);
            if (zBooleanValue) {
                ((KVStorageProxy) a.a(KVStorageProxy.class)).putLong(this.OooO0O0, this.OooO0OO, this.f196OooO0Oo + "_time", System.currentTimeMillis());
            }
            return Unit.f68710a;
        }
    }

    public o000oOoO(PrefetchConfigModel data) {
        Intrinsics.g(data, "data");
        this.f195a = data;
    }

    public final void a() {
        String appId;
        ArrayList<String> h5Url;
        try {
            TmcLogger.c("Prefetch:H5Task", "request start appId=" + this.f195a.getAppId() + '.');
            long jCurrentTimeMillis = System.currentTimeMillis();
            Application application$com_cloud_tmc_miniapp_sdk = ByteAppManager.INSTANCE.getApplication$com_cloud_tmc_miniapp_sdk();
            if (application$com_cloud_tmc_miniapp_sdk == null || (appId = this.f195a.getAppId()) == null || (h5Url = this.f195a.getH5Url()) == null) {
                return;
            }
            for (String str : h5Url) {
                CountDownLatch countDownLatch = new CountDownLatch(1);
                String strB = h.b(str);
                long j11 = ((KVStorageProxy) a.a(KVStorageProxy.class)).getLong(application$com_cloud_tmc_miniapp_sdk, appId, strB + "_time");
                if (j11 <= 0 || this.f195a.getExecuteTime() != 0) {
                    if (jCurrentTimeMillis - j11 >= this.f195a.getExecuteTime() * ((long) 1000)) {
                        ((PreHtmStrategyProxy) a.a(PreHtmStrategyProxy.class)).requestHtml(application$com_cloud_tmc_miniapp_sdk, str, new OooO00o(countDownLatch, application$com_cloud_tmc_miniapp_sdk, appId, strB));
                        countDownLatch.await(60L, TimeUnit.SECONDS);
                    }
                }
                TmcLogger.f("Prefetch:H5Task", "No need to make repeated requests during the validity period");
                return;
            }
        } catch (Throwable th2) {
            TmcLogger.h("Prefetch:H5Task", th2);
        }
    }
}
