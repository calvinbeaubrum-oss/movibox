package androidx.compose.ui.node;

import androidx.collection.MutableScatterSet;
import androidx.compose.ui.layout.PlaceableKt;
import androidx.core.view.ViewCompat;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
public abstract class LookaheadCapablePlaceable extends androidx.compose.ui.layout.k0 implements androidx.compose.ui.layout.y, m0 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f5026o = new a(null);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Function1<c1, Unit> f5027p = new Function1<c1, Unit>() { // from class: androidx.compose.ui.node.LookaheadCapablePlaceable$Companion$onCommitAffectingRuler$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(c1 c1Var) {
            invoke2(c1Var);
            return Unit.f68710a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(c1 c1Var) {
            if (c1Var.isValidOwnerScope()) {
                c1Var.a().F0(c1Var);
            }
        }
    };

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public androidx.compose.ui.layout.o0 f5028g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f5029h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f5030i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f5031j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final androidx.compose.ui.layout.k0.a f5032k = PlaceableKt.a(this);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public androidx.collection.h0<androidx.compose.ui.layout.n0> f5033l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public androidx.collection.h0<androidx.compose.ui.layout.n0> f5034m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public androidx.collection.l0<androidx.compose.ui.layout.n0, MutableScatterSet<WeakReference<LayoutNode>>> f5035n;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements androidx.compose.ui.layout.w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f5036a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f5037b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map<androidx.compose.ui.layout.a, Integer> f5038c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function1<androidx.compose.ui.layout.o0, Unit> f5039d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Function1<androidx.compose.ui.layout.k0.a, Unit> f5040e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ LookaheadCapablePlaceable f5041f;

        /* JADX WARN: Multi-variable type inference failed */
        public b(int i11, int i12, Map<androidx.compose.ui.layout.a, Integer> map, Function1<? super androidx.compose.ui.layout.o0, Unit> function1, Function1<? super androidx.compose.ui.layout.k0.a, Unit> function2, LookaheadCapablePlaceable lookaheadCapablePlaceable) {
            this.f5036a = i11;
            this.f5037b = i12;
            this.f5038c = map;
            this.f5039d = function1;
            this.f5040e = function2;
            this.f5041f = lookaheadCapablePlaceable;
        }

        @Override // androidx.compose.ui.layout.w
        public int getHeight() {
            return this.f5037b;
        }

        @Override // androidx.compose.ui.layout.w
        public int getWidth() {
            return this.f5036a;
        }

        @Override // androidx.compose.ui.layout.w
        public Map<androidx.compose.ui.layout.a, Integer> l() {
            return this.f5038c;
        }

        @Override // androidx.compose.ui.layout.w
        public void m() {
            this.f5040e.invoke(this.f5041f.b1());
        }

        @Override // androidx.compose.ui.layout.w
        public Function1<androidx.compose.ui.layout.o0, Unit> n() {
            return this.f5039d;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements androidx.compose.ui.layout.o0 {
        public c() {
        }

        @Override // q2.e
        public /* synthetic */ float H0(float f11) {
            return q2.d.b(this, f11);
        }

        @Override // q2.n
        public /* synthetic */ long M(float f11) {
            return q2.m.b(this, f11);
        }

        @Override // q2.n
        public float M0() {
            return LookaheadCapablePlaceable.this.M0();
        }

        @Override // q2.e
        public /* synthetic */ float N0(float f11) {
            return q2.d.d(this, f11);
        }

        @Override // q2.n
        public /* synthetic */ float O(long j11) {
            return q2.m.a(this, j11);
        }

        @Override // q2.e
        public /* synthetic */ long V0(long j11) {
            return q2.d.e(this, j11);
        }

        @Override // q2.e
        public /* synthetic */ long X(float f11) {
            return q2.d.f(this, f11);
        }

        @Override // q2.e
        public float getDensity() {
            return LookaheadCapablePlaceable.this.getDensity();
        }

        @Override // q2.e
        public /* synthetic */ int k0(float f11) {
            return q2.d.a(this, f11);
        }

        @Override // q2.e
        public /* synthetic */ float p0(long j11) {
            return q2.d.c(this, j11);
        }
    }

    public abstract int E0(androidx.compose.ui.layout.a aVar);

    /* JADX WARN: Code duplicated, block: B:20:0x005b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:21:0x005d A[LOOP:0: B:11:0x002a->B:21:0x005d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:53:0x00fe A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:54:0x0100 A[LOOP:2: B:38:0x00ab->B:54:0x0100, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:79:0x0060 A[EDGE_INSN: B:79:0x0060->B:22:0x0060 BREAK  A[LOOP:0: B:11:0x002a->B:21:0x005d], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:84:0x010b A[EDGE_INSN: B:84:0x010b->B:55:0x010b BREAK  A[LOOP:2: B:38:0x00ab->B:54:0x0100], SYNTHETIC] */
    public final void F0(final c1 c1Var) {
        LookaheadCapablePlaceable lookaheadCapablePlaceableZ0;
        MutableScatterSet<WeakReference<LayoutNode>> mutableScatterSetO;
        OwnerSnapshotObserver snapshotObserver;
        if (this.f5031j) {
            return;
        }
        Function1<androidx.compose.ui.layout.o0, Unit> function1N = c1Var.b().n();
        androidx.collection.l0<androidx.compose.ui.layout.n0, MutableScatterSet<WeakReference<LayoutNode>>> l0Var = this.f5035n;
        char c11 = 7;
        long j11 = -9187201950435737472L;
        if (function1N == null) {
            if (l0Var != null) {
                Object[] objArr = l0Var.f1984c;
                long[] jArr = l0Var.f1982a;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i11 = 0;
                    while (true) {
                        long j12 = jArr[i11];
                        if ((((~j12) << 7) & j12 & (-9187201950435737472L)) == -9187201950435737472L) {
                            if (i11 != length) {
                                break;
                                break;
                            }
                            i11++;
                        } else {
                            int i12 = 8 - ((~(i11 - length)) >>> 31);
                            for (int i13 = 0; i13 < i12; i13++) {
                                if ((j12 & 255) < 128) {
                                    k1((MutableScatterSet) objArr[(i11 << 3) + i13]);
                                }
                                j12 >>= 8;
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
                l0Var.h();
                return;
            }
            return;
        }
        androidx.collection.h0<androidx.compose.ui.layout.n0> h0Var = this.f5034m;
        if (h0Var == null) {
            h0Var = new androidx.collection.h0<>(0, 1, null);
            this.f5034m = h0Var;
        }
        androidx.collection.h0<androidx.compose.ui.layout.n0> h0Var2 = this.f5033l;
        if (h0Var2 == null) {
            h0Var2 = new androidx.collection.h0<>(0, 1, null);
            this.f5033l = h0Var2;
        }
        h0Var.p(h0Var2);
        h0Var2.i();
        y0 y0VarG0 = X0().g0();
        if (y0VarG0 != null && (snapshotObserver = y0VarG0.getSnapshotObserver()) != null) {
            snapshotObserver.i(c1Var, f5027p, new Function0<Unit>() { // from class: androidx.compose.ui.node.LookaheadCapablePlaceable$captureRulers$3
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
                    Function1<androidx.compose.ui.layout.o0, Unit> function1N2 = c1Var.b().n();
                    if (function1N2 != null) {
                        function1N2.invoke(this.e1());
                    }
                }
            });
        }
        if (l0Var != null) {
            Object[] objArr2 = h0Var.f1947b;
            float[] fArr = h0Var.f1948c;
            long[] jArr2 = h0Var.f1946a;
            int length2 = jArr2.length - 2;
            if (length2 >= 0) {
                int i14 = 0;
                while (true) {
                    long j13 = jArr2[i14];
                    if ((((~j13) << 7) & j13 & j11) != j11) {
                        int i15 = 8 - ((~(i14 - length2)) >>> 31);
                        long j14 = j13;
                        for (int i16 = 0; i16 < i15; i16++) {
                            if ((j14 & 255) < 128) {
                                int i17 = (i14 << 3) + i16;
                                androidx.compose.ui.layout.n0 n0Var = (androidx.compose.ui.layout.n0) objArr2[i17];
                                if (h0Var2.e(n0Var, Float.NaN) != fArr[i17] && (mutableScatterSetO = l0Var.o(n0Var)) != null) {
                                    k1(mutableScatterSetO);
                                }
                            }
                            j14 >>= 8;
                        }
                        if (i15 != 8) {
                            break;
                        }
                        if (i14 != length2) {
                            break;
                        }
                        i14++;
                        j11 = -9187201950435737472L;
                    } else if (i14 != length2) {
                        break;
                        break;
                    } else {
                        i14++;
                        j11 = -9187201950435737472L;
                    }
                }
            }
        }
        Object[] objArr3 = h0Var2.f1947b;
        long[] jArr3 = h0Var2.f1946a;
        int length3 = jArr3.length - 2;
        if (length3 >= 0) {
            int i18 = 0;
            while (true) {
                long j15 = jArr3[i18];
                if ((((~j15) << c11) & j15 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i19 = 8 - ((~(i18 - length3)) >>> 31);
                    for (int i21 = 0; i21 < i19; i21++) {
                        if ((j15 & 255) < 128) {
                            androidx.compose.ui.layout.n0 n0Var2 = (androidx.compose.ui.layout.n0) objArr3[(i18 << 3) + i21];
                            if (!h0Var.a(n0Var2) && (lookaheadCapablePlaceableZ0 = Z0()) != null) {
                                lookaheadCapablePlaceableZ0.g1(n0Var2);
                            }
                        }
                        j15 >>= 8;
                    }
                    if (i19 != 8) {
                        break;
                    }
                }
                if (i18 == length3) {
                    break;
                }
                i18++;
                c11 = 7;
            }
        }
        h0Var.i();
    }

    @Override // q2.e
    public /* synthetic */ float H0(float f11) {
        return q2.d.b(this, f11);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x004f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:19:0x0051 A[LOOP:0: B:9:0x001a->B:19:0x0051, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:28:0x0054 A[EDGE_INSN: B:28:0x0054->B:20:0x0054 BREAK  A[LOOP:0: B:9:0x001a->B:19:0x0051], SYNTHETIC] */
    public final void J0(androidx.compose.ui.layout.w wVar) {
        if (wVar != null) {
            F0(new c1(wVar, this));
            return;
        }
        androidx.collection.l0<androidx.compose.ui.layout.n0, MutableScatterSet<WeakReference<LayoutNode>>> l0Var = this.f5035n;
        if (l0Var != null) {
            Object[] objArr = l0Var.f1984c;
            long[] jArr = l0Var.f1982a;
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
                                k1((MutableScatterSet) objArr[(i11 << 3) + i13]);
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
        }
        androidx.collection.l0<androidx.compose.ui.layout.n0, MutableScatterSet<WeakReference<LayoutNode>>> l0Var2 = this.f5035n;
        if (l0Var2 != null) {
            l0Var2.h();
        }
        androidx.collection.h0<androidx.compose.ui.layout.n0> h0Var = this.f5033l;
        if (h0Var != null) {
            h0Var.i();
        }
    }

    public final LookaheadCapablePlaceable L0(androidx.compose.ui.layout.n0 n0Var) {
        LookaheadCapablePlaceable lookaheadCapablePlaceableZ0;
        LookaheadCapablePlaceable lookaheadCapablePlaceable = this;
        while (true) {
            androidx.collection.h0<androidx.compose.ui.layout.n0> h0Var = lookaheadCapablePlaceable.f5033l;
            if ((h0Var != null && h0Var.a(n0Var)) || (lookaheadCapablePlaceableZ0 = lookaheadCapablePlaceable.Z0()) == null) {
                return lookaheadCapablePlaceable;
            }
            lookaheadCapablePlaceable = lookaheadCapablePlaceableZ0;
        }
    }

    @Override // q2.n
    public /* synthetic */ long M(float f11) {
        return q2.m.b(this, f11);
    }

    @Override // q2.e
    public /* synthetic */ float N0(float f11) {
        return q2.d.d(this, f11);
    }

    @Override // q2.n
    public /* synthetic */ float O(long j11) {
        return q2.m.a(this, j11);
    }

    public final int O0(androidx.compose.ui.layout.a aVar) {
        int iE0;
        if (W0() && (iE0 = E0(aVar)) != Integer.MIN_VALUE) {
            return iE0 + q2.p.i(e0());
        }
        return Integer.MIN_VALUE;
    }

    public abstract LookaheadCapablePlaceable R0();

    @Override // androidx.compose.ui.layout.y
    public androidx.compose.ui.layout.w S0(int i11, int i12, Map<androidx.compose.ui.layout.a, Integer> map, Function1<? super androidx.compose.ui.layout.o0, Unit> function1, Function1<? super androidx.compose.ui.layout.k0.a, Unit> function2) {
        if (!((i11 & ViewCompat.MEASURED_STATE_MASK) == 0 && ((-16777216) & i12) == 0)) {
            h2.a.b("Size(" + i11 + " x " + i12 + ") is out of range. Each dimension must be between 0 and 16777215.");
        }
        return new b(i11, i12, map, function1, function2, this);
    }

    @Override // androidx.compose.ui.node.m0
    public void T(boolean z11) {
        this.f5029h = z11;
    }

    public abstract androidx.compose.ui.layout.m U0();

    @Override // q2.e
    public /* synthetic */ long V0(long j11) {
        return q2.d.e(this, j11);
    }

    public abstract boolean W0();

    @Override // q2.e
    public /* synthetic */ long X(float f11) {
        return q2.d.f(this, f11);
    }

    public abstract LayoutNode X0();

    public abstract androidx.compose.ui.layout.w Y0();

    public abstract LookaheadCapablePlaceable Z0();

    public final androidx.compose.ui.layout.k0.a b1() {
        return this.f5032k;
    }

    @Override // androidx.compose.ui.layout.k
    public boolean d0() {
        return false;
    }

    public abstract long d1();

    public final androidx.compose.ui.layout.o0 e1() {
        androidx.compose.ui.layout.o0 o0Var = this.f5028g;
        return o0Var == null ? new c() : o0Var;
    }

    public final void f1(NodeCoordinator nodeCoordinator) {
        AlignmentLines alignmentLinesL;
        NodeCoordinator nodeCoordinatorY1 = nodeCoordinator.Y1();
        if (!Intrinsics.b(nodeCoordinatorY1 != null ? nodeCoordinatorY1.X0() : null, nodeCoordinator.X0())) {
            nodeCoordinator.O1().l().m();
            return;
        }
        androidx.compose.ui.node.a aVarC = nodeCoordinator.O1().C();
        if (aVarC == null || (alignmentLinesL = aVarC.l()) == null) {
            return;
        }
        alignmentLinesL.m();
    }

    public final void g1(androidx.compose.ui.layout.n0 n0Var) {
        androidx.collection.l0<androidx.compose.ui.layout.n0, MutableScatterSet<WeakReference<LayoutNode>>> l0Var = L0(n0Var).f5035n;
        MutableScatterSet<WeakReference<LayoutNode>> mutableScatterSetO = l0Var != null ? l0Var.o(n0Var) : null;
        if (mutableScatterSetO != null) {
            k1(mutableScatterSetO);
        }
    }

    public boolean h1() {
        return this.f5029h;
    }

    public final boolean i1() {
        return this.f5031j;
    }

    public final boolean j1() {
        return this.f5030i;
    }

    @Override // q2.e
    public /* synthetic */ int k0(float f11) {
        return q2.d.a(this, f11);
    }

    public final void k1(MutableScatterSet<WeakReference<LayoutNode>> mutableScatterSet) {
        LayoutNode layoutNode;
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
                    if ((255 & j11) < 128 && (layoutNode = (LayoutNode) ((WeakReference) objArr[(i11 << 3) + i13]).get()) != null) {
                        if (d0()) {
                            layoutNode.a1(false);
                        } else {
                            layoutNode.e1(false);
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

    public abstract void l1();

    public final void m1(boolean z11) {
        this.f5031j = z11;
    }

    public final void n1(boolean z11) {
        this.f5030i = z11;
    }

    @Override // q2.e
    public /* synthetic */ float p0(long j11) {
        return q2.d.c(this, j11);
    }

    @Override // androidx.compose.ui.layout.y
    public /* synthetic */ androidx.compose.ui.layout.w y0(int i11, int i12, Map map, Function1 function1) {
        return androidx.compose.ui.layout.x.a(this, i11, i12, map, function1);
    }
}
