package i0;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import com.cloud.tmc.integration.model.CacheReportBean;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.ByteAppManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import p009OooO0oo.OooOo00;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f66814a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentLinkedQueue<CacheReportBean> f66815b = new ConcurrentLinkedQueue<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, ConcurrentLinkedQueue<CacheReportBean>> f66816c = new ConcurrentHashMap<>();

    public static final void d(ArrayList tmpDataCache) {
        Intrinsics.g(tmpDataCache, "$tmpDataCache");
        try {
            String strD = com.cloud.tmc.integration.utils.q.d();
            Iterator it = tmpDataCache.iterator();
            while (it.hasNext()) {
                Bundle data = ((CacheReportBean) it.next()).getData();
                OooOo00.a aVar = OooOo00.f166a;
                data.putString("miniGaid", strD);
            }
            f66814a.h(tmpDataCache);
        } catch (Throwable unused) {
        }
    }

    public static final void f(ArrayList tmpDataCache) {
        Intrinsics.g(tmpDataCache, "$tmpDataCache");
        try {
            String strD = com.cloud.tmc.integration.utils.q.d();
            Iterator it = tmpDataCache.iterator();
            while (it.hasNext()) {
                Bundle data = ((CacheReportBean) it.next()).getData();
                OooOo00.a aVar = OooOo00.f166a;
                data.putString("miniGaid", strD);
            }
            f66814a.h(tmpDataCache);
            f66815b.clear();
        } catch (Throwable unused) {
        }
    }

    public static final void g(ArrayList tmpDataCache) {
        Intrinsics.g(tmpDataCache, "$tmpDataCache");
        try {
            String strD = com.cloud.tmc.integration.utils.q.d();
            Iterator it = tmpDataCache.iterator();
            while (it.hasNext()) {
                Bundle data = ((CacheReportBean) it.next()).getData();
                OooOo00.a aVar = OooOo00.f166a;
                data.putString("miniGaid", strD);
            }
            f66814a.h(tmpDataCache);
        } catch (Throwable unused) {
        }
    }

    public final void a(CacheReportBean dataBean) {
        Intrinsics.g(dataBean, "dataBean");
        try {
            f66815b.add(dataBean);
        } catch (Throwable unused) {
        }
    }

    public final void b(String str) {
        try {
            final ArrayList arrayList = new ArrayList();
            ConcurrentLinkedQueue<CacheReportBean> concurrentLinkedQueue = f66815b;
            arrayList.addAll(concurrentLinkedQueue);
            ConcurrentHashMap<String, ConcurrentLinkedQueue<CacheReportBean>> concurrentHashMap = f66816c;
            ConcurrentLinkedQueue<CacheReportBean> concurrentLinkedQueue2 = concurrentHashMap.get(str);
            if ((concurrentLinkedQueue2 != null ? Boolean.valueOf(concurrentLinkedQueue2.isEmpty()) : null) != null && (!concurrentLinkedQueue2.isEmpty())) {
                arrayList.addAll(concurrentLinkedQueue2);
            }
            com.cloud.tmc.kernel.utils.e.a(ExecutorType.IO, new Runnable() { // from class: i0.d
                @Override // java.lang.Runnable
                public final void run() {
                    g.d(arrayList);
                }
            });
            if (concurrentLinkedQueue2 != null) {
                concurrentLinkedQueue2.clear();
            }
            TypeIntrinsics.d(concurrentHashMap).remove(str);
            concurrentLinkedQueue.clear();
        } catch (Throwable unused) {
        }
    }

    public final void c(String appId, CacheReportBean athenaDataBean) {
        Intrinsics.g(appId, "appId");
        Intrinsics.g(athenaDataBean, "athenaDataBean");
        try {
            ConcurrentHashMap<String, ConcurrentLinkedQueue<CacheReportBean>> concurrentHashMap = f66816c;
            ConcurrentLinkedQueue<CacheReportBean> concurrentLinkedQueue = concurrentHashMap.get(appId);
            if (concurrentLinkedQueue == null) {
                concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
                concurrentHashMap.put(appId, concurrentLinkedQueue);
            }
            concurrentLinkedQueue.add(athenaDataBean);
        } catch (Throwable th2) {
            TmcLogger.g("MiniSyncMiniappData", "setAthenaDataForId", th2);
        }
    }

    public final void e(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    final ArrayList arrayList = new ArrayList();
                    ConcurrentHashMap<String, ConcurrentLinkedQueue<CacheReportBean>> concurrentHashMap = f66816c;
                    ConcurrentLinkedQueue<CacheReportBean> concurrentLinkedQueue = concurrentHashMap.get(str);
                    if (concurrentLinkedQueue == null) {
                        return;
                    }
                    if (concurrentLinkedQueue.isEmpty()) {
                        TmcLogger.c("MiniSyncMiniappData", "reportCache ->reportCacheData is empty return ");
                        return;
                    }
                    arrayList.addAll(concurrentLinkedQueue);
                    com.cloud.tmc.kernel.utils.e.a(ExecutorType.IO, new Runnable() { // from class: i0.f
                        @Override // java.lang.Runnable
                        public final void run() {
                            g.g(arrayList);
                        }
                    });
                    concurrentLinkedQueue.clear();
                    concurrentHashMap.remove(str);
                    return;
                }
            } catch (Throwable unused) {
                return;
            }
        }
        ConcurrentLinkedQueue<CacheReportBean> concurrentLinkedQueue2 = f66815b;
        if (concurrentLinkedQueue2.isEmpty()) {
            TmcLogger.c("MiniSyncMiniappData", "reportCache ->reportCacheData is empty return ");
            return;
        }
        final ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(concurrentLinkedQueue2);
        com.cloud.tmc.kernel.utils.e.a(ExecutorType.IO, new Runnable() { // from class: i0.e
            @Override // java.lang.Runnable
            public final void run() {
                g.f(arrayList2);
            }
        });
    }

    public final void h(ArrayList<CacheReportBean> arrayList) {
        try {
            TmcLogger.c("MiniSyncMiniappData", "reportCache ->reportCacheDataBroadcast");
            Application application$com_cloud_tmc_miniapp_sdk = ByteAppManager.INSTANCE.getApplication$com_cloud_tmc_miniapp_sdk();
            if (application$com_cloud_tmc_miniapp_sdk != null) {
                OooOo00.a aVar = OooOo00.f166a;
                Intent intent = new Intent("com.cloud.tmc.miniapp.report_cache");
                intent.putParcelableArrayListExtra("reportCachedata", arrayList);
                intent.setPackage(application$com_cloud_tmc_miniapp_sdk.getPackageName());
                application$com_cloud_tmc_miniapp_sdk.sendBroadcast(intent);
            }
        } catch (Throwable unused) {
        }
    }
}
