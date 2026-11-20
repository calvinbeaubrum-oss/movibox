package androidx.compose.ui.platform;

import androidx.compose.ui.semantics.SemanticsNode;
import java.util.List;
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
public final class g2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.compose.ui.semantics.l f5480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.collection.d0 f5481b = androidx.collection.q.b();

    public g2(SemanticsNode semanticsNode, androidx.collection.n<h2> nVar) {
        this.f5480a = semanticsNode.w();
        List<SemanticsNode> listT = semanticsNode.t();
        int size = listT.size();
        for (int i11 = 0; i11 < size; i11++) {
            SemanticsNode semanticsNode2 = listT.get(i11);
            if (nVar.a(semanticsNode2.o())) {
                this.f5481b.f(semanticsNode2.o());
            }
        }
    }

    public final androidx.collection.d0 a() {
        return this.f5481b;
    }

    public final androidx.compose.ui.semantics.l b() {
        return this.f5480a;
    }
}
