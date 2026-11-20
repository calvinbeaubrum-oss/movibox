package kotlinx.coroutines.flow;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public interface d1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f69383a = a.f69384a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f69384a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d1 f69385b = new e1();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d1 f69386c = new StartedLazily();

        public static /* synthetic */ d1 b(a aVar, long j11, long j12, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                j11 = 0;
            }
            if ((i11 & 2) != 0) {
                j12 = Long.MAX_VALUE;
            }
            return aVar.a(j11, j12);
        }

        public final d1 a(long j11, long j12) {
            return new StartedWhileSubscribed(j11, j12);
        }

        public final d1 c() {
            return f69385b;
        }

        public final d1 d() {
            return f69386c;
        }
    }

    kotlinx.coroutines.flow.a<SharingCommand> a(f1<Integer> f1Var);
}
