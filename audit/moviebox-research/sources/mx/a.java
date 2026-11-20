package mx;

import com.transsion.share.bean.ShareType;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ShareType f71302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f71303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f71304c;

    public a(ShareType shareType, int i11, String shareName) {
        Intrinsics.g(shareType, "shareType");
        Intrinsics.g(shareName, "shareName");
        this.f71302a = shareType;
        this.f71303b = i11;
        this.f71304c = shareName;
    }

    public final int a() {
        return this.f71303b;
    }

    public final String b() {
        return this.f71304c;
    }

    public final ShareType c() {
        return this.f71302a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f71302a == aVar.f71302a && this.f71303b == aVar.f71303b && Intrinsics.b(this.f71304c, aVar.f71304c);
    }

    public int hashCode() {
        return (((this.f71302a.hashCode() * 31) + this.f71303b) * 31) + this.f71304c.hashCode();
    }

    public String toString() {
        return "ShareData(shareType=" + this.f71302a + ", shareIconId=" + this.f71303b + ", shareName=" + this.f71304c + ")";
    }
}
