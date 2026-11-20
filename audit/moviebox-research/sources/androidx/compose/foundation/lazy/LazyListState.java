package androidx.compose.foundation.lazy;

import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.s0;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.d0;
import androidx.compose.foundation.lazy.layout.e0;
import androidx.compose.foundation.lazy.layout.x;
import androidx.compose.runtime.i1;
import androidx.compose.runtime.r2;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.u2;
import androidx.compose.ui.layout.l0;
import androidx.compose.ui.layout.m0;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.k0;

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
public final class LazyListState implements androidx.compose.foundation.gestures.o {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final a f2548y = new a(null);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final androidx.compose.runtime.saveable.d<LazyListState, ?> f2549z = ListSaverKt.a(new Function2<androidx.compose.runtime.saveable.e, LazyListState, List<? extends Integer>>() { // from class: androidx.compose.foundation.lazy.LazyListState$Companion$Saver$1
        @Override // kotlin.jvm.functions.Function2
        public final List<Integer> invoke(androidx.compose.runtime.saveable.e eVar, LazyListState lazyListState) {
            return kotlin.collections.g.o(Integer.valueOf(lazyListState.o()), Integer.valueOf(lazyListState.p()));
        }
    }, new Function1<List<? extends Integer>, LazyListState>() { // from class: androidx.compose.foundation.lazy.LazyListState$Companion$Saver$2
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final LazyListState invoke2(List<Integer> list) {
            return new LazyListState(list.get(0).intValue(), list.get(1).intValue());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ LazyListState invoke(List<? extends Integer> list) {
            return invoke2((List<Integer>) list);
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f2550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public m f2552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final v f2553d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f2554e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final i1<m> f2555f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final o1.i f2556g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f2557h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final androidx.compose.foundation.gestures.o f2558i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f2559j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f2560k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public l0 f2561l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final m0 f2562m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AwaitFirstLayoutModifier f2563n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final LazyLayoutItemAnimator<n> f2564o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final androidx.compose.foundation.lazy.layout.e f2565p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final x f2566q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final p f2567r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final androidx.compose.foundation.lazy.layout.w f2568s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final i1<Unit> f2569t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final i1 f2570u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final i1 f2571v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final i1<Unit> f2572w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public androidx.compose.animation.core.i<Float, androidx.compose.animation.core.k> f2573x;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final androidx.compose.runtime.saveable.d<LazyListState, ?> a() {
            return LazyListState.f2549z;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class b implements p {
        public b() {
        }

        @Override // androidx.compose.foundation.lazy.p
        public x.b a(int i11) {
            androidx.compose.runtime.snapshots.j.a aVar = androidx.compose.runtime.snapshots.j.f3684e;
            LazyListState lazyListState = LazyListState.this;
            androidx.compose.runtime.snapshots.j jVarD = aVar.d();
            Function1<Object, Unit> function1H = jVarD != null ? jVarD.h() : null;
            androidx.compose.runtime.snapshots.j jVarF = aVar.f(jVarD);
            try {
                return LazyListState.this.z().e(i11, ((m) lazyListState.f2555f.getValue()).k());
            } finally {
                aVar.m(jVarD, jVarF, function1H);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements m0 {
        public c() {
        }

        @Override // androidx.compose.ui.f
        public /* synthetic */ Object c(Object obj, Function2 function2) {
            return androidx.compose.ui.g.b(this, obj, function2);
        }

        @Override // androidx.compose.ui.f
        public /* synthetic */ boolean d(Function1 function1) {
            return androidx.compose.ui.g.a(this, function1);
        }

        @Override // androidx.compose.ui.layout.m0
        public void e(l0 l0Var) {
            LazyListState.this.f2561l = l0Var;
        }

        @Override // androidx.compose.ui.f
        public /* synthetic */ androidx.compose.ui.f f(androidx.compose.ui.f fVar) {
            return androidx.compose.ui.e.a(this, fVar);
        }
    }

    public LazyListState() {
        this(0, 0, null, 7, null);
    }

    public LazyListState(int i11, int i12) {
        this(i11, i12, s.b(0, 1, null));
    }

    public LazyListState(final int i11, int i12, r rVar) {
        this.f2550a = rVar;
        v vVar = new v(i11, i12);
        this.f2553d = vVar;
        this.f2554e = new e(this);
        this.f2555f = r2.e(LazyListStateKt.f2577b, r2.g());
        this.f2556g = o1.h.a();
        this.f2558i = androidx.compose.foundation.gestures.p.a(new Function1<Float, Float>() { // from class: androidx.compose.foundation.lazy.LazyListState$scrollableState$1
            {
                super(1);
            }

            public final Float invoke(float f11) {
                return Float.valueOf(-this.this$0.F(-f11));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Float invoke(Float f11) {
                return invoke(f11.floatValue());
            }
        });
        this.f2560k = true;
        this.f2562m = new c();
        this.f2563n = new AwaitFirstLayoutModifier();
        this.f2564o = new LazyLayoutItemAnimator<>();
        this.f2565p = new androidx.compose.foundation.lazy.layout.e();
        this.f2566q = new x(rVar.c(), new Function1<d0, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListState$prefetchState$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(d0 d0Var) {
                invoke2(d0Var);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(d0 d0Var) {
                r rVar2 = this.this$0.f2550a;
                int i13 = i11;
                androidx.compose.runtime.snapshots.j.a aVar = androidx.compose.runtime.snapshots.j.f3684e;
                androidx.compose.runtime.snapshots.j jVarD = aVar.d();
                aVar.m(jVarD, aVar.f(jVarD), jVarD != null ? jVarD.h() : null);
                rVar2.a(d0Var, i13);
            }
        });
        this.f2567r = new b();
        this.f2568s = new androidx.compose.foundation.lazy.layout.w();
        vVar.b();
        this.f2569t = e0.c(null, 1, null);
        Boolean bool = Boolean.FALSE;
        this.f2570u = u2.c(bool, null, 2, null);
        this.f2571v = u2.c(bool, null, 2, null);
        this.f2572w = e0.c(null, 1, null);
        s0<Float, androidx.compose.animation.core.k> s0VarB = VectorConvertersKt.b(FloatCompanionObject.f68904a);
        Float fValueOf = Float.valueOf(0.0f);
        this.f2573x = androidx.compose.animation.core.j.b(s0VarB, fValueOf, fValueOf, (56 & 8) != 0 ? Long.MIN_VALUE : 0L, (56 & 16) != 0 ? Long.MIN_VALUE : 0L, (56 & 32) != 0 ? false : false);
    }

    public /* synthetic */ LazyListState(int i11, int i12, r rVar, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? 0 : i11, (i13 & 2) != 0 ? 0 : i12, (i13 & 4) != 0 ? s.b(0, 1, null) : rVar);
    }

    public static /* synthetic */ Object H(LazyListState lazyListState, int i11, int i12, Continuation continuation, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i12 = 0;
        }
        return lazyListState.G(i11, i12, continuation);
    }

    public static /* synthetic */ void l(LazyListState lazyListState, m mVar, boolean z11, boolean z12, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z12 = false;
        }
        lazyListState.k(mVar, z11, z12);
    }

    public final l0 A() {
        return this.f2561l;
    }

    public final m0 B() {
        return this.f2562m;
    }

    public final float C() {
        return this.f2573x.getValue().floatValue();
    }

    public final float D() {
        return this.f2557h;
    }

    public final void E(float f11, l lVar) {
        if (this.f2560k) {
            this.f2550a.b(this.f2567r, f11, lVar);
        }
    }

    public final float F(float f11) {
        if ((f11 < 0.0f && !d()) || (f11 > 0.0f && !b())) {
            return 0.0f;
        }
        if (Math.abs(this.f2557h) > 0.5f) {
            throw new IllegalStateException(("entered drag with non-zero pending scroll: " + this.f2557h).toString());
        }
        float f12 = this.f2557h + f11;
        this.f2557h = f12;
        if (Math.abs(f12) > 0.5f) {
            m value = this.f2555f.getValue();
            float f13 = this.f2557h;
            int iRound = Math.round(f13);
            m mVar = this.f2552c;
            boolean zU = value.u(iRound, !this.f2551b);
            if (zU && mVar != null) {
                zU = mVar.u(iRound, true);
            }
            if (zU) {
                k(value, this.f2551b, true);
                e0.d(this.f2572w);
                E(f13 - this.f2557h, value);
            } else {
                l0 l0Var = this.f2561l;
                if (l0Var != null) {
                    l0Var.d();
                }
                E(f13 - this.f2557h, t());
            }
        }
        if (Math.abs(this.f2557h) <= 0.5f) {
            return f11;
        }
        float f14 = f11 - this.f2557h;
        this.f2557h = 0.0f;
        return f14;
    }

    public final Object G(int i11, int i12, Continuation<? super Unit> continuation) {
        Object objC = androidx.compose.foundation.gestures.n.c(this, null, new LazyListState$scrollToItem$2(this, i11, i12, null), continuation, 1, null);
        return objC == kotlin.coroutines.intrinsics.a.e() ? objC : Unit.f68710a;
    }

    public final void I(boolean z11) {
        this.f2571v.setValue(Boolean.valueOf(z11));
    }

    public final void J(boolean z11) {
        this.f2570u.setValue(Boolean.valueOf(z11));
    }

    public final void K(int i11, int i12, boolean z11) {
        if (this.f2553d.a() != i11 || this.f2553d.c() != i12) {
            this.f2564o.o();
        }
        this.f2553d.d(i11, i12);
        if (!z11) {
            e0.d(this.f2569t);
            return;
        }
        l0 l0Var = this.f2561l;
        if (l0Var != null) {
            l0Var.d();
        }
    }

    public final void L(float f11, q2.e eVar, k0 k0Var) {
        if (f11 <= eVar.N0(LazyListStateKt.f2576a)) {
            return;
        }
        androidx.compose.runtime.snapshots.j.a aVar = androidx.compose.runtime.snapshots.j.f3684e;
        androidx.compose.runtime.snapshots.j jVarD = aVar.d();
        Function1<Object, Unit> function1H = jVarD != null ? jVarD.h() : null;
        androidx.compose.runtime.snapshots.j jVarF = aVar.f(jVarD);
        try {
            float fFloatValue = this.f2573x.getValue().floatValue();
            if (this.f2573x.h()) {
                this.f2573x = androidx.compose.animation.core.j.g(this.f2573x, fFloatValue - f11, 0.0f, 0L, 0L, false, 30, null);
                kotlinx.coroutines.j.d(k0Var, null, null, new LazyListState$updateScrollDeltaForPostLookahead$2$1(this, null), 3, null);
            } else {
                this.f2573x = new androidx.compose.animation.core.i<>(VectorConvertersKt.b(FloatCompanionObject.f68904a), Float.valueOf(-f11), null, 0L, 0L, false, 60, null);
                kotlinx.coroutines.j.d(k0Var, null, null, new LazyListState$updateScrollDeltaForPostLookahead$2$2(this, null), 3, null);
            }
        } finally {
            aVar.m(jVarD, jVarF, function1H);
        }
    }

    public final int M(k kVar, int i11) {
        return this.f2553d.j(kVar, i11);
    }

    @Override // androidx.compose.foundation.gestures.o
    public boolean a() {
        return this.f2558i.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.foundation.gestures.o
    public boolean b() {
        return ((Boolean) this.f2571v.getValue()).booleanValue();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.compose.foundation.gestures.o
    public Object c(MutatePriority mutatePriority, Function2<? super androidx.compose.foundation.gestures.k, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) throws Throwable {
        LazyListState$scroll$1 lazyListState$scroll$1;
        LazyListState lazyListState;
        if (continuation instanceof LazyListState$scroll$1) {
            lazyListState$scroll$1 = (LazyListState$scroll$1) continuation;
            int i11 = lazyListState$scroll$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                lazyListState$scroll$1.label = i11 - Integer.MIN_VALUE;
            } else {
                lazyListState$scroll$1 = new LazyListState$scroll$1(this, continuation);
            }
        } else {
            lazyListState$scroll$1 = new LazyListState$scroll$1(this, continuation);
        }
        Object obj = lazyListState$scroll$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = lazyListState$scroll$1.label;
        if (i12 != 0) {
            if (i12 == 1) {
                function2 = (Function2) lazyListState$scroll$1.L$2;
                mutatePriority = (MutatePriority) lazyListState$scroll$1.L$1;
                lazyListState = (LazyListState) lazyListState$scroll$1.L$0;
                ResultKt.b(obj);
            } else {
                if (i12 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f68710a;
        }
        ResultKt.b(obj);
        AwaitFirstLayoutModifier awaitFirstLayoutModifier = this.f2563n;
        lazyListState$scroll$1.L$0 = this;
        lazyListState$scroll$1.L$1 = mutatePriority;
        lazyListState$scroll$1.L$2 = function2;
        lazyListState$scroll$1.label = 1;
        if (awaitFirstLayoutModifier.a(lazyListState$scroll$1) == objE) {
            return objE;
        }
        lazyListState = this;
        androidx.compose.foundation.gestures.o oVar = lazyListState.f2558i;
        lazyListState$scroll$1.L$0 = null;
        lazyListState$scroll$1.L$1 = null;
        lazyListState$scroll$1.L$2 = null;
        lazyListState$scroll$1.label = 2;
        if (oVar.c(mutatePriority, function2, lazyListState$scroll$1) == objE) {
            return objE;
        }
        return Unit.f68710a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.foundation.gestures.o
    public boolean d() {
        return ((Boolean) this.f2570u.getValue()).booleanValue();
    }

    @Override // androidx.compose.foundation.gestures.o
    public float e(float f11) {
        return this.f2558i.e(f11);
    }

    public final void k(m mVar, boolean z11, boolean z12) {
        if (!z11 && this.f2551b) {
            this.f2552c = mVar;
            return;
        }
        if (z11) {
            this.f2551b = true;
        }
        I(mVar.i());
        J(mVar.j());
        this.f2557h -= mVar.o();
        this.f2555f.setValue(mVar);
        if (z12) {
            this.f2553d.i(mVar.s());
        } else {
            this.f2553d.h(mVar);
            if (this.f2560k) {
                this.f2550a.d(this.f2567r, mVar);
            }
        }
        if (z11) {
            L(mVar.t(), mVar.q(), mVar.p());
        }
        this.f2559j++;
    }

    public final AwaitFirstLayoutModifier m() {
        return this.f2563n;
    }

    public final androidx.compose.foundation.lazy.layout.e n() {
        return this.f2565p;
    }

    public final int o() {
        return this.f2553d.a();
    }

    public final int p() {
        return this.f2553d.c();
    }

    public final boolean q() {
        return this.f2551b;
    }

    public final o1.i r() {
        return this.f2556g;
    }

    public final LazyLayoutItemAnimator<n> s() {
        return this.f2564o;
    }

    public final l t() {
        return this.f2555f.getValue();
    }

    public final i1<Unit> u() {
        return this.f2569t;
    }

    public final IntRange v() {
        return this.f2553d.b().getValue();
    }

    public final androidx.compose.foundation.lazy.layout.w w() {
        return this.f2568s;
    }

    public final i1<Unit> x() {
        return this.f2572w;
    }

    public final m y() {
        return this.f2552c;
    }

    public final x z() {
        return this.f2566q;
    }
}
