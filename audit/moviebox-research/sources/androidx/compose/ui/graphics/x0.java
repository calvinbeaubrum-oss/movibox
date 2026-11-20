package androidx.compose.ui.graphics;

import android.graphics.PathMeasure;
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
public final class x0 implements t4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PathMeasure f4580a;

    public x0(PathMeasure pathMeasure) {
        this.f4580a = pathMeasure;
    }

    @Override // androidx.compose.ui.graphics.t4
    public boolean a(float f11, float f12, Path path, boolean z11) {
        PathMeasure pathMeasure = this.f4580a;
        if (path instanceof u0) {
            return pathMeasure.getSegment(f11, f12, ((u0) path).o(), z11);
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    @Override // androidx.compose.ui.graphics.t4
    public void b(Path path, boolean z11) {
        android.graphics.Path pathO;
        PathMeasure pathMeasure = this.f4580a;
        if (path == null) {
            pathO = null;
        } else {
            if (!(path instanceof u0)) {
                throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
            }
            pathO = ((u0) path).o();
        }
        pathMeasure.setPath(pathO, z11);
    }

    @Override // androidx.compose.ui.graphics.t4
    public float getLength() {
        return this.f4580a.getLength();
    }
}
