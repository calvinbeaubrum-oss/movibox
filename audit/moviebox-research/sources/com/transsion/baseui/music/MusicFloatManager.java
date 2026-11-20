package com.transsion.baseui.music;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.h0;
import com.google.android.material.card.MaterialCardView;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.transsion.baseui.activity.BaseMusicFloatActivity;
import com.transsion.player.MediaSource;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.player.orplayer.PlayError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;

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
public final class MusicFloatManager implements com.transsion.player.orplayer.e {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f51403i = new a(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f51404j = 8;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Lazy<MusicFloatManager> f51405k = LazyKt__LazyJVMKt.b(new Function0<MusicFloatManager>() { // from class: com.transsion.baseui.music.MusicFloatManager$Companion$INSTANCE$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MusicFloatManager invoke() {
            return new MusicFloatManager();
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MediaItem f51407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f51408c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.transsion.player.orplayer.f f51410f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, k> f51412h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f51406a = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CopyOnWriteArrayList<com.transsion.player.orplayer.e> f51409d = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<String> f51411g = new ArrayList();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MusicFloatManager a() {
            return (MusicFloatManager) MusicFloatManager.f51405k.getValue();
        }

        public final MusicFloatManager b() {
            return a();
        }
    }

    /* JADX INFO: renamed from: com.transsion.baseui.music.MusicFloatManager$onPlayerRelease$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.baseui.music.MusicFloatManager$onPlayerRelease$1", f = "MusicFloatManager.kt", l = {}, m = "invokeSuspend")
    @SourceDebugExtension
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ MediaSource $mediaSource;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(MediaSource mediaSource, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$mediaSource = mediaSource;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MusicFloatManager.this.new AnonymousClass1(this.$mediaSource, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            MediaItem mediaItemH;
            kotlin.coroutines.intrinsics.a.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            com.transsion.player.mediasession.d dVar = com.transsion.player.mediasession.d.f54622a;
            String strN = MusicFloatManager.this.n();
            MediaSource mediaSource = this.$mediaSource;
            dVar.a(strN + " --> onPlayerRelease() --> subjectId = " + ((mediaSource == null || (mediaItemH = mediaSource.h()) == null) ? null : mediaItemH.getSubjectId()));
            com.transsion.player.orplayer.f fVar = MusicFloatManager.this.f51410f;
            if (fVar != null) {
                fVar.removePlayerListener(MusicFloatManager.this);
            }
            MusicFloatManager.this.f51410f = null;
            CopyOnWriteArrayList copyOnWriteArrayList = MusicFloatManager.this.f51409d;
            MediaSource mediaSource2 = this.$mediaSource;
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                ((com.transsion.player.orplayer.e) it.next()).onPlayerRelease(mediaSource2);
            }
            MusicFloatManager.this.z(null);
            MusicFloatManager.this.A(null);
            MusicReport.f51422a.c();
            return Unit.f68710a;
        }
    }

    public MusicFloatManager() {
        h0.f8724j.a().getLifecycle().a(com.transsion.baseui.music.a.f51428a);
        MusicReport.f51422a.c();
        this.f51412h = new LinkedHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean k(MusicFloatManager this$0, Ref.ObjectRef musicFloatView, View view, MotionEvent event) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(musicFloatView, "$musicFloatView");
        T musicFloatView2 = musicFloatView.element;
        Intrinsics.f(musicFloatView2, "musicFloatView");
        Intrinsics.f(event, "event");
        if (!this$0.w((View) musicFloatView2, event)) {
            ((MusicFloatView) musicFloatView.element).setExpand(false);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String n() {
        String simpleName = MusicFloatManager.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final void A(String str) {
        this.f51408c = str;
    }

    public final void g(Activity activity, MotionEvent event) {
        Intrinsics.g(activity, "activity");
        Intrinsics.g(event, "event");
        MusicFloatView musicFloatView = (MusicFloatView) activity.findViewById(activity.hashCode());
        if (musicFloatView != null && musicFloatView.getVisibility() == 0 && this.f51406a && !w(musicFloatView, event)) {
            musicFloatView.setExpand(false);
        }
    }

    public final void h(long j11, long j12, int i11, int i12, MediaSource mediaSource) {
        MediaItem mediaItemH;
        MediaItem mediaItemH2;
        MediaItem mediaItemH3;
        MediaItem mediaItemH4;
        MediaItem mediaItemH5;
        MediaItem mediaItemH6;
        MediaItem mediaItemH7;
        MediaItem mediaItemH8;
        MediaItem mediaItemH9;
        MediaItem mediaItemH10;
        MediaItem mediaItemH11;
        MediaItem mediaItemH12;
        MediaItem mediaItemH13;
        if (mediaSource == null || (mediaItemH13 = mediaSource.h()) == null || !Intrinsics.b(mediaItemH13.isMusic(), Boolean.FALSE)) {
            k kVar = this.f51412h.get((mediaSource == null || (mediaItemH12 = mediaSource.h()) == null) ? null : mediaItemH12.getMediaId());
            if (!TextUtils.equals((mediaSource == null || (mediaItemH11 = mediaSource.h()) == null) ? null : mediaItemH11.getPageName(), "music_float") && (mediaSource == null || (mediaItemH10 = mediaSource.h()) == null || !Intrinsics.b(mediaItemH10.getInBackground(), Boolean.TRUE))) {
                if (kVar != null) {
                    MusicReport.f51422a.d(kVar);
                    this.f51412h.put((mediaSource == null || (mediaItemH9 = mediaSource.h()) == null) ? null : mediaItemH9.getMediaId(), null);
                    return;
                }
                return;
            }
            if (kVar == null) {
                kVar = new k((mediaSource == null || (mediaItemH8 = mediaSource.h()) == null) ? null : mediaItemH8.getMediaId(), (mediaSource == null || (mediaItemH7 = mediaSource.h()) == null) ? null : mediaItemH7.getOps(), (mediaSource == null || (mediaItemH6 = mediaSource.h()) == null) ? null : mediaItemH6.getSubjectId(), 0L, 0L, j12, 0L, 0L, i11, i12);
            }
            long jG = j11 - kVar.g();
            if (1 > jG || jG >= AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) {
                jG = 0;
            }
            if (mediaSource == null || (mediaItemH5 = mediaSource.h()) == null || !Intrinsics.b(mediaItemH5.getInBackground(), Boolean.TRUE)) {
                kVar.l(kVar.b() + jG);
            } else {
                kVar.m(kVar.c() + jG);
            }
            kVar.n((mediaSource == null || (mediaItemH4 = mediaSource.h()) == null) ? null : mediaItemH4.getOps());
            kVar.r(j12);
            kVar.s(i11);
            kVar.k(i12);
            kVar.q((mediaSource == null || (mediaItemH3 = mediaSource.h()) == null) ? null : mediaItemH3.getSubjectId());
            kVar.p(j11);
            kVar.o(kVar.f() + jG);
            this.f51412h.put((mediaSource == null || (mediaItemH2 = mediaSource.h()) == null) ? null : mediaItemH2.getMediaId(), kVar);
            if (kVar.f() > 10000) {
                MusicReport.f51422a.d(kVar);
                this.f51412h.put((mediaSource == null || (mediaItemH = mediaSource.h()) == null) ? null : mediaItemH.getMediaId(), null);
            }
        }
    }

    public final void i(com.transsion.player.orplayer.e listener) {
        Intrinsics.g(listener, "listener");
        if (this.f51409d.contains(listener)) {
            return;
        }
        this.f51409d.add(listener);
    }

    @Override // com.transsion.player.orplayer.e
    public void initPlayer() {
        com.transsion.player.orplayer.e.a.a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [T, android.view.View] */
    /* JADX WARN: Type inference failed for: r0v6, types: [T, android.view.View, com.transsion.baseui.music.MusicFloatView] */
    @SuppressLint({"ClickableViewAccessibility"})
    public final void j(AppCompatActivity appCompatActivity, int i11) {
        if (appCompatActivity == null) {
            com.transsion.player.mediasession.d.f54622a.a(n() + " --> attach() --> activity == null");
            return;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = appCompatActivity.findViewById(appCompatActivity.hashCode());
        if (o() == null) {
            MusicFloatView musicFloatView = (MusicFloatView) objectRef.element;
            if (musicFloatView == null) {
                return;
            }
            musicFloatView.setVisibility(8);
            return;
        }
        MusicFloatView musicFloatView2 = (MusicFloatView) objectRef.element;
        if (musicFloatView2 != null) {
            musicFloatView2.setVisibility(0);
        }
        if (objectRef.element == 0) {
            ?? musicFloatView3 = new MusicFloatView(appCompatActivity);
            objectRef.element = musicFloatView3;
            musicFloatView3.setId(appCompatActivity.hashCode());
            FrameLayout frameLayoutM = m(appCompatActivity);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            if (frameLayoutM != null) {
                frameLayoutM.setOnTouchListener(new View.OnTouchListener() { // from class: com.transsion.baseui.music.b
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        return MusicFloatManager.k(this.f51429a, objectRef, view, motionEvent);
                    }
                });
            }
            layoutParams.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_BOTTOM_START;
            layoutParams.bottomMargin = gs.a.a(124);
            if (frameLayoutM != null) {
                frameLayoutM.addView((View) objectRef.element, layoutParams);
            }
        }
        ((MusicFloatView) objectRef.element).refresh();
    }

    public final void l() {
        com.transsion.player.orplayer.f fVarQ = q();
        if (fVarQ != null) {
            fVarQ.stop();
        }
        if (fVarQ != null) {
            fVarQ.release();
        }
        f51403i.b().z(null);
        com.transsion.player.mediasession.c.f54613a.p();
    }

    public final FrameLayout m(AppCompatActivity appCompatActivity) {
        Object objM163constructorimpl;
        Window window;
        View decorView;
        try {
            Result.Companion companion = Result.Companion;
            FrameLayout frameLayout = (appCompatActivity == null || (window = appCompatActivity.getWindow()) == null || (decorView = window.getDecorView()) == null) ? null : (FrameLayout) decorView.findViewById(R.id.content);
            if (!(frameLayout instanceof FrameLayout)) {
                frameLayout = null;
            }
            objM163constructorimpl = Result.m163constructorimpl(frameLayout);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        return (FrameLayout) (Result.m166exceptionOrNullimpl(objM163constructorimpl) == null ? objM163constructorimpl : null);
    }

    public final MediaItem o() {
        return this.f51407b;
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
        MediaItem mediaItem = this.f51407b;
        if (mediaItem != null) {
            mediaItem.setState(MediaItem.MUSIC_FLOAT_STATE_COMPLETION);
        }
        Iterator<T> it = this.f51409d.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onCompletion(mediaSource);
        }
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
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingEnd(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.j(this, mediaSource);
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

    @Override // com.transsion.player.orplayer.e
    public void onPlayError(PlayError errorInfo, MediaSource mediaSource) {
        MediaItem mediaItemH;
        Intrinsics.g(errorInfo, "errorInfo");
        com.transsion.player.orplayer.e.a.p(this, errorInfo, mediaSource);
        com.transsion.player.mediasession.d.f54622a.a(n() + " --> onPlayError() --> subjectId = " + ((mediaSource == null || (mediaItemH = mediaSource.h()) == null) ? null : mediaItemH.getSubjectId()));
        MediaItem mediaItem = this.f51407b;
        if (mediaItem == null) {
            return;
        }
        mediaItem.setState("error");
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerRelease(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.s(this, mediaSource);
        kotlinx.coroutines.j.d(l0.a(w0.c()), null, null, new AnonymousClass1(mediaSource, null), 3, null);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerReset() {
        com.transsion.player.orplayer.e.a.u(this);
        com.transsion.player.mediasession.d.f54622a.a(n() + " --> onPlayerReset()");
    }

    @Override // com.transsion.player.orplayer.e
    public void onPrepare(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.v(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onProgress(long j11, MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.x(this, j11, mediaSource);
        Iterator<T> it = this.f51409d.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onProgress(j11, mediaSource);
        }
        com.transsion.player.orplayer.f fVarQ = q();
        long duration = fVarQ != null ? fVarQ.getDuration() : 0L;
        com.transsion.player.orplayer.f fVarQ2 = q();
        Pair<Integer, Integer> bitrate = fVarQ2 != null ? fVarQ2.getBitrate() : null;
        h(j11, duration, bitrate != null ? bitrate.getFirst().intValue() : 0, bitrate != null ? bitrate.getSecond().intValue() : 0, mediaSource);
        MediaItem mediaItemO = o();
        if (mediaItemO != null) {
            mediaItemO.setPosition(Long.valueOf(j11));
        }
        MediaItem mediaItemO2 = o();
        if (mediaItemO2 != null) {
            mediaItemO2.setState(MediaItem.MUSIC_FLOAT_STATE_PLAY);
        }
        MediaItem mediaItemO3 = o();
        if (mediaItemO3 == null) {
            return;
        }
        mediaItemO3.setDuration(Long.valueOf(duration));
    }

    @Override // com.transsion.player.orplayer.e
    public void onRenderFirstFrame() {
        com.transsion.player.orplayer.e.a.z(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onSetDataSource() {
        com.transsion.player.orplayer.e.a.A(this);
        com.transsion.player.mediasession.d.f54622a.a(n() + " --> onSetDataSource()");
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
        MediaItem mediaItemH;
        com.transsion.player.orplayer.e.a.E(this, mediaSource);
        com.transsion.player.mediasession.d.f54622a.a(n() + " --> onVideoPause() --> subjectId = " + ((mediaSource == null || (mediaItemH = mediaSource.h()) == null) ? null : mediaItemH.getSubjectId()));
        MediaItem mediaItem = this.f51407b;
        if (mediaItem != null) {
            mediaItem.setState("pause");
        }
        Iterator<T> it = this.f51409d.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onVideoPause(mediaSource);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoSizeChanged(int i11, int i12) {
        com.transsion.player.orplayer.e.a.G(this, i11, i12);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoStart(MediaSource mediaSource) {
        MediaItem mediaItemH;
        com.transsion.player.orplayer.e.a.H(this, mediaSource);
        com.transsion.player.mediasession.d.f54622a.a(n() + " --> onVideoStart() --> subjectId = " + ((mediaSource == null || (mediaItemH = mediaSource.h()) == null) ? null : mediaItemH.getSubjectId()));
        MediaItem mediaItem = this.f51407b;
        if (mediaItem != null) {
            mediaItem.setState(MediaItem.MUSIC_FLOAT_STATE_PLAY);
        }
        Iterator<T> it = this.f51409d.iterator();
        while (it.hasNext()) {
            ((com.transsion.player.orplayer.e) it.next()).onVideoStart(mediaSource);
        }
    }

    public final String p() {
        return this.f51408c;
    }

    public final com.transsion.player.orplayer.f q() {
        if (this.f51410f == null) {
            com.transsion.player.orplayer.global.e eVar = new com.transsion.player.orplayer.global.e();
            eVar.addPlayerListener(this);
            this.f51410f = eVar;
        }
        return this.f51410f;
    }

    public final String r(String str) {
        return str + "_" + l.f51448a.a(6);
    }

    public final void s() {
        f51403i.b().z(null);
        com.transsion.player.mediasession.c.f54613a.p();
        List<Activity> listA = com.blankj.utilcode.util.a.a();
        if (listA != null) {
            for (Activity activity : listA) {
                BaseMusicFloatActivity baseMusicFloatActivity = activity instanceof BaseMusicFloatActivity ? (BaseMusicFloatActivity) activity : null;
                if (baseMusicFloatActivity != null) {
                    MusicFloatView musicFloatView = (MusicFloatView) baseMusicFloatActivity.findViewById(baseMusicFloatActivity.hashCode());
                    if (musicFloatView != null) {
                        musicFloatView.setVisibility(8);
                    }
                    baseMusicFloatActivity.onCloseMusicFloating();
                }
            }
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void setOnSeekCompleteListener() {
        com.transsion.player.orplayer.e.a.J(this);
    }

    public final boolean t() {
        return this.f51406a;
    }

    public final List<String> u() {
        return this.f51411g;
    }

    public final boolean v(AppCompatActivity appCompatActivity) {
        MusicFloatView musicFloatView = appCompatActivity != null ? (MusicFloatView) appCompatActivity.findViewById(appCompatActivity.hashCode()) : null;
        return musicFloatView != null && musicFloatView.getVisibility() == 0;
    }

    public final boolean w(View view, MotionEvent motionEvent) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        int i11 = iArr[0];
        if (rawX <= i11 || rawX >= i11 + view.getWidth()) {
            return false;
        }
        int i12 = iArr[1];
        return rawY > ((float) i12) && rawY < ((float) (i12 + view.getHeight()));
    }

    public final void x(com.transsion.player.orplayer.e listener) {
        Intrinsics.g(listener, "listener");
        if (this.f51409d.contains(listener)) {
            this.f51409d.remove(listener);
        }
    }

    public final void y(boolean z11) {
        this.f51406a = z11;
    }

    public final void z(MediaItem mediaItem) {
        com.transsion.player.mediasession.d.f54622a.a(n() + " --> setMediaItem() --> musicFloatBean = " + mediaItem);
        if (mediaItem == null || !Intrinsics.b(mediaItem.isMusic(), Boolean.TRUE)) {
            mediaItem = null;
        }
        this.f51407b = mediaItem;
    }
}
