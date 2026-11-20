package com.transsion.postdetail.util;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.v;
import com.blankj.utilcode.util.f0;
import com.google.android.material.card.MaterialCardView;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.mediation.ad.TAdChoicesView;
import com.hisavana.mediation.ad.TMediaView;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baseui.R$mipmap;
import com.transsion.commercializationapi.IInterceptReportApi;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.MemberSource;
import com.transsion.postdetail.layer.local.LocalUiType;
import com.transsion.postdetail.ui.view.AdCountDownView;
import com.transsion.videofloat.VideoPipManager;
import com.transsion.wrapperad.R$drawable;
import com.transsion.wrapperad.R$id;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import tv.n0;
import tv.y;

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
public final class LocalVideoAdHelper {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final a f56168v = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LifecycleCoroutineScope f56169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DownloadBean f56170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public tv.j f56171c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f56172d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f56173e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<Unit> f56174f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.transsion.ad.bidding.nativead.c f56175g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.transsion.ad.bidding.interstitial.a f56176h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f56177i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f56178j = "";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f56179k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f56180l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f56181m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f56182n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f56183o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f56184p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f56185q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f56186r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public CountDownTimer f56187s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public CountDownTimer f56188t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f56189u;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends CountDownTimer {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.IntRef f56191b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f56192c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Ref.IntRef intRef, String str, long j11) {
            super(j11, 1000L);
            this.f56191b = intRef;
            this.f56192c = str;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (Intrinsics.b(this.f56192c, "VideoStartBidScene")) {
                LocalVideoAdHelper.this.M0();
            }
            LocalVideoAdHelper.this.f56189u = 0;
            LocalVideoAdHelper.this.H();
            LocalVideoAdHelper.this.J();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j11) {
            AdCountDownView adCountDownView;
            LocalVideoAdHelper localVideoAdHelper = LocalVideoAdHelper.this;
            Ref.IntRef intRef = this.f56191b;
            int i11 = intRef.element;
            intRef.element = i11 - 1;
            localVideoAdHelper.f56189u = i11;
            tv.j jVar = LocalVideoAdHelper.this.f56171c;
            if (jVar == null || (adCountDownView = jVar.f77796d) == null) {
                return;
            }
            adCountDownView.refreshCountDown(LocalVideoAdHelper.this.f56189u);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements su.b {
        public c() {
        }

        @Override // su.b
        public void a() {
            com.transsion.ad.a.j(com.transsion.ad.a.f50276a, LocalVideoAdHelper.this.N() + " --> startMemberPage() --> onFailed()", false, 2, null);
        }

        @Override // su.b
        public void onSuccess() {
            LocalVideoAdHelper.this.H();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d extends CountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LocalVideoAdHelper f56194a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.LongRef f56195b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(long j11, LocalVideoAdHelper localVideoAdHelper, Ref.LongRef longRef) {
            super(j11, 1000L);
            this.f56194a = localVideoAdHelper;
            this.f56195b = longRef;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            this.f56194a.K();
            this.f56194a.f56183o++;
            this.f56194a.D0("VideoInterpolateBidScene");
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j11) {
            tv.j jVar = this.f56194a.f56171c;
            AppCompatTextView appCompatTextView = jVar != null ? jVar.f77797f : null;
            if (appCompatTextView == null) {
                return;
            }
            LocalVideoAdHelper localVideoAdHelper = this.f56194a;
            Ref.LongRef longRef = this.f56195b;
            long j12 = longRef.element;
            longRef.element = (-1) + j12;
            appCompatTextView.setText(localVideoAdHelper.O(j12));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void G0(LocalVideoAdHelper localVideoAdHelper, String str, Function0 function0, Function0 function1, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function0 = null;
        }
        if ((i11 & 4) != 0) {
            function1 = null;
        }
        localVideoAdHelper.F0(str, function0, function1);
    }

    public static final void J0(LocalVideoAdHelper this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.G();
    }

    public static final void Y(LocalVideoAdHelper this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        ((IInterceptReportApi) com.alibaba.android.arouter.launcher.a.d().h(IInterceptReportApi.class)).w1();
        Object objH = com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class);
        Intrinsics.f(objH, "getInstance().navigation(IMemberApi::class.java)");
        IMemberApi.a.c((IMemberApi) objH, com.blankj.utilcode.util.a.b(), MemberSource.SOURCE_LANDSCAPE_PLAY, this$0.new c(), false, 8, null);
    }

    public static final void v0(TMediaView tMediaView) {
        View childAt;
        ViewGroup.LayoutParams layoutParams;
        View mediaView = tMediaView.getMediaView();
        if (mediaView != null) {
            mediaView.getLayoutParams().height = -1;
            if (!(mediaView instanceof ViewGroup) || (childAt = ((ViewGroup) mediaView).getChildAt(0)) == null || (layoutParams = childAt.getLayoutParams()) == null) {
                return;
            }
            Intrinsics.f(layoutParams, "layoutParams");
            layoutParams.height = -1;
        }
    }

    public final void A0(ViewGroup viewGroup, boolean z11) {
        ImageView imageView = viewGroup != null ? (ImageView) viewGroup.findViewWithTag("adVolumeImage") : null;
        if (imageView != null) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            Intrinsics.e(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            if (z11) {
                layoutParams2.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_TOP_END;
                layoutParams2.topMargin = f0.a(4.0f);
                layoutParams2.setMarginEnd(f0.a(40.0f));
                int iA = f0.a(28.0f);
                layoutParams2.width = iA;
                layoutParams2.height = iA;
                return;
            }
            layoutParams2.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_BOTTOM_START;
            layoutParams2.setMarginStart(f0.a(this.f56177i ? 16.0f : 12.0f));
            layoutParams2.bottomMargin = f0.a(16.0f);
            int iA2 = f0.a(this.f56177i ? 40.0f : 28.0f);
            layoutParams2.width = iA2;
            layoutParams2.height = iA2;
        }
    }

    public final void B0(final Function0<Unit> callback) {
        Intrinsics.g(callback, "callback");
        this.f56174f = callback;
        if (this.f56186r && a0()) {
            return;
        }
        this.f56186r = true;
        d0(new Function0<Unit>() { // from class: com.transsion.postdetail.util.LocalVideoAdHelper$showInterpolateAd$1
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
                this.this$0.L0();
            }
        }, new Function0<Unit>() { // from class: com.transsion.postdetail.util.LocalVideoAdHelper$showInterpolateAd$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                this.this$0.f56186r = false;
                callback.invoke();
            }
        });
    }

