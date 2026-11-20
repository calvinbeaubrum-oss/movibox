package wu;

import java.util.List;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f79649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f79650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<? extends Object> f79651c;

    public a(int i11, int i12) {
        this.f79649a = i11;
        this.f79650b = i12;
    }

    public /* synthetic */ a(int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, (i13 & 2) != 0 ? 0 : i12);
    }

    public final int a() {
        return this.f79650b;
    }

    public final List<Object> b() {
        return this.f79651c;
    }

    public final int c() {
        return this.f79649a;
    }

    public final boolean d() {
        return this.f79649a > this.f79650b;
    }

    public final void e(int i11) {
        this.f79650b = i11;
    }

    public final void f(List<? extends Object> list) {
        this.f79651c = list;
    }
}
