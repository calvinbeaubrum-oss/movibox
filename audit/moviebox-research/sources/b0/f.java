package b0;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.LruCache;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.model.LauncherPreDataModel;
import com.cloud.tmc.integration.utils.h;
import com.cloud.tmc.integration.utils.n0;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.network.INetWorkProxy;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.utils.AppDynamicBuildConfig;
import com.cloud.tmc.kernel.utils.r;
import com.cloud.tmc.miniapp.prestrategy.PreStrategyManager;
import com.cloud.tmc.miniapp.prestrategy.PrefetchConfigManager$requestStrategyConfig$4;
import com.cloud.tmc.miniapp.prestrategy.PrefetchData;
import com.cloud.tmc.miniutils.util.NetworkUtils;
import com.transsion.push.PushConstants;
import hd.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.TuplesKt;
import kotlin.collections.s;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.l;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f13872a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LruCache<String, PrefetchData> f13873b = new LruCache<>(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f13874c = 43200000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f13875d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicInteger f13876e = new AtomicInteger(0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map<String, String> f13877f = s.l(TuplesKt.a("keyZeroRecentData", "100002"), TuplesKt.a("keyZeroMinicardData", "100001"), TuplesKt.a("keyZeroMinicardUpdate", "100001"), TuplesKt.a("keyFullRecentMiniData", "100004"), TuplesKt.a("keyFullMinicardData", "100006"), TuplesKt.a("keyAzRecentData", "100007"), TuplesKt.a("keyFullSearchAppData", "100005"), TuplesKt.a("keyZeroBannerData", "100003"));

    public final void a(Context context, String str, ArrayList<LauncherPreDataModel> arrayList) {
        if (arrayList.isEmpty() || str == null || str.length() == 0 || context == null) {
            TmcLogger.f("Prefetch:PrefetchConfigManager", "requestStrategyConfig failed: param is invalid.");
            return;
        }
        Map<String, Bundle> linkedHashMap = new LinkedHashMap<>();
        ArrayList arrayList2 = new ArrayList();
        for (LauncherPreDataModel launcherPreDataModel : arrayList) {
            String appId = launcherPreDataModel.getAppId();
            Bundle bundle = new Bundle();
            if (appId == null || appId.length() == 0) {
                String schemeUrl = launcherPreDataModel.getSchemeUrl();
                if (schemeUrl == null || schemeUrl.length() == 0) {
                    PreStrategyManager preStrategyManager = PreStrategyManager.f31651a;
                    TmcLogger.f("Prefetch:PreStrategyManager", "preStrategyProcessing schemeUrl is null");
                } else {
                    boolean zB = MiniAppConfigHelper.f30370a.b("fixEncodeUrl", true);
                    n0 n0Var = n0.f31078a;
                    Uri uri = Uri.parse(n0Var.c(schemeUrl, zB));
                    String queryParameter = uri.getQueryParameter(PushConstants.PROVIDER_FIELD_APP_ID);
                    if (queryParameter == null || queryParameter.length() == 0) {
                        PreStrategyManager preStrategyManager2 = PreStrategyManager.f31651a;
                        TmcLogger.f("Prefetch:PreStrategyManager", "preStrategyProcessing appId is null");
                    } else {
                        String it = uri.getQueryParameter("query");
                        if (it != null) {
                            Intrinsics.f(it, "it");
                            bundle.putString("query", n0Var.d(it, zB));
                        }
                        String it2 = uri.getQueryParameter("h5Path");
                        if (it2 != null) {
                            Intrinsics.f(it2, "it");
                            bundle.putString("h5Path", n0Var.d(it2, zB));
                        }
                        String queryParameter2 = uri.getQueryParameter("hybridPath");
                        if (queryParameter2 != null) {
                            String strD = r.d(queryParameter2);
                            if (strD == null) {
                                strD = "";
                            }
                            Intrinsics.f(strD, "UrlUtils.decode(it) ?: \"\"");
                            bundle.putString("hybridPath", n0Var.d(strD, zB));
                        }
                        launcherPreDataModel.setAppId(queryParameter);
                        launcherPreDataModel.setBundle(bundle);
                        if (queryParameter != null && queryParameter.length() != 0) {
                            linkedHashMap.put(queryParameter, bundle);
                            appId = queryParameter;
                        }
                    }
                }
            }
            if (appId != null && appId.length() != 0 && !arrayList2.contains(appId)) {
                arrayList2.add(appId);
            }
        }
        b(context, str, arrayList2, linkedHashMap);
    }

    public final void b(Context context, String scene, List<String> appIdList, Map<String, Bundle> map) {
        Intrinsics.g(context, "context");
        Intrinsics.g(scene, "scene");
        Intrinsics.g(appIdList, "appIdList");
        try {
            if (f13876e.get() == 1) {
                TmcLogger.f("Prefetch:PrefetchConfigManager", "last request is executing. " + scene + " skip.");
                return;
            }
            String str = f13877f.get(scene);
            String str2 = str == null ? scene : str;
            if (l.L(scene, "key", false, 2, null)) {
                TmcLogger.f("Prefetch:PrefetchConfigManager", "sceneId:" + scene + " is invalid. skip.");
                return;
            }
            Collections.sort(appIdList);
            String str3 = "";
            Iterator<T> it = appIdList.iterator();
            while (it.hasNext()) {
                str3 = str3 + ((String) it.next()) + ',';
            }
            if (str3.length() == 0) {
                TmcLogger.f("Prefetch:PrefetchConfigManager", scene + " requestStrategyConfig failed: appId is invalid.");
                return;
            }
            int i11 = -1;
            int length = str3.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i12 = length - 1;
                    if (str3.charAt(length) == ',') {
                        i11 = length;
                        break;
                    } else if (i12 < 0) {
                        break;
                    } else {
                        length = i12;
                    }
                }
            }
            Intrinsics.f(str3.substring(i11), "this as java.lang.String).substring(startIndex)");
            long j11 = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getLong(context, "mini_PrefetchData", str2);
            long jCurrentTimeMillis = System.currentTimeMillis();
            PrefetchData prefetchData = new PrefetchData(str2, str3, map);
            if (!NetworkUtils.r()) {
                f13873b.put(str2, prefetchData);
                TmcLogger.f("Prefetch:PrefetchConfigManager", str2 + " network is not connected. push wait queue.");
                return;
            }
            long jD = MiniAppConfigHelper.f30370a.d("prefetchFreshTime", f13874c);
            if (jCurrentTimeMillis - j11 >= jD) {
                ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putLong(context, "mini_PrefetchData", str2, jCurrentTimeMillis);
                c(prefetchData);
                return;
            }
            TmcLogger.f("Prefetch:PrefetchConfigManager", "sceneId:" + str2 + " fetch time < " + jD);
        } catch (Throwable th2) {
            TmcLogger.h("Prefetch:PrefetchConfigManager", th2);
        }
    }

    public final void c(PrefetchData prefetchData) {
        String appIds;
        String sceneId = prefetchData.getSceneId();
        if (sceneId == null || sceneId.length() == 0 || (appIds = prefetchData.getAppIds()) == null || appIds.length() == 0) {
            StringBuilder sbA = j.a("request abort. ");
            sbA.append(prefetchData.getSceneId());
            sbA.append(" or ");
            sbA.append(prefetchData.getAppIds());
            sbA.append(" is invalid.");
            TmcLogger.f("Prefetch:PrefetchConfigManager", sbA.toString());
            return;
        }
        if (!f13876e.compareAndSet(0, f13875d)) {
            StringBuilder sbA2 = j.a("(sceneId=");
            sbA2.append(prefetchData.getSceneId());
            sbA2.append(") request abort. last request not finish.");
            TmcLogger.f("Prefetch:PrefetchConfigManager", sbA2.toString());
            return;
        }
        StringBuilder sbA3 = j.a("requestStrategyConfig start. sceneId:");
        sbA3.append(prefetchData.getSceneId());
        sbA3.append(", appIds=");
        sbA3.append(prefetchData.getAppIds());
        TmcLogger.f("Prefetch:PrefetchConfigManager", sbA3.toString());
        String strE = MiniAppConfigHelper.f30370a.e("prefetchConfigUrl", AppDynamicBuildConfig.o() + "miniapp/platform/consumer-not-login/commonPrefetch/query/getPrefetchStrategyByCdn");
        StringBuilder sbA4 = j.a(com.cloud.tmc.offline.download.utils.g.f32096a.b());
        sbA4.append(prefetchData.getSceneId());
        sbA4.append(prefetchData.getAppIds());
        ((INetWorkProxy) tc.a.a(INetWorkProxy.class)).get(strE, new LinkedHashMap(), s.l(TuplesKt.a("sceneId", prefetchData.getSceneId()), TuplesKt.a("miniappIds", prefetchData.getAppIds()), TuplesKt.a("cacheCDNKey", h.f31061a.v(sbA4.toString()))), Boolean.TRUE, new PrefetchConfigManager$requestStrategyConfig$4(prefetchData));
    }

    public final boolean d() {
        return MiniAppConfigHelper.f30370a.b("prefetchV2Enable", true);
    }
}
