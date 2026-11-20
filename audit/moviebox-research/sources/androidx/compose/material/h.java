package androidx.compose.material;

import androidx.compose.ui.graphics.w1;
import androidx.compose.ui.graphics.y1;
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
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f3089a = new h();

    public final androidx.compose.material.ripple.c a(long j11, boolean z11) {
        if (z11) {
            return ((double) y1.i(j11)) > 0.5d ? RippleKt.f3049e : RippleKt.f3050f;
        }
        return RippleKt.f3051g;
    }

    public final long b(long j11, boolean z11) {
        return (z11 || ((double) y1.i(j11)) >= 0.5d) ? j11 : w1.f4564b.f();
    }
}
