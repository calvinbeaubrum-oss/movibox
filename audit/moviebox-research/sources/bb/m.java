package bb;

import android.os.Bundle;
import com.cloud.tmc.integration.chain.page.PageChainContext;
import com.cloud.tmc.integration.proxy.ReportProxy;
import com.cloud.tmc.integration.utils.q;
import com.cloud.tmc.kernel.log.TmcLogger;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@SourceDebugExtension
public final class m implements ab.a {
    private final boolean a(wa.a aVar, Map<String, List<Long>> map, Map<String, Long> map2, int i11) {
        TmcLogger.c("chainPoint", m.class.getName() + "_appendStagesOnFail");
        if (aVar.q().isEmpty()) {
            return false;
        }
        PageChainContext pageChainContextPeek = aVar.q().peek();
        map.putAll(aVar.u());
        map2.putAll(aVar.t());
        int i12 = 12;
        if (12 <= i11) {
            while (true) {
                List<Long> list = pageChainContextPeek.s().get(String.valueOf(i12));
                if (list != null) {
                    map.put(String.valueOf(i12), list);
                }
                Long l11 = pageChainContextPeek.r().get(String.valueOf(i12));
                if (l11 != null) {
                    map2.put(String.valueOf(i12), Long.valueOf(l11.longValue()));
                }
                if (i12 == i11) {
                    break;
                }
                i12++;
            }
        }
        List<Long> list2 = map.get(String.valueOf(i11));
        if (list2 == null || list2.size() != 1) {
            return false;
        }
        list2.add(Long.valueOf(System.currentTimeMillis()));
        map2.put(String.valueOf(i11), Long.valueOf(list2.get(1).longValue() - list2.get(0).longValue()));
        return true;
    }

