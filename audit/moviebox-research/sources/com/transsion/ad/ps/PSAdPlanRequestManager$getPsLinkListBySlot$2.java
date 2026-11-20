package com.transsion.ad.ps;

import com.tn.lib.util.networkinfo.f;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.k0;
import org.json.JSONObject;

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
@DebugMetadata(c = "com.transsion.ad.ps.PSAdPlanRequestManager$getPsLinkListBySlot$2", f = "PSAdPlanRequestManager.kt", l = {118, 133}, m = "invokeSuspend")
public final class PSAdPlanRequestManager$getPsLinkListBySlot$2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $nonId;
    final /* synthetic */ int $pageIndex;
    final /* synthetic */ int $pageSize;
    final /* synthetic */ Integer $psScene;
    final /* synthetic */ boolean $retry;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PSAdPlanRequestManager$getPsLinkListBySlot$2(int i11, int i12, Integer num, String str, boolean z11, Continuation<? super PSAdPlanRequestManager$getPsLinkListBySlot$2> continuation) {
        super(2, continuation);
        this.$pageIndex = i11;
        this.$pageSize = i12;
        this.$psScene = num;
        this.$nonId = str;
        this.$retry = z11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PSAdPlanRequestManager$getPsLinkListBySlot$2(this.$pageIndex, this.$pageSize, this.$psScene, this.$nonId, this.$retry, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((PSAdPlanRequestManager$getPsLinkListBySlot$2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM163constructorimpl;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        try {
            if (i11 != 0) {
                if (i11 == 1) {
                    ResultKt.b(obj);
                } else {
                    if (i11 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                return Unit.f68710a;
            }
            ResultKt.b(obj);
            int i12 = this.$pageIndex;
            int i13 = this.$pageSize;
            Integer num = this.$psScene;
            String str = this.$nonId;
            Result.Companion companion = Result.Companion;
            PSAdPlanRequestManager pSAdPlanRequestManager = PSAdPlanRequestManager.f50545a;
            JSONObject jSONObjectJ = pSAdPlanRequestManager.j(i12, i13, num);
            String str2 = wo.a.f79569a.d() ? "https://test-feature-api.palmplaystore.com" : "https://feature-api.palmplaystore.com";
            com.transsion.ad.a.b(com.transsion.ad.a.f50276a, pSAdPlanRequestManager.h() + " --> getPsLinkListBySlot() --> psScene = " + num + " --> url = " + str2 + " --> jsonObject = " + jSONObjectJ, false, 2, null);
            this.label = 1;
            if (pSAdPlanRequestManager.o(jSONObjectJ, num, str, str2, this) == objE) {
                return objE;
            }
            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        Integer num2 = this.$psScene;
        boolean z11 = this.$retry;
        int i14 = this.$pageIndex;
        String str3 = this.$nonId;
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl != null) {
            com.transsion.ad.a aVar = com.transsion.ad.a.f50276a;
            PSAdPlanRequestManager pSAdPlanRequestManager2 = PSAdPlanRequestManager.f50545a;
            com.transsion.ad.a.d(aVar, pSAdPlanRequestManager2.h() + " --> getPsLinkList() --> it = " + thM166exceptionOrNullimpl, false, 2, null);
            PSReportUtil.f50550a.b(PSReportUtil.PSRequestState.REQUEST_FAIL, null, String.valueOf(thM166exceptionOrNullimpl.getMessage()), PSReportUtil.PsDistributeSceneEnum.PS_DISTRIBUTE_SCENE_AD_PLAN.getValue(), String.valueOf(num2));
            String message = thM166exceptionOrNullimpl.getMessage();
            if (message != null && StringsKt__StringsKt.Q(message, "Exception received from UploadDataProvider", false, 2, null) && z11 && f.f49475a.e()) {
                this.label = 2;
                if (PSAdPlanRequestManager.m(pSAdPlanRequestManager2, i14, false, 0, num2, str3, this, 4, null) == objE) {
                    return objE;
                }
            }
        }
        return Unit.f68710a;
    }
}
