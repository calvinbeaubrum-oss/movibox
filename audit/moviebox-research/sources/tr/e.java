package tr;

import com.transsion.baselib.db.download.DownloadEsBean;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public interface e {
    Object a(String str, Continuation<? super Unit> continuation);

    Object b(String str, Continuation<? super DownloadEsBean> continuation);

    Object c(DownloadEsBean downloadEsBean, Continuation<? super Unit> continuation);

    Object d(Continuation<? super List<DownloadEsBean>> continuation);

    Object e(int i11, Continuation<? super List<DownloadEsBean>> continuation);

    Object f(Continuation<? super List<DownloadEsBean>> continuation);

    Object g(Continuation<? super List<DownloadEsBean>> continuation);

    Object h(String str, int i11, Continuation<? super Unit> continuation);

    Object i(Continuation<? super List<DownloadEsBean>> continuation);

    Object j(String str, long j11, Continuation<? super Unit> continuation);

    Object k(DownloadEsBean downloadEsBean, Continuation<? super Unit> continuation);
}
