package com.mbridge.msdk.thrid.okhttp;

import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okio.BufferedSink;
import com.mbridge.msdk.thrid.okio.ByteString;
import com.mbridge.msdk.thrid.okio.Okio;
import com.mbridge.msdk.thrid.okio.Source;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public abstract class RequestBody {
    public static RequestBody create(final MediaType mediaType, final ByteString byteString) {
        return new RequestBody() { // from class: com.mbridge.msdk.thrid.okhttp.RequestBody.1
            @Override // com.mbridge.msdk.thrid.okhttp.RequestBody
            public long contentLength() throws IOException {
                return byteString.size();
            }

            @Override // com.mbridge.msdk.thrid.okhttp.RequestBody
            public MediaType contentType() {
                return mediaType;
            }

            @Override // com.mbridge.msdk.thrid.okhttp.RequestBody
            public void writeTo(BufferedSink bufferedSink) throws IOException {
                bufferedSink.write(byteString);
            }
        };
    }

    public static RequestBody create(final MediaType mediaType, final File file) {
        if (file != null) {
            return new RequestBody() { // from class: com.mbridge.msdk.thrid.okhttp.RequestBody.3
                @Override // com.mbridge.msdk.thrid.okhttp.RequestBody
                public long contentLength() {
                    return file.length();
                }

                @Override // com.mbridge.msdk.thrid.okhttp.RequestBody
                public MediaType contentType() {
                    return mediaType;
                }

                @Override // com.mbridge.msdk.thrid.okhttp.RequestBody
                public void writeTo(BufferedSink bufferedSink) throws IOException {
                    Source source = null;
                    try {
                        source = Okio.source(file);
                        bufferedSink.writeAll(source);
                    } finally {
                        Util.closeQuietly(source);
                    }
                }
            };
        }
        throw new NullPointerException("file == null");
    }

    public static RequestBody create(MediaType mediaType, String str) {
        Charset charset = Util.UTF_8;
        if (mediaType != null) {
            Charset charset2 = mediaType.charset();
            if (charset2 == null) {
                mediaType = MediaType.parse(mediaType + "; charset=utf-8");
            } else {
                charset = charset2;
            }
        }
        return create(mediaType, str.getBytes(charset));
    }

    public static RequestBody create(MediaType mediaType, byte[] bArr) {
        return create(mediaType, bArr, 0, bArr.length);
    }

    public static RequestBody create(final MediaType mediaType, final byte[] bArr, final int i11, final int i12) {
        if (bArr == null) {
            throw new NullPointerException("content == null");
        }
        Util.checkOffsetAndCount(bArr.length, i11, i12);
        return new RequestBody() { // from class: com.mbridge.msdk.thrid.okhttp.RequestBody.2
            @Override // com.mbridge.msdk.thrid.okhttp.RequestBody
            public long contentLength() {
                return i12;
            }

            @Override // com.mbridge.msdk.thrid.okhttp.RequestBody
            public MediaType contentType() {
                return mediaType;
            }

            @Override // com.mbridge.msdk.thrid.okhttp.RequestBody
            public void writeTo(BufferedSink bufferedSink) throws IOException {
                bufferedSink.write(bArr, i11, i12);
            }
        };
    }

    public long contentLength() throws IOException {
        return -1L;
    }

    public abstract MediaType contentType();

    public abstract void writeTo(BufferedSink bufferedSink) throws IOException;
}
