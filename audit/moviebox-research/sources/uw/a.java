package uw;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.moviedetailapi.bean.PostSubjectBean;
import com.transsion.moviedetailapi.bean.RoomBean;
import com.transsion.moviedetailapi.bean.RoomFilterClasses;
import com.transsion.moviedetailapi.bean.RoomItem;
import com.transsion.moviedetailapi.bean.RoomNet;
import com.transsion.room.bean.CheckNameBean;
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

    /* JADX INFO: renamed from: uw.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0870a {
        public static /* synthetic */ Object a(a aVar, String str, String str2, int i11, String str3, int i12, int i13, Continuation continuation, int i14, Object obj) {
            if (obj == null) {
                return aVar.c(str, str2, i11, str3, (i14 & 16) != 0 ? 0 : i12, (i14 & 32) != 0 ? 1 : i13, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMyRoomsList");
        }

        public static /* synthetic */ j b(a aVar, String str, String str2, int i11, int i12, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getRoomDetail");
            }
            if ((i12 & 4) != 0) {
                i11 = 8;
            }
            return aVar.m(str, str2, i11);
        }
    }

    @o("wefeed-mobile-bff/group/class")
    Object a(@t("host") String str, @y30.a RequestBody requestBody, Continuation<? super BaseDto<RoomFilterClasses>> continuation);

    @o("/wefeed-mobile-bff/group/update")
    j<BaseDto<RoomNet>> b(@t("host") String str, @y30.a RequestBody requestBody);

    @f("/wefeed-mobile-bff/group/list/my/v2")
    Object c(@t("host") String str, @t("page") String str2, @t("perPage") int i11, @t("userId") String str3, @t("userAvatarNum") int i12, @t("postNum") int i13, Continuation<? super BaseDto<RoomBean>> continuation);

    @f("/wefeed-mobile-bff/group/exist")
    j<BaseDto<CheckNameBean>> d(@t("host") String str, @t("name") String str2);

    @f("/wefeed-mobile-bff/group/rank")
    j<BaseDto<RoomBean>> e(@t("host") String str, @t("page") String str2, @t("perPage") int i11);

    @o("/wefeed-mobile-bff/group/create")
    j<BaseDto<RoomNet>> f(@t("host") String str, @y30.a RequestBody requestBody);

    @o("/wefeed-mobile-bff/group/list/community-entrance")
    Object g(@t("host") String str, @y30.a RequestBody requestBody, Continuation<? super BaseDto<RoomBean>> continuation);

    @o("/wefeed-mobile-bff/group/join")
    j<BaseDto<RoomNet>> h(@t("host") String str, @y30.a RequestBody requestBody);

    @f("/wefeed-mobile-bff/post/list/group")
    Object i(@t("host") String str, @t("id") String str2, @t("page") String str3, @t("perPage") int i11, @t("type") String str4, @t("with") boolean z11, Continuation<? super BaseDto<PostSubjectBean>> continuation);

    @o("/wefeed-mobile-bff/group/leave")
    j<BaseDto<RoomNet>> j(@t("host") String str, @y30.a RequestBody requestBody);

    @o("/wefeed-mobile-bff/group/list/class")
    Object k(@t("host") String str, @y30.a RequestBody requestBody, Continuation<? super BaseDto<RoomBean>> continuation);

    @o("/wefeed-mobile-bff/group/visit")
    Object l(@t("host") String str, @y30.a RequestBody requestBody, Continuation<? super BaseDto<String>> continuation);

    @f("/wefeed-mobile-bff/group/get")
    j<BaseDto<RoomItem>> m(@t("host") String str, @t("groupId") String str2, @t("userAvatarNum") int i11);

    @f("/wefeed-mobile-bff/group/list/user")
    j<BaseDto<RoomBean>> n(@t("host") String str, @t("page") String str2, @t("perPage") int i11, @t("userId") String str3);
}
