package com.mbridge.msdk.foundation.download.utils;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.ad;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class UnzipUtility {
    private static final int BUFFER_SIZE = 4096;
    private static final String TAG = "UnzipUtility";

    private void extractFile(ZipInputStream zipInputStream, String str) throws Throwable {
        File file = new File(str);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int i11 = zipInputStream.read(bArr);
                        if (i11 == -1) {
                            bufferedOutputStream2.close();
                            return;
                        }
                        bufferedOutputStream2.write(bArr, 0, i11);
                    }
                } catch (IOException e11) {
                    e = e11;
                    throw new IOException(e);
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException e12) {
            e = e12;
        }
    }

    public int unzip(String str, String str2) throws Throwable {
        FileOutputStream fileOutputStream;
        String canonicalPath;
        if (str == null || str2 == null) {
            return -1;
        }
        if (!str2.endsWith("/")) {
            str2 = str2 + "/";
        }
        File file = new File(str);
        if (!file.exists()) {
            return 1;
        }
        InputStream inputStream = null;
        try {
            ZipFile zipFile = new ZipFile(file);
            Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
            fileOutputStream = null;
            while (enumerationEntries.hasMoreElements()) {
                try {
                    try {
                        ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                        if (zipEntryNextElement == null) {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e11) {
                                    ad.b(TAG, e11.getMessage());
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e12) {
                                    ad.b(TAG, e12.getMessage());
                                }
                            }
                            return 2;
                        }
                        String name = zipEntryNextElement.getName();
                        if (!TextUtils.isEmpty(name) && !name.startsWith("..") && !name.startsWith("../")) {
                            File file2 = new File(str2 + name);
                            try {
                                canonicalPath = file2.getCanonicalPath();
                            } catch (IOException unused) {
                                canonicalPath = "";
                            }
                            if (!TextUtils.isEmpty(canonicalPath) && canonicalPath.startsWith(str2) && !canonicalPath.startsWith("..") && !canonicalPath.startsWith("../")) {
                                if (zipEntryNextElement.isDirectory()) {
                                    file2.mkdirs();
                                } else {
                                    if (!file2.getParentFile().exists()) {
                                        file2.getParentFile().mkdirs();
                                    }
                                    FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                                    try {
                                        inputStream = zipFile.getInputStream(zipEntryNextElement);
                                        byte[] bArr = new byte[1024];
                                        while (true) {
                                            int i11 = inputStream.read(bArr, 0, 1024);
                                            if (i11 == -1) {
                                                break;
                                            }
                                            fileOutputStream2.write(bArr, 0, i11);
                                            fileOutputStream2.flush();
                                        }
                                        fileOutputStream = fileOutputStream2;
                                    } catch (IOException e13) {
                                        e = e13;
                                        fileOutputStream = fileOutputStream2;
                                        ad.b(TAG, e.getMessage());
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException e14) {
                                                ad.b(TAG, e14.getMessage());
                                            }
                                        }
                                        if (fileOutputStream == null) {
                                            return 3;
                                        }
                                        try {
                                            fileOutputStream.close();
                                            return 3;
                                        } catch (IOException e15) {
                                            ad.b(TAG, e15.getMessage());
                                            return 3;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        fileOutputStream = fileOutputStream2;
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException e16) {
                                                ad.b(TAG, e16.getMessage());
                                            }
                                        }
                                        if (fileOutputStream == null) {
                                            throw th;
                                        }
                                        try {
                                            fileOutputStream.close();
                                            throw th;
                                        } catch (IOException e17) {
                                            ad.b(TAG, e17.getMessage());
                                            throw th;
                                        }
                                    }
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e18) {
                                    ad.b(TAG, e18.getMessage());
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e19) {
                                    ad.b(TAG, e19.getMessage());
                                }
                            }
                            return 2;
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e21) {
                                ad.b(TAG, e21.getMessage());
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e22) {
                                ad.b(TAG, e22.getMessage());
                            }
                        }
                        return 2;
                    } catch (IOException e23) {
                        e = e23;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            zipFile.close();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e24) {
                    ad.b(TAG, e24.getMessage());
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e25) {
                    ad.b(TAG, e25.getMessage());
                }
            }
            return 0;
        } catch (IOException e26) {
            e = e26;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }
}
