package com.transsnet.login.interest;

import com.transsnet.login.R$array;
import com.transsnet.login.constant.LoginMmkvUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.g;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
@DebugMetadata(c = "com.transsnet.login.interest.LoginInterestViewModel$postInterest$1$1", f = "LoginInterestViewModel.kt", l = {}, m = "invokeSuspend")
@SourceDebugExtension
public final class LoginInterestViewModel$postInterest$1$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Integer> $datas;
    int label;
    final /* synthetic */ LoginInterestViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginInterestViewModel$postInterest$1$1(LoginInterestViewModel loginInterestViewModel, List<Integer> list, Continuation<? super LoginInterestViewModel$postInterest$1$1> continuation) {
        super(2, continuation);
        this.this$0 = loginInterestViewModel;
        this.$datas = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LoginInterestViewModel$postInterest$1$1(this.this$0, this.$datas, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((LoginInterestViewModel$postInterest$1$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        String[] stringArray = this.this$0.b().getResources().getStringArray(R$array.interestId);
        Intrinsics.f(stringArray, "getApplication<Applicati…Array(R.array.interestId)");
        StringBuilder sb2 = new StringBuilder();
        List<Integer> list = this.$datas;
        int i11 = 0;
        for (Object obj2 : list) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                g.u();
            }
            sb2.append(stringArray[((Number) obj2).intValue()]);
            if (i11 < list.size() - 1) {
                sb2.append(",");
            }
            i11 = i12;
        }
        String string = sb2.toString();
        Intrinsics.f(string, "idString.toString()");
        LoginMmkvUtil.f61452a.a().putString("login_show_interest", string);
        this.this$0.f61528b.n(string);
        return Unit.f68710a;
    }
}
