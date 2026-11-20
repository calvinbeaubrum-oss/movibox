package f00;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class b implements e9.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f64477i = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f64478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f64479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f64480c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f64481d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f64482f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f64483g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f64484h;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public b(String downloadPath, String downloadShowPath, String pathName, int i11, long j11, int i12) {
        Intrinsics.g(downloadPath, "downloadPath");
        Intrinsics.g(downloadShowPath, "downloadShowPath");
        Intrinsics.g(pathName, "pathName");
        this.f64478a = downloadPath;
        this.f64479b = downloadShowPath;
        this.f64480c = pathName;
        this.f64481d = i11;
        this.f64482f = j11;
        this.f64483g = i12;
    }

    public final long a() {
        return this.f64482f;
    }

    public final String b() {
        return this.f64478a;
    }

    public final String c() {
        return this.f64479b;
    }

    public final String d() {
        return this.f64480c;
    }

    public final int e() {
        return this.f64481d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.b(this.f64478a, bVar.f64478a) && Intrinsics.b(this.f64479b, bVar.f64479b) && Intrinsics.b(this.f64480c, bVar.f64480c) && this.f64481d == bVar.f64481d && this.f64482f == bVar.f64482f && getItemType() == bVar.getItemType();
    }

    public final boolean f() {
        return this.f64484h;
    }

    public final void g(boolean z11) {
        this.f64484h = z11;
    }

    @Override // e9.a
    public int getItemType() {
        return this.f64483g;
    }

    public int hashCode() {
        return (((((((((this.f64478a.hashCode() * 31) + this.f64479b.hashCode()) * 31) + this.f64480c.hashCode()) * 31) + this.f64481d) * 31) + p.a(this.f64482f)) * 31) + getItemType();
    }

    public String toString() {
        return "DownloadSDCardPathInfo(downloadPath=" + this.f64478a + ", downloadShowPath=" + this.f64479b + ", pathName=" + this.f64480c + ", pathType=" + this.f64481d + ", availableSize=" + this.f64482f + ", itemType=" + getItemType() + ")";
    }
}
