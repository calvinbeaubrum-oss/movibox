package com.cloud.tmc.integration.chain.page;

import android.os.Bundle;
import android.text.TextUtils;
import com.cloud.tmc.integration.chain.ChainType;
import com.cloud.tmc.integration.chain.ContextType;
import com.cloud.tmc.integration.proxy.ReportProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.AppManager;
import com.cloud.tmc.integration.utils.q;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.cloud.tmc.miniutils.util.k;
import db.c;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import va.b;
import xa.g;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@SourceDebugExtension
public final class PageChainContext implements va.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wa.a f30663a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f30665c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f30666d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f30667e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f30668f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f30670h;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f30675m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f30676n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f30677o;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f30664b = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f30669g = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map<String, Long> f30671i = new LinkedHashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Map<String, List<Long>> f30672j = new LinkedHashMap();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Map<String, Long> f30673k = new LinkedHashMap();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Map<String, List<Long>> f30674l = new LinkedHashMap();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f30678p = "0";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f30679q = "0";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f30680r = "";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f30681s = "";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f30682t = "0";

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f30683a;

        static {
            int[] iArr = new int[ChainType.values().length];
            try {
                iArr[ChainType.TYPE_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ChainType.TYPE_END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ChainType.TYPE_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ChainType.TYPE_INSERT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f30683a = iArr;
        }
    }

    private final void B(Bundle bundle) {
        b bVar;
        TmcLogger.c("chainPoint", PageChainContext.class.getName() + "_reportPageOpenMidFail->isReportMid:" + this.f30676n);
        if (this.f30676n) {
            return;
        }
        this.f30676n = true;
        Bundle bundle2 = new Bundle();
        bundle2.putAll(bundle);
        bundle2.putString("openPageResult", "false");
        bundle2.putString("openPageFailedReason", this.f30669g);
        bundle2.putInt("maxStage", this.f30670h);
        bundle2.putString("open_channel", String.valueOf(this.f30679q));
        wa.a aVar = this.f30663a;
        bundle2.putString("hot_open_type", String.valueOf(aVar != null ? aVar.k() : null));
        long j11 = bundle2.containsKey(com.cloud.tmc.kernel.proxy.performanceanalyse.a.P) ? bundle2.getLong(com.cloud.tmc.kernel.proxy.performanceanalyse.a.P) : System.currentTimeMillis();
        boolean z11 = this.f30665c != null && this.f30666d == null;
        bundle2.putString("isExitInStage", String.valueOf(z11));
        if (z11 && (bVar = this.f30665c) != null) {
            Map<String, List<Long>> map = this.f30674l;
            Intrinsics.d(bVar);
            if (map.get(String.valueOf(bVar.d())) != null) {
                Map<String, List<Long>> map2 = this.f30674l;
                b bVar2 = this.f30665c;
                Intrinsics.d(bVar2);
                List<Long> list = map2.get(String.valueOf(bVar2.d()));
                if (list != null && list.size() == 1) {
                    Map<String, List<Long>> map3 = this.f30674l;
                    b bVar3 = this.f30665c;
                    Intrinsics.d(bVar3);
                    List<Long> list2 = map3.get(String.valueOf(bVar3.d()));
                    if (list2 != null) {
                        list2.add(Long.valueOf(j11));
                    }
                    Map<String, Long> map4 = this.f30673k;
                    b bVar4 = this.f30665c;
                    Intrinsics.d(bVar4);
                    String strValueOf = String.valueOf(bVar4.d());
                    Map<String, List<Long>> map5 = this.f30674l;
                    b bVar5 = this.f30665c;
                    Intrinsics.d(bVar5);
                    List<Long> list3 = map5.get(String.valueOf(bVar5.d()));
                    long jLongValue = list3 != null ? list3.get(1).longValue() : 0L;
                    Map<String, List<Long>> map6 = this.f30674l;
                    b bVar6 = this.f30665c;
                    Intrinsics.d(bVar6);
                    List<Long> list4 = map6.get(String.valueOf(bVar6.d()));
                    map4.put(strValueOf, Long.valueOf(jLongValue - (list4 != null ? list4.get(0).longValue() : 0L)));
                }
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        c(linkedHashMap, linkedHashMap2);
        bundle2.putString("stageCostTime", k.j(linkedHashMap2));
        bundle2.putString("stageRangeTime", k.j(linkedHashMap));
        bundle2.putString("scene", String.valueOf(this.f30678p));
        bundle2.putString("pageIndex", String.valueOf(this.f30675m));
        bundle2.putString("isAdd", "true");
        bundle2.putString("pageUniqueId", q.d() + '_' + this.f30664b);
        String string = bundle2.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N);
        if (string != null) {
            bundle2.putString("page_path", string);
        }
        bundle2.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N);
        bundle2.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W);
        ReportProxy reportProxy = (ReportProxy) tc.a.a(ReportProxy.class);
        wa.a aVar2 = this.f30663a;
        reportProxy.report(aVar2 != null ? aVar2.g() : null, "mini_page_open_mid", bundle2);
    }

    private final long t(b bVar) {
        return bVar.b().containsKey(com.cloud.tmc.kernel.proxy.performanceanalyse.a.P) ? bVar.b().getLong(com.cloud.tmc.kernel.proxy.performanceanalyse.a.P) : bVar.a();
    }

    private final void u(b bVar) {
        try {
            Bundle bundleB = bVar.b();
            if (bundleB.containsKey(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31210f0)) {
                String string = bundleB.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31210f0);
                if (string == null) {
                    string = "解析失败原因错误";
                }
                this.f30669g = string;
            }
            if (bundleB.containsKey(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31220k0)) {
                String string2 = bundleB.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31220k0, "");
                Intrinsics.f(string2, "data.getString(ChainPoin…E_H5_PROGRESS_STATUS, \"\")");
                this.f30680r = string2;
            }
        } catch (Throwable unused) {
        }
    }

    private final void w(b bVar) {
        wa.a aVar;
        long jT;
        wa.a aVar2;
        wa.a aVar3;
        v("parseChainEnd_" + bVar);
        if (this.f30677o || (aVar = this.f30663a) == null || TextUtils.isEmpty(aVar.g())) {
            return;
        }
        String string = bVar.b().getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.V);
        if (string == null) {
            string = "";
        }
        Intrinsics.f(string, "chainEndState.dataBundle…ng(CHAIN_RENDER_ID) ?: \"\"");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        this.f30666d = bVar;
        boolean z11 = bVar instanceof g;
        if (z11 && Intrinsics.b(bVar.b().getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.U), "2")) {
            jT = bVar.b().getLong(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31226n0, System.currentTimeMillis());
            TmcLogger.c("chainState", "fcpTime:" + jT);
        } else {
            jT = t(bVar);
        }
        List<Long> list = this.f30674l.get(String.valueOf(bVar.d()));
        if (list != null) {
            list.add(Long.valueOf(jT));
        }
        List<Long> list2 = this.f30674l.get(String.valueOf(bVar.d()));
        long jLongValue = 0;
        if (list2 != null && list2.size() == 2) {
            jLongValue = list2.get(1).longValue() - list2.get(0).longValue();
        }
        this.f30673k.put(String.valueOf(bVar.d()), Long.valueOf(jLongValue));
        if (this.f30675m == 1) {
            aVar.Q(this.f30674l);
            aVar.P(this.f30673k);
        }
        if (bVar instanceof xa.a) {
            C(bVar.b());
            int i11 = this.f30675m;
            if (i11 == 1) {
                aVar.K(f(bVar.b()), true);
            } else if (i11 != 1 && (aVar3 = this.f30663a) != null && !aVar3.C()) {
                aVar.K(f(bVar.b()), false);
            }
        }
        if (z11) {
            String string2 = bVar.b().getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.U, "0");
            Intrinsics.f(string2, "chainEndState.dataBundle…CHAIN_DRAW_END_TYPE, \"0\")");
            this.f30682t = string2;
            A(bVar.b());
            int i12 = this.f30675m;
            if (i12 == 1) {
                String strG = aVar.g();
                Bundle bundleD = D(strG != null ? strG : "");
                Bundle bundleF = f(bVar.b());
                bundleF.putAll(bundleD);
                aVar.I(bundleF, true);
                return;
            }
            if (i12 == 1 || (aVar2 = this.f30663a) == null || aVar2.B()) {
                return;
            }
            aVar.I(f(bVar.b()), false);
        }
    }

    private final void x(b bVar) {
        v("parseChainStart_" + bVar);
        wa.a aVar = this.f30663a;
        if (aVar == null || TextUtils.isEmpty(aVar.g())) {
            return;
        }
        String string = bVar.b().getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.V);
        if (string == null) {
            string = "";
        }
        Intrinsics.f(string, "chainStartState.dataBund…ng(CHAIN_RENDER_ID) ?: \"\"");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (e(string) == null) {
            this.f30664b = string;
            aVar.q().push(this);
        }
        if (bVar instanceof c) {
            this.f30675m = aVar.r().addAndGet(1);
            this.f30678p = aVar.s();
            this.f30679q = aVar.n();
            String string2 = bVar.b().getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N, "");
            Intrinsics.f(string2, "chainStartState.dataBund…ChainPoint.PAGE_PATH, \"\")");
            this.f30681s = string2;
            this.f30671i = aVar.t();
            this.f30672j = aVar.u();
        }
        this.f30670h = bVar.d();
        this.f30666d = null;
        this.f30665c = bVar;
        this.f30674l.put(String.valueOf(bVar.d()), kotlin.collections.g.h(Long.valueOf(t(bVar))));
        if (this.f30675m == 1) {
            aVar.Q(this.f30674l);
            aVar.O(this.f30670h);
        }
    }

    private final void y(b bVar) {
        wa.a aVar;
        List<Long> list;
        v("parseChianError_" + bVar);
        if (this.f30677o || (aVar = this.f30663a) == null || TextUtils.isEmpty(aVar.g())) {
            return;
        }
        String string = bVar.b().getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.V);
        if (string == null) {
            string = "";
        }
        Intrinsics.f(string, "pageErrorState.dataBundl…ng(CHAIN_RENDER_ID) ?: \"\"");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        this.f30666d = bVar;
        b bVar2 = this.f30665c;
        if (bVar2 != null && (list = this.f30674l.get(String.valueOf(bVar2.d()))) != null && list.size() == 1) {
            list.add(Long.valueOf(System.currentTimeMillis()));
            this.f30673k.put(String.valueOf(bVar2.d()), Long.valueOf(list.get(1).longValue() - list.get(0).longValue()));
        }
        if (this.f30675m == 1) {
            aVar.Q(this.f30674l);
            aVar.P(this.f30673k);
        }
    }

    private final void z(Bundle bundle) {
        b bVar;
        TmcLogger.c("chainPoint", PageChainContext.class.getName() + "_reportPageOpenEndFail->isReportEnd:" + this.f30677o);
        if (this.f30677o) {
            return;
        }
        this.f30677o = true;
        Bundle bundle2 = new Bundle();
        bundle2.putAll(bundle);
        bundle2.putString("openPageResult", "false");
        bundle2.putString("openPageFailedReason", this.f30669g);
        bundle2.putInt("maxStage", this.f30670h);
        bundle2.putString("open_channel", String.valueOf(this.f30679q));
        wa.a aVar = this.f30663a;
        bundle2.putString("hot_open_type", String.valueOf(aVar != null ? aVar.k() : null));
        long j11 = bundle2.containsKey(com.cloud.tmc.kernel.proxy.performanceanalyse.a.P) ? bundle2.getLong(com.cloud.tmc.kernel.proxy.performanceanalyse.a.P) : System.currentTimeMillis();
        boolean z11 = this.f30665c != null && this.f30666d == null;
        bundle2.putString("isExitInStage", String.valueOf(z11));
        if (z11 && (bVar = this.f30665c) != null) {
            Map<String, List<Long>> map = this.f30674l;
            Intrinsics.d(bVar);
            if (map.get(String.valueOf(bVar.d())) != null) {
                Map<String, List<Long>> map2 = this.f30674l;
                b bVar2 = this.f30665c;
                Intrinsics.d(bVar2);
                List<Long> list = map2.get(String.valueOf(bVar2.d()));
                if (list != null && list.size() == 1) {
                    Map<String, List<Long>> map3 = this.f30674l;
                    b bVar3 = this.f30665c;
                    Intrinsics.d(bVar3);
                    List<Long> list2 = map3.get(String.valueOf(bVar3.d()));
                    if (list2 != null) {
                        list2.add(Long.valueOf(j11));
                    }
                    Map<String, Long> map4 = this.f30673k;
                    b bVar4 = this.f30665c;
                    Intrinsics.d(bVar4);
                    String strValueOf = String.valueOf(bVar4.d());
                    Map<String, List<Long>> map5 = this.f30674l;
                    b bVar5 = this.f30665c;
                    Intrinsics.d(bVar5);
                    List<Long> list3 = map5.get(String.valueOf(bVar5.d()));
                    long jLongValue = list3 != null ? list3.get(1).longValue() : 0L;
                    Map<String, List<Long>> map6 = this.f30674l;
                    b bVar6 = this.f30665c;
                    Intrinsics.d(bVar6);
                    List<Long> list4 = map6.get(String.valueOf(bVar6.d()));
                    map4.put(strValueOf, Long.valueOf(jLongValue - (list4 != null ? list4.get(0).longValue() : 0L)));
                }
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        c(linkedHashMap, linkedHashMap2);
        bundle2.putString("stageCostTime", k.j(linkedHashMap2));
        bundle2.putString("stageRangeTime", k.j(linkedHashMap));
        bundle2.putString("scene", String.valueOf(this.f30678p));
        bundle2.putString("pageIndex", String.valueOf(this.f30675m));
        bundle2.putString("isAdd", "true");
        bundle2.putString("pageUniqueId", q.d() + '_' + this.f30664b);
        String string = bundle2.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N);
        if (string != null) {
            bundle2.putString("page_path", string);
        }
        bundle2.putString("appH5ProgressStatus", this.f30680r);
        bundle2.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N);
        bundle2.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W);
        ReportProxy reportProxy = (ReportProxy) tc.a.a(ReportProxy.class);
        wa.a aVar2 = this.f30663a;
        reportProxy.report(aVar2 != null ? aVar2.g() : null, "mini_page_open_end", bundle2);
    }

    public final void A(Bundle bundle) {
        TmcLogger.c("chainPoint", PageChainContext.class.getName() + "_reportPageOpenEndSuccess->isReportEnd:" + this.f30677o);
        if (this.f30677o) {
            return;
        }
        this.f30677o = true;
        this.f30668f = true;
        Bundle bundle2 = new Bundle();
        bundle2.putAll(bundle);
        bundle2.putString("openPageResult", "true");
        bundle2.putString("openPageFailedReason", "");
        bundle2.putInt("maxStage", this.f30670h);
        bundle2.putString("isExitInStage", "false");
        bundle2.putString("open_channel", String.valueOf(this.f30679q));
        wa.a aVar = this.f30663a;
        bundle2.putString("hot_open_type", String.valueOf(aVar != null ? aVar.k() : null));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        c(linkedHashMap, linkedHashMap2);
        bundle2.putString("stageCostTime", k.j(linkedHashMap2));
        bundle2.putString("stageRangeTime", k.j(linkedHashMap));
        bundle2.putString("scene", String.valueOf(this.f30678p));
        bundle2.putString("pageIndex", String.valueOf(this.f30675m));
        bundle2.putString("isAdd", "true");
        String string = bundle2.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N);
        if (string != null) {
            bundle2.putString("page_path", string);
        }
        bundle2.putString("appH5ProgressStatus", this.f30680r);
        bundle2.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N);
        bundle2.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W);
        ReportProxy reportProxy = (ReportProxy) tc.a.a(ReportProxy.class);
        wa.a aVar2 = this.f30663a;
        reportProxy.report(aVar2 != null ? aVar2.g() : null, "mini_page_open_end", bundle2);
    }

    public final void C(Bundle bundle) {
        TmcLogger.c("chainPoint", PageChainContext.class.getName() + "_reportPageOpenMidSuccess->isReportMid:" + this.f30676n);
        if (this.f30676n) {
            return;
        }
        this.f30676n = true;
        this.f30667e = true;
        Bundle bundle2 = new Bundle();
        bundle2.putAll(bundle);
        bundle2.putString("openPageResult", "true");
        bundle2.putString("openPageFailedReason", "");
        bundle2.putInt("maxStage", this.f30670h);
        bundle2.putString("isExitInStage", "false");
        bundle2.putString("open_channel", String.valueOf(this.f30679q));
        wa.a aVar = this.f30663a;
        bundle2.putString("hot_open_type", String.valueOf(aVar != null ? aVar.k() : null));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        c(linkedHashMap, linkedHashMap2);
        bundle2.putString("stageCostTime", k.j(linkedHashMap2));
        bundle2.putString("stageRangeTime", k.j(linkedHashMap));
        bundle2.putString("scene", String.valueOf(this.f30678p));
        bundle2.putString("pageIndex", String.valueOf(this.f30675m));
        bundle2.putString("isAdd", "true");
        String string = bundle2.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N);
        if (string != null) {
            bundle2.putString("page_path", string);
        }
        bundle2.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N);
        bundle2.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W);
        ReportProxy reportProxy = (ReportProxy) tc.a.a(ReportProxy.class);
        wa.a aVar2 = this.f30663a;
        reportProxy.report(aVar2 != null ? aVar2.g() : null, "mini_page_open_mid", bundle2);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0088 A[PHI: r7
  0x0088: PHI (r7v2 long) = (r7v0 long), (r7v7 long), (r7v7 long), (r7v7 long) binds: [B:26:0x0074, B:28:0x0078, B:33:0x0087, B:30:0x007e] A[DONT_GENERATE, DONT_INLINE]] */
    public final Bundle D(String str) {
        long j11;
        long j12;
        Bundle sceneParams;
        Bundle bundle = new Bundle();
        try {
            List<Long> list = this.f30672j.get("1");
            long jCurrentTimeMillis = (list == null || list.size() < 1 || list == null) ? System.currentTimeMillis() : list.get(0).longValue();
            List<Long> list2 = this.f30674l.get("18");
            long jCurrentTimeMillis2 = (list2 == null || list2.size() < 1 || list2 == null) ? System.currentTimeMillis() : list2.get(1).longValue();
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
                    }
                } else {
                    j12 = 0;
                }
            } catch (Throwable unused2) {
                j11 = 0;
            }
            if (j11 != 0) {
                bundle.putLong("mini_first_time", j11);
            }
            if (j12 != 0) {
                bundle.putLong("mini_second_time", j12);
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
            bundle.putLong("miniapp_all_start_time", jCurrentTimeMillis2 - jCurrentTimeMillis);
        } catch (Throwable unused3) {
        }
        return bundle;
    }

    public final void E(wa.a aVar) {
        this.f30663a = aVar;
    }

    public final void F(Map<String, Long> map) {
        Intrinsics.g(map, "<set-?>");
        this.f30671i = map;
    }

    public final void G(Map<String, List<Long>> map) {
        Intrinsics.g(map, "<set-?>");
        this.f30672j = map;
    }

    public final void H(String str) {
        Intrinsics.g(str, "<set-?>");
        this.f30680r = str;
    }

    public final void I(int i11) {
        this.f30670h = i11;
    }

    public final void J(String str) {
        Intrinsics.g(str, "<set-?>");
        this.f30679q = str;
    }

    public final void K(boolean z11) {
        this.f30668f = z11;
    }

    public final void L(boolean z11) {
        this.f30667e = z11;
    }

    public final void M(int i11) {
        this.f30675m = i11;
    }

    public final void N(boolean z11) {
        this.f30677o = z11;
    }

    public final void O(boolean z11) {
        this.f30676n = z11;
    }

    public final void P(String str) {
        Intrinsics.g(str, "<set-?>");
        this.f30678p = str;
    }

    @Override // va.a
    public void a(b chainState) {
        Intrinsics.g(chainState, "chainState");
        try {
            v("setChainState_" + chainState.d());
            int i11 = a.f30683a[chainState.c().ordinal()];
            if (i11 == 1) {
                x(chainState);
            } else if (i11 == 2) {
                w(chainState);
            } else if (i11 == 3) {
                y(chainState);
            } else if (i11 == 4) {
                u(chainState);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // va.a
    public ContextType b() {
        return ContextType.TYPE_PAGE;
    }

    public final void c(Map<String, List<Long>> map, Map<String, Long> map2) {
        TmcLogger.c("chainPoint", PageChainContext.class.getName() + "_appendStages");
        if (this.f30663a != null) {
            if (this.f30675m == 1) {
                map.putAll(this.f30672j);
                map2.putAll(this.f30671i);
            } else {
                for (int i11 = 1; i11 < 12; i11++) {
                    String strValueOf = String.valueOf(i11);
                    Long[] lArr = new Long[2];
                    List<Long> list = this.f30674l.get(PrepareException.ERROR_LOCAL_DATA_FILE_SCAN);
                    lArr[0] = Long.valueOf(list != null ? list.get(0).longValue() : 0L);
                    List<Long> list2 = this.f30674l.get(PrepareException.ERROR_LOCAL_DATA_FILE_SCAN);
                    lArr[1] = Long.valueOf(list2 != null ? list2.get(0).longValue() : 0L);
                    map.put(strValueOf, kotlin.collections.g.h(lArr));
                    map2.put(String.valueOf(i11), 0L);
                }
            }
            map.putAll(this.f30674l);
            map2.putAll(this.f30673k);
        }
    }

    public void d(Bundle data) {
        Stack<PageChainContext> stackQ;
        Intrinsics.g(data, "data");
        try {
            TmcLogger.c("chainPoint", PageChainContext.class.getName() + "_destroy->openMiniPageMidResult:" + this.f30667e + " ,openMiniPageEndResult:" + this.f30668f);
            if (!this.f30667e) {
                B(data);
            }
            if (!this.f30668f) {
                z(data);
            }
            wa.a aVar = this.f30663a;
            if (aVar != null && (stackQ = aVar.q()) != null) {
                kotlin.collections.k.G(stackQ, new Function1<PageChainContext, Boolean>() { // from class: com.cloud.tmc.integration.chain.page.PageChainContext$destroy$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(PageChainContext pageChainContext) {
                        return Boolean.valueOf(Intrinsics.b(pageChainContext.p(), this.this$0.p()));
                    }
                });
            }
            this.f30663a = null;
        } catch (Throwable unused) {
        }
    }

    public final PageChainContext e(String str) {
        Stack<PageChainContext> stackQ;
        wa.a aVar = this.f30663a;
        PageChainContext pageChainContext = null;
        if (aVar != null && (stackQ = aVar.q()) != null) {
            for (PageChainContext pageChainContext2 : stackQ) {
                if (Intrinsics.b(pageChainContext2.f30664b, str)) {
                    pageChainContext = pageChainContext2;
                }
            }
        }
        return pageChainContext;
    }

    public final Bundle f(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putAll(bundle);
        bundle2.putString("pageIndex", String.valueOf(this.f30675m));
        bundle2.putInt("maxStage", this.f30670h);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        wa.a aVar = this.f30663a;
        if (aVar != null) {
            aVar.d(this, linkedHashMap, linkedHashMap2, this.f30670h);
        }
        bundle2.putString("stageCostTime", k.j(linkedHashMap2));
        bundle2.putString("stageRangeTime", k.j(linkedHashMap));
        return bundle2;
    }

    public final b g() {
        return this.f30666d;
    }

    public final b h() {
        return this.f30665c;
    }

    public final String i() {
        return this.f30682t;
    }

    public final String j() {
        return this.f30680r;
    }

    public final int k() {
        return this.f30670h;
    }

    public final String l() {
        return this.f30679q;
    }

    public final String m() {
        return this.f30669g;
    }

    public final int n() {
        return this.f30675m;
    }

    public final String o() {
        return this.f30681s;
    }

    public final String p() {
        return this.f30664b;
    }

    public final String q() {
        return this.f30678p;
    }

    public final Map<String, Long> r() {
        return this.f30673k;
    }

    public final Map<String, List<Long>> s() {
        return this.f30674l;
    }

    public void v(String str) {
        va.a.C0873a.a(this, str);
    }
}
