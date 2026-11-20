package com.transsion.home.viewmodel.preload;

import android.content.Context;
import com.blankj.utilcode.util.n;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.moviedetailapi.bean.MainOperateData;
import com.transsion.moviedetailapi.bean.OperateItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.Boxing;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.transsion.home.viewmodel.preload.PreloadTrendingData$preloadOperating$1", f = "PreloadTrendingData.kt", l = {}, m = "invokeSuspend")
public final class PreloadTrendingData$preloadOperating$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    int label;
    final /* synthetic */ PreloadTrendingData this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreloadTrendingData$preloadOperating$1(PreloadTrendingData preloadTrendingData, Context context, Continuation<? super PreloadTrendingData$preloadOperating$1> continuation) {
        super(2, continuation);
        this.this$0 = preloadTrendingData;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PreloadTrendingData$preloadOperating$1(this.this$0, this.$context, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((PreloadTrendingData$preloadOperating$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        String string = RoomAppMMKV.f51271a.a().getString("main_operating_data", "");
        if (string == null || string.length() == 0) {
            string = this.this$0.y().e(this.$context);
        }
        if (string != null) {
            try {
                if (string.length() == 0) {
                    this.this$0.K("");
                    b.f78622a.c("PreloadTrending", "preloadOperatingCache json is null", true);
                } else {
                    MainOperateData mainOperateData = (MainOperateData) n.d(string, MainOperateData.class);
                    if (mainOperateData != null) {
                        PreloadTrendingData preloadTrendingData = this.this$0;
                        mainOperateData.setSourceFrom("from_cache");
                        b.a aVar = b.f78622a;
                        List<OperateItem> items = mainOperateData.getItems();
                        aVar.c("PreloadTrending", "load operating cache size=" + (items != null ? Boxing.d(items.size()) : null) + "}", true);
                        preloadTrendingData.q(mainOperateData);
                        preloadTrendingData.F().n(mainOperateData);
                        String version = mainOperateData.getVersion();
                        if (version == null) {
                            version = "";
                        }
                        Boxing.a(preloadTrendingData.K(version));
                    }
                }
            } catch (Exception e11) {
                b.f78622a.c("PreloadTrending", "exception when from json " + e11.getMessage(), true);
                this.this$0.K("");
            }
        } else {
            this.this$0.K("");
            b.f78622a.c("PreloadTrending", "preloadOperatingCache json is null", true);
        }
        return Unit.f68710a;
    }
}
