package org.apache.commons.compress.archivers.zip;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import okio.Utf8;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class g implements u {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f72571c = {Utf8.REPLACEMENT_BYTE};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f72572d = String.valueOf('?');

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final char[] f72573e = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Charset f72574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f72575b;

    public g(Charset charset, boolean z11) {
        this.f72574a = charset;
        this.f72575b = z11;
    }

    @Override // org.apache.commons.compress.archivers.zip.u
    public String a(byte[] bArr) throws IOException {
        return b().decode(ByteBuffer.wrap(bArr)).toString();
    }

    public final CharsetDecoder b() {
        if (this.f72575b) {
            CharsetDecoder charsetDecoderNewDecoder = this.f72574a.newDecoder();
            CodingErrorAction codingErrorAction = CodingErrorAction.REPLACE;
            return charsetDecoderNewDecoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction).replaceWith(f72572d);
        }
        CharsetDecoder charsetDecoderNewDecoder2 = this.f72574a.newDecoder();
        CodingErrorAction codingErrorAction2 = CodingErrorAction.REPORT;
        return charsetDecoderNewDecoder2.onMalformedInput(codingErrorAction2).onUnmappableCharacter(codingErrorAction2);
    }
}
