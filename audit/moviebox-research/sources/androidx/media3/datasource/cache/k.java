package androidx.media3.datasource.cache;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;
import androidx.media3.database.DatabaseIOException;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.g1;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CachedContentIndex;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, j> f9705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseArray<String> f9706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SparseBooleanArray f9707c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SparseBooleanArray f9708d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f9709e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public c f9710f;

    /* JADX INFO: compiled from: source.java */
    public static final class a implements c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final String[] f9711e = {"id", "key", TtmlNode.TAG_METADATA};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b4.a f9712a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SparseArray<j> f9713b = new SparseArray<>();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f9714c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f9715d;

        public a(b4.a aVar) {
            this.f9712a = aVar;
        }

        public static void j(b4.a aVar, String str) throws DatabaseIOException {
            try {
                String strN = n(str);
                SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    b4.c.c(writableDatabase, 1, str);
                    l(writableDatabase, strN);
                    writableDatabase.setTransactionSuccessful();
                } finally {
                    writableDatabase.endTransaction();
                }
            } catch (SQLException e11) {
                throw new DatabaseIOException(e11);
            }
        }

        public static void l(SQLiteDatabase sQLiteDatabase, String str) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
        }

        public static String n(String str) {
            return "ExoPlayerCacheIndex" + str;
        }

        @Override // androidx.media3.datasource.cache.k.c
        public boolean a() throws DatabaseIOException {
            try {
                return b4.c.b(this.f9712a.getReadableDatabase(), 1, (String) z3.a.e(this.f9714c)) != -1;
            } catch (SQLException e11) {
                throw new DatabaseIOException(e11);
            }
        }

        @Override // androidx.media3.datasource.cache.k.c
        public void b(HashMap<String, j> map) throws IOException {
            if (this.f9713b.size() == 0) {
                return;
            }
            try {
                SQLiteDatabase writableDatabase = this.f9712a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                for (int i11 = 0; i11 < this.f9713b.size(); i11++) {
                    try {
                        j jVarValueAt = this.f9713b.valueAt(i11);
                        if (jVarValueAt == null) {
                            k(writableDatabase, this.f9713b.keyAt(i11));
                        } else {
                            i(writableDatabase, jVarValueAt);
                        }
                    } catch (Throwable th2) {
                        writableDatabase.endTransaction();
                        throw th2;
                    }
                }
                writableDatabase.setTransactionSuccessful();
                this.f9713b.clear();
                writableDatabase.endTransaction();
            } catch (SQLException e11) {
                throw new DatabaseIOException(e11);
            }
        }

        @Override // androidx.media3.datasource.cache.k.c
        public void c(long j11) {
            String hexString = Long.toHexString(j11);
            this.f9714c = hexString;
            this.f9715d = n(hexString);
        }

        @Override // androidx.media3.datasource.cache.k.c
        public void d(HashMap<String, j> map) throws IOException {
            try {
                SQLiteDatabase writableDatabase = this.f9712a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    o(writableDatabase);
                    Iterator<j> it = map.values().iterator();
                    while (it.hasNext()) {
                        i(writableDatabase, it.next());
                    }
                    writableDatabase.setTransactionSuccessful();
                    this.f9713b.clear();
                } finally {
                    writableDatabase.endTransaction();
                }
            } catch (SQLException e11) {
                throw new DatabaseIOException(e11);
            }
        }

        @Override // androidx.media3.datasource.cache.k.c
        public void e(HashMap<String, j> map, SparseArray<String> sparseArray) throws IOException {
            z3.a.g(this.f9713b.size() == 0);
            try {
                if (b4.c.b(this.f9712a.getReadableDatabase(), 1, (String) z3.a.e(this.f9714c)) != 1) {
                    SQLiteDatabase writableDatabase = this.f9712a.getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        o(writableDatabase);
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Throwable th2) {
                        writableDatabase.endTransaction();
                        throw th2;
                    }
                }
                Cursor cursorM = m();
                while (cursorM.moveToNext()) {
                    try {
                        j jVar = new j(cursorM.getInt(0), (String) z3.a.e(cursorM.getString(1)), k.q(new DataInputStream(new ByteArrayInputStream(cursorM.getBlob(2)))));
                        map.put(jVar.f9699b, jVar);
                        sparseArray.put(jVar.f9698a, jVar.f9699b);
                    } catch (Throwable th3) {
                        if (cursorM != null) {
                            try {
                                cursorM.close();
                            } catch (Throwable th4) {
                                th3.addSuppressed(th4);
                            }
                        }
                        throw th3;
                    }
                }
                cursorM.close();
            } catch (SQLiteException e11) {
                map.clear();
                sparseArray.clear();
                throw new DatabaseIOException(e11);
            }
        }

        @Override // androidx.media3.datasource.cache.k.c
        public void f() throws DatabaseIOException {
            j(this.f9712a, (String) z3.a.e(this.f9714c));
        }

        @Override // androidx.media3.datasource.cache.k.c
        public void g(j jVar, boolean z11) {
            if (z11) {
                this.f9713b.delete(jVar.f9698a);
            } else {
                this.f9713b.put(jVar.f9698a, null);
            }
        }

        @Override // androidx.media3.datasource.cache.k.c
        public void h(j jVar) {
            this.f9713b.put(jVar.f9698a, jVar);
        }

        public final void i(SQLiteDatabase sQLiteDatabase, j jVar) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            k.t(jVar.d(), new DataOutputStream(byteArrayOutputStream));
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", Integer.valueOf(jVar.f9698a));
            contentValues.put("key", jVar.f9699b);
            contentValues.put(TtmlNode.TAG_METADATA, byteArray);
            sQLiteDatabase.replaceOrThrow((String) z3.a.e(this.f9715d), null, contentValues);
        }

        public final void k(SQLiteDatabase sQLiteDatabase, int i11) {
            sQLiteDatabase.delete((String) z3.a.e(this.f9715d), "id = ?", new String[]{Integer.toString(i11)});
        }

        public final Cursor m() {
            return this.f9712a.getReadableDatabase().query((String) z3.a.e(this.f9715d), f9711e, null, null, null, null, null);
        }

        public final void o(SQLiteDatabase sQLiteDatabase) throws DatabaseIOException {
            b4.c.d(sQLiteDatabase, 1, (String) z3.a.e(this.f9714c), 1);
            l(sQLiteDatabase, (String) z3.a.e(this.f9715d));
            sQLiteDatabase.execSQL("CREATE TABLE " + this.f9715d + " (id INTEGER PRIMARY KEY NOT NULL,key TEXT NOT NULL,metadata BLOB NOT NULL)");
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f9716a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final Cipher f9717b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public final SecretKeySpec f9718c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public final SecureRandom f9719d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final z3.b f9720e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f9721f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        public r f9722g;

        public b(File file, @Nullable byte[] bArr, boolean z11) {
            Cipher cipherI;
            SecretKeySpec secretKeySpec;
            z3.a.g((bArr == null && z11) ? false : true);
            if (bArr != null) {
                z3.a.a(bArr.length == 16);
                try {
                    cipherI = k.i();
                    secretKeySpec = new SecretKeySpec(bArr, "AES");
                } catch (NoSuchAlgorithmException | NoSuchPaddingException e11) {
                    throw new IllegalStateException(e11);
                }
            } else {
                z3.a.a(!z11);
                cipherI = null;
                secretKeySpec = null;
            }
            this.f9716a = z11;
            this.f9717b = cipherI;
            this.f9718c = secretKeySpec;
            this.f9719d = z11 ? new SecureRandom() : null;
            this.f9720e = new z3.b(file);
        }

        @Override // androidx.media3.datasource.cache.k.c
        public boolean a() {
            return this.f9720e.c();
        }

        @Override // androidx.media3.datasource.cache.k.c
        public void b(HashMap<String, j> map) throws Throwable {
            if (this.f9721f) {
                d(map);
            }
        }

        @Override // androidx.media3.datasource.cache.k.c
        public void c(long j11) {
        }

        @Override // androidx.media3.datasource.cache.k.c
        public void d(HashMap<String, j> map) throws Throwable {
            m(map);
            this.f9721f = false;
        }

        @Override // androidx.media3.datasource.cache.k.c
        public void e(HashMap<String, j> map, SparseArray<String> sparseArray) {
            z3.a.g(!this.f9721f);
            if (k(map, sparseArray)) {
                return;
            }
            map.clear();
            sparseArray.clear();
            this.f9720e.a();
        }

        @Override // androidx.media3.datasource.cache.k.c
        public void f() {
            this.f9720e.a();
        }

        @Override // androidx.media3.datasource.cache.k.c
        public void g(j jVar, boolean z11) {
            this.f9721f = true;
        }

        @Override // androidx.media3.datasource.cache.k.c
        public void h(j jVar) {
            this.f9721f = true;
        }

        public final int i(j jVar, int i11) {
            int iHashCode = (jVar.f9698a * 31) + jVar.f9699b.hashCode();
            if (i11 >= 2) {
                return (iHashCode * 31) + jVar.d().hashCode();
            }
            long jA = l.a(jVar.d());
            return (iHashCode * 31) + ((int) (jA ^ (jA >>> 32)));
        }

        public final j j(int i11, DataInputStream dataInputStream) throws IOException {
            o oVarQ;
            int i12 = dataInputStream.readInt();
            String utf = dataInputStream.readUTF();
            if (i11 < 2) {
                long j11 = dataInputStream.readLong();
                n nVar = new n();
                n.g(nVar, j11);
                oVarQ = o.f9725c.c(nVar);
            } else {
                oVarQ = k.q(dataInputStream);
            }
            return new j(i12, utf, oVarQ);
        }

        public final boolean k(HashMap<String, j> map, SparseArray<String> sparseArray) throws Throwable {
            if (!this.f9720e.c()) {
                return true;
            }
            DataInputStream dataInputStream = null;
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(this.f9720e.d());
                DataInputStream dataInputStream2 = new DataInputStream(bufferedInputStream);
                try {
                    int i11 = dataInputStream2.readInt();
                    if (i11 >= 0 && i11 <= 2) {
                        if ((dataInputStream2.readInt() & 1) != 0) {
                            if (this.f9717b == null) {
                                u0.m(dataInputStream2);
                                return false;
                            }
                            byte[] bArr = new byte[16];
                            dataInputStream2.readFully(bArr);
                            try {
                                this.f9717b.init(2, (Key) u0.i(this.f9718c), new IvParameterSpec(bArr));
                                dataInputStream2 = new DataInputStream(new CipherInputStream(bufferedInputStream, this.f9717b));
                            } catch (InvalidAlgorithmParameterException e11) {
                                e = e11;
                                throw new IllegalStateException(e);
                            } catch (InvalidKeyException e12) {
                                e = e12;
                                throw new IllegalStateException(e);
                            }
                        } else if (this.f9716a) {
                            this.f9721f = true;
                        }
                        int i12 = dataInputStream2.readInt();
                        int i13 = 0;
                        for (int i14 = 0; i14 < i12; i14++) {
                            j jVarJ = j(i11, dataInputStream2);
                            map.put(jVarJ.f9699b, jVarJ);
                            sparseArray.put(jVarJ.f9698a, jVarJ.f9699b);
                            i13 += i(jVarJ, i11);
                        }
                        int i15 = dataInputStream2.readInt();
                        boolean z11 = dataInputStream2.read() == -1;
                        if (i15 == i13 && z11) {
                            u0.m(dataInputStream2);
                            return true;
                        }
                        u0.m(dataInputStream2);
                        return false;
                    }
                    u0.m(dataInputStream2);
                    return false;
                } catch (IOException unused) {
                    dataInputStream = dataInputStream2;
                    if (dataInputStream != null) {
                        u0.m(dataInputStream);
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    dataInputStream = dataInputStream2;
                    if (dataInputStream != null) {
                        u0.m(dataInputStream);
                    }
                    throw th;
                }
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                th = th3;
            }
        }

        public final void l(j jVar, DataOutputStream dataOutputStream) throws IOException {
            dataOutputStream.writeInt(jVar.f9698a);
            dataOutputStream.writeUTF(jVar.f9699b);
            k.t(jVar.d(), dataOutputStream);
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void m(HashMap<String, j> map) throws Throwable {
            DataOutputStream dataOutputStream = null;
            try {
                OutputStream outputStreamF = this.f9720e.f();
                r rVar = this.f9722g;
                if (rVar == null) {
                    this.f9722g = new r(outputStreamF);
                } else {
                    rVar.a(outputStreamF);
                }
                r rVar2 = this.f9722g;
                DataOutputStream dataOutputStream2 = new DataOutputStream(rVar2);
                try {
                    dataOutputStream2.writeInt(2);
                    int i11 = 0;
                    dataOutputStream2.writeInt(this.f9716a ? 1 : 0);
                    if (this.f9716a) {
                        byte[] bArr = new byte[16];
                        ((SecureRandom) u0.i(this.f9719d)).nextBytes(bArr);
                        dataOutputStream2.write(bArr);
                        try {
                            ((Cipher) u0.i(this.f9717b)).init(1, (Key) u0.i(this.f9718c), new IvParameterSpec(bArr));
                            dataOutputStream2.flush();
                            dataOutputStream2 = new DataOutputStream(new CipherOutputStream(rVar2, this.f9717b));
                        } catch (InvalidAlgorithmParameterException e11) {
                            e = e11;
                            throw new IllegalStateException(e);
                        } catch (InvalidKeyException e12) {
                            e = e12;
                            throw new IllegalStateException(e);
                        }
                    }
                    dataOutputStream2.writeInt(map.size());
                    for (j jVar : map.values()) {
                        l(jVar, dataOutputStream2);
                        i11 += i(jVar, 2);
                    }
                    dataOutputStream2.writeInt(i11);
                    this.f9720e.b(dataOutputStream2);
                    u0.m(null);
                } catch (Throwable th2) {
                    th = th2;
                    dataOutputStream = dataOutputStream2;
                    u0.m(dataOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        boolean a() throws IOException;

        void b(HashMap<String, j> map) throws IOException;

        void c(long j11);

        void d(HashMap<String, j> map) throws IOException;

        void e(HashMap<String, j> map, SparseArray<String> sparseArray) throws IOException;

        void f() throws IOException;

        void g(j jVar, boolean z11);

        void h(j jVar);
    }

    public k(@Nullable b4.a aVar, @Nullable File file, @Nullable byte[] bArr, boolean z11, boolean z12) {
        z3.a.g((aVar == null && file == null) ? false : true);
        this.f9705a = new HashMap<>();
        this.f9706b = new SparseArray<>();
        this.f9707c = new SparseBooleanArray();
        this.f9708d = new SparseBooleanArray();
        a aVar2 = aVar != null ? new a(aVar) : null;
        b bVar = file != null ? new b(new File(file, CachedContentIndex.FILE_NAME), bArr, z11) : null;
        if (aVar2 == null || (bVar != null && z12)) {
            this.f9709e = (c) u0.i(bVar);
            this.f9710f = aVar2;
        } else {
            this.f9709e = aVar2;
            this.f9710f = bVar;
        }
    }

    @SuppressLint({"GetInstance"})
    public static Cipher i() throws NoSuchPaddingException, NoSuchAlgorithmException {
        if (u0.f81838a == 18) {
            try {
                return Cipher.getInstance("AES/CBC/PKCS5PADDING", "BC");
            } catch (Throwable unused) {
            }
        }
        return Cipher.getInstance("AES/CBC/PKCS5PADDING");
    }

    public static int l(SparseArray<String> sparseArray) {
        int size = sparseArray.size();
        int i11 = 0;
        int iKeyAt = size == 0 ? 0 : sparseArray.keyAt(size - 1) + 1;
        if (iKeyAt >= 0) {
            return iKeyAt;
        }
        while (i11 < size && i11 == sparseArray.keyAt(i11)) {
            i11++;
        }
        return i11;
    }

    public static boolean o(String str) {
        return str.startsWith(CachedContentIndex.FILE_NAME);
    }

    public static o q(DataInputStream dataInputStream) throws IOException {
        int i11 = dataInputStream.readInt();
        HashMap map = new HashMap();
        for (int i12 = 0; i12 < i11; i12++) {
            String utf = dataInputStream.readUTF();
            int i13 = dataInputStream.readInt();
            if (i13 < 0) {
                throw new IOException("Invalid value size: " + i13);
            }
            int iMin = Math.min(i13, 10485760);
            byte[] bArrCopyOf = u0.f81843f;
            int i14 = 0;
            while (i14 != i13) {
                int i15 = i14 + iMin;
                bArrCopyOf = Arrays.copyOf(bArrCopyOf, i15);
                dataInputStream.readFully(bArrCopyOf, i14, iMin);
                iMin = Math.min(i13 - i15, 10485760);
                i14 = i15;
            }
            map.put(utf, bArrCopyOf);
        }
        return new o(map);
    }

    public static void t(o oVar, DataOutputStream dataOutputStream) throws IOException {
        Set<Map.Entry<String, byte[]>> setD = oVar.d();
        dataOutputStream.writeInt(setD.size());
        for (Map.Entry<String, byte[]> entry : setD) {
            dataOutputStream.writeUTF(entry.getKey());
            byte[] value = entry.getValue();
            dataOutputStream.writeInt(value.length);
            dataOutputStream.write(value);
        }
    }

    public final j d(String str) {
        int iL = l(this.f9706b);
        j jVar = new j(iL, str);
        this.f9705a.put(str, jVar);
        this.f9706b.put(iL, str);
        this.f9708d.put(iL, true);
        this.f9709e.h(jVar);
        return jVar;
    }

    public void e(String str, n nVar) {
        j jVarM = m(str);
        if (jVarM.b(nVar)) {
            this.f9709e.h(jVarM);
        }
    }

    public int f(String str) {
        return m(str).f9698a;
    }

    @Nullable
    public j g(String str) {
        return this.f9705a.get(str);
    }

    public Collection<j> h() {
        return Collections.unmodifiableCollection(this.f9705a.values());
    }

    public m j(String str) {
        j jVarG = g(str);
        return jVarG != null ? jVarG.d() : o.f9725c;
    }

    @Nullable
    public String k(int i11) {
        return this.f9706b.get(i11);
    }

    public j m(String str) {
        j jVar = this.f9705a.get(str);
        return jVar == null ? d(str) : jVar;
    }

    public void n(long j11) throws IOException {
        c cVar;
        this.f9709e.c(j11);
        c cVar2 = this.f9710f;
        if (cVar2 != null) {
            cVar2.c(j11);
        }
        if (this.f9709e.a() || (cVar = this.f9710f) == null || !cVar.a()) {
            this.f9709e.e(this.f9705a, this.f9706b);
        } else {
            this.f9710f.e(this.f9705a, this.f9706b);
            this.f9709e.d(this.f9705a);
        }
        c cVar3 = this.f9710f;
        if (cVar3 != null) {
            cVar3.f();
            this.f9710f = null;
        }
    }

    public void p(String str) {
        j jVar = this.f9705a.get(str);
        if (jVar != null && jVar.g() && jVar.i()) {
            this.f9705a.remove(str);
            int i11 = jVar.f9698a;
            boolean z11 = this.f9708d.get(i11);
            this.f9709e.g(jVar, z11);
            if (z11) {
                this.f9706b.remove(i11);
                this.f9708d.delete(i11);
            } else {
                this.f9706b.put(i11, null);
                this.f9707c.put(i11, true);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void r() {
        g1 it = ImmutableSet.copyOf((Collection) this.f9705a.keySet()).iterator();
        while (it.hasNext()) {
            p((String) it.next());
        }
    }

    public void s() throws IOException {
        this.f9709e.b(this.f9705a);
        int size = this.f9707c.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.f9706b.remove(this.f9707c.keyAt(i11));
        }
        this.f9707c.clear();
        this.f9708d.clear();
    }
}
