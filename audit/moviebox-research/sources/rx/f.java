package rx;

import java.util.LinkedHashSet;
import java.util.Set;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f75759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f75760b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f75761c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Set<Integer> f75762d;

    public f(String subjectId, Integer num, String str) {
        Intrinsics.g(subjectId, "subjectId");
        this.f75759a = subjectId;
        this.f75760b = num;
        this.f75761c = str;
        this.f75762d = new LinkedHashSet();
    }

    public /* synthetic */ f(String str, Integer num, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? null : num, (i11 & 4) != 0 ? null : str2);
    }

    public final String a() {
        return this.f75761c;
    }

    public final String b() {
        return this.f75759a;
    }

    public final Integer c() {
        return this.f75760b;
    }

    public final Set<Integer> d() {
        return this.f75762d;
    }
}
