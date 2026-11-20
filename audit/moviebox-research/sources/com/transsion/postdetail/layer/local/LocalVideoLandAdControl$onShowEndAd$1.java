package com.transsion.postdetail.layer.local;

import android.widget.FrameLayout;
import com.transsion.ad.middle.WrapperAdListener;
import com.transsion.ad.middle.nativead.WrapperNativeManager;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.commercializationapi.IInterceptReportApi;
import com.transsion.memberapi.IMemberApi;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.transsion.postdetail.layer.local.LocalVideoLandAdControl$onShowEndAd$1", f = "LocalVideoLandAdControl.kt", l = {469}, m = "invokeSuspend")
public final class LocalVideoLandAdControl$onShowEndAd$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Integer, Unit> $showPlayerAdCallback;
    int label;
    final /* synthetic */ LocalVideoLandAdControl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LocalVideoLandAdControl$onShowEndAd$1(LocalVideoLandAdControl localVideoLandAdControl, Function1<? super Integer, Unit> function1, Continuation<? super LocalVideoLandAdControl$onShowEndAd$1> continuation) {
        super(2, continuation);
        this.this$0 = localVideoLandAdControl;
        this.$showPlayerAdCallback = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocalVideoLandAdControl$onShowEndAd$1(this.this$0, this.$showPlayerAdCallback, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((LocalVideoLandAdControl$onShowEndAd$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            if (this.this$0.f55176s == null) {
                this.this$0.f55176s = new WrapperNativeManager();
            }
            WrapperNativeManager wrapperNativeManager = this.this$0.f55176s;
            if (wrapperNativeManager != null) {
                final Function1<Integer, Unit> function1 = this.$showPlayerAdCallback;
                final LocalVideoLandAdControl localVideoLandAdControl = this.this$0;
                WrapperAdListener wrapperAdListener = new WrapperAdListener() { // from class: com.transsion.postdetail.layer.local.LocalVideoLandAdControl$onShowEndAd$1.1
                    @Override // com.transsion.ad.middle.WrapperAdListener, com.hisavana.common.interfacz.TAdListener
                    public void onLoad() {
                        super.onLoad();
                        Function1<Integer, Unit> function2 = function1;
                        if (function2 != null) {
                            function2.invoke(2);
                        }
                        FrameLayout frameLayout = localVideoLandAdControl.f55169l;
                        if (frameLayout != null) {
                            so.c.k(frameLayout);
                        }
                        WrapperNativeManager wrapperNativeManager2 = localVideoLandAdControl.f55176s;
                        if (wrapperNativeManager2 != null) {
                            FrameLayout frameLayout2 = localVideoLandAdControl.f55168k;
                            com.transsion.wrapperad.middle.nativead.f fVar = com.transsion.wrapperad.middle.nativead.f.f60247a;
                            WrapperNativeManager wrapperNativeManager3 = localVideoLandAdControl.f55176s;
                            String sceneId = wrapperNativeManager3 != null ? wrapperNativeManager3.getSceneId() : null;
                            WrapperNativeManager wrapperNativeManager4 = localVideoLandAdControl.f55176s;
                            boolean zIsMonopolyAd = wrapperNativeManager4 != null ? wrapperNativeManager4.isMonopolyAd() : false;
                            WrapperNativeManager wrapperNativeManager5 = localVideoLandAdControl.f55176s;
                            WrapperNativeManager.showNativeAd$default(wrapperNativeManager2, frameLayout2, false, false, fVar.a(sceneId, zIsMonopolyAd, wrapperNativeManager5 != null ? wrapperNativeManager5.getNativeInfo() : null, localVideoLandAdControl.f55167j), 6, null);
                        }
                        if (((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).e1()) {
                            ((IInterceptReportApi) com.alibaba.android.arouter.launcher.a.d().h(IInterceptReportApi.class)).Z();
                        }
                    }
                };
                com.transsion.ad.strategy.b bVar = com.transsion.ad.strategy.b.f50584a;
                DownloadBean downloadBean = this.this$0.B;
                Map<String, Object> mapA = bVar.a(downloadBean != null ? downloadBean.getGenre() : null);
                this.label = 1;
                if (wrapperNativeManager.loadNativeAd("VideoEndBidScene", wrapperAdListener, mapA, this) == objE) {
                    return objE;
                }
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f68710a;
    }
}
