package androidx.compose.ui.layout;

import androidx.compose.ui.graphics.e4;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public abstract class k0 implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f4883c = q2.u.a(0, 0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f4884d = PlaceableKt.f4841b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f4885f = q2.p.f74244b.a();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f4886a;

        public static /* synthetic */ void h(a aVar, k0 k0Var, int i11, int i12, float f11, int i13, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: place");
            }
            if ((i13 & 4) != 0) {
                f11 = 0.0f;
            }
            aVar.g(k0Var, i11, i12, f11);
        }

        public static /* synthetic */ void j(a aVar, k0 k0Var, long j11, float f11, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: place-70tqf50");
            }
            if ((i11 & 2) != 0) {
                f11 = 0.0f;
            }
            aVar.i(k0Var, j11, f11);
        }

        public static /* synthetic */ void l(a aVar, k0 k0Var, int i11, int i12, float f11, int i13, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelative");
            }
            if ((i13 & 4) != 0) {
                f11 = 0.0f;
            }
            aVar.k(k0Var, i11, i12, f11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void n(a aVar, k0 k0Var, int i11, int i12, float f11, Function1 function1, int i13, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer");
            }
            float f12 = (i13 & 4) != 0 ? 0.0f : f11;
            if ((i13 & 8) != 0) {
                function1 = PlaceableKt.f4840a;
            }
            aVar.m(k0Var, i11, i12, f12, function1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void q(a aVar, k0 k0Var, long j11, float f11, Function1 function1, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer-aW-9-wM");
            }
            float f12 = (i11 & 2) != 0 ? 0.0f : f11;
            if ((i11 & 4) != 0) {
                function1 = PlaceableKt.f4840a;
            }
            aVar.o(k0Var, j11, f12, function1);
        }

        public static /* synthetic */ void r(a aVar, k0 k0Var, long j11, GraphicsLayer graphicsLayer, float f11, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer-aW-9-wM");
            }
            aVar.p(k0Var, j11, graphicsLayer, (i11 & 4) != 0 ? 0.0f : f11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void t(a aVar, k0 k0Var, int i11, int i12, float f11, Function1 function1, int i13, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer");
            }
            float f12 = (i13 & 4) != 0 ? 0.0f : f11;
            if ((i13 & 8) != 0) {
                function1 = PlaceableKt.f4840a;
            }
            aVar.s(k0Var, i11, i12, f12, function1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void w(a aVar, k0 k0Var, long j11, float f11, Function1 function1, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer-aW-9-wM");
            }
            float f12 = (i11 & 2) != 0 ? 0.0f : f11;
            if ((i11 & 4) != 0) {
                function1 = PlaceableKt.f4840a;
            }
            aVar.u(k0Var, j11, f12, function1);
        }

        public static /* synthetic */ void x(a aVar, k0 k0Var, long j11, GraphicsLayer graphicsLayer, float f11, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer-aW-9-wM");
            }
            aVar.v(k0Var, j11, graphicsLayer, (i11 & 4) != 0 ? 0.0f : f11);
        }

        public abstract LayoutDirection d();

        public abstract int e();

        /* JADX WARN: Multi-variable type inference failed */
        public final void f(k0 k0Var) {
            if (k0Var instanceof androidx.compose.ui.node.m0) {
                ((androidx.compose.ui.node.m0) k0Var).T(this.f4886a);
            }
        }

        public final void g(k0 k0Var, int i11, int i12, float f11) {
            long jA = q2.q.a(i11, i12);
            f(k0Var);
            k0Var.x0(q2.p.l(jA, k0Var.f4885f), f11, null);
        }

        public final void i(k0 k0Var, long j11, float f11) {
            f(k0Var);
            k0Var.x0(q2.p.l(j11, k0Var.f4885f), f11, null);
        }

        public final void k(k0 k0Var, int i11, int i12, float f11) {
            long jA = q2.q.a(i11, i12);
            if (d() == LayoutDirection.Ltr || e() == 0) {
                f(k0Var);
                k0Var.x0(q2.p.l(jA, k0Var.f4885f), f11, null);
            } else {
                long jA2 = q2.q.a((e() - k0Var.s0()) - q2.p.h(jA), q2.p.i(jA));
                f(k0Var);
                k0Var.x0(q2.p.l(jA2, k0Var.f4885f), f11, null);
            }
        }

        public final void m(k0 k0Var, int i11, int i12, float f11, Function1<? super e4, Unit> function1) {
            long jA = q2.q.a(i11, i12);
            if (d() == LayoutDirection.Ltr || e() == 0) {
                f(k0Var);
                k0Var.x0(q2.p.l(jA, k0Var.f4885f), f11, function1);
            } else {
                long jA2 = q2.q.a((e() - k0Var.s0()) - q2.p.h(jA), q2.p.i(jA));
                f(k0Var);
                k0Var.x0(q2.p.l(jA2, k0Var.f4885f), f11, function1);
            }
        }

        public final void o(k0 k0Var, long j11, float f11, Function1<? super e4, Unit> function1) {
            if (d() == LayoutDirection.Ltr || e() == 0) {
                f(k0Var);
                k0Var.x0(q2.p.l(j11, k0Var.f4885f), f11, function1);
            } else {
                long jA = q2.q.a((e() - k0Var.s0()) - q2.p.h(j11), q2.p.i(j11));
                f(k0Var);
                k0Var.x0(q2.p.l(jA, k0Var.f4885f), f11, function1);
            }
        }

        public final void p(k0 k0Var, long j11, GraphicsLayer graphicsLayer, float f11) {
            if (d() == LayoutDirection.Ltr || e() == 0) {
                f(k0Var);
                k0Var.u0(q2.p.l(j11, k0Var.f4885f), f11, graphicsLayer);
            } else {
                long jA = q2.q.a((e() - k0Var.s0()) - q2.p.h(j11), q2.p.i(j11));
                f(k0Var);
                k0Var.u0(q2.p.l(jA, k0Var.f4885f), f11, graphicsLayer);
            }
        }

        public final void s(k0 k0Var, int i11, int i12, float f11, Function1<? super e4, Unit> function1) {
            long jA = q2.q.a(i11, i12);
            f(k0Var);
            k0Var.x0(q2.p.l(jA, k0Var.f4885f), f11, function1);
        }

        public final void u(k0 k0Var, long j11, float f11, Function1<? super e4, Unit> function1) {
            f(k0Var);
            k0Var.x0(q2.p.l(j11, k0Var.f4885f), f11, function1);
        }

        public final void v(k0 k0Var, long j11, GraphicsLayer graphicsLayer, float f11) {
            f(k0Var);
            k0Var.u0(q2.p.l(j11, k0Var.f4885f), f11, graphicsLayer);
        }
    }

    public final void A0(long j11) {
        if (q2.t.e(this.f4883c, j11)) {
            return;
        }
        this.f4883c = j11;
        t0();
    }

    public final void B0(long j11) {
        if (q2.b.f(this.f4884d, j11)) {
            return;
        }
        this.f4884d = j11;
        t0();
    }

    public /* synthetic */ Object F() {
        return z.a(this);
    }

    public final long e0() {
        return this.f4885f;
    }

    public final int g0() {
        return this.f4882b;
    }

    public int h0() {
        return q2.t.f(this.f4883c);
    }

    public final long o0() {
        return this.f4883c;
    }

    public int q0() {
        return q2.t.g(this.f4883c);
    }

    public final long r0() {
        return this.f4884d;
    }

    public final int s0() {
        return this.f4881a;
    }

    public final void t0() {
        this.f4881a = kotlin.ranges.a.k(q2.t.g(this.f4883c), q2.b.n(this.f4884d), q2.b.l(this.f4884d));
        this.f4882b = kotlin.ranges.a.k(q2.t.f(this.f4883c), q2.b.m(this.f4884d), q2.b.k(this.f4884d));
        this.f4885f = q2.q.a((this.f4881a - q2.t.g(this.f4883c)) / 2, (this.f4882b - q2.t.f(this.f4883c)) / 2);
    }

    public void u0(long j11, float f11, GraphicsLayer graphicsLayer) {
        x0(j11, f11, null);
    }

    public abstract void x0(long j11, float f11, Function1<? super e4, Unit> function1);
}
