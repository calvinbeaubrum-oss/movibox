package com.transsion.wrapperad.view;

import android.content.Context;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.v;
import com.hisavana.common.bean.TAdErrorCode;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;

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
public final class NativeSlideshowView$loadBottomAd$1 extends jq.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NativeSlideshowView f60265a;

    public NativeSlideshowView$loadBottomAd$1(NativeSlideshowView nativeSlideshowView) {
        this.f60265a = nativeSlideshowView;
    }

    public static final void o(NativeSlideshowView this$0) {
        Intrinsics.g(this$0, "this$0");
        NativeWrapperAdView nativeWrapperAdView = this$0.f60264k;
        if (nativeWrapperAdView != null) {
            nativeWrapperAdView.setVisibility(8);
        }
        NativeWrapperAdView nativeWrapperAdView2 = this$0.f60263j;
        if (nativeWrapperAdView2 != null) {
            nativeWrapperAdView2.setVisibility(0);
        }
        com.transsion.ad.bidding.nativead.c cVar = this$0.f60258d;
        if (cVar != null) {
            cVar.F();
        }
        this$0.f60258d = null;
    }

    @Override // jq.a
    public void g(TAdErrorCode tAdErrorCode) {
        super.g(tAdErrorCode);
        this.f60265a.h(true);
    }

    @Override // jq.a
    public void h(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        LifecycleCoroutineScope lifecycleCoroutineScopeA;
        super.h(biddingIntermediateMaterialBean);
        com.transsion.ad.a.J(com.transsion.ad.a.f50276a, this.f60265a.getClassTag() + " --> loadBottomAd() --> sceneId = " + this.f60265a.getSceneId(), false, 2, null);
        Context context = this.f60265a.getContext();
        if (context != null) {
            NativeSlideshowView nativeSlideshowView = this.f60265a;
            Context context2 = nativeSlideshowView.getContext();
            AppCompatActivity appCompatActivity = context2 instanceof AppCompatActivity ? (AppCompatActivity) context2 : null;
            if (appCompatActivity != null && (lifecycleCoroutineScopeA = v.a(appCompatActivity)) != null) {
                j.d(lifecycleCoroutineScopeA, null, null, new NativeSlideshowView$loadBottomAd$1$onBiddingLoad$1$1(context, nativeSlideshowView, null), 3, null);
            }
        }
        Handler handler = this.f60265a.f60260g;
        final NativeSlideshowView nativeSlideshowView2 = this.f60265a;
        handler.postDelayed(new Runnable() { // from class: com.transsion.wrapperad.view.c
            @Override // java.lang.Runnable
            public final void run() {
                NativeSlideshowView$loadBottomAd$1.o(nativeSlideshowView2);
            }
        }, 300L);
        NativeSlideshowView.i(this.f60265a, false, 1, null);
    }
}
