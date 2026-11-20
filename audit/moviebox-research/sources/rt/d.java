package rt;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.home.bean.AppTab;
import com.transsion.home.bean.HotItemsBean;
import com.transsion.home.bean.HotSubjectEntity;
import com.transsion.home.bean.RoomEntranceResponse;
import com.transsion.home.bean.SubOperateData;
import com.transsion.home.bean.TrendingRespData;
import com.transsion.moviedetailapi.bean.MainOperateData;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public interface d {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public static /* synthetic */ Object a(d dVar, String str, int i11, Continuation continuation, int i12, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getHotSearch");
            }
            if ((i12 & 1) != 0) {
                str = cp.a.f62775a.a();
            }
            return dVar.f(str, i11, continuation);
        }

        public static /* synthetic */ Object b(d dVar, String str, int i11, int i12, String str2, Continuation continuation, int i13, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMainOperation");
            }
            if ((i13 & 1) != 0) {
                str = cp.a.f62775a.a();
            }
            return dVar.d(str, i11, (i13 & 4) != 0 ? 0 : i12, str2, continuation);
        }

        public static /* synthetic */ Object c(d dVar, String str, int i11, Continuation continuation, int i12, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getRoomPostEntrance");
            }
            if ((i12 & 1) != 0) {
                str = cp.a.f62775a.a();
            }
            return dVar.a(str, i11, continuation);
        }

        public static /* synthetic */ Object d(d dVar, String str, int i11, String str2, Continuation continuation, int i12, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSubOperation");
            }
            if ((i12 & 1) != 0) {
                str = cp.a.f62775a.a();
            }
            return dVar.g(str, i11, str2, continuation);
        }
    }

    @f("/wefeed-mobile-bff/community/trending-entrance")
    Object a(@t("host") String str, @t("postNum") int i11, Continuation<? super BaseDto<RoomEntranceResponse>> continuation);

    @f("/wefeed-mobile-bff/subject-api/bottom-tab")
    Object b(@t("host") String str, Continuation<? super BaseDto<AppTab>> continuation);

    @o("/wefeed-mobile-bff/subject-api/trending/v2")
    Object c(@t("host") String str, @y30.a RequestBody requestBody, Continuation<? super BaseDto<TrendingRespData>> continuation);

    @f("/wefeed-mobile-bff/tab-operating")
    Object d(@t("host") String str, @t("page") int i11, @t("tabId") int i12, @t("version") String str2, Continuation<? super BaseDto<MainOperateData>> continuation);

    @o("/wefeed-mobile-bff/subject-api/top-rec")
    Object e(@t("host") String str, @y30.a RequestBody requestBody, Continuation<? super BaseDto<HotItemsBean>> continuation);

    @f("/wefeed-mobile-bff/subject-api/search-rank")
    Object f(@t("host") String str, @t("everyoneSearch") int i11, Continuation<? super BaseDto<HotSubjectEntity>> continuation);

    @f("/wefeed-mobile-bff/tab-operating")
    Object g(@t("host") String str, @t("tabId") int i11, @t("version") String str2, Continuation<? super BaseDto<SubOperateData>> continuation);
}
