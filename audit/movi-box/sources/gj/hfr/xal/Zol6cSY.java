package gj.hfr.xal;

import android.util.Base64;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: C */
/* JADX INFO: loaded from: classes.dex */
public class Zol6cSY {
    public static native void i(int i);

    public static String oOooo0o0ooooO00OoooO(String str) throws Throwable {
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
                    bArr2[0] = new byte[]{-37, 89, -13, -111, -110, -20, -83, -14, -125, 72, 59, -33, -54, -128, -125, 21};
                    i5 = 2;
                    i3 = i8;
                    break;
                case 2:
                    bArr2[1] = new byte[]{-47, 58, -90, 37, 22, -47, 88, -39, 78, -94, 55, -121, 31, -6, -38, -25};
                    i5 = 3;
                    i3 = i8;
                    break;
                case 3:
                    bArr2[2] = new byte[]{-22, -106, 50, 88, -18, -115, 8, -14, -100, 47, -127, 61, 13, 126, 27, 51};
                    i5 = 4;
                    i3 = i8;
                    break;
                case 4:
                    bArr2[3] = new byte[]{61, -27, 43, 120, -4, -12, -96, 91, -9, -31, -89, 109, 49, -114, 60, -21};
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
}
