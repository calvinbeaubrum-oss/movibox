package androidx.compose.runtime;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import androidx.compose.runtime.collection.ScatterSetWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
public final class o implements y, d2, w1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f3513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f<?> f3514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference<Object> f3515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f3516d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set<b2> f3517f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final j2 f3518g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final androidx.compose.runtime.collection.e<Object, RecomposeScopeImpl> f3519h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MutableScatterSet<RecomposeScopeImpl> f3520i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MutableScatterSet<RecomposeScopeImpl> f3521j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final androidx.compose.runtime.collection.e<Object, z<?>> f3522k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final r1.a f3523l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final r1.a f3524m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final androidx.compose.runtime.collection.e<Object, RecomposeScopeImpl> f3525n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public androidx.compose.runtime.collection.e<RecomposeScopeImpl, Object> f3526o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f3527p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public o f3528q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f3529r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final u f3530s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ComposerImpl f3531t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final CoroutineContext f3532u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f3533v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f3534w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Function2<? super i, ? super Integer, Unit> f3535x;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a implements a2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<b2> f3536a;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public MutableScatterSet<h> f3540e;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<b2> f3537b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<Object> f3538c = new ArrayList();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<Function0<Unit>> f3539d = new ArrayList();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List<Object> f3541f = new ArrayList();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final androidx.collection.b0 f3542g = new androidx.collection.b0(0, 1, null);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final androidx.collection.b0 f3543h = new androidx.collection.b0(0, 1, null);

        public a(Set<b2> set) {
            this.f3536a = set;
        }

        @Override // androidx.compose.runtime.a2
        public void a(Function0<Unit> function0) {
            this.f3539d.add(function0);
        }

        @Override // androidx.compose.runtime.a2
        public void b(h hVar, int i11, int i12, int i13) {
            MutableScatterSet<h> mutableScatterSetA = this.f3540e;
            if (mutableScatterSetA == null) {
                mutableScatterSetA = androidx.collection.u0.a();
                this.f3540e = mutableScatterSetA;
            }
            mutableScatterSetA.w(hVar);
            j(hVar, i11, i12, i13);
        }

        @Override // androidx.compose.runtime.a2
        public void c(b2 b2Var) {
            this.f3537b.add(b2Var);
        }

        @Override // androidx.compose.runtime.a2
        public void d(h hVar, int i11, int i12, int i13) {
            j(hVar, i11, i12, i13);
        }

        @Override // androidx.compose.runtime.a2
        public void e(b2 b2Var, int i11, int i12, int i13) {
            j(b2Var, i11, i12, i13);
        }

        public final void f() {
            if (!this.f3536a.isEmpty()) {
                Object objA = e3.f3371a.a("Compose:abandons");
                try {
                    Iterator<b2> it = this.f3536a.iterator();
                    while (it.hasNext()) {
                        b2 next = it.next();
                        it.remove();
                        next.onAbandoned();
                    }
                    Unit unit = Unit.f68710a;
                } finally {
                    e3.f3371a.b(objA);
                }
            }
        }

        public final void g() {
            i(Integer.MIN_VALUE);
            if (!this.f3538c.isEmpty()) {
                Object objA = e3.f3371a.a("Compose:onForgotten");
                try {
                    MutableScatterSet<h> mutableScatterSet = this.f3540e;
                    for (int size = this.f3538c.size() - 1; -1 < size; size--) {
                        Object obj = this.f3538c.get(size);
                        if (obj instanceof b2) {
                            this.f3536a.remove(obj);
                            ((b2) obj).onForgotten();
                        }
                        if (obj instanceof h) {
                            if (mutableScatterSet == null || !mutableScatterSet.a((h) obj)) {
                                ((h) obj).onDeactivate();
                            } else {
                                ((h) obj).onRelease();
                            }
                        }
                    }
                    Unit unit = Unit.f68710a;
                    e3.f3371a.b(objA);
                } catch (Throwable th2) {
                    e3.f3371a.b(objA);
                    throw th2;
                }
            }
            if (!this.f3537b.isEmpty()) {
                Object objA2 = e3.f3371a.a("Compose:onRemembered");
                try {
                    List<b2> list = this.f3537b;
                    int size2 = list.size();
                    for (int i11 = 0; i11 < size2; i11++) {
                        b2 b2Var = list.get(i11);
                        this.f3536a.remove(b2Var);
                        b2Var.onRemembered();
                    }
                    Unit unit2 = Unit.f68710a;
                } finally {
                    e3.f3371a.b(objA2);
                }
            }
        }

        public final void h() {
            if (!this.f3539d.isEmpty()) {
                Object objA = e3.f3371a.a("Compose:sideeffects");
                try {
                    List<Function0<Unit>> list = this.f3539d;
                    int size = list.size();
                    for (int i11 = 0; i11 < size; i11++) {
                        list.get(i11).invoke();
                    }
                    this.f3539d.clear();
                    Unit unit = Unit.f68710a;
                } finally {
                    e3.f3371a.b(objA);
                }
            }
        }

        public final void i(int i11) {
            if (!this.f3541f.isEmpty()) {
                int i12 = 0;
                List listQ = null;
                androidx.collection.b0 b0Var = null;
                androidx.collection.b0 b0Var2 = null;
                int i13 = 0;
                while (i13 < this.f3543h.b()) {
                    if (i11 <= this.f3543h.a(i13)) {
                        Object objRemove = this.f3541f.remove(i13);
                        int iK = this.f3543h.k(i13);
                        int iK2 = this.f3542g.k(i13);
                        if (listQ == null) {
                            listQ = kotlin.collections.g.q(objRemove);
                            b0Var2 = new androidx.collection.b0(0, 1, null);
                            b0Var2.f(iK);
                            b0Var = new androidx.collection.b0(0, 1, null);
                            b0Var.f(iK2);
                        } else {
                            Intrinsics.e(b0Var, "null cannot be cast to non-null type androidx.collection.MutableIntList");
                            Intrinsics.e(b0Var2, "null cannot be cast to non-null type androidx.collection.MutableIntList");
                            listQ.add(objRemove);
                            b0Var2.f(iK);
                            b0Var.f(iK2);
                        }
                    } else {
                        i13++;
                    }
                }
                if (listQ != null) {
                    Intrinsics.e(b0Var, "null cannot be cast to non-null type androidx.collection.MutableIntList");
                    Intrinsics.e(b0Var2, "null cannot be cast to non-null type androidx.collection.MutableIntList");
                    int size = listQ.size() - 1;
                    while (i12 < size) {
                        int i14 = i12 + 1;
                        int size2 = listQ.size();
                        for (int i15 = i14; i15 < size2; i15++) {
                            int iA = b0Var2.a(i12);
                            int iA2 = b0Var2.a(i15);
                            if (iA < iA2 || (iA2 == iA && b0Var.a(i12) < b0Var.a(i15))) {
                                p.g(listQ, i12, i15);
                                p.f(b0Var, i12, i15);
                                p.f(b0Var2, i12, i15);
                            }
                        }
                        i12 = i14;
                    }
                    this.f3538c.addAll(listQ);
                }
            }
        }

        public final void j(Object obj, int i11, int i12, int i13) {
            i(i11);
            if (i13 < 0 || i13 >= i11) {
                this.f3538c.add(obj);
                return;
            }
            this.f3541f.add(obj);
            this.f3542g.f(i12);
            this.f3543h.f(i13);
        }
    }

    public o(m mVar, f<?> fVar, CoroutineContext coroutineContext) {
        this.f3513a = mVar;
        this.f3514b = fVar;
        this.f3515c = new AtomicReference<>(null);
        this.f3516d = new Object();
        Set<b2> setL = new MutableScatterSet(0, 1, null).l();
        this.f3517f = setL;
        j2 j2Var = new j2();
        if (mVar.d()) {
            j2Var.i();
        }
        if (mVar.f()) {
            j2Var.j();
        }
        this.f3518g = j2Var;
        this.f3519h = new androidx.compose.runtime.collection.e<>();
        this.f3520i = new MutableScatterSet<>(0, 1, null);
        this.f3521j = new MutableScatterSet<>(0, 1, null);
        this.f3522k = new androidx.compose.runtime.collection.e<>();
        r1.a aVar = new r1.a();
        this.f3523l = aVar;
        r1.a aVar2 = new r1.a();
        this.f3524m = aVar2;
        this.f3525n = new androidx.compose.runtime.collection.e<>();
        this.f3526o = new androidx.compose.runtime.collection.e<>();
        this.f3530s = new u(null, false, 3, null);
        ComposerImpl composerImpl = new ComposerImpl(fVar, mVar, j2Var, setL, aVar, aVar2, this);
        mVar.p(composerImpl);
        this.f3531t = composerImpl;
        this.f3532u = coroutineContext;
        this.f3533v = mVar instanceof Recomposer;
        this.f3535x = ComposableSingletons$CompositionKt.f3236a.a();
    }

    public /* synthetic */ o(m mVar, f fVar, CoroutineContext coroutineContext, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(mVar, fVar, (i11 & 4) != 0 ? null : coroutineContext);
    }

    public final void A(Function2<? super i, ? super Integer, Unit> function2) {
        if (!(!this.f3534w)) {
            o1.b("The composition is disposed");
        }
        this.f3535x = function2;
        this.f3513a.a(this, function2);
    }

    public final void B() {
        Object andSet = this.f3515c.getAndSet(p.f3547a);
        if (andSet != null) {
            if (Intrinsics.b(andSet, p.f3547a)) {
                k.t("pending composition has not been applied");
                throw new KotlinNothingValueException();
            }
            if (andSet instanceof Set) {
                x((Set) andSet, true);
                return;
            }
            if (!(andSet instanceof Object[])) {
                k.t("corrupt pendingModifications drain: " + this.f3515c);
                throw new KotlinNothingValueException();
            }
            for (Set<? extends Object> set : (Set[]) andSet) {
                x(set, true);
            }
        }
    }

    public final void C() {
        Object andSet = this.f3515c.getAndSet(null);
        if (Intrinsics.b(andSet, p.f3547a)) {
            return;
        }
        if (andSet instanceof Set) {
            x((Set) andSet, false);
            return;
        }
        if (andSet instanceof Object[]) {
            for (Set<? extends Object> set : (Set[]) andSet) {
                x(set, false);
            }
            return;
        }
        if (andSet == null) {
            k.t("calling recordModificationsOf and applyChanges concurrently is not supported");
            throw new KotlinNothingValueException();
        }
        k.t("corrupt pendingModifications drain: " + this.f3515c);
        throw new KotlinNothingValueException();
    }

    public final boolean D() {
        return this.f3531t.A0();
    }

    public final u E() {
        return this.f3530s;
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00a0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:45:0x00a2 A[Catch: all -> 0x001e, LOOP:0: B:32:0x0063->B:45:0x00a2, LOOP_END, TryCatch #0 {all -> 0x001e, blocks: (B:4:0x000b, B:6:0x0010, B:14:0x0023, B:16:0x0029, B:19:0x002d, B:21:0x0032, B:22:0x003b, B:24:0x003f, B:25:0x0047, B:27:0x0053, B:29:0x0057, B:32:0x0063, B:34:0x0073, B:36:0x007f, B:38:0x0089, B:41:0x0094, B:45:0x00a2, B:46:0x00a5, B:49:0x00aa), top: B:61:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00aa A[Catch: all -> 0x001e, EDGE_INSN: B:49:0x00aa->B:50:0x00af BREAK  A[LOOP:0: B:32:0x0063->B:45:0x00a2], TRY_LEAVE, TryCatch #0 {all -> 0x001e, blocks: (B:4:0x000b, B:6:0x0010, B:14:0x0023, B:16:0x0029, B:19:0x002d, B:21:0x0032, B:22:0x003b, B:24:0x003f, B:25:0x0047, B:27:0x0053, B:29:0x0057, B:32:0x0063, B:34:0x0073, B:36:0x007f, B:38:0x0089, B:41:0x0094, B:45:0x00a2, B:46:0x00a5, B:49:0x00aa), top: B:61:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:64:0x00aa A[SYNTHETIC] */
    public final InvalidationResult F(RecomposeScopeImpl recomposeScopeImpl, c cVar, Object obj) {
        synchronized (this.f3516d) {
            try {
                o oVar = this.f3528q;
                o oVar2 = null;
                if (oVar != null) {
                    if (!this.f3518g.C(this.f3529r, cVar)) {
                        oVar = null;
                    }
                    oVar2 = oVar;
                }
                if (oVar2 == null) {
                    if (L(recomposeScopeImpl, obj)) {
                        return InvalidationResult.IMMINENT;
                    }
                    H();
                    if (obj != null && (obj instanceof z)) {
                        Object objB = this.f3526o.d().b(recomposeScopeImpl);
                        if (objB == null) {
                            this.f3526o.a(recomposeScopeImpl, obj);
                            break;
                        }
                        if (objB instanceof MutableScatterSet) {
                            MutableScatterSet mutableScatterSet = (MutableScatterSet) objB;
                            Object[] objArr = mutableScatterSet.f1898b;
                            long[] jArr = mutableScatterSet.f1897a;
                            int length = jArr.length - 2;
                            if (length < 0) {
                                this.f3526o.a(recomposeScopeImpl, obj);
                                break;
                            }
                            int i11 = 0;
                            loop0: while (true) {
                                long j11 = jArr[i11];
                                if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                                    int i12 = 8 - ((~(i11 - length)) >>> 31);
                                    for (int i13 = 0; i13 < i12; i13++) {
                                        if ((j11 & 255) < 128 && objArr[(i11 << 3) + i13] == f2.f3409a) {
                                            break loop0;
                                        }
                                        j11 >>= 8;
                                    }
                                    if (i12 == 8) {
                                        if (i11 == length) {
                                            i11++;
                                        }
                                    }
                                    this.f3526o.a(recomposeScopeImpl, obj);
                                    break;
                                }
                                if (i11 == length) {
                                    this.f3526o.a(recomposeScopeImpl, obj);
                                    break;
                                }
                                i11++;
                            }
                        } else {
                            if (objB != f2.f3409a) {
                                this.f3526o.a(recomposeScopeImpl, obj);
                                break;
                            }
                        }
                    } else {
                        this.f3526o.h(recomposeScopeImpl, f2.f3409a);
                    }
                }
                if (oVar2 != null) {
                    return oVar2.F(recomposeScopeImpl, cVar, obj);
                }
                this.f3513a.l(this);
                return o() ? InvalidationResult.DEFERRED : InvalidationResult.SCHEDULED;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void G(Object obj) {
        Object objB = this.f3519h.d().b(obj);
        if (objB == null) {
            return;
        }
        if (!(objB instanceof MutableScatterSet)) {
            RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) objB;
            if (recomposeScopeImpl.s(obj) == InvalidationResult.IMMINENT) {
                this.f3525n.a(obj, recomposeScopeImpl);
                return;
            }
            return;
        }
        MutableScatterSet mutableScatterSet = (MutableScatterSet) objB;
        Object[] objArr = mutableScatterSet.f1898b;
        long[] jArr = mutableScatterSet.f1897a;
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
                        RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) objArr[(i11 << 3) + i13];
                        if (recomposeScopeImpl2.s(obj) == InvalidationResult.IMMINENT) {
                            this.f3525n.a(obj, recomposeScopeImpl2);
                        }
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

    public final w1.c H() {
        u uVar = this.f3530s;
        if (uVar.b()) {
            uVar.a();
        } else {
            u uVarJ = this.f3513a.j();
            if (uVarJ != null) {
                uVarJ.a();
            }
            uVar.a();
            if (!Intrinsics.b(null, null)) {
                uVar.c(null);
            }
        }
        return null;
    }

    public final void I(z<?> zVar) {
        if (this.f3519h.c(zVar)) {
            return;
        }
        this.f3522k.g(zVar);
    }

    public final void J(Object obj, RecomposeScopeImpl recomposeScopeImpl) {
        this.f3519h.f(obj, recomposeScopeImpl);
    }

    public final androidx.compose.runtime.collection.e<RecomposeScopeImpl, Object> K() {
        androidx.compose.runtime.collection.e<RecomposeScopeImpl, Object> eVar = this.f3526o;
        this.f3526o = new androidx.compose.runtime.collection.e<>();
        return eVar;
    }

    public final boolean L(RecomposeScopeImpl recomposeScopeImpl, Object obj) {
        return o() && this.f3531t.o1(recomposeScopeImpl, obj);
    }

    @Override // androidx.compose.runtime.y, androidx.compose.runtime.w1
    public void a(Object obj) {
        RecomposeScopeImpl recomposeScopeImplC0;
        long[] jArr;
        if (D() || (recomposeScopeImplC0 = this.f3531t.C0()) == null) {
            return;
        }
        recomposeScopeImplC0.H(true);
        if (recomposeScopeImplC0.w(obj)) {
            return;
        }
        if (obj instanceof androidx.compose.runtime.snapshots.d0) {
            ((androidx.compose.runtime.snapshots.d0) obj).m48recordReadInh_f27i8$runtime_release(androidx.compose.runtime.snapshots.f.a(1));
        }
        this.f3519h.a(obj, recomposeScopeImplC0);
        if (obj instanceof z) {
            z<?> zVar = (z) obj;
            z.a<?> aVarD = zVar.d();
            this.f3522k.g(obj);
            androidx.collection.n0<androidx.compose.runtime.snapshots.c0> n0VarB = aVarD.b();
            Object[] objArr = n0VarB.f1957b;
            long[] jArr2 = n0VarB.f1956a;
            int length = jArr2.length - 2;
            if (length >= 0) {
                int i11 = 0;
                while (true) {
                    long j11 = jArr2[i11];
                    if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i12 = 8 - ((~(i11 - length)) >>> 31);
                        int i13 = 0;
                        while (i13 < i12) {
                            if ((j11 & 255) < 128) {
                                androidx.compose.runtime.snapshots.c0 c0Var = (androidx.compose.runtime.snapshots.c0) objArr[(i11 << 3) + i13];
                                if (c0Var instanceof androidx.compose.runtime.snapshots.d0) {
                                    ((androidx.compose.runtime.snapshots.d0) c0Var).m48recordReadInh_f27i8$runtime_release(androidx.compose.runtime.snapshots.f.a(1));
                                }
                                this.f3522k.a(c0Var, obj);
                            } else {
                                jArr2 = jArr2;
                            }
                            j11 >>= 8;
                            i13++;
                            jArr2 = jArr2;
                        }
                        jArr = jArr2;
                        if (i12 != 8) {
                            break;
                        }
                    } else {
                        jArr = jArr2;
                    }
                    if (i11 == length) {
                        break;
                    }
                    i11++;
                    jArr2 = jArr;
                }
            }
            recomposeScopeImplC0.v(zVar, aVarD.a());
        }
    }

    @Override // androidx.compose.runtime.y
    public void b(Function2<? super i, ? super Integer, Unit> function2) throws Exception {
        try {
            synchronized (this.f3516d) {
                B();
                androidx.compose.runtime.collection.e<RecomposeScopeImpl, Object> eVarK = K();
                try {
                    H();
                    this.f3531t.i0(eVarK, function2);
                } catch (Exception e11) {
                    this.f3526o = eVarK;
                    throw e11;
                }
            }
        } catch (Throwable th2) {
            try {
                if (!this.f3517f.isEmpty()) {
                    new a(this.f3517f).f();
                }
                throw th2;
            } catch (Exception e12) {
                s();
                throw e12;
            }
        }
    }

    @Override // androidx.compose.runtime.y
    public void c() {
        synchronized (this.f3516d) {
            try {
                if (this.f3524m.d()) {
                    y(this.f3524m);
                }
                Unit unit = Unit.f68710a;
            } catch (Throwable th2) {
                try {
                    try {
                        if (!this.f3517f.isEmpty()) {
                            new a(this.f3517f).f();
                        }
                        throw th2;
                    } catch (Exception e11) {
                        s();
                        throw e11;
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }
    }

    @Override // androidx.compose.runtime.l
    public void d(Function2<? super i, ? super Integer, Unit> function2) {
        A(function2);
    }

    @Override // androidx.compose.runtime.d2
    public void deactivate() {
        synchronized (this.f3516d) {
            try {
                boolean z11 = this.f3518g.w() > 0;
                if (z11 || (!this.f3517f.isEmpty())) {
                    e3 e3Var = e3.f3371a;
                    Object objA = e3Var.a("Compose:deactivate");
                    try {
                        a aVar = new a(this.f3517f);
                        if (z11) {
                            this.f3514b.h();
                            m2 m2VarE = this.f3518g.E();
                            try {
                                k.u(m2VarE, aVar);
                                Unit unit = Unit.f68710a;
                                m2VarE.L(true);
                                this.f3514b.e();
                                aVar.g();
                            } catch (Throwable th2) {
                                m2VarE.L(false);
                                throw th2;
                            }
                        }
                        aVar.f();
                        Unit unit2 = Unit.f68710a;
                        e3Var.b(objA);
                    } catch (Throwable th3) {
                        e3.f3371a.b(objA);
                        throw th3;
                    }
                }
                this.f3519h.b();
                this.f3522k.b();
                this.f3526o.b();
                this.f3523l.a();
                this.f3524m.a();
                this.f3531t.n0();
                Unit unit3 = Unit.f68710a;
            } catch (Throwable th4) {
                throw th4;
            }
        }
    }

    @Override // androidx.compose.runtime.l
    public void dispose() {
        synchronized (this.f3516d) {
            try {
                if (!(!this.f3531t.L0())) {
                    o1.b("Composition is disposed while composing. If dispose is triggered by a call in @Composable function, consider wrapping it with SideEffect block.");
                }
                if (!this.f3534w) {
                    this.f3534w = true;
                    this.f3535x = ComposableSingletons$CompositionKt.f3236a.b();
                    r1.a aVarD0 = this.f3531t.D0();
                    if (aVarD0 != null) {
                        y(aVarD0);
                    }
                    boolean z11 = this.f3518g.w() > 0;
                    if (z11 || (!this.f3517f.isEmpty())) {
                        a aVar = new a(this.f3517f);
                        if (z11) {
                            this.f3514b.h();
                            m2 m2VarE = this.f3518g.E();
                            try {
                                k.M(m2VarE, aVar);
                                Unit unit = Unit.f68710a;
                                m2VarE.L(true);
                                this.f3514b.clear();
                                this.f3514b.e();
                                aVar.g();
                            } catch (Throwable th2) {
                                m2VarE.L(false);
                                throw th2;
                            }
                        }
                        aVar.f();
                    }
                    this.f3531t.o0();
                }
                Unit unit2 = Unit.f68710a;
            } catch (Throwable th3) {
                throw th3;
            }
        }
        this.f3513a.t(this);
    }

    @Override // androidx.compose.runtime.y
    public void e(x0 x0Var) {
        a aVar = new a(this.f3517f);
        m2 m2VarE = x0Var.a().E();
        try {
            k.M(m2VarE, aVar);
            Unit unit = Unit.f68710a;
            m2VarE.L(true);
            aVar.g();
        } catch (Throwable th2) {
            m2VarE.L(false);
            throw th2;
        }
    }

    @Override // androidx.compose.runtime.y
    public void f(List<Pair<y0, y0>> list) throws Exception {
        int size = list.size();
        boolean z11 = false;
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                z11 = true;
                break;
            } else if (!Intrinsics.b(list.get(i11).getFirst().b(), this)) {
                break;
            } else {
                i11++;
            }
        }
        k.Q(z11);
        try {
            this.f3531t.I0(list);
            Unit unit = Unit.f68710a;
        } catch (Throwable th2) {
            try {
                if (!this.f3517f.isEmpty()) {
                    new a(this.f3517f).f();
                }
                throw th2;
            } catch (Exception e11) {
                s();
                throw e11;
            }
        }
    }

    @Override // androidx.compose.runtime.y
    public <R> R g(y yVar, int i11, Function0<? extends R> function0) {
        if (yVar == null || Intrinsics.b(yVar, this) || i11 < 0) {
            return function0.invoke();
        }
        this.f3528q = (o) yVar;
        this.f3529r = i11;
        try {
            return function0.invoke();
        } finally {
            this.f3528q = null;
            this.f3529r = 0;
        }
    }

    @Override // androidx.compose.runtime.w1
    public void h(RecomposeScopeImpl recomposeScopeImpl) {
        this.f3527p = true;
    }

    @Override // androidx.compose.runtime.y
    public boolean i() {
        boolean zS0;
        synchronized (this.f3516d) {
            try {
                B();
                try {
                    androidx.compose.runtime.collection.e<RecomposeScopeImpl, Object> eVarK = K();
                    try {
                        H();
                        zS0 = this.f3531t.S0(eVarK);
                        if (!zS0) {
                            C();
                        }
                    } catch (Exception e11) {
                        this.f3526o = eVarK;
                        throw e11;
                    }
                } catch (Throwable th2) {
                    try {
                        if (!this.f3517f.isEmpty()) {
                            new a(this.f3517f).f();
                        }
                        throw th2;
                    } catch (Exception e12) {
                        s();
                        throw e12;
                    }
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        return zS0;
    }

    @Override // androidx.compose.runtime.l
    public boolean isDisposed() {
        return this.f3534w;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x005b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:21:0x005d A[LOOP:0: B:7:0x001a->B:21:0x005d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:34:0x0081 A[SYNTHETIC] */
    @Override // androidx.compose.runtime.y
    public boolean j(Set<? extends Object> set) {
        if (set instanceof ScatterSetWrapper) {
            ScatterSet scatterSetA = ((ScatterSetWrapper) set).a();
            Object[] objArr = scatterSetA.f1898b;
            long[] jArr = scatterSetA.f1897a;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i11 = 0;
                loop0: while (true) {
                    long j11 = jArr[i11];
                    if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i12 = 8 - ((~(i11 - length)) >>> 31);
                        for (int i13 = 0; i13 < i12; i13++) {
                            if ((255 & j11) < 128) {
                                Object obj = objArr[(i11 << 3) + i13];
                                if (this.f3519h.c(obj) || this.f3522k.c(obj)) {
                                    break loop0;
                                }
                            }
                            j11 >>= 8;
                        }
                        if (i12 == 8) {
                            if (i11 != length) {
                                i11++;
                            }
                        }
                    } else if (i11 != length) {
                        i11++;
                    }
                }
                return true;
            }
        } else {
            for (Object obj2 : set) {
                if (this.f3519h.c(obj2) || this.f3522k.c(obj2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // androidx.compose.runtime.w1
    public InvalidationResult k(RecomposeScopeImpl recomposeScopeImpl, Object obj) {
        o oVar;
        if (recomposeScopeImpl.k()) {
            recomposeScopeImpl.C(true);
        }
        c cVarI = recomposeScopeImpl.i();
        if (cVarI == null || !cVarI.b()) {
            return InvalidationResult.IGNORED;
        }
        if (this.f3518g.F(cVarI)) {
            return !recomposeScopeImpl.j() ? InvalidationResult.IGNORED : F(recomposeScopeImpl, cVarI, obj);
        }
        synchronized (this.f3516d) {
            oVar = this.f3528q;
        }
        return (oVar == null || !oVar.L(recomposeScopeImpl, obj)) ? InvalidationResult.IGNORED : InvalidationResult.IMMINENT;
    }

    @Override // androidx.compose.runtime.y
    public void l(Function0<Unit> function0) {
        this.f3531t.Q0(function0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.y
    public void m(Set<? extends Object> set) {
        Object obj;
        Object objA;
        do {
            obj = this.f3515c.get();
            if (obj == null || Intrinsics.b(obj, p.f3547a)) {
                objA = set;
            } else if (obj instanceof Set) {
                objA = new Set[]{obj, set};
            } else {
                if (!(obj instanceof Object[])) {
                    throw new IllegalStateException(("corrupt pendingModifications: " + this.f3515c).toString());
                }
                Intrinsics.e(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.collections.Set<kotlin.Any>>");
                objA = ArraysKt___ArraysJvmKt.A((Set[]) obj, set);
            }
        } while (!androidx.compose.animation.core.j0.a(this.f3515c, obj, objA));
        if (obj == null) {
            synchronized (this.f3516d) {
                C();
                Unit unit = Unit.f68710a;
            }
        }
    }

    @Override // androidx.compose.runtime.y
    public void n() {
        synchronized (this.f3516d) {
            try {
                y(this.f3523l);
                C();
                Unit unit = Unit.f68710a;
            } catch (Throwable th2) {
                try {
                    try {
                        if (!this.f3517f.isEmpty()) {
                            new a(this.f3517f).f();
                        }
                        throw th2;
                    } catch (Exception e11) {
                        s();
                        throw e11;
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }
    }

    @Override // androidx.compose.runtime.y
    public boolean o() {
        return this.f3531t.L0();
    }

    @Override // androidx.compose.runtime.d2
    public void p(Function2<? super i, ? super Integer, Unit> function2) {
        this.f3531t.m1();
        A(function2);
        this.f3531t.t0();
    }

    /* JADX WARN: Code duplicated, block: B:22:0x005f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:23:0x0061 A[Catch: all -> 0x0057, LOOP:0: B:11:0x0027->B:23:0x0061, LOOP_END, TryCatch #0 {all -> 0x0057, blocks: (B:4:0x0005, B:6:0x0016, B:8:0x001a, B:11:0x0027, B:13:0x0037, B:15:0x0043, B:17:0x004c, B:20:0x0059, B:23:0x0061, B:24:0x0064, B:25:0x0069), top: B:30:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0069 A[EDGE_INSN: B:33:0x0069->B:25:0x0069 BREAK  A[LOOP:0: B:11:0x0027->B:23:0x0061], SYNTHETIC] */
    @Override // androidx.compose.runtime.y
    public void q(Object obj) {
        synchronized (this.f3516d) {
            try {
                G(obj);
                Object objB = this.f3522k.d().b(obj);
                if (objB != null) {
                    if (objB instanceof MutableScatterSet) {
                        MutableScatterSet mutableScatterSet = (MutableScatterSet) objB;
                        Object[] objArr = mutableScatterSet.f1898b;
                        long[] jArr = mutableScatterSet.f1897a;
                        int length = jArr.length - 2;
                        if (length >= 0) {
                            int i11 = 0;
                            while (true) {
                                long j11 = jArr[i11];
                                if ((((~j11) << 7) & j11 & (-9187201950435737472L)) == -9187201950435737472L) {
                                    if (i11 != length) {
                                        break;
                                        break;
                                    }
                                    i11++;
                                } else {
                                    int i12 = 8 - ((~(i11 - length)) >>> 31);
                                    for (int i13 = 0; i13 < i12; i13++) {
                                        if ((255 & j11) < 128) {
                                            G((z) objArr[(i11 << 3) + i13]);
                                        }
                                        j11 >>= 8;
                                    }
                                    if (i12 != 8) {
                                        break;
                                    } else if (i11 != length) {
                                        break;
                                    } else {
                                        i11++;
                                    }
                                }
                            }
                        }
                    } else {
                        G((z) objB);
                    }
                }
                Unit unit = Unit.f68710a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.compose.runtime.l
    public boolean r() {
        boolean z11;
        synchronized (this.f3516d) {
            z11 = this.f3526o.e() > 0;
        }
        return z11;
    }

    @Override // androidx.compose.runtime.y
    public void s() {
        this.f3515c.set(null);
        this.f3523l.a();
        this.f3524m.a();
        if (!this.f3517f.isEmpty()) {
            new a(this.f3517f).f();
        }
    }

    @Override // androidx.compose.runtime.y
    public void t() {
        synchronized (this.f3516d) {
            try {
                this.f3531t.f0();
                if (!this.f3517f.isEmpty()) {
                    new a(this.f3517f).f();
                }
                Unit unit = Unit.f68710a;
            } catch (Throwable th2) {
                try {
                    try {
                        if (!this.f3517f.isEmpty()) {
                            new a(this.f3517f).f();
                        }
                        throw th2;
                    } catch (Exception e11) {
                        s();
                        throw e11;
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }
    }

    @Override // androidx.compose.runtime.y
    public void u() {
        synchronized (this.f3516d) {
            try {
                for (Object obj : this.f3518g.x()) {
                    RecomposeScopeImpl recomposeScopeImpl = obj instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) obj : null;
                    if (recomposeScopeImpl != null) {
                        recomposeScopeImpl.invalidate();
                    }
                }
                Unit unit = Unit.f68710a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void w(Object obj, boolean z11) {
        Object objB = this.f3519h.d().b(obj);
        if (objB == null) {
            return;
        }
        if (!(objB instanceof MutableScatterSet)) {
            RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) objB;
            if (this.f3525n.f(obj, recomposeScopeImpl) || recomposeScopeImpl.s(obj) == InvalidationResult.IGNORED) {
                return;
            }
            if (!recomposeScopeImpl.t() || z11) {
                this.f3520i.h(recomposeScopeImpl);
                return;
            } else {
                this.f3521j.h(recomposeScopeImpl);
                return;
            }
        }
        MutableScatterSet mutableScatterSet = (MutableScatterSet) objB;
        Object[] objArr = mutableScatterSet.f1898b;
        long[] jArr = mutableScatterSet.f1897a;
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
                        RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) objArr[(i11 << 3) + i13];
                        if (!this.f3525n.f(obj, recomposeScopeImpl2) && recomposeScopeImpl2.s(obj) != InvalidationResult.IGNORED) {
                            if (!recomposeScopeImpl2.t() || z11) {
                                this.f3520i.h(recomposeScopeImpl2);
                            } else {
                                this.f3521j.h(recomposeScopeImpl2);
                            }
                        }
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

    /* JADX WARN: Code duplicated, block: B:117:0x0281 A[PHI: r16 r25 r26 r33 r34
  0x0281: PHI (r16v15 long[]) = (r16v14 long[]), (r16v14 long[]), (r16v16 long[]) binds: [B:114:0x0279, B:116:0x027f, B:111:0x0263] A[DONT_GENERATE, DONT_INLINE]
  0x0281: PHI (r25v12 int) = (r25v11 int), (r25v11 int), (r25v13 int) binds: [B:114:0x0279, B:116:0x027f, B:111:0x0263] A[DONT_GENERATE, DONT_INLINE]
  0x0281: PHI (r26v13 long) = (r26v12 long), (r26v12 long), (r26v15 long) binds: [B:114:0x0279, B:116:0x027f, B:111:0x0263] A[DONT_GENERATE, DONT_INLINE]
  0x0281: PHI (r33v18 java.lang.String) = (r33v17 java.lang.String), (r33v17 java.lang.String), (r33v19 java.lang.String) binds: [B:114:0x0279, B:116:0x027f, B:111:0x0263] A[DONT_GENERATE, DONT_INLINE]
  0x0281: PHI (r34v11 int) = (r34v10 int), (r34v10 int), (r34v12 int) binds: [B:114:0x0279, B:116:0x027f, B:111:0x0263] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:182:0x00cc A[EDGE_INSN: B:182:0x00cc->B:36:0x00cc BREAK  A[LOOP:2: B:23:0x0074->B:34:0x00b8], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:210:0x0109 A[EDGE_INSN: B:210:0x0109->B:205:0x0109 BREAK  A[LOOP:13: B:58:0x013e->B:69:0x017a], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x00b6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:34:0x00b8 A[LOOP:2: B:23:0x0074->B:34:0x00b8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:68:0x0178 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:69:0x017a A[LOOP:13: B:58:0x013e->B:69:0x017a, LOOP_END] */
    public final void x(Set<? extends Object> set, boolean z11) {
        String str;
        long[] jArr;
        int i11;
        String str2;
        int i12;
        boolean zA;
        Object[] objArr;
        long[] jArr2;
        Object[] objArr2;
        long[] jArr3;
        String str3;
        long[] jArr4;
        int i13;
        String str4;
        long[] jArr5;
        int i14;
        int i15;
        long j11;
        long[] jArr6;
        Object[] objArr3;
        long[] jArr7;
        Object[] objArr4;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21;
        char c11 = 7;
        long j12 = -9187201950435737472L;
        if (set instanceof ScatterSetWrapper) {
            ScatterSet scatterSetA = ((ScatterSetWrapper) set).a();
            Object[] objArr5 = scatterSetA.f1898b;
            long[] jArr8 = scatterSetA.f1897a;
            int length = jArr8.length - 2;
            if (length >= 0) {
                int i22 = 0;
                while (true) {
                    long j13 = jArr8[i22];
                    if ((((~j13) << c11) & j13 & j12) != j12) {
                        int i23 = 8 - ((~(i22 - length)) >>> 31);
                        int i24 = 0;
                        while (i24 < i23) {
                            if ((j13 & 255) < 128) {
                                Object obj = objArr5[(i22 << 3) + i24];
                                if (obj instanceof RecomposeScopeImpl) {
                                    ((RecomposeScopeImpl) obj).s(null);
                                } else {
                                    w(obj, z11);
                                    Object objB = this.f3522k.d().b(obj);
                                    if (objB != null) {
                                        if (objB instanceof MutableScatterSet) {
                                            MutableScatterSet mutableScatterSet = (MutableScatterSet) objB;
                                            Object[] objArr6 = mutableScatterSet.f1898b;
                                            long[] jArr9 = mutableScatterSet.f1897a;
                                            int length2 = jArr9.length - 2;
                                            if (length2 >= 0) {
                                                i19 = length;
                                                i21 = i22;
                                                int i25 = 0;
                                                while (true) {
                                                    long j14 = jArr9[i25];
                                                    i17 = i23;
                                                    i18 = i24;
                                                    if ((((~j14) << c11) & j14 & (-9187201950435737472L)) == -9187201950435737472L) {
                                                        if (i25 != length2) {
                                                            break;
                                                            break;
                                                        }
                                                        i25++;
                                                        i23 = i17;
                                                        i24 = i18;
                                                        c11 = 7;
                                                    } else {
                                                        int i26 = 8 - ((~(i25 - length2)) >>> 31);
                                                        for (int i27 = 0; i27 < i26; i27++) {
                                                            if ((j14 & 255) < 128) {
                                                                w((z) objArr6[(i25 << 3) + i27], z11);
                                                            }
                                                            j14 >>= 8;
                                                        }
                                                        if (i26 != 8) {
                                                            break;
                                                        }
                                                        if (i25 != length2) {
                                                            break;
                                                        }
                                                        i25++;
                                                        i23 = i17;
                                                        i24 = i18;
                                                        c11 = 7;
                                                    }
                                                }
                                            }
                                        } else {
                                            i17 = i23;
                                            i18 = i24;
                                            i19 = length;
                                            i21 = i22;
                                            w((z) objB, z11);
                                        }
                                    }
                                }
                                i17 = i23;
                                i18 = i24;
                                i19 = length;
                                i21 = i22;
                            } else {
                                i17 = i23;
                                i18 = i24;
                                i19 = length;
                                i21 = i22;
                            }
                            j13 >>= 8;
                            i24 = i18 + 1;
                            length = i19;
                            i22 = i21;
                            i23 = i17;
                            c11 = 7;
                        }
                        int i28 = length;
                        i16 = i22;
                        if (i23 != 8) {
                            break;
                        } else {
                            length = i28;
                        }
                    } else {
                        i16 = i22;
                    }
                    if (i16 == length) {
                        break;
                    }
                    i22 = i16 + 1;
                    c11 = 7;
                    j12 = -9187201950435737472L;
                }
            }
        } else {
            for (Object obj2 : set) {
                if (obj2 instanceof RecomposeScopeImpl) {
                    ((RecomposeScopeImpl) obj2).s(null);
                } else {
                    w(obj2, z11);
                    Object objB2 = this.f3522k.d().b(obj2);
                    if (objB2 != null) {
                        if (objB2 instanceof MutableScatterSet) {
                            MutableScatterSet mutableScatterSet2 = (MutableScatterSet) objB2;
                            Object[] objArr7 = mutableScatterSet2.f1898b;
                            long[] jArr10 = mutableScatterSet2.f1897a;
                            int length3 = jArr10.length - 2;
                            if (length3 >= 0) {
                                int i29 = 0;
                                while (true) {
                                    long j15 = jArr10[i29];
                                    if ((((~j15) << 7) & j15 & (-9187201950435737472L)) == -9187201950435737472L) {
                                        if (i29 != length3) {
                                            break;
                                            break;
                                        }
                                        i29++;
                                    } else {
                                        int i31 = 8 - ((~(i29 - length3)) >>> 31);
                                        for (int i32 = 0; i32 < i31; i32++) {
                                            if ((j15 & 255) < 128) {
                                                w((z) objArr7[(i29 << 3) + i32], z11);
                                            }
                                            j15 >>= 8;
                                        }
                                        if (i31 != 8) {
                                            break;
                                        } else if (i29 != length3) {
                                            break;
                                        } else {
                                            i29++;
                                        }
                                    }
                                }
                            }
                        } else {
                            w((z) objB2, z11);
                        }
                    }
                }
            }
        }
        MutableScatterSet<RecomposeScopeImpl> mutableScatterSet3 = this.f3521j;
        MutableScatterSet<RecomposeScopeImpl> mutableScatterSet4 = this.f3520i;
        String str5 = "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2>";
        if (!z11 || !mutableScatterSet3.e()) {
            String str6 = "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2>";
            if (mutableScatterSet4.e()) {
                androidx.collection.l0<Object, Object> l0VarD = this.f3519h.d();
                long[] jArr11 = l0VarD.f1982a;
                int length4 = jArr11.length - 2;
                if (length4 >= 0) {
                    int i33 = 0;
                    while (true) {
                        long j16 = jArr11[i33];
                        if ((((~j16) << 7) & j16 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i34 = 8 - ((~(i33 - length4)) >>> 31);
                            int i35 = 0;
                            while (i35 < i34) {
                                if ((j16 & 255) < 128) {
                                    int i36 = (i33 << 3) + i35;
                                    Object obj3 = l0VarD.f1983b[i36];
                                    Object obj4 = l0VarD.f1984c[i36];
                                    if (obj4 instanceof MutableScatterSet) {
                                        String str7 = str6;
                                        Intrinsics.e(obj4, str7);
                                        MutableScatterSet mutableScatterSet5 = (MutableScatterSet) obj4;
                                        Object[] objArr8 = mutableScatterSet5.f1898b;
                                        long[] jArr12 = mutableScatterSet5.f1897a;
                                        int length5 = jArr12.length - 2;
                                        if (length5 >= 0) {
                                            int i37 = 0;
                                            while (true) {
                                                long j17 = jArr12[i37];
                                                str2 = str7;
                                                i12 = i34;
                                                if ((((~j17) << 7) & j17 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                    int i38 = 8 - ((~(i37 - length5)) >>> 31);
                                                    int i39 = 0;
                                                    while (i39 < i38) {
                                                        if ((j17 & 255) < 128) {
                                                            jArr3 = jArr12;
                                                            int i40 = (i37 << 3) + i39;
                                                            objArr2 = objArr8;
                                                            if (mutableScatterSet4.a((RecomposeScopeImpl) objArr8[i40])) {
                                                                mutableScatterSet5.y(i40);
                                                            }
                                                        } else {
                                                            objArr2 = objArr8;
                                                            jArr3 = jArr12;
                                                        }
                                                        j17 >>= 8;
                                                        i39++;
                                                        jArr12 = jArr3;
                                                        objArr8 = objArr2;
                                                    }
                                                    objArr = objArr8;
                                                    jArr2 = jArr12;
                                                    if (i38 != 8) {
                                                        break;
                                                    }
                                                } else {
                                                    objArr = objArr8;
                                                    jArr2 = jArr12;
                                                }
                                                if (i37 == length5) {
                                                    break;
                                                }
                                                i37++;
                                                i34 = i12;
                                                str7 = str2;
                                                jArr12 = jArr2;
                                                objArr8 = objArr;
                                            }
                                        } else {
                                            str2 = str7;
                                            i12 = i34;
                                        }
                                        zA = mutableScatterSet5.d();
                                    } else {
                                        str2 = str6;
                                        i12 = i34;
                                        Intrinsics.e(obj4, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2");
                                        zA = mutableScatterSet4.a((RecomposeScopeImpl) obj4);
                                    }
                                    if (zA) {
                                        l0VarD.p(i36);
                                    }
                                } else {
                                    str2 = str6;
                                    jArr11 = jArr11;
                                    length4 = length4;
                                    i33 = i33;
                                    i12 = i34;
                                }
                                j16 >>= 8;
                                i35++;
                                length4 = length4;
                                i33 = i33;
                                jArr11 = jArr11;
                                i34 = i12;
                                str6 = str2;
                            }
                            str = str6;
                            jArr = jArr11;
                            int i41 = length4;
                            int i42 = i33;
                            if (i34 != 8) {
                                break;
                            }
                            length4 = i41;
                            i11 = i42;
                        } else {
                            str = str6;
                            jArr = jArr11;
                            i11 = i33;
                        }
                        if (i11 == length4) {
                            break;
                        }
                        i33 = i11 + 1;
                        jArr11 = jArr;
                        str6 = str;
                    }
                }
                z();
                mutableScatterSet4.m();
                return;
            }
            return;
        }
        androidx.collection.l0<Object, Object> l0VarD2 = this.f3519h.d();
        long[] jArr13 = l0VarD2.f1982a;
        int length6 = jArr13.length - 2;
        if (length6 >= 0) {
            int i43 = 0;
            while (true) {
                long j18 = jArr13[i43];
                if ((((~j18) << 7) & j18 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i44 = 8 - ((~(i43 - length6)) >>> 31);
                    int i45 = 0;
                    while (i45 < i44) {
                        if ((j18 & 255) < 128) {
                            int i46 = (i43 << 3) + i45;
                            Object obj5 = l0VarD2.f1983b[i46];
                            Object obj6 = l0VarD2.f1984c[i46];
                            if (obj6 instanceof MutableScatterSet) {
                                Intrinsics.e(obj6, str5);
                                MutableScatterSet mutableScatterSet6 = (MutableScatterSet) obj6;
                                Object[] objArr9 = mutableScatterSet6.f1898b;
                                jArr5 = jArr13;
                                long[] jArr14 = mutableScatterSet6.f1897a;
                                str4 = str5;
                                int length7 = jArr14.length - 2;
                                i14 = length6;
                                i15 = i43;
                                if (length7 >= 0) {
                                    int i47 = 0;
                                    while (true) {
                                        long j19 = jArr14[i47];
                                        j11 = j18;
                                        if ((((~j19) << 7) & j19 & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i48 = 8 - ((~(i47 - length7)) >>> 31);
                                            int i49 = 0;
                                            while (i49 < i48) {
                                                if ((j19 & 255) < 128) {
                                                    jArr7 = jArr14;
                                                    int i50 = (i47 << 3) + i49;
                                                    objArr4 = objArr9;
                                                    RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) objArr9[i50];
                                                    if (mutableScatterSet3.a(recomposeScopeImpl) || mutableScatterSet4.a(recomposeScopeImpl)) {
                                                        mutableScatterSet6.y(i50);
                                                    }
                                                } else {
                                                    jArr7 = jArr14;
                                                    objArr4 = objArr9;
                                                }
                                                j19 >>= 8;
                                                i49++;
                                                jArr14 = jArr7;
                                                objArr9 = objArr4;
                                            }
                                            jArr6 = jArr14;
                                            objArr3 = objArr9;
                                            if (i48 != 8) {
                                                break;
                                            }
                                        } else {
                                            jArr6 = jArr14;
                                            objArr3 = objArr9;
                                        }
                                        if (i47 == length7) {
                                            break;
                                        }
                                        i47++;
                                        j18 = j11;
                                        jArr14 = jArr6;
                                        objArr9 = objArr3;
                                    }
                                } else {
                                    j11 = j18;
                                }
                                if (mutableScatterSet6.d()) {
                                    l0VarD2.p(i46);
                                }
                            } else {
                                str4 = str5;
                                jArr5 = jArr13;
                                i14 = length6;
                                i15 = i43;
                                j11 = j18;
                                Intrinsics.e(obj6, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2");
                                RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) obj6;
                                if (mutableScatterSet3.a(recomposeScopeImpl2) || mutableScatterSet4.a(recomposeScopeImpl2)) {
                                    l0VarD2.p(i46);
                                }
                            }
                        } else {
                            str4 = str5;
                            jArr5 = jArr13;
                            i14 = length6;
                            i15 = i43;
                            j11 = j18;
                        }
                        j18 = j11 >> 8;
                        i45++;
                        str5 = str4;
                        length6 = i14;
                        jArr13 = jArr5;
                        i43 = i15;
                    }
                    str3 = str5;
                    jArr4 = jArr13;
                    int i51 = length6;
                    int i52 = i43;
                    if (i44 != 8) {
                        break;
                    }
                    length6 = i51;
                    i13 = i52;
                } else {
                    str3 = str5;
                    jArr4 = jArr13;
                    i13 = i43;
                }
                if (i13 == length6) {
                    break;
                }
                i43 = i13 + 1;
                str5 = str3;
                jArr13 = jArr4;
            }
        }
        mutableScatterSet3.m();
        z();
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01ed  */
    public final void y(r1.a aVar) throws Throwable {
        a aVar2;
        long[] jArr;
        int i11;
        a aVar3;
        long[] jArr2;
        int i12;
        int i13;
        long j11;
        long[] jArr3;
        long[] jArr4;
        o oVar = this;
        a aVar4 = new a(oVar.f3517f);
        try {
            if (aVar.c()) {
                if (oVar.f3524m.c()) {
                    aVar4.f();
                    return;
                }
                return;
            }
            e3 e3Var = e3.f3371a;
            Object objA = e3Var.a("Compose:applyChanges");
            oVar.f3514b.h();
            m2 m2VarE = oVar.f3518g.E();
            int i14 = 0;
            try {
                aVar.b(oVar.f3514b, m2VarE, aVar4);
                Unit unit = Unit.f68710a;
                m2VarE.L(true);
                oVar.f3514b.e();
                e3Var.b(objA);
                aVar4.g();
                aVar4.h();
                if (oVar.f3527p) {
                    try {
                        try {
                            Object objA2 = e3Var.a("Compose:unobserve");
                            try {
                                oVar.f3527p = false;
                                androidx.collection.l0<Object, Object> l0VarD = oVar.f3519h.d();
                                long[] jArr5 = l0VarD.f1982a;
                                int length = jArr5.length - 2;
                                if (length >= 0) {
                                    int i15 = 0;
                                    while (true) {
                                        long j12 = jArr5[i15];
                                        long j13 = -9187201950435737472L;
                                        if ((((~j12) << 7) & j12 & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i16 = 8 - ((~(i15 - length)) >>> 31);
                                            while (i14 < i16) {
                                                if ((j12 & 255) < 128) {
                                                    int i17 = (i15 << 3) + i14;
                                                    Object obj = l0VarD.f1983b[i17];
                                                    Object obj2 = l0VarD.f1984c[i17];
                                                    if (obj2 instanceof MutableScatterSet) {
                                                        Intrinsics.e(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2>");
                                                        MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                                                        Object[] objArr = mutableScatterSet.f1898b;
                                                        long[] jArr6 = mutableScatterSet.f1897a;
                                                        int length2 = jArr6.length - 2;
                                                        aVar3 = aVar4;
                                                        jArr2 = jArr5;
                                                        if (length2 >= 0) {
                                                            int i18 = 0;
                                                            while (true) {
                                                                try {
                                                                    long j14 = jArr6[i18];
                                                                    i12 = length;
                                                                    i13 = i15;
                                                                    j11 = -9187201950435737472L;
                                                                    if ((((~j14) << 7) & j14 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                                        int i19 = 8 - ((~(i18 - length2)) >>> 31);
                                                                        int i21 = 0;
                                                                        while (i21 < i19) {
                                                                            if ((j14 & 255) < 128) {
                                                                                jArr4 = jArr6;
                                                                                int i22 = (i18 << 3) + i21;
                                                                                if (!((RecomposeScopeImpl) objArr[i22]).r()) {
                                                                                    mutableScatterSet.y(i22);
                                                                                }
                                                                            } else {
                                                                                jArr4 = jArr6;
                                                                            }
                                                                            j14 >>= 8;
                                                                            i21++;
                                                                            jArr6 = jArr4;
                                                                        }
                                                                        jArr3 = jArr6;
                                                                        if (i19 != 8) {
                                                                            break;
                                                                        }
                                                                    } else {
                                                                        jArr3 = jArr6;
                                                                    }
                                                                    if (i18 == length2) {
                                                                        break;
                                                                    }
                                                                    i18++;
                                                                    length = i12;
                                                                    i15 = i13;
                                                                    jArr6 = jArr3;
                                                                } catch (Throwable th2) {
                                                                    th = th2;
                                                                    e3.f3371a.b(objA2);
                                                                    throw th;
                                                                }
                                                            }
                                                        } else {
                                                            i12 = length;
                                                            i13 = i15;
                                                            j11 = -9187201950435737472L;
                                                        }
                                                        if (mutableScatterSet.d()) {
                                                            l0VarD.p(i17);
                                                        }
                                                    } else {
                                                        aVar3 = aVar4;
                                                        jArr2 = jArr5;
                                                        i12 = length;
                                                        i13 = i15;
                                                        j11 = -9187201950435737472L;
                                                        Intrinsics.e(obj2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2");
                                                        if (!((RecomposeScopeImpl) obj2).r()) {
                                                            l0VarD.p(i17);
                                                        }
                                                    }
                                                } else {
                                                    aVar3 = aVar4;
                                                    jArr2 = jArr5;
                                                    i12 = length;
                                                    i13 = i15;
                                                    j11 = j13;
                                                }
                                                j12 >>= 8;
                                                i14++;
                                                j13 = j11;
                                                jArr5 = jArr2;
                                                aVar4 = aVar3;
                                                length = i12;
                                                i15 = i13;
                                            }
                                            aVar2 = aVar4;
                                            jArr = jArr5;
                                            int i23 = length;
                                            int i24 = i15;
                                            if (i16 != 8) {
                                                break;
                                            }
                                            length = i23;
                                            i11 = i24;
                                        } else {
                                            aVar2 = aVar4;
                                            jArr = jArr5;
                                            i11 = i15;
                                        }
                                        if (i11 == length) {
                                            break;
                                        }
                                        i15 = i11 + 1;
                                        jArr5 = jArr;
                                        aVar4 = aVar2;
                                        i14 = 0;
                                    }
                                } else {
                                    aVar2 = aVar4;
                                }
                                z();
                                Unit unit2 = Unit.f68710a;
                                e3.f3371a.b(objA2);
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            oVar = this;
                            if (oVar.f3524m.c()) {
                                aVar4.f();
                            }
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        aVar4 = aVar4;
                        oVar = this;
                        if (oVar.f3524m.c()) {
                            aVar4.f();
                        }
                        throw th;
                    }
                } else {
                    aVar2 = aVar4;
                }
                if (this.f3524m.c()) {
                    aVar2.f();
                    return;
                }
                return;
            } catch (Throwable th6) {
                try {
                    m2VarE.L(false);
                    throw th6;
                } catch (Throwable th7) {
                    th = th7;
                    try {
                        e3.f3371a.b(objA);
                        throw th;
                    } catch (Throwable th8) {
                        th = th8;
                    }
                }
            }
        } catch (Throwable th9) {
            th = th9;
            aVar4 = aVar4;
        }
        if (oVar.f3524m.c()) {
            aVar4.f();
        }
        throw th;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00f2 A[PHI: r24 r25 r26 r27
  0x00f2: PHI (r24v6 long[]) = (r24v5 long[]), (r24v7 long[]) binds: [B:39:0x00f0, B:36:0x00d6] A[DONT_GENERATE, DONT_INLINE]
  0x00f2: PHI (r25v4 int) = (r25v3 int), (r25v5 int) binds: [B:39:0x00f0, B:36:0x00d6] A[DONT_GENERATE, DONT_INLINE]
  0x00f2: PHI (r26v3 int) = (r26v2 int), (r26v5 int) binds: [B:39:0x00f0, B:36:0x00d6] A[DONT_GENERATE, DONT_INLINE]
  0x00f2: PHI (r27v3 int) = (r27v2 int), (r27v5 int) binds: [B:39:0x00f0, B:36:0x00d6] A[DONT_GENERATE, DONT_INLINE]] */
    public final void z() {
        long[] jArr;
        long[] jArr2;
        int i11;
        int i12;
        int i13;
        Object[] objArr;
        long[] jArr3;
        Object[] objArr2;
        long[] jArr4;
        androidx.collection.l0<Object, Object> l0VarD = this.f3522k.d();
        long[] jArr5 = l0VarD.f1982a;
        int length = jArr5.length - 2;
        long j11 = 255;
        char c11 = 7;
        long j12 = -9187201950435737472L;
        if (length >= 0) {
            int i14 = 0;
            while (true) {
                long j13 = jArr5[i14];
                if ((((~j13) << c11) & j13 & j12) != j12) {
                    int i15 = 8 - ((~(i14 - length)) >>> 31);
                    int i16 = 0;
                    while (i16 < i15) {
                        if ((j13 & j11) < 128) {
                            int i17 = (i14 << 3) + i16;
                            Object obj = l0VarD.f1983b[i17];
                            Object obj2 = l0VarD.f1984c[i17];
                            if (obj2 instanceof MutableScatterSet) {
                                Intrinsics.e(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2>");
                                MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                                Object[] objArr3 = mutableScatterSet.f1898b;
                                long[] jArr6 = mutableScatterSet.f1897a;
                                int length2 = jArr6.length - 2;
                                jArr2 = jArr5;
                                i11 = length;
                                if (length2 >= 0) {
                                    int i18 = 0;
                                    while (true) {
                                        long j14 = jArr6[i18];
                                        i12 = i15;
                                        i13 = i16;
                                        if ((((~j14) << c11) & j14 & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i19 = 8 - ((~(i18 - length2)) >>> 31);
                                            int i21 = 0;
                                            while (i21 < i19) {
                                                if ((j14 & 255) < 128) {
                                                    int i22 = (i18 << 3) + i21;
                                                    objArr2 = objArr3;
                                                    jArr4 = jArr6;
                                                    if (!this.f3519h.c((z) objArr3[i22])) {
                                                        mutableScatterSet.y(i22);
                                                    }
                                                } else {
                                                    objArr2 = objArr3;
                                                    jArr4 = jArr6;
                                                }
                                                j14 >>= 8;
                                                i21++;
                                                jArr6 = jArr4;
                                                objArr3 = objArr2;
                                            }
                                            objArr = objArr3;
                                            jArr3 = jArr6;
                                            if (i19 != 8) {
                                                break;
                                            }
                                        } else {
                                            objArr = objArr3;
                                            jArr3 = jArr6;
                                        }
                                        if (i18 == length2) {
                                            break;
                                        }
                                        i18++;
                                        i15 = i12;
                                        i16 = i13;
                                        jArr6 = jArr3;
                                        objArr3 = objArr;
                                        c11 = 7;
                                    }
                                } else {
                                    i12 = i15;
                                    i13 = i16;
                                }
                                if (mutableScatterSet.d()) {
                                    l0VarD.p(i17);
                                }
                            } else {
                                jArr2 = jArr5;
                                i11 = length;
                                i12 = i15;
                                i13 = i16;
                                Intrinsics.e(obj2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2");
                                if (!this.f3519h.c((z) obj2)) {
                                    l0VarD.p(i17);
                                }
                            }
                        } else {
                            jArr2 = jArr5;
                            i11 = length;
                            i12 = i15;
                            i13 = i16;
                        }
                        j13 >>= 8;
                        i16 = i13 + 1;
                        jArr5 = jArr2;
                        length = i11;
                        i15 = i12;
                        j11 = 255;
                        c11 = 7;
                    }
                    jArr = jArr5;
                    int i23 = length;
                    if (i15 != 8) {
                        break;
                    } else {
                        length = i23;
                    }
                } else {
                    jArr = jArr5;
                }
                if (i14 == length) {
                    break;
                }
                i14++;
                jArr5 = jArr;
                j11 = 255;
                c11 = 7;
                j12 = -9187201950435737472L;
            }
        }
        if (!this.f3521j.e()) {
            return;
        }
        MutableScatterSet<RecomposeScopeImpl> mutableScatterSet2 = this.f3521j;
        Object[] objArr4 = mutableScatterSet2.f1898b;
        long[] jArr7 = mutableScatterSet2.f1897a;
        int length3 = jArr7.length - 2;
        if (length3 < 0) {
            return;
        }
        int i24 = 0;
        while (true) {
            long j15 = jArr7[i24];
            if ((((~j15) << 7) & j15 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i25 = 8 - ((~(i24 - length3)) >>> 31);
                for (int i26 = 0; i26 < i25; i26++) {
                    if ((j15 & 255) < 128) {
                        int i27 = (i24 << 3) + i26;
                        if (!((RecomposeScopeImpl) objArr4[i27]).t()) {
                            mutableScatterSet2.y(i27);
                        }
                    }
                    j15 >>= 8;
                }
                if (i25 != 8) {
                    return;
                }
            }
            if (i24 == length3) {
                return;
            } else {
                i24++;
            }
        }
    }
}
