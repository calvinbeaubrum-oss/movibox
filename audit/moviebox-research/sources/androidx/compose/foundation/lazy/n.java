package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.k0;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class n implements j, androidx.compose.foundation.lazy.layout.s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<k0> f2774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f2775c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.compose.ui.b.InterfaceC0052b f2776d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final androidx.compose.ui.b.c f2777e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LayoutDirection f2778f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f2779g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f2780h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f2781i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f2782j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f2783k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Object f2784l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Object f2785m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final LazyLayoutItemAnimator<n> f2786n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final long f2787o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f2788p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f2789q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f2790r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f2791s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f2792t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f2793u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f2794v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f2795w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f2796x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f2797y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int[] f2798z;

    /* JADX WARN: Multi-variable type inference failed */
    public n(int i11, List<? extends k0> list, boolean z11, androidx.compose.ui.b.InterfaceC0052b interfaceC0052b, androidx.compose.ui.b.c cVar, LayoutDirection layoutDirection, boolean z12, int i12, int i13, int i14, long j11, Object obj, Object obj2, LazyLayoutItemAnimator<n> lazyLayoutItemAnimator, long j12) {
        this.f2773a = i11;
        this.f2774b = list;
        this.f2775c = z11;
        this.f2776d = interfaceC0052b;
        this.f2777e = cVar;
        this.f2778f = layoutDirection;
        this.f2779g = z12;
        this.f2780h = i12;
        this.f2781i = i13;
        this.f2782j = i14;
        this.f2783k = j11;
        this.f2784l = obj;
        this.f2785m = obj2;
        this.f2786n = lazyLayoutItemAnimator;
        this.f2787o = j12;
        this.f2791s = 1;
        this.f2795w = Integer.MIN_VALUE;
        int size = list.size();
        int iG0 = 0;
        int iMax = 0;
        for (int i15 = 0; i15 < size; i15++) {
            k0 k0Var = (k0) list.get(i15);
            iG0 += e() ? k0Var.g0() : k0Var.s0();
            iMax = Math.max(iMax, !e() ? k0Var.g0() : k0Var.s0());
        }
        this.f2789q = iG0;
        this.f2792t = kotlin.ranges.a.d(getSize() + this.f2782j, 0);
        this.f2793u = iMax;
        this.f2798z = new int[this.f2774b.size() * 2];
    }

    public /* synthetic */ n(int i11, List list, boolean z11, androidx.compose.ui.b.InterfaceC0052b interfaceC0052b, androidx.compose.ui.b.c cVar, LayoutDirection layoutDirection, boolean z12, int i12, int i13, int i14, long j11, Object obj, Object obj2, LazyLayoutItemAnimator lazyLayoutItemAnimator, long j12, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, list, z11, interfaceC0052b, cVar, layoutDirection, z12, i12, i13, i14, j11, obj, obj2, lazyLayoutItemAnimator, j12);
    }

    @Override // androidx.compose.foundation.lazy.layout.s
    public long a() {
        return this.f2787o;
    }

    @Override // androidx.compose.foundation.lazy.layout.s
    public int b() {
        return this.f2774b.size();
    }

    @Override // androidx.compose.foundation.lazy.layout.s
    public void c(boolean z11) {
        this.f2794v = z11;
    }

    @Override // androidx.compose.foundation.lazy.layout.s
    public int d() {
        return this.f2791s;
    }

    @Override // androidx.compose.foundation.lazy.layout.s
    public boolean e() {
        return this.f2775c;
    }

    @Override // androidx.compose.foundation.lazy.layout.s
    public void f(int i11, int i12, int i13, int i14) {
        r(i11, i13, i14);
    }

    @Override // androidx.compose.foundation.lazy.j
    public int g() {
        return this.f2788p;
    }

    @Override // androidx.compose.foundation.lazy.j, androidx.compose.foundation.lazy.layout.s
    public int getIndex() {
        return this.f2773a;
    }

    @Override // androidx.compose.foundation.lazy.layout.s
    public Object getKey() {
        return this.f2784l;
    }

    @Override // androidx.compose.foundation.lazy.j
    public int getSize() {
        return this.f2789q;
    }

    @Override // androidx.compose.foundation.lazy.layout.s
    public int h() {
        return this.f2792t;
    }

    @Override // androidx.compose.foundation.lazy.layout.s
    public Object i(int i11) {
        return this.f2774b.get(i11).F();
    }

    @Override // androidx.compose.foundation.lazy.layout.s
    public long j(int i11) {
        int[] iArr = this.f2798z;
        int i12 = i11 * 2;
        return q2.q.a(iArr[i12], iArr[i12 + 1]);
    }

    @Override // androidx.compose.foundation.lazy.layout.s
    public int k() {
        return this.f2790r;
    }

    public final void l(int i11, boolean z11) {
        if (p()) {
            return;
        }
        this.f2788p = g() + i11;
        int length = this.f2798z.length;
        for (int i12 = 0; i12 < length; i12++) {
            if ((e() && i12 % 2 == 1) || (!e() && i12 % 2 == 0)) {
                int[] iArr = this.f2798z;
                iArr[i12] = iArr[i12] + i11;
            }
        }
        if (z11) {
            int iB = b();
            for (int i13 = 0; i13 < iB; i13++) {
                LazyLayoutItemAnimation lazyLayoutItemAnimationE = this.f2786n.e(getKey(), i13);
                if (lazyLayoutItemAnimationE != null) {
                    long jS = lazyLayoutItemAnimationE.s();
                    int iH = e() ? q2.p.h(jS) : Integer.valueOf(q2.p.h(jS) + i11).intValue();
                    boolean zE = e();
                    int i14 = q2.p.i(jS);
                    if (zE) {
                        i14 += i11;
                    }
                    lazyLayoutItemAnimationE.J(q2.q.a(iH, i14));
                }
            }
        }
    }

    public final int m() {
        return this.f2793u;
    }

    public final int n(long j11) {
        return e() ? q2.p.i(j11) : q2.p.h(j11);
    }

    public final int o(k0 k0Var) {
        return e() ? k0Var.g0() : k0Var.s0();
    }

    public boolean p() {
        return this.f2794v;
    }

    public final void q(k0.a aVar, boolean z11) {
        GraphicsLayer graphicsLayerP;
        if (this.f2795w == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("position() should be called first".toString());
        }
        int iB = b();
        for (int i11 = 0; i11 < iB; i11++) {
            k0 k0Var = this.f2774b.get(i11);
            int iO = this.f2796x - o(k0Var);
            int i12 = this.f2797y;
            long j11 = j(i11);
            LazyLayoutItemAnimation lazyLayoutItemAnimationE = this.f2786n.e(getKey(), i11);
            if (lazyLayoutItemAnimationE != null) {
                if (z11) {
                    lazyLayoutItemAnimationE.F(j11);
                } else {
                    if (!q2.p.g(lazyLayoutItemAnimationE.q(), LazyLayoutItemAnimation.f2599s.a())) {
                        j11 = lazyLayoutItemAnimationE.q();
                    }
                    long jL = q2.p.l(j11, lazyLayoutItemAnimationE.r());
                    if ((n(j11) <= iO && n(jL) <= iO) || (n(j11) >= i12 && n(jL) >= i12)) {
                        lazyLayoutItemAnimationE.n();
                    }
                    j11 = jL;
                }
                graphicsLayerP = lazyLayoutItemAnimationE.p();
            } else {
                graphicsLayerP = null;
            }
            if (this.f2779g) {
                j11 = q2.q.a(e() ? q2.p.h(j11) : (this.f2795w - q2.p.h(j11)) - o(k0Var), e() ? (this.f2795w - q2.p.i(j11)) - o(k0Var) : q2.p.i(j11));
            }
            long jL2 = q2.p.l(j11, this.f2783k);
            if (!z11 && lazyLayoutItemAnimationE != null) {
                lazyLayoutItemAnimationE.E(jL2);
            }
            if (e()) {
                if (graphicsLayerP != null) {
                    k0.a.x(aVar, k0Var, jL2, graphicsLayerP, 0.0f, 4, null);
                } else {
                    k0.a.w(aVar, k0Var, jL2, 0.0f, null, 6, null);
                }
            } else if (graphicsLayerP != null) {
                k0.a.r(aVar, k0Var, jL2, graphicsLayerP, 0.0f, 4, null);
            } else {
                k0.a.q(aVar, k0Var, jL2, 0.0f, null, 6, null);
            }
        }
    }

    public final void r(int i11, int i12, int i13) {
        int iS0;
        this.f2788p = i11;
        this.f2795w = e() ? i13 : i12;
        List<k0> list = this.f2774b;
        int size = list.size();
        for (int i14 = 0; i14 < size; i14++) {
            k0 k0Var = list.get(i14);
            int i15 = i14 * 2;
            if (e()) {
                int[] iArr = this.f2798z;
                androidx.compose.ui.b.InterfaceC0052b interfaceC0052b = this.f2776d;
                if (interfaceC0052b == null) {
                    throw new IllegalArgumentException("null horizontalAlignment when isVertical == true".toString());
                }
                iArr[i15] = interfaceC0052b.a(k0Var.s0(), i12, this.f2778f);
                this.f2798z[i15 + 1] = i11;
                iS0 = k0Var.g0();
            } else {
                int[] iArr2 = this.f2798z;
                iArr2[i15] = i11;
                int i16 = i15 + 1;
                androidx.compose.ui.b.c cVar = this.f2777e;
                if (cVar == null) {
                    throw new IllegalArgumentException("null verticalAlignment when isVertical == false".toString());
                }
                iArr2[i16] = cVar.a(k0Var.g0(), i13);
                iS0 = k0Var.s0();
            }
            i11 += iS0;
        }
        this.f2796x = -this.f2780h;
        this.f2797y = this.f2795w + this.f2781i;
    }

    public final void s(int i11) {
        this.f2795w = i11;
        this.f2797y = i11 + this.f2781i;
    }
}
