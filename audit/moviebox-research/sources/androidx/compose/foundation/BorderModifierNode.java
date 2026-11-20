package androidx.compose.foundation;

import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.c5;
import androidx.compose.ui.graphics.d5;
import androidx.compose.ui.graphics.e1;
import androidx.compose.ui.graphics.g4;
import androidx.compose.ui.graphics.h4;
import androidx.compose.ui.graphics.i4;
import androidx.compose.ui.graphics.l1;
import androidx.compose.ui.graphics.m4;
import androidx.compose.ui.graphics.o1;
import androidx.compose.ui.graphics.q1;
import androidx.compose.ui.graphics.q4;
import androidx.compose.ui.graphics.u4;
import androidx.compose.ui.graphics.v1;
import androidx.compose.ui.graphics.w1;
import androidx.compose.ui.graphics.x1;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class BorderModifierNode extends androidx.compose.ui.node.i {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public c f2199q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f2200r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public l1 f2201s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public c5 f2202t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final androidx.compose.ui.draw.b f2203u;

    public BorderModifierNode(float f11, l1 l1Var, c5 c5Var) {
        this.f2200r = f11;
        this.f2201s = l1Var;
        this.f2202t = c5Var;
        this.f2203u = (androidx.compose.ui.draw.b) H1(androidx.compose.ui.draw.h.a(new Function1<androidx.compose.ui.draw.c, androidx.compose.ui.draw.i>() { // from class: androidx.compose.foundation.BorderModifierNode$drawWithCacheModifierNode$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final androidx.compose.ui.draw.i invoke(androidx.compose.ui.draw.c cVar) {
                if (cVar.N0(this.this$0.T1()) < 0.0f || y1.m.h(cVar.i()) <= 0.0f) {
                    return BorderKt.i(cVar);
                }
                float f12 = 2;
                float fMin = Math.min(q2.i.j(this.this$0.T1(), q2.i.f74232b.a()) ? 1.0f : (float) Math.ceil(cVar.N0(this.this$0.T1())), (float) Math.ceil(y1.m.h(cVar.i()) / f12));
                float f13 = fMin / f12;
                long jA = y1.h.a(f13, f13);
                long jA2 = y1.n.a(y1.m.i(cVar.i()) - fMin, y1.m.g(cVar.i()) - fMin);
                boolean z11 = f12 * fMin > y1.m.h(cVar.i());
                m4 m4VarA = this.this$0.S1().a(cVar.i(), cVar.getLayoutDirection(), cVar);
                if (m4VarA instanceof m4.a) {
                    BorderModifierNode borderModifierNode = this.this$0;
                    return borderModifierNode.P1(cVar, borderModifierNode.R1(), (m4.a) m4VarA, z11, fMin);
                }
                if (m4VarA instanceof m4.c) {
                    BorderModifierNode borderModifierNode2 = this.this$0;
                    return borderModifierNode2.Q1(cVar, borderModifierNode2.R1(), (m4.c) m4VarA, jA, jA2, z11, fMin);
                }
                if (m4VarA instanceof m4.b) {
                    return BorderKt.j(cVar, this.this$0.R1(), jA, jA2, z11, fMin);
                }
                throw new NoWhenBranchMatchedException();
            }
        }));
    }

    public /* synthetic */ BorderModifierNode(float f11, l1 l1Var, c5 c5Var, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, l1Var, c5Var);
    }

    public final void K0(c5 c5Var) {
        if (Intrinsics.b(this.f2202t, c5Var)) {
            return;
        }
        this.f2202t = c5Var;
        this.f2203u.x0();
    }

    /* JADX WARN: Code duplicated, block: B:27:0x00dc  */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4, types: [T, androidx.compose.ui.graphics.g4] */
    public final androidx.compose.ui.draw.i P1(androidx.compose.ui.draw.c cVar, final l1 l1Var, final m4.a aVar, boolean z11, float f11) throws Throwable {
        int iB;
        x1 x1VarB;
        boolean z12;
        o1 o1Var;
        ?? r12;
        float f12;
        long j11;
        z1.d dVar;
        if (z11) {
            return cVar.l(new Function1<z1.c, Unit>() { // from class: androidx.compose.foundation.BorderModifierNode$drawGenericBorder$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(z1.c cVar2) {
                    invoke2(cVar2);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(z1.c cVar2) {
                    cVar2.a1();
                    z1.f.g(cVar2, aVar.b(), l1Var, 0.0f, null, null, 0, 60, null);
                }
            });
        }
        if (l1Var instanceof d5) {
            iB = h4.f4148b.a();
            x1VarB = x1.a.b(x1.f4581b, ((d5) l1Var).b(), 0, 2, null);
        } else {
            iB = h4.f4148b.b();
            x1VarB = null;
        }
        final y1.i bounds = aVar.b().getBounds();
        if (this.f2199q == null) {
            this.f2199q = new c(null, null, null, null, 15, null);
        }
        c cVar2 = this.f2199q;
        Intrinsics.d(cVar2);
        Path pathG = cVar2.g();
        pathG.reset();
        q4.a(pathG, bounds, null, 2, null);
        pathG.l(pathG, aVar.b(), u4.f4354a.a());
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final long jA = q2.u.a((int) Math.ceil(bounds.k()), (int) Math.ceil(bounds.e()));
        c cVar3 = this.f2199q;
        Intrinsics.d(cVar3);
        g4 g4Var = cVar3.f2259a;
        o1 o1Var2 = cVar3.f2260b;
        h4 h4VarF = g4Var != null ? h4.f(g4Var.b()) : null;
        int iB2 = h4.f4148b.b();
        if (h4VarF != null && h4.i(h4VarF.l(), iB2)) {
            z12 = true;
        } else {
            if (h4.h(iB, g4Var != null ? h4.f(g4Var.b()) : null)) {
                z12 = true;
            } else {
                z12 = false;
            }
        }
        if (g4Var == null || o1Var2 == null || y1.m.i(cVar.i()) > g4Var.getWidth() || y1.m.g(cVar.i()) > g4Var.getHeight() || !z12) {
            g4 g4VarB = i4.b(q2.t.g(jA), q2.t.f(jA), iB, false, null, 24, null);
            cVar3.f2259a = g4VarB;
            o1 o1VarA = q1.a(g4VarB);
            cVar3.f2260b = o1VarA;
            o1Var = o1VarA;
            r12 = g4VarB;
        } else {
            r12 = g4Var;
            o1Var = o1Var2;
        }
        z1.a aVar2 = cVar3.f2261c;
        if (aVar2 == null) {
            aVar2 = new z1.a();
            cVar3.f2261c = aVar2;
        }
        z1.a aVar3 = aVar2;
        long jD = q2.u.d(jA);
        LayoutDirection layoutDirection = cVar.getLayoutDirection();
        z1.a.C0925a c0925aD = aVar3.D();
        q2.e eVarA = c0925aD.a();
        LayoutDirection layoutDirectionB = c0925aD.b();
        o1 o1VarC = c0925aD.c();
        long jD2 = c0925aD.d();
        z1.a.C0925a c0925aD2 = aVar3.D();
        c0925aD2.j(cVar);
        c0925aD2.k(layoutDirection);
        c0925aD2.i(o1Var);
        c0925aD2.l(jD);
        o1Var.d();
        long jA2 = w1.f4564b.a();
        e1.a aVar4 = e1.f4102a;
        z1.f.j(aVar3, jA2, 0L, jD, 0.0f, null, null, aVar4.a(), 58, null);
        float f13 = -bounds.f();
        float f14 = -bounds.i();
        aVar3.Q0().c().c(f13, f14);
        try {
            f14 = f14;
            f12 = f13;
            try {
                z1.f.g(aVar3, aVar.b(), l1Var, 0.0f, new z1.m(f11 * 2, 0.0f, 0, 0, null, 30, null), null, 0, 52, null);
                float f15 = 1;
                float fI = (y1.m.i(aVar3.i()) + f15) / y1.m.i(aVar3.i());
                float fG = (y1.m.g(aVar3.i()) + f15) / y1.m.g(aVar3.i());
                long jT0 = aVar3.T0();
                z1.d dVarQ0 = aVar3.Q0();
                long jI = dVarQ0.i();
                dVarQ0.e().d();
                try {
                    dVarQ0.c().e(fI, fG, jT0);
                    dVar = dVarQ0;
                    try {
                        z1.f.g(aVar3, pathG, l1Var, 0.0f, null, null, aVar4.a(), 28, null);
                        dVar.e().k();
                        dVar.f(jI);
                        aVar3.Q0().c().c(-f12, -f14);
                        o1Var.k();
                        z1.a.C0925a c0925aD3 = aVar3.D();
                        c0925aD3.j(eVarA);
                        c0925aD3.k(layoutDirectionB);
                        c0925aD3.i(o1VarC);
                        c0925aD3.l(jD2);
                        r12.a();
                        objectRef.element = r12;
                        final x1 x1Var = x1VarB;
                        return cVar.l(new Function1<z1.c, Unit>() { // from class: androidx.compose.foundation.BorderModifierNode$drawGenericBorder$3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(z1.c cVar4) {
                                invoke2(cVar4);
                                return Unit.f68710a;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(z1.c cVar4) {
                                cVar4.a1();
                                float f16 = bounds.f();
                                float fI2 = bounds.i();
                                Ref.ObjectRef<g4> objectRef2 = objectRef;
                                long j12 = jA;
                                x1 x1Var2 = x1Var;
                                cVar4.Q0().c().c(f16, fI2);
                                try {
                                    z1.f.e(cVar4, objectRef2.element, 0L, j12, 0L, 0L, 0.0f, null, x1Var2, 0, 0, 890, null);
                                } finally {
                                    cVar4.Q0().c().c(-f16, -fI2);
                                }
                            }
                        });
                    } catch (Throwable th2) {
                        th = th2;
                        j11 = jI;
                        try {
                            dVar.e().k();
                            dVar.f(j11);
                            throw th;
                        } catch (Throwable th3) {
                            th = th3;
                            aVar3.Q0().c().c(-f12, -f14);
                            throw th;
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    j11 = jI;
                    dVar = dVarQ0;
                }
            } catch (Throwable th5) {
                th = th5;
                f14 = f14;
                f12 = f12;
            }
        } catch (Throwable th6) {
            th = th6;
            f12 = f13;
        }
    }

    public final androidx.compose.ui.draw.i Q1(androidx.compose.ui.draw.c cVar, final l1 l1Var, m4.c cVar2, final long j11, final long j12, final boolean z11, final float f11) {
        if (y1.l.e(cVar2.b())) {
            final long jH = cVar2.b().h();
            final float f12 = f11 / 2;
            final z1.m mVar = new z1.m(f11, 0.0f, 0, 0, null, 30, null);
            return cVar.l(new Function1<z1.c, Unit>() { // from class: androidx.compose.foundation.BorderModifierNode$drawRoundRectBorder$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(z1.c cVar3) throws Throwable {
                    invoke2(cVar3);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(z1.c cVar3) throws Throwable {
                    long j13;
                    cVar3.a1();
                    if (z11) {
                        z1.f.k(cVar3, l1Var, 0L, 0L, jH, 0.0f, null, null, 0, 246, null);
                        return;
                    }
                    float fD = y1.a.d(jH);
                    float f13 = f12;
                    if (fD >= f13) {
                        z1.f.k(cVar3, l1Var, j11, j12, BorderKt.k(jH, f13), 0.0f, mVar, null, 0, 208, null);
                        return;
                    }
                    float f14 = f11;
                    float fI = y1.m.i(cVar3.i()) - f11;
                    float fG = y1.m.g(cVar3.i()) - f11;
                    int iA = v1.f4361a.a();
                    l1 l1Var2 = l1Var;
                    long j14 = jH;
                    z1.d dVarQ0 = cVar3.Q0();
                    long jI = dVarQ0.i();
                    dVarQ0.e().d();
                    try {
                        dVarQ0.c().a(f14, f14, fI, fG, iA);
                        j13 = jI;
                        try {
                            z1.f.k(cVar3, l1Var2, 0L, 0L, j14, 0.0f, null, null, 0, 246, null);
                            dVarQ0.e().k();
                            dVarQ0.f(j13);
                        } catch (Throwable th2) {
                            th = th2;
                            dVarQ0.e().k();
                            dVarQ0.f(j13);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        j13 = jI;
                    }
                }
            });
        }
        if (this.f2199q == null) {
            this.f2199q = new c(null, null, null, null, 15, null);
        }
        c cVar3 = this.f2199q;
        Intrinsics.d(cVar3);
        final Path pathH = BorderKt.h(cVar3.g(), cVar2.b(), f11, z11);
        return cVar.l(new Function1<z1.c, Unit>() { // from class: androidx.compose.foundation.BorderModifierNode$drawRoundRectBorder$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(z1.c cVar4) {
                invoke2(cVar4);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(z1.c cVar4) {
                cVar4.a1();
                z1.f.g(cVar4, pathH, l1Var, 0.0f, null, null, 0, 60, null);
            }
        });
    }

    public final l1 R1() {
        return this.f2201s;
    }

    public final c5 S1() {
        return this.f2202t;
    }

    public final float T1() {
        return this.f2200r;
    }

    public final void U1(l1 l1Var) {
        if (Intrinsics.b(this.f2201s, l1Var)) {
            return;
        }
        this.f2201s = l1Var;
        this.f2203u.x0();
    }

    public final void V1(float f11) {
        if (q2.i.j(this.f2200r, f11)) {
            return;
        }
        this.f2200r = f11;
        this.f2203u.x0();
    }
}
