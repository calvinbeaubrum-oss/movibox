package androidx.compose.material.ripple;

import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.a3;
import androidx.compose.ui.graphics.w1;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Deprecated;
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
@Deprecated
@Metadata
@SourceDebugExtension
public final class b extends Ripple {
    public b(boolean z11, float f11, a3<w1> a3Var) {
        super(z11, f11, a3Var, null);
    }

    public /* synthetic */ b(boolean z11, float f11, a3 a3Var, DefaultConstructorMarker defaultConstructorMarker) {
        this(z11, f11, a3Var);
    }

    @Override // androidx.compose.material.ripple.Ripple
    public RippleIndicationInstance c(o1.g gVar, boolean z11, float f11, a3<w1> a3Var, a3<c> a3Var2, androidx.compose.runtime.i iVar, int i11) {
        iVar.R(331259447);
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.S(331259447, i11, -1, "androidx.compose.material.ripple.PlatformRipple.rememberUpdatedRippleInstance (Ripple.android.kt:92)");
        }
        ViewGroup viewGroupE = j.e((View) iVar.l(AndroidCompositionLocals_androidKt.j()));
        boolean zQ = ((((i11 & 14) ^ 6) > 4 && iVar.Q(gVar)) || (i11 & 6) == 4) | ((((458752 & i11) ^ 196608) > 131072 && iVar.Q(this)) || (i11 & 196608) == 131072) | iVar.Q(viewGroupE);
        Object objY = iVar.y();
        if (zQ || objY == androidx.compose.runtime.i.f3413a.a()) {
            objY = new AndroidRippleIndicationInstance(z11, f11, a3Var, a3Var2, viewGroupE, null);
            iVar.p(objY);
        }
        AndroidRippleIndicationInstance androidRippleIndicationInstance = (AndroidRippleIndicationInstance) objY;
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.R();
        }
        iVar.L();
        return androidRippleIndicationInstance;
    }
}
