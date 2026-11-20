package com.transsion.player;

import android.os.Bundle;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.google.common.collect.g1;
import com.transsion.player.exo.ORExoPlayer;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.e;
import java.util.Iterator;
import kotlin.Metadata;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class DashDemoActivity extends AppCompatActivity implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextureView f54207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ORExoPlayer f54208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f54209c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f54210d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f54211f = "DashActivity";

    public static final void Q(DashDemoActivity this$0, TextView textView, View view) {
        d next;
        Intrinsics.g(this$0, "this$0");
        ORExoPlayer oRExoPlayer = this$0.f54208b;
        if (oRExoPlayer != null) {
            Iterator<d> it = oRExoPlayer.getCurrentTracks().a().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (next.e() != 2);
            d dVar = next;
            if (dVar != null) {
                int iD = dVar.d();
                int i11 = this$0.f54210d + 1;
                this$0.f54210d = i11;
                int i12 = i11 % iD;
                oRExoPlayer.changeTrackSelection(dVar, i12);
                ov.b bVar = dVar.b()[i12];
                textView.setText("codecs:" + bVar.b() + " peakBitrate:" + bVar.e() + "  " + bVar.f() + "*" + bVar.c());
            }
        }
    }

    public static final void R(DashDemoActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        ORExoPlayer oRExoPlayer = this$0.f54208b;
        if (oRExoPlayer != null) {
            long currentPosition = oRExoPlayer.getCurrentPosition();
            ORExoPlayer oRExoPlayer2 = this$0.f54208b;
            if (oRExoPlayer2 != null) {
                oRExoPlayer2.seekTo(currentPosition + ((long) 10000));
            }
        }
    }

    public static final void S(DashDemoActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        float f11 = this$0.f54209c + 0.25f;
        this$0.f54209c = f11;
        Log.e(this$0.f54211f, "speed:" + f11);
        ORExoPlayer oRExoPlayer = this$0.f54208b;
        if (oRExoPlayer != null) {
            oRExoPlayer.setSpeed(this$0.f54209c);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void initPlayer() {
        e.a.a(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onAliyunDecodeErrorChangeSoftwareDecoder(MediaSource mediaSource) {
        e.a.b(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onBufferedPosition(long j11, MediaSource mediaSource) {
        e.a.c(this, j11, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onCompletion(MediaSource mediaSource) {
        e.a.d(this, mediaSource);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_dash);
        View viewFindViewById = findViewById(R$id.f54225tv);
        Intrinsics.f(viewFindViewById, "findViewById(R.id.tv)");
        this.f54207a = (TextureView) viewFindViewById;
        String str = getFilesDir().getAbsolutePath() + "/test265/1.mpd";
        ORExoPlayer oRExoPlayer = new ORExoPlayer(this, null, false, 6, null);
        TextureView textureView = this.f54207a;
        if (textureView == null) {
            Intrinsics.y("textureView");
            textureView = null;
        }
        oRExoPlayer.setTextureView(textureView);
        oRExoPlayer.addPlayerListener(this);
        oRExoPlayer.z(new MediaSource(PrepareException.ERROR_DOWNLOAD_PACKAGE_URL_EMPTY, str, 0, null, null, 28, null));
        oRExoPlayer.prepare();
        oRExoPlayer.play();
        this.f54208b = oRExoPlayer;
        final TextView textView = (TextView) findViewById(R$id.tv_index);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DashDemoActivity.Q(this.f54226a, textView, view);
            }
        });
        findViewById(R$id.tv_seek).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DashDemoActivity.R(this.f54228a, view);
            }
        });
        findViewById(R$id.tv_speed).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.player.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DashDemoActivity.S(this.f54229a, view);
            }
        });
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
        e.a.h(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingEnd(MediaSource mediaSource) {
        e.a.j(this, mediaSource);
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
    public void onPlayError(PlayError playError, MediaSource mediaSource) {
        e.a.p(this, playError, mediaSource);
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
    }

    @Override // com.transsion.player.orplayer.e
    public void onProgress(long j11, MediaSource mediaSource) {
        e.a.x(this, j11, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onRenderFirstFrame() {
        e.a.z(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onSetDataSource() {
        e.a.A(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksAudioBitrateChange(int i11) {
        e.a.B(this, i11);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksChange(ov.c tracks) {
        Intrinsics.g(tracks, "tracks");
        Log.e(this.f54211f, "onTracksChanged  tracks:" + tracks);
        g1<d> it = tracks.a().iterator();
        while (it.hasNext()) {
            d next = it.next();
            int iE = next.e();
            boolean zA = next.a();
            for (ov.b bVar : next.b()) {
                Log.e(this.f54211f, "onTracksChanged  trackInGroupIsSupported:" + zA + " \ntrackFormat:" + bVar + " \n");
            }
            Log.e(this.f54211f, "onTracksChanged  trackType:" + iE + " \ntrackInGroupIsSupported:" + zA + " \n");
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksVideoBitrateChange(int i11) {
        e.a.D(this, i11);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoPause(MediaSource mediaSource) {
        e.a.E(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoSizeChanged(int i11, int i12) {
        Log.e(this.f54211f, "onVideoSizeChanged  width:" + i11 + " height:" + i12);
        if (i11 > 0 || i12 > 0) {
            TextureView textureView = this.f54207a;
            TextureView textureView2 = null;
            if (textureView == null) {
                Intrinsics.y("textureView");
                textureView = null;
            }
            ConstraintLayout.b bVar = (ConstraintLayout.b) textureView.getLayoutParams();
            if (bVar != null) {
                ((ViewGroup.MarginLayoutParams) bVar).width = 720;
            }
            if (bVar != null) {
                ((ViewGroup.MarginLayoutParams) bVar).height = (i12 * 720) / i11;
            }
            TextureView textureView3 = this.f54207a;
            if (textureView3 == null) {
                Intrinsics.y("textureView");
            } else {
                textureView2 = textureView3;
            }
            textureView2.setLayoutParams(bVar);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoStart(MediaSource mediaSource) {
        e.a.H(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void setOnSeekCompleteListener() {
        e.a.J(this);
    }
}
