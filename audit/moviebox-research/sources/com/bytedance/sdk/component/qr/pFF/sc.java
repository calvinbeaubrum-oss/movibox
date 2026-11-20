package com.bytedance.sdk.component.qr.pFF;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.bumptech.glide.integration.cronet.BufferQueue;
import com.bytedance.sdk.component.pFF.sc.BT;
import com.bytedance.sdk.component.pFF.sc.Ql;
import com.bytedance.sdk.component.pFF.sc.TRI;
import com.bytedance.sdk.component.pFF.sc.UFX;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.zip.GZIPInputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc extends zY {
    private volatile boolean WH;
    public File pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public File f26974sc;

    public sc(UFX ufx) {
        super(ufx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean ExN(Map<String, String> map) {
        if (TextUtils.equals(map.get("Accept-Ranges"), "bytes") || TextUtils.equals(map.get("accept-ranges"), "bytes")) {
            return true;
        }
        String str = map.get("Content-Range");
        if (TextUtils.isEmpty(str)) {
            str = map.get("content-range");
        }
        return str != null && str.startsWith("bytes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long TRI(Map<String, String> map) {
        String str;
        if (map.containsKey(BufferQueue.CONTENT_LENGTH)) {
            str = map.get(BufferQueue.CONTENT_LENGTH);
        } else {
            str = map.containsKey(HttpHeaders.CONTENT_LENGTH) ? map.get(HttpHeaders.CONTENT_LENGTH) : null;
        }
        if (TextUtils.isEmpty(str) || str == null) {
            return 0L;
        }
        try {
            return Long.valueOf(str).longValue();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void We() {
        try {
            this.f26974sc.delete();
        } catch (Throwable unused) {
        }
        try {
            this.pFF.delete();
        } catch (Throwable unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean qr(Map<String, String> map) {
        return TextUtils.equals(map.get(HttpHeaders.CONTENT_ENCODING), "gzip");
    }

    @Override // com.bytedance.sdk.component.qr.pFF.zY
    public void pFF() {
        this.WH = true;
        super.pFF();
    }

    public com.bytedance.sdk.component.qr.pFF sc() {
        BT btPFF;
        RandomAccessFile randomAccessFile;
        long j11;
        InputStream inputStream;
        InputStream inputStreamZY;
        byte[] bArr;
        int i11;
        long j12;
        File file = this.f26974sc;
        if (file != null && this.pFF != null) {
            long j13 = 0;
            if (file.exists() && this.f26974sc.length() != 0) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                com.bytedance.sdk.component.qr.pFF pff = new com.bytedance.sdk.component.qr.pFF(true, 200, "Success", null, null, jCurrentTimeMillis, jCurrentTimeMillis);
                pff.sc(this.f26974sc);
                return pff;
            }
            long length = this.pFF.length();
            if (length < 0) {
                length = 0;
            }
            Ql.sc scVar = new Ql.sc();
            scVar.sc((Object) zY());
            pFF("Range", "bytes=" + length + "-");
            if (TextUtils.isEmpty(this.Qj)) {
                Log.e("DownloadExecutor", "execute: Url is Empty");
                return null;
            }
            try {
                scVar.pFF(this.Qj);
                sc(scVar);
                try {
                    com.bytedance.sdk.component.pFF.sc.pFF pffSc = this.zY.sc(scVar.sc().pFF());
                    if (pffSc == null || (btPFF = pffSc.pFF()) == null || !btPFF.We()) {
                        return null;
                    }
                    HashMap map = new HashMap();
                    TRI triQr = btPFF.qr();
                    if (triQr != null) {
                        for (int i12 = 0; i12 < triQr.sc(); i12++) {
                            map.put(triQr.sc(i12), triQr.pFF(i12));
                        }
                    }
                    com.bytedance.sdk.component.qr.pFF pff2 = new com.bytedance.sdk.component.qr.pFF(btPFF.We(), btPFF.zY(), btPFF.ExN(), map, null, btPFF.pFF(), btPFF.sc());
                    long jSc = btPFF.TRI().sc();
                    if (jSc <= 0) {
                        jSc = TRI(map);
                    }
                    long length2 = this.pFF.length();
                    boolean zExN = ExN(map);
                    int i13 = -1;
                    if (zExN) {
                        jSc += length2;
                        String str = (String) map.get("Content-Range");
                        if (!TextUtils.isEmpty(str)) {
                            if (TextUtils.indexOf(str, "bytes " + length2 + "-" + (jSc - 1)) == -1) {
                                Objects.toString(this.pFF);
                                We();
                                return null;
                            }
                        }
                        j13 = 0;
                    }
                    if (jSc > j13 && this.pFF.exists() && this.pFF.length() == jSc) {
                        if (!this.pFF.renameTo(this.f26974sc)) {
                            return null;
                        }
                        pff2.sc(this.f26974sc);
                        return pff2;
                    }
                    com.bytedance.sdk.component.qr.pFF pff3 = pff2;
                    try {
                        try {
                            try {
                                randomAccessFile = new RandomAccessFile(this.pFF, "rw");
                                try {
                                    if (zExN) {
                                        randomAccessFile.seek(length);
                                        j11 = length;
                                    } else {
                                        randomAccessFile.setLength(0L);
                                        j11 = 0;
                                    }
                                    while (true) {
                                        int i14 = inputStreamZY.read(bArr, i11, 16384 - i11);
                                        if (i14 == i13) {
                                            com.bytedance.sdk.component.qr.pFF pff4 = pff3;
                                            if (i14 != 0) {
                                                randomAccessFile.seek(j11);
                                                randomAccessFile.write(bArr, 0, i11);
                                            }
                                            if (!zExN || length == 0) {
                                                jSc = this.pFF.length();
                                            }
                                            if (jSc <= 0 || !this.pFF.exists() || this.pFF.length() != jSc) {
                                                this.pFF.length();
                                                try {
                                                    inputStreamZY.close();
                                                } catch (Throwable unused) {
                                                }
                                                try {
                                                    randomAccessFile.close();
                                                    return null;
                                                } catch (Throwable unused2) {
                                                    return null;
                                                }
                                            }
                                            if (this.pFF.renameTo(this.f26974sc)) {
                                                pff4.sc(this.f26974sc);
                                                try {
                                                    inputStreamZY.close();
                                                } catch (Throwable unused3) {
                                                }
                                                try {
                                                    randomAccessFile.close();
                                                } catch (Throwable unused4) {
                                                }
                                                return pff4;
                                            }
                                            try {
                                                inputStreamZY.close();
                                            } catch (Throwable unused5) {
                                            }
                                            try {
                                                randomAccessFile.close();
                                                return null;
                                            } catch (Throwable unused6) {
                                                return null;
                                            }
                                        }
                                        i11 += i14;
                                        com.bytedance.sdk.component.qr.pFF pff5 = pff3;
                                        j12 += (long) i14;
                                        if (j12 % 16384 == 0 || j12 == jSc - length) {
                                            randomAccessFile.seek(j11);
                                            randomAccessFile.write(bArr, 0, i11);
                                            j11 += (long) i11;
                                            i11 = 0;
                                        }
                                        if (this.WH) {
                                            throw new IOException("net is cancel");
                                        }
                                        pff3 = pff5;
                                        i13 = -1;
                                    }
                                } catch (Throwable unused7) {
                                }
                            } catch (Throwable unused8) {
                                randomAccessFile = null;
                            }
                            if (qr(map) && !(inputStreamZY instanceof GZIPInputStream)) {
                                inputStreamZY = new GZIPInputStream(inputStreamZY);
                            }
                            bArr = new byte[16384];
                            i11 = 0;
                            j12 = 0;
                        } catch (Throwable unused9) {
                            inputStream = inputStreamZY;
                            if (!zExN) {
                                try {
                                    We();
                                } finally {
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Throwable unused10) {
                                        }
                                    }
                                    try {
                                        randomAccessFile.close();
                                    } catch (Throwable unused11) {
                                    }
                                }
                            }
                            try {
                                return null;
                            } catch (Throwable unused12) {
                                return null;
                            }
                        }
                        inputStreamZY = btPFF.TRI().zY();
                    } catch (Throwable unused13) {
                        inputStream = null;
                    }
                } catch (IOException unused14) {
                    We();
                    return null;
                }
            } catch (IllegalArgumentException unused15) {
                Log.e("DownloadExecutor", "execute: Url is not a valid HTTP or HTTPS URL");
            }
        }
        return null;
    }

    public void sc(final com.bytedance.sdk.component.qr.sc.sc scVar) {
        File file = this.f26974sc;
        if (file == null || this.pFF == null) {
            if (scVar != null) {
                scVar.sc(this, new IOException("File info is null, please exec setFileInfo(String dir, String fileName)"));
                return;
            }
            return;
        }
        if (file.exists() && this.f26974sc.length() != 0 && scVar != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.bytedance.sdk.component.qr.pFF pff = new com.bytedance.sdk.component.qr.pFF(true, 200, "Success", null, null, jCurrentTimeMillis, jCurrentTimeMillis);
            pff.sc(this.f26974sc);
            scVar.sc(this, pff);
            return;
        }
        long length = this.pFF.length();
        final long j11 = length >= 0 ? length : 0L;
        Ql.sc scVar2 = new Ql.sc();
        scVar2.sc((Object) zY());
        pFF("Range", "bytes=" + j11 + "-");
        if (TextUtils.isEmpty(this.Qj)) {
            scVar.sc(this, new IOException("Url is Empty"));
            return;
        }
        try {
            scVar2.pFF(this.Qj);
            if (!TextUtils.isEmpty(this.ExN)) {
                scVar2.sc(this.ExN);
            }
            int i11 = this.TRI;
            if (i11 > 0) {
                scVar2.sc(i11);
            }
            sc(scVar2);
            com.bytedance.sdk.component.pFF.sc.pFF pffSc = this.zY.sc(scVar2.sc().pFF());
            if (pffSc == null) {
                scVar.sc(this, new IOException("new call error"));
            } else {
                pffSc.sc(new com.bytedance.sdk.component.pFF.sc.zY() { // from class: com.bytedance.sdk.component.qr.pFF.sc.1
                    @Override // com.bytedance.sdk.component.pFF.sc.zY
                    public void sc(com.bytedance.sdk.component.pFF.sc.pFF pff2, BT bt2) throws IOException {
                        RandomAccessFile randomAccessFile;
                        long j12;
                        InputStream inputStreamZY;
                        byte[] bArr;
                        long j13;
                        int i12;
                        if (scVar == null) {
                            return;
                        }
                        HashMap map = new HashMap();
                        if (bt2 == null) {
                            return;
                        }
                        TRI triQr = bt2.qr();
                        if (triQr != null) {
                            for (int i13 = 0; i13 < triQr.sc(); i13++) {
                                map.put(triQr.sc(i13), triQr.pFF(i13));
                            }
                        }
                        com.bytedance.sdk.component.qr.pFF pff3 = new com.bytedance.sdk.component.qr.pFF(bt2.We(), bt2.zY(), bt2.ExN(), map, null, bt2.pFF(), bt2.sc());
                        if (!bt2.We()) {
                            scVar.sc(sc.this, pff3);
                            return;
                        }
                        long jSc = bt2.TRI().sc();
                        if (jSc <= 0) {
                            jSc = sc.TRI(map);
                        }
                        boolean zExN = sc.ExN(map);
                        int i14 = -1;
                        if (zExN) {
                            jSc += j11;
                            String str = (String) map.get("Content-Range");
                            if (!TextUtils.isEmpty(str)) {
                                String str2 = "bytes " + j11 + "-" + (jSc - 1);
                                if (TextUtils.indexOf(str, str2) == -1) {
                                    sc.this.We();
                                    scVar.sc(sc.this, new IOException("The Content-Range Header is invalid Assume[" + str2 + "] vs Real[" + str + "], please remove the temporary file [" + sc.this.pFF + "]."));
                                    return;
                                }
                            }
                        }
                        String str3 = "Rename fail";
                        if (jSc > 0 && sc.this.pFF.exists() && sc.this.pFF.length() == jSc) {
                            sc scVar3 = sc.this;
                            if (!scVar3.pFF.renameTo(scVar3.f26974sc)) {
                                scVar.sc(sc.this, new IOException("Rename fail"));
                                return;
                            } else {
                                pff3.sc(sc.this.f26974sc);
                                scVar.sc(sc.this, pff3);
                                return;
                            }
                        }
                        InputStream inputStream = null;
                        try {
                            try {
                                randomAccessFile = new RandomAccessFile(sc.this.pFF, "rw");
                                try {
                                    if (zExN) {
                                        randomAccessFile.seek(j11);
                                        j12 = j11;
                                    } else {
                                        randomAccessFile.setLength(0L);
                                        j12 = 0;
                                    }
                                    while (true) {
                                        int i15 = inputStreamZY.read(bArr, i12, 16384 - i12);
                                        if (i15 == i14) {
                                            String str4 = str3;
                                            if (i12 != 0) {
                                                randomAccessFile.seek(j12);
                                                randomAccessFile.write(bArr, 0, i12);
                                            }
                                            if (!zExN) {
                                                jSc = sc.this.pFF.length();
                                            }
                                            if (jSc > 0 && sc.this.pFF.exists() && sc.this.pFF.length() == jSc) {
                                                sc scVar4 = sc.this;
                                                if (scVar4.pFF.renameTo(scVar4.f26974sc)) {
                                                    pff3.sc(sc.this.f26974sc);
                                                    scVar.sc(sc.this, pff3);
                                                } else {
                                                    scVar.sc(sc.this, new IOException(str4));
                                                }
                                            } else {
                                                com.bytedance.sdk.component.qr.sc.sc scVar5 = scVar;
                                                sc scVar6 = sc.this;
                                                StringBuilder sb2 = new StringBuilder(" tempFile.length() == fileSize is");
                                                sb2.append(sc.this.pFF.length() == jSc);
                                                scVar5.sc(scVar6, new IOException(sb2.toString()));
                                            }
                                            try {
                                                inputStreamZY.close();
                                            } catch (Throwable unused) {
                                            }
                                            try {
                                                randomAccessFile.close();
                                                return;
                                            } catch (Throwable unused2) {
                                                return;
                                            }
                                        }
                                        i12 += i15;
                                        String str5 = str3;
                                        j13 += (long) i15;
                                        if (j13 % 16384 == 0 || j13 == jSc - j11) {
                                            randomAccessFile.seek(j12);
                                            randomAccessFile.write(bArr, 0, i12);
                                            j12 += (long) i12;
                                            i12 = 0;
                                        }
                                        if (sc.this.WH) {
                                            throw new IOException("net is cancel");
                                        }
                                        str3 = str5;
                                        i14 = -1;
                                    }
                                } catch (Throwable unused3) {
                                }
                            } catch (Throwable unused4) {
                                randomAccessFile = null;
                            }
                            inputStreamZY = bt2.TRI().zY();
                            if (sc.qr(map) && !(inputStreamZY instanceof GZIPInputStream)) {
                                inputStreamZY = new GZIPInputStream(inputStreamZY);
                            }
                            bArr = new byte[16384];
                            j13 = 0;
                            i12 = 0;
                        } catch (Throwable th2) {
                            try {
                                scVar.sc(sc.this, new IOException(th2.getMessage()));
                                if (!zExN) {
                                    sc.this.We();
                                }
                            } finally {
                                if (0 != 0) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable unused5) {
                                    }
                                }
                                try {
                                    randomAccessFile.close();
                                } catch (Throwable unused6) {
                                }
                            }
                        }
                    }

                    @Override // com.bytedance.sdk.component.pFF.sc.zY
                    public void sc(com.bytedance.sdk.component.pFF.sc.pFF pff2, IOException iOException) {
                        com.bytedance.sdk.component.qr.sc.sc scVar3 = scVar;
                        if (scVar3 != null) {
                            scVar3.sc(sc.this, iOException);
                        }
                        sc.this.We();
                    }
                });
            }
        } catch (IllegalArgumentException unused) {
            scVar.sc(this, new IOException("Url is not a valid HTTP or HTTPS URL"));
        }
    }

    public void sc(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        this.f26974sc = new File(str, str2);
        this.pFF = new File(str, str2 + ".temp");
    }
}
