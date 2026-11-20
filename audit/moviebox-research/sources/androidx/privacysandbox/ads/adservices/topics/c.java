package androidx.privacysandbox.ads.adservices.topics;

import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f12355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f12356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12357c;

    public c(long j11, long j12, int i11) {
        this.f12355a = j11;
        this.f12356b = j12;
        this.f12357c = i11;
    }

    public final long a() {
        return this.f12356b;
    }

    public final long b() {
        return this.f12355a;
    }

    public final int c() {
        return this.f12357c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f12355a == cVar.f12355a && this.f12356b == cVar.f12356b && this.f12357c == cVar.f12357c;
    }

    public int hashCode() {
        return (((l.p.a(this.f12355a) * 31) + l.p.a(this.f12356b)) * 31) + this.f12357c;
    }

    public String toString() {
        return "Topic { " + ("TaxonomyVersion=" + this.f12355a + ", ModelVersion=" + this.f12356b + ", TopicCode=" + this.f12357c + " }");
    }
}
