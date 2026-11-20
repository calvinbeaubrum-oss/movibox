package androidx.compose.runtime;

import androidx.collection.ScatterSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public final class RecomposeScopeImpl implements g2, u1 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f3302h = new a(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f3303i = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public w1 f3305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f3306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function2<? super i, ? super Integer, Unit> f3307d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3308e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public androidx.collection.i0<Object> f3309f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public androidx.collection.l0<z<?>, Object> f3310g;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(m2 m2Var, List<c> list, w1 w1Var) {
            if (!list.isEmpty()) {
                int size = list.size();
                for (int i11 = 0; i11 < size; i11++) {
                    Object objB1 = m2Var.b1(list.get(i11), 0);
                    RecomposeScopeImpl recomposeScopeImpl = objB1 instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) objB1 : null;
                    if (recomposeScopeImpl != null) {
                        recomposeScopeImpl.e(w1Var);
                    }
                }
            }
        }

        public final boolean b(j2 j2Var, List<c> list) {
            if (!list.isEmpty()) {
                int size = list.size();
                for (int i11 = 0; i11 < size; i11++) {
                    c cVar = list.get(i11);
                    if (j2Var.F(cVar) && (j2Var.H(j2Var.e(cVar), 0) instanceof RecomposeScopeImpl)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public RecomposeScopeImpl(w1 w1Var) {
        this.f3305b = w1Var;
    }

    public final void A(c cVar) {
        this.f3306c = cVar;
    }

    public final void B(boolean z11) {
        if (z11) {
            this.f3304a |= 2;
        } else {
            this.f3304a &= -3;
        }
    }

    public final void C(boolean z11) {
        if (z11) {
            this.f3304a |= 4;
        } else {
            this.f3304a &= -5;
        }
    }

    public final void D(boolean z11) {
        if (z11) {
            this.f3304a |= 64;
        } else {
            this.f3304a &= -65;
        }
    }

    public final void E(boolean z11) {
        if (z11) {
            this.f3304a |= 8;
        } else {
            this.f3304a &= -9;
        }
    }

    public final void F(boolean z11) {
        if (z11) {
            this.f3304a |= 32;
        } else {
            this.f3304a &= -33;
        }
    }

    public final void G(boolean z11) {
        if (z11) {
            this.f3304a |= 16;
        } else {
            this.f3304a &= -17;
        }
    }

    public final void H(boolean z11) {
        if (z11) {
            this.f3304a |= 1;
        } else {
            this.f3304a &= -2;
        }
    }

    public final void I(int i11) {
        this.f3308e = i11;
        G(false);
    }

    @Override // androidx.compose.runtime.g2
    public void a(Function2<? super i, ? super Integer, Unit> function2) {
        this.f3307d = function2;
    }

    public final void e(w1 w1Var) {
        this.f3305b = w1Var;
    }

    public final boolean f(z<?> zVar, androidx.collection.l0<z<?>, Object> l0Var) {
        Intrinsics.e(zVar, "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>");
        q2<?> policy = zVar.getPolicy();
        if (policy == null) {
            policy = r2.j();
        }
        return !policy.b(zVar.d().a(), l0Var.b(zVar));
    }

    public final void g(i iVar) {
        Unit unit;
        Function2<? super i, ? super Integer, Unit> function2 = this.f3307d;
        if (function2 != null) {
            function2.invoke(iVar, 1);
            unit = Unit.f68710a;
        } else {
            unit = null;
        }
        if (unit == null) {
            throw new IllegalStateException("Invalid restart scope".toString());
        }
    }

    public final Function1<l, Unit> h(final int i11) {
        final androidx.collection.i0<Object> i0Var = this.f3309f;
        if (i0Var == null || p()) {
            return null;
        }
        Object[] objArr = i0Var.f1957b;
        int[] iArr = i0Var.f1958c;
        long[] jArr = i0Var.f1956a;
        int length = jArr.length - 2;
        if (length < 0) {
            return null;
        }
        int i12 = 0;
        while (true) {
            long j11 = jArr[i12];
            if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i13 = 8 - ((~(i12 - length)) >>> 31);
                for (int i14 = 0; i14 < i13; i14++) {
                    if ((255 & j11) < 128) {
                        int i15 = (i12 << 3) + i14;
                        Object obj = objArr[i15];
                        if (iArr[i15] != i11) {
                            return new Function1<l, Unit>() { // from class: androidx.compose.runtime.RecomposeScopeImpl$end$1$2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(l lVar) {
                                    invoke2(lVar);
                                    return Unit.f68710a;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(l lVar) {
                                    if (this.this$0.f3308e != i11 || !Intrinsics.b(i0Var, this.this$0.f3309f) || !(lVar instanceof o)) {
                                        return;
                                    }
                                    androidx.collection.i0<Object> i0Var2 = i0Var;
                                    int i16 = i11;
                                    RecomposeScopeImpl recomposeScopeImpl = this.this$0;
                                    long[] jArr2 = i0Var2.f1956a;
                                    int length2 = jArr2.length - 2;
                                    if (length2 < 0) {
                                        return;
                                    }
                                    int i17 = 0;
                                    while (true) {
                                        long j12 = jArr2[i17];
                                        if ((((~j12) << 7) & j12 & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i18 = 8 - ((~(i17 - length2)) >>> 31);
                                            for (int i19 = 0; i19 < i18; i19++) {
                                                if ((255 & j12) < 128) {
                                                    int i21 = (i17 << 3) + i19;
                                                    Object obj2 = i0Var2.f1957b[i21];
                                                    boolean z11 = i0Var2.f1958c[i21] != i16;
                                                    if (z11) {
                                                        o oVar = (o) lVar;
                                                        oVar.J(obj2, recomposeScopeImpl);
                                                        if (obj2 instanceof z) {
                                                            oVar.I((z) obj2);
                                                            androidx.collection.l0 l0Var = recomposeScopeImpl.f3310g;
                                                            if (l0Var != null) {
                                                                l0Var.o(obj2);
                                                            }
                                                        }
                                                    }
                                                    if (z11) {
                                                        i0Var2.q(i21);
                                                    }
                                                }
                                                j12 >>= 8;
                                            }
                                            if (i18 != 8) {
                                                return;
                                            }
                                        }
                                        if (i17 == length2) {
                                            return;
                                        } else {
                                            i17++;
                                        }
                                    }
                                }
                            };
                        }
                    }
                    j11 >>= 8;
                }
                if (i13 != 8) {
                    return null;
                }
            }
            if (i12 == length) {
                return null;
            }
            i12++;
        }
    }

    public final c i() {
        return this.f3306c;
    }

    @Override // androidx.compose.runtime.u1
    public void invalidate() {
        w1 w1Var = this.f3305b;
        if (w1Var != null) {
            w1Var.k(this, null);
        }
    }

    public final boolean j() {
        return this.f3307d != null;
    }

    public final boolean k() {
        return (this.f3304a & 2) != 0;
    }

    public final boolean l() {
        return (this.f3304a & 4) != 0;
    }

    public final boolean m() {
        return (this.f3304a & 64) != 0;
    }

    public final boolean n() {
        return (this.f3304a & 8) != 0;
    }

    public final boolean o() {
        return (this.f3304a & 32) != 0;
    }

    public final boolean p() {
        return (this.f3304a & 16) != 0;
    }

    public final boolean q() {
        return (this.f3304a & 1) != 0;
    }

    public final boolean r() {
        c cVar;
        return (this.f3305b == null || (cVar = this.f3306c) == null || !cVar.b()) ? false : true;
    }

    public final InvalidationResult s(Object obj) {
        InvalidationResult invalidationResultK;
        w1 w1Var = this.f3305b;
        return (w1Var == null || (invalidationResultK = w1Var.k(this, obj)) == null) ? InvalidationResult.IGNORED : invalidationResultK;
    }

    public final boolean t() {
        return this.f3310g != null;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x006c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:32:0x006e A[LOOP:0: B:18:0x002f->B:32:0x006e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:38:0x0071 A[SYNTHETIC] */
    public final boolean u(Object obj) {
        androidx.collection.l0<z<?>, Object> l0Var;
        if (obj == null || (l0Var = this.f3310g) == null) {
            return true;
        }
        if (obj instanceof z) {
            return f((z) obj, l0Var);
        }
        if (!(obj instanceof ScatterSet)) {
            return true;
        }
        ScatterSet scatterSet = (ScatterSet) obj;
        if (scatterSet.e()) {
            Object[] objArr = scatterSet.f1898b;
            long[] jArr = scatterSet.f1897a;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i11 = 0;
                while (true) {
                    long j11 = jArr[i11];
                    if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i12 = 8 - ((~(i11 - length)) >>> 31);
                        for (int i13 = 0; i13 < i12; i13++) {
                            if ((255 & j11) < 128) {
                                Object obj2 = objArr[(i11 << 3) + i13];
                                if (!(obj2 instanceof z) || f((z) obj2, l0Var)) {
                                    return true;
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
            }
        }
        return false;
    }

    public final void v(z<?> zVar, Object obj) {
        androidx.collection.l0<z<?>, Object> l0Var = this.f3310g;
        if (l0Var == null) {
            l0Var = new androidx.collection.l0<>(0, 1, null);
            this.f3310g = l0Var;
        }
        l0Var.r(zVar, obj);
    }

    public final boolean w(Object obj) {
        int i11 = 0;
        if (o()) {
            return false;
        }
        androidx.collection.i0<Object> i0Var = this.f3309f;
        int i12 = 1;
        if (i0Var == null) {
            i0Var = new androidx.collection.i0<>(i11, i12, null);
            this.f3309f = i0Var;
        }
        return i0Var.p(obj, this.f3308e, -1) == this.f3308e;
    }

    public final void x() {
        w1 w1Var = this.f3305b;
        if (w1Var != null) {
            w1Var.h(this);
        }
        this.f3305b = null;
        this.f3309f = null;
        this.f3310g = null;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0053 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:23:0x0055 A[LOOP:0: B:10:0x001b->B:23:0x0055, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:31:0x0058 A[EDGE_INSN: B:31:0x0058->B:24:0x0058 BREAK  A[LOOP:0: B:10:0x001b->B:23:0x0055], SYNTHETIC] */
    public final void y() {
        androidx.collection.i0<Object> i0Var;
        w1 w1Var = this.f3305b;
        if (w1Var == null || (i0Var = this.f3309f) == null) {
            return;
        }
        F(true);
        try {
            Object[] objArr = i0Var.f1957b;
            int[] iArr = i0Var.f1958c;
            long[] jArr = i0Var.f1956a;
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
                                int i14 = (i11 << 3) + i13;
                                Object obj = objArr[i14];
                                int i15 = iArr[i14];
                                w1Var.a(obj);
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
        } finally {
            F(false);
        }
    }

    public final void z() {
        G(true);
    }
}
