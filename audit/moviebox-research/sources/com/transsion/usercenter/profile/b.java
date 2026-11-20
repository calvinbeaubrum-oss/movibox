package com.transsion.usercenter.profile;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.moviedetailapi.bean.PostSubjectBean;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.usercenter.profile.bean.MinePageInfo;
import com.transsion.usercenter.profile.bean.ProfileEntranceInfo;
import com.transsion.usercenter.profile.bean.ProfileInfo;
import com.transsion.usercenter.profile.bean.ProfileNewMessage;
import com.transsion.usercenter.profile.see.bean.ProfileSeeData;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
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
public interface b {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public static /* synthetic */ io.reactivex.rxjava3.core.j a(b bVar, String str, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkNewMessage");
            }
            if ((i11 & 1) != 0) {
                str = cp.a.f62775a.a();
            }
            return bVar.h(str);
        }

        public static /* synthetic */ io.reactivex.rxjava3.core.j b(b bVar, String str, String str2, int i11, String str3, int i12, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLikeSubject");
            }
            if ((i12 & 8) != 0) {
                str3 = cp.a.f62775a.a();
            }
            return bVar.c(str, str2, i11, str3);
        }

        public static /* synthetic */ Object c(b bVar, String str, String str2, Continuation continuation, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMineInfo");
            }
            if ((i11 & 1) != 0) {
                str = null;
            }
            if ((i11 & 2) != 0) {
                str2 = cp.a.f62775a.a();
            }
            return bVar.e(str, str2, continuation);
        }

        public static /* synthetic */ io.reactivex.rxjava3.core.j d(b bVar, String str, String str2, int i11, String str3, String str4, int i12, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMyPostSubject");
            }
            if ((i12 & 8) != 0) {
                str3 = "PostRankTypeNew";
            }
            String str5 = str3;
            if ((i12 & 16) != 0) {
                str4 = cp.a.f62775a.a();
            }
            return bVar.i(str, str2, i11, str5, str4);
        }

        public static /* synthetic */ Object e(b bVar, String str, String str2, Continuation continuation, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPostDetail");
            }
            if ((i11 & 2) != 0) {
                str2 = cp.a.f62775a.a();
            }
            return bVar.a(str, str2, continuation);
        }

        public static /* synthetic */ io.reactivex.rxjava3.core.j f(b bVar, String str, String str2, int i11, String str3, String str4, int i12, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPostSubject");
            }
            if ((i12 & 8) != 0) {
                str3 = "PostRankTypeNew";
            }
            String str5 = str3;
            if ((i12 & 16) != 0) {
                str4 = cp.a.f62775a.a();
            }
            return bVar.d(str, str2, i11, str5, str4);
        }

        public static /* synthetic */ io.reactivex.rxjava3.core.j g(b bVar, String str, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getProfileEntrance");
            }
            if ((i11 & 1) != 0) {
                str = cp.a.f62775a.a();
            }
            return bVar.f(str);
        }

        public static /* synthetic */ io.reactivex.rxjava3.core.j h(b bVar, String str, String str2, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getProfileInfo");
            }
            if ((i11 & 2) != 0) {
                str2 = cp.a.f62775a.a();
            }
            return bVar.b(str, str2);
        }

        public static /* synthetic */ io.reactivex.rxjava3.core.j i(b bVar, String str, int i11, int i12, int i13, String str2, int i14, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSeeList");
            }
            int i15 = (i14 & 8) != 0 ? 1 : i13;
            if ((i14 & 16) != 0) {
                str2 = cp.a.f62775a.a();
            }
            return bVar.g(str, i11, i12, i15, str2);
        }
    }

    @y30.f("/wefeed-mobile-bff/post/get")
    Object a(@t("postId") String str, @t("host") String str2, Continuation<? super BaseDto<PostSubjectItem>> continuation);

    @y30.f("/wefeed-mobile-bff/user-api/profile")
    io.reactivex.rxjava3.core.j<BaseDto<ProfileInfo>> b(@t("userId") String str, @t("host") String str2);

    @y30.f("/wefeed-mobile-bff/post/list/likes")
    io.reactivex.rxjava3.core.j<BaseDto<PostSubjectBean>> c(@t("userId") String str, @t("page") String str2, @t("perPage") int i11, @t("host") String str3);

    @y30.f("/wefeed-mobile-bff/post/list/user")
    io.reactivex.rxjava3.core.j<BaseDto<PostSubjectBean>> d(@t("id") String str, @t("page") String str2, @t("perPage") int i11, @t("type") String str3, @t("host") String str4);

    @y30.f("/wefeed-mobile-bff/user-api/profile/v2")
    Object e(@t("userId") String str, @t("host") String str2, Continuation<? super BaseDto<MinePageInfo>> continuation);

    @y30.f("/wefeed-mobile-bff/activity/entrance")
    io.reactivex.rxjava3.core.j<BaseDto<ProfileEntranceInfo>> f(@t("host") String str);

    @y30.f("/wefeed-mobile-bff/subject-api/see-list-v2")
    io.reactivex.rxjava3.core.j<BaseDto<ProfileSeeData>> g(@t("userId") String str, @t("page") int i11, @t("perPage") int i12, @t("seeType") int i13, @t("host") String str2);

    @y30.f("/wefeed-mobile-bff/message/internal/has-new")
    io.reactivex.rxjava3.core.j<BaseDto<ProfileNewMessage>> h(@t("host") String str);

    @y30.f("/wefeed-mobile-bff/post/list/user/my")
    io.reactivex.rxjava3.core.j<BaseDto<PostSubjectBean>> i(@t("id") String str, @t("page") String str2, @t("perPage") int i11, @t("type") String str3, @t("host") String str4);
}
