package r;

import android.os.Bundle;
import android.text.TextUtils;
import com.cloud.tmc.integration.proxy.ReportProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppManager;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.cloud.tmc.miniutils.util.k;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;
import kd.l;
import kotlin.TuplesKt;
import kotlin.collections.s;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f75020a = new b();

    /* JADX WARN: Code duplicated, block: B:84:0x01f7 A[PHI: r14
  0x01f7: PHI (r14v6 long) = (r14v4 long), (r14v9 long) binds: [B:82:0x01f0, B:75:0x01d0] A[DONT_GENERATE, DONT_INLINE]] */
    public final void a(s.a appOpenPointData, a aVar, Bundle data) {
        int i11;
        int size;
        long jLongValue;
        long jLongValue2;
        long jLongValue3;
        long j11;
        long jLongValue4;
        String str = "false";
        Intrinsics.g(appOpenPointData, "appOpenPointData");
        Intrinsics.g(data, "data");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("reportPageOpenFail #########> appOpenPointData:");
        sb2.append(appOpenPointData);
        sb2.append(", pageOpenPointData:");
        sb2.append(aVar);
        sb2.append(", data");
        sb2.append(data);
        try {
            long j12 = data.containsKey(com.cloud.tmc.kernel.proxy.performanceanalyse.a.P) ? data.getLong(com.cloud.tmc.kernel.proxy.performanceanalyse.a.P) : System.currentTimeMillis();
            data.putString("openPageResult", "false");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            if (aVar == null) {
                size = appOpenPointData.f75890c.size();
                if (1 <= size) {
                    int i12 = 1;
                    while (true) {
                        String strValueOf = String.valueOf(i12);
                        Long l11 = appOpenPointData.f75890c.get(strValueOf);
                        long jLongValue5 = l11 != null ? l11.longValue() : 0L;
                        Long l12 = appOpenPointData.f75891d.get(strValueOf);
                        long jLongValue6 = l12 != null ? l12.longValue() : 0L;
                        Long l13 = appOpenPointData.f75892e.get(strValueOf);
                        linkedHashMap.put(strValueOf, Long.valueOf(l13 != null ? l13.longValue() : 0L));
                        linkedHashMap2.put(strValueOf, new long[]{jLongValue5, jLongValue6});
                        if (i12 == size) {
                            break;
                        } else {
                            i12++;
                        }
                    }
                }
            } else {
                int size2 = aVar.f75014c.size() + 11;
                Iterator<Map.Entry<String, Long>> it = aVar.f75014c.entrySet().iterator();
                while (it.hasNext()) {
                    String key = it.next().getKey();
                    if (!aVar.f75015d.containsKey(key)) {
                        aVar.f75015d.put(key, Long.valueOf(j12));
                        Map<String, Long> map = aVar.f75016e;
                        Long l14 = aVar.f75015d.get(key);
                        Intrinsics.d(l14);
                        long jLongValue7 = l14.longValue();
                        Long l15 = aVar.f75014c.get(key);
                        Intrinsics.d(l15);
                        map.put(key, Long.valueOf(jLongValue7 - l15.longValue()));
                        str = "true";
                    }
                }
                data.putString("isExitInStage", str);
                int i13 = 1;
                while (true) {
                    i11 = 12;
                    if (i13 >= 12) {
                        break;
                    }
                    String strValueOf2 = String.valueOf(i13);
                    if (aVar.f75017f) {
                        Long l16 = appOpenPointData.f75890c.get(strValueOf2);
                        jLongValue3 = l16 != null ? l16.longValue() : 0L;
                        Long l17 = appOpenPointData.f75891d.get(strValueOf2);
                        jLongValue4 = l17 != null ? l17.longValue() : 0L;
                        Long l18 = appOpenPointData.f75892e.get(strValueOf2);
                        linkedHashMap.put(strValueOf2, Long.valueOf(l18 != null ? l18.longValue() : 0L));
                    } else {
                        Long l19 = aVar.f75014c.get(PrepareException.ERROR_LOCAL_DATA_FILE_SCAN);
                        jLongValue3 = l19 != null ? l19.longValue() : 0L;
                        Long l21 = aVar.f75014c.get(PrepareException.ERROR_LOCAL_DATA_FILE_SCAN);
                        if (l21 != null) {
                            jLongValue4 = l21.longValue();
                            j11 = 0;
                        } else {
                            j11 = 0;
                            jLongValue4 = 0;
                        }
                        linkedHashMap.put(strValueOf2, Long.valueOf(j11));
                    }
                    linkedHashMap2.put(strValueOf2, new long[]{jLongValue3, jLongValue4});
                    i13++;
                }
                if (12 <= size2) {
                    while (true) {
                        String strValueOf3 = String.valueOf(i11);
                        if (aVar.f75017f || !(Intrinsics.b(strValueOf3, PrepareException.ERROR_FILE2VURL_MINIAPP_FILE_EXCEPTION) || Intrinsics.b(strValueOf3, "16"))) {
                            Long l22 = aVar.f75014c.get(strValueOf3);
                            jLongValue = l22 != null ? l22.longValue() : 0L;
                            Long l23 = aVar.f75015d.get(strValueOf3);
                            if (l23 != null) {
                                jLongValue2 = l23.longValue();
                            } else {
                                jLongValue2 = 0;
                            }
                        } else {
                            Long l24 = aVar.f75015d.get(PrepareException.ERROR_FILE2VURL_FRAMEWORK_FILE_EXCEPTION);
                            jLongValue = l24 != null ? l24.longValue() : 0L;
                            Long l25 = aVar.f75015d.get(PrepareException.ERROR_FILE2VURL_FRAMEWORK_FILE_EXCEPTION);
                            if (l25 != null) {
                                jLongValue2 = l25.longValue();
                            } else {
                                jLongValue2 = 0;
                            }
                        }
                        Long l26 = aVar.f75016e.get(strValueOf3);
                        linkedHashMap.put(strValueOf3, Long.valueOf(l26 != null ? l26.longValue() : 0L));
                        linkedHashMap2.put(strValueOf3, new long[]{jLongValue, jLongValue2});
                        if (i11 == size2) {
                            break;
                        } else {
                            i11++;
                        }
                    }
                }
                size = size2;
            }
            data.putInt("maxStage", size);
            data.putString("stageCostTime", k.j(linkedHashMap));
            data.putString("stageRangeTime", k.j(linkedHashMap2));
            data.putString("page_path", String.valueOf(aVar != null ? aVar.f75012a : null));
            if (aVar != null) {
                aVar.f75018g = true;
            }
            data.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N);
            data.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W);
            ((ReportProxy) tc.a.a(ReportProxy.class)).report(appOpenPointData.f75888a, "mini_page_open", data);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:55:0x0141 A[PHI: r9
  0x0141: PHI (r9v12 long) = (r9v10 long), (r9v21 long) binds: [B:53:0x013a, B:46:0x011a] A[DONT_GENERATE, DONT_INLINE]] */
    public final void b(s.a aVar, a aVar2, Bundle bundle, boolean z11) {
        int i11;
        long j11;
        App appFindApp;
        l lVar;
        Stack<com.cloud.tmc.miniapp.base.a> stackA;
        long jLongValue;
        long jLongValue2;
        long jLongValue3;
        long jLongValue4;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("reportPageOpenSuccess #########> appOpenPointData:");
        sb2.append(aVar);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("reportPageOpenSuccess #########> pageOpenPointData:");
        sb3.append(aVar2);
        StringBuilder sb4 = new StringBuilder();
        sb4.append("reportPageOpenSuccess #########> data:");
        sb4.append(bundle);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("reportPageOpenSuccess #########> isHomePage:");
        sb5.append(z11);
        try {
            if (aVar2.f75019h) {
                return;
            }
            bundle.putString("openPageResult", "true");
            bundle.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31210f0, "");
            bundle.putInt("maxStage", 17);
            bundle.putString("isExitInStage", "");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            int i12 = 1;
            while (true) {
                i11 = 12;
                j11 = 0;
                if (i12 >= 12) {
                    break;
                }
                String strValueOf = String.valueOf(i12);
                if (z11) {
                    Long l11 = aVar.f75890c.get(strValueOf);
                    jLongValue3 = l11 != null ? l11.longValue() : 0L;
                    Long l12 = aVar.f75891d.get(strValueOf);
                    jLongValue4 = l12 != null ? l12.longValue() : 0L;
                    Long l13 = aVar.f75892e.get(strValueOf);
                    linkedHashMap.put(strValueOf, Long.valueOf(l13 != null ? l13.longValue() : 0L));
                } else {
                    Long l14 = aVar2.f75014c.get(PrepareException.ERROR_LOCAL_DATA_FILE_SCAN);
                    jLongValue3 = l14 != null ? l14.longValue() : 0L;
                    Long l15 = aVar2.f75014c.get(PrepareException.ERROR_LOCAL_DATA_FILE_SCAN);
                    jLongValue4 = l15 != null ? l15.longValue() : 0L;
                    linkedHashMap.put(strValueOf, 0L);
                }
                linkedHashMap2.put(strValueOf, new long[]{jLongValue3, jLongValue4});
                i12++;
            }
            while (i11 < 18) {
                String strValueOf2 = String.valueOf(i11);
                if (z11 || !(Intrinsics.b(strValueOf2, PrepareException.ERROR_FILE2VURL_MINIAPP_FILE_EXCEPTION) || Intrinsics.b(strValueOf2, "16"))) {
                    Long l16 = aVar2.f75014c.get(strValueOf2);
                    jLongValue = l16 != null ? l16.longValue() : 0L;
                    Long l17 = aVar2.f75015d.get(strValueOf2);
                    if (l17 != null) {
                        jLongValue2 = l17.longValue();
                    } else {
                        jLongValue2 = 0;
                    }
                } else {
                    Long l18 = aVar2.f75015d.get(PrepareException.ERROR_FILE2VURL_FRAMEWORK_FILE_EXCEPTION);
                    jLongValue = l18 != null ? l18.longValue() : j11;
                    Long l19 = aVar2.f75015d.get(PrepareException.ERROR_FILE2VURL_FRAMEWORK_FILE_EXCEPTION);
                    if (l19 != null) {
                        jLongValue2 = l19.longValue();
                    } else {
                        jLongValue2 = 0;
                    }
                }
                Long l21 = aVar2.f75016e.get(strValueOf2);
                linkedHashMap.put(strValueOf2, Long.valueOf(l21 != null ? l21.longValue() : 0L));
                linkedHashMap2.put(strValueOf2, new long[]{jLongValue, jLongValue2});
                i11++;
                j11 = 0;
            }
            bundle.putString("stageCostTime", k.j(linkedHashMap));
            bundle.putString("stageRangeTime", k.j(linkedHashMap2));
            bundle.putString("page_path", String.valueOf(aVar2.f75012a));
            aVar2.f75019h = true;
            bundle.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N);
            bundle.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W);
            if (Intrinsics.b(bundle.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31212g0), "2") && (appFindApp = ((AppManager) tc.a.a(AppManager.class)).findApp(aVar.f75888a)) != null && (lVar = (l) appFindApp.getData(l.class)) != null && (stackA = lVar.a()) != null) {
                for (com.cloud.tmc.miniapp.base.a aVar3 : stackA) {
                    if (Intrinsics.b(aVar3.i(), aVar2.f75012a)) {
                        bundle.putString("page_path", String.valueOf(aVar3.g()));
                    }
                }
            }
            ((ReportProxy) tc.a.a(ReportProxy.class)).report(aVar.f75888a, "mini_page_open", bundle);
        } catch (Throwable unused) {
        }
    }

    public final boolean c(String str, Bundle data) {
        a aVar;
        Intrinsics.g(data, "data");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("reportPageOpenFinish #########> appId:");
        sb2.append(str);
        sb2.append(", data:");
        sb2.append(data);
        if (str != null) {
            try {
                s.a aVar2 = (s.a) ((LinkedHashMap) s.b.f75902b).get(str);
                if (aVar2 == null) {
                    return true;
                }
                String string = data.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W, "");
                if (TextUtils.isEmpty(string) || (aVar = aVar2.f75893f.get(string)) == null || !Intrinsics.b(aVar.f75013b, string)) {
                    return true;
                }
                if (!Intrinsics.b(aVar.f75012a, data.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, ""))) {
                    return true;
                }
                if (aVar.f75019h) {
                    aVar2.f75893f.remove(string);
                    return true;
                }
                if (aVar.f75018g) {
                    aVar2.f75893f.remove(string);
                    return true;
                }
                f75020a.a(aVar2, aVar, data);
                aVar2.f75893f.remove(string);
            } catch (Throwable unused) {
            }
        }
        return true;
    }

    public final boolean d(String stage, String str, Bundle data) {
        a aVar;
        Intrinsics.g(stage, "stage");
        Intrinsics.g(data, "data");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("recordPageStageEnd #########> stage:");
        sb2.append(stage);
        sb2.append(", appId:");
        sb2.append(str);
        sb2.append(", data:");
        sb2.append(data);
        try {
            long j11 = data.containsKey(com.cloud.tmc.kernel.proxy.performanceanalyse.a.P) ? data.getLong(com.cloud.tmc.kernel.proxy.performanceanalyse.a.P) : System.currentTimeMillis();
            s.a aVar2 = (s.a) ((LinkedHashMap) s.b.f75902b).get(str);
            if (aVar2 == null) {
                return true;
            }
            String string = data.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W, "");
            if (TextUtils.isEmpty(string) || (aVar = aVar2.f75893f.get(string)) == null || !Intrinsics.b(aVar.f75013b, string)) {
                return true;
            }
            if (!Intrinsics.b(aVar.f75012a, data.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, "")) || !aVar.f75014c.containsKey(stage)) {
                return true;
            }
            aVar.f75015d.put(stage, Long.valueOf(j11));
            Map<String, Long> map = aVar.f75016e;
            Long l11 = aVar.f75015d.get(stage);
            Intrinsics.d(l11);
            long jLongValue = l11.longValue();
            Long l12 = aVar.f75014c.get(stage);
            Intrinsics.d(l12);
            map.put(stage, Long.valueOf(jLongValue - l12.longValue()));
            if (Intrinsics.b(stage, com.cloud.tmc.kernel.proxy.performanceanalyse.a.K)) {
                b(aVar2, aVar, data, aVar.f75017f);
            }
        } catch (Throwable unused) {
        }
        return true;
    }

    public final boolean e(String stage, String str, Bundle data) {
        Intrinsics.g(stage, "stage");
        Intrinsics.g(data, "data");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("recordPageStageStart #########> stage:");
        sb2.append(stage);
        sb2.append(", appId:");
        sb2.append(str);
        sb2.append(", data:");
        sb2.append(data);
        try {
            long j11 = data.containsKey(com.cloud.tmc.kernel.proxy.performanceanalyse.a.P) ? data.getLong(com.cloud.tmc.kernel.proxy.performanceanalyse.a.P) : System.currentTimeMillis();
            s.a aVar = (s.a) ((LinkedHashMap) s.b.f75902b).get(str);
            if (aVar == null) {
                return true;
            }
            String pageId = data.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W, "");
            if (TextUtils.isEmpty(pageId)) {
                return true;
            }
            String pagePath = data.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, "");
            if (Intrinsics.b(stage, com.cloud.tmc.kernel.proxy.performanceanalyse.a.F)) {
                if (aVar.f75893f.containsKey(pageId)) {
                    aVar.f75893f.remove(pageId);
                }
                Map mapL = s.l(TuplesKt.a(stage, Long.valueOf(j11)));
                boolean zIsEmpty = aVar.f75893f.isEmpty();
                Map<String, a> map = aVar.f75893f;
                Intrinsics.f(pageId, "pageId");
                Intrinsics.f(pagePath, "pagePath");
                map.put(pageId, new a(pagePath, pageId, mapL, new LinkedHashMap(), new LinkedHashMap(), zIsEmpty, false, false));
            } else {
                a aVar2 = aVar.f75893f.get(pageId);
                if (aVar2 == null) {
                    return true;
                }
                aVar2.f75014c.put(stage, Long.valueOf(j11));
            }
            return true;
        } catch (Throwable unused) {
        }
    }
}
