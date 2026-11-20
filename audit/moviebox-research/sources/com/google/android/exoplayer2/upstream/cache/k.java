package com.google.android.exoplayer2.upstream.cache;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.database.DatabaseIOException;
import com.google.android.exoplayer2.util.o0;
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

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, j> f35345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseArray<String> f35346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SparseBooleanArray f35347c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SparseBooleanArray f35348d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f35349e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public c f35350f;

    /* JADX INFO: compiled from: source.java */
    public static final class a implements c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final String[] f35351e = {"id", "key", TtmlNode.TAG_METADATA};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final rg.a f35352a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SparseArray<j> f35353b = new SparseArray<>();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f35354c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f35355d;

        public a(rg.a aVar) {
            this.f35352a = aVar;
        }

        public static void j(rg.a aVar, String str) throws DatabaseIOException {
            try {
                String strN = n(str);
                SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    rg.c.c(writableDatabase, 1, str);
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

        @Override // com.google.android.exoplayer2.upstream.cache.k.c
        public boolean a() throws DatabaseIOException {
            return rg.c.b(this.f35352a.getReadableDatabase(), 1, (String) com.google.android.exoplayer2.util.a.e(this.f35354c)) != -1;
        }

        @Override // com.google.android.exoplayer2.upstream.cache.k.c
        public void b(HashMap<String, j> map) throws IOException {
            if (this.f35353b.size() == 0) {
                return;
            }
            try {
                SQLiteDatabase writableDatabase = this.f35352a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                for (int i11 = 0; i11 < this.f35353b.size(); i11++) {
                    try {
                        j jVarValueAt = this.f35353b.valueAt(i11);
                        if (jVarValueAt == null) {
                            k(writableDatabase, this.f35353b.keyAt(i11));
                        } else {
                            i(writableDatabase, jVarValueAt);
                        }
                    } catch (Throwable th2) {
                        writableDatabase.endTransaction();
                        throw th2;
                    }
                }
                writableDatabase.setTransactionSuccessful();
                this.f35353b.clear();
                writableDatabase.endTransaction();
            } catch (SQLException e11) {
                throw new DatabaseIOException(e11);
            }
        }

        @Override // com.google.android.exoplayer2.upstream.cache.k.c
        public void c(long j11) {
            String hexString = Long.toHexString(j11);
            this.f35354c = hexString;
            this.f35355d = n(hexString);
        }

        @Override // com.google.android.exoplayer2.upstream.cache.k.c
        public void d(HashMap<String, j> map) throws IOException {
            try {
                SQLiteDatabase writableDatabase = this.f35352a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    o(writableDatabase);
                    Iterator<j> it = map.values().iterator();
                    while (it.hasNext()) {
                        i(writableDatabase, it.next());
                    }
                    writableDatabase.setTransactionSuccessful();
                    this.f35353b.clear();
                } finally {
                    writableDatabase.endTransaction();
                }
            } catch (SQLException e11) {
                throw new DatabaseIOException(e11);
            }
        }

        @Override // com.google.android.exoplayer2.upstream.cache.k.c
        public void e(HashMap<String, j> map, SparseArray<String> sparseArray) throws IOException {
            com.google.android.exoplayer2.util.a.g(this.f35353b.size() == 0);
            try {
                if (rg.c.b(this.f35352a.getReadableDatabase(), 1, (String) com.google.android.exoplayer2.util.a.e(this.f35354c)) != 1) {
                    SQLiteDatabase writableDatabase = this.f35352a.getWritableDatabase();
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
                        j jVar = new j(cursorM.getInt(0), (String) com.google.android.exoplayer2.util.a.e(cursorM.getString(1)), k.q(new DataInputStream(new ByteArrayInputStream(cursorM.getBlob(2)))));
                        map.put(jVar.f35339b, jVar);
                        sparseArray.put(jVar.f35338a, jVar.f35339b);
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

        @Override // com.google.android.exoplayer2.upstream.cache.k.c
        public void f() throws DatabaseIOException {
            j(this.f35352a, (String) com.google.android.exoplayer2.util.a.e(this.f35354c));
        }

        @Override // com.google.android.exoplayer2.upstream.cache.k.c
        public void g(j jVar, boolean z11) {
            if (z11) {
                this.f35353b.delete(jVar.f35338a);
            } else {
                this.f35353b.put(jVar.f35338a, null);
            }
        }

        @Override // com.google.android.exoplayer2.upstream.cache.k.c
        public void h(j jVar) {
            this.f35353b.put(jVar.f35338a, jVar);
        }

        public final void i(SQLiteDatabase sQLiteDatabase, j jVar) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            k.t(jVar.d(), new DataOutputStream(byteArrayOutputStream));
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", Integer.valueOf(jVar.f35338a));
            contentValues.put("key", jVar.f35339b);
            contentValues.put(TtmlNode.TAG_METADATA, byteArray);
            sQLiteDatabase.replaceOrThrow((String) com.google.android.exoplayer2.util.a.e(this.f35355d), null, contentValues);
        }

        public final void k(SQLiteDatabase sQLiteDatabase, int i11) {
            sQLiteDatabase.delete((String) com.google.android.exoplayer2.util.a.e(this.f35355d), "id = ?", new String[]{Integer.toString(i11)});
        }

        public final Cursor m() {
            return this.f35352a.getReadableDatabase().query((String) com.google.android.exoplayer2.util.a.e(this.f35355d), f35351e, null, null, null, null, null);
        }

        public final void o(SQLiteDatabase sQLiteDatabase) throws DatabaseIOException {
            rg.c.d(sQLiteDatabase, 1, (String) com.google.android.exoplayer2.util.a.e(this.f35354c), 1);
            l(sQLiteDatabase, (String) com.google.android.exoplayer2.util.a.e(this.f35355d));
            sQLiteDatabase.execSQL("CREATE TABLE " + this.f35355d + " (id INTEGER PRIMARY KEY NOT NULL,key TEXT NOT NULL,metadata BLOB NOT NULL)");
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f35356a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final Cipher f35357b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public final SecretKeySpec f35358c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public final SecureRandom f35359d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final com.google.android.exoplayer2.util.b f35360e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f35361f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        public r f35362g;

        public b(File file, @Nullable byte[] bArr, boolean z11) {
            Cipher cipherI;
            SecretKeySpec secretKeySpec;
            com.google.android.exoplayer2.util.a.g((bArr == null && z11) ? false : true);
            if (bArr != null) {
                com.google.android.exoplayer2.util.a.a(bArr.length == 16);
                try {
                    cipherI = k.i();
                    secretKeySpec = new SecretKeySpec(bArr, "AES");
                } catch (NoSuchAlgorithmException | NoSuchPaddingException e11) {
                    throw new IllegalStateException(e11);
                }
            } else {
                com.google.android.exoplayer2.util.a.a(!z11);
                cipherI = null;
                secretKeySpec = null;
            }
            this.f35356a = z11;
            this.f35357b = cipherI;
            this.f35358c = secretKeySpec;
            this.f35359d = z11 ? new SecureRandom() : null;
            this.f35360e = new com.google.android.exoplayer2.util.b(file);
        }

        @Override // com.google.android.exoplayer2.upstream.cache.k.c
        public boolean a() {
            return this.f35360e.c();
        }

        @Override // com.google.android.exoplayer2.upstream.cache.k.c
        public void b(HashMap<String, j> map) throws Throwable {
            if (this.f35361f) {
                d(map);
            }
        }

        @Override // com.google.android.exoplayer2.upstream.cache.k.c
        public void c(long j11) {
        }

        @Override // com.google.android.exoplayer2.upstream.cache.k.c
        public void d(HashMap<String, j> map) throws Throwable {
            m(map);
            this.f35361f = false;
        }

        @Override // com.google.android.exoplayer2.upstream.cache.k.c
        public void e(HashMap<String, j> map, SparseArray<String> sparseArray) {
            com.google.android.exoplayer2.util.a.g(!this.f35361f);
            if (k(map, sparseArray)) {
                return;
            }
            map.clear();
            sparseArray.clear();
            this.f35360e.a();
        }

        @Override // com.google.android.exoplayer2.upstream.cache.k.c
        public void f() {
            this.f35360e.a();
        }

        @Override // com.google.android.exoplayer2.upstream.cache.k.c
        public void g(j jVar, boolean z11) {
            this.f35361f = true;
        }

        @Override // com.google.android.exoplayer2.upstream.cache.k.c
        public void h(j jVar) {
            this.f35361f = true;
        }

        public final int i(j jVar, int i11) {
            int iHashCode = (jVar.f35338a * 31) + jVar.f35339b.hashCode();
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
                oVarQ = o.f35365c.c(nVar);
            } else {
                oVarQ = k.q(dataInputStream);
            }
            return new j(i12, utf, oVarQ);
        }

        public final boolean k(HashMap<String, j> map, SparseArray<String> sparseArray) throws Throwable {
            if (!this.f35360e.c()) {
                return true;
            }
            DataInputStream dataInputStream = null;
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(this.f35360e.d());
                DataInputStream dataInputStream2 = new DataInputStream(bufferedInputStream);
                try {
                    int i11 = dataInputStream2.readInt();
                    if (i11 >= 0 && i11 <= 2) {
                        if ((dataInputStream2.readInt() & 1) != 0) {
                            if (this.f35357b == null) {
                                o0.n(dataInputStream2);
                                return false;
                            }
                            byte[] bArr = new byte[16];
                            dataInputStream2.readFully(bArr);
                            try {
                                this.f35357b.init(2, (Key) o0.j(this.f35358c), new IvParameterSpec(bArr));
                                dataInputStream2 = new DataInputStream(new CipherInputStream(bufferedInputStream, this.f35357b));
                            } catch (InvalidAlgorithmParameterException e11) {
                                e = e11;
                                throw new IllegalStateException(e);
                            } catch (InvalidKeyException e12) {
                                e = e12;
                                throw new IllegalStateException(e);
                            }
                        } else if (this.f35356a) {
                            this.f35361f = true;
                        }
                        int i12 = dataInputStream2.readInt();
                        int i13 = 0;
                        for (int i14 = 0; i14 < i12; i14++) {
                            j jVarJ = j(i11, dataInputStream2);
                            map.put(jVarJ.f35339b, jVarJ);
                            sparseArray.put(jVarJ.f35338a, jVarJ.f35339b);
                            i13 += i(jVarJ, i11);
                        }
                        int i15 = dataInputStream2.readInt();
                        boolean z11 = dataInputStream2.read() == -1;
                        if (i15 == i13 && z11) {
                            o0.n(dataInputStream2);
                            return true;
                        }
                        o0.n(dataInputStream2);
                        return false;
                    }
                    o0.n(dataInputStream2);
                    return false;
                } catch (IOException unused) {
                    dataInputStream = dataInputStream2;
                    if (dataInputStream != null) {
                        o0.n(dataInputStream);
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    dataInputStream = dataInputStream2;
                    if (dataInputStream != null) {
                        o0.n(dataInputStream);
                    }
                    throw th;
                }
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                th = th3;
            }
        }

        public final void l(j jVar, DataOutputStream dataOutputStream) throws IOException {
            dataOutputStream.writeInt(jVar.f35338a);
            dataOutputStream.writeUTF(jVar.f35339b);
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
                OutputStream outputStreamF = this.f35360e.f();
                r rVar = this.f35362g;
                if (rVar == null) {
                    this.f35362g = new r(outputStreamF);
                } else {
                    rVar.a(outputStreamF);
                }
                r rVar2 = this.f35362g;
                DataOutputStream dataOutputStream2 = new DataOutputStream(rVar2);
                try {
                    dataOutputStream2.writeInt(2);
                    int i11 = 0;
                    dataOutputStream2.writeInt(this.f35356a ? 1 : 0);
                    if (this.f35356a) {
                        byte[] bArr = new byte[16];
                        ((SecureRandom) o0.j(this.f35359d)).nextBytes(bArr);
                        dataOutputStream2.write(bArr);
                        try {
                            ((Cipher) o0.j(this.f35357b)).init(1, (Key) o0.j(this.f35358c), new IvParameterSpec(bArr));
                            dataOutputStream2.flush();
                            dataOutputStream2 = new DataOutputStream(new CipherOutputStream(rVar2, this.f35357b));
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
                    this.f35360e.b(dataOutputStream2);
                    o0.n(null);
                } catch (Throwable th2) {
                    th = th2;
                    dataOutputStream = dataOutputStream2;
                    o0.n(dataOutputStream);
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

    public k(@Nullable rg.a aVar, @Nullable File file, @Nullable byte[] bArr, boolean z11, boolean z12) {
        com.google.android.exoplayer2.util.a.g((aVar == null && file == null) ? false : true);
        this.f35345a = new HashMap<>();
        this.f35346b = new SparseArray<>();
        this.f35347c = new SparseBooleanArray();
        this.f35348d = new SparseBooleanArray();
        a aVar2 = aVar != null ? new a(aVar) : null;
        b bVar = file != null ? new b(new File(file, CachedContentIndex.FILE_NAME), bArr, z11) : null;
        if (aVar2 == null || (bVar != null && z12)) {
            this.f35349e = (c) o0.j(bVar);
            this.f35350f = aVar2;
        } else {
            this.f35349e = aVar2;
            this.f35350f = bVar;
        }
    }

    @SuppressLint({"GetInstance"})
    public static Cipher i() throws NoSuchPaddingException, NoSuchAlgorithmException {
        if (o0.f35608a == 18) {
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
            byte[] bArrCopyOf = o0.f35613f;
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
        int iL = l(this.f35346b);
        j jVar = new j(iL, str);
        this.f35345a.put(str, jVar);
        this.f35346b.put(iL, str);
        this.f35348d.put(iL, true);
        this.f35349e.h(jVar);
        return jVar;
    }

    public void e(String str, n nVar) {
        j jVarM = m(str);
        if (jVarM.b(nVar)) {
            this.f35349e.h(jVarM);
        }
    }

    public int f(String str) {
        return m(str).f35338a;
    }

    @Nullable
    public j g(String str) {
        return this.f35345a.get(str);
    }

    public Collection<j> h() {
        return Collections.unmodifiableCollection(this.f35345a.values());
    }

    public m j(String str) {
        j jVarG = g(str);
        return jVarG != null ? jVarG.d() : o.f35365c;
    }

    @Nullable
    public String k(int i11) {
        return this.f35346b.get(i11);
    }

    public j m(String str) {
        j jVar = this.f35345a.get(str);
        return jVar == null ? d(str) : jVar;
    }

    public void n(long j11) throws IOException {
        c cVar;
        this.f35349e.c(j11);
        c cVar2 = this.f35350f;
        if (cVar2 != null) {
            cVar2.c(j11);
        }
        if (this.f35349e.a() || (cVar = this.f35350f) == null || !cVar.a()) {
            this.f35349e.e(this.f35345a, this.f35346b);
        } else {
            this.f35350f.e(this.f35345a, this.f35346b);
            this.f35349e.d(this.f35345a);
        }
        c cVar3 = this.f35350f;
        if (cVar3 != null) {
            cVar3.f();
            this.f35350f = null;
        }
    }

    public void p(String str) {
        j jVar = this.f35345a.get(str);
        if (jVar != null && jVar.g() && jVar.i()) {
            this.f35345a.remove(str);
            int i11 = jVar.f35338a;
            boolean z11 = this.f35348d.get(i11);
            this.f35349e.g(jVar, z11);
            if (z11) {
                this.f35346b.remove(i11);
                this.f35348d.delete(i11);
            } else {
                this.f35346b.put(i11, null);
                this.f35347c.put(i11, true);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void r() {
        g1 it = ImmutableSet.copyOf((Collection) this.f35345a.keySet()).iterator();
        while (it.hasNext()) {
            p((String) it.next());
        }
    }

    public void s() throws IOException {
        this.f35349e.b(this.f35345a);
        int size = this.f35347c.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.f35346b.remove(this.f35347c.keyAt(i11));
        }
        this.f35347c.clear();
        this.f35348d.clear();
    }
}
