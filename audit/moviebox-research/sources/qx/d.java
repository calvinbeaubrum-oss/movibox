package qx;

import com.transsion.moviedetailapi.bean.ShortTVItem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class d extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f74989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f74990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ShortTVItem f74991c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f74992d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f74993e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(String subjectId, int i11, ShortTVItem shortTVItem, int i12) {
        super(null);
        Intrinsics.g(subjectId, "subjectId");
        this.f74989a = subjectId;
        this.f74990b = i11;
        this.f74991c = shortTVItem;
        this.f74992d = i12;
    }

    public /* synthetic */ d(String str, int i11, ShortTVItem shortTVItem, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i11, (i13 & 4) != 0 ? null : shortTVItem, (i13 & 8) != 0 ? 0 : i12);
    }

    public final int a() {
        return this.f74992d;
    }

    public final int b() {
        return this.f74990b;
    }

    public final ShortTVItem c() {
        return this.f74991c;
    }

    public final String d() {
        return this.f74989a;
    }

    public final boolean e() {
        ShortTVItem shortTVItem = this.f74991c;
        if (shortTVItem != null) {
            return shortTVItem.getLockStatus() == 1;
        }
        return this.f74993e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.b(d.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.e(obj, "null cannot be cast to non-null type com.transsion.shorttv.source.ShortTvEpisodeSelectItem");
        d dVar = (d) obj;
        return Intrinsics.b(this.f74989a, dVar.f74989a) && this.f74990b == dVar.f74990b;
    }

    public final void f(int i11) {
        this.f74992d = i11;
    }

    public final void g(boolean z11) {
        this.f74993e = z11;
        ShortTVItem shortTVItem = this.f74991c;
        if (shortTVItem == null) {
            return;
        }
        shortTVItem.setLockStatus(1);
    }

    public final void h(ShortTVItem shortTVItem) {
        this.f74991c = shortTVItem;
    }

    public int hashCode() {
        return (this.f74989a.hashCode() * 31) + this.f74990b;
    }

    public String toString() {
        return "ShortTvEpisodeSelectItem(subjectId=" + this.f74989a + ", ep=" + this.f74990b + ", item=" + this.f74991c + ", downloadStatus=" + this.f74992d + ")";
    }
}
