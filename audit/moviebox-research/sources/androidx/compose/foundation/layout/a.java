package androidx.compose.foundation.layout;

import androidx.compose.runtime.i1;
import androidx.compose.runtime.u2;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.WindowInsetsCompat;
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
public final class a implements h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i1 f2475c = u2.c(c3.c.f14553e, null, 2, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i1 f2476d = u2.c(Boolean.TRUE, null, 2, null);

    public a(int i11, String str) {
        this.f2473a = i11;
        this.f2474b = str;
    }

    @Override // androidx.compose.foundation.layout.h0
    public int a(q2.e eVar) {
        return e().f14557d;
    }

    @Override // androidx.compose.foundation.layout.h0
    public int b(q2.e eVar) {
        return e().f14555b;
    }

    @Override // androidx.compose.foundation.layout.h0
    public int c(q2.e eVar, LayoutDirection layoutDirection) {
        return e().f14554a;
    }

    @Override // androidx.compose.foundation.layout.h0
    public int d(q2.e eVar, LayoutDirection layoutDirection) {
        return e().f14556c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final c3.c e() {
        return (c3.c) this.f2475c.getValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.f2473a == ((a) obj).f2473a;
    }

    public final void f(c3.c cVar) {
        this.f2475c.setValue(cVar);
    }

    public final void g(boolean z11) {
        this.f2476d.setValue(Boolean.valueOf(z11));
    }

    public final void h(WindowInsetsCompat windowInsetsCompat, int i11) {
        if (i11 == 0 || (i11 & this.f2473a) != 0) {
            f(windowInsetsCompat.getInsets(this.f2473a));
            g(windowInsetsCompat.isVisible(this.f2473a));
        }
    }

    public int hashCode() {
        return this.f2473a;
    }

    public String toString() {
        return this.f2474b + '(' + e().f14554a + ", " + e().f14555b + ", " + e().f14556c + ", " + e().f14557d + ')';
    }
}
