package co;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f15002c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f15003d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f15004e;

    public a() {
        this(null, null, null, null, null, 31, null);
    }

    public a(String str, String str2, String str3, Integer num, Integer num2) {
        this.f15000a = str;
        this.f15001b = str2;
        this.f15002c = str3;
        this.f15003d = num;
        this.f15004e = num2;
    }

    public /* synthetic */ a(String str, String str2, String str3, Integer num, Integer num2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? null : num, (i11 & 16) != 0 ? null : num2);
    }

    public final String a() {
        return this.f15002c;
    }

    public final Integer b() {
        return this.f15004e;
    }

    public final Integer c() {
        return this.f15003d;
    }

    public final String d() {
        return this.f15001b;
    }

    public final String e() {
        return this.f15000a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.b(this.f15000a, aVar.f15000a) && Intrinsics.b(this.f15001b, aVar.f15001b) && Intrinsics.b(this.f15002c, aVar.f15002c) && Intrinsics.b(this.f15003d, aVar.f15003d) && Intrinsics.b(this.f15004e, aVar.f15004e);
    }

    public int hashCode() {
        String str = this.f15000a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f15001b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f15002c;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.f15003d;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.f15004e;
        return iHashCode4 + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        return "DialogInfo(title=" + this.f15000a + ", subtitle=" + this.f15001b + ", buttonText=" + this.f15002c + ", iconResId=" + this.f15003d + ", iconBgColorResId=" + this.f15004e + ")";
    }
}
