package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.exoplayer2.common.base.Charsets;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ua extends dk {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Pattern f23559c = Pattern.compile("(.+?)='(.*?)';", 32);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CharsetDecoder f23560a = Charsets.UTF_8.newDecoder();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CharsetDecoder f23561b = Charsets.ISO_8859_1.newDecoder();

    private String a(ByteBuffer byteBuffer) {
        try {
            String string = this.f23560a.decode(byteBuffer).toString();
            this.f23560a.reset();
            byteBuffer.rewind();
            return string;
        } catch (CharacterCodingException unused) {
            this.f23560a.reset();
            byteBuffer.rewind();
            try {
                return this.f23561b.decode(byteBuffer).toString();
            } catch (CharacterCodingException unused2) {
                return null;
            } finally {
                this.f23561b.reset();
                byteBuffer.rewind();
            }
        } catch (Throwable th2) {
            this.f23560a.reset();
            byteBuffer.rewind();
            throw th2;
        }
    }

    @Override // com.applovin.impl.dk
    public bf a(ef efVar, ByteBuffer byteBuffer) {
        String strA = a(byteBuffer);
        byte[] bArr = new byte[byteBuffer.limit()];
        byteBuffer.get(bArr);
        String str = null;
        if (strA == null) {
            return new bf(new wa(bArr, null, null));
        }
        Matcher matcher = f23559c.matcher(strA);
        String str2 = null;
        for (int iEnd = 0; matcher.find(iEnd); iEnd = matcher.end()) {
            String strGroup = matcher.group(1);
            String strGroup2 = matcher.group(2);
            if (strGroup != null) {
                String lowerCase = Ascii.toLowerCase(strGroup);
                lowerCase.hashCode();
                if (lowerCase.equals("streamurl")) {
                    str2 = strGroup2;
                } else if (lowerCase.equals("streamtitle")) {
                    str = strGroup2;
                }
            }
        }
        return new bf(new wa(bArr, str, str2));
    }
}
