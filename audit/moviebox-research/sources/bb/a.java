package bb;

import android.os.Bundle;
import com.cloud.tmc.integration.chain.page.PageChainContext;
import com.cloud.tmc.integration.proxy.ReportProxy;
import com.cloud.tmc.kernel.log.TmcLogger;
import java.util.LinkedHashMap;
import java.util.List;
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
public final class a implements ab.a {
    public void a(wa.a appChainContext, Bundle dataBundle) {
        PageChainContext pageChainContextPeek;
        Intrinsics.g(appChainContext, "appChainContext");
        Intrinsics.g(dataBundle, "dataBundle");
        b("keepSituation");
        appChainContext.r().set(0);
        appChainContext.p().set(0);
        appChainContext.Y(false);
        appChainContext.X(false);
        appChainContext.W(false);
        appChainContext.V(false);
        va.b bVarI = appChainContext.i();
        appChainContext.T(bVarI != null ? bVarI.d() : 1);
        appChainContext.t().clear();
        appChainContext.u().clear();
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iL = appChainContext.l();
        if (1 <= iL) {
            int i11 = 1;
            while (true) {
                appChainContext.t().put(String.valueOf(i11), 0L);
                appChainContext.u().put(String.valueOf(i11), kotlin.collections.g.h(Long.valueOf(jCurrentTimeMillis), Long.valueOf(jCurrentTimeMillis)));
                if (i11 == iL) {
                    break;
                } else {
                    i11++;
                }
            }
        }
        appChainContext.a0(0);
        appChainContext.x().clear();
        appChainContext.R("");
        if (appChainContext.q().size() <= 0 || (pageChainContextPeek = appChainContext.q().peek()) == null) {
            return;
        }
        Intrinsics.f(pageChainContextPeek, "peek()");
        pageChainContextPeek.M(0);
        pageChainContextPeek.O(false);
        pageChainContextPeek.N(false);
        pageChainContextPeek.L(false);
        pageChainContextPeek.K(false);
        va.b bVarH = pageChainContextPeek.h();
        int i12 = 12;
        pageChainContextPeek.I(bVarH != null ? bVarH.d() : 12);
        appChainContext.O(pageChainContextPeek.k());
        pageChainContextPeek.F(appChainContext.t());
        pageChainContextPeek.G(appChainContext.u());
        int iK = pageChainContextPeek.k();
        if (12 <= iK) {
            while (true) {
                pageChainContextPeek.r().put(String.valueOf(i12), 0L);
                pageChainContextPeek.s().put(String.valueOf(i12), kotlin.collections.g.h(Long.valueOf(jCurrentTimeMillis), Long.valueOf(jCurrentTimeMillis)));
                if (i12 == iK) {
                    break;
                } else {
                    i12++;
                }
            }
        }
        appChainContext.P(pageChainContextPeek.r());
        appChainContext.Q(pageChainContextPeek.s());
        pageChainContextPeek.H("");
    }

    public void b(String str) {
        ab.a.C0021a.a(this, str);
    }

