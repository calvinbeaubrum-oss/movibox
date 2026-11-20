package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.logging.type.LogSeverity;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcfp extends zzcfr implements TextureView.SurfaceTextureListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener {
    private static final Map zzc;
    private final zzcgl zzd;
    private final zzcgm zze;
    private final boolean zzf;
    private int zzg;
    private int zzh;
    private MediaPlayer zzi;
    private Uri zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private zzcgj zzn;
    private final boolean zzo;
    private int zzp;
    private zzcfq zzq;
    private boolean zzr;
    private Integer zzs;

    static {
        HashMap map = new HashMap();
        zzc = map;
        map.put(-1004, "MEDIA_ERROR_IO");
        map.put(-1007, "MEDIA_ERROR_MALFORMED");
        map.put(-1010, "MEDIA_ERROR_UNSUPPORTED");
        map.put(-110, "MEDIA_ERROR_TIMED_OUT");
        map.put(3, "MEDIA_INFO_VIDEO_RENDERING_START");
        map.put(100, "MEDIA_ERROR_SERVER_DIED");
        map.put(1, "MEDIA_ERROR_UNKNOWN");
        map.put(1, "MEDIA_INFO_UNKNOWN");
        map.put(Integer.valueOf(LogSeverity.ALERT_VALUE), "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        map.put(701, "MEDIA_INFO_BUFFERING_START");
        map.put(702, "MEDIA_INFO_BUFFERING_END");
        map.put(Integer.valueOf(LogSeverity.EMERGENCY_VALUE), "MEDIA_INFO_BAD_INTERLEAVING");
        map.put(801, "MEDIA_INFO_NOT_SEEKABLE");
        map.put(802, "MEDIA_INFO_METADATA_UPDATE");
        map.put(901, "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
        map.put(902, "MEDIA_INFO_SUBTITLE_TIMED_OUT");
    }

    public zzcfp(Context context, zzcgl zzcglVar, boolean z11, boolean z12, zzcgk zzcgkVar, zzcgm zzcgmVar) {
        super(context);
        this.zzg = 0;
        this.zzh = 0;
        this.zzr = false;
        this.zzs = null;
        setSurfaceTextureListener(this);
        this.zzd = zzcglVar;
        this.zze = zzcgmVar;
        this.zzo = z11;
        this.zzf = z12;
        zzcgmVar.zza(this);
    }

    private final void zzD() {
        com.google.android.gms.ads.internal.util.zze.zza("AdMediaPlayerView init MediaPlayer");
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (this.zzj == null || surfaceTexture == null) {
            return;
        }
        zzE(false);
        try {
            com.google.android.gms.ads.internal.zzt.zzk();
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.zzi = mediaPlayer;
            mediaPlayer.setOnBufferingUpdateListener(this);
            this.zzi.setOnCompletionListener(this);
            this.zzi.setOnErrorListener(this);
            this.zzi.setOnInfoListener(this);
            this.zzi.setOnPreparedListener(this);
            this.zzi.setOnVideoSizeChangedListener(this);
            this.zzm = 0;
            if (this.zzo) {
                zzcgj zzcgjVar = new zzcgj(getContext());
                this.zzn = zzcgjVar;
                zzcgjVar.zzd(surfaceTexture, getWidth(), getHeight());
                this.zzn.start();
                SurfaceTexture surfaceTextureZzb = this.zzn.zzb();
                if (surfaceTextureZzb != null) {
                    surfaceTexture = surfaceTextureZzb;
                } else {
                    this.zzn.zze();
                    this.zzn = null;
                }
            }
            this.zzi.setDataSource(getContext(), this.zzj);
            com.google.android.gms.ads.internal.zzt.zzl();
            this.zzi.setSurface(new Surface(surfaceTexture));
            this.zzi.setAudioStreamType(3);
            this.zzi.setScreenOnWhilePlaying(true);
            this.zzi.prepareAsync();
            zzF(1);
        } catch (IOException e11) {
            e = e11;
            zzcec.zzk("Failed to initialize MediaPlayer at ".concat(String.valueOf(this.zzj)), e);
            onError(this.zzi, 1, 0);
        } catch (IllegalArgumentException e12) {
            e = e12;
            zzcec.zzk("Failed to initialize MediaPlayer at ".concat(String.valueOf(this.zzj)), e);
            onError(this.zzi, 1, 0);
        } catch (IllegalStateException e13) {
            e = e13;
            zzcec.zzk("Failed to initialize MediaPlayer at ".concat(String.valueOf(this.zzj)), e);
            onError(this.zzi, 1, 0);
        }
    }

    private final void zzE(boolean z11) {
        com.google.android.gms.ads.internal.util.zze.zza("AdMediaPlayerView release");
        zzcgj zzcgjVar = this.zzn;
        if (zzcgjVar != null) {
            zzcgjVar.zze();
            this.zzn = null;
        }
        MediaPlayer mediaPlayer = this.zzi;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.zzi.release();
            this.zzi = null;
            zzF(0);
            if (z11) {
                this.zzh = 0;
            }
        }
    }

    private final void zzF(int i11) {
        if (i11 == 3) {
            this.zze.zzc();
            this.zzb.zzb();
        } else if (this.zzg == 3) {
            this.zze.zze();
            this.zzb.zzc();
        }
        this.zzg = i11;
    }

    private final void zzG(float f11) {
        MediaPlayer mediaPlayer = this.zzi;
        if (mediaPlayer == null) {
            zzcec.zzj("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
        } else {
            try {
                mediaPlayer.setVolume(f11, f11);
            } catch (IllegalStateException unused) {
            }
        }
    }

    private final boolean zzH() {
        int i11;
        return (this.zzi == null || (i11 = this.zzg) == -1 || i11 == 0 || i11 == 1) ? false : true;
    }

    public static /* bridge */ /* synthetic */ void zzl(zzcfp zzcfpVar, MediaPlayer mediaPlayer) {
        MediaFormat format;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbQ)).booleanValue() || zzcfpVar.zzd == null || mediaPlayer == null) {
            return;
        }
        try {
            MediaPlayer.TrackInfo[] trackInfo = mediaPlayer.getTrackInfo();
            if (trackInfo != null) {
                HashMap map = new HashMap();
                for (MediaPlayer.TrackInfo trackInfo2 : trackInfo) {
                    if (trackInfo2 != null) {
                        int trackType = trackInfo2.getTrackType();
                        if (trackType == 1) {
                            MediaFormat format2 = trackInfo2.getFormat();
                            if (format2 != null) {
                                if (format2.containsKey("frame-rate")) {
                                    try {
                                        map.put("frameRate", String.valueOf(format2.getFloat("frame-rate")));
                                    } catch (ClassCastException unused) {
                                        map.put("frameRate", String.valueOf(format2.getInteger("frame-rate")));
                                    }
                                }
                                if (format2.containsKey("bitrate")) {
                                    Integer numValueOf = Integer.valueOf(format2.getInteger("bitrate"));
                                    zzcfpVar.zzs = numValueOf;
                                    map.put("bitRate", String.valueOf(numValueOf));
                                }
                                if (format2.containsKey("width") && format2.containsKey("height")) {
                                    map.put("resolution", format2.getInteger("width") + "x" + format2.getInteger("height"));
                                }
                                if (format2.containsKey("mime")) {
                                    map.put("videoMime", format2.getString("mime"));
                                }
                                if (Build.VERSION.SDK_INT >= 30 && format2.containsKey("codecs-string")) {
                                    map.put("videoCodec", format2.getString("codecs-string"));
                                }
                            }
                        } else if (trackType == 2 && (format = trackInfo2.getFormat()) != null) {
                            if (format.containsKey("mime")) {
                                map.put("audioMime", format.getString("mime"));
                            }
                            if (Build.VERSION.SDK_INT >= 30 && format.containsKey("codecs-string")) {
                                map.put("audioCodec", format.getString("codecs-string"));
                            }
                        }
                    }
                }
                if (map.isEmpty()) {
                    return;
                }
                zzcfpVar.zzd.zzd("onMetadataEvent", map);
            }
        } catch (RuntimeException e11) {
            com.google.android.gms.ads.internal.zzt.zzo().zzw(e11, "AdMediaPlayerView.reportMetadata");
        }
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i11) {
        this.zzm = i11;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        com.google.android.gms.ads.internal.util.zze.zza("AdMediaPlayerView completion");
        zzF(5);
        this.zzh = 5;
        com.google.android.gms.ads.internal.util.zzt.zza.post(new zzcfi(this));
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i11, int i12) {
        Map map = zzc;
        String str = (String) map.get(Integer.valueOf(i11));
        String str2 = (String) map.get(Integer.valueOf(i12));
        zzcec.zzj("AdMediaPlayerView MediaPlayer error: " + str + ":" + str2);
        zzF(-1);
        this.zzh = -1;
        com.google.android.gms.ads.internal.util.zzt.zza.post(new zzcfj(this, str, str2));
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public final boolean onInfo(MediaPlayer mediaPlayer, int i11, int i12) {
        Map map = zzc;
        com.google.android.gms.ads.internal.util.zze.zza("AdMediaPlayerView MediaPlayer info: " + ((String) map.get(Integer.valueOf(i11))) + ":" + ((String) map.get(Integer.valueOf(i12))));
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0048  */
    /* JADX WARN: Code duplicated, block: B:26:0x0056 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:27:0x0058  */
    /* JADX WARN: Code duplicated, block: B:32:0x0067  */
    /* JADX WARN: Code duplicated, block: B:36:0x0073  */
    @Override // android.view.View
    public final void onMeasure(int i11, int i12) {
        int i13;
        int i14;
        int i15;
        int i16;
        int defaultSize = View.getDefaultSize(this.zzk, i11);
        int defaultSize2 = View.getDefaultSize(this.zzl, i12);
        if (this.zzk > 0 && this.zzl > 0 && this.zzn == null) {
            int mode = View.MeasureSpec.getMode(i11);
            int size = View.MeasureSpec.getSize(i11);
            int mode2 = View.MeasureSpec.getMode(i12);
            int size2 = View.MeasureSpec.getSize(i12);
            if (mode != 1073741824) {
                if (mode == 1073741824) {
                    i16 = (this.zzl * size) / this.zzk;
                    if (mode2 == Integer.MIN_VALUE || i16 <= size2) {
                        defaultSize2 = i16;
                        defaultSize = size;
                    }
                    defaultSize = size;
                    defaultSize2 = size2;
                } else {
                    if (mode2 == 1073741824) {
                        i15 = (this.zzk * size2) / this.zzl;
                        if (mode != Integer.MIN_VALUE && i15 > size) {
                            defaultSize = size;
                        }
                        defaultSize2 = size2;
                    } else {
                        i13 = this.zzk;
                        i14 = this.zzl;
                        if (mode2 == Integer.MIN_VALUE || i14 <= size2) {
                            i15 = i13;
                            size2 = i14;
                        } else {
                            i15 = (size2 * i13) / i14;
                        }
                        if (mode == Integer.MIN_VALUE && i15 > size) {
                            defaultSize2 = (i14 * size) / i13;
                            defaultSize = size;
                        }
                    }
                    defaultSize = i15;
                    defaultSize2 = size2;
                }
            } else if (mode2 == 1073741824) {
                int i17 = this.zzk;
                int i18 = i17 * size2;
                int i19 = this.zzl;
                int i21 = size * i19;
                if (i18 < i21) {
                    defaultSize = i18 / i19;
                } else {
                    if (i18 > i21) {
                        defaultSize2 = i21 / i17;
                        defaultSize = size;
                    }
                    defaultSize = size;
                }
                defaultSize2 = size2;
            } else {
                mode = 1073741824;
                if (mode == 1073741824) {
                    i16 = (this.zzl * size) / this.zzk;
                    if (mode2 == Integer.MIN_VALUE) {
                    }
                    defaultSize2 = i16;
                    defaultSize = size;
                } else {
                    if (mode2 == 1073741824) {
                        i15 = (this.zzk * size2) / this.zzl;
                        if (mode != Integer.MIN_VALUE) {
                        }
                    } else {
                        i13 = this.zzk;
                        i14 = this.zzl;
                        if (mode2 == Integer.MIN_VALUE) {
                            i15 = i13;
                            size2 = i14;
                        } else {
                            i15 = i13;
                            size2 = i14;
                        }
                        if (mode == Integer.MIN_VALUE) {
                            defaultSize2 = (i14 * size) / i13;
                            defaultSize = size;
                        }
                    }
                    defaultSize = i15;
                    defaultSize2 = size2;
                }
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
        zzcgj zzcgjVar = this.zzn;
        if (zzcgjVar != null) {
            zzcgjVar.zzc(defaultSize, defaultSize2);
        }
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        com.google.android.gms.ads.internal.util.zze.zza("AdMediaPlayerView prepared");
        zzF(2);
        this.zze.zzb();
        com.google.android.gms.ads.internal.util.zzt.zza.post(new zzcfh(this, mediaPlayer));
        this.zzk = mediaPlayer.getVideoWidth();
        this.zzl = mediaPlayer.getVideoHeight();
        int i11 = this.zzp;
        if (i11 != 0) {
            zzq(i11);
        }
        if (this.zzf && zzH() && this.zzi.getCurrentPosition() > 0 && this.zzh != 3) {
            com.google.android.gms.ads.internal.util.zze.zza("AdMediaPlayerView nudging MediaPlayer");
            zzG(0.0f);
            this.zzi.start();
            int currentPosition = this.zzi.getCurrentPosition();
            long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis();
            while (zzH() && this.zzi.getCurrentPosition() == currentPosition && com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis() - jCurrentTimeMillis <= 250) {
            }
            this.zzi.pause();
            zzn();
        }
        zzcec.zzi("AdMediaPlayerView stream dimensions: " + this.zzk + " x " + this.zzl);
        if (this.zzh == 3) {
            zzp();
        }
        zzn();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i11, int i12) {
        com.google.android.gms.ads.internal.util.zze.zza("AdMediaPlayerView surface created");
        zzD();
        com.google.android.gms.ads.internal.util.zzt.zza.post(new zzcfk(this));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        com.google.android.gms.ads.internal.util.zze.zza("AdMediaPlayerView surface destroyed");
        MediaPlayer mediaPlayer = this.zzi;
        if (mediaPlayer != null && this.zzp == 0) {
            this.zzp = mediaPlayer.getCurrentPosition();
        }
        zzcgj zzcgjVar = this.zzn;
        if (zzcgjVar != null) {
            zzcgjVar.zze();
        }
        com.google.android.gms.ads.internal.util.zzt.zza.post(new zzcfm(this));
        zzE(true);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i11, int i12) {
        com.google.android.gms.ads.internal.util.zze.zza("AdMediaPlayerView surface changed");
        int i13 = this.zzh;
        boolean z11 = false;
        if (this.zzk == i11 && this.zzl == i12) {
            z11 = true;
        }
        if (this.zzi != null && i13 == 3 && z11) {
            int i14 = this.zzp;
            if (i14 != 0) {
                zzq(i14);
            }
            zzp();
        }
        zzcgj zzcgjVar = this.zzn;
        if (zzcgjVar != null) {
            zzcgjVar.zzc(i11, i12);
        }
        com.google.android.gms.ads.internal.util.zzt.zza.post(new zzcfl(this, i11, i12));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zze.zzf(this);
        this.zza.zza(surfaceTexture, this.zzq);
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i11, int i12) {
        com.google.android.gms.ads.internal.util.zze.zza("AdMediaPlayerView size changed: " + i11 + " x " + i12);
        this.zzk = mediaPlayer.getVideoWidth();
        int videoHeight = mediaPlayer.getVideoHeight();
        this.zzl = videoHeight;
        if (this.zzk == 0 || videoHeight == 0) {
            return;
        }
        requestLayout();
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(final int i11) {
        com.google.android.gms.ads.internal.util.zze.zza("AdMediaPlayerView window visibility changed to " + i11);
        com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfg
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzm(i11);
            }
        });
        super.onWindowVisibilityChanged(i11);
    }

    @Override // android.view.View
    public final String toString() {
        return zzcfp.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final int zza() {
        if (zzH()) {
            return this.zzi.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final int zzb() {
        if (Build.VERSION.SDK_INT < 26 || !zzH()) {
            return -1;
        }
        return this.zzi.getMetrics().getInt("android.media.mediaplayer.dropped");
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final int zzc() {
        if (zzH()) {
            return this.zzi.getDuration();
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final int zzd() {
        MediaPlayer mediaPlayer = this.zzi;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final int zze() {
        MediaPlayer mediaPlayer = this.zzi;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final long zzf() {
        return 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final long zzg() {
        if (this.zzs != null) {
            return (zzh() * ((long) this.zzm)) / 100;
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final long zzh() {
        if (this.zzs != null) {
            return ((long) zzc()) * ((long) this.zzs.intValue());
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final String zzj() {
        return "MediaPlayer".concat(true != this.zzo ? "" : " spherical");
    }

    public final /* synthetic */ void zzm(int i11) {
        zzcfq zzcfqVar = this.zzq;
        if (zzcfqVar != null) {
            zzcfqVar.onWindowVisibilityChanged(i11);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfr, com.google.android.gms.internal.ads.zzcgo
    public final void zzn() {
        zzG(this.zzb.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final void zzo() {
        com.google.android.gms.ads.internal.util.zze.zza("AdMediaPlayerView pause");
        if (zzH() && this.zzi.isPlaying()) {
            this.zzi.pause();
            zzF(4);
            com.google.android.gms.ads.internal.util.zzt.zza.post(new zzcfo(this));
        }
        this.zzh = 4;
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final void zzp() {
        com.google.android.gms.ads.internal.util.zze.zza("AdMediaPlayerView play");
        if (zzH()) {
            this.zzi.start();
            zzF(3);
            this.zza.zzb();
            com.google.android.gms.ads.internal.util.zzt.zza.post(new zzcfn(this));
        }
        this.zzh = 3;
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final void zzq(int i11) {
        com.google.android.gms.ads.internal.util.zze.zza("AdMediaPlayerView seek " + i11);
        if (!zzH()) {
            this.zzp = i11;
        } else {
            this.zzi.seekTo(i11);
            this.zzp = 0;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final void zzr(zzcfq zzcfqVar) {
        this.zzq = zzcfqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final void zzs(@Nullable String str) {
        Uri uri = Uri.parse(str);
        zzbbb zzbbbVarZza = zzbbb.zza(uri);
        if (zzbbbVarZza == null || zzbbbVarZza.zza != null) {
            if (zzbbbVarZza != null) {
                uri = Uri.parse(zzbbbVarZza.zza);
            }
            this.zzj = uri;
            this.zzp = 0;
            zzD();
            requestLayout();
            invalidate();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final void zzt() {
        com.google.android.gms.ads.internal.util.zze.zza("AdMediaPlayerView stop");
        MediaPlayer mediaPlayer = this.zzi;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.zzi.release();
            this.zzi = null;
            zzF(0);
            this.zzh = 0;
        }
        this.zze.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final void zzu(float f11, float f12) {
        zzcgj zzcgjVar = this.zzn;
        if (zzcgjVar != null) {
            zzcgjVar.zzf(f11, f12);
        }
    }
}
