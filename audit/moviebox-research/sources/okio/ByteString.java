package okio;

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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.l;
import okio.internal.ByteStringKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public class ByteString implements Serializable, Comparable<ByteString> {
    public static final Companion Companion = new Companion(null);

    @JvmField
    public static final ByteString EMPTY = new ByteString(new byte[0]);
    private static final long serialVersionUID = 1;
    private final byte[] data;
    private transient int hashCode;
    private transient String utf8;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ByteString encodeString$default(Companion companion, String str, Charset charset, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                charset = Charsets.f69091b;
            }
            return companion.encodeString(str, charset);
        }

        public static /* synthetic */ ByteString of$default(Companion companion, byte[] bArr, int i11, int i12, int i13, Object obj) {
            if ((i13 & 1) != 0) {
                i11 = 0;
            }
            if ((i13 & 2) != 0) {
                i12 = bArr.length;
            }
            return companion.of(bArr, i11, i12);
        }

        @Deprecated
        @JvmName
        /* JADX INFO: renamed from: -deprecated_decodeBase64, reason: not valid java name */
        public final ByteString m317deprecated_decodeBase64(String string) {
            Intrinsics.g(string, "string");
            return decodeBase64(string);
        }

        @Deprecated
        @JvmName
        /* JADX INFO: renamed from: -deprecated_decodeHex, reason: not valid java name */
        public final ByteString m318deprecated_decodeHex(String string) {
            Intrinsics.g(string, "string");
            return decodeHex(string);
        }

        @Deprecated
        @JvmName
        /* JADX INFO: renamed from: -deprecated_encodeString, reason: not valid java name */
        public final ByteString m319deprecated_encodeString(String string, Charset charset) {
            Intrinsics.g(string, "string");
            Intrinsics.g(charset, "charset");
            return encodeString(string, charset);
        }

        @Deprecated
        @JvmName
        /* JADX INFO: renamed from: -deprecated_encodeUtf8, reason: not valid java name */
        public final ByteString m320deprecated_encodeUtf8(String string) {
            Intrinsics.g(string, "string");
            return encodeUtf8(string);
        }

        @Deprecated
        @JvmName
        /* JADX INFO: renamed from: -deprecated_of, reason: not valid java name */
        public final ByteString m321deprecated_of(ByteBuffer buffer) {
            Intrinsics.g(buffer, "buffer");
            return of(buffer);
        }

        @Deprecated
        @JvmName
        /* JADX INFO: renamed from: -deprecated_of, reason: not valid java name */
        public final ByteString m322deprecated_of(byte[] array, int i11, int i12) {
            Intrinsics.g(array, "array");
            return of(array, i11, i12);
        }

        @Deprecated
        @JvmName
        /* JADX INFO: renamed from: -deprecated_read, reason: not valid java name */
        public final ByteString m323deprecated_read(InputStream inputstream, int i11) {
            Intrinsics.g(inputstream, "inputstream");
            return read(inputstream, i11);
        }

        @JvmStatic
        public final ByteString decodeBase64(String decodeBase64) {
            Intrinsics.g(decodeBase64, "$this$decodeBase64");
            byte[] bArrDecodeBase64ToArray = Base64.decodeBase64ToArray(decodeBase64);
            if (bArrDecodeBase64ToArray != null) {
                return new ByteString(bArrDecodeBase64ToArray);
            }
            return null;
        }

        @JvmStatic
        public final ByteString decodeHex(String decodeHex) {
            Intrinsics.g(decodeHex, "$this$decodeHex");
            if (!(decodeHex.length() % 2 == 0)) {
                throw new IllegalArgumentException(("Unexpected hex string: " + decodeHex).toString());
            }
            int length = decodeHex.length() / 2;
            byte[] bArr = new byte[length];
            for (int i11 = 0; i11 < length; i11++) {
                int i12 = i11 * 2;
                bArr[i11] = (byte) ((ByteStringKt.decodeHexDigit(decodeHex.charAt(i12)) << 4) + ByteStringKt.decodeHexDigit(decodeHex.charAt(i12 + 1)));
            }
            return new ByteString(bArr);
        }

        @JvmStatic
        @JvmName
        public final ByteString encodeString(String encode, Charset charset) {
            Intrinsics.g(encode, "$this$encode");
            Intrinsics.g(charset, "charset");
            byte[] bytes = encode.getBytes(charset);
            Intrinsics.f(bytes, "(this as java.lang.String).getBytes(charset)");
            return new ByteString(bytes);
        }

        @JvmStatic
        public final ByteString encodeUtf8(String encodeUtf8) {
            Intrinsics.g(encodeUtf8, "$this$encodeUtf8");
            ByteString byteString = new ByteString(Platform.asUtf8ToByteArray(encodeUtf8));
            byteString.setUtf8$okio(encodeUtf8);
            return byteString;
        }

        @JvmStatic
        @JvmName
        public final ByteString of(ByteBuffer toByteString) {
            Intrinsics.g(toByteString, "$this$toByteString");
            byte[] bArr = new byte[toByteString.remaining()];
            toByteString.get(bArr);
            return new ByteString(bArr);
        }

        @JvmStatic
        public final ByteString of(byte... data) {
            Intrinsics.g(data, "data");
            byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
            Intrinsics.f(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
            return new ByteString(bArrCopyOf);
        }

        @JvmStatic
        @JvmName
        public final ByteString of(byte[] toByteString, int i11, int i12) {
            Intrinsics.g(toByteString, "$this$toByteString");
            Util.checkOffsetAndCount(toByteString.length, i11, i12);
            return new ByteString(ArraysKt___ArraysJvmKt.q(toByteString, i11, i12 + i11));
        }

        @JvmStatic
        @JvmName
        public final ByteString read(InputStream readByteString, int i11) throws IOException {
            Intrinsics.g(readByteString, "$this$readByteString");
            int i12 = 0;
            if (!(i11 >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + i11).toString());
            }
            byte[] bArr = new byte[i11];
            while (i12 < i11) {
                int i13 = readByteString.read(bArr, i12, i11 - i12);
                if (i13 == -1) {
                    throw new EOFException();
                }
                i12 += i13;
            }
            return new ByteString(bArr);
        }
    }

    public ByteString(byte[] data) {
        Intrinsics.g(data, "data");
        this.data = data;
    }

    @JvmStatic
    public static final ByteString decodeBase64(String str) {
        return Companion.decodeBase64(str);
    }

    @JvmStatic
    public static final ByteString decodeHex(String str) {
        return Companion.decodeHex(str);
    }

    @JvmStatic
    @JvmName
    public static final ByteString encodeString(String str, Charset charset) {
        return Companion.encodeString(str, charset);
    }

    @JvmStatic
    public static final ByteString encodeUtf8(String str) {
        return Companion.encodeUtf8(str);
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, ByteString byteString2, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        return byteString.indexOf(byteString2, i11);
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, byte[] bArr, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        return byteString.indexOf(bArr, i11);
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, ByteString byteString2, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i12 & 2) != 0) {
            i11 = byteString.size();
        }
        return byteString.lastIndexOf(byteString2, i11);
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, byte[] bArr, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i12 & 2) != 0) {
            i11 = byteString.size();
        }
        return byteString.lastIndexOf(bArr, i11);
    }

    @JvmStatic
    @JvmName
    public static final ByteString of(ByteBuffer byteBuffer) {
        return Companion.of(byteBuffer);
    }

    @JvmStatic
    public static final ByteString of(byte... bArr) {
        return Companion.of(bArr);
    }

    @JvmStatic
    @JvmName
    public static final ByteString of(byte[] bArr, int i11, int i12) {
        return Companion.of(bArr, i11, i12);
    }

    @JvmStatic
    @JvmName
    public static final ByteString read(InputStream inputStream, int i11) throws IOException {
        return Companion.read(inputStream, i11);
    }

    private final void readObject(ObjectInputStream objectInputStream) throws IllegalAccessException, NoSuchFieldException, IOException {
        ByteString byteString = Companion.read(objectInputStream, objectInputStream.readInt());
        Field field = ByteString.class.getDeclaredField("data");
        Intrinsics.f(field, "field");
        field.setAccessible(true);
        field.set(this, byteString.data);
    }

    public static /* synthetic */ ByteString substring$default(ByteString byteString, int i11, int i12, int i13, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
        }
        if ((i13 & 1) != 0) {
            i11 = 0;
        }
        if ((i13 & 2) != 0) {
            i12 = byteString.size();
        }
        return byteString.substring(i11, i12);
    }

    private final void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.write(this.data);
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_getByte, reason: not valid java name */
    public final byte m315deprecated_getByte(int i11) {
        return getByte(i11);
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_size, reason: not valid java name */
    public final int m316deprecated_size() {
        return size();
    }

    public ByteBuffer asByteBuffer() {
        ByteBuffer byteBufferAsReadOnlyBuffer = ByteBuffer.wrap(this.data).asReadOnlyBuffer();
        Intrinsics.f(byteBufferAsReadOnlyBuffer, "ByteBuffer.wrap(data).asReadOnlyBuffer()");
        return byteBufferAsReadOnlyBuffer;
    }

    public String base64() {
        return Base64.encodeBase64$default(getData$okio(), null, 1, null);
    }

    public String base64Url() {
        return Base64.encodeBase64(getData$okio(), Base64.getBASE64_URL_SAFE());
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002c A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:9:0x002a A[ORIG_RETURN, RETURN] */
    @Override // java.lang.Comparable
    public int compareTo(ByteString other) {
        Intrinsics.g(other, "other");
        int size = size();
        int size2 = other.size();
        int iMin = Math.min(size, size2);
        for (int i11 = 0; i11 < iMin; i11++) {
            int i12 = getByte(i11) & 255;
            int i13 = other.getByte(i11) & 255;
            if (i12 != i13) {
                if (i12 < i13) {
                    return -1;
                }
                return 1;
            }
        }
        if (size == size2) {
            return 0;
        }
        if (size < size2) {
            return -1;
        }
        return 1;
    }

    public ByteString digest$okio(String algorithm) throws NoSuchAlgorithmException {
        Intrinsics.g(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        messageDigest.update(this.data, 0, size());
        byte[] digestBytes = messageDigest.digest();
        Intrinsics.f(digestBytes, "digestBytes");
        return new ByteString(digestBytes);
    }

    public final boolean endsWith(ByteString suffix) {
        Intrinsics.g(suffix, "suffix");
        return rangeEquals(size() - suffix.size(), suffix, 0, suffix.size());
    }

    public final boolean endsWith(byte[] suffix) {
        Intrinsics.g(suffix, "suffix");
        return rangeEquals(size() - suffix.length, suffix, 0, suffix.length);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == getData$okio().length && byteString.rangeEquals(0, getData$okio(), 0, getData$okio().length)) {
                return true;
            }
        }
        return false;
    }

    @JvmName
    public final byte getByte(int i11) {
        return internalGet$okio(i11);
    }

    public final byte[] getData$okio() {
        return this.data;
    }

    public final int getHashCode$okio() {
        return this.hashCode;
    }

    public int getSize$okio() {
        return getData$okio().length;
    }

    public final String getUtf8$okio() {
        return this.utf8;
    }

    public int hashCode() {
        int hashCode$okio = getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int iHashCode = Arrays.hashCode(getData$okio());
        setHashCode$okio(iHashCode);
        return iHashCode;
    }

    public String hex() {
        char[] cArr = new char[getData$okio().length * 2];
        int i11 = 0;
        for (byte b11 : getData$okio()) {
            int i12 = i11 + 1;
            cArr[i11] = ByteStringKt.getHEX_DIGIT_CHARS()[(b11 >> 4) & 15];
            i11 += 2;
            cArr[i12] = ByteStringKt.getHEX_DIGIT_CHARS()[b11 & Ascii.SI];
        }
        return new String(cArr);
    }

    public ByteString hmac$okio(String algorithm, ByteString key) throws NoSuchAlgorithmException {
        Intrinsics.g(algorithm, "algorithm");
        Intrinsics.g(key, "key");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.toByteArray(), algorithm));
            byte[] bArrDoFinal = mac.doFinal(this.data);
            Intrinsics.f(bArrDoFinal, "mac.doFinal(data)");
            return new ByteString(bArrDoFinal);
        } catch (InvalidKeyException e11) {
            throw new IllegalArgumentException(e11);
        }
    }

    public ByteString hmacSha1(ByteString key) {
        Intrinsics.g(key, "key");
        return hmac$okio("HmacSHA1", key);
    }

    public ByteString hmacSha256(ByteString key) {
        Intrinsics.g(key, "key");
        return hmac$okio("HmacSHA256", key);
    }

    public ByteString hmacSha512(ByteString key) {
        Intrinsics.g(key, "key");
        return hmac$okio("HmacSHA512", key);
    }

    @JvmOverloads
    public final int indexOf(ByteString byteString) {
        return indexOf$default(this, byteString, 0, 2, (Object) null);
    }

    @JvmOverloads
    public final int indexOf(ByteString other, int i11) {
        Intrinsics.g(other, "other");
        return indexOf(other.internalArray$okio(), i11);
    }

    @JvmOverloads
    public final int indexOf(byte[] bArr) {
        return indexOf$default(this, bArr, 0, 2, (Object) null);
    }

    @JvmOverloads
    public int indexOf(byte[] other, int i11) {
        Intrinsics.g(other, "other");
        int length = getData$okio().length - other.length;
        int iMax = Math.max(i11, 0);
        if (iMax <= length) {
            while (!Util.arrayRangeEquals(getData$okio(), iMax, other, 0, other.length)) {
                if (iMax != length) {
                    iMax++;
                }
            }
            return iMax;
        }
        return -1;
    }

    public byte[] internalArray$okio() {
        return getData$okio();
    }

    public byte internalGet$okio(int i11) {
        return getData$okio()[i11];
    }

    @JvmOverloads
    public final int lastIndexOf(ByteString byteString) {
        return lastIndexOf$default(this, byteString, 0, 2, (Object) null);
    }

    @JvmOverloads
    public final int lastIndexOf(ByteString other, int i11) {
        Intrinsics.g(other, "other");
        return lastIndexOf(other.internalArray$okio(), i11);
    }

    @JvmOverloads
    public final int lastIndexOf(byte[] bArr) {
        return lastIndexOf$default(this, bArr, 0, 2, (Object) null);
    }

    @JvmOverloads
    public int lastIndexOf(byte[] other, int i11) {
        Intrinsics.g(other, "other");
        for (int iMin = Math.min(i11, getData$okio().length - other.length); iMin >= 0; iMin--) {
            if (Util.arrayRangeEquals(getData$okio(), iMin, other, 0, other.length)) {
                return iMin;
            }
        }
        return -1;
    }

    public final ByteString md5() {
        return digest$okio("MD5");
    }

    public boolean rangeEquals(int i11, ByteString other, int i12, int i13) {
        Intrinsics.g(other, "other");
        return other.rangeEquals(i12, getData$okio(), i11, i13);
    }

    public boolean rangeEquals(int i11, byte[] other, int i12, int i13) {
        Intrinsics.g(other, "other");
        return i11 >= 0 && i11 <= getData$okio().length - i13 && i12 >= 0 && i12 <= other.length - i13 && Util.arrayRangeEquals(getData$okio(), i11, other, i12, i13);
    }

    public final void setHashCode$okio(int i11) {
        this.hashCode = i11;
    }

    public final void setUtf8$okio(String str) {
        this.utf8 = str;
    }

    public final ByteString sha1() {
        return digest$okio(EncoderUtil.ALGORITHM_SHA_1);
    }

    public final ByteString sha256() {
        return digest$okio(EncoderUtil.ALGORITHM_SHA_256);
    }

    public final ByteString sha512() {
        return digest$okio(EncoderUtil.ALGORITHM_SHA_512);
    }

    @JvmName
    public final int size() {
        return getSize$okio();
    }

    public final boolean startsWith(ByteString prefix) {
        Intrinsics.g(prefix, "prefix");
        return rangeEquals(0, prefix, 0, prefix.size());
    }

    public final boolean startsWith(byte[] prefix) {
        Intrinsics.g(prefix, "prefix");
        return rangeEquals(0, prefix, 0, prefix.length);
    }

    public String string(Charset charset) {
        Intrinsics.g(charset, "charset");
        return new String(this.data, charset);
    }

    @JvmOverloads
    public final ByteString substring() {
        return substring$default(this, 0, 0, 3, null);
    }

    @JvmOverloads
    public final ByteString substring(int i11) {
        return substring$default(this, i11, 0, 2, null);
    }

    @JvmOverloads
    public ByteString substring(int i11, int i12) {
        if (!(i11 >= 0)) {
            throw new IllegalArgumentException("beginIndex < 0".toString());
        }
        if (i12 <= getData$okio().length) {
            if (i12 - i11 >= 0) {
                return (i11 == 0 && i12 == getData$okio().length) ? this : new ByteString(ArraysKt___ArraysJvmKt.q(getData$okio(), i11, i12));
            }
            throw new IllegalArgumentException("endIndex < beginIndex".toString());
        }
        throw new IllegalArgumentException(("endIndex > length(" + getData$okio().length + ')').toString());
    }

    public ByteString toAsciiLowercase() {
        byte b11;
        for (int i11 = 0; i11 < getData$okio().length; i11++) {
            byte b12 = getData$okio()[i11];
            byte b13 = (byte) 65;
            if (b12 >= b13 && b12 <= (b11 = (byte) 90)) {
                byte[] data$okio = getData$okio();
                byte[] bArrCopyOf = Arrays.copyOf(data$okio, data$okio.length);
                Intrinsics.f(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
                bArrCopyOf[i11] = (byte) (b12 + 32);
                for (int i12 = i11 + 1; i12 < bArrCopyOf.length; i12++) {
                    byte b14 = bArrCopyOf[i12];
                    if (b14 >= b13 && b14 <= b11) {
                        bArrCopyOf[i12] = (byte) (b14 + 32);
                    }
                }
                return new ByteString(bArrCopyOf);
            }
        }
        return this;
    }

    public ByteString toAsciiUppercase() {
        byte b11;
        for (int i11 = 0; i11 < getData$okio().length; i11++) {
            byte b12 = getData$okio()[i11];
            byte b13 = (byte) 97;
            if (b12 >= b13 && b12 <= (b11 = (byte) 122)) {
                byte[] data$okio = getData$okio();
                byte[] bArrCopyOf = Arrays.copyOf(data$okio, data$okio.length);
                Intrinsics.f(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
                bArrCopyOf[i11] = (byte) (b12 - 32);
                for (int i12 = i11 + 1; i12 < bArrCopyOf.length; i12++) {
                    byte b14 = bArrCopyOf[i12];
                    if (b14 >= b13 && b14 <= b11) {
                        bArrCopyOf[i12] = (byte) (b14 - 32);
                    }
                }
                return new ByteString(bArrCopyOf);
            }
        }
        return this;
    }

    public byte[] toByteArray() {
        byte[] data$okio = getData$okio();
        byte[] bArrCopyOf = Arrays.copyOf(data$okio, data$okio.length);
        Intrinsics.f(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        return bArrCopyOf;
    }

    public String toString() {
        if (getData$okio().length == 0) {
            return "[size=0]";
        }
        int iCodePointIndexToCharIndex = ByteStringKt.codePointIndexToCharIndex(getData$okio(), 64);
        if (iCodePointIndexToCharIndex == -1) {
            if (getData$okio().length <= 64) {
                return "[hex=" + hex() + ']';
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[size=");
            sb2.append(getData$okio().length);
            sb2.append(" hex=");
            if (64 <= getData$okio().length) {
                sb2.append((64 == getData$okio().length ? this : new ByteString(ArraysKt___ArraysJvmKt.q(getData$okio(), 0, 64))).hex());
                sb2.append("…]");
                return sb2.toString();
            }
            throw new IllegalArgumentException(("endIndex > length(" + getData$okio().length + ')').toString());
        }
        String strUtf8 = utf8();
        if (strUtf8 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = strUtf8.substring(0, iCodePointIndexToCharIndex);
        Intrinsics.f(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String strF = l.F(l.F(l.F(strSubstring, "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
        if (iCodePointIndexToCharIndex >= strUtf8.length()) {
            return "[text=" + strF + ']';
        }
        return "[size=" + getData$okio().length + " text=" + strF + "…]";
    }

    public String utf8() {
        String utf8$okio = getUtf8$okio();
        if (utf8$okio != null) {
            return utf8$okio;
        }
        String utf8String = Platform.toUtf8String(internalArray$okio());
        setUtf8$okio(utf8String);
        return utf8String;
    }

    public void write(OutputStream out) throws IOException {
        Intrinsics.g(out, "out");
        out.write(this.data);
    }

    public void write$okio(Buffer buffer, int i11, int i12) {
        Intrinsics.g(buffer, "buffer");
        ByteStringKt.commonWrite(this, buffer, i11, i12);
    }
}
