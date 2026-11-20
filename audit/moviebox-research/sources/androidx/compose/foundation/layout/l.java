package androidx.compose.foundation.layout;

import kotlin.Metadata;
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
public final class l implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f2502a = new l();

    @Override // androidx.compose.foundation.layout.k
    public androidx.compose.ui.f a(androidx.compose.ui.f fVar, float f11, boolean z11) {
        if (f11 > 0.0d) {
            return fVar.f(new LayoutWeightElement(kotlin.ranges.a.f(f11, Float.MAX_VALUE), z11));
        }
        throw new IllegalArgumentException(("invalid weight " + f11 + "; must be greater than zero").toString());
    }

    @Override // androidx.compose.foundation.layout.k
    public androidx.compose.ui.f b(androidx.compose.ui.f fVar, androidx.compose.ui.b.InterfaceC0052b interfaceC0052b) {
        return fVar.f(new HorizontalAlignElement(interfaceC0052b));
    }
}
