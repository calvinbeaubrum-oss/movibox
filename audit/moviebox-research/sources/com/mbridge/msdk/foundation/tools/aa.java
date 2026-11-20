package com.mbridge.msdk.foundation.tools;

import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class aa {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static MessageDigest f44956b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static char[] f44955a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f44957c = "SameFileMD5";

    static {
        f44956b = null;
        try {
            f44956b = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e11) {
            System.err.println(aa.class.getName() + "初始化失败，MessageDigest不支持MD5Util.");
            e11.printStackTrace();
        }
    }

    public static String a(File file) throws IOException {
        if (file == null || !file.exists()) {
            return "";
        }
        RandomAccessFile randomAccessFile = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, CampaignEx.JSON_KEY_AD_R);
            try {
                byte[] bArr = new byte[10485760];
                while (true) {
                    int i11 = randomAccessFile2.read(bArr);
                    if (i11 == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, i11);
                }
                byte[] bArrDigest = messageDigest.digest();
                String strA = a(bArrDigest, 0, bArrDigest.length);
                try {
                    randomAccessFile2.close();
                } catch (IOException e11) {
                    ad.b(f44957c, e11.getMessage());
                }
                return strA;
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = randomAccessFile2;
                try {
                    ad.b(f44957c, th.getMessage());
                    return "";
                } finally {
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e12) {
                            ad.b(f44957c, e12.getMessage());
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private static String a(byte[] bArr, int i11, int i12) {
        StringBuffer stringBuffer = new StringBuffer(i12 * 2);
        int i13 = i12 + i11;
        while (i11 < i13) {
            byte b11 = bArr[i11];
            char[] cArr = f44955a;
            char c11 = cArr[(b11 & 240) >> 4];
            char c12 = cArr[b11 & Ascii.SI];
            stringBuffer.append(c11);
            stringBuffer.append(c12);
            i11++;
        }
        return stringBuffer.toString();
    }
}
