package androidx.compose.foundation.lazy;

import androidx.compose.ui.layout.l0;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;

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
public final class g implements androidx.compose.foundation.lazy.layout.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LazyListState f2590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2591b;

    public g(LazyListState lazyListState, int i11) {
        this.f2590a = lazyListState;
        this.f2591b = i11;
    }

    @Override // androidx.compose.foundation.lazy.layout.h
    public void a() {
        l0 l0VarA = this.f2590a.A();
        if (l0VarA != null) {
            l0VarA.d();
        }
    }

    @Override // androidx.compose.foundation.lazy.layout.h
    public boolean b() {
        return !this.f2590a.t().h().isEmpty();
    }

    @Override // androidx.compose.foundation.lazy.layout.h
    public int c() {
        return Math.max(0, this.f2590a.o() - this.f2591b);
    }

    @Override // androidx.compose.foundation.lazy.layout.h
    public int d() {
        return Math.min(getItemCount() - 1, ((j) CollectionsKt___CollectionsKt.q0(this.f2590a.t().h())).getIndex() + this.f2591b);
    }

    @Override // androidx.compose.foundation.lazy.layout.h
    public int getItemCount() {
        return this.f2590a.t().d();
    }
}
