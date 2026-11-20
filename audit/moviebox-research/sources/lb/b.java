package lb;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f70165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f70166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f70167c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f70168d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f70169e;

    public b(long j11, long j12, long j13, int i11, String foregroundRandomId) {
        Intrinsics.g(foregroundRandomId, "foregroundRandomId");
        this.f70165a = j11;
        this.f70166b = j12;
        this.f70167c = j13;
        this.f70168d = i11;
        this.f70169e = foregroundRandomId;
    }

    public final long a() {
        return this.f70167c;
    }

    public final long b() {
        return this.f70166b;
    }

    public final String c() {
        return this.f70169e;
    }

    public final int d() {
        return this.f70168d;
    }

    public final long e() {
        return this.f70165a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f70165a == bVar.f70165a && this.f70166b == bVar.f70166b && this.f70167c == bVar.f70167c && this.f70168d == bVar.f70168d && Intrinsics.b(this.f70169e, bVar.f70169e);
    }

    public int hashCode() {
        return (((((((p.a(this.f70165a) * 31) + p.a(this.f70166b)) * 31) + p.a(this.f70167c)) * 31) + this.f70168d) * 31) + this.f70169e.hashCode();
    }

    public String toString() {
        return "ForegroundRangTime(startTime=" + this.f70165a + ", endTime=" + this.f70166b + ", costTime=" + this.f70167c + ", foregroundStartCount=" + this.f70168d + ", foregroundRandomId=" + this.f70169e + ')';
    }
}
