package rt;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.home.bean.FilterItems;
import com.transsion.home.bean.MovieBean;
import com.transsion.home.bean.RefreshBaseDto;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okhttp3.RequestBody;
import y30.f;
import y30.o;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public interface b {
    @o("/wefeed-mobile-bff/subject-api/list")
    Object a(@t("host") String str, @y30.a RequestBody requestBody, Continuation<? super RefreshBaseDto<MovieBean>> continuation);

    @f("/wefeed-mobile-bff/subject-api/filter-items")
    Object b(@t("host") String str, @t("tabId") int i11, @t("filterItemVer") String str2, Continuation<? super BaseDto<FilterItems>> continuation);
}
