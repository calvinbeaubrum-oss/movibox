package com.mbridge.msdk.foundation.same.c;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.net.k;
import java.io.File;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class e extends com.mbridge.msdk.foundation.same.e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f44482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f44483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f44484c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f44485d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a f44486e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f44487f;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(String str, String str2);

        void b(String str, String str2);
    }

    public e(String str, String str2, String str3) {
        this.f44482a = false;
        this.f44484c = false;
        this.f44485d = str;
        this.f44483b = str2;
        this.f44487f = str3;
    }

    public e(String str, String str2, String str3, h hVar) {
        this.f44484c = false;
        this.f44485d = str;
        this.f44483b = str2;
        this.f44487f = str3;
        this.f44482a = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        a aVar = this.f44486e;
        if (aVar != null) {
            aVar.b(str, str2);
        }
    }

    private void b() {
        try {
            File file = new File(this.f44487f);
            if (!file.exists()) {
                file.mkdirs();
            }
            if (file.exists()) {
                file.delete();
            }
            com.mbridge.msdk.foundation.same.net.h.c.downloadFile(file, this.f44483b, new com.mbridge.msdk.foundation.same.net.f<Void>() { // from class: com.mbridge.msdk.foundation.same.c.e.1
                @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
                public final void onError(final com.mbridge.msdk.foundation.same.net.b.a aVar) {
                    Runnable runnable = new Runnable() { // from class: com.mbridge.msdk.foundation.same.c.e.1.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            e eVar = e.this;
                            eVar.a(eVar.f44483b, "load image from http faild because http return code: " + aVar.f44551a + ".image url is " + e.this.f44483b);
                        }
                    };
                    if (e.this.f44482a) {
                        com.mbridge.msdk.foundation.same.f.b.c().execute(runnable);
                    } else {
                        runnable.run();
                    }
                }

                @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
                public final void onFinish() {
                }

                @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
                public final void onProgressChange(long j11, long j12) {
                }

                @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
                public final void onSuccess(k kVar) {
                    Runnable runnable = new Runnable() { // from class: com.mbridge.msdk.foundation.same.c.e.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            String unused = e.this.f44487f;
                            e.this.a();
                        }
                    };
                    if (e.this.f44482a) {
                        com.mbridge.msdk.foundation.same.f.b.c().execute(runnable);
                    } else {
                        runnable.run();
                    }
                }
            });
        } catch (Exception e11) {
            a(this.f44483b, e11.getMessage());
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        } catch (OutOfMemoryError e12) {
            a(this.f44483b, e12.getMessage());
        }
    }

    public final void a() {
        if (new File(this.f44487f).exists()) {
            String str = this.f44483b;
            String str2 = this.f44487f;
            a aVar = this.f44486e;
            if (aVar != null) {
                aVar.a(str, str2);
                return;
            }
            return;
        }
        a(this.f44483b, "load image faild.because file[" + this.f44487f + "] is not exist!");
    }

    public final void a(a aVar) {
        this.f44486e = aVar;
    }

    public final void a(boolean z11) {
        this.f44484c = z11;
    }

    @Override // com.mbridge.msdk.foundation.same.e.a
    public final void cancelTask() {
    }

    @Override // com.mbridge.msdk.foundation.same.e.a
    public final void pauseTask(boolean z11) {
    }

    @Override // com.mbridge.msdk.foundation.same.e.a
    public final void runTask() {
        if (this.f44484c) {
            b();
            return;
        }
        if (TextUtils.isEmpty(this.f44487f)) {
            a(this.f44483b, "save path is null.");
            return;
        }
        File file = new File(this.f44487f);
        if (!file.exists() || file.length() <= 0) {
            b();
        } else {
            a();
        }
    }
}
