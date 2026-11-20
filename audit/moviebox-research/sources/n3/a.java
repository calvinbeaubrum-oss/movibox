package n3;

import android.content.res.AssetManager;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.system.OsConstants;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.common.api.Api;
import com.google.logging.type.LogSeverity;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import org.apache.tools.zip.UnixStat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static SimpleDateFormat T;
    public static SimpleDateFormat U;
    public static final d[] Y;
    public static final d[] Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final d[] f71494a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final d[] f71495b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final d[] f71496c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final d f71497d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final d[] f71498e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final d[] f71499f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final d[] f71500g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final d[] f71501h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final d[][] f71502i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final d[] f71503j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final HashMap<Integer, d>[] f71504k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final HashMap<String, d>[] f71505l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final HashSet<String> f71506m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final HashMap<Integer, Integer> f71507n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final Charset f71508o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final byte[] f71509p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final byte[] f71510q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final Pattern f71511r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final Pattern f71512s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final Pattern f71513t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final Pattern f71515u0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f71521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FileDescriptor f71522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AssetManager.AssetInputStream f71523c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f71524d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f71525e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap<String, c>[] f71526f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Set<Integer> f71527g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ByteOrder f71528h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f71529i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f71530j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f71531k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f71532l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f71533m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public byte[] f71534n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f71535o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f71536p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f71537q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f71538r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f71539s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f71540t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final boolean f71514u = Log.isLoggable("ExifInterface", 3);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final List<Integer> f71516v = Arrays.asList(1, 6, 3, 8);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final List<Integer> f71517w = Arrays.asList(2, 7, 4, 5);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int[] f71518x = {8, 8, 8};

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int[] f71519y = {4};

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int[] f71520z = {8};
    public static final byte[] A = {-1, -40, -1};
    public static final byte[] B = {102, 116, 121, 112};
    public static final byte[] C = {109, 105, 102, 49};
    public static final byte[] D = {104, 101, 105, 99};
    public static final byte[] E = {79, 76, 89, 77, 80, 0};
    public static final byte[] F = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    public static final byte[] G = {-119, 80, 78, 71, Ascii.CR, 10, Ascii.SUB, 10};
    public static final byte[] H = {101, 88, 73, 102};
    public static final byte[] I = {73, 72, 68, 82};
    public static final byte[] J = {73, 69, 78, 68};
    public static final byte[] K = {82, 73, 70, 70};
    public static final byte[] L = {87, 69, 66, 80};
    public static final byte[] M = {69, 88, 73, 70};
    public static final byte[] N = {-99, 1, 42};
    public static final byte[] O = "VP8X".getBytes(Charset.defaultCharset());
    public static final byte[] P = "VP8L".getBytes(Charset.defaultCharset());
    public static final byte[] Q = "VP8 ".getBytes(Charset.defaultCharset());
    public static final byte[] R = "ANIM".getBytes(Charset.defaultCharset());
    public static final byte[] S = "ANMF".getBytes(Charset.defaultCharset());
    public static final String[] V = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
    public static final int[] W = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    public static final byte[] X = {65, 83, 67, 73, 73, 0, 0, 0};

    /* JADX INFO: renamed from: n3.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0766a extends MediaDataSource {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f71541a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f71542b;

        public C0766a(f fVar) {
            this.f71542b = fVar;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // android.media.MediaDataSource
        public long getSize() throws IOException {
            return -1L;
        }

        @Override // android.media.MediaDataSource
        public int readAt(long j11, byte[] bArr, int i11, int i12) throws IOException {
            if (i12 == 0) {
                return 0;
            }
            if (j11 < 0) {
                return -1;
            }
            try {
                long j12 = this.f71541a;
                if (j12 != j11) {
                    if (j12 >= 0 && j11 >= j12 + ((long) this.f71542b.available())) {
                        return -1;
                    }
                    this.f71542b.e(j11);
                    this.f71541a = j11;
                }
                if (i12 > this.f71542b.available()) {
                    i12 = this.f71542b.available();
                }
                int i13 = this.f71542b.read(bArr, i11, i12);
                if (i13 >= 0) {
                    this.f71541a += (long) i13;
                    return i13;
                }
            } catch (IOException unused) {
            }
            this.f71541a = -1L;
            return -1;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b extends InputStream implements DataInput {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final ByteOrder f71544f = ByteOrder.LITTLE_ENDIAN;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final ByteOrder f71545g = ByteOrder.BIG_ENDIAN;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DataInputStream f71546a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ByteOrder f71547b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f71548c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte[] f71549d;

        public b(InputStream inputStream) throws IOException {
            this(inputStream, ByteOrder.BIG_ENDIAN);
        }

        public b(InputStream inputStream, ByteOrder byteOrder) throws IOException {
            this.f71547b = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.f71546a = dataInputStream;
            dataInputStream.mark(0);
            this.f71548c = 0;
            this.f71547b = byteOrder;
        }

        public b(byte[] bArr) throws IOException {
            this(new ByteArrayInputStream(bArr), ByteOrder.BIG_ENDIAN);
        }

        public int a() {
            return this.f71548c;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return this.f71546a.available();
        }

        public long b() throws IOException {
            return ((long) readInt()) & 4294967295L;
        }

        public void c(ByteOrder byteOrder) {
            this.f71547b = byteOrder;
        }

        public void d(int i11) throws IOException {
            int i12 = 0;
            while (i12 < i11) {
                int i13 = i11 - i12;
                int iSkip = (int) this.f71546a.skip(i13);
                if (iSkip <= 0) {
                    if (this.f71549d == null) {
                        this.f71549d = new byte[8192];
                    }
                    iSkip = this.f71546a.read(this.f71549d, 0, Math.min(8192, i13));
                    if (iSkip == -1) {
                        throw new EOFException("Reached EOF while skipping " + i11 + " bytes.");
                    }
                }
                i12 += iSkip;
            }
            this.f71548c += i12;
        }

        @Override // java.io.InputStream
        public void mark(int i11) {
            throw new UnsupportedOperationException("Mark is currently unsupported");
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            this.f71548c++;
            return this.f71546a.read();
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i11, int i12) throws IOException {
            int i13 = this.f71546a.read(bArr, i11, i12);
            this.f71548c += i13;
            return i13;
        }

        @Override // java.io.DataInput
        public boolean readBoolean() throws IOException {
            this.f71548c++;
            return this.f71546a.readBoolean();
        }

        @Override // java.io.DataInput
        public byte readByte() throws IOException {
            this.f71548c++;
            int i11 = this.f71546a.read();
            if (i11 >= 0) {
                return (byte) i11;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public char readChar() throws IOException {
            this.f71548c += 2;
            return this.f71546a.readChar();
        }

        @Override // java.io.DataInput
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readLong());
        }

        @Override // java.io.DataInput
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr) throws IOException {
            this.f71548c += bArr.length;
            this.f71546a.readFully(bArr);
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr, int i11, int i12) throws IOException {
            this.f71548c += i12;
            this.f71546a.readFully(bArr, i11, i12);
        }

        @Override // java.io.DataInput
        public int readInt() throws IOException {
            this.f71548c += 4;
            int i11 = this.f71546a.read();
            int i12 = this.f71546a.read();
            int i13 = this.f71546a.read();
            int i14 = this.f71546a.read();
            if ((i11 | i12 | i13 | i14) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f71547b;
            if (byteOrder == f71544f) {
                return (i14 << 24) + (i13 << 16) + (i12 << 8) + i11;
            }
            if (byteOrder == f71545g) {
                return (i11 << 24) + (i12 << 16) + (i13 << 8) + i14;
            }
            throw new IOException("Invalid byte order: " + this.f71547b);
        }

        @Override // java.io.DataInput
        public String readLine() throws IOException {
            return null;
        }

        @Override // java.io.DataInput
        public long readLong() throws IOException {
            this.f71548c += 8;
            int i11 = this.f71546a.read();
            int i12 = this.f71546a.read();
            int i13 = this.f71546a.read();
            int i14 = this.f71546a.read();
            int i15 = this.f71546a.read();
            int i16 = this.f71546a.read();
            int i17 = this.f71546a.read();
            int i18 = this.f71546a.read();
            if ((i11 | i12 | i13 | i14 | i15 | i16 | i17 | i18) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f71547b;
            if (byteOrder == f71544f) {
                return (((long) i18) << 56) + (((long) i17) << 48) + (((long) i16) << 40) + (((long) i15) << 32) + (((long) i14) << 24) + (((long) i13) << 16) + (((long) i12) << 8) + ((long) i11);
            }
            if (byteOrder == f71545g) {
                return (((long) i11) << 56) + (((long) i12) << 48) + (((long) i13) << 40) + (((long) i14) << 32) + (((long) i15) << 24) + (((long) i16) << 16) + (((long) i17) << 8) + ((long) i18);
            }
            throw new IOException("Invalid byte order: " + this.f71547b);
        }

        @Override // java.io.DataInput
        public short readShort() throws IOException {
            this.f71548c += 2;
            int i11 = this.f71546a.read();
            int i12 = this.f71546a.read();
            if ((i11 | i12) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f71547b;
            if (byteOrder == f71544f) {
                return (short) ((i12 << 8) + i11);
            }
            if (byteOrder == f71545g) {
                return (short) ((i11 << 8) + i12);
            }
            throw new IOException("Invalid byte order: " + this.f71547b);
        }

        @Override // java.io.DataInput
        public String readUTF() throws IOException {
            this.f71548c += 2;
            return this.f71546a.readUTF();
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() throws IOException {
            this.f71548c++;
            return this.f71546a.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() throws IOException {
            this.f71548c += 2;
            int i11 = this.f71546a.read();
            int i12 = this.f71546a.read();
            if ((i11 | i12) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f71547b;
            if (byteOrder == f71544f) {
                return (i12 << 8) + i11;
            }
            if (byteOrder == f71545g) {
                return (i11 << 8) + i12;
            }
            throw new IOException("Invalid byte order: " + this.f71547b);
        }

        @Override // java.io.InputStream
        public void reset() {
            throw new UnsupportedOperationException("Reset is currently unsupported");
        }

        @Override // java.io.DataInput
        public int skipBytes(int i11) throws IOException {
            throw new UnsupportedOperationException("skipBytes is currently unsupported");
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f71550a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f71551b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f71552c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final byte[] f71553d;

        public c(int i11, int i12, long j11, byte[] bArr) {
            this.f71550a = i11;
            this.f71551b = i12;
            this.f71552c = j11;
            this.f71553d = bArr;
        }

        public c(int i11, int i12, byte[] bArr) {
            this(i11, i12, -1L, bArr);
        }

        public static c a(String str) {
            byte[] bytes = (str + (char) 0).getBytes(a.f71508o0);
            return new c(2, bytes.length, bytes);
        }

        public static c b(long j11, ByteOrder byteOrder) {
            return c(new long[]{j11}, byteOrder);
        }

        public static c c(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[a.W[4] * jArr.length]);
            byteBufferWrap.order(byteOrder);
            for (long j11 : jArr) {
                byteBufferWrap.putInt((int) j11);
            }
            return new c(4, jArr.length, byteBufferWrap.array());
        }

        public static c d(e eVar, ByteOrder byteOrder) {
            return e(new e[]{eVar}, byteOrder);
        }

        public static c e(e[] eVarArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[a.W[5] * eVarArr.length]);
            byteBufferWrap.order(byteOrder);
            for (e eVar : eVarArr) {
                byteBufferWrap.putInt((int) eVar.f71558a);
                byteBufferWrap.putInt((int) eVar.f71559b);
            }
            return new c(5, eVarArr.length, byteBufferWrap.array());
        }

        public static c f(int i11, ByteOrder byteOrder) {
            return g(new int[]{i11}, byteOrder);
        }

        public static c g(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[a.W[3] * iArr.length]);
            byteBufferWrap.order(byteOrder);
            for (int i11 : iArr) {
                byteBufferWrap.putShort((short) i11);
            }
            return new c(3, iArr.length, byteBufferWrap.array());
        }

        public double h(ByteOrder byteOrder) throws Throwable {
            Object objK = k(byteOrder);
            if (objK == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            }
            if (objK instanceof String) {
                return Double.parseDouble((String) objK);
            }
            if (objK instanceof long[]) {
                long[] jArr = (long[]) objK;
                if (jArr.length == 1) {
                    return jArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (objK instanceof int[]) {
                int[] iArr = (int[]) objK;
                if (iArr.length == 1) {
                    return iArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (objK instanceof double[]) {
                double[] dArr = (double[]) objK;
                if (dArr.length == 1) {
                    return dArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(objK instanceof e[])) {
                throw new NumberFormatException("Couldn't find a double value");
            }
            e[] eVarArr = (e[]) objK;
            if (eVarArr.length == 1) {
                return eVarArr[0].a();
            }
            throw new NumberFormatException("There are more than one component");
        }

        public int i(ByteOrder byteOrder) throws Throwable {
            Object objK = k(byteOrder);
            if (objK == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            }
            if (objK instanceof String) {
                return Integer.parseInt((String) objK);
            }
            if (objK instanceof long[]) {
                long[] jArr = (long[]) objK;
                if (jArr.length == 1) {
                    return (int) jArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(objK instanceof int[])) {
                throw new NumberFormatException("Couldn't find a integer value");
            }
            int[] iArr = (int[]) objK;
            if (iArr.length == 1) {
                return iArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }

        public String j(ByteOrder byteOrder) throws Throwable {
            Object objK = k(byteOrder);
            if (objK == null) {
                return null;
            }
            if (objK instanceof String) {
                return (String) objK;
            }
            StringBuilder sb2 = new StringBuilder();
            int i11 = 0;
            if (objK instanceof long[]) {
                long[] jArr = (long[]) objK;
                while (i11 < jArr.length) {
                    sb2.append(jArr[i11]);
                    i11++;
                    if (i11 != jArr.length) {
                        sb2.append(",");
                    }
                }
                return sb2.toString();
            }
            if (objK instanceof int[]) {
                int[] iArr = (int[]) objK;
                while (i11 < iArr.length) {
                    sb2.append(iArr[i11]);
                    i11++;
                    if (i11 != iArr.length) {
                        sb2.append(",");
                    }
                }
                return sb2.toString();
            }
            if (objK instanceof double[]) {
                double[] dArr = (double[]) objK;
                while (i11 < dArr.length) {
                    sb2.append(dArr[i11]);
                    i11++;
                    if (i11 != dArr.length) {
                        sb2.append(",");
                    }
                }
                return sb2.toString();
            }
            if (!(objK instanceof e[])) {
                return null;
            }
            e[] eVarArr = (e[]) objK;
            while (i11 < eVarArr.length) {
                sb2.append(eVarArr[i11].f71558a);
                sb2.append('/');
                sb2.append(eVarArr[i11].f71559b);
                i11++;
                if (i11 != eVarArr.length) {
                    sb2.append(",");
                }
            }
            return sb2.toString();
        }

        /* JADX WARN: Code duplicated, block: B:183:0x0199 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Not initialized variable reg: 3, insn: 0x0030: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:18:0x0030 */
        public Object k(ByteOrder byteOrder) throws Throwable {
            b bVar;
            InputStream inputStream;
            byte b11;
            byte b12;
            InputStream inputStream2 = null;
            try {
                try {
                    bVar = new b(this.f71553d);
                    try {
                        bVar.c(byteOrder);
                        int length = 0;
                        switch (this.f71550a) {
                            case 1:
                            case 6:
                                byte[] bArr = this.f71553d;
                                if (bArr.length != 1 || (b11 = bArr[0]) < 0 || b11 > 1) {
                                    String str = new String(bArr, a.f71508o0);
                                    try {
                                        bVar.close();
                                        break;
                                    } catch (IOException e11) {
                                        Log.e("ExifInterface", "IOException occurred while closing InputStream", e11);
                                    }
                                    return str;
                                }
                                String str2 = new String(new char[]{(char) (b11 + 48)});
                                try {
                                    bVar.close();
                                    break;
                                } catch (IOException e12) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e12);
                                }
                                return str2;
                            case 2:
                            case 7:
                                if (this.f71551b >= a.X.length) {
                                    int i11 = 0;
                                    while (true) {
                                        byte[] bArr2 = a.X;
                                        if (i11 >= bArr2.length) {
                                            length = bArr2.length;
                                        } else if (this.f71553d[i11] == bArr2[i11]) {
                                            i11++;
                                        }
                                    }
                                }
                                StringBuilder sb2 = new StringBuilder();
                                while (length < this.f71551b && (b12 = this.f71553d[length]) != 0) {
                                    if (b12 >= 32) {
                                        sb2.append((char) b12);
                                    } else {
                                        sb2.append('?');
                                    }
                                    length++;
                                }
                                String string = sb2.toString();
                                try {
                                    bVar.close();
                                    break;
                                } catch (IOException e13) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e13);
                                }
                                return string;
                            case 3:
                                int[] iArr = new int[this.f71551b];
                                while (length < this.f71551b) {
                                    iArr[length] = bVar.readUnsignedShort();
                                    length++;
                                }
                                try {
                                    bVar.close();
                                    break;
                                } catch (IOException e14) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e14);
                                }
                                return iArr;
                            case 4:
                                long[] jArr = new long[this.f71551b];
                                while (length < this.f71551b) {
                                    jArr[length] = bVar.b();
                                    length++;
                                }
                                try {
                                    bVar.close();
                                    break;
                                } catch (IOException e15) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e15);
                                }
                                return jArr;
                            case 5:
                                e[] eVarArr = new e[this.f71551b];
                                while (length < this.f71551b) {
                                    eVarArr[length] = new e(bVar.b(), bVar.b());
                                    length++;
                                }
                                try {
                                    bVar.close();
                                    break;
                                } catch (IOException e16) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e16);
                                }
                                return eVarArr;
                            case 8:
                                int[] iArr2 = new int[this.f71551b];
                                while (length < this.f71551b) {
                                    iArr2[length] = bVar.readShort();
                                    length++;
                                }
                                try {
                                    bVar.close();
                                    break;
                                } catch (IOException e17) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e17);
                                }
                                return iArr2;
                            case 9:
                                int[] iArr3 = new int[this.f71551b];
                                while (length < this.f71551b) {
                                    iArr3[length] = bVar.readInt();
                                    length++;
                                }
                                try {
                                    bVar.close();
                                    break;
                                } catch (IOException e18) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e18);
                                }
                                return iArr3;
                            case 10:
                                e[] eVarArr2 = new e[this.f71551b];
                                while (length < this.f71551b) {
                                    eVarArr2[length] = new e(bVar.readInt(), bVar.readInt());
                                    length++;
                                }
                                try {
                                    bVar.close();
                                    break;
                                } catch (IOException e19) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e19);
                                }
                                return eVarArr2;
                            case 11:
                                double[] dArr = new double[this.f71551b];
                                while (length < this.f71551b) {
                                    dArr[length] = bVar.readFloat();
                                    length++;
                                }
                                try {
                                    bVar.close();
                                    break;
                                } catch (IOException e21) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e21);
                                }
                                return dArr;
                            case 12:
                                double[] dArr2 = new double[this.f71551b];
                                while (length < this.f71551b) {
                                    dArr2[length] = bVar.readDouble();
                                    length++;
                                }
                                try {
                                    bVar.close();
                                    break;
                                } catch (IOException e22) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e22);
                                }
                                return dArr2;
                            default:
                                try {
                                    bVar.close();
                                    break;
                                } catch (IOException e23) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e23);
                                }
                                return null;
                        }
                    } catch (IOException e24) {
                        e = e24;
                        Log.w("ExifInterface", "IOException occurred during reading a value", e);
                        if (bVar != null) {
                            try {
                                bVar.close();
                            } catch (IOException e25) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e25);
                            }
                        }
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    inputStream2 = inputStream;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e26) {
                            Log.e("ExifInterface", "IOException occurred while closing InputStream", e26);
                        }
                    }
                    throw th;
                }
            } catch (IOException e27) {
                e = e27;
                bVar = null;
            } catch (Throwable th3) {
                th = th3;
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                throw th;
            }
        }

        public String toString() {
            return "(" + a.V[this.f71550a] + ", data length:" + this.f71553d.length + ")";
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f71554a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f71555b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f71556c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f71557d;

        public d(String str, int i11, int i12) {
            this.f71555b = str;
            this.f71554a = i11;
            this.f71556c = i12;
            this.f71557d = -1;
        }

        public d(String str, int i11, int i12, int i13) {
            this.f71555b = str;
            this.f71554a = i11;
            this.f71556c = i12;
            this.f71557d = i13;
        }

        public boolean a(int i11) {
            int i12;
            int i13 = this.f71556c;
            if (i13 == 7 || i11 == 7 || i13 == i11 || (i12 = this.f71557d) == i11) {
                return true;
            }
            if ((i13 == 4 || i12 == 4) && i11 == 3) {
                return true;
            }
            if ((i13 == 9 || i12 == 9) && i11 == 8) {
                return true;
            }
            return (i13 == 12 || i12 == 12) && i11 == 11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f71558a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f71559b;

        public e(long j11, long j12) {
            if (j12 == 0) {
                this.f71558a = 0L;
                this.f71559b = 1L;
            } else {
                this.f71558a = j11;
                this.f71559b = j12;
            }
        }

        public double a() {
            return this.f71558a / this.f71559b;
        }

        public String toString() {
            return this.f71558a + "/" + this.f71559b;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class f extends b {
        public f(InputStream inputStream) throws IOException {
            super(inputStream);
            if (!inputStream.markSupported()) {
                throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
            }
            this.f71546a.mark(Api.BaseClientBuilder.API_PRIORITY_OTHER);
        }

        public f(byte[] bArr) throws IOException {
            super(bArr);
            this.f71546a.mark(Api.BaseClientBuilder.API_PRIORITY_OTHER);
        }

        public void e(long j11) throws IOException {
            int i11 = this.f71548c;
            if (i11 > j11) {
                this.f71548c = 0;
                this.f71546a.reset();
            } else {
                j11 -= (long) i11;
            }
            d((int) j11);
        }
    }

    static {
        d[] dVarArr = {new d("NewSubfileType", 254, 4), new d("SubfileType", 255, 4), new d("ImageWidth", 256, 3, 4), new d("ImageLength", InputDeviceCompat.SOURCE_KEYBOARD, 3, 4), new d("BitsPerSample", 258, 3), new d("Compression", 259, 3), new d("PhotometricInterpretation", 262, 3), new d("ImageDescription", 270, 2), new d("Make", 271, 2), new d("Model", 272, 2), new d("StripOffsets", 273, 3, 4), new d("Orientation", 274, 3), new d("SamplesPerPixel", 277, 3), new d("RowsPerStrip", 278, 3, 4), new d("StripByteCounts", 279, 3, 4), new d("XResolution", 282, 5), new d("YResolution", 283, 5), new d("PlanarConfiguration", 284, 3), new d("ResolutionUnit", 296, 3), new d("TransferFunction", 301, 3), new d("Software", 305, 2), new d("DateTime", 306, 2), new d("Artist", 315, 2), new d("WhitePoint", 318, 5), new d("PrimaryChromaticities", 319, 5), new d("SubIFDPointer", 330, 4), new d("JPEGInterchangeFormat", 513, 4), new d("JPEGInterchangeFormatLength", 514, 4), new d("YCbCrCoefficients", 529, 5), new d("YCbCrSubSampling", 530, 3), new d("YCbCrPositioning", 531, 3), new d("ReferenceBlackWhite", 532, 5), new d("Copyright", 33432, 2), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("SensorTopBorder", 4, 4), new d("SensorLeftBorder", 5, 4), new d("SensorBottomBorder", 6, 4), new d("SensorRightBorder", 7, 4), new d("ISO", 23, 3), new d("JpgFromRaw", 46, 7), new d("Xmp", LogSeverity.ALERT_VALUE, 1)};
        Y = dVarArr;
        d[] dVarArr2 = {new d("ExposureTime", 33434, 5), new d("FNumber", 33437, 5), new d("ExposureProgram", 34850, 3), new d("SpectralSensitivity", 34852, 2), new d("PhotographicSensitivity", 34855, 3), new d("OECF", 34856, 7), new d("SensitivityType", 34864, 3), new d("StandardOutputSensitivity", 34865, 4), new d("RecommendedExposureIndex", 34866, 4), new d("ISOSpeed", 34867, 4), new d("ISOSpeedLatitudeyyy", 34868, 4), new d("ISOSpeedLatitudezzz", 34869, 4), new d("ExifVersion", 36864, 2), new d("DateTimeOriginal", 36867, 2), new d("DateTimeDigitized", 36868, 2), new d("OffsetTime", 36880, 2), new d("OffsetTimeOriginal", 36881, 2), new d("OffsetTimeDigitized", 36882, 2), new d("ComponentsConfiguration", 37121, 7), new d("CompressedBitsPerPixel", 37122, 5), new d("ShutterSpeedValue", 37377, 10), new d("ApertureValue", 37378, 5), new d("BrightnessValue", 37379, 10), new d("ExposureBiasValue", 37380, 10), new d("MaxApertureValue", 37381, 5), new d("SubjectDistance", 37382, 5), new d("MeteringMode", 37383, 3), new d("LightSource", 37384, 3), new d("Flash", 37385, 3), new d("FocalLength", 37386, 5), new d("SubjectArea", 37396, 3), new d("MakerNote", 37500, 7), new d("UserComment", 37510, 7), new d("SubSecTime", 37520, 2), new d("SubSecTimeOriginal", 37521, 2), new d("SubSecTimeDigitized", 37522, 2), new d("FlashpixVersion", UnixStat.LINK_FLAG, 7), new d("ColorSpace", 40961, 3), new d("PixelXDimension", 40962, 3, 4), new d("PixelYDimension", 40963, 3, 4), new d("RelatedSoundFile", 40964, 2), new d("InteroperabilityIFDPointer", 40965, 4), new d("FlashEnergy", 41483, 5), new d("SpatialFrequencyResponse", 41484, 7), new d("FocalPlaneXResolution", 41486, 5), new d("FocalPlaneYResolution", 41487, 5), new d("FocalPlaneResolutionUnit", 41488, 3), new d("SubjectLocation", 41492, 3), new d("ExposureIndex", 41493, 5), new d("SensingMethod", 41495, 3), new d("FileSource", 41728, 7), new d("SceneType", 41729, 7), new d("CFAPattern", 41730, 7), new d("CustomRendered", 41985, 3), new d("ExposureMode", 41986, 3), new d("WhiteBalance", 41987, 3), new d("DigitalZoomRatio", 41988, 5), new d("FocalLengthIn35mmFilm", 41989, 3), new d("SceneCaptureType", 41990, 3), new d("GainControl", 41991, 3), new d("Contrast", 41992, 3), new d("Saturation", 41993, 3), new d("Sharpness", 41994, 3), new d("DeviceSettingDescription", 41995, 7), new d("SubjectDistanceRange", 41996, 3), new d("ImageUniqueID", 42016, 2), new d("CameraOwnerName", 42032, 2), new d("BodySerialNumber", 42033, 2), new d("LensSpecification", 42034, 5), new d("LensMake", 42035, 2), new d("LensModel", 42036, 2), new d("Gamma", 42240, 5), new d("DNGVersion", 50706, 1), new d("DefaultCropSize", 50720, 3, 4)};
        Z = dVarArr2;
        d[] dVarArr3 = {new d("GPSVersionID", 0, 1), new d("GPSLatitudeRef", 1, 2), new d("GPSLatitude", 2, 5, 10), new d("GPSLongitudeRef", 3, 2), new d("GPSLongitude", 4, 5, 10), new d("GPSAltitudeRef", 5, 1), new d("GPSAltitude", 6, 5), new d("GPSTimeStamp", 7, 5), new d("GPSSatellites", 8, 2), new d("GPSStatus", 9, 2), new d("GPSMeasureMode", 10, 2), new d("GPSDOP", 11, 5), new d("GPSSpeedRef", 12, 2), new d("GPSSpeed", 13, 5), new d("GPSTrackRef", 14, 2), new d("GPSTrack", 15, 5), new d("GPSImgDirectionRef", 16, 2), new d("GPSImgDirection", 17, 5), new d("GPSMapDatum", 18, 2), new d("GPSDestLatitudeRef", 19, 2), new d("GPSDestLatitude", 20, 5), new d("GPSDestLongitudeRef", 21, 2), new d("GPSDestLongitude", 22, 5), new d("GPSDestBearingRef", 23, 2), new d("GPSDestBearing", 24, 5), new d("GPSDestDistanceRef", 25, 2), new d("GPSDestDistance", 26, 5), new d("GPSProcessingMethod", 27, 7), new d("GPSAreaInformation", 28, 7), new d("GPSDateStamp", 29, 2), new d("GPSDifferential", 30, 3), new d("GPSHPositioningError", 31, 5)};
        f71494a0 = dVarArr3;
        d[] dVarArr4 = {new d("InteroperabilityIndex", 1, 2)};
        f71495b0 = dVarArr4;
        d[] dVarArr5 = {new d("NewSubfileType", 254, 4), new d("SubfileType", 255, 4), new d("ThumbnailImageWidth", 256, 3, 4), new d("ThumbnailImageLength", InputDeviceCompat.SOURCE_KEYBOARD, 3, 4), new d("BitsPerSample", 258, 3), new d("Compression", 259, 3), new d("PhotometricInterpretation", 262, 3), new d("ImageDescription", 270, 2), new d("Make", 271, 2), new d("Model", 272, 2), new d("StripOffsets", 273, 3, 4), new d("ThumbnailOrientation", 274, 3), new d("SamplesPerPixel", 277, 3), new d("RowsPerStrip", 278, 3, 4), new d("StripByteCounts", 279, 3, 4), new d("XResolution", 282, 5), new d("YResolution", 283, 5), new d("PlanarConfiguration", 284, 3), new d("ResolutionUnit", 296, 3), new d("TransferFunction", 301, 3), new d("Software", 305, 2), new d("DateTime", 306, 2), new d("Artist", 315, 2), new d("WhitePoint", 318, 5), new d("PrimaryChromaticities", 319, 5), new d("SubIFDPointer", 330, 4), new d("JPEGInterchangeFormat", 513, 4), new d("JPEGInterchangeFormatLength", 514, 4), new d("YCbCrCoefficients", 529, 5), new d("YCbCrSubSampling", 530, 3), new d("YCbCrPositioning", 531, 3), new d("ReferenceBlackWhite", 532, 5), new d("Copyright", 33432, 2), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("DNGVersion", 50706, 1), new d("DefaultCropSize", 50720, 3, 4)};
        f71496c0 = dVarArr5;
        f71497d0 = new d("StripOffsets", 273, 3);
        d[] dVarArr6 = {new d("ThumbnailImage", 256, 7), new d("CameraSettingsIFDPointer", 8224, 4), new d("ImageProcessingIFDPointer", 8256, 4)};
        f71498e0 = dVarArr6;
        d[] dVarArr7 = {new d("PreviewImageStart", InputDeviceCompat.SOURCE_KEYBOARD, 4), new d("PreviewImageLength", 258, 4)};
        f71499f0 = dVarArr7;
        d[] dVarArr8 = {new d("AspectFrame", 4371, 3)};
        f71500g0 = dVarArr8;
        d[] dVarArr9 = {new d("ColorSpace", 55, 3)};
        f71501h0 = dVarArr9;
        d[][] dVarArr10 = {dVarArr, dVarArr2, dVarArr3, dVarArr4, dVarArr5, dVarArr, dVarArr6, dVarArr7, dVarArr8, dVarArr9};
        f71502i0 = dVarArr10;
        f71503j0 = new d[]{new d("SubIFDPointer", 330, 4), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("InteroperabilityIFDPointer", 40965, 4), new d("CameraSettingsIFDPointer", 8224, 1), new d("ImageProcessingIFDPointer", 8256, 1)};
        f71504k0 = new HashMap[dVarArr10.length];
        f71505l0 = new HashMap[dVarArr10.length];
        f71506m0 = new HashSet<>(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
        f71507n0 = new HashMap<>();
        Charset charsetForName = Charset.forName(C.ASCII_NAME);
        f71508o0 = charsetForName;
        f71509p0 = "Exif\u0000\u0000".getBytes(charsetForName);
        f71510q0 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(charsetForName);
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale);
        T = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
        U = simpleDateFormat2;
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("UTC"));
        int i11 = 0;
        while (true) {
            d[][] dVarArr11 = f71502i0;
            if (i11 >= dVarArr11.length) {
                HashMap<Integer, Integer> map = f71507n0;
                d[] dVarArr12 = f71503j0;
                map.put(Integer.valueOf(dVarArr12[0].f71554a), 5);
                map.put(Integer.valueOf(dVarArr12[1].f71554a), 1);
                map.put(Integer.valueOf(dVarArr12[2].f71554a), 2);
                map.put(Integer.valueOf(dVarArr12[3].f71554a), 3);
                map.put(Integer.valueOf(dVarArr12[4].f71554a), 7);
                map.put(Integer.valueOf(dVarArr12[5].f71554a), 8);
                f71511r0 = Pattern.compile(".*[1-9].*");
                f71512s0 = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
                f71513t0 = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                f71515u0 = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                return;
            }
            f71504k0[i11] = new HashMap<>();
            f71505l0[i11] = new HashMap<>();
            for (d dVar : dVarArr11[i11]) {
                f71504k0[i11].put(Integer.valueOf(dVar.f71554a), dVar);
                f71505l0[i11].put(dVar.f71555b, dVar);
            }
            i11++;
        }
    }

    public a(@NonNull InputStream inputStream) throws IOException {
        this(inputStream, 0);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0062  */
    public a(@NonNull InputStream inputStream, int i11) throws IOException {
        d[][] dVarArr = f71502i0;
        this.f71526f = new HashMap[dVarArr.length];
        this.f71527g = new HashSet(dVarArr.length);
        this.f71528h = ByteOrder.BIG_ENDIAN;
        if (inputStream == null) {
            throw new NullPointerException("inputStream cannot be null");
        }
        this.f71521a = null;
        if (i11 == 1) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, f71509p0.length);
            if (!r(bufferedInputStream)) {
                Log.w("ExifInterface", "Given data does not follow the structure of an Exif-only data.");
                return;
            }
            this.f71525e = true;
            this.f71523c = null;
            this.f71522b = null;
            inputStream = bufferedInputStream;
        } else if (inputStream instanceof AssetManager.AssetInputStream) {
            this.f71523c = (AssetManager.AssetInputStream) inputStream;
            this.f71522b = null;
        } else if (inputStream instanceof FileInputStream) {
            FileInputStream fileInputStream = (FileInputStream) inputStream;
            if (y(fileInputStream.getFD())) {
                this.f71523c = null;
                this.f71522b = fileInputStream.getFD();
            } else {
                this.f71523c = null;
                this.f71522b = null;
            }
        } else {
            this.f71523c = null;
            this.f71522b = null;
        }
        C(inputStream);
    }

    public static boolean L(int i11) {
        return (i11 == 4 || i11 == 9 || i11 == 13 || i11 == 14) ? false : true;
    }

    public static boolean r(BufferedInputStream bufferedInputStream) throws IOException {
        byte[] bArr = f71509p0;
        bufferedInputStream.mark(bArr.length);
        byte[] bArr2 = new byte[bArr.length];
        bufferedInputStream.read(bArr2);
        bufferedInputStream.reset();
        int i11 = 0;
        while (true) {
            byte[] bArr3 = f71509p0;
            if (i11 >= bArr3.length) {
                return true;
            }
            if (bArr2[i11] != bArr3[i11]) {
                return false;
            }
            i11++;
        }
    }

    public static boolean t(byte[] bArr) throws IOException {
        int i11 = 0;
        while (true) {
            byte[] bArr2 = A;
            if (i11 >= bArr2.length) {
                return true;
            }
            if (bArr[i11] != bArr2[i11]) {
                return false;
            }
            i11++;
        }
    }

    public static boolean y(FileDescriptor fileDescriptor) {
        try {
            n3.b.a.c(fileDescriptor, 0L, OsConstants.SEEK_CUR);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean A(HashMap map) throws IOException {
        c cVar = (c) map.get("ImageLength");
        c cVar2 = (c) map.get("ImageWidth");
        if (cVar == null || cVar2 == null) {
            return false;
        }
        return cVar.i(this.f71528h) <= 512 && cVar2.i(this.f71528h) <= 512;
    }

    public final boolean B(byte[] bArr) throws IOException {
        int i11 = 0;
        while (true) {
            byte[] bArr2 = K;
            if (i11 >= bArr2.length) {
                int i12 = 0;
                while (true) {
                    byte[] bArr3 = L;
                    if (i12 >= bArr3.length) {
                        return true;
                    }
                    if (bArr[K.length + i12 + 4] != bArr3[i12]) {
                        return false;
                    }
                    i12++;
                }
            } else {
                if (bArr[i11] != bArr2[i11]) {
                    return false;
                }
                i11++;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:49:0x009f A[Catch: all -> 0x0015, TRY_LEAVE, TryCatch #0 {all -> 0x0015, blocks: (B:4:0x0004, B:6:0x0009, B:13:0x001e, B:15:0x0022, B:16:0x0030, B:18:0x0038, B:20:0x0041, B:31:0x0061, B:21:0x0045, B:23:0x004b, B:26:0x0052, B:29:0x005a, B:30:0x005e, B:32:0x006b, B:34:0x0075, B:37:0x007d, B:40:0x0085, B:43:0x008d, B:47:0x009b, B:49:0x009f), top: B:60:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:63:? A[RETURN, SYNTHETIC] */
    public final void C(@NonNull InputStream inputStream) {
        boolean z11;
        if (inputStream == null) {
            throw new NullPointerException("inputstream shouldn't be null");
        }
        for (int i11 = 0; i11 < f71502i0.length; i11++) {
            try {
                try {
                    this.f71526f[i11] = new HashMap<>();
                } catch (Throwable th2) {
                    a();
                    if (f71514u) {
                        E();
                    }
                    throw th2;
                }
            } catch (IOException e11) {
                e = e11;
                z11 = f71514u;
                if (z11) {
                    Log.w("ExifInterface", "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", e);
                }
                a();
                if (!z11) {
                    return;
                }
            } catch (UnsupportedOperationException e12) {
                e = e12;
                z11 = f71514u;
                if (z11) {
                    Log.w("ExifInterface", "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", e);
                }
                a();
                if (!z11) {
                    return;
                }
            }
        }
        if (!this.f71525e) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
            this.f71524d = g(bufferedInputStream);
            inputStream = bufferedInputStream;
        }
        if (L(this.f71524d)) {
            f fVar = new f(inputStream);
            if (this.f71525e) {
                n(fVar);
            } else {
                int i12 = this.f71524d;
                if (i12 == 12) {
                    e(fVar);
                } else if (i12 == 7) {
                    h(fVar);
                } else if (i12 == 10) {
                    m(fVar);
                } else {
                    k(fVar);
                }
            }
            fVar.e(this.f71536p);
            K(fVar);
        } else {
            b bVar = new b(inputStream);
            int i13 = this.f71524d;
            if (i13 == 4) {
                f(bVar, 0, 0);
            } else if (i13 == 13) {
                i(bVar);
            } else if (i13 == 9) {
                j(bVar);
            } else if (i13 == 14) {
                o(bVar);
            }
        }
        a();
        if (!f71514u) {
            return;
        }
        E();
    }

    public final void D(b bVar) throws IOException {
        ByteOrder byteOrderF = F(bVar);
        this.f71528h = byteOrderF;
        bVar.c(byteOrderF);
        int unsignedShort = bVar.readUnsignedShort();
        int i11 = this.f71524d;
        if (i11 != 7 && i11 != 10 && unsignedShort != 42) {
            throw new IOException("Invalid start code: " + Integer.toHexString(unsignedShort));
        }
        int i12 = bVar.readInt();
        if (i12 < 8) {
            throw new IOException("Invalid first Ifd offset: " + i12);
        }
        int i13 = i12 - 8;
        if (i13 > 0) {
            bVar.d(i13);
        }
    }

    public final void E() {
        for (int i11 = 0; i11 < this.f71526f.length; i11++) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("The size of tag group[");
            sb2.append(i11);
            sb2.append("]: ");
            sb2.append(this.f71526f[i11].size());
            for (Map.Entry<String, c> entry : this.f71526f[i11].entrySet()) {
                c value = entry.getValue();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("tagName: ");
                sb3.append(entry.getKey());
                sb3.append(", tagType: ");
                sb3.append(value.toString());
                sb3.append(", tagValue: '");
                sb3.append(value.j(this.f71528h));
                sb3.append("'");
            }
        }
    }

    public final ByteOrder F(b bVar) throws IOException {
        short s11 = bVar.readShort();
        if (s11 == 18761) {
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (s11 == 19789) {
            return ByteOrder.BIG_ENDIAN;
        }
        throw new IOException("Invalid byte order: " + Integer.toHexString(s11));
    }

    public final void G(byte[] bArr, int i11) throws IOException {
        f fVar = new f(bArr);
        D(fVar);
        H(fVar, i11);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x025b  */
    /* JADX WARN: Code duplicated, block: B:102:0x028a  */
    /* JADX WARN: Code duplicated, block: B:105:0x0297  */
    /* JADX WARN: Code duplicated, block: B:107:0x02a1  */
    /* JADX WARN: Code duplicated, block: B:116:0x02cd  */
    /* JADX WARN: Code duplicated, block: B:140:0x02d0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x010b  */
    /* JADX WARN: Code duplicated, block: B:47:0x0114  */
    /* JADX WARN: Code duplicated, block: B:49:0x011a  */
    /* JADX WARN: Code duplicated, block: B:51:0x0120  */
    /* JADX WARN: Code duplicated, block: B:52:0x0130  */
    /* JADX WARN: Code duplicated, block: B:55:0x0137  */
    /* JADX WARN: Code duplicated, block: B:57:0x0145  */
    /* JADX WARN: Code duplicated, block: B:59:0x014a  */
    /* JADX WARN: Code duplicated, block: B:61:0x014d  */
    /* JADX WARN: Code duplicated, block: B:64:0x0191  */
    /* JADX WARN: Code duplicated, block: B:66:0x019c  */
    /* JADX WARN: Code duplicated, block: B:69:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:72:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:74:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:76:0x01d1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:77:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:79:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:84:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:85:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:86:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:88:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:91:0x020f  */
    /* JADX WARN: Code duplicated, block: B:93:0x021c  */
    /* JADX WARN: Code duplicated, block: B:95:0x0229 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:96:0x022b  */
    /* JADX WARN: Code duplicated, block: B:97:0x0246 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:98:0x0248  */
    public final void H(f fVar, int i11) throws IOException {
        d dVar;
        int i12;
        long j11;
        boolean z11;
        d dVar2;
        short s11;
        Integer num;
        long j12;
        int unsignedShort;
        long jB;
        int i13;
        this.f71527g.add(Integer.valueOf(fVar.f71548c));
        short s12 = fVar.readShort();
        if (f71514u) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("numberOfDirectoryEntry: ");
            sb2.append((int) s12);
        }
        if (s12 <= 0) {
            return;
        }
        char c11 = 0;
        short s13 = 0;
        while (s13 < s12) {
            int unsignedShort2 = fVar.readUnsignedShort();
            int unsignedShort3 = fVar.readUnsignedShort();
            int i14 = fVar.readInt();
            long jA = ((long) fVar.a()) + 4;
            d dVar3 = f71504k0[i11].get(Integer.valueOf(unsignedShort2));
            boolean z12 = f71514u;
            if (z12) {
                Object[] objArr = new Object[5];
                objArr[c11] = Integer.valueOf(i11);
                objArr[1] = Integer.valueOf(unsignedShort2);
                objArr[2] = dVar3 != null ? dVar3.f71555b : null;
                objArr[3] = Integer.valueOf(unsignedShort3);
                objArr[4] = Integer.valueOf(i14);
                String.format("ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d", objArr);
            }
            if (dVar3 != null) {
                if (unsignedShort3 > 0) {
                    int[] iArr = W;
                    if (unsignedShort3 < iArr.length) {
                        if (dVar3.a(unsignedShort3)) {
                            if (unsignedShort3 == 7) {
                                unsignedShort3 = dVar3.f71556c;
                            }
                            i12 = unsignedShort2;
                            dVar = dVar3;
                            j11 = ((long) iArr[unsignedShort3]) * ((long) i14);
                            if (j11 < 0 || j11 > 2147483647L) {
                                if (z12) {
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append("Skip the tag entry since the number of components is invalid: ");
                                    sb3.append(i14);
                                }
                                z11 = false;
                            } else {
                                z11 = true;
                            }
                        } else if (z12) {
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("Skip the tag entry since data format (");
                            sb4.append(V[unsignedShort3]);
                            sb4.append(") is unexpected for tag: ");
                            sb4.append(dVar3.f71555b);
                        }
                    }
                    if (z11) {
                        if (j11 > 4) {
                            i13 = fVar.readInt();
                            if (z12) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("seek to data offset: ");
                                sb5.append(i13);
                            }
                            if (this.f71524d == 7) {
                                dVar2 = dVar;
                                s11 = s13;
                                if ("MakerNote".equals(dVar2.f71555b)) {
                                    this.f71537q = i13;
                                } else if (i11 != 6 && "ThumbnailImage".equals(dVar2.f71555b)) {
                                    this.f71538r = i13;
                                    this.f71539s = i14;
                                    c cVarF = c.f(6, this.f71528h);
                                    c cVarB = c.b(this.f71538r, this.f71528h);
                                    c cVarB2 = c.b(this.f71539s, this.f71528h);
                                    this.f71526f[4].put("Compression", cVarF);
                                    this.f71526f[4].put("JPEGInterchangeFormat", cVarB);
                                    this.f71526f[4].put("JPEGInterchangeFormatLength", cVarB2);
                                }
                            } else {
                                dVar2 = dVar;
                                s11 = s13;
                            }
                            fVar.e(i13);
                        } else {
                            s12 = s12;
                            jA = jA;
                            dVar2 = dVar;
                            s11 = s13;
                        }
                        num = f71507n0.get(Integer.valueOf(i12));
                        if (z12) {
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("nextIfdType: ");
                            sb6.append(num);
                            sb6.append(" byteCount: ");
                            sb6.append(j11);
                        }
                        if (num != null) {
                            if (unsignedShort3 != 3) {
                                if (unsignedShort3 == 4) {
                                    jB = fVar.b();
                                } else if (unsignedShort3 == 8) {
                                    unsignedShort = fVar.readShort();
                                } else if (unsignedShort3 != 9 || unsignedShort3 == 13) {
                                    unsignedShort = fVar.readInt();
                                } else {
                                    jB = -1;
                                }
                                if (z12) {
                                    String.format("Offset: %d, tagName: %s", Long.valueOf(jB), dVar2.f71555b);
                                }
                                if (jB > 0) {
                                    if (!this.f71527g.contains(Integer.valueOf((int) jB))) {
                                        fVar.e(jB);
                                        H(fVar, num.intValue());
                                    } else if (z12) {
                                        StringBuilder sb7 = new StringBuilder();
                                        sb7.append("Skip jump into the IFD since it has already been read: IfdType ");
                                        sb7.append(num);
                                        sb7.append(" (at ");
                                        sb7.append(jB);
                                        sb7.append(")");
                                    }
                                } else if (z12) {
                                    StringBuilder sb8 = new StringBuilder();
                                    sb8.append("Skip jump into the IFD since its offset is invalid: ");
                                    sb8.append(jB);
                                }
                                fVar.e(jA);
                            } else {
                                unsignedShort = fVar.readUnsignedShort();
                            }
                            jB = unsignedShort;
                            if (z12) {
                                String.format("Offset: %d, tagName: %s", Long.valueOf(jB), dVar2.f71555b);
                            }
                            if (jB > 0) {
                                if (!this.f71527g.contains(Integer.valueOf((int) jB))) {
                                    fVar.e(jB);
                                    H(fVar, num.intValue());
                                } else if (z12) {
                                    StringBuilder sb9 = new StringBuilder();
                                    sb9.append("Skip jump into the IFD since it has already been read: IfdType ");
                                    sb9.append(num);
                                    sb9.append(" (at ");
                                    sb9.append(jB);
                                    sb9.append(")");
                                }
                            } else if (z12) {
                                StringBuilder sb10 = new StringBuilder();
                                sb10.append("Skip jump into the IFD since its offset is invalid: ");
                                sb10.append(jB);
                            }
                            fVar.e(jA);
                        } else {
                            j12 = jA;
                            int iA = fVar.a() + this.f71536p;
                            byte[] bArr = new byte[(int) j11];
                            fVar.readFully(bArr);
                            c cVar = new c(unsignedShort3, i14, iA, bArr);
                            this.f71526f[i11].put(dVar2.f71555b, cVar);
                            if ("DNGVersion".equals(dVar2.f71555b)) {
                                this.f71524d = 3;
                            }
                            if (((!"Make".equals(dVar2.f71555b) || "Model".equals(dVar2.f71555b)) && cVar.j(this.f71528h).contains("PENTAX")) || ("Compression".equals(dVar2.f71555b) && cVar.i(this.f71528h) == 65535)) {
                                this.f71524d = 8;
                            }
                            if (fVar.a() != j12) {
                                fVar.e(j12);
                            }
                        }
                    } else {
                        fVar.e(jA);
                        s12 = s12;
                        s11 = s13;
                    }
                    s13 = (short) (s11 + 1);
                    s12 = s12;
                    c11 = 0;
                }
                dVar = dVar3;
                i12 = unsignedShort2;
                if (z12) {
                    StringBuilder sb11 = new StringBuilder();
                    sb11.append("Skip the tag entry since data format is invalid: ");
                    sb11.append(unsignedShort3);
                }
                z11 = false;
                j11 = 0;
                if (z11) {
                    fVar.e(jA);
                    s12 = s12;
                    s11 = s13;
                } else {
                    if (j11 > 4) {
                        i13 = fVar.readInt();
                        if (z12) {
                            StringBuilder sb12 = new StringBuilder();
                            sb12.append("seek to data offset: ");
                            sb12.append(i13);
                        }
                        if (this.f71524d == 7) {
                            dVar2 = dVar;
                            s11 = s13;
                            if ("MakerNote".equals(dVar2.f71555b)) {
                                this.f71537q = i13;
                            } else if (i11 != 6) {
                            }
                        } else {
                            dVar2 = dVar;
                            s11 = s13;
                        }
                        fVar.e(i13);
                    } else {
                        s12 = s12;
                        jA = jA;
                        dVar2 = dVar;
                        s11 = s13;
                    }
                    num = f71507n0.get(Integer.valueOf(i12));
                    if (z12) {
                        StringBuilder sb13 = new StringBuilder();
                        sb13.append("nextIfdType: ");
                        sb13.append(num);
                        sb13.append(" byteCount: ");
                        sb13.append(j11);
                    }
                    if (num != null) {
                        if (unsignedShort3 != 3) {
                            if (unsignedShort3 == 4) {
                                jB = fVar.b();
                            } else if (unsignedShort3 == 8) {
                                if (unsignedShort3 != 9) {
                                }
                                unsignedShort = fVar.readInt();
                            } else {
                                unsignedShort = fVar.readShort();
                            }
                            if (z12) {
                                String.format("Offset: %d, tagName: %s", Long.valueOf(jB), dVar2.f71555b);
                            }
                            if (jB > 0) {
                                if (!this.f71527g.contains(Integer.valueOf((int) jB))) {
                                    fVar.e(jB);
                                    H(fVar, num.intValue());
                                } else if (z12) {
                                    StringBuilder sb14 = new StringBuilder();
                                    sb14.append("Skip jump into the IFD since it has already been read: IfdType ");
                                    sb14.append(num);
                                    sb14.append(" (at ");
                                    sb14.append(jB);
                                    sb14.append(")");
                                }
                            } else if (z12) {
                                StringBuilder sb15 = new StringBuilder();
                                sb15.append("Skip jump into the IFD since its offset is invalid: ");
                                sb15.append(jB);
                            }
                            fVar.e(jA);
                        } else {
                            unsignedShort = fVar.readUnsignedShort();
                        }
                        jB = unsignedShort;
                        if (z12) {
                            String.format("Offset: %d, tagName: %s", Long.valueOf(jB), dVar2.f71555b);
                        }
                        if (jB > 0) {
                            if (!this.f71527g.contains(Integer.valueOf((int) jB))) {
                                fVar.e(jB);
                                H(fVar, num.intValue());
                            } else if (z12) {
                                StringBuilder sb16 = new StringBuilder();
                                sb16.append("Skip jump into the IFD since it has already been read: IfdType ");
                                sb16.append(num);
                                sb16.append(" (at ");
                                sb16.append(jB);
                                sb16.append(")");
                            }
                        } else if (z12) {
                            StringBuilder sb17 = new StringBuilder();
                            sb17.append("Skip jump into the IFD since its offset is invalid: ");
                            sb17.append(jB);
                        }
                        fVar.e(jA);
                    } else {
                        j12 = jA;
                        int iA2 = fVar.a() + this.f71536p;
                        byte[] bArr2 = new byte[(int) j11];
                        fVar.readFully(bArr2);
                        c cVar2 = new c(unsignedShort3, i14, iA2, bArr2);
                        this.f71526f[i11].put(dVar2.f71555b, cVar2);
                        if ("DNGVersion".equals(dVar2.f71555b)) {
                            this.f71524d = 3;
                        }
                        if (!"Make".equals(dVar2.f71555b)) {
                        }
                        this.f71524d = 8;
                        if (fVar.a() != j12) {
                            fVar.e(j12);
                        }
                    }
                }
                s13 = (short) (s11 + 1);
                s12 = s12;
                c11 = 0;
            } else if (z12) {
                StringBuilder sb18 = new StringBuilder();
                sb18.append("Skip the tag entry since tag number is not defined: ");
                sb18.append(unsignedShort2);
            }
            dVar = dVar3;
            i12 = unsignedShort2;
            z11 = false;
            j11 = 0;
            if (z11) {
                fVar.e(jA);
                s12 = s12;
                s11 = s13;
            } else {
                if (j11 > 4) {
                    i13 = fVar.readInt();
                    if (z12) {
                        StringBuilder sb19 = new StringBuilder();
                        sb19.append("seek to data offset: ");
                        sb19.append(i13);
                    }
                    if (this.f71524d == 7) {
                        dVar2 = dVar;
                        s11 = s13;
                        if ("MakerNote".equals(dVar2.f71555b)) {
                            this.f71537q = i13;
                        } else if (i11 != 6) {
                        }
                    } else {
                        dVar2 = dVar;
                        s11 = s13;
                    }
                    fVar.e(i13);
                } else {
                    s12 = s12;
                    jA = jA;
                    dVar2 = dVar;
                    s11 = s13;
                }
                num = f71507n0.get(Integer.valueOf(i12));
                if (z12) {
                    StringBuilder sb110 = new StringBuilder();
                    sb110.append("nextIfdType: ");
                    sb110.append(num);
                    sb110.append(" byteCount: ");
                    sb110.append(j11);
                }
                if (num != null) {
                    if (unsignedShort3 != 3) {
                        if (unsignedShort3 == 4) {
                            jB = fVar.b();
                        } else if (unsignedShort3 == 8) {
                            if (unsignedShort3 != 9) {
                            }
                            unsignedShort = fVar.readInt();
                        } else {
                            unsignedShort = fVar.readShort();
                        }
                        if (z12) {
                            String.format("Offset: %d, tagName: %s", Long.valueOf(jB), dVar2.f71555b);
                        }
                        if (jB > 0) {
                            if (!this.f71527g.contains(Integer.valueOf((int) jB))) {
                                fVar.e(jB);
                                H(fVar, num.intValue());
                            } else if (z12) {
                                StringBuilder sb111 = new StringBuilder();
                                sb111.append("Skip jump into the IFD since it has already been read: IfdType ");
                                sb111.append(num);
                                sb111.append(" (at ");
                                sb111.append(jB);
                                sb111.append(")");
                            }
                        } else if (z12) {
                            StringBuilder sb112 = new StringBuilder();
                            sb112.append("Skip jump into the IFD since its offset is invalid: ");
                            sb112.append(jB);
                        }
                        fVar.e(jA);
                    } else {
                        unsignedShort = fVar.readUnsignedShort();
                    }
                    jB = unsignedShort;
                    if (z12) {
                        String.format("Offset: %d, tagName: %s", Long.valueOf(jB), dVar2.f71555b);
                    }
                    if (jB > 0) {
                        if (!this.f71527g.contains(Integer.valueOf((int) jB))) {
                            fVar.e(jB);
                            H(fVar, num.intValue());
                        } else if (z12) {
                            StringBuilder sb113 = new StringBuilder();
                            sb113.append("Skip jump into the IFD since it has already been read: IfdType ");
                            sb113.append(num);
                            sb113.append(" (at ");
                            sb113.append(jB);
                            sb113.append(")");
                        }
                    } else if (z12) {
                        StringBuilder sb114 = new StringBuilder();
                        sb114.append("Skip jump into the IFD since its offset is invalid: ");
                        sb114.append(jB);
                    }
                    fVar.e(jA);
                } else {
                    j12 = jA;
                    int iA3 = fVar.a() + this.f71536p;
                    byte[] bArr3 = new byte[(int) j11];
                    fVar.readFully(bArr3);
                    c cVar3 = new c(unsignedShort3, i14, iA3, bArr3);
                    this.f71526f[i11].put(dVar2.f71555b, cVar3);
                    if ("DNGVersion".equals(dVar2.f71555b)) {
                        this.f71524d = 3;
                    }
                    if (!"Make".equals(dVar2.f71555b)) {
                    }
                    this.f71524d = 8;
                    if (fVar.a() != j12) {
                        fVar.e(j12);
                    }
                }
            }
            s13 = (short) (s11 + 1);
            s12 = s12;
            c11 = 0;
        }
        int i15 = fVar.readInt();
        boolean z13 = f71514u;
        if (z13) {
            String.format("nextIfdOffset: %d", Integer.valueOf(i15));
        }
        long j13 = i15;
        if (j13 <= 0) {
            if (z13) {
                StringBuilder sb20 = new StringBuilder();
                sb20.append("Stop reading file since a wrong offset may cause an infinite loop: ");
                sb20.append(i15);
                return;
            }
            return;
        }
        if (this.f71527g.contains(Integer.valueOf(i15))) {
            if (z13) {
                StringBuilder sb21 = new StringBuilder();
                sb21.append("Stop reading file since re-reading an IFD may cause an infinite loop: ");
                sb21.append(i15);
                return;
            }
            return;
        }
        fVar.e(j13);
        if (this.f71526f[4].isEmpty()) {
            H(fVar, 4);
        } else if (this.f71526f[5].isEmpty()) {
            H(fVar, 5);
        }
    }

    public final void I(int i11, String str, String str2) {
        if (this.f71526f[i11].isEmpty() || this.f71526f[i11].get(str) == null) {
            return;
        }
        HashMap<String, c> map = this.f71526f[i11];
        map.put(str2, map.get(str));
        this.f71526f[i11].remove(str);
    }

    public final void J(f fVar, int i11) throws Throwable {
        c cVar = this.f71526f[i11].get("ImageLength");
        c cVar2 = this.f71526f[i11].get("ImageWidth");
        if (cVar == null || cVar2 == null) {
            c cVar3 = this.f71526f[i11].get("JPEGInterchangeFormat");
            c cVar4 = this.f71526f[i11].get("JPEGInterchangeFormatLength");
            if (cVar3 == null || cVar4 == null) {
                return;
            }
            int i12 = cVar3.i(this.f71528h);
            int i13 = cVar3.i(this.f71528h);
            fVar.e(i12);
            byte[] bArr = new byte[i13];
            fVar.read(bArr);
            f(new b(bArr), i12, i11);
        }
    }

    public final void K(b bVar) throws Throwable {
        HashMap<String, c> map = this.f71526f[4];
        c cVar = map.get("Compression");
        if (cVar == null) {
            this.f71535o = 6;
            p(bVar, map);
            return;
        }
        int i11 = cVar.i(this.f71528h);
        this.f71535o = i11;
        if (i11 != 1) {
            if (i11 == 6) {
                p(bVar, map);
                return;
            } else if (i11 != 7) {
                return;
            }
        }
        if (z(map)) {
            q(bVar, map);
        }
    }

    public final void M(int i11, int i12) throws Throwable {
        if (this.f71526f[i11].isEmpty() || this.f71526f[i12].isEmpty()) {
            return;
        }
        c cVar = this.f71526f[i11].get("ImageLength");
        c cVar2 = this.f71526f[i11].get("ImageWidth");
        c cVar3 = this.f71526f[i12].get("ImageLength");
        c cVar4 = this.f71526f[i12].get("ImageWidth");
        if (cVar == null || cVar2 == null || cVar3 == null || cVar4 == null) {
            return;
        }
        int i13 = cVar.i(this.f71528h);
        int i14 = cVar2.i(this.f71528h);
        int i15 = cVar3.i(this.f71528h);
        int i16 = cVar4.i(this.f71528h);
        if (i13 >= i15 || i14 >= i16) {
            return;
        }
        HashMap<String, c>[] mapArr = this.f71526f;
        HashMap<String, c> map = mapArr[i11];
        mapArr[i11] = mapArr[i12];
        mapArr[i12] = map;
    }

    public final void N(f fVar, int i11) throws Throwable {
        c cVarF;
        c cVarF2;
        c cVar = this.f71526f[i11].get("DefaultCropSize");
        c cVar2 = this.f71526f[i11].get("SensorTopBorder");
        c cVar3 = this.f71526f[i11].get("SensorLeftBorder");
        c cVar4 = this.f71526f[i11].get("SensorBottomBorder");
        c cVar5 = this.f71526f[i11].get("SensorRightBorder");
        if (cVar == null) {
            if (cVar2 == null || cVar3 == null || cVar4 == null || cVar5 == null) {
                J(fVar, i11);
                return;
            }
            int i12 = cVar2.i(this.f71528h);
            int i13 = cVar4.i(this.f71528h);
            int i14 = cVar5.i(this.f71528h);
            int i15 = cVar3.i(this.f71528h);
            if (i13 <= i12 || i14 <= i15) {
                return;
            }
            c cVarF3 = c.f(i13 - i12, this.f71528h);
            c cVarF4 = c.f(i14 - i15, this.f71528h);
            this.f71526f[i11].put("ImageLength", cVarF3);
            this.f71526f[i11].put("ImageWidth", cVarF4);
            return;
        }
        if (cVar.f71550a == 5) {
            e[] eVarArr = (e[]) cVar.k(this.f71528h);
            if (eVarArr == null || eVarArr.length != 2) {
                Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(eVarArr));
                return;
            }
            cVarF = c.d(eVarArr[0], this.f71528h);
            cVarF2 = c.d(eVarArr[1], this.f71528h);
        } else {
            int[] iArr = (int[]) cVar.k(this.f71528h);
            if (iArr == null || iArr.length != 2) {
                Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                return;
            }
            cVarF = c.f(iArr[0], this.f71528h);
            cVarF2 = c.f(iArr[1], this.f71528h);
        }
        this.f71526f[i11].put("ImageWidth", cVarF);
        this.f71526f[i11].put("ImageLength", cVarF2);
    }

    public final void O() throws Throwable {
        M(0, 5);
        M(0, 4);
        M(5, 4);
        c cVar = this.f71526f[1].get("PixelXDimension");
        c cVar2 = this.f71526f[1].get("PixelYDimension");
        if (cVar != null && cVar2 != null) {
            this.f71526f[0].put("ImageWidth", cVar);
            this.f71526f[0].put("ImageLength", cVar2);
        }
        if (this.f71526f[4].isEmpty() && A(this.f71526f[5])) {
            HashMap<String, c>[] mapArr = this.f71526f;
            mapArr[4] = mapArr[5];
            mapArr[5] = new HashMap<>();
        }
        A(this.f71526f[4]);
        I(0, "ThumbnailOrientation", "Orientation");
        I(0, "ThumbnailImageLength", "ImageLength");
        I(0, "ThumbnailImageWidth", "ImageWidth");
        I(5, "ThumbnailOrientation", "Orientation");
        I(5, "ThumbnailImageLength", "ImageLength");
        I(5, "ThumbnailImageWidth", "ImageWidth");
        I(4, "Orientation", "ThumbnailOrientation");
        I(4, "ImageLength", "ThumbnailImageLength");
        I(4, "ImageWidth", "ThumbnailImageWidth");
    }

    public final void a() {
        String strB = b("DateTimeOriginal");
        if (strB != null && b("DateTime") == null) {
            this.f71526f[0].put("DateTime", c.a(strB));
        }
        if (b("ImageWidth") == null) {
            this.f71526f[0].put("ImageWidth", c.b(0L, this.f71528h));
        }
        if (b("ImageLength") == null) {
            this.f71526f[0].put("ImageLength", c.b(0L, this.f71528h));
        }
        if (b("Orientation") == null) {
            this.f71526f[0].put("Orientation", c.b(0L, this.f71528h));
        }
        if (b("LightSource") == null) {
            this.f71526f[1].put("LightSource", c.b(0L, this.f71528h));
        }
    }

    @Nullable
    public String b(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        c cVarD = d(str);
        if (cVarD != null) {
            if (!f71506m0.contains(str)) {
                return cVarD.j(this.f71528h);
            }
            if (str.equals("GPSTimeStamp")) {
                int i11 = cVarD.f71550a;
                if (i11 != 5 && i11 != 10) {
                    Log.w("ExifInterface", "GPS Timestamp format is not rational. format=" + cVarD.f71550a);
                    return null;
                }
                e[] eVarArr = (e[]) cVarD.k(this.f71528h);
                if (eVarArr != null && eVarArr.length == 3) {
                    e eVar = eVarArr[0];
                    e eVar2 = eVarArr[1];
                    e eVar3 = eVarArr[2];
                    return String.format("%02d:%02d:%02d", Integer.valueOf((int) (eVar.f71558a / eVar.f71559b)), Integer.valueOf((int) (eVar2.f71558a / eVar2.f71559b)), Integer.valueOf((int) (eVar3.f71558a / eVar3.f71559b)));
                }
                Log.w("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(eVarArr));
                return null;
            }
            try {
                return Double.toString(cVarD.h(this.f71528h));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public int c(@NonNull String str, int i11) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        c cVarD = d(str);
        if (cVarD == null) {
            return i11;
        }
        try {
            return cVarD.i(this.f71528h);
        } catch (NumberFormatException unused) {
            return i11;
        }
    }

    @Nullable
    public final c d(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        if ("ISOSpeedRatings".equals(str)) {
            str = "PhotographicSensitivity";
        }
        for (int i11 = 0; i11 < f71502i0.length; i11++) {
            c cVar = this.f71526f[i11].get(str);
            if (cVar != null) {
                return cVar;
            }
        }
        return null;
    }

    public final void e(f fVar) throws IOException {
        String strExtractMetadata;
        String strExtractMetadata2;
        String strExtractMetadata3;
        int i11;
        if (Build.VERSION.SDK_INT < 28) {
            throw new UnsupportedOperationException("Reading EXIF from HEIF files is supported from SDK 28 and above");
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                n3.b.C0767b.a(mediaMetadataRetriever, new C0766a(fVar));
                String strExtractMetadata4 = mediaMetadataRetriever.extractMetadata(33);
                String strExtractMetadata5 = mediaMetadataRetriever.extractMetadata(34);
                String strExtractMetadata6 = mediaMetadataRetriever.extractMetadata(26);
                String strExtractMetadata7 = mediaMetadataRetriever.extractMetadata(17);
                if ("yes".equals(strExtractMetadata6)) {
                    strExtractMetadata = mediaMetadataRetriever.extractMetadata(29);
                    strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(30);
                    strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(31);
                } else if ("yes".equals(strExtractMetadata7)) {
                    strExtractMetadata = mediaMetadataRetriever.extractMetadata(18);
                    strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                    strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(24);
                } else {
                    strExtractMetadata = null;
                    strExtractMetadata2 = null;
                    strExtractMetadata3 = null;
                }
                if (strExtractMetadata != null) {
                    this.f71526f[0].put("ImageWidth", c.f(Integer.parseInt(strExtractMetadata), this.f71528h));
                }
                if (strExtractMetadata2 != null) {
                    this.f71526f[0].put("ImageLength", c.f(Integer.parseInt(strExtractMetadata2), this.f71528h));
                }
                if (strExtractMetadata3 != null) {
                    int i12 = Integer.parseInt(strExtractMetadata3);
                    if (i12 == 90) {
                        i11 = 6;
                    } else if (i12 != 180) {
                        i11 = i12 != 270 ? 1 : 8;
                    } else {
                        i11 = 3;
                    }
                    this.f71526f[0].put("Orientation", c.f(i11, this.f71528h));
                }
                if (strExtractMetadata4 != null && strExtractMetadata5 != null) {
                    int i13 = Integer.parseInt(strExtractMetadata4);
                    int i14 = Integer.parseInt(strExtractMetadata5);
                    if (i14 <= 6) {
                        throw new IOException("Invalid exif length");
                    }
                    fVar.e(i13);
                    byte[] bArr = new byte[6];
                    if (fVar.read(bArr) != 6) {
                        throw new IOException("Can't read identifier");
                    }
                    int i15 = i13 + 6;
                    int i16 = i14 - 6;
                    if (!Arrays.equals(bArr, f71509p0)) {
                        throw new IOException("Invalid identifier");
                    }
                    byte[] bArr2 = new byte[i16];
                    if (fVar.read(bArr2) != i16) {
                        throw new IOException("Can't read exif");
                    }
                    this.f71536p = i15;
                    G(bArr2, 0);
                }
                if (f71514u) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Heif meta: ");
                    sb2.append(strExtractMetadata);
                    sb2.append("x");
                    sb2.append(strExtractMetadata2);
                    sb2.append(", rotation ");
                    sb2.append(strExtractMetadata3);
                }
                mediaMetadataRetriever.release();
            } catch (RuntimeException unused) {
                throw new UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.");
            }
        } catch (Throwable th2) {
            mediaMetadataRetriever.release();
            throw th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00a0 A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:36:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:37:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:40:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:41:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:63:0x0161 A[LOOP:0: B:10:0x002e->B:63:0x0161, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:81:0x0168 A[SYNTHETIC] */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1092)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:419)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:91)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:31)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:399)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:31)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:91)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:21)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    public final void f(n3.a.b r21, int r22, int r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 506
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.a.f(n3.a$b, int, int):void");
    }

    public final int g(BufferedInputStream bufferedInputStream) throws IOException {
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (t(bArr)) {
            return 4;
        }
        if (w(bArr)) {
            return 9;
        }
        if (s(bArr)) {
            return 12;
        }
        if (u(bArr)) {
            return 7;
        }
        if (x(bArr)) {
            return 10;
        }
        if (v(bArr)) {
            return 13;
        }
        return B(bArr) ? 14 : 0;
    }

    public final void h(f fVar) throws Throwable {
        int i11;
        int i12;
        k(fVar);
        c cVar = this.f71526f[1].get("MakerNote");
        if (cVar != null) {
            f fVar2 = new f(cVar.f71553d);
            fVar2.c(this.f71528h);
            byte[] bArr = E;
            byte[] bArr2 = new byte[bArr.length];
            fVar2.readFully(bArr2);
            fVar2.e(0L);
            byte[] bArr3 = F;
            byte[] bArr4 = new byte[bArr3.length];
            fVar2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                fVar2.e(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                fVar2.e(12L);
            }
            H(fVar2, 6);
            c cVar2 = this.f71526f[7].get("PreviewImageStart");
            c cVar3 = this.f71526f[7].get("PreviewImageLength");
            if (cVar2 != null && cVar3 != null) {
                this.f71526f[5].put("JPEGInterchangeFormat", cVar2);
                this.f71526f[5].put("JPEGInterchangeFormatLength", cVar3);
            }
            c cVar4 = this.f71526f[8].get("AspectFrame");
            if (cVar4 != null) {
                int[] iArr = (int[]) cVar4.k(this.f71528h);
                if (iArr == null || iArr.length != 4) {
                    Log.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
                    return;
                }
                int i13 = iArr[2];
                int i14 = iArr[0];
                if (i13 <= i14 || (i11 = iArr[3]) <= (i12 = iArr[1])) {
                    return;
                }
                int i15 = (i13 - i14) + 1;
                int i16 = (i11 - i12) + 1;
                if (i15 < i16) {
                    int i17 = i15 + i16;
                    i16 = i17 - i16;
                    i15 = i17 - i16;
                }
                c cVarF = c.f(i15, this.f71528h);
                c cVarF2 = c.f(i16, this.f71528h);
                this.f71526f[0].put("ImageWidth", cVarF);
                this.f71526f[0].put("ImageLength", cVarF2);
            }
        }
    }

    public final void i(b bVar) throws Throwable {
        if (f71514u) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getPngAttributes starting with: ");
            sb2.append(bVar);
        }
        bVar.c(ByteOrder.BIG_ENDIAN);
        byte[] bArr = G;
        bVar.d(bArr.length);
        int length = bArr.length;
        while (true) {
            try {
                int i11 = bVar.readInt();
                byte[] bArr2 = new byte[4];
                if (bVar.read(bArr2) != 4) {
                    throw new IOException("Encountered invalid length while parsing PNG chunktype");
                }
                int i12 = length + 8;
                if (i12 == 16 && !Arrays.equals(bArr2, I)) {
                    throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                }
                if (Arrays.equals(bArr2, J)) {
                    return;
                }
                if (Arrays.equals(bArr2, H)) {
                    byte[] bArr3 = new byte[i11];
                    if (bVar.read(bArr3) != i11) {
                        throw new IOException("Failed to read given length for given PNG chunk type: " + n3.b.a(bArr2));
                    }
                    int i13 = bVar.readInt();
                    CRC32 crc32 = new CRC32();
                    crc32.update(bArr2);
                    crc32.update(bArr3);
                    if (((int) crc32.getValue()) == i13) {
                        this.f71536p = i12;
                        G(bArr3, 0);
                        O();
                        K(new b(bArr3));
                        return;
                    }
                    throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + i13 + ", calculated CRC value: " + crc32.getValue());
                }
                int i14 = i11 + 4;
                bVar.d(i14);
                length = i12 + i14;
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    public final void j(b bVar) throws Throwable {
        boolean z11 = f71514u;
        if (z11) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getRafAttributes starting with: ");
            sb2.append(bVar);
        }
        bVar.d(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        bVar.read(bArr);
        bVar.read(bArr2);
        bVar.read(bArr3);
        int i11 = ByteBuffer.wrap(bArr).getInt();
        int i12 = ByteBuffer.wrap(bArr2).getInt();
        int i13 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i12];
        bVar.d(i11 - bVar.a());
        bVar.read(bArr4);
        f(new b(bArr4), i11, 5);
        bVar.d(i13 - bVar.a());
        bVar.c(ByteOrder.BIG_ENDIAN);
        int i14 = bVar.readInt();
        if (z11) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("numberOfDirectoryEntry: ");
            sb3.append(i14);
        }
        for (int i15 = 0; i15 < i14; i15++) {
            int unsignedShort = bVar.readUnsignedShort();
            int unsignedShort2 = bVar.readUnsignedShort();
            if (unsignedShort == f71497d0.f71554a) {
                short s11 = bVar.readShort();
                short s12 = bVar.readShort();
                c cVarF = c.f(s11, this.f71528h);
                c cVarF2 = c.f(s12, this.f71528h);
                this.f71526f[0].put("ImageLength", cVarF);
                this.f71526f[0].put("ImageWidth", cVarF2);
                if (f71514u) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Updated to length: ");
                    sb4.append((int) s11);
                    sb4.append(", width: ");
                    sb4.append((int) s12);
                    return;
                }
                return;
            }
            bVar.d(unsignedShort2);
        }
    }

    public final void k(f fVar) throws Throwable {
        c cVar;
        D(fVar);
        H(fVar, 0);
        N(fVar, 0);
        N(fVar, 5);
        N(fVar, 4);
        O();
        if (this.f71524d != 8 || (cVar = this.f71526f[1].get("MakerNote")) == null) {
            return;
        }
        f fVar2 = new f(cVar.f71553d);
        fVar2.c(this.f71528h);
        fVar2.d(6);
        H(fVar2, 9);
        c cVar2 = this.f71526f[9].get("ColorSpace");
        if (cVar2 != null) {
            this.f71526f[1].put("ColorSpace", cVar2);
        }
    }

    public int l() {
        switch (c("Orientation", 1)) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 8:
                return 270;
            case 6:
            case 7:
                return 90;
            default:
                return 0;
        }
    }

    public final void m(f fVar) throws Throwable {
        if (f71514u) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getRw2Attributes starting with: ");
            sb2.append(fVar);
        }
        k(fVar);
        c cVar = this.f71526f[0].get("JpgFromRaw");
        if (cVar != null) {
            f(new b(cVar.f71553d), (int) cVar.f71552c, 5);
        }
        c cVar2 = this.f71526f[0].get("ISO");
        c cVar3 = this.f71526f[1].get("PhotographicSensitivity");
        if (cVar2 == null || cVar3 != null) {
            return;
        }
        this.f71526f[1].put("PhotographicSensitivity", cVar2);
    }

    public final void n(f fVar) throws IOException {
        byte[] bArr = f71509p0;
        fVar.d(bArr.length);
        byte[] bArr2 = new byte[fVar.available()];
        fVar.readFully(bArr2);
        this.f71536p = bArr.length;
        G(bArr2, 0);
    }

    public final void o(b bVar) throws Throwable {
        if (f71514u) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getWebpAttributes starting with: ");
            sb2.append(bVar);
        }
        bVar.c(ByteOrder.LITTLE_ENDIAN);
        bVar.d(K.length);
        int i11 = bVar.readInt() + 8;
        byte[] bArr = L;
        bVar.d(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                if (bVar.read(bArr2) != 4) {
                    throw new IOException("Encountered invalid length while parsing WebP chunktype");
                }
                int i12 = bVar.readInt();
                int i13 = length + 8;
                if (Arrays.equals(M, bArr2)) {
                    byte[] bArr3 = new byte[i12];
                    if (bVar.read(bArr3) == i12) {
                        this.f71536p = i13;
                        G(bArr3, 0);
                        K(new b(bArr3));
                        return;
                    } else {
                        throw new IOException("Failed to read given length for given PNG chunk type: " + n3.b.a(bArr2));
                    }
                }
                if (i12 % 2 == 1) {
                    i12++;
                }
                length = i13 + i12;
                if (length == i11) {
                    return;
                }
                if (length > i11) {
                    throw new IOException("Encountered WebP file with invalid chunk size");
                }
                bVar.d(i12);
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    public final void p(b bVar, HashMap map) throws Throwable {
        c cVar = (c) map.get("JPEGInterchangeFormat");
        c cVar2 = (c) map.get("JPEGInterchangeFormatLength");
        if (cVar == null || cVar2 == null) {
            return;
        }
        int i11 = cVar.i(this.f71528h);
        int i12 = cVar2.i(this.f71528h);
        if (this.f71524d == 7) {
            i11 += this.f71537q;
        }
        if (i11 > 0 && i12 > 0) {
            this.f71529i = true;
            if (this.f71521a == null && this.f71523c == null && this.f71522b == null) {
                byte[] bArr = new byte[i12];
                bVar.skip(i11);
                bVar.read(bArr);
                this.f71534n = bArr;
            }
            this.f71532l = i11;
            this.f71533m = i12;
        }
        if (f71514u) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Setting thumbnail attributes with offset: ");
            sb2.append(i11);
            sb2.append(", length: ");
            sb2.append(i12);
        }
    }

    public final void q(b bVar, HashMap map) throws IOException {
        c cVar = (c) map.get("StripOffsets");
        c cVar2 = (c) map.get("StripByteCounts");
        if (cVar == null || cVar2 == null) {
            return;
        }
        long[] jArrB = n3.b.b(cVar.k(this.f71528h));
        long[] jArrB2 = n3.b.b(cVar2.k(this.f71528h));
        if (jArrB == null || jArrB.length == 0) {
            Log.w("ExifInterface", "stripOffsets should not be null or have zero length.");
            return;
        }
        if (jArrB2 == null || jArrB2.length == 0) {
            Log.w("ExifInterface", "stripByteCounts should not be null or have zero length.");
            return;
        }
        if (jArrB.length != jArrB2.length) {
            Log.w("ExifInterface", "stripOffsets and stripByteCounts should have same length.");
            return;
        }
        long j11 = 0;
        for (long j12 : jArrB2) {
            j11 += j12;
        }
        int i11 = (int) j11;
        byte[] bArr = new byte[i11];
        int i12 = 1;
        this.f71531k = true;
        this.f71530j = true;
        this.f71529i = true;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i13 < jArrB.length) {
            int i16 = (int) jArrB[i13];
            int i17 = (int) jArrB2[i13];
            if (i13 < jArrB.length - i12 && i16 + i17 != jArrB[i13 + 1]) {
                this.f71531k = false;
            }
            int i18 = i16 - i14;
            if (i18 < 0) {
                return;
            }
            long j13 = i18;
            if (bVar.skip(j13) != j13) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed to skip ");
                sb2.append(i18);
                sb2.append(" bytes.");
                return;
            }
            int i19 = i14 + i18;
            byte[] bArr2 = new byte[i17];
            if (bVar.read(bArr2) != i17) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Failed to read ");
                sb3.append(i17);
                sb3.append(" bytes.");
                return;
            }
            i14 = i19 + i17;
            System.arraycopy(bArr2, 0, bArr, i15, i17);
            i15 += i17;
            i13++;
            i12 = 1;
        }
        this.f71534n = bArr;
        if (this.f71531k) {
            this.f71532l = (int) jArrB[0];
            this.f71533m = i11;
        }
    }

    public final boolean s(byte[] bArr) throws Throwable {
        long j11;
        b bVar = null;
        try {
            b bVar2 = new b(bArr);
            try {
                long length = bVar2.readInt();
                byte[] bArr2 = new byte[4];
                bVar2.read(bArr2);
                if (!Arrays.equals(bArr2, B)) {
                    bVar2.close();
                    return false;
                }
                if (length == 1) {
                    length = bVar2.readLong();
                    j11 = 16;
                    if (length < 16) {
                        bVar2.close();
                        return false;
                    }
                } else {
                    j11 = 8;
                }
                if (length > bArr.length) {
                    length = bArr.length;
                }
                long j12 = length - j11;
                if (j12 < 8) {
                    bVar2.close();
                    return false;
                }
                byte[] bArr3 = new byte[4];
                boolean z11 = false;
                boolean z12 = false;
                for (long j13 = 0; j13 < j12 / 4; j13++) {
                    if (bVar2.read(bArr3) != 4) {
                        bVar2.close();
                        return false;
                    }
                    if (j13 != 1) {
                        if (Arrays.equals(bArr3, C)) {
                            z11 = true;
                        } else if (Arrays.equals(bArr3, D)) {
                            z12 = true;
                        }
                        if (z11 && z12) {
                            bVar2.close();
                            return true;
                        }
                    }
                }
                bVar2.close();
            } catch (Exception unused) {
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
            } catch (Throwable th2) {
                th = th2;
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            th = th3;
        }
        return false;
    }

    public final boolean u(byte[] bArr) throws Throwable {
        b bVar = null;
        try {
            b bVar2 = new b(bArr);
            try {
                ByteOrder byteOrderF = F(bVar2);
                this.f71528h = byteOrderF;
                bVar2.c(byteOrderF);
                short s11 = bVar2.readShort();
                boolean z11 = s11 == 20306 || s11 == 21330;
                bVar2.close();
                return z11;
            } catch (Exception unused) {
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public final boolean v(byte[] bArr) throws IOException {
        int i11 = 0;
        while (true) {
            byte[] bArr2 = G;
            if (i11 >= bArr2.length) {
                return true;
            }
            if (bArr[i11] != bArr2[i11]) {
                return false;
            }
            i11++;
        }
    }

    public final boolean w(byte[] bArr) throws IOException {
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        for (int i11 = 0; i11 < bytes.length; i11++) {
            if (bArr[i11] != bytes[i11]) {
                return false;
            }
        }
        return true;
    }

    public final boolean x(byte[] bArr) throws Throwable {
        b bVar = null;
        try {
            b bVar2 = new b(bArr);
            try {
                ByteOrder byteOrderF = F(bVar2);
                this.f71528h = byteOrderF;
                bVar2.c(byteOrderF);
                boolean z11 = bVar2.readShort() == 85;
                bVar2.close();
                return z11;
            } catch (Exception unused) {
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public final boolean z(HashMap map) throws Throwable {
        c cVar;
        c cVar2 = (c) map.get("BitsPerSample");
        if (cVar2 == null) {
            return false;
        }
        int[] iArr = (int[]) cVar2.k(this.f71528h);
        int[] iArr2 = f71518x;
        if (Arrays.equals(iArr2, iArr)) {
            return true;
        }
        if (this.f71524d != 3 || (cVar = (c) map.get("PhotometricInterpretation")) == null) {
            return false;
        }
        int i11 = cVar.i(this.f71528h);
        return (i11 == 1 && Arrays.equals(iArr, f71520z)) || (i11 == 6 && Arrays.equals(iArr, iArr2));
    }
}
