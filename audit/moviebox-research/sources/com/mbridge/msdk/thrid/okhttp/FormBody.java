package com.mbridge.msdk.thrid.okhttp;

import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okio.Buffer;
import com.mbridge.msdk.thrid.okio.BufferedSink;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class FormBody extends RequestBody {
    private static final MediaType CONTENT_TYPE = MediaType.get("application/x-www-form-urlencoded");
    private final List<String> encodedNames;
    private final List<String> encodedValues;

    /* JADX INFO: compiled from: source.java */
    public static final class Builder {
        private final Charset charset;
        private final List<String> names;
        private final List<String> values;

        public Builder() {
            this(null);
        }

        public Builder(Charset charset) {
            this.names = new ArrayList();
            this.values = new ArrayList();
            this.charset = charset;
        }

        public Builder add(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (str2 == null) {
                throw new NullPointerException("value == null");
            }
            this.names.add(HttpUrl.canonicalize(str, okhttp3.HttpUrl.FORM_ENCODE_SET, false, false, true, true, this.charset));
            this.values.add(HttpUrl.canonicalize(str2, okhttp3.HttpUrl.FORM_ENCODE_SET, false, false, true, true, this.charset));
            return this;
        }

        public Builder addEncoded(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (str2 == null) {
                throw new NullPointerException("value == null");
            }
            this.names.add(HttpUrl.canonicalize(str, okhttp3.HttpUrl.FORM_ENCODE_SET, true, false, true, true, this.charset));
            this.values.add(HttpUrl.canonicalize(str2, okhttp3.HttpUrl.FORM_ENCODE_SET, true, false, true, true, this.charset));
            return this;
        }

        public FormBody build() {
            return new FormBody(this.names, this.values);
        }
    }

    public FormBody(List<String> list, List<String> list2) {
        this.encodedNames = Util.immutableList(list);
        this.encodedValues = Util.immutableList(list2);
    }

    private long writeOrCountBytes(BufferedSink bufferedSink, boolean z11) {
        Buffer buffer = z11 ? new Buffer() : bufferedSink.buffer();
        int size = this.encodedNames.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (i11 > 0) {
                buffer.writeByte(38);
            }
            buffer.writeUtf8(this.encodedNames.get(i11));
            buffer.writeByte(61);
            buffer.writeUtf8(this.encodedValues.get(i11));
        }
        if (!z11) {
            return 0L;
        }
        long size2 = buffer.size();
        buffer.clear();
        return size2;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.RequestBody
    public long contentLength() {
        return writeOrCountBytes(null, true);
    }

    @Override // com.mbridge.msdk.thrid.okhttp.RequestBody
    public MediaType contentType() {
        return CONTENT_TYPE;
    }

    public String encodedName(int i11) {
        return this.encodedNames.get(i11);
    }

    public String encodedValue(int i11) {
        return this.encodedValues.get(i11);
    }

    public String name(int i11) {
        return HttpUrl.percentDecode(encodedName(i11), true);
    }

    public int size() {
        return this.encodedNames.size();
    }

    public String value(int i11) {
        return HttpUrl.percentDecode(encodedValue(i11), true);
    }

    @Override // com.mbridge.msdk.thrid.okhttp.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        writeOrCountBytes(bufferedSink, false);
    }
}
