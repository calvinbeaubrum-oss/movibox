package jj;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.compose.animation.core.j0;
import androidx.core.os.s;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.components.ComponentDiscoveryService;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.concurrent.UiExecutor;
import com.google.firebase.provider.FirebaseInitProvider;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rj.o;
import rj.u;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class e {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Object f68012k = new Object();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Map<String, e> f68013l = new androidx.collection.a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f68014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f68015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f68016c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o f68017d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final u<hl.a> f68020g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final bl.b<com.google.firebase.heartbeatinfo.a> f68021h;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f68018e = new AtomicBoolean(false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f68019f = new AtomicBoolean();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<a> f68022i = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<Object> f68023j = new CopyOnWriteArrayList();

    /* JADX INFO: compiled from: source.java */
    @KeepForSdk
    public interface a {
        @KeepForSdk
        void onBackgroundStateChanged(boolean z11);
    }

    /* JADX INFO: compiled from: source.java */
    @TargetApi(14)
    public static class b implements BackgroundDetector.BackgroundStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static AtomicReference<b> f68024a = new AtomicReference<>();

        public static void b(Context context) {
            if (PlatformVersion.isAtLeastIceCreamSandwich() && (context.getApplicationContext() instanceof Application)) {
                Application application = (Application) context.getApplicationContext();
                if (f68024a.get() == null) {
                    b bVar = new b();
                    if (j0.a(f68024a, null, bVar)) {
                        BackgroundDetector.initialize(application);
                        BackgroundDetector.getInstance().addListener(bVar);
                    }
                }
            }
        }

        @Override // com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener
        public void onBackgroundStateChanged(boolean z11) {
            synchronized (e.f68012k) {
                try {
                    for (e eVar : new ArrayList(e.f68013l.values())) {
                        if (eVar.f68018e.get()) {
                            eVar.x(z11);
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @TargetApi(24)
    public static class c extends BroadcastReceiver {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static AtomicReference<c> f68025b = new AtomicReference<>();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f68026a;

        public c(Context context) {
            this.f68026a = context;
        }

        public static void b(Context context) {
            if (f68025b.get() == null) {
                c cVar = new c(context);
                if (j0.a(f68025b, null, cVar)) {
                    context.registerReceiver(cVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }

        public void c() {
            this.f68026a.unregisterReceiver(this);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            synchronized (e.f68012k) {
                try {
                    Iterator<e> it = e.f68013l.values().iterator();
                    while (it.hasNext()) {
                        it.next().o();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            c();
        }
    }

    public e(final Context context, String str, k kVar) {
        this.f68014a = (Context) Preconditions.checkNotNull(context);
        this.f68015b = Preconditions.checkNotEmpty(str);
        this.f68016c = (k) Preconditions.checkNotNull(kVar);
        l lVarB = FirebaseInitProvider.b();
        bm.c.b("Firebase");
        bm.c.b("ComponentDiscovery");
        List<bl.b<ComponentRegistrar>> listB = rj.g.c(context, ComponentDiscoveryService.class).b();
        bm.c.a();
        bm.c.b("Runtime");
        o.b bVarG = o.m(UiExecutor.INSTANCE).d(listB).c(new FirebaseCommonRegistrar()).c(new ExecutorsRegistrar()).b(rj.c.s(context, Context.class, new Class[0])).b(rj.c.s(this, e.class, new Class[0])).b(rj.c.s(kVar, k.class, new Class[0])).g(new bm.b());
        if (s.a(context) && FirebaseInitProvider.c()) {
            bVarG.b(rj.c.s(lVarB, l.class, new Class[0]));
        }
        o oVarE = bVarG.e();
        this.f68017d = oVarE;
        bm.c.a();
        this.f68020g = new u<>(new bl.b() { // from class: jj.c
            @Override // bl.b
            public final Object get() {
                return this.f68009a.u(context);
            }
        });
        this.f68021h = oVarE.f(com.google.firebase.heartbeatinfo.a.class);
        g(new a() { // from class: jj.d
            @Override // jj.e.a
            public final void onBackgroundStateChanged(boolean z11) {
                this.f68011a.v(z11);
            }
        });
        bm.c.a();
    }

    @NonNull
    public static e k() {
        e eVar;
        synchronized (f68012k) {
            try {
                eVar = f68013l.get("[DEFAULT]");
                if (eVar == null) {
                    throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + ProcessUtils.getMyProcessName() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
                }
                eVar.f68021h.get().l();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return eVar;
    }

    @Nullable
    public static e p(@NonNull Context context) {
        synchronized (f68012k) {
            try {
                if (f68013l.containsKey("[DEFAULT]")) {
                    return k();
                }
                k kVarA = k.a(context);
                if (kVarA == null) {
                    Log.w("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                    return null;
                }
                return q(context, kVarA);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @NonNull
    public static e q(@NonNull Context context, @NonNull k kVar) {
        return r(context, kVar, "[DEFAULT]");
    }

    @NonNull
    public static e r(@NonNull Context context, @NonNull k kVar, @NonNull String str) {
        e eVar;
        b.b(context);
        String strW = w(str);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (f68012k) {
            Map<String, e> map = f68013l;
            Preconditions.checkState(!map.containsKey(strW), "FirebaseApp name " + strW + " already exists!");
            Preconditions.checkNotNull(context, "Application context cannot be null.");
            eVar = new e(context, strW, kVar);
            map.put(strW, eVar);
        }
        eVar.o();
        return eVar;
    }

    public static String w(@NonNull String str) {
        return str.trim();
    }

    public boolean equals(Object obj) {
        if (obj instanceof e) {
            return this.f68015b.equals(((e) obj).l());
        }
        return false;
    }

    @KeepForSdk
    public void g(a aVar) {
        h();
        if (this.f68018e.get() && BackgroundDetector.getInstance().isInBackground()) {
            aVar.onBackgroundStateChanged(true);
        }
        this.f68022i.add(aVar);
    }

    public final void h() {
        Preconditions.checkState(!this.f68019f.get(), "FirebaseApp was deleted");
    }

    public int hashCode() {
        return this.f68015b.hashCode();
    }

    @KeepForSdk
    public <T> T i(Class<T> cls) {
        h();
        return (T) this.f68017d.b(cls);
    }

    @NonNull
    public Context j() {
        h();
        return this.f68014a;
    }

    @NonNull
    public String l() {
        h();
        return this.f68015b;
    }

    @NonNull
    public k m() {
        h();
        return this.f68016c;
    }

    @KeepForSdk
    public String n() {
        return Base64Utils.encodeUrlSafeNoPadding(l().getBytes(Charset.defaultCharset())) + "+" + Base64Utils.encodeUrlSafeNoPadding(m().c().getBytes(Charset.defaultCharset()));
    }

    public final void o() {
        if (!s.a(this.f68014a)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Device in Direct Boot Mode: postponing initialization of Firebase APIs for app ");
            sb2.append(l());
            c.b(this.f68014a);
            return;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Device unlocked: initializing all Firebase APIs for app ");
        sb3.append(l());
        this.f68017d.p(t());
        this.f68021h.get().l();
    }

    @KeepForSdk
    public boolean s() {
        h();
        return this.f68020g.get().b();
    }

    @KeepForSdk
    public boolean t() {
        return "[DEFAULT]".equals(l());
    }

    public String toString() {
        return Objects.toStringHelper(this).add("name", this.f68015b).add("options", this.f68016c).toString();
    }

    public final /* synthetic */ hl.a u(Context context) {
        return new hl.a(context, n(), (yk.c) this.f68017d.b(yk.c.class));
    }

    public final /* synthetic */ void v(boolean z11) {
        if (z11) {
            return;
        }
        this.f68021h.get().l();
    }

    public final void x(boolean z11) {
        Iterator<a> it = this.f68022i.iterator();
        while (it.hasNext()) {
            it.next().onBackgroundStateChanged(z11);
        }
    }
}
