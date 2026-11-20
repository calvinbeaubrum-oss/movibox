package androidx.media3.exoplayer.audio;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import f4.k;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f9921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f9922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f9923c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final c f9924d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final BroadcastReceiver f9925e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final d f9926f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public f4.e f9927g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public k f9928h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public androidx.media3.common.d f9929i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f9930j;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(23)
    public static final class b {
        public static void a(Context context, AudioDeviceCallback audioDeviceCallback, Handler handler) {
            ((AudioManager) z3.a.e((AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO))).registerAudioDeviceCallback(audioDeviceCallback, handler);
        }

        public static void b(Context context, AudioDeviceCallback audioDeviceCallback) {
            ((AudioManager) z3.a.e((AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO))).unregisterAudioDeviceCallback(audioDeviceCallback);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(23)
    public final class c extends AudioDeviceCallback {
        public c() {
        }

        @Override // android.media.AudioDeviceCallback
        public void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
            a aVar = a.this;
            aVar.f(f4.e.g(aVar.f9921a, a.this.f9929i, a.this.f9928h));
        }

        @Override // android.media.AudioDeviceCallback
        public void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
            if (u0.s(audioDeviceInfoArr, a.this.f9928h)) {
                a.this.f9928h = null;
            }
            a aVar = a.this;
            aVar.f(f4.e.g(aVar.f9921a, a.this.f9929i, a.this.f9928h));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class d extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ContentResolver f9932a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Uri f9933b;

        public d(Handler handler, ContentResolver contentResolver, Uri uri) {
            super(handler);
            this.f9932a = contentResolver;
            this.f9933b = uri;
        }

        public void a() {
            this.f9932a.registerContentObserver(this.f9933b, false, this);
        }

        public void b() {
            this.f9932a.unregisterContentObserver(this);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z11) {
            a aVar = a.this;
            aVar.f(f4.e.g(aVar.f9921a, a.this.f9929i, a.this.f9928h));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class e extends BroadcastReceiver {
        public e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (isInitialStickyBroadcast()) {
                return;
            }
            a aVar = a.this;
            aVar.f(f4.e.f(context, intent, aVar.f9929i, a.this.f9928h));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface f {
        void a(f4.e eVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Context context, f fVar, androidx.media3.common.d dVar, @Nullable k kVar) {
        Context applicationContext = context.getApplicationContext();
        this.f9921a = applicationContext;
        this.f9922b = (f) z3.a.e(fVar);
        this.f9929i = dVar;
        this.f9928h = kVar;
        Handler handlerC = u0.C();
        this.f9923c = handlerC;
        int i11 = u0.f81838a;
        Object[] objArr = 0;
        this.f9924d = i11 >= 23 ? new c() : null;
        this.f9925e = i11 >= 21 ? new e() : null;
        Uri uriJ = f4.e.j();
        this.f9926f = uriJ != null ? new d(handlerC, applicationContext.getContentResolver(), uriJ) : null;
    }

    public final void f(f4.e eVar) {
        if (!this.f9930j || eVar.equals(this.f9927g)) {
            return;
        }
        this.f9927g = eVar;
        this.f9922b.a(eVar);
    }

    public f4.e g() {
        c cVar;
        if (this.f9930j) {
            return (f4.e) z3.a.e(this.f9927g);
        }
        this.f9930j = true;
        d dVar = this.f9926f;
        if (dVar != null) {
            dVar.a();
        }
        if (u0.f81838a >= 23 && (cVar = this.f9924d) != null) {
            b.a(this.f9921a, cVar, this.f9923c);
        }
        f4.e eVarF = f4.e.f(this.f9921a, this.f9925e != null ? this.f9921a.registerReceiver(this.f9925e, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"), null, this.f9923c) : null, this.f9929i, this.f9928h);
        this.f9927g = eVarF;
        return eVarF;
    }

    public void h(androidx.media3.common.d dVar) {
        this.f9929i = dVar;
        f(f4.e.g(this.f9921a, dVar, this.f9928h));
    }

    @RequiresApi(23)
    public void i(@Nullable AudioDeviceInfo audioDeviceInfo) {
        k kVar = this.f9928h;
        if (u0.c(audioDeviceInfo, kVar == null ? null : kVar.f64562a)) {
            return;
        }
        k kVar2 = audioDeviceInfo != null ? new k(audioDeviceInfo) : null;
        this.f9928h = kVar2;
        f(f4.e.g(this.f9921a, this.f9929i, kVar2));
    }

    public void j() {
        c cVar;
        if (this.f9930j) {
            this.f9927g = null;
            if (u0.f81838a >= 23 && (cVar = this.f9924d) != null) {
                b.b(this.f9921a, cVar);
            }
            BroadcastReceiver broadcastReceiver = this.f9925e;
            if (broadcastReceiver != null) {
                this.f9921a.unregisterReceiver(broadcastReceiver);
            }
            d dVar = this.f9926f;
            if (dVar != null) {
                dVar.b();
            }
            this.f9930j = false;
        }
    }
}
