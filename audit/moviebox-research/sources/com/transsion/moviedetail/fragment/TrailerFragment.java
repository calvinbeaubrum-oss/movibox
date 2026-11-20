package com.transsion.moviedetail.fragment;

import android.graphics.drawable.BitmapDrawable;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.FragmentActivity;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.Glide;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.util.networkinfo.NetworkType;
import com.tn.lib.view.SecondariesSeekBar;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.baseui.image.blurhash.BlurHashHelper;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.PreVideoAddress;
import com.transsion.moviedetailapi.bean.Trailer;
import com.transsion.player.MediaSource;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.global.TnPlayerManager;
import com.transsion.postdetail.R$drawable;
import com.transsion.postdetail.R$string;
import com.transsion.room.api.IAudioApi;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class TrailerFragment extends BaseFragment<tu.t> implements com.transsion.player.orplayer.e, com.tn.lib.util.networkinfo.g {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final a f53604t = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PreVideoAddress f53605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f53606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f53607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f53608d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f53609f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Trailer f53610g;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f53615l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f53616m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f53618o;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public PlayError f53620q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View f53621r;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f53611h = "TrailerFragment";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f53612i = LazyKt__LazyJVMKt.b(new Function0<IAudioApi>() { // from class: com.transsion.moviedetail.fragment.TrailerFragment$mAudioApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final IAudioApi invoke() {
            return (IAudioApi) com.alibaba.android.arouter.launcher.a.d().h(IAudioApi.class);
        }
    });

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f53613j = LazyKt__LazyJVMKt.b(new Function0<Handler>() { // from class: com.transsion.moviedetail.fragment.TrailerFragment$loadingHandler$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Handler invoke() {
            Looper looperMyLooper = Looper.myLooper();
            Intrinsics.d(looperMyLooper);
            return new Handler(looperMyLooper);
        }
    });

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f53614k = LazyKt__LazyJVMKt.b(new Function0<com.transsion.player.orplayer.f>() { // from class: com.transsion.moviedetail.fragment.TrailerFragment$mOrPlayer$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final com.transsion.player.orplayer.f invoke() {
            com.transsion.player.orplayer.f fVarI = TnPlayerManager.f54684a.i();
            TrailerFragment trailerFragment = this.this$0;
            fVarI.setPlayerConfig(new iv.d(null, false, 0, 0, 0, 0, 0, 0, 0L, 0, 0, false, false, false, false, false, null, 126975, null));
            tu.t mViewBinding = trailerFragment.getMViewBinding();
            fVarI.setTextureView(mViewBinding != null ? mViewBinding.f77623i : null);
            fVarI.setLooping(false);
            fVarI.setPlayerListener(trailerFragment);
            return fVarI;
        }
    });

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String[] f53617n = {InstructionFileId.DOT, "..", "..."};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Runnable f53619p = new Runnable() { // from class: com.transsion.moviedetail.fragment.w0
        @Override // java.lang.Runnable
        public final void run() {
            TrailerFragment.x0(this.f53687a);
        }
    };

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Runnable f53622s = new Runnable() { // from class: com.transsion.moviedetail.fragment.x0
        @Override // java.lang.Runnable
        public final void run() {
            TrailerFragment.H0(this.f53689a);
        }
    };

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
    public static final class b implements com.tn.lib.view.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f53623a;

        public b() {
        }

        @Override // com.tn.lib.view.p
        public void a(SecondariesSeekBar seekBar) {
            Intrinsics.g(seekBar, "seekBar");
            TrailerFragment.this.f53607c = false;
            TrailerFragment.this.s0().seekTo((this.f53623a * TrailerFragment.this.f53606b) / ((long) 100));
            if (TrailerFragment.this.s0().isPlaying()) {
                return;
            }
            TrailerFragment.this.s0().play();
        }

        @Override // com.tn.lib.view.p
        public void b(SecondariesSeekBar seekBar, long j11, boolean z11) {
            Intrinsics.g(seekBar, "seekBar");
            if (z11) {
                this.f53623a = j11;
            }
        }

        @Override // com.tn.lib.view.p
        public void c(SecondariesSeekBar seekBar) {
            Intrinsics.g(seekBar, "seekBar");
            TrailerFragment.this.f53607c = true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f53625a;

        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TrailerFragment.this.f53608d != 10) {
                TrailerFragment.this.A0();
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j11 = this.f53625a;
            if (j11 == 0 || jCurrentTimeMillis - j11 > 500) {
                this.f53625a = jCurrentTimeMillis;
            } else {
                this.f53625a = 0L;
                TrailerFragment.this.y0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A0() {
        tu.t mViewBinding;
        Group group;
        tu.t mViewBinding2;
        Group group2;
        int i11 = this.f53608d;
        if (i11 == -1) {
            B0();
            return;
        }
        if (i11 == 0) {
            s0().prepare();
            s0().seekTo(0L);
            z0();
            if (this.f53608d != 10 || (mViewBinding = getMViewBinding()) == null || (group = mViewBinding.f77617b) == null) {
                return;
            }
            so.c.k(group);
            return;
        }
        if (i11 == 10) {
            y0();
            return;
        }
        if (i11 == 20 || i11 == 22) {
            z0();
            return;
        }
        if (i11 != 30) {
            return;
        }
        s0().seekTo(0L);
        z0();
        if (this.f53608d != 10 || (mViewBinding2 = getMViewBinding()) == null || (group2 = mViewBinding2.f77617b) == null) {
            return;
        }
        so.c.k(group2);
    }

    private final void B0() {
        uo.b.a.f(uo.b.f78622a, this.f53611h, "video error，reload~~", false, 4, null);
        this.f53615l = 0L;
        s0().stop();
        s0().reset();
        s0().prepare();
        s0().seekTo(this.f53616m);
        I0();
    }

    private final void E0(Cover cover) {
        final tu.t mViewBinding;
        if (cover == null || (mViewBinding = getMViewBinding()) == null) {
            return;
        }
        int iF = com.transsion.core.utils.e.f();
        ImageHelper.Companion companion = ImageHelper.f51371a;
        String url = cover.getUrl();
        if (url == null) {
            url = "";
        }
        String strE = companion.e(url, (124 & 2) != 0 ? 0 : iF, (124 & 4) != 0 ? 0 : 0, (124 & 8) != 0, (124 & 16) != 0 ? false : false, (124 & 32) == 0 ? false : false, (124 & 64) != 0 ? 25 : 0);
        String thumbnail = cover.getThumbnail();
        BlurHashHelper.b(BlurHashHelper.f51391a, thumbnail == null ? "" : thumbnail, 0, 0, new Function1<BitmapDrawable, Unit>() { // from class: com.transsion.moviedetail.fragment.TrailerFragment$showCover$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BitmapDrawable bitmapDrawable) {
                invoke2(bitmapDrawable);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(BitmapDrawable it) {
                Intrinsics.g(it, "it");
                mViewBinding.f77619d.setImageDrawable(it);
            }
        }, 6, null);
        Glide.with(requireContext()).load2(strE).into(mViewBinding.f77620f);
    }

    private final void F0(int i11) {
        AppCompatImageView appCompatImageView;
        Group group;
        ShapeableImageView shapeableImageView;
        ShapeableImageView shapeableImageView2;
        ViewStub viewStub;
        if (this.f53621r == null) {
            tu.t mViewBinding = getMViewBinding();
            this.f53621r = (mViewBinding == null || (viewStub = mViewBinding.f77629o) == null) ? null : viewStub.inflate();
        }
        if (i11 == 1) {
            Intrinsics.f(Utils.a().getString(R$string.downloading_play_timeout), "getApp().getString(com.t…downloading_play_timeout)");
            Intrinsics.f(Utils.a().getString(R$string.downloading_play_timeout_reload), "getApp().getString(com.t…ding_play_timeout_reload)");
            this.f53608d = -1;
        } else {
            Intrinsics.f(Utils.a().getString(R$string.downloading_play_load_failed), "getApp().getString(com.t…loading_play_load_failed)");
            Intrinsics.f(Utils.a().getString(R$string.turn_on_network), "getApp().getString(com.t…R.string.turn_on_network)");
            this.f53608d = 22;
        }
        s0().pause();
        tu.t mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (shapeableImageView2 = mViewBinding2.f77619d) != null) {
            so.c.k(shapeableImageView2);
        }
        tu.t mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (shapeableImageView = mViewBinding3.f77620f) != null) {
            so.c.g(shapeableImageView);
        }
        tu.t mViewBinding4 = getMViewBinding();
        if (mViewBinding4 != null && (group = mViewBinding4.f77617b) != null) {
            so.c.g(group);
        }
        View view = this.f53621r;
        if (view != null) {
            so.c.k(view);
        }
        View view2 = this.f53621r;
        if (view2 != null) {
            view2.setTag(Integer.valueOf(i11));
        }
        tu.t mViewBinding5 = getMViewBinding();
        if (mViewBinding5 != null && (appCompatImageView = mViewBinding5.f77626l) != null) {
            appCompatImageView.setImageResource(R$drawable.post_icon_play);
        }
        tu.t mViewBinding6 = getMViewBinding();
        AppCompatImageView appCompatImageView2 = mViewBinding6 != null ? mViewBinding6.f77626l : null;
        if (appCompatImageView2 == null) {
            return;
        }
        appCompatImageView2.setKeepScreenOn(false);
    }

    private final void G0(long j11) {
        q0().removeCallbacks(this.f53622s);
        q0().postDelayed(this.f53622s, j11);
    }

    public static final void H0(TrailerFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.F0(0);
    }

    private final Handler q0() {
        return (Handler) this.f53613j.getValue();
    }

    private final IAudioApi r0() {
        return (IAudioApi) this.f53612i.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.transsion.player.orplayer.f s0() {
        return (com.transsion.player.orplayer.f) this.f53614k.getValue();
    }

    private final void u0() {
        SecondariesSeekBar secondariesSeekBar;
        tu.t mViewBinding = getMViewBinding();
        if (mViewBinding == null || (secondariesSeekBar = mViewBinding.f77627m) == null) {
            return;
        }
        secondariesSeekBar.setOnSeekBarChangeListener(new b());
    }

    public static final void v0(TrailerFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.A0();
    }

    private final void w0() {
        q0().postDelayed(this.f53619p, 1000L);
    }

    public static final void x0(TrailerFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        int i11 = this$0.f53618o;
        if (i11 >= 2) {
            this$0.f53618o = 0;
        } else {
            this$0.f53618o = i11 + 1;
        }
        tu.t mViewBinding = this$0.getMViewBinding();
        TextView textView = mViewBinding != null ? mViewBinding.f77624j : null;
        if (textView != null) {
            textView.setText(Utils.a().getString(R$string.play_loading) + this$0.f53617n[this$0.f53618o]);
        }
        this$0.w0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y0() {
        this.f53608d = 20;
        s0().pause();
    }

    public final void C0(Trailer trailer) {
        String url;
        Integer duration;
        SecondariesSeekBar secondariesSeekBar;
        E0(trailer.getCover());
        this.f53605a = trailer.getVideoAddress();
        tu.t mViewBinding = getMViewBinding();
        if (mViewBinding != null && (secondariesSeekBar = mViewBinding.f77627m) != null) {
            secondariesSeekBar.setMax(100L);
        }
        PreVideoAddress preVideoAddress = this.f53605a;
        long jIntValue = (preVideoAddress == null || (duration = preVideoAddress.getDuration()) == null) ? 0L : duration.intValue() * 1000;
        this.f53606b = jIntValue;
        if (jIntValue > 0) {
            String str = "00:00/" + com.transsion.postdetail.util.i.d(jIntValue);
            tu.t mViewBinding2 = getMViewBinding();
            TextView textView = mViewBinding2 != null ? mViewBinding2.f77628n : null;
            if (textView != null) {
                textView.setText(str);
            }
        }
        PreVideoAddress preVideoAddress2 = this.f53605a;
        if (preVideoAddress2 == null || (url = preVideoAddress2.getUrl()) == null) {
            return;
        }
        s0().setDataSource(new MediaSource(url, url, 0, null, null, 28, null));
    }

    public final void D0() {
        ShapeableImageView shapeableImageView;
        ShapeableImageView shapeableImageView2;
        tu.t mViewBinding = getMViewBinding();
        if (mViewBinding != null && (shapeableImageView2 = mViewBinding.f77620f) != null) {
            so.c.k(shapeableImageView2);
        }
        tu.t mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (shapeableImageView = mViewBinding2.f77619d) == null) {
            return;
        }
        so.c.k(shapeableImageView);
    }

    public final void I0() {
        AppCompatImageView appCompatImageView;
        Group group;
        AppCompatImageView appCompatImageView2;
        IAudioApi iAudioApiR0 = r0();
        if (iAudioApiR0 != null) {
            iAudioApiR0.pause();
        }
        this.f53608d = 10;
        this.f53620q = null;
        s0().play();
        View view = this.f53621r;
        if (view != null) {
            so.c.g(view);
        }
        tu.t mViewBinding = getMViewBinding();
        if (mViewBinding != null && (appCompatImageView2 = mViewBinding.f77621g) != null) {
            so.c.g(appCompatImageView2);
        }
        tu.t mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (group = mViewBinding2.f77618c) != null) {
            so.c.k(group);
        }
        tu.t mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (appCompatImageView = mViewBinding3.f77626l) != null) {
            appCompatImageView.setImageResource(R$drawable.post_icon_pause);
        }
        q0().removeCallbacks(this.f53622s);
        Trailer trailer = this.f53610g;
        if (trailer == null || trailer.getSubjectType() != SubjectType.MUSIC.getValue()) {
            p0();
        } else {
            D0();
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void initPlayer() {
        com.transsion.player.orplayer.e.a.a(this);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        tu.t mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.transsion.moviedetail.fragment.y0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    TrailerFragment.v0(this.f53691a, view2);
                }
            };
            mViewBinding.f77621g.setOnClickListener(onClickListener);
            mViewBinding.f77626l.setOnClickListener(onClickListener);
            mViewBinding.f77625k.setOnClickListener(new c());
        }
        u0();
        com.tn.lib.util.networkinfo.f.f49475a.l(this);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
        Bundle arguments = getArguments();
        Trailer trailer = null;
        Trailer trailer2 = (Trailer) (arguments != null ? arguments.getSerializable("trailer") : null);
        if (trailer2 != null) {
            C0(trailer2);
            if (NetworkType.NETWORK_WIFI == com.tn.lib.util.networkinfo.f.f49475a.d() && trailer2.getSubjectType() < SubjectType.AUDIO.getValue()) {
                A0();
            }
            trailer = trailer2;
        }
        this.f53610g = trailer;
    }

    @Override // com.transsion.player.orplayer.e
    public void onAliyunDecodeErrorChangeSoftwareDecoder(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.b(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onBufferedPosition(long j11, MediaSource mediaSource) {
        SecondariesSeekBar secondariesSeekBar;
        com.transsion.player.orplayer.e.a.c(this, j11, mediaSource);
        if (this.f53615l < j11) {
            this.f53615l = j11;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(0, Integer.valueOf((int) ((j11 * ((long) 100)) / this.f53606b)));
            tu.t mViewBinding = getMViewBinding();
            if (mViewBinding == null || (secondariesSeekBar = mViewBinding.f77627m) == null) {
                return;
            }
            secondariesSeekBar.setSecondariesProgress(linkedHashMap);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onCompletion(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.d(this, mediaSource);
        tu.t mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            this.f53616m = 0L;
            this.f53608d = 30;
            AppCompatImageView ivPlay = mViewBinding.f77621g;
            Intrinsics.f(ivPlay, "ivPlay");
            so.c.k(ivPlay);
            mViewBinding.f77626l.setImageResource(R$drawable.post_icon_play);
            Group groupProgress = mViewBinding.f77618c;
            Intrinsics.f(groupProgress, "groupProgress");
            so.c.g(groupProgress);
            ShapeableImageView ivMovieCover = mViewBinding.f77620f;
            Intrinsics.f(ivMovieCover, "ivMovieCover");
            so.c.k(ivMovieCover);
            ShapeableImageView ivMovieBlurCover = mViewBinding.f77619d;
            Intrinsics.f(ivMovieBlurCover, "ivMovieBlurCover");
            so.c.k(ivMovieBlurCover);
            uo.b.a.f(uo.b.f78622a, this.f53611h, "onCompletion", false, 4, null);
        }
    }

    @Override // com.tn.lib.util.networkinfo.g
    public void onConnected() {
        com.tn.lib.util.networkinfo.g.a.a(this);
    }

    @Override // com.tn.lib.util.networkinfo.g
    public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
        int i11;
        PlayError playError;
        Integer errorCode;
        Intrinsics.g(network, "network");
        Intrinsics.g(networkCapabilities, "networkCapabilities");
        uo.b.a.f(uo.b.f78622a, this.f53611h, "onConnected~~", false, 4, null);
        View view = this.f53621r;
        if (view == null || view.getVisibility() != 0 || (i11 = this.f53608d) == 20 || i11 == 21) {
            return;
        }
        View view2 = this.f53621r;
        if ((view2 == null || !Intrinsics.b(view2.getTag(), 1)) && ((playError = this.f53620q) == null || (errorCode = playError.getErrorCode()) == null || errorCode.intValue() != 537067524)) {
            I0();
        } else {
            B0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        q0().removeCallbacks(this.f53619p);
        com.tn.lib.util.networkinfo.f.f49475a.m(this);
    }

    @Override // com.tn.lib.util.networkinfo.g
    public void onDisconnected() {
        uo.b.a.f(uo.b.f78622a, this.f53611h, "onDisconnected~~", false, 4, null);
        if (this.f53608d != 10 || s0().isPlaying()) {
            return;
        }
        G0(500L);
    }

    @Override // com.transsion.player.orplayer.e
    public void onFocusChange(boolean z11) {
        com.transsion.player.orplayer.e.a.f(this, z11);
    }

    @Override // com.transsion.player.orplayer.e
    public void onIsPlayingChanged(boolean z11) {
        com.transsion.player.orplayer.e.a.g(this, z11);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingBegin(MediaSource mediaSource) {
        Group group;
        com.transsion.player.orplayer.e.a.h(this, mediaSource);
        uo.b.a.f(uo.b.f78622a, this.f53611h, "onLoadingBegin", false, 4, null);
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            G0(1000L);
            return;
        }
        tu.t mViewBinding = getMViewBinding();
        if (mViewBinding != null && (group = mViewBinding.f77617b) != null) {
            so.c.k(group);
        }
        q0().post(this.f53619p);
        View view = this.f53621r;
        if (view != null) {
            so.c.g(view);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingEnd(MediaSource mediaSource) {
        Group group;
        com.transsion.player.orplayer.e.a.j(this, mediaSource);
        tu.t mViewBinding = getMViewBinding();
        if (mViewBinding != null && (group = mViewBinding.f77617b) != null) {
            so.c.g(group);
        }
        uo.b.a.f(uo.b.f78622a, this.f53611h, "onLoadingEnd", false, 4, null);
        View view = this.f53621r;
        if (view != null) {
            so.c.g(view);
        }
        q0().removeCallbacks(this.f53619p);
        q0().removeCallbacks(this.f53622s);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingProgress(int i11, float f11, MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.l(this, i11, f11, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoopingStart() {
        com.transsion.player.orplayer.e.a.n(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onMediaItemTransition(String str) {
        com.transsion.player.orplayer.e.a.o(this, str);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        FragmentActivity activity = getActivity();
        if (activity != null && activity.isFinishing()) {
            s0().release();
        } else if (this.f53608d == 10) {
            this.f53608d = 21;
            s0().pause();
        }
        IAudioApi iAudioApiR0 = r0();
        if (iAudioApiR0 != null) {
            iAudioApiR0.start();
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayError(PlayError errorInfo, MediaSource mediaSource) {
        Intrinsics.g(errorInfo, "errorInfo");
        com.transsion.player.orplayer.e.a.p(this, errorInfo, mediaSource);
        Integer errorCode = errorInfo.getErrorCode();
        if (errorCode != null && errorCode.intValue() == 537067524) {
            if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
                F0(1);
            } else {
                G0(500L);
            }
        }
        this.f53620q = errorInfo;
        uo.b.f78622a.h("i_media", this.f53611h + " --> IPlayerListener --> onPlayError()  errorCode:" + errorInfo.getErrorCode() + " errorMessage:" + errorInfo.getErrorMessage() + " url:" + (mediaSource != null ? mediaSource.j() : null) + " --> 预告片播放失败了", true);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerRelease(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.s(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerReset() {
        com.transsion.player.orplayer.e.a.u(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPrepare(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.v(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onProgress(long j11, MediaSource mediaSource) {
        SecondariesSeekBar secondariesSeekBar;
        com.transsion.player.orplayer.e.a.x(this, j11, mediaSource);
        if (this.f53607c) {
            return;
        }
        this.f53616m = j11;
        if (this.f53606b <= 0) {
            this.f53606b = s0().getDuration();
        }
        String str = com.transsion.postdetail.util.i.d(j11) + "/" + com.transsion.postdetail.util.i.d(this.f53606b);
        tu.t mViewBinding = getMViewBinding();
        TextView textView = mViewBinding != null ? mViewBinding.f77628n : null;
        if (textView != null) {
            textView.setText(str);
        }
        tu.t mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (secondariesSeekBar = mViewBinding2.f77627m) == null) {
            return;
        }
        secondariesSeekBar.setProgress((j11 * ((long) 100)) / this.f53606b);
    }

    @Override // com.transsion.player.orplayer.e
    public void onRenderFirstFrame() {
        com.transsion.player.orplayer.e.a.z(this);
        this.f53609f = true;
        uo.b.a.f(uo.b.f78622a, this.f53611h, "onRenderFirstFrame", false, 4, null);
        p0();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        PreVideoAddress preVideoAddress = this.f53605a;
        if ((preVideoAddress != null ? preVideoAddress.getUrl() : null) != null) {
            if (s0().requestForce()) {
                s0().prepare();
                s0().seekTo(this.f53616m);
            }
            if (this.f53608d == 21) {
                this.f53608d = 10;
                s0().play();
                IAudioApi iAudioApiR0 = r0();
                if (iAudioApiR0 != null) {
                    iAudioApiR0.pause();
                }
            }
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onSetDataSource() {
        com.transsion.player.orplayer.e.a.A(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        uo.b.a.f(uo.b.f78622a, this.f53611h, "onStart~~", false, 4, null);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksAudioBitrateChange(int i11) {
        com.transsion.player.orplayer.e.a.B(this, i11);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksChange(ov.c cVar) {
        com.transsion.player.orplayer.e.a.C(this, cVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksVideoBitrateChange(int i11) {
        com.transsion.player.orplayer.e.a.D(this, i11);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoPause(MediaSource mediaSource) {
        AppCompatImageView appCompatImageView;
        com.transsion.player.orplayer.e.a.E(this, mediaSource);
        tu.t mViewBinding = getMViewBinding();
        if (mViewBinding != null && (appCompatImageView = mViewBinding.f77626l) != null) {
            appCompatImageView.setImageResource(R$drawable.post_icon_play);
        }
        tu.t mViewBinding2 = getMViewBinding();
        AppCompatImageView appCompatImageView2 = mViewBinding2 != null ? mViewBinding2.f77626l : null;
        if (appCompatImageView2 != null) {
            appCompatImageView2.setKeepScreenOn(false);
        }
        uo.b.a.f(uo.b.f78622a, this.f53611h, "onVideoPause", false, 4, null);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoSizeChanged(int i11, int i12) {
        com.transsion.player.orplayer.e.a.G(this, i11, i12);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoStart(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.H(this, mediaSource);
        tu.t mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            Group groupLoading = mViewBinding.f77617b;
            Intrinsics.f(groupLoading, "groupLoading");
            so.c.g(groupLoading);
            mViewBinding.f77626l.setImageResource(R$drawable.post_icon_pause);
            mViewBinding.f77626l.setKeepScreenOn(true);
            p0();
            uo.b.a.f(uo.b.f78622a, this.f53611h, "onVideoStart", false, 4, null);
        }
    }

    public final void p0() {
        ShapeableImageView shapeableImageView;
        ShapeableImageView shapeableImageView2;
        if (this.f53609f) {
            Trailer trailer = this.f53610g;
            if (trailer == null || trailer.getSubjectType() != SubjectType.MUSIC.getValue()) {
                tu.t mViewBinding = getMViewBinding();
                if (mViewBinding != null && (shapeableImageView2 = mViewBinding.f77620f) != null) {
                    so.c.g(shapeableImageView2);
                }
                tu.t mViewBinding2 = getMViewBinding();
                if (mViewBinding2 == null || (shapeableImageView = mViewBinding2.f77619d) == null) {
                    return;
                }
                so.c.g(shapeableImageView);
            }
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void setOnSeekCompleteListener() {
        com.transsion.player.orplayer.e.a.J(this);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: t0, reason: merged with bridge method [inline-methods] */
    public tu.t getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        tu.t tVarC = tu.t.c(inflater);
        Intrinsics.f(tVarC, "inflate(inflater)");
        return tVarC;
    }

    public final void z0() {
        this.f53608d = 10;
        I0();
    }
}
