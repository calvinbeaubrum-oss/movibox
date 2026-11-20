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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class c extends g {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f75754e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f75756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f75757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f75758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f75753d = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f75755f = 1;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return c.f75754e;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(int i11, String str, f params) {
        super(null);
        Intrinsics.g(params, "params");
        this.f75756a = i11;
        this.f75757b = str;
        this.f75758c = params;
    }

    public final f b() {
        return this.f75758c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f75756a == cVar.f75756a && Intrinsics.b(this.f75757b, cVar.f75757b) && Intrinsics.b(this.f75758c, cVar.f75758c);
    }

    public int hashCode() {
        int i11 = this.f75756a * 31;
        String str = this.f75757b;
        return ((i11 + (str == null ? 0 : str.hashCode())) * 31) + this.f75758c.hashCode();
    }

    public String toString() {
        return "ShortTvUnlockFail(code=" + this.f75756a + ", msg=" + this.f75757b + ", params=" + this.f75758c + ")";
    }
}
