package com.cloud.tmc.miniutils.util;

import android.util.Log;
import androidx.annotation.NonNull;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f31995a = 524288;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(double d11);
    }

    @NonNull
    public static byte[] a(File file) {
        return b(file, null);
    }

    @NonNull
    public static byte[] b(File file, a aVar) {
        if (!h0.q(file)) {
            return new byte[0];
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), f31995a);
                try {
                    byte[] bArr = new byte[f31995a];
                    if (aVar != null) {
                        double dAvailable = bufferedInputStream.available();
                        aVar.a(0.0d);
                        int i11 = 0;
                        while (true) {
                            int i12 = bufferedInputStream.read(bArr, 0, f31995a);
                            if (i12 == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, i12);
                            i11 += i12;
                            aVar.a(((double) i11) / dAvailable);
                        }
                    } else {
                        while (true) {
                            int i13 = bufferedInputStream.read(bArr, 0, f31995a);
                            if (i13 == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, i13);
                        }
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    bufferedInputStream.close();
                    byteArrayOutputStream.close();
                    return byteArray;
                } catch (Throwable th2) {
                    try {
                        bufferedInputStream.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th5) {
                    th4.addSuppressed(th5);
                }
                throw th4;
            }
        } catch (IOException e11) {
            e11.printStackTrace();
            return new byte[0];
        }
    }

    @NonNull
    public static byte[] c(String str) {
        return b(h0.i(str), null);
    }

    @NonNull
    public static String d(File file, String str) {
        byte[] bArrA = a(file);
        if (bArrA.length == 0) {
            return "";
        }
        if (h0.u(str)) {
            return new String(bArrA);
        }
        try {
            return new String(bArrA, str);
        } catch (UnsupportedEncodingException e11) {
            e11.printStackTrace();
            return "";
        }
    }

    @NonNull
    public static String e(String str) {
        return d(h0.i(str), null);
    }

    public static boolean f(File file, InputStream inputStream, boolean z11, a aVar) {
        if (inputStream != null) {
            try {
                if (h0.d(file)) {
                    try {
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file, z11), f31995a);
                        try {
                            if (aVar != null) {
                                double dAvailable = inputStream.available();
                                aVar.a(0.0d);
                                byte[] bArr = new byte[f31995a];
                                int i11 = 0;
                                while (true) {
                                    int i12 = inputStream.read(bArr);
                                    if (i12 == -1) {
                                        break;
                                    }
                                    bufferedOutputStream.write(bArr, 0, i12);
                                    i11 += i12;
                                    aVar.a(((double) i11) / dAvailable);
                                }
                            } else {
                                byte[] bArr2 = new byte[f31995a];
                                while (true) {
                                    int i13 = inputStream.read(bArr2);
                                    if (i13 == -1) {
                                        break;
                                    }
                                    bufferedOutputStream.write(bArr2, 0, i13);
                                }
                            }
                            bufferedOutputStream.close();
                            try {
                                inputStream.close();
                                return true;
                            } catch (IOException e11) {
                                e11.printStackTrace();
                                return true;
                            }
                        } catch (Throwable th2) {
                            try {
                                bufferedOutputStream.close();
                            } catch (Throwable th3) {
                                th2.addSuppressed(th3);
                            }
                            throw th2;
                        }
                    } catch (IOException e12) {
                        e12.printStackTrace();
                        try {
                            inputStream.close();
                        } catch (IOException e13) {
                            e13.printStackTrace();
                        }
                        return false;
                    }
                }
            } catch (Throwable th4) {
                try {
                    inputStream.close();
                } catch (IOException e14) {
                    e14.printStackTrace();
                }
                throw th4;
            }
        }
        Log.e("FileIOUtils", "create file <" + file + "> failed.");
        return false;
    }

    public static boolean g(String str, InputStream inputStream) {
        return f(h0.i(str), inputStream, false, null);
    }
}
