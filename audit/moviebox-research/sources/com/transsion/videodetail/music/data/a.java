package com.transsion.videodetail.music.data;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.videodetail.music.bean.MusicLikedRemoteActionBean;
import com.transsion.videodetail.music.bean.MusicLikedRemoteBean;
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

    /* JADX INFO: renamed from: com.transsion.videodetail.music.data.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0614a {
        public static /* synthetic */ Object a(a aVar, String str, int i11, String str2, Continuation continuation, int i12, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMusicLikedList");
            }
            if ((i12 & 2) != 0) {
                i11 = 20;
            }
            if ((i12 & 4) != 0) {
                str2 = cp.a.f62775a.a();
            }
            return aVar.b(str, i11, str2, continuation);
        }

        public static /* synthetic */ Object b(a aVar, RequestBody requestBody, String str, Continuation continuation, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: likeMusic");
            }
            if ((i11 & 2) != 0) {
                str = cp.a.f62775a.a();
            }
            return aVar.a(requestBody, str, continuation);
        }
    }

    @o("/wefeed-mobile-bff/music/like")
    Object a(@y30.a RequestBody requestBody, @t("host") String str, Continuation<? super BaseDto<MusicLikedRemoteActionBean>> continuation);

    @f("/wefeed-mobile-bff/music/like-list")
    Object b(@t("page") String str, @t("perPage") int i11, @t("host") String str2, Continuation<? super BaseDto<MusicLikedRemoteBean>> continuation);
}
