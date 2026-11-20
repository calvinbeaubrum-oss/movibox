package com.transsion.transfer.androidasync.http.filter;

import com.transsion.transfer.androidasync.ByteBufferList;
import com.transsion.transfer.androidasync.c0;
import com.transsion.transfer.androidasync.r;
import com.transsion.transfer.androidasync.v;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class ChunkedInputFilter extends v {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f58655g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f58656h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public State f58657i = State.CHUNK_LEN;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ByteBufferList f58658j = new ByteBufferList();

    /* JADX INFO: compiled from: source.java */
    public enum State {
        CHUNK_LEN,
        CHUNK_LEN_CR,
        CHUNK_LEN_CRLF,
        CHUNK,
        CHUNK_CR,
        CHUNK_CRLF,
        COMPLETE,
        ERROR
    }

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f58659a;

        static {
            int[] iArr = new int[State.values().length];
            f58659a = iArr;
            try {
                iArr[State.CHUNK_LEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f58659a[State.CHUNK_LEN_CR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f58659a[State.CHUNK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f58659a[State.CHUNK_CR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f58659a[State.CHUNK_CRLF.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f58659a[State.COMPLETE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    @Override // com.transsion.transfer.androidasync.v, fy.d
    public void D(r rVar, ByteBufferList byteBufferList) {
        if (this.f58657i == State.ERROR) {
            byteBufferList.B();
            return;
        }
        while (byteBufferList.C() > 0) {
            try {
                switch (a.f58659a[this.f58657i.ordinal()]) {
                    case 1:
                        char cM = byteBufferList.m();
                        if (cM == '\r') {
                            this.f58657i = State.CHUNK_LEN_CR;
                        } else {
                            int i11 = this.f58655g * 16;
                            this.f58655g = i11;
                            if (cM >= 'a' && cM <= 'f') {
                                this.f58655g = i11 + (cM - 'W');
                            } else if (cM >= '0' && cM <= '9') {
                                this.f58655g = i11 + (cM - '0');
                            } else {
                                if (cM < 'A' || cM > 'F') {
                                    L(new ChunkedDataException("invalid chunk length: " + cM));
                                    return;
                                }
                                this.f58655g = i11 + (cM - '7');
                            }
                        }
                        this.f58656h = this.f58655g;
                        continue;
                    case 2:
                        if (P(byteBufferList.m())) {
                            this.f58657i = State.CHUNK;
                            continue;
                        } else {
                            return;
                        }
                        break;
                    case 3:
                        int iMin = Math.min(this.f58656h, byteBufferList.C());
                        int i12 = this.f58656h - iMin;
                        this.f58656h = i12;
                        if (i12 == 0) {
                            this.f58657i = State.CHUNK_CR;
                        }
                        if (iMin != 0) {
                            byteBufferList.g(this.f58658j, iMin);
                            c0.a(this, this.f58658j);
                            continue;
                        }
                        break;
                    case 4:
                        if (O(byteBufferList.m())) {
                            this.f58657i = State.CHUNK_CRLF;
                            continue;
                        } else {
                            return;
                        }
                        break;
                    case 5:
                        if (P(byteBufferList.m())) {
                            if (this.f58655g > 0) {
                                this.f58657i = State.CHUNK_LEN;
                            } else {
                                this.f58657i = State.COMPLETE;
                                L(null);
                            }
                            this.f58655g = 0;
                            continue;
                        } else {
                            return;
                        }
                        break;
                    case 6:
                        return;
                    default:
                        continue;
                }
            } catch (Exception e11) {
                L(e11);
                return;
            }
            L(e11);
            return;
        }
    }

    @Override // com.transsion.transfer.androidasync.s
    public void L(Exception exc) {
        if (exc == null && this.f58657i != State.COMPLETE) {
            exc = new ChunkedDataException("chunked input ended before final chunk");
        }
        super.L(exc);
    }

    public final boolean N(char c11, char c12) {
        if (c11 == c12) {
            return true;
        }
        this.f58657i = State.ERROR;
        L(new ChunkedDataException(c12 + " was expected, got " + c11));
        return false;
    }

    public final boolean O(char c11) {
        return N(c11, '\r');
    }

    public final boolean P(char c11) {
        return N(c11, '\n');
    }
}
