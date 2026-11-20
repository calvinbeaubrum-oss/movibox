package f10;

import androidx.compose.animation.core.r;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f64518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f64519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f64520c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f64521d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f64522e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f64523f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final double f64524g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f64525h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f64526i;

    public d(int i11, String str, String codecName, String str2, int i12, long j11, double d11, int i13, int i14) {
        Intrinsics.g(codecName, "codecName");
        this.f64518a = i11;
        this.f64519b = str;
        this.f64520c = codecName;
        this.f64521d = str2;
        this.f64522e = i12;
        this.f64523f = j11;
        this.f64524g = d11;
        this.f64525h = i13;
        this.f64526i = i14;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f64518a == dVar.f64518a && Intrinsics.b(this.f64519b, dVar.f64519b) && Intrinsics.b(this.f64520c, dVar.f64520c) && Intrinsics.b(this.f64521d, dVar.f64521d) && this.f64522e == dVar.f64522e && this.f64523f == dVar.f64523f && Double.compare(this.f64524g, dVar.f64524g) == 0 && this.f64525h == dVar.f64525h && this.f64526i == dVar.f64526i;
    }

    public int hashCode() {
        int i11 = this.f64518a * 31;
        String str = this.f64519b;
        int iHashCode = (((i11 + (str == null ? 0 : str.hashCode())) * 31) + this.f64520c.hashCode()) * 31;
        String str2 = this.f64521d;
        return ((((((((((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f64522e) * 31) + p.a(this.f64523f)) * 31) + r.a(this.f64524g)) * 31) + this.f64525h) * 31) + this.f64526i;
    }

    public String toString() {
        return "VideoStream(index=" + this.f64518a + ", title=" + this.f64519b + ", codecName=" + this.f64520c + ", language=" + this.f64521d + ", disposition=" + this.f64522e + ", bitRate=" + this.f64523f + ", frameRate=" + this.f64524g + ", frameWidth=" + this.f64525h + ", frameHeight=" + this.f64526i + ")";
    }
}
