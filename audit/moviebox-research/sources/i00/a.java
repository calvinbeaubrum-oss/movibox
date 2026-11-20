package i00;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.moviedetailapi.bean.DubsInfoData;
import com.transsion.moviedetailapi.bean.ResourcesSeasonList;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.downloader.bean.DownloadListBean;
import com.transsnet.downloader.bean.DownloadUrlBean;
import com.transsnet.downloader.bean.MovieRecBean;
import com.transsnet.downloader.bean.StartResponseBean;
import io.reactivex.rxjava3.core.j;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public interface a {

    /* JADX INFO: renamed from: i00.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0703a {
        public static /* synthetic */ Object a(a aVar, RequestBody requestBody, String str, Continuation continuation, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: favoriteShortTv");
            }
            if ((i11 & 2) != 0) {
                str = cp.a.f62775a.a();
            }
            return aVar.b(requestBody, str, continuation);
        }

        public static /* synthetic */ Object b(a aVar, String str, RequestBody requestBody, Continuation continuation, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: finishDownloadResource");
            }
            if ((i11 & 1) != 0) {
                str = cp.a.f62775a.a();
            }
            return aVar.i(str, requestBody, continuation);
        }

        public static /* synthetic */ Object c(a aVar, String str, String str2, String str3, int i11, int i12, int i13, int i14, int i15, Integer num, int i16, int i17, int i18, Continuation continuation, int i19, Object obj) {
            if (obj == null) {
                return aVar.g(str, str2, str3, (i19 & 8) != 0 ? 8 : i11, (i19 & 16) != 0 ? 0 : i12, (i19 & 32) != 0 ? 1 : i13, (i19 & 64) != 0 ? 1 : i14, (i19 & 128) != 0 ? 0 : i15, (i19 & 256) != 0 ? Integer.valueOf(RoomAppMMKV.f51271a.a().getInt("download_last_resolution", 0)) : num, (i19 & 512) != 0 ? 1 : i16, (i19 & 1024) != 0 ? 1 : i17, (i19 & 2048) != 0 ? 1 : i18, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getDownloadList");
        }

        public static /* synthetic */ Object d(a aVar, String str, String str2, String str3, String str4, String str5, int i11, Continuation continuation, int i12, Object obj) {
            if (obj == null) {
                return aVar.f(str, str2, str3, str4, str5, (i12 & 32) != 0 ? 1 : i11, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getResource");
        }
    }

    @f("/wefeed-mobile-bff/subject-api/get")
    j<BaseDto<Subject>> a(@t("host") String str, @t("subjectId") String str2);

    @o("/wefeed-mobile-bff/shorts/favorite")
    Object b(@y30.a RequestBody requestBody, @t("host") String str, Continuation<? super BaseDto<String>> continuation);

    @f("/wefeed-mobile-bff/subject-api/dub-info")
    Object c(@t("host") String str, @t("subjectId") String str2, Continuation<? super BaseDto<DubsInfoData>> continuation);

    @f("/wefeed-mobile-bff/subject-api/season-info")
    Object d(@t("host") String str, @t("subjectId") String str2, Continuation<? super BaseDto<ResourcesSeasonList>> continuation);

    @f("/wefeed-mobile-bff/sniff/config")
    j<BaseDto<DownloadUrlBean>> e(@t("host") String str, @t("linkUrl") String str2, @t("subjectId") String str3);

    @f("/wefeed-mobile-bff/subject-api/resource-position")
    Object f(@t("host") String str, @t("subjectId") String str2, @t("resourceId") String str3, @t("failUrl") String str4, @t("failCode") String str5, @t("resourceNum") int i11, Continuation<? super BaseDto<DownloadListBean>> continuation);

    @f("/wefeed-mobile-bff/subject-api/resource")
    Object g(@t("host") String str, @t("subjectId") String str2, @t("page") String str3, @t("perPage") int i11, @t("all") int i12, @t("startPosition") int i13, @t("endPosition") int i14, @t("pagerMode") int i15, @t("resolution") Integer num, @t("se") int i16, @t("epFrom") int i17, @t("epTo") int i18, Continuation<? super BaseDto<DownloadListBean>> continuation);

    @o("/wefeed-mobile-bff/subject-api/start-download-resource")
    Object h(@t("host") String str, @y30.a RequestBody requestBody, Continuation<? super BaseDto<StartResponseBean>> continuation);

    @o("/wefeed-mobile-bff/subject-api/finish-download-resource")
    Object i(@t("host") String str, @y30.a RequestBody requestBody, Continuation<? super BaseDto<StartResponseBean>> continuation);

    @o("/wefeed-mobile-bff/subject-api/daily-movie-rec")
    Object j(@y30.a RequestBody requestBody, Continuation<? super BaseDto<MovieRecBean>> continuation);
}
