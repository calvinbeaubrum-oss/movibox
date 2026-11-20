package o1;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface a extends f {

    /* JADX INFO: renamed from: o1.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0776a implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f72251a;

        public C0776a(b bVar) {
            this.f72251a = bVar;
        }

        public final b a() {
            return this.f72251a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements a {
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f72252a;

        public c(b bVar) {
            this.f72252a = bVar;
        }

        public final b a() {
            return this.f72252a;
        }
    }
}
