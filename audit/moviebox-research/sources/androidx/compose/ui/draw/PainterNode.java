package androidx.compose.ui.draw;

import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.x1;
import androidx.compose.ui.layout.k0;
import androidx.compose.ui.layout.q0;
import androidx.compose.ui.layout.t;
import androidx.compose.ui.layout.w;
import androidx.compose.ui.layout.y;
import androidx.compose.ui.node.n;
import androidx.compose.ui.node.x;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import q2.p;
import q2.u;

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
public final class PainterNode extends androidx.compose.ui.f.c implements x, n {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Painter f3840o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f3841p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public androidx.compose.ui.b f3842q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public androidx.compose.ui.layout.f f3843r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f3844s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public x1 f3845t;

    public PainterNode(Painter painter, boolean z11, androidx.compose.ui.b bVar, androidx.compose.ui.layout.f fVar, float f11, x1 x1Var) {
        this.f3840o = painter;
        this.f3841p = z11;
        this.f3842q = bVar;
        this.f3843r = fVar;
        this.f3844s = f11;
        this.f3845t = x1Var;
    }

    @Override // androidx.compose.ui.node.n
    public void A(z1.c cVar) {
        long jH = this.f3840o.h();
        long jA = y1.n.a(M1(jH) ? y1.m.i(jH) : y1.m.i(cVar.i()), L1(jH) ? y1.m.g(jH) : y1.m.g(cVar.i()));
        long jB = (y1.m.i(cVar.i()) == 0.0f || y1.m.g(cVar.i()) == 0.0f) ? y1.m.f81091b.b() : q0.b(jA, this.f3843r.a(jA, cVar.i()));
        long jA2 = this.f3842q.a(u.a(Math.round(y1.m.i(jB)), Math.round(y1.m.g(jB))), u.a(Math.round(y1.m.i(cVar.i())), Math.round(y1.m.g(cVar.i()))), cVar.getLayoutDirection());
        float fH = p.h(jA2);
        float fI = p.i(jA2);
        cVar.Q0().c().c(fH, fI);
        try {
            this.f3840o.g(cVar, jB, this.f3844s, this.f3845t);
            cVar.Q0().c().c(-fH, -fI);
            cVar.a1();
        } catch (Throwable th2) {
            cVar.Q0().c().c(-fH, -fI);
            throw th2;
        }
    }

    @Override // androidx.compose.ui.node.x
    public w C(y yVar, t tVar, long j11) {
        final k0 k0VarL = tVar.L(N1(j11));
        return androidx.compose.ui.layout.x.b(yVar, k0VarL.s0(), k0VarL.g0(), null, new Function1<k0.a, Unit>() { // from class: androidx.compose.ui.draw.PainterNode$measure$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(k0.a aVar) {
                invoke2(aVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(k0.a aVar) {
                k0.a.l(aVar, k0VarL, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.node.n
    public /* synthetic */ void F0() {
        androidx.compose.ui.node.m.a(this);
    }

    public final long H1(long j11) {
        if (!K1()) {
            return j11;
        }
        long jA = y1.n.a(!M1(this.f3840o.h()) ? y1.m.i(j11) : y1.m.i(this.f3840o.h()), !L1(this.f3840o.h()) ? y1.m.g(j11) : y1.m.g(this.f3840o.h()));
        return (y1.m.i(j11) == 0.0f || y1.m.g(j11) == 0.0f) ? y1.m.f81091b.b() : q0.b(jA, this.f3843r.a(jA, j11));
    }

    public final Painter I1() {
        return this.f3840o;
    }

    public final boolean J1() {
        return this.f3841p;
    }

    public final boolean K1() {
        return this.f3841p && this.f3840o.h() != 9205357640488583168L;
    }

    public final boolean L1(long j11) {
        if (!y1.m.f(j11, y1.m.f81091b.a())) {
            float fG = y1.m.g(j11);
            if (!Float.isInfinite(fG) && !Float.isNaN(fG)) {
                return true;
            }
        }
        return false;
    }

    public final boolean M1(long j11) {
        if (!y1.m.f(j11, y1.m.f81091b.a())) {
            float fI = y1.m.i(j11);
            if (!Float.isInfinite(fI) && !Float.isNaN(fI)) {
                return true;
            }
        }
        return false;
    }

    public final long N1(long j11) {
        boolean z11 = false;
        boolean z12 = q2.b.h(j11) && q2.b.g(j11);
        if (q2.b.j(j11) && q2.b.i(j11)) {
            z11 = true;
        }
        if ((!K1() && z12) || z11) {
            return q2.b.d(j11, q2.b.l(j11), 0, q2.b.k(j11), 0, 10, null);
        }
        long jH = this.f3840o.h();
        long jH1 = H1(y1.n.a(q2.c.i(j11, M1(jH) ? Math.round(y1.m.i(jH)) : q2.b.n(j11)), q2.c.h(j11, L1(jH) ? Math.round(y1.m.g(jH)) : q2.b.m(j11))));
        return q2.b.d(j11, q2.c.i(j11, Math.round(y1.m.i(jH1))), 0, q2.c.h(j11, Math.round(y1.m.g(jH1))), 0, 10, null);
    }

    public final void O1(androidx.compose.ui.b bVar) {
        this.f3842q = bVar;
    }

    public final void P1(x1 x1Var) {
        this.f3845t = x1Var;
    }

    public final void Q1(androidx.compose.ui.layout.f fVar) {
        this.f3843r = fVar;
    }

    public final void R1(Painter painter) {
        this.f3840o = painter;
    }

    public final void S1(boolean z11) {
        this.f3841p = z11;
    }

    @Override // androidx.compose.ui.f.c
    public boolean m1() {
        return false;
    }

    public final void setAlpha(float f11) {
        this.f3844s = f11;
    }

    public String toString() {
        return "PainterModifier(painter=" + this.f3840o + ", sizeToIntrinsics=" + this.f3841p + ", alignment=" + this.f3842q + ", alpha=" + this.f3844s + ", colorFilter=" + this.f3845t + ')';
    }
}
