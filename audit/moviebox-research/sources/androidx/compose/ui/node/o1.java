package androidx.compose.ui.node;

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
public final class o1 extends androidx.compose.runtime.a<LayoutNode> {
    public o1(LayoutNode layoutNode) {
        super(layoutNode);
    }

    @Override // androidx.compose.runtime.f
    public void b(int i11, int i12) {
        a().Y0(i11, i12);
    }

    @Override // androidx.compose.runtime.f
    public void c(int i11, int i12, int i13) {
        a().P0(i11, i12, i13);
    }

    @Override // androidx.compose.runtime.a, androidx.compose.runtime.f
    public void e() {
        super.e();
        y0 y0VarG0 = j().g0();
        if (y0VarG0 != null) {
            y0VarG0.onEndApplyChanges();
        }
    }

    @Override // androidx.compose.runtime.a
    public void k() {
        j().X0();
    }

    @Override // androidx.compose.runtime.f
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public void f(int i11, LayoutNode layoutNode) {
        a().u0(i11, layoutNode);
    }

    @Override // androidx.compose.runtime.f
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public void d(int i11, LayoutNode layoutNode) {
    }
}
