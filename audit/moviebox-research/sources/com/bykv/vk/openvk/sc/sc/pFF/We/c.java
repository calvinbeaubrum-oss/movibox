package com.bykv.vk.openvk.sc.sc.pFF.We;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.RequiresApi;
import com.bykv.vk.openvk.sc.sc.sc.zY.zY;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class c extends d {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MediaPlayer f25889i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a f25890j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public n8.a f25891k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Surface f25892l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Object f25893m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile boolean f25894n;

    /* JADX INFO: compiled from: source.java */
    public static class a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<c> f25895a;

        public a(c cVar) {
            this.f25895a = new WeakReference<>(cVar);
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i11) {
            try {
                c cVar = this.f25895a.get();
                if (cVar != null) {
                    cVar.o(i11);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            try {
                c cVar = this.f25895a.get();
                if (cVar != null) {
                    cVar.r();
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i11, int i12) {
            try {
                c cVar = this.f25895a.get();
                return cVar != null && cVar.q(i11, i12);
            } catch (Throwable unused) {
                return false;
            }
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i11, int i12) {
            try {
                c cVar = this.f25895a.get();
                return cVar != null && cVar.m(i11, i12);
            } catch (Throwable unused) {
                return false;
            }
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            try {
                c cVar = this.f25895a.get();
                if (cVar != null) {
                    cVar.l();
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            try {
                c cVar = this.f25895a.get();
                if (cVar != null) {
                    cVar.k();
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i11, int i12) {
            try {
                c cVar = this.f25895a.get();
                if (cVar != null) {
                    cVar.p(i11, i12, 1, 1);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public c() {
        MediaPlayer mediaPlayer;
        Object obj = new Object();
        this.f25893m = obj;
        synchronized (obj) {
            mediaPlayer = new MediaPlayer();
            this.f25889i = mediaPlayer;
        }
        v(mediaPlayer);
        try {
            mediaPlayer.setAudioStreamType(3);
        } catch (Throwable unused) {
        }
        this.f25890j = new a(this);
        u();
    }

    @Override // com.bykv.vk.openvk.sc.sc.pFF.We.e
    public void ExN() throws Throwable {
        this.f25889i.start();
    }

    @Override // com.bykv.vk.openvk.sc.sc.pFF.We.e
    public long Ol() {
        try {
            return this.f25889i.getCurrentPosition();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    @Override // com.bykv.vk.openvk.sc.sc.pFF.We.e
    public void Qj() {
        MediaPlayer mediaPlayer = this.f25889i;
        if (mediaPlayer != null) {
            mediaPlayer.prepareAsync();
        }
    }

    @Override // com.bykv.vk.openvk.sc.sc.pFF.We.e
    public int Ql() {
        MediaPlayer mediaPlayer = this.f25889i;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // com.bykv.vk.openvk.sc.sc.pFF.We.e
    public int SR() {
        MediaPlayer mediaPlayer = this.f25889i;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // com.bykv.vk.openvk.sc.sc.pFF.We.e
    public void TRI() throws Throwable {
        this.f25889i.stop();
    }

    @Override // com.bykv.vk.openvk.sc.sc.pFF.We.e
    public void Tf() throws Throwable {
        try {
            this.f25889i.reset();
        } catch (Throwable unused) {
        }
        s();
        n();
        u();
    }

    @Override // com.bykv.vk.openvk.sc.sc.pFF.We.e
    public void UFX() throws Throwable {
        synchronized (this.f25893m) {
            try {
                if (!this.f25894n) {
                    this.f25889i.release();
                    this.f25894n = true;
                    t();
                    s();
                    n();
                    u();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.bykv.vk.openvk.sc.sc.pFF.We.e
    public long WH() {
        try {
            return this.f25889i.getDuration();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    @Override // com.bykv.vk.openvk.sc.sc.pFF.We.e
    public void We(boolean z11) throws Throwable {
        MediaPlayer mediaPlayer = this.f25889i;
        if (mediaPlayer == null) {
            return;
        }
        if (z11) {
            mediaPlayer.setVolume(0.0f, 0.0f);
        } else {
            mediaPlayer.setVolume(1.0f, 1.0f);
        }
    }

    @Override // com.bykv.vk.openvk.sc.sc.pFF.We.e
    @TargetApi(14)
    public void b(Surface surface) {
        t();
        this.f25892l = surface;
        this.f25889i.setSurface(surface);
    }

    @Override // com.bykv.vk.openvk.sc.sc.pFF.We.e
    public void f(FileDescriptor fileDescriptor) throws Throwable {
        this.f25889i.setDataSource(fileDescriptor);
    }

    public void finalize() throws Throwable {
        super.finalize();
        t();
    }

    @Override // com.bykv.vk.openvk.sc.sc.pFF.We.e
    @RequiresApi(api = 23)
    public void h(q8.a aVar) throws Throwable {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f25889i.setPlaybackParams(this.f25889i.getPlaybackParams().setSpeed(aVar.a()));
        }
    }

    @Override // com.bykv.vk.openvk.sc.sc.pFF.We.e
    public void pFF(boolean z11) throws Throwable {
        this.f25889i.setScreenOnWhilePlaying(z11);
    }

    @Override // com.bykv.vk.openvk.sc.sc.pFF.We.e
    public void qr() throws Throwable {
        this.f25889i.pause();
    }

    public final void s() {
        n8.a aVar;
        if (Build.VERSION.SDK_INT < 23 || (aVar = this.f25891k) == null) {
            return;
        }
        try {
            aVar.close();
        } catch (Throwable unused) {
        }
        this.f25891k = null;
    }

    @Override // com.bykv.vk.openvk.sc.sc.pFF.We.e
    public void sc(long j11, int i11) throws Throwable {
        if (Build.VERSION.SDK_INT < 26) {
            this.f25889i.seekTo((int) j11);
            return;
        }
        if (i11 == 0) {
            this.f25889i.seekTo((int) j11, 0);
            return;
        }
        if (i11 == 1) {
            this.f25889i.seekTo((int) j11, 1);
            return;
        }
        if (i11 == 2) {
            this.f25889i.seekTo((int) j11, 2);
        } else if (i11 != 3) {
            this.f25889i.seekTo((int) j11);
        } else {
            this.f25889i.seekTo((int) j11, 3);
        }
    }

    @Override // com.bykv.vk.openvk.sc.sc.pFF.We.e
    public void sc(SurfaceHolder surfaceHolder) throws Throwable {
        synchronized (this.f25893m) {
            try {
                if (!this.f25894n && surfaceHolder != null && surfaceHolder.getSurface() != null && this.f25903h) {
                    this.f25889i.setDisplay(surfaceHolder);
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bykv.vk.openvk.sc.sc.pFF.We.e
    @RequiresApi(api = 23)
    public synchronized void sc(zY zYVar) {
        this.f25891k = n8.a.b(q8.c.e(), zYVar);
        o8.c.b(zYVar);
        this.f25889i.setDataSource(this.f25891k);
    }

    @Override // com.bykv.vk.openvk.sc.sc.pFF.We.e
    public void sc(String str) throws Throwable {
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        if (TextUtils.isEmpty(scheme) || !scheme.equalsIgnoreCase("file")) {
            this.f25889i.setDataSource(str);
        } else {
            this.f25889i.setDataSource(uri.getPath());
        }
    }

    public final void t() {
        try {
            Surface surface = this.f25892l;
            if (surface != null) {
                surface.release();
                this.f25892l = null;
            }
        } catch (Throwable unused) {
        }
    }

    public final void u() {
        this.f25889i.setOnPreparedListener(this.f25890j);
        this.f25889i.setOnBufferingUpdateListener(this.f25890j);
        this.f25889i.setOnCompletionListener(this.f25890j);
        this.f25889i.setOnSeekCompleteListener(this.f25890j);
        this.f25889i.setOnVideoSizeChangedListener(this.f25890j);
        this.f25889i.setOnErrorListener(this.f25890j);
        this.f25889i.setOnInfoListener(this.f25890j);
    }

    public final void v(MediaPlayer mediaPlayer) {
        if (Build.VERSION.SDK_INT >= 28) {
            return;
        }
        try {
            Class<?> cls = Class.forName("android.media.MediaTimeProvider");
            Class<?> cls2 = Class.forName("android.media.SubtitleController");
            Class<?> cls3 = Class.forName("android.media.SubtitleController$Anchor");
            Object objNewInstance = cls2.getConstructor(Context.class, cls, Class.forName("android.media.SubtitleController$Listener")).newInstance(q8.c.e(), null, null);
            Field declaredField = cls2.getDeclaredField("mHandler");
            declaredField.setAccessible(true);
            try {
                declaredField.set(objNewInstance, new Handler());
                declaredField.setAccessible(false);
                mediaPlayer.getClass().getMethod("setSubtitleAnchor", cls2, cls3).invoke(mediaPlayer, objNewInstance, null);
            } catch (Throwable unused) {
                declaredField.setAccessible(false);
            }
        } catch (Throwable unused2) {
        }
    }

    @Override // com.bykv.vk.openvk.sc.sc.pFF.We.e
    public void zY(boolean z11) throws Throwable {
        this.f25889i.setLooping(z11);
    }
}
