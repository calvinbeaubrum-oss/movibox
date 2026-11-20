package be;

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
public final class b implements a.InterfaceC0143a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f14095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a.b f14097c;

    /* JADX WARN: Multi-variable type inference failed */
    public b(List<? extends a> interceptors, int i11, a.b params) {
        Intrinsics.g(interceptors, "interceptors");
        Intrinsics.g(params, "params");
        this.f14095a = interceptors;
        this.f14096b = i11;
        this.f14097c = params;
    }

    @Override // be.a.InterfaceC0143a
    public a.b a() {
        return this.f14097c;
    }

    @Override // be.a.InterfaceC0143a
    public a.c b(a.b params) {
        Intrinsics.g(params, "params");
        if (this.f14096b >= this.f14095a.size()) {
            return new a.c(null, 1, null);
        }
        return this.f14095a.get(this.f14096b).a(c(this.f14096b + 1, params));
    }

    public final b c(int i11, a.b bVar) {
        return new b(this.f14095a, i11, bVar);
    }
}
