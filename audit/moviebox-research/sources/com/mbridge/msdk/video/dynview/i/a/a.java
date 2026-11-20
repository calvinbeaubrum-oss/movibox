package com.mbridge.msdk.video.dynview.i.a;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.f.b;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.o;
import com.mbridge.msdk.video.dynview.c;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f47622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f47623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Bitmap f47624c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Bitmap f47625d;

    private a() {
    }

    public static a a() {
        a aVar;
        if (f47622a != null) {
            return f47622a;
        }
        synchronized (a.class) {
            try {
                if (f47622a == null) {
                    f47622a = new a();
                }
                aVar = f47622a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aVar;
    }

    private synchronized void a(final int i11, final float f11, final float f12, final Bitmap bitmap, Bitmap bitmap2) {
        try {
            b.a().execute(new Runnable() { // from class: com.mbridge.msdk.video.dynview.i.a.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        Bitmap bitmapA = o.a(bitmap, 10);
                        Bitmap bitmapA2 = o.a(bitmap, 10);
                        final com.mbridge.msdk.video.dynview.g.a.C0524a c0524aA = com.mbridge.msdk.video.dynview.g.a.a();
                        c0524aA.a(i11).a(bitmapA).b(bitmapA2);
                        if (i11 == 2) {
                            float f13 = f11;
                            float f14 = f12;
                            if (f13 > f14) {
                                c0524aA.a(f13).b(f12);
                            } else {
                                c0524aA.a(f14).b(f11);
                            }
                        } else {
                            c0524aA.a(f11).b(f12);
                        }
                        if (a.this.f47623b != null) {
                            a.this.f47623b.post(new Runnable() { // from class: com.mbridge.msdk.video.dynview.i.a.a.1.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    if (a.this.f47623b == null || c0524aA.a() == null) {
                                        return;
                                    }
                                    a.this.f47623b.setBackground(c0524aA.a());
                                }
                            });
                        }
                    } catch (Exception e11) {
                        ad.b("ChoiceOneDrawBitBg", e11.getMessage());
                    }
                }
            });
        } catch (Exception e11) {
            ad.a("ChoiceOneDrawBitBg", e11.getMessage());
        }
    }

    public final void a(Map<String, Bitmap> map, c cVar, View view) {
        if (view == null || cVar == null || map == null || map.size() == 0 || map.size() < 2 || cVar.g() == null || cVar.g().size() < 2) {
            return;
        }
        this.f47623b = view;
        int iE = cVar.e();
        float fD = cVar.d();
        float fC = cVar.c();
        try {
            List<CampaignEx> listG = cVar.g();
            String md5 = listG.get(0) != null ? SameMD5.getMD5(listG.get(0).getImageUrl()) : "";
            String md6 = listG.get(1) != null ? SameMD5.getMD5(listG.get(1).getImageUrl()) : "";
            Bitmap bitmap = (TextUtils.isEmpty(md5) || !map.containsKey(md5)) ? null : map.get(md5);
            Bitmap bitmap2 = (TextUtils.isEmpty(md6) || !map.containsKey(md6)) ? null : map.get(md6);
            if (bitmap == null || bitmap.isRecycled() || bitmap2 == null || bitmap2.isRecycled()) {
                return;
            }
            a(iE, fD, fC, bitmap, bitmap2);
        } catch (Exception e11) {
            ad.b("ChoiceOneDrawBitBg", e11.getMessage());
        }
    }

    public final void b() {
        if (this.f47623b != null) {
            this.f47623b = null;
        }
        Bitmap bitmap = this.f47624c;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f47624c.recycle();
            this.f47624c = null;
        }
        Bitmap bitmap2 = this.f47625d;
        if (bitmap2 == null || bitmap2.isRecycled()) {
            return;
        }
        this.f47625d.recycle();
        this.f47625d = null;
    }
}
