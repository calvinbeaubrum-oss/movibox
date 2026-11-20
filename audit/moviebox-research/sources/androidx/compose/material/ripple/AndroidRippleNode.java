package androidx.compose.material.ripple;

import android.view.View;
import androidx.compose.ui.graphics.h0;
import androidx.compose.ui.graphics.o1;
import androidx.compose.ui.graphics.z1;
import androidx.compose.ui.node.o;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class AndroidRippleNode extends RippleNode implements e {
    public RippleHostView A;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public RippleContainer f3116z;

    public AndroidRippleNode(o1.g gVar, boolean z11, float f11, z1 z1Var, Function0<c> function0) {
        super(gVar, z11, f11, z1Var, function0, null);
    }

    public /* synthetic */ AndroidRippleNode(o1.g gVar, boolean z11, float f11, z1 z1Var, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(gVar, z11, f11, z1Var, function0);
    }

    @Override // androidx.compose.material.ripple.e
    public void E0() {
        W1(null);
    }

    @Override // androidx.compose.material.ripple.RippleNode
    public void M1(o1.k.b bVar, long j11, float f11) {
        RippleHostView rippleHostView = V1().getRippleHostView(this);
        rippleHostView.m39addRippleKOepWvA(bVar, O1(), j11, a20.b.d(f11), Q1(), P1().invoke().d(), new Function0<Unit>() { // from class: androidx.compose.material.ripple.AndroidRippleNode$addRipple$1$1$1
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
                o.a(this.this$0);
            }
        });
        W1(rippleHostView);
    }

    @Override // androidx.compose.material.ripple.RippleNode
    public void N1(z1.g gVar) {
        o1 o1VarE = gVar.Q0().e();
        RippleHostView rippleHostView = this.A;
        if (rippleHostView != null) {
            rippleHostView.m40setRippleProperties07v42R4(R1(), Q1(), P1().invoke().d());
            rippleHostView.draw(h0.d(o1VarE));
        }
    }

    @Override // androidx.compose.material.ripple.RippleNode
    public void T1(o1.k.b bVar) {
        RippleHostView rippleHostView = this.A;
        if (rippleHostView != null) {
            rippleHostView.removeRipple();
        }
    }

    public final RippleContainer V1() {
        RippleContainer rippleContainer = this.f3116z;
        if (rippleContainer != null) {
            Intrinsics.d(rippleContainer);
            return rippleContainer;
        }
        RippleContainer rippleContainerC = j.c(j.e((View) androidx.compose.ui.node.e.a(this, AndroidCompositionLocals_androidKt.j())));
        this.f3116z = rippleContainerC;
        Intrinsics.d(rippleContainerC);
        return rippleContainerC;
    }

    public final void W1(RippleHostView rippleHostView) {
        this.A = rippleHostView;
        o.a(this);
    }

    @Override // androidx.compose.ui.f.c
    public void s1() {
        RippleContainer rippleContainer = this.f3116z;
        if (rippleContainer != null) {
            rippleContainer.disposeRippleIfNeeded(this);
        }
    }
}
