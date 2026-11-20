package androidx.room;

import android.annotation.SuppressLint;
import androidx.lifecycle.LiveData;
import java.util.Set;
import java.util.concurrent.Callable;
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
@SuppressLint({"RestrictedApi"})
public final class y<T> extends LiveData<T> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final RoomDatabase f12905l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final l f12906m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f12907n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Callable<T> f12908o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final InvalidationTracker.c f12909p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final AtomicBoolean f12910q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final AtomicBoolean f12911r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final AtomicBoolean f12912s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Runnable f12913t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Runnable f12914u;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends InvalidationTracker.c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ y<T> f12915b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String[] strArr, y<T> yVar) {
            super(strArr);
            this.f12915b = yVar;
        }

        @Override // androidx.room.InvalidationTracker.c
        public void c(Set<String> tables) {
            Intrinsics.g(tables, "tables");
            h1.c.h().b(this.f12915b.t());
        }
    }

    public y(RoomDatabase database, l container, boolean z11, Callable<T> computeFunction, String[] tableNames) {
        Intrinsics.g(database, "database");
        Intrinsics.g(container, "container");
        Intrinsics.g(computeFunction, "computeFunction");
        Intrinsics.g(tableNames, "tableNames");
        this.f12905l = database;
        this.f12906m = container;
        this.f12907n = z11;
        this.f12908o = computeFunction;
        this.f12909p = new a(tableNames, this);
        this.f12910q = new AtomicBoolean(true);
        this.f12911r = new AtomicBoolean(false);
        this.f12912s = new AtomicBoolean(false);
        this.f12913t = new Runnable() { // from class: androidx.room.w
            @Override // java.lang.Runnable
            public final void run() {
                y.w(this.f12903a);
            }
        };
        this.f12914u = new Runnable() { // from class: androidx.room.x
            @Override // java.lang.Runnable
            public final void run() {
                y.v(this.f12904a);
            }
        };
    }

    public static final void v(y this$0) {
        Intrinsics.g(this$0, "this$0");
        boolean zH = this$0.h();
        if (this$0.f12910q.compareAndSet(false, true) && zH) {
            this$0.u().execute(this$0.f12913t);
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0034 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void w(y this$0) {
        Intrinsics.g(this$0, "this$0");
        if (this$0.f12912s.compareAndSet(false, true)) {
            this$0.f12905l.m().d(this$0.f12909p);
        }
        while (this$0.f12911r.compareAndSet(false, true)) {
            T tCall = null;
            boolean z11 = false;
            while (this$0.f12910q.compareAndSet(true, false)) {
                try {
                    tCall = this$0.f12908o.call();
                    z11 = true;
                } catch (Exception e11) {
                    throw new RuntimeException("Exception while computing database live data.", e11);
                }
            }
            if (z11) {
                this$0.n(tCall);
            }
            this$0.f12911r.set(false);
            if (!z11 || !this$0.f12910q.get()) {
                return;
            }
        }
    }

    @Override // androidx.lifecycle.LiveData
    public void l() {
        super.l();
        l lVar = this.f12906m;
        Intrinsics.e(this, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Any>");
        lVar.b(this);
        u().execute(this.f12913t);
    }

    @Override // androidx.lifecycle.LiveData
    public void m() {
        super.m();
        l lVar = this.f12906m;
        Intrinsics.e(this, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Any>");
        lVar.c(this);
    }

    public final Runnable t() {
        return this.f12914u;
    }

    public final Executor u() {
        return this.f12907n ? this.f12905l.s() : this.f12905l.o();
    }
}
