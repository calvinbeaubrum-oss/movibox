package s6;

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
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f76164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f76165b;

    public d(String key, Long l11) {
        Intrinsics.g(key, "key");
        this.f76164a = key;
        this.f76165b = l11;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(String key, boolean z11) {
        this(key, Long.valueOf(z11 ? 1L : 0L));
        Intrinsics.g(key, "key");
    }

    public final String a() {
        return this.f76164a;
    }

    public final Long b() {
        return this.f76165b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return Intrinsics.b(this.f76164a, dVar.f76164a) && Intrinsics.b(this.f76165b, dVar.f76165b);
    }

    public int hashCode() {
        int iHashCode = this.f76164a.hashCode() * 31;
        Long l11 = this.f76165b;
        return iHashCode + (l11 == null ? 0 : l11.hashCode());
    }

    public String toString() {
        return "Preference(key=" + this.f76164a + ", value=" + this.f76165b + ')';
    }
}
