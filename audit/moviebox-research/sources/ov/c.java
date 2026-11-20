package ov;

import com.google.common.collect.ImmutableList;
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
    public final ImmutableList<d> f73442a;

    /* JADX WARN: Multi-variable type inference failed */
    public c() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public c(ImmutableList<d> groups) {
        Intrinsics.g(groups, "groups");
        this.f73442a = groups;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ c(ImmutableList immutableList, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i11 & 1) != 0) {
            immutableList = ImmutableList.of();
            Intrinsics.f(immutableList, "of()");
        }
        this(immutableList);
    }

    public final ImmutableList<d> a() {
        return this.f73442a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && Intrinsics.b(this.f73442a, ((c) obj).f73442a);
    }

    public int hashCode() {
        return this.f73442a.hashCode();
    }

    public String toString() {
        return "TnTracks(groups=" + this.f73442a + ")";
    }
}
