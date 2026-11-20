package rn;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f75642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AudioManager f75643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f75644c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f75645d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f75646e;

    public d(Handler handler, Context context, a aVar, c cVar) {
        super(handler);
        this.f75642a = context;
        this.f75643b = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.f75644c = aVar;
        this.f75645d = cVar;
    }

    public void a() {
        this.f75646e = d();
        e();
        this.f75642a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    public final boolean b(float f11) {
        return f11 != this.f75646e;
    }

    public void c() {
        this.f75642a.getContentResolver().unregisterContentObserver(this);
    }

    public final float d() {
        return this.f75644c.a(this.f75643b.getStreamVolume(3), this.f75643b.getStreamMaxVolume(3));
    }

    public final void e() {
        this.f75645d.a(this.f75646e);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z11) {
        super.onChange(z11);
        float fD = d();
        if (b(fD)) {
            this.f75646e = fD;
            e();
        }
    }
}
