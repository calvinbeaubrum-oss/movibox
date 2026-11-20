package com.facebook.ads.redexgen.uinode;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1780Xy implements InterfaceC1203Ao {
    public static boolean A0p;
    public static boolean A0q;
    public static byte[] A0r;
    public static String[] A0s = {"hUCCDXcY4t01difYD4QJmSlSRe7RVS9F", "yHOnf8lHgEM0FI0EKX1KbB3TaozNa", "kXByBOPR65DToxooqsu0gGt9HKAYl4Vo", "NIkyagP1AzDGImvyfrRhWneTEqqmK", "aXPRHAu0VDe5efXXlwPVbrYy41", "xYrm6yKJij65q9D2CisZETvgfz", "Fi2DTXQipqprJDEroL63LN5SWS4FAMqA", "8o6UBOAn3xAy4ZEKn0SjK2UR42QgxF0P"};
    public float A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08;
    public int A09;
    public int A0A;
    public int A0B;
    public int A0C;
    public int A0D;
    public long A0E;
    public long A0F;
    public long A0G;
    public long A0H;
    public long A0I;
    public long A0J;
    public long A0K;
    public long A0L;
    public AudioTrack A0M;
    public AudioTrack A0N;
    public C11869x A0O;
    public C11869x A0P;
    public AT A0Q;
    public InterfaceC1201Am A0R;
    public ByteBuffer A0S;
    public ByteBuffer A0T;
    public ByteBuffer A0U;
    public boolean A0V;
    public boolean A0W;
    public boolean A0X;
    public boolean A0Y;
    public boolean A0Z;
    public boolean A0a;
    public boolean A0b;
    public byte[] A0c;
    public InterfaceC1190Ab[] A0d;
    public ByteBuffer[] A0e;
    public final ConditionVariable A0f;
    public final AU A0g;
    public final C1209Au A0h;
    public final Y1 A0i;
    public final InterfaceC1212Ax A0j;
    public final C1774Xs A0k;
    public final ArrayDeque<C1214Az> A0l;
    public final boolean A0m;
    public final InterfaceC1190Ab[] A0n;
    public final InterfaceC1190Ab[] A0o;

    static {
        A0O();
        A0p = false;
        A0q = false;
    }

    public C1780Xy(AU au2, InterfaceC1212Ax interfaceC1212Ax, boolean z11) {
        this.A0g = au2;
        this.A0j = (InterfaceC1212Ax) AbstractC1351Ha.A01(interfaceC1212Ax);
        this.A0m = z11;
        this.A0f = new ConditionVariable(true);
        this.A0h = new C1209Au(new C1781Xz(this, null));
        Y1 y11 = new Y1();
        this.A0i = y11;
        C1774Xs c1774Xs = new C1774Xs();
        this.A0k = c1774Xs;
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new C1777Xv(), y11, c1774Xs);
        Collections.addAll(arrayList, interfaceC1212Ax.A64());
        this.A0o = (InterfaceC1190Ab[]) arrayList.toArray(new InterfaceC1190Ab[arrayList.size()]);
        this.A0n = new InterfaceC1190Ab[]{new C1779Xx()};
        this.A00 = 1.0f;
        this.A0D = 0;
        this.A0Q = AT.A04;
        this.A01 = 0;
        this.A0P = C11869x.A04;
        this.A04 = -1;
        this.A0d = new InterfaceC1190Ab[0];
        this.A0e = new ByteBuffer[0];
        this.A0l = new ArrayDeque<>();
    }

    public C1780Xy(AU au2, InterfaceC1190Ab[] interfaceC1190AbArr) {
        this(au2, interfaceC1190AbArr, false);
    }

    public C1780Xy(AU au2, InterfaceC1190Ab[] interfaceC1190AbArr, boolean z11) {
        this(au2, new Y0(interfaceC1190AbArr), z11);
    }

    public static int A00(int i11, ByteBuffer byteBuffer) {
        if (i11 == 7 || i11 == 8) {
            return B1.A00(byteBuffer);
        }
        if (i11 == 5) {
            return AQ.A00();
        }
        if (i11 != 6) {
            if (i11 != 14) {
                throw new IllegalStateException(A0I(84, 27, 113) + i11);
            }
            int iA02 = AQ.A02(byteBuffer);
            if (iA02 == -1) {
                return 0;
            }
            return AQ.A04(byteBuffer, iA02) * 16;
        }
        int iA03 = AQ.A03(byteBuffer);
        String[] strArr = A0s;
        if (strArr[2].charAt(5) != strArr[7].charAt(5)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0s;
        strArr2[4] = "kQJQgIYBfsXVI0BXiDfXFh8Y0v";
        strArr2[5] = "xmKGBElaJ1P1UFLQWjzE2KvoVx";
        return iA03;
    }

    public static int A01(AudioTrack audioTrack, ByteBuffer byteBuffer, int i11) {
        return audioTrack.write(byteBuffer, i11, 1);
    }

    private int A02(AudioTrack audioTrack, ByteBuffer byteBuffer, int i11, long j11) {
        if (this.A0S == null) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
            this.A0S = byteBufferAllocate;
            byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
            this.A0S.putInt(1431633921);
        }
        if (this.A03 == 0) {
            this.A0S.putInt(4, i11);
            this.A0S.putLong(8, 1000 * j11);
            this.A0S.position(0);
            this.A03 = i11;
        }
        int iRemaining = this.A0S.remaining();
        String[] strArr = A0s;
        if (strArr[4].length() != strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0s;
        strArr2[6] = "ZxHEhXNaRaOeicOuVS0y7eKtBmJV15x7";
        strArr2[0] = "lpmrRXkhPpBf5A8LovnLhyOg75mNhzFm";
        if (iRemaining > 0) {
            int iWrite = audioTrack.write(this.A0S, iRemaining, 1);
            if (iWrite < 0) {
                this.A03 = 0;
                return iWrite;
            }
            if (iWrite < iRemaining) {
                return 0;
            }
        }
        int iA01 = A01(audioTrack, byteBuffer, i11);
        if (iA01 >= 0) {
            this.A03 -= iA01;
            return iA01;
        }
        this.A03 = 0;
        String[] strArr3 = A0s;
        if (strArr3[6].charAt(5) != strArr3[0].charAt(5)) {
            throw new RuntimeException();
        }
        String[] strArr4 = A0s;
        strArr4[6] = "98oBXXwj84JUUigMvdtlS6TYqH9EDAiG";
        strArr4[0] = "VyAxkX5UR8Pe4wLdxiezRSIVcQQDizsa";
        return iA01;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long A03() {
        return this.A0X ? this.A0J / ((long) this.A0B) : this.A0I;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long A04() {
        return this.A0X ? this.A0L / ((long) this.A09) : this.A0K;
    }

    private long A05(long j11) {
        return A08(this.A0j.A80()) + j11;
    }

    private long A06(long j11) {
        C1214Az c1214Az = null;
        while (!this.A0l.isEmpty() && j11 >= this.A0l.getFirst().A01) {
            C1214Az c1214AzRemove = this.A0l.remove();
            String[] strArr = A0s;
            if (strArr[1].length() != strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0s;
            strArr2[1] = "EqLX22Mle1kVg1sX5ZT6YkRLc5f35";
            strArr2[3] = "gdY2b1urbXezKivfsFNrjnMWNzK4t";
            c1214Az = c1214AzRemove;
        }
        if (c1214Az != null) {
            this.A0P = c1214Az.A02;
            this.A0G = c1214Az.A01;
            this.A0F = c1214Az.A00 - this.A0H;
        }
        if (this.A0P.A01 == 1.0f) {
            return (this.A0F + j11) - this.A0G;
        }
        return this.A0l.isEmpty() ? this.A0F + this.A0j.A7O(j11 - this.A0G) : this.A0F + IF.A0C(j11 - this.A0G, this.A0P.A01);
    }

    private long A07(long j11) {
        return (((long) this.A0A) * j11) / 1000000;
    }

    private long A08(long j11) {
        return (1000000 * j11) / ((long) this.A0A);
    }

    private long A09(long j11) {
        return (1000000 * j11) / ((long) this.A06);
    }

    private AudioTrack A0D() {
        AudioAttributes audioAttributesBuild = this.A0b ? new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build() : this.A0Q.A00();
        AudioFormat audioFormatBuild = new AudioFormat.Builder().setChannelMask(this.A07).setEncoding(this.A08).setSampleRate(this.A0A).build();
        int i11 = this.A01;
        if (i11 == 0) {
            i11 = 0;
        }
        return new AudioTrack(audioAttributesBuild, audioFormatBuild, this.A02, 1, i11);
    }

    private AudioTrack A0E() throws C1200Al {
        AudioTrack audioTrack;
        if (IF.A02 >= 21) {
            audioTrack = A0D();
        } else {
            int iA03 = IF.A03(this.A0Q.A03);
            audioTrack = this.A01 == 0 ? new AudioTrack(iA03, this.A0A, this.A07, this.A08, this.A02, 1) : new AudioTrack(iA03, this.A0A, this.A07, this.A08, this.A02, 1, this.A01);
        }
        int state = audioTrack.getState();
        if (state == 1) {
            return audioTrack;
        }
        try {
            audioTrack.release();
        } catch (Exception unused) {
        }
        throw new C1200Al(state, this.A0A, this.A07, this.A02);
    }

    private AudioTrack A0F(int i11) {
        return new AudioTrack(3, 4000, 4, 2, 2, 0, i11);
    }

    public static String A0I(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0r, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 10);
        }
        return new String(bArrCopyOfRange);
    }

    private void A0J() {
        int i11 = 0;
        while (true) {
            InterfaceC1190Ab[] interfaceC1190AbArr = this.A0d;
            if (i11 >= interfaceC1190AbArr.length) {
                return;
            }
            InterfaceC1190Ab interfaceC1190Ab = interfaceC1190AbArr[i11];
            interfaceC1190Ab.flush();
            this.A0e[i11] = interfaceC1190Ab.A7W();
            i11++;
        }
    }

    private void A0K() throws C1200Al {
        this.A0f.block();
        AudioTrack audioTrackA0E = A0E();
        this.A0M = audioTrackA0E;
        int audioSessionId = audioTrackA0E.getAudioSessionId();
        if (A0p && IF.A02 < 21) {
            AudioTrack audioTrack = this.A0N;
            if (audioTrack != null && audioSessionId != audioTrack.getAudioSessionId()) {
                A0L();
            }
            if (this.A0N == null) {
                this.A0N = A0F(audioSessionId);
            }
        }
        if (this.A01 != audioSessionId) {
            this.A01 = audioSessionId;
            InterfaceC1201Am interfaceC1201Am = this.A0R;
            if (interfaceC1201Am != null) {
                interfaceC1201Am.AAs(audioSessionId);
            }
        }
        this.A0P = this.A0V ? this.A0j.A3b(this.A0P) : C11869x.A04;
        A0N();
        this.A0h.A0G(this.A0M, this.A08, this.A09, this.A02);
        A0M();
    }

    private void A0L() {
        if (this.A0N == null) {
            return;
        }
        AudioTrack audioTrack = this.A0N;
        this.A0N = null;
        new C1211Aw(this, audioTrack).start();
    }

    private void A0M() {
        if (A0U()) {
            if (IF.A02 >= 21) {
                A0Q(this.A0M, this.A00);
                return;
            }
            AudioTrack audioTrack = this.A0M;
            String[] strArr = A0s;
            if (strArr[4].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0s;
            strArr2[2] = "RUPACOvpiKp7bcWaTWyqVFSR7GtEantX";
            strArr2[7] = "RzQzoOWLdvYkkdkBCtRhC7yU7hWBsadG";
            A0R(audioTrack, this.A00);
        }
    }

    private void A0N() {
        ArrayList arrayList = new ArrayList();
        for (InterfaceC1190Ab interfaceC1190Ab : A0V()) {
            if (interfaceC1190Ab.A8w()) {
                arrayList.add(interfaceC1190Ab);
            } else {
                interfaceC1190Ab.flush();
            }
        }
        int size = arrayList.size();
        this.A0d = (InterfaceC1190Ab[]) arrayList.toArray(new InterfaceC1190Ab[size]);
        this.A0e = new ByteBuffer[size];
        A0J();
    }

    public static void A0O() {
        A0r = new byte[]{33, 45, 106, 98, 121, 45, 82, 102, 119, 122, 124, 71, 97, 114, 112, 120, 47, 2, Ascii.CAN, 8, 4, 5, Ascii.US, 2, 5, Ascii.RS, 2, Ascii.US, Ascii.DC2, 75, Ascii.SI, Ascii.SO, Ascii.US, Ascii.SO, 8, Ascii.US, Ascii.SO, Ascii.SI, 75, 48, Ascii.SO, 19, Ascii.ESC, Ascii.SO, 8, Ascii.US, Ascii.SO, Ascii.SI, 75, 33, 57, 38, 43, 38, 46, 78, 121, 111, 121, 104, 104, 117, 114, 123, 60, 111, 104, 125, 112, 112, 121, 120, 60, 125, 105, 120, 117, 115, 60, 104, 110, 125, Ascii.DEL, 119, 46, Ascii.NAK, Ascii.RS, 3, Ascii.VT, Ascii.RS, Ascii.CAN, Ascii.SI, Ascii.RS, Ascii.US, 91, Ascii.SUB, Ascii.SO, Ascii.US, Ascii.DC2, Ascii.DC4, 91, Ascii.RS, Ascii.NAK, Ascii.CAN, Ascii.DC4, Ascii.US, Ascii.DC2, Ascii.NAK, Ascii.FS, 65, 91, 58, 1, Ascii.FS, Ascii.SUB, Ascii.US, Ascii.US, 0, Ascii.GS, Ascii.ESC, 10, Ascii.VT, 79, Ascii.FF, 7, Ascii.SO, 1, 1, 10, 3, 79, Ascii.FF, 0, Ascii.SUB, 1, Ascii.ESC, 85, 79, Ascii.CAN, 121, 112, 108, 107, 122, 109, 41, 58, 40, 58};
    }

    private void A0P(long j11) throws C1202An {
        ByteBuffer byteBuffer;
        int length = this.A0d.length;
        int i11 = length;
        while (i11 >= 0) {
            if (i11 > 0) {
                byteBuffer = this.A0e[i11 - 1];
            } else {
                byteBuffer = this.A0T;
                if (byteBuffer == null) {
                    byteBuffer = InterfaceC1190Ab.A00;
                }
            }
            if (i11 == length) {
                A0S(byteBuffer, j11);
            } else {
                InterfaceC1190Ab interfaceC1190Ab = this.A0d[i11];
                interfaceC1190Ab.AEF(byteBuffer);
                ByteBuffer byteBufferA7W = interfaceC1190Ab.A7W();
                this.A0e[i11] = byteBufferA7W;
                if (byteBufferA7W.hasRemaining()) {
                    i11++;
                }
            }
            boolean zHasRemaining = byteBuffer.hasRemaining();
            String[] strArr = A0s;
            if (strArr[4].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0s;
            strArr2[2] = "GvJ2yOfBgit1iG3ukbpo3ztMvZtxyKui";
            strArr2[7] = "YNNwMOgGE9szKpvyLkHk1WmQlE5xjnt7";
            if (zHasRemaining) {
                return;
            } else {
                i11--;
            }
        }
    }

    public static void A0Q(AudioTrack audioTrack, float f11) {
        audioTrack.setVolume(f11);
    }

    public static void A0R(AudioTrack audioTrack, float f11) {
        audioTrack.setStereoVolume(f11, f11);
    }

    private void A0S(ByteBuffer byteBuffer, long j11) throws C1202An {
        if (byteBuffer.hasRemaining()) {
            ByteBuffer byteBuffer2 = this.A0U;
            String[] strArr = A0s;
            if (strArr[2].charAt(5) != strArr[7].charAt(5)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0s;
            strArr2[1] = "Y8Mrx0I9TdYWTjTrSbpDFDKjoXuQO";
            strArr2[3] = "wRs1O0frPXGaUer72uaPv4p6RCTih";
            if (byteBuffer2 != null) {
                AbstractC1351Ha.A03(byteBuffer2 == byteBuffer);
            } else {
                this.A0U = byteBuffer;
                if (IF.A02 < 21) {
                    int iRemaining = byteBuffer.remaining();
                    byte[] bArr = this.A0c;
                    if (bArr == null || bArr.length < iRemaining) {
                        this.A0c = new byte[iRemaining];
                    }
                    int iPosition = byteBuffer.position();
                    byteBuffer.get(this.A0c, 0, iRemaining);
                    byteBuffer.position(iPosition);
                    this.A0C = 0;
                }
            }
            int iRemaining2 = byteBuffer.remaining();
            int iA01 = 0;
            if (IF.A02 < 21) {
                int iA0B = this.A0h.A0B(this.A0L);
                if (iA0B > 0) {
                    iA01 = this.A0M.write(this.A0c, this.A0C, Math.min(iRemaining2, iA0B));
                    if (iA01 > 0) {
                        this.A0C += iA01;
                        byteBuffer.position(byteBuffer.position() + iA01);
                    }
                }
            } else if (this.A0b) {
                AbstractC1351Ha.A04(j11 != C.TIME_UNSET);
                iA01 = A02(this.A0M, byteBuffer, iRemaining2, j11);
            } else {
                iA01 = A01(this.A0M, byteBuffer, iRemaining2);
            }
            this.A0E = SystemClock.elapsedRealtime();
            if (iA01 < 0) {
                throw new C1202An(iA01);
            }
            boolean z11 = this.A0X;
            if (z11) {
                this.A0L += (long) iA01;
            }
            if (iA01 == iRemaining2) {
                if (!z11) {
                    this.A0K += (long) this.A05;
                }
                this.A0U = null;
            }
        }
    }

    private boolean A0T() throws C1202An {
        boolean z11 = false;
        if (this.A04 == -1) {
            this.A04 = this.A0Z ? 0 : this.A0d.length;
            z11 = true;
        }
        while (true) {
            int i11 = this.A04;
            InterfaceC1190Ab[] interfaceC1190AbArr = this.A0d;
            if (i11 >= interfaceC1190AbArr.length) {
                ByteBuffer byteBuffer = this.A0U;
                if (byteBuffer != null) {
                    A0S(byteBuffer, C.TIME_UNSET);
                    if (this.A0U != null) {
                        return false;
                    }
                }
                this.A04 = -1;
                return true;
            }
            InterfaceC1190Ab interfaceC1190Ab = interfaceC1190AbArr[i11];
            if (z11) {
                interfaceC1190Ab.AEE();
            }
            A0P(C.TIME_UNSET);
            if (!interfaceC1190Ab.A91()) {
                return false;
            }
            z11 = true;
            this.A04++;
        }
    }

    private boolean A0U() {
        return this.A0M != null;
    }

    private InterfaceC1190Ab[] A0V() {
        return this.A0a ? this.A0n : this.A0o;
    }

    /* JADX WARN: Code duplicated, block: B:76:0x0148  */
    /* JADX WARN: Code duplicated, block: B:78:0x014c A[RETURN] */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x01d4, code lost:
    
        if (r6 != false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01d7, code lost:
    
        r4 = r10.A08;
        r2 = com.facebook.ads.redexgen.uinode.C1780Xy.A0s;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01ea, code lost:
    
        if (r2[2].charAt(5) == r2[7].charAt(5)) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01f1, code lost:
    
        throw new java.lang.RuntimeException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01f2, code lost:
    
        r2 = com.facebook.ads.redexgen.uinode.C1780Xy.A0s;
        r2[4] = "14nowEFL6Yk6bTHhGEAerIHyFS";
        r2[5] = "whsLbLpoTkO7JKoY0ylMAK08jN";
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x01ff, code lost:
    
        if (r4 == 5) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0202, code lost:
    
        if (r4 != 6) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0204, code lost:
    
        r10.A02 = com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CacheDataSink.DEFAULT_BUFFER_SIZE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x020b, code lost:
    
        if (r4 != 7) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x020d, code lost:
    
        r10.A02 = 49152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0214, code lost:
    
        r10.A02 = 294912;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0193, code lost:
    
        if (r6 != false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0195, code lost:
    
        r2 = android.media.AudioTrack.getMinBufferSize(r13, r5, r10.A08);
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x019c, code lost:
    
        if (r2 == (-2)) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x019e, code lost:
    
        com.facebook.ads.redexgen.uinode.AbstractC1351Ha.A04(r4);
        r10.A02 = com.facebook.ads.redexgen.uinode.IF.A06(r2 * 4, ((int) A07(250000)) * r10.A09, (int) java.lang.Math.max(r2, A07(750000) * ((long) r10.A09)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01c6, code lost:
    
        r4 = false;
     */
    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1203Ao
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A4P(int i11, int i12, int i13, int i14, int[] iArr, int i15, int i16) throws C1199Ak {
        int i17;
        boolean z11;
        boolean zA4Q = false;
        this.A06 = i13;
        this.A0X = IF.A0c(i11);
        this.A0a = this.A0m && A90(1073741824) && IF.A0b(i11);
        if (this.A0X) {
            this.A0B = IF.A05(i11, i12);
        }
        int iA7Y = i11;
        boolean z12 = this.A0X && i11 != 4;
        this.A0V = z12 && !this.A0a;
        if (z12) {
            C1774Xs c1774Xs = this.A0k;
            String[] strArr = A0s;
            if (strArr[2].charAt(5) != strArr[7].charAt(5)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0s;
            strArr2[2] = "ej7gIOv1RSWnjsTxHmkmyi8L1IunU9uG";
            strArr2[7] = "hfKjQOc2MeS54BGnG6pnxpZTrszWdpVu";
            c1774Xs.A00(i15, i16);
            this.A0i.A00(iArr);
            for (InterfaceC1190Ab interfaceC1190Ab : A0V()) {
                try {
                    zA4Q |= interfaceC1190Ab.A4Q(i13, i12, iA7Y);
                    if (interfaceC1190Ab.A8w()) {
                        i12 = interfaceC1190Ab.A7X();
                        i13 = interfaceC1190Ab.A7Z();
                        iA7Y = interfaceC1190Ab.A7Y();
                    }
                } catch (C1189Aa e11) {
                    throw new C1199Ak(e11);
                }
            }
        }
        switch (i12) {
            case 1:
                i17 = 4;
                break;
            case 2:
                i17 = 12;
                break;
            case 3:
                i17 = 28;
                break;
            case 4:
                i17 = 204;
                break;
            case 5:
                i17 = 220;
                break;
            case 6:
                i17 = 252;
                break;
            case 7:
                i17 = 1276;
                break;
            case 8:
                i17 = C9W.A00;
                break;
            default:
                throw new C1199Ak(A0I(111, 27, 101) + i12);
        }
        if (IF.A02 <= 23 && A0I(139, 6, 21).equals(IF.A03) && A0I(49, 6, 101).equals(IF.A05)) {
            switch (i12) {
                case 3:
                case 5:
                    i17 = 252;
                    break;
                case 7:
                    i17 = C9W.A00;
                    break;
            }
        }
        if (IF.A02 > 25 || !A0I(145, 4, 69).equals(IF.A03) || this.A0X) {
            z11 = true;
        } else {
            z11 = true;
            if (i12 == 1) {
                i17 = 12;
            }
        }
        if (!zA4Q && A0U() && this.A08 == iA7Y) {
            int i18 = this.A0A;
            String[] strArr3 = A0s;
            if (strArr3[4].length() == strArr3[5].length()) {
                String[] strArr4 = A0s;
                strArr4[6] = "u2P4sXJj5H8su2Kql34JpmWdGsVOFAs5";
                strArr4[0] = "NVG4MXG40xPwcgngyVWUBbOvox4lVKJJ";
                if (i18 == i13) {
                    if (this.A07 == i17) {
                        return;
                    }
                }
            } else if (i18 == i13) {
                if (this.A07 == i17) {
                    return;
                }
            }
        }
        reset();
        this.A0Z = z12;
        this.A0A = i13;
        this.A07 = i17;
        this.A08 = iA7Y;
        this.A09 = this.A0X ? IF.A05(iA7Y, i12) : -1;
        if (i14 != 0) {
            this.A02 = i14;
            return;
        }
        boolean z13 = this.A0X;
        String[] strArr5 = A0s;
        if (strArr5[6].charAt(5) == strArr5[0].charAt(5)) {
            String[] strArr6 = A0s;
            strArr6[6] = "DTWWXXvppHPLDuHJPaEYpRthtIw4YpkI";
            strArr6[0] = "uyl1CXNLwzeT5NMhWvVG28BgBRP6XYYa";
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1203Ao
    public final void A59() {
        if (this.A0b) {
            this.A0b = false;
            this.A01 = 0;
            reset();
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1203Ao
    public final void A5W(int i11) {
        AbstractC1351Ha.A04(IF.A02 >= 21);
        if (this.A0b) {
            int i12 = this.A01;
            String[] strArr = A0s;
            if (strArr[1].length() != strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0s;
            strArr2[2] = "PS7IBOM7NZDOoVGPPjdQOv1dv3IkizxK";
            strArr2[7] = "jjqtzOvKeeqNL4elNx3MZRV4owozeHXU";
            if (i12 == i11) {
                return;
            }
        }
        this.A0b = true;
        this.A01 = i11;
        reset();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1203Ao
    public final long A6e(boolean z11) {
        if (!A0U() || this.A0D == 0) {
            return Long.MIN_VALUE;
        }
        return this.A0H + A05(A06(Math.min(this.A0h.A0C(z11), A08(A04()))));
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1203Ao
    public final C11869x A7h() {
        return this.A0P;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1203Ao
    public final boolean A8R(ByteBuffer byteBuffer, long j11) throws C1200Al, C1202An {
        ByteBuffer byteBuffer2 = this.A0T;
        AbstractC1351Ha.A03(byteBuffer2 == null || byteBuffer == byteBuffer2);
        boolean zA0U = A0U();
        String[] strArr = A0s;
        if (strArr[4].length() != strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0s;
        strArr2[6] = "RcCB0XsFwDDOAw3euoH2B524NJP5PtQP";
        strArr2[0] = "S6sRDXDIUBrBns4w0IFsbKHJgfJaiswv";
        if (!zA0U) {
            A0K();
            if (this.A0Y) {
                AE2();
            }
        }
        if (!this.A0h.A0L(A04())) {
            return false;
        }
        ByteBuffer byteBuffer3 = this.A0T;
        String strA0I = A0I(6, 10, 25);
        if (byteBuffer3 == null) {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (!this.A0X && this.A05 == 0) {
                int iA00 = A00(this.A08, byteBuffer);
                this.A05 = iA00;
                if (iA00 == 0) {
                    return true;
                }
            }
            if (this.A0O != null) {
                if (!A0T()) {
                    return false;
                }
                C11869x c11869x = this.A0O;
                this.A0O = null;
                this.A0l.add(new C1214Az(this.A0j.A3b(c11869x), Math.max(0L, j11), A08(A04()), null));
                A0N();
            }
            if (this.A0D == 0) {
                this.A0H = Math.max(0L, j11);
                this.A0D = 1;
            } else {
                long jA09 = this.A0H + A09(A03());
                if (this.A0D == 1 && Math.abs(jA09 - j11) > 200000) {
                    Log.e(strA0I, A0I(16, 33, 97) + jA09 + A0I(0, 6, 7) + j11 + A0I(TsExtractor.TS_STREAM_TYPE_DTS, 1, 79));
                    this.A0D = 2;
                }
                if (this.A0D == 2) {
                    this.A0H += j11 - jA09;
                    this.A0D = 1;
                    InterfaceC1201Am interfaceC1201Am = this.A0R;
                    if (interfaceC1201Am != null) {
                        interfaceC1201Am.ACg();
                    }
                }
            }
            if (this.A0X) {
                this.A0J += (long) byteBuffer.remaining();
            } else {
                this.A0I += (long) this.A05;
            }
            this.A0T = byteBuffer;
        }
        if (this.A0Z) {
            A0P(j11);
        } else {
            A0S(this.A0T, j11);
        }
        if (!this.A0T.hasRemaining()) {
            this.A0T = null;
            return true;
        }
        if (!this.A0h.A0K(A04())) {
            return false;
        }
        Log.w(strA0I, A0I(55, 29, 22));
        reset();
        return true;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1203Ao
    public final void A8U() {
        if (this.A0D == 1) {
            this.A0D = 2;
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1203Ao
    public final boolean A8Z() {
        if (A0U()) {
            boolean zA0J = this.A0h.A0J(A04());
            String[] strArr = A0s;
            if (strArr[4].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0s;
            strArr2[4] = "9qaAbWK7Rz0EURQ8gVPoKZJ79p";
            strArr2[5] = "PQsLZF4zdgMsSCMdKk30KO6aPE";
            if (zA0J) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1203Ao
    public final boolean A90(int i11) {
        if (IF.A0c(i11)) {
            return i11 != 4 || IF.A02 >= 21;
        }
        AU au2 = this.A0g;
        return au2 != null && au2.A04(i11);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1203Ao
    public final boolean A91() {
        return !A0U() || (this.A0W && !A8Z());
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1203Ao
    public final void AE2() {
        this.A0Y = true;
        if (A0U()) {
            this.A0h.A0E();
            this.A0M.play();
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1203Ao
    public final void AE3() throws C1202An {
        if (!this.A0W && A0U() && A0T()) {
            this.A0h.A0F(A04());
            String[] strArr = A0s;
            if (strArr[4].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0s;
            strArr2[1] = "3Beu4rQqJml6K6p71ugtSnl6z4kve";
            strArr2[3] = "vTiWK9GhFZyDb3TQGI4eNztci47gx";
            this.A0M.stop();
            this.A03 = 0;
            this.A0W = true;
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1203Ao
    public final void AEV() {
        reset();
        A0L();
        for (InterfaceC1190Ab interfaceC1190Ab : this.A0o) {
            interfaceC1190Ab.reset();
        }
        for (InterfaceC1190Ab interfaceC1190Ab2 : this.A0n) {
            interfaceC1190Ab2.reset();
        }
        this.A01 = 0;
        this.A0Y = false;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1203Ao
    public final void AFs(AT at2) {
        if (this.A0Q.equals(at2)) {
            return;
        }
        this.A0Q = at2;
        if (this.A0b) {
            return;
        }
        reset();
        this.A01 = 0;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1203Ao
    public final void AG4(InterfaceC1201Am interfaceC1201Am) {
        this.A0R = interfaceC1201Am;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1203Ao
    public final C11869x AGA(C11869x c11869x) {
        if (A0U() && !this.A0V) {
            C11869x c11869x2 = C11869x.A04;
            this.A0P = c11869x2;
            return c11869x2;
        }
        C11869x c11869x3 = this.A0O;
        String[] strArr = A0s;
        if (strArr[6].charAt(5) != strArr[0].charAt(5)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0s;
        strArr2[1] = "qknQOXr2sfI1wZbS1fFTxKCHwtwOF";
        strArr2[3] = "6hx8Cx11JAWA8IEiphxLzKnZtiWJj";
        if (c11869x3 == null) {
            c11869x3 = !this.A0l.isEmpty() ? this.A0l.getLast().A02 : this.A0P;
        }
        boolean zEquals = c11869x.equals(c11869x3);
        String[] strArr3 = A0s;
        if (strArr3[6].charAt(5) != strArr3[0].charAt(5)) {
            throw new RuntimeException();
        }
        String[] strArr4 = A0s;
        strArr4[4] = "rapNwYGl5aH6wSWwsREtxqAYY9";
        strArr4[5] = "Swk5nrnVyktI66zCHmEiilSuas";
        if (!zEquals) {
            if (A0U()) {
                this.A0O = c11869x;
            } else {
                this.A0P = this.A0j.A3b(c11869x);
            }
        }
        return this.A0P;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1203Ao
    public final void pause() {
        this.A0Y = false;
        if (A0U() && this.A0h.A0I()) {
            AudioTrack audioTrack = this.A0M;
            String[] strArr = A0s;
            if (strArr[2].charAt(5) != strArr[7].charAt(5)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0s;
            strArr2[2] = "3LzsBOqgGe30i16a9NIVlDJcub4Z4Vvr";
            strArr2[7] = "hMaFPO8QBdBmzyeIOXtEGbbLXROtxATQ";
            audioTrack.pause();
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1203Ao
    public final void reset() {
        if (A0U()) {
            this.A0J = 0L;
            this.A0I = 0L;
            this.A0L = 0L;
            this.A0K = 0L;
            this.A05 = 0;
            C11869x c11869x = this.A0O;
            if (c11869x != null) {
                this.A0P = c11869x;
                String[] strArr = A0s;
                if (strArr[2].charAt(5) != strArr[7].charAt(5)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0s;
                strArr2[1] = "rnKZk3c8Taby0V4iUj7wGFJub43iz";
                strArr2[3] = "VEk4k7rPnS3kvq1QwagsAStWXQ6pG";
                this.A0O = null;
            } else if (!this.A0l.isEmpty()) {
                this.A0P = this.A0l.getLast().A02;
            }
            this.A0l.clear();
            this.A0F = 0L;
            this.A0G = 0L;
            this.A0T = null;
            this.A0U = null;
            A0J();
            this.A0W = false;
            this.A04 = -1;
            this.A0S = null;
            this.A03 = 0;
            this.A0D = 0;
            if (this.A0h.A0H()) {
                this.A0M.pause();
            }
            AudioTrack audioTrack = this.A0M;
            this.A0M = null;
            this.A0h.A0D();
            this.A0f.close();
            new C1210Av(this, audioTrack).start();
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1203Ao
    public final void setVolume(float f11) {
        if (this.A00 != f11) {
            this.A00 = f11;
            A0M();
        }
    }
}
