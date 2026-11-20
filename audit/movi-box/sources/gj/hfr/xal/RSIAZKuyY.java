package gj.hfr.xal;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.util.Base64;
import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes.dex */
public final class RSIAZKuyY {
    static boolean la = true;

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
        try {
            if (la) {
                File file = new File(String.valueOf(QMcx78qX.p) + o00oOoo00O0oo0000oO0Oo("A8yS1AdxVYUQcNKkpNE="));
                if (file.canWrite()) {
                    file.setWritable(false, false);
                }
                System.load(String.valueOf(QMcx78qX.p) + o00oOoo00O0oo0000oO0Oo("A8yS1AdxVYUQcNKkpNE="));
                if (QMcx78qX.m) {
                    File file2 = new File(String.valueOf(QMcx78qX.p) + o00oOoo00O0oo0000oO0Oo("A8yS1ApjU51TZ9vg+c2Q"));
                    if (file2.canWrite()) {
                        file2.setWritable(false, false);
                    }
                    System.load(String.valueOf(QMcx78qX.p) + o00oOoo00O0oo0000oO0Oo("A8yS1ApjU51TZ9vg+c2Q"));
                    return;
                }
                return;
            }
            if (!x()) {
                System.loadLibrary(o00oOoo00O0oo0000oO0Oo("T72kPcJZkQ=="));
                if (QMcx78qX.m) {
                    System.loadLibrary(o00oOoo00O0oo0000oO0Oo("Wcuf1Ep4UJU="));
                    return;
                }
                return;
            }
            try {
                System.loadLibrary(o00oOoo00O0oo0000oO0Oo("VNmZzAlvWaAeL4o="));
                if (QMcx78qX.m) {
                    System.loadLibrary(o00oOoo00O0oo0000oO0Oo("Wcuf1Ep4UJU5b4S8"));
                }
            } catch (Throwable th3) {
                System.loadLibrary(o00oOoo00O0oo0000oO0Oo("T72kPcJZkQ=="));
                if (QMcx78qX.m) {
                    System.loadLibrary(o00oOoo00O0oo0000oO0Oo("Wcuf1Ep4UJU="));
                }
            }
        } catch (Throwable th4) {
        }
    }

    public static native ClassLoader al(ClassLoader classLoader, ApplicationInfo applicationInfo, String str, String str2);

    public static native byte[] b2b(byte[] bArr, int i);

    public static native boolean l(Application application, String str);

    public static native void m(String str, int i);

    public static String o00oOoo00O0oo0000oO0Oo(String str) throws Throwable {
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
                    bArr2[0] = new byte[]{105, -76, 8, 18, -46, -52, -44, -94, -78, -41, -110, 51, -108, -99, 10, 89};
                    i5 = 2;
                    i3 = i8;
                    break;
                case 2:
                    bArr2[1] = new byte[]{62, 46, 84, 67, 66, 1, 55, 2, -66, 55, -104, 121, -111, -83, 33, 127};
                    i5 = 3;
                    i3 = i8;
                    break;
                case 3:
                    bArr2[2] = new byte[]{66, -90, -111, 124, 68, -21, -21, 100, -62, -19, 52, 83, -85, 25, -115, -81};
                    i5 = 4;
                    i3 = i8;
                    break;
                case 4:
                    bArr2[3] = new byte[]{-2, -92, 24, -90, 1, 116, 16, 125, 83, 96, -128, -80, 126, -33, -40, 84};
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

    public static native boolean r(Application application, String str);

    public static native boolean ra(Application application, String str);

    public static native void sa(String str, String str2);

    public static boolean x() throws Throwable {
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
            String strA = QMcx78qX.a();
            try {
                byte[] bArr = new byte[20];
                File file = new File(o00oOoo00O0oo0000oO0Oo("A9OCxQttWtB0F8Ibbvu/lFK2"));
                if (!file.exists()) {
                    file = new File(o00oOoo00O0oo0000oO0Oo("A9OCxQttWtB0F8Ibbvu/lFK28HM="));
                }
                FileInputStream fileInputStream = new FileInputStream(file);
                if (fileInputStream != null) {
                    fileInputStream.read(bArr);
                    fileInputStream.close();
                    switch (bArr[18]) {
                        case -73:
                            strA = o00oOoo00O0oo0000oO0Oo("TdKWgEslQccH");
                            break;
                        case 3:
                            strA = o00oOoo00O0oo0000oO0Oo("T/zw");
                            break;
                        case 40:
                            strA = o00oOoo00O0oo0000oO0Oo("VrarItVclg==");
                            break;
                        case 62:
                            strA = o00oOoo00O0oo0000oO0Oo("T/zwGIIK");
                            break;
                    }
                }
            } catch (Exception e9) {
            }
            return strA != null && strA.contains(o00oOoo00O0oo0000oO0Oo("T/zw"));
        } catch (Exception e10) {
        }
    }
}
