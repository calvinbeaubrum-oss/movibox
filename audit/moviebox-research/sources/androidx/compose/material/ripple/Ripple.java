package androidx.compose.material.ripple;

import androidx.compose.foundation.x;
import androidx.compose.foundation.y;
import androidx.compose.runtime.a3;
import androidx.compose.runtime.g0;
import androidx.compose.runtime.r2;
import androidx.compose.ui.graphics.w1;
import kotlin.Deprecated;
import kotlin.Metadata;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Deprecated
@Metadata
@SourceDebugExtension
public abstract class Ripple implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f3118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f3119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a3<w1> f3120c;

    public Ripple(boolean z11, float f11, a3<w1> a3Var) {
        this.f3118a = z11;
        this.f3119b = f11;
        this.f3120c = a3Var;
    }

    public /* synthetic */ Ripple(boolean z11, float f11, a3 a3Var, DefaultConstructorMarker defaultConstructorMarker) {
        this(z11, f11, a3Var);
    }

    @Override // androidx.compose.foundation.x
    @Deprecated
    public final y b(o1.g gVar, androidx.compose.runtime.i iVar, int i11) {
        long jA;
        iVar.R(988743187);
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.S(988743187, i11, -1, "androidx.compose.material.ripple.Ripple.rememberUpdatedInstance (Ripple.kt:196)");
        }
        i iVar2 = (i) iVar.l(RippleThemeKt.d());
        if (this.f3120c.getValue().u() != 16) {
            iVar.R(-303571590);
            iVar.L();
            jA = this.f3120c.getValue().u();
        } else {
            iVar.R(-303521246);
            jA = iVar2.a(iVar, 0);
            iVar.L();
        }
        int i12 = i11 & 14;
        RippleIndicationInstance rippleIndicationInstanceC = c(gVar, this.f3118a, this.f3119b, r2.i(w1.g(jA), iVar, 0), r2.i(iVar2.b(iVar, 0), iVar, 0), iVar, i12 | ((i11 << 12) & 458752));
        boolean zA = iVar.A(rippleIndicationInstanceC) | (((i12 ^ 6) > 4 && iVar.Q(gVar)) || (i11 & 6) == 4);
        Object objY = iVar.y();
        if (zA || objY == androidx.compose.runtime.i.f3413a.a()) {
            objY = new Ripple$rememberUpdatedInstance$1$1(gVar, rippleIndicationInstanceC, null);
            iVar.p(objY);
        }
        g0.c(rippleIndicationInstanceC, gVar, (Function2) objY, iVar, (i11 << 3) & 112);
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.R();
        }
        iVar.L();
        return rippleIndicationInstanceC;
    }

    public abstract RippleIndicationInstance c(o1.g gVar, boolean z11, float f11, a3<w1> a3Var, a3<c> a3Var2, androidx.compose.runtime.i iVar, int i11);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Ripple)) {
            return false;
        }
        Ripple ripple = (Ripple) obj;
        return this.f3118a == ripple.f3118a && q2.i.j(this.f3119b, ripple.f3119b) && Intrinsics.b(this.f3120c, ripple.f3120c);
    }

    public int hashCode() {
        return (((androidx.compose.foundation.e.a(this.f3118a) * 31) + q2.i.k(this.f3119b)) * 31) + this.f3120c.hashCode();
    }
}
