package com.transsion.player.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.transsion.player.MediaSource;
import com.transsion.player.control.BaseVideoController;
import com.transsion.player.orplayer.e;
import com.transsion.player.orplayer.f;
import com.transsion.player.p006enum.PipStatus;
import com.transsion.player.p006enum.ScaleMode;
import com.transsion.player.utils.LandSpaceHelper;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import jv.b;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import ov.d;

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
public final class ORVideoView extends FrameLayout implements com.transsion.player.ui.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f54825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f54826b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f54827c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f54828d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f54829f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinearLayout f54830g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public BaseVideoController<?, ?> f54831h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LandSpaceHelper f54832i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f54833j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f54834k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public PipStatus f54835l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CopyOnWriteArrayList<e> f54836m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f54837n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f54838o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f54839p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f54840q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ScaleMode f54841r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Function0<? extends ViewGroup> f54842s;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f54843a;

        static {
            int[] iArr = new int[PipStatus.values().length];
            try {
                iArr[PipStatus.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PipStatus.PIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PipStatus.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f54843a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ORVideoView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ORVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ORVideoView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f54825a = "ORVideoView-player";
        this.f54827c = new FrameLayout(getContext());
        View view = new View(getContext());
        view.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.f54828d = view;
        View view2 = new View(getContext());
        view2.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.f54829f = view2;
        this.f54830g = new LinearLayout(getContext());
        this.f54834k = true;
        this.f54835l = PipStatus.DEFAULT;
        this.f54836m = new CopyOnWriteArrayList<>();
        this.f54837n = 1.0f;
        this.f54839p = 1.0f;
        this.f54841r = ScaleMode.SCALE_ASPECT_FIT;
        this.f54832i = new LandSpaceHelper(view, view2);
    }

    public final void a(ORPlayerView oRPlayerView) {
        addView(this.f54830g, new FrameLayout.LayoutParams(-1, -1));
        this.f54830g.setOrientation(0);
        this.f54830g.addView(this.f54828d, new LinearLayout.LayoutParams(0, -1));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.f54830g.addView(this.f54827c, layoutParams);
        this.f54830g.addView(this.f54829f, new LinearLayout.LayoutParams(0, -1));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 17;
        this.f54827c.addView(oRPlayerView, 0, layoutParams2);
    }

    public void addPlayerListener(e listener) {
        Intrinsics.g(listener, "listener");
        if (!this.f54836m.contains(listener)) {
            this.f54836m.add(listener);
        }
        f fVar = this.f54826b;
        if (fVar != null) {
            fVar.addPlayerListener(listener);
        }
    }

    public void changeFullscreen(boolean z11, boolean z12) {
        ViewGroup viewGroupInvoke;
        LinkedHashMap<b<?, ?>, Boolean> controlComponentMap;
        Function0<? extends ViewGroup> function0 = this.f54842s;
        if (function0 == null || (viewGroupInvoke = function0.invoke()) == null) {
            return;
        }
        this.f54833j = z11;
        boolean z13 = !z11 ? false : z12;
        this.f54834k = z13;
        com.transsion.player.utils.b.b(com.transsion.player.utils.b.f54866a, this.f54825a, "changeFullscreen, isFullscreen:" + z11 + ", isLand:" + z13 + ", curPipStatus:" + this.f54835l, false, 4, null);
        ViewParent parent = this.f54830g.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this.f54830g);
        }
        if (z11) {
            viewGroupInvoke.addView(this.f54830g, new FrameLayout.LayoutParams(-1, -1));
        } else {
            addView(this.f54830g, 0, new FrameLayout.LayoutParams(-1, -1));
        }
        BaseVideoController<?, ?> baseVideoController = this.f54831h;
        if (baseVideoController != null && (controlComponentMap = baseVideoController.getControlComponentMap()) != null) {
            Iterator<Map.Entry<b<?, ?>, Boolean>> it = controlComponentMap.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getKey().c(z11, z12);
            }
        }
        this.f54832i.g(this.f54834k);
    }

    public void changeTrackSelection(d mediaTrackGroup, int i11) {
        Intrinsics.g(mediaTrackGroup, "mediaTrackGroup");
        f fVar = this.f54826b;
        if (fVar != null) {
            fVar.changeTrackSelection(mediaTrackGroup, i11);
        }
    }

    public void clearScreen() {
        f fVar = this.f54826b;
        if (fVar != null) {
            fVar.clearScreen();
        }
    }

    public void enableHardwareDecoder(boolean z11) {
        f fVar = this.f54826b;
        if (fVar != null) {
            fVar.enableHardwareDecoder(z11);
        }
    }

    public PipStatus getCurPipStatus() {
        return this.f54835l;
    }

    public long getDuration() {
        f fVar = this.f54826b;
        if (fVar != null) {
            return fVar.getDuration();
        }
        return 0L;
    }

    public MediaSource getMediaData() {
        f fVar = this.f54826b;
        if (fVar != null) {
            return fVar.currentMediaSource();
        }
        return null;
    }

    public long getPosition() {
        f fVar = this.f54826b;
        if (fVar != null) {
            return fVar.getCurrentPosition();
        }
        return 0L;
    }

    public ov.b getVideoFormat() {
        f fVar = this.f54826b;
        if (fVar != null) {
            return fVar.getCurrentVideoFormat();
        }
        return null;
    }

    public int getVideoHeight() {
        f fVar = this.f54826b;
        if (fVar != null) {
            return fVar.getVideoHeight();
        }
        return 0;
    }

    public int getVideoWidth() {
        f fVar = this.f54826b;
        if (fVar != null) {
            return fVar.getVideoWidth();
        }
        return 0;
    }

    public final void initCreatePlayer(Context context, f player) {
        Intrinsics.g(context, "context");
        Intrinsics.g(player, "player");
        this.f54826b = player;
        ORPlayerView oRPlayerView = new ORPlayerView(context);
        a(oRPlayerView);
        f fVar = this.f54826b;
        if (fVar != null) {
            fVar.setSurfaceView(oRPlayerView.getSurface());
        }
    }

    public boolean isBuffering() {
        f fVar = this.f54826b;
        if (fVar != null) {
            return fVar.isLoading();
        }
        return false;
    }

    public boolean isComplete() {
        f fVar = this.f54826b;
        if (fVar != null) {
            return fVar.isComplete();
        }
        return false;
    }

    public boolean isFullscreen() {
        return this.f54833j;
    }

    public boolean isLand() {
        return this.f54834k;
    }

    public boolean isMute() {
        f fVar = this.f54826b;
        if (fVar != null) {
            return fVar.isMute();
        }
        return false;
    }

    public boolean isPlaying() {
        f fVar = this.f54826b;
        if (fVar != null) {
            return fVar.isPlaying();
        }
        return false;
    }

    public boolean isPrepared() {
        f fVar = this.f54826b;
        if (fVar != null) {
            return fVar.isPrepared();
        }
        return false;
    }

    public void pause() {
        f fVar = this.f54826b;
        if (fVar != null) {
            fVar.pause();
        }
        this.f54832i.d();
        setKeepScreenOn(false);
    }

    public void pipChangeFullscreen(PipStatus pipStatus) {
        ViewGroup viewGroupInvoke;
        BaseVideoController<?, ?> baseVideoController;
        LinkedHashMap<b<?, ?>, Boolean> controlComponentMap;
        LinkedHashMap<b<?, ?>, Boolean> controlComponentMap2;
        Intrinsics.g(pipStatus, "pipStatus");
        this.f54835l = pipStatus;
        BaseVideoController<?, ?> baseVideoController2 = this.f54831h;
        if (baseVideoController2 != null && (controlComponentMap2 = baseVideoController2.getControlComponentMap()) != null) {
            Iterator<Map.Entry<b<?, ?>, Boolean>> it = controlComponentMap2.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getKey().b(pipStatus);
            }
        }
        int i11 = a.f54843a[pipStatus.ordinal()];
        if (i11 == 1) {
            this.f54832i.e();
        } else if (i11 == 2 || i11 == 3) {
            this.f54832i.d();
            this.f54832i.g(false);
        }
        Function0<? extends ViewGroup> function0 = this.f54842s;
        if (function0 == null || (viewGroupInvoke = function0.invoke()) == null) {
            return;
        }
        com.transsion.player.utils.b.b(com.transsion.player.utils.b.f54866a, this.f54825a, "pipChangeFullscreen, isLand:" + this.f54834k + ", curPipStatus:" + this.f54835l, false, 4, null);
        ViewParent parent = this.f54830g.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this.f54830g);
        }
        PipStatus pipStatus2 = PipStatus.PIP;
        if (pipStatus == pipStatus2) {
            viewGroupInvoke.addView(this.f54830g, new FrameLayout.LayoutParams(-1, -1));
        } else {
            addView(this.f54830g, 0, new FrameLayout.LayoutParams(-1, -1));
        }
        if (!this.f54833j || pipStatus != pipStatus2 || (baseVideoController = this.f54831h) == null || (controlComponentMap = baseVideoController.getControlComponentMap()) == null) {
            return;
        }
        Iterator<Map.Entry<b<?, ?>, Boolean>> it2 = controlComponentMap.entrySet().iterator();
        while (it2.hasNext()) {
            it2.next().getKey().c(false, false);
        }
    }

    public void play() {
        f fVar = this.f54826b;
        if (fVar != null) {
            fVar.play();
        }
        this.f54832i.e();
        setKeepScreenOn(true);
    }

    public void prepare() {
        f fVar = this.f54826b;
        if (fVar != null) {
            fVar.prepare();
        }
    }

    public void release() {
        LinkedHashMap<b<?, ?>, Boolean> controlComponentMap;
        f fVar = this.f54826b;
        if (fVar != null) {
            fVar.release();
        }
        BaseVideoController<?, ?> baseVideoController = this.f54831h;
        if (baseVideoController != null && (controlComponentMap = baseVideoController.getControlComponentMap()) != null) {
            Iterator<Map.Entry<b<?, ?>, Boolean>> it = controlComponentMap.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getKey().release();
            }
        }
        this.f54832i.d();
        setKeepScreenOn(false);
    }

    public void release(String str) {
        com.transsion.player.ui.a.C0583a.a(this, str);
    }

    public void removePayerListener(e listener) {
        Intrinsics.g(listener, "listener");
        this.f54836m.remove(listener);
        f fVar = this.f54826b;
        if (fVar != null) {
            fVar.removePlayerListener(listener);
        }
    }

    public void reset() {
        f fVar = this.f54826b;
        if (fVar != null) {
            fVar.reset();
        }
        this.f54832i.d();
        setKeepScreenOn(false);
    }

    public void seekTo(long j11) {
        f fVar = this.f54826b;
        if (fVar != null) {
            fVar.seekTo(j11);
        }
    }

    public final void setActivityContainerCallback(Function0<? extends ViewGroup> callback) {
        Intrinsics.g(callback, "callback");
        this.f54842s = callback;
    }

    public void setLooping(boolean z11) {
        this.f54838o = z11;
        f fVar = this.f54826b;
        if (fVar != null) {
            fVar.setLooping(z11);
        }
    }

    public void setMediaData(MediaSource data) {
        Intrinsics.g(data, "data");
        com.transsion.player.utils.b.f54866a.a(this.f54825a, "setMediaData, url:" + data.j() + " ", true);
        f fVar = this.f54826b;
        if (fVar != null) {
            fVar.setDataSource(data);
        }
        this.f54832i.e();
        setKeepScreenOn(true);
    }

    public void setMute(boolean z11) {
        this.f54840q = z11;
        f fVar = this.f54826b;
        if (fVar != null) {
            fVar.setMute(z11);
        }
    }

    public void setPipStatus(PipStatus pipStatus) {
        LinkedHashMap<b<?, ?>, Boolean> controlComponentMap;
        Intrinsics.g(pipStatus, "pipStatus");
        this.f54835l = pipStatus;
        BaseVideoController<?, ?> baseVideoController = this.f54831h;
        if (baseVideoController != null) {
            baseVideoController.onPipStatusChange(pipStatus);
        }
        BaseVideoController<?, ?> baseVideoController2 = this.f54831h;
        if (baseVideoController2 != null && (controlComponentMap = baseVideoController2.getControlComponentMap()) != null) {
            Iterator<Map.Entry<b<?, ?>, Boolean>> it = controlComponentMap.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getKey().b(pipStatus);
            }
        }
        int i11 = a.f54843a[pipStatus.ordinal()];
        if (i11 == 1) {
            this.f54832i.e();
        } else if (i11 == 2) {
            this.f54832i.d();
        } else {
            if (i11 != 3) {
                return;
            }
            this.f54832i.d();
        }
    }

    public void setScaleMode(ScaleMode scaleMode) {
        Intrinsics.g(scaleMode, "scaleMode");
        this.f54841r = scaleMode;
        f fVar = this.f54826b;
        if (fVar != null) {
            fVar.setScaleMode(scaleMode);
        }
    }

    public void setSpeed(float f11) {
        this.f54837n = f11;
        f fVar = this.f54826b;
        if (fVar != null) {
            fVar.setSpeed(f11);
        }
    }

    public final void setVideoController(BaseVideoController<?, ?> baseVideoController) {
        this.f54827c.removeView(this.f54831h);
        this.f54831h = baseVideoController;
        if (baseVideoController != null) {
            baseVideoController.setPayerView(this);
            this.f54827c.addView(baseVideoController, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void setVolume(float f11) {
        this.f54839p = f11;
        f fVar = this.f54826b;
        if (fVar != null) {
            fVar.setVolume(f11);
        }
    }
}
