package ay;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.subtitle_download.bean.SubtitleListBean;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import y30.f;
import y30.t;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public interface a {
    @f("/wefeed-mobile-bff/subject-api/get-stream-captions")
    Object a(@t("host") String str, @t("subjectId") String str2, @t("streamId") String str3, Continuation<? super BaseDto<SubtitleListBean>> continuation);

    @f("/wefeed-mobile-bff/subject-api/get-ext-captions")
    Object b(@t("host") String str, @t("subjectId") String str2, @t("resourceId") String str3, @t("episode") int i11, Continuation<? super BaseDto<SubtitleListBean>> continuation);
}
