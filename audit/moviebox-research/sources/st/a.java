package st;

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
    public String f76458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f76459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f76460c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f76461d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f76462e;

    public a(String filterValue, String filterName, String filterType, boolean z11, String str) {
        Intrinsics.g(filterValue, "filterValue");
        Intrinsics.g(filterName, "filterName");
        Intrinsics.g(filterType, "filterType");
        this.f76458a = filterValue;
        this.f76459b = filterName;
        this.f76460c = filterType;
        this.f76461d = z11;
        this.f76462e = str;
    }

    public /* synthetic */ a(String str, String str2, String str3, boolean z11, String str4, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, z11, (i11 & 16) != 0 ? null : str4);
    }

    public final String a() {
        return this.f76459b;
    }

    public final String b() {
        return this.f76460c;
    }

    public final String c() {
        return this.f76458a;
    }

    public final boolean d() {
        return this.f76461d;
    }

    public final void e(boolean z11) {
        this.f76461d = z11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.b(this.f76458a, aVar.f76458a) && Intrinsics.b(this.f76459b, aVar.f76459b) && Intrinsics.b(this.f76460c, aVar.f76460c) && this.f76461d == aVar.f76461d && Intrinsics.b(this.f76462e, aVar.f76462e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    public int hashCode() {
        int iHashCode = ((((this.f76458a.hashCode() * 31) + this.f76459b.hashCode()) * 31) + this.f76460c.hashCode()) * 31;
        boolean z11 = this.f76461d;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int i11 = (iHashCode + r11) * 31;
        String str = this.f76462e;
        return i11 + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "FilterItem(filterValue=" + this.f76458a + ", filterName=" + this.f76459b + ", filterType=" + this.f76460c + ", isSelected=" + this.f76461d + ", filterRangeValue=" + this.f76462e + ")";
    }
}
