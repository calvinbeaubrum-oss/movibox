package androidx.compose.foundation;

import android.content.Context;
import android.os.Build;
import android.widget.EdgeEffect;
import androidx.compose.runtime.i1;
import androidx.compose.runtime.r2;
import androidx.compose.ui.graphics.y1;
import androidx.compose.ui.input.pointer.o0;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.e1;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
public final class AndroidEdgeEffectOverscrollEffect implements f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y1.g f2178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f2179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i1<Unit> f2180c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2181d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2182e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f2183f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public androidx.compose.ui.input.pointer.y f2184g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final androidx.compose.ui.f f2185h;

    public AndroidEdgeEffectOverscrollEffect(Context context, e0 e0Var) {
        androidx.compose.ui.f hVar;
        p pVar = new p(context, y1.j(e0Var.b()));
        this.f2179b = pVar;
        Unit unit = Unit.f68710a;
        this.f2180c = r2.e(unit, r2.g());
        this.f2181d = true;
        this.f2183f = y1.m.f81091b.b();
        androidx.compose.ui.f fVarD = o0.d(androidx.compose.ui.f.f3863a, unit, new AndroidEdgeEffectOverscrollEffect$effectModifier$1(this, null));
        if (Build.VERSION.SDK_INT >= 31) {
            hVar = new n(this, pVar, InspectableValueKt.b() ? new Function1<e1, Unit>() { // from class: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$special$$inlined$debugInspectorInfo$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(e1 e1Var) {
                    invoke2(e1Var);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(e1 e1Var) {
                    e1Var.b("overscroll");
                    e1Var.c(this.this$0);
                }
            } : InspectableValueKt.a());
        } else {
            hVar = new h(this, pVar, e0Var, InspectableValueKt.b() ? new Function1<e1, Unit>() { // from class: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$special$$inlined$debugInspectorInfo$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(e1 e1Var) {
                    invoke2(e1Var);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(e1 e1Var) {
                    e1Var.b("overscroll");
                    e1Var.c(this.this$0);
                }
            } : InspectableValueKt.a());
        }
        this.f2185h = fVarD.f(hVar);
    }

    @Override // androidx.compose.foundation.f0
    public boolean a() {
        p pVar = this.f2179b;
        EdgeEffect edgeEffect = pVar.f2819d;
        if (edgeEffect != null && o.f2815a.b(edgeEffect) != 0.0f) {
            return true;
        }
        EdgeEffect edgeEffect2 = pVar.f2820e;
        if (edgeEffect2 != null && o.f2815a.b(edgeEffect2) != 0.0f) {
            return true;
        }
        EdgeEffect edgeEffect3 = pVar.f2821f;
        if (edgeEffect3 != null && o.f2815a.b(edgeEffect3) != 0.0f) {
            return true;
        }
        EdgeEffect edgeEffect4 = pVar.f2822g;
        return (edgeEffect4 == null || o.f2815a.b(edgeEffect4) == 0.0f) ? false : true;
    }

    @Override // androidx.compose.foundation.f0
    public androidx.compose.ui.f b() {
        return this.f2185h;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002a  */
    /* JADX WARN: Code duplicated, block: B:50:0x0107  */
    /* JADX WARN: Code duplicated, block: B:52:0x010c  */
    /* JADX WARN: Code duplicated, block: B:54:0x0114  */
    /* JADX WARN: Code duplicated, block: B:55:0x0118  */
    /* JADX WARN: Code duplicated, block: B:57:0x011b A[ADDED_TO_REGION] */
    @Override // androidx.compose.foundation.f0
    public long c(long j11, int i11, Function1<? super y1.g, y1.g> function1) {
        float fL;
        boolean z11;
        boolean z12;
        if (y1.m.k(this.f2183f)) {
            return function1.invoke(y1.g.d(j11)).v();
        }
        boolean z13 = true;
        if (!this.f2182e) {
            q();
            this.f2182e = true;
        }
        float fN = 0.0f;
        if (y1.g.n(j11) == 0.0f) {
            fL = 0.0f;
        } else if (this.f2179b.A()) {
            fL = o(j11);
            if (!this.f2179b.A()) {
                this.f2179b.l().onRelease();
            }
        } else if (this.f2179b.q()) {
            fL = l(j11);
            if (!this.f2179b.q()) {
                this.f2179b.f().onRelease();
            }
        } else {
            fL = 0.0f;
        }
        if (y1.g.m(j11) != 0.0f) {
            if (this.f2179b.t()) {
                fN = m(j11);
                if (!this.f2179b.t()) {
                    this.f2179b.h().onRelease();
                }
            } else if (this.f2179b.w()) {
                fN = n(j11);
                if (!this.f2179b.w()) {
                    this.f2179b.j().onRelease();
                }
            }
        }
        long jA = y1.h.a(fN, fL);
        if (!y1.g.j(jA, y1.g.f81070b.c())) {
            k();
        }
        long jQ = y1.g.q(j11, jA);
        long jV = function1.invoke(y1.g.d(jQ)).v();
        long jQ2 = y1.g.q(jQ, jV);
        boolean z14 = false;
        if (androidx.compose.ui.input.nestedscroll.e.d(i11, androidx.compose.ui.input.nestedscroll.e.f4627a.b())) {
            if (y1.g.m(jQ2) > 0.5f) {
                m(jQ2);
            } else {
                if (y1.g.m(jQ2) < -0.5f) {
                    n(jQ2);
                } else {
                    z11 = false;
                }
                if (y1.g.n(jQ2) > 0.5f) {
                    o(jQ2);
                } else {
                    if (y1.g.n(jQ2) < -0.5f) {
                        l(jQ2);
                    } else {
                        z12 = false;
                    }
                    if (!z11 && !z12) {
                        z13 = false;
                    }
                    z14 = z13;
                }
                z12 = true;
                if (!z11) {
                    z13 = false;
                }
                z14 = z13;
            }
            z11 = true;
            if (y1.g.n(jQ2) > 0.5f) {
                o(jQ2);
            } else {
                if (y1.g.n(jQ2) < -0.5f) {
                    l(jQ2);
                } else {
                    z12 = false;
                }
                if (!z11) {
                    z13 = false;
                }
                z14 = z13;
            }
            z12 = true;
            if (!z11) {
                z13 = false;
            }
            z14 = z13;
        }
        if (p(j11) || z14) {
            k();
        }
        return y1.g.r(jA, jV);
    }

    /* JADX WARN: Code duplicated, block: B:54:0x013d  */
    /* JADX WARN: Code duplicated, block: B:55:0x0151  */
    /* JADX WARN: Code duplicated, block: B:57:0x0159  */
    /* JADX WARN: Code duplicated, block: B:60:0x0175  */
    /* JADX WARN: Code duplicated, block: B:61:0x0189  */
    /* JADX WARN: Code duplicated, block: B:63:0x0191  */
    /* JADX WARN: Code duplicated, block: B:66:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.compose.foundation.f0
    public Object d(long j11, Function2<? super q2.z, ? super Continuation<? super q2.z>, ? extends Object> function2, Continuation<? super Unit> continuation) throws Throwable {
        AndroidEdgeEffectOverscrollEffect$applyToFling$1 androidEdgeEffectOverscrollEffect$applyToFling$1;
        float fH;
        float fI;
        long jK;
        AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect;
        long jK2;
        if (continuation instanceof AndroidEdgeEffectOverscrollEffect$applyToFling$1) {
            androidEdgeEffectOverscrollEffect$applyToFling$1 = (AndroidEdgeEffectOverscrollEffect$applyToFling$1) continuation;
            int i11 = androidEdgeEffectOverscrollEffect$applyToFling$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                androidEdgeEffectOverscrollEffect$applyToFling$1.label = i11 - Integer.MIN_VALUE;
            } else {
                androidEdgeEffectOverscrollEffect$applyToFling$1 = new AndroidEdgeEffectOverscrollEffect$applyToFling$1(this, continuation);
            }
        } else {
            androidEdgeEffectOverscrollEffect$applyToFling$1 = new AndroidEdgeEffectOverscrollEffect$applyToFling$1(this, continuation);
        }
        Object objInvoke = androidEdgeEffectOverscrollEffect$applyToFling$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = androidEdgeEffectOverscrollEffect$applyToFling$1.label;
        if (i12 != 0) {
            if (i12 == 1) {
                ResultKt.b(objInvoke);
                return Unit.f68710a;
            }
            if (i12 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            jK = androidEdgeEffectOverscrollEffect$applyToFling$1.J$0;
            androidEdgeEffectOverscrollEffect = (AndroidEdgeEffectOverscrollEffect) androidEdgeEffectOverscrollEffect$applyToFling$1.L$0;
            ResultKt.b(objInvoke);
            jK2 = q2.z.k(jK, ((q2.z) objInvoke).n());
            androidEdgeEffectOverscrollEffect.f2182e = false;
            if (q2.z.h(jK2) > 0.0f) {
                o.f2815a.c(androidEdgeEffectOverscrollEffect.f2179b.h(), a20.b.d(q2.z.h(jK2)));
            } else if (q2.z.h(jK2) < 0.0f) {
                o.f2815a.c(androidEdgeEffectOverscrollEffect.f2179b.j(), -a20.b.d(q2.z.h(jK2)));
            }
            if (q2.z.i(jK2) > 0.0f) {
                o.f2815a.c(androidEdgeEffectOverscrollEffect.f2179b.l(), a20.b.d(q2.z.i(jK2)));
            } else if (q2.z.i(jK2) < 0.0f) {
                o.f2815a.c(androidEdgeEffectOverscrollEffect.f2179b.f(), -a20.b.d(q2.z.i(jK2)));
            }
            if (!q2.z.g(jK2, q2.z.f74266b.a())) {
                androidEdgeEffectOverscrollEffect.k();
            }
            androidEdgeEffectOverscrollEffect.h();
            return Unit.f68710a;
        }
        ResultKt.b(objInvoke);
        if (y1.m.k(this.f2183f)) {
            q2.z zVarB = q2.z.b(j11);
            androidEdgeEffectOverscrollEffect$applyToFling$1.label = 1;
            if (function2.invoke(zVarB, androidEdgeEffectOverscrollEffect$applyToFling$1) == objE) {
                return objE;
            }
            return Unit.f68710a;
        }
        if (q2.z.h(j11) > 0.0f && this.f2179b.t()) {
            o.f2815a.c(this.f2179b.h(), a20.b.d(q2.z.h(j11)));
            fH = q2.z.h(j11);
        } else if (q2.z.h(j11) >= 0.0f || !this.f2179b.w()) {
            fH = 0.0f;
        } else {
            o.f2815a.c(this.f2179b.j(), -a20.b.d(q2.z.h(j11)));
            fH = q2.z.h(j11);
        }
        if (q2.z.i(j11) > 0.0f && this.f2179b.A()) {
            o.f2815a.c(this.f2179b.l(), a20.b.d(q2.z.i(j11)));
            fI = q2.z.i(j11);
        } else if (q2.z.i(j11) >= 0.0f || !this.f2179b.q()) {
            fI = 0.0f;
        } else {
            o.f2815a.c(this.f2179b.f(), -a20.b.d(q2.z.i(j11)));
            fI = q2.z.i(j11);
        }
        long jA = q2.a0.a(fH, fI);
        if (!q2.z.g(jA, q2.z.f74266b.a())) {
            k();
        }
        jK = q2.z.k(j11, jA);
        q2.z zVarB2 = q2.z.b(jK);
        androidEdgeEffectOverscrollEffect$applyToFling$1.L$0 = this;
        androidEdgeEffectOverscrollEffect$applyToFling$1.J$0 = jK;
        androidEdgeEffectOverscrollEffect$applyToFling$1.label = 2;
        objInvoke = function2.invoke(zVarB2, androidEdgeEffectOverscrollEffect$applyToFling$1);
        if (objInvoke == objE) {
            return objE;
        }
        androidEdgeEffectOverscrollEffect = this;
        jK2 = q2.z.k(jK, ((q2.z) objInvoke).n());
        androidEdgeEffectOverscrollEffect.f2182e = false;
        if (q2.z.h(jK2) > 0.0f) {
            o.f2815a.c(androidEdgeEffectOverscrollEffect.f2179b.h(), a20.b.d(q2.z.h(jK2)));
        } else if (q2.z.h(jK2) < 0.0f) {
            o.f2815a.c(androidEdgeEffectOverscrollEffect.f2179b.j(), -a20.b.d(q2.z.h(jK2)));
        }
        if (q2.z.i(jK2) > 0.0f) {
            o.f2815a.c(androidEdgeEffectOverscrollEffect.f2179b.l(), a20.b.d(q2.z.i(jK2)));
        } else if (q2.z.i(jK2) < 0.0f) {
            o.f2815a.c(androidEdgeEffectOverscrollEffect.f2179b.f(), -a20.b.d(q2.z.i(jK2)));
        }
        if (!q2.z.g(jK2, q2.z.f74266b.a())) {
            androidEdgeEffectOverscrollEffect.k();
        }
        androidEdgeEffectOverscrollEffect.h();
        return Unit.f68710a;
    }

    public final void h() {
        boolean zIsFinished;
        p pVar = this.f2179b;
        EdgeEffect edgeEffect = pVar.f2819d;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = edgeEffect.isFinished();
        } else {
            zIsFinished = false;
        }
        EdgeEffect edgeEffect2 = pVar.f2820e;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished = edgeEffect2.isFinished() || zIsFinished;
        }
        EdgeEffect edgeEffect3 = pVar.f2821f;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished = edgeEffect3.isFinished() || zIsFinished;
        }
        EdgeEffect edgeEffect4 = pVar.f2822g;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            if (!edgeEffect4.isFinished() && !zIsFinished) {
                return;
            }
        } else if (!zIsFinished) {
            return;
        }
        k();
    }

    public final long i() {
        y1.g gVar = this.f2178a;
        long jV = gVar != null ? gVar.v() : y1.n.b(this.f2183f);
        return y1.h.a(y1.g.m(jV) / y1.m.i(this.f2183f), y1.g.n(jV) / y1.m.g(this.f2183f));
    }

    public final i1<Unit> j() {
        return this.f2180c;
    }

    public final void k() {
        if (this.f2181d) {
            this.f2180c.setValue(Unit.f68710a);
        }
    }

    public final float l(long j11) {
        float fM = y1.g.m(i());
        float fN = y1.g.n(j11) / y1.m.g(this.f2183f);
        EdgeEffect edgeEffectF = this.f2179b.f();
        o oVar = o.f2815a;
        return oVar.b(edgeEffectF) == 0.0f ? (-oVar.d(edgeEffectF, -fN, 1 - fM)) * y1.m.g(this.f2183f) : y1.g.n(j11);
    }

    public final float m(long j11) {
        float fN = y1.g.n(i());
        float fM = y1.g.m(j11) / y1.m.i(this.f2183f);
        EdgeEffect edgeEffectH = this.f2179b.h();
        o oVar = o.f2815a;
        return oVar.b(edgeEffectH) == 0.0f ? oVar.d(edgeEffectH, fM, 1 - fN) * y1.m.i(this.f2183f) : y1.g.m(j11);
    }

    public final float n(long j11) {
        float fN = y1.g.n(i());
        float fM = y1.g.m(j11) / y1.m.i(this.f2183f);
        EdgeEffect edgeEffectJ = this.f2179b.j();
        o oVar = o.f2815a;
        return oVar.b(edgeEffectJ) == 0.0f ? (-oVar.d(edgeEffectJ, -fM, fN)) * y1.m.i(this.f2183f) : y1.g.m(j11);
    }

    public final float o(long j11) {
        float fM = y1.g.m(i());
        float fN = y1.g.n(j11) / y1.m.g(this.f2183f);
        EdgeEffect edgeEffectL = this.f2179b.l();
        o oVar = o.f2815a;
        return oVar.b(edgeEffectL) == 0.0f ? oVar.d(edgeEffectL, fN, fM) * y1.m.g(this.f2183f) : y1.g.n(j11);
    }

    public final boolean p(long j11) {
        boolean z11;
        boolean z12 = true;
        if (!this.f2179b.r() || y1.g.m(j11) >= 0.0f) {
            z11 = false;
        } else {
            o.f2815a.e(this.f2179b.h(), y1.g.m(j11));
            z11 = !this.f2179b.r();
        }
        if (this.f2179b.u() && y1.g.m(j11) > 0.0f) {
            o.f2815a.e(this.f2179b.j(), y1.g.m(j11));
            z11 = z11 || !this.f2179b.u();
        }
        if (this.f2179b.y() && y1.g.n(j11) < 0.0f) {
            o.f2815a.e(this.f2179b.l(), y1.g.n(j11));
            z11 = z11 || !this.f2179b.y();
        }
        if (!this.f2179b.o() || y1.g.n(j11) <= 0.0f) {
            return z11;
        }
        o.f2815a.e(this.f2179b.f(), y1.g.n(j11));
        if (!z11 && this.f2179b.o()) {
            z12 = false;
        }
        return z12;
    }

    public final boolean q() {
        boolean z11;
        if (this.f2179b.t()) {
            m(y1.g.f81070b.c());
            z11 = true;
        } else {
            z11 = false;
        }
        if (this.f2179b.w()) {
            n(y1.g.f81070b.c());
            z11 = true;
        }
        if (this.f2179b.A()) {
            o(y1.g.f81070b.c());
            z11 = true;
        }
        if (!this.f2179b.q()) {
            return z11;
        }
        l(y1.g.f81070b.c());
        return true;
    }

    public final void r(long j11) {
        boolean zF = y1.m.f(this.f2183f, y1.m.f81091b.b());
        boolean z11 = !y1.m.f(j11, this.f2183f);
        this.f2183f = j11;
        if (z11) {
            this.f2179b.B(q2.u.a(a20.b.d(y1.m.i(j11)), a20.b.d(y1.m.g(j11))));
        }
        if (zF || !z11) {
            return;
        }
        k();
        h();
    }
}
