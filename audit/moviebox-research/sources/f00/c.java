package f00;

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
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f64485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f64486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f64487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f64488d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f64489e;

    public c(String subjectId, int i11, boolean z11, boolean z12, boolean z13) {
        Intrinsics.g(subjectId, "subjectId");
        this.f64485a = subjectId;
        this.f64486b = i11;
        this.f64487c = z11;
        this.f64488d = z12;
        this.f64489e = z13;
    }

    public /* synthetic */ c(String str, int i11, boolean z11, boolean z12, boolean z13, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i11, (i12 & 4) != 0 ? false : z11, (i12 & 8) != 0 ? false : z12, (i12 & 16) != 0 ? false : z13);
    }

    public final int a() {
        return this.f64486b;
    }

    public final boolean b() {
        return this.f64489e;
    }

    public final boolean c() {
        return this.f64487c;
    }

    public final boolean d() {
        return this.f64488d;
    }

    public final void e(boolean z11) {
        this.f64489e = z11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Intrinsics.b(this.f64485a, cVar.f64485a) && this.f64486b == cVar.f64486b && this.f64487c == cVar.f64487c && this.f64488d == cVar.f64488d && this.f64489e == cVar.f64489e;
    }

    public final void f(boolean z11) {
        this.f64487c = z11;
    }

    public final void g(boolean z11) {
        this.f64488d = z11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((this.f64485a.hashCode() * 31) + this.f64486b) * 31;
        boolean z11 = this.f64487c;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int i11 = (iHashCode + r11) * 31;
        boolean z12 = this.f64488d;
        ?? r12 = z12;
        if (z12) {
            r12 = 1;
        }
        int i12 = (i11 + r12) * 31;
        boolean z13 = this.f64489e;
        return i12 + (z13 ? 1 : z13);
    }

    public String toString() {
        return "DownloadShortTVEpisodeSelectItem(subjectId=" + this.f64485a + ", position=" + this.f64486b + ", isFree=" + this.f64487c + ", isSelect=" + this.f64488d + ", isDownload=" + this.f64489e + ")";
    }
}
