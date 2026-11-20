package com.transsion.player.orplayer;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.aliyun.player.AliPlayer;
import com.aliyun.player.AliPlayerFactory;
import com.aliyun.player.AliPlayerGlobalSettings;
import com.aliyun.player.IPlayer;
import com.aliyun.player.bean.ErrorCode;
import com.aliyun.player.bean.ErrorInfo;
import com.aliyun.player.bean.InfoBean;
import com.aliyun.player.bean.InfoCode;
import com.aliyun.player.nativeclass.CacheConfig;
import com.aliyun.player.nativeclass.MediaInfo;
import com.aliyun.player.nativeclass.PlayerConfig;
import com.aliyun.player.nativeclass.TrackInfo;
import com.aliyun.player.source.UrlSource;
import com.transsion.player.MediaSource;
import com.transsion.player.p006enum.ScaleMode;
import java.io.File;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
public final class ORPlayerImpl implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f54623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AliPlayer f54624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.transsion.player.orplayer.c f54625c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f54626d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f54627f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public MediaSource f54628g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f54629h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f54630i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f54631j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f54632k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f54633l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CopyOnWriteArrayList<e> f54634m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Context f54635n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f54636o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f54637p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f54638q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f54639r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Handler f54640s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ORPlayerImpl$mSurfaceCallback$1 f54641t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public TextureView f54642u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public SurfaceView f54643v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ORPlayerImpl$mSurfaceTextureListener$1 f54644w;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f54645a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f54646b;

        static {
            int[] iArr = new int[TrackInfo.Type.values().length];
            try {
                iArr[TrackInfo.Type.TYPE_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TrackInfo.Type.TYPE_AUDIO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f54645a = iArr;
            int[] iArr2 = new int[ScaleMode.values().length];
            try {
                iArr2[ScaleMode.SCALE_ASPECT_FILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[ScaleMode.SCALE_TO_FILL.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[ScaleMode.SCALE_ASPECT_FIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            f54646b = iArr2;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements d {
        public b() {
        }

        @Override // com.transsion.player.orplayer.d
        public boolean isMute() {
            AliPlayer aliPlayer = ORPlayerImpl.this.f54624b;
            if (aliPlayer != null) {
                return aliPlayer.isMute();
            }
            return false;
        }

        @Override // com.transsion.player.orplayer.d
        public void pause() {
            AliPlayer aliPlayer = ORPlayerImpl.this.f54624b;
            if (aliPlayer != null) {
                aliPlayer.pause();
            }
        }

        @Override // com.transsion.player.orplayer.d
        public void play() {
            AliPlayer aliPlayer = ORPlayerImpl.this.f54624b;
            if (aliPlayer != null) {
                aliPlayer.start();
            }
        }

        @Override // com.transsion.player.orplayer.d
        public void setVolume(float f11) {
            AliPlayer aliPlayer = ORPlayerImpl.this.f54624b;
            if (aliPlayer == null) {
                return;
            }
            aliPlayer.setVolume(f11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class c implements IPlayer.OnLoadingStatusListener {
        public c() {
        }

        @Override // com.aliyun.player.IPlayer.OnLoadingStatusListener
        public void onLoadingBegin() {
            String unused = ORPlayerImpl.this.f54623a;
            ORPlayerImpl.this.f54630i = true;
            e eVar = ORPlayerImpl.this.f54626d;
            if (eVar != null) {
                eVar.onLoadingBegin(ORPlayerImpl.this.f54628g);
            }
            CopyOnWriteArrayList copyOnWriteArrayList = ORPlayerImpl.this.f54634m;
            ORPlayerImpl oRPlayerImpl = ORPlayerImpl.this;
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                ((e) it.next()).onLoadingBegin(oRPlayerImpl.f54628g);
            }
        }

        @Override // com.aliyun.player.IPlayer.OnLoadingStatusListener
        public void onLoadingEnd() {
            String unused = ORPlayerImpl.this.f54623a;
            ORPlayerImpl.this.f54630i = false;
            e eVar = ORPlayerImpl.this.f54626d;
            if (eVar != null) {
                eVar.onLoadingEnd(ORPlayerImpl.this.f54628g);
            }
            CopyOnWriteArrayList copyOnWriteArrayList = ORPlayerImpl.this.f54634m;
            ORPlayerImpl oRPlayerImpl = ORPlayerImpl.this;
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                ((e) it.next()).onLoadingEnd(oRPlayerImpl.f54628g);
            }
        }

        @Override // com.aliyun.player.IPlayer.OnLoadingStatusListener
        public void onLoadingProgress(int i11, float f11) {
            String unused = ORPlayerImpl.this.f54623a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onLoadingProgress percent:");
            sb2.append(i11);
            sb2.append(",netSpeed:");
            sb2.append(f11);
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.transsion.player.orplayer.ORPlayerImpl$mSurfaceTextureListener$1] */
    public ORPlayerImpl(Context context, iv.d dVar) {
        Intrinsics.g(context, "context");
        this.f54623a = "ORPlayerImpl";
        this.f54627f = "";
        this.f54634m = new CopyOnWriteArrayList<>();
        this.f54641t = new ORPlayerImpl$mSurfaceCallback$1(this);
        this.f54644w = new TextureView.SurfaceTextureListener() { // from class: com.transsion.player.orplayer.ORPlayerImpl$mSurfaceTextureListener$1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(final SurfaceTexture surfaceTexture, int i11, int i12) {
                Intrinsics.g(surfaceTexture, "surfaceTexture");
                final ORPlayerImpl oRPlayerImpl = this.f54650a;
                oRPlayerImpl.E(new Function0<Unit>() { // from class: com.transsion.player.orplayer.ORPlayerImpl$mSurfaceTextureListener$1$onSurfaceTextureAvailable$1
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
                        AliPlayer aliPlayer;
                        Surface surface = new Surface(surfaceTexture);
                        if (!surface.isValid() || (aliPlayer = oRPlayerImpl.f54624b) == null) {
                            return;
                        }
                        aliPlayer.setSurface(surface);
                    }
                });
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
                Intrinsics.g(surface, "surface");
                final ORPlayerImpl oRPlayerImpl = this.f54650a;
                oRPlayerImpl.E(new Function0<Unit>() { // from class: com.transsion.player.orplayer.ORPlayerImpl$mSurfaceTextureListener$1$onSurfaceTextureDestroyed$1
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
                        AliPlayer aliPlayer = oRPlayerImpl.f54624b;
                        if (aliPlayer != null) {
                            aliPlayer.setSurface(null);
                        }
                    }
                });
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int i11, int i12) {
                Intrinsics.g(surface, "surface");
                final ORPlayerImpl oRPlayerImpl = this.f54650a;
                oRPlayerImpl.E(new Function0<Unit>() { // from class: com.transsion.player.orplayer.ORPlayerImpl$mSurfaceTextureListener$1$onSurfaceTextureSizeChanged$1
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
                        AliPlayer aliPlayer = oRPlayerImpl.f54624b;
                        if (aliPlayer != null) {
                            aliPlayer.surfaceChanged();
                        }
                    }
                });
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surface) {
                Intrinsics.g(surface, "surface");
            }
        };
        this.f54635n = context;
        AliPlayer aliPlayerCreateAliPlayer = AliPlayerFactory.createAliPlayer(context);
        aliPlayerCreateAliPlayer.setTraceId(dVar != null ? dVar.o() : null);
        aliPlayerCreateAliPlayer.enableHardwareDecoder(dVar != null ? dVar.e() : true);
        this.f54624b = aliPlayerCreateAliPlayer;
        if (dVar == null || dVar.i()) {
            v();
        }
        setPlayerConfig(dVar == null ? iv.b.f67716a.a() : dVar);
        w(dVar != null ? dVar.j() : true);
    }

    public static final void A(ORPlayerImpl this$0) {
        Intrinsics.g(this$0, "this$0");
        e eVar = this$0.f54626d;
        if (eVar != null) {
            eVar.setOnSeekCompleteListener();
        }
        Iterator<T> it = this$0.f54634m.iterator();
        while (it.hasNext()) {
            ((e) it.next()).setOnSeekCompleteListener();
        }
    }

    public static final void B(ORPlayerImpl this$0) {
        MediaInfo mediaInfo;
        List<TrackInfo> trackInfos;
        Intrinsics.g(this$0, "this$0");
        AliPlayer aliPlayer = this$0.f54624b;
        if (aliPlayer != null && (mediaInfo = aliPlayer.getMediaInfo()) != null && (trackInfos = mediaInfo.getTrackInfos()) != null) {
            for (TrackInfo trackInfo : trackInfos) {
                com.transsion.player.utils.b.f54866a.a(this$0.f54623a, "setOnInfoListener onRenderFirstFrame " + com.blankj.utilcode.util.n.j(trackInfo), true);
                TrackInfo.Type type = trackInfo.mType;
                int i11 = type == null ? -1 : a.f54645a[type.ordinal()];
                if (i11 == 1) {
                    int i12 = trackInfo.videoBitrate;
                    this$0.f54637p = i12;
                    e eVar = this$0.f54626d;
                    if (eVar != null) {
                        eVar.onTracksVideoBitrateChange(i12);
                    }
                    Iterator<T> it = this$0.f54634m.iterator();
                    while (it.hasNext()) {
                        ((e) it.next()).onTracksVideoBitrateChange(this$0.f54637p);
                    }
                } else if (i11 == 2) {
                    int i13 = trackInfo.videoBitrate;
                    this$0.f54638q = i13;
                    e eVar2 = this$0.f54626d;
                    if (eVar2 != null) {
                        eVar2.onTracksAudioBitrateChange(i13);
                    }
                    Iterator<T> it2 = this$0.f54634m.iterator();
                    while (it2.hasNext()) {
                        ((e) it2.next()).onTracksAudioBitrateChange(this$0.f54638q);
                    }
                }
            }
        }
        int i14 = this$0.f54637p;
        int i15 = this$0.f54638q;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("setOnInfoListener onRenderFirstFrame，videoBitrate:");
        sb2.append(i14);
        sb2.append(", audioBitrate:");
        sb2.append(i15);
        e eVar3 = this$0.f54626d;
        if (eVar3 != null) {
            eVar3.onRenderFirstFrame();
        }
        Iterator<T> it3 = this$0.f54634m.iterator();
        while (it3.hasNext()) {
            ((e) it3.next()).onRenderFirstFrame();
        }
    }

    public static final void C(ORPlayerImpl this$0, int i11, int i12) {
        Intrinsics.g(this$0, "this$0");
        e eVar = this$0.f54626d;
        if (eVar != null) {
            eVar.onVideoSizeChanged(i11, i12);
        }
        Iterator<T> it = this$0.f54634m.iterator();
        while (it.hasNext()) {
            ((e) it.next()).onVideoSizeChanged(i11, i12);
        }
    }

    public static final void D(ORPlayerImpl this$0, ErrorInfo errorInfo) {
        Intrinsics.g(this$0, "this$0");
        String str = this$0.f54623a;
        ErrorCode code = errorInfo.getCode();
        String msg = errorInfo.getMsg();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onError code:");
        sb2.append(code);
        sb2.append(",msg:");
        sb2.append(msg);
        PlayError playError = new PlayError(Integer.valueOf(errorInfo.getCode().getValue()), errorInfo.getMsg());
        if (this$0.u(playError)) {
            return;
        }
        e eVar = this$0.f54626d;
        if (eVar != null) {
            eVar.onPlayError(playError, this$0.f54628g);
        }
        Iterator<T> it = this$0.f54634m.iterator();
        while (it.hasNext()) {
            ((e) it.next()).onPlayError(playError, this$0.f54628g);
        }
        if (errorInfo.getCode() == ErrorCode.ERROR_DECODE_AUDIO) {
            this$0.prepare();
            this$0.play();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(final Function0<Unit> function0) {
        Handler handler = this.f54640s;
        if (handler == null || Intrinsics.b(Thread.currentThread(), handler.getLooper().getThread())) {
            function0.invoke();
        } else {
            handler.post(new Runnable() { // from class: com.transsion.player.orplayer.o
                @Override // java.lang.Runnable
                public final void run() {
                    ORPlayerImpl.F(function0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(Function0 block) {
        Intrinsics.g(block, "$block");
        block.invoke();
    }

    public static final String H(String str) {
        try {
            URI uri = new URI(str);
            com.transsion.player.utils.a.C0585a c0585a = com.transsion.player.utils.a.f54864a;
            String string = new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), null, uri.getFragment()).toString();
            Intrinsics.f(string, "URI(\n                   …             ).toString()");
            return c0585a.a(string);
        } catch (Exception unused) {
            com.transsion.player.utils.a.C0585a c0585a2 = com.transsion.player.utils.a.f54864a;
            if (str == null) {
                str = "";
            }
            return c0585a2.a(str);
        }
    }

    private final void v() {
        this.f54625c = new com.transsion.player.orplayer.c(new b(), new Function1<Boolean, Unit>() { // from class: com.transsion.player.orplayer.ORPlayerImpl$initAudioFocus$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.f68710a;
            }

            public final void invoke(boolean z11) {
                e eVar = this.this$0.f54626d;
                if (eVar != null) {
                    eVar.onFocusChange(z11);
                }
                Iterator it = this.this$0.f54634m.iterator();
                while (it.hasNext()) {
                    ((e) it.next()).onFocusChange(z11);
                }
            }
        });
    }

    public static final void x(ORPlayerImpl this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.f54633l = true;
        if (this$0.f54639r && this$0.f54636o > 0) {
            com.transsion.player.utils.b.f54866a.a(this$0.f54623a, "aliyun onPrepare 内部的解码切换，已有播放进度，直接播放", true);
            this$0.seekTo(this$0.f54636o);
            this$0.play();
        } else {
            e eVar = this$0.f54626d;
            if (eVar != null) {
                eVar.onPrepare(this$0.f54628g);
            }
            Iterator<T> it = this$0.f54634m.iterator();
            while (it.hasNext()) {
                ((e) it.next()).onPrepare(this$0.f54628g);
            }
        }
    }

    public static final void y(ORPlayerImpl this$0, InfoBean infoBean) {
        Intrinsics.g(this$0, "this$0");
        long extraValue = infoBean.getExtraValue();
        if (infoBean.getCode() == InfoCode.CurrentPosition) {
            this$0.f54636o = extraValue;
            e eVar = this$0.f54626d;
            if (eVar != null) {
                eVar.onProgress(extraValue, this$0.f54628g);
            }
            Iterator<T> it = this$0.f54634m.iterator();
            while (it.hasNext()) {
                ((e) it.next()).onProgress(extraValue, this$0.f54628g);
            }
        }
        if (infoBean.getCode() == InfoCode.LoopingStart) {
            e eVar2 = this$0.f54626d;
            if (eVar2 != null) {
                eVar2.onLoopingStart();
            }
            Iterator<T> it2 = this$0.f54634m.iterator();
            while (it2.hasNext()) {
                ((e) it2.next()).onLoopingStart();
            }
        }
        if (infoBean.getCode() == InfoCode.BufferedPosition) {
            e eVar3 = this$0.f54626d;
            if (eVar3 != null) {
                eVar3.onBufferedPosition(extraValue, this$0.f54628g);
            }
            Iterator<T> it3 = this$0.f54634m.iterator();
            while (it3.hasNext()) {
                ((e) it3.next()).onBufferedPosition(extraValue, this$0.f54628g);
            }
        }
        if (infoBean.getCode() == InfoCode.SwitchToSoftwareVideoDecoder) {
            com.transsion.player.utils.b.f54866a.e(this$0.f54623a, "aliyun 硬解失败，自动切换到软件", true);
        }
    }

    public static final void z(ORPlayerImpl this$0, int i11) {
        Intrinsics.g(this$0, "this$0");
        String str = this$0.f54623a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("setOnStateChangedListener status:");
        sb2.append(i11);
        boolean z11 = i11 == 3;
        this$0.f54629h = z11;
        e eVar = this$0.f54626d;
        if (eVar != null) {
            eVar.onIsPlayingChanged(z11);
        }
        Iterator<T> it = this$0.f54634m.iterator();
        while (it.hasNext()) {
            ((e) it.next()).onIsPlayingChanged(this$0.f54629h);
        }
        this$0.f54632k = i11 == 6;
        com.transsion.player.orplayer.c cVar = this$0.f54625c;
        if (cVar != null) {
            cVar.f(this$0.f54629h);
        }
        if (i11 == 3) {
            e eVar2 = this$0.f54626d;
            if (eVar2 != null) {
                eVar2.onVideoStart(this$0.f54628g);
            }
            Iterator<T> it2 = this$0.f54634m.iterator();
            while (it2.hasNext()) {
                ((e) it2.next()).onVideoStart(this$0.f54628g);
            }
            return;
        }
        if (i11 == 4) {
            e eVar3 = this$0.f54626d;
            if (eVar3 != null) {
                eVar3.onVideoPause(this$0.f54628g);
            }
            Iterator<T> it3 = this$0.f54634m.iterator();
            while (it3.hasNext()) {
                ((e) it3.next()).onVideoPause(this$0.f54628g);
            }
            return;
        }
        if (i11 != 6) {
            return;
        }
        e eVar4 = this$0.f54626d;
        if (eVar4 != null) {
            eVar4.onCompletion(this$0.f54628g);
        }
        Iterator<T> it4 = this$0.f54634m.iterator();
        while (it4.hasNext()) {
            ((e) it4.next()).onCompletion(this$0.f54628g);
        }
    }

    public final void G(iv.d dVar, boolean z11) {
        CacheConfig cacheConfig = new CacheConfig();
        cacheConfig.mEnable = z11;
        cacheConfig.mMaxDurationS = 120L;
        File externalCacheDir = this.f54635n.getExternalCacheDir();
        String absolutePath = externalCacheDir != null ? externalCacheDir.getAbsolutePath() : null;
        String str = absolutePath + File.separator + "video_cache";
        cacheConfig.mDir = str;
        cacheConfig.mMaxSizeMB = dVar.a();
        AliPlayer aliPlayer = this.f54624b;
        if (aliPlayer != null) {
            aliPlayer.setCacheConfig(cacheConfig);
        }
        try {
            Result.Companion companion = Result.Companion;
            AliPlayerGlobalSettings.enableLocalCache(z11, 0, str);
            AliPlayerGlobalSettings.setCacheUrlHashCallback(new AliPlayerGlobalSettings.OnGetUrlHashCallback() { // from class: com.transsion.player.orplayer.p
                @Override // com.aliyun.player.AliPlayerGlobalSettings.OnGetUrlHashCallback
                public final String getUrlHashCallback(String str2) {
                    return ORPlayerImpl.H(str2);
                }
            });
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    @Override // com.transsion.player.orplayer.f
    public boolean addDataSource(MediaSource mediaSource) {
        return f.b.a(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.f
    public void addPlayerListener(e listener) {
        Intrinsics.g(listener, "listener");
        if (this.f54634m.contains(listener)) {
            return;
        }
        this.f54634m.add(listener);
    }

    @Override // com.transsion.player.orplayer.f
    public void changeTrackSelection(ov.d dVar, int i11) {
        f.b.c(this, dVar, i11);
    }

    @Override // com.transsion.player.orplayer.f
    public void clearScreen() {
        AliPlayer aliPlayer = this.f54624b;
        if (aliPlayer != null) {
            aliPlayer.clearScreen();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void clearSurfaceOnly() {
        SurfaceTexture surfaceTexture;
        SurfaceHolder holder;
        Surface surface;
        AliPlayer aliPlayer = this.f54624b;
        if (aliPlayer != null) {
            aliPlayer.setSurface(null);
        }
        SurfaceView surfaceView = this.f54643v;
        if (surfaceView != null && (holder = surfaceView.getHolder()) != null && (surface = holder.getSurface()) != null) {
            surface.release();
        }
        TextureView textureView = this.f54642u;
        if (textureView != null && (surfaceTexture = textureView.getSurfaceTexture()) != null) {
            surfaceTexture.release();
        }
        t();
    }

    @Override // com.transsion.player.orplayer.f
    public MediaSource currentMediaSource() {
        return this.f54628g;
    }

    @Override // com.transsion.player.orplayer.f
    public void enableHardwareDecoder(boolean z11) {
        AliPlayer aliPlayer = this.f54624b;
        if (aliPlayer != null) {
            aliPlayer.enableHardwareDecoder(z11);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public Pair<Integer, Integer> getBitrate() {
        return new Pair<>(Integer.valueOf(this.f54637p), Integer.valueOf(this.f54638q));
    }

    @Override // com.transsion.player.orplayer.f
    public long getCurrentPosition() {
        return this.f54636o;
    }

    @Override // com.transsion.player.orplayer.f
    public ov.c getCurrentTracks() {
        return f.b.h(this);
    }

    @Override // com.transsion.player.orplayer.f
    public ov.b getCurrentVideoFormat() {
        return f.b.i(this);
    }

    @Override // com.transsion.player.orplayer.f
    public Object getDownloadBitrate() {
        AliPlayer aliPlayer = this.f54624b;
        if (aliPlayer != null) {
            return aliPlayer.getOption(IPlayer.Option.DownloadBitrate);
        }
        return null;
    }

    @Override // com.transsion.player.orplayer.f
    public long getDuration() {
        AliPlayer aliPlayer = this.f54624b;
        if (aliPlayer != null) {
            return aliPlayer.getDuration();
        }
        return 0L;
    }

    @Override // com.transsion.player.orplayer.f
    public int getVideoHeight() {
        AliPlayer aliPlayer = this.f54624b;
        return aliPlayer != null ? aliPlayer.getVideoHeight() : f.b.k(this);
    }

    @Override // com.transsion.player.orplayer.f
    public int getVideoWidth() {
        AliPlayer aliPlayer = this.f54624b;
        return aliPlayer != null ? aliPlayer.getVideoWidth() : f.b.l(this);
    }

    @Override // com.transsion.player.orplayer.f
    public Float getVolume() {
        AliPlayer aliPlayer = this.f54624b;
        if (aliPlayer != null) {
            return Float.valueOf(aliPlayer.getVolume());
        }
        return null;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isComplete() {
        return this.f54632k;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isLoading() {
        return this.f54630i;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isMute() {
        AliPlayer aliPlayer = this.f54624b;
        if (aliPlayer != null) {
            return aliPlayer.isMute();
        }
        return false;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isPlaying() {
        return this.f54629h;
    }

    @Override // com.transsion.player.orplayer.f
    public boolean isPrepared() {
        return this.f54633l;
    }

    @Override // com.transsion.player.orplayer.f
    public void pause() {
        com.transsion.player.orplayer.c cVar = this.f54625c;
        if (cVar != null) {
            cVar.g(true);
        }
        AliPlayer aliPlayer = this.f54624b;
        if (aliPlayer != null) {
            aliPlayer.pause();
        }
        com.transsion.player.orplayer.c cVar2 = this.f54625c;
        if (cVar2 != null) {
            cVar2.b();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void play() {
        e eVar = this.f54626d;
        if (eVar != null) {
            eVar.initPlayer();
        }
        Iterator<T> it = this.f54634m.iterator();
        while (it.hasNext()) {
            ((e) it.next()).initPlayer();
        }
        AliPlayer aliPlayer = this.f54624b;
        if (aliPlayer != null) {
            aliPlayer.start();
        }
        com.transsion.player.orplayer.c cVar = this.f54625c;
        if (cVar != null) {
            cVar.g(false);
        }
        com.transsion.player.orplayer.c cVar2 = this.f54625c;
        if (cVar2 != null) {
            cVar2.e();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void prepare() {
        AliPlayer aliPlayer = this.f54624b;
        if (aliPlayer != null) {
            aliPlayer.prepare();
        }
        this.f54631j = false;
    }

    @Override // com.transsion.player.orplayer.f
    public void release() {
        this.f54627f = "";
        AliPlayer aliPlayer = this.f54624b;
        if (aliPlayer != null) {
            aliPlayer.release();
        }
        e eVar = this.f54626d;
        if (eVar != null) {
            e.a.t(eVar, null, 1, null);
        }
        for (e it : this.f54634m) {
            Intrinsics.f(it, "it");
            e.a.t(it, null, 1, null);
        }
        com.transsion.player.orplayer.c cVar = this.f54625c;
        if (cVar != null) {
            cVar.b();
        }
        t();
        this.f54633l = false;
        this.f54639r = false;
    }

    @Override // com.transsion.player.orplayer.f
    public void release(String str) {
        f.b.o(this, str);
    }

    @Override // com.transsion.player.orplayer.f
    public boolean removeDataSource(MediaSource mediaSource) {
        return f.b.p(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.f
    public void removePlayerListener(e listener) {
        Intrinsics.g(listener, "listener");
        this.f54634m.remove(listener);
    }

    @Override // com.transsion.player.orplayer.f
    public boolean requestForce() {
        return f.b.r(this);
    }

    @Override // com.transsion.player.orplayer.f
    public void reset() {
        AliPlayer aliPlayer = this.f54624b;
        if (aliPlayer != null) {
            aliPlayer.stop();
        }
        AliPlayer aliPlayer2 = this.f54624b;
        if (aliPlayer2 != null) {
            aliPlayer2.reset();
        }
        AliPlayer aliPlayer3 = this.f54624b;
        if (aliPlayer3 != null) {
            aliPlayer3.clearScreen();
        }
        com.transsion.player.orplayer.c cVar = this.f54625c;
        if (cVar != null) {
            cVar.b();
        }
        if (!this.f54631j) {
            e eVar = this.f54626d;
            if (eVar != null) {
                eVar.onPlayerReset();
            }
            Iterator<T> it = this.f54634m.iterator();
            while (it.hasNext()) {
                ((e) it.next()).onPlayerReset();
            }
        }
        this.f54631j = true;
        this.f54633l = false;
        this.f54639r = false;
    }

    @Override // com.transsion.player.orplayer.f
    public void seekTo(long j11) {
        AliPlayer aliPlayer = this.f54624b;
        if (aliPlayer != null) {
            aliPlayer.setMaxAccurateSeekDelta(150000);
        }
        AliPlayer aliPlayer2 = this.f54624b;
        if (aliPlayer2 != null) {
            aliPlayer2.seekTo(j11, IPlayer.SeekMode.Accurate);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void seekTo(String str, long j11) {
        f.b.s(this, str, j11);
    }

    @Override // com.transsion.player.orplayer.f
    public void setAutoPlay(boolean z11) {
    }

    @Override // com.transsion.player.orplayer.f
    public void setDataSource(MediaSource mediaSource) {
        Intrinsics.g(mediaSource, "mediaSource");
        UrlSource urlSource = new UrlSource();
        String strJ = mediaSource.j();
        this.f54627f = strJ;
        this.f54628g = mediaSource;
        urlSource.setUri(strJ);
        e eVar = this.f54626d;
        if (eVar != null) {
            eVar.onSetDataSource();
        }
        Iterator<T> it = this.f54634m.iterator();
        while (it.hasNext()) {
            ((e) it.next()).onSetDataSource();
        }
        AliPlayer aliPlayer = this.f54624b;
        if (aliPlayer != null) {
            aliPlayer.setDataSource(urlSource);
        }
        this.f54633l = false;
        this.f54639r = false;
    }

    @Override // com.transsion.player.orplayer.f
    public void setLooping(boolean z11) {
        AliPlayer aliPlayer = this.f54624b;
        if (aliPlayer == null) {
            return;
        }
        aliPlayer.setLoop(z11);
    }

    @Override // com.transsion.player.orplayer.f
    public void setMute(boolean z11) {
        AliPlayer aliPlayer = this.f54624b;
        if (aliPlayer == null) {
            return;
        }
        aliPlayer.setMute(z11);
    }

    @Override // com.transsion.player.orplayer.f
    public void setPlayerConfig(iv.d vodConfig) {
        Intrinsics.g(vodConfig, "vodConfig");
        AliPlayer aliPlayer = this.f54624b;
        PlayerConfig config = aliPlayer != null ? aliPlayer.getConfig() : null;
        Intrinsics.e(config, "null cannot be cast to non-null type com.aliyun.player.nativeclass.PlayerConfig");
        config.mClearFrameWhenStop = vodConfig.b();
        config.mEnableLocalCache = vodConfig.j();
        config.mPositionTimerIntervalMs = vodConfig.k();
        config.mMaxBufferDuration = vodConfig.g();
        config.mHighBufferDuration = vodConfig.f();
        config.mStartBufferDuration = vodConfig.n();
        config.mNetworkRetryCount = vodConfig.m();
        config.mNetworkTimeout = vodConfig.h();
        config.mDisableAudio = vodConfig.c();
        config.mDisableVideo = vodConfig.d();
        AliPlayer aliPlayer2 = this.f54624b;
        if (aliPlayer2 == null) {
            return;
        }
        aliPlayer2.setConfig(config);
    }

    @Override // com.transsion.player.orplayer.f
    public void setPlayerListener(e listener) {
        Intrinsics.g(listener, "listener");
        this.f54626d = listener;
    }

    @Override // com.transsion.player.orplayer.f
    public void setScaleMode(ScaleMode scaleMode) {
        AliPlayer aliPlayer;
        Intrinsics.g(scaleMode, "scaleMode");
        int i11 = a.f54646b[scaleMode.ordinal()];
        if (i11 == 1) {
            AliPlayer aliPlayer2 = this.f54624b;
            if (aliPlayer2 == null) {
                return;
            }
            aliPlayer2.setScaleMode(IPlayer.ScaleMode.SCALE_ASPECT_FILL);
            return;
        }
        if (i11 != 2) {
            if (i11 == 3 && (aliPlayer = this.f54624b) != null) {
                aliPlayer.setScaleMode(IPlayer.ScaleMode.SCALE_ASPECT_FIT);
                return;
            }
            return;
        }
        AliPlayer aliPlayer3 = this.f54624b;
        if (aliPlayer3 == null) {
            return;
        }
        aliPlayer3.setScaleMode(IPlayer.ScaleMode.SCALE_TO_FILL);
    }

    @Override // com.transsion.player.orplayer.f
    public void setSpeed(float f11) {
        AliPlayer aliPlayer = this.f54624b;
        if (aliPlayer == null) {
            return;
        }
        aliPlayer.setSpeed(f11);
    }

    @Override // com.transsion.player.orplayer.f
    public void setSurfaceView(SurfaceView surfaceView) {
        SurfaceHolder holder;
        Surface surface;
        AliPlayer aliPlayer;
        SurfaceHolder holder2;
        t();
        this.f54643v = surfaceView;
        Thread threadCurrentThread = Thread.currentThread();
        if (surfaceView != null) {
            this.f54640s = threadCurrentThread instanceof HandlerThread ? new Handler(((HandlerThread) threadCurrentThread).getLooper()) : new Handler(Looper.getMainLooper());
        }
        if (surfaceView != null && (holder2 = surfaceView.getHolder()) != null) {
            holder2.addCallback(this.f54641t);
        }
        if (surfaceView == null || (holder = surfaceView.getHolder()) == null || (surface = holder.getSurface()) == null || !surface.isValid() || (aliPlayer = this.f54624b) == null) {
            return;
        }
        aliPlayer.setSurface(surface);
    }

    @Override // com.transsion.player.orplayer.f
    public void setTextureView(TextureView textureView) {
        SurfaceTexture surfaceTexture;
        AliPlayer aliPlayer;
        t();
        this.f54642u = textureView;
        Thread threadCurrentThread = Thread.currentThread();
        if (this.f54643v != null) {
            this.f54640s = threadCurrentThread instanceof HandlerThread ? new Handler(((HandlerThread) threadCurrentThread).getLooper()) : new Handler(Looper.getMainLooper());
        }
        if (textureView != null) {
            textureView.setSurfaceTextureListener(this.f54644w);
        }
        if (textureView == null || (surfaceTexture = textureView.getSurfaceTexture()) == null) {
            return;
        }
        Surface surface = new Surface(surfaceTexture);
        if (!surface.isValid() || (aliPlayer = this.f54624b) == null) {
            return;
        }
        aliPlayer.setSurface(surface);
    }

    @Override // com.transsion.player.orplayer.f
    public void setVolume(float f11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("setVolume   volume:");
        sb2.append(f11);
        AliPlayer aliPlayer = this.f54624b;
        if (aliPlayer == null) {
            return;
        }
        aliPlayer.setVolume(kotlin.ranges.a.j(f11, 0.0f, 2.0f));
    }

    @Override // com.transsion.player.orplayer.f
    public void stop() {
        this.f54627f = "";
        com.transsion.player.orplayer.c cVar = this.f54625c;
        if (cVar != null) {
            cVar.g(true);
        }
        AliPlayer aliPlayer = this.f54624b;
        if (aliPlayer != null) {
            aliPlayer.stop();
        }
        com.transsion.player.orplayer.c cVar2 = this.f54625c;
        if (cVar2 != null) {
            cVar2.b();
        }
        this.f54639r = false;
    }

    public final void t() {
        SurfaceHolder holder;
        SurfaceView surfaceView = this.f54643v;
        if (surfaceView != null && (holder = surfaceView.getHolder()) != null) {
            holder.removeCallback(this.f54641t);
        }
        this.f54643v = null;
        TextureView textureView = this.f54642u;
        if (textureView != null) {
            textureView.setSurfaceTextureListener(null);
        }
        this.f54642u = null;
    }

    public final boolean u(PlayError playError) {
        Integer errorCode;
        Integer errorCode2 = playError.getErrorCode();
        if ((errorCode2 == null || errorCode2.intValue() != 537133057) && ((errorCode = playError.getErrorCode()) == null || errorCode.intValue() != 537133058)) {
            return false;
        }
        if (this.f54639r) {
            com.transsion.player.utils.b.f54866a.a(this.f54623a, "aliyun 已经切过软解，还是出错不再处理", true);
            return false;
        }
        com.transsion.player.utils.b.f54866a.c(this.f54623a, "aliyun onError -- 解码失败，强制切到软解", true);
        e eVar = this.f54626d;
        if (eVar != null) {
            eVar.onAliyunDecodeErrorChangeSoftwareDecoder(this.f54628g);
        }
        Iterator<T> it = this.f54634m.iterator();
        while (it.hasNext()) {
            ((e) it.next()).onAliyunDecodeErrorChangeSoftwareDecoder(this.f54628g);
        }
        stop();
        reset();
        AliPlayer aliPlayer = this.f54624b;
        if (aliPlayer != null) {
            aliPlayer.enableHardwareDecoder(false);
        }
        MediaSource mediaSource = this.f54628g;
        if (mediaSource != null) {
            setDataSource(mediaSource);
            prepare();
        }
        this.f54639r = true;
        return true;
    }

    public final void w(boolean z11) {
        iv.b bVar = iv.b.f67716a;
        G(bVar.a(), bVar.c() && z11);
        AliPlayer aliPlayer = this.f54624b;
        if (aliPlayer != null) {
            aliPlayer.setOnRenderingStartListener(new IPlayer.OnRenderingStartListener() { // from class: com.transsion.player.orplayer.h
                @Override // com.aliyun.player.IPlayer.OnRenderingStartListener
                public final void onRenderingStart() {
                    ORPlayerImpl.B(this.f54735a);
                }
            });
        }
        AliPlayer aliPlayer2 = this.f54624b;
        if (aliPlayer2 != null) {
            aliPlayer2.setOnVideoSizeChangedListener(new IPlayer.OnVideoSizeChangedListener() { // from class: com.transsion.player.orplayer.i
                @Override // com.aliyun.player.IPlayer.OnVideoSizeChangedListener
                public final void onVideoSizeChanged(int i11, int i12) {
                    ORPlayerImpl.C(this.f54736a, i11, i12);
                }
            });
        }
        AliPlayer aliPlayer3 = this.f54624b;
        if (aliPlayer3 != null) {
            aliPlayer3.setOnErrorListener(new IPlayer.OnErrorListener() { // from class: com.transsion.player.orplayer.j
                @Override // com.aliyun.player.IPlayer.OnErrorListener
                public final void onError(ErrorInfo errorInfo) {
                    ORPlayerImpl.D(this.f54737a, errorInfo);
                }
            });
        }
        AliPlayer aliPlayer4 = this.f54624b;
        if (aliPlayer4 != null) {
            aliPlayer4.setOnLoadingStatusListener(new c());
        }
        AliPlayer aliPlayer5 = this.f54624b;
        if (aliPlayer5 != null) {
            aliPlayer5.setOnPreparedListener(new IPlayer.OnPreparedListener() { // from class: com.transsion.player.orplayer.k
                @Override // com.aliyun.player.IPlayer.OnPreparedListener
                public final void onPrepared() {
                    ORPlayerImpl.x(this.f54738a);
                }
            });
        }
        AliPlayer aliPlayer6 = this.f54624b;
        if (aliPlayer6 != null) {
            aliPlayer6.setOnInfoListener(new IPlayer.OnInfoListener() { // from class: com.transsion.player.orplayer.l
                @Override // com.aliyun.player.IPlayer.OnInfoListener
                public final void onInfo(InfoBean infoBean) {
                    ORPlayerImpl.y(this.f54739a, infoBean);
                }
            });
        }
        AliPlayer aliPlayer7 = this.f54624b;
        if (aliPlayer7 != null) {
            aliPlayer7.setOnStateChangedListener(new IPlayer.OnStateChangedListener() { // from class: com.transsion.player.orplayer.m
                @Override // com.aliyun.player.IPlayer.OnStateChangedListener
                public final void onStateChanged(int i11) {
                    ORPlayerImpl.z(this.f54740a, i11);
                }
            });
        }
        AliPlayer aliPlayer8 = this.f54624b;
        if (aliPlayer8 != null) {
            aliPlayer8.setOnSeekCompleteListener(new IPlayer.OnSeekCompleteListener() { // from class: com.transsion.player.orplayer.n
                @Override // com.aliyun.player.IPlayer.OnSeekCompleteListener
                public final void onSeekComplete() {
                    ORPlayerImpl.A(this.f54741a);
                }
            });
        }
    }
}
