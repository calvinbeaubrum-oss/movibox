package com.cloud.tmc.worker;

import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import com.cloud.tmc.kernel.bridge.IMsgDispatcher;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.WorkerAnalyseType;
import com.cloud.tmc.kernel.resource.IPackageResourceManager;
import com.cloud.tmc.worker.debug.WebviewWorker;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import gd.d;
import gd.e;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.l;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;

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
public final class WorkerManager implements gd.b {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f32140n = new a(null);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f32141o = "resend_page_enter";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gd.a f32142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f32143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f32144c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Node f32145d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f32146e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public gd.b.a f32147f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map<String, gd.c> f32148g = new HashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Handler f32149h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f32150i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f32151j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f32152k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f32153l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f32154m;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return WorkerManager.f32141o;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public final class b implements d {
        public b() {
        }

        /* JADX WARN: Code duplicated, block: B:9:0x0016  */
        public static final void c(JsonObject jsonObject, WorkerManager this$0) {
            String asString;
            Intrinsics.g(this$0, "this$0");
            if (jsonObject != null) {
                try {
                    JsonElement jsonElement = jsonObject.get("abilityName");
                    if (jsonElement != null) {
                        asString = jsonElement.getAsString();
                    } else {
                        asString = null;
                    }
                } catch (Exception e11) {
                    TmcLogger.f("TmcWorker", "Worker send message to Native/Render fail: " + e11 + " ; ");
                    return;
                }
            } else {
                asString = null;
            }
            if (!Intrinsics.b(asString, "callback")) {
                ((IMsgDispatcher) tc.a.a(IMsgDispatcher.class)).handleMsgFromWorker(this$0, jsonObject);
                return;
            }
            String asString2 = jsonObject.get("callbackId").getAsString();
            gd.c cVar = (gd.c) this$0.f32148g.get(asString2);
            if (cVar != null) {
                cVar.a(jsonObject);
            }
            this$0.f32148g.remove(asString2);
        }

