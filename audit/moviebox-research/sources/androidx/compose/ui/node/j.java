package androidx.compose.ui.node;

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
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DepthSortedSet f5083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DepthSortedSet f5084b;

    public j(boolean z11) {
        this.f5083a = new DepthSortedSet(z11);
        this.f5084b = new DepthSortedSet(z11);
    }

    public final void c(LayoutNode layoutNode, boolean z11) {
        if (z11) {
            this.f5083a.a(layoutNode);
            this.f5084b.a(layoutNode);
        } else {
            if (this.f5083a.b(layoutNode)) {
                return;
            }
            this.f5084b.a(layoutNode);
        }
    }

    public final boolean d(LayoutNode layoutNode) {
        return this.f5083a.b(layoutNode) || this.f5084b.b(layoutNode);
    }

    public final boolean e(LayoutNode layoutNode, boolean z11) {
        boolean zB = this.f5083a.b(layoutNode);
        if (z11) {
            return zB;
        }
        return zB || this.f5084b.b(layoutNode);
    }

    public final boolean f() {
        return this.f5084b.d() && this.f5083a.d();
    }

    public final boolean g(boolean z11) {
        return (z11 ? this.f5083a : this.f5084b).d();
    }

    public final boolean h() {
        return !f();
    }

    public final boolean i(LayoutNode layoutNode) {
        return this.f5084b.f(layoutNode) || this.f5083a.f(layoutNode);
    }
}
