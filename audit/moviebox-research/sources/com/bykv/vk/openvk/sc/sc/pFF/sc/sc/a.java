package com.bykv.vk.openvk.sc.sc.pFF.sc.sc;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import com.bykv.vk.openvk.sc.sc.sc.zY.zY;
import com.bytedance.sdk.component.pFF.sc.BT;
import com.bytedance.sdk.component.pFF.sc.Ql;
import com.bytedance.sdk.component.pFF.sc.UFX;
import com.bytedance.sdk.component.pFF.sc.dE;
import com.bytedance.sdk.component.pFF.sc.pFF;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;
import q8.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class a implements b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public File f26048c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public File f26049d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f26050e;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RandomAccessFile f26054i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final zY f26055j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile long f26046a = -2147483648L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f26047b = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile long f26051f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f26052g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f26053h = false;

    /* JADX INFO: renamed from: com.bykv.vk.openvk.sc.sc.pFF.sc.sc.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0220a implements com.bytedance.sdk.component.pFF.sc.zY {
        public C0220a() {
        }

        /* JADX WARN: Code duplicated, block: B:77:0x018f A[Catch: all -> 0x01b6, TryCatch #0 {all -> 0x01b6, blocks: (B:75:0x018a, B:77:0x018f, B:78:0x0192, B:80:0x019d, B:82:0x01b1), top: B:91:0x018a }] */
        @Override // com.bytedance.sdk.component.pFF.sc.zY
        public void sc(pFF pff, BT bt2) throws IOException {
            dE dEVarTRI;
            InputStream inputStream;
            long length;
            long j11;
            if (bt2 == null) {
                a.this.f26053h = false;
                a aVar = a.this;
                aVar.f26046a = aVar.f26051f;
                return;
            }
            InputStream inputStreamZY = null;
            try {
                a.this.f26053h = bt2.We();
                if (a.this.f26053h) {
                    dEVarTRI = bt2.TRI();
                    try {
                        if (a.this.f26053h && dEVarTRI != null) {
                            a.this.f26046a = dEVarTRI.sc() + a.this.f26050e;
                            inputStreamZY = dEVarTRI.zY();
                        }
                        inputStream = inputStreamZY;
                        if (inputStream == null) {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable unused) {
                                    return;
                                }
                            }
                            if (dEVarTRI != null) {
                                dEVarTRI.close();
                            }
                            bt2.close();
                            if (a.this.f26053h && a.this.f26048c.length() == a.this.f26046a) {
                                a.this.g();
                                return;
                            }
                            return;
                        }
                        try {
                            byte[] bArr = new byte[8192];
                            long j12 = a.this.f26050e;
                            long j13 = 0;
                            loop0: while (true) {
                                int i11 = 0;
                                while (true) {
                                    int i12 = inputStream.read(bArr, i11, 8192 - i11);
                                    if (i12 == -1) {
                                        break loop0;
                                    }
                                    i11 += i12;
                                    j13 += (long) i12;
                                    boolean z11 = j13 % PlaybackStateCompat.ACTION_PLAY_FROM_URI == 0 || j13 == a.this.f26046a - a.this.f26050e;
                                    long unused2 = a.this.f26046a;
                                    long unused3 = a.this.f26050e;
                                    a.this.f26055j.SR();
                                    a.this.f26055j.Ql();
                                    if (z11) {
                                        synchronized (a.this.f26047b) {
                                            k8.a.c(a.this.f26054i, bArr, Long.valueOf(j12).intValue(), i11, a.this.f26055j.SR());
                                        }
                                        j12 += (long) i11;
                                    }
                                }
                            }
                            long unused4 = a.this.f26050e;
                            long unused5 = a.this.f26046a;
                            long unused6 = a.this.f26046a;
                            long unused7 = a.this.f26050e;
                            a.this.f26055j.Ql();
                            inputStreamZY = inputStream;
                        } catch (Throwable unused8) {
                            try {
                                a.this.f26053h = false;
                                a aVar2 = a.this;
                                aVar2.f26046a = aVar2.f26051f;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable unused9) {
                                        return;
                                    }
                                }
                                if (dEVarTRI != null) {
                                    dEVarTRI.close();
                                }
                                bt2.close();
                                if (a.this.f26053h) {
                                    if (length == j11) {
                                        return;
                                    } else {
                                        return;
                                    }
                                }
                                return;
                            } finally {
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                        if (dEVarTRI != null) {
                                            dEVarTRI.close();
                                        }
                                        bt2.close();
                                        if (a.this.f26053h && a.this.f26048c.length() == a.this.f26046a) {
                                            a.this.g();
                                        }
                                    } catch (Throwable unused10) {
                                    }
                                } else {
                                    if (dEVarTRI != null) {
                                        dEVarTRI.close();
                                    }
                                    bt2.close();
                                    if (a.this.f26053h) {
                                        a.this.g();
                                    }
                                }
                            }
                        }
                    } catch (Throwable unused11) {
                        inputStream = null;
                    }
                } else {
                    a.this.f26053h = false;
                    a aVar3 = a.this;
                    aVar3.f26046a = aVar3.f26051f;
                    dEVarTRI = null;
                }
                if (inputStreamZY != null) {
                    try {
                        inputStreamZY.close();
                    } catch (Throwable unused12) {
                        return;
                    }
                }
                if (dEVarTRI != null) {
                    dEVarTRI.close();
                }
                bt2.close();
                if (a.this.f26053h && a.this.f26048c.length() == a.this.f26046a) {
                    a.this.g();
                }
            } catch (Throwable unused13) {
                dEVarTRI = null;
                inputStream = null;
            }
        }

        @Override // com.bytedance.sdk.component.pFF.sc.zY
        public void sc(pFF pff, IOException iOException) {
            a.this.f26053h = false;
            a.this.f26046a = -1L;
        }
    }

    public a(Context context, zY zYVar) {
        this.f26050e = 0L;
        this.f26054i = null;
        this.f26055j = zYVar;
        try {
            this.f26048c = k8.a.a(zYVar.pFF(), zYVar.SR());
            this.f26049d = k8.a.d(zYVar.pFF(), zYVar.SR());
            if (i()) {
                this.f26054i = new RandomAccessFile(this.f26049d, CampaignEx.JSON_KEY_AD_R);
            } else {
                this.f26054i = new RandomAccessFile(this.f26048c, "rw");
            }
            if (i()) {
                return;
            }
            this.f26050e = this.f26048c.length();
            m();
        } catch (Throwable unused) {
            zYVar.Ql();
        }
    }

    @Override // com.bykv.vk.openvk.sc.sc.pFF.sc.sc.b
    public int a(long j11, byte[] bArr, int i11, int i12) throws IOException {
        try {
            if (j11 == this.f26046a) {
                return -1;
            }
            int i13 = 0;
            int i14 = 0;
            while (!this.f26052g) {
                synchronized (this.f26047b) {
                    try {
                        if (j11 < b()) {
                            this.f26054i.seek(j11);
                            i14 = this.f26054i.read(bArr, i11, i12);
                        } else {
                            i13 += 33;
                            this.f26047b.wait(33L);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                if (i14 > 0) {
                    return i14;
                }
                if (i13 >= 20000) {
                    throw new SocketTimeoutException();
                }
            }
            return -1;
        } catch (Throwable th3) {
            if (th3 instanceof IOException) {
                throw th3;
            }
            throw new IOException();
        }
    }

    public final long b() {
        return i() ? this.f26049d.length() : this.f26048c.length();
    }

    public final void g() throws IOException {
        synchronized (this.f26047b) {
            if (i()) {
                this.f26055j.Ql();
                this.f26055j.SR();
                return;
            }
            try {
                if (!this.f26048c.renameTo(this.f26049d)) {
                    throw new IOException("Error renaming file " + this.f26048c + " to " + this.f26049d + " for completion!");
                }
                RandomAccessFile randomAccessFile = this.f26054i;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                this.f26054i = new RandomAccessFile(this.f26049d, "rw");
                this.f26055j.SR();
                this.f26055j.Ql();
            } catch (Throwable th2) {
                th2.getMessage();
            }
        }
    }

    public final boolean i() {
        return this.f26049d.exists();
    }

    public void m() {
        UFX.sc scVarPFF = c.c() != null ? c.c().pFF() : new UFX.sc("v_cache");
        long jDE = this.f26055j.dE();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        scVarPFF.sc(jDE, timeUnit).pFF(this.f26055j.Xc(), timeUnit).zY(this.f26055j.wjp(), timeUnit);
        UFX ufxSc = scVarPFF.sc();
        this.f26055j.SR();
        ufxSc.sc(new Ql.sc().sc("RANGE", "bytes=" + this.f26050e + "-").pFF(this.f26055j.Ql()).sc().sc("videoLoadWhenPlaying").sc(9).pFF()).sc(new C0220a());
    }

    @Override // com.bykv.vk.openvk.sc.sc.pFF.sc.sc.b
    public void pFF() {
        try {
            if (!this.f26052g) {
                this.f26054i.close();
            }
            File file = this.f26048c;
            if (file != null) {
                file.setLastModified(System.currentTimeMillis());
            }
            File file2 = this.f26049d;
            if (file2 != null) {
                file2.setLastModified(System.currentTimeMillis());
            }
        } catch (Throwable unused) {
        }
        this.f26052g = true;
    }

    @Override // com.bykv.vk.openvk.sc.sc.pFF.sc.sc.b
    public long zY() throws IOException {
        if (i()) {
            this.f26046a = this.f26049d.length();
        } else {
            synchronized (this.f26047b) {
                int i11 = 0;
                while (this.f26046a == -2147483648L) {
                    try {
                        i11 += 15;
                        try {
                            this.f26047b.wait(5L);
                            if (i11 > 20000) {
                                return -1L;
                            }
                        } catch (InterruptedException unused) {
                            throw new IOException("total length InterruptException");
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }
        return this.f26046a;
    }
}
