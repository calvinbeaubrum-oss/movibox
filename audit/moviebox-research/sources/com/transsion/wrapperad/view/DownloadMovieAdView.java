package com.transsion.wrapperad.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.v;
import com.hisavana.mediation.ad.TAdNativeView;
import com.transsion.ad.middle.WrapperAdListener;
import com.transsion.ad.middle.icon.BuyOutIconView;
import com.transsion.ad.middle.icon.WrapperIconAdManager;
import com.transsion.ad.middle.icon.WrapperIconBean;
import com.transsion.wrapperad.R$id;
import com.transsion.wrapperad.R$layout;
import com.transsion.wrapperad.R$mipmap;
import com.transsion.wrapperad.middle.nativead.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class DownloadMovieAdView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TAdNativeView f60248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BuyOutIconView f60249b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WrapperIconAdManager f60250c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f60251d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final WrapperAdListener f60252f;

    /* JADX INFO: renamed from: com.transsion.wrapperad.view.DownloadMovieAdView$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.wrapperad.view.DownloadMovieAdView$2", f = "DownloadMovieAdView.kt", l = {81}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DownloadMovieAdView.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            WrapperIconAdManager wrapperIconAdManager;
            DownloadMovieAdView downloadMovieAdView;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                DownloadMovieAdView downloadMovieAdView2 = DownloadMovieAdView.this;
                wrapperIconAdManager = new WrapperIconAdManager();
                WrapperAdListener wrapperAdListener = DownloadMovieAdView.this.f60252f;
                this.L$0 = wrapperIconAdManager;
                this.L$1 = downloadMovieAdView2;
                this.label = 1;
                if (wrapperIconAdManager.loadIconAd("DownloadMovieAppDistributionScene", true, 1, wrapperAdListener, this) == objE) {
                    return objE;
                }
                downloadMovieAdView = downloadMovieAdView2;
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                downloadMovieAdView = (DownloadMovieAdView) this.L$1;
                wrapperIconAdManager = (WrapperIconAdManager) this.L$0;
                ResultKt.b(obj);
            }
            downloadMovieAdView.f60250c = wrapperIconAdManager;
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DownloadMovieAdView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DownloadMovieAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DownloadMovieAdView(Context context, AttributeSet attributeSet, int i11) {
        LifecycleCoroutineScope lifecycleCoroutineScopeA;
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f60251d = true;
        this.f60252f = new WrapperAdListener() { // from class: com.transsion.wrapperad.view.DownloadMovieAdView$listener$1
            @Override // com.transsion.ad.middle.WrapperAdListener
            public void onWrapperIconReady(List<WrapperIconBean> list) throws InterruptedException {
                super.onWrapperIconReady(list);
                com.transsion.ad.a.B(com.transsion.ad.a.f50276a, "DownloadMovieAdView --> onWrapperIconReady() --> size = " + (list != null ? Integer.valueOf(list.size()) : null) + " --> data = " + list, false, 2, null);
                this.this$0.c(list);
                if (list == null || !(!list.isEmpty())) {
                    return;
                }
                this.this$0.setVisibility(0);
            }
        };
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.view_download_movie_ad_layout, (ViewGroup) this, false);
        addView(viewInflate);
        setVisibility(8);
        this.f60248a = (TAdNativeView) viewInflate.findViewById(R$id.tAdNativeView);
        this.f60249b = (BuyOutIconView) viewInflate.findViewById(R$id.buyOutIconView);
        final ImageView imageView = (ImageView) viewInflate.findViewById(R$id.ivCheck);
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.wrapperad.view.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadMovieAdView.b(this.f60267a, imageView, view);
                }
            });
        }
        AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
        if (appCompatActivity == null || (lifecycleCoroutineScopeA = v.a(appCompatActivity)) == null) {
            return;
        }
        j.d(lifecycleCoroutineScopeA, null, null, new AnonymousClass2(null), 3, null);
    }

    public /* synthetic */ DownloadMovieAdView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public static final void b(DownloadMovieAdView this$0, ImageView this_apply, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(this_apply, "$this_apply");
        boolean z11 = !this$0.f60251d;
        this$0.f60251d = z11;
        this_apply.setImageResource(z11 ? R$mipmap.ad_check_oval_2 : R$mipmap.ad_check_oval_1);
    }

    public final void c(List<WrapperIconBean> list) throws InterruptedException {
        List<WrapperIconBean> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        WrapperIconBean wrapperIconBean = list.get(0);
        e eVar = new e();
        if (wrapperIconBean.getType() == 2) {
            WrapperIconAdManager wrapperIconAdManager = this.f60250c;
            if (wrapperIconAdManager != null) {
                wrapperIconAdManager.bindHiIconView(eVar, this.f60248a, getContext(), wrapperIconBean.getNativeInfo());
            }
            BuyOutIconView buyOutIconView = this.f60249b;
            if (buyOutIconView == null) {
                return;
            }
            buyOutIconView.setVisibility(8);
            return;
        }
        WrapperIconAdManager wrapperIconAdManager2 = this.f60250c;
        if (wrapperIconAdManager2 != null) {
            wrapperIconAdManager2.bindPsIconView(wrapperIconBean.getRecommendInfo(), eVar, this.f60249b, getContext());
        }
        TAdNativeView tAdNativeView = this.f60248a;
        if (tAdNativeView == null) {
            return;
        }
        tAdNativeView.setVisibility(8);
    }

    public final void download() throws InterruptedException {
        WrapperIconAdManager wrapperIconAdManager;
        if (!this.f60251d || (wrapperIconAdManager = this.f60250c) == null) {
            return;
        }
        wrapperIconAdManager.clickAd();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        WrapperIconAdManager wrapperIconAdManager = this.f60250c;
        if (wrapperIconAdManager != null) {
            wrapperIconAdManager.destroy();
        }
    }
}
