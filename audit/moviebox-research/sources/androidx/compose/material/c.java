package androidx.compose.material;

import androidx.compose.ui.graphics.w1;
import androidx.compose.ui.graphics.y1;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
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
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f3075a = new c();

    public final float a(float f11, float f12, androidx.compose.runtime.i iVar, int i11) {
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.S(-1528360391, i11, -1, "androidx.compose.material.ContentAlpha.contentAlpha (ContentAlpha.kt:76)");
        }
        long jU = ((w1) iVar.l(ContentColorKt.a())).u();
        if (!e.f3086a.a(iVar, 6).m() ? y1.i(jU) >= 0.5d : y1.i(jU) <= 0.5d) {
            f11 = f12;
        }
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.R();
        }
        return f11;
    }

    @JvmName
    public final float b(androidx.compose.runtime.i iVar, int i11) {
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.S(621183615, i11, -1, "androidx.compose.material.ContentAlpha.<get-disabled> (ContentAlpha.kt:57)");
        }
        float fA = a(0.38f, 0.38f, iVar, ((i11 << 6) & 896) | 54);
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.R();
        }
        return fA;
    }
}
