package com.mbridge.msdk.thrid.okio;

import androidx.annotation.Nullable;
import com.applovin.exoplayer2.common.base.Ascii;
import com.transsion.api.gateway.utils.EncoderUtil;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class ByteString implements Serializable, Comparable<ByteString> {
    private static final long serialVersionUID = 1;
    final byte[] data;
    transient int hashCode;
    transient String utf8;
    static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final ByteString EMPTY = of(new byte[0]);

    public ByteString(byte[] bArr) {
        this.data = bArr;
    }

    public static int codePointIndexToCharIndex(String str, int i11) {
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

    @Nullable
    public static ByteString decodeBase64(String str) {
        if (str == null) {
            throw new IllegalArgumentException("base64 == null");
        }
        byte[] bArrDecode = Base64.decode(str);
        if (bArrDecode != null) {
            return new ByteString(bArrDecode);
        }
        return null;
    }

    public static ByteString decodeHex(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        }
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: " + str);
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i11 = 0; i11 < length; i11++) {
            int i12 = i11 * 2;
            bArr[i11] = (byte) ((decodeHexDigit(str.charAt(i12)) << 4) + decodeHexDigit(str.charAt(i12 + 1)));
        }
        return of(bArr);
    }

    private static int decodeHexDigit(char c11) {
        if (c11 >= '0' && c11 <= '9') {
            return c11 - '0';
        }
        if (c11 >= 'a' && c11 <= 'f') {
            return c11 - 'W';
        }
        if (c11 >= 'A' && c11 <= 'F') {
            return c11 - '7';
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c11);
    }

    private ByteString digest(String str) {
        try {
            return of(MessageDigest.getInstance(str).digest(this.data));
        } catch (NoSuchAlgorithmException e11) {
            throw new AssertionError(e11);
        }
    }

    public static ByteString encodeString(String str, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        if (charset != null) {
            return new ByteString(str.getBytes(charset));
        }
        throw new IllegalArgumentException("charset == null");
    }

    public static ByteString encodeUtf8(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        ByteString byteString = new ByteString(str.getBytes(Util.UTF_8));
        byteString.utf8 = str;
        return byteString;
    }

    private ByteString hmac(String str, ByteString byteString) {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.toByteArray(), str));
            return of(mac.doFinal(this.data));
        } catch (InvalidKeyException e11) {
            throw new IllegalArgumentException(e11);
        } catch (NoSuchAlgorithmException e12) {
            throw new AssertionError(e12);
        }
    }

    public static ByteString of(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("data == null");
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        return new ByteString(bArr);
    }

    public static ByteString of(byte... bArr) {
        if (bArr != null) {
            return new ByteString((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public static ByteString of(byte[] bArr, int i11, int i12) {
        if (bArr == null) {
            throw new IllegalArgumentException("data == null");
        }
        Util.checkOffsetAndCount(bArr.length, i11, i12);
        byte[] bArr2 = new byte[i12];
        System.arraycopy(bArr, i11, bArr2, 0, i12);
        return new ByteString(bArr2);
    }

    public static ByteString read(InputStream inputStream, int i11) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (i11 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + i11);
        }
        byte[] bArr = new byte[i11];
        int i12 = 0;
        while (i12 < i11) {
            int i13 = inputStream.read(bArr, i12, i11 - i12);
            if (i13 == -1) {
                throw new EOFException();
            }
            i12 += i13;
        }
        return new ByteString(bArr);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        ByteString byteString = read(objectInputStream, objectInputStream.readInt());
        try {
            Field declaredField = ByteString.class.getDeclaredField("data");
            declaredField.setAccessible(true);
            declaredField.set(this, byteString.data);
        } catch (IllegalAccessException unused) {
            throw new AssertionError();
        } catch (NoSuchFieldException unused2) {
            throw new AssertionError();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.write(this.data);
    }

    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(this.data).asReadOnlyBuffer();
    }

    public String base64() {
        return Base64.encode(this.data);
    }

    public String base64Url() {
        return Base64.encodeUrl(this.data);
    }

    @Override // java.lang.Comparable
    public int compareTo(ByteString byteString) {
        int size = size();
        int size2 = byteString.size();
        int iMin = Math.min(size, size2);
        for (int i11 = 0; i11 < iMin; i11++) {
            int i12 = getByte(i11) & 255;
            int i13 = byteString.getByte(i11) & 255;
            if (i12 != i13) {
                return i12 < i13 ? -1 : 1;
            }
        }
        if (size == size2) {
            return 0;
        }
        return size < size2 ? -1 : 1;
    }

    public final boolean endsWith(ByteString byteString) {
        return rangeEquals(size() - byteString.size(), byteString, 0, byteString.size());
    }

    public final boolean endsWith(byte[] bArr) {
        return rangeEquals(size() - bArr.length, bArr, 0, bArr.length);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            int size = byteString.size();
            byte[] bArr = this.data;
            if (size == bArr.length && byteString.rangeEquals(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public byte getByte(int i11) {
        return this.data[i11];
    }

    public int hashCode() {
        int i11 = this.hashCode;
        if (i11 != 0) {
            return i11;
        }
        int iHashCode = Arrays.hashCode(this.data);
        this.hashCode = iHashCode;
        return iHashCode;
    }

    public String hex() {
        byte[] bArr = this.data;
        char[] cArr = new char[bArr.length * 2];
        int i11 = 0;
        for (byte b11 : bArr) {
            int i12 = i11 + 1;
            char[] cArr2 = HEX_DIGITS;
            cArr[i11] = cArr2[(b11 >> 4) & 15];
            i11 += 2;
            cArr[i12] = cArr2[b11 & Ascii.SI];
        }
        return new String(cArr);
    }

    public ByteString hmacSha1(ByteString byteString) {
        return hmac("HmacSHA1", byteString);
    }

    public ByteString hmacSha256(ByteString byteString) {
        return hmac("HmacSHA256", byteString);
    }

    public ByteString hmacSha512(ByteString byteString) {
        return hmac("HmacSHA512", byteString);
    }

    public final int indexOf(ByteString byteString) {
        return indexOf(byteString.internalArray(), 0);
    }

    public final int indexOf(ByteString byteString, int i11) {
        return indexOf(byteString.internalArray(), i11);
    }

    public final int indexOf(byte[] bArr) {
        return indexOf(bArr, 0);
    }

    public int indexOf(byte[] bArr, int i11) {
        int length = this.data.length - bArr.length;
        for (int iMax = Math.max(i11, 0); iMax <= length; iMax++) {
            if (Util.arrayRangeEquals(this.data, iMax, bArr, 0, bArr.length)) {
                return iMax;
            }
        }
        return -1;
    }

    public byte[] internalArray() {
        return this.data;
    }

    public final int lastIndexOf(ByteString byteString) {
        return lastIndexOf(byteString.internalArray(), size());
    }

    public final int lastIndexOf(ByteString byteString, int i11) {
        return lastIndexOf(byteString.internalArray(), i11);
    }

    public final int lastIndexOf(byte[] bArr) {
        return lastIndexOf(bArr, size());
    }

    public int lastIndexOf(byte[] bArr, int i11) {
        for (int iMin = Math.min(i11, this.data.length - bArr.length); iMin >= 0; iMin--) {
            if (Util.arrayRangeEquals(this.data, iMin, bArr, 0, bArr.length)) {
                return iMin;
            }
        }
        return -1;
    }

    public ByteString md5() {
        return digest("MD5");
    }

    public boolean rangeEquals(int i11, ByteString byteString, int i12, int i13) {
        return byteString.rangeEquals(i12, this.data, i11, i13);
    }

    public boolean rangeEquals(int i11, byte[] bArr, int i12, int i13) {
        if (i11 >= 0) {
            byte[] bArr2 = this.data;
            if (i11 <= bArr2.length - i13 && i12 >= 0 && i12 <= bArr.length - i13 && Util.arrayRangeEquals(bArr2, i11, bArr, i12, i13)) {
                return true;
            }
        }
        return false;
    }

    public ByteString sha1() {
        return digest(EncoderUtil.ALGORITHM_SHA_1);
    }

    public ByteString sha256() {
        return digest(EncoderUtil.ALGORITHM_SHA_256);
    }

    public ByteString sha512() {
        return digest(EncoderUtil.ALGORITHM_SHA_512);
    }

    public int size() {
        return this.data.length;
    }

    public final boolean startsWith(ByteString byteString) {
        return rangeEquals(0, byteString, 0, byteString.size());
    }

    public final boolean startsWith(byte[] bArr) {
        return rangeEquals(0, bArr, 0, bArr.length);
    }

    public String string(Charset charset) {
        if (charset != null) {
            return new String(this.data, charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    public ByteString substring(int i11) {
        return substring(i11, this.data.length);
    }

    public ByteString substring(int i11, int i12) {
        if (i11 < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        byte[] bArr = this.data;
        if (i12 > bArr.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.data.length + ")");
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
        return new ByteString(bArr2);
    }

    public ByteString toAsciiLowercase() {
        int i11 = 0;
        while (true) {
            byte[] bArr = this.data;
            if (i11 >= bArr.length) {
                return this;
            }
            byte b11 = bArr[i11];
            if (b11 >= 65 && b11 <= 90) {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i11] = (byte) (b11 + 32);
                for (int i12 = i11 + 1; i12 < bArr2.length; i12++) {
                    byte b12 = bArr2[i12];
                    if (b12 >= 65 && b12 <= 90) {
                        bArr2[i12] = (byte) (b12 + 32);
                    }
                }
                return new ByteString(bArr2);
            }
            i11++;
        }
    }

    public ByteString toAsciiUppercase() {
        int i11 = 0;
        while (true) {
            byte[] bArr = this.data;
            if (i11 >= bArr.length) {
                return this;
            }
            byte b11 = bArr[i11];
            if (b11 >= 97 && b11 <= 122) {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i11] = (byte) (b11 - 32);
                for (int i12 = i11 + 1; i12 < bArr2.length; i12++) {
                    byte b12 = bArr2[i12];
                    if (b12 >= 97 && b12 <= 122) {
                        bArr2[i12] = (byte) (b12 - 32);
                    }
                }
                return new ByteString(bArr2);
            }
            i11++;
        }
    }

    public byte[] toByteArray() {
        return (byte[]) this.data.clone();
    }

    public String toString() {
        StringBuilder sb2;
        if (this.data.length == 0) {
            return "[size=0]";
        }
        String strUtf8 = utf8();
        int iCodePointIndexToCharIndex = codePointIndexToCharIndex(strUtf8, 64);
        if (iCodePointIndexToCharIndex == -1) {
            if (this.data.length <= 64) {
                return "[hex=" + hex() + "]";
            }
            return "[size=" + this.data.length + " hex=" + substring(0, 64).hex() + "…]";
        }
        String strReplace = strUtf8.substring(0, iCodePointIndexToCharIndex).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        if (iCodePointIndexToCharIndex < strUtf8.length()) {
            sb2 = new StringBuilder();
            sb2.append("[size=");
            sb2.append(this.data.length);
            sb2.append(" text=");
            sb2.append(strReplace);
            sb2.append("…]");
        } else {
            sb2 = new StringBuilder();
            sb2.append("[text=");
            sb2.append(strReplace);
            sb2.append("]");
        }
        return sb2.toString();
    }

    public String utf8() {
        String str = this.utf8;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.data, Util.UTF_8);
        this.utf8 = str2;
        return str2;
    }

    public void write(Buffer buffer) {
        byte[] bArr = this.data;
        buffer.write(bArr, 0, bArr.length);
    }

    public void write(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        outputStream.write(this.data);
    }
}
