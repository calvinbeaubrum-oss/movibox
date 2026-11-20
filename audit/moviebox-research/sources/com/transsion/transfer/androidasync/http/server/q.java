package com.transsion.transfer.androidasync.http.server;

import com.transsion.transfer.androidasync.ByteBufferList;
import com.transsion.transfer.androidasync.v;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class q extends v {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f58810g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f58811h = 2;

    @Override // com.transsion.transfer.androidasync.v, fy.d
    public void D(com.transsion.transfer.androidasync.r rVar, ByteBufferList byteBufferList) {
        if (this.f58811h > 0) {
            ByteBuffer byteBufferT = ByteBufferList.t(this.f58810g.length);
            byteBufferT.put(this.f58810g, 0, this.f58811h);
            byteBufferT.flip();
            byteBufferList.c(byteBufferT);
            this.f58811h = 0;
        }
        int iC = byteBufferList.C();
        byte[] bArr = new byte[iC];
        byteBufferList.h(bArr);
        int i11 = 0;
        int i12 = 0;
        while (i11 < iC) {
            int i13 = this.f58811h;
            if (i13 >= 0) {
                byte b11 = bArr[i11];
                byte[] bArr2 = this.f58810g;
                if (b11 == bArr2[i13]) {
                    int i14 = i13 + 1;
                    this.f58811h = i14;
                    if (i14 == bArr2.length) {
                        this.f58811h = -1;
                    }
                } else if (i13 > 0) {
                    i11 -= i13;
                    this.f58811h = 0;
                }
            } else if (i13 == -1) {
                byte b12 = bArr[i11];
                if (b12 == 13) {
                    this.f58811h = -4;
                    int length = (i11 - i12) - this.f58810g.length;
                    if (i12 != 0 || length != 0) {
                        ByteBuffer byteBufferPut = ByteBufferList.t(length).put(bArr, i12, length);
                        byteBufferPut.flip();
                        ByteBufferList byteBufferList2 = new ByteBufferList();
                        byteBufferList2.a(byteBufferPut);
                        super.D(this, byteBufferList2);
                    }
                    R();
                } else {
                    if (b12 != 45) {
                        L(new MimeEncodingException("Invalid multipart/form-data. Expected \r or -"));
                        return;
                    }
                    this.f58811h = -2;
                }
            } else if (i13 == -2) {
                if (bArr[i11] != 45) {
                    L(new MimeEncodingException("Invalid multipart/form-data. Expected -"));
                    return;
                }
                this.f58811h = -3;
            } else if (i13 == -3) {
                if (bArr[i11] != 13) {
                    L(new MimeEncodingException("Invalid multipart/form-data. Expected \r"));
                    return;
                }
                this.f58811h = -4;
                int i15 = i11 - i12;
                ByteBuffer byteBufferPut2 = ByteBufferList.t((i15 - this.f58810g.length) - 2).put(bArr, i12, (i15 - this.f58810g.length) - 2);
                byteBufferPut2.flip();
                ByteBufferList byteBufferList3 = new ByteBufferList();
                byteBufferList3.a(byteBufferPut2);
                super.D(this, byteBufferList3);
                Q();
            } else if (i13 != -4) {
                L(new MimeEncodingException("Invalid multipart/form-data. Unknown state?"));
            } else if (bArr[i11] == 10) {
                i12 = i11 + 1;
                this.f58811h = 0;
            } else {
                L(new MimeEncodingException("Invalid multipart/form-data. Expected \n"));
            }
            i11++;
        }
        if (i12 < iC) {
            int iMax = (iC - i12) - Math.max(this.f58811h, 0);
            ByteBuffer byteBufferPut3 = ByteBufferList.t(iMax).put(bArr, i12, iMax);
            byteBufferPut3.flip();
            ByteBufferList byteBufferList4 = new ByteBufferList();
            byteBufferList4.a(byteBufferPut3);
            super.D(this, byteBufferList4);
        }
    }

    public String N() {
        byte[] bArr = this.f58810g;
        if (bArr == null) {
            return null;
        }
        return new String(bArr, 4, bArr.length - 4);
    }

    public String O() {
        return P() + "--\r\n";
    }

    public String P() {
        byte[] bArr = this.f58810g;
        return new String(bArr, 2, bArr.length - 2);
    }

    public void Q() {
    }

    public void R() {
        throw null;
    }

    public void S(String str) {
        this.f58810g = ("\r\n--" + str).getBytes();
    }
}
