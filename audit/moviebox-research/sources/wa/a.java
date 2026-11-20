package wa;

import android.os.Bundle;
import android.text.TextUtils;
import com.cloud.tmc.integration.chain.ChainType;
import com.cloud.tmc.integration.chain.ContextType;
import com.cloud.tmc.integration.chain.page.PageChainContext;
import com.cloud.tmc.integration.proxy.ReportProxy;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniutils.util.k;
import db.p;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.g;
import kotlin.jvm.internal.Intrinsics;
import va.b;

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
public final class a implements va.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f79389d;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f79396k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f79397l;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f79400o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f79401p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f79403r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f79404s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f79405t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public b f79406u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public b f79407v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f79386a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f79387b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Stack<PageChainContext> f79388c = new Stack<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AtomicInteger f79390e = new AtomicInteger(0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f79391f = "0";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f79392g = "0";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map<String, Long> f79393h = new LinkedHashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map<String, List<Long>> f79394i = new LinkedHashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public AtomicInteger f79395j = new AtomicInteger(0);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Map<String, Long> f79398m = new LinkedHashMap();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Map<String, List<Long>> f79399n = new LinkedHashMap();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Map<String, Integer> f79402q = new LinkedHashMap();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f79408w = "";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f79409x = "-1";

    /* JADX INFO: renamed from: wa.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class C0886a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f79410a;

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
            f79410a = iArr;
        }
    }

    public final void A(b bVar) {
        try {
            Bundle bundleB = bVar.b();
            D("insertData_" + bVar + '_' + bundleB);
            if (bundleB.containsKey(com.cloud.tmc.kernel.proxy.performanceanalyse.a.R)) {
                int i11 = bundleB.getInt(com.cloud.tmc.kernel.proxy.performanceanalyse.a.R);
                this.f79402q.put(String.valueOf(bVar.c().getType()), Integer.valueOf(i11));
                this.f79401p = w(this.f79401p, i11);
            }
            if (bundleB.containsKey(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31208e0)) {
                String string = bundleB.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31208e0);
                if (string == null) {
                    string = "解析失败原因错误";
                }
                this.f79387b = string;
            }
            if (bundleB.containsKey(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31216i0)) {
                String string2 = bundleB.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31216i0, "");
                Intrinsics.f(string2, "data.getString(APP_H5_PROGRESS_STATUS, \"\")");
                this.f79408w = string2;
            }
            if (bundleB.containsKey(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31218j0)) {
                this.f79389d = bundleB.getBoolean(com.cloud.tmc.kernel.proxy.performanceanalyse.a.f31218j0, false);
            }
        } catch (Throwable unused) {
        }
    }

    public final boolean B() {
        return this.f79397l;
    }

    public final boolean C() {
        return this.f79396k;
    }

    public void D(String str) {
        va.a.C0873a.a(this, str);
    }

    public final void E(b bVar) {
        D("parseChainEnd_" + bVar);
        if (TextUtils.isEmpty(this.f79386a)) {
            return;
        }
        this.f79407v = bVar;
        List<Long> list = this.f79394i.get(String.valueOf(bVar.d()));
        if (list != null) {
            list.add(Long.valueOf(y(bVar)));
        }
        List<Long> list2 = this.f79394i.get(String.valueOf(bVar.d()));
        long jLongValue = 0;
        if (list2 != null && list2.size() == 2) {
            jLongValue = list2.get(1).longValue() - list2.get(0).longValue();
        }
        this.f79393h.put(String.valueOf(bVar.d()), Long.valueOf(jLongValue));
    }

    public final void F(b bVar) {
        D("parseChainStart_" + bVar);
        boolean z11 = bVar instanceof p;
        if (z11 && bVar.b().containsKey(com.cloud.tmc.kernel.proxy.performanceanalyse.a.Q)) {
            String string = bVar.b().getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.Q);
            if (string == null) {
                string = "";
            }
            this.f79386a = string;
        }
        if (TextUtils.isEmpty(this.f79386a)) {
            return;
        }
        if (z11 && !Intrinsics.b(this.f79391f, "3")) {
            if (bVar.b().containsKey(com.cloud.tmc.kernel.proxy.performanceanalyse.a.S)) {
                String string2 = bVar.b().getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.S, "0");
                Intrinsics.f(string2, "chainStartState.dataBund…tString(CHAIN_SCENE, \"0\")");
                this.f79392g = string2;
            }
            if (bVar.b().containsKey(com.cloud.tmc.kernel.proxy.performanceanalyse.a.T)) {
                String string3 = bVar.b().getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.T, "-1");
                Intrinsics.f(string3, "chainStartState.dataBund…CHAIN_OPEN_CHANNEL, \"-1\")");
                this.f79391f = string3;
            }
        }
        this.f79403r = bVar.d();
        this.f79407v = null;
        this.f79406u = bVar;
        this.f79394i.put(String.valueOf(bVar.d()), g.h(Long.valueOf(y(bVar))));
    }

    public final void G(b bVar) {
        List<Long> list;
        D("parseChianError_" + bVar);
        if (TextUtils.isEmpty(this.f79386a)) {
            return;
        }
        this.f79407v = bVar;
        b bVar2 = this.f79406u;
        if (bVar2 == null || (list = this.f79394i.get(String.valueOf(bVar2.d()))) == null || list.size() != 1) {
            return;
        }
        list.add(Long.valueOf(System.currentTimeMillis()));
        this.f79393h.put(String.valueOf(bVar2.d()), Long.valueOf(list.get(1).longValue() - list.get(0).longValue()));
    }

    public final void H(Bundle bundle) {
        TmcLogger.c("chainPoint", a.class.getName() + "_reportAppOpenEndFail->isReportEnd:" + this.f79397l);
        if (this.f79397l) {
            return;
        }
        this.f79397l = true;
        Bundle bundle2 = new Bundle();
        bundle2.putAll(bundle);
        bundle2.putString("openMiniAppResult", "false");
        bundle2.putString("openMiniAppFailedReason", this.f79387b);
        bundle2.putInt("maxStage", m());
        bundle2.putInt("syncType", this.f79401p);
        bundle2.putString("open_channel", String.valueOf(this.f79391f));
        bundle2.putString("hot_open_type", String.valueOf(this.f79409x));
        long j11 = bundle2.containsKey(com.cloud.tmc.kernel.proxy.performanceanalyse.a.P) ? bundle2.getLong(com.cloud.tmc.kernel.proxy.performanceanalyse.a.P) : System.currentTimeMillis();
        b bVar = this.f79406u;
        boolean z11 = bVar != null && this.f79407v == null;
        if (z11 && bVar != null) {
            Map<String, List<Long>> map = this.f79394i;
            Intrinsics.d(bVar);
            if (map.get(String.valueOf(bVar.d())) != null) {
                Map<String, List<Long>> map2 = this.f79394i;
                b bVar2 = this.f79406u;
                Intrinsics.d(bVar2);
                List<Long> list = map2.get(String.valueOf(bVar2.d()));
                if (list != null && list.size() == 1) {
                    Map<String, List<Long>> map3 = this.f79394i;
                    b bVar3 = this.f79406u;
                    Intrinsics.d(bVar3);
                    List<Long> list2 = map3.get(String.valueOf(bVar3.d()));
                    if (list2 != null) {
                        list2.add(Long.valueOf(j11));
                    }
                    Map<String, Long> map4 = this.f79393h;
                    b bVar4 = this.f79406u;
                    Intrinsics.d(bVar4);
                    String strValueOf = String.valueOf(bVar4.d());
                    Map<String, List<Long>> map5 = this.f79394i;
                    b bVar5 = this.f79406u;
                    Intrinsics.d(bVar5);
                    List<Long> list3 = map5.get(String.valueOf(bVar5.d()));
                    long jLongValue = list3 != null ? list3.get(1).longValue() : 0L;
                    Map<String, List<Long>> map6 = this.f79394i;
                    b bVar6 = this.f79406u;
                    Intrinsics.d(bVar6);
                    List<Long> list4 = map6.get(String.valueOf(bVar6.d()));
                    map4.put(strValueOf, Long.valueOf(jLongValue - (list4 != null ? list4.get(0).longValue() : 0L)));
                }
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        bundle2.putString("isExitInStage", String.valueOf(c(linkedHashMap, linkedHashMap2, z11)));
        bundle2.putString("stageCostTime", k.j(linkedHashMap2));
        bundle2.putString("stageRangeTime", k.j(linkedHashMap));
        bundle2.putString("scene", String.valueOf(this.f79392g));
        String string = bundle2.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N);
        if (string != null) {
            bundle2.putString("page_path", string);
        }
        bundle2.putString("openedPageCount", String.valueOf(this.f79390e.get()));
        bundle2.putString("appH5ProgressStatus", this.f79408w);
        bundle2.putBoolean("offScreenRender", this.f79389d);
        bundle2.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N);
        bundle2.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W);
        ((ReportProxy) tc.a.a(ReportProxy.class)).report(this.f79386a, "mini_app_open_end", bundle2);
    }

    public final void I(Bundle data, boolean z11) {
        Intrinsics.g(data, "data");
        try {
            TmcLogger.c("chainPoint", a.class.getName() + "_reportAppOpenEndSuccess->isReportEnd:" + this.f79397l);
            if (this.f79397l) {
                return;
            }
            this.f79397l = true;
            this.f79405t = true;
            Bundle bundle = new Bundle();
            bundle.putAll(data);
            bundle.putString("openMiniAppResult", "true");
            bundle.putString("openMiniAppFailedReason", "");
            bundle.putInt("syncType", this.f79401p);
            bundle.putString("isExitInStage", "false");
            bundle.putString("open_channel", String.valueOf(this.f79391f));
            bundle.putString("hot_open_type", String.valueOf(this.f79409x));
            bundle.putString("scene", String.valueOf(this.f79392g));
            bundle.putString("openByLaunch", String.valueOf(z11));
            String string = bundle.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N);
            if (string != null) {
                bundle.putString("page_path", string);
            }
            bundle.putString("appH5ProgressStatus", this.f79408w);
            bundle.putBoolean("offScreenRender", this.f79389d);
            bundle.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N);
            bundle.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W);
            ((ReportProxy) tc.a.a(ReportProxy.class)).report(this.f79386a, "mini_app_open_end", bundle);
        } catch (Throwable unused) {
        }
    }

    public final void J(Bundle bundle) {
        TmcLogger.c("chainPoint", a.class.getName() + "_reportAppOpenMidFail->isReportMid:" + this.f79396k);
        if (this.f79396k) {
            return;
        }
        this.f79396k = true;
        Bundle bundle2 = new Bundle();
        bundle2.putAll(bundle);
        bundle2.putString("openMiniAppResult", "false");
        bundle2.putString("openMiniAppFailedReason", this.f79387b);
        bundle2.putInt("maxStage", m());
        bundle2.putInt("syncType", this.f79401p);
        bundle2.putString("open_channel", String.valueOf(this.f79391f));
        bundle2.putString("hot_open_type", String.valueOf(this.f79409x));
        long j11 = bundle2.containsKey(com.cloud.tmc.kernel.proxy.performanceanalyse.a.P) ? bundle2.getLong(com.cloud.tmc.kernel.proxy.performanceanalyse.a.P) : System.currentTimeMillis();
        b bVar = this.f79406u;
        boolean z11 = bVar != null && this.f79407v == null;
        if (z11 && bVar != null) {
            Map<String, List<Long>> map = this.f79394i;
            Intrinsics.d(bVar);
            if (map.get(String.valueOf(bVar.d())) != null) {
                Map<String, List<Long>> map2 = this.f79394i;
                b bVar2 = this.f79406u;
                Intrinsics.d(bVar2);
                List<Long> list = map2.get(String.valueOf(bVar2.d()));
                if (list != null && list.size() == 1) {
                    Map<String, List<Long>> map3 = this.f79394i;
                    b bVar3 = this.f79406u;
                    Intrinsics.d(bVar3);
                    List<Long> list2 = map3.get(String.valueOf(bVar3.d()));
                    if (list2 != null) {
                        list2.add(Long.valueOf(j11));
                    }
                    Map<String, Long> map4 = this.f79393h;
                    b bVar4 = this.f79406u;
                    Intrinsics.d(bVar4);
                    String strValueOf = String.valueOf(bVar4.d());
                    Map<String, List<Long>> map5 = this.f79394i;
                    b bVar5 = this.f79406u;
                    Intrinsics.d(bVar5);
                    List<Long> list3 = map5.get(String.valueOf(bVar5.d()));
                    long jLongValue = list3 != null ? list3.get(1).longValue() : 0L;
                    Map<String, List<Long>> map6 = this.f79394i;
                    b bVar6 = this.f79406u;
                    Intrinsics.d(bVar6);
                    List<Long> list4 = map6.get(String.valueOf(bVar6.d()));
                    map4.put(strValueOf, Long.valueOf(jLongValue - (list4 != null ? list4.get(0).longValue() : 0L)));
                }
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        bundle2.putString("isExitInStage", String.valueOf(c(linkedHashMap, linkedHashMap2, z11)));
        bundle2.putString("stageCostTime", k.j(linkedHashMap2));
        bundle2.putString("stageRangeTime", k.j(linkedHashMap));
        bundle2.putString("scene", this.f79392g);
        String string = bundle2.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N);
        if (string != null) {
            bundle2.putString("page_path", string);
        }
        bundle2.putString("openedPageCount", String.valueOf(this.f79390e.get()));
        bundle2.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N);
        bundle2.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W);
        ((ReportProxy) tc.a.a(ReportProxy.class)).report(this.f79386a, "mini_app_open_mid", bundle2);
    }

    public final void K(Bundle data, boolean z11) {
        Intrinsics.g(data, "data");
        try {
            TmcLogger.c("chainPoint", a.class.getName() + "_reportAppOpenMidSuccess->isReportMid:" + this.f79396k);
            if (this.f79396k) {
                return;
            }
            this.f79396k = true;
            this.f79404s = true;
            Bundle bundle = new Bundle();
            bundle.putAll(data);
            bundle.putString("openMiniAppResult", "true");
            bundle.putString("openMiniAppFailedReason", "");
            bundle.putInt("syncType", this.f79401p);
            bundle.putString("isExitInStage", "false");
            bundle.putString("open_channel", String.valueOf(this.f79391f));
            bundle.putString("hot_open_type", String.valueOf(this.f79409x));
            bundle.putString("scene", String.valueOf(this.f79392g));
            bundle.putString("openByLaunch", String.valueOf(z11));
            String string = bundle.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N);
            if (string != null) {
                bundle.putString("page_path", string);
            }
            bundle.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N);
            bundle.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W);
            ((ReportProxy) tc.a.a(ReportProxy.class)).report(this.f79386a, "mini_app_open_mid", bundle);
        } catch (Throwable unused) {
        }
    }

    public final void L() {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("openMiniAppFailedReason", "reload");
            N(bundle);
            M(bundle);
        } catch (Throwable th2) {
            TmcLogger.h("Tmc", th2);
        }
    }

    public final void M(Bundle bundle) {
        b bVar;
        TmcLogger.c("chainPoint", a.class.getName() + "_reportPageOpenEndFail");
        Bundle bundle2 = new Bundle();
        bundle2.putAll(bundle);
        bundle2.putString("openPageResult", "false");
        bundle2.putString("openPageFailedReason", this.f79387b);
        bundle2.putInt("maxStage", this.f79403r);
        bundle2.putString("open_channel", String.valueOf(this.f79391f));
        bundle2.putString("hot_open_type", String.valueOf(this.f79409x));
        long j11 = bundle2.containsKey(com.cloud.tmc.kernel.proxy.performanceanalyse.a.P) ? bundle2.getLong(com.cloud.tmc.kernel.proxy.performanceanalyse.a.P) : System.currentTimeMillis();
        boolean z11 = this.f79406u != null && this.f79407v == null;
        bundle2.putString("isExitInStage", String.valueOf(z11));
        if (z11 && (bVar = this.f79406u) != null) {
            Map<String, List<Long>> map = this.f79394i;
            Intrinsics.d(bVar);
            if (map.get(String.valueOf(bVar.d())) != null) {
                Map<String, List<Long>> map2 = this.f79394i;
                b bVar2 = this.f79406u;
                Intrinsics.d(bVar2);
                List<Long> list = map2.get(String.valueOf(bVar2.d()));
                if (list != null && list.size() == 1) {
                    Map<String, List<Long>> map3 = this.f79394i;
                    b bVar3 = this.f79406u;
                    Intrinsics.d(bVar3);
                    List<Long> list2 = map3.get(String.valueOf(bVar3.d()));
                    if (list2 != null) {
                        list2.add(Long.valueOf(j11));
                    }
                    Map<String, Long> map4 = this.f79393h;
                    b bVar4 = this.f79406u;
                    Intrinsics.d(bVar4);
                    String strValueOf = String.valueOf(bVar4.d());
                    Map<String, List<Long>> map5 = this.f79394i;
                    b bVar5 = this.f79406u;
                    Intrinsics.d(bVar5);
                    List<Long> list3 = map5.get(String.valueOf(bVar5.d()));
                    long jLongValue = list3 != null ? list3.get(1).longValue() : 0L;
                    Map<String, List<Long>> map6 = this.f79394i;
                    b bVar6 = this.f79406u;
                    Intrinsics.d(bVar6);
                    List<Long> list4 = map6.get(String.valueOf(bVar6.d()));
                    map4.put(strValueOf, Long.valueOf(jLongValue - (list4 != null ? list4.get(0).longValue() : 0L)));
                }
            }
        }
        bundle2.putString("stageCostTime", k.j(this.f79393h));
        bundle2.putString("stageRangeTime", k.j(this.f79394i));
        bundle2.putString("scene", String.valueOf(this.f79392g));
        String string = bundle2.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N);
        if (string != null) {
            bundle2.putString("page_path", string);
        }
        bundle2.putString("pageIndex", "1");
        bundle2.putString("isAdd", "false");
        bundle2.putBoolean("offScreenRender", this.f79389d);
        bundle2.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N);
        bundle2.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W);
        ((ReportProxy) tc.a.a(ReportProxy.class)).report(this.f79386a, "mini_page_open_end", bundle2);
    }

    public final void N(Bundle bundle) {
        b bVar;
        TmcLogger.c("chainPoint", a.class.getName() + "_reportPageOpenMidFail");
        Bundle bundle2 = new Bundle();
        bundle2.putAll(bundle);
        bundle2.putString("openPageResult", "false");
        bundle2.putString("openPageFailedReason", this.f79387b);
        bundle2.putInt("maxStage", this.f79403r);
        bundle2.putString("open_channel", String.valueOf(this.f79391f));
        bundle2.putString("hot_open_type", String.valueOf(this.f79409x));
        long j11 = bundle2.containsKey(com.cloud.tmc.kernel.proxy.performanceanalyse.a.P) ? bundle2.getLong(com.cloud.tmc.kernel.proxy.performanceanalyse.a.P) : System.currentTimeMillis();
        boolean z11 = this.f79406u != null && this.f79407v == null;
        bundle2.putString("isExitInStage", String.valueOf(z11));
        if (z11 && (bVar = this.f79406u) != null) {
            Map<String, List<Long>> map = this.f79394i;
            Intrinsics.d(bVar);
            if (map.get(String.valueOf(bVar.d())) != null) {
                Map<String, List<Long>> map2 = this.f79394i;
                b bVar2 = this.f79406u;
                Intrinsics.d(bVar2);
                List<Long> list = map2.get(String.valueOf(bVar2.d()));
                if (list != null && list.size() == 1) {
                    Map<String, List<Long>> map3 = this.f79394i;
                    b bVar3 = this.f79406u;
                    Intrinsics.d(bVar3);
                    List<Long> list2 = map3.get(String.valueOf(bVar3.d()));
                    if (list2 != null) {
                        list2.add(Long.valueOf(j11));
                    }
                    Map<String, Long> map4 = this.f79393h;
                    b bVar4 = this.f79406u;
                    Intrinsics.d(bVar4);
                    String strValueOf = String.valueOf(bVar4.d());
                    Map<String, List<Long>> map5 = this.f79394i;
                    b bVar5 = this.f79406u;
                    Intrinsics.d(bVar5);
                    List<Long> list3 = map5.get(String.valueOf(bVar5.d()));
                    long jLongValue = list3 != null ? list3.get(1).longValue() : 0L;
                    Map<String, List<Long>> map6 = this.f79394i;
                    b bVar6 = this.f79406u;
                    Intrinsics.d(bVar6);
                    List<Long> list4 = map6.get(String.valueOf(bVar6.d()));
                    map4.put(strValueOf, Long.valueOf(jLongValue - (list4 != null ? list4.get(0).longValue() : 0L)));
                }
            }
        }
        bundle2.putString("stageCostTime", k.j(this.f79393h));
        bundle2.putString("stageRangeTime", k.j(this.f79394i));
        bundle2.putString("scene", String.valueOf(this.f79392g));
        String string = bundle2.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N);
        if (string != null) {
            bundle2.putString("page_path", string);
        }
        bundle2.putString("pageIndex", "1");
        bundle2.putString("isAdd", "false");
        bundle2.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.N);
        bundle2.remove(com.cloud.tmc.kernel.proxy.performanceanalyse.a.W);
        ((ReportProxy) tc.a.a(ReportProxy.class)).report(this.f79386a, "mini_page_open_mid", bundle2);
    }

    public final void O(int i11) {
        this.f79400o = i11;
    }

    public final void P(Map<String, Long> map) {
        Intrinsics.g(map, "<set-?>");
        this.f79398m = map;
    }

    public final void Q(Map<String, List<Long>> map) {
        Intrinsics.g(map, "<set-?>");
        this.f79399n = map;
    }

    public final void R(String str) {
        Intrinsics.g(str, "<set-?>");
        this.f79408w = str;
    }

    public final void S(String str) {
        Intrinsics.g(str, "<set-?>");
        this.f79409x = str;
    }

    public final void T(int i11) {
        this.f79403r = i11;
    }

    public final void U(String str) {
        Intrinsics.g(str, "<set-?>");
        this.f79391f = str;
    }

    public final void V(boolean z11) {
        this.f79405t = z11;
    }

    public final void W(boolean z11) {
        this.f79404s = z11;
    }

    public final void X(boolean z11) {
        this.f79397l = z11;
    }

    public final void Y(boolean z11) {
        this.f79396k = z11;
    }

    public final void Z(String str) {
        Intrinsics.g(str, "<set-?>");
        this.f79392g = str;
    }

    @Override // va.a
    public void a(b chainState) {
        Intrinsics.g(chainState, "chainState");
        try {
            D("setChainState_" + chainState.d());
            int i11 = C0886a.f79410a[chainState.c().ordinal()];
            if (i11 == 1) {
                F(chainState);
            } else if (i11 == 2) {
                E(chainState);
            } else if (i11 == 3) {
                G(chainState);
            } else if (i11 == 4) {
                A(chainState);
            }
        } catch (Throwable unused) {
        }
    }

    public final void a0(int i11) {
        this.f79401p = i11;
    }

    @Override // va.a
    public ContextType b() {
        return ContextType.TYPE_APP;
    }

    public final void b0(Map<String, Integer> map) {
        Intrinsics.g(map, "<set-?>");
        this.f79402q = map;
    }

    public final boolean c(Map<String, List<Long>> map, Map<String, Long> map2, boolean z11) {
        b bVar;
        TmcLogger.c("chainPoint", a.class.getName() + "_appendStages");
        if (Intrinsics.b(this.f79391f, "3")) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            b bVar2 = this.f79406u;
            int iD = bVar2 != null ? bVar2.d() : 1;
            if (1 <= iD) {
                int i11 = 1;
                while (true) {
                    map2.put(String.valueOf(i11), 0L);
                    map.put(String.valueOf(i11), g.h(Long.valueOf(jCurrentTimeMillis), Long.valueOf(jCurrentTimeMillis)));
                    if (i11 == iD) {
                        break;
                    }
                    i11++;
                }
            }
        } else if (Intrinsics.b(this.f79391f, "0")) {
            map.putAll(this.f79394i);
            map2.putAll(this.f79393h);
        }
        b bVar3 = this.f79406u;
        if (bVar3 != null && bVar3.d() == 11 && (bVar = this.f79407v) != null && bVar.d() == 11) {
            if ((!this.f79399n.isEmpty()) && ((List) ((Map.Entry) CollectionsKt___CollectionsKt.p0(this.f79399n.entrySet())).getValue()).size() == 1) {
                ((List) ((Map.Entry) CollectionsKt___CollectionsKt.p0(this.f79399n.entrySet())).getValue()).add(Long.valueOf(System.currentTimeMillis()));
                this.f79398m.put((String) ((Map.Entry) CollectionsKt___CollectionsKt.p0(this.f79399n.entrySet())).getKey(), Long.valueOf(((Number) ((List) ((Map.Entry) CollectionsKt___CollectionsKt.p0(this.f79399n.entrySet())).getValue()).get(1)).longValue() - ((Number) ((List) ((Map.Entry) CollectionsKt___CollectionsKt.p0(this.f79399n.entrySet())).getValue()).get(0)).longValue()));
                z11 = true;
            }
            map.putAll(this.f79399n);
            map2.putAll(this.f79398m);
        }
        return z11;
    }

    public final void d(PageChainContext pageChainContext, Map<String, List<Long>> tmpStateRangeTime, Map<String, Long> tmpStateCostTime, int i11) {
        Intrinsics.g(pageChainContext, "pageChainContext");
        Intrinsics.g(tmpStateRangeTime, "tmpStateRangeTime");
        Intrinsics.g(tmpStateCostTime, "tmpStateCostTime");
        TmcLogger.c("chainPoint", a.class.getName() + "_appendStages");
        if ((i11 != 17 || this.f79396k) && (i11 != 18 || this.f79397l)) {
            return;
        }
        tmpStateRangeTime.putAll(this.f79394i);
        tmpStateCostTime.putAll(this.f79393h);
        tmpStateRangeTime.putAll(pageChainContext.s());
        tmpStateCostTime.putAll(pageChainContext.r());
    }

    public void e(Bundle data) {
        Intrinsics.g(data, "data");
        try {
            TmcLogger.c("chainPoint", a.class.getName() + "_destroy");
            f(data);
            this.f79388c.clear();
        } catch (Throwable unused) {
        }
    }

    public final void f(Bundle bundle) {
        TmcLogger.c("chainPoint", a.class.getName() + "_destroyReport->openMiniAppMidResult:" + this.f79404s + ", openMiniAppEndResult:" + this.f79405t + ", pageIndexOfApp:" + this.f79395j.get());
        if (!this.f79404s) {
            if (this.f79395j.get() == 0) {
                N(bundle);
            }
            J(bundle);
        }
        if (this.f79405t) {
            return;
        }
        if (this.f79395j.get() == 0) {
            M(bundle);
        }
        H(bundle);
    }

    public final String g() {
        return this.f79386a;
    }

    public final b h() {
        return this.f79407v;
    }

    public final b i() {
        return this.f79406u;
    }

    public final String j() {
        return this.f79408w;
    }

    public final String k() {
        return this.f79409x;
    }

    public final int l() {
        return this.f79403r;
    }

    public final int m() {
        int i11 = this.f79403r;
        int i12 = this.f79400o;
        return i11 >= i12 ? i11 : i12;
    }

    public final String n() {
        return this.f79391f;
    }

    public final String o() {
        return this.f79387b;
    }

    public final AtomicInteger p() {
        return this.f79390e;
    }

    public final Stack<PageChainContext> q() {
        return this.f79388c;
    }

    public final AtomicInteger r() {
        return this.f79395j;
    }

    public final String s() {
        return this.f79392g;
    }

    public final Map<String, Long> t() {
        return this.f79393h;
    }

    public final Map<String, List<Long>> u() {
        return this.f79394i;
    }

    public final int v() {
        return this.f79401p;
    }

    public final int w(int i11, int i12) {
        if (i11 == 2) {
            return i11;
        }
        if (i11 == 0) {
            return i12;
        }
        return 0;
    }

    public final Map<String, Integer> x() {
        return this.f79402q;
    }

    public final long y(b bVar) {
        return bVar.b().containsKey(com.cloud.tmc.kernel.proxy.performanceanalyse.a.P) ? bVar.b().getLong(com.cloud.tmc.kernel.proxy.performanceanalyse.a.P) : bVar.a();
    }

    /* JADX WARN: Code duplicated, block: B:16:0x004f A[Catch: all -> 0x0092, TryCatch #0 {all -> 0x0092, blocks: (B:3:0x0005, B:5:0x002e, B:7:0x0036, B:8:0x0039, B:10:0x003d, B:16:0x004f, B:13:0x0046, B:17:0x005a, B:23:0x006c, B:20:0x0063, B:24:0x0072, B:33:0x008d, B:27:0x007b, B:30:0x0084), top: B:37:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:23:0x006c A[Catch: all -> 0x0092, TryCatch #0 {all -> 0x0092, blocks: (B:3:0x0005, B:5:0x002e, B:7:0x0036, B:8:0x0039, B:10:0x003d, B:16:0x004f, B:13:0x0046, B:17:0x005a, B:23:0x006c, B:20:0x0063, B:24:0x0072, B:33:0x008d, B:27:0x007b, B:30:0x0084), top: B:37:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x008d A[Catch: all -> 0x0092, TRY_LEAVE, TryCatch #0 {all -> 0x0092, blocks: (B:3:0x0005, B:5:0x002e, B:7:0x0036, B:8:0x0039, B:10:0x003d, B:16:0x004f, B:13:0x0046, B:17:0x005a, B:23:0x006c, B:20:0x0063, B:24:0x0072, B:33:0x008d, B:27:0x007b, B:30:0x0084), top: B:37:0x0005 }] */
    /* JADX WARN: Failed to clean up code after switch over string restore
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r1v2 int, still in use, count: 2, list:
  (r1v2 int) from 0x0034: IF  (r1v2 int) != (48 int)  -> B:7:0x0036 A[HIDDEN]
  (r1v2 int) from 0x0039: SWITCH (r1v2 int)
 case 2057739745: goto B:13:0x0046
 case 2057739746: goto B:10:0x003d
 default: goto B:9:0x003c A[Catch: all -> 0x0092, RegionRef:SW:8]
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
    	at jadx.core.utils.InsnRemover.remove(InsnRemover.java:226)
    	at jadx.core.utils.InsnRemover.remove(InsnRemover.java:215)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.replaceWithMergedSwitch(SwitchOverStringVisitor.java:355)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:111)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:72)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:140)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:47)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:66)
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void z(Bundle dataBundle) {
        Intrinsics.g(dataBundle, "dataBundle");
        try {
            String hotOpenType = dataBundle.getString("hot_open_type", "-1");
            TmcLogger.c("chainPoint", a.class.getName() + "_hotOpen -> hotOpenType:" + hotOpenType);
            if (hotOpenType != null) {
                if (iHashCode != 48) {
                    switch (hotOpenType) {
                        case "normal_1":
                        case "normal_2":
                            za.a.f81892a.a(this, dataBundle);
                            break;
                        case "normal_3":
                        case "normal_4":
                            za.a.f81892a.c(this, dataBundle);
                            break;
                        default:
                            switch (iHashCode) {
                                case 2057739745:
                                    if (hotOpenType.equals("shell_0")) {
                                        za.a aVar = za.a.f81892a;
                                        Intrinsics.f(hotOpenType, "hotOpenType");
                                        aVar.b(this, dataBundle, hotOpenType);
                                    }
                                    break;
                                case 2057739746:
                                    if (hotOpenType.equals("shell_1")) {
                                        za.a aVar2 = za.a.f81892a;
                                        Intrinsics.f(hotOpenType, "hotOpenType");
                                        aVar2.b(this, dataBundle, hotOpenType);
                                    }
                                    break;
                            }
                    }
                } else if (hotOpenType.equals("0")) {
                    za.a.f81892a.a(this, dataBundle);
                }
            }
        } catch (Throwable unused) {
        }
    }
}
