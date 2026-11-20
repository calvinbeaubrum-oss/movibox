package tr;

import com.transsion.baselib.db.download.DownloadBean;
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
public interface c {
    Object A(String str, int i11, int i12, Continuation<? super DownloadBean> continuation);

    Object B(String str, Continuation<? super DownloadBean> continuation);

    Object C(String str, Continuation<? super List<? extends DownloadBean>> continuation);

    Object D(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, Continuation<? super Unit> continuation);

    Object a(String str, Continuation<? super Unit> continuation);

    Object b(String str, Continuation<? super DownloadBean> continuation);

    Object c(String str, String str2, Continuation<? super Unit> continuation);

    Object d(Continuation<? super List<? extends DownloadBean>> continuation);

    Object e(int i11, Continuation<? super List<? extends DownloadBean>> continuation);

    Object f(Continuation<? super List<? extends DownloadBean>> continuation);

    Object g(Continuation<? super List<? extends DownloadBean>> continuation);

    Object h(String str, int i11, Continuation<? super Unit> continuation);

    Object i(Continuation<? super List<? extends DownloadBean>> continuation);

    Object j(String str, long j11, Continuation<? super Unit> continuation);

    Object k(String str, Continuation<? super List<? extends DownloadBean>> continuation);

    Object l(String str, Continuation<? super List<? extends DownloadBean>> continuation);

    Object m(String str, int i11, Continuation<? super DownloadBean> continuation);

    Object n(String str, int i11, int i12, Continuation<? super Unit> continuation);

    Object o(Continuation<? super List<? extends DownloadBean>> continuation);

    Object p(String str, Continuation<? super Unit> continuation);

    Object q(String str, Continuation<? super Unit> continuation);

    Object r(String str, Continuation<? super List<? extends DownloadBean>> continuation);

    Object s(String str, long j11, Continuation<? super Unit> continuation);

    Object t(DownloadBean downloadBean, Continuation<? super Unit> continuation);

    Object u(String str, long j11, Continuation<? super Unit> continuation);

    Object v(Continuation<? super DownloadBean> continuation);

    Object w(DownloadBean downloadBean, Continuation<? super Unit> continuation);

    Object x(String str, int i11, Continuation<? super DownloadBean> continuation);

    Object y(Continuation<? super DownloadBean> continuation);

    Object z(String str, Continuation<? super DownloadBean> continuation);
}
