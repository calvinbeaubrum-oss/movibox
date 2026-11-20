package com.transsion.player.longvideo.ui.dialog;

import android.app.Application;
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
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.f0;
import com.google.android.material.card.MaterialCardView;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.constant.ComConstants;
import com.hisavana.common.tracking.TrackingKey;
import com.hisavana.mediation.ad.TAdChoicesView;
import com.hisavana.mediation.ad.TMediaView;
import com.noober.background.view.BLTextView;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baselib.report.m;
import com.transsion.baseui.R$mipmap;
import com.transsion.commercializationapi.IInterceptReportApi;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.MemberSource;
import com.transsion.player.longvideo.R$string;
import com.transsion.player.longvideo.ui.LongVodPlayerView;
import com.transsion.player.longvideo.ui.LongVodUiType;
import com.transsion.player.longvideo.view.LongVodRewardInterceptTimerView;
import com.transsion.player.longvideo.view.LongVodRewardInterceptView;
import com.transsion.player.ui.longvideo.ORLongVodPlayerView;
import com.transsion.postdetail.ui.view.AdCountDownView;
import com.transsion.videofloat.VideoPipManager;
import com.transsion.wrapperad.R$drawable;
import com.transsion.wrapperad.R$id;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.j;
import kotlinx.coroutines.k0;
import org.apache.tools.zip.UnixStat;
import tv.n0;
import w9.y;

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
public final class LongVodPlayerViewAdHelper {

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final a f54527b0 = new a(null);
    public CountDownTimer A;
    public com.transsion.ad.bidding.video.f E;
    public com.transsion.ad.bidding.interstitial.a F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public long N;
    public long O;
    public long P;
    public int Q;
    public Function0<Unit> S;
    public Function1<? super Boolean, Unit> T;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LifecycleCoroutineScope f54528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public lv.a f54530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public VideoDetailPlayBean f54531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f54532d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.transsion.ad.bidding.nativead.c f54533e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.transsion.ad.bidding.interstitial.a f54534f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public mv.i f54536h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f54537i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f54538j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f54539k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Function0<Unit> f54540l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f54542n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f54543o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f54544p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f54545q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f54546r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f54547s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public CountDownTimer f54548t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f54549u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f54550v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f54551w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f54552x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f54553y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f54554z;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f54535g = "";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f54541m = LazyKt__LazyJVMKt.b(new Function0<VideoDetailPlayDao>() { // from class: com.transsion.player.longvideo.ui.dialog.LongVodPlayerViewAdHelper$videoDetailPlayDao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final VideoDetailPlayDao invoke() {
            AppDatabase.v0 v0Var = AppDatabase.f51036p;
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            return v0Var.b(applicationA).O0();
        }
    });
    public final Lazy B = LazyKt__LazyJVMKt.b(new Function0<Integer>() { // from class: com.transsion.player.longvideo.ui.dialog.LongVodPlayerViewAdHelper$interpolateInterval$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Integer invoke() {
            return Integer.valueOf(this.this$0.d1());
        }
    });
    public final Lazy C = LazyKt__LazyJVMKt.b(new Function0<Integer>() { // from class: com.transsion.player.longvideo.ui.dialog.LongVodPlayerViewAdHelper$interpolateEnterCountdown$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Integer invoke() {
            return Integer.valueOf(this.this$0.b1());
        }
    });
    public final Lazy D = LazyKt__LazyJVMKt.b(new Function0<Integer>() { // from class: com.transsion.player.longvideo.ui.dialog.LongVodPlayerViewAdHelper$interpolateFrequency$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Integer invoke() {
            return Integer.valueOf(this.this$0.c1());
        }
    });
    public String R = "";
    public final Lazy U = LazyKt__LazyJVMKt.b(new Function0<Integer>() { // from class: com.transsion.player.longvideo.ui.dialog.LongVodPlayerViewAdHelper$rewardUnlockFreeTimes$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Integer invoke() {
            return Integer.valueOf(this.this$0.a1());
        }
    });
    public final Lazy V = LazyKt__LazyJVMKt.b(new Function0<Integer>() { // from class: com.transsion.player.longvideo.ui.dialog.LongVodPlayerViewAdHelper$playedPercent$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Integer invoke() {
            return Integer.valueOf(this.this$0.j1());
        }
    });
    public final Lazy W = LazyKt__LazyJVMKt.b(new Function0<Integer>() { // from class: com.transsion.player.longvideo.ui.dialog.LongVodPlayerViewAdHelper$rewardInterceptDuration$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Integer invoke() {
            return Integer.valueOf(this.this$0.l1());
        }
    });
    public final Lazy X = LazyKt__LazyJVMKt.b(new Function0<Integer>() { // from class: com.transsion.player.longvideo.ui.dialog.LongVodPlayerViewAdHelper$rewardInterceptProgress$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Integer invoke() {
            return Integer.valueOf(this.this$0.n1());
        }
    });
    public final Lazy Y = LazyKt__LazyJVMKt.b(new Function0<Boolean>() { // from class: com.transsion.player.longvideo.ui.dialog.LongVodPlayerViewAdHelper$isRewardedSceneOff$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.valueOf(wq.c.f79583a.d("StreamVideoInterceptRewarded").length() > 0);
        }
    });
    public final Lazy Z = LazyKt__LazyJVMKt.b(new Function0<Boolean>() { // from class: com.transsion.player.longvideo.ui.dialog.LongVodPlayerViewAdHelper$isRewardedInterstitialSceneOff$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.valueOf(wq.c.f79583a.d("StreamVideoInterceptInterstitial").length() > 0);
        }
    });

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final d f54529a0 = new d();

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
        public final /* synthetic */ Ref.IntRef f54556b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f54557c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Ref.IntRef intRef, String str, long j11) {
            super(j11, 1000L);
            this.f54556b = intRef;
            this.f54557c = str;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (Intrinsics.b("VideoStartBidScene", this.f54557c)) {
                LongVodPlayerViewAdHelper.this.K2();
            }
            LongVodPlayerViewAdHelper.this.f54549u = 0;
            LongVodPlayerViewAdHelper.this.O0();
            LongVodPlayerViewAdHelper.this.Q0();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j11) {
            AdCountDownView adCountDownView;
            LongVodPlayerViewAdHelper longVodPlayerViewAdHelper = LongVodPlayerViewAdHelper.this;
            Ref.IntRef intRef = this.f54556b;
            int i11 = intRef.element;
            intRef.element = i11 - 1;
            longVodPlayerViewAdHelper.f54549u = i11;
            mv.i iVar = LongVodPlayerViewAdHelper.this.f54536h;
            if (iVar == null || (adCountDownView = iVar.f71232d) == null) {
                return;
            }
            adCountDownView.refreshCountDown(LongVodPlayerViewAdHelper.this.f54549u);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements su.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f54559b;

        public c(boolean z11) {
            this.f54559b = z11;
        }

        @Override // su.b
        public void a() {
            com.transsion.ad.a.j(com.transsion.ad.a.f50276a, LongVodPlayerViewAdHelper.this.X0() + " --> startMemberPage() --> onFailed()", false, 2, null);
        }

        @Override // su.b
        public void onSuccess() {
            LongVodPlayerViewAdHelper.this.O0();
            LongVodPlayerViewAdHelper.this.q2();
            if (this.f54559b) {
                LongVodPlayerViewAdHelper.this.I0();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d extends jq.a {
        public d() {
        }

        @Override // jq.a
        public void g(TAdErrorCode tAdErrorCode) {
            uo.b.a.g(uo.b.f78622a, LongVodPlayerViewAdHelper.this.X0() + " --> rewardInterceptListener --> onError() --> 广告加载失败", false, 2, null);
            LongVodPlayerViewAdHelper.this.N1();
        }

        @Override // jq.a
        public void h(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            uo.b.a.g(uo.b.f78622a, LongVodPlayerViewAdHelper.this.X0() + " --> rewardInterceptListener --> onLoad() --> 广告加载", false, 2, null);
            LongVodPlayerViewAdHelper.this.O1();
        }

        @Override // jq.a
        public void j(int i11) {
            uo.b.a.g(uo.b.f78622a, LongVodPlayerViewAdHelper.this.X0() + " --> rewardInterceptListener --> onClosed() --> 广告关闭", false, 2, null);
            LongVodPlayerViewAdHelper.this.M1();
        }

        @Override // jq.a
        public void k(int i11) {
            uo.b.a.g(uo.b.f78622a, LongVodPlayerViewAdHelper.this.X0() + " --> rewardInterceptListener --> onShow() --> Hi广告展示", false, 2, null);
            LongVodPlayerViewAdHelper.this.Q1();
        }

        @Override // jq.a
        public void l(int i11) {
            uo.b.a.g(uo.b.f78622a, LongVodPlayerViewAdHelper.this.X0() + " --> rewardInterceptListener --> onRewarded() --> 广告奖励", false, 2, null);
            LongVodPlayerViewAdHelper.this.P1();
        }

        @Override // jq.a
        public void m(int i11) {
            uo.b.a.g(uo.b.f78622a, LongVodPlayerViewAdHelper.this.X0() + " --> rewardInterceptListener --> onError() --> 广告展示失败", false, 2, null);
            LongVodPlayerViewAdHelper.this.R1();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class e extends CountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LongVodPlayerViewAdHelper f54561a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.LongRef f54562b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(long j11, LongVodPlayerViewAdHelper longVodPlayerViewAdHelper, Ref.LongRef longRef) {
            super(j11, 1000L);
            this.f54561a = longVodPlayerViewAdHelper;
            this.f54562b = longRef;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            this.f54561a.R0();
            this.f54561a.f54553y++;
            this.f54561a.x2("VideoInterpolateBidScene");
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j11) {
            mv.i iVar = this.f54561a.f54536h;
            AppCompatTextView appCompatTextView = iVar != null ? iVar.f71234g : null;
            if (appCompatTextView == null) {
                return;
            }
            LongVodPlayerViewAdHelper longVodPlayerViewAdHelper = this.f54561a;
            Ref.LongRef longRef = this.f54562b;
            long j12 = longRef.element;
            longRef.element = (-1) + j12;
            appCompatTextView.setText(longVodPlayerViewAdHelper.Y0(j12));
        }
    }

    public static final void A2(LongVodPlayerViewAdHelper this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.t2();
        this$0.c2("click", true);
    }

    public static final void B2(LongVodPlayerViewAdHelper this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.J0(true);
        this$0.c2("click", false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void E2(LongVodPlayerViewAdHelper longVodPlayerViewAdHelper, String str, Function0 function0, Function0 function1, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function0 = null;
        }
        if ((i11 & 4) != 0) {
            function1 = null;
        }
        longVodPlayerViewAdHelper.D2(str, function0, function1);
    }

    public static final void H2(LongVodPlayerViewAdHelper this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.N0();
    }

    public static final void M0(LongVodPlayerViewAdHelper this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.J0(true);
        this$0.b2("click");
    }

    public static final void k2(TMediaView tMediaView) {
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

    public static final void v1(LongVodPlayerViewAdHelper this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.J0(false);
    }

    public final boolean A1() {
        return ((Boolean) this.Z.getValue()).booleanValue();
    }

    public final boolean B1() {
        return ((Boolean) this.Y.getValue()).booleanValue();
    }

    public final void C1() {
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        if (this.f54532d) {
            mv.i iVar = this.f54536h;
            if (iVar == null || (appCompatImageView2 = iVar.f71248u) == null) {
                return;
            }
            appCompatImageView2.setImageResource(R$mipmap.ad_rotate);
            return;
        }
        mv.i iVar2 = this.f54536h;
        if (iVar2 == null || (appCompatImageView = iVar2.f71248u) == null) {
            return;
        }
        appCompatImageView.setImageResource(R$mipmap.ad_fullscreen);
    }

    public final void C2() {
        View root;
        Context context;
        mv.i iVar = this.f54536h;
        if (iVar == null || (root = iVar.getRoot()) == null || (context = root.getContext()) == null) {
            return;
        }
        this.R = "StreamVideoInterceptRewarded";
        LifecycleCoroutineScope lifecycleCoroutineScope = this.f54528a;
        if (lifecycleCoroutineScope != null) {
            j.d(lifecycleCoroutineScope, null, null, new LongVodPlayerViewAdHelper$showRewardedAd$1$1(this, context, null), 3, null);
        }
    }

    public final boolean D1() {
        return this.f54553y < g1();
    }

    public final void D2(String str, Function0<Unit> function0, Function0<Unit> function1) {
        com.transsion.ad.a.j(com.transsion.ad.a.f50276a, X0() + " --> showSceneAd() --> sceneId = " + str, false, 2, null);
        LifecycleCoroutineScope lifecycleCoroutineScope = this.f54528a;
        if (lifecycleCoroutineScope != null) {
            j.d(lifecycleCoroutineScope, null, null, new LongVodPlayerViewAdHelper$showSceneAd$1(str, this, function0, function1, null), 3, null);
        }
    }

    public final void E1(final Function0<Unit> function0, final Function0<Unit> function1) {
        D2("VideoInterpolateBidScene", new Function0<Unit>() { // from class: com.transsion.player.longvideo.ui.dialog.LongVodPlayerViewAdHelper$loadInterpolateAd$1
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
        }, new Function0<Unit>() { // from class: com.transsion.player.longvideo.ui.dialog.LongVodPlayerViewAdHelper$loadInterpolateAd$2
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
                this.this$0.F0(false);
                function1.invoke();
            }
        });
    }

    public final void F0(boolean z11) {
        Function1<? super Boolean, Unit> function1 = this.f54539k;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(z11));
        }
        this.f54542n = z11;
        if (z11) {
            p2(false);
        } else {
            p2(this.M);
        }
    }

    public final void F1() {
        mv.i iVar;
        View root;
        Context context;
        if (A1() || (iVar = this.f54536h) == null || (root = iVar.getRoot()) == null || (context = root.getContext()) == null) {
            return;
        }
        this.R = "StreamVideoInterceptInterstitial";
        LifecycleCoroutineScope lifecycleCoroutineScope = this.f54528a;
        if (lifecycleCoroutineScope != null) {
            j.d(lifecycleCoroutineScope, null, null, new LongVodPlayerViewAdHelper$loadInterstitialAd$1$1(this, context, null), 3, null);
        }
    }

    public final void F2(Function0<Unit> callback) {
        Intrinsics.g(callback, "callback");
        this.f54540l = callback;
        com.transsion.ad.a.j(com.transsion.ad.a.f50276a, X0() + " --> showStartAd() --> " + this.f54543o, false, 2, null);
        if (this.f54543o && z1()) {
            D2("VideoStartBidScene", new Function0<Unit>() { // from class: com.transsion.player.longvideo.ui.dialog.LongVodPlayerViewAdHelper$showStartAd$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            }, new Function0<Unit>() { // from class: com.transsion.player.longvideo.ui.dialog.LongVodPlayerViewAdHelper$showStartAd$2
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
                    this.this$0.F0(false);
                    this.this$0.U1();
                }
            });
        } else {
            U1();
        }
    }

    public final void G0(String str) {
        AdCountDownView adCountDownView;
        uo.b.a.f(uo.b.f78622a, LongVodPlayerView.TAG, "adShowCountDown", false, 4, null);
        Ref.IntRef intRef = new Ref.IntRef();
        int iV0 = this.f54549u;
        if (iV0 == 0) {
            iV0 = V0(str);
        }
        intRef.element = iV0;
        mv.i iVar = this.f54536h;
        if (iVar != null && (adCountDownView = iVar.f71232d) != null) {
            adCountDownView.refreshCountDown(iV0);
        }
        Q0();
        b bVar = new b(intRef, str, ((long) intRef.element) * 1000);
        this.f54548t = bVar;
        bVar.start();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object G1(String str, Function0<Unit> function0, Function0<Unit> function1, Continuation<? super Unit> continuation) throws Throwable {
        LongVodPlayerViewAdHelper$loadLandPauseAd$1 longVodPlayerViewAdHelper$loadLandPauseAd$1;
        View root;
        Context context;
        if (continuation instanceof LongVodPlayerViewAdHelper$loadLandPauseAd$1) {
            longVodPlayerViewAdHelper$loadLandPauseAd$1 = (LongVodPlayerViewAdHelper$loadLandPauseAd$1) continuation;
            int i11 = longVodPlayerViewAdHelper$loadLandPauseAd$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                longVodPlayerViewAdHelper$loadLandPauseAd$1.label = i11 - Integer.MIN_VALUE;
            } else {
                longVodPlayerViewAdHelper$loadLandPauseAd$1 = new LongVodPlayerViewAdHelper$loadLandPauseAd$1(this, continuation);
            }
        } else {
            longVodPlayerViewAdHelper$loadLandPauseAd$1 = new LongVodPlayerViewAdHelper$loadLandPauseAd$1(this, continuation);
        }
        Object obj = longVodPlayerViewAdHelper$loadLandPauseAd$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = longVodPlayerViewAdHelper$loadLandPauseAd$1.label;
        if (i12 == 0) {
            ResultKt.b(obj);
            mv.i iVar = this.f54536h;
            if (iVar != null && (root = iVar.getRoot()) != null && (context = root.getContext()) != null) {
                com.transsion.ad.bidding.interstitial.a aVar = this.f54534f;
                if (aVar != null) {
                    aVar.F();
                }
                com.transsion.ad.bidding.interstitial.a aVar2 = new com.transsion.ad.bidding.interstitial.a();
                this.f54534f = aVar2;
                aVar2.m0(str);
                com.transsion.ad.bidding.interstitial.a aVar3 = this.f54534f;
                if (aVar3 != null) {
                    aVar3.k0(com.transsion.ad.strategy.b.f50584a.a(this.f54537i));
                }
                com.transsion.ad.bidding.interstitial.a aVar4 = this.f54534f;
                if (aVar4 != null) {
                    aVar4.j0(context);
                }
                com.transsion.ad.bidding.interstitial.a aVar5 = this.f54534f;
                if (aVar5 != null) {
                    aVar5.l0(M2(str, function0, function1));
                }
                com.transsion.ad.bidding.interstitial.a aVar6 = this.f54534f;
                if (aVar6 != null) {
                    longVodPlayerViewAdHelper$loadLandPauseAd$1.label = 1;
                    if (aVar6.T(longVodPlayerViewAdHelper$loadLandPauseAd$1) == objE) {
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

    public final void G2() {
        ImageView imageView;
        View root;
        Context context;
        NativeWrapperAdView nativeWrapperAdView;
        F0(true);
        this.f54547s = true;
        mv.i iVar = this.f54536h;
        if (iVar != null && (root = iVar.getRoot()) != null && (context = root.getContext()) != null) {
            d00.b bVar = d00.b.f62855a;
            com.transsion.ad.bidding.nativead.c cVar = this.f54533e;
            zq.b bVarA = bVar.a(context, cVar != null ? cVar.Q() : null);
            mv.i iVar2 = this.f54536h;
            if (iVar2 != null && (nativeWrapperAdView = iVar2.f71231c) != null) {
                nativeWrapperAdView.bindNativeView(this.f54533e, bVarA);
            }
        }
        h2(true);
        mv.i iVar3 = this.f54536h;
        FrameLayout frameLayout = iVar3 != null ? iVar3.f71237j : null;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        mv.i iVar4 = this.f54536h;
        if (iVar4 != null && (imageView = iVar4.f71241n) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.ui.dialog.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LongVodPlayerViewAdHelper.H2(this.f54575a, view);
                }
            });
        }
        R0();
    }

    public final void H0(long j11) {
        this.O = j11;
        if (B1()) {
            return;
        }
        o2();
        if (this.L || this.K || this.H || Math.abs(j11 - this.N) < this.P) {
            return;
        }
        this.H = true;
        this.Q++;
        RoomAppMMKV.f51271a.a().putInt("video_played_count_per_day", this.Q);
        uo.b.a.f(uo.b.f78622a, LongVodPlayerView.TAG, "--> calculatePlayedTimes --> videoPlayedTimesPerDay:" + this.Q, false, 4, null);
        L2();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object H1(String str, Function0<Unit> function0, Function0<Unit> function1, Continuation<? super Unit> continuation) throws Throwable {
        LongVodPlayerViewAdHelper$loadNativeAd$1 longVodPlayerViewAdHelper$loadNativeAd$1;
        View root;
        Context context;
        if (continuation instanceof LongVodPlayerViewAdHelper$loadNativeAd$1) {
            longVodPlayerViewAdHelper$loadNativeAd$1 = (LongVodPlayerViewAdHelper$loadNativeAd$1) continuation;
            int i11 = longVodPlayerViewAdHelper$loadNativeAd$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                longVodPlayerViewAdHelper$loadNativeAd$1.label = i11 - Integer.MIN_VALUE;
            } else {
                longVodPlayerViewAdHelper$loadNativeAd$1 = new LongVodPlayerViewAdHelper$loadNativeAd$1(this, continuation);
            }
        } else {
            longVodPlayerViewAdHelper$loadNativeAd$1 = new LongVodPlayerViewAdHelper$loadNativeAd$1(this, continuation);
        }
        Object obj = longVodPlayerViewAdHelper$loadNativeAd$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = longVodPlayerViewAdHelper$loadNativeAd$1.label;
        if (i12 == 0) {
            ResultKt.b(obj);
            mv.i iVar = this.f54536h;
            if (iVar != null && (root = iVar.getRoot()) != null && (context = root.getContext()) != null) {
                com.transsion.ad.bidding.nativead.c cVar = this.f54533e;
                if (cVar != null) {
                    cVar.F();
                }
                com.transsion.ad.bidding.nativead.c cVar2 = new com.transsion.ad.bidding.nativead.c();
                this.f54533e = cVar2;
                cVar2.m0(str);
                com.transsion.ad.bidding.nativead.c cVar3 = this.f54533e;
                if (cVar3 != null) {
                    cVar3.k0(com.transsion.ad.strategy.b.f50584a.a(this.f54537i));
                }
                com.transsion.ad.bidding.nativead.c cVar4 = this.f54533e;
                if (cVar4 != null) {
                    cVar4.j0(context);
                }
                com.transsion.ad.bidding.nativead.c cVar5 = this.f54533e;
                if (cVar5 != null) {
                    cVar5.l0(M2(str, function0, function1));
                }
                com.transsion.ad.bidding.nativead.c cVar6 = this.f54533e;
                if (cVar6 != null) {
                    longVodPlayerViewAdHelper$loadNativeAd$1.label = 1;
                    if (cVar6.T(longVodPlayerViewAdHelper$loadNativeAd$1) == objE) {
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

    public final void I0() {
        Function1<? super Boolean, Unit> function1 = this.T;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(this.J));
        }
        if (this.J) {
            this.f54551w = System.currentTimeMillis();
        }
    }

    public final void I1() {
        mv.i iVar;
        View root;
        Context context;
        if (B1() || (iVar = this.f54536h) == null || (root = iVar.getRoot()) == null || (context = root.getContext()) == null) {
            return;
        }
        this.R = "StreamVideoInterceptRewarded";
        LifecycleCoroutineScope lifecycleCoroutineScope = this.f54528a;
        if (lifecycleCoroutineScope != null) {
            j.d(lifecycleCoroutineScope, null, null, new LongVodPlayerViewAdHelper$loadRewardedAd$1$1(this, context, null), 3, null);
        }
    }

    public final void I2() {
        boolean z11 = System.currentTimeMillis() - this.f54545q > ((long) W0());
        com.transsion.ad.a.j(com.transsion.ad.a.f50276a, X0() + " --> showVideoEndAd(), isShowEndAdEnable -> " + this.f54544p + ", isReachInterval -> " + z11, false, 2, null);
        if (this.f54544p && z11 && z1()) {
            D2("VideoEndBidScene", new Function0<Unit>() { // from class: com.transsion.player.longvideo.ui.dialog.LongVodPlayerViewAdHelper$showVideoEndAd$1

                /* JADX INFO: renamed from: com.transsion.player.longvideo.ui.dialog.LongVodPlayerViewAdHelper$showVideoEndAd$1$1, reason: invalid class name */
                /* JADX INFO: compiled from: source.java */
                @Metadata
                @DebugMetadata(c = "com.transsion.player.longvideo.ui.dialog.LongVodPlayerViewAdHelper$showVideoEndAd$1$1", f = "LongVodPlayerViewAdHelper.kt", l = {491, UnixStat.DEFAULT_DIR_PERM}, m = "invokeSuspend")
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
                    Object L$0;
                    Object L$1;
                    int label;
                    final /* synthetic */ LongVodPlayerViewAdHelper this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(LongVodPlayerViewAdHelper longVodPlayerViewAdHelper, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.this$0 = longVodPlayerViewAdHelper;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.this$0, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        LongVodPlayerViewAdHelper longVodPlayerViewAdHelper;
                        VideoDetailPlayBean videoDetailPlayBean;
                        Object objE = kotlin.coroutines.intrinsics.a.e();
                        int i11 = this.label;
                        if (i11 != 0) {
                            if (i11 == 1) {
                                ResultKt.b(obj);
                            } else {
                                if (i11 != 2) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                videoDetailPlayBean = (VideoDetailPlayBean) this.L$1;
                                longVodPlayerViewAdHelper = (LongVodPlayerViewAdHelper) this.L$0;
                                ResultKt.b(obj);
                            }
                            longVodPlayerViewAdHelper.f54544p = false;
                            com.transsion.ad.a.j(com.transsion.ad.a.f50276a, longVodPlayerViewAdHelper.X0() + " --> isShowEndAd() --> 保存结束广告时间戳 --> videoDetailPlayBean = " + videoDetailPlayBean, false, 2, null);
                            return Unit.f68710a;
                        }
                        ResultKt.b(obj);
                        LongVodPlayerViewAdHelper longVodPlayerViewAdHelper2 = this.this$0;
                        this.label = 1;
                        obj = longVodPlayerViewAdHelper2.q1(this);
                        if (obj == objE) {
                            return objE;
                        }
                        VideoDetailPlayBean videoDetailPlayBean2 = (VideoDetailPlayBean) obj;
                        if (videoDetailPlayBean2 != null) {
                            longVodPlayerViewAdHelper = this.this$0;
                            videoDetailPlayBean2.setLastAdEndTimeStamp(Boxing.e(System.currentTimeMillis()));
                            VideoDetailPlayDao videoDetailPlayDaoR1 = longVodPlayerViewAdHelper.r1();
                            this.L$0 = longVodPlayerViewAdHelper;
                            this.L$1 = videoDetailPlayBean2;
                            this.label = 2;
                            if (videoDetailPlayDaoR1.q(videoDetailPlayBean2, this) == objE) {
                                return objE;
                            }
                            videoDetailPlayBean = videoDetailPlayBean2;
                            longVodPlayerViewAdHelper.f54544p = false;
                            com.transsion.ad.a.j(com.transsion.ad.a.f50276a, longVodPlayerViewAdHelper.X0() + " --> isShowEndAd() --> 保存结束广告时间戳 --> videoDetailPlayBean = " + videoDetailPlayBean, false, 2, null);
                        }
                        return Unit.f68710a;
                    }
                }

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
                    LifecycleCoroutineScope lifecycleCoroutineScope = this.this$0.f54528a;
                    if (lifecycleCoroutineScope != null) {
                        j.d(lifecycleCoroutineScope, null, null, new AnonymousClass1(this.this$0, null), 3, null);
                    }
                }
            }, new Function0<Unit>() { // from class: com.transsion.player.longvideo.ui.dialog.LongVodPlayerViewAdHelper$showVideoEndAd$2
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
                    this.this$0.F0(false);
                    this.this$0.U1();
                }
            });
        } else {
            U1();
        }
    }

    public final void J0(boolean z11) {
        if (!z11) {
            ((IInterceptReportApi) com.alibaba.android.arouter.launcher.a.d().h(IInterceptReportApi.class)).w1();
        }
        Object objH = com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class);
        Intrinsics.f(objH, "getInstance().navigation(IMemberApi::class.java)");
        IMemberApi.a.c((IMemberApi) objH, com.blankj.utilcode.util.a.b(), MemberSource.SOURCE_LANDSCAPE_PLAY, new c(z11), false, 8, null);
    }

    public final void J1(String str) {
        this.f54535g = str;
        LifecycleCoroutineScope lifecycleCoroutineScope = this.f54528a;
        if (lifecycleCoroutineScope != null) {
            j.d(lifecycleCoroutineScope, null, null, new LongVodPlayerViewAdHelper$onAdLoad$1(str, this, null), 3, null);
        }
    }

    public final void J2() {
        AppCompatTextView appCompatTextView;
        if (this.L) {
            return;
        }
        R0();
        long jF1 = f1();
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = jF1 / ((long) 1000);
        mv.i iVar = this.f54536h;
        if (iVar != null && (appCompatTextView = iVar.f71234g) != null) {
            so.c.k(appCompatTextView);
        }
        mv.i iVar2 = this.f54536h;
        AppCompatTextView appCompatTextView2 = iVar2 != null ? iVar2.f71234g : null;
        if (appCompatTextView2 != null) {
            appCompatTextView2.setText(Y0(longRef.element));
        }
        e eVar = new e(jF1, this, longRef);
        this.A = eVar;
        eVar.start();
    }

    public final void K0(long j11, Function0<Unit> callback) {
        Intrinsics.g(callback, "callback");
        if (this.f54552x == 0) {
            this.f54552x = j11;
            return;
        }
        if (this.L || this.f54542n || !D1()) {
            return;
        }
        if (Math.abs(j11 - this.f54552x) > 5000) {
            this.f54552x = j11;
            this.f54550v += System.currentTimeMillis() - this.f54551w;
            this.f54551w = System.currentTimeMillis();
        }
        if (this.f54550v >= e1()) {
            this.f54540l = callback;
            u2();
        }
    }

    public final void K1(Function0<Unit> callback) {
        Intrinsics.g(callback, "callback");
        this.f54550v = 0L;
        this.f54551w = 0L;
        this.f54540l = callback;
        R0();
        I2();
    }

    public final void K2() {
        LifecycleCoroutineScope lifecycleCoroutineScope = this.f54528a;
        if (lifecycleCoroutineScope != null) {
            j.d(lifecycleCoroutineScope, null, null, new LongVodPlayerViewAdHelper$updateAdStartLastShowTime$1(this, null), 3, null);
        }
    }

    public final void L0(long j11, Function0<Unit> callback, Function0<Unit> interceptCallback, Function1<? super Boolean, Unit> unlockCallback) {
        mv.h hVar;
        LongVodRewardInterceptTimerView longVodRewardInterceptTimerView;
        mv.f bind;
        TextView textView;
        Intrinsics.g(callback, "callback");
        Intrinsics.g(interceptCallback, "interceptCallback");
        Intrinsics.g(unlockCallback, "unlockCallback");
        if (B1()) {
            callback.invoke();
            return;
        }
        this.S = interceptCallback;
        this.T = unlockCallback;
        this.P = (long) ((((long) i1()) * j11) / 100.0f);
        boolean z11 = j11 >= ((long) k1());
        this.K = this.K && z11;
        uo.b.a.f(uo.b.f78622a, LongVodPlayerView.TAG, "---> checkShowRewardIntercept --> totalDuration:" + j11 + ", playedThreshold:" + this.P + ", isTotalDurationFit:" + z11 + ", rewardInterceptProgress:" + m1() + ", isRewardInterceptEnable:" + this.K, false, 4, null);
        if (this.G || j11 < k1()) {
            this.f54551w = System.currentTimeMillis();
            this.M = true;
            callback.invoke();
            return;
        }
        if (this.N >= m1() && this.K) {
            this.J = true;
            z2();
            return;
        }
        this.J = false;
        o2();
        b2("browse");
        mv.i iVar = this.f54536h;
        if (iVar != null && (hVar = iVar.f71244q) != null && (longVodRewardInterceptTimerView = hVar.f71223c) != null && (bind = longVodRewardInterceptTimerView.getBind()) != null && (textView = bind.f71212f) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.ui.dialog.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LongVodPlayerViewAdHelper.M0(this.f54573a, view);
                }
            });
        }
        this.M = true;
        callback.invoke();
    }

    public final void L1() {
        this.f54540l = null;
        O0();
        this.f54549u = 0;
    }

    public final void L2() {
        LifecycleCoroutineScope lifecycleCoroutineScope = this.f54528a;
        if (lifecycleCoroutineScope != null) {
            j.d(lifecycleCoroutineScope, null, null, new LongVodPlayerViewAdHelper$updateRewardState$1(this, null), 3, null);
        }
    }

    public final void M1() {
        F0(false);
        LifecycleCoroutineScope lifecycleCoroutineScope = this.f54528a;
        if (lifecycleCoroutineScope != null) {
            j.d(lifecycleCoroutineScope, null, null, new LongVodPlayerViewAdHelper$onRewardInterceptAdClose$1(this, null), 3, null);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.transsion.player.longvideo.ui.dialog.LongVodPlayerViewAdHelper$wrapperAdListener$1] */
    public final LongVodPlayerViewAdHelper$wrapperAdListener$1 M2(final String str, final Function0<Unit> function0, final Function0<Unit> function1) {
        return new jq.a() { // from class: com.transsion.player.longvideo.ui.dialog.LongVodPlayerViewAdHelper$wrapperAdListener$1
            @Override // jq.a
            public void g(TAdErrorCode tAdErrorCode) {
                com.transsion.ad.a.j(com.transsion.ad.a.f50276a, this.f54563a.X0() + " --> loadAd() --> onError() --> p0 = " + tAdErrorCode, false, 2, null);
                LifecycleCoroutineScope lifecycleCoroutineScope = this.f54563a.f54528a;
                if (lifecycleCoroutineScope != null) {
                    j.d(lifecycleCoroutineScope, null, null, new LongVodPlayerViewAdHelper$wrapperAdListener$1$onBiddingError$1(function1, null), 3, null);
                }
            }

            @Override // jq.a
            public void h(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
                LifecycleCoroutineScope lifecycleCoroutineScope = this.f54563a.f54528a;
                if (lifecycleCoroutineScope != null) {
                    j.d(lifecycleCoroutineScope, null, null, new LongVodPlayerViewAdHelper$wrapperAdListener$1$onBiddingLoad$1(function0, this.f54563a, str, null), 3, null);
                }
            }

            @Override // jq.a
            public void j(int i11) {
                LifecycleCoroutineScope lifecycleCoroutineScope = this.f54563a.f54528a;
                if (lifecycleCoroutineScope != null) {
                    j.d(lifecycleCoroutineScope, null, null, new LongVodPlayerViewAdHelper$wrapperAdListener$1$onBiddingWrapperAdClose$1(this.f54563a, null), 3, null);
                }
            }
        };
    }

    public final void N0() {
        if (TextUtils.equals(this.f54535g, "LandscapePauseSceneNew") || TextUtils.equals(this.f54535g, "VerticalPauseScene")) {
            O0();
        }
    }

    public final void N1() {
        LifecycleCoroutineScope lifecycleCoroutineScope = this.f54528a;
        if (lifecycleCoroutineScope != null) {
            j.d(lifecycleCoroutineScope, null, null, new LongVodPlayerViewAdHelper$onRewardInterceptAdError$1(this, null), 3, null);
        }
    }

    public final void O0() {
        com.transsion.ad.a.j(com.transsion.ad.a.f50276a, X0() + " --> closeSceneAd()", false, 2, null);
        LifecycleCoroutineScope lifecycleCoroutineScope = this.f54528a;
        if (lifecycleCoroutineScope != null) {
            j.d(lifecycleCoroutineScope, null, null, new LongVodPlayerViewAdHelper$closeSceneAd$1(this, null), 3, null);
        }
    }

    public final void O1() {
        LifecycleCoroutineScope lifecycleCoroutineScope = this.f54528a;
        if (lifecycleCoroutineScope != null) {
            j.d(lifecycleCoroutineScope, null, null, new LongVodPlayerViewAdHelper$onRewardInterceptAdLoad$1(this, null), 3, null);
        }
    }

    public final void P0() {
        com.transsion.ad.bidding.nativead.c cVar = this.f54533e;
        if (cVar != null) {
            cVar.F();
        }
        this.f54536h = null;
        com.transsion.ad.bidding.interstitial.a aVar = this.f54534f;
        if (aVar != null) {
            aVar.F();
        }
        this.f54534f = null;
        com.transsion.ad.bidding.video.f fVar = this.E;
        if (fVar != null) {
            fVar.F();
        }
        this.E = null;
        com.transsion.ad.bidding.interstitial.a aVar2 = this.F;
        if (aVar2 != null) {
            aVar2.F();
        }
        this.F = null;
        Q0();
        CountDownTimer countDownTimer = this.A;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.A = null;
    }

    public final void P1() {
        LifecycleCoroutineScope lifecycleCoroutineScope = this.f54528a;
        if (lifecycleCoroutineScope != null) {
            j.d(lifecycleCoroutineScope, null, null, new LongVodPlayerViewAdHelper$onRewardInterceptAdRewarded$1(this, null), 3, null);
        }
    }

    public final void Q0() {
        CountDownTimer countDownTimer = this.f54548t;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.f54548t = null;
    }

    public final void Q1() {
        LifecycleCoroutineScope lifecycleCoroutineScope = this.f54528a;
        if (lifecycleCoroutineScope != null) {
            j.d(lifecycleCoroutineScope, null, null, new LongVodPlayerViewAdHelper$onRewardInterceptAdShow$1(this, null), 3, null);
        }
    }

    public final void R0() {
        AppCompatTextView appCompatTextView;
        CountDownTimer countDownTimer = this.A;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.A = null;
        mv.i iVar = this.f54536h;
        if (iVar == null || (appCompatTextView = iVar.f71234g) == null) {
            return;
        }
        so.c.g(appCompatTextView);
    }

    public final void R1() {
        LifecycleCoroutineScope lifecycleCoroutineScope = this.f54528a;
        if (lifecycleCoroutineScope != null) {
            j.d(lifecycleCoroutineScope, null, null, new LongVodPlayerViewAdHelper$onRewardInterceptAdShowError$1(this, null), 3, null);
        }
    }

    public final void S0() {
        com.transsion.ad.bidding.interstitial.a aVar = this.F;
        if (aVar != null) {
            aVar.F();
        }
        this.F = null;
    }

    public final void S1() {
        q2();
        L2();
        F0(false);
        I0();
    }

    public final void T0() {
        com.transsion.ad.bidding.video.f fVar = this.E;
        if (fVar != null) {
            fVar.F();
        }
        this.E = null;
    }

    public final void T1(LongVodUiType curUiType) {
        ORLongVodPlayerView oRLongVodPlayerView;
        mv.i iVar;
        ORLongVodPlayerView oRLongVodPlayerView2;
        Intrinsics.g(curUiType, "curUiType");
        this.f54532d = curUiType == LongVodUiType.LAND;
        com.transsion.ad.a.j(com.transsion.ad.a.f50276a, X0() + " --> onScreenUIChange() --> isLandUIType = " + this.f54532d, false, 2, null);
        N0();
        mv.i iVar2 = this.f54536h;
        if (iVar2 != null && (oRLongVodPlayerView = iVar2.f71246s) != null && !oRLongVodPlayerView.isPlaying() && (iVar = this.f54536h) != null && (oRLongVodPlayerView2 = iVar.f71246s) != null && !oRLongVodPlayerView2.isComplete() && this.f54547s) {
            y2();
        }
        if (this.f54546r) {
            C1();
            h2(false);
        }
    }

    public final String U0(long j11) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long minutes = timeUnit.toMinutes(j11);
        long seconds = timeUnit.toSeconds(j11) % ((long) 60);
        StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
        String str = String.format(Locale.getDefault(), "%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(minutes), Long.valueOf(seconds)}, 2));
        Intrinsics.f(str, "format(...)");
        return str;
    }

    public final void U1() {
        Function0<Unit> function0 = this.f54540l;
        if (function0 != null) {
            function0.invoke();
        }
        this.f54540l = null;
    }

    public final int V0(String str) {
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

    public final void V1() {
        this.f54551w = System.currentTimeMillis();
        o2();
        this.f54547s = false;
        N0();
    }

    public final int W0() {
        JsonElement jsonElement;
        JsonObject jsonObjectB = wq.d.f79584a.b("VideoEndBidScene");
        return ((jsonObjectB == null || (jsonElement = jsonObjectB.get("threshold")) == null) ? 5 : jsonElement.getAsInt()) * 60000;
    }

    public final void W1() {
        Q0();
        R0();
        p2(false);
    }

    public final String X0() {
        String simpleName = LongVodPlayerViewAdHelper.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final void X1() {
        ORLongVodPlayerView oRLongVodPlayerView;
        ORLongVodPlayerView oRLongVodPlayerView2;
        if (this.f54546r) {
            G0(this.f54535g);
        }
        uo.b.a aVar = uo.b.f78622a;
        mv.i iVar = this.f54536h;
        uo.b.a.f(aVar, LongVodPlayerView.TAG, "onViewResume --> isPlaying:" + ((iVar == null || (oRLongVodPlayerView2 = iVar.f71246s) == null) ? null : Boolean.valueOf(oRLongVodPlayerView2.isPlaying())), false, 4, null);
        mv.i iVar2 = this.f54536h;
        p2(!((iVar2 == null || (oRLongVodPlayerView = iVar2.f71246s) == null) ? false : oRLongVodPlayerView.isPlaying()));
    }

    public final String Y0(long j11) {
        return j11 + "s  |  Enter the AD";
    }

    public final void Y1() {
        if (A1()) {
            return;
        }
        this.R = "StreamVideoInterceptInterstitial";
        com.transsion.ad.bidding.interstitial.a.f50342m.a("StreamVideoInterceptInterstitial");
    }

    public final int Z0() {
        JsonElement jsonElement;
        JsonObject jsonObjectB = wq.d.f79584a.b("VideoEndBidScene");
        return ((jsonObjectB == null || (jsonElement = jsonObjectB.get("interval")) == null) ? 1440 : jsonElement.getAsInt()) * 60000;
    }

    public final void Z1() {
        if (B1()) {
            return;
        }
        this.R = "StreamVideoInterceptRewarded";
        com.transsion.ad.bidding.video.f.f50385m.a("StreamVideoInterceptRewarded");
    }

    public final int a1() {
        JsonElement jsonElement;
        JsonObject jsonObjectB = wq.d.f79584a.b("StreamVideoInterceptRewarded");
        if (jsonObjectB == null || (jsonElement = jsonObjectB.get("freeTimes")) == null) {
            return 1;
        }
        return jsonElement.getAsInt();
    }

    public final void a2(String str, Map<String, String> map) {
        if (Intrinsics.b(str, "browse")) {
            m mVar = m.f51277a;
            String str2 = this.f54538j;
            mVar.t(str2 != null ? str2 : "LongVodPlayer", str, map);
        } else if (Intrinsics.b(str, "click")) {
            m mVar2 = m.f51277a;
            String str3 = this.f54538j;
            mVar2.m(str3 != null ? str3 : "LongVodPlayer", str, map);
        }
    }

    public final int b1() {
        JsonElement jsonElement;
        JsonObject jsonObjectB = wq.d.f79584a.b("VideoInterpolateBidScene");
        return ((jsonObjectB == null || (jsonElement = jsonObjectB.get("enterCountdown")) == null) ? 10 : jsonElement.getAsInt()) * 1000;
    }

    public final void b2(String str) {
        if (this.K) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(TrackingKey.SCENE_ID, "StreamVideoInterceptRewarded");
            linkedHashMap.put("module_name", "stream_rewarded_countdown_timer");
            if (Intrinsics.b(str, "browse")) {
                linkedHashMap.put("action", "show_view");
            } else if (Intrinsics.b(str, "click")) {
                linkedHashMap.put("action", "click_member");
            }
            a2(str, linkedHashMap);
        }
    }

    public final int c1() {
        JsonElement jsonElement;
        JsonObject jsonObjectB = wq.d.f79584a.b("VideoInterpolateBidScene");
        if (jsonObjectB == null || (jsonElement = jsonObjectB.get("frequency")) == null) {
            return 2;
        }
        return jsonElement.getAsInt();
    }

    public final void c2(String str, boolean z11) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(TrackingKey.SCENE_ID, "StreamVideoInterceptRewarded");
        linkedHashMap.put("module_name", "stream_rewarded_intercept_view");
        if (Intrinsics.b(str, "browse")) {
            linkedHashMap.put("action", "show_view");
        } else if (Intrinsics.b(str, "click")) {
            linkedHashMap.put("action", z11 ? "click_ad" : "click_member");
        }
        a2(str, linkedHashMap);
    }

    public final int d1() {
        JsonElement jsonElement;
        JsonObject jsonObjectB = wq.d.f79584a.b("VideoInterpolateBidScene");
        return ((jsonObjectB == null || (jsonElement = jsonObjectB.get("interval")) == null) ? 15 : jsonElement.getAsInt()) * 60000;
    }

    public final void d2() {
        this.f54550v = 0L;
        this.f54551w = System.currentTimeMillis();
    }

    public final int e1() {
        return h1() - f1();
    }

    public final void e2() {
        this.f54552x = 0L;
        this.f54545q = 0L;
        this.f54550v = 0L;
        this.f54553y = 0;
    }

    public final int f1() {
        return ((Number) this.C.getValue()).intValue();
    }

    public final void f2() {
        Unit unit;
        NativeWrapperAdView nativeWrapperAdView;
        mv.i iVar = this.f54536h;
        TAdChoicesView tAdChoicesView = (iVar == null || (nativeWrapperAdView = iVar.f71235h) == null) ? null : (TAdChoicesView) nativeWrapperAdView.findViewById(R$id.adChoicesView);
        if (tAdChoicesView != null) {
            ViewGroup.LayoutParams layoutParams = tAdChoicesView.getLayoutParams();
            Intrinsics.e(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            ((FrameLayout.LayoutParams) layoutParams).leftMargin = f0.a(this.f54532d ? 14.0f : 10.0f);
            View adChoice = tAdChoicesView.getChildAt(0);
            if (adChoice != null) {
                Intrinsics.f(adChoice, "adChoice");
                ViewGroup.LayoutParams layoutParams2 = adChoice.getLayoutParams();
                int iA = f0.a(this.f54532d ? 24.0f : 16.0f);
                layoutParams2.width = iA;
                layoutParams2.height = iA;
                ((ImageView) adChoice).setScaleType(ImageView.ScaleType.FIT_CENTER);
                g2(adChoice);
                unit = Unit.f68710a;
            } else {
                unit = null;
            }
            if (unit == null) {
                g2(null);
            }
        }
    }

    public final int g1() {
        return ((Number) this.D.getValue()).intValue();
    }

    public final void g2(View view) {
        AdCountDownView adCountDownView;
        float f11;
        mv.i iVar = this.f54536h;
        if (iVar == null || (adCountDownView = iVar.f71232d) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = adCountDownView.getLayoutParams();
        Intrinsics.e(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.topMargin = f0.a(16.0f);
        if (view != null) {
            f11 = this.f54532d ? 58.0f : 35.0f;
        } else {
            f11 = this.f54532d ? 30.0f : 12.0f;
        }
        layoutParams2.leftMargin = f0.a(f11);
        float f12 = this.f54532d ? 16.0f : 10.0f;
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

    public final int h1() {
        return ((Number) this.B.getValue()).intValue();
    }

    public final void h2(boolean z11) {
        if (z11) {
            n2();
            mv.i iVar = this.f54536h;
            s2(iVar != null ? iVar.f71231c : null, true);
            return;
        }
        j2();
        i2();
        l2();
        r2();
        mv.i iVar2 = this.f54536h;
        s2(iVar2 != null ? iVar2.f71235h : null, false);
        f2();
    }

    public final int i1() {
        return ((Number) this.V.getValue()).intValue();
    }

    public final void i2() {
        AppCompatTextView appCompatTextView;
        mv.i iVar = this.f54536h;
        if (iVar == null || (appCompatTextView = iVar.f71234g) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = appCompatTextView.getLayoutParams();
        Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.b) layoutParams)).height = f0.a(this.f54532d ? 32.0f : 24.0f);
        appCompatTextView.setTextSize(this.f54532d ? 12.0f : 10.0f);
    }

    public final int j1() {
        JsonElement jsonElement;
        JsonObject jsonObjectB = wq.d.f79584a.b("StreamVideoInterceptRewarded");
        if (jsonObjectB == null || (jsonElement = jsonObjectB.get("playedPercent")) == null) {
            return 10;
        }
        return jsonElement.getAsInt();
    }

    public final void j2() {
        NativeWrapperAdView nativeWrapperAdView;
        com.transsion.ad.bidding.nativead.c cVar = this.f54533e;
        if (cVar == null || cVar.q0()) {
            mv.i iVar = this.f54536h;
            final TMediaView tMediaView = (iVar == null || (nativeWrapperAdView = iVar.f71235h) == null) ? null : (TMediaView) nativeWrapperAdView.findViewById(R$id.native_ad_media);
            if (tMediaView != null) {
                tMediaView.post(new Runnable() { // from class: com.transsion.player.longvideo.ui.dialog.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        LongVodPlayerViewAdHelper.k2(tMediaView);
                    }
                });
            }
        }
    }

    public final int k1() {
        return ((Number) this.W.getValue()).intValue();
    }

    public final int l1() {
        JsonElement jsonElement;
        JsonObject jsonObjectB = wq.d.f79584a.b("StreamVideoInterceptRewarded");
        return ((jsonObjectB == null || (jsonElement = jsonObjectB.get("interceptDuration")) == null) ? 10 : jsonElement.getAsInt()) * 60000;
    }

    public final void l2() {
        NativeWrapperAdView nativeWrapperAdView;
        mv.i iVar = this.f54536h;
        AppCompatTextView appCompatTextView = (iVar == null || (nativeWrapperAdView = iVar.f71235h) == null) ? null : (AppCompatTextView) nativeWrapperAdView.findViewById(R$id.learn_more);
        if (appCompatTextView != null) {
            ViewGroup.LayoutParams layoutParams = appCompatTextView.getLayoutParams();
            Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
            ((ViewGroup.MarginLayoutParams) bVar).height = f0.a(this.f54532d ? 40.0f : 26.0f);
            ((ViewGroup.MarginLayoutParams) bVar).rightMargin = f0.a(this.f54532d ? 70.0f : 48.0f);
            appCompatTextView.setTextSize(this.f54532d ? 20.0f : 12.0f);
            int iA = f0.a(this.f54532d ? 16.0f : 6.0f);
            appCompatTextView.setPadding(iA, 3, iA, 4);
            appCompatTextView.setBackground(this.f54532d ? z2.a.getDrawable(appCompatTextView.getContext(), R$drawable.ad_shape_dp_8_black) : z2.a.getDrawable(appCompatTextView.getContext(), R$drawable.ad_shape_tag));
        }
    }

    public final int m1() {
        return ((Number) this.X.getValue()).intValue();
    }

    public final void m2(lv.a bean) {
        Intrinsics.g(bean, "bean");
        LifecycleCoroutineScope lifecycleCoroutineScope = this.f54528a;
        if (lifecycleCoroutineScope != null) {
            j.d(lifecycleCoroutineScope, null, null, new LongVodPlayerViewAdHelper$setLongVdPlayerBean$1(this, bean, null), 3, null);
        }
    }

    public final int n1() {
        JsonElement jsonElement;
        JsonObject jsonObjectB = wq.d.f79584a.b("StreamVideoInterceptRewarded");
        return ((jsonObjectB == null || (jsonElement = jsonObjectB.get("interceptProgress")) == null) ? 5 : jsonElement.getAsInt()) * 60000;
    }

    public final void n2() {
        FrameLayout frameLayout;
        mv.i iVar = this.f54536h;
        if (iVar == null || (frameLayout = iVar.f71237j) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        if (layoutParams != null) {
            Intrinsics.f(layoutParams, "layoutParams");
            layoutParams.width = f0.a(this.f54532d ? 352.0f : 200.0f);
            layoutParams.height = f0.a(this.f54532d ? 198.0f : 113.0f);
        }
        AppCompatTextView learnMore = (AppCompatTextView) frameLayout.findViewById(R$id.learn_more);
        if (learnMore != null) {
            Intrinsics.f(learnMore, "learnMore");
            ViewGroup.LayoutParams layoutParams2 = learnMore.getLayoutParams();
            Intrinsics.e(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams2;
            ((ViewGroup.MarginLayoutParams) bVar).height = f0.a(this.f54532d ? 28.0f : 22.0f);
            int iA = f0.a(this.f54532d ? 8.0f : 4.0f);
            ((ViewGroup.MarginLayoutParams) bVar).rightMargin = iA;
            ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = iA;
            learnMore.setTextSize(this.f54532d ? 14.0f : 12.0f);
        }
    }

    public final int o1() {
        return ((Number) this.U.getValue()).intValue();
    }

    public final void o2() {
        mv.h hVar;
        LongVodRewardInterceptTimerView longVodRewardInterceptTimerView;
        mv.f bind;
        if (!this.K || this.L) {
            p2(false);
            return;
        }
        long jM1 = ((long) m1()) - this.O;
        if (jM1 <= 0) {
            z2();
            return;
        }
        mv.i iVar = this.f54536h;
        TextView textView = (iVar == null || (hVar = iVar.f71244q) == null || (longVodRewardInterceptTimerView = hVar.f71223c) == null || (bind = longVodRewardInterceptTimerView.getBind()) == null) ? null : bind.f71210c;
        if (textView != null) {
            textView.setText(U0(jM1));
        }
        p2(true);
    }

    public final int p1() {
        JsonElement jsonElement;
        JsonObject jsonObjectB = wq.d.f79584a.b("VideoStartBidScene");
        return ((jsonObjectB == null || (jsonElement = jsonObjectB.get("interval")) == null) ? 1440 : jsonElement.getAsInt()) * 60000;
    }

    public final void p2(boolean z11) {
        mv.h hVar;
        LongVodRewardInterceptTimerView longVodRewardInterceptTimerView;
        mv.h hVar2;
        LongVodRewardInterceptTimerView longVodRewardInterceptTimerView2;
        if (z11 && this.K && !this.L) {
            mv.i iVar = this.f54536h;
            if (iVar == null || (hVar2 = iVar.f71244q) == null || (longVodRewardInterceptTimerView2 = hVar2.f71223c) == null) {
                return;
            }
            so.c.k(longVodRewardInterceptTimerView2);
            return;
        }
        mv.i iVar2 = this.f54536h;
        if (iVar2 == null || (hVar = iVar2.f71244q) == null || (longVodRewardInterceptTimerView = hVar.f71223c) == null) {
            return;
        }
        so.c.g(longVodRewardInterceptTimerView);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object q1(Continuation<? super VideoDetailPlayBean> continuation) throws Throwable {
        LongVodPlayerViewAdHelper$getVideoDetailPlayBean$1 longVodPlayerViewAdHelper$getVideoDetailPlayBean$1;
        LongVodPlayerViewAdHelper longVodPlayerViewAdHelper;
        LongVodPlayerViewAdHelper longVodPlayerViewAdHelper2;
        lv.a aVar;
        if (continuation instanceof LongVodPlayerViewAdHelper$getVideoDetailPlayBean$1) {
            longVodPlayerViewAdHelper$getVideoDetailPlayBean$1 = (LongVodPlayerViewAdHelper$getVideoDetailPlayBean$1) continuation;
            int i11 = longVodPlayerViewAdHelper$getVideoDetailPlayBean$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                longVodPlayerViewAdHelper$getVideoDetailPlayBean$1.label = i11 - Integer.MIN_VALUE;
            } else {
                longVodPlayerViewAdHelper$getVideoDetailPlayBean$1 = new LongVodPlayerViewAdHelper$getVideoDetailPlayBean$1(this, continuation);
            }
        } else {
            longVodPlayerViewAdHelper$getVideoDetailPlayBean$1 = new LongVodPlayerViewAdHelper$getVideoDetailPlayBean$1(this, continuation);
        }
        Object objK = longVodPlayerViewAdHelper$getVideoDetailPlayBean$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = longVodPlayerViewAdHelper$getVideoDetailPlayBean$1.label;
        if (i12 == 0) {
            ResultKt.b(objK);
            VideoDetailPlayBean videoDetailPlayBean = this.f54531c;
            if (videoDetailPlayBean != null) {
                return videoDetailPlayBean;
            }
            lv.a aVar2 = this.f54530b;
            if (aVar2 != null) {
                VideoDetailPlayDao videoDetailPlayDaoR1 = r1();
                String strM = aVar2.m();
                int iK = aVar2.k();
                int iD = aVar2.d();
                longVodPlayerViewAdHelper$getVideoDetailPlayBean$1.L$0 = this;
                longVodPlayerViewAdHelper$getVideoDetailPlayBean$1.L$1 = this;
                longVodPlayerViewAdHelper$getVideoDetailPlayBean$1.label = 1;
                objK = videoDetailPlayDaoR1.k(strM, iK, iD, longVodPlayerViewAdHelper$getVideoDetailPlayBean$1);
                if (objK == objE) {
                    return objE;
                }
                longVodPlayerViewAdHelper = this;
                longVodPlayerViewAdHelper2 = longVodPlayerViewAdHelper;
            } else {
                longVodPlayerViewAdHelper = this;
            }
            if (longVodPlayerViewAdHelper.f54531c == null && (aVar = longVodPlayerViewAdHelper.f54530b) != null) {
                longVodPlayerViewAdHelper.f54531c = new VideoDetailPlayBean(aVar.m(), "", aVar.d(), aVar.k(), 0L, null, null, null, null, 0L, null, null, null, null, null, false, null, null, null, 0L, null, null, null, false, false, false, 67108848, null);
            }
            return longVodPlayerViewAdHelper.f54531c;
        }
        if (i12 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        longVodPlayerViewAdHelper2 = (LongVodPlayerViewAdHelper) longVodPlayerViewAdHelper$getVideoDetailPlayBean$1.L$1;
        longVodPlayerViewAdHelper = (LongVodPlayerViewAdHelper) longVodPlayerViewAdHelper$getVideoDetailPlayBean$1.L$0;
        ResultKt.b(objK);
        longVodPlayerViewAdHelper2.f54531c = (VideoDetailPlayBean) objK;
        if (longVodPlayerViewAdHelper.f54531c == null) {
            longVodPlayerViewAdHelper.f54531c = new VideoDetailPlayBean(aVar.m(), "", aVar.d(), aVar.k(), 0L, null, null, null, null, 0L, null, null, null, null, null, false, null, null, null, 0L, null, null, null, false, false, false, 67108848, null);
        }
        return longVodPlayerViewAdHelper.f54531c;
    }

    public final void q2() {
        LongVodRewardInterceptView longVodRewardInterceptView;
        this.L = false;
        this.K = false;
        this.G = true;
        mv.i iVar = this.f54536h;
        if (iVar != null && (longVodRewardInterceptView = iVar.f71247t) != null) {
            so.c.g(longVodRewardInterceptView);
        }
        p2(false);
    }

    public final VideoDetailPlayDao r1() {
        return (VideoDetailPlayDao) this.f54541m.getValue();
    }

    public final void r2() {
        AppCompatImageView appCompatImageView;
        mv.i iVar = this.f54536h;
        if (iVar == null || (appCompatImageView = iVar.f71248u) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = appCompatImageView.getLayoutParams();
        Intrinsics.e(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        int iA = f0.a(this.f54532d ? 40.0f : 26.0f);
        layoutParams2.width = iA;
        layoutParams2.height = iA;
        layoutParams2.rightMargin = f0.a(this.f54532d ? 16.0f : 12.0f);
    }

    public final void s1(boolean z11) {
        this.f54550v += (System.currentTimeMillis() - this.f54551w) / ((long) 1000);
        this.f54551w = System.currentTimeMillis();
        if (z11) {
            this.f54547s = true;
            y2();
            p2(false);
        }
    }

    public final void s2(ViewGroup viewGroup, boolean z11) {
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
            layoutParams2.setMarginStart(f0.a(this.f54532d ? 16.0f : 12.0f));
            layoutParams2.bottomMargin = f0.a(16.0f);
            int iA2 = f0.a(this.f54532d ? 40.0f : 28.0f);
            layoutParams2.width = iA2;
            layoutParams2.height = iA2;
        }
    }

    public final void t1(String str, mv.i viewBinding, String str2, Function1<? super Boolean, Unit> adShowCallback) {
        Intrinsics.g(viewBinding, "viewBinding");
        Intrinsics.g(adShowCallback, "adShowCallback");
        com.transsion.ad.a.j(com.transsion.ad.a.f50276a, X0() + " --> initAdHelper()", false, 2, null);
        this.f54538j = str;
        this.f54536h = viewBinding;
        this.f54537i = str2;
        this.f54539k = adShowCallback;
        Context context = viewBinding.getRoot().getContext();
        AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
        this.f54528a = appCompatActivity != null ? v.a(appCompatActivity) : null;
        u1();
    }

    public final void t2() {
        String str = this.R;
        if (Intrinsics.b(str, "StreamVideoInterceptRewarded")) {
            I1();
        } else if (Intrinsics.b(str, "StreamVideoInterceptInterstitial")) {
            F1();
        }
    }

    public final void u1() {
        AdCountDownView adCountDownView;
        mv.i iVar = this.f54536h;
        if (iVar == null || (adCountDownView = iVar.f71232d) == null) {
            return;
        }
        adCountDownView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.ui.dialog.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LongVodPlayerViewAdHelper.v1(this.f54574a, view);
            }
        });
    }

    public final void u2() {
        if (this.f54554z || this.L || !z1()) {
            return;
        }
        this.f54554z = true;
        E1(new Function0<Unit>() { // from class: com.transsion.player.longvideo.ui.dialog.LongVodPlayerViewAdHelper$showInterpolateAd$1
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
                this.this$0.J2();
            }
        }, new Function0<Unit>() { // from class: com.transsion.player.longvideo.ui.dialog.LongVodPlayerViewAdHelper$showInterpolateAd$2
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
                this.this$0.f54554z = false;
                this.this$0.f54550v = 0L;
                this.this$0.f54551w = System.currentTimeMillis();
            }
        });
    }

    public final void v2() {
        View root;
        Context context;
        mv.i iVar = this.f54536h;
        if (iVar == null || (root = iVar.getRoot()) == null || (context = root.getContext()) == null) {
            return;
        }
        this.R = "StreamVideoInterceptInterstitial";
        LifecycleCoroutineScope lifecycleCoroutineScope = this.f54528a;
        if (lifecycleCoroutineScope != null) {
            j.d(lifecycleCoroutineScope, null, null, new LongVodPlayerViewAdHelper$showInterstitialAd$1$1(this, context, null), 3, null);
        }
    }

    public final void w1(lv.a aVar) {
        LongVodRewardInterceptView longVodRewardInterceptView;
        this.L = false;
        this.M = false;
        mv.i iVar = this.f54536h;
        if (iVar != null && (longVodRewardInterceptView = iVar.f71247t) != null) {
            so.c.g(longVodRewardInterceptView);
        }
        if (B1()) {
            this.K = false;
            return;
        }
        this.N = aVar.j();
        this.O = aVar.j();
        VideoDetailPlayBean videoDetailPlayBean = this.f54531c;
        this.G = videoDetailPlayBean != null ? videoDetailPlayBean.getRewardUnlock() : false;
        VideoDetailPlayBean videoDetailPlayBean2 = this.f54531c;
        this.H = videoDetailPlayBean2 != null ? videoDetailPlayBean2.getRewardPlayed() : false;
        VideoDetailPlayBean videoDetailPlayBean3 = this.f54531c;
        this.I = videoDetailPlayBean3 != null ? videoDetailPlayBean3.getRewardFree() : false;
        uo.b.a aVar2 = uo.b.f78622a;
        uo.b.a.f(aVar2, LongVodPlayerView.TAG, "---> initRewardInterceptVariables --> startPlayProgress:" + this.N + "，isRewardUnlock:" + this.G + ", rewardUnlockFreeTimes:" + o1(), false, 4, null);
        RoomAppMMKV roomAppMMKV = RoomAppMMKV.f51271a;
        long j11 = roomAppMMKV.a().getLong("zero_clock_timestamp", 0L);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - j11 >= ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED) {
            this.Q = 0;
            boolean z11 = o1() == 0 && !this.G;
            this.K = z11;
            this.H = z11;
            this.I = true ^ z11;
            uo.b.a.f(aVar2, LongVodPlayerView.TAG, "---> FreeTimes Reset", false, 4, null);
            roomAppMMKV.a().putInt("video_played_count_per_day", 0);
            roomAppMMKV.a().putLong("zero_clock_timestamp", y.c(jCurrentTimeMillis));
        } else {
            int i11 = roomAppMMKV.a().getInt("video_played_count_per_day", 0);
            this.Q = i11;
            if (i11 >= o1()) {
                this.K = !this.G;
            }
            VideoDetailPlayBean videoDetailPlayBean4 = this.f54531c;
            if (Math.abs(y.c(videoDetailPlayBean4 != null ? videoDetailPlayBean4.getTimeStamp() : 0L) - j11) >= ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED) {
                boolean z12 = this.K;
                this.H = z12;
                this.I = !z12;
            } else if (this.I) {
                this.K = false;
            }
            uo.b.a.f(aVar2, LongVodPlayerView.TAG, "---> videoPlayedTimesPerDay:" + this.Q + ", isRewardPlayed:" + this.H + ", isRewardFree:" + this.I, false, 4, null);
        }
        VideoDetailPlayBean videoDetailPlayBean5 = this.f54531c;
        if (videoDetailPlayBean5 == null || videoDetailPlayBean5.getRewardFree() != this.I) {
            L2();
        }
    }

    public final void w2() {
        View root;
        Context context;
        com.transsion.ad.bidding.interstitial.a aVar;
        F0(true);
        this.f54547s = true;
        mv.i iVar = this.f54536h;
        if (iVar != null && (root = iVar.getRoot()) != null && (context = root.getContext()) != null && (aVar = this.f54534f) != null) {
            aVar.n0((AppCompatActivity) context);
        }
        R0();
    }

    public final void x1() {
        View root;
        Context context;
        S1();
        S0();
        zp.b.a aVar = zp.b.f82110a;
        mv.i iVar = this.f54536h;
        aVar.e((iVar == null || (root = iVar.getRoot()) == null || (context = root.getContext()) == null) ? null : context.getString(R$string.long_vod_reward_intercept_skip));
    }

    public final void x2(String str) {
        View root;
        Context context;
        NativeWrapperAdView nativeWrapperAdView;
        F0(true);
        this.f54546r = true;
        this.f54545q = System.currentTimeMillis();
        mv.i iVar = this.f54536h;
        if (iVar != null && (root = iVar.getRoot()) != null && (context = root.getContext()) != null) {
            d00.b bVar = d00.b.f62855a;
            com.transsion.ad.bidding.nativead.c cVar = this.f54533e;
            zq.b bVarA = bVar.a(context, cVar != null ? cVar.Q() : null);
            mv.i iVar2 = this.f54536h;
            if (iVar2 != null && (nativeWrapperAdView = iVar2.f71235h) != null) {
                nativeWrapperAdView.bindNativeView(this.f54533e, bVarA);
            }
        }
        h2(false);
        mv.i iVar3 = this.f54536h;
        FrameLayout frameLayout = iVar3 != null ? iVar3.f71236i : null;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        G0(str);
        C1();
    }

    public final boolean y1(int i11, long j11) {
        return Math.abs(System.currentTimeMillis() - j11) > ((long) i11);
    }

    public final void y2() {
        if (this.f54532d) {
            E2(this, "LandscapePauseSceneNew", null, new Function0<Unit>() { // from class: com.transsion.player.longvideo.ui.dialog.LongVodPlayerViewAdHelper$showPauseAd$1
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
                    this.this$0.F0(false);
                }
            }, 2, null);
        } else {
            E2(this, "VerticalPauseScene", null, new Function0<Unit>() { // from class: com.transsion.player.longvideo.ui.dialog.LongVodPlayerViewAdHelper$showPauseAd$2
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
                    this.this$0.F0(false);
                }
            }, 2, null);
        }
    }

    public final boolean z1() {
        return !VideoPipManager.f60024a.a().k();
    }

    public final void z2() {
        LongVodRewardInterceptView longVodRewardInterceptView;
        BLTextView bLTextView;
        BLTextView bLTextView2;
        LongVodRewardInterceptView longVodRewardInterceptView2;
        if (!this.K || this.O < m1()) {
            return;
        }
        this.L = true;
        Function0<Unit> function0 = this.S;
        if (function0 != null) {
            function0.invoke();
        }
        mv.i iVar = this.f54536h;
        if (iVar != null && (longVodRewardInterceptView2 = iVar.f71247t) != null) {
            so.c.k(longVodRewardInterceptView2);
        }
        p2(false);
        Z1();
        mv.i iVar2 = this.f54536h;
        if (iVar2 != null && (longVodRewardInterceptView = iVar2.f71247t) != null) {
            mv.e bind = longVodRewardInterceptView.getBind();
            if (bind != null && (bLTextView2 = bind.f71206f) != null) {
                bLTextView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.ui.dialog.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        LongVodPlayerViewAdHelper.A2(this.f54570a, view);
                    }
                });
            }
            mv.e bind2 = longVodRewardInterceptView.getBind();
            if (bind2 != null && (bLTextView = bind2.f71203b) != null) {
                bLTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.longvideo.ui.dialog.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        LongVodPlayerViewAdHelper.B2(this.f54571a, view);
                    }
                });
            }
        }
        c2("browse", true);
    }
}
