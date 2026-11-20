package c4;

import android.net.Uri;
import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.media3.common.ParserException;
import androidx.media3.datasource.DataSourceException;
import java.io.IOException;
import java.net.URLDecoder;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public g f14588e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public byte[] f14589f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f14590g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f14591h;

    public b() {
        super(false);
    }

    @Override // androidx.media3.datasource.a
    public long a(g gVar) throws IOException {
        f(gVar);
        this.f14588e = gVar;
        Uri uriNormalizeScheme = gVar.f14598a.normalizeScheme();
        String scheme = uriNormalizeScheme.getScheme();
        z3.a.b("data".equals(scheme), "Unsupported scheme: " + scheme);
        String[] strArrO1 = u0.o1(uriNormalizeScheme.getSchemeSpecificPart(), ",");
        if (strArrO1.length != 2) {
            throw ParserException.createForMalformedDataOfUnknownType("Unexpected URI format: " + uriNormalizeScheme, null);
        }
        String str = strArrO1[1];
        if (strArrO1[0].contains(";base64")) {
            try {
                this.f14589f = Base64.decode(str, 0);
            } catch (IllegalArgumentException e11) {
                throw ParserException.createForMalformedDataOfUnknownType("Error while parsing Base64 encoded string: " + str, e11);
            }
        } else {
            this.f14589f = u0.w0(URLDecoder.decode(str, com.google.common.base.c.f38163a.name()));
        }
        long j11 = gVar.f14604g;
        byte[] bArr = this.f14589f;
        if (j11 > bArr.length) {
            this.f14589f = null;
            throw new DataSourceException(2008);
        }
        int i11 = (int) j11;
        this.f14590g = i11;
        int length = bArr.length - i11;
        this.f14591h = length;
        long j12 = gVar.f14605h;
        if (j12 != -1) {
            this.f14591h = (int) Math.min(length, j12);
        }
        g(gVar);
        long j13 = gVar.f14605h;
        return j13 != -1 ? j13 : this.f14591h;
    }

    @Override // androidx.media3.datasource.a
    public void close() {
        if (this.f14589f != null) {
            this.f14589f = null;
            e();
        }
        this.f14588e = null;
    }

    @Override // androidx.media3.datasource.a
    @Nullable
    public Uri getUri() {
        g gVar = this.f14588e;
        if (gVar != null) {
            return gVar.f14598a;
        }
        return null;
    }

    @Override // androidx.media3.common.l
    public int read(byte[] bArr, int i11, int i12) {
        if (i12 == 0) {
            return 0;
        }
        int i13 = this.f14591h;
        if (i13 == 0) {
            return -1;
        }
        int iMin = Math.min(i12, i13);
        System.arraycopy(u0.i(this.f14589f), this.f14590g, bArr, i11, iMin);
        this.f14590g += iMin;
        this.f14591h -= iMin;
        d(iMin);
        return iMin;
    }
}
