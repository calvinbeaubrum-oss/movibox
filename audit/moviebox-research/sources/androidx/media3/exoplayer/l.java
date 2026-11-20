package androidx.media3.exoplayer;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AudioManager f10655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f10656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public b f10657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public androidx.media3.common.d f10658d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f10660f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AudioFocusRequest f10662h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f10663i;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f10661g = 1.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f10659e = 0;

    /* JADX INFO: compiled from: source.java */
    public class a implements AudioManager.OnAudioFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f10664a;

        public a(Handler handler) {
            this.f10664a = handler;
        }

        public final /* synthetic */ void b(int i11) {
            l.this.h(i11);
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i11) {
            this.f10664a.post(new Runnable() { // from class: androidx.media3.exoplayer.k
                @Override // java.lang.Runnable
                public final void run() {
                    this.f10647a.b(i11);
                }
            });
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void u(float f11);

        void v(int i11);
    }

    public l(Context context, Handler handler, b bVar) {
        this.f10655a = (AudioManager) z3.a.e((AudioManager) context.getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO));
        this.f10657c = bVar;
        this.f10656b = new a(handler);
    }

    public static int e(@Nullable androidx.media3.common.d dVar) {
        if (dVar == null) {
            return 0;
        }
        switch (dVar.f9132c) {
            case 0:
                z3.o.h("AudioFocusManager", "Specify a proper usage in the audio attributes for audio focus handling. Using AUDIOFOCUS_GAIN by default.");
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
                if (dVar.f9130a == 1) {
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
                z3.o.h("AudioFocusManager", "Unidentified audio usage: " + dVar.f9132c);
                return 0;
            case 16:
                return z3.u0.f81838a >= 19 ? 4 : 2;
        }
    }

    public final void a() {
        this.f10655a.abandonAudioFocus(this.f10656b);
    }

    public final void b() {
        if (this.f10659e == 0) {
            return;
        }
        if (z3.u0.f81838a >= 26) {
            c();
        } else {
            a();
        }
        n(0);
    }

    @RequiresApi(26)
    public final void c() {
        AudioFocusRequest audioFocusRequest = this.f10662h;
        if (audioFocusRequest != null) {
            this.f10655a.abandonAudioFocusRequest(audioFocusRequest);
        }
    }

    public final void f(int i11) {
        b bVar = this.f10657c;
        if (bVar != null) {
            bVar.v(i11);
        }
    }

    public float g() {
        return this.f10661g;
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
            z3.o.h("AudioFocusManager", "Unknown focus change type: " + i11);
        }
    }

    public void i() {
        this.f10657c = null;
        b();
    }

    public final int j() {
        if (this.f10659e == 1) {
            return 1;
        }
        if ((z3.u0.f81838a >= 26 ? l() : k()) == 1) {
            n(1);
            return 1;
        }
        n(0);
        return -1;
    }

    public final int k() {
        return this.f10655a.requestAudioFocus(this.f10656b, z3.u0.p0(((androidx.media3.common.d) z3.a.e(this.f10658d)).f9132c), this.f10660f);
    }

    @RequiresApi(26)
    public final int l() {
        AudioFocusRequest.Builder builderA;
        AudioFocusRequest audioFocusRequest = this.f10662h;
        if (audioFocusRequest == null || this.f10663i) {
            if (audioFocusRequest == null) {
                d.a();
                builderA = androidx.media3.exoplayer.b.a(this.f10660f);
            } else {
                d.a();
                builderA = c.a(this.f10662h);
            }
            this.f10662h = builderA.setAudioAttributes(((androidx.media3.common.d) z3.a.e(this.f10658d)).a().f9136a).setWillPauseWhenDucked(q()).setOnAudioFocusChangeListener(this.f10656b).build();
            this.f10663i = false;
        }
        return this.f10655a.requestAudioFocus(this.f10662h);
    }

    public void m(@Nullable androidx.media3.common.d dVar) {
        if (z3.u0.c(this.f10658d, dVar)) {
            return;
        }
        this.f10658d = dVar;
        int iE = e(dVar);
        this.f10660f = iE;
        boolean z11 = true;
        if (iE != 1 && iE != 0) {
            z11 = false;
        }
        z3.a.b(z11, "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME.");
    }

    public final void n(int i11) {
        if (this.f10659e == i11) {
            return;
        }
        this.f10659e = i11;
        float f11 = i11 == 3 ? 0.2f : 1.0f;
        if (this.f10661g == f11) {
            return;
        }
        this.f10661g = f11;
        b bVar = this.f10657c;
        if (bVar != null) {
            bVar.u(f11);
        }
    }

    public final boolean o(int i11) {
        return i11 == 1 || this.f10660f != 1;
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
        androidx.media3.common.d dVar = this.f10658d;
        return dVar != null && dVar.f9130a == 1;
    }
}
