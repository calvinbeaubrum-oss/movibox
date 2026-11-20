package androidx.compose.ui.graphics.layer;

import androidx.collection.MutableScatterSet;
import androidx.compose.ui.graphics.j4;
import kotlin.Metadata;
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
@Metadata
@SourceDebugExtension
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public GraphicsLayer f4207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public GraphicsLayer f4208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MutableScatterSet<GraphicsLayer> f4209c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MutableScatterSet<GraphicsLayer> f4210d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f4211e;

    public final boolean i(GraphicsLayer graphicsLayer) {
        if (!this.f4211e) {
            j4.a("Only add dependencies during a tracking");
        }
        MutableScatterSet<GraphicsLayer> mutableScatterSet = this.f4209c;
        if (mutableScatterSet != null) {
            Intrinsics.d(mutableScatterSet);
            mutableScatterSet.h(graphicsLayer);
        } else if (this.f4207a != null) {
            MutableScatterSet<GraphicsLayer> mutableScatterSetA = androidx.collection.u0.a();
            GraphicsLayer graphicsLayer2 = this.f4207a;
            Intrinsics.d(graphicsLayer2);
            mutableScatterSetA.h(graphicsLayer2);
            mutableScatterSetA.h(graphicsLayer);
            this.f4209c = mutableScatterSetA;
            this.f4207a = null;
        } else {
            this.f4207a = graphicsLayer;
        }
        MutableScatterSet<GraphicsLayer> mutableScatterSet2 = this.f4210d;
        if (mutableScatterSet2 != null) {
            Intrinsics.d(mutableScatterSet2);
            return !mutableScatterSet2.x(graphicsLayer);
        }
        if (this.f4208b != graphicsLayer) {
            return true;
        }
        this.f4208b = null;
        return false;
    }
}
