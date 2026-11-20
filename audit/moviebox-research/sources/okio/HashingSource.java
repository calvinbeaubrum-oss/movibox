package okio;

import com.transsion.api.gateway.utils.EncoderUtil;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class HashingSource extends ForwardingSource {
    public static final Companion Companion = new Companion(null);
    private final Mac mac;
    private final MessageDigest messageDigest;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final HashingSource hmacSha1(Source source, ByteString key) {
            Intrinsics.g(source, "source");
            Intrinsics.g(key, "key");
            return new HashingSource(source, key, "HmacSHA1");
        }

        @JvmStatic
        public final HashingSource hmacSha256(Source source, ByteString key) {
            Intrinsics.g(source, "source");
            Intrinsics.g(key, "key");
            return new HashingSource(source, key, "HmacSHA256");
        }

        @JvmStatic
        public final HashingSource hmacSha512(Source source, ByteString key) {
            Intrinsics.g(source, "source");
            Intrinsics.g(key, "key");
            return new HashingSource(source, key, "HmacSHA512");
        }

        @JvmStatic
        public final HashingSource md5(Source source) {
            Intrinsics.g(source, "source");
            return new HashingSource(source, "MD5");
        }

        @JvmStatic
        public final HashingSource sha1(Source source) {
            Intrinsics.g(source, "source");
            return new HashingSource(source, EncoderUtil.ALGORITHM_SHA_1);
        }

        @JvmStatic
        public final HashingSource sha256(Source source) {
            Intrinsics.g(source, "source");
            return new HashingSource(source, EncoderUtil.ALGORITHM_SHA_256);
        }

        @JvmStatic
        public final HashingSource sha512(Source source) {
            Intrinsics.g(source, "source");
            return new HashingSource(source, EncoderUtil.ALGORITHM_SHA_512);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public HashingSource(Source source, String algorithm) throws NoSuchAlgorithmException {
        Intrinsics.g(source, "source");
        Intrinsics.g(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        Intrinsics.f(messageDigest, "MessageDigest.getInstance(algorithm)");
        this(source, messageDigest);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSource(Source source, MessageDigest digest) {
        super(source);
        Intrinsics.g(source, "source");
        Intrinsics.g(digest, "digest");
        this.messageDigest = digest;
        this.mac = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSource(Source source, Mac mac) {
        super(source);
        Intrinsics.g(source, "source");
        Intrinsics.g(mac, "mac");
        this.mac = mac;
        this.messageDigest = null;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public HashingSource(Source source, ByteString key, String algorithm) throws NoSuchAlgorithmException {
        Intrinsics.g(source, "source");
        Intrinsics.g(key, "key");
        Intrinsics.g(algorithm, "algorithm");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.toByteArray(), algorithm));
            Unit unit = Unit.f68710a;
            Intrinsics.f(mac, "try {\n      Mac.getInsta…rgumentException(e)\n    }");
            this(source, mac);
        } catch (InvalidKeyException e11) {
            throw new IllegalArgumentException(e11);
        }
    }

    @JvmStatic
    public static final HashingSource hmacSha1(Source source, ByteString byteString) {
        return Companion.hmacSha1(source, byteString);
    }

    @JvmStatic
    public static final HashingSource hmacSha256(Source source, ByteString byteString) {
        return Companion.hmacSha256(source, byteString);
    }

    @JvmStatic
    public static final HashingSource hmacSha512(Source source, ByteString byteString) {
        return Companion.hmacSha512(source, byteString);
    }

    @JvmStatic
    public static final HashingSource md5(Source source) {
        return Companion.md5(source);
    }

    @JvmStatic
    public static final HashingSource sha1(Source source) {
        return Companion.sha1(source);
    }

    @JvmStatic
    public static final HashingSource sha256(Source source) {
        return Companion.sha256(source);
    }

    @JvmStatic
    public static final HashingSource sha512(Source source) {
        return Companion.sha512(source);
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_hash, reason: not valid java name */
    public final ByteString m329deprecated_hash() {
        return hash();
    }

    @JvmName
    public final ByteString hash() {
        byte[] result;
        MessageDigest messageDigest = this.messageDigest;
        if (messageDigest != null) {
            result = messageDigest.digest();
        } else {
            Mac mac = this.mac;
            Intrinsics.d(mac);
            result = mac.doFinal();
        }
        Intrinsics.f(result, "result");
        return new ByteString(result);
    }

    @Override // okio.ForwardingSource, okio.Source
    public long read(Buffer sink, long j11) throws IOException {
        Intrinsics.g(sink, "sink");
        long j12 = super.read(sink, j11);
        if (j12 != -1) {
            long size = sink.size() - j12;
            long size2 = sink.size();
            Segment segment = sink.head;
            Intrinsics.d(segment);
            while (size2 > size) {
                segment = segment.prev;
                Intrinsics.d(segment);
                size2 -= (long) (segment.limit - segment.pos);
            }
            while (size2 < sink.size()) {
                int i11 = (int) ((((long) segment.pos) + size) - size2);
                MessageDigest messageDigest = this.messageDigest;
                if (messageDigest != null) {
                    messageDigest.update(segment.data, i11, segment.limit - i11);
                } else {
                    Mac mac = this.mac;
                    Intrinsics.d(mac);
                    mac.update(segment.data, i11, segment.limit - i11);
                }
                size2 += (long) (segment.limit - segment.pos);
                segment = segment.next;
                Intrinsics.d(segment);
                size = size2;
            }
        }
        return j12;
    }
}
