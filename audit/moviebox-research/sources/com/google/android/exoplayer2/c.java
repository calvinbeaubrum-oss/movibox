package com.google.android.exoplayer2;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AudioManager f32993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f32994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public b f32995c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public com.google.android.exoplayer2.audio.e f32996d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f32998f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AudioFocusRequest f33000h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f33001i;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f32999g = 1.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f32997e = 0;

    /* JADX INFO: compiled from: source.java */
    public class a implements AudioManager.OnAudioFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f33002a;

        public a(Handler handler) {
            this.f33002a = handler;
        }

        public final /* synthetic */ void b(int i11) {
            c.this.h(i11);
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i11) {
            this.f33002a.post(new Runnable() { // from class: com.google.android.exoplayer2.b
                @Override // java.lang.Runnable
                public final void run() {
                    this.f32973a.b(i11);
                }
            });
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void u(float f11);

        void v(int i11);
    }

    public c(Context context, Handler handler, b bVar) {
        this.f32993a = (AudioManager) com.google.android.exoplayer2.util.a.e((AudioManager) context.getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO));
        this.f32995c = bVar;
        this.f32994b = new a(handler);
    }

    public static int e(@Nullable com.google.android.exoplayer2.audio.e eVar) {
        if (eVar == null) {
            return 0;
        }
        switch (eVar.f32810c) {
            case 0:
                com.google.android.exoplayer2.util.s.i("AudioFocusManager", "Specify a proper usage in the audio attributes for audio focus handling. Using AUDIOFOCUS_GAIN by default.");
                return 1;
            case 1:
            case 14:
                return 1;
            case 2:
            case 4:
                return 2;
            case 3:
                return 0;
            case 11:
                if (eVar.f32808a == 1) {
                    return 2;
                }
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 12:
            case 13:
                return 3;
            case 15:
            default:
                com.google.android.exoplayer2.util.s.i("AudioFocusManager", "Unidentified audio usage: " + eVar.f32810c);
                return 0;
            case 16:
                return com.google.android.exoplayer2.util.o0.f35608a >= 19 ? 4 : 2;
        }
    }

    public final void a() {
        this.f32993a.abandonAudioFocus(this.f32994b);
    }

    public final void b() {
        if (this.f32997e == 0) {
            return;
        }
        if (com.google.android.exoplayer2.util.o0.f35608a >= 26) {
            c();
        } else {
            a();
        }
        n(0);
    }

    @RequiresApi(26)
    public final void c() {
        AudioFocusRequest audioFocusRequest = this.f33000h;
        if (audioFocusRequest != null) {
            this.f32993a.abandonAudioFocusRequest(audioFocusRequest);
        }
    }

    public final void f(int i11) {
        b bVar = this.f32995c;
        if (bVar != null) {
            bVar.v(i11);
        }
    }

    public float g() {
        return this.f32999g;
    }

    public final void h(int i11) {
        if (i11 == -3 || i11 == -2) {
            if (i11 != -2 && !q()) {
                n(3);
                return;
            } else {
                f(0);
                n(2);
                return;
            }
        }
        if (i11 == -1) {
            f(-1);
            b();
        } else if (i11 == 1) {
            n(1);
            f(1);
        } else {
            com.google.android.exoplayer2.util.s.i("AudioFocusManager", "Unknown focus change type: " + i11);
        }
    }

    public void i() {
        this.f32995c = null;
        b();
    }

    public final int j() {
        if (this.f32997e == 1) {
            return 1;
        }
        if ((com.google.android.exoplayer2.util.o0.f35608a >= 26 ? l() : k()) == 1) {
            n(1);
            return 1;
        }
        n(0);
        return -1;
    }

    public final int k() {
        return this.f32993a.requestAudioFocus(this.f32994b, com.google.android.exoplayer2.util.o0.g0(((com.google.android.exoplayer2.audio.e) com.google.android.exoplayer2.util.a.e(this.f32996d)).f32810c), this.f32998f);
    }

    @RequiresApi(26)
    public final int l() {
        AudioFocusRequest.Builder builderA;
        AudioFocusRequest audioFocusRequest = this.f33000h;
        if (audioFocusRequest == null || this.f33001i) {
            if (audioFocusRequest == null) {
                androidx.media3.exoplayer.d.a();
                builderA = androidx.media3.exoplayer.b.a(this.f32998f);
            } else {
                androidx.media3.exoplayer.d.a();
                builderA = androidx.media3.exoplayer.c.a(this.f33000h);
            }
            this.f33000h = builderA.setAudioAttributes(((com.google.android.exoplayer2.audio.e) com.google.android.exoplayer2.util.a.e(this.f32996d)).b().f32814a).setWillPauseWhenDucked(q()).setOnAudioFocusChangeListener(this.f32994b).build();
            this.f33001i = false;
        }
        return this.f32993a.requestAudioFocus(this.f33000h);
    }

    public void m(@Nullable com.google.android.exoplayer2.audio.e eVar) {
        if (com.google.android.exoplayer2.util.o0.c(this.f32996d, eVar)) {
            return;
        }
        this.f32996d = eVar;
        int iE = e(eVar);
        this.f32998f = iE;
        boolean z11 = true;
        if (iE != 1 && iE != 0) {
            z11 = false;
        }
        com.google.android.exoplayer2.util.a.b(z11, "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME.");
    }

    public final void n(int i11) {
        if (this.f32997e == i11) {
            return;
        }
        this.f32997e = i11;
        float f11 = i11 == 3 ? 0.2f : 1.0f;
        if (this.f32999g == f11) {
            return;
        }
        this.f32999g = f11;
        b bVar = this.f32995c;
        if (bVar != null) {
            bVar.u(f11);
        }
    }

    public final boolean o(int i11) {
        return i11 == 1 || this.f32998f != 1;
    }

    public int p(boolean z11, int i11) {
        if (o(i11)) {
            b();
            return z11 ? 1 : -1;
        }
        if (z11) {
            return j();
        }
        return -1;
    }

    public final boolean q() {
        com.google.android.exoplayer2.audio.e eVar = this.f32996d;
        return eVar != null && eVar.f32808a == 1;
    }
}
