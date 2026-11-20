package OooOoo;

import android.app.Application;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.ExtendModel;
import com.cloud.tmc.integration.proxy.PreHtmStrategyProxy;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.utils.i;
import com.cloud.tmc.miniapp.ByteAppManager;
import com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager;
import com.cloud.tmc.miniapp.prestrategy.PrefetchConfigModel;
import com.cloud.tmc.miniutils.util.h;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import tc.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o00O0O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PrefetchConfigModel f197a;

    /* JADX INFO: compiled from: source.java */
    public static final class OooO00o extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ CountDownLatch OooO00o;
        public final /* synthetic */ Application OooO0O0;
        public final /* synthetic */ String OooO0OO;

        /* JADX INFO: renamed from: OooO0Oo, reason: collision with root package name */
        public final /* synthetic */ String f198OooO0Oo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooO00o(CountDownLatch countDownLatch, Application application, String str, String str2) {
            super(1);
            this.OooO00o = countDownLatch;
            this.OooO0O0 = application;
            this.OooO0OO = str;
            this.f198OooO0Oo = str2;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            boolean zBooleanValue = bool.booleanValue();
            this.OooO00o.countDown();
            if (zBooleanValue) {
                ((KVStorageProxy) a.a(KVStorageProxy.class)).putLong(this.OooO0O0, this.OooO0OO, this.f198OooO0Oo + "_time", System.currentTimeMillis());
            }
            return Unit.f68710a;
        }
    }

    public o00O0O(PrefetchConfigModel data) {
        Intrinsics.g(data, "data");
        this.f197a = data;
    }

    public final void a() {
        String appId;
        AppModel appModel;
        String h5Url;
        try {
            TmcLogger.c("Prefetch:ShellH5Task", "request start appId=" + this.f197a.getAppId() + '.');
            long jCurrentTimeMillis = System.currentTimeMillis();
            Application application$com_cloud_tmc_miniapp_sdk = ByteAppManager.INSTANCE.getApplication$com_cloud_tmc_miniapp_sdk();
            if (application$com_cloud_tmc_miniapp_sdk == null || (appId = this.f197a.getAppId()) == null || (appModel = ((TmcAppInfoManager) a.a(TmcAppInfoManager.class)).getAppModel(application$com_cloud_tmc_miniapp_sdk, lb.a.f70163b.a(appId))) == null) {
                return;
            }
            ExtendModel extend = appModel.getExtend();
            if (extend == null || (h5Url = extend.getH5Url()) == null) {
                h5Url = "";
            }
            if (h5Url.length() == 0) {
                TmcLogger.c("Prefetch:ShellH5Task", appId + " ->h5Url is empty ,return!");
                return;
            }
            String strB = i.b(h5Url, this.f197a.getBundle());
            String strB2 = h.b(strB);
            long j11 = ((KVStorageProxy) a.a(KVStorageProxy.class)).getLong(application$com_cloud_tmc_miniapp_sdk, appId, strB2 + "_time");
            if ((j11 > 0 && this.f197a.getExecuteTime() == 0) || jCurrentTimeMillis - j11 < this.f197a.getExecuteTime() * ((long) 1000)) {
                TmcLogger.f("Prefetch:H5Task", "No need to make repeated requests during the validity period");
                return;
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            ((PreHtmStrategyProxy) a.a(PreHtmStrategyProxy.class)).requestHtml(application$com_cloud_tmc_miniapp_sdk, strB, new OooO00o(countDownLatch, application$com_cloud_tmc_miniapp_sdk, appId, strB2));
            countDownLatch.await(60L, TimeUnit.SECONDS);
        } catch (Throwable th2) {
            TmcLogger.h("Prefetch:ShellH5Task", th2);
        }
    }
}
