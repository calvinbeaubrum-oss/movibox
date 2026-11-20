package com.bytedance.adsdk.pFF.We;

import android.util.Pair;
import com.bytedance.component.sdk.annotation.RestrictTo;
import com.bytedance.component.sdk.annotation.WorkerThread;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class qr {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final ExN f26164sc;

    public qr(ExN exN) {
        this.f26164sc = exN;
    }

    private File pFF(String str) throws FileNotFoundException {
        File file = new File(sc(), sc(str, zY.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(sc(), sc(str, zY.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    private File sc() {
        File fileSc = this.f26164sc.sc();
        if (fileSc.isFile()) {
            fileSc.delete();
        }
        if (!fileSc.exists()) {
            fileSc.mkdirs();
        }
        return fileSc;
    }

    private static String sc(String str, zY zYVar, boolean z11) {
        StringBuilder sb2 = new StringBuilder("lottie_cache_");
        sb2.append(str.replaceAll("\\W+", ""));
        sb2.append(z11 ? zYVar.sc() : zYVar.zY);
        return sb2.toString();
    }

    @WorkerThread
    public Pair<zY, InputStream> sc(String str) {
        try {
            File filePFF = pFF(str);
            if (filePFF == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(filePFF);
            zY zYVar = filePFF.getAbsolutePath().endsWith(".zip") ? zY.ZIP : zY.JSON;
            filePFF.getAbsolutePath();
            return new Pair<>(zYVar, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    public File sc(String str, InputStream inputStream, zY zYVar) throws IOException {
        File file = new File(sc(), sc(str, zYVar, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i11 = inputStream.read(bArr);
                    if (i11 == -1) {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        inputStream.close();
                        return file;
                    }
                    fileOutputStream.write(bArr, 0, i11);
                }
            } catch (Throwable th2) {
                fileOutputStream.close();
                throw th2;
            }
        } catch (Throwable th3) {
            inputStream.close();
            throw th3;
        }
    }

    public void sc(String str, zY zYVar) {
        File file = new File(sc(), sc(str, zYVar, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean zRenameTo = file.renameTo(file2);
        file2.toString();
        if (zRenameTo) {
            return;
        }
        file.getAbsolutePath();
        file2.getAbsolutePath();
    }
}
