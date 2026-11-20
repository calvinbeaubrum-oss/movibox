package com.transsion.home.viewmodel;

import com.google.gson.JsonObject;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.home.bean.CategoryBean;
import ip.b;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
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
@DebugMetadata(c = "com.transsion.home.viewmodel.CategoryViewModel$getCategoryList$1", f = "CategoryViewModel.kt", l = {32}, m = "invokeSuspend")
public final class CategoryViewModel$getCategoryList$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $type;
    Object L$0;
    int label;
    final /* synthetic */ CategoryViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CategoryViewModel$getCategoryList$1(String str, CategoryViewModel categoryViewModel, Continuation<? super CategoryViewModel$getCategoryList$1> continuation) {
        super(2, continuation);
        this.$type = str;
        this.this$0 = categoryViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CategoryViewModel$getCategoryList$1(this.$type, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((CategoryViewModel$getCategoryList$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        CategoryViewModel categoryViewModel;
        Object objE = a.e();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("type", this.$type);
                jsonObject.addProperty("page", Boxing.d(this.this$0.h()));
                jsonObject.addProperty("perPage", Boxing.d(this.this$0.f52734c));
                b.a aVar = b.f67591a;
                String string = jsonObject.toString();
                Intrinsics.f(string, "jsonObject.toString()");
                RequestBody requestBodyA = aVar.a(string);
                if (requestBodyA != null) {
                    CategoryViewModel categoryViewModel2 = this.this$0;
                    rt.a aVarI = categoryViewModel2.i();
                    String strA = cp.a.f62775a.a();
                    this.L$0 = categoryViewModel2;
                    this.label = 1;
                    obj = aVarI.a(strA, requestBodyA, this);
                    if (obj == objE) {
                        return objE;
                    }
                    categoryViewModel = categoryViewModel2;
                }
                return Unit.f68710a;
            }
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            categoryViewModel = (CategoryViewModel) this.L$0;
            ResultKt.b(obj);
            BaseDto<CategoryBean> baseDto = (BaseDto) obj;
            categoryViewModel.j(baseDto.getData());
            categoryViewModel.g().n(baseDto);
            int iH = categoryViewModel.h();
            categoryViewModel.k(iH + 1);
            Boxing.d(iH);
        } catch (Exception e11) {
            this.this$0.g().n(new BaseDto<>());
            e11.printStackTrace();
        }
        return Unit.f68710a;
    }
}
