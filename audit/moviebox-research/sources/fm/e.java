package fm;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.util.Log;
import com.google.zxing.client.android.R$raw;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f65121d = "e";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f65122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f65123b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f65124c = false;

    public e(Activity activity) {
        activity.setVolumeControlStream(3);
        this.f65122a = activity.getApplicationContext();
    }

    public static /* synthetic */ void c(MediaPlayer mediaPlayer) {
        mediaPlayer.stop();
        mediaPlayer.reset();
        mediaPlayer.release();
    }

    public static /* synthetic */ boolean d(MediaPlayer mediaPlayer, int i11, int i12) {
        Log.w(f65121d, "Failed to beep " + i11 + ", " + i12);
        mediaPlayer.stop();
        mediaPlayer.reset();
        mediaPlayer.release();
        return true;
    }

    public MediaPlayer e() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setContentType(2).build());
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: fm.c
            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer mediaPlayer2) {
                e.c(mediaPlayer2);
            }
        });
        mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: fm.d
            @Override // android.media.MediaPlayer.OnErrorListener
            public final boolean onError(MediaPlayer mediaPlayer2, int i11, int i12) {
                return e.d(mediaPlayer2, i11, i12);
            }
        });
        try {
            AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = this.f65122a.getResources().openRawResourceFd(R$raw.zxing_beep);
            try {
                mediaPlayer.setDataSource(assetFileDescriptorOpenRawResourceFd.getFileDescriptor(), assetFileDescriptorOpenRawResourceFd.getStartOffset(), assetFileDescriptorOpenRawResourceFd.getLength());
                assetFileDescriptorOpenRawResourceFd.close();
                mediaPlayer.setVolume(0.1f, 0.1f);
                mediaPlayer.prepare();
                mediaPlayer.start();
                return mediaPlayer;
            } catch (Throwable th2) {
                assetFileDescriptorOpenRawResourceFd.close();
                throw th2;
            }
        } catch (IOException e11) {
            Log.w(f65121d, e11);
            mediaPlayer.reset();
            mediaPlayer.release();
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    public synchronized void f() {
        Vibrator vibrator;
        try {
            if (this.f65123b) {
                e();
            }
            if (this.f65124c && (vibrator = (Vibrator) this.f65122a.getSystemService("vibrator")) != null) {
                vibrator.vibrate(200L);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void g(boolean z11) {
        this.f65123b = z11;
    }
}
