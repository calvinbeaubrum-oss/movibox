package androidx.media3.exoplayer.audio;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.f0;
import androidx.media3.common.y;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.vungle.warren.error.VungleException;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f implements DefaultAudioSink.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final Context f9980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f9981b;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public static final class a {
        public static androidx.media3.exoplayer.audio.b a(AudioFormat audioFormat, AudioAttributes audioAttributes, boolean z11) {
            return !AudioManager.isOffloadedPlaybackSupported(audioFormat, audioAttributes) ? androidx.media3.exoplayer.audio.b.f9936d : new androidx.media3.exoplayer.audio.b.C0094b().e(true).g(z11).d();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.WEB_CRASH)
    public static final class b {
        public static androidx.media3.exoplayer.audio.b a(AudioFormat audioFormat, AudioAttributes audioAttributes, boolean z11) {
            int playbackOffloadSupport = AudioManager.getPlaybackOffloadSupport(audioFormat, audioAttributes);
            if (playbackOffloadSupport == 0) {
                return androidx.media3.exoplayer.audio.b.f9936d;
            }
            return new androidx.media3.exoplayer.audio.b.C0094b().e(true).f(u0.f81838a > 32 && playbackOffloadSupport == 2).g(z11).d();
        }
    }

    public f(@Nullable Context context) {
        this.f9980a = context;
    }

    @Override // androidx.media3.exoplayer.audio.DefaultAudioSink.d
    public androidx.media3.exoplayer.audio.b a(y yVar, androidx.media3.common.d dVar) {
        z3.a.e(yVar);
        z3.a.e(dVar);
        int i11 = u0.f81838a;
        if (i11 < 29 || yVar.A == -1) {
            return androidx.media3.exoplayer.audio.b.f9936d;
        }
        boolean zB = b(this.f9980a);
        int iF = f0.f((String) z3.a.e(yVar.f9501m), yVar.f9498j);
        if (iF == 0 || i11 < u0.K(iF)) {
            return androidx.media3.exoplayer.audio.b.f9936d;
        }
        int iM = u0.M(yVar.f9514z);
        if (iM == 0) {
            return androidx.media3.exoplayer.audio.b.f9936d;
        }
        try {
            AudioFormat audioFormatL = u0.L(yVar.A, iM, iF);
            return i11 >= 31 ? b.a(audioFormatL, dVar.a().f9136a, zB) : a.a(audioFormatL, dVar.a().f9136a, zB);
        } catch (IllegalArgumentException unused) {
            return androidx.media3.exoplayer.audio.b.f9936d;
        }
    }

    public final boolean b(@Nullable Context context) {
        AudioManager audioManager;
        Boolean bool = this.f9981b;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (context == null || (audioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO)) == null) {
            this.f9981b = Boolean.FALSE;
        } else {
            String parameters = audioManager.getParameters("offloadVariableRateSupported");
            this.f9981b = Boolean.valueOf(parameters != null && parameters.equals("offloadVariableRateSupported=1"));
        }
        return this.f9981b.booleanValue();
    }
}
