package com.transsnet.login.phone;

import com.transsnet.loginapi.bean.Country;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
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
@DebugMetadata(c = "com.transsnet.login.phone.LoginPhoneViewModel$checkPhoneNum$1", f = "LoginPhoneViewModel.kt", l = {}, m = "invokeSuspend")
public final class LoginPhoneViewModel$checkPhoneNum$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $phoneNum;
    int label;
    final /* synthetic */ LoginPhoneViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginPhoneViewModel$checkPhoneNum$1(LoginPhoneViewModel loginPhoneViewModel, String str, Continuation<? super LoginPhoneViewModel$checkPhoneNum$1> continuation) {
        super(2, continuation);
        this.this$0 = loginPhoneViewModel;
        this.$phoneNum = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LoginPhoneViewModel$checkPhoneNum$1(this.this$0, this.$phoneNum, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((LoginPhoneViewModel$checkPhoneNum$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        Country countryA = m00.a.f70582a.a(this.this$0.b(), this.$phoneNum);
        if (countryA != null) {
            String str = this.$phoneNum;
            LoginPhoneViewModel loginPhoneViewModel = this.this$0;
            String strSubstring = str.substring(countryA.getCode().length() + 1, str.length());
            Intrinsics.f(strSubstring, "substring(...)");
            loginPhoneViewModel.f61573c.n(strSubstring);
            loginPhoneViewModel.f61572b.n(countryA);
        }
        return Unit.f68710a;
    }
}
