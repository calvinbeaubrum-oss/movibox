package com.applovin.impl;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class o1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AudioManager f21439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f21440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f21441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private l1 f21442d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f21444f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AudioFocusRequest f21446h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f21447i;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f21445g = 1.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f21443e = 0;

    /* JADX INFO: compiled from: source.java */
    public class a implements AudioManager.OnAudioFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f21448a;

        public a(Handler handler) {
            this.f21448a = handler;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(int i11) {
            o1.this.b(i11);
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i11) {
            this.f21448a.post(new Runnable() { // from class: com.applovin.impl.o00
                @Override // java.lang.Runnable
                public final void run() {
                    this.f21437a.a(i11);
                }
            });
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void b(float f11);

        void f(int i11);
    }

    public o1(Context context, Handler handler, b bVar) {
        this.f21439a = (AudioManager) b1.a((AudioManager) context.getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO));
        this.f21441c = bVar;
        this.f21440b = new a(handler);
    }

    private static int a(l1 l1Var) {
        if (l1Var == null) {
            return 0;
        }
        switch (l1Var.f20316c) {
            case 0:
                pc.d("AudioFocusManager", "Specify a proper usage in the audio attributes for audio focus handling. Using AUDIOFOCUS_GAIN by default.");
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
                if (l1Var.f20314a == 1) {
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
                pc.d("AudioFocusManager", "Unidentified audio usage: " + l1Var.f20316c);
                return 0;
            case 16:
                return xp.f24372a >= 19 ? 4 : 2;
        }
    }

    private void a() {
        this.f21439a.abandonAudioFocus(this.f21440b);
    }

    private void a(int i11) {
        b bVar = this.f21441c;
        if (bVar != null) {
            bVar.f(i11);
        }
    }

    private void b() {
        if (this.f21443e == 0) {
            return;
        }
        if (xp.f24372a >= 26) {
            c();
        } else {
            a();
        }
        c(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i11) {
        if (i11 == -3 || i11 == -2) {
            if (i11 != -2 && !i()) {
                c(3);
                return;
            } else {
                a(0);
                c(2);
                return;
            }
        }
        if (i11 == -1) {
            a(-1);
            b();
        } else if (i11 == 1) {
            c(1);
            a(1);
        } else {
            pc.d("AudioFocusManager", "Unknown focus change type: " + i11);
        }
    }

    private void c() {
        AudioFocusRequest audioFocusRequest = this.f21446h;
        if (audioFocusRequest != null) {
            this.f21439a.abandonAudioFocusRequest(audioFocusRequest);
        }
    }

    private void c(int i11) {
        if (this.f21443e == i11) {
            return;
        }
        this.f21443e = i11;
        float f11 = i11 == 3 ? 0.2f : 1.0f;
        if (this.f21445g == f11) {
            return;
        }
        this.f21445g = f11;
        b bVar = this.f21441c;
        if (bVar != null) {
            bVar.b(f11);
        }
    }

    private boolean d(int i11) {
        return i11 == 1 || this.f21444f != 1;
    }

    private int f() {
        if (this.f21443e == 1) {
            return 1;
        }
        if ((xp.f24372a >= 26 ? h() : g()) == 1) {
            c(1);
            return 1;
        }
        c(0);
        return -1;
    }

    private int g() {
        return this.f21439a.requestAudioFocus(this.f21440b, xp.e(((l1) b1.a(this.f21442d)).f20316c), this.f21444f);
    }

    private int h() {
        AudioFocusRequest.Builder builderA;
        AudioFocusRequest audioFocusRequest = this.f21446h;
        if (audioFocusRequest == null || this.f21447i) {
            if (audioFocusRequest == null) {
                androidx.media3.exoplayer.d.a();
                builderA = androidx.media3.exoplayer.b.a(this.f21444f);
            } else {
                androidx.media3.exoplayer.d.a();
                builderA = androidx.media3.exoplayer.c.a(this.f21446h);
            }
            this.f21446h = builderA.setAudioAttributes(((l1) b1.a(this.f21442d)).a()).setWillPauseWhenDucked(i()).setOnAudioFocusChangeListener(this.f21440b).build();
            this.f21447i = false;
        }
        return this.f21439a.requestAudioFocus(this.f21446h);
    }

    private boolean i() {
        l1 l1Var = this.f21442d;
        return l1Var != null && l1Var.f20314a == 1;
    }

    public int a(boolean z11, int i11) {
        if (d(i11)) {
            b();
            return z11 ? 1 : -1;
        }
        if (z11) {
            return f();
        }
        return -1;
    }

    public void b(l1 l1Var) {
        if (xp.a(this.f21442d, l1Var)) {
            return;
        }
        this.f21442d = l1Var;
        int iA = a(l1Var);
        this.f21444f = iA;
        boolean z11 = true;
        if (iA != 1 && iA != 0) {
            z11 = false;
        }
        b1.a(z11, "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME.");
    }

    public float d() {
        return this.f21445g;
    }

    public void e() {
        this.f21441c = null;
        b();
    }
}
