package ga;

import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0686a f65463a = C0686a.f65464a;

    /* JADX INFO: renamed from: ga.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0686a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ C0686a f65464a = new C0686a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static String f65465b = "api.fat1.eagllwin.com";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static String f65466c = "api.test.eagllwin.com";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static String f65467d = "api.pre.eagllwin.com";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static String f65468e = "api.eagllwin.com";

        public final String a() {
            return f65465b;
        }

        public final String b() {
            return f65467d;
        }

        public final String c() {
            return f65468e;
        }

        public final String d() {
            return f65466c;
        }
    }
}
