package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

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
public final class MatchGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f69139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IntRange f69140b;

    public MatchGroup(String value, IntRange range) {
        Intrinsics.g(value, "value");
        Intrinsics.g(range, "range");
        this.f69139a = value;
        this.f69140b = range;
    }

    public final String a() {
        return this.f69139a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MatchGroup)) {
            return false;
        }
        MatchGroup matchGroup = (MatchGroup) obj;
        return Intrinsics.b(this.f69139a, matchGroup.f69139a) && Intrinsics.b(this.f69140b, matchGroup.f69140b);
    }

    public int hashCode() {
        return (this.f69139a.hashCode() * 31) + this.f69140b.hashCode();
    }

    public String toString() {
        return "MatchGroup(value=" + this.f69139a + ", range=" + this.f69140b + ')';
    }
}
