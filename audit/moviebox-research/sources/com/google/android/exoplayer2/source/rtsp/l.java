package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import android.util.Base64;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.o0;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f34557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f34558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f34559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f34560d;

    public l(int i11, String str, String str2, String str3) {
        this.f34557a = i11;
        this.f34558b = str;
        this.f34559c = str2;
        this.f34560d = str3;
    }

    public String a(y.a aVar, Uri uri, int i11) throws ParserException {
        int i12 = this.f34557a;
        if (i12 == 1) {
            return b(aVar);
        }
        if (i12 == 2) {
            return c(aVar, uri, i11);
        }
        throw ParserException.createForManifestWithUnsupportedFeature(null, new UnsupportedOperationException());
    }

    public final String b(y.a aVar) {
        return o0.C("Basic %s", Base64.encodeToString(y.d(aVar.f34640a + ":" + aVar.f34641b), 0));
    }

    public final String c(y.a aVar, Uri uri, int i11) throws ParserException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            String strT = y.t(i11);
            String strA1 = o0.a1(messageDigest.digest(y.d(aVar.f34640a + ":" + this.f34558b + ":" + aVar.f34641b)));
            StringBuilder sb2 = new StringBuilder();
            sb2.append(strT);
            sb2.append(":");
            sb2.append(uri);
            String strA2 = o0.a1(messageDigest.digest(y.d(strA1 + ":" + this.f34559c + ":" + o0.a1(messageDigest.digest(y.d(sb2.toString()))))));
            return this.f34560d.isEmpty() ? o0.C("Digest username=\"%s\", realm=\"%s\", nonce=\"%s\", uri=\"%s\", response=\"%s\"", aVar.f34640a, this.f34558b, this.f34559c, uri, strA2) : o0.C("Digest username=\"%s\", realm=\"%s\", nonce=\"%s\", uri=\"%s\", response=\"%s\", opaque=\"%s\"", aVar.f34640a, this.f34558b, this.f34559c, uri, strA2, this.f34560d);
        } catch (NoSuchAlgorithmException e11) {
            throw ParserException.createForManifestWithUnsupportedFeature(null, e11);
        }
    }
}
