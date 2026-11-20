package com.cloud.tmc.miniapp.prestrategy;

import OooOoOO.o0OOO0o;
import b0.f;
import com.cloud.tmc.integration.net.BaseResponse;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.utils.e;
import com.cloud.tmc.miniapp.ByteAppManager;
import com.cloud.tmc.miniapp.prestrategy.PrefetchConfigManager$requestStrategyConfig$4;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import mb.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class PrefetchConfigManager$requestStrategyConfig$4 extends c<ArrayList<PrefetchConfigModel>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PrefetchData f31657a;

    public PrefetchConfigManager$requestStrategyConfig$4(PrefetchData prefetchData) {
        this.f31657a = prefetchData;
    }

    public static final void h(List list, PrefetchData data) {
        Intrinsics.g(data, "$data");
        o0OOO0o.f188a.c(list, data.getBundleMap());
    }

    @Override // mb.c
    public Type d() {
        Type type = new TypeToken<BaseResponse<? extends ArrayList<PrefetchConfigModel>>>() { // from class: com.cloud.tmc.miniapp.prestrategy.PrefetchConfigManager$requestStrategyConfig$4$getType$1
        }.getType();
        Intrinsics.f(type, "object : TypeToken<BaseR…hConfigModel>>>() {}.type");
        return type;
    }

    @Override // mb.c
    public void e(BaseResponse<? extends Object> fail, Map<String, String> map) {
        Intrinsics.g(fail, "fail");
        f.f13876e.set(0);
        TmcLogger.c("Prefetch:PrefetchConfigManager", "requestStrategyConfig failed( " + fail.getCode() + ':' + fail.getMessage() + ").");
    }

    @Override // mb.c
    public void g(BaseResponse<? extends ArrayList<PrefetchConfigModel>> bean, Map<String, String> map) {
        Intrinsics.g(bean, "bean");
        f.f13876e.set(0);
        TmcLogger.c("Prefetch:PrefetchConfigManager", "requestStrategyConfig success.");
        if (ByteAppManager.INSTANCE.getApplication$com_cloud_tmc_miniapp_sdk() != null) {
            final PrefetchData prefetchData = this.f31657a;
            try {
                final ArrayList<PrefetchConfigModel> data = bean.getData();
                if (data != null && !data.isEmpty()) {
                    TmcLogger.c("Prefetch:PrefetchConfigManager", "requestStrategyConfig data=" + data + '.');
                    e.a(ExecutorType.IDLE, new Runnable() { // from class: od.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            PrefetchConfigManager$requestStrategyConfig$4.h(data, prefetchData);
                        }
                    });
                    return;
                }
                TmcLogger.f("Prefetch:PrefetchConfigManager", "modelList is empty.");
            } catch (Throwable th2) {
                TmcLogger.h("Prefetch:PrefetchConfigManager", th2);
            }
        }
    }
}
