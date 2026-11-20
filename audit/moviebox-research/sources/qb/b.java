package qb;

import java.util.List;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class b implements a.InterfaceC0816a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f74491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f74492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a.c f74493c;

    /* JADX WARN: Multi-variable type inference failed */
    public b(List<? extends a> interceptors, int i11, a.c params) {
        Intrinsics.g(interceptors, "interceptors");
        Intrinsics.g(params, "params");
        this.f74491a = interceptors;
        this.f74492b = i11;
        this.f74493c = params;
    }

    @Override // qb.a.InterfaceC0816a
    public a.c a() {
        return this.f74493c;
    }

    @Override // qb.a.InterfaceC0816a
    public a.d b(a.c params) {
        Intrinsics.g(params, "params");
        if (this.f74492b >= this.f74491a.size()) {
            return new a.d(false, 1, null);
        }
        return this.f74491a.get(this.f74492b).c(c(this.f74492b + 1, params));
    }

    public final b c(int i11, a.c cVar) {
        return new b(this.f74491a, i11, cVar);
    }
}
