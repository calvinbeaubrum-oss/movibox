package f10;

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
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f64499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f64500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f64501c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f64502d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f64503e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f64504f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f64505g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f64506h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f64507i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f64508j;

    public a(int i11, String str, String codecName, String str2, int i12, long j11, String str3, int i13, int i14, String str4) {
        Intrinsics.g(codecName, "codecName");
        this.f64499a = i11;
        this.f64500b = str;
        this.f64501c = codecName;
        this.f64502d = str2;
        this.f64503e = i12;
        this.f64504f = j11;
        this.f64505g = str3;
        this.f64506h = i13;
        this.f64507i = i14;
        this.f64508j = str4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f64499a == aVar.f64499a && Intrinsics.b(this.f64500b, aVar.f64500b) && Intrinsics.b(this.f64501c, aVar.f64501c) && Intrinsics.b(this.f64502d, aVar.f64502d) && this.f64503e == aVar.f64503e && this.f64504f == aVar.f64504f && Intrinsics.b(this.f64505g, aVar.f64505g) && this.f64506h == aVar.f64506h && this.f64507i == aVar.f64507i && Intrinsics.b(this.f64508j, aVar.f64508j);
    }

    public int hashCode() {
        int i11 = this.f64499a * 31;
        String str = this.f64500b;
        int iHashCode = (((i11 + (str == null ? 0 : str.hashCode())) * 31) + this.f64501c.hashCode()) * 31;
        String str2 = this.f64502d;
        int iHashCode2 = (((((iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f64503e) * 31) + p.a(this.f64504f)) * 31;
        String str3 = this.f64505g;
        int iHashCode3 = (((((iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.f64506h) * 31) + this.f64507i) * 31;
        String str4 = this.f64508j;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "AudioStream(index=" + this.f64499a + ", title=" + this.f64500b + ", codecName=" + this.f64501c + ", language=" + this.f64502d + ", disposition=" + this.f64503e + ", bitRate=" + this.f64504f + ", sampleFormat=" + this.f64505g + ", sampleRate=" + this.f64506h + ", channels=" + this.f64507i + ", channelLayout=" + this.f64508j + ")";
    }
}