    public final void C0() {
        ConstraintLayout root;
        Context context;
        com.transsion.ad.bidding.interstitial.a aVar;
        E(true);
        this.f56181m = true;
        tv.j jVar = this.f56171c;
        if (jVar != null && (root = jVar.getRoot()) != null && (context = root.getContext()) != null && (aVar = this.f56176h) != null) {
            aVar.n0((AppCompatActivity) context);
        }
        K();
    }

    public final void D0(String str) {
        ConstraintLayout root;
        Context context;
        NativeWrapperAdView nativeWrapperAdView;
        Function1<? super Boolean, Unit> function1 = this.f56173e;
        if (function1 != null) {
            function1.invoke(Boolean.TRUE);
        }
        this.f56184p = true;
        this.f56182n = System.currentTimeMillis();
        tv.j jVar = this.f56171c;
        if (jVar != null && (root = jVar.getRoot()) != null && (context = root.getContext()) != null) {
            d00.b bVar = d00.b.f62855a;
            com.transsion.ad.bidding.nativead.c cVar = this.f56175g;
            zq.b bVarA = bVar.a(context, cVar != null ? cVar.Q() : null);
            tv.j jVar2 = this.f56171c;
            if (jVar2 != null && (nativeWrapperAdView = jVar2.f77798g) != null) {
                nativeWrapperAdView.bindNativeView(this.f56175g, bVarA);
            }
        }
        q0(false);
        tv.j jVar3 = this.f56171c;
        FrameLayout frameLayout = jVar3 != null ? jVar3.f77799h : null;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        F(str);
        b0();
    }

