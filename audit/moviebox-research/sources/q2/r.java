package q2;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class r {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f74247e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final r f74248f = new r(0, 0, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f74249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f74250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f74251c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f74252d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final r a() {
            return r.f74248f;
        }
    }

    public r(int i11, int i12, int i13, int i14) {
        this.f74249a = i11;
        this.f74250b = i12;
        this.f74251c = i13;
        this.f74252d = i14;
    }

    public static /* synthetic */ r c(r rVar, int i11, int i12, int i13, int i14, int i15, Object obj) {
        if ((i15 & 1) != 0) {
            i11 = rVar.f74249a;
        }
        if ((i15 & 2) != 0) {
            i12 = rVar.f74250b;
        }
        if ((i15 & 4) != 0) {
            i13 = rVar.f74251c;
        }
        if ((i15 & 8) != 0) {
            i14 = rVar.f74252d;
        }
        return rVar.b(i11, i12, i13, i14);
    }

    public final r b(int i11, int i12, int i13, int i14) {
        return new r(i11, i12, i13, i14);
    }

    public final int d() {
        return this.f74252d;
    }

    public final int e() {
        return this.f74252d - this.f74250b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return this.f74249a == rVar.f74249a && this.f74250b == rVar.f74250b && this.f74251c == rVar.f74251c && this.f74252d == rVar.f74252d;
    }

    public final int f() {
        return this.f74249a;
    }

    public final int g() {
        return this.f74251c;
    }

    public final int h() {
        return this.f74250b;
    }

    public int hashCode() {
        return (((((this.f74249a * 31) + this.f74250b) * 31) + this.f74251c) * 31) + this.f74252d;
    }

    public final long i() {
        return q.a(this.f74249a, this.f74250b);
    }

    public final int j() {
        return this.f74251c - this.f74249a;
    }

    public final boolean k() {
        return this.f74249a >= this.f74251c || this.f74250b >= this.f74252d;
    }

    public final r l(int i11, int i12) {
        return new r(this.f74249a + i11, this.f74250b + i12, this.f74251c + i11, this.f74252d + i12);
    }

    public String toString() {
        return "IntRect.fromLTRB(" + this.f74249a + ", " + this.f74250b + ", " + this.f74251c + ", " + this.f74252d + ')';
    }
}
