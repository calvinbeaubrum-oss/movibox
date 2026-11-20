package ee;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.cloud.tmc.kernel.constants.MiniAppType;
import com.cloud.tmc.kernel.engine.EngineRouter;
import com.cloud.tmc.kernel.engine.IEngine;
import com.cloud.tmc.kernel.model.CreateParams;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.proxy.performanceanalyse.RenderAnalyseType;
import com.cloud.tmc.kernel.proxy.render.IWebViewFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zc.k;
import zc.l;
import zc.o;
import zc.p;

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
public final class j implements zc.i {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final a f64083y = new a(null);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final AtomicInteger f64084z = new AtomicInteger(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f64085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IEngine f64086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Node f64087c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CreateParams f64088d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f64089e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public k f64090f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f64091g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f64092h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public l f64093i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public zc.f f64094j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public zc.h f64095k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ac.a f64096l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f64097m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f64098n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f64099o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public EngineRouter f64100p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public p f64101q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public zc.a f64102r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public zc.d f64103s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public o f64104t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f64105u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f64106v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f64107w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f64108x;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @JvmOverloads
    public j(Context context, IEngine iEngine, Node node, CreateParams createParams) {
        this(context, iEngine, node, createParams, 0, 16, null);
    }

    @JvmOverloads
    public j(Context context, IEngine iEngine, Node node, CreateParams createParams, int i11) {
        this.f64085a = context;
        this.f64086b = iEngine;
        this.f64087c = node;
        this.f64088d = createParams;
        this.f64089e = i11;
        this.f64091g = "";
        this.f64099o = iEngine != null ? iEngine.getAppId() : null;
        IEngine iEngine2 = this.f64086b;
        this.f64100p = iEngine2 != null ? iEngine2.getEngineRouter() : null;
    }

    public /* synthetic */ j(Context context, IEngine iEngine, Node node, CreateParams createParams, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, iEngine, node, createParams, (i12 & 16) != 0 ? MiniAppType.NORMAL.ordinal() : i11);
    }

    public void A(int i11) {
        this.f64097m = true;
        this.f64106v = i11;
    }

    @Override // zc.i
    public boolean a() {
        return this.f64098n;
    }

    @Override // zc.i
    public String b() {
        return this.f64091g;
    }

    @Override // zc.i
    public boolean c() {
        return this.f64097m;
    }

    @Override // zc.i
    public void d(zc.f fVar) {
        this.f64094j = fVar;
        o oVar = this.f64104t;
        f fVar2 = oVar instanceof f ? (f) oVar : null;
        if (fVar2 != null) {
            fVar2.d(fVar);
        }
    }

    @Override // zc.i
    public void destroy() {
        this.f64092h = true;
        this.f64085a = null;
        this.f64100p = null;
        this.f64101q = null;
        this.f64104t = null;
        this.f64093i = null;
        this.f64094j = null;
        this.f64102r = null;
        this.f64103s = null;
        this.f64095k = null;
        ((IWebViewFactory) tc.a.a(IWebViewFactory.class)).clear();
        k kVar = this.f64090f;
        if (kVar != null) {
            kVar.destroy();
        }
        this.f64090f = null;
    }

    @Override // zc.i
    public int e() {
        return this.f64106v;
    }

    @Override // zc.i
    public void f(zc.h hVar) {
        this.f64095k = hVar;
        p pVar = this.f64101q;
        g gVar = pVar instanceof g ? (g) pVar : null;
        if (gVar != null) {
            Object obj = this.f64090f;
            gVar.b(obj instanceof WebView ? (WebView) obj : null, hVar);
        }
    }

    @Override // zc.i
    public Boolean g() {
        return Boolean.valueOf(this.f64108x);
    }

    @Override // zc.i
    public Activity getActivity() {
        Context context = this.f64085a;
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return null;
    }

    @Override // zc.i
    public String getAppId() {
        return this.f64099o;
    }

    @Override // zc.i
    public String getFrameworkVersion() {
        return this.f64107w;
    }

    @Override // zc.i
    public ac.a getRenderBridge() {
        return this.f64096l;
    }

