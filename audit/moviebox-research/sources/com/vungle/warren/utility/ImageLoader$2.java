package com.vungle.warren.utility;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
class ImageLoader$2 implements Runnable {
    final /* synthetic */ l this$0;
    final /* synthetic */ l.b val$listener;
    final /* synthetic */ String val$uri;

    public ImageLoader$2(l lVar, String str, l.b bVar) {
        this.this$0 = lVar;
        this.val$uri = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.val$uri.startsWith("file://")) {
            Bitmap bitmap = (Bitmap) this.this$0.f62604a.get(this.val$uri);
            if (bitmap == null || bitmap.isRecycled()) {
                Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(this.val$uri.substring(7));
                if (bitmapDecodeFile != null) {
                    this.this$0.f62604a.put(this.val$uri, bitmapDecodeFile);
                } else {
                    Log.w(l.f62602b, "decode bitmap failed.");
                }
            }
        }
    }
}
