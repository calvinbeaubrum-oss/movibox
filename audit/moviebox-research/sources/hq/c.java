package hq;

import java.util.HashMap;
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
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f66766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f66767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, String> f66768c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f66769d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f66770e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f66771f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f66772g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f66773h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f66774i;

    public c(String pageName, boolean z11) {
        Intrinsics.g(pageName, "pageName");
        this.f66766a = pageName;
        this.f66767b = z11;
        this.f66768c = new HashMap<>();
        this.f66771f = true;
        this.f66772g = -1L;
    }

    public /* synthetic */ c(String str, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? true : z11);
    }

    public final String a() {
        return this.f66769d;
    }

    public final boolean b() {
        return this.f66767b;
    }

    public final boolean c() {
        return this.f66770e;
    }

    public final boolean d() {
        return this.f66771f;
    }

    public final String e() {
        return this.f66774i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Intrinsics.b(this.f66766a, cVar.f66766a) && this.f66767b == cVar.f66767b;
    }

    public final String f() {
        return this.f66766a;
    }

    public final HashMap<String, String> g() {
        return this.f66768c;
    }

    public final long h() {
        return this.f66772g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        int iHashCode = this.f66766a.hashCode() * 31;
        boolean z11 = this.f66767b;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        return iHashCode + r11;
    }

    public final boolean i() {
        return this.f66773h;
    }

    public final void j(boolean z11) {
        this.f66773h = z11;
    }

    public final void k(long j11) {
        this.f66772g = j11;
    }

    public String toString() {
        return "LogViewConfig(pageName=" + this.f66766a + ", needAddToPageFrom=" + this.f66767b + ")";
    }
}
