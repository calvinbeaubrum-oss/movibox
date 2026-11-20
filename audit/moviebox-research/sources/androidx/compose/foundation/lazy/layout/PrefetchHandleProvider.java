package androidx.compose.foundation.lazy.layout;

import android.os.Trace;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.node.TraversableNode$Companion$TraverseDescendantsAction;
import androidx.compose.ui.node.m1;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
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
public final class PrefetchHandleProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LazyLayoutItemContentFactory f2674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SubcomposeLayoutState f2675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i0 f2676c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public final class HandleAndRequestImpl implements x.b, g0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f2677a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f2678b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final f0 f2679c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public SubcomposeLayoutState.a f2680d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f2681e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f2682f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f2683g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public a f2684h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f2685i;

        /* JADX INFO: compiled from: source.java */
        @Metadata
        @SourceDebugExtension
        public final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final List<x> f2687a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final List<g0>[] f2688b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f2689c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f2690d;

            public a(List<x> list) {
                this.f2687a = list;
                this.f2688b = new List[list.size()];
                if (!(!list.isEmpty())) {
                    throw new IllegalArgumentException("NestedPrefetchController shouldn't be created with no states".toString());
                }
            }

            public final boolean a(h0 h0Var) {
                if (this.f2689c >= this.f2687a.size()) {
                    return false;
                }
                if (!(!HandleAndRequestImpl.this.f2682f)) {
                    throw new IllegalStateException("Should not execute nested prefetch on canceled request".toString());
                }
                Trace.beginSection("compose:lazy:prefetch:nested");
                while (this.f2689c < this.f2687a.size()) {
                    try {
                        if (this.f2688b[this.f2689c] == null) {
                            if (h0Var.a() <= 0) {
                                Trace.endSection();
                                return true;
                            }
                            List<g0>[] listArr = this.f2688b;
                            int i11 = this.f2689c;
                            listArr[i11] = this.f2687a.get(i11).b();
                        }
                        List<g0> list = this.f2688b[this.f2689c];
                        Intrinsics.d(list);
                        while (this.f2690d < list.size()) {
                            if (list.get(this.f2690d).b(h0Var)) {
                                Trace.endSection();
                                return true;
                            }
                            this.f2690d++;
                        }
                        this.f2690d = 0;
                        this.f2689c++;
                    } catch (Throwable th2) {
                        Trace.endSection();
                        throw th2;
                    }
                }
                Unit unit = Unit.f68710a;
                Trace.endSection();
                return false;
            }
        }

        public HandleAndRequestImpl(int i11, long j11, f0 f0Var) {
            this.f2677a = i11;
            this.f2678b = j11;
            this.f2679c = f0Var;
        }

        public /* synthetic */ HandleAndRequestImpl(PrefetchHandleProvider prefetchHandleProvider, int i11, long j11, f0 f0Var, DefaultConstructorMarker defaultConstructorMarker) {
            this(i11, j11, f0Var);
        }

        @Override // androidx.compose.foundation.lazy.layout.x.b
        public void a() {
            this.f2685i = true;
        }

        @Override // androidx.compose.foundation.lazy.layout.g0
        public boolean b(h0 h0Var) {
            if (!e()) {
                return false;
            }
            Object objC = PrefetchHandleProvider.this.f2674a.d().invoke().c(this.f2677a);
            if (!d()) {
                if (!i(h0Var, (objC == null || !this.f2679c.f().a(objC)) ? this.f2679c.e() : this.f2679c.f().c(objC))) {
                    return true;
                }
                f0 f0Var = this.f2679c;
                long jNanoTime = System.nanoTime();
                Trace.beginSection("compose:lazy:prefetch:compose");
                try {
                    f();
                    Unit unit = Unit.f68710a;
                    Trace.endSection();
                    long jNanoTime2 = System.nanoTime() - jNanoTime;
                    if (objC != null) {
                        f0Var.f().p(objC, f0Var.d(jNanoTime2, f0Var.f().e(objC, 0L)));
                    }
                    f0Var.f2721c = f0Var.d(jNanoTime2, f0Var.e());
                } catch (Throwable th2) {
                    Trace.endSection();
                    throw th2;
                }
            }
            if (!this.f2685i) {
                if (!this.f2683g) {
                    if (h0Var.a() <= 0) {
                        return true;
                    }
                    Trace.beginSection("compose:lazy:prefetch:resolve-nested");
                    try {
                        this.f2684h = h();
                        this.f2683g = true;
                        Unit unit2 = Unit.f68710a;
                        Trace.endSection();
                    } catch (Throwable th3) {
                        Trace.endSection();
                        throw th3;
                    }
                }
                a aVar = this.f2684h;
                if (aVar != null && aVar.a(h0Var)) {
                    return true;
                }
            }
            if (!this.f2681e && !q2.b.p(this.f2678b)) {
                if (!i(h0Var, (objC == null || !this.f2679c.h().a(objC)) ? this.f2679c.g() : this.f2679c.h().c(objC))) {
                    return true;
                }
                f0 f0Var2 = this.f2679c;
                long jNanoTime3 = System.nanoTime();
                Trace.beginSection("compose:lazy:prefetch:measure");
                try {
                    g(this.f2678b);
                    Unit unit3 = Unit.f68710a;
                    Trace.endSection();
                    long jNanoTime4 = System.nanoTime() - jNanoTime3;
                    if (objC != null) {
                        f0Var2.h().p(objC, f0Var2.d(jNanoTime4, f0Var2.h().e(objC, 0L)));
                    }
                    f0Var2.f2722d = f0Var2.d(jNanoTime4, f0Var2.g());
                } catch (Throwable th4) {
                    Trace.endSection();
                    throw th4;
                }
            }
            return false;
        }

        @Override // androidx.compose.foundation.lazy.layout.x.b
        public void cancel() {
            if (this.f2682f) {
                return;
            }
            this.f2682f = true;
            SubcomposeLayoutState.a aVar = this.f2680d;
            if (aVar != null) {
                aVar.dispose();
            }
            this.f2680d = null;
        }

        public final boolean d() {
            return this.f2680d != null;
        }

        public final boolean e() {
            if (!this.f2682f) {
                int itemCount = PrefetchHandleProvider.this.f2674a.d().invoke().getItemCount();
                int i11 = this.f2677a;
                if (i11 >= 0 && i11 < itemCount) {
                    return true;
                }
            }
            return false;
        }

        public final void f() {
            if (!e()) {
                throw new IllegalArgumentException("Callers should check whether the request is still valid before calling performComposition()".toString());
            }
            if (this.f2680d != null) {
                throw new IllegalArgumentException("Request was already composed!".toString());
            }
            m mVarInvoke = PrefetchHandleProvider.this.f2674a.d().invoke();
            Object objB = mVarInvoke.b(this.f2677a);
            this.f2680d = PrefetchHandleProvider.this.f2675b.i(objB, PrefetchHandleProvider.this.f2674a.b(this.f2677a, objB, mVarInvoke.c(this.f2677a)));
        }

        public final void g(long j11) {
            if (!(!this.f2682f)) {
                throw new IllegalArgumentException("Callers should check whether the request is still valid before calling performMeasure()".toString());
            }
            if (!(!this.f2681e)) {
                throw new IllegalArgumentException("Request was already measured!".toString());
            }
            this.f2681e = true;
            SubcomposeLayoutState.a aVar = this.f2680d;
            if (aVar == null) {
                throw new IllegalArgumentException("performComposition() must be called before performMeasure()".toString());
            }
            int iB = aVar.b();
            for (int i11 = 0; i11 < iB; i11++) {
                aVar.c(i11, j11);
            }
        }

        public final a h() {
            SubcomposeLayoutState.a aVar = this.f2680d;
            if (aVar == null) {
                throw new IllegalArgumentException("Should precompose before resolving nested prefetch states".toString());
            }
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            aVar.a("androidx.compose.foundation.lazy.layout.TraversablePrefetchStateNode", new Function1<m1, TraversableNode$Companion$TraverseDescendantsAction>() { // from class: androidx.compose.foundation.lazy.layout.PrefetchHandleProvider$HandleAndRequestImpl$resolveNestedPrefetchStates$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public final TraversableNode$Companion$TraverseDescendantsAction invoke(m1 m1Var) {
                    T tQ;
                    Intrinsics.e(m1Var, "null cannot be cast to non-null type androidx.compose.foundation.lazy.layout.TraversablePrefetchStateNode");
                    x xVarH1 = ((l0) m1Var).H1();
                    Ref.ObjectRef<List<x>> objectRef2 = objectRef;
                    List<x> list = objectRef2.element;
                    if (list != null) {
                        list.add(xVarH1);
                        tQ = list;
                    } else {
                        tQ = kotlin.collections.g.q(xVarH1);
                    }
                    objectRef2.element = tQ;
                    return TraversableNode$Companion$TraverseDescendantsAction.SkipSubtreeAndContinueTraversal;
                }
            });
            List list = (List) objectRef.element;
            if (list != null) {
                return new a(list);
            }
            return null;
        }

        public final boolean i(h0 h0Var, long j11) {
            long jA = h0Var.a();
            return (this.f2685i && jA > 0) || j11 < jA;
        }

        public String toString() {
            return "HandleAndRequestImpl { index = " + this.f2677a + ", constraints = " + ((Object) q2.b.q(this.f2678b)) + ", isComposed = " + d() + ", isMeasured = " + this.f2681e + ", isCanceled = " + this.f2682f + " }";
        }
    }

    public PrefetchHandleProvider(LazyLayoutItemContentFactory lazyLayoutItemContentFactory, SubcomposeLayoutState subcomposeLayoutState, i0 i0Var) {
        this.f2674a = lazyLayoutItemContentFactory;
        this.f2675b = subcomposeLayoutState;
        this.f2676c = i0Var;
    }

    public final g0 c(int i11, long j11, f0 f0Var) {
        return new HandleAndRequestImpl(this, i11, j11, f0Var, null);
    }

    public final x.b d(int i11, long j11, f0 f0Var) {
        HandleAndRequestImpl handleAndRequestImpl = new HandleAndRequestImpl(this, i11, j11, f0Var, null);
        this.f2676c.schedulePrefetch(handleAndRequestImpl);
        return handleAndRequestImpl;
    }
}
