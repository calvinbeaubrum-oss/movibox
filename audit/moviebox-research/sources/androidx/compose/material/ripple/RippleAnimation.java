package androidx.compose.material.ripple;

import androidx.compose.animation.core.Animatable;
import androidx.compose.runtime.i1;
import androidx.compose.runtime.u2;
import androidx.compose.ui.graphics.v1;
import androidx.compose.ui.graphics.w1;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;
import y1.m;

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
public final class RippleAnimation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y1.g f3123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f3124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f3125c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Float f3126d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public y1.g f3127e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Animatable<Float, androidx.compose.animation.core.k> f3128f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Animatable<Float, androidx.compose.animation.core.k> f3129g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Animatable<Float, androidx.compose.animation.core.k> f3130h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final w<Unit> f3131i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final i1 f3132j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final i1 f3133k;

    public RippleAnimation(y1.g gVar, float f11, boolean z11) {
        this.f3123a = gVar;
        this.f3124b = f11;
        this.f3125c = z11;
        this.f3128f = androidx.compose.animation.core.a.b(0.0f, 0.0f, 2, null);
        this.f3129g = androidx.compose.animation.core.a.b(0.0f, 0.0f, 2, null);
        this.f3130h = androidx.compose.animation.core.a.b(0.0f, 0.0f, 2, null);
        this.f3131i = y.a(null);
        Boolean bool = Boolean.FALSE;
        this.f3132j = u2.c(bool, null, 2, null);
        this.f3133k = u2.c(bool, null, 2, null);
    }

    public /* synthetic */ RippleAnimation(y1.g gVar, float f11, boolean z11, DefaultConstructorMarker defaultConstructorMarker) {
        this(gVar, f11, z11);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0071 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object d(Continuation<? super Unit> continuation) throws Throwable {
        RippleAnimation$animate$1 rippleAnimation$animate$1;
        RippleAnimation rippleAnimation;
        if (continuation instanceof RippleAnimation$animate$1) {
            rippleAnimation$animate$1 = (RippleAnimation$animate$1) continuation;
            int i11 = rippleAnimation$animate$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                rippleAnimation$animate$1.label = i11 - Integer.MIN_VALUE;
            } else {
                rippleAnimation$animate$1 = new RippleAnimation$animate$1(this, continuation);
            }
        } else {
            rippleAnimation$animate$1 = new RippleAnimation$animate$1(this, continuation);
        }
        Object obj = rippleAnimation$animate$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = rippleAnimation$animate$1.label;
        if (i12 != 0) {
            if (i12 == 1) {
                rippleAnimation = (RippleAnimation) rippleAnimation$animate$1.L$0;
                ResultKt.b(obj);
            } else if (i12 == 2) {
                rippleAnimation = (RippleAnimation) rippleAnimation$animate$1.L$0;
                ResultKt.b(obj);
                rippleAnimation$animate$1.L$0 = null;
                rippleAnimation$animate$1.label = 3;
                if (rippleAnimation.g(rippleAnimation$animate$1) == objE) {
                    return objE;
                }
            } else {
                if (i12 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f68710a;
        }
        ResultKt.b(obj);
        rippleAnimation$animate$1.L$0 = this;
        rippleAnimation$animate$1.label = 1;
        if (f(rippleAnimation$animate$1) == objE) {
            return objE;
        }
        rippleAnimation = this;
        rippleAnimation.l(true);
        w<Unit> wVar = rippleAnimation.f3131i;
        rippleAnimation$animate$1.L$0 = rippleAnimation;
        rippleAnimation$animate$1.label = 2;
        if (wVar.c(rippleAnimation$animate$1) == objE) {
            return objE;
        }
        rippleAnimation$animate$1.L$0 = null;
        rippleAnimation$animate$1.label = 3;
        if (rippleAnimation.g(rippleAnimation$animate$1) == objE) {
            return objE;
        }
        return Unit.f68710a;
    }

    public final void e(z1.g gVar, long j11) {
        if (this.f3126d == null) {
            this.f3126d = Float.valueOf(d.b(gVar.i()));
        }
        if (this.f3123a == null) {
            this.f3123a = y1.g.d(gVar.T0());
        }
        if (this.f3127e == null) {
            this.f3127e = y1.g.d(y1.h.a(m.i(gVar.i()) / 2.0f, m.g(gVar.i()) / 2.0f));
        }
        float fFloatValue = (!i() || j()) ? this.f3128f.k().floatValue() : 1.0f;
        Float f11 = this.f3126d;
        Intrinsics.d(f11);
        float fB = s2.b.b(f11.floatValue(), this.f3124b, this.f3129g.k().floatValue());
        y1.g gVar2 = this.f3123a;
        Intrinsics.d(gVar2);
        float fM = y1.g.m(gVar2.v());
        y1.g gVar3 = this.f3127e;
        Intrinsics.d(gVar3);
        float fB2 = s2.b.b(fM, y1.g.m(gVar3.v()), this.f3130h.k().floatValue());
        y1.g gVar4 = this.f3123a;
        Intrinsics.d(gVar4);
        float fN = y1.g.n(gVar4.v());
        y1.g gVar5 = this.f3127e;
        Intrinsics.d(gVar5);
        long jA = y1.h.a(fB2, s2.b.b(fN, y1.g.n(gVar5.v()), this.f3130h.k().floatValue()));
        long jK = w1.k(j11, w1.n(j11) * fFloatValue, 0.0f, 0.0f, 0.0f, 14, null);
        if (!this.f3125c) {
            z1.f.d(gVar, jK, fB, jA, 0.0f, null, null, 0, 120, null);
            return;
        }
        float fI = m.i(gVar.i());
        float fG = m.g(gVar.i());
        int iB = v1.f4361a.b();
        z1.d dVarQ0 = gVar.Q0();
        long jI = dVarQ0.i();
        dVarQ0.e().d();
        try {
            dVarQ0.c().a(0.0f, 0.0f, fI, fG, iB);
            z1.f.d(gVar, jK, fB, jA, 0.0f, null, null, 0, 120, null);
        } finally {
            dVarQ0.e().k();
            dVarQ0.f(jI);
        }
    }

    public final Object f(Continuation<? super Unit> continuation) {
        Object objE = l0.e(new RippleAnimation$fadeIn$2(this, null), continuation);
        return objE == kotlin.coroutines.intrinsics.a.e() ? objE : Unit.f68710a;
    }

    public final Object g(Continuation<? super Unit> continuation) {
        Object objE = l0.e(new RippleAnimation$fadeOut$2(this, null), continuation);
        return objE == kotlin.coroutines.intrinsics.a.e() ? objE : Unit.f68710a;
    }

    public final void h() {
        k(true);
        this.f3131i.j(Unit.f68710a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean i() {
        return ((Boolean) this.f3133k.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean j() {
        return ((Boolean) this.f3132j.getValue()).booleanValue();
    }

    public final void k(boolean z11) {
        this.f3133k.setValue(Boolean.valueOf(z11));
    }

    public final void l(boolean z11) {
        this.f3132j.setValue(Boolean.valueOf(z11));
    }
}
