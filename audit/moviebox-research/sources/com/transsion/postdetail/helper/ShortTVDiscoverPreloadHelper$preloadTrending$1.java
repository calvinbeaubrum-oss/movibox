package com.transsion.postdetail.helper;

import androidx.lifecycle.c0;
import com.transsion.moviedetailapi.bean.ShortTVRespData;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.List;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.transsion.postdetail.helper.ShortTVDiscoverPreloadHelper$preloadTrending$1", f = "ShortTVDiscoverPreloadHelper.kt", l = {}, m = "invokeSuspend")
public final class ShortTVDiscoverPreloadHelper$preloadTrending$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ShortTVDiscoverPreloadHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTVDiscoverPreloadHelper$preloadTrending$1(ShortTVDiscoverPreloadHelper shortTVDiscoverPreloadHelper, Continuation<? super ShortTVDiscoverPreloadHelper$preloadTrending$1> continuation) {
        super(2, continuation);
        this.this$0 = shortTVDiscoverPreloadHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShortTVDiscoverPreloadHelper$preloadTrending$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((ShortTVDiscoverPreloadHelper$preloadTrending$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        c0 c0Var;
        ShortTVRespData shortTVRespData;
        List<Subject> items;
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (this.this$0.D() == null) {
            this.this$0.N(new c0<>());
            this.this$0.s();
        }
        if (this.this$0.f55038e == null) {
            this.this$0.f55038e = new c0();
        }
        uo.b.a aVar = uo.b.f78622a;
        boolean z11 = this.this$0.f55044k.get();
        c0 c0Var2 = this.this$0.f55038e;
        uo.b.a.f(aVar, "DiscoverPreload", "preloadTrending delay trendingNetLoaded:" + z11 + ", cache:" + (c0Var2 != null ? (ShortTVRespData) c0Var2.f() : null), false, 4, null);
        if (this.this$0.f55044k.get()) {
            uo.b.a.f(aVar, "DiscoverPreload", "preloadTrending 接口已返回", false, 4, null);
        } else {
            c0 c0Var3 = this.this$0.f55038e;
            if ((c0Var3 != null ? (ShortTVRespData) c0Var3.f() : null) != null && (c0Var = this.this$0.f55038e) != null && (shortTVRespData = (ShortTVRespData) c0Var.f()) != null && (items = shortTVRespData.getItems()) != null && (!items.isEmpty())) {
                uo.b.a.f(aVar, "DiscoverPreload", "preloadTrending 接口还未返回，使用缓存", false, 4, null);
                c0<ShortTVRespData> c0VarD = this.this$0.D();
                if (c0VarD != null) {
                    c0 c0Var4 = this.this$0.f55038e;
                    c0VarD.n(c0Var4 != null ? (ShortTVRespData) c0Var4.f() : null);
                }
            }
        }
        return Unit.f68710a;
    }
}
