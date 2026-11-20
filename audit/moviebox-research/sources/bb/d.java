package bb;

import android.os.Bundle;
import com.cloud.tmc.integration.chain.page.PageChainContext;
import com.cloud.tmc.integration.proxy.ReportProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppManager;
import com.cloud.tmc.integration.utils.q;
import com.cloud.tmc.kernel.log.TmcLogger;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.s;
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
public final class d implements ab.a {
    private final void a(PageChainContext pageChainContext, Map<String, List<Long>> map, Map<String, Long> map2, int[] iArr) {
        TmcLogger.c("chainPoint", d.class.getName() + "_appendStages");
        long jCurrentTimeMillis = System.currentTimeMillis();
        for (int i11 = 1; i11 < 12; i11++) {
            map.put(String.valueOf(i11), kotlin.collections.g.h(Long.valueOf(jCurrentTimeMillis), Long.valueOf(jCurrentTimeMillis)));
            map2.put(String.valueOf(i11), 0L);
        }
        for (int i12 : iArr) {
            map.put(String.valueOf(i12), kotlin.collections.g.h(Long.valueOf(jCurrentTimeMillis), Long.valueOf(jCurrentTimeMillis)));
            map2.put(String.valueOf(i12), 0L);
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:41:0x01c6 A[Catch: all -> 0x01cd, TRY_LEAVE, TryCatch #2 {all -> 0x01cd, blocks: (B:39:0x01c0, B:41:0x01c6), top: B:68:0x01c0 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x01c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private final void c(wa.a aVar, Bundle bundle) {
        long j11;
        long j12;
        Bundle sceneParams;
        Bundle sceneParams2;
        Bundle sceneParams3;
        TmcLogger.c("chainPoint", d.class.getName() + "_reportAppOpenEndSuccess");
        if (aVar.q().isEmpty()) {
            return;
        }
        PageChainContext page = aVar.q().peek();
        Bundle bundle2 = new Bundle();
        bundle2.putAll(bundle);
        bundle2.putString("pageIndex", String.valueOf(page.n()));
        bundle2.putInt("maxStage", 18);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        Intrinsics.f(page, "page");
        a(page, linkedHashMap, linkedHashMap2, new int[]{12, 13, 14, 15, 16, 17, 18});
        bundle2.putString("stageCostTime", com.cloud.tmc.miniutils.util.k.j(linkedHashMap2));
        bundle2.putString("stageRangeTime", com.cloud.tmc.miniutils.util.k.j(linkedHashMap));
        bundle2.putString("openMiniAppResult", "true");
        bundle2.putString("openMiniAppFailedReason", "");
        bundle2.putInt("syncType", aVar.v());
        bundle2.putString("isExitInStage", "false");
        bundle2.putString("open_channel", aVar.n());
        bundle2.putString("scene", aVar.s());
        bundle2.putString("openByLaunch", "true");
        bundle2.putString("page_path", String.valueOf(page.o()));
        bundle2.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.U, page.i());
        boolean z11 = false;
        bundle2.putString("appH5ProgressStatus", String.valueOf(com.cloud.tmc.miniutils.util.k.j(s.k(TuplesKt.a(30, 0), TuplesKt.a(50, 0), TuplesKt.a(70, 0)))));
        bundle2.putString("pageUniqueId", q.d() + '_' + page.p());
        bundle2.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N);
        bundle2.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W);
        try {
            List<Long> list = linkedHashMap.get("1");
            long jCurrentTimeMillis = (list == null || list.size() < 1 || list == null) ? System.currentTimeMillis() : list.get(0).longValue();
            List<Long> list2 = linkedHashMap.get("18");
            long jCurrentTimeMillis2 = (list2 == null || list2.size() < 1 || list2 == null) ? System.currentTimeMillis() : list2.get(1).longValue();
            App appFindApp = null;
            try {
                appFindApp = ((AppManager) tc.a.a(AppManager.class)).findApp(aVar.g());
                j11 = (appFindApp == null || (sceneParams3 = appFindApp.getSceneParams()) == null) ? 0L : sceneParams3.getLong("start_main_first_time");
                if (appFindApp != null) {
                    try {
                        Bundle sceneParams4 = appFindApp.getSceneParams();
                        if (sceneParams4 != null) {
                            j12 = sceneParams4.getLong("start_mini_first_time");
                        } else {
                            j12 = 0;
                        }
                        if (appFindApp != null) {
                            try {
                                sceneParams2 = appFindApp.getSceneParams();
                                if (sceneParams2 != null) {
                                    z11 = sceneParams2.getBoolean("mini_process_alive");
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    } catch (Throwable unused2) {
                        j12 = 0;
                    }
                } else {
                    j12 = 0;
                    if (appFindApp != null) {
                        sceneParams2 = appFindApp.getSceneParams();
                        if (sceneParams2 != null) {
                            z11 = sceneParams2.getBoolean("mini_process_alive");
                        }
                    }
                }
            } catch (Throwable unused3) {
                j11 = 0;
                j12 = 0;
            }
            if (j11 != 0) {
                bundle2.putLong("mini_first_time", j11);
            }
            if (j12 != 0) {
                bundle2.putLong("mini_second_time", j12);
            }
            if (appFindApp != null && (sceneParams = appFindApp.getSceneParams()) != null) {
                sceneParams.getString("miniapp_frm_start");
            }
            if (j11 != 0) {
                TmcLogger.c("Tmc", "firstStartTime:" + j11);
                jCurrentTimeMillis = j11;
            } else if (j12 != 0) {
                TmcLogger.c("Tmc", "secondStartTime:" + j12);
                jCurrentTimeMillis = j12;
            } else {
                TmcLogger.c("Tmc", "reportStartTime:" + jCurrentTimeMillis);
            }
            bundle2.putLong("miniapp_all_start_time", jCurrentTimeMillis2 - jCurrentTimeMillis);
            bundle2.putBoolean("is_mini_process_alive", z11);
        } catch (Throwable unused4) {
        }
        ((ReportProxy) tc.a.a(ReportProxy.class)).report(aVar.g(), "mini_app_open_end", bundle2);
    }

    private final void d(wa.a aVar, Bundle bundle) {
        TmcLogger.c("chainPoint", d.class.getName() + "_reportAppOpenMidSuccess");
        if (aVar.q().isEmpty()) {
            return;
        }
        PageChainContext page = aVar.q().peek();
        Bundle bundle2 = new Bundle();
        bundle2.putAll(bundle);
        bundle2.putString("pageIndex", String.valueOf(page.n()));
        bundle2.putInt("maxStage", 17);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        Intrinsics.f(page, "page");
        a(page, linkedHashMap, linkedHashMap2, new int[]{12, 13, 14, 15, 16, 17});
        bundle2.putString("stageCostTime", com.cloud.tmc.miniutils.util.k.j(linkedHashMap2));
        bundle2.putString("stageRangeTime", com.cloud.tmc.miniutils.util.k.j(linkedHashMap));
        bundle2.putString("openMiniAppResult", "true");
        bundle2.putString("openMiniAppFailedReason", "");
        bundle2.putInt("syncType", aVar.v());
        bundle2.putString("isExitInStage", "false");
        bundle2.putString("open_channel", aVar.n());
        bundle2.putString("scene", aVar.s());
        bundle2.putString("openByLaunch", "true");
        bundle2.putString("page_path", String.valueOf(page.o()));
        bundle2.putString("pageUniqueId", q.d() + '_' + page.p());
        bundle2.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N);
        bundle2.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W);
        ((ReportProxy) tc.a.a(ReportProxy.class)).report(aVar.g(), "mini_app_open_mid", bundle2);
    }