        @Override // gd.d
        public void a(final JsonObject jsonObject) {
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(WorkerManager.this.f32144c, WorkerAnalyseType.SEND_TO_NATIVE, new Gson().toJson((JsonElement) jsonObject));
            Handler handler = WorkerManager.this.f32149h;
            final WorkerManager workerManager = WorkerManager.this;
            handler.post(new Runnable() { // from class: com.cloud.tmc.worker.a
                @Override // java.lang.Runnable
                public final void run() {
                    WorkerManager.b.c(jsonObject, workerManager);
                }
            });
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public final class c implements e {
        public c() {
        }

        public static final void b(WorkerManager this$0) {
            Intrinsics.g(this$0, "this$0");
            gd.b.a aVar = this$0.f32147f;
            if (aVar != null) {
                aVar.a();
            }
        }

        @Override // gd.e
        public void onCreate() {
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(WorkerManager.this.f32144c, WorkerAnalyseType.CREATE_END, null);
            Handler handler = WorkerManager.this.f32149h;
            final WorkerManager workerManager = WorkerManager.this;
            handler.post(new Runnable() { // from class: com.cloud.tmc.worker.b
                @Override // java.lang.Runnable
                public final void run() {
                    WorkerManager.c.b(workerManager);
                }
            });
        }

        @Override // gd.e
        public void onDestroy() {
            WorkerManager.this.f32147f = null;
        }
    }

    public WorkerManager() {
        Looper mainLooper = Looper.getMainLooper();
        Intrinsics.d(mainLooper);
        this.f32149h = new Handler(mainLooper);
    }

    public final void D() {
        IEventCenterFactory iEventCenterFactory = (IEventCenterFactory) tc.a.a(IEventCenterFactory.class);
        uc.a aVarCreateEvent = iEventCenterFactory.createEvent(String.valueOf(this.f32143b));
        uc.b eventCenterInstance = iEventCenterFactory.getEventCenterInstance(this.f32145d);
        if (eventCenterInstance != null) {
            eventCenterInstance.d("create_miniapp_worker_fail", aVarCreateEvent);
        }
    }

    public void E(int i11) {
        this.f32151j = true;
        this.f32153l = i11;
    }

    @Override // gd.b
    public Boolean a() {
        return Boolean.valueOf(this.f32150i);
    }

    @Override // gd.b
    public Boolean c() {
        return Boolean.valueOf(this.f32151j);
    }

    @Override // gd.b
    public void destroy() {
        this.f32147f = null;
        this.f32148g.clear();
        gd.a aVar = this.f32142a;
        if (aVar != null) {
            aVar.destroy();
        }
        this.f32145d = null;
    }

    @Override // gd.b
    public int e() {
        return this.f32153l;
    }

    @Override // gd.b
    public void f() {
        Object obj = this.f32142a;
        if (obj == null || !(obj instanceof WebView)) {
            return;
        }
        ((WebView) obj).loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
    }

    @Override // gd.b
    public void g(String str, String str2) {
        try {
            String filePath = ((IPackageResourceManager) tc.a.a(IPackageResourceManager.class)).getFilePath(str, str2);
            gd.a aVar = this.f32142a;
            if (aVar != null) {
                aVar.loadJS(filePath);
            }
        } catch (Exception e11) {
            TmcLogger.o("TmcWorker", "parse appLoadResult fail:" + e11);
        }
    }

    @Override // gd.b
    public String getFrameworkVersion() {
        return this.f32154m;
    }

    @Override // gd.b
    public Node getNode() {
        return this.f32145d;
    }

    @Override // gd.b
    public String getWorkerId() {
        return this.f32143b;
    }

    @Override // gd.b
    public void h() {
        this.f32150i = true;
    }

    @Override // gd.b
    public boolean i() {
        gd.a aVar = this.f32142a;
        Boolean boolIsLoad = aVar != null ? aVar.isLoad() : null;
        if (boolIsLoad == null) {
            return false;
        }
        return boolIsLoad.booleanValue();
    }

    @Override // gd.b
    public boolean isDestroyed() {
        gd.a aVar = this.f32142a;
        Boolean boolIsDestroy = aVar != null ? aVar.isDestroy() : null;
        if (boolIsDestroy == null) {
            return true;
        }
        return boolIsDestroy.booleanValue();
    }

    @Override // gd.b
    public Boolean isRenderProcessGone() {
        gd.a aVar = this.f32142a;
        yc.a aVar2 = aVar instanceof yc.a ? (yc.a) aVar : null;
        if (aVar2 != null) {
            return aVar2.isRenderProcessGone();
        }
        return null;
    }

    @Override // gd.b
    public void j(HashMap<String, Object> map, gd.c cVar) {
        Object obj = map != null ? map.get("callbackId") : null;
        if (obj != null && cVar != null) {
            this.f32148g.put(String.valueOf(obj), cVar);
        }
        gd.a aVar = this.f32142a;
        if (aVar != null) {
            aVar.execute(map);
        }
    }

    @Override // gd.b
    public void k(JsonObject jsonObject, gd.c cVar) {
        JsonElement jsonElement = jsonObject != null ? jsonObject.get("callbackId") : null;
        if (jsonElement != null && cVar != null) {
            this.f32148g.put(String.valueOf(jsonElement), cVar);
        }
        gd.a aVar = this.f32142a;
        if (aVar != null) {
            aVar.execute(jsonObject);
        }
    }

    @Override // gd.b
    public void l(gd.b.a aVar) {
        ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(this.f32144c, WorkerAnalyseType.INIT, null);
        this.f32147f = aVar;
        j.d(l0.a(w0.c()), null, null, new WorkerManager$registerWorkerReadyListener$1(this, null), 3, null);
    }

    @Override // gd.b
    public Handler m() {
        return this.f32149h;
    }

    @Override // gd.b
    public Boolean n() {
        return Boolean.valueOf(this.f32146e);
    }

    @Override // gd.b
    public void o() {
    }

    @Override // gd.b
    public void p(String str) {
        this.f32146e = true;
        IEventCenterFactory iEventCenterFactory = (IEventCenterFactory) tc.a.a(IEventCenterFactory.class);
        uc.a aVarCreateEvent = iEventCenterFactory.createEvent(str);
        uc.b eventCenterInstance = iEventCenterFactory.getEventCenterInstance(this.f32145d);
        if (eventCenterInstance != null) {
            eventCenterInstance.d(f32141o, aVarCreateEvent);
        }
    }

    @Override // gd.b
    public void q() {
        gd.a aVar = this.f32142a;
        if (aVar == null || aVar.type() != 3) {
            return;
        }
        gd.a aVar2 = this.f32142a;
        WebviewWorker webviewWorker = aVar2 instanceof WebviewWorker ? (WebviewWorker) aVar2 : null;
        if (webviewWorker != null) {
            webviewWorker.registerWorkerMessageChannel();
        }
    }

    @Override // gd.b
    public void r(String str) {
        String str2;
        if (this.f32142a == null && (str2 = this.f32143b) != null && str2 != null && l.L(str2, "warmup_worker_id_", false, 2, null) && this.f32152k) {
            this.f32152k = false;
            D();
        }
        this.f32143b = str;
    }

    @Override // gd.b
    public void s(String str) {
        me.b bVar;
        try {
            gd.a aVar = this.f32142a;
            WebviewWorker webviewWorker = aVar instanceof WebviewWorker ? (WebviewWorker) aVar : null;
            if (webviewWorker == null || (bVar = webviewWorker.getmWebViewClientInstance()) == null) {
                return;
            }
            if (str == null) {
                str = "";
            }
            bVar.a(str);
        } catch (Throwable unused) {
        }
    }

    @Override // gd.b
    public void setAppId(String str) {
        this.f32144c = str;
    }

    @Override // gd.b
    public void setFrameworkVersion(String str) {
        this.f32154m = str;
    }

    @Override // gd.b
    public void setNode(Node node) {
        this.f32145d = node;
    }

    @Override // gd.b
    public int workerType() {
        gd.a aVar = this.f32142a;
        if (aVar != null) {
            return aVar.type();
        }
        return 0;
    }
}
