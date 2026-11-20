package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.node.l0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
final class NestedScrollElement extends l0<NestedScrollNode> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f4622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NestedScrollDispatcher f4623c;

    public NestedScrollElement(b bVar, NestedScrollDispatcher nestedScrollDispatcher) {
        this.f4622b = bVar;
        this.f4623c = nestedScrollDispatcher;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof NestedScrollElement)) {
            return false;
        }
        NestedScrollElement nestedScrollElement = (NestedScrollElement) obj;
        return Intrinsics.b(nestedScrollElement.f4622b, this.f4622b) && Intrinsics.b(nestedScrollElement.f4623c, this.f4623c);
    }

    public int hashCode() {
        int iHashCode = this.f4622b.hashCode() * 31;
        NestedScrollDispatcher nestedScrollDispatcher = this.f4623c;
        return iHashCode + (nestedScrollDispatcher != null ? nestedScrollDispatcher.hashCode() : 0);
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public NestedScrollNode a() {
        return new NestedScrollNode(this.f4622b, this.f4623c);
    }

    @Override // androidx.compose.ui.node.l0
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void o(NestedScrollNode nestedScrollNode) {
        nestedScrollNode.O1(this.f4622b, this.f4623c);
    }
}
