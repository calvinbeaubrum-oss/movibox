package com.transsion.postdetail.viewmodel;

import com.tn.lib.net.bean.BaseDto;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;
import retrofit2.HttpException;
import xv.b;

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
@DebugMetadata(c = "com.transsion.postdetail.viewmodel.PostDetailViewModel$getPostDetail$1", f = "PostDetailViewModel.kt", l = {80}, m = "invokeSuspend")
public final class PostDetailViewModel$getPostDetail$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $postId;
    Object L$0;
    int label;
    final /* synthetic */ PostDetailViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostDetailViewModel$getPostDetail$1(PostDetailViewModel postDetailViewModel, String str, Continuation<? super PostDetailViewModel$getPostDetail$1> continuation) {
        super(2, continuation);
        this.this$0 = postDetailViewModel;
        this.$postId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PostDetailViewModel$getPostDetail$1(this.this$0, this.$postId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((PostDetailViewModel$getPostDetail$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM163constructorimpl;
        PostDetailViewModel postDetailViewModel;
        Object objE = a.e();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                PostDetailViewModel postDetailViewModel2 = this.this$0;
                String str = this.$postId;
                Result.Companion companion = Result.Companion;
                b bVarT = postDetailViewModel2.t();
                String strA = cp.a.f62775a.a();
                this.L$0 = postDetailViewModel2;
                this.label = 1;
                Object objA = bVarT.a(strA, str, this);
                if (objA == objE) {
                    return objE;
                }
                postDetailViewModel = postDetailViewModel2;
                obj = objA;
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                postDetailViewModel = (PostDetailViewModel) this.L$0;
                ResultKt.b(obj);
            }
            postDetailViewModel.p().q(((BaseDto) obj).getData());
            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        PostDetailViewModel postDetailViewModel3 = this.this$0;
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl != null) {
            if (thM166exceptionOrNullimpl instanceof HttpException) {
                HttpException httpException = (HttpException) thM166exceptionOrNullimpl;
                if (httpException.code() == 404) {
                    postDetailViewModel3.o().q(String.valueOf(httpException.code()));
                }
            }
            postDetailViewModel3.p().q(null);
        }
        return Unit.f68710a;
    }
}
