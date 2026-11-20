package com.transsion.postdetail.shorttv;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.shorttv.source.ShortTvInfoEpisodeList;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okhttp3.RequestBody;
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
public interface a {

    /* JADX INFO: renamed from: com.transsion.postdetail.shorttv.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0589a {
        public static /* synthetic */ Object a(a aVar, RequestBody requestBody, String str, Continuation continuation, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: favoriteShortTv");
            }
            if ((i11 & 2) != 0) {
                str = cp.a.f62775a.a();
            }
            return aVar.b(requestBody, str, continuation);
        }

        public static /* synthetic */ Object b(a aVar, String str, String str2, Continuation continuation, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getShortTvInfo");
            }
            if ((i11 & 2) != 0) {
                str2 = cp.a.f62775a.a();
            }
            return aVar.c(str, str2, continuation);
        }
    }

    @y30.f("/wefeed-mobile-bff/shorts/mini-list")
    Object a(@t("subjectId") String str, @t("startPosition") int i11, @t("endPosition") int i12, @t("pagerMode") int i13, @t("host") String str2, Continuation<? super BaseDto<ShortTvInfoEpisodeList>> continuation);

    @y30.o("/wefeed-mobile-bff/shorts/favorite")
    Object b(@y30.a RequestBody requestBody, @t("host") String str, Continuation<? super BaseDto<String>> continuation);

    @y30.f("/wefeed-mobile-bff/shorts/get-info")
    Object c(@t("subjectId") String str, @t("host") String str2, Continuation<? super BaseDto<Subject>> continuation);
}
