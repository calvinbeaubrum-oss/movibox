package com.transsion.wrapperad.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.v;
import com.transsion.ad.strategy.MeasureManager;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.wrapperad.R$id;
import com.transsion.wrapperad.R$layout;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.s;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class NativeSlideshowView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f60255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f60256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, ? extends Object> f60257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.transsion.ad.bidding.nativead.c f60258d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.transsion.ad.bidding.nativead.c f60259f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Handler f60260g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f60261h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function0<Unit> f60262i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public NativeWrapperAdView f60263j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public NativeWrapperAdView f60264k;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NativeSlideshowView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NativeSlideshowView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NativeSlideshowView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f60260g = new Handler(Looper.getMainLooper());
        this.f60261h = 1L;
        this.f60262i = new Function0<Unit>() { // from class: com.transsion.wrapperad.view.NativeSlideshowView$postAdDelayed$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                NativeSlideshowView.f(this.this$0, false, 1, null);
            }
        };
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.view_native_slideshow_layout, (ViewGroup) this, false);
        this.f60264k = (NativeWrapperAdView) viewInflate.findViewById(R$id.vTop);
        this.f60263j = (NativeWrapperAdView) viewInflate.findViewById(R$id.vBottom);
        addView(viewInflate);
    }

    public /* synthetic */ NativeSlideshowView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public static /* synthetic */ long c(NativeSlideshowView nativeSlideshowView, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        return nativeSlideshowView.b(z11);
    }

    public static /* synthetic */ void f(NativeSlideshowView nativeSlideshowView, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        nativeSlideshowView.e(z11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getClassTag() {
        String simpleName = NativeSlideshowView.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public static /* synthetic */ void i(NativeSlideshowView nativeSlideshowView, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        nativeSlideshowView.h(z11);
    }

    public static final void j(Function0 tmp0) {
        Intrinsics.g(tmp0, "$tmp0");
        tmp0.invoke();
    }

    public final void affirm() {
        com.transsion.ad.a.J(com.transsion.ad.a.f50276a, getClassTag() + " --> affirm() --> 确认是否有广告在展示 --> sceneId = " + getSceneId(), false, 2, null);
    }

    public final long b(boolean z11) {
        if (z11) {
            this.f60261h++;
        } else {
            this.f60261h = 1L;
        }
        long jD = wq.a.f79581a.d(getSceneId()) * 1000;
        long j11 = this.f60261h;
        return jD * j11 * j11;
    }

    public final void d() {
        if (this.f60259f == null) {
            com.transsion.ad.bidding.nativead.c cVar = new com.transsion.ad.bidding.nativead.c();
            this.f60259f = cVar;
            cVar.m0(getSceneId());
            com.transsion.ad.bidding.nativead.c cVar2 = this.f60258d;
            if (cVar2 != null) {
                cVar2.k0(getCtxMap());
            }
            com.transsion.ad.bidding.nativead.c cVar3 = this.f60259f;
            if (cVar3 != null) {
                cVar3.l0(new NativeSlideshowView$loadBottomAd$1(this));
            }
        }
        Context context = getContext();
        AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
        if (appCompatActivity != null) {
            j.d(v.a(appCompatActivity), null, null, new NativeSlideshowView$loadBottomAd$2$1(this, null), 3, null);
        }
    }

    public final void destroy() {
        com.transsion.ad.bidding.nativead.c cVar = this.f60258d;
        if (cVar != null) {
            cVar.F();
        }
        com.transsion.ad.bidding.nativead.c cVar2 = this.f60259f;
        if (cVar2 != null) {
            cVar2.F();
        }
        this.f60260g.removeCallbacksAndMessages(null);
    }

    public final void e(boolean z11) {
        if (MeasureManager.f50573a.m(this) || z11) {
            NativeWrapperAdView nativeWrapperAdView = this.f60264k;
            if (nativeWrapperAdView == null || nativeWrapperAdView.getVisibility() != 8) {
                d();
                return;
            } else {
                g();
                return;
            }
        }
        com.transsion.ad.a.L(com.transsion.ad.a.f50276a, getClassTag() + " --> loadNextAd() --> 广告容器不可见，不加载广告了 -- 延迟触发加载", false, 2, null);
        i(this, false, 1, null);
    }

    public final void g() {
        if (this.f60258d == null) {
            com.transsion.ad.bidding.nativead.c cVar = new com.transsion.ad.bidding.nativead.c();
            this.f60258d = cVar;
            cVar.m0(getSceneId());
            com.transsion.ad.bidding.nativead.c cVar2 = this.f60258d;
            if (cVar2 != null) {
                cVar2.k0(getCtxMap());
            }
            com.transsion.ad.bidding.nativead.c cVar3 = this.f60258d;
            if (cVar3 != null) {
                cVar3.l0(new NativeSlideshowView$loadTopAd$1(this));
            }
        }
        Context context = getContext();
        AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
        if (appCompatActivity != null) {
            j.d(v.a(appCompatActivity), null, null, new NativeSlideshowView$loadTopAd$2$1(this, null), 3, null);
        }
    }

    public final Map<String, Object> getCtxMap() {
        Map<String, ? extends Object> map = this.f60257c;
        return map == null ? s.h() : map;
    }

    public final View getReferenceView() {
        return this.f60256b;
    }

    public final String getSceneId() {
        return this.f60255a;
    }

    public final void h(boolean z11) {
        Handler handler = this.f60260g;
        final Function0<Unit> function0 = this.f60262i;
        handler.postDelayed(new Runnable() { // from class: com.transsion.wrapperad.view.b
            @Override // java.lang.Runnable
            public final void run() {
                NativeSlideshowView.j(function0);
            }
        }, b(z11));
    }

    public final void initAd() {
        com.transsion.ad.a.J(com.transsion.ad.a.f50276a, getClassTag() + " --> start() --> 页面创建了 --> delayTime = " + c(this, false, 1, null) + " --> sceneId = " + getSceneId(), false, 2, null);
        e(true);
    }

    public final void setCtxMap(Map<String, ? extends Object> map) {
        this.f60257c = map;
    }

    public final void setReferenceView(View view) {
        this.f60256b = view;
    }

    public final void setSceneId(String str) {
        this.f60255a = str;
    }
}
