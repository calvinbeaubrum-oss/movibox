package androidx.compose.ui.scrollcapture;

import androidx.compose.ui.layout.m;
import androidx.compose.ui.semantics.SemanticsNode;
import kotlin.Metadata;
import q2.r;

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
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SemanticsNode f5579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r f5581c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m f5582d;

    public j(SemanticsNode semanticsNode, int i11, r rVar, m mVar) {
        this.f5579a = semanticsNode;
        this.f5580b = i11;
        this.f5581c = rVar;
        this.f5582d = mVar;
    }

    public final m a() {
        return this.f5582d;
    }

    public final int b() {
        return this.f5580b;
    }

    public final SemanticsNode c() {
        return this.f5579a;
    }

    public final r d() {
        return this.f5581c;
    }

    public String toString() {
        return "ScrollCaptureCandidate(node=" + this.f5579a + ", depth=" + this.f5580b + ", viewportBoundsInWindow=" + this.f5581c + ", coordinates=" + this.f5582d + ')';
    }
}
