package com.transsion.compressor.image;

import android.graphics.BitmapFactory;
import android.util.Log;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.File;
import java.io.InputStream;
import java.util.Arrays;
import vs.d;
import vs.j;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public enum Checker {
    SINGLE;

    private static final int IS_JPG_TAG = 3;
    private static final byte[] JPEG_SIGNATURE = {-1, -40, -1};
    private static final String JPG = ".jpg";

    /* JADX WARN: Code duplicated, block: B:40:0x0064  */
    /* JADX WARN: Code duplicated, block: B:47:0x007a  */
    /* JADX WARN: Code duplicated, block: B:48:0x007c  */
    /* JADX WARN: Code duplicated, block: B:77:0x00c8  */
    private int getOrientation(byte[] bArr) {
        int i11;
        int iPack;
        boolean z11;
        int iPack2;
        if (bArr == null) {
            return 0;
        }
        int i12 = 0;
        while (true) {
            if (i12 + 3 < bArr.length) {
                int i13 = i12 + 1;
                if ((bArr[i12] & 255) == 255) {
                    int i14 = bArr[i13] & 255;
                    if (i14 != 255) {
                        i13 = i12 + 2;
                        if (i14 != 216 && i14 != 1) {
                            if (i14 != 217 && i14 != 218) {
                                int iPack3 = pack(bArr, i13, 2, false);
                                if (iPack3 < 2 || (i13 = i13 + iPack3) > bArr.length) {
                                    j.f("Invalid length");
                                    return 0;
                                }
                                if (i14 == 225 && iPack3 >= 8 && pack(bArr, i12 + 4, 4, false) == 1165519206 && pack(bArr, i12 + 8, 2, false) == 0) {
                                    i12 += 10;
                                    i11 = iPack3 - 8;
                                }
                            }
                            if (i11 > 8) {
                                iPack = pack(bArr, i12, 4, false);
                                if (iPack == 1229531648 && iPack != 1296891946) {
                                    j.f("Invalid byte order");
                                    return 0;
                                }
                                if (iPack == 1229531648) {
                                    z11 = true;
                                } else {
                                    z11 = false;
                                }
                                iPack2 = pack(bArr, i12 + 4, 4, z11) + 2;
                                if (iPack2 >= 10 || iPack2 > i11) {
                                    j.f("Invalid offset");
                                } else {
                                    int i15 = i12 + iPack2;
                                    int i16 = i11 - iPack2;
                                    int iPack4 = pack(bArr, i15 - 2, 2, z11);
                                    while (true) {
                                        int i17 = iPack4 - 1;
                                        if (iPack4 <= 0 || i16 < 12) {
                                            break;
                                        }
                                        if (pack(bArr, i15, 2, z11) == 274) {
                                            int iPack5 = pack(bArr, i15 + 8, 2, z11);
                                            if (iPack5 == 1) {
                                                return 0;
                                            }
                                            if (iPack5 == 3) {
                                                return 180;
                                            }
                                            if (iPack5 == 6) {
                                                return 90;
                                            }
                                            if (iPack5 == 8) {
                                                return 270;
                                            }
                                            j.f("Unsupported orientation");
                                            return 0;
                                        }
                                        i15 += 12;
                                        i16 -= 12;
                                        iPack4 = i17;
                                    }
                                }
                            }
                            return 0;
                        }
                    }
                    i12 = i13;
                }
                i12 = i13;
            }
            i11 = 0;
            if (i11 > 8) {
                iPack = pack(bArr, i12, 4, false);
                if (iPack == 1229531648) {
                }
                if (iPack == 1229531648) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                iPack2 = pack(bArr, i12 + 4, 4, z11) + 2;
                if (iPack2 >= 10) {
                    j.f("Invalid offset");
                } else {
                    j.f("Invalid offset");
                }
            }
            return 0;
        }
    }

    private boolean isJpg(byte[] bArr) {
        if (bArr == null || bArr.length < 3) {
            return false;
        }
        return Arrays.equals(JPEG_SIGNATURE, new byte[]{bArr[0], bArr[1], bArr[2]});
    }

    private int pack(byte[] bArr, int i11, int i12, boolean z11) {
        int i13;
        if (z11) {
            i11 += i12 - 1;
            i13 = -1;
        } else {
            i13 = 1;
        }
        int i14 = 0;
        while (true) {
            int i15 = i12 - 1;
            if (i12 <= 0) {
                return i14;
            }
            i14 = (bArr[i11] & 255) | (i14 << 8);
            i11 += i13;
            i12 = i15;
        }
    }

    public String extSuffix(d dVar) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(dVar.open(), null, options);
            return options.outMimeType.replace("image/", InstructionFileId.DOT);
        } catch (Exception unused) {
            return JPG;
        }
    }

    public int getOrientation(InputStream inputStream) {
        return getOrientation(j.g(inputStream));
    }

    public boolean isJpg(InputStream inputStream) {
        return isJpg(j.g(inputStream));
    }

    public boolean needCompress(int i11, String str) {
        if (i11 > 0) {
            try {
                File file = new File(str);
                return file.exists() && file.length() > (((long) i11) << 10);
            } catch (Exception e11) {
                j.f(Log.getStackTraceString(e11));
            }
        }
        return true;
    }
}
