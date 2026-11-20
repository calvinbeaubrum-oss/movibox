package androidx.compose.runtime;

import androidx.collection.MutableScatterSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;

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
public final class Recomposer extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f3313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BroadcastFrameClock f3314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f3315c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public kotlinx.coroutines.q1 f3316d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Throwable f3317e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<y> f3318f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<? extends y> f3319g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public MutableScatterSet<Object> f3320h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final androidx.compose.runtime.collection.b<y> f3321i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<y> f3322j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<y0> f3323k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map<w0<Object>, List<y0>> f3324l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<y0, x0> f3325m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List<y> f3326n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Set<y> f3327o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public kotlinx.coroutines.n<? super Unit> f3328p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f3329q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f3330r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public b f3331s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f3332t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final kotlinx.coroutines.flow.v0<State> f3333u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final kotlinx.coroutines.z f3334v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final CoroutineContext f3335w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final c f3336x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final a f3311y = new a(null);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f3312z = 8;
    public static final kotlinx.coroutines.flow.v0<s1.h<c>> A = kotlinx.coroutines.flow.g1.a(s1.a.c());
    public static final AtomicReference<Boolean> B = new AtomicReference<>(Boolean.FALSE);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public enum State {
        ShutDown,
        ShuttingDown,
        Inactive,
        InactivePendingWork,
        Idle,
        PendingWork
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void c(c cVar) {
            s1.h hVar;
            s1.h hVarAdd;
            do {
                hVar = (s1.h) Recomposer.A.getValue();
                hVarAdd = hVar.add(cVar);
                if (hVar == hVarAdd) {
                    return;
                }
            } while (!Recomposer.A.e(hVar, hVarAdd));
        }

        public final void d(c cVar) {
            s1.h hVar;
            s1.h hVarRemove;
            do {
                hVar = (s1.h) Recomposer.A.getValue();
                hVarRemove = hVar.remove(cVar);
                if (hVar == hVarRemove) {
                    return;
                }
            } while (!Recomposer.A.e(hVar, hVarRemove));
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f3337a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Exception f3338b;

        public b(boolean z11, Exception exc) {
            this.f3337a = z11;
            this.f3338b = exc;
        }

        public Exception a() {
            return this.f3338b;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public final class c {
        public c() {
        }
    }

    public Recomposer(CoroutineContext coroutineContext) {
        BroadcastFrameClock broadcastFrameClock = new BroadcastFrameClock(new Function0<Unit>() { // from class: androidx.compose.runtime.Recomposer$broadcastFrameClock$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                kotlinx.coroutines.n nVarC0;
                Object obj = this.this$0.f3315c;
                Recomposer recomposer = this.this$0;
                synchronized (obj) {
                    nVarC0 = recomposer.c0();
                    if (((Recomposer.State) recomposer.f3333u.getValue()).compareTo(Recomposer.State.ShuttingDown) <= 0) {
                        throw kotlinx.coroutines.g1.a("Recomposer shutdown; frame clock awaiter will never resume", recomposer.f3317e);
                    }
                }
                if (nVarC0 != null) {
                    Result.Companion companion = Result.Companion;
                    nVarC0.resumeWith(Result.m163constructorimpl(Unit.f68710a));
                }
            }
        });
        this.f3314b = broadcastFrameClock;
        this.f3315c = new Object();
        this.f3318f = new ArrayList();
        this.f3320h = new MutableScatterSet<>(0, 1, null);
        this.f3321i = new androidx.compose.runtime.collection.b<>(new y[16], 0);
        this.f3322j = new ArrayList();
        this.f3323k = new ArrayList();
        this.f3324l = new LinkedHashMap();
        this.f3325m = new LinkedHashMap();
        this.f3333u = kotlinx.coroutines.flow.g1.a(State.Inactive);
        kotlinx.coroutines.z zVarA = kotlinx.coroutines.t1.a((kotlinx.coroutines.q1) coroutineContext.get(kotlinx.coroutines.q1.f69514j8));
        zVarA.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.Recomposer$effectJob$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th2) {
                invoke2(th2);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final Throwable th2) {
                kotlinx.coroutines.n nVar;
                kotlinx.coroutines.n nVar2;
                CancellationException cancellationExceptionA = kotlinx.coroutines.g1.a("Recomposer effect job completed", th2);
                Object obj = this.this$0.f3315c;
                final Recomposer recomposer = this.this$0;
                synchronized (obj) {
                    try {
                        kotlinx.coroutines.q1 q1Var = recomposer.f3316d;
                        nVar = null;
                        if (q1Var != null) {
                            recomposer.f3333u.setValue(Recomposer.State.ShuttingDown);
                            if (recomposer.f3330r) {
                                if (recomposer.f3328p != null) {
                                    nVar2 = recomposer.f3328p;
                                }
                                recomposer.f3328p = null;
                                q1Var.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.Recomposer$effectJob$1$1$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th3) {
                                        invoke2(th3);
                                        return Unit.f68710a;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Throwable th3) {
                                        Object obj2 = recomposer.f3315c;
                                        Recomposer recomposer2 = recomposer;
                                        Throwable th4 = th2;
                                        synchronized (obj2) {
                                            if (th4 == null) {
                                                th4 = null;
                                            } else if (th3 != null) {
                                                try {
                                                    if (!(!(th3 instanceof CancellationException))) {
                                                        th3 = null;
                                                    }
                                                    if (th3 != null) {
                                                        v10.b.a(th4, th3);
                                                    }
                                                } catch (Throwable th5) {
                                                    throw th5;
                                                }
                                            }
                                            recomposer2.f3317e = th4;
                                            recomposer2.f3333u.setValue(Recomposer.State.ShutDown);
                                            Unit unit = Unit.f68710a;
                                        }
                                    }
                                });
                                nVar = nVar2;
                            } else {
                                q1Var.cancel(cancellationExceptionA);
                            }
                            nVar2 = null;
                            recomposer.f3328p = null;
                            q1Var.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.Recomposer$effectJob$1$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Throwable th3) {
                                    invoke2(th3);
                                    return Unit.f68710a;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Throwable th3) {
                                    Object obj2 = recomposer.f3315c;
                                    Recomposer recomposer2 = recomposer;
                                    Throwable th4 = th2;
                                    synchronized (obj2) {
                                        if (th4 == null) {
                                            th4 = null;
                                        } else if (th3 != null) {
                                            try {
                                                if (!(!(th3 instanceof CancellationException))) {
                                                    th3 = null;
                                                }
                                                if (th3 != null) {
                                                    v10.b.a(th4, th3);
                                                }
                                            } catch (Throwable th5) {
                                                throw th5;
                                            }
                                        }
                                        recomposer2.f3317e = th4;
                                        recomposer2.f3333u.setValue(Recomposer.State.ShutDown);
                                        Unit unit = Unit.f68710a;
                                    }
                                }
                            });
                            nVar = nVar2;
                        } else {
                            recomposer.f3317e = cancellationExceptionA;
                            recomposer.f3333u.setValue(Recomposer.State.ShutDown);
                            Unit unit = Unit.f68710a;
                        }
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
                if (nVar != null) {
                    Result.Companion companion = Result.Companion;
                    nVar.resumeWith(Result.m163constructorimpl(Unit.f68710a));
                }
            }
        });
        this.f3334v = zVarA;
        this.f3335w = coroutineContext.plus(broadcastFrameClock).plus(zVarA);
        this.f3336x = new c();
    }

    public static final void p0(List<y0> list, Recomposer recomposer, y yVar) {
        list.clear();
        synchronized (recomposer.f3315c) {
            try {
                Iterator<y0> it = recomposer.f3323k.iterator();
                while (it.hasNext()) {
                    y0 next = it.next();
                    if (Intrinsics.b(next.b(), yVar)) {
                        list.add(next);
                        it.remove();
                    }
                }
                Unit unit = Unit.f68710a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static /* synthetic */ void t0(Recomposer recomposer, Exception exc, y yVar, boolean z11, int i11, Object obj) throws Exception {
        if ((i11 & 2) != 0) {
            yVar = null;
        }
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        recomposer.s0(exc, yVar, z11);
    }

    public final void A0() {
        kotlinx.coroutines.n<Unit> nVarC0;
        synchronized (this.f3315c) {
            if (this.f3332t) {
                this.f3332t = false;
                nVarC0 = c0();
            } else {
                nVarC0 = null;
            }
        }
        if (nVarC0 != null) {
            Result.Companion companion = Result.Companion;
            nVarC0.resumeWith(Result.m163constructorimpl(Unit.f68710a));
        }
    }

    public final Object B0(Continuation<? super Unit> continuation) {
        Object objV0 = v0(new Recomposer$runRecomposeAndApplyChanges$2(this, null), continuation);
        return objV0 == kotlin.coroutines.intrinsics.a.e() ? objV0 : Unit.f68710a;
    }

    public final Function1<Object, Unit> C0(final y yVar, final MutableScatterSet<Object> mutableScatterSet) {
        return new Function1<Object, Unit>() { // from class: androidx.compose.runtime.Recomposer$writeObserverOf$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                yVar.q(obj);
                MutableScatterSet<Object> mutableScatterSet2 = mutableScatterSet;
                if (mutableScatterSet2 != null) {
                    mutableScatterSet2.h(obj);
                }
            }
        };
    }

    public final void X(y yVar) {
        this.f3318f.add(yVar);
        this.f3319g = null;
    }

    public final void Y(androidx.compose.runtime.snapshots.b bVar) {
        try {
            if (bVar.C() instanceof androidx.compose.runtime.snapshots.k.a) {
                throw new IllegalStateException("Unsupported concurrent change during composition. A state object was modified by composition as well as being modified outside composition.".toString());
            }
            bVar.d();
        } catch (Throwable th2) {
            bVar.d();
            throw th2;
        }
    }

    public final Object Z(Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl;
        if (j0()) {
            return Unit.f68710a;
        }
        CancellableContinuationImpl cancellableContinuationImpl2 = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.c(continuation), 1);
        cancellableContinuationImpl2.initCancellability();
        synchronized (this.f3315c) {
            if (j0()) {
                cancellableContinuationImpl = cancellableContinuationImpl2;
            } else {
                this.f3328p = cancellableContinuationImpl2;
                cancellableContinuationImpl = null;
            }
        }
        if (cancellableContinuationImpl != null) {
            Result.Companion companion = Result.Companion;
            cancellableContinuationImpl.resumeWith(Result.m163constructorimpl(Unit.f68710a));
        }
        Object result = cancellableContinuationImpl2.getResult();
        if (result == kotlin.coroutines.intrinsics.a.e()) {
            DebugProbesKt.c(continuation);
        }
        return result == kotlin.coroutines.intrinsics.a.e() ? result : Unit.f68710a;
    }

    @Override // androidx.compose.runtime.m
    public void a(y yVar, Function2<? super i, ? super Integer, Unit> function2) throws Exception {
        boolean zO = yVar.o();
        try {
            androidx.compose.runtime.snapshots.j.a aVar = androidx.compose.runtime.snapshots.j.f3684e;
            androidx.compose.runtime.snapshots.b bVarO = aVar.o(u0(yVar), C0(yVar, null));
            try {
                androidx.compose.runtime.snapshots.j jVarL = bVarO.l();
                try {
                    yVar.b(function2);
                    Unit unit = Unit.f68710a;
                    bVarO.s(jVarL);
                    Y(bVarO);
                    if (!zO) {
                        aVar.g();
                    }
                    synchronized (this.f3315c) {
                        if (this.f3333u.getValue().compareTo(State.ShuttingDown) > 0 && !k0().contains(yVar)) {
                            X(yVar);
                        }
                    }
                    try {
                        o0(yVar);
                        try {
                            yVar.n();
                            yVar.c();
                            if (zO) {
                                return;
                            }
                            aVar.g();
                        } catch (Exception e11) {
                            t0(this, e11, null, false, 6, null);
                        }
                    } catch (Exception e12) {
                        s0(e12, yVar, true);
                    }
                } catch (Throwable th2) {
                    bVarO.s(jVarL);
                    throw th2;
                }
            } catch (Throwable th3) {
                Y(bVarO);
                throw th3;
            }
        } catch (Exception e13) {
            s0(e13, yVar, true);
        }
    }

    public final void a0() {
        synchronized (this.f3315c) {
            try {
                if (this.f3333u.getValue().compareTo(State.Idle) >= 0) {
                    this.f3333u.setValue(State.ShuttingDown);
                }
                Unit unit = Unit.f68710a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        kotlinx.coroutines.q1.a.b(this.f3334v, null, 1, null);
    }

    @Override // androidx.compose.runtime.m
    public void b(y0 y0Var) {
        synchronized (this.f3315c) {
            x1.a(this.f3324l, y0Var.c(), y0Var);
        }
    }

    public final void b0() {
        this.f3318f.clear();
        this.f3319g = kotlin.collections.g.l();
    }

    public final kotlinx.coroutines.n<Unit> c0() {
        State state;
        int i11 = 0;
        int i12 = 1;
        DefaultConstructorMarker defaultConstructorMarker = null;
        if (this.f3333u.getValue().compareTo(State.ShuttingDown) <= 0) {
            b0();
            this.f3320h = new MutableScatterSet<>(i11, i12, defaultConstructorMarker);
            this.f3321i.i();
            this.f3322j.clear();
            this.f3323k.clear();
            this.f3326n = null;
            kotlinx.coroutines.n<? super Unit> nVar = this.f3328p;
            if (nVar != null) {
                kotlinx.coroutines.n.a.a(nVar, null, 1, null);
            }
            this.f3328p = null;
            this.f3331s = null;
            return null;
        }
        if (this.f3331s != null) {
            state = State.Inactive;
        } else if (this.f3316d == null) {
            this.f3320h = new MutableScatterSet<>(i11, i12, defaultConstructorMarker);
            this.f3321i.i();
            state = h0() ? State.InactivePendingWork : State.Inactive;
        } else {
            state = (this.f3321i.u() || this.f3320h.e() || (this.f3322j.isEmpty() ^ true) || (this.f3323k.isEmpty() ^ true) || this.f3329q > 0 || h0()) ? State.PendingWork : State.Idle;
        }
        this.f3333u.setValue(state);
        if (state != State.PendingWork) {
            return null;
        }
        kotlinx.coroutines.n nVar2 = this.f3328p;
        this.f3328p = null;
        return nVar2;
    }

    @Override // androidx.compose.runtime.m
    public boolean d() {
        return B.get().booleanValue();
    }

    public final void d0() {
        int i11;
        List listL;
        synchronized (this.f3315c) {
            try {
                if (!this.f3324l.isEmpty()) {
                    List listW = kotlin.collections.h.w(this.f3324l.values());
                    this.f3324l.clear();
                    listL = new ArrayList(listW.size());
                    int size = listW.size();
                    for (int i12 = 0; i12 < size; i12++) {
                        y0 y0Var = (y0) listW.get(i12);
                        listL.add(TuplesKt.a(y0Var, this.f3325m.get(y0Var)));
                    }
                    this.f3325m.clear();
                } else {
                    listL = kotlin.collections.g.l();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        int size2 = listL.size();
        for (i11 = 0; i11 < size2; i11++) {
            Pair pair = (Pair) listL.get(i11);
            y0 y0Var2 = (y0) pair.component1();
            x0 x0Var = (x0) pair.component2();
            if (x0Var != null) {
                y0Var2.b().e(x0Var);
            }
        }
    }

    @Override // androidx.compose.runtime.m
    public boolean e() {
        return false;
    }

    public final long e0() {
        return this.f3313a;
    }

    @Override // androidx.compose.runtime.m
    public boolean f() {
        return false;
    }

    public final kotlinx.coroutines.flow.f1<State> f0() {
        return this.f3333u;
    }

    public final boolean g0() {
        boolean zH0;
        synchronized (this.f3315c) {
            zH0 = h0();
        }
        return zH0;
    }

    @Override // androidx.compose.runtime.m
    public int h() {
        return 1000;
    }

    public final boolean h0() {
        return !this.f3332t && this.f3314b.t();
    }

    @Override // androidx.compose.runtime.m
    public CoroutineContext i() {
        return this.f3335w;
    }

    public final boolean i0() {
        return this.f3321i.u() || h0();
    }

    public final boolean j0() {
        boolean z11;
        synchronized (this.f3315c) {
            z11 = this.f3320h.e() || this.f3321i.u() || h0();
        }
        return z11;
    }

    @Override // androidx.compose.runtime.m
    public void k(y0 y0Var) {
        kotlinx.coroutines.n<Unit> nVarC0;
        synchronized (this.f3315c) {
            this.f3323k.add(y0Var);
            nVarC0 = c0();
        }
        if (nVarC0 != null) {
            Result.Companion companion = Result.Companion;
            nVarC0.resumeWith(Result.m163constructorimpl(Unit.f68710a));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<y> k0() {
        List list = this.f3319g;
        List list2 = list;
        if (list == null) {
            List<y> list3 = this.f3318f;
            List listL = list3.isEmpty() ? kotlin.collections.g.l() : new ArrayList(list3);
            this.f3319g = listL;
            list2 = listL;
        }
        return list2;
    }

    @Override // androidx.compose.runtime.m
    public void l(y yVar) {
        kotlinx.coroutines.n<Unit> nVarC0;
        synchronized (this.f3315c) {
            if (this.f3321i.j(yVar)) {
                nVarC0 = null;
            } else {
                this.f3321i.b(yVar);
                nVarC0 = c0();
            }
        }
        if (nVarC0 != null) {
            Result.Companion companion = Result.Companion;
            nVarC0.resumeWith(Result.m163constructorimpl(Unit.f68710a));
        }
    }

    public final boolean l0() {
        boolean z11;
        synchronized (this.f3315c) {
            z11 = !this.f3330r;
        }
        if (z11) {
            return true;
        }
        Iterator<kotlinx.coroutines.q1> it = this.f3334v.getChildren().iterator();
        while (it.hasNext()) {
            if (it.next().isActive()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.compose.runtime.m
    public void m(y0 y0Var, x0 x0Var) {
        synchronized (this.f3315c) {
            this.f3325m.put(y0Var, x0Var);
            Unit unit = Unit.f68710a;
        }
    }

    public final Object m0(Continuation<? super Unit> continuation) {
        Object objN = kotlinx.coroutines.flow.c.n(f0(), new Recomposer$join$2(null), continuation);
        return objN == kotlin.coroutines.intrinsics.a.e() ? objN : Unit.f68710a;
    }

    @Override // androidx.compose.runtime.m
    public x0 n(y0 y0Var) {
        x0 x0VarRemove;
        synchronized (this.f3315c) {
            x0VarRemove = this.f3325m.remove(y0Var);
        }
        return x0VarRemove;
    }

    public final void n0() {
        synchronized (this.f3315c) {
            this.f3332t = true;
            Unit unit = Unit.f68710a;
        }
    }

    @Override // androidx.compose.runtime.m
    public void o(Set<w1.a> set) {
    }

    public final void o0(y yVar) {
        synchronized (this.f3315c) {
            List<y0> list = this.f3323k;
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                if (Intrinsics.b(list.get(i11).b(), yVar)) {
                    Unit unit = Unit.f68710a;
                    ArrayList arrayList = new ArrayList();
                    p0(arrayList, this, yVar);
                    while (!arrayList.isEmpty()) {
                        q0(arrayList, null);
                        p0(arrayList, this, yVar);
                    }
                    return;
                }
            }
        }
    }

    @Override // androidx.compose.runtime.m
    public void q(y yVar) {
        synchronized (this.f3315c) {
            try {
                Set linkedHashSet = this.f3327o;
                if (linkedHashSet == null) {
                    linkedHashSet = new LinkedHashSet();
                    this.f3327o = linkedHashSet;
                }
                linkedHashSet.add(yVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final List<y> q0(List<y0> list, MutableScatterSet<Object> mutableScatterSet) {
        ArrayList arrayList;
        HashMap map = new HashMap(list.size());
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            y0 y0Var = list.get(i11);
            y yVarB = y0Var.b();
            Object arrayList2 = map.get(yVarB);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                map.put(yVarB, arrayList2);
            }
            ((ArrayList) arrayList2).add(y0Var);
        }
        for (Map.Entry entry : map.entrySet()) {
            y yVar = (y) entry.getKey();
            List list2 = (List) entry.getValue();
            k.Q(!yVar.o());
            androidx.compose.runtime.snapshots.b bVarO = androidx.compose.runtime.snapshots.j.f3684e.o(u0(yVar), C0(yVar, mutableScatterSet));
            try {
                androidx.compose.runtime.snapshots.j jVarL = bVarO.l();
                try {
                    synchronized (this.f3315c) {
                        arrayList = new ArrayList(list2.size());
                        int size2 = list2.size();
                        for (int i12 = 0; i12 < size2; i12++) {
                            y0 y0Var2 = (y0) list2.get(i12);
                            arrayList.add(TuplesKt.a(y0Var2, x1.b(this.f3324l, y0Var2.c())));
                        }
                    }
                    int size3 = arrayList.size();
                    for (int i13 = 0; i13 < size3; i13++) {
                        if (arrayList.get(i13).getSecond() != null) {
                            int size4 = arrayList.size();
                            for (int i14 = 0; i14 < size4; i14++) {
                                if (arrayList.get(i14).getSecond() == null) {
                                    ArrayList arrayList3 = new ArrayList(arrayList.size());
                                    int size5 = arrayList.size();
                                    for (int i15 = 0; i15 < size5; i15++) {
                                        Pair<y0, y0> pair = arrayList.get(i15);
                                        y0 first = pair.getSecond() == null ? pair.getFirst() : null;
                                        if (first != null) {
                                            arrayList3.add(first);
                                        }
                                    }
                                    synchronized (this.f3315c) {
                                        kotlin.collections.k.A(this.f3323k, arrayList3);
                                        Unit unit = Unit.f68710a;
                                    }
                                    ArrayList arrayList4 = new ArrayList(arrayList.size());
                                    int size6 = arrayList.size();
                                    for (int i16 = 0; i16 < size6; i16++) {
                                        Pair<y0, y0> pair2 = arrayList.get(i16);
                                        if (pair2.getSecond() != null) {
                                            arrayList4.add(pair2);
                                        }
                                    }
                                    arrayList = arrayList4;
                                    break;
                                }
                            }
                            break;
                        }
                    }
                    yVar.f(arrayList);
                    Unit unit2 = Unit.f68710a;
                    bVarO.s(jVarL);
                    Y(bVarO);
                } catch (Throwable th2) {
                    bVarO.s(jVarL);
                    throw th2;
                }
            } catch (Throwable th3) {
                Y(bVarO);
                throw th3;
            }
        }
        return CollectionsKt___CollectionsKt.J0(map.keySet());
    }

    public final y r0(final y yVar, final MutableScatterSet<Object> mutableScatterSet) {
        Set<y> set;
        if (yVar.o() || yVar.isDisposed() || ((set = this.f3327o) != null && set.contains(yVar))) {
            return null;
        }
        androidx.compose.runtime.snapshots.b bVarO = androidx.compose.runtime.snapshots.j.f3684e.o(u0(yVar), C0(yVar, mutableScatterSet));
        try {
            androidx.compose.runtime.snapshots.j jVarL = bVarO.l();
            if (mutableScatterSet != null) {
                try {
                    if (mutableScatterSet.e()) {
                        yVar.l(new Function0<Unit>() { // from class: androidx.compose.runtime.Recomposer$performRecompose$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.f68710a;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                MutableScatterSet<Object> mutableScatterSet2 = mutableScatterSet;
                                y yVar2 = yVar;
                                Object[] objArr = mutableScatterSet2.f1898b;
                                long[] jArr = mutableScatterSet2.f1897a;
                                int length = jArr.length - 2;
                                if (length < 0) {
                                    return;
                                }
                                int i11 = 0;
                                while (true) {
                                    long j11 = jArr[i11];
                                    if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i12 = 8 - ((~(i11 - length)) >>> 31);
                                        for (int i13 = 0; i13 < i12; i13++) {
                                            if ((255 & j11) < 128) {
                                                yVar2.q(objArr[(i11 << 3) + i13]);
                                            }
                                            j11 >>= 8;
                                        }
                                        if (i12 != 8) {
                                            return;
                                        }
                                    }
                                    if (i11 == length) {
                                        return;
                                    } else {
                                        i11++;
                                    }
                                }
                            }
                        });
                    }
                } catch (Throwable th2) {
                    bVarO.s(jVarL);
                    throw th2;
                }
            }
            boolean zI = yVar.i();
            bVarO.s(jVarL);
            Y(bVarO);
            if (zI) {
                return yVar;
            }
            return null;
        } catch (Throwable th3) {
            Y(bVarO);
            throw th3;
        }
    }

    public final void s0(Exception exc, y yVar, boolean z11) throws Exception {
        int i11 = 0;
        if (!B.get().booleanValue() || (exc instanceof ComposeRuntimeError)) {
            synchronized (this.f3315c) {
                b bVar = this.f3331s;
                if (bVar != null) {
                    throw bVar.a();
                }
                this.f3331s = new b(false, exc);
                Unit unit = Unit.f68710a;
            }
            throw exc;
        }
        synchronized (this.f3315c) {
            try {
                ActualAndroid_androidKt.e("Error was captured in composition while live edit was enabled.", exc);
                this.f3322j.clear();
                this.f3321i.i();
                this.f3320h = new MutableScatterSet<>(i11, 1, null);
                this.f3323k.clear();
                this.f3324l.clear();
                this.f3325m.clear();
                this.f3331s = new b(z11, exc);
                if (yVar != null) {
                    x0(yVar);
                }
                c0();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.compose.runtime.m
    public void t(y yVar) {
        synchronized (this.f3315c) {
            z0(yVar);
            this.f3321i.x(yVar);
            this.f3322j.remove(yVar);
            Unit unit = Unit.f68710a;
        }
    }

    public final Function1<Object, Unit> u0(final y yVar) {
        return new Function1<Object, Unit>() { // from class: androidx.compose.runtime.Recomposer$readObserverOf$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                yVar.a(obj);
            }
        };
    }

    public final Object v0(Function3<? super kotlinx.coroutines.k0, ? super u0, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super Unit> continuation) {
        Object objG = kotlinx.coroutines.h.g(this.f3314b, new Recomposer$recompositionRunner$2(this, function3, v0.a(continuation.getContext()), null), continuation);
        return objG == kotlin.coroutines.intrinsics.a.e() ? objG : Unit.f68710a;
    }

    public final boolean w0() {
        List<y> listK0;
        boolean zI0;
        synchronized (this.f3315c) {
            if (this.f3320h.d()) {
                return i0();
            }
            Set<? extends Object> setA = androidx.compose.runtime.collection.d.a(this.f3320h);
            DefaultConstructorMarker defaultConstructorMarker = null;
            int i11 = 1;
            int i12 = 0;
            this.f3320h = new MutableScatterSet<>(i12, i11, defaultConstructorMarker);
            synchronized (this.f3315c) {
                listK0 = k0();
            }
            try {
                int size = listK0.size();
                for (int i13 = 0; i13 < size; i13++) {
                    listK0.get(i13).m(setA);
                    if (this.f3333u.getValue().compareTo(State.ShuttingDown) <= 0) {
                        break;
                    }
                }
                synchronized (this.f3315c) {
                    this.f3320h = new MutableScatterSet<>(i12, i11, defaultConstructorMarker);
                    Unit unit = Unit.f68710a;
                }
                synchronized (this.f3315c) {
                    if (c0() != null) {
                        throw new IllegalStateException("called outside of runRecomposeAndApplyChanges".toString());
                    }
                    zI0 = i0();
                }
                return zI0;
            } catch (Throwable th2) {
                synchronized (this.f3315c) {
                    this.f3320h.j(setA);
                    throw th2;
                }
            }
        }
    }

    public final void x0(y yVar) {
        List arrayList = this.f3326n;
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.f3326n = arrayList;
        }
        if (!arrayList.contains(yVar)) {
            arrayList.add(yVar);
        }
        z0(yVar);
    }

    public final void y0(kotlinx.coroutines.q1 q1Var) {
        synchronized (this.f3315c) {
            Throwable th2 = this.f3317e;
            if (th2 != null) {
                throw th2;
            }
            if (this.f3333u.getValue().compareTo(State.ShuttingDown) <= 0) {
                throw new IllegalStateException("Recomposer shut down".toString());
            }
            if (this.f3316d != null) {
                throw new IllegalStateException("Recomposer already running".toString());
            }
            this.f3316d = q1Var;
            c0();
        }
    }

    public final void z0(y yVar) {
        this.f3318f.remove(yVar);
        this.f3319g = null;
    }
}
