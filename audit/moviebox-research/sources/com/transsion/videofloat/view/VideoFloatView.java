package com.transsion.videofloat.view;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.view.ViewCompat;
import com.avery.subtitle.widget.SimpleSubtitleView;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.d0;
import com.blankj.utilcode.util.f0;
import com.google.android.material.card.MaterialCardView;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.tn.lib.widget.R$color;
import com.transsion.baselib.helper.LocalVideoPlayerConfigMmkv;
import com.transsion.player.MediaSource;
import com.transsion.player.config.RenderType;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.global.TnPlayerType;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.videofloat.R$layout;
import com.transsion.videofloat.bean.FloatPlayType;
import com.transsion.videofloat.manager.VideoFloatSubtitleControl;
import com.transsion.videofloat.manager.v;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

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
public final class VideoFloatView extends ConstraintLayout implements com.transsion.player.orplayer.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wz.b f60113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FloatPlayType f60114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f60115c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f60116d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f60117f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f60118g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final WindowManager f60119h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public WindowManager.LayoutParams f60120i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public yz.a f60121j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.transsion.player.orplayer.f f60122k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ORPlayerView f60123l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public vz.a f60124m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public VideoFloatSubtitleControl f60125n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public com.transsion.videofloat.manager.d f60126o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Handler f60127p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public a f60128q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f60129r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final xz.a f60130s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Runnable f60131t;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public final class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function1<Boolean, Unit> f60132a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f60133b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ VideoFloatView f60134c;

        /* JADX WARN: Multi-variable type inference failed */
        public a(VideoFloatView videoFloatView, Function1<? super Boolean, Unit> callback) {
            Intrinsics.g(callback, "callback");
            this.f60134c = videoFloatView;
            this.f60132a = callback;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intrinsics.g(context, "context");
            Intrinsics.g(intent, "intent");
            String action = intent.getAction();
            if (action != null) {
                int iHashCode = action.hashCode();
                if (iHashCode == -2128145023) {
                    if (action.equals("android.intent.action.SCREEN_OFF")) {
                        this.f60133b = true;
                        this.f60132a.invoke(Boolean.TRUE);
                        uo.b.a.f(uo.b.f78622a, "VideoFloat", "Screen off", false, 4, null);
                        return;
                    }
                    return;
                }
                if (iHashCode == 823795052 && action.equals("android.intent.action.USER_PRESENT")) {
                    this.f60133b = false;
                    this.f60132a.invoke(Boolean.FALSE);
                    uo.b.a.f(uo.b.f78622a, "VideoFloat", "User present", false, 4, null);
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements xz.c {
        public b() {
        }

        @Override // xz.c
        public void a() {
            VideoFloatView.this.x();
        }

        @Override // xz.c
        public void b(float f11, float f12) {
            WindowManager.LayoutParams layoutParams = VideoFloatView.this.f60120i;
            if (layoutParams != null) {
                VideoFloatView videoFloatView = VideoFloatView.this;
                layoutParams.x += (int) f11;
                layoutParams.y += (int) f12;
                int i11 = videoFloatView.f60117f - layoutParams.width;
                int i12 = videoFloatView.f60118g - layoutParams.height;
                int i13 = layoutParams.x;
                if (i11 <= 0) {
                    i11 = 0;
                }
                layoutParams.x = kotlin.ranges.a.k(i13, 0, i11);
                int i14 = layoutParams.y;
                if (i12 <= 0) {
                    i12 = 0;
                }
                layoutParams.y = kotlin.ranges.a.k(i14, 0, i12);
                videoFloatView.f60119h.updateViewLayout(videoFloatView, layoutParams);
            }
        }

        @Override // xz.c
        public void onScale(ScaleGestureDetector detector) {
            Intrinsics.g(detector, "detector");
            WindowManager.LayoutParams layoutParams = VideoFloatView.this.f60120i;
            if (layoutParams != null) {
                VideoFloatView videoFloatView = VideoFloatView.this;
                int scaleFactor = (int) (layoutParams.width * detector.getScaleFactor());
                layoutParams.width = scaleFactor;
                if (scaleFactor > videoFloatView.f60117f) {
                    layoutParams.width = videoFloatView.f60117f;
                }
                if (layoutParams.width < videoFloatView.f60115c) {
                    layoutParams.width = videoFloatView.f60115c;
                }
                videoFloatView.C(layoutParams.width);
                vz.a aVar = videoFloatView.f60124m;
                layoutParams.height = (aVar != null ? aVar.h() : null) == FloatPlayType.SHORT_TV ? (layoutParams.width * 16) / 9 : (layoutParams.width * 9) / 16;
                videoFloatView.f60119h.updateViewLayout(videoFloatView, layoutParams);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoFloatView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoFloatView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoFloatView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        Object systemService = context.getSystemService("window");
        Intrinsics.e(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        this.f60119h = (WindowManager) systemService;
        this.f60127p = new Handler(Looper.getMainLooper());
        this.f60130s = new xz.a(context, new b());
        View.inflate(getContext(), R$layout.view_video_float, this);
        wz.b bVarA = wz.b.a(this);
        Intrinsics.f(bVarA, "bind(this)");
        this.f60113a = bVarA;
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        n();
        this.f60131t = new Runnable() { // from class: com.transsion.videofloat.view.a
            @Override // java.lang.Runnable
            public final void run() {
                VideoFloatView.i(this.f60136a);
            }
        };
    }

    public static final void i(VideoFloatView this$0) {
        Intrinsics.g(this$0, "this$0");
        Group group = this$0.f60113a.f79773c;
        Intrinsics.f(group, "viewBinding.groupControl");
        so.c.g(group);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void n() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.transsion.videofloat.view.b
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return VideoFloatView.o(this.f60137a, view, motionEvent);
            }
        });
        this.f60113a.f79777h.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.videofloat.view.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoFloatView.p(this.f60138a, view);
            }
        });
        this.f60113a.f79775f.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.videofloat.view.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoFloatView.q(this.f60139a, view);
            }
        });
        this.f60113a.f79778i.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.videofloat.view.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoFloatView.r(this.f60140a, view);
            }
        });
        this.f60113a.f79774d.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.videofloat.view.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoFloatView.s(this.f60141a, view);
            }
        });
        this.f60113a.f79776g.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.videofloat.view.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoFloatView.t(this.f60142a, view);
            }
        });
    }

    public static final boolean o(VideoFloatView this$0, View view, MotionEvent event) {
        Intrinsics.g(this$0, "this$0");
        xz.a aVar = this$0.f60130s;
        Intrinsics.f(event, "event");
        return aVar.d(event);
    }

    public static final void p(VideoFloatView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.v();
    }

    public static final void q(VideoFloatView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.u();
    }

    public static final void r(VideoFloatView this$0, View it) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.f(it, "it");
        this$0.w(it);
    }

    public static final void s(VideoFloatView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.j(false);
    }

    private final void setForwardStatus(boolean z11) {
        if (!this.f60113a.f79776g.isClickable() || z11) {
            this.f60113a.f79776g.setClickable(!z11);
            this.f60113a.f79776g.setImageTintList(ColorStateList.valueOf(z2.a.getColor(getContext(), z11 ? R$color.gray_dark_50 : R$color.white)));
        }
    }

    public static final void t(VideoFloatView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.j(true);
    }

    private final void w(View view) {
        com.transsion.player.orplayer.f fVar;
        com.transsion.player.orplayer.f fVar2 = this.f60122k;
        if (fVar2 != null && fVar2.isPlaying()) {
            this.f60129r = true;
            com.transsion.player.orplayer.f fVar3 = this.f60122k;
            if (fVar3 != null) {
                fVar3.pause();
            }
            view.setSelected(true);
            B(false);
            return;
        }
        com.transsion.player.orplayer.f fVar4 = this.f60122k;
        if (fVar4 != null && fVar4.isComplete() && (fVar = this.f60122k) != null) {
            fVar.seekTo(0L);
        }
        com.transsion.player.orplayer.f fVar5 = this.f60122k;
        if (fVar5 != null) {
            fVar5.play();
        }
        view.setSelected(false);
        setForwardStatus(false);
        B(true);
    }

    public final void A() {
        this.f60113a.f79778i.setSelected(true);
        B(false);
        setForwardStatus(true);
    }

    public final void B(boolean z11) {
        Group group = this.f60113a.f79773c;
        Intrinsics.f(group, "viewBinding.groupControl");
        so.c.k(group);
        if (z11) {
            k(false);
        } else {
            this.f60127p.removeCallbacks(this.f60131t);
        }
    }

    public final void C(int i11) {
        this.f60113a.f79779j.setTextSize(kotlin.ranges.a.f(((i11 * 1.0f) / this.f60116d) * 12.0f, 16.0f));
    }

    public final void addToWindow(boolean z11, vz.a floatBean) {
        Intrinsics.g(floatBean, "floatBean");
        uo.b.f78622a.n("VideoFloat", new String[]{"VideoFloatView--addToWindow"}, true);
        m(floatBean);
        l(floatBean);
        this.f60122k = floatBean.e();
        this.f60124m = floatBean;
        B(true);
        com.transsion.player.orplayer.f fVar = this.f60122k;
        if (fVar != null) {
            fVar.addPlayerListener(this);
        }
        if (!floatBean.e().isPlaying()) {
            floatBean.e().play();
        }
        z(floatBean);
        try {
            Result.Companion companion = Result.Companion;
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            ORPlayerView oRPlayerView = new ORPlayerView(applicationA, RenderType.SURFACE_VIEW);
            oRPlayerView.setKeepScreenOn(true);
            com.transsion.player.orplayer.f fVar2 = this.f60122k;
            if (fVar2 != null) {
                fVar2.setSurfaceView(oRPlayerView.getSurface());
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.f60113a.f79772b.removeAllViews();
            this.f60113a.f79772b.addView(oRPlayerView, layoutParams);
            this.f60119h.addView(this, this.f60120i);
            y();
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    public final vz.a getFloatBean() {
        return this.f60124m;
    }

    public final com.transsion.player.orplayer.f getPlayer() {
        return this.f60122k;
    }

    @Override // com.transsion.player.orplayer.e
    public void initPlayer() {
        com.transsion.player.orplayer.e.a.a(this);
    }

    public final boolean isPlaying() {
        com.transsion.player.orplayer.f fVar = this.f60122k;
        if (fVar != null) {
            return fVar.isPlaying();
        }
        return false;
    }

    public final void j(boolean z11) {
        long jE;
        uo.b.f78622a.c("VideoFloat", "VideoFloatView--forwardOrBackward :" + z11, true);
        if (z11) {
            com.transsion.player.orplayer.f fVar = this.f60122k;
            long currentPosition = (fVar != null ? fVar.getCurrentPosition() : 0L) + ((long) 10000);
            com.transsion.player.orplayer.f fVar2 = this.f60122k;
            jE = kotlin.ranges.a.h(currentPosition, fVar2 != null ? fVar2.getDuration() : 0L);
        } else {
            setForwardStatus(false);
            com.transsion.player.orplayer.f fVar3 = this.f60122k;
            jE = kotlin.ranges.a.e(0L, (fVar3 != null ? fVar3.getCurrentPosition() : 0L) - ((long) 10000));
        }
        com.transsion.player.orplayer.f fVar4 = this.f60122k;
        if (fVar4 != null) {
            fVar4.seekTo(jE);
        }
    }

    public final void k(boolean z11) {
        if (!z11) {
            this.f60127p.removeCallbacks(this.f60131t);
            this.f60127p.postDelayed(this.f60131t, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
        } else {
            Group group = this.f60113a.f79773c;
            Intrinsics.f(group, "viewBinding.groupControl");
            so.c.g(group);
        }
    }

    public final void l(vz.a aVar) {
        com.transsion.videofloat.manager.d dVar = new com.transsion.videofloat.manager.d(aVar, aVar.e().isPrepared());
        dVar.d();
        dVar.a();
        String strI = aVar.i();
        if (strI == null) {
            strI = "";
        }
        dVar.p(strI);
        dVar.n();
        this.f60126o = dVar;
    }

    public final void m(vz.a aVar) {
        SimpleSubtitleView simpleSubtitleView = this.f60113a.f79779j;
        Intrinsics.f(simpleSubtitleView, "viewBinding.vSubtitle");
        VideoFloatSubtitleControl videoFloatSubtitleControl = new VideoFloatSubtitleControl(simpleSubtitleView, aVar);
        videoFloatSubtitleControl.t(LocalVideoPlayerConfigMmkv.f51172a.c());
        this.f60125n = videoFloatSubtitleControl;
    }

    @Override // com.transsion.player.orplayer.e
    public void onAliyunDecodeErrorChangeSoftwareDecoder(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.b(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onBufferedPosition(long j11, MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.c(this, j11, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onCompletion(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.d(this, mediaSource);
        com.transsion.videofloat.manager.d dVar = this.f60126o;
        if (dVar != null) {
            dVar.e();
        }
        yz.a aVar = this.f60121j;
        if (aVar != null && aVar.b(this.f60124m)) {
            com.transsion.videofloat.manager.d dVar2 = this.f60126o;
            if (dVar2 != null) {
                dVar2.a();
            }
            uo.b.a aVar2 = uo.b.f78622a;
            vz.a aVar3 = this.f60124m;
            uo.b.a.f(aVar2, "VideoFloat", "VideoFloatView--onCompletion curEp:" + (aVar3 != null ? Integer.valueOf(aVar3.b()) : null) + ", play next", false, 4, null);
            return;
        }
        uo.b.a aVar4 = uo.b.f78622a;
        vz.a aVar5 = this.f60124m;
        uo.b.a.f(aVar4, "VideoFloat", "VideoFloatView--onCompletion curEp:" + (aVar5 != null ? Integer.valueOf(aVar5.b()) : null) + ",no next", false, 4, null);
        com.transsion.videofloat.manager.d dVar3 = this.f60126o;
        if (dVar3 != null) {
            dVar3.b();
        }
        A();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Intrinsics.g(canvas, "canvas");
        super.onDraw(canvas);
        this.f60117f = d0.e();
        this.f60118g = d0.c();
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
        com.transsion.player.orplayer.e.a.h(this, mediaSource);
        com.transsion.videofloat.manager.d dVar = this.f60126o;
        if (dVar != null) {
            dVar.f();
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingEnd(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.j(this, mediaSource);
        com.transsion.videofloat.manager.d dVar = this.f60126o;
        if (dVar != null) {
            dVar.g();
        }
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
        com.transsion.videofloat.manager.d dVar = this.f60126o;
        if (dVar != null) {
            dVar.e();
        }
        yz.a aVar = this.f60121j;
        if (aVar != null && aVar.b(this.f60124m)) {
            uo.b.a aVar2 = uo.b.f78622a;
            vz.a aVar3 = this.f60124m;
            uo.b.a.f(aVar2, "VideoFloat", "VideoFloatView--onMediaItemTransition curEp:" + (aVar3 != null ? Integer.valueOf(aVar3.b()) : null) + ", play next", false, 4, null);
            return;
        }
        uo.b.a aVar4 = uo.b.f78622a;
        vz.a aVar5 = this.f60124m;
        uo.b.a.f(aVar4, "VideoFloat", "VideoFloatView--onMediaItemTransition curEp:" + (aVar5 != null ? Integer.valueOf(aVar5.b()) : null) + ",no next", false, 4, null);
        A();
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayError(PlayError playError, MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.p(this, playError, mediaSource);
    }

    public void onPlayErrorChangePayer(TnPlayerType tnPlayerType, MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.r(this, tnPlayerType, mediaSource);
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
        String strJ;
        com.transsion.videofloat.manager.d dVar;
        com.transsion.player.orplayer.e.a.x(this, j11, mediaSource);
        if (mediaSource != null && (strJ = mediaSource.j()) != null && (dVar = this.f60126o) != null) {
            dVar.r(strJ);
        }
        com.transsion.videofloat.manager.d dVar2 = this.f60126o;
        if (dVar2 != null) {
            dVar2.h(j11);
        }
        vz.a aVar = this.f60124m;
        if (aVar != null) {
            aVar.C(j11);
        }
        VideoFloatSubtitleControl videoFloatSubtitleControl = this.f60125n;
        if (videoFloatSubtitleControl == null) {
            return;
        }
        videoFloatSubtitleControl.r(j11);
    }

    @Override // com.transsion.player.orplayer.e
    public void onRenderFirstFrame() {
        com.transsion.player.orplayer.e.a.z(this);
        com.transsion.videofloat.manager.d dVar = this.f60126o;
        if (dVar != null) {
            dVar.i();
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onSetDataSource() {
        com.transsion.player.orplayer.e.a.A(this);
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
        com.transsion.player.orplayer.e.a.E(this, mediaSource);
        this.f60113a.f79778i.setSelected(true);
        VideoFloatSubtitleControl videoFloatSubtitleControl = this.f60125n;
        if (videoFloatSubtitleControl != null) {
            videoFloatSubtitleControl.s(false);
        }
        VideoFloatSubtitleControl videoFloatSubtitleControl2 = this.f60125n;
        if (videoFloatSubtitleControl2 != null) {
            videoFloatSubtitleControl2.n();
        }
        com.transsion.videofloat.manager.d dVar = this.f60126o;
        if (dVar != null) {
            dVar.j();
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoSizeChanged(int i11, int i12) {
        com.transsion.player.orplayer.e.a.G(this, i11, i12);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoStart(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.H(this, mediaSource);
        this.f60113a.f79778i.setSelected(false);
        VideoFloatSubtitleControl videoFloatSubtitleControl = this.f60125n;
        if (videoFloatSubtitleControl != null) {
            videoFloatSubtitleControl.s(true);
        }
        VideoFloatSubtitleControl videoFloatSubtitleControl2 = this.f60125n;
        if (videoFloatSubtitleControl2 != null) {
            videoFloatSubtitleControl2.p();
        }
        com.transsion.videofloat.manager.d dVar = this.f60126o;
        if (dVar != null) {
            dVar.k();
        }
    }

    public final void removeFromWindow() {
        uo.b.f78622a.t("VideoFloat", "VideoFloatView--removeFromWindow", true);
        VideoFloatSubtitleControl videoFloatSubtitleControl = this.f60125n;
        if (videoFloatSubtitleControl != null) {
            videoFloatSubtitleControl.o();
        }
        this.f60125n = null;
        com.transsion.videofloat.manager.d dVar = this.f60126o;
        if (dVar != null) {
            dVar.b();
        }
        this.f60126o = null;
        com.transsion.player.orplayer.f fVar = this.f60122k;
        if (fVar != null) {
            fVar.removePlayerListener(this);
        }
        try {
            Result.Companion companion = Result.Companion;
            ORPlayerView oRPlayerView = this.f60123l;
            if (oRPlayerView != null) {
                oRPlayerView.setKeepScreenOn(false);
            }
            this.f60119h.removeViewImmediate(this);
            getContext().unregisterReceiver(this.f60128q);
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void setOnSeekCompleteListener() {
        com.transsion.player.orplayer.e.a.J(this);
    }

    public final void setVideoFloatListener(yz.a listener) {
        Intrinsics.g(listener, "listener");
        this.f60121j = listener;
    }

    public final void u() {
        com.transsion.videofloat.manager.d dVar = this.f60126o;
        if (dVar != null) {
            dVar.m();
        }
        removeFromWindow();
        v.f60111a.d();
        com.transsion.player.orplayer.f fVar = this.f60122k;
        if (fVar != null) {
            fVar.stop();
        }
        com.transsion.player.orplayer.f fVar2 = this.f60122k;
        if (fVar2 != null) {
            fVar2.release();
        }
        yz.a aVar = this.f60121j;
        if (aVar != null) {
            aVar.a(this.f60124m);
        }
    }

    public final void v() {
        com.transsion.videofloat.manager.d dVar = this.f60126o;
        if (dVar != null) {
            dVar.l();
        }
        yz.a aVar = this.f60121j;
        if (aVar != null) {
            aVar.c(this.f60124m);
        }
        removeFromWindow();
    }

    public final void x() {
        Group group = this.f60113a.f79773c;
        Intrinsics.f(group, "viewBinding.groupControl");
        if (so.c.i(group)) {
            k(true);
        } else {
            B(true);
        }
    }

    public final void y() {
        this.f60128q = new a(this, new Function1<Boolean, Unit>() { // from class: com.transsion.videofloat.view.VideoFloatView$registerScreenStateReceiver$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.f68710a;
            }

            public final void invoke(boolean z11) {
                com.transsion.player.orplayer.f fVar;
                if (z11) {
                    com.transsion.player.orplayer.f fVar2 = this.this$0.f60122k;
                    if (fVar2 != null) {
                        fVar2.pause();
                        return;
                    }
                    return;
                }
                if (this.this$0.f60129r || (fVar = this.this$0.f60122k) == null) {
                    return;
                }
                fVar.play();
            }
        });
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        try {
            Result.Companion companion = Result.Companion;
            Result.m163constructorimpl(Build.VERSION.SDK_INT >= 33 ? getContext().registerReceiver(this.f60128q, intentFilter, 2) : getContext().registerReceiver(this.f60128q, intentFilter));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    public final void z(vz.a aVar) {
        if (this.f60114b == aVar.h()) {
            return;
        }
        this.f60117f = d0.e();
        int iC = d0.c();
        this.f60118g = iC;
        int i11 = this.f60117f;
        if (i11 > iC) {
            this.f60117f = iC;
            this.f60118g = i11;
        }
        FloatPlayType floatPlayTypeH = aVar.h();
        FloatPlayType floatPlayType = FloatPlayType.SHORT_TV;
        this.f60115c = floatPlayTypeH == floatPlayType ? f0.a(120.0f) : f0.a(180.0f);
        int iA = aVar.h() == floatPlayType ? f0.a(120.0f) : f0.a(180.0f);
        this.f60116d = iA;
        int i12 = aVar.h() == floatPlayType ? (iA * 16) / 9 : (iA * 9) / 16;
        int iA2 = (this.f60117f - iA) - f0.a(12.0f);
        int iA3 = ((this.f60118g - i12) - f0.a(64.0f)) - com.blankj.utilcode.util.d.c();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = Build.VERSION.SDK_INT >= 26 ? 2038 : 2003;
        layoutParams.format = -3;
        layoutParams.flags = 40;
        layoutParams.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_TOP_START;
        layoutParams.width = iA;
        layoutParams.height = i12;
        layoutParams.x = iA2;
        layoutParams.y = iA3;
        this.f60120i = layoutParams;
        ViewGroup.LayoutParams layoutParams2 = this.f60113a.f79772b.getLayoutParams();
        ConstraintLayout.b bVar = layoutParams2 instanceof ConstraintLayout.b ? (ConstraintLayout.b) layoutParams2 : null;
        if (bVar != null) {
            bVar.I = aVar.h() == floatPlayType ? "h,9:16" : "h,16:9";
        } else {
            bVar = new ConstraintLayout.b(0, 0);
            bVar.I = aVar.h() == floatPlayType ? "h,9:16" : "h,16:9";
        }
        this.f60113a.f79772b.setLayoutParams(bVar);
        this.f60114b = aVar.h();
    }
}
