package com.iab.omid.library.bytedance2.devicevolume;

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
    private final Context f42238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AudioManager f42239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f42240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f42241d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f42242e;

    public d(Handler handler, Context context, a aVar, c cVar) {
        super(handler);
        this.f42238a = context;
        this.f42239b = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.f42240c = aVar;
        this.f42241d = cVar;
    }

    private float a() {
        return this.f42240c.a(this.f42239b.getStreamVolume(3), this.f42239b.getStreamMaxVolume(3));
    }

    private boolean a(float f11) {
        return f11 != this.f42242e;
    }

    private void b() {
        this.f42241d.a(this.f42242e);
    }

    public void c() {
        this.f42242e = a();
        b();
        this.f42238a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    public void d() {
        this.f42238a.getContentResolver().unregisterContentObserver(this);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z11) {
        super.onChange(z11);
        float fA = a();
        if (a(fA)) {
            this.f42242e = fA;
            b();
        }
    }
}
