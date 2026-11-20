package androidx.compose.foundation.lazy;

import androidx.compose.runtime.e1;
import androidx.compose.runtime.n2;
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
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e1 f2807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e1 f2808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2809c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f2810d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final androidx.compose.foundation.lazy.layout.u f2811e;

    public v(int i11, int i12) {
        this.f2807a = n2.a(i11);
        this.f2808b = n2.a(i12);
        this.f2811e = new androidx.compose.foundation.lazy.layout.u(i11, 30, 100);
    }

    public final int a() {
        return this.f2807a.getIntValue();
    }

    public final androidx.compose.foundation.lazy.layout.u b() {
        return this.f2811e;
    }

    public final int c() {
        return this.f2808b.getIntValue();
    }

    public final void d(int i11, int i12) {
        g(i11, i12);
        this.f2810d = null;
    }

    public final void e(int i11) {
        this.f2807a.setIntValue(i11);
    }

    public final void f(int i11) {
        this.f2808b.setIntValue(i11);
    }

    public final void g(int i11, int i12) {
        if (i11 >= 0.0f) {
            e(i11);
            this.f2811e.e(i11);
            f(i12);
        } else {
            throw new IllegalArgumentException(("Index should be non-negative (" + i11 + ')').toString());
        }
    }

    public final void h(m mVar) {
        n nVarR = mVar.r();
        this.f2810d = nVarR != null ? nVarR.getKey() : null;
        if (this.f2809c || mVar.d() > 0) {
            this.f2809c = true;
            int iS = mVar.s();
            if (iS >= 0.0f) {
                n nVarR2 = mVar.r();
                g(nVarR2 != null ? nVarR2.getIndex() : 0, iS);
            } else {
                throw new IllegalStateException(("scrollOffset should be non-negative (" + iS + ')').toString());
            }
        }
    }

    public final void i(int i11) {
        if (i11 >= 0.0f) {
            f(i11);
            return;
        }
        throw new IllegalStateException(("scrollOffset should be non-negative (" + i11 + ')').toString());
    }

    public final int j(k kVar, int i11) {
        int iA = androidx.compose.foundation.lazy.layout.n.a(kVar, this.f2810d, i11);
        if (i11 != iA) {
            e(iA);
            this.f2811e.e(i11);
        }
        return iA;
    }
}