    public final void c(wa.a aVar, Bundle bundle) {
        TmcLogger.c("chainPoint", a.class.getName() + "_reportAppOpenEndFail");
        Bundle bundle2 = new Bundle();
        bundle2.putAll(bundle);
        bundle2.putString("openMiniAppResult", "false");
        bundle2.putString("openMiniAppFailedReason", aVar.o());
        bundle2.putInt("maxStage", aVar.l());
        bundle2.putInt("syncType", aVar.v());
        bundle2.putString("open_channel", aVar.n());
        long j11 = bundle2.containsKey(com.cloud.tmc.kernel.proxy.performanceanalyse.a.P) ? bundle2.getLong(com.cloud.tmc.kernel.proxy.performanceanalyse.a.P) : System.currentTimeMillis();
        boolean z11 = aVar.i() != null && aVar.h() == null;
        bundle2.putString("isExitInStage", String.valueOf(z11));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(aVar.u());
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(aVar.t());
        if (z11 && aVar.i() != null) {
            va.b bVarI = aVar.i();
            Intrinsics.d(bVarI);
            if (linkedHashMap.get(String.valueOf(bVarI.d())) != null) {
                va.b bVarI2 = aVar.i();
                Intrinsics.d(bVarI2);
                List list = (List) linkedHashMap.get(String.valueOf(bVarI2.d()));
                if (list != null && list.size() == 1) {
                    va.b bVarI3 = aVar.i();
                    Intrinsics.d(bVarI3);
                    List list2 = (List) linkedHashMap.get(String.valueOf(bVarI3.d()));
                    if (list2 != null) {
                        list2.add(Long.valueOf(j11));
                    }
                    va.b bVarI4 = aVar.i();
                    Intrinsics.d(bVarI4);
                    String strValueOf = String.valueOf(bVarI4.d());
                    va.b bVarI5 = aVar.i();
                    Intrinsics.d(bVarI5);
                    List list3 = (List) linkedHashMap.get(String.valueOf(bVarI5.d()));
                    long jLongValue = list3 != null ? ((Number) list3.get(1)).longValue() : 0L;
                    va.b bVarI6 = aVar.i();
                    Intrinsics.d(bVarI6);
                    List list4 = (List) linkedHashMap.get(String.valueOf(bVarI6.d()));
                    linkedHashMap2.put(strValueOf, Long.valueOf(jLongValue - (list4 != null ? ((Number) list4.get(0)).longValue() : 0L)));
                }
            }
        }
        bundle2.putString("stageCostTime", com.cloud.tmc.miniutils.util.k.j(linkedHashMap2));
        bundle2.putString("stageRangeTime", com.cloud.tmc.miniutils.util.k.j(linkedHashMap));
        bundle2.putString("scene", aVar.s());
        String string = bundle2.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N);
        if (string != null) {
            bundle2.putString("page_path", string);
        }
        bundle2.putString("openedPageCount", String.valueOf(aVar.p().get()));
        bundle2.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N);
        bundle2.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W);
        ((ReportProxy) tc.a.a(ReportProxy.class)).report(aVar.g(), "mini_app_open_end", bundle2);
    }

    public final void d(wa.a aVar, Bundle bundle) {
        TmcLogger.c("chainPoint", a.class.getName() + "_reportAppOpenMidFail");
        Bundle bundle2 = new Bundle();
        bundle2.putAll(bundle);
        bundle2.putString("openMiniAppResult", "false");
        bundle2.putString("openMiniAppFailedReason", aVar.o());
        bundle2.putInt("maxStage", aVar.l());
        bundle2.putInt("syncType", aVar.v());
        bundle2.putString("open_channel", aVar.n());
        long j11 = bundle2.containsKey(com.cloud.tmc.kernel.proxy.performanceanalyse.a.P) ? bundle2.getLong(com.cloud.tmc.kernel.proxy.performanceanalyse.a.P) : System.currentTimeMillis();
        boolean z11 = aVar.i() != null && aVar.h() == null;
        bundle2.putString("isExitInStage", String.valueOf(z11));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(aVar.u());
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(aVar.t());
        if (z11 && aVar.i() != null) {
            va.b bVarI = aVar.i();
            Intrinsics.d(bVarI);
            if (linkedHashMap.get(String.valueOf(bVarI.d())) != null) {
                va.b bVarI2 = aVar.i();
                Intrinsics.d(bVarI2);
                List list = (List) linkedHashMap.get(String.valueOf(bVarI2.d()));
                if (list != null && list.size() == 1) {
                    va.b bVarI3 = aVar.i();
                    Intrinsics.d(bVarI3);
                    List list2 = (List) linkedHashMap.get(String.valueOf(bVarI3.d()));
                    if (list2 != null) {
                        list2.add(Long.valueOf(j11));
                    }
                    va.b bVarI4 = aVar.i();
                    Intrinsics.d(bVarI4);
                    String strValueOf = String.valueOf(bVarI4.d());
                    va.b bVarI5 = aVar.i();
                    Intrinsics.d(bVarI5);
                    List list3 = (List) linkedHashMap.get(String.valueOf(bVarI5.d()));
                    long jLongValue = list3 != null ? ((Number) list3.get(1)).longValue() : 0L;
                    va.b bVarI6 = aVar.i();
                    Intrinsics.d(bVarI6);
                    List list4 = (List) linkedHashMap.get(String.valueOf(bVarI6.d()));
                    linkedHashMap2.put(strValueOf, Long.valueOf(jLongValue - (list4 != null ? ((Number) list4.get(0)).longValue() : 0L)));
                }
            }
        }
        bundle2.putString("stageCostTime", com.cloud.tmc.miniutils.util.k.j(linkedHashMap2));
        bundle2.putString("stageRangeTime", com.cloud.tmc.miniutils.util.k.j(linkedHashMap));
        bundle2.putString("scene", aVar.s());
        String string = bundle2.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N);
        if (string != null) {
            bundle2.putString("page_path", string);
        }
        bundle2.putString("openedPageCount", String.valueOf(aVar.p().get()));
        bundle2.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N);
        bundle2.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W);
        ((ReportProxy) tc.a.a(ReportProxy.class)).report(aVar.g(), "mini_app_open_mid", bundle2);
    }

    public void e(wa.a appChainContext, Bundle dataBundle) {
        Intrinsics.g(appChainContext, "appChainContext");
        Intrinsics.g(dataBundle, "dataBundle");
        b("reportOld");
        if (!appChainContext.C()) {
            g(appChainContext, dataBundle);
            d(appChainContext, dataBundle);
        }
        if (appChainContext.B()) {
            return;
        }
        f(appChainContext, dataBundle);
        c(appChainContext, dataBundle);
    }

    public final void f(wa.a aVar, Bundle bundle) {
        TmcLogger.c("chainPoint", a.class.getName() + "_reportPageOpenEndFail");
        Bundle bundle2 = new Bundle();
        bundle2.putAll(bundle);
        bundle2.putString("openPageResult", "false");
        bundle2.putString("openPageFailedReason", aVar.o());
        bundle2.putInt("maxStage", aVar.l());
        bundle2.putString("open_channel", aVar.n());
        long j11 = bundle2.containsKey(com.cloud.tmc.kernel.proxy.performanceanalyse.a.P) ? bundle2.getLong(com.cloud.tmc.kernel.proxy.performanceanalyse.a.P) : System.currentTimeMillis();
        boolean z11 = aVar.i() != null && aVar.h() == null;
        bundle2.putString("isExitInStage", String.valueOf(z11));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(aVar.u());
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(aVar.t());
        if (z11 && aVar.i() != null) {
            va.b bVarI = aVar.i();
            Intrinsics.d(bVarI);
            if (linkedHashMap.get(String.valueOf(bVarI.d())) != null) {
                va.b bVarI2 = aVar.i();
                Intrinsics.d(bVarI2);
                List list = (List) linkedHashMap.get(String.valueOf(bVarI2.d()));
                if (list != null && list.size() == 1) {
                    va.b bVarI3 = aVar.i();
                    Intrinsics.d(bVarI3);
                    List list2 = (List) linkedHashMap.get(String.valueOf(bVarI3.d()));
                    if (list2 != null) {
                        list2.add(Long.valueOf(j11));
                    }
                    va.b bVarI4 = aVar.i();
                    Intrinsics.d(bVarI4);
                    String strValueOf = String.valueOf(bVarI4.d());
                    va.b bVarI5 = aVar.i();
                    Intrinsics.d(bVarI5);
                    List list3 = (List) linkedHashMap.get(String.valueOf(bVarI5.d()));
                    long jLongValue = list3 != null ? ((Number) list3.get(1)).longValue() : 0L;
                    va.b bVarI6 = aVar.i();
                    Intrinsics.d(bVarI6);
                    List list4 = (List) linkedHashMap.get(String.valueOf(bVarI6.d()));
                    linkedHashMap2.put(strValueOf, Long.valueOf(jLongValue - (list4 != null ? ((Number) list4.get(0)).longValue() : 0L)));
                }
            }
        }
        bundle2.putString("stageCostTime", com.cloud.tmc.miniutils.util.k.j(linkedHashMap2));
        bundle2.putString("stageRangeTime", com.cloud.tmc.miniutils.util.k.j(linkedHashMap));
        bundle2.putString("scene", aVar.s());
        String string = bundle2.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N);
        if (string != null) {
            bundle2.putString("page_path", string);
        }
        bundle2.putString("pageIndex", "1");
        bundle2.putString("isAdd", "false");
        bundle2.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N);
        bundle2.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W);
        ((ReportProxy) tc.a.a(ReportProxy.class)).report(aVar.g(), "mini_page_open_end", bundle2);
    }

    public final void g(wa.a aVar, Bundle bundle) {
        TmcLogger.c("chainPoint", a.class.getName() + "_reportPageOpenMidFail");
        Bundle bundle2 = new Bundle();
        bundle2.putAll(bundle);
        bundle2.putString("openPageResult", "false");
        bundle2.putString("openPageFailedReason", aVar.o());
        bundle2.putInt("maxStage", aVar.l());
        bundle2.putString("open_channel", aVar.n());
        long j11 = bundle2.containsKey(com.cloud.tmc.kernel.proxy.performanceanalyse.a.P) ? bundle2.getLong(com.cloud.tmc.kernel.proxy.performanceanalyse.a.P) : System.currentTimeMillis();
        boolean z11 = aVar.i() != null && aVar.h() == null;
        bundle2.putString("isExitInStage", String.valueOf(z11));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(aVar.u());
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.putAll(aVar.t());
        if (z11 && aVar.i() != null) {
            va.b bVarI = aVar.i();
            Intrinsics.d(bVarI);
            if (linkedHashMap.get(String.valueOf(bVarI.d())) != null) {
                va.b bVarI2 = aVar.i();
                Intrinsics.d(bVarI2);
                List list = (List) linkedHashMap.get(String.valueOf(bVarI2.d()));
                if (list != null && list.size() == 1) {
                    va.b bVarI3 = aVar.i();
                    Intrinsics.d(bVarI3);
                    List list2 = (List) linkedHashMap.get(String.valueOf(bVarI3.d()));
                    if (list2 != null) {
                        list2.add(Long.valueOf(j11));
                    }
                    va.b bVarI4 = aVar.i();
                    Intrinsics.d(bVarI4);
                    String strValueOf = String.valueOf(bVarI4.d());
                    va.b bVarI5 = aVar.i();
                    Intrinsics.d(bVarI5);
                    List list3 = (List) linkedHashMap.get(String.valueOf(bVarI5.d()));
                    long jLongValue = list3 != null ? ((Number) list3.get(1)).longValue() : 0L;
                    va.b bVarI6 = aVar.i();
                    Intrinsics.d(bVarI6);
                    List list4 = (List) linkedHashMap.get(String.valueOf(bVarI6.d()));
                    linkedHashMap2.put(strValueOf, Long.valueOf(jLongValue - (list4 != null ? ((Number) list4.get(0)).longValue() : 0L)));
                }
            }
        }
        bundle2.putString("stageCostTime", com.cloud.tmc.miniutils.util.k.j(linkedHashMap2));
        bundle2.putString("stageRangeTime", com.cloud.tmc.miniutils.util.k.j(linkedHashMap));
        bundle2.putString("scene", aVar.s());
        String string = bundle2.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N);
        if (string != null) {
            bundle2.putString("page_path", string);
        }
        bundle2.putString("pageIndex", "1");
        bundle2.putString("isAdd", "false");
        bundle2.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N);
        bundle2.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W);
        ((ReportProxy) tc.a.a(ReportProxy.class)).report(aVar.g(), "mini_page_open_mid", bundle2);
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
    }
}