    @Override // zc.i
    public View getView() {
        Object obj = this.f64090f;
        if (obj == null) {
            return null;
        }
        Intrinsics.e(obj, "null cannot be cast to non-null type android.view.View");
        return (View) obj;
    }

    @Override // zc.i
    public void h(EngineRouter engineRouter) {
        this.f64100p = engineRouter;
    }

    @Override // zc.i
    public Node i() {
        return this.f64087c;
    }

    @Override // zc.i
    public void init(String renderId) {
        Intrinsics.g(renderId, "renderId");
        if (this.f64085a == null) {
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this.f64099o, RenderAnalyseType.ERROR, "context不能为空!");
            return;
        }
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this.f64099o, RenderAnalyseType.INIT, null);
        this.f64091g = renderId;
        IEngine iEngineT = t();
        String workerId = iEngineT != null ? iEngineT.getWorkerId() : null;
        String str = workerId == null ? "" : workerId;
        this.f64104t = new b(this.f64094j);
        this.f64101q = new c(str, renderId, this.f64095k, new ne.a(), this.f64100p);
        this.f64102r = new ee.a(this.f64103s);
        k kVarCreateWebView = ((IWebViewFactory) tc.a.a(IWebViewFactory.class)).createWebView(this.f64085a, this.f64089e);
        if (kVarCreateWebView != null) {
            kVarCreateWebView.registerPageCallback(this.f64104t);
            kVarCreateWebView.registerPageEventCallback(this.f64101q);
            kVarCreateWebView.registerCustomViewVisiableCallback(this.f64102r);
        } else {
            kVarCreateWebView = null;
        }
        this.f64090f = kVarCreateWebView;
        if (kVarCreateWebView != null) {
            if (kVarCreateWebView instanceof WebView) {
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this.f64099o, RenderAnalyseType.CREATE_START, null);
                kVarCreateWebView.setAppId(this.f64099o);
                kVarCreateWebView.setNode(this.f64087c);
                kVarCreateWebView.create();
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this.f64099o, RenderAnalyseType.CREATE_END, null);
                this.f64096l = kVarCreateWebView.getRenderBridge();
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this.f64099o, PointAnalyseType.POINT_RENDER_READY, "");
            } else {
                ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this.f64099o, RenderAnalyseType.ERROR, kVarCreateWebView + " is not extends WebView; plz initialize WebView first");
                com.cloud.tmc.kernel.utils.p.c("TmcRender", kVarCreateWebView + " is not extends WebView; plz initialize WebView first");
            }
        }
        if (this.f64090f == null) {
            if (kotlin.text.l.L(renderId, "warmup_render_id_", false, 2, null)) {
                this.f64105u = true;
            } else {
                z();
            }
        }
    }

    @Override // zc.i
    public void j(String str) {
        this.f64099o = str;
        k kVar = this.f64090f;
        if (kVar != null) {
            kVar.setAppId(str);
        }
    }

    @Override // zc.i
    public void k(l lVar) {
        this.f64093i = lVar;
        String str = lVar != null ? lVar.f81893a : null;
        if (str == null) {
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this.f64099o, RenderAnalyseType.ERROR, "url is null,cant not load");
            com.cloud.tmc.kernel.utils.p.h("TmcRender", "url is null,cant not load");
        } else {
            k kVar = this.f64090f;
            if (kVar != null) {
                kVar.load(str);
            }
        }
    }

    @Override // zc.i
    public void l(zc.c cVar) {
        k kVar = this.f64090f;
        if (kVar != null) {
            kVar.goBack();
            Unit unit = Unit.f68710a;
        }
        if (cVar != null) {
            cVar.a(false);
        }
    }

    @Override // zc.i
    public void m(boolean z11) {
        this.f64108x = z11;
    }

    @Override // zc.i
    public void n(l lVar, String data, String str, String str2, String str3) {
        Intrinsics.g(data, "data");
        this.f64093i = lVar;
        k kVar = this.f64090f;
        if (kVar != null) {
            String str4 = lVar != null ? lVar.f81893a : null;
            if (str4 == null) {
                str4 = "";
            }
            kVar.loadData(str4, data, str, str2, str3);
        }
    }

    @Override // zc.i
    public void o(Activity activity) {
        this.f64085a = activity;
    }

    @Override // zc.i
    public void onPause() {
        k kVar = this.f64090f;
        if (kVar != null) {
            kVar.onPause();
        }
    }

    @Override // zc.i
    public void onResume() {
        k kVar = this.f64090f;
        if (kVar != null) {
            kVar.onResume();
        }
    }

    @Override // zc.i
    public void p(Node node) {
        this.f64087c = node;
        k kVar = this.f64090f;
        if (kVar != null) {
            kVar.setNode(node);
        }
    }

    @Override // zc.i
    public void q(String str) {
        this.f64099o = str;
    }

    @Override // zc.i
    public void r(IEngine iEngine) {
        this.f64086b = iEngine;
        p pVar = this.f64101q;
        e eVar = pVar instanceof e ? (e) pVar : null;
        if (eVar != null) {
            eVar.c(iEngine != null ? iEngine.getEngineRouter() : null);
        }
    }

    @Override // zc.i
    public void reload() {
        k kVar = this.f64090f;
        if (kVar != null) {
            kVar.reload();
        }
    }

    @Override // zc.i
    public void s(zc.b bVar) {
        destroy();
        Unit unit = Unit.f68710a;
        if (bVar != null) {
            bVar.a(false);
        }
    }

    @Override // zc.i
    public void setBgColor(String color) {
        Intrinsics.g(color, "color");
        k kVar = this.f64090f;
        if (kVar != null) {
            kVar.setBgColor(color);
        }
    }

    @Override // zc.i
    public void setFrameworkVersion(String str) {
        this.f64107w = str;
    }

    @Override // zc.i
    public void setMiniAppType(int i11) {
        k kVar = this.f64090f;
        if (kVar != null) {
            kVar.setMiniAppType(i11);
            this.f64096l = kVar.getRenderBridge();
        }
    }

    @Override // zc.i
    public void setSupportFullScreen(boolean z11) {
        k kVar = this.f64090f;
        if (kVar != null) {
            kVar.setSupportFullScreen(z11);
        }
    }

    @Override // zc.i
    public IEngine t() {
        return this.f64086b;
    }

    @Override // zc.i
    public void u() {
        this.f64098n = true;
    }

    @Override // zc.i
    public String v() {
        l lVar = this.f64093i;
        String str = lVar != null ? lVar.f81894b : null;
        return str == null ? "" : str;
    }

    @Override // zc.i
    public void w(CreateParams createParams) {
        this.f64088d = createParams;
    }

    @Override // zc.i
    public void x(String renderId) {
        String str;
        Intrinsics.g(renderId, "renderId");
        if (this.f64090f == null && (str = this.f64091g) != null && str != null && kotlin.text.l.L(str, "warmup_render_id_", false, 2, null) && this.f64105u) {
            this.f64105u = false;
            z();
        }
        this.f64091g = renderId;
        p pVar = this.f64101q;
        h hVar = pVar instanceof h ? (h) pVar : null;
        if (hVar != null) {
            hVar.a(renderId);
        }
    }

    @Override // zc.i
    public void y(zc.d dVar) {
        this.f64103s = dVar;
        zc.a aVar = this.f64102r;
        d dVar2 = aVar instanceof d ? (d) aVar : null;
        if (dVar2 != null) {
            dVar2.c(dVar);
        }
    }

    public final void z() {
        IEventCenterFactory iEventCenterFactory = (IEventCenterFactory) tc.a.a(IEventCenterFactory.class);
        uc.a aVarCreateEvent = iEventCenterFactory.createEvent(String.valueOf(this.f64091g));
        uc.b eventCenterInstance = iEventCenterFactory.getEventCenterInstance(this.f64087c);
        if (eventCenterInstance != null) {
            eventCenterInstance.d("create_miniapp_worker_fail", aVarCreateEvent);
        }
    }
}
