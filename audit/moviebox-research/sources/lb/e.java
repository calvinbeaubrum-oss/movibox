package lb;

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
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f70175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f70176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f70177c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f70178d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f70179e;

    public e(String appId, String name, Integer num, String logoUrl, String str) {
        Intrinsics.g(appId, "appId");
        Intrinsics.g(name, "name");
        Intrinsics.g(logoUrl, "logoUrl");
        this.f70175a = appId;
        this.f70176b = name;
        this.f70177c = num;
        this.f70178d = logoUrl;
        this.f70179e = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return Intrinsics.b(this.f70175a, eVar.f70175a) && Intrinsics.b(this.f70176b, eVar.f70176b) && Intrinsics.b(this.f70177c, eVar.f70177c) && Intrinsics.b(this.f70178d, eVar.f70178d) && Intrinsics.b(this.f70179e, eVar.f70179e);
    }

    public int hashCode() {
        int iHashCode = ((this.f70175a.hashCode() * 31) + this.f70176b.hashCode()) * 31;
        Integer num = this.f70177c;
        int iHashCode2 = (((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + this.f70178d.hashCode()) * 31;
        String str = this.f70179e;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "MiniAppCenterInfoData(appId=" + this.f70175a + ", name=" + this.f70176b + ", logoResId=" + this.f70177c + ", logoUrl=" + this.f70178d + ", logoPath=" + this.f70179e + ')';
    }
}
