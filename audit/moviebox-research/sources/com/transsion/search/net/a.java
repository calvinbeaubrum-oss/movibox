package com.transsion.search.net;

import com.google.android.libraries.places.api.model.PlaceTypes;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.publish.model.PostEntity;
import com.transsion.search.bean.HotSubjectEntity;
import com.transsion.search.bean.JoinGroupEntity;
import com.transsion.search.bean.SearchGroupEntity;
import com.transsion.search.bean.SearchResultEntity;
import com.transsion.search.bean.SearchSuggestEntity;
import com.transsion.search.bean.SearchWorkEntity;
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

    /* JADX INFO: renamed from: com.transsion.search.net.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0595a {
        public static /* synthetic */ j a(a aVar, int i11, int i12, int i13, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getHotSubject");
            }
            if ((i13 & 2) != 0) {
                i12 = 1;
            }
            return aVar.g(i11, i12);
        }

        public static /* synthetic */ j b(a aVar, String str, int i11, int i12, int i13, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSearchSuggest");
            }
            if ((i13 & 2) != 0) {
                i11 = 10;
            }
            if ((i13 & 4) != 0) {
                i12 = 2;
            }
            return aVar.d(str, i11, i12);
        }
    }

    @f("/wefeed-mobile-bff/group/list/search")
    j<BaseDto<SearchGroupEntity>> a(@t("host") String str, @t("page") int i11, @t("keyword") String str2);

    @o("/wefeed-mobile-bff/group/join")
    j<BaseDto<JoinGroupEntity>> b(@t("host") String str, @y30.a RequestBody requestBody);

    @o("/wefeed-mobile-bff/subject-api/search/v2")
    Object c(@t("host") String str, @y30.a RequestBody requestBody, Continuation<? super BaseDto<SearchResultEntity>> continuation);

    @f("/wefeed-mobile-bff/subject-api/search-suggest")
    j<BaseDto<SearchSuggestEntity>> d(@t("keyword") String str, @t("perPage") int i11, @t("resultMode") int i12);

    @o("/wefeed-mobile-bff/subject-api/search")
    Object e(@t("host") String str, @y30.a RequestBody requestBody, Continuation<? super BaseDto<SearchWorkEntity>> continuation);

    @o("/wefeed-mobile-bff/search-anaylze/seek")
    j<BaseDto<PostEntity>> f(@t("host") String str, @y30.a RequestBody requestBody);

    @f("/wefeed-mobile-bff/subject-api/search-rank/v2")
    j<BaseDto<HotSubjectEntity>> g(@t("everyoneSearch") int i11, @t(PlaceTypes.ROOM) int i12);
}
