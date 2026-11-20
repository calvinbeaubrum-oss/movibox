package com.cloud.hisavana.sdk.common.http.listener;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import com.cloud.hisavana.sdk.common.bean.AdImage;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.e1;
import com.cloud.hisavana.sdk.z;
import com.cloud.sdk.commonutil.util.Preconditions;
import com.cloud.sdk.commonutil.util.f;
import pl.droidsonroids.gif.GifDrawable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class DrawableResponseListener extends ResponseBaseListener {

    /* JADX INFO: renamed from: com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public class AnonymousClass2 implements Runnable {
        final /* synthetic */ byte[] val$data;
        final /* synthetic */ String val$filePath;
        final /* synthetic */ int val$mime;
        final /* synthetic */ int val$statusCode;

        /* JADX INFO: renamed from: com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener$2$a */
        /* JADX INFO: compiled from: source.java */
        public class a implements Preconditions.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Drawable f29455a;

            public a(Drawable drawable) {
                this.f29455a = drawable;
            }

            @Override // com.cloud.sdk.commonutil.util.Preconditions.a
            public void onRun() {
                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                if (anonymousClass2.val$mime == -1) {
                    DrawableResponseListener.this.a(new TaErrorCode(TaErrorCode.CODE_BITMAP_TAKE_FAILED, "parse bitmap error."));
                    return;
                }
                DrawableResponseListener drawableResponseListener = DrawableResponseListener.this;
                int i11 = anonymousClass2.val$statusCode;
                AnonymousClass2 anonymousClass3 = AnonymousClass2.this;
                drawableResponseListener.g(i11, new AdImage(anonymousClass3.val$mime, this.f29455a, anonymousClass3.val$filePath));
            }
        }

        public AnonymousClass2(int i11, byte[] bArr, int i12, String str) {
            this.val$mime = i11;
            this.val$data = bArr;
            this.val$statusCode = i12;
            this.val$filePath = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0() {
            DrawableResponseListener.this.a(new TaErrorCode(TaErrorCode.CODE_FILE_NO_SUPPORT, "bitmap is not support."));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$1() {
            DrawableResponseListener.this.a(new TaErrorCode(TaErrorCode.CODE_BITMAP_TOO_LARGE, "bitmap is too large."));
        }

        @Override // java.lang.Runnable
        public void run() {
            final Drawable bitmapDrawable;
            try {
                if (this.val$mime == 2) {
                    if (Build.VERSION.SDK_INT >= 35) {
                        Handler handler = DrawableResponseListener.this.f29457a;
                        if (handler != null) {
                            handler.post(new Runnable() { // from class: com.cloud.hisavana.sdk.common.http.listener.a
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f29459a.lambda$run$0();
                                }
                            });
                            return;
                        }
                        return;
                    }
                    bitmapDrawable = new GifDrawable(this.val$data);
                } else {
                    if (e1.r(f.a(), this.val$data)) {
                        Handler handler2 = DrawableResponseListener.this.f29457a;
                        if (handler2 != null) {
                            handler2.post(new Runnable() { // from class: com.cloud.hisavana.sdk.common.http.listener.b
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f29460a.lambda$run$1();
                                }
                            });
                            return;
                        }
                        return;
                    }
                    byte[] bArr = this.val$data;
                    bitmapDrawable = new BitmapDrawable(f.a().getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                }
            } catch (Throwable th2) {
                z.a().e(Log.getStackTraceString(th2));
                bitmapDrawable = null;
            }
            Handler handler3 = DrawableResponseListener.this.f29457a;
            if (handler3 != null) {
                handler3.post(new Runnable() { // from class: com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        if (anonymousClass2.val$mime == -1) {
                            DrawableResponseListener.this.a(new TaErrorCode(TaErrorCode.CODE_BITMAP_TAKE_FAILED, "parse bitmap error."));
                            return;
                        }
                        DrawableResponseListener drawableResponseListener = DrawableResponseListener.this;
                        int i11 = anonymousClass2.val$statusCode;
                        AnonymousClass2 anonymousClass3 = AnonymousClass2.this;
                        drawableResponseListener.g(i11, new AdImage(anonymousClass3.val$mime, bitmapDrawable, anonymousClass3.val$filePath));
                    }
                });
            } else {
                Preconditions.d(new a(bitmapDrawable));
            }
        }
    }

    public abstract void g(int i11, AdImage adImage);

    public final void h(int i11, final int i12, byte[] bArr, final String str) {
        final int i13;
        if (bArr.length > 1) {
            i13 = bArr[0] == 71 ? 2 : 1;
        } else {
            i13 = -1;
        }
        if (i11 != 3) {
            com.cloud.sdk.commonutil.pool.b.b().a(new AnonymousClass2(i13, bArr, i12, str));
            return;
        }
        Handler handler = this.f29457a;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener.1
                @Override // java.lang.Runnable
                public void run() {
                    DrawableResponseListener.this.g(i12, new AdImage(i13, null, str));
                }
            });
        } else {
            g(i12, new AdImage(i13, null, str));
        }
    }
}
