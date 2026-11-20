package gj.hfr.xal;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.util.Base64;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes.dex */
public final class QMcx78qX extends Application {
    public static String p = null;
    public static Application n = null;
    public static boolean m = true;
    public static String f = null;
    public static boolean l = false;
    public static long sT = 0;
    public static long eT = 0;
    public static long tT = 0;
    public static boolean la = true;

    static {
        Object obj;
        Object obj2;
        Object obj3 = null;
        try {
            obj2 = new Object();
            try {
                Object obj4 = new Object();
                if (obj2 != null) {
                    try {
                        obj2.hashCode();
                    } catch (Exception e) {
                    }
                }
                if (obj4 != null) {
                    try {
                        obj4.hashCode();
                    } catch (Exception e2) {
                    }
                }
            } catch (Exception e3) {
                if (obj2 != null) {
                    try {
                        obj2.hashCode();
                    } catch (Exception e4) {
                    }
                }
                if (0 != 0) {
                    try {
                        obj3.hashCode();
                    } catch (Exception e5) {
                    }
                }
            } catch (Throwable th) {
                obj = obj2;
                th = th;
                if (obj != null) {
                    try {
                        obj.hashCode();
                    } catch (Exception e6) {
                    }
                }
                if (0 == 0) {
                    throw th;
                }
                try {
                    obj3.hashCode();
                    throw th;
                } catch (Exception e7) {
                    throw th;
                }
            }
        } catch (Exception e8) {
            obj2 = null;
        } catch (Throwable th2) {
            th = th2;
            obj = null;
        }
    }

