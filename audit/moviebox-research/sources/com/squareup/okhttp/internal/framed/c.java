package com.squareup.okhttp.internal.framed;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.bumptech.glide.integration.cronet.BufferQueue;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.squareup.okhttp.internal.framed.b[] f49154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<ByteString, Integer> f49155b;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BufferedSource f49157b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f49158c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f49159d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public com.squareup.okhttp.internal.framed.b[] f49160e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f49161f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<com.squareup.okhttp.internal.framed.b> f49156a = new ArrayList();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f49162g = 0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f49163h = 0;

        public a(int i11, Source source) {
            com.squareup.okhttp.internal.framed.b[] bVarArr = new com.squareup.okhttp.internal.framed.b[8];
            this.f49160e = bVarArr;
            this.f49161f = bVarArr.length - 1;
            this.f49158c = i11;
            this.f49159d = i11;
            this.f49157b = Okio.buffer(source);
        }

        public final void a() {
            int i11 = this.f49159d;
            int i12 = this.f49163h;
            if (i11 < i12) {
                if (i11 == 0) {
                    b();
                } else {
                    d(i12 - i11);
                }
            }
        }

        public final void b() {
            this.f49156a.clear();
            Arrays.fill(this.f49160e, (Object) null);
            this.f49161f = this.f49160e.length - 1;
            this.f49162g = 0;
            this.f49163h = 0;
        }

        public final int c(int i11) {
            return this.f49161f + 1 + i11;
        }

        public final int d(int i11) {
            int i12;
            int i13 = 0;
            if (i11 > 0) {
                int length = this.f49160e.length;
                while (true) {
                    length--;
                    i12 = this.f49161f;
                    if (length < i12 || i11 <= 0) {
                        break;
                    }
                    int i14 = this.f49160e[length].f49153c;
                    i11 -= i14;
                    this.f49163h -= i14;
                    this.f49162g--;
                    i13++;
                }
                com.squareup.okhttp.internal.framed.b[] bVarArr = this.f49160e;
                System.arraycopy(bVarArr, i12 + 1, bVarArr, i12 + 1 + i13, this.f49162g);
                this.f49161f += i13;
            }
            return i13;
        }

        public List<com.squareup.okhttp.internal.framed.b> e() {
            ArrayList arrayList = new ArrayList(this.f49156a);
            this.f49156a.clear();
            return arrayList;
        }

        public final ByteString f(int i11) {
            return i(i11) ? c.f49154a[i11].f49151a : this.f49160e[c(i11 - c.f49154a.length)].f49151a;
        }

        public void g(int i11) {
            this.f49158c = i11;
            this.f49159d = i11;
            a();
        }

        public final void h(int i11, com.squareup.okhttp.internal.framed.b bVar) {
            this.f49156a.add(bVar);
            int i12 = bVar.f49153c;
            if (i11 != -1) {
                i12 -= this.f49160e[c(i11)].f49153c;
            }
            int i13 = this.f49159d;
            if (i12 > i13) {
                b();
                return;
            }
            int iD = d((this.f49163h + i12) - i13);
            if (i11 == -1) {
                int i14 = this.f49162g + 1;
                com.squareup.okhttp.internal.framed.b[] bVarArr = this.f49160e;
                if (i14 > bVarArr.length) {
                    com.squareup.okhttp.internal.framed.b[] bVarArr2 = new com.squareup.okhttp.internal.framed.b[bVarArr.length * 2];
                    System.arraycopy(bVarArr, 0, bVarArr2, bVarArr.length, bVarArr.length);
                    this.f49161f = this.f49160e.length - 1;
                    this.f49160e = bVarArr2;
                }
                int i15 = this.f49161f;
                this.f49161f = i15 - 1;
                this.f49160e[i15] = bVar;
                this.f49162g++;
            } else {
                this.f49160e[i11 + c(i11) + iD] = bVar;
            }
            this.f49163h += i12;
        }

        public final boolean i(int i11) {
            return i11 >= 0 && i11 <= c.f49154a.length - 1;
        }

        public final int j() throws IOException {
            return this.f49157b.readByte() & 255;
        }

        public ByteString k() throws IOException {
            int iJ = j();
            boolean z11 = (iJ & 128) == 128;
            int iN = n(iJ, 127);
            return z11 ? ByteString.of(e.d().c(this.f49157b.readByteArray(iN))) : this.f49157b.readByteString(iN);
        }

        public void l() throws IOException {
            while (!this.f49157b.exhausted()) {
                byte b11 = this.f49157b.readByte();
                int i11 = b11 & 255;
                if (i11 == 128) {
                    throw new IOException("index == 0");
                }
                if ((b11 & 128) == 128) {
                    m(n(i11, 127) - 1);
                } else if (i11 == 64) {
                    p();
                } else if ((b11 & 64) == 64) {
                    o(n(i11, 63) - 1);
                } else if ((b11 & 32) == 32) {
                    int iN = n(i11, 31);
                    this.f49159d = iN;
                    if (iN < 0 || iN > this.f49158c) {
                        throw new IOException("Invalid dynamic table size update " + this.f49159d);
                    }
                    a();
                } else if (i11 == 16 || i11 == 0) {
                    r();
                } else {
                    q(n(i11, 15) - 1);
                }
            }
        }

        public final void m(int i11) throws IOException {
            if (i(i11)) {
                this.f49156a.add(c.f49154a[i11]);
                return;
            }
            int iC = c(i11 - c.f49154a.length);
            if (iC >= 0) {
                com.squareup.okhttp.internal.framed.b[] bVarArr = this.f49160e;
                if (iC <= bVarArr.length - 1) {
                    this.f49156a.add(bVarArr[iC]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i11 + 1));
        }

        public int n(int i11, int i12) throws IOException {
            int i13 = i11 & i12;
            if (i13 < i12) {
                return i13;
            }
            int i14 = 0;
            while (true) {
                int iJ = j();
                if ((iJ & 128) == 0) {
                    return i12 + (iJ << i14);
                }
                i12 += (iJ & 127) << i14;
                i14 += 7;
            }
        }

        public final void o(int i11) throws IOException {
            h(-1, new com.squareup.okhttp.internal.framed.b(f(i11), k()));
        }

        public final void p() throws IOException {
            h(-1, new com.squareup.okhttp.internal.framed.b(c.d(k()), k()));
        }

        public final void q(int i11) throws IOException {
            this.f49156a.add(new com.squareup.okhttp.internal.framed.b(f(i11), k()));
        }

        public final void r() throws IOException {
            this.f49156a.add(new com.squareup.okhttp.internal.framed.b(c.d(k()), k()));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Buffer f49164a;

        public b(Buffer buffer) {
            this.f49164a = buffer;
        }

        public void a(ByteString byteString) throws IOException {
            c(byteString.size(), 127, 0);
            this.f49164a.write(byteString);
        }

        public void b(List<com.squareup.okhttp.internal.framed.b> list) throws IOException {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                ByteString asciiLowercase = list.get(i11).f49151a.toAsciiLowercase();
                Integer num = (Integer) c.f49155b.get(asciiLowercase);
                if (num != null) {
                    c(num.intValue() + 1, 15, 0);
                    a(list.get(i11).f49152b);
                } else {
                    this.f49164a.writeByte(0);
                    a(asciiLowercase);
                    a(list.get(i11).f49152b);
                }
            }
        }

        public void c(int i11, int i12, int i13) throws IOException {
            if (i11 < i12) {
                this.f49164a.writeByte(i11 | i13);
                return;
            }
            this.f49164a.writeByte(i13 | i12);
            int i14 = i11 - i12;
            while (i14 >= 128) {
                this.f49164a.writeByte(128 | (i14 & 127));
                i14 >>>= 7;
            }
            this.f49164a.writeByte(i14);
        }
    }

    static {
        ByteString byteString = com.squareup.okhttp.internal.framed.b.f49145e;
        ByteString byteString2 = com.squareup.okhttp.internal.framed.b.f49146f;
        ByteString byteString3 = com.squareup.okhttp.internal.framed.b.f49147g;
        ByteString byteString4 = com.squareup.okhttp.internal.framed.b.f49144d;
        f49154a = new com.squareup.okhttp.internal.framed.b[]{new com.squareup.okhttp.internal.framed.b(com.squareup.okhttp.internal.framed.b.f49148h, ""), new com.squareup.okhttp.internal.framed.b(byteString, "GET"), new com.squareup.okhttp.internal.framed.b(byteString, "POST"), new com.squareup.okhttp.internal.framed.b(byteString2, "/"), new com.squareup.okhttp.internal.framed.b(byteString2, "/index.html"), new com.squareup.okhttp.internal.framed.b(byteString3, HttpHost.DEFAULT_SCHEME_NAME), new com.squareup.okhttp.internal.framed.b(byteString3, "https"), new com.squareup.okhttp.internal.framed.b(byteString4, "200"), new com.squareup.okhttp.internal.framed.b(byteString4, "204"), new com.squareup.okhttp.internal.framed.b(byteString4, "206"), new com.squareup.okhttp.internal.framed.b(byteString4, "304"), new com.squareup.okhttp.internal.framed.b(byteString4, "400"), new com.squareup.okhttp.internal.framed.b(byteString4, "404"), new com.squareup.okhttp.internal.framed.b(byteString4, "500"), new com.squareup.okhttp.internal.framed.b("accept-charset", ""), new com.squareup.okhttp.internal.framed.b("accept-encoding", "gzip, deflate"), new com.squareup.okhttp.internal.framed.b("accept-language", ""), new com.squareup.okhttp.internal.framed.b("accept-ranges", ""), new com.squareup.okhttp.internal.framed.b("accept", ""), new com.squareup.okhttp.internal.framed.b("access-control-allow-origin", ""), new com.squareup.okhttp.internal.framed.b("age", ""), new com.squareup.okhttp.internal.framed.b("allow", ""), new com.squareup.okhttp.internal.framed.b("authorization", ""), new com.squareup.okhttp.internal.framed.b("cache-control", ""), new com.squareup.okhttp.internal.framed.b("content-disposition", ""), new com.squareup.okhttp.internal.framed.b(BufferQueue.CONTENT_ENCODING, ""), new com.squareup.okhttp.internal.framed.b("content-language", ""), new com.squareup.okhttp.internal.framed.b(BufferQueue.CONTENT_LENGTH, ""), new com.squareup.okhttp.internal.framed.b("content-location", ""), new com.squareup.okhttp.internal.framed.b("content-range", ""), new com.squareup.okhttp.internal.framed.b("content-type", ""), new com.squareup.okhttp.internal.framed.b("cookie", ""), new com.squareup.okhttp.internal.framed.b("date", ""), new com.squareup.okhttp.internal.framed.b(DownloadModel.ETAG, ""), new com.squareup.okhttp.internal.framed.b("expect", ""), new com.squareup.okhttp.internal.framed.b("expires", ""), new com.squareup.okhttp.internal.framed.b("from", ""), new com.squareup.okhttp.internal.framed.b("host", ""), new com.squareup.okhttp.internal.framed.b("if-match", ""), new com.squareup.okhttp.internal.framed.b("if-modified-since", ""), new com.squareup.okhttp.internal.framed.b("if-none-match", ""), new com.squareup.okhttp.internal.framed.b("if-range", ""), new com.squareup.okhttp.internal.framed.b("if-unmodified-since", ""), new com.squareup.okhttp.internal.framed.b("last-modified", ""), new com.squareup.okhttp.internal.framed.b("link", ""), new com.squareup.okhttp.internal.framed.b(RequestParameters.SUBRESOURCE_LOCATION, ""), new com.squareup.okhttp.internal.framed.b("max-forwards", ""), new com.squareup.okhttp.internal.framed.b("proxy-authenticate", ""), new com.squareup.okhttp.internal.framed.b("proxy-authorization", ""), new com.squareup.okhttp.internal.framed.b("range", ""), new com.squareup.okhttp.internal.framed.b(RequestParameters.SUBRESOURCE_REFERER, ""), new com.squareup.okhttp.internal.framed.b(ToolBar.REFRESH, ""), new com.squareup.okhttp.internal.framed.b("retry-after", ""), new com.squareup.okhttp.internal.framed.b("server", ""), new com.squareup.okhttp.internal.framed.b("set-cookie", ""), new com.squareup.okhttp.internal.framed.b("strict-transport-security", ""), new com.squareup.okhttp.internal.framed.b("transfer-encoding", ""), new com.squareup.okhttp.internal.framed.b("user-agent", ""), new com.squareup.okhttp.internal.framed.b("vary", ""), new com.squareup.okhttp.internal.framed.b("via", ""), new com.squareup.okhttp.internal.framed.b("www-authenticate", "")};
        f49155b = e();
    }

    public static ByteString d(ByteString byteString) throws IOException {
        int size = byteString.size();
        for (int i11 = 0; i11 < size; i11++) {
            byte b11 = byteString.getByte(i11);
            if (b11 >= 65 && b11 <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.utf8());
            }
        }
        return byteString;
    }

    public static Map<ByteString, Integer> e() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f49154a.length);
        int i11 = 0;
        while (true) {
            com.squareup.okhttp.internal.framed.b[] bVarArr = f49154a;
            if (i11 >= bVarArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(bVarArr[i11].f49151a)) {
                linkedHashMap.put(bVarArr[i11].f49151a, Integer.valueOf(i11));
            }
            i11++;
        }
    }
}
