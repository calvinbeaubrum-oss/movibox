package com.transsion.postdetail.helper;

import androidx.lifecycle.c0;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.OperatingResp;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.r0;

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
@DebugMetadata(c = "com.transsion.postdetail.helper.ShortTVDiscoverPreloadHelper$preloadOperatingList$1", f = "ShortTVDiscoverPreloadHelper.kt", l = {90}, m = "invokeSuspend")
public final class ShortTVDiscoverPreloadHelper$preloadOperatingList$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ShortTVDiscoverPreloadHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTVDiscoverPreloadHelper$preloadOperatingList$1(ShortTVDiscoverPreloadHelper shortTVDiscoverPreloadHelper, Continuation<? super ShortTVDiscoverPreloadHelper$preloadOperatingList$1> continuation) {
        super(2, continuation);
        this.this$0 = shortTVDiscoverPreloadHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShortTVDiscoverPreloadHelper$preloadOperatingList$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((ShortTVDiscoverPreloadHelper$preloadOperatingList$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        c0 c0Var;
        OperatingResp operatingResp;
        List<OperateItem> ops;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            this.label = 1;
            if (r0.a(500L, this) == objE) {
                return objE;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        if (this.this$0.y() == null) {
            this.this$0.L(new c0<>());
        }
        if (this.this$0.f55037d == null) {
            this.this$0.f55037d = new c0();
        }
        if (this.this$0.f55043j.get()) {
            uo.b.a.f(uo.b.f78622a, "DiscoverPreload", "1---preloadOperating 接口已返回", false, 4, null);
        } else {
            c0 c0Var2 = this.this$0.f55037d;
            if ((c0Var2 != null ? (OperatingResp) c0Var2.f() : null) != null && (c0Var = this.this$0.f55037d) != null && (operatingResp = (OperatingResp) c0Var.f()) != null && (ops = operatingResp.getOps()) != null && (!ops.isEmpty())) {
                uo.b.a.f(uo.b.f78622a, "DiscoverPreload", "1---preloadOperating 接口还未返回，使用缓存", false, 4, null);
                c0<OperatingResp> c0VarY = this.this$0.y();
                if (c0VarY != null) {
                    c0 c0Var3 = this.this$0.f55037d;
                    c0VarY.n(c0Var3 != null ? (OperatingResp) c0Var3.f() : null);
                }
            }
        }
        return Unit.f68710a;
    }
}
