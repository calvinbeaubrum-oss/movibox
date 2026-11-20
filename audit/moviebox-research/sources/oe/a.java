package oe;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.NonNull;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f72412a = 524288;

    /* JADX INFO: renamed from: oe.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0780a {
        void a(double d11);
    }

    public static File a(String str) {
        if (e(str)) {
            return null;
        }
        return new File(str);
    }

    public static boolean b(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return true;
        }
        return c(file.getAbsolutePath());
    }

    public static boolean c(String str) {
        File fileA = a(str);
        if (fileA == null) {
            return false;
        }
        if (fileA.exists()) {
            return true;
        }
        return d(str);
    }

    public static boolean d(String str) {
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = b.f72413a.getContentResolver().openAssetFileDescriptor(Uri.parse(str), CampaignEx.JSON_KEY_AD_R);
                if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                    return false;
                }
                try {
                    assetFileDescriptorOpenAssetFileDescriptor.close();
                    return true;
                } catch (IOException unused) {
                    return true;
                }
            } catch (FileNotFoundException unused2) {
            }
        }
        return false;
    }

    public static boolean e(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i11 = 0; i11 < length; i11++) {
            if (!Character.isWhitespace(str.charAt(i11))) {
                return false;
            }
        }
        return true;
    }

    @NonNull
    public static byte[] f(File file) {
        return g(file, null);
    }

    @NonNull
    public static byte[] g(File file, InterfaceC0780a interfaceC0780a) {
        if (!b(file)) {
            return new byte[0];
        }
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), f72412a);
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[f72412a];
                    if (interfaceC0780a != null) {
                        double dAvailable = bufferedInputStream.available();
                        interfaceC0780a.a(0.0d);
                        int i11 = 0;
                        while (true) {
                            int i12 = bufferedInputStream.read(bArr, 0, f72412a);
                            if (i12 == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, i12);
                            i11 += i12;
                            interfaceC0780a.a(((double) i11) / dAvailable);
                        }
                    } else {
                        while (true) {
                            int i13 = bufferedInputStream.read(bArr, 0, f72412a);
                            if (i13 == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, i13);
                        }
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    bufferedInputStream.close();
                    return byteArray;
                } catch (Throwable th2) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                try {
                    bufferedInputStream.close();
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
    public static String h(File file) {
        return i(file, null);
    }

    @NonNull
    public static String i(File file, String str) {
        byte[] bArrF = f(file);
        if (bArrF.length == 0) {
            return "";
        }
        if (e(str)) {
            return new String(bArrF);
        }
        try {
            return new String(bArrF, str);
        } catch (UnsupportedEncodingException e11) {
            e11.printStackTrace();
            return "";
        }
    }
}
