package com.facebook.ads.redexgen.uinode;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import com.facebook.ads.internal.exoplayer2.thirdparty.drm.FrameworkMediaCrypto;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import okio.Utf8;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6j, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC11066j extends EM {
    public static byte[] A0d;
    public static String[] A0e = {"el1NIdjJdnQk8rQ7yI3DLJMJGUNGpsaL", "cMnDkAErKs2M6cVzDcwdPqTaRDuVL2G6", "3Ljz1yFix4teFI07gFBJ1ZVJZ4Elk", "rfweshkfyu7YGNu9gmTN5aJbUxr0jD44", "UwDJ5OwzyxxJZbvw2og9SG", "E", "kELoxR7DFwuexd5ZjpenISH", "LMGopoJZLCWwOw1IQPtLBjMdbqq8sxxW"};
    public static final byte[] A0f;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public long A05;
    public MediaCodec A06;
    public Format A07;
    public InterfaceC1216Bb<FrameworkMediaCrypto> A08;
    public InterfaceC1216Bb<FrameworkMediaCrypto> A09;
    public DG A0A;
    public ByteBuffer A0B;
    public boolean A0C;
    public boolean A0D;
    public boolean A0E;
    public boolean A0F;
    public boolean A0G;
    public boolean A0H;
    public boolean A0I;
    public boolean A0J;
    public boolean A0K;
    public boolean A0L;
    public boolean A0M;
    public boolean A0N;
    public boolean A0O;
    public boolean A0P;
    public boolean A0Q;
    public boolean A0R;
    public ByteBuffer[] A0S;
    public ByteBuffer[] A0T;
    public BC A0U;
    public final MediaCodec.BufferInfo A0V;
    public final C11789p A0W;
    public final C1773Xr A0X;
    public final C1773Xr A0Y;
    public final InterfaceC1217Bc<FrameworkMediaCrypto> A0Z;
    public final DM A0a;
    public final List<Long> A0b;
    public final boolean A0c;

    static {
        A0j();
        A0f = IF.A0h(A0Z(59, 76, 99));
    }

    public AbstractC11066j(int i11, DM dm2, InterfaceC1217Bc<FrameworkMediaCrypto> interfaceC1217Bc, boolean z11) {
        super(i11);
        AbstractC1351Ha.A04(IF.A02 >= 16);
        this.A0a = (DM) AbstractC1351Ha.A01(dm2);
        this.A0Z = interfaceC1217Bc;
        this.A0c = z11;
        this.A0X = new C1773Xr(0);
        this.A0Y = C1773Xr.A02();
        this.A0W = new C11789p();
        this.A0b = new ArrayList();
        this.A0V = new MediaCodec.BufferInfo();
        this.A01 = 0;
        this.A02 = 0;
    }

    private int A0W(String str) {
        if (IF.A02 <= 25 && A0Z(255, 25, 86).equals(str) && (IF.A06.startsWith(A0Z(617, 7, 3)) || IF.A06.startsWith(A0Z(589, 7, 41)) || IF.A06.startsWith(A0Z(596, 7, 80)) || IF.A06.startsWith(A0Z(610, 7, 97)))) {
            return 2;
        }
        if (IF.A02 >= 24) {
            return 0;
        }
        if (!A0Z(330, 22, 82).equals(str) && !A0Z(352, 29, 73).equals(str)) {
            return 0;
        }
        if (A0Z(689, 8, 65).equals(IF.A03)) {
            return 1;
        }
        if (A0Z(697, 12, 102).equals(IF.A03)) {
            return 1;
        }
        if (A0Z(731, 7, 17).equals(IF.A03)) {
            return 1;
        }
        return A0Z(774, 7, 37).equals(IF.A03) ? 1 : 0;
    }

    private final long A0X() {
        return 0L;
    }

    public static MediaCodec.CryptoInfo A0Y(C1773Xr c1773Xr, int i11) {
        MediaCodec.CryptoInfo cryptoInfoA02 = c1773Xr.A02.A02();
        if (i11 == 0) {
            return cryptoInfoA02;
        }
        if (cryptoInfoA02.numBytesOfClearData == null) {
            cryptoInfoA02.numBytesOfClearData = new int[1];
        }
        int[] iArr = cryptoInfoA02.numBytesOfClearData;
        int i12 = iArr[0];
        if (A0e[2].length() == 1) {
            throw new RuntimeException();
        }
        String[] strArr = A0e;
        strArr[7] = "NOzrMPRB76F8DdbUb3OPVPb4rTNpEGvY";
        strArr[3] = "IDmZDsJhwqXuUzopfYWLVElAjmr2DtdU";
        iArr[0] = i12 + i11;
        return cryptoInfoA02;
    }

    public static String A0Z(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0d, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            int i15 = (bArrCopyOfRange[i14] ^ i13) ^ 57;
            if (A0e[5].length() == 20) {
                throw new RuntimeException();
            }
            A0e[0] = "GT4OiQXgMfCUtJ1QRZ1mZZkQ0KPtv7dD";
            bArrCopyOfRange[i14] = (byte) i15;
        }
        return new String(bArrCopyOfRange);
    }

    private ByteBuffer A0a(int i11) {
        if (IF.A02 >= 21) {
            return this.A06.getInputBuffer(i11);
        }
        ByteBuffer byteBuffer = this.A0S[i11];
        String[] strArr = A0e;
        if (strArr[4].length() == strArr[6].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0e;
        strArr2[7] = "akmimywpCQzy2zgGqC6e1Zi0HtFx9MqZ";
        strArr2[3] = "4g16x1WFaX1F1Ai56lyJAgpz1Kjl0dDQ";
        return byteBuffer;
    }

    private ByteBuffer A0b(int i11) {
        return IF.A02 >= 21 ? this.A06.getOutputBuffer(i11) : this.A0T[i11];
    }

    private void A0c() {
        if (IF.A02 < 21) {
            this.A0S = this.A06.getInputBuffers();
            MediaCodec mediaCodec = this.A06;
            if (A0e[5].length() == 20) {
                throw new RuntimeException();
            }
            A0e[2] = "BQUwUvW99pDNY9ExELsrhPAvhUrne6";
            this.A0T = mediaCodec.getOutputBuffers();
        }
    }

    private void A0d() throws C11669c {
        if (this.A02 == 2) {
            A1H();
            A1J();
        } else {
            this.A0N = true;
            A1I();
        }
    }

    private void A0e() {
        if (IF.A02 < 21) {
            this.A0T = this.A06.getOutputBuffers();
        }
    }

    private void A0f() throws C11669c {
        MediaFormat outputFormat = this.A06.getOutputFormat();
        if (this.A00 != 0 && outputFormat.getInteger(A0Z(781, 5, 7)) == 32 && outputFormat.getInteger(A0Z(744, 6, 55)) == 32) {
            this.A0O = true;
            return;
        }
        if (this.A0I) {
            outputFormat.setInteger(A0Z(638, 13, 38), 1);
        }
        A1L(this.A06, outputFormat);
    }

    private void A0g() {
        if (IF.A02 < 21) {
            this.A0S = null;
            this.A0T = null;
        }
    }

    private void A0h() {
        this.A03 = -1;
        this.A0X.A01 = null;
    }

    private void A0i() {
        this.A04 = -1;
        this.A0B = null;
    }

    public static void A0j() {
        A0d = new byte[]{85, 89, Ascii.ESC, Ascii.FF, Ascii.CR, 89, Ascii.ETB, Ascii.SYN, 89, 10, Ascii.FS, Ascii.SUB, Ascii.FF, Ascii.VT, Ascii.FS, 89, Ascii.GS, Ascii.FS, Ascii.SUB, Ascii.SYN, Ascii.GS, Ascii.FS, Ascii.VT, 89, Ascii.CAN, Ascii.SI, Ascii.CAN, Ascii.DLE, Ascii.NAK, Ascii.CAN, Ascii.ESC, Ascii.NAK, Ascii.FS, 87, 89, 45, Ascii.VT, 0, Ascii.DLE, Ascii.ETB, Ascii.RS, 89, Ascii.CR, Ascii.SYN, 89, 9, Ascii.VT, Ascii.SYN, Ascii.SUB, Ascii.FS, Ascii.FS, Ascii.GS, 89, Ascii.SO, Ascii.DLE, Ascii.CR, 17, 89, 19, 106, 106, 106, 106, 106, 107, 108, 109, 110, 104, Ascii.EM, 106, 106, Ascii.CAN, Ascii.RS, Ascii.ESC, 104, 111, 99, 106, 106, 106, 106, 106, 106, 107, 108, 98, Ascii.EM, Ascii.US, 106, Ascii.FS, 107, 105, 104, 106, 106, 106, 106, 106, 106, 107, 108, 111, 98, 98, 98, 110, 106, Ascii.RS, Ascii.EM, Ascii.US, 109, 107, 107, 98, Ascii.ESC, 106, 106, 106, 104, Ascii.FS, Ascii.CAN, Ascii.FS, 107, Ascii.EM, 105, 107, Ascii.EM, 105, 104, 109, 111, Ascii.RS, 109, 98, 107, 108, 126, 121, 3, 47, 35, 56, 45, 44, 93, 107, 116, 57, 106, 124, 106, 106, 112, 118, 119, 57, 107, 124, 104, 108, 112, 107, 124, 106, 57, 106, 124, 122, 108, 107, 124, 57, 125, 124, 122, 118, 125, 124, 107, 57, Ascii.DEL, 118, 107, 57, Ascii.ESC, 51, 50, Utf8.REPLACEMENT_BYTE, 55, 118, 36, 51, 39, 35, Utf8.REPLACEMENT_BYTE, 36, 51, 37, 118, 55, 118, Ascii.DC2, 36, 59, 5, 51, 37, 37, Utf8.REPLACEMENT_BYTE, 57, 56, Ascii.ESC, 55, 56, 55, 49, 51, 36, 9, 33, 32, 45, 37, 7, 43, 32, 33, 39, Ascii.SYN, 33, 42, 32, 33, 54, 33, 54, 69, 71, 82, 36, 79, 114, 115, 100, 101, 121, 36, 107, 124, 105, 36, 110, 111, 105, 32, 34, 55, 65, 42, Ascii.ETB, Ascii.SYN, 1, 0, Ascii.FS, 65, Ascii.SO, Ascii.EM, Ascii.FF, 65, Ascii.VT, 10, Ascii.FF, 65, Ascii.FS, 10, Ascii.FF, Ascii.SUB, Ascii.GS, 10, 42, 40, 61, 75, 40, 49, 46, 75, 36, 48, 33, 44, 42, 75, 33, 32, 38, 42, 33, 32, 55, 75, 40, 53, 86, 80, 82, 71, 49, 82, 75, 84, 49, 73, 86, 91, 90, 80, 49, 91, 90, 92, 80, 91, 90, 77, 49, 94, 73, 92, 36, 38, 51, 69, 37, Ascii.GS, 2, Ascii.SI, 2, 10, 69, 3, 89, 93, 95, 69, Ascii.SI, Ascii.SO, 8, 4, Ascii.SI, Ascii.SO, Utf8.REPLACEMENT_BYTE, 61, 40, 94, 62, 6, Ascii.EM, Ascii.DC4, Ascii.EM, 17, 94, Ascii.CAN, 66, 70, 68, 94, Ascii.DC4, Ascii.NAK, 19, Ascii.US, Ascii.DC4, Ascii.NAK, 94, 3, Ascii.NAK, 19, 5, 2, Ascii.NAK, Ascii.SO, Ascii.FF, Ascii.EM, 111, Ascii.DC2, 4, 2, 111, 32, 55, 34, 111, 37, 36, 34, 4, 6, 19, 101, Ascii.CAN, Ascii.SO, 8, 101, 42, 61, 40, 101, 47, 46, 40, 101, 56, 46, 40, 62, 57, 46, 4, 6, 19, 101, 42, 39, 39, 60, 34, 37, 37, 46, 57, 101, 61, 34, 47, 46, 36, 101, 47, 46, 40, 36, 47, 46, 57, 101, 42, 61, 40, 75, 73, 92, 42, 101, 105, 104, 107, 99, 109, 103, 42, 101, 114, 103, 42, 96, 97, 103, 107, 96, 97, 118, 42, 101, 115, 97, 119, 107, 105, 97, 110, 108, 121, Ascii.SI, 64, 76, 77, 78, 70, 72, 66, Ascii.SI, 64, 87, 66, Ascii.SI, 69, 68, 66, 78, 69, 68, 83, Ascii.SI, 64, 86, 68, 82, 78, 76, 68, Ascii.SI, 82, 68, 66, 84, 83, 68, 87, 85, 64, 54, Ascii.DEL, 119, 119, Ascii.DEL, 116, 125, 54, 121, 121, 123, 54, 124, 125, 123, 119, 124, 125, 106, 114, 112, 101, 19, 90, 82, 82, 90, 81, 88, 19, 75, 82, 79, 95, 84, 78, 19, 89, 88, 94, 82, 89, 88, 79, 123, 121, 108, Ascii.SUB, 70, 95, Ascii.SUB, 66, 93, 80, 81, 91, 107, 80, 81, 87, 91, 80, 81, 70, Ascii.SUB, 85, 66, 87, 67, 93, 61, 81, 37, 33, 32, 58, 36, 68, 40, 92, 91, 89, 57, 39, 71, 45, 82, 90, 90, Ascii.VT, Ascii.NAK, 117, Ascii.DC2, 111, 104, 104, 105, 119, Ascii.ETB, 110, Ascii.SI, 2, Ascii.SI, 104, 106, 120, 124, 96, 123, 108, 90, 108, 122, 122, 96, 102, 103, 124, 119, 126, 113, 113, 122, 115, 50, 124, 112, 106, 113, 107, Ascii.VT, 7, 6, Ascii.SO, 1, Ascii.SI, Ascii.GS, Ascii.SUB, Ascii.CR, 43, 7, Ascii.FF, Ascii.CR, Ascii.VT, 4, Ascii.NAK, 2, 6, 19, 2, 36, 8, 3, 2, 4, 93, 122, 108, Ascii.DEL, 119, 112, 95, 112, 122, 88, 123, 123, 122, Ascii.RS, Ascii.DC4, Ascii.ETB, Ascii.CR, Ascii.SYN, Ascii.FS, Ascii.GS, 10, 57, 51, 48, 42, 49, 59, 58, 45, 0, 51, 43, 58, 107, 105, 120, 65, 105, 104, 101, 109, 79, 126, 117, 124, 120, 99, 1, 3, Ascii.DC2, 53, Ascii.DC2, 7, Ascii.DC2, 3, 79, 90, 71, 93, 88, 77, 90, 62, 52, 100, 102, 102, 102, 102, 107, 103, 105, 102, 122, 68, 83, 90, 83, 87, 69, 83, 101, 83, 69, 69, 95, 89, 88, 55, 48, 37, 54, 48, 7, 43, 32, 33, 39, 104, 117, 112, 125, 108, 117, 125, 73, 87, 90, 74, 86};
    }

    private void A0k(DI di2) throws C11669c {
        throw C11669c.A01(di2, A0z());
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x0139, code lost:
    
        if (r6 == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x013b, code lost:
    
        A0d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x013e, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0146, code lost:
    
        if (r6 == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x014b, code lost:
    
        if (r13.A0G == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x014e, code lost:
    
        r13.A0K = true;
        r13.A06.queueInputBuffer(r13.A03, 0, 0, 0, 4);
        A0h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x015f, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0160, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0169, code lost:
    
        throw com.facebook.ads.redexgen.uinode.C11669c.A01(r1, A0z());
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x018a, code lost:
    
        if (r8.A05() == false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x018c, code lost:
    
        r13.A0X.A07();
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0193, code lost:
    
        if (r13.A01 != 2) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0195, code lost:
    
        r13.A01 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0197, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01a8, code lost:
    
        if (r8.A05() == false) goto L81;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean A0l() throws C11669c {
        int iA11;
        MediaCodec mediaCodec = this.A06;
        if (mediaCodec == null || this.A02 == 2 || this.A0M) {
            return false;
        }
        if (this.A03 < 0) {
            int iDequeueInputBuffer = mediaCodec.dequeueInputBuffer(0L);
            this.A03 = iDequeueInputBuffer;
            if (iDequeueInputBuffer < 0) {
                return false;
            }
            this.A0X.A01 = A0a(iDequeueInputBuffer);
            this.A0X.A07();
        }
        int i11 = this.A02;
        if (A0e[2].length() == 1) {
            throw new RuntimeException();
        }
        A0e[0] = "BGv06lkWwG6z0hSmECPMwAj0xiUhKKMm";
        if (i11 == 1) {
            if (!this.A0G) {
                this.A0K = true;
                this.A06.queueInputBuffer(this.A03, 0, 0, 0L, 4);
                A0h();
            }
            this.A02 = 2;
            return false;
        }
        if (this.A0C) {
            this.A0C = false;
            ByteBuffer byteBuffer = this.A0X.A01;
            byte[] bArr = A0f;
            byteBuffer.put(bArr);
            this.A06.queueInputBuffer(this.A03, 0, bArr.length, 0L, 0);
            A0h();
            this.A0J = true;
            return true;
        }
        int iPosition = 0;
        if (this.A0R) {
            iA11 = -4;
            if (A0e[2].length() == 1) {
                throw new RuntimeException();
            }
            A0e[0] = "cWcFMDoxN8Aku4bywP95fMqNRICNv17K";
        } else {
            if (this.A01 == 1) {
                for (int i12 = 0; i12 < this.A07.A0P.size(); i12++) {
                    this.A0X.A01.put(this.A07.A0P.get(i12));
                }
                this.A01 = 2;
            }
            iPosition = this.A0X.A01.position();
            C11789p c11789p = this.A0W;
            if (A0e[5].length() != 20) {
                String[] strArr = A0e;
                strArr[7] = "GMhmsEJxFGP4UGYwyrNMJ7ABPSyH92Wb";
                strArr[3] = "9vGc1NAfm636mRfTzlbxXXygjN4bGT7w";
                iA11 = A11(c11789p, this.A0X, false);
            } else {
                String[] strArr2 = A0e;
                strArr2[4] = "jZbWd1eO6yZY8R9xWwlVER";
                strArr2[6] = "QWk96bCMj56V6fYDRZTqXno";
                iA11 = A11(c11789p, this.A0X, false);
            }
        }
        if (iA11 == -3) {
            return false;
        }
        if (iA11 == -5) {
            if (this.A01 == 2) {
                this.A0X.A07();
                this.A01 = 1;
            }
            A1M(this.A0W.A00);
            return true;
        }
        if (!this.A0X.A04()) {
            if (this.A0Q) {
                C1773Xr c1773Xr = this.A0X;
                if (A0e[0].charAt(8) != 's') {
                    A0e[0] = "ywBWkcBFyHyOTxmikBGNQ7ElC4JSn47y";
                } else {
                    String[] strArr3 = A0e;
                    strArr3[7] = "uqwAh7OiLzrqYCdIK7FE27Aq9dnmjoOb";
                    strArr3[3] = "CGhJEeUUTBGplB6hh3d6N38sXeZGKtI8";
                }
            }
            this.A0Q = false;
            boolean zA0A = this.A0X.A0A();
            boolean zA0v = A0v(zA0A);
            this.A0R = zA0v;
            if (zA0v) {
                return false;
            }
            if (this.A0D && !zA0A) {
                AbstractC1372Hv.A0A(this.A0X.A01);
                if (this.A0X.A01.position() == 0) {
                    return true;
                }
                this.A0D = false;
            }
            try {
                long j11 = this.A0X.A00;
                if (this.A0X.A03()) {
                    this.A0b.add(Long.valueOf(j11));
                }
                this.A0X.A08();
                A1N(this.A0X);
                if (zA0A) {
                    this.A06.queueSecureInputBuffer(this.A03, 0, A0Y(this.A0X, iPosition), j11, 0);
                } else {
                    this.A06.queueInputBuffer(this.A03, 0, this.A0X.A01.limit(), j11, 0);
                }
                A0h();
                this.A0J = true;
                this.A01 = 0;
                this.A0U.A04++;
                return true;
            } catch (MediaCodec.CryptoException e11) {
                throw C11669c.A01(e11, A0z());
            }
        }
        if (this.A01 == 2) {
            this.A0X.A07();
            this.A01 = 1;
        }
        this.A0M = true;
        boolean z11 = this.A0J;
        if (A0e[1].charAt(18) == 'w') {
            A0e[5] = "IK13ew4";
        }
    }

    private boolean A0m() {
        return this.A04 >= 0;
    }

    private boolean A0n(long j11) {
        int size = this.A0b.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (this.A0b.get(i11).longValue() == j11) {
                this.A0b.remove(i11);
                if (A0e[1].charAt(18) != 'w') {
                    throw new RuntimeException();
                }
                A0e[5] = "GAQPkPxILqrNxqRn";
                return true;
            }
        }
        return false;
    }

    private boolean A0o(long j11, long j12) throws C11669c {
        boolean zA1Q;
        int iDequeueOutputBuffer;
        if (!A0m()) {
            if (this.A0F && this.A0K) {
                try {
                    iDequeueOutputBuffer = this.A06.dequeueOutputBuffer(this.A0V, A0X());
                } catch (IllegalStateException unused) {
                    A0d();
                    if (this.A0N) {
                        A1H();
                    }
                    return false;
                }
            } else {
                iDequeueOutputBuffer = this.A06.dequeueOutputBuffer(this.A0V, A0X());
            }
            if (iDequeueOutputBuffer >= 0) {
                if (this.A0O) {
                    this.A0O = false;
                    this.A06.releaseOutputBuffer(iDequeueOutputBuffer, false);
                    return true;
                }
                if (this.A0V.size == 0 && (this.A0V.flags & 4) != 0) {
                    A0d();
                    return false;
                }
                this.A04 = iDequeueOutputBuffer;
                ByteBuffer byteBufferA0b = A0b(iDequeueOutputBuffer);
                this.A0B = byteBufferA0b;
                if (byteBufferA0b != null) {
                    byteBufferA0b.position(this.A0V.offset);
                    ByteBuffer byteBuffer = this.A0B;
                    int i11 = this.A0V.offset + this.A0V.size;
                    if (A0e[2].length() != 1) {
                        String[] strArr = A0e;
                        strArr[4] = "FaJE2XiArfhYqeNyfkTyaQ";
                        strArr[6] = "HvmGKe0EFE5f200jghUPQNW";
                        byteBuffer.limit(i11);
                    }
                }
                this.A0P = A0n(this.A0V.presentationTimeUs);
            } else if (A0e[5].length() != 20) {
                A0e[1] = "HT1pBWWLOYy8PEf8scwcSavywhmMK5P3";
                if (iDequeueOutputBuffer == -2) {
                    A0f();
                    String[] strArr2 = A0e;
                    if (strArr2[4].length() == strArr2[6].length()) {
                        return true;
                    }
                    A0e[5] = "todLl0dSZi0vPTtgICo1ottwNzErViL";
                    return true;
                }
                if (A0e[0].charAt(8) == 's') {
                    throw new RuntimeException();
                }
                A0e[5] = "4PVEqwR";
                if (iDequeueOutputBuffer == -3) {
                    A0e();
                    return true;
                }
                boolean z11 = this.A0G;
                if (A0e[0].charAt(8) == 's') {
                    throw new RuntimeException();
                }
                A0e[1] = "oPTnjsm2EBoNSW7B2QwBvulptlCCgQiW";
                if (z11 && (this.A0M || this.A02 == 2)) {
                    A0d();
                }
                return false;
            }
            throw new RuntimeException();
        }
        if (this.A0F && this.A0K) {
            try {
                zA1Q = A1Q(j11, j12, this.A06, this.A0B, this.A04, this.A0V.flags, this.A0V.presentationTimeUs, this.A0P);
            } catch (IllegalStateException unused2) {
                A0d();
                if (this.A0N) {
                    A1H();
                }
                return false;
            }
        } else {
            zA1Q = A1Q(j11, j12, this.A06, this.A0B, this.A04, this.A0V.flags, this.A0V.presentationTimeUs, this.A0P);
        }
        if (zA1Q) {
            A1K(this.A0V.presentationTimeUs);
            boolean z12 = (this.A0V.flags & 4) != 0;
            A0i();
            if (!z12) {
                return true;
            }
            A0d();
        }
        return false;
    }

    public static boolean A0p(DG dg2) {
        String str = dg2.A02;
        if (IF.A02 > 17 || (!A0Z(565, 24, 13).equals(str) && !A0Z(418, 31, 114).equals(str))) {
            if (A0Z(139, 6, 123).equals(IF.A05)) {
                String strA0Z = A0Z(TsExtractor.TS_STREAM_TYPE_E_AC3, 4, 19);
                if (A0e[5].length() == 20) {
                    throw new RuntimeException();
                }
                String[] strArr = A0e;
                strArr[4] = "ta8dfTbq5GbSxrQo9R7BCH";
                strArr[6] = "TLzt7USKw6C8aMs6TrECz9n";
                if (!strA0Z.equals(IF.A06) || !dg2.A05) {
                }
            }
            return false;
        }
        return true;
    }

    public static boolean A0q(String str) {
        if (IF.A02 > 23 || !A0Z(540, 25, 4).equals(str)) {
            if (IF.A02 <= 19) {
                if (!A0Z(738, 6, 111).equals(IF.A03) || (!A0Z(449, 31, 61).equals(str) && !A0Z(480, 38, 24).equals(str))) {
                }
            }
            return false;
        }
        return true;
    }

    public static boolean A0r(String str) {
        return IF.A02 == 21 && A0Z(518, 22, 33).equals(str);
    }

    public static boolean A0s(String str) {
        return IF.A02 < 18 || (IF.A02 == 18 && (A0Z(381, 15, 120).equals(str) || A0Z(396, 22, 114).equals(str))) || (IF.A02 == 19 && IF.A06.startsWith(A0Z(603, 7, 83)) && (A0Z(237, 18, 51).equals(str) || A0Z(255, 25, 86).equals(str)));
    }

    public static boolean A0t(String str, Format format) {
        return IF.A02 < 21 && format.A0P.isEmpty() && A0Z(305, 25, 38).equals(str);
    }

    public static boolean A0u(String str, Format format) {
        return IF.A02 <= 18 && format.A05 == 1 && A0Z(280, 25, 92).equals(str);
    }

    private boolean A0v(boolean z11) throws C11669c {
        if (0 == 0 || (!z11 && this.A0c)) {
            return false;
        }
        throw new NullPointerException(A0Z(723, 8, 95));
    }

    @Override // com.facebook.ads.redexgen.uinode.EM
    public void A13() {
    }

    @Override // com.facebook.ads.redexgen.uinode.EM
    public void A14() {
    }

    @Override // com.facebook.ads.redexgen.uinode.EM
    public void A15() {
        this.A07 = null;
        try {
            A1H();
            if (0 == 0) {
                if (0 == 0 || 0 == 0) {
                    this.A08 = null;
                    this.A09 = null;
                    return;
                } else {
                    try {
                        throw new NullPointerException(A0Z(750, 14, 15));
                    } catch (Throwable th2) {
                        this.A08 = null;
                        this.A09 = null;
                        throw th2;
                    }
                }
            }
            try {
                throw new NullPointerException(A0Z(750, 14, 15));
            } catch (Throwable th3) {
                if (0 == 0 || 0 == 0) {
                    this.A08 = null;
                    this.A09 = null;
                    throw th3;
                }
                try {
                    throw new NullPointerException(A0Z(750, 14, 15));
                } catch (Throwable th4) {
                    this.A08 = null;
                    this.A09 = null;
                    throw th4;
                }
            }
        } catch (Throwable th5) {
            if (0 == 0) {
                if (0 == 0 || 0 == 0) {
                    this.A08 = null;
                    this.A09 = null;
                    throw th5;
                }
                try {
                    throw new NullPointerException(A0Z(750, 14, 15));
                } catch (Throwable th6) {
                    this.A08 = null;
                    this.A09 = null;
                    throw th6;
                }
            }
            try {
                throw new NullPointerException(A0Z(750, 14, 15));
            } catch (Throwable th7) {
                if (0 == 0 || 0 == 0) {
                    this.A08 = null;
                    this.A09 = null;
                    throw th7;
                }
                try {
                    throw new NullPointerException(A0Z(750, 14, 15));
                } catch (Throwable th8) {
                    this.A08 = null;
                    this.A09 = null;
                    throw th8;
                }
            }
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.EM
    public void A16(long j11, boolean z11) throws C11669c {
        this.A0M = false;
        this.A0N = false;
        if (this.A06 != null) {
            A1G();
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.EM
    public void A17(boolean z11) throws C11669c {
        this.A0U = new BC();
    }

    public abstract int A1B(MediaCodec mediaCodec, DG dg2, Format format, Format format2);

    public abstract int A1C(DM dm2, InterfaceC1217Bc<FrameworkMediaCrypto> interfaceC1217Bc, Format format) throws DP;

    public final MediaCodec A1D() {
        return this.A06;
    }

    public final DG A1E() {
        return this.A0A;
    }

    public DG A1F(DM dm2, Format format, boolean z11) throws DP {
        return dm2.A6m(format.A0O, z11);
    }

    public void A1G() throws C11669c {
        this.A05 = C.TIME_UNSET;
        A0h();
        A0i();
        this.A0Q = true;
        this.A0R = false;
        this.A0P = false;
        this.A0b.clear();
        this.A0C = false;
        this.A0O = false;
        if (this.A0H || ((this.A0E && this.A0K) || this.A02 != 0)) {
            A1H();
            A1J();
        } else {
            this.A06.flush();
            this.A0J = false;
        }
        if (!this.A0L || this.A07 == null) {
            return;
        }
        this.A01 = 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c8, code lost:
    
        if (0 != 0) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d2, code lost:
    
        if (0 != 0) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e3, code lost:
    
        throw new java.lang.NullPointerException(A0Z(750, 14, 15));
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00e4, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e5, code lost:
    
        r7.A08 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00e7, code lost:
    
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void A1H() {
        this.A05 = C.TIME_UNSET;
        A0h();
        A0i();
        this.A0R = false;
        this.A0P = false;
        this.A0b.clear();
        A0g();
        this.A0A = null;
        this.A0L = false;
        this.A0J = false;
        this.A0D = false;
        this.A0H = false;
        this.A00 = 0;
        this.A0G = false;
        this.A0E = false;
        this.A0I = false;
        this.A0C = false;
        this.A0O = false;
        this.A0K = false;
        this.A01 = 0;
        this.A02 = 0;
        if (this.A06 != null) {
            this.A0U.A01++;
            try {
                this.A06.stop();
                try {
                    this.A06.release();
                    this.A06 = null;
                    if (0 == 0 || 0 == 0) {
                        return;
                    }
                    try {
                        throw new NullPointerException(A0Z(750, 14, 15));
                    } catch (Throwable th2) {
                        this.A08 = null;
                        throw th2;
                    }
                } catch (Throwable th3) {
                    this.A06 = null;
                    if (0 != 0) {
                        if (A0e[1].charAt(18) != 'w') {
                            throw new RuntimeException();
                        }
                        A0e[1] = "xSjaYNEZ4qh1ZPx8xTwjTufaVWwElX5P";
                        if (0 != 0) {
                            try {
                                throw new NullPointerException(A0Z(750, 14, 15));
                            } catch (Throwable th4) {
                                this.A08 = null;
                                throw th4;
                            }
                        }
                    }
                    throw th3;
                }
            } catch (Throwable th5) {
                try {
                    this.A06.release();
                    this.A06 = null;
                    if (0 != 0) {
                        String[] strArr = A0e;
                        if (strArr[4].length() != strArr[6].length()) {
                            A0e[1] = "DpnT2etBhelIXAl4LKwzAMEbQbMU5HtS";
                        } else {
                            A0e[2] = "TXp75XLN6vD6SaWS";
                        }
                    }
                    throw th5;
                } catch (Throwable th6) {
                    this.A06 = null;
                    if (0 == 0 || 0 == 0) {
                        throw th6;
                    }
                    try {
                        throw new NullPointerException(A0Z(750, 14, 15));
                    } catch (Throwable th7) {
                        this.A08 = null;
                        throw th7;
                    }
                }
            }
        }
    }

    public void A1I() throws C11669c {
    }

    public final void A1J() throws C11669c {
        Format format;
        if (this.A06 != null || (format = this.A07) == null) {
            return;
        }
        this.A08 = null;
        String str = format.A0O;
        String[] strArr = A0e;
        if (strArr[7].charAt(15) == strArr[3].charAt(15)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0e;
        strArr2[7] = "pTVSxclXptnWdkcsOldSnbHbt080oNsP";
        strArr2[3] = "3A2dqVKC7anzB9bdQIqtLGHUlM9PHMrl";
        if (0 != 0) {
            throw new NullPointerException(A0Z(709, 14, 53));
        }
        if (this.A0A == null) {
            try {
                DG dgA1F = A1F(this.A0a, this.A07, false);
                this.A0A = dgA1F;
                if (dgA1F == null && 0 != 0) {
                    DG dgA1F2 = A1F(this.A0a, this.A07, false);
                    this.A0A = dgA1F2;
                    if (dgA1F2 != null) {
                        Log.w(A0Z(219, 18, 125), A0Z(145, 40, 32) + str + A0Z(0, 58, 64) + this.A0A.A02 + A0Z(58, 1, 4));
                    }
                }
                if (this.A0A == null) {
                    A0k(new DI(this.A07, (Throwable) null, false, -49999));
                    throw null;
                }
            } catch (DP e11) {
                A0k(new DI(this.A07, (Throwable) e11, false, -49998));
                throw null;
            }
        }
        if (A1R(this.A0A)) {
            String str2 = this.A0A.A02;
            this.A00 = A0W(str2);
            this.A0D = A0t(str2, this.A07);
            this.A0H = A0s(str2);
            this.A0G = A0p(this.A0A);
            this.A0E = A0q(str2);
            this.A0F = A0r(str2);
            this.A0I = A0u(str2, this.A07);
            try {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                IC.A02(A0Z(665, 12, 94) + str2);
                this.A06 = MediaCodec.createByCodecName(str2);
                IC.A00();
                IC.A02(A0Z(651, 14, 81));
                A1O(this.A0A, this.A06, this.A07, null);
                IC.A00();
                IC.A02(A0Z(764, 10, 125));
                this.A06.start();
                IC.A00();
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                A1P(str2, jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime);
                A0c();
                this.A05 = A81() == 2 ? SystemClock.elapsedRealtime() + 1000 : C.TIME_UNSET;
                A0h();
                A0i();
                this.A0Q = true;
                this.A0U.A00++;
            } catch (Exception e12) {
                A0k(new DI(this.A07, (Throwable) e12, false, str2));
                throw null;
            }
        }
    }

    public void A1K(long j11) {
    }

    public abstract void A1L(MediaCodec mediaCodec, MediaFormat mediaFormat) throws C11669c;

    public void A1M(Format format) throws C11669c {
        MediaCodec mediaCodec;
        Format format2 = this.A07;
        this.A07 = format;
        if (!IF.A0g(format.A0H, format2 == null ? null : format2.A0H)) {
            if (this.A07.A0H != null) {
                if (0 == 0) {
                    throw C11669c.A01(new IllegalStateException(A0Z(185, 34, 111)), A0z());
                }
                Looper.myLooper();
                throw new NullPointerException(A0Z(624, 14, 48));
            }
            this.A09 = null;
        }
        boolean z11 = false;
        if (0 == 0 && (mediaCodec = this.A06) != null) {
            switch (A1B(mediaCodec, this.A0A, format2, this.A07)) {
                case 0:
                    break;
                case 1:
                    z11 = true;
                    break;
                case 2:
                default:
                    throw new IllegalStateException();
                case 3:
                    z11 = true;
                    this.A0L = true;
                    if (A0e[1].charAt(18) != 'w') {
                        throw new RuntimeException();
                    }
                    A0e[5] = "470Pj9QxuaVscsy8pk25MlpSOfE9YJj";
                    this.A01 = 1;
                    int i11 = this.A00;
                    this.A0C = i11 == 2 || (i11 == 1 && this.A07.A0F == format2.A0F && this.A07.A08 == format2.A08);
                    break;
            }
        }
        if (z11) {
            return;
        }
        if (this.A0J) {
            this.A02 = 1;
        } else {
            A1H();
            A1J();
        }
    }

    public abstract void A1N(C1773Xr c1773Xr);

    public abstract void A1O(DG dg2, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) throws DP;

    public abstract void A1P(String str, long j11, long j12);

    public abstract boolean A1Q(long j11, long j12, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i11, int i12, long j13, boolean z11) throws C11669c;

    public boolean A1R(DG dg2) {
        return true;
    }

    @Override // com.facebook.ads.redexgen.uinode.Y5
    public boolean A91() {
        return this.A0N;
    }

    @Override // com.facebook.ads.redexgen.uinode.Y5
    public boolean A9C() {
        return (this.A07 == null || this.A0R || (!A19() && !A0m() && (this.A05 == C.TIME_UNSET || SystemClock.elapsedRealtime() >= this.A05))) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0064  */
    /* JADX WARN: Code duplicated, block: B:30:0x008f  */
    /* JADX WARN: Code duplicated, block: B:32:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:35:0x00b7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:36:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:42:? A[LOOP:0: B:20:0x0071->B:42:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:? A[LOOP:1: B:26:0x0084->B:44:?, LOOP_END, SYNTHETIC] */
    @Override // com.facebook.ads.redexgen.uinode.Y5
    public final void AFB(long j11, long j12) throws C11669c {
        int iA11;
        if (this.A0N) {
            A1I();
            String[] strArr = A0e;
            if (strArr[4].length() == strArr[6].length()) {
                throw new RuntimeException();
            }
            A0e[0] = "lwFTUI1opuqPhbxVYngJAvB4EigDaO53";
            return;
        }
        if (this.A07 == null) {
            this.A0Y.A07();
            int iA12 = A11(this.A0W, this.A0Y, true);
            if (iA12 != -5) {
                if (iA12 == -4) {
                    AbstractC1351Ha.A04(this.A0Y.A04());
                    this.A0M = true;
                    A0d();
                    return;
                }
                return;
            }
            A1M(this.A0W.A00);
        }
        A1J();
        String[] strArr2 = A0e;
        if (strArr2[4].length() != strArr2[6].length()) {
            A0e[0] = "eroLcdOpjUP85EYGmYhVy7jJ6XqjjMHN";
            if (this.A06 != null) {
                IC.A02(A0Z(677, 12, 39));
                while (A0o(j11, j12)) {
                }
                while (A0l()) {
                }
                IC.A00();
            } else {
                this.A0U.A07 += A10(j11);
                this.A0Y.A07();
                iA11 = A11(this.A0W, this.A0Y, false);
                if (iA11 == -5) {
                    A1M(this.A0W.A00);
                } else if (iA11 == -4) {
                    AbstractC1351Ha.A04(this.A0Y.A04());
                    this.A0M = true;
                    A0d();
                }
            }
        } else {
            A0e[1] = "qeXDyPBokWYcVwHFGawdRvPvaKboAA5h";
            if (this.A06 != null) {
                IC.A02(A0Z(677, 12, 39));
                while (A0o(j11, j12)) {
                }
                while (A0l()) {
                }
                IC.A00();
            } else {
                this.A0U.A07 += A10(j11);
                this.A0Y.A07();
                iA11 = A11(this.A0W, this.A0Y, false);
                if (iA11 == -5) {
                    A1M(this.A0W.A00);
                } else if (iA11 == -4) {
                    AbstractC1351Ha.A04(this.A0Y.A04());
                    this.A0M = true;
                    A0d();
                }
            }
        }
        this.A0U.A00();
    }

    @Override // com.facebook.ads.redexgen.uinode.AA
    public final int AGe(Format format) throws C11669c {
        try {
            return A1C(this.A0a, null, format);
        } catch (DP e11) {
            throw C11669c.A01(e11, A0z());
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.EM, com.facebook.ads.redexgen.uinode.AA
    public final int AGg() {
        return 8;
    }
}
