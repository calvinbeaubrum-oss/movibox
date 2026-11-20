package com.transsion.member.dialog;

import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.MemberCheckResult;
import com.transsion.memberapi.MemberSceneType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.transsion.member.dialog.CheckMemberRightsLoadingDialog$checkMember$1", f = "CheckMemberRightsLoadingDialog.kt", l = {81}, m = "invokeSuspend")
public final class CheckMemberRightsLoadingDialog$checkMember$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CheckMemberRightsLoadingDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckMemberRightsLoadingDialog$checkMember$1(CheckMemberRightsLoadingDialog checkMemberRightsLoadingDialog, Continuation<? super CheckMemberRightsLoadingDialog$checkMember$1> continuation) {
        super(2, continuation);
        this.this$0 = checkMemberRightsLoadingDialog;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CheckMemberRightsLoadingDialog$checkMember$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((CheckMemberRightsLoadingDialog$checkMember$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            IMemberApi iMemberApi = (IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class);
            MemberSceneType memberSceneType = this.this$0.f53262d;
            Integer num = this.this$0.f53263f;
            final CheckMemberRightsLoadingDialog checkMemberRightsLoadingDialog = this.this$0;
            Function1<MemberCheckResult, Unit> function1 = new Function1<MemberCheckResult, Unit>() { // from class: com.transsion.member.dialog.CheckMemberRightsLoadingDialog$checkMember$1.1
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
                    if (checkMemberRightsLoadingDialog.isDetached() || !checkMemberRightsLoadingDialog.isAdded()) {
                        return;
                    }
                    checkMemberRightsLoadingDialog.r0(memberCheckResult);
                }
            };
            this.label = 1;
            if (iMemberApi.f(memberSceneType, num, function1, this) == objE) {
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
