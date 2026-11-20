package androidx.compose.material.ripple;

import android.view.ViewGroup;
import androidx.compose.runtime.a3;
import androidx.compose.runtime.b2;
import androidx.compose.runtime.i1;
import androidx.compose.runtime.u2;
import androidx.compose.ui.graphics.h0;
import androidx.compose.ui.graphics.o1;
import androidx.compose.ui.graphics.w1;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.k0;
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
@Deprecated
@Metadata
@SourceDebugExtension
public final class AndroidRippleIndicationInstance extends RippleIndicationInstance implements b2, e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f3105c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f3106d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a3<w1> f3107f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a3<c> f3108g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ViewGroup f3109h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RippleContainer f3110i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final i1 f3111j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final i1 f3112k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f3113l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f3114m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Function0<Unit> f3115n;

    public AndroidRippleIndicationInstance(boolean z11, float f11, a3<w1> a3Var, a3<c> a3Var2, ViewGroup viewGroup) {
        super(z11, a3Var2);
        this.f3105c = z11;
        this.f3106d = f11;
        this.f3107f = a3Var;
        this.f3108g = a3Var2;
        this.f3109h = viewGroup;
        this.f3111j = u2.c(null, null, 2, null);
        this.f3112k = u2.c(Boolean.TRUE, null, 2, null);
        this.f3113l = m.f81091b.b();
        this.f3114m = -1;
        this.f3115n = new Function0<Unit>() { // from class: androidx.compose.material.ripple.AndroidRippleIndicationInstance$onInvalidateRipple$1
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
                AndroidRippleIndicationInstance androidRippleIndicationInstance = this.this$0;
                androidRippleIndicationInstance.l(!androidRippleIndicationInstance.i());
            }
        };
    }

    public /* synthetic */ AndroidRippleIndicationInstance(boolean z11, float f11, a3 a3Var, a3 a3Var2, ViewGroup viewGroup, DefaultConstructorMarker defaultConstructorMarker) {
        this(z11, f11, a3Var, a3Var2, viewGroup);
    }

    private final void h() {
        RippleContainer rippleContainer = this.f3110i;
        if (rippleContainer != null) {
            rippleContainer.disposeRippleIfNeeded(this);
        }
    }

    private final RippleContainer j() {
        RippleContainer rippleContainer = this.f3110i;
        if (rippleContainer != null) {
            Intrinsics.d(rippleContainer);
            return rippleContainer;
        }
        RippleContainer rippleContainerC = j.c(this.f3109h);
        this.f3110i = rippleContainerC;
        Intrinsics.d(rippleContainerC);
        return rippleContainerC;
    }

    private final void m(RippleHostView rippleHostView) {
        this.f3111j.setValue(rippleHostView);
    }

    @Override // androidx.compose.material.ripple.e
    public void E0() {
        m(null);
    }

    @Override // androidx.compose.foundation.y
    public void a(z1.c cVar) {
        this.f3113l = cVar.i();
        this.f3114m = Float.isNaN(this.f3106d) ? a20.b.d(d.a(cVar, this.f3105c, cVar.i())) : cVar.k0(this.f3106d);
        long jU = this.f3107f.getValue().u();
        float fD = this.f3108g.getValue().d();
        cVar.a1();
        c(cVar, this.f3106d, jU);
        o1 o1VarE = cVar.Q0().e();
        i();
        RippleHostView rippleHostViewK = k();
        if (rippleHostViewK != null) {
            rippleHostViewK.m40setRippleProperties07v42R4(cVar.i(), jU, fD);
            rippleHostViewK.draw(h0.d(o1VarE));
        }
    }

    @Override // androidx.compose.material.ripple.RippleIndicationInstance
    public void b(o1.k.b bVar, k0 k0Var) {
        RippleHostView rippleHostView = j().getRippleHostView(this);
        rippleHostView.m39addRippleKOepWvA(bVar, this.f3105c, this.f3113l, this.f3114m, this.f3107f.getValue().u(), this.f3108g.getValue().d(), this.f3115n);
        m(rippleHostView);
    }

    @Override // androidx.compose.material.ripple.RippleIndicationInstance
    public void d(o1.k.b bVar) {
        RippleHostView rippleHostViewK = k();
        if (rippleHostViewK != null) {
            rippleHostViewK.removeRipple();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean i() {
        return ((Boolean) this.f3112k.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final RippleHostView k() {
        return (RippleHostView) this.f3111j.getValue();
    }

    public final void l(boolean z11) {
        this.f3112k.setValue(Boolean.valueOf(z11));
    }

    @Override // androidx.compose.runtime.b2
    public void onAbandoned() {
        h();
    }

    @Override // androidx.compose.runtime.b2
    public void onForgotten() {
        h();
    }

    @Override // androidx.compose.runtime.b2
    public void onRemembered() {
    }
}
