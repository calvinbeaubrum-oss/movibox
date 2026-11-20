package com.transsnet.login.phone;

import com.transsnet.login.LoginProvider;
import com.transsnet.login.constant.LoginSmsCodeMmkvUtil;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsnet.login.phone.LoginPhoneViewModel$handleLoginSuccess$1", f = "LoginPhoneViewModel.kt", l = {424}, m = "invokeSuspend")
public final class LoginPhoneViewModel$handleLoginSuccess$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ UserInfo $data;
    final /* synthetic */ androidx.lifecycle.c0<UserInfo> $liveData;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginPhoneViewModel$handleLoginSuccess$1(UserInfo userInfo, androidx.lifecycle.c0<UserInfo> c0Var, Continuation<? super LoginPhoneViewModel$handleLoginSuccess$1> continuation) {
        super(2, continuation);
        this.$data = userInfo;
        this.$liveData = c0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LoginPhoneViewModel$handleLoginSuccess$1(this.$data, this.$liveData, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((LoginPhoneViewModel$handleLoginSuccess$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            if (this.$data != null) {
                ILoginApi iLoginApiA = LoginProvider.f61428f.a();
                UserInfo userInfo = this.$data;
                this.label = 1;
                if (iLoginApiA.Y0(userInfo, this) == objE) {
                    return objE;
                }
            }
            return Unit.f68710a;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        this.$liveData.q(this.$data);
        LoginSmsCodeMmkvUtil.f61454a.a().clearAll();
        return Unit.f68710a;
    }
}
