package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.o1;
import java.util.Set;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public abstract class j {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f3684e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f3685f = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SnapshotIdSet f3686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3688c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3689d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static final void j(Function2 function2) {
            synchronized (SnapshotKt.I()) {
                SnapshotKt.f3609h = CollectionsKt___CollectionsKt.v0(SnapshotKt.f3609h, function2);
                Unit unit = Unit.f68710a;
            }
        }

        public static final void l(Function1 function1) {
            synchronized (SnapshotKt.I()) {
                SnapshotKt.f3610i = CollectionsKt___CollectionsKt.v0(SnapshotKt.f3610i, function1);
                Unit unit = Unit.f68710a;
            }
            SnapshotKt.B();
        }

        public final j c() {
            return SnapshotKt.H();
        }

        public final j d() {
            return (j) SnapshotKt.f3603b.a();
        }

        public final boolean e() {
            return SnapshotKt.f3603b.a() != null;
        }

        @PublishedApi
        public final j f(j jVar) {
            if (jVar instanceof g0) {
                g0 g0Var = (g0) jVar;
                if (g0Var.U() == androidx.compose.runtime.b.a()) {
                    g0Var.X(null);
                    return jVar;
                }
            }
            if (jVar instanceof h0) {
                h0 h0Var = (h0) jVar;
                if (h0Var.C() == androidx.compose.runtime.b.a()) {
                    h0Var.F(null);
                    return jVar;
                }
            }
            j jVarE = SnapshotKt.E(jVar, null, false, 6, null);
            jVarE.l();
            return jVarE;
        }

        public final void g() {
            SnapshotKt.H().o();
        }

        public final <T> T h(Function1<Object, Unit> function1, Function1<Object, Unit> function2, Function0<? extends T> function0) {
            j g0Var;
            if (function1 == null && function2 == null) {
                return function0.invoke();
            }
            j jVar = (j) SnapshotKt.f3603b.a();
            if (jVar instanceof g0) {
                g0 g0Var2 = (g0) jVar;
                if (g0Var2.U() == androidx.compose.runtime.b.a()) {
                    Function1<Object, Unit> function1H = g0Var2.h();
                    Function1<Object, Unit> function1K = g0Var2.k();
                    try {
                        ((g0) jVar).X(SnapshotKt.L(function1, function1H, false, 4, null));
                        ((g0) jVar).Y(SnapshotKt.M(function2, function1K));
                        return function0.invoke();
                    } finally {
                        g0Var2.X(function1H);
                        g0Var2.Y(function1K);
                    }
                }
            }
            if (jVar == null || (jVar instanceof b)) {
                g0Var = new g0(jVar instanceof b ? (b) jVar : null, function1, function2, true, false);
            } else {
                if (function1 == null) {
                    return function0.invoke();
                }
                g0Var = jVar.x(function1);
            }
            try {
                j jVarL = g0Var.l();
                try {
                    T tInvoke = function0.invoke();
                    g0Var.s(jVarL);
                    g0Var.d();
                    return tInvoke;
                } catch (Throwable th2) {
                    g0Var.s(jVarL);
                    throw th2;
                }
            } catch (Throwable th3) {
                g0Var.d();
                throw th3;
            }
        }

        public final e i(final Function2<? super Set<? extends Object>, ? super j, Unit> function2) {
            SnapshotKt.A(SnapshotKt.f3602a);
            synchronized (SnapshotKt.I()) {
                SnapshotKt.f3609h = CollectionsKt___CollectionsKt.y0(SnapshotKt.f3609h, function2);
                Unit unit = Unit.f68710a;
            }
            return new e() { // from class: androidx.compose.runtime.snapshots.h
                @Override // androidx.compose.runtime.snapshots.e
                public final void dispose() {
                    j.a.j(function2);
                }
            };
        }

        public final e k(final Function1<Object, Unit> function1) {
            synchronized (SnapshotKt.I()) {
                SnapshotKt.f3610i = CollectionsKt___CollectionsKt.y0(SnapshotKt.f3610i, function1);
                Unit unit = Unit.f68710a;
            }
            SnapshotKt.B();
            return new e() { // from class: androidx.compose.runtime.snapshots.i
                @Override // androidx.compose.runtime.snapshots.e
                public final void dispose() {
                    j.a.l(function1);
                }
            };
        }

        @PublishedApi
        public final void m(j jVar, j jVar2, Function1<Object, Unit> function1) {
            if (jVar != jVar2) {
                jVar2.s(jVar);
                jVar2.d();
            } else if (jVar instanceof g0) {
                ((g0) jVar).X(function1);
            } else {
                if (jVar instanceof h0) {
                    ((h0) jVar).F(function1);
                    return;
                }
                throw new IllegalStateException(("Non-transparent snapshot was reused: " + jVar).toString());
            }
        }

        public final void n() {
            boolean z11;
            synchronized (SnapshotKt.I()) {
                MutableScatterSet<c0> mutableScatterSetE = ((GlobalSnapshot) SnapshotKt.f3611j.get()).E();
                z11 = false;
                if (mutableScatterSetE != null && mutableScatterSetE.e()) {
                    z11 = true;
                }
            }
            if (z11) {
                SnapshotKt.B();
            }
        }

        public final b o(Function1<Object, Unit> function1, Function1<Object, Unit> function2) {
            b bVarQ;
            j jVarH = SnapshotKt.H();
            b bVar = jVarH instanceof b ? (b) jVarH : null;
            if (bVar == null || (bVarQ = bVar.Q(function1, function2)) == null) {
                throw new IllegalStateException("Cannot create a mutable snapshot of an read-only snapshot".toString());
            }
            return bVarQ;
        }
    }

    public j(int i11, SnapshotIdSet snapshotIdSet) {
        this.f3686a = snapshotIdSet;
        this.f3687b = i11;
        this.f3689d = i11 != 0 ? SnapshotKt.c0(i11, g()) : -1;
    }

    public /* synthetic */ j(int i11, SnapshotIdSet snapshotIdSet, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, snapshotIdSet);
    }

    public final void b() {
        synchronized (SnapshotKt.I()) {
            c();
            r();
            Unit unit = Unit.f68710a;
        }
    }

    public void c() {
        SnapshotKt.f3605d = SnapshotKt.f3605d.r(f());
    }

    public void d() {
        this.f3688c = true;
        synchronized (SnapshotKt.I()) {
            q();
            Unit unit = Unit.f68710a;
        }
    }

    public final boolean e() {
        return this.f3688c;
    }

    public int f() {
        return this.f3687b;
    }

    public SnapshotIdSet g() {
        return this.f3686a;
    }

    public abstract Function1<Object, Unit> h();

    public abstract boolean i();

    public int j() {
        return 0;
    }

    public abstract Function1<Object, Unit> k();

    @PublishedApi
    public j l() {
        j jVar = (j) SnapshotKt.f3603b.a();
        SnapshotKt.f3603b.b(this);
        return jVar;
    }

    public abstract void m(j jVar);

    public abstract void n(j jVar);

    public abstract void o();

    public abstract void p(c0 c0Var);

    public final void q() {
        int i11 = this.f3689d;
        if (i11 >= 0) {
            SnapshotKt.Y(i11);
            this.f3689d = -1;
        }
    }

    public void r() {
        q();
    }

    @PublishedApi
    public void s(j jVar) {
        SnapshotKt.f3603b.b(jVar);
    }

    public final void t(boolean z11) {
        this.f3688c = z11;
    }

    public void u(int i11) {
        this.f3687b = i11;
    }

    public void v(SnapshotIdSet snapshotIdSet) {
        this.f3686a = snapshotIdSet;
    }

    public void w(int i11) {
        throw new IllegalStateException("Updating write count is not supported for this snapshot".toString());
    }

    public abstract j x(Function1<Object, Unit> function1);

    public final int y() {
        int i11 = this.f3689d;
        this.f3689d = -1;
        return i11;
    }

    public final void z() {
        if (!this.f3688c) {
            return;
        }
        o1.a("Cannot use a disposed snapshot");
    }
}
