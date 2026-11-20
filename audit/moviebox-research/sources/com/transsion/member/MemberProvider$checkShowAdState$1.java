package com.transsion.member;

import com.tencent.mmkv.MMKV;
import com.transsion.memberapi.MemberCheckResult;
import com.transsion.memberapi.MemberSceneType;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "com.transsion.member.MemberProvider$checkShowAdState$1", f = "MemberProvider.kt", l = {203}, m = "invokeSuspend")
public final class MemberProvider$checkShowAdState$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $callback;
    int label;
    final /* synthetic */ MemberProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberProvider$checkShowAdState$1(MemberProvider memberProvider, Function0<Unit> function0, Continuation<? super MemberProvider$checkShowAdState$1> continuation) {
        super(2, continuation);
        this.this$0 = memberProvider;
        this.$callback = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MemberProvider$checkShowAdState$1(this.this$0, this.$callback, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((MemberProvider$checkShowAdState$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            MemberProvider memberProvider = this.this$0;
            MemberSceneType memberSceneType = MemberSceneType.SCENE_AD;
            Integer numD = Boxing.d(0);
            final MemberProvider memberProvider2 = this.this$0;
            final Function0<Unit> function0 = this.$callback;
            Function1<MemberCheckResult, Unit> function1 = new Function1<MemberCheckResult, Unit>() { // from class: com.transsion.member.MemberProvider$checkShowAdState$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(MemberCheckResult memberCheckResult) {
                    invoke2(memberCheckResult);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(MemberCheckResult memberCheckResult) {
                    List<String> vipAdScenes;
                    String pointUrl;
                    Integer multiDownloadLimit;
                    String inviteH5Url;
                    String inviteRewardDays;
                    Boolean vipPayEnable;
                    Boolean vipEnable;
                    Boolean boolIsPassed;
                    String string;
                    a aVar = a.f53220a;
                    String strH1 = memberProvider2.H1();
                    MMKV mmkvC = ip.a.f67589a.c();
                    String str = "";
                    if (mmkvC != null && (string = mmkvC.getString("sp_code", "")) != null) {
                        str = string;
                    }
                    aVar.a(strH1 + " --> checkShowAdState() --> SP_CODE = " + str + " --> it = " + memberCheckResult);
                    if (memberCheckResult != null && (boolIsPassed = memberCheckResult.isPassed()) != null) {
                        boolean zBooleanValue = boolIsPassed.booleanValue();
                        MemberKV.f53157a.a().putBoolean("kv_is_skip_ad", zBooleanValue);
                        oq.a.f72510a.d(zBooleanValue);
                    }
                    if (memberCheckResult != null && (vipEnable = memberCheckResult.getVipEnable()) != null) {
                        MemberKV.f53157a.a().putBoolean("kv_is_enable_member", vipEnable.booleanValue());
                    }
                    if (memberCheckResult != null && (vipPayEnable = memberCheckResult.getVipPayEnable()) != null) {
                        MemberKV.f53157a.a().putBoolean("kv_is_pay_enable_member", vipPayEnable.booleanValue());
                    }
                    if (memberCheckResult != null && (inviteRewardDays = memberCheckResult.getInviteRewardDays()) != null) {
                        MemberKV.f53157a.a().putString("kv_invite_Reward_Days", inviteRewardDays);
                    }
                    if (memberCheckResult != null && (inviteH5Url = memberCheckResult.getInviteH5Url()) != null) {
                        MemberKV.f53157a.a().putString("kv_invite_H5_Url", inviteH5Url);
                    }
                    if (memberCheckResult != null && (multiDownloadLimit = memberCheckResult.getMultiDownloadLimit()) != null) {
                        MemberKV.f53157a.a().putInt("kv_parallel_download_task_num", multiDownloadLimit.intValue());
                    }
                    if (memberCheckResult != null && (pointUrl = memberCheckResult.getPointUrl()) != null) {
                        MemberKV.f53157a.a().putString("kv_point_url", pointUrl);
                    }
                    if (memberCheckResult != null && (vipAdScenes = memberCheckResult.getVipAdScenes()) != null) {
                        oq.a.f72510a.a(vipAdScenes);
                    }
                    Function0<Unit> function2 = function0;
                    if (function2 != null) {
                        function2.invoke();
                    }
                }
            };
            this.label = 1;
            if (memberProvider.f(memberSceneType, numD, function1, this) == objE) {
                return objE;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f68710a;
    }
}
