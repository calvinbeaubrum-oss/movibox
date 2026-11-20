package androidx.compose.ui.node;

import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.z4;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

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
public interface w0 {
    void destroy();

    void drawLayer(androidx.compose.ui.graphics.o1 o1Var, GraphicsLayer graphicsLayer);

    void invalidate();

    /* JADX INFO: renamed from: isInLayer-k-4lQ0M, reason: not valid java name */
    boolean mo57isInLayerk4lQ0M(long j11);

    void mapBounds(y1.e eVar, boolean z11);

    /* JADX INFO: renamed from: mapOffset-8S9VItk, reason: not valid java name */
    long mo58mapOffset8S9VItk(long j11, boolean z11);

    /* JADX INFO: renamed from: move--gyyYBs, reason: not valid java name */
    void mo59movegyyYBs(long j11);

    /* JADX INFO: renamed from: resize-ozmzZPI, reason: not valid java name */
    void mo60resizeozmzZPI(long j11);

    void reuseLayer(Function2<? super androidx.compose.ui.graphics.o1, ? super GraphicsLayer, Unit> function2, Function0<Unit> function0);

    void updateDisplayList();

    void updateLayerProperties(z4 z4Var);
}
