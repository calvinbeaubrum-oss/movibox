package androidx.compose.ui.text.font;

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
public final class i0 implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f5829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5830c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f5831d;

    public final int a() {
        return this.f5828a;
    }

    @Override // androidx.compose.ui.text.font.h
    public u b() {
        return this.f5829b;
    }

    @Override // androidx.compose.ui.text.font.h
    public int c() {
        return this.f5831d;
    }

    @Override // androidx.compose.ui.text.font.h
    public int d() {
        return this.f5830c;
    }

    public final t e() {
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i0)) {
            return false;
        }
        i0 i0Var = (i0) obj;
        if (this.f5828a != i0Var.f5828a || !Intrinsics.b(b(), i0Var.b()) || !q.f(d(), i0Var.d())) {
            return false;
        }
        i0Var.getClass();
        return Intrinsics.b(null, null) && o.e(c(), i0Var.c());
    }

    public int hashCode() {
        b().hashCode();
        q.g(d());
        o.f(c());
        throw null;
    }

    public String toString() {
        return "ResourceFont(resId=" + this.f5828a + ", weight=" + b() + ", style=" + ((Object) q.h(d())) + ", loadingStrategy=" + ((Object) o.g(c())) + ')';
    }
}
