package wo;

import com.tn.lib.net.cons.HeaderType;
import kotlin.Metadata;
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
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f79573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f79574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f79575c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HeaderType f79576d = HeaderType.ONE_ROOM;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f79577e;

    public final HeaderType a() {
        return this.f79576d;
    }

    public final String b() {
        return this.f79575c;
    }

    public final boolean c() {
        return this.f79573a;
    }

    public final boolean d() {
        return this.f79574b;
    }

    public final void e(boolean z11) {
        this.f79573a = z11;
    }

    public final void f(boolean z11) {
        this.f79574b = z11;
    }

    public final void g(long j11) {
        this.f79577e = j11;
    }

    public final void h(String str) {
        Intrinsics.g(str, "<set-?>");
        this.f79575c = str;
    }
}
