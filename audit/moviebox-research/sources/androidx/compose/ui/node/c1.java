package androidx.compose.ui.node;

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
public final class c1 implements z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.compose.ui.layout.w f5073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LookaheadCapablePlaceable f5074b;

    public c1(androidx.compose.ui.layout.w wVar, LookaheadCapablePlaceable lookaheadCapablePlaceable) {
        this.f5073a = wVar;
        this.f5074b = lookaheadCapablePlaceable;
    }

    public final LookaheadCapablePlaceable a() {
        return this.f5074b;
    }

    public final androidx.compose.ui.layout.w b() {
        return this.f5073a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c1)) {
            return false;
        }
        c1 c1Var = (c1) obj;
        return Intrinsics.b(this.f5073a, c1Var.f5073a) && Intrinsics.b(this.f5074b, c1Var.f5074b);
    }

    public int hashCode() {
        return (this.f5073a.hashCode() * 31) + this.f5074b.hashCode();
    }

    @Override // androidx.compose.ui.node.z0
    public boolean isValidOwnerScope() {
        return this.f5074b.U0().D();
    }

    public String toString() {
        return "PlaceableResult(result=" + this.f5073a + ", placeable=" + this.f5074b + ')';
    }
}