    private final boolean b(wa.a aVar, Map<String, List<Long>> map, Map<String, Long> map2, int i11) {
        TmcLogger.c("chainPoint", m.class.getName() + "_appendStagesOnSuccess");
        for (int i12 = 1; i12 < 18; i12++) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            map2.put(String.valueOf(i12), 0L);
            map.put(String.valueOf(i12), kotlin.collections.g.h(Long.valueOf(jCurrentTimeMillis), Long.valueOf(jCurrentTimeMillis)));
        }
        return false;
    }

    private final void d(wa.a aVar, Bundle bundle) {
        TmcLogger.c("chainPoint", m.class.getName() + "_reportAppOpenEndFail");
        Bundle bundle2 = new Bundle();
        bundle2.putAll(bundle);
        bundle2.putString("openMiniAppResult", "false");
        bundle2.putString("openMiniAppFailedReason", aVar.o());
        bundle2.putInt("syncType", Intrinsics.b(aVar.n(), "0") ? aVar.v() : 0);
        bundle2.putString("open_channel", aVar.n());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        bundle2.putString("isExitInStage", String.valueOf(a(aVar, linkedHashMap, linkedHashMap2, 18)));
        bundle2.putInt("maxStage", linkedHashMap.size());
        bundle2.putString("stageCostTime", com.cloud.tmc.miniutils.util.k.j(linkedHashMap2));
        bundle2.putString("stageRangeTime", com.cloud.tmc.miniutils.util.k.j(linkedHashMap));
        bundle2.putString("scene", aVar.s());
        if (aVar.q().size() > 0) {
            PageChainContext pageChainContextPeek = aVar.q().peek();
            bundle2.putString("pageUniqueId", q.d() + '_' + pageChainContextPeek.p());
            bundle2.putString("page_path", String.valueOf(pageChainContextPeek.o()));
        }
        bundle2.putString("openedPageCount", String.valueOf(aVar.p().get()));
        bundle2.putString("appH5ProgressStatus", aVar.j());
        bundle2.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N);
        bundle2.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W);
        ((ReportProxy) tc.a.a(ReportProxy.class)).report(aVar.g(), "mini_app_open_end", bundle2);
    }

    private final void e(wa.a aVar, Bundle bundle) {
        TmcLogger.c("chainPoint", m.class.getName() + "_reportAppOpenMidSuccess");
        Bundle bundle2 = new Bundle();
        bundle2.putAll(bundle);
        bundle2.putString("pageIndex", "1");
        bundle2.putInt("maxStage", 17);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        b(aVar, linkedHashMap, linkedHashMap2, 17);
        bundle2.putString("stageCostTime", com.cloud.tmc.miniutils.util.k.j(linkedHashMap2));
        bundle2.putString("stageRangeTime", com.cloud.tmc.miniutils.util.k.j(linkedHashMap));
        bundle2.putString("openMiniAppResult", "true");
        bundle2.putString("openMiniAppFailedReason", "");
        bundle2.putInt("syncType", Intrinsics.b(aVar.n(), "0") ? aVar.v() : 0);
        bundle2.putString("isExitInStage", "false");
        bundle2.putString("open_channel", aVar.n());
        bundle2.putString("scene", aVar.s());
        bundle2.putString("openByLaunch", "true");
        if (aVar.q().size() > 0) {
            PageChainContext pageChainContextPeek = aVar.q().peek();
            bundle2.putString("pageUniqueId", q.d() + '_' + pageChainContextPeek.p());
            bundle2.putString("page_path", String.valueOf(pageChainContextPeek.o()));
        }
        bundle2.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N);
        bundle2.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W);
        ((ReportProxy) tc.a.a(ReportProxy.class)).report(aVar.g(), "mini_app_open_mid", bundle2);
    }

    private final void h(wa.a aVar, Bundle bundle) {
        TmcLogger.c("chainPoint", m.class.getName() + "_reportPageOpenEndFail");
        if (aVar.q().isEmpty()) {
            return;
        }
        PageChainContext pageChainContextPeek = aVar.q().peek();
        Bundle bundle2 = new Bundle();
        bundle2.putAll(bundle);
        bundle2.putString("openPageResult", "false");
        bundle2.putString("openPageFailedReason", String.valueOf(pageChainContextPeek != null ? pageChainContextPeek.m() : null));
        bundle2.putString("open_channel", aVar.n());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        bundle2.putString("isExitInStage", String.valueOf(a(aVar, linkedHashMap, linkedHashMap2, 18)));
        bundle2.putInt("maxStage", linkedHashMap.size());
        bundle2.putString("stageCostTime", com.cloud.tmc.miniutils.util.k.j(linkedHashMap2));
        bundle2.putString("stageRangeTime", com.cloud.tmc.miniutils.util.k.j(linkedHashMap));
        bundle2.putString("scene", aVar.s());
        bundle2.putString("pageIndex", String.valueOf(pageChainContextPeek.n()));
        bundle2.putString("isAdd", "true");
        bundle2.putString("page_path", String.valueOf(pageChainContextPeek.o()));
        bundle2.putString("pageUniqueId", q.d() + '_' + pageChainContextPeek.p());
        bundle2.putString("appH5ProgressStatus", String.valueOf(pageChainContextPeek.j()));
        bundle2.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N);
        bundle2.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W);
        ((ReportProxy) tc.a.a(ReportProxy.class)).report(aVar.g(), "mini_page_open_end", bundle2);
    }

    private final void i(wa.a aVar, Bundle bundle) {
        TmcLogger.c("chainPoint", m.class.getName() + "_reportPageOpenMidSuccess");
        if (aVar.q().isEmpty()) {
            return;
        }
        PageChainContext pageChainContextPeek = aVar.q().peek();
        Bundle bundle2 = new Bundle();
        bundle2.putAll(bundle);
        bundle2.putString("openPageResult", "true");
        bundle2.putString("openPageFailedReason", "");
        bundle2.putInt("maxStage", 17);
        bundle2.putString("isExitInStage", "false");
        bundle2.putString("open_channel", aVar.n());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        b(aVar, linkedHashMap, linkedHashMap2, 17);
        bundle2.putString("stageCostTime", com.cloud.tmc.miniutils.util.k.j(linkedHashMap2));
        bundle2.putString("stageRangeTime", com.cloud.tmc.miniutils.util.k.j(linkedHashMap));
        bundle2.putString("scene", aVar.s());
        bundle2.putString("pageIndex", String.valueOf(pageChainContextPeek.n()));
        bundle2.putString("isAdd", "true");
        bundle2.putString("page_path", String.valueOf(pageChainContextPeek.o()));
        bundle2.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N);
        bundle2.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W);
        bundle2.putString("pageUniqueId", q.d() + '_' + pageChainContextPeek.p());
        ((ReportProxy) tc.a.a(ReportProxy.class)).report(aVar.g(), "mini_page_open_mid", bundle2);
    }

    public void c(String str) {
        ab.a.C0021a.a(this, str);
    }

    public void f(wa.a appChainContext, Bundle dataBundle) {
        Intrinsics.g(appChainContext, "appChainContext");
        Intrinsics.g(dataBundle, "dataBundle");
        c("reportNew");
        i(appChainContext, dataBundle);
        e(appChainContext, dataBundle);
    }

    public void g(wa.a appChainContext, Bundle dataBundle) {
        Intrinsics.g(appChainContext, "appChainContext");
        Intrinsics.g(dataBundle, "dataBundle");
        c("reportOld");
        h(appChainContext, dataBundle);
        if (appChainContext.B()) {
            return;
        }
        d(appChainContext, dataBundle);
    }

    public void j(wa.a appChainContext, Bundle dataBundle) {
        Intrinsics.g(appChainContext, "appChainContext");
        Intrinsics.g(dataBundle, "dataBundle");
        c("reset");
        if (dataBundle.containsKey(com.cloud.tmc.kernel.proxy.performanceanalyse.a.S)) {
            String string = dataBundle.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.S, "0");
            Intrinsics.f(string, "dataBundle.getString(ChainPoint.CHAIN_SCENE, \"0\")");
            appChainContext.Z(string);
            String string2 = dataBundle.getString("hot_open_type", "-2");
            Intrinsics.f(string2, "dataBundle.getString(Tmc…ants.HOT_OPEN_TYPE, \"-2\")");
            appChainContext.S(string2);
            for (PageChainContext pageChainContext : appChainContext.q()) {
                String string3 = dataBundle.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.S, "0");
                Intrinsics.f(string3, "dataBundle.getString(ChainPoint.CHAIN_SCENE, \"0\")");
                pageChainContext.P(string3);
            }
        }
        if (dataBundle.containsKey(com.cloud.tmc.kernel.proxy.performanceanalyse.a.T)) {
            String string4 = dataBundle.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.T, "-1");
            Intrinsics.f(string4, "dataBundle.getString(Cha…CHAIN_OPEN_CHANNEL, \"-1\")");
            appChainContext.U(string4);
            for (PageChainContext pageChainContext2 : appChainContext.q()) {
                String string5 = dataBundle.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.T, "-1");
                Intrinsics.f(string5, "dataBundle.getString(Cha…CHAIN_OPEN_CHANNEL, \"-1\")");
                pageChainContext2.J(string5);
            }
        }
        appChainContext.r().set(1);
        appChainContext.p().set(1);
    }
}
