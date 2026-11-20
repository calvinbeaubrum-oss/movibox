package com.mbridge.msdk.thrid.okio;

import com.transsion.api.gateway.utils.EncoderUtil;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class HashingSource extends ForwardingSource {
    private final Mac mac;
    private final MessageDigest messageDigest;

    private HashingSource(Source source, ByteString byteString, String str) {
        super(source);
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

    private HashingSource(Source source, String str) {
        super(source);
        try {
            this.messageDigest = MessageDigest.getInstance(str);
            this.mac = null;
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    public static HashingSource hmacSha1(Source source, ByteString byteString) {
        return new HashingSource(source, byteString, "HmacSHA1");
    }

    public static HashingSource hmacSha256(Source source, ByteString byteString) {
        return new HashingSource(source, byteString, "HmacSHA256");
    }

    public static HashingSource md5(Source source) {
        return new HashingSource(source, "MD5");
    }

    public static HashingSource sha1(Source source) {
        return new HashingSource(source, EncoderUtil.ALGORITHM_SHA_1);
    }

    public static HashingSource sha256(Source source) {
        return new HashingSource(source, EncoderUtil.ALGORITHM_SHA_256);
    }

    public final ByteString hash() {
        MessageDigest messageDigest = this.messageDigest;
        return ByteString.of(messageDigest != null ? messageDigest.digest() : this.mac.doFinal());
    }

    @Override // com.mbridge.msdk.thrid.okio.ForwardingSource, com.mbridge.msdk.thrid.okio.Source
    public long read(Buffer buffer, long j11) throws IOException {
        long j12 = super.read(buffer, j11);
        if (j12 != -1) {
            long j13 = buffer.size;
            long j14 = j13 - j12;
            Segment segment = buffer.head;
            while (j13 > j14) {
                segment = segment.prev;
                j13 -= (long) (segment.limit - segment.pos);
            }
            while (j13 < buffer.size) {
                int i11 = (int) ((((long) segment.pos) + j14) - j13);
                MessageDigest messageDigest = this.messageDigest;
                if (messageDigest != null) {
                    messageDigest.update(segment.data, i11, segment.limit - i11);
                } else {
                    this.mac.update(segment.data, i11, segment.limit - i11);
                }
                j14 = ((long) (segment.limit - segment.pos)) + j13;
                segment = segment.next;
                j13 = j14;
            }
        }
        return j12;
    }
}
