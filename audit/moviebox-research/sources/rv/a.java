package rv;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l.p;

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
public final class a implements e9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("comment_id")
    private String f75733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f75734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f75735c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f75736d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f75737f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f75738g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f75739h;

    public a(String str, int i11, int i12, boolean z11, long j11, String str2, int i13) {
        this.f75733a = str;
        this.f75734b = i11;
        this.f75735c = i12;
        this.f75736d = z11;
        this.f75737f = j11;
        this.f75738g = str2;
        this.f75739h = i13;
    }

    public final String a() {
        return this.f75733a;
    }

    public final int b() {
        return this.f75735c;
    }

    public final int c() {
        return this.f75739h;
    }

    public final String d() {
        return this.f75738g;
    }

    public final int e() {
        return this.f75734b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.b(this.f75733a, aVar.f75733a) && this.f75734b == aVar.f75734b && this.f75735c == aVar.f75735c && this.f75736d == aVar.f75736d && this.f75737f == aVar.f75737f && Intrinsics.b(this.f75738g, aVar.f75738g) && this.f75739h == aVar.f75739h;
    }

    public final boolean f() {
        return this.f75736d;
    }

    public final void g(boolean z11) {
        this.f75736d = z11;
    }

    @Override // e9.a
    public int getItemType() {
        return 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public int hashCode() {
        String str = this.f75733a;
        int iHashCode = (((((str == null ? 0 : str.hashCode()) * 31) + this.f75734b) * 31) + this.f75735c) * 31;
        boolean z11 = this.f75736d;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int iA = (((iHashCode + r11) * 31) + p.a(this.f75737f)) * 31;
        String str2 = this.f75738g;
        return ((iA + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f75739h;
    }

    public String toString() {
        return "CommentSubLoadMoreBean(commentId=" + this.f75733a + ", subCount=" + this.f75734b + ", currentCount=" + this.f75735c + ", isLoading=" + this.f75736d + ", createTime=" + this.f75737f + ", postId=" + this.f75738g + ", nextPage=" + this.f75739h + ")";
    }
}
