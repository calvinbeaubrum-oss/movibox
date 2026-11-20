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
public final class HashingSink extends ForwardingSink {
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
        public final HashingSink hmacSha1(Sink sink, ByteString key) {
            Intrinsics.g(sink, "sink");
            Intrinsics.g(key, "key");
            return new HashingSink(sink, key, "HmacSHA1");
        }

        @JvmStatic
        public final HashingSink hmacSha256(Sink sink, ByteString key) {
            Intrinsics.g(sink, "sink");
            Intrinsics.g(key, "key");
            return new HashingSink(sink, key, "HmacSHA256");
        }

        @JvmStatic
        public final HashingSink hmacSha512(Sink sink, ByteString key) {
            Intrinsics.g(sink, "sink");
            Intrinsics.g(key, "key");
            return new HashingSink(sink, key, "HmacSHA512");
        }

        @JvmStatic
        public final HashingSink md5(Sink sink) {
            Intrinsics.g(sink, "sink");
            return new HashingSink(sink, "MD5");
        }

        @JvmStatic
        public final HashingSink sha1(Sink sink) {
            Intrinsics.g(sink, "sink");
            return new HashingSink(sink, EncoderUtil.ALGORITHM_SHA_1);
        }

        @JvmStatic
        public final HashingSink sha256(Sink sink) {
            Intrinsics.g(sink, "sink");
            return new HashingSink(sink, EncoderUtil.ALGORITHM_SHA_256);
        }

        @JvmStatic
        public final HashingSink sha512(Sink sink) {
            Intrinsics.g(sink, "sink");
            return new HashingSink(sink, EncoderUtil.ALGORITHM_SHA_512);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public HashingSink(Sink sink, String algorithm) throws NoSuchAlgorithmException {
        Intrinsics.g(sink, "sink");
        Intrinsics.g(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        Intrinsics.f(messageDigest, "MessageDigest.getInstance(algorithm)");
        this(sink, messageDigest);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSink(Sink sink, MessageDigest digest) {
        super(sink);
        Intrinsics.g(sink, "sink");
        Intrinsics.g(digest, "digest");
        this.messageDigest = digest;
        this.mac = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSink(Sink sink, Mac mac) {
        super(sink);
        Intrinsics.g(sink, "sink");
        Intrinsics.g(mac, "mac");
        this.mac = mac;
        this.messageDigest = null;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public HashingSink(Sink sink, ByteString key, String algorithm) throws NoSuchAlgorithmException {
        Intrinsics.g(sink, "sink");
        Intrinsics.g(key, "key");
        Intrinsics.g(algorithm, "algorithm");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.toByteArray(), algorithm));
            Unit unit = Unit.f68710a;
            Intrinsics.f(mac, "try {\n      Mac.getInsta…rgumentException(e)\n    }");
            this(sink, mac);
        } catch (InvalidKeyException e11) {
            throw new IllegalArgumentException(e11);
        }
    }

    @JvmStatic
    public static final HashingSink hmacSha1(Sink sink, ByteString byteString) {
        return Companion.hmacSha1(sink, byteString);
    }

    @JvmStatic
    public static final HashingSink hmacSha256(Sink sink, ByteString byteString) {
        return Companion.hmacSha256(sink, byteString);
    }

    @JvmStatic
    public static final HashingSink hmacSha512(Sink sink, ByteString byteString) {
        return Companion.hmacSha512(sink, byteString);
    }

    @JvmStatic
    public static final HashingSink md5(Sink sink) {
        return Companion.md5(sink);
    }

    @JvmStatic
    public static final HashingSink sha1(Sink sink) {
        return Companion.sha1(sink);
    }

    @JvmStatic
    public static final HashingSink sha256(Sink sink) {
        return Companion.sha256(sink);
    }

    @JvmStatic
    public static final HashingSink sha512(Sink sink) {
        return Companion.sha512(sink);
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_hash, reason: not valid java name */
    public final ByteString m328deprecated_hash() {
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

    @Override // okio.ForwardingSink, okio.Sink
    public void write(Buffer source, long j11) throws IOException {
        Intrinsics.g(source, "source");
        Util.checkOffsetAndCount(source.size(), 0L, j11);
        Segment segment = source.head;
        Intrinsics.d(segment);
        long j12 = 0;
        while (j12 < j11) {
            int iMin = (int) Math.min(j11 - j12, segment.limit - segment.pos);
            MessageDigest messageDigest = this.messageDigest;
            if (messageDigest != null) {
                messageDigest.update(segment.data, segment.pos, iMin);
            } else {
                Mac mac = this.mac;
                Intrinsics.d(mac);
                mac.update(segment.data, segment.pos, iMin);
            }
            j12 += (long) iMin;
            segment = segment.next;
            Intrinsics.d(segment);
        }
        super.write(source, j11);
    }
}
