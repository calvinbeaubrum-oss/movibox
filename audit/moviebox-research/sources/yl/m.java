package yl;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.remoteconfig.internal.ConfigFetchHttpClient;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
@KeepForSdk
public class m {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Clock f81530j = DefaultClock.getInstance();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Random f81531k = new Random();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, f> f81532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f81533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f81534c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final jj.e f81535d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final cl.g f81536e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final kj.b f81537f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final bl.b<nj.a> f81538g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f81539h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map<String, String> f81540i;

    public m(Context context, @qj.b Executor executor, jj.e eVar, cl.g gVar, kj.b bVar, bl.b<nj.a> bVar2) {
        this(context, executor, eVar, gVar, bVar, bVar2, true);
    }

    public m(Context context, Executor executor, jj.e eVar, cl.g gVar, kj.b bVar, bl.b<nj.a> bVar2, boolean z11) {
        this.f81532a = new HashMap();
        this.f81540i = new HashMap();
        this.f81533b = context;
        this.f81534c = executor;
        this.f81535d = eVar;
        this.f81536e = gVar;
        this.f81537f = bVar;
        this.f81538g = bVar2;
        this.f81539h = eVar.m().c();
        if (z11) {
            Tasks.call(executor, new Callable() { // from class: yl.k
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f81529a.e();
                }
            });
        }
    }

    public static com.google.firebase.remoteconfig.internal.c i(Context context, String str, String str2) {
        return new com.google.firebase.remoteconfig.internal.c(context.getSharedPreferences(String.format("%s_%s_%s_%s", "frc", str, str2, "settings"), 0));
    }

    @Nullable
    public static zl.m j(jj.e eVar, String str, bl.b<nj.a> bVar) {
        if (l(eVar) && str.equals("firebase")) {
            return new zl.m(bVar);
        }
        return null;
    }

    public static boolean k(jj.e eVar, String str) {
        return str.equals("firebase") && l(eVar);
    }

    public static boolean l(jj.e eVar) {
        return eVar.l().equals("[DEFAULT]");
    }

    public static /* synthetic */ nj.a m() {
        return null;
    }

    @KeepForSdk
    public synchronized f b(String str) {
        zl.d dVarD;
        zl.d dVarD2;
        zl.d dVarD3;
        com.google.firebase.remoteconfig.internal.c cVarI;
        zl.j jVarH;
        try {
            dVarD = d(str, "fetch");
            dVarD2 = d(str, "activate");
            dVarD3 = d(str, "defaults");
            cVarI = i(this.f81533b, this.f81539h, str);
            jVarH = h(dVarD2, dVarD3);
            final zl.m mVarJ = j(this.f81535d, str, this.f81538g);
            if (mVarJ != null) {
                jVarH.b(new BiConsumer() { // from class: yl.j
                    @Override // com.google.android.gms.common.util.BiConsumer
                    public final void accept(Object obj, Object obj2) {
                        mVarJ.a((String) obj, (com.google.firebase.remoteconfig.internal.a) obj2);
                    }
                });
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return c(this.f81535d, str, this.f81536e, this.f81537f, this.f81534c, dVarD, dVarD2, dVarD3, f(str, dVarD, cVarI), jVarH, cVarI);
    }

    public synchronized f c(jj.e eVar, String str, cl.g gVar, kj.b bVar, Executor executor, zl.d dVar, zl.d dVar2, zl.d dVar3, com.google.firebase.remoteconfig.internal.b bVar2, zl.j jVar, com.google.firebase.remoteconfig.internal.c cVar) {
        try {
            if (!this.f81532a.containsKey(str)) {
                f fVar = new f(this.f81533b, eVar, gVar, k(eVar, str) ? bVar : null, executor, dVar, dVar2, dVar3, bVar2, jVar, cVar);
                fVar.w();
                this.f81532a.put(str, fVar);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f81532a.get(str);
    }

    public final zl.d d(String str, String str2) {
        return zl.d.h(this.f81534c, zl.k.c(this.f81533b, String.format("%s_%s_%s_%s.json", "frc", this.f81539h, str, str2)));
    }

    public f e() {
        return b("firebase");
    }

    public synchronized com.google.firebase.remoteconfig.internal.b f(String str, zl.d dVar, com.google.firebase.remoteconfig.internal.c cVar) {
        try {
        } catch (Throwable th2) {
            throw th2;
        }
        return new com.google.firebase.remoteconfig.internal.b(this.f81536e, l(this.f81535d) ? this.f81538g : new bl.b() { // from class: yl.l
            @Override // bl.b
            public final Object get() {
                return m.m();
            }
        }, this.f81534c, f81530j, f81531k, dVar, g(this.f81535d.m().b(), str, cVar), cVar, this.f81540i);
    }

    public ConfigFetchHttpClient g(String str, String str2, com.google.firebase.remoteconfig.internal.c cVar) {
        return new ConfigFetchHttpClient(this.f81533b, this.f81535d.m().c(), str, str2, cVar.b(), cVar.b());
    }

    public final zl.j h(zl.d dVar, zl.d dVar2) {
        return new zl.j(this.f81534c, dVar, dVar2);
    }
}
