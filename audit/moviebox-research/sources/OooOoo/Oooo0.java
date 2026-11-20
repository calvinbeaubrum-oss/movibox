package OooOoo;

import android.app.Application;
import com.cloud.tmc.integration.model.AppInfoModel;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.net.BaseResponse;
import com.cloud.tmc.integration.utils.MiniRequestUtils;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.ByteAppManager;
import com.cloud.tmc.miniapp.prepare.manager.TmcAppInfoManager;
import com.cloud.tmc.miniapp.prestrategy.PrefetchConfigModel;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import tc.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class Oooo0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PrefetchConfigModel f194a;

    /* JADX INFO: compiled from: source.java */
    public static final class OooO00o extends Lambda implements Function1<BaseResponse<? extends AppInfoModel>, Unit> {
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
        public Unit invoke(BaseResponse<? extends AppInfoModel> baseResponse) {
            BaseResponse<? extends AppInfoModel> it = baseResponse;
            Intrinsics.g(it, "it");
            try {
                this.OooO00o.countDown();
                AppInfoModel data = it.getData();
                if (data != null) {
                    AppModel appModelG = MiniAppLaunch.f31784a.G(data);
                    ((TmcAppInfoManager) a.a(TmcAppInfoManager.class)).updateAppModel(this.OooO0O0, appModelG, this.OooO0OO + "_pre");
                    ((TmcAppInfoManager) a.a(TmcAppInfoManager.class)).refreshUpdateTime(this.OooO0O0, this.OooO0OO, System.currentTimeMillis());
                    TmcLogger.c("Prefetch:AppInfoTask", "request success.");
                }
            } catch (Throwable th2) {
                TmcLogger.h("Prefetch:AppInfoTask", th2);
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0O0 extends Lambda implements Function1<BaseResponse<? extends Object>, Unit> {
        public final /* synthetic */ CountDownLatch OooO00o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooO0O0(CountDownLatch countDownLatch) {
            super(1);
            this.OooO00o = countDownLatch;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(BaseResponse<? extends Object> baseResponse) {
            BaseResponse<? extends Object> it = baseResponse;
            Intrinsics.g(it, "it");
            try {
                this.OooO00o.countDown();
                TmcLogger.c("Prefetch:AppInfoTask", "request failed.");
            } catch (Throwable th2) {
                TmcLogger.h("Prefetch:AppInfoTask", th2);
            }
            return Unit.f68710a;
        }
    }

    public Oooo0(PrefetchConfigModel data) {
        Intrinsics.g(data, "data");
        this.f194a = data;
    }

    public final void a() {
        String appId;
        try {
            TmcLogger.c("Prefetch:AppInfoTask", "request start appId=" + this.f194a.getAppId() + '.');
            long jCurrentTimeMillis = System.currentTimeMillis();
            Application application$com_cloud_tmc_miniapp_sdk = ByteAppManager.INSTANCE.getApplication$com_cloud_tmc_miniapp_sdk();
            if (application$com_cloud_tmc_miniapp_sdk == null || (appId = this.f194a.getAppId()) == null) {
                return;
            }
            long lastUpdateTime = ((TmcAppInfoManager) a.a(TmcAppInfoManager.class)).getLastUpdateTime(application$com_cloud_tmc_miniapp_sdk, appId);
            if (lastUpdateTime <= 0 || this.f194a.getExecuteTime() != 0) {
                if (jCurrentTimeMillis - lastUpdateTime >= this.f194a.getExecuteTime() * ((long) 1000)) {
                    CountDownLatch countDownLatch = new CountDownLatch(1);
                    MiniRequestUtils.d(appId, new OooO00o(countDownLatch, application$com_cloud_tmc_miniapp_sdk, appId), new OooO0O0(countDownLatch));
                    countDownLatch.await(60L, TimeUnit.SECONDS);
                    return;
                }
            }
            TmcLogger.f("Prefetch:AppInfoTask", "No need to make repeated requests during the validity period");
        } catch (Throwable th2) {
            TmcLogger.h("Prefetch:AppInfoTask", th2);
        }
    }
}
