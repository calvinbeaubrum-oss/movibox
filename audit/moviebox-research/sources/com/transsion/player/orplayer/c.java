package com.transsion.player.orplayer;

import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.Utils;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import kotlin.Metadata;
import kotlin.Unit;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class c implements AudioManager.OnAudioFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f54663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Boolean, Unit> f54664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f54665c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AudioManager f54666d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f54667e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f54668f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f54669g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AudioFocusRequest f54670h;

    /* JADX WARN: Multi-variable type inference failed */
    public c(d player, Function1<? super Boolean, Unit> callback) {
        Intrinsics.g(player, "player");
        Intrinsics.g(callback, "callback");
        this.f54663a = player;
        this.f54664b = callback;
        this.f54665c = "AudioFocusHelper";
        Object systemService = Utils.a().getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        Intrinsics.e(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        this.f54666d = (AudioManager) systemService;
        com.transsion.player.utils.b.b(com.transsion.player.utils.b.f54866a, this.f54665c, "AudioFocusHelper orPlayer " + this, false, 4, null);
        if (Build.VERSION.SDK_INT >= 26) {
            AudioFocusRequest.Builder builderA = androidx.media3.exoplayer.b.a(1);
            AudioAttributes.Builder builder = new AudioAttributes.Builder();
            builder.setUsage(14);
            builder.setContentType(2);
            builderA.setAudioAttributes(builder.build());
            builderA.setAcceptsDelayedFocusGain(true);
            builderA.setOnAudioFocusChangeListener(this);
            this.f54670h = builderA.build();
        }
    }

    public static final void d(c this$0, int i11) {
        Intrinsics.g(this$0, "this$0");
        this$0.c(i11);
    }

    public final void b() {
        com.transsion.player.utils.b.b(com.transsion.player.utils.b.f54866a, this.f54665c, "abandonFocus " + this, false, 4, null);
        if (Build.VERSION.SDK_INT >= 26) {
            AudioFocusRequest audioFocusRequest = this.f54670h;
            if (audioFocusRequest != null) {
                this.f54666d.abandonAudioFocusRequest(audioFocusRequest);
            }
        } else {
            this.f54666d.abandonAudioFocus(this);
        }
        this.f54667e = false;
    }

    public final void c(int i11) {
        com.transsion.player.utils.b bVar = com.transsion.player.utils.b.f54866a;
        com.transsion.player.utils.b.b(bVar, this.f54665c, "handleAudioFocusChange ------------ " + this + ", focusChange = " + i11, false, 4, null);
        if (i11 == -3) {
            if (!this.f54669g || this.f54663a.isMute()) {
                return;
            }
            com.transsion.player.utils.b.b(bVar, this.f54665c, "handleAudioFocusChange AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK, focusChange = " + i11, false, 4, null);
            this.f54663a.setVolume(1.0f);
            return;
        }
        if (i11 == -2 || i11 == -1) {
            com.transsion.player.utils.b.i(bVar, this.f54665c, "handleAudioFocusChange LOSS, focusChange = " + i11 + ", isUserPause = " + this.f54668f, false, 4, null);
            this.f54664b.invoke(Boolean.TRUE);
            if (this.f54669g) {
                this.f54663a.pause();
                return;
            }
            return;
        }
        if (i11 == 1 || i11 == 2) {
            com.transsion.player.utils.b.b(bVar, this.f54665c, "handleAudioFocusChange GAIN, focusChange = " + i11 + "， mStartRequested = " + this.f54667e + ", isUserPause = " + this.f54668f, false, 4, null);
            this.f54664b.invoke(Boolean.FALSE);
            if (this.f54667e && !this.f54668f) {
                this.f54663a.play();
            }
            if (this.f54663a.isMute()) {
                return;
            }
            this.f54663a.setVolume(1.0f);
        }
    }

    public final void e() {
        com.transsion.player.utils.b bVar = com.transsion.player.utils.b.f54866a;
        com.transsion.player.utils.b.b(bVar, this.f54665c, "requestFocus " + this, false, 4, null);
        if (Build.VERSION.SDK_INT >= 26) {
            AudioFocusRequest audioFocusRequest = this.f54670h;
            if (audioFocusRequest != null) {
                int iRequestAudioFocus = this.f54666d.requestAudioFocus(audioFocusRequest);
                com.transsion.player.utils.b.b(bVar, this.f54665c, "requestFocus, result:" + iRequestAudioFocus, false, 4, null);
            }
        } else {
            int iRequestAudioFocus2 = this.f54666d.requestAudioFocus(this, 3, 1);
            com.transsion.player.utils.b.b(bVar, this.f54665c, "requestFocus, result:" + iRequestAudioFocus2, false, 4, null);
        }
        this.f54667e = true;
    }

    public final void f(boolean z11) {
        this.f54669g = z11;
    }

    public final void g(boolean z11) {
        this.f54668f = z11;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(final int i11) {
        ThreadUtils.j(new Runnable() { // from class: com.transsion.player.orplayer.b
            @Override // java.lang.Runnable
            public final void run() {
                c.d(this.f54661a, i11);
            }
        });
    }
}
