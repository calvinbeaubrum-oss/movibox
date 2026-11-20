package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

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
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f3223a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float f3224b = q1.b.f74147a.b();

    @JvmName
    public final long a(androidx.compose.runtime.i iVar, int i11) {
        iVar.x(77461041);
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.S(77461041, i11, -1, "androidx.compose.material3.DividerDefaults.<get-color> (Divider.kt:67)");
        }
        long jE = ColorSchemeKt.e(q1.b.f74147a.a(), iVar, 6);
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.R();
        }
        iVar.P();
        return jE;
    }

    public final float b() {
        return f3224b;
    }
}
