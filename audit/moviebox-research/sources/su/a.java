package su;

import com.transsion.memberapi.MemberCheckResult;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public interface a {

    /* JADX INFO: renamed from: su.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0841a {
        public static void a(a aVar, MemberCheckResult memberCheckResult) {
        }

        public static void b(a aVar, String errorMsg) {
            Intrinsics.g(errorMsg, "errorMsg");
        }

        public static void c(a aVar) {
        }

        public static void d(a aVar, MemberCheckResult memberCheckResult) {
        }

        public static void e(a aVar, MemberCheckResult memberCheckResult) {
        }

        public static void f(a aVar, MemberCheckResult memberCheckResult) {
        }
    }

    void a(MemberCheckResult memberCheckResult);

    void b(MemberCheckResult memberCheckResult);

    void c(MemberCheckResult memberCheckResult);

    void d();

    void e(MemberCheckResult memberCheckResult);

    void onFail(String str);
}
