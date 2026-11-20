package com.cloud.tmc.integration.audio;

import android.media.MediaPlayer;
import android.text.TextUtils;
import android.util.Log;
import com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.utils.FileUtil;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.google.gson.JsonObject;
import java.io.File;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class PlayerInstance implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f30396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f30397b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f30399d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f30402h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f30403i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f30405k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public MediaPlayer f30407m;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final App f30410p;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f30398c = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f30400f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f30401g = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f30404j = 1.0f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f30406l = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f30409o = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f30408n = true;

    /* JADX INFO: compiled from: source.java */
    public enum PlayType {
        ON_CAN_PLAY,
        ON_PLAY,
        ON_PAUSE,
        ON_STOP,
        ON_ENDED,
        ON_ERROR,
        ON_WAITING,
        ON_SEEKING,
        ON_SEEKED
    }

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(PlayType playType, String str, String str2);
    }

    public PlayerInstance(App app, String str, a aVar) {
        this.f30410p = app;
        this.f30397b = str;
        this.f30396a = aVar;
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.f30407m = mediaPlayer;
        mediaPlayer.setAudioStreamType(3);
    }

    public static void n(bc.a aVar, String str) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("success", Boolean.FALSE);
        jsonObject.addProperty("errMsg", str);
        if (aVar != null) {
            aVar.a(jsonObject);
        }
    }

    public void a() {
        TmcLogger.c("PlayerInstance", "addMonitors");
        this.f30407m.setOnPreparedListener(this);
        this.f30407m.setOnBufferingUpdateListener(this);
        this.f30407m.setOnErrorListener(this);
        this.f30407m.setOnSeekCompleteListener(this);
        this.f30407m.setOnCompletionListener(this);
    }

    public final void b(PlayType playType) {
        try {
            this.f30396a.a(playType, null, this.f30397b);
        } catch (Exception e11) {
            TmcLogger.h("PlayerInstance", e11);
        }
    }

    public boolean c() {
        TmcLogger.c("PlayerInstance", "getAutoPlay:### id=" + this.f30397b);
        return this.f30402h;
    }

    public int d() {
        return this.f30406l;
    }

    public int e() {
        MediaPlayer mediaPlayer = this.f30407m;
        if (mediaPlayer != null) {
            return mediaPlayer.getCurrentPosition();
        }
        return 0;
    }

    public int f() {
        MediaPlayer mediaPlayer = this.f30407m;
        if (mediaPlayer != null) {
            return mediaPlayer.getDuration();
        }
        return 0;
    }

    public final String g(String str) {
        App app;
        if (TextUtils.isEmpty(str) || (app = this.f30410p) == null) {
            return str;
        }
        File fileJ = FileUtil.J(app, str);
        if (fileJ == null || !fileJ.exists() || !fileJ.isFile()) {
            return "";
        }
        String absolutePath = fileJ.getAbsolutePath();
        if (TextUtils.isEmpty(absolutePath)) {
            return (str.startsWith(AgentPageJsBridge.HTTPS) || str.startsWith("http://")) ? str : "";
        }
        return absolutePath;
    }

    public boolean h() {
        TmcLogger.c("PlayerInstance", "getLoop:### id=" + this.f30397b);
        return this.f30403i;
    }

    public String i() {
        return this.f30397b;
    }

    public String j() {
        TmcLogger.c("PlayerInstance", "getSrc:### id=" + this.f30397b);
        return this.f30399d;
    }

    public float k() {
        TmcLogger.c("PlayerInstance", "getStartTime:### id=" + this.f30397b);
        return this.f30405k / 1000.0f;
    }

    public float l() {
        TmcLogger.c("PlayerInstance", "getVolume:### id=" + this.f30397b);
        return this.f30404j;
    }

    public boolean m() {
        try {
            MediaPlayer mediaPlayer = this.f30407m;
            return mediaPlayer != null && mediaPlayer.isPlaying();
        } catch (Exception e11) {
            TmcLogger.n(Log.getStackTraceString(e11));
            return false;
        }
    }

    public boolean o() {
        try {
            if (m()) {
                this.f30407m.pause();
                this.f30400f = true;
                this.f30401g = false;
                b(PlayType.ON_PAUSE);
            }
            return true;
        } catch (Exception e11) {
            TmcLogger.h("PlayerInstance", e11);
            return false;
        }
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i11) {
        TmcLogger.f("PlayerInstance", "onBufferingUpdate i=" + i11);
        this.f30406l = i11;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f30401g = true;
        b(PlayType.ON_ENDED);
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i11, int i12) {
        String str;
        String str2 = i11 == 1 ? "UNKNOWN_ERROR" : "SERVER_DIED";
        if (i12 == -1010) {
            str = "ERROR_UNSUPPORTED";
        } else if (i12 == -1007) {
            str = "ERROR_MALFORMED";
        } else if (i12 == -1004) {
            str = "IO_ERROR";
        } else if (i12 != -110) {
            str = "error code , what is : " + i11 + "   extra is :" + i12;
        } else {
            str = "TIMED_OUT_ERROR";
        }
        this.f30396a.a(PlayType.ON_ERROR, str2 + "\t" + str, this.f30397b);
        return false;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        b(PlayType.ON_CAN_PLAY);
        if (mediaPlayer.isPlaying()) {
            return;
        }
        b(PlayType.ON_PLAY);
        if (!this.f30409o) {
            mediaPlayer.start();
            this.f30400f = false;
        } else {
            this.f30400f = true;
            this.f30398c = true;
            b(PlayType.ON_PAUSE);
        }
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        b(PlayType.ON_SEEKED);
    }

    public boolean p() {
        try {
            if (m()) {
                if (!this.f30408n) {
                    this.f30407m.pause();
                    this.f30400f = true;
                }
                return true;
            }
            MediaPlayer mediaPlayer = this.f30407m;
            if (mediaPlayer != null) {
                if (this.f30400f || this.f30401g) {
                    mediaPlayer.start();
                    b(PlayType.ON_PLAY);
                } else {
                    this.f30401g = false;
                    mediaPlayer.prepareAsync();
                    b(PlayType.ON_WAITING);
                }
                this.f30400f = false;
            }
            return true;
        } catch (Exception e11) {
            TmcLogger.h("PlayerInstance", e11);
            return false;
        }
    }

    public void q() {
        this.f30400f = false;
        this.f30398c = false;
        MediaPlayer mediaPlayer = this.f30407m;
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }

    public void r() {
        TmcLogger.c("PlayerInstance", "removeMonitors");
        this.f30407m.setOnPreparedListener(null);
        this.f30407m.setOnBufferingUpdateListener(null);
        this.f30407m.setOnErrorListener(null);
        this.f30407m.setOnSeekCompleteListener(null);
        this.f30407m.setOnCompletionListener(null);
    }

    public boolean s(float f11) {
        boolean z11 = false;
        try {
            MediaPlayer mediaPlayer = this.f30407m;
            if (mediaPlayer == null) {
                return false;
            }
            mediaPlayer.seekTo(Math.round(f11 * 1000.0f));
            z11 = true;
            b(PlayType.ON_SEEKING);
            return true;
        } catch (Exception e11) {
            TmcLogger.n(Log.getStackTraceString(e11));
            return z11;
        }
    }

    public boolean t(boolean z11) {
        TmcLogger.c("PlayerInstance", "setAutoPlay:### id=" + this.f30397b + "### autoPlay=" + z11);
        this.f30402h = z11;
        if (!z11 || TextUtils.isEmpty(this.f30399d) || m()) {
            return true;
        }
        p();
        return true;
    }

    public boolean u(boolean z11) {
        TmcLogger.c("PlayerInstance", "setLoop:### id=" + this.f30397b + ", loop=" + z11);
        this.f30403i = z11;
        this.f30407m.setLooping(z11);
        return true;
    }

    public boolean v(String str) {
        TmcLogger.c("PlayerInstance", "setSrc:### id=" + this.f30397b);
        if (!TextUtils.isEmpty(this.f30399d)) {
            TmcLogger.f("PlayerInstance", "must not set mutli src ### src=" + str);
            return false;
        }
        try {
            str = g(str);
        } catch (Throwable th2) {
            TmcLogger.g("PlayerInstance", "setSrc Error:### id=" + this.f30397b, th2);
        }
        if (TextUtils.isEmpty(str)) {
            TmcLogger.c("PlayerInstance", "setSrc: param is invaild ### src=" + str);
            return false;
        }
        this.f30399d = str;
        try {
            this.f30407m.setDataSource(str);
            if (!this.f30402h) {
                return true;
            }
            TmcLogger.c("PlayerInstance", "OnAutoPlay true,call play when setSrc = " + str);
            this.f30407m.prepareAsync();
            b(PlayType.ON_WAITING);
            return true;
        } catch (Exception e11) {
            TmcLogger.n(Log.getStackTraceString(e11));
            b(PlayType.ON_ERROR);
            return false;
        }
    }

    public boolean w(int i11) {
        TmcLogger.c("PlayerInstance", "setStartTime:### id=" + this.f30397b + ", startTime=" + i11);
        this.f30405k = i11 * 1000;
        return true;
    }

    public boolean x(float f11) {
        TmcLogger.c("PlayerInstance", "setVolume:### id=" + this.f30397b + ", volume=" + f11);
        if (f11 < 0.0f || f11 > 1.0f) {
            TmcLogger.c("PlayerInstance", "setVolume invalid param.");
            return false;
        }
        this.f30407m.setVolume(f11, f11);
        this.f30404j = f11;
        return true;
    }

    public boolean y() {
        boolean z11 = false;
        try {
            MediaPlayer mediaPlayer = this.f30407m;
            if (mediaPlayer == null) {
                return false;
            }
            mediaPlayer.stop();
            this.f30400f = false;
            this.f30398c = false;
            this.f30401g = false;
            z11 = true;
            b(PlayType.ON_STOP);
            return true;
        } catch (Exception e11) {
            TmcLogger.n(Log.getStackTraceString(e11));
            return z11;
        }
    }
}
