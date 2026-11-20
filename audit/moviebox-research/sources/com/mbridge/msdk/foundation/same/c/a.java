package com.mbridge.msdk.foundation.same.c;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.ab;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class a {
    public static Bitmap a(String str) {
        Bitmap bitmapDecodeFile = null;
        if (!ab.d(str)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        try {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            options.inJustDecodeBounds = false;
            options.inPurgeable = true;
            options.inInputShareable = true;
            options.inDither = true;
            return BitmapFactory.decodeFile(str, options);
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        } catch (OutOfMemoryError e12) {
            e12.printStackTrace();
            System.gc();
            b.a();
            try {
                options.inPreferredConfig = Bitmap.Config.ARGB_4444;
                bitmapDecodeFile = BitmapFactory.decodeFile(str, options);
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                return bitmapDecodeFile;
            } catch (OutOfMemoryError e13) {
                e13.printStackTrace();
                return bitmapDecodeFile;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0045 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0025: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:13:0x0025 */
    public static InputStream a(Bitmap bitmap) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        ByteArrayOutputStream byteArrayOutputStream3 = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception e11) {
                        if (MBridgeConstans.DEBUG) {
                            e11.printStackTrace();
                        }
                    }
                    return byteArrayInputStream;
                } catch (Exception e12) {
                    e = e12;
                    if (MBridgeConstans.DEBUG) {
                        e.printStackTrace();
                    }
                    if (byteArrayOutputStream == null) {
                        return null;
                    }
                    try {
                        byteArrayOutputStream.close();
                        return null;
                    } catch (Exception e13) {
                        if (!MBridgeConstans.DEBUG) {
                            return null;
                        }
                        e13.printStackTrace();
                        return null;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream3 = byteArrayOutputStream2;
                if (byteArrayOutputStream3 != null) {
                    try {
                        byteArrayOutputStream3.close();
                    } catch (Exception e14) {
                        if (MBridgeConstans.DEBUG) {
                            e14.printStackTrace();
                        }
                    }
                }
                throw th;
            }
        } catch (Exception e15) {
            e = e15;
            byteArrayOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            if (byteArrayOutputStream3 != null) {
                byteArrayOutputStream3.close();
            }
            throw th;
        }
    }
}
