package androidx.compose.ui.draw;

import androidx.collection.j0;
import androidx.collection.p0;
import androidx.compose.ui.graphics.c4;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
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
public final class l implements c4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j0<GraphicsLayer> f3861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c4 f3862b;

    @Override // androidx.compose.ui.graphics.c4
    public GraphicsLayer a() {
        c4 c4Var = this.f3862b;
        if (!(c4Var != null)) {
            h2.a.b("GraphicsContext not provided");
        }
        GraphicsLayer graphicsLayerA = c4Var.a();
        j0<GraphicsLayer> j0Var = this.f3861a;
        if (j0Var == null) {
            this.f3861a = p0.b(graphicsLayerA);
        } else {
            j0Var.e(graphicsLayerA);
        }
        return graphicsLayerA;
    }

    @Override // androidx.compose.ui.graphics.c4
    public void b(GraphicsLayer graphicsLayer) {
        c4 c4Var = this.f3862b;
        if (c4Var != null) {
            c4Var.b(graphicsLayer);
        }
    }

    public final c4 c() {
        return this.f3862b;
    }

    public final void d() {
        j0<GraphicsLayer> j0Var = this.f3861a;
        if (j0Var != null) {
            Object[] objArr = j0Var.f1895a;
            int i11 = j0Var.f1896b;
            for (int i12 = 0; i12 < i11; i12++) {
                b((GraphicsLayer) objArr[i12]);
            }
            j0Var.f();
        }
    }

    public final void e(c4 c4Var) {
        d();
        this.f3862b = c4Var;
    }
}
