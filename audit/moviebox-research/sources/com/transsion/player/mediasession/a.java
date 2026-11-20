package com.transsion.player.mediasession;

import android.os.Bundle;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import com.transsion.player.orplayer.f;
import com.transsion.player.orplayer.global.TnPlayerManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class a extends MediaSessionCompat.Callback {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0582a f54609d = new C0582a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaSessionCompat f54610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MediaService f54611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MediaItem f54612c;

    /* JADX INFO: renamed from: com.transsion.player.mediasession.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0582a {
        public C0582a() {
        }

        public /* synthetic */ C0582a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(MediaSessionCompat mediaSessionCompat, MediaService mediaService) {
        Intrinsics.g(mediaService, "mediaService");
        this.f54610a = mediaSessionCompat;
        this.f54611b = mediaService;
    }

    public final void a(PlaybackStateCompat playbackStateCompat) {
        if (playbackStateCompat != null) {
            c.f54613a.o(this.f54611b, this.f54612c, Integer.valueOf(playbackStateCompat.getState()), this.f54610a);
        }
    }

    public final String b() {
        String simpleName = a.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final PlaybackStateCompat c(int i11) {
        Long position;
        MediaItem mediaItem = this.f54612c;
        PlaybackStateCompat playbackState = new PlaybackStateCompat.Builder().setActions(775L).setState(i11, (mediaItem == null || (position = mediaItem.getPosition()) == null) ? 0L : position.longValue(), 1.0f).build();
        MediaSessionCompat mediaSessionCompat = this.f54610a;
        if (mediaSessionCompat != null) {
            mediaSessionCompat.setPlaybackState(playbackState);
        }
        Intrinsics.f(playbackState, "playbackState");
        return playbackState;
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onCustomAction(String str, Bundle bundle) {
        Long duration;
        super.onCustomAction(str, bundle);
        PlaybackStateCompat playbackStateCompatC = null;
        this.f54612c = bundle != null ? (MediaItem) bundle.getParcelable("MediaItem") : null;
        if (Intrinsics.b(str, "transsion_play")) {
            MediaSessionCompat mediaSessionCompat = this.f54610a;
            if (mediaSessionCompat != null) {
                MediaMetadataCompat.Builder builder = new MediaMetadataCompat.Builder();
                MediaItem mediaItem = this.f54612c;
                MediaMetadataCompat.Builder builderPutString = builder.putString(MediaMetadataCompat.METADATA_KEY_MEDIA_ID, mediaItem != null ? mediaItem.getMediaId() : null);
                MediaItem mediaItem2 = this.f54612c;
                mediaSessionCompat.setMetadata(builderPutString.putLong(MediaMetadataCompat.METADATA_KEY_DURATION, (mediaItem2 == null || (duration = mediaItem2.getDuration()) == null) ? 0L : duration.longValue()).build());
            }
            playbackStateCompatC = c(3);
        } else if (Intrinsics.b(str, "transsion_pause")) {
            playbackStateCompatC = c(2);
        }
        a(playbackStateCompatC);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPause() {
        super.onPause();
        d.f54622a.a(b() + " --> mediaSessionCallback --> onPause()");
        a(c(2));
        f fVarB = TnPlayerManager.f54684a.b();
        if (fVarB != null) {
            fVarB.pause();
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPlay() {
        super.onPlay();
        d.f54622a.a(b() + " --> mediaSessionCallback --> onPlay()");
        a(c(3));
        f fVarB = TnPlayerManager.f54684a.b();
        if (fVarB != null) {
            fVarB.play();
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSeekTo(long j11) {
        super.onSeekTo(j11);
        MediaItem mediaItem = this.f54612c;
        if (mediaItem != null) {
            mediaItem.setPosition(Long.valueOf(j11));
        }
        d.f54622a.a(b() + " --> mediaSessionCallback --> onSeekTo() --> mediaItem = " + this.f54612c);
        f fVarB = TnPlayerManager.f54684a.b();
        if (fVarB != null) {
            fVarB.seekTo(j11);
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSkipToNext() {
        super.onSkipToNext();
        d.f54622a.a(b() + " --> mediaSessionCallback --> onSkipToNext() -- 暂不处理该事件");
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSkipToPrevious() {
        super.onSkipToPrevious();
        d.f54622a.a(b() + " --> mediaSessionCallback --> onSkipToPrevious() -- 暂不处理该事件");
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onStop() {
        super.onStop();
        d.f54622a.a(b() + " --> mediaSessionCallback --> onStop()");
        c(1);
        f fVarB = TnPlayerManager.f54684a.b();
        if (fVarB != null) {
            fVarB.release();
        }
    }
}
