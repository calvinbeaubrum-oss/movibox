package o1;

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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface k extends f {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f72256a;

        public a(b bVar) {
            this.f72256a = bVar;
        }

        public final b a() {
            return this.f72256a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f72257a;

        public b(long j11) {
            this.f72257a = j11;
        }

        public /* synthetic */ b(long j11, DefaultConstructorMarker defaultConstructorMarker) {
            this(j11);
        }

        public final long a() {
            return this.f72257a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f72258a;

        public c(b bVar) {
            this.f72258a = bVar;
        }

        public final b a() {
            return this.f72258a;
        }
    }
}
