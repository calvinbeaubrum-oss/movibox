package com.mbridge.msdk.thrid.okhttp.internal.publicsuffix;

import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okhttp.internal.platform.Platform;
import com.mbridge.msdk.thrid.okio.BufferedSource;
import com.mbridge.msdk.thrid.okio.GzipSource;
import com.mbridge.msdk.thrid.okio.Okio;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class PublicSuffixDatabase {
    private static final byte EXCEPTION_MARKER = 33;
    public static final String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.gz";
    private byte[] publicSuffixExceptionListBytes;
    private byte[] publicSuffixListBytes;
    private static final byte[] WILDCARD_LABEL = {42};
    private static final String[] EMPTY_RULE = new String[0];
    private static final String[] PREVAILING_RULE = {"*"};
    private static final PublicSuffixDatabase instance = new PublicSuffixDatabase();
    private final AtomicBoolean listRead = new AtomicBoolean(false);
    private final CountDownLatch readCompleteLatch = new CountDownLatch(1);

    private static String binarySearchBytes(byte[] bArr, byte[][] bArr2, int i11) {
        int i12;
        boolean z11;
        int i13;
        int i14;
        int length = bArr.length;
        int i15 = 0;
        while (i15 < length) {
            int i16 = (i15 + length) / 2;
            while (i16 > -1 && bArr[i16] != 10) {
                i16--;
            }
            int i17 = i16 + 1;
            int i18 = 1;
            while (true) {
                i12 = i17 + i18;
                if (bArr[i12] == 10) {
                    break;
                }
                i18++;
            }
            int i19 = i12 - i17;
            int i21 = i11;
            boolean z12 = false;
            int i22 = 0;
            int i23 = 0;
            while (true) {
                if (z12) {
                    i13 = 46;
                    z11 = false;
                } else {
                    z11 = z12;
                    i13 = bArr2[i21][i22] & 255;
                }
                i14 = i13 - (bArr[i17 + i23] & 255);
                if (i14 == 0) {
                    i23++;
                    i22++;
                    if (i23 == i19) {
                        break;
                    }
                    if (bArr2[i21].length != i22) {
                        z12 = z11;
                    } else {
                        if (i21 == bArr2.length - 1) {
                            break;
                        }
                        i21++;
                        z12 = true;
                        i22 = -1;
                    }
                } else {
                    break;
                }
            }
            if (i14 >= 0) {
                if (i14 <= 0) {
                    int i24 = i19 - i23;
                    int length2 = bArr2[i21].length - i22;
                    while (true) {
                        i21++;
                        if (i21 >= bArr2.length) {
                            break;
                        }
                        length2 += bArr2[i21].length;
                    }
                    if (length2 >= i24) {
                        if (length2 <= i24) {
                            return new String(bArr, i17, i19, Util.UTF_8);
                        }
                    }
                }
                i15 = i12 + 1;
            }
            length = i16;
        }
        return null;
    }

    private String[] findMatchingRule(String[] strArr) {
        String str;
        String strBinarySearchBytes;
        String strBinarySearchBytes2;
        if (this.listRead.get() || !this.listRead.compareAndSet(false, true)) {
            try {
                this.readCompleteLatch.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            readTheListUninterruptibly();
        }
        synchronized (this) {
            if (this.publicSuffixListBytes == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        int length = strArr.length;
        byte[][] bArr = new byte[length][];
        for (int i11 = 0; i11 < strArr.length; i11++) {
            bArr[i11] = strArr[i11].getBytes(Util.UTF_8);
        }
        int i12 = 0;
        while (true) {
            str = null;
            if (i12 >= length) {
                strBinarySearchBytes = null;
                break;
            }
            strBinarySearchBytes = binarySearchBytes(this.publicSuffixListBytes, bArr, i12);
            if (strBinarySearchBytes != null) {
                break;
            }
            i12++;
        }
        if (length <= 1) {
            strBinarySearchBytes2 = null;
            break;
        }
        byte[][] bArr2 = (byte[][]) bArr.clone();
        int i13 = 0;
        while (true) {
            if (i13 >= bArr2.length - 1) {
                strBinarySearchBytes2 = null;
                break;
            }
            bArr2[i13] = WILDCARD_LABEL;
            strBinarySearchBytes2 = binarySearchBytes(this.publicSuffixListBytes, bArr2, i13);
            if (strBinarySearchBytes2 != null) {
                break;
            }
            i13++;
        }
        if (strBinarySearchBytes2 != null) {
            for (int i14 = 0; i14 < length - 1; i14++) {
                String strBinarySearchBytes3 = binarySearchBytes(this.publicSuffixExceptionListBytes, bArr, i14);
                if (strBinarySearchBytes3 != null) {
                    str = strBinarySearchBytes3;
                    break;
                }
            }
        }
        if (str != null) {
            return ("!" + str).split("\\.");
        }
        if (strBinarySearchBytes == null && strBinarySearchBytes2 == null) {
            return PREVAILING_RULE;
        }
        String[] strArrSplit = strBinarySearchBytes != null ? strBinarySearchBytes.split("\\.") : EMPTY_RULE;
        String[] strArrSplit2 = strBinarySearchBytes2 != null ? strBinarySearchBytes2.split("\\.") : EMPTY_RULE;
        return strArrSplit.length > strArrSplit2.length ? strArrSplit : strArrSplit2;
    }

    public static PublicSuffixDatabase get() {
        return instance;
    }

    private void readTheList() throws IOException {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream == null) {
            return;
        }
        BufferedSource bufferedSourceBuffer = Okio.buffer(new GzipSource(Okio.source(resourceAsStream)));
        try {
            byte[] bArr = new byte[bufferedSourceBuffer.readInt()];
            bufferedSourceBuffer.readFully(bArr);
            byte[] bArr2 = new byte[bufferedSourceBuffer.readInt()];
            bufferedSourceBuffer.readFully(bArr2);
            Util.closeQuietly(bufferedSourceBuffer);
            synchronized (this) {
                this.publicSuffixListBytes = bArr;
                this.publicSuffixExceptionListBytes = bArr2;
            }
            this.readCompleteLatch.countDown();
        } catch (Throwable th2) {
            Util.closeQuietly(bufferedSourceBuffer);
            throw th2;
        }
    }

    private void readTheListUninterruptibly() {
        boolean z11 = false;
        while (true) {
            try {
                try {
                    readTheList();
                    break;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z11 = true;
                } catch (IOException e11) {
                    Platform.get().log(5, "Failed to read public suffix list", e11);
                    if (z11) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (Throwable th2) {
                if (z11) {
                    Thread.currentThread().interrupt();
                }
                throw th2;
            }
        }
        if (z11) {
            Thread.currentThread().interrupt();
        }
    }

    public String getEffectiveTldPlusOne(String str) {
        int length;
        int length2;
        if (str == null) {
            throw new NullPointerException("domain == null");
        }
        String[] strArrSplit = IDN.toUnicode(str).split("\\.");
        String[] strArrFindMatchingRule = findMatchingRule(strArrSplit);
        if (strArrSplit.length == strArrFindMatchingRule.length && strArrFindMatchingRule[0].charAt(0) != '!') {
            return null;
        }
        if (strArrFindMatchingRule[0].charAt(0) == '!') {
            length = strArrSplit.length;
            length2 = strArrFindMatchingRule.length;
        } else {
            length = strArrSplit.length;
            length2 = strArrFindMatchingRule.length + 1;
        }
        StringBuilder sb2 = new StringBuilder();
        String[] strArrSplit2 = str.split("\\.");
        for (int i11 = length - length2; i11 < strArrSplit2.length; i11++) {
            sb2.append(strArrSplit2[i11]);
            sb2.append('.');
        }
        sb2.deleteCharAt(sb2.length() - 1);
        return sb2.toString();
    }

    public void setListBytes(byte[] bArr, byte[] bArr2) {
        this.publicSuffixListBytes = bArr;
        this.publicSuffixExceptionListBytes = bArr2;
        this.listRead.set(true);
        this.readCompleteLatch.countDown();
    }
}
