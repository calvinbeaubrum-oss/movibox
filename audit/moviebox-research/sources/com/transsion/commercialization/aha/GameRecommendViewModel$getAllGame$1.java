package com.transsion.commercialization.aha;

import com.transsion.bean.AhaGameResponse;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;
import okhttp3.RequestBody;

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
@DebugMetadata(c = "com.transsion.commercialization.aha.GameRecommendViewModel$getAllGame$1", f = "GameRecommendViewModel.kt", l = {37}, m = "invokeSuspend")
public final class GameRecommendViewModel$getAllGame$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ GameRecommendViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameRecommendViewModel$getAllGame$1(GameRecommendViewModel gameRecommendViewModel, Continuation<? super GameRecommendViewModel$getAllGame$1> continuation) {
        super(2, continuation);
        this.this$0 = gameRecommendViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GameRecommendViewModel$getAllGame$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((GameRecommendViewModel$getAllGame$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM163constructorimpl;
        GameRecommendViewModel gameRecommendViewModel;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                GameRecommendViewModel gameRecommendViewModel2 = this.this$0;
                Result.Companion companion = Result.Companion;
                d dVarJ = gameRecommendViewModel2.j();
                Map<String, Object> mapA = d.f51622a.a();
                RequestBody requestBodyA = ip.b.f67591a.a(new AhaGameRequest(new AhaGameQuery(gameRecommendViewModel2.f51617c, 10)));
                this.L$0 = gameRecommendViewModel2;
                this.label = 1;
                Object objA = dVarJ.a(mapA, requestBodyA, this);
                if (objA == objE) {
                    return objE;
                }
                gameRecommendViewModel = gameRecommendViewModel2;
                obj = objA;
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                gameRecommendViewModel = (GameRecommendViewModel) this.L$0;
                ResultKt.b(obj);
            }
            AhaGameResponse ahaGameResponse = (AhaGameResponse) obj;
            Integer code = ahaGameResponse.getCode();
            if (code != null && code.intValue() == 1000) {
                gameRecommendViewModel.f51617c++;
            }
            gameRecommendViewModel.f51615a.n(ahaGameResponse);
            uo.b.f78622a.c(gameRecommendViewModel.i(), gameRecommendViewModel.i() + " --> getAllGame() --> postAhaGameRecommendList = " + ahaGameResponse, true);
            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        GameRecommendViewModel gameRecommendViewModel3 = this.this$0;
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl != null) {
            uo.b.f78622a.c(gameRecommendViewModel3.i(), gameRecommendViewModel3.i() + " --> getAllGame() --> 加载失败了 it = " + thM166exceptionOrNullimpl, true);
            gameRecommendViewModel3.f51615a.n(null);
        }
        return Unit.f68710a;
    }
}
