package pu;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.member.bean.PointsHistoryData;
import com.transsion.member.bean.RedeemResult;
import com.transsion.member.bean.request.InviteUserShareInfoReq;
import com.transsion.member.bean.request.MemberInviteUserShareInfo;
import com.transsion.member.bean.request.MemberPromoCodeReq;
import com.transsion.member.bean.request.MemberPromoCodeRes;
import com.transsion.memberapi.GlobalTaskInfo;
import com.transsion.memberapi.MemberCheckResult;
import com.transsion.memberapi.MemberDetail;
import com.transsion.memberapi.MemberTaskCheckInInfo;
import com.transsion.memberapi.MemberTaskInfo;
import com.transsion.memberapi.MemberTaskInviteRewards;
import com.transsion.memberapi.MemberTaskRewardInfo;
import com.transsion.memberapi.MemberTaskSubmitCheckInRes;
import com.transsion.memberapi.SkuData;
import com.transsion.memberapi.TaskRewards;
import io.reactivex.rxjava3.core.j;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okhttp3.MediaType;
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
public interface a {

    /* JADX INFO: renamed from: pu.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0809a {
        public static /* synthetic */ j a(a aVar, String str, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fetchGlobalTask");
            }
            if ((i11 & 1) != 0) {
                str = cp.a.f62775a.a();
            }
            return aVar.n(str);
        }

        public static /* synthetic */ j b(a aVar, String str, int i11, int i12, int i13, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fetchInviteUserRewards");
            }
            if ((i13 & 1) != 0) {
                str = cp.a.f62775a.a();
            }
            return aVar.b(str, i11, i12);
        }

        public static /* synthetic */ j c(a aVar, String str, InviteUserShareInfoReq inviteUserShareInfoReq, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fetchInviteUserShareInfo");
            }
            if ((i11 & 1) != 0) {
                str = cp.a.f62775a.a();
            }
            return aVar.d(str, inviteUserShareInfoReq);
        }

        public static /* synthetic */ j d(a aVar, String str, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fetchMemberDetail");
            }
            if ((i11 & 1) != 0) {
                str = cp.a.f62775a.a();
            }
            return aVar.k(str);
        }

        public static /* synthetic */ j e(a aVar, String str, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fetchMemberTaskCheckInInfo");
            }
            if ((i11 & 1) != 0) {
                str = cp.a.f62775a.a();
            }
            return aVar.i(str);
        }

        public static /* synthetic */ j f(a aVar, String str, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fetchMemberTaskInfo");
            }
            if ((i11 & 1) != 0) {
                str = cp.a.f62775a.a();
            }
            return aVar.m(str);
        }

        public static /* synthetic */ j g(a aVar, String str, int i11, String str2, int i12, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fetchPointsHistory");
            }
            if ((i12 & 2) != 0) {
                i11 = 20;
            }
            if ((i12 & 4) != 0) {
                str2 = cp.a.f62775a.a();
            }
            return aVar.a(str, i11, str2);
        }

        public static /* synthetic */ j h(a aVar, String str, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fetchSkuList");
            }
            if ((i11 & 1) != 0) {
                str = cp.a.f62775a.a();
            }
            return aVar.f(str);
        }

        public static /* synthetic */ j i(a aVar, String str, String str2, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: receiveRewards");
            }
            if ((i11 & 1) != 0) {
                str = cp.a.f62775a.a();
            }
            if ((i11 & 2) != 0) {
                str2 = "0";
            }
            return aVar.c(str, str2);
        }

        public static /* synthetic */ j j(a aVar, String str, RequestBody requestBody, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: receiveTaskRewards");
            }
            if ((i11 & 1) != 0) {
                str = cp.a.f62775a.a();
            }
            return aVar.j(str, requestBody);
        }

        public static /* synthetic */ j k(a aVar, String str, MemberPromoCodeReq memberPromoCodeReq, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: submitPromoCode");
            }
            if ((i11 & 1) != 0) {
                str = cp.a.f62775a.a();
            }
            return aVar.h(str, memberPromoCodeReq);
        }

        public static /* synthetic */ j l(a aVar, String str, RequestBody requestBody, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: taskCheckInSubmit");
            }
            if ((i11 & 1) != 0) {
                str = cp.a.f62775a.a();
            }
            if ((i11 & 2) != 0) {
                requestBody = RequestBody.Companion.create("{}", MediaType.Companion.parse("application/json"));
            }
            return aVar.e(str, requestBody);
        }
    }

    @f("/wefeed-mobile-bff/money/coin-log")
    j<BaseDto<PointsHistoryData>> a(@t("pageNum") String str, @t("pageSize") int i11, @t("host") String str2);

    @f("/wefeed-mobile-bff/activity/fission/reward-list")
    j<BaseDto<MemberTaskInviteRewards>> b(@t("host") String str, @t("lastId") int i11, @t("limit") int i12);

    @f("/wefeed-mobile-bff/vip/member/rewards-receive")
    j<BaseDto<MemberTaskRewardInfo>> c(@t("host") String str, @t("rewardId") String str2);

    @o("/wefeed-mobile-bff/share/shorturl")
    j<BaseDto<MemberInviteUserShareInfo>> d(@t("host") String str, @y30.a InviteUserShareInfoReq inviteUserShareInfoReq);

    @o("/wefeed-mobile-bff/activity/check-in")
    j<BaseDto<MemberTaskSubmitCheckInRes>> e(@t("host") String str, @y30.a RequestBody requestBody);

    @f("/wefeed-mobile-bff/money/sku-list/get")
    j<BaseDto<SkuData>> f(@t("host") String str);

    @o("/wefeed-mobile-bff/statistics/user-operation")
    j<BaseDto<Object>> g(@t("host") String str, @y30.a RequestBody requestBody);

    @o("/wefeed-mobile-bff/activity/promo-code-bind")
    j<BaseDto<MemberPromoCodeRes>> h(@t("host") String str, @y30.a MemberPromoCodeReq memberPromoCodeReq);

    @f("/wefeed-mobile-bff/activity/check-in-info")
    j<BaseDto<MemberTaskCheckInInfo>> i(@t("host") String str);

    @o("/wefeed-mobile-bff/activity/rewards-receive")
    j<BaseDto<TaskRewards>> j(@t("host") String str, @y30.a RequestBody requestBody);

    @f("/wefeed-mobile-bff/vip/member/detail")
    j<BaseDto<MemberDetail>> k(@t("host") String str);

    @o("/wefeed-mobile-bff/vip/member/rights-check")
    Object l(@t("host") String str, @y30.a RequestBody requestBody, Continuation<? super BaseDto<MemberCheckResult>> continuation);

    @f("/wefeed-mobile-bff/activity/task-list")
    j<BaseDto<MemberTaskInfo>> m(@t("host") String str);

    @f("/wefeed-mobile-bff/activity/global-task")
    j<BaseDto<GlobalTaskInfo>> n(@t("host") String str);

    @o("/wefeed-mobile-bff/money/exchange/order")
    Object o(@t("host") String str, @y30.a RequestBody requestBody, Continuation<? super BaseDto<RedeemResult>> continuation);
}
