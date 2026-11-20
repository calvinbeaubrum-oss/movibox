package dy;

import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

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
public interface a {

    /* JADX INFO: renamed from: dy.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0651a {
        public static /* synthetic */ Object a(a aVar, int i11, Continuation continuation, int i12, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getDownloadFailureList");
            }
            if ((i12 & 1) != 0) {
                i11 = 6;
            }
            return aVar.d(i11, continuation);
        }
    }

    Object a(String str, Continuation<? super List<SubtitleDownloadTable>> continuation);

    Object b(String str, Continuation<? super Unit> continuation);

    SubtitleDownloadTable c(String str, int i11);

    Object d(int i11, Continuation<? super List<SubtitleDownloadTable>> continuation);

    Object e(SubtitleDownloadTable subtitleDownloadTable, Continuation<? super Unit> continuation);

    void f(SubtitleDownloadTable subtitleDownloadTable);

    void g(SubtitleDownloadTable subtitleDownloadTable);
}
