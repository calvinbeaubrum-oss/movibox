package androidx.compose.material.ripple;

import androidx.compose.ui.graphics.w1;
import kotlin.Deprecated;
import kotlin.Metadata;

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
public final class a implements i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f3170b = new a();

    @Override // androidx.compose.material.ripple.i
    @Deprecated
    public long a(androidx.compose.runtime.i iVar, int i11) {
        iVar.R(2042140174);
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.S(2042140174, i11, -1, "androidx.compose.material.ripple.DebugRippleTheme.defaultColor (RippleTheme.kt:239)");
        }
        long jB = i.f3180a.b(w1.f4564b.a(), true);
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.R();
        }
        iVar.L();
        return jB;
    }

    @Override // androidx.compose.material.ripple.i
    @Deprecated
    public c b(androidx.compose.runtime.i iVar, int i11) {
        iVar.R(-1629816343);
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.S(-1629816343, i11, -1, "androidx.compose.material.ripple.DebugRippleTheme.rippleAlpha (RippleTheme.kt:243)");
        }
        c cVarA = i.f3180a.a(w1.f4564b.a(), true);
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.R();
        }
        iVar.L();
        return cVarA;
    }
}
