package com.mbridge.msdk.foundation.same.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.foundation.tools.ai;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f44435a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.mbridge.msdk.foundation.same.a.c<String, Bitmap> f44437c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.mbridge.msdk.foundation.same.e.b f44439e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LinkedHashMap<String, List<c>> f44436b = new LinkedHashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Handler f44438d = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.foundation.same.c.b.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                int i11 = message.what;
                if (i11 == 1) {
                    String string = message.getData().getString("message_key");
                    Bitmap bitmapA = a.a(message.getData().getString("message_bitmap"));
                    b.this.a(string, bitmapA);
                    LinkedList<c> linkedList = (LinkedList) b.this.f44436b.get(string);
                    if (linkedList != null) {
                        for (c cVar : linkedList) {
                            if (cVar != null) {
                                cVar.onSuccessLoad(bitmapA, string);
                            }
                        }
                    }
                    b.this.f44436b.remove(string);
                    return;
                }
                if (i11 == 2) {
                    String string2 = message.getData().getString("message_key");
                    String string3 = message.getData().getString("message_message");
                    LinkedList<c> linkedList2 = (LinkedList) b.this.f44436b.get(string2);
                    if (linkedList2 != null) {
                        for (c cVar2 : linkedList2) {
                            if (cVar2 != null) {
                                cVar2.onFailedLoad(string3, string2);
                            }
                        }
                    }
                    b.this.f44436b.remove(string2);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    };

    private b(Context context) {
        this.f44439e = new com.mbridge.msdk.foundation.same.e.b(context);
        com.mbridge.msdk.c.g gVarA = com.mbridge.msdk.c.h.a().a(com.mbridge.msdk.foundation.controller.c.m().k());
        int iQ = gVarA != null ? gVarA.Q() : 10;
        this.f44437c = new com.mbridge.msdk.foundation.same.a.a(((int) Runtime.getRuntime().maxMemory()) / (iQ > 0 ? iQ : 10));
    }

    public static b a(Context context) {
        if (f44435a == null) {
            f44435a = new b(context);
        }
        return f44435a;
    }

    public static void a() {
        if (g.c()) {
            return;
        }
        f44435a.b();
    }

    public static /* synthetic */ void a(b bVar, final String str, final Bitmap bitmap, final c cVar) {
        if (MBridgeConstans.DEBUG) {
            ad.a("ImageLoader", "handler image load success event");
        }
        if (cVar == null) {
            return;
        }
        bVar.f44438d.post(new Runnable() { // from class: com.mbridge.msdk.foundation.same.c.b.3
            @Override // java.lang.Runnable
            public final void run() {
                c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.onSuccessLoad(bitmap, str);
                    try {
                        LinkedList<c> linkedList = (LinkedList) b.this.f44436b.get(str);
                        if (linkedList != null) {
                            linkedList.remove(cVar);
                            for (c cVar3 : linkedList) {
                                if (cVar3 != null) {
                                    cVar3.onSuccessLoad(bitmap, str);
                                }
                            }
                        }
                        b.this.f44436b.remove(str);
                    } catch (Throwable th2) {
                        ad.b("ImageLoader", th2.getMessage());
                    }
                }
            }
        });
    }

    public static /* synthetic */ void a(b bVar, final String str, final String str2, final c cVar) {
        if (MBridgeConstans.DEBUG) {
            ad.a("ImageLoader", "handler image load failed event");
        }
        if (cVar == null) {
            return;
        }
        bVar.f44438d.post(new Runnable() { // from class: com.mbridge.msdk.foundation.same.c.b.4
            @Override // java.lang.Runnable
            public final void run() {
                c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.onFailedLoad(str2, str);
                    try {
                        LinkedList<c> linkedList = (LinkedList) b.this.f44436b.get(str);
                        if (linkedList != null) {
                            linkedList.remove(cVar);
                            for (c cVar3 : linkedList) {
                                if (cVar3 != null) {
                                    cVar3.onFailedLoad(str2, str);
                                }
                            }
                        }
                        b.this.f44436b.remove(str);
                    } catch (Throwable th2) {
                        ad.b("ImageLoader", th2.getMessage());
                    }
                }
            }
        });
    }

    public static /* synthetic */ void a(b bVar, final String str, String str2, String str3, boolean z11, boolean z12, final c cVar, final h hVar) {
        if (bVar.f44436b.containsKey(str2)) {
            LinkedList linkedList = (LinkedList) bVar.f44436b.get(str2);
            if (linkedList == null || linkedList.contains(cVar)) {
                return;
            }
            linkedList.add(cVar);
            return;
        }
        LinkedList linkedList2 = new LinkedList();
        linkedList2.add(cVar);
        bVar.f44436b.put(str2, linkedList2);
        e.a aVar = new e.a() { // from class: com.mbridge.msdk.foundation.same.c.b.5
            @Override // com.mbridge.msdk.foundation.same.c.e.a
            public final void a(String str4, String str5) {
                Bitmap bitmapA = a.a(str5);
                if (bitmapA == null || bitmapA.isRecycled()) {
                    b.a(b.this, str, "bitmap file not found", cVar);
                    return;
                }
                h hVar2 = hVar;
                if (hVar2 == null) {
                    b.a(b.this, str, bitmapA, cVar);
                    return;
                }
                try {
                    Bitmap bitmapA2 = hVar2.a(bitmapA);
                    if (bitmapA2 != null) {
                        b.a(b.this, str, bitmapA2, cVar);
                    } else {
                        b.a(b.this, str, "bitmap transform failed", cVar);
                    }
                } catch (Exception unused) {
                    b.a(b.this, str, "bitmap transform failed", cVar);
                }
            }

            @Override // com.mbridge.msdk.foundation.same.c.e.a
            public final void b(String str4, String str5) {
                b.a(b.this, str, str5, cVar);
            }
        };
        e eVar = new e(str, str2, str3, hVar);
        eVar.a(z11);
        eVar.a(aVar);
        com.mbridge.msdk.foundation.same.f.b.d().execute(eVar);
    }

    private void a(String str, String str2, String str3, boolean z11, boolean z12, c cVar) {
        if (this.f44436b.containsKey(str2)) {
            LinkedList linkedList = (LinkedList) this.f44436b.get(str2);
            if (linkedList == null || linkedList.contains(cVar)) {
                return;
            }
            linkedList.add(cVar);
            return;
        }
        LinkedList linkedList2 = new LinkedList();
        linkedList2.add(cVar);
        this.f44436b.put(str2, linkedList2);
        e.a aVar = new e.a() { // from class: com.mbridge.msdk.foundation.same.c.b.6
            @Override // com.mbridge.msdk.foundation.same.c.e.a
            public final void a(String str4, String str5) {
                Message messageObtainMessage = b.this.f44438d.obtainMessage();
                messageObtainMessage.what = 1;
                Bundle bundle = new Bundle();
                bundle.putString("message_key", str4);
                bundle.putString("message_bitmap", str5);
                messageObtainMessage.setData(bundle);
                b.this.f44438d.sendMessage(messageObtainMessage);
            }

            @Override // com.mbridge.msdk.foundation.same.c.e.a
            public final void b(String str4, String str5) {
                Message messageObtainMessage = b.this.f44438d.obtainMessage();
                messageObtainMessage.what = 2;
                Bundle bundle = new Bundle();
                bundle.putString("message_key", str4);
                bundle.putString("message_message", str5);
                messageObtainMessage.setData(bundle);
                b.this.f44438d.sendMessage(messageObtainMessage);
            }
        };
        e eVar = new e(str, str2, str3);
        eVar.a(z11);
        eVar.a(aVar);
        this.f44439e.a(eVar);
    }

    private Bitmap d(String str) {
        return this.f44437c.b(str);
    }

    public final void a(String str) {
        if (g.c()) {
            return;
        }
        try {
            com.mbridge.msdk.foundation.same.a.c<String, Bitmap> cVar = this.f44437c;
            if (cVar == null || !cVar.a().contains(str)) {
                return;
            }
            this.f44437c.a(str);
        } catch (Throwable th2) {
            ad.b("ImageLoader", th2.getMessage());
        }
    }

    public final void a(String str, Bitmap bitmap) {
        if (d(str) != null || bitmap == null) {
            return;
        }
        this.f44437c.a(str, bitmap);
    }

    public final void a(final String str, final c cVar) {
        if (g.c()) {
            d.a.f44469a.a(str, null, cVar);
            return;
        }
        final String strA = ah.a(str);
        if (g.b()) {
            final boolean z11 = false;
            final h hVar = null;
            if (ai.k(str) || ai.k(str) || ai.k(strA)) {
                return;
            }
            if (g.c()) {
                d.a.f44469a.a(str, null, cVar);
                return;
            } else {
                g.a().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.c.b.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (!new File(strA).exists()) {
                            b.a(b.this, str, str, strA, false, z11, cVar, hVar);
                            return;
                        }
                        Bitmap bitmapA = a.a(strA);
                        if (bitmapA == null || bitmapA.isRecycled()) {
                            b.a(b.this, str, str, strA, true, z11, cVar, hVar);
                            return;
                        }
                        h hVar2 = hVar;
                        if (hVar2 == null) {
                            b.a(b.this, str, bitmapA, cVar);
                            return;
                        }
                        try {
                            Bitmap bitmapA2 = hVar2.a(bitmapA);
                            if (bitmapA2 != null) {
                                b.a(b.this, str, bitmapA2, cVar);
                            } else {
                                b.a(b.this, str, "image transform failed", cVar);
                            }
                        } catch (Exception unused) {
                            b.a(b.this, str, "image transform failed", cVar);
                        }
                    }
                });
                return;
            }
        }
        if (ai.k(str) || ai.k(str) || ai.k(strA)) {
            return;
        }
        if (g.c()) {
            d.a.f44469a.a(str, null, cVar);
            return;
        }
        File file = new File(strA);
        Bitmap bitmapD = d(str);
        if (bitmapD != null && !bitmapD.isRecycled()) {
            cVar.onSuccessLoad(bitmapD, str);
            return;
        }
        if (!file.exists()) {
            a(str, str, strA, false, false, cVar);
            return;
        }
        Bitmap bitmapA = a.a(strA);
        if (bitmapA == null || bitmapA.isRecycled()) {
            a(str, str, strA, true, false, cVar);
        } else {
            a(str, bitmapA);
            cVar.onSuccessLoad(bitmapA, str);
        }
    }

    public final Bitmap b(String str) {
        Bitmap bitmapA;
        if (ai.k(str)) {
            return null;
        }
        if (g.c()) {
            return d.a.f44469a.a(str);
        }
        String strA = ah.a(str);
        File file = new File(strA);
        if (d(str) != null) {
            return d(str);
        }
        if (!file.exists() || (bitmapA = a.a(strA)) == null) {
            return null;
        }
        a(str, bitmapA);
        return bitmapA;
    }

    public final void b() {
        com.mbridge.msdk.foundation.same.a.c<String, Bitmap> cVar;
        if (g.c() || (cVar = this.f44437c) == null) {
            return;
        }
        cVar.b();
    }

    public final void c() {
        if (g.c()) {
            return;
        }
        this.f44437c.b();
        LinkedHashMap<String, List<c>> linkedHashMap = this.f44436b;
        if (linkedHashMap != null) {
            linkedHashMap.clear();
        }
    }

    public final boolean c(String str) {
        if (ai.k(str)) {
            return false;
        }
        if (g.c()) {
            return d.a.f44469a.b(str);
        }
        File file = new File(ah.a(str));
        if (d(str) != null) {
            return true;
        }
        return file.exists() && file.isFile() && file.length() > 1;
    }
}
