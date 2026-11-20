package com.android.volley.toolbox;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class ImageLoader$4 implements Runnable {
    final /* synthetic */ h this$0;

    public ImageLoader$4(h hVar) {
    }

    @Override // java.lang.Runnable
    public void run() {
        for (h.a aVar : h.b(null).values()) {
            for (h.b bVar : aVar.f16581d) {
                if (bVar.f16583b != null) {
                    if (aVar.c() == null) {
                        bVar.f16582a = aVar.f16579b;
                        bVar.f16583b.a(bVar, false);
                    } else {
                        bVar.f16583b.onErrorResponse(aVar.c());
                    }
                }
            }
        }
        h.b(null).clear();
        h.c(null, null);
    }
}
