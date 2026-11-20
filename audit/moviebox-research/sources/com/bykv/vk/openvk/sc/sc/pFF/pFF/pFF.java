package com.bykv.vk.openvk.sc.sc.pFF.pFF;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.SystemClock;
import android.provider.BaseColumns;
import android.text.TextUtils;
import android.util.Log;
import com.bykv.vk.openvk.sc.sc.pFF.pFF.pFF.zY;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF extends sc {
    private final int BT;
    final Object Ql;
    final Object SR;
    private volatile Qj.sc Xc;
    private final a dE;
    private volatile com.bykv.vk.openvk.sc.sc.pFF.pFF.zY.pFF wjp;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(pFF pff);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f25994a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f25995b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public com.bykv.vk.openvk.sc.sc.pFF.pFF.b f25996c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public com.bykv.vk.openvk.sc.sc.pFF.pFF.sc.b f25997d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public zY f25998e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List<Ol.a> f25999f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f26000g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Ol f26001h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public a f26002i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f26003j;

        public b a(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("key == null");
            }
            this.f25995b = str;
            return this;
        }

        public b b(int i11) {
            this.f26000g = i11;
            return this;
        }

        public b c(Ol ol2) {
            this.f26001h = ol2;
            return this;
        }

        public b d(com.bykv.vk.openvk.sc.sc.pFF.pFF.b bVar) {
            if (bVar == null) {
                throw new IllegalArgumentException("urls is empty");
            }
            this.f25996c = bVar;
            return this;
        }

        public b e(a aVar) {
            this.f26002i = aVar;
            return this;
        }

        public b f(zY zYVar) {
            if (zYVar == null) {
                throw new IllegalArgumentException("db == null");
            }
            this.f25998e = zYVar;
            return this;
        }

        public b g(com.bykv.vk.openvk.sc.sc.pFF.pFF.sc.b bVar) {
            if (bVar == null) {
                throw new IllegalArgumentException("cache == null");
            }
            this.f25997d = bVar;
            return this;
        }

        public b h(Object obj) {
            this.f26003j = obj;
            return this;
        }

        public b i(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("rawKey == null");
            }
            this.f25994a = str;
            return this;
        }

        public b j(List<Ol.a> list) {
            this.f25999f = list;
            return this;
        }

        public pFF k() {
            if (this.f25997d == null || this.f25998e == null || TextUtils.isEmpty(this.f25994a) || TextUtils.isEmpty(this.f25995b) || this.f25996c == null) {
                throw new IllegalArgumentException();
            }
            return new pFF(this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends SQLiteOpenHelper {
        public c(Context context) {
            super(context, "tt_open_sdk_video.db", (SQLiteDatabase.CursorFactory) null, 3);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS video_http_header_t(_id INTEGER PRIMARY KEY AUTOINCREMENT,key TEXT,mime TEXT,contentLength INTEGER,flag INTEGER,extra TEXT)");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
            if (i11 == 1) {
                sQLiteDatabase.execSQL("ALTER TABLE video_http_header_t ADD COLUMN flag INTEGER DEFAULT 0");
                sQLiteDatabase.execSQL("ALTER TABLE video_http_header_t ADD COLUMN extra TEXT DEFAULT ''");
            } else if (i11 == 2) {
                sQLiteDatabase.execSQL("ALTER TABLE video_http_header_t ADD COLUMN extra TEXT DEFAULT ''");
            } else {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS video_http_header_t");
                onCreate(sQLiteDatabase);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class d implements BaseColumns {
        public static int a(boolean z11) {
            return z11 ? 1 : 0;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f26004a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f26005b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f26006c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f26007d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f26008e;

        public e(String str, String str2, int i11, int i12, String str3) {
            this.f26004a = str;
            this.f26005b = str2;
            this.f26006c = i11;
            this.f26007d = i12;
            this.f26008e = str3;
        }
    }

    public pFF(b bVar) {
        super(bVar.f25997d, bVar.f25998e);
        this.BT = bVar.f26000g;
        this.dE = bVar.f26002i;
        this.Ql = this;
        this.f26025qr = bVar.f25994a;
        this.Qj = bVar.f25995b;
        this.TRI = bVar.f25999f;
        this.WH = bVar.f25996c;
        this.Ol = bVar.f26001h;
        this.SR = bVar.f26003j;
    }

    private boolean WH() throws com.bykv.vk.openvk.sc.sc.pFF.pFF.zY.sc {
        while (this.WH.c()) {
            ExN();
            com.bykv.vk.openvk.sc.sc.pFF.pFF.b.a aVarB = this.WH.b();
            try {
                sc(aVarB);
                return true;
            } catch (Qj.sc e11) {
                this.Xc = e11;
                qr();
                return false;
            } catch (com.bykv.vk.openvk.sc.sc.pFF.pFF.zY.pFF e12) {
                this.wjp = e12;
                return false;
            } catch (com.bykv.vk.openvk.sc.sc.pFF.pFF.zY.zY unused) {
                aVarB.b();
                qr();
            } catch (IOException e13) {
                if (e13 instanceof SocketTimeoutException) {
                    aVarB.a();
                }
                if (!pFF()) {
                    qr();
                }
            } catch (Throwable unused2) {
                return false;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:92:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:94:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:96:0x01ed  */
    private void sc(com.bykv.vk.openvk.sc.sc.pFF.pFF.b.a aVar) throws Throwable {
        File fileD = this.f26026sc.d(this.Qj);
        long length = fileD.length();
        int i11 = this.BT;
        if (i11 > 0 && length >= i11) {
            if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c) {
                StringBuilder sb2 = new StringBuilder("no necessary to download for ");
                sb2.append(this.Qj);
                sb2.append(", cache file size: ");
                sb2.append(length);
                sb2.append(", max: ");
                sb2.append(this.BT);
                return;
            }
            return;
        }
        int iTRI = TRI();
        e eVarE = this.pFF.e(this.Qj, iTRI);
        if (eVarE != null && length >= eVarE.f26006c) {
            if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c) {
                new StringBuilder("file download complete, key: ").append(this.Qj);
                return;
            }
            return;
        }
        ExN();
        int i12 = (int) length;
        l8.e eVarSc = sc(aVar, i12, this.BT, "GET");
        if (eVarSc == null) {
            return;
        }
        boolean z11 = true;
        Qj qj2 = null;
        try {
            ExN();
            String strM = p8.a.m(eVarSc, this.Ol == null && com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25975f, true);
            if (strM != null) {
                throw new com.bykv.vk.openvk.sc.sc.pFF.pFF.zY.zY(strM + ", rawKey: " + this.f26025qr + ", url: " + aVar);
            }
            int iH = p8.a.h(eVarSc);
            if (eVarE != null && eVarE.f26006c != iH) {
                if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c) {
                    Log.e("TAG_PROXY_DownloadTask", "Content-Length not match, old: " + eVarE.f26006c + ", " + iH + ", key: " + this.Qj);
                }
                throw new com.bykv.vk.openvk.sc.sc.pFF.pFF.zY.pFF("Content-Length not match, old length: " + eVarE.f26006c + ", new length: " + iH + ", rawKey: " + this.f26025qr + ", currentUrl: " + aVar + ", previousInfo: " + eVarE.f26008e);
            }
            p8.a.i(eVarSc, this.pFF, this.Qj, iTRI);
            e eVarE2 = this.pFF.e(this.Qj, iTRI);
            int i13 = eVarE2 == null ? 0 : eVarE2.f26006c;
            InputStream inputStreamC = eVarSc.c();
            Qj qj3 = new Qj(fileD, com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25974e ? "rwd" : "rw");
            try {
                qj3.c(length);
                if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c) {
                    "preload start from: ".concat(String.valueOf(length));
                }
                byte[] bArr = new byte[8192];
                while (true) {
                    int i14 = inputStreamC.read(bArr);
                    if (i14 < 0) {
                        try {
                            zY();
                            com.bykv.vk.openvk.sc.sc.pFF.pFF.sc.zY zYVar = com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25970a;
                            p8.a.r(eVarSc.c());
                            qj3.b();
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            qj2 = qj3;
                            z11 = false;
                            p8.a.r(eVarSc.c());
                            if (qj2 != null) {
                                qj2.b();
                            }
                            if (z11) {
                                sc();
                                if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c) {
                                    Log.w("TAG_PROXY_DownloadTask", "cancel call");
                                }
                            }
                            throw th;
                        }
                    }
                    ExN();
                    if (i14 > 0) {
                        qj3.d(bArr, 0, i14);
                        i12 += i14;
                        if (this.Ol != null) {
                            synchronized (this.Ql) {
                                this.Ql.notifyAll();
                            }
                        }
                        this.zY.addAndGet(i14);
                        sc(i13, i12);
                    }
                    int i15 = this.BT;
                    if (i15 > 0 && i12 >= i15) {
                        boolean z12 = com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c;
                        if (z12) {
                            Log.w("TAG_PROXY_DownloadTask", "download, more data received, currentCacheFileSize: " + i12 + ", max: " + this.BT);
                        }
                        p8.a.r(eVarSc.c());
                        qj3.b();
                        sc();
                        if (z12) {
                            Log.w("TAG_PROXY_DownloadTask", "cancel call");
                            return;
                        }
                        return;
                    }
                    ExN();
                }
            } catch (Throwable th3) {
                th = th3;
                qj2 = qj3;
                p8.a.r(eVarSc.c());
                if (qj2 != null) {
                    qj2.b();
                }
                if (z11) {
                    sc();
                    if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c) {
                        Log.w("TAG_PROXY_DownloadTask", "cancel call");
                    }
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public com.bykv.vk.openvk.sc.sc.pFF.pFF.zY.pFF Ol() {
        return this.wjp;
    }

    public Qj.sc Qj() {
        return this.Xc;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f26026sc.c(this.Qj);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            WH();
        } catch (Throwable unused) {
        }
        this.We.set(SystemClock.elapsedRealtime() - jElapsedRealtime);
        this.f26026sc.b(this.Qj);
        a aVar = this.dE;
        if (aVar != null) {
            aVar.a(this);
        }
    }
}
