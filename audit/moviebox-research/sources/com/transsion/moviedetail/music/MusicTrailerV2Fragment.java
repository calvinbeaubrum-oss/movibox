package com.transsion.moviedetail.music;

import android.app.Activity;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Group;
import c1.i;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.util.networkinfo.NetworkType;
import com.tn.lib.view.SecondariesSeekBar;
import com.tn.lib.view.p;
import com.transsion.baseui.fragment.PageStatusFragment;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.baseui.image.blurhash.BlurHashHelper;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.PreVideoAddress;
import com.transsion.moviedetailapi.bean.Trailer;
import com.transsion.player.MediaSource;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.e;
import com.transsion.player.orplayer.f;
import com.transsion.player.orplayer.global.TnPlayerManager;
import com.transsion.postdetail.R$drawable;
import com.transsion.postdetail.R$string;
import com.transsion.push.api.IPushProvider;
import java.util.LinkedHashMap;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import org.mvel2.ast.ASTNode;
import tu.j;

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
@Deprecated
@SourceDebugExtension
public final class MusicTrailerV2Fragment extends PageStatusFragment<j> implements e {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final a f53694z = new a(null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Trailer f53695k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f53696l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f53697m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f53698n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f53699o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f53700p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public PlayError f53701q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View f53702r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public f f53703s;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f53707w;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final b1.b<String> f53709y;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f53704t = LazyKt__LazyJVMKt.b(new Function0<Handler>() { // from class: com.transsion.moviedetail.music.MusicTrailerV2Fragment$loadingHandler$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Handler invoke() {
            Looper looperMyLooper = Looper.myLooper();
            Intrinsics.d(looperMyLooper);
            return new Handler(looperMyLooper);
        }
    });

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Runnable f53705u = new Runnable() { // from class: com.transsion.moviedetail.music.a
        @Override // java.lang.Runnable
        public final void run() {
            MusicTrailerV2Fragment.t1(this.f53714a);
        }
    };

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String[] f53706v = {InstructionFileId.DOT, "..", "..."};

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Runnable f53708x = new Runnable() { // from class: com.transsion.moviedetail.music.b
        @Override // java.lang.Runnable
        public final void run() {
            MusicTrailerV2Fragment.k1(this.f53715a);
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
    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f53710a;

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MusicTrailerV2Fragment.this.f53698n != 10) {
                MusicTrailerV2Fragment.this.o1();
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j11 = this.f53710a;
            if (j11 == 0 || jCurrentTimeMillis - j11 > 500) {
                this.f53710a = jCurrentTimeMillis;
            } else {
                this.f53710a = 0L;
                MusicTrailerV2Fragment.this.l1();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f53712a;

        public c() {
        }

        @Override // com.tn.lib.view.p
        public void a(SecondariesSeekBar seekBar) {
            Intrinsics.g(seekBar, "seekBar");
            MusicTrailerV2Fragment.this.f53697m = false;
            j mViewBinding = MusicTrailerV2Fragment.this.getMViewBinding();
            Group group = mViewBinding != null ? mViewBinding.f77510b : null;
            if (group != null) {
                group.setVisibility(0);
            }
            f fVar = MusicTrailerV2Fragment.this.f53703s;
            if (fVar != null) {
                fVar.seekTo((this.f53712a * MusicTrailerV2Fragment.this.f53696l) / ((long) 100));
            }
        }

        @Override // com.tn.lib.view.p
        public void b(SecondariesSeekBar seekBar, long j11, boolean z11) {
            Intrinsics.g(seekBar, "seekBar");
            if (z11) {
                this.f53712a = j11;
            }
        }

        @Override // com.tn.lib.view.p
        public void c(SecondariesSeekBar seekBar) {
            Intrinsics.g(seekBar, "seekBar");
            MusicTrailerV2Fragment.this.f53697m = true;
        }
    }

    public MusicTrailerV2Fragment() {
        b1.b<String> bVarRegisterForActivityResult = registerForActivityResult(new i(), new b1.a() { // from class: com.transsion.moviedetail.music.c
            @Override // b1.a
            public final void a(Object obj) {
                MusicTrailerV2Fragment.q1((Boolean) obj);
            }
        });
        Intrinsics.f(bVarRegisterForActivityResult, "registerForActivityResul…ission.\")\n        }\n    }");
        this.f53709y = bVarRegisterForActivityResult;
    }

    private final MediaItem d1() {
        PreVideoAddress videoAddress;
        Cover cover;
        Trailer trailer = this.f53695k;
        String url = null;
        String musicName = trailer != null ? trailer.getMusicName() : null;
        Trailer trailer2 = this.f53695k;
        String url2 = (trailer2 == null || (cover = trailer2.getCover()) == null) ? null : cover.getUrl();
        Trailer trailer3 = this.f53695k;
        if (trailer3 != null && (videoAddress = trailer3.getVideoAddress()) != null) {
            url = videoAddress.getUrl();
        }
        return new MediaItem(musicName, "", url2, null, null, null, e1(), b1("media_music_float_notification"), null, url, Boolean.TRUE, null, null, null, 14648, null);
    }

    public static final void h1(MusicTrailerV2Fragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.o1();
    }

    public static final void k1(MusicTrailerV2Fragment this$0) {
        Intrinsics.g(this$0, "this$0");
        int i11 = this$0.f53707w;
        if (i11 >= 2) {
            this$0.f53707w = 0;
        } else {
            this$0.f53707w = i11 + 1;
        }
        j mViewBinding = this$0.getMViewBinding();
        TextView textView = mViewBinding != null ? mViewBinding.f77516i : null;
        if (textView != null) {
            textView.setText(Utils.a().getString(R$string.play_loading) + this$0.f53706v[this$0.f53707w]);
        }
        this$0.j1();
    }

    public static /* synthetic */ void n1(MusicTrailerV2Fragment musicTrailerV2Fragment, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = true;
        }
        musicTrailerV2Fragment.m1(z11);
    }

    public static final void q1(Boolean granted) {
        Intrinsics.f(granted, "granted");
        if (granted.booleanValue()) {
            uo.b.a.g(uo.b.f78622a, "User allow the permission.", false, 2, null);
        } else {
            uo.b.a.g(uo.b.f78622a, "User deny the permission.", false, 2, null);
        }
    }

    public static final void t1(MusicTrailerV2Fragment this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.r1(0);
    }

    public static /* synthetic */ void w1(MusicTrailerV2Fragment musicTrailerV2Fragment, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = true;
        }
        musicTrailerV2Fragment.v1(z11);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean A0() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void B0() {
        super.B0();
        u1();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void D0() {
        Bundle arguments = getArguments();
        Trailer trailer = (Trailer) (arguments != null ? arguments.getSerializable("trailer") : null);
        this.f53695k = trailer;
        com.transsion.player.mediasession.d.f54622a.a("MusicTrailerV2Fragment --> receiveArguments() --> trailer = " + trailer);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
        int i11;
        uo.b.a.g(uo.b.f78622a, "MusicTrailerV2Fragment --> retryLoadData()", false, 2, null);
        u1();
        View view = this.f53702r;
        if (view == null || view.getVisibility() != 0 || (i11 = this.f53698n) == 20 || i11 == 21) {
            return;
        }
        w1(this, false, 1, null);
    }

    public final void a1() {
    }

    public final Intent b1(String str) {
        IPushProvider iPushProvider = (IPushProvider) com.alibaba.android.arouter.launcher.a.d().h(IPushProvider.class);
        StringBuilder sb2 = new StringBuilder("oneroom://com.community.oneroom?type=");
        sb2.append("/movie/detail");
        sb2.append("&");
        sb2.append("id");
        sb2.append("=");
        Trailer trailer = this.f53695k;
        sb2.append(trailer != null ? trailer.getSubjectId() : null);
        sb2.append("&");
        sb2.append("subject_type");
        sb2.append("=");
        Trailer trailer2 = this.f53695k;
        sb2.append(trailer2 != null ? Integer.valueOf(trailer2.getSubjectType()) : null);
        sb2.append("extra_page_from");
        sb2.append("=");
        sb2.append(str);
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        Intent intentD1 = iPushProvider.d1(applicationA);
        intentD1.addFlags(603979776);
        intentD1.setData(Uri.parse(sb2.toString()));
        return intentD1;
    }

    public final Handler c1() {
        return (Handler) this.f53704t.getValue();
    }

    public final PendingIntent e1() {
        return PendingIntent.getActivity(Utils.a(), 0, b1("media_notification"), f1());
    }

    public final int f1() {
        if (Build.VERSION.SDK_INT >= 31) {
            return 67108864;
        }
        return ASTNode.NOJIT;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: g1, reason: merged with bridge method [inline-methods] */
    public j getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        j jVarC = j.c(inflater);
        Intrinsics.f(jVarC, "inflate(inflater)");
        return jVarC;
    }

    public final void i1() {
        SecondariesSeekBar secondariesSeekBar;
        j mViewBinding = getMViewBinding();
        if (mViewBinding == null || (secondariesSeekBar = mViewBinding.f77519l) == null) {
            return;
        }
        secondariesSeekBar.setOnSeekBarChangeListener(new c());
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        f fVar;
        i1();
        j mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.transsion.moviedetail.music.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MusicTrailerV2Fragment.h1(this.f53716a, view);
                }
            };
            mViewBinding.f77514g.setOnClickListener(onClickListener);
            mViewBinding.f77518k.setOnClickListener(onClickListener);
            mViewBinding.f77517j.setOnClickListener(new b());
            if (NetworkType.NETWORK_WIFI != com.tn.lib.util.networkinfo.f.f49475a.d() || (fVar = this.f53703s) == null || fVar.isPlaying()) {
                return;
            }
            o1();
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void initPlayer() {
        e.a.a(this);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
    }

    public final void j1() {
        c1().postDelayed(this.f53708x, 1000L);
    }

    public final void l1() {
        this.f53698n = 20;
        f fVar = this.f53703s;
        if (fVar != null) {
            fVar.pause();
        }
    }

    public final void m1(boolean z11) {
        this.f53698n = 10;
        v1(z11);
    }

    public final void o1() {
        PreVideoAddress videoAddress;
        String url;
        int i11 = this.f53698n;
        if (i11 == -1) {
            p1();
            return;
        }
        if (i11 != 0) {
            if (i11 == 10) {
                l1();
                return;
            } else if (i11 == 20 || i11 == 22) {
                n1(this, false, 1, null);
                return;
            } else if (i11 != 30) {
                return;
            }
        }
        f fVar = this.f53703s;
        if (fVar != null) {
            Trailer trailer = this.f53695k;
            if (trailer != null && (videoAddress = trailer.getVideoAddress()) != null && (url = videoAddress.getUrl()) != null) {
                Trailer trailer2 = this.f53695k;
                fVar.setDataSource(new MediaSource(trailer2 != null ? trailer2.getSubjectId() : null, url, 0, null, d1(), 12, null));
            }
            fVar.prepare();
        }
        m1(false);
    }

    @Override // com.transsion.player.orplayer.e
    public void onAliyunDecodeErrorChangeSoftwareDecoder(MediaSource mediaSource) {
        e.a.b(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onBufferedPosition(long j11, MediaSource mediaSource) {
        SecondariesSeekBar secondariesSeekBar;
        e.a.c(this, j11, mediaSource);
        if (this.f53699o >= j11 || this.f53696l <= 0) {
            return;
        }
        this.f53699o = j11;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(0, Integer.valueOf((int) ((j11 * ((long) 100)) / this.f53696l)));
        j mViewBinding = getMViewBinding();
        if (mViewBinding == null || (secondariesSeekBar = mViewBinding.f77519l) == null) {
            return;
        }
        secondariesSeekBar.setSecondariesProgress(linkedHashMap);
    }

    @Override // com.transsion.player.orplayer.e
    public void onCompletion(MediaSource mediaSource) {
        e.a.d(this, mediaSource);
        uo.b.a.g(uo.b.f78622a, "MusicTrailerV2Fragment --> onCompletion()", false, 2, null);
        j mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            this.f53700p = 0L;
            this.f53698n = 30;
            AppCompatImageView ivPlay = mViewBinding.f77514g;
            Intrinsics.f(ivPlay, "ivPlay");
            so.c.k(ivPlay);
            mViewBinding.f77518k.setImageResource(R$drawable.post_icon_play);
            Group groupProgress = mViewBinding.f77511c;
            Intrinsics.f(groupProgress, "groupProgress");
            so.c.g(groupProgress);
            ShapeableImageView ivMovieCover = mViewBinding.f77513f;
            Intrinsics.f(ivMovieCover, "ivMovieCover");
            so.c.k(ivMovieCover);
            ShapeableImageView ivMovieBlurCover = mViewBinding.f77512d;
            Intrinsics.f(ivMovieBlurCover, "ivMovieBlurCover");
            so.c.k(ivMovieBlurCover);
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        f fVar = this.f53703s;
        if (fVar != null) {
            fVar.removePlayerListener(this);
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, com.tn.lib.util.networkinfo.g
    public void onDisconnected() {
        f fVar;
        uo.b.a.g(uo.b.f78622a, "MusicTrailerV2Fragment --> onDisconnected()", false, 2, null);
        if (this.f53698n != 10 || (fVar = this.f53703s) == null || fVar.isPlaying()) {
            return;
        }
        s1(500L);
    }

    @Override // com.transsion.player.orplayer.e
    public void onFocusChange(boolean z11) {
        e.a.f(this, z11);
    }

    @Override // com.transsion.player.orplayer.e
    public void onIsPlayingChanged(boolean z11) {
        e.a.g(this, z11);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingBegin(MediaSource mediaSource) {
        Group group;
        e.a.h(this, mediaSource);
        uo.b.a.g(uo.b.f78622a, "MusicTrailerV2Fragment --> onLoadingBegin()", false, 2, null);
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            s1(1000L);
            return;
        }
        j mViewBinding = getMViewBinding();
        if (mViewBinding != null && (group = mViewBinding.f77510b) != null) {
            so.c.k(group);
        }
        c1().post(this.f53708x);
        View view = this.f53702r;
        if (view != null) {
            so.c.g(view);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingEnd(MediaSource mediaSource) {
        Group group;
        e.a.j(this, mediaSource);
        uo.b.a.g(uo.b.f78622a, "MusicTrailerV2Fragment --> onLoadingEnd()", false, 2, null);
        j mViewBinding = getMViewBinding();
        if (mViewBinding != null && (group = mViewBinding.f77510b) != null) {
            so.c.g(group);
        }
        View view = this.f53702r;
        if (view != null) {
            so.c.g(view);
        }
        c1().removeCallbacks(this.f53708x);
        c1().removeCallbacks(this.f53705u);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingProgress(int i11, float f11, MediaSource mediaSource) {
        e.a.l(this, i11, f11, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoopingStart() {
        e.a.n(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onMediaItemTransition(String str) {
        e.a.o(this, str);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayError(PlayError errorInfo, MediaSource mediaSource) {
        Intrinsics.g(errorInfo, "errorInfo");
        e.a.p(this, errorInfo, mediaSource);
        uo.b.a.g(uo.b.f78622a, "MusicTrailerV2Fragment --> onPlayError() --> errorInfo.errorCode = " + errorInfo.getErrorCode(), false, 2, null);
        Integer errorCode = errorInfo.getErrorCode();
        if (errorCode != null && errorCode.intValue() == 537067524) {
            if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
                r1(1);
            } else {
                s1(500L);
            }
        }
        this.f53701q = errorInfo;
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerRelease(MediaSource mediaSource) {
        e.a.s(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerReset() {
        e.a.u(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPrepare(MediaSource mediaSource) {
        e.a.v(this, mediaSource);
        f fVar = this.f53703s;
        if (fVar != null) {
            fVar.play();
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onProgress(long j11, MediaSource mediaSource) {
        SecondariesSeekBar secondariesSeekBar;
        f fVar;
        e.a.x(this, j11, mediaSource);
        j mViewBinding = getMViewBinding();
        Group group = mViewBinding != null ? mViewBinding.f77510b : null;
        if (group != null) {
            group.setVisibility(8);
        }
        if (this.f53697m) {
            return;
        }
        this.f53700p = j11;
        if (this.f53696l <= 0 && (fVar = this.f53703s) != null) {
            this.f53696l = fVar.getDuration();
        }
        String str = com.transsion.postdetail.util.i.d(j11) + "/" + com.transsion.postdetail.util.i.d(this.f53696l);
        j mViewBinding2 = getMViewBinding();
        TextView textView = mViewBinding2 != null ? mViewBinding2.f77520m : null;
        if (textView != null) {
            textView.setText(str);
        }
        j mViewBinding3 = getMViewBinding();
        if (mViewBinding3 == null || (secondariesSeekBar = mViewBinding3.f77519l) == null) {
            return;
        }
        secondariesSeekBar.setProgress((j11 * ((long) 100)) / this.f53696l);
    }

    @Override // com.transsion.player.orplayer.e
    public void onRenderFirstFrame() {
        e.a.z(this);
        uo.b.a.g(uo.b.f78622a, "MusicTrailerV2Fragment --> onRenderFirstFrame()", false, 2, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // com.transsion.player.orplayer.e
    public void onSetDataSource() {
        e.a.A(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        AppCompatImageView appCompatImageView;
        super.onStop();
        Activity activityB = com.blankj.utilcode.util.a.b();
        uo.b.a.g(uo.b.f78622a, "zxb_lob --> topActivity = " + activityB, false, 2, null);
        if (activityB != null) {
            String simpleName = activityB.getClass().getSimpleName();
            Intrinsics.f(simpleName, "topActivity.javaClass.simpleName");
            if (StringsKt__StringsKt.Q(simpleName, "LocalVideoDetailActivity", false, 2, null)) {
                this.f53698n = 0;
                j mViewBinding = getMViewBinding();
                if (mViewBinding != null && (appCompatImageView = mViewBinding.f77518k) != null) {
                    appCompatImageView.setImageResource(R$drawable.post_icon_play);
                }
                j mViewBinding2 = getMViewBinding();
                AppCompatImageView appCompatImageView2 = mViewBinding2 != null ? mViewBinding2.f77518k : null;
                if (appCompatImageView2 == null) {
                    return;
                }
                appCompatImageView2.setKeepScreenOn(false);
            }
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksAudioBitrateChange(int i11) {
        e.a.B(this, i11);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksChange(ov.c cVar) {
        e.a.C(this, cVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksVideoBitrateChange(int i11) {
        e.a.D(this, i11);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoPause(MediaSource mediaSource) {
        AppCompatImageView appCompatImageView;
        e.a.E(this, mediaSource);
        uo.b.a.g(uo.b.f78622a, "MusicTrailerV2Fragment --> onVideoPause()", false, 2, null);
        this.f53698n = 20;
        j mViewBinding = getMViewBinding();
        if (mViewBinding != null && (appCompatImageView = mViewBinding.f77518k) != null) {
            appCompatImageView.setImageResource(R$drawable.post_icon_play);
        }
        j mViewBinding2 = getMViewBinding();
        AppCompatImageView appCompatImageView2 = mViewBinding2 != null ? mViewBinding2.f77518k : null;
        if (appCompatImageView2 == null) {
            return;
        }
        appCompatImageView2.setKeepScreenOn(false);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoSizeChanged(int i11, int i12) {
        e.a.G(this, i11, i12);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoStart(MediaSource mediaSource) {
        e.a.H(this, mediaSource);
        uo.b.a.g(uo.b.f78622a, "MusicTrailerV2Fragment --> onVideoStart()", false, 2, null);
        j mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            Group groupLoading = mViewBinding.f77510b;
            Intrinsics.f(groupLoading, "groupLoading");
            so.c.g(groupLoading);
            mViewBinding.f77518k.setImageResource(R$drawable.post_icon_pause);
            mViewBinding.f77518k.setKeepScreenOn(true);
            v1(false);
        }
    }

    public final void p1() {
        uo.b.a.g(uo.b.f78622a, "MusicTrailerV2Fragment --> reloadVideo() --> video error，reload~~", false, 2, null);
        this.f53699o = 0L;
        f fVar = this.f53703s;
        if (fVar != null) {
            fVar.stop();
            fVar.reset();
            fVar.prepare();
        }
        f fVar2 = this.f53703s;
        if (fVar2 != null) {
            fVar2.seekTo(this.f53700p);
        }
        w1(this, false, 1, null);
    }

    public final void r1(int i11) {
        AppCompatImageView appCompatImageView;
        Group group;
        ShapeableImageView shapeableImageView;
        ShapeableImageView shapeableImageView2;
        ViewStub viewStub;
        if (this.f53702r == null) {
            j mViewBinding = getMViewBinding();
            this.f53702r = (mViewBinding == null || (viewStub = mViewBinding.f77521n) == null) ? null : viewStub.inflate();
        }
        if (i11 == 1) {
            Intrinsics.f(Utils.a().getString(R$string.downloading_play_timeout), "getApp()\n               …downloading_play_timeout)");
            Intrinsics.f(Utils.a().getString(R$string.downloading_play_timeout_reload), "getApp()\n               …ding_play_timeout_reload)");
            this.f53698n = -1;
        } else {
            Intrinsics.f(Utils.a().getString(R$string.downloading_play_load_failed), "getApp()\n               …loading_play_load_failed)");
            Intrinsics.f(Utils.a().getString(R$string.turn_on_network), "getApp().getString(com.t…R.string.turn_on_network)");
            this.f53698n = 22;
        }
        f fVar = this.f53703s;
        if (fVar != null) {
            fVar.pause();
        }
        j mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (shapeableImageView2 = mViewBinding2.f77512d) != null) {
            so.c.k(shapeableImageView2);
        }
        j mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (shapeableImageView = mViewBinding3.f77513f) != null) {
            so.c.g(shapeableImageView);
        }
        j mViewBinding4 = getMViewBinding();
        if (mViewBinding4 != null && (group = mViewBinding4.f77510b) != null) {
            so.c.g(group);
        }
        View view = this.f53702r;
        if (view != null) {
            so.c.k(view);
        }
        View view2 = this.f53702r;
        if (view2 != null) {
            view2.setTag(Integer.valueOf(i11));
        }
        j mViewBinding5 = getMViewBinding();
        if (mViewBinding5 != null && (appCompatImageView = mViewBinding5.f77518k) != null) {
            appCompatImageView.setImageResource(R$drawable.post_icon_play);
        }
        j mViewBinding6 = getMViewBinding();
        AppCompatImageView appCompatImageView2 = mViewBinding6 != null ? mViewBinding6.f77518k : null;
        if (appCompatImageView2 == null) {
            return;
        }
        appCompatImageView2.setKeepScreenOn(false);
    }

    public final void s1(long j11) {
        c1().removeCallbacks(this.f53705u);
        c1().postDelayed(this.f53705u, j11);
    }

    @Override // com.transsion.player.orplayer.e
    public void setOnSeekCompleteListener() {
        e.a.J(this);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    public final void u1() {
        ShapeableImageView shapeableImageView;
        String url;
        Cover cover;
        Cover cover2;
        String thumbnail;
        PreVideoAddress videoAddress;
        Integer duration;
        SecondariesSeekBar secondariesSeekBar;
        if (!isAdded() || getActivity() == null) {
            return;
        }
        j mViewBinding = getMViewBinding();
        if (mViewBinding != null && (secondariesSeekBar = mViewBinding.f77519l) != null) {
            secondariesSeekBar.setMax(100L);
        }
        Trailer trailer = this.f53695k;
        long jIntValue = (trailer == null || (videoAddress = trailer.getVideoAddress()) == null || (duration = videoAddress.getDuration()) == null) ? 0L : duration.intValue() * 1000;
        this.f53696l = jIntValue;
        if (jIntValue > 0) {
            String str = "00:00/" + com.transsion.postdetail.util.i.d(jIntValue);
            j mViewBinding2 = getMViewBinding();
            TextView textView = mViewBinding2 != null ? mViewBinding2.f77520m : null;
            if (textView != null) {
                textView.setText(str);
            }
        }
        Trailer trailer2 = this.f53695k;
        BlurHashHelper.b(BlurHashHelper.f51391a, (trailer2 == null || (cover2 = trailer2.getCover()) == null || (thumbnail = cover2.getThumbnail()) == null) ? "" : thumbnail, 0, 0, new Function1<BitmapDrawable, Unit>() { // from class: com.transsion.moviedetail.music.MusicTrailerV2Fragment$showMusicInfo$2
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
                ShapeableImageView shapeableImageView2;
                Intrinsics.g(it, "it");
                j mViewBinding3 = this.this$0.getMViewBinding();
                if (mViewBinding3 == null || (shapeableImageView2 = mViewBinding3.f77512d) == null) {
                    return;
                }
                shapeableImageView2.setImageDrawable(it);
            }
        }, 6, null);
        j mViewBinding3 = getMViewBinding();
        if (mViewBinding3 == null || (shapeableImageView = mViewBinding3.f77513f) == null) {
            return;
        }
        shapeableImageView.setVisibility(0);
        RequestManager requestManagerWith = Glide.with(requireContext());
        ImageHelper.Companion companion = ImageHelper.f51371a;
        Trailer trailer3 = this.f53695k;
        if (trailer3 == null || (cover = trailer3.getCover()) == null || (url = cover.getUrl()) == null) {
            url = "";
        }
        requestManagerWith.load2(companion.e(url, (124 & 2) != 0 ? 0 : com.transsion.core.utils.e.f(), (124 & 4) != 0 ? 0 : 0, (124 & 8) != 0, (124 & 16) != 0 ? false : false, (124 & 32) == 0 ? false : false, (124 & 64) != 0 ? 25 : 0)).into(shapeableImageView);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        String subjectId;
        a1();
        Trailer trailer = this.f53695k;
        if (trailer == null || (subjectId = trailer.getSubjectId()) == null) {
            return;
        }
        TnPlayerManager tnPlayerManager = TnPlayerManager.f54684a;
        f fVarA = tnPlayerManager.a(subjectId);
        if (fVarA == null) {
            fVarA = tnPlayerManager.i();
        } else if (fVarA.isPlaying()) {
            v1(false);
        }
        fVarA.addPlayerListener(this);
        this.f53703s = fVarA;
    }

    public final void v1(boolean z11) {
        AppCompatImageView appCompatImageView;
        Group group;
        AppCompatImageView appCompatImageView2;
        Group group2;
        f fVar;
        this.f53698n = 10;
        this.f53701q = null;
        if (z11 && (fVar = this.f53703s) != null) {
            fVar.play();
        }
        j mViewBinding = getMViewBinding();
        if (mViewBinding != null && (group2 = mViewBinding.f77510b) != null) {
            so.c.k(group2);
        }
        View view = this.f53702r;
        if (view != null) {
            so.c.g(view);
        }
        j mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (appCompatImageView2 = mViewBinding2.f77514g) != null) {
            so.c.g(appCompatImageView2);
        }
        j mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (group = mViewBinding3.f77511c) != null) {
            so.c.k(group);
        }
        j mViewBinding4 = getMViewBinding();
        if (mViewBinding4 != null && (appCompatImageView = mViewBinding4.f77518k) != null) {
            appCompatImageView.setImageResource(R$drawable.post_icon_pause);
        }
        c1().removeCallbacks(this.f53705u);
        u1();
    }
}
