package androidx.compose.foundation.layout;

import androidx.compose.runtime.i1;
import androidx.compose.runtime.u2;
import androidx.compose.ui.unit.LayoutDirection;
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
public final class g0 implements h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i1 f2497b;

    public g0(r rVar, String str) {
        this.f2496a = str;
        this.f2497b = u2.c(rVar, null, 2, null);
    }

    @Override // androidx.compose.foundation.layout.h0
    public int a(q2.e eVar) {
        return e().a();
    }

    @Override // androidx.compose.foundation.layout.h0
    public int b(q2.e eVar) {
        return e().d();
    }

    @Override // androidx.compose.foundation.layout.h0
    public int c(q2.e eVar, LayoutDirection layoutDirection) {
        return e().b();
    }

    @Override // androidx.compose.foundation.layout.h0
    public int d(q2.e eVar, LayoutDirection layoutDirection) {
        return e().c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final r e() {
        return (r) this.f2497b.getValue();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g0) {
            return Intrinsics.b(e(), ((g0) obj).e());
        }
        return false;
    }

    public final void f(r rVar) {
        this.f2497b.setValue(rVar);
    }

    public int hashCode() {
        return this.f2496a.hashCode();
    }

    public String toString() {
        return this.f2496a + "(left=" + e().b() + ", top=" + e().d() + ", right=" + e().c() + ", bottom=" + e().a() + ')';
    }
}