    private final void f(wa.a aVar, Bundle bundle) {
        PageChainContext pageChainContextPeek;
        TmcLogger.c("chainPoint", d.class.getName() + "_reportPageOpenEndSuccess->pageContexts.size:" + aVar.q().size());
        if (aVar.q().isEmpty() || (pageChainContextPeek = aVar.q().peek()) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putAll(bundle);
        bundle2.putString("openPageResult", "true");
        bundle2.putString("openPageFailedReason", "");
        bundle2.putInt("maxStage", 18);
        bundle2.putString("isExitInStage", "false");
        bundle2.putString("open_channel", pageChainContextPeek.l());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        a(pageChainContextPeek, linkedHashMap, linkedHashMap2, new int[]{12, 13, 14, 15, 16, 17, 18});
        bundle2.putString("stageCostTime", com.cloud.tmc.miniutils.util.k.j(linkedHashMap2));
        bundle2.putString("stageRangeTime", com.cloud.tmc.miniutils.util.k.j(linkedHashMap));
        bundle2.putString("scene", pageChainContextPeek.q());
        bundle2.putString("pageIndex", String.valueOf(pageChainContextPeek.n()));
        bundle2.putString("isAdd", "true");
        bundle2.putString("page_path", pageChainContextPeek.o());
        bundle2.putString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.U, pageChainContextPeek.i());
        bundle2.putString("pageUniqueId", q.d() + '_' + pageChainContextPeek.p());
        bundle2.putString("appH5ProgressStatus", String.valueOf(com.cloud.tmc.miniutils.util.k.j(s.k(TuplesKt.a(30, 0), TuplesKt.a(50, 0), TuplesKt.a(70, 0)))));
        bundle2.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N);
        bundle2.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W);
        ((ReportProxy) tc.a.a(ReportProxy.class)).report(aVar.g(), "mini_page_open_end", bundle2);
    }

    private final void g(wa.a aVar, Bundle bundle) {
        PageChainContext pageChainContextPeek;
        TmcLogger.c("chainPoint", d.class.getName() + "_reportPageOpenMidSuccess->pageContexts.size:" + aVar.q().size());
        if (aVar.q().isEmpty() || (pageChainContextPeek = aVar.q().peek()) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putAll(bundle);
        bundle2.putString("openPageResult", "true");
        bundle2.putString("openPageFailedReason", "");
        bundle2.putInt("maxStage", 17);
        bundle2.putString("isExitInStage", "false");
        bundle2.putString("open_channel", pageChainContextPeek.l());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        a(pageChainContextPeek, linkedHashMap, linkedHashMap2, new int[]{12, 13, 14, 15, 16, 17});
        bundle2.putString("stageCostTime", com.cloud.tmc.miniutils.util.k.j(linkedHashMap2));
        bundle2.putString("stageRangeTime", com.cloud.tmc.miniutils.util.k.j(linkedHashMap));
        bundle2.putString("scene", pageChainContextPeek.q());
        bundle2.putString("pageIndex", String.valueOf(pageChainContextPeek.n()));
        bundle2.putString("isAdd", "true");
        bundle2.putString("page_path", pageChainContextPeek.o());
        bundle2.putString("pageUniqueId", q.d() + '_' + pageChainContextPeek.p());
        bundle2.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N);
        bundle2.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W);
        ((ReportProxy) tc.a.a(ReportProxy.class)).report(aVar.g(), "mini_page_open_mid", bundle2);
    }

    public void b(String str) {
        ab.a.C0021a.a(this, str);
    }

    public void e(wa.a appChainContext, Bundle dataBundle) {
        Intrinsics.g(appChainContext, "appChainContext");
        Intrinsics.g(dataBundle, "dataBundle");
        b("reportNew");
        g(appChainContext, dataBundle);
        d(appChainContext, dataBundle);
        f(appChainContext, dataBundle);
        c(appChainContext, dataBundle);
    }

    public void h(wa.a appChainContext, Bundle dataBundle) {
        Intrinsics.g(appChainContext, "appChainContext");
        Intrinsics.g(dataBundle, "dataBundle");
        b("reset");
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
