package com.cloud.hisavana.sdk;

import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.bean.ProgressData;
import com.cloud.hisavana.sdk.common.bean.VastData;
import com.cloud.hisavana.sdk.common.bean.VastTracking;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.google.android.exoplayer2.PlaybackException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public abstract class f0 implements q0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f29704d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f29705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f29706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AdsDTO f29707c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public f0() {
    }

    public f0(AdsDTO adsDTO) {
        this();
        this.f29707c = adsDTO;
    }

    @Override // com.cloud.hisavana.sdk.q0
    public void a() {
        VastData videoInfo;
        VastTracking vastTrack;
        AdsDTO adsDTO = this.f29707c;
        if (adsDTO == null || adsDTO.getSource() != 4) {
            AdsDTO adsDTO2 = this.f29707c;
            o1.j((adsDTO2 == null || (videoInfo = adsDTO2.getVideoInfo()) == null || (vastTrack = videoInfo.getVastTrack()) == null) ? null : vastTrack.getStartTrack(), this.f29707c);
            g(2);
        }
    }

    @Override // com.cloud.hisavana.sdk.q0
    public void b(long j11, long j12, int i11) {
        String thirdQuarter;
        AdsDTO adsDTO = this.f29707c;
        if (adsDTO == null || adsDTO.getSource() == 4) {
            return;
        }
        AdsDTO adsDTO2 = this.f29707c;
        VastData videoInfo = adsDTO2 != null ? adsDTO2.getVideoInfo() : null;
        if (videoInfo == null) {
            return;
        }
        ProgressData progressData = videoInfo.getProgressData();
        if (progressData == null) {
            f();
        }
        if (progressData != null) {
            progressData.setProgress(Integer.valueOf(i11));
        }
        VastTracking vastTrack = videoInfo.getVastTrack();
        if (vastTrack == null) {
            return;
        }
        z.a().i("Rewarded", "progress : " + i11);
        if (25 > i11 || i11 >= 50) {
            if (50 > i11 || i11 >= 75) {
                if (i11 < 75 || this.f29706b >= 75) {
                    return;
                }
                this.f29706b = 75;
                h(5, 75);
                thirdQuarter = vastTrack.getThirdQuarter();
            } else {
                if (this.f29706b >= 50) {
                    return;
                }
                this.f29706b = 50;
                h(5, 50);
                thirdQuarter = vastTrack.getMidpoint();
            }
        } else {
            if (this.f29706b >= 25) {
                return;
            }
            this.f29706b = 25;
            h(5, 25);
            thirdQuarter = vastTrack.getQuarter();
        }
        o1.j(thirdQuarter, this.f29707c);
    }

    @Override // com.cloud.hisavana.sdk.q0
    public void c(boolean z11) {
        z.a().d("AdMediaPlayerListener", "onVideoClickToPauseOrPlay isPlay " + z11);
        AdsDTO adsDTO = this.f29707c;
        if (adsDTO == null || adsDTO.getSource() != 4) {
            f();
            g(4);
        }
    }

    @Override // com.cloud.hisavana.sdk.q0
    public void d() {
        f();
    }

    @Override // com.cloud.hisavana.sdk.q0
    public void e(boolean z11) {
        z.a().d("AdMediaPlayerListener", "onCompanion ");
        AdsDTO adsDTO = this.f29707c;
        if (adsDTO == null || adsDTO.getSource() != 4) {
            f();
            if (z11) {
                g(1);
            }
        }
    }

    public final void f() {
        AdsDTO adsDTO = this.f29707c;
        if (adsDTO != null) {
            VastData videoInfo = adsDTO.getVideoInfo();
            ProgressData progressData = videoInfo != null ? videoInfo.getProgressData() : null;
            if (progressData == null) {
                progressData = new ProgressData(null, null, null, false, 15, null);
                if (videoInfo != null) {
                    videoInfo.setProgressData(progressData);
                }
            }
            Integer duration = videoInfo != null ? videoInfo.getDuration() : null;
            if (duration == null) {
                duration = 0;
            }
            progressData.setDuration(duration);
        }
    }

    public final void g(int i11) {
        h(i11, -1);
    }

    public final void h(int i11, int i12) {
        VastData videoInfo;
        AdsDTO adsDTO = this.f29707c;
        if (adsDTO == null || adsDTO.getSource() == 4) {
            return;
        }
        AdsDTO adsDTO2 = this.f29707c;
        ProgressData progressData = (adsDTO2 == null || (videoInfo = adsDTO2.getVideoInfo()) == null) ? null : videoInfo.getProgressData();
        if (progressData != null) {
            progressData.setVideoPlayTimeType(Integer.valueOf(i11));
        }
        ProgressData progressDataCopy$default = progressData != null ? ProgressData.copy$default(progressData, null, null, null, false, 15, null) : null;
        if (i12 > 0 && progressDataCopy$default != null) {
            progressDataCopy$default.setProgress(Integer.valueOf(i12));
        }
        AthenaTracker.n0(this.f29707c, progressDataCopy$default);
    }

    public final void i() {
        g(6);
    }

    @Override // com.cloud.hisavana.sdk.q0
    public void onComplete() {
        VastData videoInfo;
        VastTracking vastTrack;
        AdsDTO adsDTO = this.f29707c;
        if (adsDTO == null || adsDTO.getSource() != 4) {
            g(7);
            AdsDTO adsDTO2 = this.f29707c;
            o1.j((adsDTO2 == null || (videoInfo = adsDTO2.getVideoInfo()) == null || (vastTrack = videoInfo.getVastTrack()) == null) ? null : vastTrack.getComplete(), this.f29707c);
        }
    }

    @Override // com.cloud.hisavana.sdk.q0
    public void onIsPlayingChanged(boolean z11) {
        this.f29705a = z11;
    }

    @Override // com.cloud.hisavana.sdk.q0
    public void onPlayerError(PlaybackException playbackException) {
        String string;
        AdsDTO adsDTO = this.f29707c;
        if (adsDTO == null || adsDTO.getSource() != 4) {
            if (playbackException == null || (string = Integer.valueOf(playbackException.errorCode).toString()) == null) {
                string = "";
            }
            AdsDTO adsDTO2 = this.f29707c;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(string);
            sb2.append(playbackException != null ? playbackException.getMessage() : null);
            AthenaTracker.m0(adsDTO2, new TaErrorCode(TaErrorCode.VAST_VIDEO_PLAY_ERROR, sb2.toString()));
        }
    }

    @Override // com.cloud.hisavana.sdk.q0
    public void onVideoSizeChanged(int i11, int i12) {
    }

    @Override // com.cloud.hisavana.sdk.q0
    public void onVolumeChanged(float f11) {
    }
}
