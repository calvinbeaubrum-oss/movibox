package com.cloud.hisavana.sdk.common.http;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.cloud.hisavana.net.HttpRequest;
import com.cloud.hisavana.net.RequestParams;
import com.cloud.hisavana.net.disklrucache.utils.DiskLruCacheUtil;
import com.cloud.hisavana.net.impl.HttpCallbackImpl;
import com.cloud.hisavana.sdk.api.config.AdManager;
import com.cloud.hisavana.sdk.common.bean.AdImage;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.e1;
import com.cloud.hisavana.sdk.z;
import com.cloud.sdk.commonutil.util.Preconditions;
import com.cloud.sdk.commonutil.util.f;
import com.cloud.sdk.commonutil.util.l;
import com.cloud.sdk.commonutil.util.t;
import java.io.File;
import okhttp3.Headers;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class DownLoadRequest extends com.cloud.hisavana.sdk.common.http.b<DrawableResponseListener> {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static boolean f29427p = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f29428c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f29429d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f29430e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f29431f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f29432g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f29433h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f29434i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f29435j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f29436k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f29437l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f29438m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f29439n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f29440o;

    /* JADX INFO: renamed from: com.cloud.hisavana.sdk.common.http.DownLoadRequest$3, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public class AnonymousClass3 implements Runnable {
        final /* synthetic */ String val$filePath;
        final /* synthetic */ ImageView val$imageView;
        final /* synthetic */ DrawableResponseListener val$listener;

        /* JADX INFO: renamed from: com.cloud.hisavana.sdk.common.http.DownLoadRequest$3$a */
        /* JADX INFO: compiled from: source.java */
        public class a implements Preconditions.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Bitmap f29447a;

            public a(Bitmap bitmap) {
                this.f29447a = bitmap;
            }

            @Override // com.cloud.sdk.commonutil.util.Preconditions.a
            public void onRun() {
                Bitmap bitmap = this.f29447a;
                if (bitmap == null) {
                    DrawableResponseListener drawableResponseListener = AnonymousClass3.this.val$listener;
                    if (drawableResponseListener != null) {
                        drawableResponseListener.a(TaErrorCode.ERROR_BITMAP_TAKE_FAILED);
                        return;
                    }
                    return;
                }
                AnonymousClass3.this.val$imageView.setImageBitmap(bitmap);
                DrawableResponseListener drawableResponseListener2 = AnonymousClass3.this.val$listener;
                if (drawableResponseListener2 != null) {
                    drawableResponseListener2.g(200, null);
                }
            }
        }

        public AnonymousClass3(String str, DrawableResponseListener drawableResponseListener, ImageView imageView) {
            this.val$filePath = str;
            this.val$listener = drawableResponseListener;
            this.val$imageView = imageView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$run$0(DrawableResponseListener drawableResponseListener) {
            drawableResponseListener.a(TaErrorCode.ERROR_BITMAP_TOO_LARGE);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!e1.o(f.a(), this.val$filePath)) {
                    Preconditions.d(new a(BitmapFactory.decodeFile(this.val$filePath)));
                    return;
                }
                final DrawableResponseListener drawableResponseListener = this.val$listener;
                if (drawableResponseListener != null) {
                    Preconditions.d(new Preconditions.a() { // from class: com.cloud.hisavana.sdk.common.http.a
                        @Override // com.cloud.sdk.commonutil.util.Preconditions.a
                        public final void onRun() {
                            DownLoadRequest.AnonymousClass3.lambda$run$0(drawableResponseListener);
                        }
                    });
                }
            } catch (Throwable th2) {
                z.a().e(Log.getStackTraceString(th2));
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a extends DrawableResponseListener {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DrawableResponseListener f29449b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ImageView f29450c;

        public a(DrawableResponseListener drawableResponseListener, ImageView imageView) {
            this.f29449b = drawableResponseListener;
            this.f29450c = imageView;
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            z.a().e("DownLoadRequest", "loadImageView " + taErrorCode);
            DrawableResponseListener drawableResponseListener = this.f29449b;
            if (drawableResponseListener != null) {
                drawableResponseListener.a(taErrorCode);
            }
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
        public void g(int i11, AdImage adImage) {
            if (adImage == null) {
                DrawableResponseListener drawableResponseListener = this.f29449b;
                if (drawableResponseListener != null) {
                    drawableResponseListener.a(new TaErrorCode(TaErrorCode.CODE_BITMAP_TAKE_FAILED, "mediaBean == null."));
                    return;
                }
                return;
            }
            adImage.attachView(this.f29450c);
            DrawableResponseListener drawableResponseListener2 = this.f29449b;
            if (drawableResponseListener2 != null) {
                drawableResponseListener2.g(i11, adImage);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends HttpCallbackImpl {
        public b() {
        }

        @Override // com.cloud.hisavana.net.impl.HttpCallbackImpl
        public void j(int i11, byte[] bArr, Throwable th2) {
            z.a().d("ssp", "DownLoadRequest --> onFailure statusCode " + i11 + " e" + th2 + " url " + DownLoadRequest.this.f29437l);
            DownLoadRequest.this.f29434i = i11 == 256 ? 2 : 1;
            T t11 = DownLoadRequest.this.f29454b;
            if (t11 != 0) {
                ((DrawableResponseListener) t11).d(i11, bArr, th2);
            }
            DownLoadRequest.this.f29431f = i11;
        }

        @Override // com.cloud.hisavana.net.impl.HttpCallbackImpl
        public void m(Headers headers) {
            String strValue;
            super.m(headers);
            if (headers == null || headers.size() <= 0) {
                return;
            }
            for (int i11 = 0; i11 < headers.size(); i11++) {
                if (headers.name(i11) != null && headers.name(i11).contains("x-response-cdn") && (strValue = headers.value(i11)) != null && !strValue.isEmpty()) {
                    DownLoadRequest.this.f29429d = strValue;
                }
            }
        }

        @Override // com.cloud.hisavana.net.impl.HttpCallbackImpl
        public void o(int i11, byte[] bArr) {
            z.a().d("DownLoadRequest", "DownLoadRequest --> onSuccess statusCode " + i11 + " url " + DownLoadRequest.this.f29437l);
            DownLoadRequest.this.f29434i = i11 == 250 ? 2 : 1;
            DownLoadRequest downLoadRequest = DownLoadRequest.this;
            T t11 = downLoadRequest.f29454b;
            if (t11 != 0 && (t11 instanceof DrawableResponseListener)) {
                ((DrawableResponseListener) t11).h(downLoadRequest.f29438m, i11, bArr, null);
            }
            if (bArr != null) {
                DownLoadRequest.this.f29428c = bArr.length;
            }
            if (DownLoadRequest.this.f29433h == 3) {
                DownLoadRequest.f29427p = true;
            }
        }

        @Override // com.cloud.hisavana.net.impl.HttpCallbackImpl
        public void p(int i11, byte[] bArr, String str) {
            z.a().d("ssp", "DownLoadRequest --> onSuccess statusCode " + i11 + " filePath " + str + " url" + DownLoadRequest.this.f29437l);
            DownLoadRequest.this.f29434i = i11 == 250 ? 2 : 1;
            DownLoadRequest downLoadRequest = DownLoadRequest.this;
            T t11 = downLoadRequest.f29454b;
            if (t11 != 0 && (t11 instanceof DrawableResponseListener)) {
                ((DrawableResponseListener) t11).h(downLoadRequest.f29438m, i11, bArr, str);
            }
            if (bArr != null) {
                DownLoadRequest.this.f29428c = bArr.length;
            }
            if (DownLoadRequest.this.f29433h == 3) {
                DownLoadRequest.f29427p = true;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        void onSuccess();
    }

    public DownLoadRequest() {
        this.f29428c = 0L;
        this.f29429d = "";
        this.f29430e = 0L;
        this.f29431f = 0;
        this.f29432g = 1;
        this.f29434i = 1;
        this.f29435j = false;
        this.f29436k = false;
        this.f29437l = "";
        this.f29438m = 1;
        this.f29439n = 1;
        this.f29440o = false;
    }

    public static void k(@NonNull final String str, final int i11, final boolean z11, final int i12, final boolean z12, final int i13, final boolean z13, AdsDTO adsDTO, final DrawableResponseListener drawableResponseListener) {
        if (!e1.s(adsDTO)) {
            t.a().b(new Runnable() { // from class: com.cloud.hisavana.sdk.common.http.DownLoadRequest.5
                @Override // java.lang.Runnable
                public void run() {
                    new DownLoadRequest().w(i11).v(drawableResponseListener).x(str).s(Boolean.valueOf(z11), i12).t(i13).u(z12).n(z13).c();
                }
            });
        } else if (drawableResponseListener != null) {
            drawableResponseListener.a(new TaErrorCode(TaErrorCode.CODE_BITMAP_TOO_LARGE, "main image is too large."));
        }
    }

    public static void l(@NonNull String str, AdsDTO adsDTO, int i11, boolean z11, DrawableResponseListener drawableResponseListener) {
        k(str, 3, adsDTO == null ? false : adsDTO.isOfflineAd(), i11, z11, 1, false, adsDTO, drawableResponseListener);
    }

    public static void m(@NonNull String str, AdsDTO adsDTO, boolean z11, DrawableResponseListener drawableResponseListener) {
        k(str, 3, adsDTO == null ? false : adsDTO.isOfflineAd(), 10, z11, 3, true, adsDTO, drawableResponseListener);
    }

    public static void o(@NonNull final String str, final AdsDTO adsDTO, final DrawableResponseListener drawableResponseListener, final ImageView imageView) {
        if (TextUtils.isEmpty(str) || imageView == null) {
            if (drawableResponseListener != null) {
                drawableResponseListener.a(new TaErrorCode(TaErrorCode.CODE_BITMAP_TAKE_FAILED, "filePath == null or imageView == null."));
            }
        } else if (!e1.s(adsDTO)) {
            com.cloud.sdk.commonutil.pool.b.b().a(new Runnable() { // from class: com.cloud.hisavana.sdk.common.http.DownLoadRequest.2

                /* JADX INFO: renamed from: com.cloud.hisavana.sdk.common.http.DownLoadRequest$2$a */
                /* JADX INFO: compiled from: source.java */
                public class a implements Preconditions.a {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ boolean f29444a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ String f29445b;

                    public a(boolean z11, String str) {
                        this.f29444a = z11;
                        this.f29445b = str;
                    }

                    @Override // com.cloud.sdk.commonutil.util.Preconditions.a
                    public void onRun() {
                        if (this.f29444a) {
                            if (l.d("file://" + this.f29445b, imageView, false)) {
                                DrawableResponseListener drawableResponseListener = drawableResponseListener;
                                if (drawableResponseListener != null) {
                                    drawableResponseListener.g(200, null);
                                    return;
                                }
                                return;
                            }
                        }
                        String str = this.f29445b;
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        DownLoadRequest.q(str, drawableResponseListener, imageView);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    String strE = adsDTO.isFromLocal() ? str : DiskLruCacheUtil.e(str, 4);
                    Preconditions.d(new a(new File(strE).exists(), strE));
                }
            });
        } else if (drawableResponseListener != null) {
            drawableResponseListener.a(new TaErrorCode(TaErrorCode.CODE_BITMAP_TOO_LARGE, "main image is too large."));
        }
    }

    public static void p(@NonNull final String str, final AdsDTO adsDTO, final int i11, final DrawableResponseListener drawableResponseListener, final ImageView imageView) {
        if (TextUtils.isEmpty(str) || imageView == null) {
            if (drawableResponseListener != null) {
                drawableResponseListener.a(new TaErrorCode(TaErrorCode.CODE_BITMAP_TAKE_FAILED, "url == null."));
            }
        } else if (!e1.s(adsDTO)) {
            com.cloud.sdk.commonutil.pool.b.b().a(new Runnable() { // from class: com.cloud.hisavana.sdk.common.http.DownLoadRequest.1

                /* JADX INFO: renamed from: com.cloud.hisavana.sdk.common.http.DownLoadRequest$1$a */
                /* JADX INFO: compiled from: source.java */
                public class a implements Preconditions.a {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ boolean f29441a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ String f29442b;

                    public a(boolean z11, String str) {
                        this.f29441a = z11;
                        this.f29442b = str;
                    }

                    @Override // com.cloud.sdk.commonutil.util.Preconditions.a
                    public void onRun() {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        boolean zY = DownLoadRequest.y(adsDTO, i11);
                        if (this.f29441a) {
                            if (l.d("file://" + this.f29442b, imageView, zY)) {
                                z.a().d("ssp", "loadImageView with glide, useHighPriority: " + zY + ", url: " + str);
                                DrawableResponseListener drawableResponseListener = drawableResponseListener;
                                if (drawableResponseListener != null) {
                                    drawableResponseListener.g(200, null);
                                    return;
                                }
                                return;
                            }
                        }
                        z.a().d("ssp", "loadImageView with ssp, url: " + str);
                        AnonymousClass1 anonymousClass2 = AnonymousClass1.this;
                        DownLoadRequest.r(str, imageView, adsDTO, i11, drawableResponseListener);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    String strE;
                    boolean z11 = false;
                    if (adsDTO != null) {
                        strE = DiskLruCacheUtil.e(str, 1);
                        if (!TextUtils.isEmpty(strE) && new File(strE).exists()) {
                            z11 = true;
                        }
                    } else {
                        strE = "";
                    }
                    Preconditions.d(new a(z11, strE));
                }
            });
        } else if (drawableResponseListener != null) {
            drawableResponseListener.a(new TaErrorCode(TaErrorCode.CODE_BITMAP_TOO_LARGE, "main image is too large."));
        }
    }

    public static void q(String str, DrawableResponseListener drawableResponseListener, ImageView imageView) {
        if (imageView == null) {
            return;
        }
        com.cloud.sdk.commonutil.pool.b.b().a(new AnonymousClass3(str, drawableResponseListener, imageView));
    }

    public static void r(@NonNull String str, @NonNull ImageView imageView, AdsDTO adsDTO, int i11, DrawableResponseListener drawableResponseListener) {
        k(str, 1, adsDTO == null ? false : adsDTO.isOfflineAd(), i11, false, 1, false, adsDTO, new a(drawableResponseListener, imageView));
    }

    public static boolean y(AdsDTO adsDTO, int i11) {
        if (AdManager.l() && adsDTO != null && i11 == 2) {
            return adsDTO.getAdType() == 4 || adsDTO.getAdType() == 3 || adsDTO.getAdType() == 5;
        }
        return false;
    }

    @Override // com.cloud.hisavana.sdk.common.http.b
    public void b() {
        try {
            RequestParams requestParams = new RequestParams();
            requestParams.k(this.f29435j);
            requestParams.m(true);
            requestParams.i(this.f29439n);
            requestParams.j(this.f29440o);
            this.f29430e = System.currentTimeMillis();
            HttpRequest.c(this.f29437l, requestParams, new b());
        } catch (Throwable th2) {
            z.a().e(Log.getStackTraceString(th2));
            this.f29434i = 1;
            T t11 = this.f29454b;
            if (t11 != 0) {
                ((DrawableResponseListener) t11).e(TaErrorCode.ERROR_UNKNOWN);
            }
            this.f29431f = 101;
        }
    }

    @Override // com.cloud.hisavana.sdk.common.http.b
    public void c() {
        if (TextUtils.isEmpty(this.f29437l)) {
            z.a().e("ssp", "url is empty");
        } else {
            b();
        }
    }

    public DownLoadRequest n(boolean z11) {
        this.f29440o = z11;
        return this;
    }

    public DownLoadRequest s(Boolean bool, int i11) {
        this.f29436k = bool.booleanValue();
        this.f29433h = i11;
        return this;
    }

    public DownLoadRequest t(int i11) {
        this.f29439n = i11;
        return this;
    }

    public DownLoadRequest u(boolean z11) {
        this.f29435j = z11;
        return this;
    }

    public DownLoadRequest v(DrawableResponseListener drawableResponseListener) {
        this.f29454b = drawableResponseListener;
        return this;
    }

    public DownLoadRequest w(int i11) {
        this.f29438m = i11;
        return this;
    }

    public DownLoadRequest x(String str) {
        this.f29437l = str;
        return this;
    }
}
