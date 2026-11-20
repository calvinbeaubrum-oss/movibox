package athena;

import android.util.Base64;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class p0 {
    /* JADX WARN: Code duplicated, block: B:74:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:78:0x009e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:86:? A[SYNTHETIC] */
    public static String a(File file, byte[] bArr) throws Exception {
        Throwable th2;
        ByteArrayOutputStream byteArrayOutputStream;
        Exception e11;
        if (!file.exists() || !file.isFile()) {
            return "";
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        byte[] bArr2 = new byte[1024];
                        while (true) {
                            int i11 = fileInputStream2.read(bArr2);
                            if (i11 == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr2, 0, i11);
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        if (byteArray.length == 0) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e12) {
                                a0.c(e12.getMessage());
                            }
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e13) {
                                a0.c(e13.getMessage());
                            }
                            return "";
                        }
                        String str = new String(f(bArr, byteArray));
                        try {
                            fileInputStream2.close();
                        } catch (IOException e14) {
                            a0.c(e14.getMessage());
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e15) {
                            a0.c(e15.getMessage());
                        }
                        return str;
                    } catch (Exception e16) {
                        e11 = e16;
                        a0.c(Log.getStackTraceString(e11));
                        throw e11;
                    } catch (Throwable th3) {
                        th2 = th3;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e17) {
                                a0.c(e17.getMessage());
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            throw th2;
                        }
                        try {
                            byteArrayOutputStream.close();
                            throw th2;
                        } catch (IOException e18) {
                            a0.c(e18.getMessage());
                            throw th2;
                        }
                    }
                } catch (Exception e19) {
                    e11 = e19;
                }
            } catch (Throwable th4) {
                th2 = th4;
                byteArrayOutputStream = null;
            }
        } catch (Exception e21) {
            e11 = e21;
        } catch (Throwable th5) {
            th2 = th5;
            byteArrayOutputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (byteArrayOutputStream != null) {
                throw th2;
            }
            byteArrayOutputStream.close();
            throw th2;
        }
    }

    public static String b(String str, byte[] bArr) {
        try {
            if (bArr != null) {
                return new String(Base64.encode(e(bArr, str), 2));
            }
            a0.c("encryptEventData password is null");
            return null;
        } catch (Exception e11) {
            a0.c(Log.getStackTraceString(e11));
            return null;
        }
    }

    public static String c(String str, byte[] bArr, int i11) {
        try {
            if (bArr != null) {
                return new String(f(bArr, Base64.decode(str, 2)));
            }
            a0.c("decryptEventData password is null");
            return null;
        } catch (Exception e11) {
            a0.c(Log.getStackTraceString(e11));
            return null;
        }
    }

    public static void d(File file, String str, byte[] bArr) throws Exception {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                byte[] bArrE = e(bArr, str);
                if (bArrE == null || bArrE.length == 0) {
                    throw new Exception("encode failed p = " + br.d.e(bArr) + ", m = " + str.length());
                }
                if (!file.exists() && !file.createNewFile()) {
                    throw new IOException("createNewFile failed");
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                FileOutputStream fileOutputStream3 = fileOutputStream2;
                fileOutputStream3.write(bArrE);
                fileOutputStream3.flush();
                try {
                    fileOutputStream3.close();
                } catch (IOException unused) {
                }
            } catch (Exception e11) {
                a0.c(Log.getStackTraceString(e11));
                throw e11;
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                try {
                    fileOutputStream.close();
                } catch (IOException unused2) {
                }
            }
            throw th2;
        }
    }

    public static byte[] e(byte[] bArr, String str) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(br.g.f14362o));
        try {
            return cipher.doFinal(str.getBytes("UTF-8"));
        } catch (Exception e11) {
            e11.printStackTrace();
            throw e11;
        }
    }

    public static byte[] f(byte[] bArr, byte[] bArr2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec(br.g.f14362o));
        try {
            return cipher.doFinal(bArr2);
        } catch (Exception e11) {
            a0.c(Log.getStackTraceString(e11));
            throw e11;
        }
    }
}
