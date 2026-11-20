package com.bytedance.sdk.component.pFF.sc.pFF;

import com.applovin.exoplayer2.common.base.Ascii;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class We implements Serializable, Comparable<We> {
    transient int ExN;
    transient String TRI;
    final byte[] We;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    static final char[] f26944sc = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final Charset pFF = Charset.forName("UTF-8");
    public static final We zY = sc(new byte[0]);

    public We(byte[] bArr) {
        this.We = bArr;
    }

    public static int sc(String str, int i11) {
        int length = str.length();
        int iCharCount = 0;
        int i12 = 0;
        while (iCharCount < length) {
            if (i12 == i11) {
                return iCharCount;
            }
            int iCodePointAt = str.codePointAt(iCharCount);
            if ((Character.isISOControl(iCodePointAt) && iCodePointAt != 10 && iCodePointAt != 13) || iCodePointAt == 65533) {
                return -1;
            }
            i12++;
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str.length();
    }

    public static We sc(byte... bArr) {
        if (bArr != null) {
            return new We((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public byte[] We() {
        return (byte[]) this.We.clone();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof We) {
            We we2 = (We) obj;
            int iZY = we2.zY();
            byte[] bArr = this.We;
            if (iZY == bArr.length && we2.sc(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i11 = this.ExN;
        if (i11 != 0) {
            return i11;
        }
        int iHashCode = Arrays.hashCode(this.We);
        this.ExN = iHashCode;
        return iHashCode;
    }

    public String pFF() {
        byte[] bArr = this.We;
        char[] cArr = new char[bArr.length * 2];
        int i11 = 0;
        for (byte b11 : bArr) {
            int i12 = i11 + 1;
            char[] cArr2 = f26944sc;
            cArr[i11] = cArr2[(b11 >> 4) & 15];
            i11 += 2;
            cArr[i12] = cArr2[b11 & Ascii.SI];
        }
        return new String(cArr);
    }

    public byte sc(int i11) {
        return this.We[i11];
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
    public int compareTo(We we2) {
        int iZY = zY();
        int iZY2 = we2.zY();
        int iMin = Math.min(iZY, iZY2);
        for (int i11 = 0; i11 < iMin; i11++) {
            int iSc = sc(i11) & 255;
            int iSc2 = we2.sc(i11) & 255;
            if (iSc != iSc2) {
                return iSc < iSc2 ? -1 : 1;
            }
        }
        if (iZY == iZY2) {
            return 0;
        }
        return iZY < iZY2 ? -1 : 1;
    }

    public We sc(int i11, int i12) {
        if (i11 < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        byte[] bArr = this.We;
        if (i12 > bArr.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.We.length + ")");
        }
        int i13 = i12 - i11;
        if (i13 < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        if (i11 == 0 && i12 == bArr.length) {
            return this;
        }
        byte[] bArr2 = new byte[i13];
        System.arraycopy(bArr, i11, bArr2, 0, i13);
        return new We(bArr2);
    }

    public String sc() {
        String str = this.TRI;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.We, pFF);
        this.TRI = str2;
        return str2;
    }

    public boolean sc(int i11, We we2, int i12, int i13) {
        return we2.sc(i12, this.We, i11, i13);
    }

    public boolean sc(int i11, byte[] bArr, int i12, int i13) {
        if (i11 < 0) {
            return false;
        }
        byte[] bArr2 = this.We;
        return i11 <= bArr2.length - i13 && i12 >= 0 && i12 <= bArr.length - i13 && Ol.sc(bArr2, i11, bArr, i12, i13);
    }

    public String toString() {
        if (this.We.length == 0) {
            return "[size=0]";
        }
        String strSc = sc();
        int iSc = sc(strSc, 64);
        if (iSc == -1) {
            if (this.We.length <= 64) {
                return "[hex=" + pFF() + "]";
            }
            return "[size=" + this.We.length + " hex=" + sc(0, 64).pFF() + "…]";
        }
        String strReplace = strSc.substring(0, iSc).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        if (iSc >= strSc.length()) {
            return "[text=" + strReplace + "]";
        }
        return "[size=" + this.We.length + " text=" + strReplace + "…]";
    }

    public int zY() {
        return this.We.length;
    }
}
