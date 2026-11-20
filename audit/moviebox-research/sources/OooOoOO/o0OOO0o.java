package OooOoOO;

import OooOoOO.o0OOO0o;
import OooOoo.Oooo0;
import OooOoo.o000oOoO;
import OooOoo.o00O0O;
import OooOoo.o0OoOo0;
import android.app.Application;
import android.os.Bundle;
import android.util.LruCache;
import b0.f;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.utils.e;
import com.cloud.tmc.miniapp.ByteAppManager;
import com.cloud.tmc.miniapp.prestrategy.PrefetchConfigModel;
import com.cloud.tmc.miniapp.prestrategy.PrefetchData;
import com.cloud.tmc.miniutils.util.NetworkUtils;
import com.cloud.tmc.miniutils.util.k;
import com.google.gson.reflect.TypeToken;
import hd.j;
import java.lang.reflect.Type;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension
public final class o0OOO0o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f190c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static ThreadPoolExecutor f193f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o0OOO0o f188a = new o0OOO0o();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final LruCache<PrefetchConfigModel, Integer> f191d = new LruCache<>(20);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final LruCache<PrefetchConfigModel, Integer> f192e = new LruCache<>(50);

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0O0 implements Runnable {
        public final PrefetchConfigModel OooO00o;

        public OooO0O0(PrefetchConfigModel model) {
            Intrinsics.g(model, "model");
            this.OooO00o = model;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                TmcLogger.c("Prefetch:StrategyExecuteManager", "StrategyTask execute. (appId=" + this.OooO00o.getAppId() + ", dataType=" + this.OooO00o.getDataType() + ") ");
                if (System.currentTimeMillis() > this.OooO00o.getExpiredTime() * ((long) 1000)) {
                    TmcLogger.f("Prefetch:StrategyExecuteManager", "this strategy(appId=" + this.OooO00o.getAppId() + ", dataType=" + this.OooO00o.getDataType() + ") has expired.");
                    return;
                }
                LruCache<PrefetchConfigModel, Integer> lruCache = o0OOO0o.f192e;
                synchronized (lruCache) {
                    if (!o0OOO0o.f189b) {
                        TmcLogger.f("Prefetch:StrategyExecuteManager", "no network, push wait queue.");
                        lruCache.put(this.OooO00o, 0);
                        return;
                    }
                    if (this.OooO00o.getNetType() == 2 && o0OOO0o.f190c != 2) {
                        TmcLogger.f("Prefetch:StrategyExecuteManager", "this strategy require wifi. push wait queue.");
                        lruCache.put(this.OooO00o, 0);
                        return;
                    }
                    Unit unit = Unit.f68710a;
                    String dataType = this.OooO00o.getDataType();
                    if (dataType != null) {
                        int iHashCode = dataType.hashCode();
                        if (iHashCode == 49) {
                            if (dataType.equals("1")) {
                                if (this.OooO00o.getMiniappType() == 2) {
                                    new o00O0O(this.OooO00o).a();
                                    return;
                                } else {
                                    new o0OoOo0(this.OooO00o).a();
                                    return;
                                }
                            }
                            return;
                        }
                        if (iHashCode == 50) {
                            if (dataType.equals("2")) {
                                new o000oOoO(this.OooO00o).a();
                            }
                        } else {
                            if (iHashCode == 52 && dataType.equals("4")) {
                                new Oooo0(this.OooO00o).a();
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                TmcLogger.h("Prefetch:StrategyExecuteManager", th2);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a implements NetworkUtils.b {
        public static final void b() {
            f fVar = f.f13872a;
            try {
                if (ByteAppManager.INSTANCE.getApplication$com_cloud_tmc_miniapp_sdk() != null) {
                    LruCache<String, PrefetchData> lruCache = f.f13873b;
                    if (lruCache.size() <= 0) {
                        TmcLogger.f("Prefetch:PrefetchConfigManager", "no recover request, request queue is empty.");
                    } else {
                        PrefetchData prefetchData = null;
                        for (String str : lruCache.snapshot().keySet()) {
                            LruCache<String, PrefetchData> lruCache2 = f.f13873b;
                            PrefetchData prefetchData2 = lruCache2.get(str);
                            if (prefetchData2 != null) {
                                lruCache2.remove(str);
                                prefetchData = prefetchData2;
                            }
                        }
                        if (prefetchData != null) {
                            TmcLogger.f("Prefetch:PrefetchConfigManager", "start recover config request.");
                            f.f13872a.c(prefetchData);
                        }
                    }
                }
            } catch (Throwable th2) {
                TmcLogger.h("Prefetch:PrefetchConfigManager", th2);
            }
            o0OOO0o o0ooo0o = o0OOO0o.f188a;
            try {
                LruCache<PrefetchConfigModel, Integer> lruCache3 = o0OOO0o.f192e;
                if (lruCache3.size() <= 0) {
                    TmcLogger.f("Prefetch:StrategyExecuteManager", "strategyWaitCache is empty.");
                } else {
                    Set<PrefetchConfigModel> setKeySet = lruCache3.snapshot().keySet();
                    lruCache3.evictAll();
                    o0ooo0o.c(CollectionsKt___CollectionsKt.J0(setKeySet), null);
                }
            } catch (Throwable th3) {
                TmcLogger.h("Prefetch:StrategyExecuteManager", th3);
            }
        }

        @Override // com.cloud.tmc.miniutils.util.NetworkUtils.b
        public void a(NetworkUtils.NetworkType networkType) {
            o0OOO0o.f189b = true;
            o0OOO0o.f190c = networkType == NetworkUtils.NetworkType.NETWORK_WIFI ? 2 : 1;
            StringBuilder sbA = j.a("network connected. netType=");
            sbA.append(o0OOO0o.f190c);
            TmcLogger.f("Prefetch:StrategyExecuteManager", sbA.toString());
            e.a(ExecutorType.IDLE, new Runnable() { // from class: b0.e
                @Override // java.lang.Runnable
                public final void run() {
                    o0OOO0o.a.b();
                }
            });
        }

        @Override // com.cloud.tmc.miniutils.util.NetworkUtils.b
        public void onDisconnected() {
            o0OOO0o.f190c = 0;
            o0OOO0o.f189b = false;
            TmcLogger.f("Prefetch:StrategyExecuteManager", "network disconnected.");
        }
    }

    static {
        boolean zR = NetworkUtils.r();
        f189b = zR;
        if (zR) {
            f190c = NetworkUtils.t() ? 1 : 2;
        }
        e.a(ExecutorType.IO, new Runnable() { // from class: b0.c
            @Override // java.lang.Runnable
            public final void run() {
                o0OOO0o.b();
            }
        });
        f193f = new ThreadPoolExecutor(1, 2, 60L, TimeUnit.SECONDS, new PriorityBlockingQueue(50, new Comparator() { // from class: b0.d
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return o0OOO0o.a((Runnable) obj, (Runnable) obj2);
            }
        }), new ThreadPoolExecutor.DiscardOldestPolicy());
    }

    public static final int a(Runnable runnable, Runnable runnable2) {
        PrefetchConfigModel prefetchConfigModel;
        PrefetchConfigModel prefetchConfigModel2;
        int priority = 0;
        try {
            OooO0O0 oooO0O0 = runnable instanceof OooO0O0 ? (OooO0O0) runnable : null;
            int priority2 = (oooO0O0 == null || (prefetchConfigModel2 = oooO0O0.OooO00o) == null) ? 0 : prefetchConfigModel2.getPriority();
            OooO0O0 oooO0O1 = runnable2 instanceof OooO0O0 ? (OooO0O0) runnable2 : null;
            if (oooO0O1 != null && (prefetchConfigModel = oooO0O1.OooO00o) != null) {
                priority = prefetchConfigModel.getPriority();
            }
            return priority2 - priority;
        } catch (Throwable th2) {
            TmcLogger.h("Prefetch:StrategyExecuteManager", th2);
            return 0;
        }
    }

    public static final void b() {
        NetworkUtils.y(new a());
        try {
            Application application$com_cloud_tmc_miniapp_sdk = ByteAppManager.INSTANCE.getApplication$com_cloud_tmc_miniapp_sdk();
            if (application$com_cloud_tmc_miniapp_sdk == null) {
                return;
            }
            Type type = new TypeToken<Set<PrefetchConfigModel>>() { // from class: com.cloud.tmc.miniapp.prestrategy.StrategyExecuteManager$recoverSource$setType$1
            }.getType();
            String string = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getString(application$com_cloud_tmc_miniapp_sdk, "mini_PrefetchData", "keyPrefetchSource");
            if (string != null && string.length() != 0) {
                Set set = (Set) k.e(string, type);
                if (set == null) {
                    return;
                }
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    f191d.put((PrefetchConfigModel) it.next(), 0);
                }
                return;
            }
            TmcLogger.f("Prefetch:StrategyExecuteManager", "no source strategy cache.");
        } catch (Throwable th2) {
            TmcLogger.h("Prefetch:StrategyExecuteManager", th2);
        }
    }

    public final void c(List<PrefetchConfigModel> list, Map<String, Bundle> map) {
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    boolean z11 = false;
                    for (PrefetchConfigModel prefetchConfigModel : list) {
                        String appId = prefetchConfigModel.getAppId();
                        if (appId == null || appId.length() == 0) {
                            TmcLogger.f("Prefetch:StrategyExecuteManager", "skip: appId is empty.");
                        } else if (Intrinsics.b(prefetchConfigModel.getDataType(), "3")) {
                            TmcLogger.f("Prefetch:StrategyExecuteManager", "skip: strategy is source.");
                            f191d.put(prefetchConfigModel, 0);
                            z11 = true;
                        } else {
                            if (prefetchConfigModel.getBundle() == null) {
                                prefetchConfigModel.setBundle(map != null ? map.get(prefetchConfigModel.getAppId()) : null);
                            }
                            f193f.execute(new OooO0O0(prefetchConfigModel));
                        }
                    }
                    if (z11) {
                        d();
                        return;
                    }
                    return;
                }
            } catch (Throwable th2) {
                TmcLogger.h("Prefetch:StrategyExecuteManager", th2);
                return;
            }
        }
        TmcLogger.f("Prefetch:StrategyExecuteManager", "executePreStrategy failed: strategyList is empty.");
    }

    public final void d() {
        Application application$com_cloud_tmc_miniapp_sdk = ByteAppManager.INSTANCE.getApplication$com_cloud_tmc_miniapp_sdk();
        LruCache<PrefetchConfigModel, Integer> lruCache = f191d;
        if (lruCache.size() <= 0 || application$com_cloud_tmc_miniapp_sdk == null) {
            return;
        }
        try {
            synchronized (lruCache) {
                ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putString(application$com_cloud_tmc_miniapp_sdk, "mini_PrefetchData", "keyPrefetchSource", k.j(lruCache.snapshot().keySet()));
                Unit unit = Unit.f68710a;
            }
        } catch (Throwable th2) {
            TmcLogger.h("Prefetch:StrategyExecuteManager", th2);
        }
    }
}
