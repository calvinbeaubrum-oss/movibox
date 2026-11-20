package rx;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class i extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f75764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f75765b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(f params, Object obj) {
        super(null);
        Intrinsics.g(params, "params");
        this.f75764a = params;
        this.f75765b = obj;
    }

    public /* synthetic */ i(f fVar, Object obj, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(fVar, (i11 & 2) != 0 ? null : obj);
    }

    public final f a() {
        return this.f75764a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return Intrinsics.b(this.f75764a, iVar.f75764a) && Intrinsics.b(this.f75765b, iVar.f75765b);
    }

    public int hashCode() {
        int iHashCode = this.f75764a.hashCode() * 31;
        Object obj = this.f75765b;
        return iHashCode + (obj == null ? 0 : obj.hashCode());
    }

    public String toString() {
        return "ShortTvUnlockSuccess(params=" + this.f75764a + ", body=" + this.f75765b + ")";
    }
}
