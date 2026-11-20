package s;

import android.os.Bundle;
import com.cloud.tmc.integration.proxy.ReportProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppManager;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import com.cloud.tmc.miniutils.util.k;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.s;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f75901a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, a> f75902b = new LinkedHashMap();

    public final int a(int i11, int i12) {
        if (i11 == 2) {
            return i11;
        }
        if (i11 == 0) {
            return i12;
        }
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:57:0x012b  */
    /* JADX WARN: Code duplicated, block: B:65:0x0141 A[PHI: r5 r7
  0x0141: PHI (r5v13 long) = (r5v6 long), (r5v15 long), (r5v15 long), (r5v15 long) binds: [B:56:0x0128, B:58:0x012d, B:64:0x0140, B:60:0x0133] A[DONT_GENERATE, DONT_INLINE]
  0x0141: PHI (r7v6 long) = (r7v2 long), (r7v9 long), (r7v9 long), (r7v9 long) binds: [B:56:0x0128, B:58:0x012d, B:64:0x0140, B:60:0x0133] A[DONT_GENERATE, DONT_INLINE]] */
    public final void b(a appOpenPointData, Bundle data) {
        long j11;
        long j12;
        boolean z11;
        Bundle sceneParams;
        Intrinsics.g(appOpenPointData, "appOpenPointData");
        Intrinsics.g(data, "data");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("reportAppOpenSuccess =======> appOpenPointData:");
        sb2.append(appOpenPointData);
        sb2.append(", data:");
        sb2.append(data);
        try {
            if (appOpenPointData.f75899l) {
                return;
            }
            data.putString("openMiniAppResult", "true");
            data.putInt("syncType", (appOpenPointData.f75894g == 2 || appOpenPointData.f75895h == 2 || appOpenPointData.f75896i == 2 || appOpenPointData.f75897j == 2) ? 2 : 1);
            data.putString("openMiniAppFailedReason", "");
            data.putInt("maxStage", 17);
            data.putString("isExitInStage", "");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            long j13 = 0;
            long j14 = 0;
            for (int i11 = 1; i11 < 18; i11++) {
                String strValueOf = String.valueOf(i11);
                Long l11 = appOpenPointData.f75890c.get(strValueOf);
                long jLongValue = l11 != null ? l11.longValue() : 0L;
                Long l12 = appOpenPointData.f75891d.get(strValueOf);
                long jLongValue2 = l12 != null ? l12.longValue() : 0L;
                Long l13 = appOpenPointData.f75892e.get(strValueOf);
                linkedHashMap.put(strValueOf, Long.valueOf(l13 != null ? l13.longValue() : 0L));
                linkedHashMap2.put(strValueOf, new long[]{jLongValue, jLongValue2});
                if (i11 == 1) {
                    j13 = jLongValue;
                } else if (i11 == 17) {
                    j14 = jLongValue2;
                }
            }
            data.putString("stageCostTime", k.j(linkedHashMap));
            data.putString("stageRangeTime", k.j(linkedHashMap2));
            data.putString("page_path", String.valueOf(appOpenPointData.f75889b));
            appOpenPointData.f75900m = true;
            appOpenPointData.f75899l = true;
            data.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N);
            data.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W);
            String str = appOpenPointData.f75888a;
            try {
                App appFindApp = ((AppManager) tc.a.a(AppManager.class)).findApp(str);
                j11 = (appFindApp == null || (sceneParams = appFindApp.getSceneParams()) == null) ? 0L : sceneParams.getLong("start_main_first_time");
                if (appFindApp != null) {
                    try {
                        Bundle sceneParams2 = appFindApp.getSceneParams();
                        if (sceneParams2 != null) {
                            j12 = sceneParams2.getLong("start_mini_first_time");
                        } else {
                            j12 = 0;
                        }
                    } catch (Throwable unused) {
                        j12 = 0;
                    }
                } else {
                    j12 = 0;
                }
                if (appFindApp != null) {
                    try {
                        Bundle sceneParams3 = appFindApp.getSceneParams();
                        if (sceneParams3 != null) {
                            z11 = sceneParams3.getBoolean("mini_process_alive");
                        } else {
                            z11 = false;
                        }
                    } catch (Throwable unused2) {
                    }
                } else {
                    z11 = false;
                }
            } catch (Throwable unused3) {
                j11 = 0;
            }
            if (j11 != 0) {
                data.putLong("mini_first_time", j11);
            }
            if (j12 != 0) {
                data.putLong("mini_second_time", j12);
            }
            try {
                if (j11 != 0) {
                    TmcLogger.c("h5PointTrack", "firstStartTime:" + j11);
                    j13 = j11;
                } else if (j12 != 0) {
                    TmcLogger.c("h5PointTrack", "secondStartTime:" + j12);
                    j13 = j12;
                } else {
                    TmcLogger.c("h5PointTrack", "reportStartTime:" + j13);
                }
                data.putString("miniapp_all_start_time", String.valueOf(j14 - j13));
                data.putBoolean("is_mini_process_alive", z11);
                MiniAppLaunch.f31784a.n0(str, data);
                ((ReportProxy) tc.a.a(ReportProxy.class)).report(appOpenPointData.f75888a, "mini_app_open", data);
            } catch (Throwable unused4) {
            }
        } catch (Throwable th2) {
            TmcLogger.g("h5PointTrack", "Exception failed!", th2);
        }
    }

    public final boolean c(String str) {
        a aVar;
        if (str == null || (aVar = (a) ((LinkedHashMap) f75902b).get(str)) == null) {
            return false;
        }
        return aVar.f75900m;
    }

    public final boolean d(String str, Bundle data) {
        a aVar;
        String str2 = "false";
        Intrinsics.g(data, "data");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("recordAppStageFail =======> appId:");
        sb2.append(str);
        sb2.append(", data:");
        sb2.append(data);
        try {
            long j11 = data.containsKey(com.cloud.tmc.kernel.proxy.performanceanalyse.a.P) ? data.getLong(com.cloud.tmc.kernel.proxy.performanceanalyse.a.P) : System.currentTimeMillis();
            if (str == null || (aVar = (a) ((LinkedHashMap) f75902b).get(str)) == null) {
                return true;
            }
            data.putString("openMiniAppResult", "false");
            Iterator<Map.Entry<String, Long>> it = aVar.f75890c.entrySet().iterator();
            while (it.hasNext()) {
                String key = it.next().getKey();
                if (!aVar.f75891d.containsKey(key)) {
                    aVar.f75891d.put(key, Long.valueOf(j11));
                    Map<String, Long> map = aVar.f75892e;
                    Long l11 = aVar.f75891d.get(key);
                    Intrinsics.d(l11);
                    long jLongValue = l11.longValue();
                    Long l12 = aVar.f75890c.get(key);
                    Intrinsics.d(l12);
                    map.put(key, Long.valueOf(jLongValue - l12.longValue()));
                    str2 = "true";
                }
            }
            data.putString("isExitInStage", str2);
            b bVar = f75901a;
            data.putInt("syncType", bVar.a(bVar.a(bVar.a(bVar.a(0, aVar.f75894g), aVar.f75895h), aVar.f75897j), aVar.f75896i));
            int size = aVar.f75890c.size();
            data.putInt("maxStage", size);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            if (1 <= size) {
                int i11 = 1;
                while (true) {
                    String strValueOf = String.valueOf(i11);
                    Long l13 = aVar.f75890c.get(strValueOf);
                    long jLongValue2 = l13 != null ? l13.longValue() : 0L;
                    Long l14 = aVar.f75891d.get(strValueOf);
                    long jLongValue3 = l14 != null ? l14.longValue() : 0L;
                    Long l15 = aVar.f75892e.get(strValueOf);
                    linkedHashMap.put(strValueOf, Long.valueOf(l15 != null ? l15.longValue() : 0L));
                    linkedHashMap2.put(strValueOf, new long[]{jLongValue2, jLongValue3});
                    if (i11 == size) {
                        break;
                    }
                    i11++;
                }
            }
            data.putString("stageCostTime", k.j(linkedHashMap));
            data.putString("stageRangeTime", k.j(linkedHashMap2));
            data.putString("page_path", String.valueOf(aVar.f75889b));
            MiniAppLaunch.f31784a.n0(str, data);
            data.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N);
            data.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W);
            ((ReportProxy) tc.a.a(ReportProxy.class)).report(aVar.f75888a, "mini_app_open", data);
            aVar.f75899l = true;
            if (!aVar.f75898k) {
                r.b bVar2 = r.b.f75020a;
                Bundle bundle = new Bundle();
                bundle.putString("isExitInStage", str2);
                Unit unit = Unit.f68710a;
                bVar2.a(aVar, null, bundle);
            }
        } catch (Throwable unused) {
        }
        return true;
    }

    public final boolean e(String stage, String str, Bundle data) {
        Intrinsics.g(stage, "stage");
        Intrinsics.g(data, "data");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("recordAppStageEnd =======> stage:");
        sb2.append(stage);
        sb2.append(", appId:");
        sb2.append(str);
        sb2.append(", data:");
        sb2.append(data);
        try {
            long j11 = data.containsKey(com.cloud.tmc.kernel.proxy.performanceanalyse.a.P) ? data.getLong(com.cloud.tmc.kernel.proxy.performanceanalyse.a.P) : System.currentTimeMillis();
            if (str != null) {
                b bVar = f75901a;
                a aVar = (a) ((LinkedHashMap) f75902b).get(str);
                if (aVar == null || !aVar.f75890c.containsKey(stage) || aVar.f75891d.containsKey(stage)) {
                    return true;
                }
                aVar.f75891d.put(stage, Long.valueOf(j11));
                Map<String, Long> map = aVar.f75892e;
                Long l11 = aVar.f75891d.get(stage);
                Intrinsics.d(l11);
                long jLongValue = l11.longValue();
                Long l12 = aVar.f75890c.get(stage);
                Intrinsics.d(l12);
                map.put(stage, Long.valueOf(jLongValue - l12.longValue()));
                if (Intrinsics.b(stage, com.cloud.tmc.kernel.proxy.performanceanalyse.a.K)) {
                    bVar.b(aVar, data);
                }
            }
        } catch (Throwable unused) {
        }
        return true;
    }

    public final boolean f(String str, Bundle data) {
        Intrinsics.g(data, "data");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("recordAppStageFinish =======> appId:");
        sb2.append(str);
        sb2.append(", data:");
        sb2.append(data);
        if (str != null) {
            try {
                b bVar = f75901a;
                Map<String, a> map = f75902b;
                a aVar = (a) ((LinkedHashMap) map).get(str);
                if (aVar == null) {
                    return true;
                }
                if (aVar.f75899l) {
                    map.remove(str);
                    return true;
                }
                data.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31208e0, "小程序关闭");
                bVar.d(str, data);
                map.remove(str);
            } catch (Throwable unused) {
            }
        }
        return true;
    }

    public final boolean g(String stage, String str, Bundle data) {
        Intrinsics.g(stage, "stage");
        Intrinsics.g(data, "data");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("recordAppStageStart =======> stage:");
        sb2.append(stage);
        sb2.append(", appId:");
        sb2.append(str);
        sb2.append(", data:");
        sb2.append(data);
        try {
            long j11 = data.containsKey(com.cloud.tmc.kernel.proxy.performanceanalyse.a.P) ? data.getLong(com.cloud.tmc.kernel.proxy.performanceanalyse.a.P) : System.currentTimeMillis();
            if (str != null) {
                if (Intrinsics.b(stage, com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31233u)) {
                    Map<String, a> map = f75902b;
                    if (map.containsKey(str)) {
                        map.remove(str);
                    }
                    map.put(str, new a(str, null, s.l(TuplesKt.a(stage, Long.valueOf(j11))), new LinkedHashMap(), new LinkedHashMap(), new LinkedHashMap(), 0, 0, 0, 0, false, false, false));
                } else {
                    a aVar = (a) ((LinkedHashMap) f75902b).get(str);
                    if (aVar == null || aVar.f75890c.containsKey(stage)) {
                        return true;
                    }
                    aVar.f75890c.put(stage, Long.valueOf(j11));
                    if (Intrinsics.b(stage, com.cloud.tmc.kernel.proxy.performanceanalyse.a.F)) {
                        aVar.f75898k = true;
                        aVar.f75889b = data.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, "");
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return true;
    }

    public final boolean h(String str, Bundle data) {
        Intrinsics.g(data, "data");
        if (str != null) {
            try {
                a aVar = (a) ((LinkedHashMap) f75902b).get(str);
                if (aVar == null) {
                    return true;
                }
                int i11 = data.getInt(com.cloud.tmc.kernel.proxy.performanceanalyse.a.Y, -1);
                if (i11 != -1) {
                    aVar.f75895h = i11;
                }
                int i12 = data.getInt(com.cloud.tmc.kernel.proxy.performanceanalyse.a.Z, -1);
                if (i12 != -1) {
                    aVar.f75894g = i12;
                }
                int i13 = data.getInt(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31200a0, -1);
                if (i13 != -1) {
                    aVar.f75897j = i13;
                }
                int i14 = data.getInt(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31204c0, -1);
                if (i14 != -1) {
                    aVar.f75896i = i14;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("recordAppStageInsert ==> updateFrameworkMode:");
                sb2.append(i11);
                sb2.append(", updateAppMode:");
                sb2.append(i12);
                sb2.append(", downloadFrameworkMode:");
                sb2.append(i13);
                sb2.append(", downloadAppMode:");
                sb2.append(i14);
            } catch (Throwable unused) {
            }
        }
        return true;
    }
}
