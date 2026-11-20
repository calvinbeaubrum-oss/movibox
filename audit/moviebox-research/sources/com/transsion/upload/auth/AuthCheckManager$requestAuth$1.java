package com.transsion.upload.auth;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.upload.bean.TstTokenEntity;
import kotlin.Metadata;
import kotlin.Result;
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
@DebugMetadata(c = "com.transsion.upload.auth.AuthCheckManager$requestAuth$1", f = "AuthCheckManager.kt", l = {112}, m = "invokeSuspend")
public final class AuthCheckManager$requestAuth$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ a $callBack;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthCheckManager$requestAuth$1(a aVar, Continuation<? super AuthCheckManager$requestAuth$1> continuation) {
        super(2, continuation);
        this.$callBack = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AuthCheckManager$requestAuth$1 authCheckManager$requestAuth$1 = new AuthCheckManager$requestAuth$1(this.$callBack, continuation);
        authCheckManager$requestAuth$1.L$0 = obj;
        return authCheckManager$requestAuth$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((AuthCheckManager$requestAuth$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM163constructorimpl;
        a aVar;
        Unit unit;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                k0 k0Var = (k0) this.L$0;
                a aVar2 = this.$callBack;
                Result.Companion companion = Result.Companion;
                b bVarI = AuthCheckManager.f59256a.i();
                String strA = cp.a.f62775a.a();
                this.L$0 = k0Var;
                this.L$1 = aVar2;
                this.label = 1;
                obj = bVarI.a(strA, this);
                if (obj == objE) {
                    return objE;
                }
                aVar = aVar2;
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                aVar = (a) this.L$1;
                ResultKt.b(obj);
            }
            BaseDto baseDto = (BaseDto) obj;
            AuthCheckManager.f59257b = baseDto != null ? (TstTokenEntity) baseDto.getData() : null;
            TstTokenEntity tstTokenEntity = AuthCheckManager.f59257b;
            if (tstTokenEntity != null) {
                vy.b bVar = vy.b.f79124a;
                AuthCheckManager authCheckManager = AuthCheckManager.f59256a;
                bVar.b(authCheckManager.h() + " --> requestAuth() --> tstToken = " + AuthCheckManager.f59257b);
                if (aVar != null) {
                    aVar.a(tstTokenEntity);
                }
                authCheckManager.k();
                unit = Unit.f68710a;
            } else {
                unit = null;
            }
            if (unit == null) {
                if (aVar != null) {
                    aVar.onFail("tstToken is empty");
                }
                AuthCheckManager.f59256a.k();
            }
            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        a aVar3 = this.$callBack;
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl != null) {
            vy.b bVar2 = vy.b.f79124a;
            AuthCheckManager authCheckManager2 = AuthCheckManager.f59256a;
            bVar2.c(authCheckManager2.h() + " --> requestAuth() --> it = " + thM166exceptionOrNullimpl);
            AuthCheckManager.f59257b = null;
            if (aVar3 != null) {
                aVar3.onFail(String.valueOf(thM166exceptionOrNullimpl.getMessage()));
            }
            authCheckManager2.k();
        }
        return Unit.f68710a;
    }
}
