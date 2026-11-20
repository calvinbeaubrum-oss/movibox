package androidx.compose.ui.semantics;

import androidx.compose.ui.node.LayoutNode;
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
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LayoutNode f5691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f5692b;

    public p(LayoutNode layoutNode, f fVar) {
        this.f5691a = layoutNode;
        this.f5692b = fVar;
    }

    public final SemanticsNode a() {
        return new SemanticsNode(this.f5692b, false, this.f5691a, new l());
    }
}
