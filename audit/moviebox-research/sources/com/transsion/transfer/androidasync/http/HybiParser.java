package com.transsion.transfer.androidasync.http;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import com.transsion.transfer.androidasync.ByteBufferList;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class HybiParser {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final List<Integer> f58595w = Arrays.asList(0, 1, 2, 8, 9, 10);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final List<Integer> f58596x = Arrays.asList(0, 1, 2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f58599c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f58600d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f58601e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f58602f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f58603g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f58604h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f58605i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f58606j;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public com.transsion.transfer.androidasync.t f58618v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f58597a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f58598b = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public byte[] f58607k = new byte[0];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public byte[] f58608l = new byte[0];

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f58609m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ByteArrayOutputStream f58610n = new ByteArrayOutputStream();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Inflater f58611o = new Inflater(true);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public byte[] f58612p = new byte[4096];

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public fy.d f58613q = new a();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public fy.d f58614r = new b();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public fy.d f58615s = new c();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public fy.d f58616t = new d();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public fy.d f58617u = new e();

    /* JADX INFO: compiled from: source.java */
    public static class ProtocolError extends IOException {
        public ProtocolError(String str) {
            super(str);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements fy.d {
        public a() {
        }

        @Override // fy.d
        public void D(com.transsion.transfer.androidasync.r rVar, ByteBufferList byteBufferList) {
            try {
                HybiParser.this.F(byteBufferList.e());
            } catch (ProtocolError e11) {
                HybiParser.this.H(e11);
                e11.printStackTrace();
            }
            HybiParser.this.C();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements fy.d {
        public b() {
        }

        @Override // fy.d
        public void D(com.transsion.transfer.androidasync.r rVar, ByteBufferList byteBufferList) {
            HybiParser.this.E(byteBufferList.e());
            HybiParser.this.C();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c implements fy.d {
        public c() {
        }

        @Override // fy.d
        public void D(com.transsion.transfer.androidasync.r rVar, ByteBufferList byteBufferList) {
            byte[] bArr = new byte[HybiParser.this.f58604h];
            byteBufferList.h(bArr);
            try {
                HybiParser.this.D(bArr);
            } catch (ProtocolError e11) {
                HybiParser.this.H(e11);
                e11.printStackTrace();
            }
            HybiParser.this.C();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class d implements fy.d {
        public d() {
        }

        @Override // fy.d
        public void D(com.transsion.transfer.androidasync.r rVar, ByteBufferList byteBufferList) {
            HybiParser.this.f58607k = new byte[4];
            byteBufferList.h(HybiParser.this.f58607k);
            HybiParser.this.f58599c = 4;
            HybiParser.this.C();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e implements fy.d {
        public e() {
        }

        @Override // fy.d
        public void D(com.transsion.transfer.androidasync.r rVar, ByteBufferList byteBufferList) {
            HybiParser hybiParser = HybiParser.this;
            hybiParser.f58608l = new byte[hybiParser.f58605i];
            byteBufferList.h(HybiParser.this.f58608l);
            try {
                HybiParser.this.n();
            } catch (IOException e11) {
                HybiParser.this.H(e11);
                e11.printStackTrace();
            }
            HybiParser.this.f58599c = 0;
            HybiParser.this.C();
        }
    }

    public HybiParser(com.transsion.transfer.androidasync.r rVar) {
        com.transsion.transfer.androidasync.t tVar = new com.transsion.transfer.androidasync.t();
        this.f58618v = tVar;
        rVar.o(tVar);
        C();
    }

    public static long l(byte[] bArr, int i11, int i12) {
        if (bArr.length < i12) {
            throw new IllegalArgumentException("length must be less than or equal to b.length");
        }
        long j11 = 0;
        for (int i13 = 0; i13 < i12; i13++) {
            j11 += (long) ((bArr[i13 + i11] & 255) << (((i12 - 1) - i13) * 8));
        }
        return j11;
    }

    public static byte[] w(byte[] bArr, byte[] bArr2, int i11) {
        if (bArr2.length == 0) {
            return bArr;
        }
        for (int i12 = 0; i12 < bArr.length - i11; i12++) {
            int i13 = i11 + i12;
            bArr[i13] = (byte) (bArr[i13] ^ bArr2[i12 % 4]);
        }
        return bArr;
    }

    public abstract void A(String str);

    public abstract void B(String str);

    public void C() {
        int i11 = this.f58599c;
        if (i11 == 0) {
            this.f58618v.b(1, this.f58613q);
            return;
        }
        if (i11 == 1) {
            this.f58618v.b(1, this.f58614r);
            return;
        }
        if (i11 == 2) {
            this.f58618v.b(this.f58604h, this.f58615s);
        } else if (i11 == 3) {
            this.f58618v.b(4, this.f58616t);
        } else {
            if (i11 != 4) {
                return;
            }
            this.f58618v.b(this.f58605i, this.f58617u);
        }
    }

    public final void D(byte[] bArr) throws ProtocolError {
        this.f58605i = u(bArr);
        this.f58599c = this.f58601e ? 3 : 4;
    }

    public final void E(byte b11) {
        boolean z11 = (b11 & 128) == 128;
        this.f58601e = z11;
        int i11 = b11 & Ascii.DEL;
        this.f58605i = i11;
        if (i11 >= 0 && i11 <= 125) {
            this.f58599c = z11 ? 3 : 4;
        } else {
            this.f58604h = i11 == 126 ? 2 : 8;
            this.f58599c = 2;
        }
    }

    public final void F(byte b11) throws ProtocolError {
        boolean z11 = (b11 & 64) == 64;
        boolean z12 = (b11 & 32) == 32;
        boolean z13 = (b11 & Ascii.DLE) == 16;
        if ((!this.f58598b && z11) || z12 || z13) {
            throw new ProtocolError("RSV not zero");
        }
        this.f58600d = (b11 & 128) == 128;
        int i11 = b11 & Ascii.SI;
        this.f58603g = i11;
        this.f58602f = z11;
        this.f58607k = new byte[0];
        this.f58608l = new byte[0];
        if (!f58595w.contains(Integer.valueOf(i11))) {
            throw new ProtocolError("Bad opcode");
        }
        if (!f58596x.contains(Integer.valueOf(this.f58603g)) && !this.f58600d) {
            throw new ProtocolError("Expected non-final packet");
        }
        this.f58599c = 1;
    }

    public byte[] G(String str) {
        return p(9, str, -1);
    }

    public abstract void H(Exception exc);

    public final void I() {
        this.f58606j = 0;
        this.f58610n.reset();
    }

    public abstract void J(byte[] bArr);

    public void K(boolean z11) {
        this.f58598b = z11;
    }

    public void L(boolean z11) {
        this.f58597a = z11;
    }

    public final byte[] M(byte[] bArr, int i11) {
        byte[] bArr2 = new byte[bArr.length - i11];
        System.arraycopy(bArr, i11, bArr2, 0, bArr.length - i11);
        return bArr2;
    }

    public void finalize() throws Throwable {
        Inflater inflater = this.f58611o;
        if (inflater != null) {
            try {
                inflater.end();
            } catch (Exception e11) {
                Log.e("HybiParser", "inflater.end failed", e11);
            }
        }
        super.finalize();
    }

    public final byte[] m(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e11) {
            throw new RuntimeException(e11);
        }
    }

    public final void n() throws IOException {
        int i11 = 0;
        byte[] bArrW = w(this.f58608l, this.f58607k, 0);
        if (this.f58602f) {
            try {
                bArrW = v(bArrW);
            } catch (DataFormatException unused) {
                throw new IOException("Invalid deflated data");
            }
        }
        int i12 = this.f58603g;
        if (i12 == 0) {
            if (this.f58606j == 0) {
                throw new ProtocolError("Mode was not set.");
            }
            this.f58610n.write(bArrW);
            if (this.f58600d) {
                byte[] byteArray = this.f58610n.toByteArray();
                if (this.f58606j == 1) {
                    y(o(byteArray));
                } else {
                    z(byteArray);
                }
                I();
                return;
            }
            return;
        }
        if (i12 == 1) {
            if (this.f58600d) {
                y(o(bArrW));
                return;
            } else {
                this.f58606j = 1;
                this.f58610n.write(bArrW);
                return;
            }
        }
        if (i12 == 2) {
            if (this.f58600d) {
                z(bArrW);
                return;
            } else {
                this.f58606j = 2;
                this.f58610n.write(bArrW);
                return;
            }
        }
        if (i12 == 8) {
            if (bArrW.length >= 2) {
                i11 = (bArrW[1] & 255) + ((bArrW[0] & 255) * 256);
            }
            x(i11, bArrW.length > 2 ? o(M(bArrW, 2)) : null);
        } else if (i12 != 9) {
            if (i12 == 10) {
                B(o(bArrW));
            }
        } else {
            if (bArrW.length > 125) {
                throw new ProtocolError("Ping payload too large");
            }
            String strO = o(bArrW);
            J(q(10, bArrW, -1));
            A(strO);
        }
    }

    public final String o(byte[] bArr) {
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e11) {
            throw new RuntimeException(e11);
        }
    }

    public final byte[] p(int i11, String str, int i12) {
        return q(i11, m(str), i12);
    }

    public final byte[] q(int i11, byte[] bArr, int i12) {
        return r(i11, bArr, i12, 0, bArr.length);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:35:0x00dd  */
    public final byte[] r(int i11, byte[] bArr, int i12, int i13, int i14) {
        int i15;
        if (this.f58609m) {
            return null;
        }
        int i16 = i12 > 0 ? 2 : 0;
        int i17 = (i14 + i16) - i13;
        if (i17 <= 125) {
            i15 = 2;
        } else {
            i15 = i17 <= 65535 ? 4 : 10;
        }
        boolean z11 = this.f58597a;
        int i18 = (z11 ? 4 : 0) + i15;
        int i19 = z11 ? 128 : 0;
        byte[] bArr2 = new byte[i17 + i18];
        bArr2[0] = (byte) (((byte) i11) | (-128));
        if (i17 > 125) {
            if (i17 <= 65535) {
                bArr2[1] = (byte) (i19 | WebSocketProtocol.PAYLOAD_SHORT);
                bArr2[2] = (byte) (i17 / 256);
                bArr2[3] = (byte) (i17 & 255);
            } else {
                bArr2[1] = (byte) (i19 | 127);
                long j11 = i17;
                bArr2[2] = (byte) ((j11 / 72057594037927936L) & 255);
                bArr2[3] = (byte) ((j11 / 281474976710656L) & 255);
                bArr2[4] = (byte) ((j11 / 1099511627776L) & 255);
                bArr2[5] = (byte) ((j11 / 4294967296L) & 255);
                bArr2[6] = (byte) ((j11 / 16777216) & 255);
                bArr2[7] = (byte) ((j11 / PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) & 255);
                bArr2[8] = (byte) ((j11 / 256) & 255);
                bArr2[9] = (byte) (i17 & 255);
            }
            if (i12 > 0) {
                bArr2[i18] = (byte) ((i12 / 256) & 255);
                bArr2[i18 + 1] = (byte) (i12 & 255);
            }
            System.arraycopy(bArr, i13, bArr2, i18 + i16, i14 - i13);
            if (this.f58597a) {
                byte[] bArr3 = {(byte) Math.floor(Math.random() * 256.0d), (byte) Math.floor(Math.random() * 256.0d), (byte) Math.floor(Math.random() * 256.0d), (byte) Math.floor(Math.random() * 256.0d)};
                System.arraycopy(bArr3, 0, bArr2, i15, 4);
                w(bArr2, bArr3, i18);
            }
            return bArr2;
        }
        bArr2[1] = (byte) (i17 | i19);
        if (i12 > 0) {
            bArr2[i18] = (byte) ((i12 / 256) & 255);
            bArr2[i18 + 1] = (byte) (i12 & 255);
        }
        System.arraycopy(bArr, i13, bArr2, i18 + i16, i14 - i13);
        if (this.f58597a) {
            byte[] bArr4 = {(byte) Math.floor(Math.random() * 256.0d), (byte) Math.floor(Math.random() * 256.0d), (byte) Math.floor(Math.random() * 256.0d), (byte) Math.floor(Math.random() * 256.0d)};
            System.arraycopy(bArr4, 0, bArr2, i15, 4);
            w(bArr2, bArr4, i18);
        }
        return bArr2;
    }

    public byte[] s(String str) {
        return p(1, str, -1);
    }

    public byte[] t(byte[] bArr) {
        return q(2, bArr, -1);
    }

    public final int u(byte[] bArr) throws ProtocolError {
        long jL = l(bArr, 0, bArr.length);
        if (jL >= 0 && jL <= 2147483647L) {
            return (int) jL;
        }
        throw new ProtocolError("Bad integer: " + jL);
    }

    public final byte[] v(byte[] bArr) throws DataFormatException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f58611o.setInput(bArr);
        while (!this.f58611o.needsInput()) {
            byteArrayOutputStream.write(this.f58612p, 0, this.f58611o.inflate(this.f58612p));
        }
        this.f58611o.setInput(new byte[]{0, 0, -1, -1});
        while (!this.f58611o.needsInput()) {
            byteArrayOutputStream.write(this.f58612p, 0, this.f58611o.inflate(this.f58612p));
        }
        return byteArrayOutputStream.toByteArray();
    }

    public abstract void x(int i11, String str);

    public abstract void y(String str);

    public abstract void z(byte[] bArr);
}
