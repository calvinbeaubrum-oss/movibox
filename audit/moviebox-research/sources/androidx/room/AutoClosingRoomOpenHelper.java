package androidx.room;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.SQLException;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import com.vungle.warren.error.VungleException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class AutoClosingRoomOpenHelper implements g6.h, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g6.h f12723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    public final c f12724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AutoClosingSupportSQLiteDatabase f12725c;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    public static final class AutoClosingSupportSQLiteDatabase implements g6.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f12726a;

        public AutoClosingSupportSQLiteDatabase(c autoCloser) {
            Intrinsics.g(autoCloser, "autoCloser");
            this.f12726a = autoCloser;
        }

        @Override // g6.g
        public void A() {
            try {
                this.f12726a.j().A();
            } catch (Throwable th2) {
                this.f12726a.e();
                throw th2;
            }
        }

        @Override // g6.g
        public List<Pair<String, String>> D() {
            return (List) this.f12726a.g(new Function1<g6.g, List<? extends Pair<String, String>>>() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$attachedDbs$1
                @Override // kotlin.jvm.functions.Function1
                public final List<Pair<String, String>> invoke(g6.g obj) {
                    Intrinsics.g(obj, "obj");
                    return obj.D();
                }
            });
        }

        @Override // g6.g
        public void E(final String sql) throws SQLException {
            Intrinsics.g(sql, "sql");
            this.f12726a.g(new Function1<g6.g, Object>() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$execSQL$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(g6.g db2) {
                    Intrinsics.g(db2, "db");
                    db2.E(sql);
                    return null;
                }
            });
        }

        @Override // g6.g
        public void I() {
            Unit unit;
            g6.g gVarH = this.f12726a.h();
            if (gVarH != null) {
                gVarH.I();
                unit = Unit.f68710a;
            } else {
                unit = null;
            }
            if (unit == null) {
                throw new IllegalStateException("setTransactionSuccessful called but delegateDb is null".toString());
            }
        }

        @Override // g6.g
        public void J(final String sql, final Object[] bindArgs) throws SQLException {
            Intrinsics.g(sql, "sql");
            Intrinsics.g(bindArgs, "bindArgs");
            this.f12726a.g(new Function1<g6.g, Object>() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$execSQL$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(g6.g db2) {
                    Intrinsics.g(db2, "db");
                    db2.J(sql, bindArgs);
                    return null;
                }
            });
        }

        @Override // g6.g
        public void K() {
            try {
                this.f12726a.j().K();
            } catch (Throwable th2) {
                this.f12726a.e();
                throw th2;
            }
        }

        @Override // g6.g
        public void L() {
            if (this.f12726a.h() == null) {
                throw new IllegalStateException("End transaction called but delegateDb is null".toString());
            }
            try {
                g6.g gVarH = this.f12726a.h();
                Intrinsics.d(gVarH);
                gVarH.L();
            } finally {
                this.f12726a.e();
            }
        }

        @Override // g6.g
        public g6.k S(String sql) {
            Intrinsics.g(sql, "sql");
            return new AutoClosingSupportSqliteStatement(sql, this.f12726a);
        }

        @Override // g6.g
        public Cursor X(g6.j query) {
            Intrinsics.g(query, "query");
            try {
                return new a(this.f12726a.j().X(query), this.f12726a);
            } catch (Throwable th2) {
                this.f12726a.e();
                throw th2;
            }
        }

        @Override // g6.g
        @RequiresApi(api = 24)
        public Cursor Y(g6.j query, CancellationSignal cancellationSignal) {
            Intrinsics.g(query, "query");
            try {
                return new a(this.f12726a.j().Y(query, cancellationSignal), this.f12726a);
            } catch (Throwable th2) {
                this.f12726a.e();
                throw th2;
            }
        }

        public final void a() {
            this.f12726a.g(new Function1<g6.g, Object>() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pokeOpen$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(g6.g it) {
                    Intrinsics.g(it, "it");
                    return null;
                }
            });
        }

        @Override // g6.g
        public int a0(final String table, final int i11, final ContentValues values, final String str, final Object[] objArr) {
            Intrinsics.g(table, "table");
            Intrinsics.g(values, "values");
            return ((Number) this.f12726a.g(new Function1<g6.g, Integer>() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$update$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Integer invoke(g6.g db2) {
                    Intrinsics.g(db2, "db");
                    return Integer.valueOf(db2.a0(table, i11, values, str, objArr));
                }
            })).intValue();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f12726a.d();
        }

        @Override // g6.g
        public Cursor f0(String query) {
            Intrinsics.g(query, "query");
            try {
                return new a(this.f12726a.j().f0(query), this.f12726a);
            } catch (Throwable th2) {
                this.f12726a.e();
                throw th2;
            }
        }

        @Override // g6.g
        public String getPath() {
            return (String) this.f12726a.g(new Function1<g6.g, String>() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$path$1
                @Override // kotlin.jvm.functions.Function1
                public final String invoke(g6.g obj) {
                    Intrinsics.g(obj, "obj");
                    return obj.getPath();
                }
            });
        }

        @Override // g6.g
        public boolean isOpen() {
            g6.g gVarH = this.f12726a.h();
            if (gVarH == null) {
                return false;
            }
            return gVarH.isOpen();
        }

        @Override // g6.g
        public boolean n0() {
            if (this.f12726a.h() == null) {
                return false;
            }
            return ((Boolean) this.f12726a.g(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$inTransaction$1.INSTANCE)).booleanValue();
        }

        @Override // g6.g
        @RequiresApi(api = 16)
        public boolean r0() {
            return ((Boolean) this.f12726a.g(new Function1<g6.g, Boolean>() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isWriteAheadLoggingEnabled$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(g6.g db2) {
                    Intrinsics.g(db2, "db");
                    return Boolean.valueOf(db2.r0());
                }
            })).booleanValue();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    public static final class AutoClosingSupportSqliteStatement implements g6.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f12727a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c f12728b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayList<Object> f12729c;

        public AutoClosingSupportSqliteStatement(String sql, c autoCloser) {
            Intrinsics.g(sql, "sql");
            Intrinsics.g(autoCloser, "autoCloser");
            this.f12727a = sql;
            this.f12728b = autoCloser;
            this.f12729c = new ArrayList<>();
        }

        @Override // g6.k
        public int F() {
            return ((Number) d(new Function1<g6.k, Integer>() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeUpdateDelete$1
                @Override // kotlin.jvm.functions.Function1
                public final Integer invoke(g6.k obj) {
                    Intrinsics.g(obj, "obj");
                    return Integer.valueOf(obj.F());
                }
            })).intValue();
        }

        @Override // g6.k
        public long R() {
            return ((Number) d(new Function1<g6.k, Long>() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeInsert$1
                @Override // kotlin.jvm.functions.Function1
                public final Long invoke(g6.k obj) {
                    Intrinsics.g(obj, "obj");
                    return Long.valueOf(obj.R());
                }
            })).longValue();
        }

        @Override // g6.i
        public void V(int i11, long j11) {
            e(i11, Long.valueOf(j11));
        }

        public final void c(g6.k kVar) {
            Iterator<T> it = this.f12729c.iterator();
            int i11 = 0;
            while (it.hasNext()) {
                it.next();
                int i12 = i11 + 1;
                if (i11 < 0) {
                    kotlin.collections.g.u();
                }
                Object obj = this.f12729c.get(i11);
                if (obj == null) {
                    kVar.m0(i12);
                } else if (obj instanceof Long) {
                    kVar.V(i12, ((Number) obj).longValue());
                } else if (obj instanceof Double) {
                    kVar.f(i12, ((Number) obj).doubleValue());
                } else if (obj instanceof String) {
                    kVar.s(i12, (String) obj);
                } else if (obj instanceof byte[]) {
                    kVar.c0(i12, (byte[]) obj);
                }
                i11 = i12;
            }
        }

        @Override // g6.i
        public void c0(int i11, byte[] value) {
            Intrinsics.g(value, "value");
            e(i11, value);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        public final <T> T d(final Function1<? super g6.k, ? extends T> function1) {
            return (T) this.f12728b.g(new Function1<g6.g, T>() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeSqliteStatementWithRefCount$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final T invoke(g6.g db2) {
                    Intrinsics.g(db2, "db");
                    g6.k kVarS = db2.S(this.this$0.f12727a);
                    this.this$0.c(kVarS);
                    return function1.invoke(kVarS);
                }
            });
        }

        public final void e(int i11, Object obj) {
            int size;
            int i12 = i11 - 1;
            if (i12 >= this.f12729c.size() && (size = this.f12729c.size()) <= i12) {
                while (true) {
                    this.f12729c.add(null);
                    if (size == i12) {
                        break;
                    } else {
                        size++;
                    }
                }
            }
            this.f12729c.set(i12, obj);
        }

        @Override // g6.i
        public void f(int i11, double d11) {
            e(i11, Double.valueOf(d11));
        }

        @Override // g6.i
        public void m0(int i11) {
            e(i11, null);
        }

        @Override // g6.i
        public void s(int i11, String value) {
            Intrinsics.g(value, "value");
            e(i11, value);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    public static final class a implements Cursor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Cursor f12730a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c f12731b;

        public a(Cursor delegate, c autoCloser) {
            Intrinsics.g(delegate, "delegate");
            Intrinsics.g(autoCloser, "autoCloser");
            this.f12730a = delegate;
            this.f12731b = autoCloser;
        }

        @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f12730a.close();
            this.f12731b.e();
        }

        @Override // android.database.Cursor
        public void copyStringToBuffer(int i11, CharArrayBuffer charArrayBuffer) {
            this.f12730a.copyStringToBuffer(i11, charArrayBuffer);
        }

        @Override // android.database.Cursor
        @Deprecated
        public void deactivate() {
            this.f12730a.deactivate();
        }

        @Override // android.database.Cursor
        public byte[] getBlob(int i11) {
            return this.f12730a.getBlob(i11);
        }

        @Override // android.database.Cursor
        public int getColumnCount() {
            return this.f12730a.getColumnCount();
        }

        @Override // android.database.Cursor
        public int getColumnIndex(String str) {
            return this.f12730a.getColumnIndex(str);
        }

        @Override // android.database.Cursor
        public int getColumnIndexOrThrow(String str) {
            return this.f12730a.getColumnIndexOrThrow(str);
        }

        @Override // android.database.Cursor
        public String getColumnName(int i11) {
            return this.f12730a.getColumnName(i11);
        }

        @Override // android.database.Cursor
        public String[] getColumnNames() {
            return this.f12730a.getColumnNames();
        }

        @Override // android.database.Cursor
        public int getCount() {
            return this.f12730a.getCount();
        }

        @Override // android.database.Cursor
        public double getDouble(int i11) {
            return this.f12730a.getDouble(i11);
        }

        @Override // android.database.Cursor
        public Bundle getExtras() {
            return this.f12730a.getExtras();
        }

        @Override // android.database.Cursor
        public float getFloat(int i11) {
            return this.f12730a.getFloat(i11);
        }

        @Override // android.database.Cursor
        public int getInt(int i11) {
            return this.f12730a.getInt(i11);
        }

        @Override // android.database.Cursor
        public long getLong(int i11) {
            return this.f12730a.getLong(i11);
        }

        @Override // android.database.Cursor
        @RequiresApi(api = 19)
        public Uri getNotificationUri() {
            return g6.c.a(this.f12730a);
        }

        @Override // android.database.Cursor
        @RequiresApi(api = VungleException.INCORRECT_DEFAULT_API_USAGE)
        public List<Uri> getNotificationUris() {
            return g6.f.a(this.f12730a);
        }

        @Override // android.database.Cursor
        public int getPosition() {
            return this.f12730a.getPosition();
        }

        @Override // android.database.Cursor
        public short getShort(int i11) {
            return this.f12730a.getShort(i11);
        }

        @Override // android.database.Cursor
        public String getString(int i11) {
            return this.f12730a.getString(i11);
        }

        @Override // android.database.Cursor
        public int getType(int i11) {
            return this.f12730a.getType(i11);
        }

        @Override // android.database.Cursor
        public boolean getWantsAllOnMoveCalls() {
            return this.f12730a.getWantsAllOnMoveCalls();
        }

        @Override // android.database.Cursor
        public boolean isAfterLast() {
            return this.f12730a.isAfterLast();
        }

        @Override // android.database.Cursor
        public boolean isBeforeFirst() {
            return this.f12730a.isBeforeFirst();
        }

        @Override // android.database.Cursor
        public boolean isClosed() {
            return this.f12730a.isClosed();
        }

        @Override // android.database.Cursor
        public boolean isFirst() {
            return this.f12730a.isFirst();
        }

        @Override // android.database.Cursor
        public boolean isLast() {
            return this.f12730a.isLast();
        }

        @Override // android.database.Cursor
        public boolean isNull(int i11) {
            return this.f12730a.isNull(i11);
        }

        @Override // android.database.Cursor
        public boolean move(int i11) {
            return this.f12730a.move(i11);
        }

        @Override // android.database.Cursor
        public boolean moveToFirst() {
            return this.f12730a.moveToFirst();
        }

        @Override // android.database.Cursor
        public boolean moveToLast() {
            return this.f12730a.moveToLast();
        }

        @Override // android.database.Cursor
        public boolean moveToNext() {
            return this.f12730a.moveToNext();
        }

        @Override // android.database.Cursor
        public boolean moveToPosition(int i11) {
            return this.f12730a.moveToPosition(i11);
        }

        @Override // android.database.Cursor
        public boolean moveToPrevious() {
            return this.f12730a.moveToPrevious();
        }

        @Override // android.database.Cursor
        public void registerContentObserver(ContentObserver contentObserver) {
            this.f12730a.registerContentObserver(contentObserver);
        }

        @Override // android.database.Cursor
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.f12730a.registerDataSetObserver(dataSetObserver);
        }

        @Override // android.database.Cursor
        @Deprecated
        public boolean requery() {
            return this.f12730a.requery();
        }

        @Override // android.database.Cursor
        public Bundle respond(Bundle bundle) {
            return this.f12730a.respond(bundle);
        }

        @Override // android.database.Cursor
        @RequiresApi(api = 23)
        public void setExtras(Bundle extras) {
            Intrinsics.g(extras, "extras");
            g6.e.a(this.f12730a, extras);
        }

        @Override // android.database.Cursor
        public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
            this.f12730a.setNotificationUri(contentResolver, uri);
        }

        @Override // android.database.Cursor
        @RequiresApi(api = VungleException.INCORRECT_DEFAULT_API_USAGE)
        public void setNotificationUris(ContentResolver cr2, List<? extends Uri> uris) {
            Intrinsics.g(cr2, "cr");
            Intrinsics.g(uris, "uris");
            g6.f.b(this.f12730a, cr2, uris);
        }

        @Override // android.database.Cursor
        public void unregisterContentObserver(ContentObserver contentObserver) {
            this.f12730a.unregisterContentObserver(contentObserver);
        }

        @Override // android.database.Cursor
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            this.f12730a.unregisterDataSetObserver(dataSetObserver);
        }
    }

    public AutoClosingRoomOpenHelper(g6.h delegate, c autoCloser) {
        Intrinsics.g(delegate, "delegate");
        Intrinsics.g(autoCloser, "autoCloser");
        this.f12723a = delegate;
        this.f12724b = autoCloser;
        autoCloser.k(getDelegate());
        this.f12725c = new AutoClosingSupportSQLiteDatabase(autoCloser);
    }

    @Override // g6.h, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f12725c.close();
    }

    @Override // g6.h
    public String getDatabaseName() {
        return this.f12723a.getDatabaseName();
    }

    @Override // androidx.room.g
    public g6.h getDelegate() {
        return this.f12723a;
    }

    @Override // g6.h
    @RequiresApi(api = 24)
    public g6.g getWritableDatabase() {
        this.f12725c.a();
        return this.f12725c;
    }

    @Override // g6.h
    @RequiresApi(api = 16)
    public void setWriteAheadLoggingEnabled(boolean z11) {
        this.f12723a.setWriteAheadLoggingEnabled(z11);
    }
}
