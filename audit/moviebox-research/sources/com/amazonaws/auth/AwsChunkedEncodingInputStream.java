package com.amazonaws.auth;

import android.support.v4.media.session.PlaybackStateCompat;
import com.amazonaws.AmazonClientException;
import com.amazonaws.internal.SdkInputStream;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.StringUtils;
import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AwsChunkedEncodingInputStream extends SdkInputStream {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final byte[] f15671n = new byte[0];

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Log f15672o = LogFactory.b(AwsChunkedEncodingInputStream.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InputStream f15673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15674b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f15675c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f15676d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f15677f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f15678g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f15679h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AWS4Signer f15680i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ChunkContentIterator f15681j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public DecodedStreamBuffer f15682k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f15683l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f15684m;

    public AwsChunkedEncodingInputStream(InputStream inputStream, int i11, byte[] bArr, String str, String str2, String str3, AWS4Signer aWS4Signer) {
        this.f15673a = null;
        this.f15683l = true;
        this.f15684m = false;
        if (inputStream instanceof AwsChunkedEncodingInputStream) {
            AwsChunkedEncodingInputStream awsChunkedEncodingInputStream = (AwsChunkedEncodingInputStream) inputStream;
            i11 = Math.max(awsChunkedEncodingInputStream.f15674b, i11);
            this.f15673a = awsChunkedEncodingInputStream.f15673a;
            this.f15682k = awsChunkedEncodingInputStream.f15682k;
        } else {
            this.f15673a = inputStream;
            this.f15682k = null;
        }
        if (i11 < 131072) {
            throw new IllegalArgumentException("Max buffer size should not be less than chunk size");
        }
        this.f15674b = i11;
        this.f15675c = bArr;
        this.f15676d = str;
        this.f15677f = str2;
        this.f15678g = str3;
        this.f15679h = str3;
        this.f15680i = aWS4Signer;
    }

    public AwsChunkedEncodingInputStream(InputStream inputStream, byte[] bArr, String str, String str2, String str3, AWS4Signer aWS4Signer) {
        this(inputStream, 262144, bArr, str, str2, str3, aWS4Signer);
    }

    public static long e(long j11) {
        return ((long) (Long.toHexString(j11).length() + 83)) + j11 + ((long) 2);
    }

    public static long g(long j11) {
        if (j11 < 0) {
            throw new IllegalArgumentException("Nonnegative content length expected.");
        }
        long j12 = j11 / PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
        long j13 = j11 % PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
        return (j12 * e(PlaybackStateCompat.ACTION_PREPARE_FROM_URI)) + (j13 > 0 ? e(j13) : 0L) + e(0L);
    }

    @Override // com.amazonaws.internal.SdkInputStream
    public InputStream d() {
        return this.f15673a;
    }

    public final byte[] h(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Integer.toHexString(bArr.length));
        String strD = BinaryUtils.d(this.f15680i.r("AWS4-HMAC-SHA256-PAYLOAD\n" + this.f15676d + "\n" + this.f15677f + "\n" + this.f15679h + "\n" + BinaryUtils.d(this.f15680i.o("")) + "\n" + BinaryUtils.d(this.f15680i.p(bArr)), this.f15675c, SigningAlgorithm.HmacSHA256));
        this.f15679h = strD;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(";chunk-signature=");
        sb3.append(strD);
        sb2.append(sb3.toString());
        sb2.append("\r\n");
        try {
            String string = sb2.toString();
            Charset charset = StringUtils.f16272a;
            byte[] bytes = string.getBytes(charset);
            byte[] bytes2 = "\r\n".getBytes(charset);
            byte[] bArr2 = new byte[bytes.length + bArr.length + bytes2.length];
            System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
            System.arraycopy(bArr, 0, bArr2, bytes.length, bArr.length);
            System.arraycopy(bytes2, 0, bArr2, bytes.length + bArr.length, bytes2.length);
            return bArr2;
        } catch (Exception e11) {
            throw new AmazonClientException("Unable to sign the chunked data. " + e11.getMessage(), e11);
        }
    }

    public final boolean i() throws IOException {
        byte[] bArr = new byte[131072];
        int i11 = 0;
        while (i11 < 131072) {
            DecodedStreamBuffer decodedStreamBuffer = this.f15682k;
            if (decodedStreamBuffer == null || !decodedStreamBuffer.b()) {
                int i12 = this.f15673a.read(bArr, i11, 131072 - i11);
                if (i12 == -1) {
                    break;
                }
                DecodedStreamBuffer decodedStreamBuffer2 = this.f15682k;
                if (decodedStreamBuffer2 != null) {
                    decodedStreamBuffer2.a(bArr, i11, i12);
                }
                i11 += i12;
            } else {
                bArr[i11] = this.f15682k.c();
                i11++;
            }
        }
        if (i11 == 0) {
            this.f15681j = new ChunkContentIterator(h(f15671n));
            return true;
        }
        if (i11 < 131072) {
            byte[] bArr2 = new byte[i11];
            System.arraycopy(bArr, 0, bArr2, 0, i11);
            bArr = bArr2;
        }
        this.f15681j = new ChunkContentIterator(h(bArr));
        return false;
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i11) {
        try {
            c();
            if (!this.f15683l) {
                throw new UnsupportedOperationException("Chunk-encoded stream only supports mark() at the start of the stream.");
            }
            if (this.f15673a.markSupported()) {
                Log log = f15672o;
                if (log.b()) {
                    log.a("AwsChunkedEncodingInputStream marked at the start of the stream (will directly mark the wrapped stream since it's mark-supported).");
                }
                this.f15673a.mark(Api.BaseClientBuilder.API_PRIORITY_OTHER);
            } else {
                Log log2 = f15672o;
                if (log2.b()) {
                    log2.a("AwsChunkedEncodingInputStream marked at the start of the stream (initializing the buffer since the wrapped stream is not mark-supported).");
                }
                this.f15682k = new DecodedStreamBuffer(this.f15674b);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        byte[] bArr = new byte[1];
        int i11 = read(bArr, 0, 1);
        if (i11 == -1) {
            return i11;
        }
        Log log = f15672o;
        if (log.b()) {
            log.a("One byte read from the stream.");
        }
        return bArr[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i11, int i12) throws IOException {
        c();
        bArr.getClass();
        if (i11 < 0 || i12 < 0 || i12 > bArr.length - i11) {
            throw new IndexOutOfBoundsException();
        }
        if (i12 == 0) {
            return 0;
        }
        ChunkContentIterator chunkContentIterator = this.f15681j;
        if (chunkContentIterator == null || !chunkContentIterator.a()) {
            if (this.f15684m) {
                return -1;
            }
            this.f15684m = i();
        }
        int iB = this.f15681j.b(bArr, i11, i12);
        if (iB > 0) {
            this.f15683l = false;
            Log log = f15672o;
            if (log.b()) {
                log.a(iB + " byte read from the stream.");
            }
        }
        return iB;
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        try {
            c();
            this.f15681j = null;
            this.f15679h = this.f15678g;
            if (this.f15673a.markSupported()) {
                Log log = f15672o;
                if (log.b()) {
                    log.a("AwsChunkedEncodingInputStream reset (will reset the wrapped stream because it is mark-supported).");
                }
                this.f15673a.reset();
            } else {
                Log log2 = f15672o;
                if (log2.b()) {
                    log2.a("AwsChunkedEncodingInputStream reset (will use the buffer of the decoded stream).");
                }
                DecodedStreamBuffer decodedStreamBuffer = this.f15682k;
                if (decodedStreamBuffer == null) {
                    throw new IOException("Cannot reset the stream because the mark is not set.");
                }
                decodedStreamBuffer.d();
            }
            this.f15681j = null;
            this.f15683l = true;
            this.f15684m = false;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // java.io.InputStream
    public long skip(long j11) throws IOException {
        int i11;
        if (j11 <= 0) {
            return 0L;
        }
        int iMin = (int) Math.min(PlaybackStateCompat.ACTION_SET_REPEAT_MODE, j11);
        byte[] bArr = new byte[iMin];
        long j12 = j11;
        while (j12 > 0 && (i11 = read(bArr, 0, iMin)) >= 0) {
            j12 -= (long) i11;
        }
        return j11 - j12;
    }
}
