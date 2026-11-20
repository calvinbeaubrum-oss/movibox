package com.transsion.videodetail;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.moviedetailapi.bean.ResourcesSeasonList;
import com.transsion.videodetail.bean.VideoDetailStreamList;
import kotlin.Metadata;
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
public interface b {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public static /* synthetic */ Object a(b bVar, String str, int i11, int i12, String str2, Continuation continuation, int i13, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getVideoPlayInfo");
            }
            if ((i13 & 8) != 0) {
                str2 = cp.a.f62775a.a();
            }
            return bVar.b(str, i11, i12, str2, continuation);
        }

        public static /* synthetic */ Object b(b bVar, String str, String str2, Continuation continuation, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getVideoSeasonInfo");
            }
            if ((i11 & 2) != 0) {
                str2 = cp.a.f62775a.a();
            }
            return bVar.a(str, str2, continuation);
        }
    }

    @y30.f("/wefeed-mobile-bff/subject-api/season-info")
    Object a(@y30.t("subjectId") String str, @y30.t("host") String str2, Continuation<? super BaseDto<ResourcesSeasonList>> continuation);

    @y30.f("/wefeed-mobile-bff/subject-api/play-info")
    Object b(@y30.t("subjectId") String str, @y30.t("se") int i11, @y30.t("ep") int i12, @y30.t("host") String str2, Continuation<? super BaseDto<VideoDetailStreamList>> continuation);
}