    public static String O0000o000000oOoo(String str) throws Throwable {
        Object obj;
        int i;
        String str2;
        Object obj2 = null;
        Object obj3 = null;
        try {
            obj = new Object();
            try {
                Object obj4 = new Object();
                if (obj != null) {
                    try {
                        obj.hashCode();
                    } catch (Exception e) {
                    }
                }
                if (obj4 != null) {
                    try {
                        obj4.hashCode();
                    } catch (Exception e2) {
                    }
                }
            } catch (Exception e3) {
                if (obj != null) {
                    try {
                        obj.hashCode();
                    } catch (Exception e4) {
                    }
                }
                if (0 != 0) {
                    try {
                        obj3.hashCode();
                    } catch (Exception e5) {
                    }
                }
            } catch (Throwable th) {
                obj2 = obj;
                th = th;
                if (obj2 != null) {
                    try {
                        obj2.hashCode();
                    } catch (Exception e6) {
                    }
                }
                if (0 == 0) {
                    throw th;
                }
                try {
                    obj3.hashCode();
                    throw th;
                } catch (Exception e7) {
                    throw th;
                }
            }
        } catch (Exception e8) {
            obj = null;
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            Class.forName(new String(""));
        } catch (Exception e9) {
        }
        long j = 4 | 7;
        long j2 = (j << 2) - 2;
        long j3 = (j << 1) - 1;
        byte[][] bArr = new byte[4][];
        byte[][] bArr2 = new byte[4][];
        byte[] bArr3 = null;
        int i2 = 0;
        int i3 = 0;
        String str3 = null;
        int i4 = 0;
        int i5 = 0;
        byte[] bArr4 = null;
        int i6 = 0;
        UnsupportedEncodingException e10 = null;
        int i7 = 0;
        while (i5 >= 0) {
            long j4 = (((long) i5) ^ 3405691582L) * j2;
            int i8 = ((1 & j4) != 0 || i5 <= 20) ? i3 : (int) ((j4 % 2) + ((long) i3));
            switch (i5) {
                case 0:
                    byte[] bArrDecode = Base64.decode(str, 0);
                    int length = bArrDecode.length;
                    byte[] bArr5 = new byte[length];
                    int i9 = length / 8;
                    int i10 = length % 8;
                    bArr3 = bArrDecode;
                    i4 = length;
                    i5 = 1;
                    bArr4 = bArr5;
                    i7 = i9;
                    i3 = i8;
                    break;
                case 1:
                    bArr2[0] = new byte[]{-29, -63, 121, 123, 32, -95, 100, -121, 82, 15, 87, 8, -122, 45, -101, -23};
                    i5 = 2;
                    i3 = i8;
                    break;
                case 2:
                    bArr2[1] = new byte[]{86, -38, -30, -115, 35, 46, -118, 6, -74, 67, 125, 123, 11, 127, -117, -52};
                    i5 = 3;
                    i3 = i8;
                    break;
                case 3:
                    bArr2[2] = new byte[]{29, 45, 109, 105, -16, 97, 115, -120, 46, -8, 84, -58, 13, 9, -125, -109};
                    i5 = 4;
                    i3 = i8;
                    break;
                case 4:
                    bArr2[3] = new byte[]{108, -97, -83, 76, 83, 18, -122, -56, 91, 61, -1, -120, -18, 126, 72, -74};
                    i5 = 10;
                    i3 = 0;
                    break;
                case 10:
                    bArr[0] = new byte[bArr2[0].length];
                    i5 = 11;
                    i3 = i8;
                    break;
                case 11:
                    if (i8 < bArr2[0].length) {
                        bArr[0][(((int) (j - 4)) + i8) % bArr2[0].length] = bArr2[0][i8];
                        i3 = i8 + 1;
                    } else {
                        i5 = 12;
                        i3 = 0;
                    }
                    break;
                case 12:
                    bArr[1] = new byte[bArr2[1].length];
                    i5 = 13;
                    i3 = i8;
                    break;
                case 13:
                    if (i8 < bArr2[1].length) {
                        bArr[1][(((int) (7 - 2)) + i8) % bArr2[1].length] = bArr2[1][i8];
                        i3 = i8 + 1;
                    } else {
                        i5 = 14;
                        i3 = 0;
                    }
                    break;
                case 14:
                    bArr[2] = new byte[bArr2[2].length];
                    System.arraycopy(bArr2[2], 0, bArr[2], 0, bArr2[2].length);
                    i5 = 15;
                    i3 = i8;
                    break;
                case 15:
                    if (i8 < bArr[2].length) {
                        int length2 = (((bArr[2][i8] & 255) ^ ((int) j2)) + i8) % bArr[2].length;
                        byte b = bArr[2][i8];
                        bArr[2][i8] = bArr[2][length2];
                        bArr[2][length2] = b;
                        i3 = i8 + 1;
                    } else {
                        i5 = 16;
                        i3 = 0;
                    }
                    break;
                case 16:
                    bArr[3] = new byte[bArr2[3].length];
                    System.arraycopy(bArr2[3], 0, bArr[3], 0, bArr2[3].length);
                    i5 = 17;
                    i3 = i8;
                    break;
                case 17:
                    if (i8 < bArr[3].length) {
                        int length3 = (((bArr[3][i8] & 255) ^ ((int) j3)) + i8) % bArr[3].length;
                        byte b2 = bArr[3][i8];
                        bArr[3][i8] = bArr[3][length3];
                        bArr[3][length3] = b2;
                        i3 = i8 + 1;
                    } else {
                        i5 = 20;
                        i2 = 0;
                        i3 = 0;
                    }
                    break;
                case 20:
                    if (i2 >= i7) {
                        i5 = 21;
                        i3 = i7 * 8;
                    } else if (i6 < 8) {
                        int i11 = (i2 * 8) + i6;
                        for (int i12 = (((i11 ^ 165) & 7) * 2) + 1; i12 > 0; i12 = 0) {
                            int i13 = i12 - 1;
                            if (i12 == 1) {
                                bArr4[i11] = (byte) (bArr3[i11] ^ bArr[0][i11 % bArr[0].length]);
                            } else {
                                int i14 = i13 - 1;
                                if (i13 == 2) {
                                    bArr4[i11] = (byte) (bArr3[i11] ^ bArr[1][i11 % bArr[1].length]);
                                } else {
                                    int i15 = i14 - 1;
                                    if (i14 == 3) {
                                        bArr4[i11] = (byte) (bArr3[i11] ^ (-1));
                                    } else {
                                        int i16 = i15 - 1;
                                        if (i15 == 4) {
                                            bArr4[i11] = (byte) ((bArr3[i11] ^ bArr[2][i11 % bArr[2].length]) ^ bArr[3][i11 % bArr[3].length]);
                                        } else {
                                            int i17 = i16 - 1;
                                            if (i16 == 5) {
                                                bArr4[i11] = (byte) ((bArr3[i11] ^ bArr[0][i11 % bArr[0].length]) ^ 170);
                                            } else {
                                                int i18 = i17 - 1;
                                                if (i17 == 6) {
                                                    bArr4[i11] = (byte) ((bArr3[i11] ^ bArr[1][i11 % bArr[1].length]) ^ 85);
                                                } else {
                                                    int i19 = i18 - 1;
                                                    if (i18 == 7) {
                                                        bArr4[i11] = (byte) (((bArr3[i11] ^ bArr[2][i11 % bArr[2].length]) ^ bArr[3][i11 % bArr[3].length]) ^ 255);
                                                    } else {
                                                        bArr4[i11] = (byte) ((bArr3[i11] ^ 15) ^ (bArr[0][i11 % bArr[0].length] ^ bArr[1][i11 % bArr[1].length]));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        i6++;
                        i3 = i8;
                    } else {
                        i2++;
                        i6 = 0;
                        i3 = i8;
                    }
                    break;
                case 21:
                    if (i8 < i4) {
                        byte b3 = bArr[0][i8 % bArr[0].length];
                        byte b4 = bArr[1][i8 % bArr[1].length];
                        byte b5 = bArr[2][i8 % bArr[2].length];
                        byte b6 = bArr[3][i8 % bArr[3].length];
                        int i20 = (((int) ((2 * j2) + 8)) ^ i8) & 7;
                        do {
                            if (i20 == 0) {
                                bArr4[i8] = (byte) (b3 ^ bArr3[i8]);
                            } else if (i20 == 1) {
                                bArr4[i8] = (byte) (bArr3[i8] ^ b4);
                            } else if (i20 == 2) {
                                bArr4[i8] = (byte) (bArr3[i8] ^ (-1));
                            } else if (i20 == 3) {
                                bArr4[i8] = (byte) ((bArr3[i8] ^ b6) ^ b5);
                            } else if (i20 == 4) {
                                bArr4[i8] = (byte) (b3 ^ (bArr3[i8] ^ 170));
                            } else if (i20 == 5) {
                                bArr4[i8] = (byte) ((bArr3[i8] ^ 85) ^ b4);
                            } else if (i20 == 6) {
                                bArr4[i8] = (byte) (((bArr3[i8] ^ 255) ^ b6) ^ b5);
                            } else {
                                bArr4[i8] = (byte) ((bArr3[i8] ^ 15) ^ (b3 ^ b4));
                            }
                            i3 = i8 + 1;
                            break;
                        } while ((4 & 7) == 1);
                        i3 = i8 + 1;
                    } else {
                        i5 = 100;
                        i3 = i8;
                    }
                    break;
                case 100:
                    try {
                        str2 = new String(bArr4, "UTF-8");
                        i = i5;
                    } catch (UnsupportedEncodingException e11) {
                        e10 = e11;
                        String str4 = str3;
                        i = -2;
                        str2 = str4;
                    }
                    if (i != -2) {
                        i5 = -1;
                        str3 = str2;
                        i3 = i8;
                    } else {
                        i5 = i;
                        str3 = str2;
                        i3 = i8;
                    }
                    break;
                default:
                    if (e10 != null) {
                        e10.printStackTrace();
                    }
                    str3 = null;
                    i5 = -1;
                    i3 = i8;
                    break;
            }
        }
        return str3;
    }

    public static String a() throws Throwable {
        Object obj;
        Object obj2;
        Object obj3 = null;
        try {
            obj2 = new Object();
            try {
                Object obj4 = new Object();
                if (obj2 != null) {
                    try {
                        obj2.hashCode();
                    } catch (Exception e) {
                    }
                }
                if (obj4 != null) {
                    try {
                        obj4.hashCode();
                    } catch (Exception e2) {
                    }
                }
            } catch (Exception e3) {
                if (obj2 != null) {
                    try {
                        obj2.hashCode();
                    } catch (Exception e4) {
                    }
                }
                if (0 != 0) {
                    try {
                        obj3.hashCode();
                    } catch (Exception e5) {
                    }
                }
            } catch (Throwable th) {
                obj = obj2;
                th = th;
                if (obj != null) {
                    try {
                        obj.hashCode();
                    } catch (Exception e6) {
                    }
                }
                if (0 == 0) {
                    throw th;
                }
                try {
                    obj3.hashCode();
                    throw th;
                } catch (Exception e7) {
                    throw th;
                }
            }
        } catch (Exception e8) {
            obj2 = null;
        } catch (Throwable th2) {
            th = th2;
            obj = null;
        }
        String strO0000o000000oOoo = O0000o000000oOoo("5iy3AqA0lg==");
        try {
            Field declaredField = Build.class.getDeclaredField(O0000o000000oOoo("fWTJj4Mr8bpPKaWVRuU="));
            declaredField.setAccessible(true);
            Object obj5 = declaredField.get(null);
            return (obj5 == null || !Arrays.toString((String[]) obj5).contains(O0000o000000oOoo("/2bs"))) ? strO0000o000000oOoo : O0000o000000oOoo("/2bs");
        } catch (Exception e9) {
            try {
                Method declaredMethod = Build.class.getDeclaredMethod(O0000o000000oOoo("SVTtjLgLzJFs"), String.class);
                declaredMethod.setAccessible(true);
                return (String) declaredMethod.invoke(null, O0000o000000oOoo("XF63r74WwYq7uoiCdiIQnuU3"));
            } catch (Exception e10) {
                return strO0000o000000oOoo;
            }
        }
    }

    public static void c(String str) throws Throwable {
        Object obj;
        Object obj2;
        ZipEntry entry;
        Object obj3 = null;
        try {
            obj2 = new Object();
            try {
                Object obj4 = new Object();
                if (obj2 != null) {
                    try {
                        obj2.hashCode();
                    } catch (Exception e) {
                    }
                }
                if (obj4 != null) {
                    try {
                        obj4.hashCode();
                    } catch (Exception e2) {
                    }
                }
            } catch (Exception e3) {
                if (obj2 != null) {
                    try {
                        obj2.hashCode();
                    } catch (Exception e4) {
                    }
                }
                if (0 != 0) {
                    try {
                        obj3.hashCode();
                    } catch (Exception e5) {
                    }
                }
            } catch (Throwable th) {
                obj = obj2;
                th = th;
                if (obj != null) {
                    try {
                        obj.hashCode();
                    } catch (Exception e6) {
                    }
                }
                if (0 == 0) {
                    throw th;
                }
                try {
                    obj3.hashCode();
                    throw th;
                } catch (Exception e7) {
                    throw th;
                }
            }
        } catch (Exception e8) {
            obj2 = null;
        } catch (Throwable th2) {
            th = th2;
            obj = null;
        }
        String str2 = String.format(O0000o000000oOoo("T0LqurgKirKLitC0Qgd4nAEU6vCgEMeHoazcl2E5EIzo"), str);
        String str3 = String.format(O0000o000000oOoo("T0LqurgKirKLitC0Qgd4nAEU6vCgEMeKs6rE1HYwVNH0MQ=="), str);
        File file = new File(p, O0000o000000oOoo("Qlj7p7Ub34lsGMqkYA=="));
        File file2 = new File(p, O0000o000000oOoo("Qlj7qqcdx8p7EY75fNk="));
        ZipFile zipFile = new ZipFile(f);
        ZipEntry entry2 = zipFile.getEntry(str2);
        if (entry2 != null && entry2.getCrc() != g(file)) {
            c(zipFile, entry2, file);
        }
        if (m && (entry = zipFile.getEntry(str3)) != null && entry.getCrc() != g(file2)) {
            c(zipFile, entry, file2);
        }
        zipFile.close();
    }

    public static void c(ZipFile zipFile, ZipEntry zipEntry, File file) throws Throwable {
        Object obj;
        Object obj2;
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        byte[] bArr;
        Object obj3 = null;
        try {
            try {
                obj2 = new Object();
                try {
                    Object obj4 = new Object();
                    if (obj2 != null) {
                        try {
                            obj2.hashCode();
                        } catch (Exception e) {
                        }
                    }
                    if (obj4 != null) {
                        try {
                            obj4.hashCode();
                        } catch (Exception e2) {
                        }
                    }
                    while (true) {
                        int i = inputStream.read(bArr);
                        if (i == -1) {
                            break;
                        } else {
                            fileOutputStream.write(bArr, 0, i);
                        }
                    }
                } catch (Exception e3) {
                    if (obj2 != null) {
                        try {
                            obj2.hashCode();
                        } catch (Exception e4) {
                        }
                    }
                    if (0 != 0) {
                        try {
                            obj3.hashCode();
                        } catch (Exception e5) {
                        }
                    }
                } catch (Throwable th) {
                    obj = obj2;
                    th = th;
                    if (obj != null) {
                        try {
                            obj.hashCode();
                        } catch (Exception e6) {
                        }
                    }
                    if (0 == 0) {
                        throw th;
                    }
                    try {
                        obj3.hashCode();
                        throw th;
                    } catch (Exception e7) {
                        throw th;
                    }
                }
            } catch (Exception e8) {
                obj2 = null;
            } catch (Throwable th2) {
                th = th2;
                obj = null;
            }
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (!file.canWrite()) {
                file.setWritable(true, true);
            }
            inputStream = zipFile.getInputStream(zipEntry);
            fileOutputStream = new FileOutputStream(file);
            bArr = new byte[1024];
            inputStream.close();
            fileOutputStream.close();
            if (file.canWrite()) {
                file.setWritable(false, false);
            }
        } catch (IOException e9) {
        }
    }

    public static long g(File file) throws Throwable {
        Object obj;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        long value = 0;
        CheckedInputStream checkedInputStream = null;
        Object obj2 = null;
        try {
            obj = new Object();
            try {
                Object obj3 = new Object();
                if (obj != null) {
                    try {
                        obj.hashCode();
                    } catch (Exception e) {
                    }
                }
                if (obj3 != null) {
                    try {
                        obj3.hashCode();
                    } catch (Exception e2) {
                    }
                }
            } catch (Exception e3) {
                if (obj != null) {
                    try {
                        obj.hashCode();
                    } catch (Exception e4) {
                    }
                }
                if (0 != 0) {
                    try {
                        obj2.hashCode();
                    } catch (Exception e5) {
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (obj != null) {
                    try {
                        obj.hashCode();
                    } catch (Exception e6) {
                    }
                }
                if (0 == 0) {
                    throw th;
                }
                try {
                    obj2.hashCode();
                    throw th;
                } catch (Exception e7) {
                    throw th;
                }
            }
        } catch (Exception e8) {
            obj = null;
        } catch (Throwable th2) {
            th = th2;
            obj = null;
        }
        if (file.exists()) {
            CRC32 crc32 = new CRC32();
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    CheckedInputStream checkedInputStream2 = new CheckedInputStream(fileInputStream, crc32);
                    try {
                        while (checkedInputStream2.read(new byte[1024]) != -1) {
                        }
                        value = crc32.getValue();
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e9) {
                            }
                        }
                        if (checkedInputStream2 != null) {
                            try {
                                checkedInputStream2.close();
                            } catch (IOException e10) {
                            }
                        }
                    } catch (Exception e11) {
                        checkedInputStream = checkedInputStream2;
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e12) {
                            }
                        }
                        if (checkedInputStream != null) {
                            try {
                                checkedInputStream.close();
                            } catch (IOException e13) {
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        checkedInputStream = checkedInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e14) {
                            }
                        }
                        if (checkedInputStream == null) {
                            throw th;
                        }
                        try {
                            checkedInputStream.close();
                            throw th;
                        } catch (IOException e15) {
                            throw th;
                        }
                    }
                } catch (Exception e16) {
                    fileInputStream2 = fileInputStream;
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (Exception e17) {
                fileInputStream2 = null;
            } catch (Throwable th5) {
                th = th5;
                fileInputStream = null;
            }
        }
        return value;
    }

    public static void gET() {
        eT = System.currentTimeMillis();
        tT = eT - sT;
    }

    public static void gST() {
        sT = System.currentTimeMillis();
    }

    public static boolean il() throws Throwable {
        Object obj;
        Object obj2;
        boolean z;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        Object obj3 = null;
        try {
            try {
                obj2 = new Object();
                try {
                    Object obj4 = new Object();
                    if (obj2 != null) {
                        try {
                            obj2.hashCode();
                        } catch (Exception e) {
                        }
                    }
                    if (obj4 != null) {
                        try {
                            obj4.hashCode();
                        } catch (Exception e2) {
                        }
                    }
                    while (true) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            if (line.contains(O0000o000000oOoo("AV3wvfpNipOxrMeTcnlNkA==")) || line.contains(O0000o000000oOoo("AV3wvfpNipOxrMeOZXlNkA==")) || line.contains(O0000o000000oOoo("AVPwseMVzJFgE5bhOw=="))) {
                                z = true;
                                break;
                            }
                        } catch (Exception e3) {
                            bufferedReader2 = bufferedReader;
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e4) {
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e5) {
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Exception e6) {
                    if (obj2 != null) {
                        try {
                            obj2.hashCode();
                        } catch (Exception e7) {
                        }
                    }
                    if (0 != 0) {
                        try {
                            obj3.hashCode();
                        } catch (Exception e8) {
                        }
                    }
                } catch (Throwable th2) {
                    obj = obj2;
                    th = th2;
                    if (obj != null) {
                        try {
                            obj.hashCode();
                        } catch (Exception e9) {
                        }
                    }
                    if (0 == 0) {
                        throw th;
                    }
                    try {
                        obj3.hashCode();
                        throw th;
                    } catch (Exception e10) {
                        throw th;
                    }
                }
            } catch (Exception e11) {
                obj2 = null;
            } catch (Throwable th3) {
                th = th3;
                obj = null;
            }
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(O0000o000000oOoo("AUHrsK9W1ppnEMu6bsaM"))));
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e12) {
                }
            }
        } catch (Exception e13) {
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
        }
        z = false;
        return z;
    }

    public static void l(Context context) throws Throwable {
        Object obj;
        Object obj2;
        Object obj3 = null;
        try {
            obj2 = new Object();
            try {
                Object obj4 = new Object();
                if (obj2 != null) {
                    try {
                        obj2.hashCode();
                    } catch (Exception e) {
                    }
                }
                if (obj4 != null) {
                    try {
                        obj4.hashCode();
                    } catch (Exception e2) {
                    }
                }
            } catch (Exception e3) {
                if (obj2 != null) {
                    try {
                        obj2.hashCode();
                    } catch (Exception e4) {
                    }
                }
                if (0 != 0) {
                    try {
                        obj3.hashCode();
                    } catch (Exception e5) {
                    }
                }
            } catch (Throwable th) {
                obj = obj2;
                th = th;
                if (obj != null) {
                    try {
                        obj.hashCode();
                    } catch (Exception e6) {
                    }
                }
                if (0 == 0) {
                    throw th;
                }
                try {
                    obj3.hashCode();
                    throw th;
                } catch (Exception e7) {
                    throw th;
                }
            }
        } catch (Exception e8) {
            obj2 = null;
        } catch (Throwable th2) {
            th = th2;
            obj = null;
        }
        try {
            if (p == null) {
                p = context.getFilesDir().getAbsolutePath();
            }
            if (f == null) {
                f = context.getPackageCodePath();
            }
            String strA = a();
            String strLd = ld(context);
            if (strLd.equals("")) {
                strLd = strA;
            }
            if (strLd == null || !strLd.contains(O0000o000000oOoo("/2bs"))) {
                if (il()) {
                    c(O0000o000000oOoo("T0P06fhU08dq"));
                    return;
                } else {
                    c(O0000o000000oOoo("5iy3AqA0lg=="));
                    return;
                }
            }
            if (il()) {
                c(O0000o000000oOoo("/2bsOPdi"));
            } else {
                c(O0000o000000oOoo("/2bs"));
            }
        } catch (Exception e9) {
            try {
                c(O0000o000000oOoo("5iy3AqA0lg=="));
            } catch (Exception e10) {
            }
        }
    }

    public static String ld(Context context) throws Throwable {
        Object obj;
        Object obj2;
        Object obj3 = null;
        try {
            obj2 = new Object();
            try {
                Object obj4 = new Object();
                if (obj2 != null) {
                    try {
                        obj2.hashCode();
                    } catch (Exception e) {
                    }
                }
                if (obj4 != null) {
                    try {
                        obj4.hashCode();
                    } catch (Exception e2) {
                    }
                }
            } catch (Exception e3) {
                if (obj2 != null) {
                    try {
                        obj2.hashCode();
                    } catch (Exception e4) {
                    }
                }
                if (0 != 0) {
                    try {
                        obj3.hashCode();
                    } catch (Exception e5) {
                    }
                }
            } catch (Throwable th) {
                obj = obj2;
                th = th;
                if (obj != null) {
                    try {
                        obj.hashCode();
                    } catch (Exception e6) {
                    }
                }
                if (0 == 0) {
                    throw th;
                }
                try {
                    obj3.hashCode();
                    throw th;
                } catch (Exception e7) {
                    throw th;
                }
            }
        } catch (Exception e8) {
            obj2 = null;
        } catch (Throwable th2) {
            th = th2;
            obj = null;
        }
        try {
            byte[] bArr = new byte[20];
            File file = new File(O0000o000000oOoo("AULgrLgcyNC6p8jOaj5QlOIs"));
            if (!file.exists()) {
                file = new File(O0000o000000oOoo("AULgrLgcyNC6p8jOaj5QlOIs7FM="));
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            if (fileInputStream == null) {
                return "";
            }
            fileInputStream.read(bArr);
            fileInputStream.close();
            switch (bArr[18]) {
                case -73:
                    return O0000o000000oOoo("T0P06fhU08dq");
                case 3:
                    return O0000o000000oOoo("/2bs");
                case 40:
                    return O0000o000000oOoo("5iy3AqA0lg==");
                case 62:
                    return O0000o000000oOoo("/2bsOPdi");
                default:
                    return "";
            }
        } catch (Exception e9) {
            return "";
        }
    }

    public static void sp() throws Throwable {
        Object obj;
        Object obj2;
        Object obj3 = null;
        try {
            obj2 = new Object();
            try {
                Object obj4 = new Object();
                if (obj2 != null) {
                    try {
                        obj2.hashCode();
                    } catch (Exception e) {
                    }
                }
                if (obj4 != null) {
                    try {
                        obj4.hashCode();
                    } catch (Exception e2) {
                    }
                }
            } catch (Exception e3) {
                if (obj2 != null) {
                    try {
                        obj2.hashCode();
                    } catch (Exception e4) {
                    }
                }
                if (0 != 0) {
                    try {
                        obj3.hashCode();
                    } catch (Exception e5) {
                    }
                }
            } catch (Throwable th) {
                obj = obj2;
                th = th;
                if (obj != null) {
                    try {
                        obj.hashCode();
                    } catch (Exception e6) {
                    }
                }
                if (0 == 0) {
                    throw th;
                }
                try {
                    obj3.hashCode();
                    throw th;
                } catch (Exception e7) {
                    throw th;
                }
            }
        } catch (Exception e8) {
            obj2 = null;
        } catch (Throwable th2) {
            th = th2;
            obj = null;
        }
        try {
            Method declaredMethod = Class.forName(O0000o000000oOoo("TV708aUTyNG8r9KAYzldjVdB7bajF4u7TiKLuGM=")).getDeclaredMethod(O0000o000000oOoo("Ql74u4g81pA="), String.class, String.class, String.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, f, p, O0000o000000oOoo("TV708a8WyJKtoM+Vf3lRkeIstQis"));
        } catch (Exception e9) {
        }
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) throws Throwable {
        Object obj;
        Object obj2;
        gST();
        super.attachBaseContext(context);
        Object obj3 = null;
        try {
            obj2 = new Object();
            try {
                Object obj4 = new Object();
                if (obj2 != null) {
                    try {
                        obj2.hashCode();
                    } catch (Exception e) {
                    }
                }
                if (obj4 != null) {
                    try {
                        obj4.hashCode();
                    } catch (Exception e2) {
                    }
                }
            } catch (Exception e3) {
                if (obj2 != null) {
                    try {
                        obj2.hashCode();
                    } catch (Exception e4) {
                    }
                }
                if (0 != 0) {
                    try {
                        obj3.hashCode();
                    } catch (Exception e5) {
                    }
                }
            } catch (Throwable th) {
                obj = obj2;
                th = th;
                if (obj != null) {
                    try {
                        obj.hashCode();
                    } catch (Exception e6) {
                    }
                }
                if (0 == 0) {
                    throw th;
                }
                try {
                    obj3.hashCode();
                    throw th;
                } catch (Exception e7) {
                    throw th;
                }
            }
        } catch (Exception e8) {
            obj2 = null;
        } catch (Throwable th2) {
            th = th2;
            obj = null;
        }
        if (la) {
            l(context);
        }
        RSIAZKuyY.l(this, O0000o000000oOoo("TV708a8WyJKtoM+Vf3lRkeIstQis"));
        RSIAZKuyY.r(this, O0000o000000oOoo("TV708bgLxJGrvc+OaHlNikxD9rChV8SPqOD1lGQFUZDqH6oX"));
        gET();
    }

    @Override // android.app.Application
    public void onCreate() throws Throwable {
        Object obj;
        Object obj2;
        Object obj3 = null;
        try {
            obj2 = new Object();
            try {
                Object obj4 = new Object();
                if (obj2 != null) {
                    try {
                        obj2.hashCode();
                    } catch (Exception e) {
                    }
                }
                if (obj4 != null) {
                    try {
                        obj4.hashCode();
                    } catch (Exception e2) {
                    }
                }
            } catch (Exception e3) {
                if (obj2 != null) {
                    try {
                        obj2.hashCode();
                    } catch (Exception e4) {
                    }
                }
                if (0 != 0) {
                    try {
                        obj3.hashCode();
                    } catch (Exception e5) {
                    }
                }
            } catch (Throwable th) {
                obj = obj2;
                th = th;
                if (obj != null) {
                    try {
                        obj.hashCode();
                    } catch (Exception e6) {
                    }
                }
                if (0 == 0) {
                    throw th;
                }
                try {
                    obj3.hashCode();
                    throw th;
                } catch (Exception e7) {
                    throw th;
                }
            }
        } catch (Exception e8) {
            obj2 = null;
        } catch (Throwable th2) {
            th = th2;
            obj = null;
        }
        RSIAZKuyY.ra(this, O0000o000000oOoo("TV708bgLxJGrvc+OaHlNikxD9rChV8SPqOD1lGQFUZDqH6oX"));
        if (n != null) {
            n.onCreate();
        }
        super.onCreate();
    }
}