    public final void E(boolean z11) {
        Function1<? super Boolean, Unit> function1 = this.f56173e;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(z11));
        }
    }

    public final void E0() {
        if (this.f56177i) {
            G0(this, "LandscapePauseSceneNew", null, new Function0<Unit>() { // from class: com.transsion.postdetail.util.LocalVideoAdHelper$showPauseAd$1
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
                    this.this$0.E(false);
                }
            }, 2, null);
        } else {
            G0(this, "VerticalPauseScene", null, new Function0<Unit>() { // from class: com.transsion.postdetail.util.LocalVideoAdHelper$showPauseAd$2
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
                    this.this$0.E(false);
                }
            }, 2, null);
        }
    }

    public final void F(String str) {
        AdCountDownView adCountDownView;
        Ref.IntRef intRef = new Ref.IntRef();
        int iL = this.f56189u;
        if (iL == 0) {
            iL = L(str);
        }
        intRef.element = iL;
        tv.j jVar = this.f56171c;
        if (jVar != null && (adCountDownView = jVar.f77796d) != null) {
            adCountDownView.refreshCountDown(iL);
        }
        J();
        b bVar = new b(intRef, str, ((long) intRef.element) * 1000);
        this.f56188t = bVar;
        bVar.start();
    }

    public final void F0(String str, Function0<Unit> function0, Function0<Unit> function1) {
        com.transsion.ad.a.j(com.transsion.ad.a.f50276a, N() + " --> showSceneAd() --> sceneId = " + str, false, 2, null);
        LifecycleCoroutineScope lifecycleCoroutineScope = this.f56169a;
        if (lifecycleCoroutineScope != null) {
            kotlinx.coroutines.j.d(lifecycleCoroutineScope, null, null, new LocalVideoAdHelper$showSceneAd$1(str, this, function0, function1, null), 3, null);
        }
    }

    public final void G() {
        if (TextUtils.equals(this.f56178j, "LandscapePauseSceneNew") || TextUtils.equals(this.f56178j, "VerticalPauseScene")) {
            H();
        }
    }

    public final void H() {
        com.transsion.ad.a.j(com.transsion.ad.a.f50276a, N() + " --> closeSceneAd()", false, 2, null);
        LifecycleCoroutineScope lifecycleCoroutineScope = this.f56169a;
        if (lifecycleCoroutineScope != null) {
            kotlinx.coroutines.j.d(lifecycleCoroutineScope, null, null, new LocalVideoAdHelper$closeSceneAd$1(this, null), 3, null);
        }
    }

    public final void H0(Function0<Unit> callback) {
        Intrinsics.g(callback, "callback");
        this.f56174f = callback;
        com.transsion.ad.a.j(com.transsion.ad.a.f50276a, N() + " --> showStartAd() --> " + this.f56179k, false, 2, null);
        if (this.f56179k && a0()) {
            F0("VideoStartBidScene", new Function0<Unit>() { // from class: com.transsion.postdetail.util.LocalVideoAdHelper$showStartAd$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            }, new Function0<Unit>() { // from class: com.transsion.postdetail.util.LocalVideoAdHelper$showStartAd$2
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
                    Function1 function1 = this.this$0.f56173e;
                    if (function1 != null) {
                        function1.invoke(Boolean.FALSE);
                    }
                    this.this$0.k0();
                }
            });
        } else {
            k0();
        }
    }

    public final void I() {
        com.transsion.ad.bidding.nativead.c cVar = this.f56175g;
        if (cVar != null) {
            cVar.F();
        }
        this.f56175g = null;
        com.transsion.ad.bidding.interstitial.a aVar = this.f56176h;
        if (aVar != null) {
            aVar.F();
        }
        this.f56176h = null;
        this.f56171c = null;
        J();
        K();
    }

    public final void I0() {
        ImageView imageView;
        ConstraintLayout root;
        Context context;
        NativeWrapperAdView nativeWrapperAdView;
        Function1<? super Boolean, Unit> function1 = this.f56173e;
        if (function1 != null) {
            function1.invoke(Boolean.TRUE);
        }
        this.f56181m = true;
        tv.j jVar = this.f56171c;
        if (jVar != null && (root = jVar.getRoot()) != null && (context = root.getContext()) != null) {
            d00.b bVar = d00.b.f62855a;
            com.transsion.ad.bidding.nativead.c cVar = this.f56175g;
            zq.b bVarA = bVar.a(context, cVar != null ? cVar.Q() : null);
            tv.j jVar2 = this.f56171c;
            if (jVar2 != null && (nativeWrapperAdView = jVar2.f77795c) != null) {
                nativeWrapperAdView.bindNativeView(this.f56175g, bVarA);
            }
        }
        q0(true);
        tv.j jVar3 = this.f56171c;
        ConstraintLayout constraintLayout = jVar3 != null ? jVar3.f77800i : null;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        tv.j jVar4 = this.f56171c;
        if (jVar4 != null && (imageView = jVar4.f77802k) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.util.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LocalVideoAdHelper.J0(this.f56209a, view);
                }
            });
        }
        K();
    }

    public final void J() {
        CountDownTimer countDownTimer = this.f56188t;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.f56188t = null;
    }

    public final void K() {
        AppCompatTextView appCompatTextView;
        CountDownTimer countDownTimer = this.f56187s;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.f56187s = null;
        tv.j jVar = this.f56171c;
        if (jVar == null || (appCompatTextView = jVar.f77797f) == null) {
            return;
        }
        so.c.g(appCompatTextView);
    }

    public final void K0() {
        boolean z11 = System.currentTimeMillis() - this.f56182n > ((long) M());
        com.transsion.ad.a.j(com.transsion.ad.a.f50276a, N() + " --> showVideoEndAd(), isShowEndAdEnable -> " + this.f56180l + ", isReachInterval -> " + z11, false, 2, null);
        if (this.f56180l && z11 && a0()) {
            F0("VideoEndBidScene", new Function0<Unit>() { // from class: com.transsion.postdetail.util.LocalVideoAdHelper$showVideoEndAd$1
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
                    ConstraintLayout root;
                    tv.j jVar = this.this$0.f56171c;
                    Context context = (jVar == null || (root = jVar.getRoot()) == null) ? null : root.getContext();
                    AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
                    if (appCompatActivity != null) {
                        kotlinx.coroutines.j.d(v.a(appCompatActivity), null, null, new LocalVideoAdHelper$showVideoEndAd$1$1$1(this.this$0, null), 3, null);
                    }
                }
            }, new Function0<Unit>() { // from class: com.transsion.postdetail.util.LocalVideoAdHelper$showVideoEndAd$2
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            });
        }
    }

    public final int L(String str) {
        JsonElement jsonElement;
        JsonElement jsonElement2;
        JsonElement jsonElement3;
        int iHashCode = str.hashCode();
        if (iHashCode != -172473003) {
            if (iHashCode != -73588874) {
                if (iHashCode == 2049503279 && str.equals("VideoEndBidScene")) {
                    JsonObject jsonObjectB = wq.d.f79584a.b("VideoEndBidScene");
                    if (jsonObjectB == null || (jsonElement3 = jsonObjectB.get("videoEndAdCountdownTime")) == null) {
                        return 10;
                    }
                    return jsonElement3.getAsInt();
                }
            } else if (str.equals("VideoStartBidScene")) {
                JsonObject jsonObjectB2 = wq.d.f79584a.b("VideoStartBidScene");
                if (jsonObjectB2 == null || (jsonElement2 = jsonObjectB2.get("videoStartAdCountdownTime")) == null) {
                    return 10;
                }
                return jsonElement2.getAsInt();
            }
        } else if (str.equals("VideoInterpolateBidScene")) {
            JsonObject jsonObjectB3 = wq.d.f79584a.b("VideoInterpolateBidScene");
            if (jsonObjectB3 == null || (jsonElement = jsonObjectB3.get("videoInterpolateAdCountdownTime")) == null) {
                return 10;
            }
            return jsonElement.getAsInt();
        }
        return 0;
    }

    public final void L0() {
        AppCompatTextView appCompatTextView;
        K();
        long jQ = Q();
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = jQ / ((long) 1000);
        tv.j jVar = this.f56171c;
        if (jVar != null && (appCompatTextView = jVar.f77797f) != null) {
            so.c.k(appCompatTextView);
        }
        tv.j jVar2 = this.f56171c;
        AppCompatTextView appCompatTextView2 = jVar2 != null ? jVar2.f77797f : null;
        if (appCompatTextView2 != null) {
            appCompatTextView2.setText(O(longRef.element));
        }
        d dVar = new d(jQ, this, longRef);
        this.f56187s = dVar;
        dVar.start();
    }

    public final int M() {
        JsonElement jsonElement;
        JsonObject jsonObjectB = wq.d.f79584a.b("VideoEndBidScene");
        return ((jsonObjectB == null || (jsonElement = jsonObjectB.get("threshold")) == null) ? 5 : jsonElement.getAsInt()) * 60000;
    }

    public final void M0() {
        ConstraintLayout root;
        tv.j jVar = this.f56171c;
        Context context = (jVar == null || (root = jVar.getRoot()) == null) ? null : root.getContext();
        AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
        if (appCompatActivity != null) {
            kotlinx.coroutines.j.d(v.a(appCompatActivity), null, null, new LocalVideoAdHelper$updateAdStartLastShowTime$1$1(this, null), 3, null);
        }
    }

    public final String N() {
        String simpleName = LocalVideoAdHelper.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.transsion.postdetail.util.LocalVideoAdHelper$wrapperAdListener$1] */
    public final LocalVideoAdHelper$wrapperAdListener$1 N0(final String str, final Function0<Unit> function0, final Function0<Unit> function1) {
        return new jq.a() { // from class: com.transsion.postdetail.util.LocalVideoAdHelper$wrapperAdListener$1
            @Override // jq.a
            public void g(TAdErrorCode tAdErrorCode) {
                com.transsion.ad.a.j(com.transsion.ad.a.f50276a, this.f56196a.N() + " --> loadAd() --> onError() --> p0 = " + tAdErrorCode, false, 2, null);
                LifecycleCoroutineScope lifecycleCoroutineScope = this.f56196a.f56169a;
                if (lifecycleCoroutineScope != null) {
                    kotlinx.coroutines.j.d(lifecycleCoroutineScope, null, null, new LocalVideoAdHelper$wrapperAdListener$1$onBiddingError$1(function1, null), 3, null);
                }
            }

            @Override // jq.a
            public void h(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
                LifecycleCoroutineScope lifecycleCoroutineScope = this.f56196a.f56169a;
                if (lifecycleCoroutineScope != null) {
                    kotlinx.coroutines.j.d(lifecycleCoroutineScope, null, null, new LocalVideoAdHelper$wrapperAdListener$1$onBiddingLoad$1(function0, this.f56196a, str, null), 3, null);
                }
            }

            @Override // jq.a
            public void j(int i11) {
                LifecycleCoroutineScope lifecycleCoroutineScope = this.f56196a.f56169a;
                if (lifecycleCoroutineScope != null) {
                    kotlinx.coroutines.j.d(lifecycleCoroutineScope, null, null, new LocalVideoAdHelper$wrapperAdListener$1$onBiddingWrapperAdClose$1(this.f56196a, null), 3, null);
                }
            }
        };
    }

    public final String O(long j11) {
        return j11 + "s | Enter the AD";
    }

    public final int P() {
        JsonElement jsonElement;
        JsonObject jsonObjectB = wq.d.f79584a.b("VideoEndBidScene");
        return ((jsonObjectB == null || (jsonElement = jsonObjectB.get("interval")) == null) ? 1440 : jsonElement.getAsInt()) * 60000;
    }

    public final int Q() {
        JsonElement jsonElement;
        JsonObject jsonObjectB = wq.d.f79584a.b("VideoInterpolateBidScene");
        return ((jsonObjectB == null || (jsonElement = jsonObjectB.get("enterCountdown")) == null) ? 10 : jsonElement.getAsInt()) * 1000;
    }

    public final int R() {
        JsonElement jsonElement;
        JsonObject jsonObjectB = wq.d.f79584a.b("VideoInterpolateBidScene");
        if (jsonObjectB == null || (jsonElement = jsonObjectB.get("frequency")) == null) {
            return 2;
        }
        return jsonElement.getAsInt();
    }

    public final int S() {
        JsonElement jsonElement;
        JsonObject jsonObjectB = wq.d.f79584a.b("VideoInterpolateBidScene");
        return ((jsonObjectB == null || (jsonElement = jsonObjectB.get("interval")) == null) ? 15 : jsonElement.getAsInt()) * 60000;
    }

    public final int T() {
        return S() - Q();
    }

    public final int U() {
        JsonElement jsonElement;
        JsonObject jsonObjectB = wq.d.f79584a.b("VideoStartBidScene");
        return ((jsonObjectB == null || (jsonElement = jsonObjectB.get("interval")) == null) ? 1440 : jsonElement.getAsInt()) * 60000;
    }

    public final void V() {
        this.f56181m = true;
        E0();
    }

    public final void W(tv.j jVar, String str, Function1<? super Boolean, Unit> adShowCallback) {
        ConstraintLayout root;
        Intrinsics.g(adShowCallback, "adShowCallback");
        com.transsion.ad.a.j(com.transsion.ad.a.f50276a, N() + " --> init()", false, 2, null);
        this.f56171c = jVar;
        this.f56172d = str;
        this.f56173e = adShowCallback;
        Context context = (jVar == null || (root = jVar.getRoot()) == null) ? null : root.getContext();
        AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
        this.f56169a = appCompatActivity != null ? v.a(appCompatActivity) : null;
        X();
        this.f56185q = S();
    }

    public final void X() {
        AdCountDownView adCountDownView;
        tv.j jVar = this.f56171c;
        if (jVar == null || (adCountDownView = jVar.f77796d) == null) {
            return;
        }
        adCountDownView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.util.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LocalVideoAdHelper.Y(this.f56208a, view);
            }
        });
    }

    public final boolean Z(int i11, long j11) {
        return Math.abs(System.currentTimeMillis() - j11) > ((long) i11);
    }

    public final boolean a0() {
        return !VideoPipManager.f60024a.a().k();
    }

    public final void b0() {
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        if (this.f56177i) {
            tv.j jVar = this.f56171c;
            if (jVar == null || (appCompatImageView2 = jVar.f77806o) == null) {
                return;
            }
            appCompatImageView2.setImageResource(R$mipmap.ad_rotate);
            return;
        }
        tv.j jVar2 = this.f56171c;
        if (jVar2 == null || (appCompatImageView = jVar2.f77806o) == null) {
            return;
        }
        appCompatImageView.setImageResource(R$mipmap.ad_fullscreen);
    }

    public final boolean c0() {
        return this.f56183o < R();
    }

    public final void d0(final Function0<Unit> function0, final Function0<Unit> function1) {
        F0("VideoInterpolateBidScene", new Function0<Unit>() { // from class: com.transsion.postdetail.util.LocalVideoAdHelper$loadInterpolateAd$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                function0.invoke();
            }
        }, new Function0<Unit>() { // from class: com.transsion.postdetail.util.LocalVideoAdHelper$loadInterpolateAd$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                Function1 function2 = this.this$0.f56173e;
                if (function2 != null) {
                    function2.invoke(Boolean.FALSE);
                }
                function1.invoke();
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object e0(String str, Function0<Unit> function0, Function0<Unit> function1, Continuation<? super Unit> continuation) throws Throwable {
        LocalVideoAdHelper$loadLandPauseAd$1 localVideoAdHelper$loadLandPauseAd$1;
        ConstraintLayout root;
        Context context;
        if (continuation instanceof LocalVideoAdHelper$loadLandPauseAd$1) {
            localVideoAdHelper$loadLandPauseAd$1 = (LocalVideoAdHelper$loadLandPauseAd$1) continuation;
            int i11 = localVideoAdHelper$loadLandPauseAd$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                localVideoAdHelper$loadLandPauseAd$1.label = i11 - Integer.MIN_VALUE;
            } else {
                localVideoAdHelper$loadLandPauseAd$1 = new LocalVideoAdHelper$loadLandPauseAd$1(this, continuation);
            }
        } else {
            localVideoAdHelper$loadLandPauseAd$1 = new LocalVideoAdHelper$loadLandPauseAd$1(this, continuation);
        }
        Object obj = localVideoAdHelper$loadLandPauseAd$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = localVideoAdHelper$loadLandPauseAd$1.label;
        if (i12 == 0) {
            ResultKt.b(obj);
            tv.j jVar = this.f56171c;
            if (jVar != null && (root = jVar.getRoot()) != null && (context = root.getContext()) != null) {
                com.transsion.ad.bidding.interstitial.a aVar = this.f56176h;
                if (aVar != null) {
                    aVar.F();
                }
                com.transsion.ad.bidding.interstitial.a aVar2 = new com.transsion.ad.bidding.interstitial.a();
                this.f56176h = aVar2;
                aVar2.m0(str);
                com.transsion.ad.bidding.interstitial.a aVar3 = this.f56176h;
                if (aVar3 != null) {
                    aVar3.k0(com.transsion.ad.strategy.b.f50584a.a(this.f56172d));
                }
                com.transsion.ad.bidding.interstitial.a aVar4 = this.f56176h;
                if (aVar4 != null) {
                    aVar4.j0(context);
                }
                com.transsion.ad.bidding.interstitial.a aVar5 = this.f56176h;
                if (aVar5 != null) {
                    aVar5.l0(N0(str, function0, function1));
                }
                com.transsion.ad.bidding.interstitial.a aVar6 = this.f56176h;
                if (aVar6 != null) {
                    localVideoAdHelper$loadLandPauseAd$1.label = 1;
                    if (aVar6.T(localVideoAdHelper$loadLandPauseAd$1) == objE) {
                        return objE;
                    }
                }
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f68710a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object f0(String str, Function0<Unit> function0, Function0<Unit> function1, Continuation<? super Unit> continuation) throws Throwable {
        LocalVideoAdHelper$loadNativeAd$1 localVideoAdHelper$loadNativeAd$1;
        ConstraintLayout root;
        Context context;
        if (continuation instanceof LocalVideoAdHelper$loadNativeAd$1) {
            localVideoAdHelper$loadNativeAd$1 = (LocalVideoAdHelper$loadNativeAd$1) continuation;
            int i11 = localVideoAdHelper$loadNativeAd$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                localVideoAdHelper$loadNativeAd$1.label = i11 - Integer.MIN_VALUE;
            } else {
                localVideoAdHelper$loadNativeAd$1 = new LocalVideoAdHelper$loadNativeAd$1(this, continuation);
            }
        } else {
            localVideoAdHelper$loadNativeAd$1 = new LocalVideoAdHelper$loadNativeAd$1(this, continuation);
        }
        Object obj = localVideoAdHelper$loadNativeAd$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = localVideoAdHelper$loadNativeAd$1.label;
        if (i12 == 0) {
            ResultKt.b(obj);
            tv.j jVar = this.f56171c;
            if (jVar != null && (root = jVar.getRoot()) != null && (context = root.getContext()) != null) {
                com.transsion.ad.bidding.nativead.c cVar = this.f56175g;
                if (cVar != null) {
                    cVar.F();
                }
                com.transsion.ad.bidding.nativead.c cVar2 = new com.transsion.ad.bidding.nativead.c();
                this.f56175g = cVar2;
                cVar2.m0(str);
                com.transsion.ad.bidding.nativead.c cVar3 = this.f56175g;
                if (cVar3 != null) {
                    cVar3.k0(com.transsion.ad.strategy.b.f50584a.a(this.f56172d));
                }
                com.transsion.ad.bidding.nativead.c cVar4 = this.f56175g;
                if (cVar4 != null) {
                    cVar4.j0(context);
                }
                com.transsion.ad.bidding.nativead.c cVar5 = this.f56175g;
                if (cVar5 != null) {
                    cVar5.l0(N0(str, function0, function1));
                }
                com.transsion.ad.bidding.nativead.c cVar6 = this.f56175g;
                if (cVar6 != null) {
                    localVideoAdHelper$loadNativeAd$1.label = 1;
                    if (cVar6.T(localVideoAdHelper$loadNativeAd$1) == objE) {
                        return objE;
                    }
                }
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f68710a;
    }

    public final void g0(String str) {
        this.f56178j = str;
        LifecycleCoroutineScope lifecycleCoroutineScope = this.f56169a;
        if (lifecycleCoroutineScope != null) {
            kotlinx.coroutines.j.d(lifecycleCoroutineScope, null, null, new LocalVideoAdHelper$onAdLoad$1(str, this, null), 3, null);
        }
    }

    public final void h0() {
        K();
        K0();
    }

    public final void i0() {
        this.f56174f = null;
        H();
        this.f56189u = 0;
    }

    public final void j0(LocalUiType uiType, com.transsion.player.orplayer.f fVar) {
        Intrinsics.g(uiType, "uiType");
        this.f56177i = uiType == LocalUiType.LAND;
        com.transsion.ad.a.j(com.transsion.ad.a.f50276a, N() + " --> onScreenUIChange() --> isLandUIType = " + this.f56177i, false, 2, null);
        G();
        if (fVar != null && !fVar.isPlaying() && !fVar.isComplete() && this.f56181m) {
            E0();
        }
        if (this.f56184p) {
            b0();
            q0(false);
        }
    }

    public final void k0() {
        Function0<Unit> function0 = this.f56174f;
        if (function0 != null) {
            function0.invoke();
        }
        this.f56174f = null;
    }

    public final void l0() {
        this.f56181m = false;
        G();
    }

    public final void m0() {
        J();
        K();
    }

    public final void n0() {
        if (this.f56184p) {
            F(this.f56178j);
        }
    }

    public final void o0() {
        Unit unit;
        NativeWrapperAdView nativeWrapperAdView;
        tv.j jVar = this.f56171c;
        TAdChoicesView tAdChoicesView = (jVar == null || (nativeWrapperAdView = jVar.f77798g) == null) ? null : (TAdChoicesView) nativeWrapperAdView.findViewById(R$id.adChoicesView);
        if (tAdChoicesView != null) {
            ViewGroup.LayoutParams layoutParams = tAdChoicesView.getLayoutParams();
            Intrinsics.e(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            ((FrameLayout.LayoutParams) layoutParams).leftMargin = f0.a(this.f56177i ? 14.0f : 10.0f);
            View adChoice = tAdChoicesView.getChildAt(0);
            if (adChoice != null) {
                Intrinsics.f(adChoice, "adChoice");
                ViewGroup.LayoutParams layoutParams2 = adChoice.getLayoutParams();
                int iA = f0.a(this.f56177i ? 24.0f : 16.0f);
                layoutParams2.width = iA;
                layoutParams2.height = iA;
                ((ImageView) adChoice).setScaleType(ImageView.ScaleType.FIT_CENTER);
                p0(adChoice);
                unit = Unit.f68710a;
            } else {
                unit = null;
            }
            if (unit == null) {
                p0(null);
            }
        }
    }

    public final void p0(View view) {
        AdCountDownView adCountDownView;
        float f11;
        tv.j jVar = this.f56171c;
        if (jVar == null || (adCountDownView = jVar.f77796d) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = adCountDownView.getLayoutParams();
        Intrinsics.e(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.topMargin = f0.a(16.0f);
        if (view != null) {
            f11 = this.f56177i ? 58.0f : 35.0f;
        } else {
            f11 = this.f56177i ? 30.0f : 12.0f;
        }
        layoutParams2.leftMargin = f0.a(f11);
        float f12 = this.f56177i ? 16.0f : 10.0f;
        n0 bind = adCountDownView.getBind();
        TextView textView = bind != null ? bind.f77873d : null;
        if (textView != null) {
            textView.setTextSize(f12);
        }
        n0 bind2 = adCountDownView.getBind();
        TextView textView2 = bind2 != null ? bind2.f77874f : null;
        if (textView2 == null) {
            return;
        }
        textView2.setTextSize(f12);
    }

    public final void q0(boolean z11) {
        if (z11) {
            t0();
            y0();
            tv.j jVar = this.f56171c;
            A0(jVar != null ? jVar.f77795c : null, true);
            return;
        }
        w0();
        u0();
        s0();
        x0();
        z0();
        tv.j jVar2 = this.f56171c;
        A0(jVar2 != null ? jVar2.f77798g : null, false);
        o0();
    }

    public final void r0(DownloadBean downloadBean) {
        Long lastAdEndTimeStamp;
        Long lastAdStartTimeStamp;
        this.f56170b = downloadBean;
        long jLongValue = 0;
        this.f56179k = Z(U(), (downloadBean == null || (lastAdStartTimeStamp = downloadBean.getLastAdStartTimeStamp()) == null) ? 0L : lastAdStartTimeStamp.longValue());
        int iP = P();
        if (downloadBean != null && (lastAdEndTimeStamp = downloadBean.getLastAdEndTimeStamp()) != null) {
            jLongValue = lastAdEndTimeStamp.longValue();
        }
        this.f56180l = Z(iP, jLongValue);
        com.transsion.ad.a.j(com.transsion.ad.a.f50276a, N() + " --> setLongVdPlayerBean() --> isShowStartAd = " + this.f56179k + " --> isShowEndAd = " + this.f56180l + " --> downloadBean = " + this.f56170b, false, 2, null);
    }

    public final void s0() {
        AppCompatTextView appCompatTextView;
        tv.j jVar = this.f56171c;
        if (jVar == null || (appCompatTextView = jVar.f77797f) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = appCompatTextView.getLayoutParams();
        Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.b) layoutParams)).height = f0.a(this.f56177i ? 32.0f : 24.0f);
        appCompatTextView.setTextSize(this.f56177i ? 12.0f : 10.0f);
    }

    public final void t0() {
        View view;
        y yVar;
        FrameLayout frameLayout;
        tv.j jVar = this.f56171c;
        if (jVar == null || (view = jVar.f77801j) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        int height = -1;
        ((ViewGroup.MarginLayoutParams) bVar).width = -1;
        if (!this.f56177i) {
            tv.j jVar2 = this.f56171c;
            height = (jVar2 == null || (yVar = jVar2.f77804m) == null || (frameLayout = yVar.S) == null) ? (int) ((((double) (-1)) * 9.0d) / ((double) 16)) : frameLayout.getHeight();
        }
        ((ViewGroup.MarginLayoutParams) bVar).height = height;
    }

    public final void u0() {
        NativeWrapperAdView nativeWrapperAdView;
        com.transsion.ad.bidding.nativead.c cVar = this.f56175g;
        if (cVar == null || cVar.q0()) {
            tv.j jVar = this.f56171c;
            final TMediaView tMediaView = (jVar == null || (nativeWrapperAdView = jVar.f77798g) == null) ? null : (TMediaView) nativeWrapperAdView.findViewById(R$id.native_ad_media);
            if (tMediaView != null) {
                tMediaView.post(new Runnable() { // from class: com.transsion.postdetail.util.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        LocalVideoAdHelper.v0(tMediaView);
                    }
                });
            }
        }
    }

    public final void w0() {
        FrameLayout frameLayout;
        y yVar;
        FrameLayout frameLayout2;
        tv.j jVar = this.f56171c;
        if (jVar == null || (frameLayout = jVar.f77799h) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        int height = -1;
        layoutParams.width = -1;
        if (!this.f56177i) {
            tv.j jVar2 = this.f56171c;
            height = (jVar2 == null || (yVar = jVar2.f77804m) == null || (frameLayout2 = yVar.S) == null) ? (int) ((((double) (-1)) * 9.0d) / ((double) 16)) : frameLayout2.getHeight();
        }
        layoutParams.height = height;
    }

    public final void x0() {
        NativeWrapperAdView nativeWrapperAdView;
        tv.j jVar = this.f56171c;
        AppCompatTextView appCompatTextView = (jVar == null || (nativeWrapperAdView = jVar.f77798g) == null) ? null : (AppCompatTextView) nativeWrapperAdView.findViewById(R$id.learn_more);
        if (appCompatTextView != null) {
            ViewGroup.LayoutParams layoutParams = appCompatTextView.getLayoutParams();
            ConstraintLayout.b bVar = layoutParams instanceof ConstraintLayout.b ? (ConstraintLayout.b) layoutParams : null;
            if (bVar != null) {
                ((ViewGroup.MarginLayoutParams) bVar).height = f0.a(this.f56177i ? 40.0f : 26.0f);
                ((ViewGroup.MarginLayoutParams) bVar).rightMargin = f0.a(this.f56177i ? 70.0f : 48.0f);
            }
            appCompatTextView.setTextSize(this.f56177i ? 20.0f : 12.0f);
            int iA = f0.a(this.f56177i ? 16.0f : 4.0f);
            appCompatTextView.setPadding(iA, 3, iA, 4);
            appCompatTextView.setBackground(this.f56177i ? z2.a.getDrawable(appCompatTextView.getContext(), R$drawable.ad_shape_dp_8_black) : z2.a.getDrawable(appCompatTextView.getContext(), R$drawable.ad_shape_tag));
        }
    }

    public final void y0() {
        ConstraintLayout constraintLayout;
        tv.j jVar = this.f56171c;
        if (jVar == null || (constraintLayout = jVar.f77800i) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
        if (layoutParams != null) {
            Intrinsics.f(layoutParams, "layoutParams");
            layoutParams.width = f0.a(this.f56177i ? 352.0f : 200.0f);
            layoutParams.height = f0.a(this.f56177i ? 198.0f : 113.0f);
        }
        AppCompatTextView learnMore = (AppCompatTextView) constraintLayout.findViewById(R$id.learn_more);
        if (learnMore != null) {
            Intrinsics.f(learnMore, "learnMore");
            ViewGroup.LayoutParams layoutParams2 = learnMore.getLayoutParams();
            Intrinsics.e(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams2;
            ((ViewGroup.MarginLayoutParams) bVar).height = f0.a(this.f56177i ? 28.0f : 22.0f);
            int iA = f0.a(this.f56177i ? 8.0f : 4.0f);
            ((ViewGroup.MarginLayoutParams) bVar).rightMargin = iA;
            ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = iA;
            learnMore.setTextSize(this.f56177i ? 14.0f : 12.0f);
        }
    }

    public final void z0() {
        AppCompatImageView appCompatImageView;
        tv.j jVar = this.f56171c;
        if (jVar == null || (appCompatImageView = jVar.f77806o) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = appCompatImageView.getLayoutParams();
        Intrinsics.e(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        int iA = f0.a(this.f56177i ? 40.0f : 26.0f);
        layoutParams2.width = iA;
        layoutParams2.height = iA;
        layoutParams2.rightMargin = f0.a(this.f56177i ? 16.0f : 12.0f);
    }
}
