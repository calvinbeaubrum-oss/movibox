package androidx.compose.material.ripple;

import androidx.compose.animation.core.b0;
import androidx.compose.animation.core.r0;
import androidx.compose.foundation.x;
import androidx.compose.runtime.a3;
import androidx.compose.runtime.r2;
import androidx.compose.ui.graphics.w1;
import androidx.compose.ui.graphics.z1;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r0<Float> f3179a = new r0<>(15, 0, b0.d(), 2, null);

    public static final androidx.compose.ui.node.f c(o1.g gVar, boolean z11, float f11, z1 z1Var, Function0<c> function0) {
        return j.d(gVar, z11, f11, z1Var, function0);
    }

    public static final androidx.compose.animation.core.g<Float> d(o1.f fVar) {
        if (fVar instanceof o1.d) {
            return f3179a;
        }
        if (!(fVar instanceof o1.b) && !(fVar instanceof o1.a.b)) {
            return f3179a;
        }
        return new r0(45, 0, b0.d(), 2, null);
    }

    public static final androidx.compose.animation.core.g<Float> e(o1.f fVar) {
        if (!(fVar instanceof o1.d) && !(fVar instanceof o1.b) && (fVar instanceof o1.a.b)) {
            return new r0(150, 0, b0.d(), 2, null);
        }
        return f3179a;
    }

    @Deprecated
    public static final x f(boolean z11, float f11, long j11, androidx.compose.runtime.i iVar, int i11, int i12) {
        boolean z12 = true;
        if ((i12 & 1) != 0) {
            z11 = true;
        }
        if ((i12 & 2) != 0) {
            f11 = q2.i.f74232b.b();
        }
        if ((i12 & 4) != 0) {
            j11 = w1.f4564b.e();
        }
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.S(1635163520, i11, -1, "androidx.compose.material.ripple.rememberRipple (Ripple.kt:146)");
        }
        a3 a3VarI = r2.i(w1.g(j11), iVar, (i11 >> 6) & 14);
        boolean z13 = (((i11 & 14) ^ 6) > 4 && iVar.a(z11)) || (i11 & 6) == 4;
        if ((((i11 & 112) ^ 48) <= 32 || !iVar.b(f11)) && (i11 & 48) != 32) {
            z12 = false;
        }
        boolean z14 = z13 | z12;
        Object objY = iVar.y();
        if (z14 || objY == androidx.compose.runtime.i.f3413a.a()) {
            objY = new b(z11, f11, a3VarI, null);
            iVar.p(objY);
        }
        b bVar = (b) objY;
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.R();
        }
        return bVar;
    }
}
