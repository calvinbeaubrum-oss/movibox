package ln;

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
    public final Context f70342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AudioManager f70343b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f70344c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f70345d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f70346e;

    public d(Handler handler, Context context, a aVar, c cVar) {
        super(handler);
        this.f70342a = context;
        this.f70343b = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.f70344c = aVar;
        this.f70345d = cVar;
    }

    public final float a() {
        return this.f70344c.a(this.f70343b.getStreamVolume(3), this.f70343b.getStreamMaxVolume(3));
    }

    public final boolean b(float f11) {
        return f11 != this.f70346e;
    }

    public final void c() {
        this.f70345d.a(this.f70346e);
    }

    public void d() {
        this.f70346e = a();
        c();
        this.f70342a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    public void e() {
        this.f70342a.getContentResolver().unregisterContentObserver(this);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z11) {
        super.onChange(z11);
        float fA = a();
        if (b(fA)) {
            this.f70346e = fA;
            c();
        }
    }
}
