package androidx.room;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InvalidationTracker f12867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f12868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f12869d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f12870e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public InvalidationTracker.c f12871f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public k f12872g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final j f12873h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicBoolean f12874i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ServiceConnection f12875j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Runnable f12876k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Runnable f12877l;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends InvalidationTracker.c {
        public a(String[] strArr) {
            super(strArr);
        }

        @Override // androidx.room.InvalidationTracker.c
        public boolean b() {
            return true;
        }

        @Override // androidx.room.InvalidationTracker.c
        public void c(Set<String> tables) {
            Intrinsics.g(tables, "tables");
            if (p.this.j().get()) {
                return;
            }
            try {
                k kVarH = p.this.h();
                if (kVarH != null) {
                    int iC = p.this.c();
                    Object[] array = tables.toArray(new String[0]);
                    Intrinsics.e(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    kVarH.y(iC, (String[]) array);
                }
            } catch (RemoteException e11) {
                Log.w("ROOM", "Cannot broadcast invalidation", e11);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends j.a {
        public b() {
        }

        public static final void g0(p this$0, String[] tables) {
            Intrinsics.g(this$0, "this$0");
            Intrinsics.g(tables, "$tables");
            this$0.e().m((String[]) Arrays.copyOf(tables, tables.length));
        }

        @Override // androidx.room.j
        public void c(final String[] tables) {
            Intrinsics.g(tables, "tables");
            Executor executorD = p.this.d();
            final p pVar = p.this;
            executorD.execute(new Runnable() { // from class: androidx.room.q
                @Override // java.lang.Runnable
                public final void run() {
                    p.b.g0(pVar, tables);
                }
            });
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements ServiceConnection {
        public c() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            Intrinsics.g(name, "name");
            Intrinsics.g(service, "service");
            p.this.m(k.a.e0(service));
            p.this.d().execute(p.this.i());
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            Intrinsics.g(name, "name");
            p.this.d().execute(p.this.g());
            p.this.m(null);
        }
    }

    public p(Context context, String name, Intent serviceIntent, InvalidationTracker invalidationTracker, Executor executor) {
        Intrinsics.g(context, "context");
        Intrinsics.g(name, "name");
        Intrinsics.g(serviceIntent, "serviceIntent");
        Intrinsics.g(invalidationTracker, "invalidationTracker");
        Intrinsics.g(executor, "executor");
        this.f12866a = name;
        this.f12867b = invalidationTracker;
        this.f12868c = executor;
        Context applicationContext = context.getApplicationContext();
        this.f12869d = applicationContext;
        this.f12873h = new b();
        this.f12874i = new AtomicBoolean(false);
        c cVar = new c();
        this.f12875j = cVar;
        this.f12876k = new Runnable() { // from class: androidx.room.n
            @Override // java.lang.Runnable
            public final void run() {
                p.n(this.f12864a);
            }
        };
        this.f12877l = new Runnable() { // from class: androidx.room.o
            @Override // java.lang.Runnable
            public final void run() {
                p.k(this.f12865a);
            }
        };
        Object[] array = invalidationTracker.k().keySet().toArray(new String[0]);
        Intrinsics.e(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        l(new a((String[]) array));
        applicationContext.bindService(serviceIntent, cVar, 1);
    }

    public static final void k(p this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.f12867b.p(this$0.f());
    }

    public static final void n(p this$0) {
        Intrinsics.g(this$0, "this$0");
        try {
            k kVar = this$0.f12872g;
            if (kVar != null) {
                this$0.f12870e = kVar.H(this$0.f12873h, this$0.f12866a);
                this$0.f12867b.c(this$0.f());
            }
        } catch (RemoteException e11) {
            Log.w("ROOM", "Cannot register multi-instance invalidation callback", e11);
        }
    }

    public final int c() {
        return this.f12870e;
    }

    public final Executor d() {
        return this.f12868c;
    }

    public final InvalidationTracker e() {
        return this.f12867b;
    }

    public final InvalidationTracker.c f() {
        InvalidationTracker.c cVar = this.f12871f;
        if (cVar != null) {
            return cVar;
        }
        Intrinsics.y("observer");
        return null;
    }

    public final Runnable g() {
        return this.f12877l;
    }

    public final k h() {
        return this.f12872g;
    }

    public final Runnable i() {
        return this.f12876k;
    }

    public final AtomicBoolean j() {
        return this.f12874i;
    }

    public final void l(InvalidationTracker.c cVar) {
        Intrinsics.g(cVar, "<set-?>");
        this.f12871f = cVar;
    }

    public final void m(k kVar) {
        this.f12872g = kVar;
    }
}
