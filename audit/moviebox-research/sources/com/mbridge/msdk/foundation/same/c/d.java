package com.mbridge.msdk.foundation.same.c;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadPriority;
import com.mbridge.msdk.foundation.download.DownloadResourceType;
import com.mbridge.msdk.foundation.download.MBDownloadManager;
import com.mbridge.msdk.foundation.download.OnDownloadStateListener;
import com.mbridge.msdk.foundation.download.core.DownloadRequest;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.ad;
import java.io.File;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ThreadPoolExecutor f44461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f44462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f44463c;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final d f44469a = new d();
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements OnDownloadStateListener<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ThreadPoolExecutor f44470a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Handler f44471b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f44472c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f44473d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final h f44474e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String f44475f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final c f44476g;

        public b(Handler handler, ThreadPoolExecutor threadPoolExecutor, String str, String str2, String str3, h hVar, c cVar) {
            this.f44471b = handler;
            this.f44470a = threadPoolExecutor;
            this.f44475f = str;
            this.f44472c = str2;
            this.f44473d = str3;
            this.f44474e = hVar;
            this.f44476g = cVar;
        }

        private Bitmap a(Bitmap bitmap, h hVar) {
            if (hVar == null) {
                return bitmap;
            }
            try {
                return hVar.a(bitmap);
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    ad.a("CommonImageLoaderRefactor", "handlerImageTransformation error", e11);
                }
                return bitmap;
            }
        }

        public static /* synthetic */ void a(b bVar) {
            if (bVar.f44476g == null) {
                return;
            }
            try {
                Bitmap bitmapD = d.d(bVar.f44472c + bVar.f44473d);
                if (bitmapD == null) {
                    bVar.a("bitmap decode failed");
                } else {
                    final Bitmap bitmapA = bVar.a(bitmapD, bVar.f44474e);
                    if (bitmapA == null) {
                        bVar.a("bitmap transformation failed");
                    } else if (bVar.f44476g != null) {
                        bVar.f44471b.post(new Runnable() { // from class: com.mbridge.msdk.foundation.same.c.d.b.3
                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    b.this.f44476g.onSuccessLoad(bitmapA, b.this.f44475f);
                                } catch (Exception e11) {
                                    if (MBridgeConstans.DEBUG) {
                                        ad.a("CommonImageLoaderRefactor", "callbackForSuccess error", e11);
                                    }
                                }
                            }
                        });
                    }
                }
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    ad.a("CommonImageLoaderRefactor", "onDownloadComplete decodeBitmap error = " + e11.getLocalizedMessage());
                }
                bVar.a("bitmap decode failed");
            }
        }

        private void a(final String str) {
            if (this.f44476g == null) {
                return;
            }
            this.f44471b.post(new Runnable() { // from class: com.mbridge.msdk.foundation.same.c.d.b.2
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        b.this.f44476g.onFailedLoad(b.this.f44475f, str);
                    } catch (Exception e11) {
                        if (MBridgeConstans.DEBUG) {
                            ad.a("CommonImageLoaderRefactor", "callbackForFailed error", e11);
                        }
                    }
                }
            });
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public final void onCancelDownload(DownloadMessage<Object> downloadMessage) {
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public final void onDownloadComplete(DownloadMessage<Object> downloadMessage) {
            File file;
            if (MBridgeConstans.DEBUG) {
                ad.a("CommonImageLoaderRefactor", "onDownloadComplete imageUrl = " + this.f44475f + " imagePath = " + this.f44472c + this.f44473d);
                try {
                    file = new File(this.f44472c + this.f44473d);
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        ad.a("CommonImageLoaderRefactor", "onDownloadComplete error", e11);
                    }
                    file = null;
                }
                if (file != null && file.isFile() && file.exists()) {
                    ad.a("CommonImageLoaderRefactor", "onDownloadComplete file size = " + file.length());
                } else {
                    ad.b("CommonImageLoaderRefactor", "onDownloadComplete file not exist");
                }
            }
            this.f44470a.execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.c.d.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.a(b.this);
                }
            });
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public final void onDownloadError(DownloadMessage<Object> downloadMessage, DownloadError downloadError) {
            if (MBridgeConstans.DEBUG) {
                ad.a("CommonImageLoaderRefactor", "onDownloadError imageUrl = " + downloadError.getException().getLocalizedMessage());
            }
            a(downloadError.getException().getLocalizedMessage());
        }

        @Override // com.mbridge.msdk.foundation.download.OnDownloadStateListener
        public final void onDownloadStart(DownloadMessage<Object> downloadMessage) {
        }
    }

    private d() {
        this.f44462b = new Handler(Looper.getMainLooper());
        this.f44463c = com.mbridge.msdk.foundation.same.b.e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_IMG) + File.separator;
        this.f44461a = g.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadRequest<?> a(String str, String str2, h hVar, c cVar) {
        try {
            return MBDownloadManager.getInstance().download(new DownloadMessage<>(new Object(), str2, str, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_IMAGE)).withReadTimeout(com.mbridge.msdk.foundation.same.a.f44385u).withConnectTimeout(com.mbridge.msdk.foundation.same.a.f44384t).withWriteTimeout(com.mbridge.msdk.foundation.same.a.f44383s).withDownloadPriority(DownloadPriority.LOW).withHttpRetryCounter(1).withDirectoryPathInternal(this.f44463c).withDownloadStateListener(new b(this.f44462b, this.f44461a, str2, this.f44463c, str, hVar, cVar)).withProgressStateListener(null).with("do_us_fi_re", Boolean.FALSE.toString()).build();
        } catch (Exception e11) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            ad.a("CommonImageLoaderRefactor", "createDownloadRequest error", e11);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bitmap d(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inJustDecodeBounds = false;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inDither = true;
        return BitmapFactory.decodeFile(str, options);
    }

    public final Bitmap a(String str) {
        if (MBridgeConstans.DEBUG) {
            ad.a("CommonImageLoaderRefactor", "getImageBitmapByUrl imageUrl = " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = this.f44463c + ab.c(str);
        File file = new File(str2);
        if (file.isFile() && file.exists()) {
            try {
                return d(str2);
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    ad.a("CommonImageLoaderRefactor", "getImageBitmapByUrl error", e11);
                }
            }
        }
        return null;
    }

    public final void a(final String str, final h hVar, final c cVar) {
        try {
            this.f44461a.execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.c.d.1
                @Override // java.lang.Runnable
                public final void run() {
                    DownloadRequest downloadRequestA = d.this.a(ab.c(str), str, hVar, cVar);
                    if (downloadRequestA != null) {
                        downloadRequestA.start();
                        return;
                    }
                    if (MBridgeConstans.DEBUG) {
                        ad.b("CommonImageLoaderRefactor", "createDownloadRequest error");
                    }
                    if (cVar == null) {
                        return;
                    }
                    d.this.f44462b.post(new Runnable() { // from class: com.mbridge.msdk.foundation.same.c.d.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            cVar.onFailedLoad("create download request error", str);
                        }
                    });
                }
            });
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                ad.a("CommonImageLoaderRefactor", "loadImage error", e11);
            }
        }
    }

    public final boolean b(String str) {
        File file;
        if (MBridgeConstans.DEBUG) {
            ad.a("CommonImageLoaderRefactor", "isImageFileExists imageUrl = " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            try {
                file = new File(this.f44463c + ab.c(str));
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    ad.a("CommonImageLoaderRefactor", "isImageFileExists error", e11);
                }
                file = null;
            }
            return file != null && file.isFile() && file.exists();
        } catch (Exception e12) {
            if (MBridgeConstans.DEBUG) {
                ad.a("CommonImageLoaderRefactor", "isImageFileExists error", e12);
            }
            return false;
        }
    }
}
