package iw;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import java.io.IOException;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f67737e = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MediaPlayer f67738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Handler f67739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f67740c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f67741d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final void e(c this$0, MediaPlayer mediaPlayer) {
        Intrinsics.g(this$0, "this$0");
        MediaPlayer mediaPlayer2 = this$0.f67738a;
        if (mediaPlayer2 != null) {
            mediaPlayer2.start();
        }
    }

    public final boolean b() {
        try {
            MediaPlayer mediaPlayer = this.f67738a;
            return mediaPlayer != null && mediaPlayer.isPlaying();
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    public final void c() {
        try {
            this.f67741d = true;
            MediaPlayer mediaPlayer = this.f67738a;
            if (mediaPlayer != null) {
                mediaPlayer.pause();
            }
        } catch (Exception e11) {
            String message = e11.getMessage();
            if (message != null) {
                uo.b.a.f(uo.b.f78622a, "MediaPlayerHelper", message, false, 4, null);
            }
        }
    }

    public final void d(Context context, String path, boolean z11, MediaPlayer.OnCompletionListener onCompletionListener) {
        MediaPlayer mediaPlayer;
        Intrinsics.g(context, "context");
        Intrinsics.g(path, "path");
        if (TextUtils.isEmpty(path)) {
            return;
        }
        this.f67741d = false;
        if (this.f67738a == null) {
            MediaPlayer mediaPlayer2 = new MediaPlayer();
            this.f67738a = mediaPlayer2;
            mediaPlayer2.setLooping(z11);
        }
        try {
            MediaPlayer mediaPlayer3 = this.f67738a;
            if (mediaPlayer3 != null && mediaPlayer3.isPlaying()) {
                if (TextUtils.equals(this.f67740c, path)) {
                    MediaPlayer mediaPlayer4 = this.f67738a;
                    if (mediaPlayer4 != null) {
                        mediaPlayer4.pause();
                        return;
                    }
                    return;
                }
                MediaPlayer mediaPlayer5 = this.f67738a;
                if (mediaPlayer5 != null) {
                    mediaPlayer5.stop();
                }
                MediaPlayer mediaPlayer6 = this.f67738a;
                if (mediaPlayer6 != null) {
                    mediaPlayer6.reset();
                }
                MediaPlayer mediaPlayer7 = this.f67738a;
                if (mediaPlayer7 != null) {
                    mediaPlayer7.release();
                }
                this.f67738a = null;
                MediaPlayer mediaPlayer8 = new MediaPlayer();
                this.f67738a = mediaPlayer8;
                mediaPlayer8.setLooping(true);
            }
        } catch (IllegalStateException unused) {
            this.f67738a = null;
            this.f67740c = path;
            this.f67738a = MediaPlayer.create(context, Uri.parse(path));
        }
        try {
            MediaPlayer mediaPlayer9 = this.f67738a;
            if (mediaPlayer9 != null) {
                mediaPlayer9.reset();
            }
            this.f67740c = path;
            MediaPlayer mediaPlayer10 = this.f67738a;
            if (mediaPlayer10 != null) {
                mediaPlayer10.setDataSource(context, Uri.parse(path));
            }
            MediaPlayer mediaPlayer11 = this.f67738a;
            if (mediaPlayer11 != null) {
                mediaPlayer11.prepareAsync();
            }
            MediaPlayer mediaPlayer12 = this.f67738a;
            if (mediaPlayer12 != null) {
                mediaPlayer12.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: iw.b
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public final void onPrepared(MediaPlayer mediaPlayer13) {
                        c.e(this.f67736a, mediaPlayer13);
                    }
                });
            }
            if (onCompletionListener == null || (mediaPlayer = this.f67738a) == null) {
                return;
            }
            mediaPlayer.setOnCompletionListener(onCompletionListener);
        } catch (IOException e11) {
            String message = e11.getMessage();
            if (message != null) {
                uo.b.a.f(uo.b.f78622a, "MediaPlayerHelper", message, false, 4, null);
            }
        } catch (IllegalArgumentException e12) {
            String message2 = e12.getMessage();
            if (message2 != null) {
                uo.b.a.f(uo.b.f78622a, "MediaPlayerHelper", message2, false, 4, null);
            }
        } catch (IllegalStateException e13) {
            String message3 = e13.getMessage();
            if (message3 != null) {
                uo.b.a.f(uo.b.f78622a, "MediaPlayerHelper", message3, false, 4, null);
            }
        } catch (SecurityException e14) {
            String message4 = e14.getMessage();
            if (message4 != null) {
                uo.b.a.f(uo.b.f78622a, "MediaPlayerHelper", message4, false, 4, null);
            }
        }
    }

    public final void f() {
        try {
            MediaPlayer mediaPlayer = this.f67738a;
            if (mediaPlayer != null) {
                Intrinsics.d(mediaPlayer);
                if (mediaPlayer.isPlaying()) {
                    MediaPlayer mediaPlayer2 = this.f67738a;
                    Intrinsics.d(mediaPlayer2);
                    mediaPlayer2.stop();
                    MediaPlayer mediaPlayer3 = this.f67738a;
                    Intrinsics.d(mediaPlayer3);
                    mediaPlayer3.release();
                    this.f67739b = null;
                }
            }
        } catch (Exception unused) {
        }
    }
}
