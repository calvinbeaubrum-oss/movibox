package com.mbridge.msdk.thrid.okio;

import androidx.annotation.Nullable;
import com.transsion.api.gateway.utils.EncoderUtil;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class HashingSink extends ForwardingSink {

    @Nullable
    private final Mac mac;

    @Nullable
    private final MessageDigest messageDigest;

    private HashingSink(Sink sink, ByteString byteString, String str) {
        super(sink);
        try {
            Mac mac = Mac.getInstance(str);
            this.mac = mac;
            mac.init(new SecretKeySpec(byteString.toByteArray(), str));
            this.messageDigest = null;
        } catch (InvalidKeyException e11) {
            throw new IllegalArgumentException(e11);
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    private HashingSink(Sink sink, String str) {
        super(sink);
        try {
            this.messageDigest = MessageDigest.getInstance(str);
            this.mac = null;
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    public static HashingSink hmacSha1(Sink sink, ByteString byteString) {
        return new HashingSink(sink, byteString, "HmacSHA1");
    }

    public static HashingSink hmacSha256(Sink sink, ByteString byteString) {
        return new HashingSink(sink, byteString, "HmacSHA256");
    }

    public static HashingSink hmacSha512(Sink sink, ByteString byteString) {
        return new HashingSink(sink, byteString, "HmacSHA512");
    }

    public static HashingSink md5(Sink sink) {
        return new HashingSink(sink, "MD5");
    }

    public static HashingSink sha1(Sink sink) {
        return new HashingSink(sink, EncoderUtil.ALGORITHM_SHA_1);
    }

    public static HashingSink sha256(Sink sink) {
        return new HashingSink(sink, EncoderUtil.ALGORITHM_SHA_256);
    }

    public static HashingSink sha512(Sink sink) {
        return new HashingSink(sink, EncoderUtil.ALGORITHM_SHA_512);
    }

    public final ByteString hash() {
        MessageDigest messageDigest = this.messageDigest;
        return ByteString.of(messageDigest != null ? messageDigest.digest() : this.mac.doFinal());
    }

    @Override // com.mbridge.msdk.thrid.okio.ForwardingSink, com.mbridge.msdk.thrid.okio.Sink
    public void write(Buffer buffer, long j11) throws IOException {
        Util.checkOffsetAndCount(buffer.size, 0L, j11);
        Segment segment = buffer.head;
        long j12 = 0;
        while (j12 < j11) {
            int iMin = (int) Math.min(j11 - j12, segment.limit - segment.pos);
            MessageDigest messageDigest = this.messageDigest;
            if (messageDigest != null) {
                messageDigest.update(segment.data, segment.pos, iMin);
            } else {
                this.mac.update(segment.data, segment.pos, iMin);
            }
            j12 += (long) iMin;
            segment = segment.next;
        }
        super.write(buffer, j11);
    }
}
