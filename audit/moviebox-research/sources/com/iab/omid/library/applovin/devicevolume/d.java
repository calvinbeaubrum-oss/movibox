package com.iab.omid.library.applovin.devicevolume;

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
    private final Context f42109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AudioManager f42110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f42111c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f42112d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f42113e;

    public d(Handler handler, Context context, a aVar, c cVar) {
        super(handler);
        this.f42109a = context;
        this.f42110b = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.f42111c = aVar;
        this.f42112d = cVar;
    }

    private float a() {
        return this.f42111c.a(this.f42110b.getStreamVolume(3), this.f42110b.getStreamMaxVolume(3));
    }

    private boolean a(float f11) {
        return f11 != this.f42113e;
    }

    private void b() {
        this.f42112d.a(this.f42113e);
    }

    public void c() {
        this.f42113e = a();
        b();
        this.f42109a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    public void d() {
        this.f42109a.getContentResolver().unregisterContentObserver(this);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z11) {
        super.onChange(z11);
        float fA = a();
        if (a(fA)) {
            this.f42113e = fA;
            b();
        }
    }
}
