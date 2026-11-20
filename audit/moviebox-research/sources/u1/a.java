package u1;

import kotlin.Metadata;

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
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f78142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f78143b;

    /* JADX WARN: Illegal instructions before constructor call */
    public a() {
        v1.c cVar = v1.c.f78697a;
        this(cVar, cVar);
    }

    public a(Object obj) {
        this(obj, v1.c.f78697a);
    }

    public a(Object obj, Object obj2) {
        this.f78142a = obj;
        this.f78143b = obj2;
    }

    public final boolean a() {
        return this.f78143b != v1.c.f78697a;
    }

    public final boolean b() {
        return this.f78142a != v1.c.f78697a;
    }

    public final Object c() {
        return this.f78143b;
    }

    public final Object d() {
        return this.f78142a;
    }

    public final a e(Object obj) {
        return new a(this.f78142a, obj);
    }

    public final a f(Object obj) {
        return new a(obj, this.f78143b);
    }
}
