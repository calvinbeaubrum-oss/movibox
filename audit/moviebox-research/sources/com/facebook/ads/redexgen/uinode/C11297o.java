package com.facebook.ads.redexgen.uinode;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.os.Looper;
import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.facebook.ads.internal.util.process.ProcessUtils;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import okhttp3.internal.ws.WebSocketProtocol;
import okio.Utf8;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7o, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C11297o {
    public static byte[] A04;
    public static String[] A05 = {"qJOvsPrm5BQkhL6wLJahauzjA45r7dQz", "hfx8x2hkXgxq19RSFkkqiaOe1zMy03Qo", "bV5o7GaQth4ZZOPd4LFtWwXjKNVB8lua", "1EyYFmGpmEhL9EWyl0I1ptwRPtnJxpez", "F", "i", "plO80lk7YnGQvaXazMopbLIwOg8MB0TR", "EzLFA06L6a2SQhX4934tm7serJXXg4XA"};
    public static final String A06;
    public static final Lock A07;
    public static final Lock A08;
    public static final ReentrantReadWriteLock A09;
    public SQLiteOpenHelper A00;
    public final C1794Ym A01;
    public final C1792Yk A03 = new C1792Yk(this);
    public final C1793Yl A02 = new C1793Yl(this);

    static {
        A07();
        StringBuilder sbAppend = new StringBuilder().append(A05(107, 14, 91)).append(C1792Yk.A02.A01);
        String strA05 = A05(58, 2, 51);
        StringBuilder sbAppend2 = sbAppend.append(strA05);
        String strA06 = A05(142, 6, 16);
        StringBuilder sbAppend3 = sbAppend2.append(strA06);
        String strA07 = A05(60, 1, 106);
        StringBuilder sbAppend4 = sbAppend3.append(strA07).append(C1792Yk.A01.A01).append(strA05);
        String strA08 = A05(136, 6, 111);
        A06 = sbAppend4.append(strA08).append(strA07).append(C1793Yl.A04.A01).append(strA05).append(strA08).append(strA07).append(C1793Yl.A05.A01).append(strA05).append(strA08).append(strA07).append(C1793Yl.A0A.A01).append(strA05).append(strA08).append(strA07).append(C1793Yl.A08.A01).append(strA05).append(strA08).append(strA07).append(C1793Yl.A07.A01).append(strA05).append(strA08).append(strA07).append(C1793Yl.A06.A01).append(strA05).append(strA08).append(strA07).append(C1793Yl.A03.A01).append(strA05).append(strA08).append(strA07).append(C1793Yl.A02.A01).append(A05(11, 6, 42)).append(strA08).append(A05(17, 6, 65)).append(strA06).append(A05(30, 4, 3)).append(strA08).append(strA07).append(C1793Yl.A09.A01).append(A05(0, 3, 78)).append(strA06).append(strA07).append(C1792Yk.A02.A01).append(A05(34, 10, 74)).append(strA08).append(strA07).append(C1793Yl.A08.A01).append(A05(7, 4, 98)).toString();
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        A09 = reentrantReadWriteLock;
        A07 = reentrantReadWriteLock.readLock();
        A08 = reentrantReadWriteLock.writeLock();
    }

    public C11297o(C1794Ym c1794Ym) {
        this.A01 = c1794Ym;
    }

    private synchronized SQLiteDatabase A00() {
        if (this.A00 == null) {
            final C1794Ym c1794Ym = this.A01;
            this.A00 = new SQLiteOpenHelper(c1794Ym, this) { // from class: com.facebook.ads.redexgen.X.7p
                public static byte[] A01;
                public static String[] A02 = {"JShIJu3JRfHt43ypO9GqFaXtQU", "Uet3LTw8rLJmru1DFWkYPrIPq9yjzQ4", "LBYTyoU1fD8w8O4ue", "ZxNu1nQjo2XkCjw5ERk40jWGoeLjYM9V", "VhJY3C97J7J84q76u4hEYHgB0g", "Ro8Wdk2EPx5GRn22XYsr1QjtSyjSX", "SdOPztDY16h0BPmxgfN82QFEWJhjV", "9YM807W9r6X84VXv6l9L7RtBJQk8UQ"};
                public static final String A03;
                public final C11297o A00;

                static {
                    A02();
                    A03 = C11307p.class.getSimpleName();
                }

                {
                    super(c1794Ym, A01(c1794Ym), (SQLiteDatabase.CursorFactory) null, 4);
                    if (this == null) {
                        throw new IllegalArgumentException(A00(41, 32, 87));
                    }
                    this.A00 = this;
                }

                public static String A00(int i11, int i12, int i13) {
                    byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
                    for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
                        bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 76);
                    }
                    return new String(bArrCopyOfRange);
                }

                public static String A01(C1794Ym c1794Ym2) {
                    Locale locale = Locale.US;
                    Object[] objArr = {A00(0, 0, 95)};
                    String strA00 = A00(WebSocketProtocol.PAYLOAD_SHORT, 8, 81);
                    String str = String.format(locale, strA00, objArr);
                    if (!C1384Ih.A2C(c1794Ym2)) {
                        return str;
                    }
                    String packageName = c1794Ym2.getPackageName();
                    String processName = ProcessUtils.getProcessName(c1794Ym2);
                    return (packageName.equals(processName) || TextUtils.isEmpty(processName)) ? str : String.format(Locale.US, strA00, '_' + processName);
                }

                public static void A02() {
                    A01 = new byte[]{17, 1, 101, 100, 103, 96, 116, 109, 117, 1, 17, 48, 61, 37, 52, 35, 81, 37, 48, 51, 61, 52, 81, Ascii.DC4, 7, Ascii.DC4, Ascii.US, 5, 2, 81, 48, 53, 53, 81, 50, 62, 61, 36, 60, Utf8.REPLACEMENT_BYTE, 81, 90, Ascii.DEL, 95, 122, 111, 122, 121, 122, 104, 126, 83, 126, 119, 107, 126, 105, 59, 120, 122, 117, 59, 117, 116, 111, 59, 121, 126, 59, 117, 110, 119, 119, 33, 55, 42, 53, 69, 49, 36, 39, 41, 32, 69, 44, 35, 69, 32, 61, 44, 54, 49, 54, 69, 6, Ascii.ETB, 4, Ascii.SYN, Ascii.CR, 0, Ascii.SYN, 88, 90, 73, 79, 69, 73, 40, 110, 103, 122, 109, 97, 111, 102, 87, 99, 109, 113, 123, 40, 53, 40, 71, 70, 51, 124, 121, 110, 56, 110, 51, 121, Ascii.DEL};
                }

                @Override // android.database.sqlite.SQLiteOpenHelper
                public final void onCreate(SQLiteDatabase sQLiteDatabase) {
                    for (AbstractC11327s abstractC11327s : this.A00.A0M()) {
                        abstractC11327s.A07(sQLiteDatabase);
                    }
                }

                @Override // android.database.sqlite.SQLiteOpenHelper
                public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
                    for (AbstractC11327s abstractC11327s : this.A00.A0M()) {
                        abstractC11327s.A08(sQLiteDatabase);
                        abstractC11327s.A07(sQLiteDatabase);
                    }
                }

                @Override // android.database.sqlite.SQLiteOpenHelper
                public final void onOpen(SQLiteDatabase sQLiteDatabase) {
                    super.onOpen(sQLiteDatabase);
                    if (sQLiteDatabase.isReadOnly()) {
                        return;
                    }
                    sQLiteDatabase.execSQL(A00(101, 25, 68));
                }

                @Override // android.database.sqlite.SQLiteOpenHelper
                public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
                    if (i11 == 2 && i12 >= 3) {
                        String strA00 = A00(73, 28, 41);
                        if (A02[7].length() != 30) {
                            throw new RuntimeException();
                        }
                        A02[3] = "Uy0CZyDaBZXeJSQ63Y80hAJR5wsAelR7";
                        sQLiteDatabase.execSQL(strA00);
                    }
                    if (i11 > 3 || i12 < 4) {
                        return;
                    }
                    C11287m c11287m = C1793Yl.A02;
                    sQLiteDatabase.execSQL(A00(11, 30, 61) + c11287m.A01 + A00(0, 1, 125) + c11287m.A02 + A00(1, 10, 109));
                }
            };
        }
        return this.A00.getWritableDatabase();
    }

    private synchronized SQLiteDatabase A01() {
        SQLiteException e11 = null;
        for (int i11 = 0; i11 < 10; i11++) {
            try {
            } catch (SQLiteException e12) {
                e11 = e12;
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException unused) {
                }
            }
        }
        this.A01.A07().A9a(A05(128, 8, 84), C8A.A0v, new C8B(e11));
        throw e11;
        return A00();
    }

    public static String A05(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i11, i11 + i12);
        int i14 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A05[3].charAt(0) != '1') {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[0] = "6YOEgEHO6bjbd5au9bSAefu6W5tI3Dak";
            strArr[6] = "kgOgsYcmlOEy6T8oxoaixHiO6WRSp1D2";
            if (i14 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 115);
            i14++;
        }
    }

    public static void A07() {
        A04 = new byte[]{-31, -2, -31, -81, -51, -81, -50, -11, Ascii.SYN, 40, Ascii.CAN, -67, -29, -17, -20, -22, -67, -44, -2, 3, -3, 2, -44, -108, -64, -67, -63, -67, -56, -108, -106, -59, -60, -106, -35, Ascii.FF, Ascii.SI, 1, 2, Ascii.SI, -35, -1, Ascii.SYN, -35, -42, 9, -5, 10, -42, -98, -43, -58, -61, -48, -61, -98, -49, -43, -46, -58, Ascii.VT, 3, -54, -52, Ascii.SYN, 52, 65, 65, 66, 71, -13, 54, 52, Utf8.REPLACEMENT_BYTE, Utf8.REPLACEMENT_BYTE, -13, 58, 56, 71, Ascii.ETB, 52, 71, 52, 53, 52, 70, 56, -13, 57, 69, 66, 64, -13, 71, 59, 56, -13, 40, Ascii.FS, -13, 71, 59, 69, 56, 52, 55, -12, 33, 19, Ascii.SUB, 19, 17, 34, -18, 66, 61, 57, 51, 60, 65, -4, 39, 34, Ascii.SYN, 19, 38, Ascii.ETB, -14, 43, 40, 59, 40, 41, 40, 58, 44, 71, 88, 71, 80, 86, 85, -9, -14, -18, -24, -15, -10};
    }

    public final int A08(int i11) {
        A08.lock();
        try {
            return A0E().delete(A05(136, 6, 111), C1793Yl.A02.A01 + A05(3, 4, 28), new String[]{String.valueOf(i11 - 1)});
        } finally {
            A08.unlock();
        }
    }

    public final Cursor A09() {
        A07.lock();
        try {
            return this.A02.A0B();
        } finally {
            A07.unlock();
        }
    }

    public final Cursor A0A() {
        A07.lock();
        try {
            return this.A02.A0C();
        } finally {
            A07.unlock();
        }
    }

    public final Cursor A0B() {
        A07.lock();
        try {
            return this.A03.A0B();
        } finally {
            A07.unlock();
        }
    }

    public final Cursor A0C(int i11) {
        A07.lock();
        try {
            return A0E().rawQuery(A06 + A05(23, 7, 1) + String.valueOf(i11), null);
        } finally {
            A07.unlock();
        }
    }

    public final Cursor A0D(String str) {
        A07.lock();
        try {
            return this.A02.A0D(str);
        } finally {
            A07.unlock();
        }
    }

    public final SQLiteDatabase A0E() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return A01();
        }
        throw new IllegalStateException(A05(64, 43, 96));
    }

    public final <T> AsyncTask A0F(final AbstractC11317r<T> abstractC11317r, final AbstractC11588t<T> abstractC11588t) {
        Executor executor = ExecutorC1467Lt.A07;
        final C1794Ym c1794Ym = this.A01;
        return AbstractC1464Lq.A00(executor, new AsyncTask<Void, Void, T>(c1794Ym, abstractC11317r, abstractC11588t) { // from class: com.facebook.ads.redexgen.X.7n
            public static byte[] A04;
            public static String[] A05 = {"65r9CRdv0GoLRVNVjbjXzJK5P2ycj7FG", "0CWnyuhck9HOQgwCfxzQ09GVkx", "IEC2mc7xTTQi8lqWDODmms9jEFByhoZx", "6exEWFSZK9oTcnxcvUurXohDGqhdlb0H", "22QzghXqrFZ4DBGtDF", "dbvBYMdgslkBJuEWD9uCPJqFmtTt8cU5", "jZC4Ivj", "4jv2LQemXeCXPfpssPDUuPD2TleIiZzb"};
            public C7q A00;
            public final C1794Ym A01;
            public final AbstractC11317r<T> A02;
            public final AbstractC11588t<T> A03;

            static {
                A02();
            }

            {
                this.A02 = abstractC11317r;
                this.A03 = abstractC11588t;
                this.A01 = c1794Ym;
            }

            private final T A00(Void... voidArr) throws Throwable {
                if (KL.A02(this)) {
                    return null;
                }
                if (A05[6].length() == 11) {
                    throw new RuntimeException();
                }
                A05[2] = "4eGiZ19xQ4OxGjIavdFldPBRBlbWR0DL";
                T tA03 = null;
                try {
                    try {
                        tA03 = this.A02.A03();
                        this.A00 = this.A02.A00();
                        return tA03;
                    } catch (Exception e11) {
                        this.A01.A07().A9a(A01(0, 8, 71), C8A.A0w, new C8B(e11));
                        this.A00 = C7q.A09;
                        return tA03;
                    }
                } catch (Throwable th2) {
                    KL.A00(th2, this);
                    return null;
                }
            }

            public static String A01(int i11, int i12, int i13) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i11, i11 + i12);
                for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
                    int i15 = (bArrCopyOfRange[i14] - i13) - 116;
                    if (A05[7].charAt(12) != 'P') {
                        throw new RuntimeException();
                    }
                    A05[6] = "VTML";
                    bArrCopyOfRange[i14] = (byte) i15;
                }
                return new String(bArrCopyOfRange);
            }

            public static void A02() {
                A04 = new byte[]{Ascii.US, Ascii.FS, 47, Ascii.FS, Ascii.GS, Ascii.FS, 46, 32};
            }

            @Override // android.os.AsyncTask
            public final /* bridge */ /* synthetic */ Object doInBackground(Void[] voidArr) throws Throwable {
                if (KL.A02(this)) {
                    return null;
                }
                try {
                    return A00(voidArr);
                } catch (Throwable th2) {
                    KL.A00(th2, this);
                    return null;
                }
            }

            @Override // android.os.AsyncTask
            public final void onPostExecute(T t11) throws Throwable {
                if (KL.A02(this)) {
                    return;
                }
                try {
                    C7q c7q = this.A00;
                    if (c7q == null) {
                        this.A03.A02(t11);
                    } else {
                        this.A03.A01(c7q.A02(), this.A00.A03());
                    }
                } catch (Throwable th2) {
                    KL.A00(th2, this);
                }
            }
        }, new Void[0]);
    }

    public final AsyncTask A0G(String str, int i11, String str2, double d11, double d12, String str3, Map<String, String> map, AbstractC11588t<String> abstractC11588t) {
        return A0F(new EP(this, str2, str, i11, d11, d12, str3, map), abstractC11588t);
    }

    public final void A0H() {
        A08.lock();
        try {
            this.A02.A09();
            this.A03.A09();
        } finally {
            A08.unlock();
        }
    }

    public final void A0I() {
        A08.lock();
        try {
            this.A03.A0D(this.A01);
        } finally {
            A08.unlock();
        }
    }

    public final synchronized void A0J() {
        for (int i11 = 0; i11 < A0M().length; i11++) {
        }
        SQLiteOpenHelper sQLiteOpenHelper = this.A00;
        if (sQLiteOpenHelper != null) {
            sQLiteOpenHelper.close();
            this.A00 = null;
        }
    }

    public final boolean A0K(String str) {
        Lock lock = A08;
        lock.lock();
        try {
            boolean zA0F = this.A02.A0F(str);
            lock.unlock();
            String[] strArr = A05;
            if (strArr[7].charAt(23) != strArr[1].charAt(23)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A05;
            strArr2[4] = PrepareException.ERROR_MANIFEST_INFO;
            strArr2[5] = "N";
            return zA0F;
        } catch (Throwable th2) {
            A08.unlock();
            throw th2;
        }
    }

    public final boolean A0L(String str) {
        boolean z11;
        A08.lock();
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(A05(121, 7, 95)).append(A05(136, 6, 111)).append(A05(44, 5, 67)).append(C1793Yl.A02.A01).append(A05(61, 1, 83)).append(C1793Yl.A02.A01).append(A05(56, 2, 49)).append(A05(49, 7, 11)).append(C1793Yl.A04.A01).append(A05(62, 2, 26));
            A0E().execSQL(sb2.toString(), new String[]{str});
            z11 = true;
        } catch (SQLiteException unused) {
            z11 = false;
        }
        A08.unlock();
        String[] strArr = A05;
        if (strArr[0].charAt(2) != strArr[6].charAt(2)) {
            throw new RuntimeException();
        }
        A05[2] = "LEhHmvsdsEQXOsQ0B1AVwqczGhJrofDk";
        return z11;
    }

    public final AbstractC11327s[] A0M() {
        return new AbstractC11327s[]{this.A03, this.A02};
    }
}
