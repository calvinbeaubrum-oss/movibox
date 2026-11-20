package com.transsion.search.viewmodel;

import com.blankj.utilcode.util.Utils;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.util.networkinfo.f;
import com.tn.lib.widget.R$string;
import com.tn.lib.widget.toast.core.h;
import com.transsion.search.net.RequestSearchEntity;
import com.transsion.search.net.SearchModel;
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
import uo.b;

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
@DebugMetadata(c = "com.transsion.search.viewmodel.SearchViewModel$searchWork$1", f = "SearchViewModel.kt", l = {69}, m = "invokeSuspend")
public final class SearchViewModel$searchWork$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ RequestSearchEntity $request;
    int label;
    final /* synthetic */ SearchViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchViewModel$searchWork$1(SearchViewModel searchViewModel, RequestSearchEntity requestSearchEntity, Continuation<? super SearchViewModel$searchWork$1> continuation) {
        super(2, continuation);
        this.this$0 = searchViewModel;
        this.$request = requestSearchEntity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SearchViewModel$searchWork$1(this.this$0, this.$request, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((SearchViewModel$searchWork$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM163constructorimpl;
        Object objE = a.e();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                SearchViewModel searchViewModel = this.this$0;
                RequestSearchEntity requestSearchEntity = this.$request;
                Result.Companion companion = Result.Companion;
                SearchModel searchModelK = searchViewModel.k();
                this.label = 1;
                obj = searchModelK.g(requestSearchEntity, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            objM163constructorimpl = Result.m163constructorimpl((BaseDto) obj);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        SearchViewModel searchViewModel2 = this.this$0;
        if (Result.m170isSuccessimpl(objM163constructorimpl)) {
            searchViewModel2.f57687c.n(((BaseDto) objM163constructorimpl).getData());
        }
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl != null) {
            b.a.u(b.f78622a, "liup", String.valueOf(thM166exceptionOrNullimpl.getMessage()), false, 4, null);
            if (f.f49475a.e()) {
                h.f50034a.l(Utils.a().getString(R$string.no_error_content));
            } else {
                h.f50034a.l(Utils.a().getString(R$string.no_network_toast));
            }
            searchViewModel2.f57687c.n(null);
        }
        return Unit.f68710a;
    }
}
