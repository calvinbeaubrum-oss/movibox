package com.vungle.warren;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.vungle.warren.downloader.AssetDownloader;
import com.vungle.warren.downloader.Downloader;
import com.vungle.warren.log.LogManager;
import com.vungle.warren.omsdk.OMInjector;
import com.vungle.warren.persistence.FilePreferences;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.utility.NetworkProvider;
import com.vungle.warren.utility.platform.AndroidPlatform;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class t {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    public static t f62338d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final com.vungle.warren.y f62339e = new k();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final y00.i.a f62340f = new s();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f62341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<Class, b0> f62342b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<Class, Object> f62343c = new HashMap();

    /* JADX INFO: compiled from: source.java */
    public class a extends b0 {
        public a() {
            super(t.this, null);
        }

        @Override // com.vungle.warren.t.b0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.vungle.warren.persistence.a a() {
            return new com.vungle.warren.persistence.a(t.this.f62341a, (FilePreferences) t.this.g(FilePreferences.class));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a0 extends b0 {
        public a0() {
            super(t.this, null);
        }

        @Override // com.vungle.warren.t.b0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.vungle.warren.persistence.d a() {
            return new com.vungle.warren.persistence.f((com.vungle.warren.persistence.a) t.this.g(com.vungle.warren.persistence.a.class));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends b0<com.vungle.warren.utility.platform.a> {
        public b() {
            super(t.this, null);
        }

        @Override // com.vungle.warren.t.b0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.vungle.warren.utility.platform.a a() {
            return new AndroidPlatform(t.this.f62341a, (Repository) t.this.g(Repository.class), ((com.vungle.warren.utility.f) t.this.g(com.vungle.warren.utility.f.class)).h(), (com.vungle.warren.utility.u) t.this.g(com.vungle.warren.utility.u.class));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public abstract class b0<T> {
        public b0() {
        }

        public /* synthetic */ b0(t tVar, k kVar) {
            this();
        }

        public abstract T a();

        public boolean b() {
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends b0 {
        public c() {
            super(t.this, null);
        }

        @Override // com.vungle.warren.t.b0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.vungle.warren.utility.f a() {
            return new com.vungle.warren.utility.p();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d extends b0 {
        public d() {
            super(t.this, null);
        }

        @Override // com.vungle.warren.t.b0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.vungle.warren.s a() {
            return new com.vungle.warren.s();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e extends b0 {
        public e() {
            super(t.this, null);
        }

        @Override // com.vungle.warren.t.b0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.vungle.warren.y a() {
            return t.f62339e;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f extends b0 {
        public f() {
            super(t.this, null);
        }

        @Override // com.vungle.warren.t.b0
        public boolean b() {
            return false;
        }

        @Override // com.vungle.warren.t.b0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.vungle.warren.r a() {
            return new com.vungle.warren.b((AdLoader) t.this.g(AdLoader.class), (com.vungle.warren.y) t.this.g(com.vungle.warren.y.class), (Repository) t.this.g(Repository.class), (VungleApiClient) t.this.g(VungleApiClient.class), (y00.h) t.this.g(y00.h.class), (com.vungle.warren.omsdk.a.b) t.this.g(com.vungle.warren.omsdk.a.b.class), ((com.vungle.warren.utility.f) t.this.g(com.vungle.warren.utility.f.class)).b());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g extends b0 {
        public g() {
            super(t.this, null);
        }

        @Override // com.vungle.warren.t.b0
        public Object a() {
            com.vungle.warren.persistence.a aVar = (com.vungle.warren.persistence.a) t.this.g(com.vungle.warren.persistence.a.class);
            return new com.vungle.warren.downloader.d(aVar, new com.vungle.warren.downloader.g(aVar, "clever_cache"), new com.vungle.warren.j(aVar, (com.vungle.warren.s) t.this.g(com.vungle.warren.s.class), 0.1f), TimeUnit.DAYS.toMillis(90L));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class h extends b0 {
        public h() {
            super(t.this, null);
        }

        @Override // com.vungle.warren.t.b0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.vungle.warren.v a() {
            return new com.vungle.warren.v((Repository) t.this.g(Repository.class), NetworkProvider.f(t.this.f62341a));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class i extends b0 {
        public i() {
            super(t.this, null);
        }

        @Override // com.vungle.warren.t.b0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.vungle.warren.utility.u a() {
            return new com.vungle.warren.utility.d();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class j extends b0 {
        public j() {
            super(t.this, null);
        }

        @Override // com.vungle.warren.t.b0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public OperationSequence a() {
            return new OperationSequence();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class k implements com.vungle.warren.y {
        @Override // com.vungle.warren.y
        public Collection<String> a() {
            return Vungle.getValidPlacements();
        }

        @Override // com.vungle.warren.y
        public boolean isInitialized() {
            return Vungle.isInitialized();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class l extends b0<OMInjector> {
        public l() {
            super(t.this, null);
        }

        @Override // com.vungle.warren.t.b0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public OMInjector a() {
            return new OMInjector(t.this.f62341a);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class m extends b0<com.vungle.warren.omsdk.a.b> {
        public m() {
            super(t.this, null);
        }

        @Override // com.vungle.warren.t.b0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.vungle.warren.omsdk.a.b a() {
            return new com.vungle.warren.omsdk.a.b();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class n extends b0<com.vungle.warren.g> {
        public n() {
            super(t.this, null);
        }

        @Override // com.vungle.warren.t.b0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.vungle.warren.g a() {
            return new com.vungle.warren.g((y00.h) t.this.g(y00.h.class));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class o extends b0<FilePreferences> {
        public o() {
            super(t.this, null);
        }

        @Override // com.vungle.warren.t.b0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public FilePreferences a() {
            return new FilePreferences(t.this.f62341a, ((com.vungle.warren.utility.f) t.this.g(com.vungle.warren.utility.f.class)).d());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class p extends b0<Gson> {
        public p() {
            super(t.this, null);
        }

        @Override // com.vungle.warren.t.b0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Gson a() {
            return new Gson();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class q extends b0<t00.a> {
        public q() {
            super(t.this, null);
        }

        @Override // com.vungle.warren.t.b0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public t00.a a() {
            return new t00.b();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class r extends b0<com.vungle.warren.f> {
        public r() {
            super(t.this, null);
        }

        @Override // com.vungle.warren.t.b0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.vungle.warren.f a() {
            return new com.vungle.warren.f((Repository) t.this.g(Repository.class), (com.vungle.warren.utility.u) t.this.g(com.vungle.warren.utility.u.class), (t00.a) t.this.g(t00.a.class), (com.vungle.warren.utility.platform.a) t.this.g(com.vungle.warren.utility.platform.a.class), (Gson) t.this.g(Gson.class), (com.vungle.warren.utility.p) t.this.g(com.vungle.warren.utility.p.class));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class s implements y00.i.a {
        @Override // y00.i.a
        public void a() {
            Vungle.reConfigure();
        }
    }

    /* JADX INFO: renamed from: com.vungle.warren.t$t, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0633t extends b0 {
        public C0633t() {
            super(t.this, null);
        }

        @Override // com.vungle.warren.t.b0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public y00.f a() {
            return new y00.l((Repository) t.this.g(Repository.class), (com.vungle.warren.persistence.d) t.this.g(com.vungle.warren.persistence.d.class), (VungleApiClient) t.this.g(VungleApiClient.class), new s00.c((VungleApiClient) t.this.g(VungleApiClient.class), (Repository) t.this.g(Repository.class)), t.f62340f, (AdLoader) t.this.g(AdLoader.class), t.f62339e, (LogManager) t.this.g(LogManager.class));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class u extends b0 {
        public u() {
            super(t.this, null);
        }

        @Override // com.vungle.warren.t.b0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public y00.h a() {
            return new VungleJobRunner((y00.f) t.this.g(y00.f.class), ((com.vungle.warren.utility.f) t.this.g(com.vungle.warren.utility.f.class)).e(), new z00.a(), NetworkProvider.f(t.this.f62341a));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class v extends b0 {
        public v() {
            super(t.this, null);
        }

        @Override // com.vungle.warren.t.b0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public AdLoader a() {
            return new AdLoader((com.vungle.warren.utility.f) t.this.g(com.vungle.warren.utility.f.class), (Repository) t.this.g(Repository.class), (VungleApiClient) t.this.g(VungleApiClient.class), (com.vungle.warren.persistence.a) t.this.g(com.vungle.warren.persistence.a.class), (Downloader) t.this.g(Downloader.class), (com.vungle.warren.s) t.this.g(com.vungle.warren.s.class), (com.vungle.warren.y) t.this.g(com.vungle.warren.y.class), (com.vungle.warren.v) t.this.g(com.vungle.warren.v.class), (OperationSequence) t.this.g(OperationSequence.class), (OMInjector) t.this.g(OMInjector.class));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class w extends b0 {
        public w() {
            super(t.this, null);
        }

        @Override // com.vungle.warren.t.b0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Downloader a() {
            return new AssetDownloader((com.vungle.warren.downloader.f) t.this.g(com.vungle.warren.downloader.f.class), AssetDownloader.f61958p, NetworkProvider.f(t.this.f62341a), ((com.vungle.warren.utility.f) t.this.g(com.vungle.warren.utility.f.class)).i(), ((com.vungle.warren.utility.f) t.this.g(com.vungle.warren.utility.f.class)).f());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class x extends b0 {
        public x() {
            super(t.this, null);
        }

        @Override // com.vungle.warren.t.b0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public VungleApiClient a() {
            return new VungleApiClient(t.this.f62341a, (com.vungle.warren.persistence.a) t.this.g(com.vungle.warren.persistence.a.class), (Repository) t.this.g(Repository.class), (OMInjector) t.this.g(OMInjector.class), (com.vungle.warren.utility.platform.a) t.this.g(com.vungle.warren.utility.platform.a.class));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class y extends b0 {
        public y() {
            super(t.this, null);
        }

        @Override // com.vungle.warren.t.b0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Repository a() {
            com.vungle.warren.utility.f fVar = (com.vungle.warren.utility.f) t.this.g(com.vungle.warren.utility.f.class);
            return new Repository(t.this.f62341a, (com.vungle.warren.persistence.d) t.this.g(com.vungle.warren.persistence.d.class), fVar.d(), fVar.f());
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class z extends b0 {
        public z() {
            super(t.this, null);
        }

        @Override // com.vungle.warren.t.b0
        public Object a() {
            return new LogManager(t.this.f62341a, (com.vungle.warren.persistence.a) t.this.g(com.vungle.warren.persistence.a.class), (VungleApiClient) t.this.g(VungleApiClient.class), ((com.vungle.warren.utility.f) t.this.g(com.vungle.warren.utility.f.class)).c(), (FilePreferences) t.this.g(FilePreferences.class));
        }
    }

    public t(@NonNull Context context) {
        this.f62341a = context.getApplicationContext();
        d();
    }

    public static synchronized void e() {
        f62338d = null;
    }

    public static synchronized t f(@NonNull Context context) {
        try {
            if (f62338d == null) {
                f62338d = new t(context);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f62338d;
    }

    public final void d() {
        this.f62342b.put(y00.f.class, new C0633t());
        this.f62342b.put(y00.h.class, new u());
        this.f62342b.put(AdLoader.class, new v());
        this.f62342b.put(Downloader.class, new w());
        this.f62342b.put(VungleApiClient.class, new x());
        this.f62342b.put(Repository.class, new y());
        this.f62342b.put(LogManager.class, new z());
        this.f62342b.put(com.vungle.warren.persistence.d.class, new a0());
        this.f62342b.put(com.vungle.warren.persistence.a.class, new a());
        this.f62342b.put(com.vungle.warren.utility.platform.a.class, new b());
        this.f62342b.put(com.vungle.warren.utility.f.class, new c());
        this.f62342b.put(com.vungle.warren.s.class, new d());
        this.f62342b.put(com.vungle.warren.y.class, new e());
        this.f62342b.put(com.vungle.warren.r.class, new f());
        this.f62342b.put(com.vungle.warren.downloader.f.class, new g());
        this.f62342b.put(com.vungle.warren.v.class, new h());
        this.f62342b.put(com.vungle.warren.utility.u.class, new i());
        this.f62342b.put(OperationSequence.class, new j());
        this.f62342b.put(OMInjector.class, new l());
        this.f62342b.put(com.vungle.warren.omsdk.a.b.class, new m());
        this.f62342b.put(com.vungle.warren.g.class, new n());
        this.f62342b.put(FilePreferences.class, new o());
        this.f62342b.put(Gson.class, new p());
        this.f62342b.put(t00.a.class, new q());
        this.f62342b.put(com.vungle.warren.f.class, new r());
    }

    public final <T> T g(@NonNull Class<T> cls) {
        Class clsI = i(cls);
        T t11 = (T) this.f62343c.get(clsI);
        if (t11 != null) {
            return t11;
        }
        b0 b0Var = this.f62342b.get(clsI);
        if (b0Var == null) {
            throw new IllegalArgumentException("Unknown class");
        }
        T t12 = (T) b0Var.a();
        if (b0Var.b()) {
            this.f62343c.put(clsI, t12);
        }
        return t12;
    }

    public synchronized <T> T h(Class<T> cls) {
        return (T) g(cls);
    }

    @NonNull
    public final Class i(@NonNull Class cls) {
        for (Class cls2 : this.f62342b.keySet()) {
            if (cls2.isAssignableFrom(cls)) {
                return cls2;
            }
        }
        throw new IllegalArgumentException("Unknown dependency for " + cls);
    }

    public synchronized <T> boolean j(Class<T> cls) {
        return this.f62343c.containsKey(i(cls));
    }
}
