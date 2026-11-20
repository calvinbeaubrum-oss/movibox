package androidx.sqlite.db.framework;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;
import android.os.CancellationSignal;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import g6.g;
import g6.j;
import g6.k;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class FrameworkSQLiteDatabase implements g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f12969b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f12970c = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f12971d = new String[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SQLiteDatabase f12972a;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public FrameworkSQLiteDatabase(SQLiteDatabase delegate) {
        Intrinsics.g(delegate, "delegate");
        this.f12972a = delegate;
    }

    public static final Cursor d(Function4 tmp0, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        Intrinsics.g(tmp0, "$tmp0");
        return (Cursor) tmp0.invoke(sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
    }

    public static final Cursor e(j query, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        Intrinsics.g(query, "$query");
        Intrinsics.d(sQLiteQuery);
        query.b(new e(sQLiteQuery));
        return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
    }

    @Override // g6.g
    public void A() {
        this.f12972a.beginTransaction();
    }

    @Override // g6.g
    public List<Pair<String, String>> D() {
        return this.f12972a.getAttachedDbs();
    }

    @Override // g6.g
    public void E(String sql) throws SQLException {
        Intrinsics.g(sql, "sql");
        this.f12972a.execSQL(sql);
    }

    @Override // g6.g
    public void I() {
        this.f12972a.setTransactionSuccessful();
    }

    @Override // g6.g
    public void J(String sql, Object[] bindArgs) throws SQLException {
        Intrinsics.g(sql, "sql");
        Intrinsics.g(bindArgs, "bindArgs");
        this.f12972a.execSQL(sql, bindArgs);
    }

    @Override // g6.g
    public void K() {
        this.f12972a.beginTransactionNonExclusive();
    }

    @Override // g6.g
    public void L() {
        this.f12972a.endTransaction();
    }

    @Override // g6.g
    public k S(String sql) {
        Intrinsics.g(sql, "sql");
        SQLiteStatement sQLiteStatementCompileStatement = this.f12972a.compileStatement(sql);
        Intrinsics.f(sQLiteStatementCompileStatement, "delegate.compileStatement(sql)");
        return new f(sQLiteStatementCompileStatement);
    }

    @Override // g6.g
    public Cursor X(final j query) {
        Intrinsics.g(query, "query");
        final Function4<SQLiteDatabase, SQLiteCursorDriver, String, SQLiteQuery, SQLiteCursor> function4 = new Function4<SQLiteDatabase, SQLiteCursorDriver, String, SQLiteQuery, SQLiteCursor>() { // from class: androidx.sqlite.db.framework.FrameworkSQLiteDatabase$query$cursorFactory$1
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public final SQLiteCursor invoke(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                j jVar = query;
                Intrinsics.d(sQLiteQuery);
                jVar.b(new e(sQLiteQuery));
                return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
            }
        };
        Cursor cursorRawQueryWithFactory = this.f12972a.rawQueryWithFactory(new SQLiteDatabase.CursorFactory() { // from class: androidx.sqlite.db.framework.b
            @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
            public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                return FrameworkSQLiteDatabase.d(function4, sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
            }
        }, query.a(), f12971d, null);
        Intrinsics.f(cursorRawQueryWithFactory, "delegate.rawQueryWithFac…EMPTY_STRING_ARRAY, null)");
        return cursorRawQueryWithFactory;
    }

    @Override // g6.g
    @RequiresApi(16)
    public Cursor Y(final j query, CancellationSignal cancellationSignal) {
        Intrinsics.g(query, "query");
        SQLiteDatabase sQLiteDatabase = this.f12972a;
        String strA = query.a();
        String[] strArr = f12971d;
        Intrinsics.d(cancellationSignal);
        return g6.b.e(sQLiteDatabase, strA, strArr, null, cancellationSignal, new SQLiteDatabase.CursorFactory() { // from class: androidx.sqlite.db.framework.a
            @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
            public final Cursor newCursor(SQLiteDatabase sQLiteDatabase2, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                return FrameworkSQLiteDatabase.e(query, sQLiteDatabase2, sQLiteCursorDriver, str, sQLiteQuery);
            }
        });
    }

    @Override // g6.g
    public int a0(String table, int i11, ContentValues values, String str, Object[] objArr) {
        Intrinsics.g(table, "table");
        Intrinsics.g(values, "values");
        if (values.size() == 0) {
            throw new IllegalArgumentException("Empty values".toString());
        }
        int size = values.size();
        int length = objArr == null ? size : objArr.length + size;
        Object[] objArr2 = new Object[length];
        StringBuilder sb2 = new StringBuilder();
        sb2.append("UPDATE ");
        sb2.append(f12970c[i11]);
        sb2.append(table);
        sb2.append(" SET ");
        int i12 = 0;
        for (String str2 : values.keySet()) {
            sb2.append(i12 > 0 ? "," : "");
            sb2.append(str2);
            objArr2[i12] = values.get(str2);
            sb2.append("=?");
            i12++;
        }
        if (objArr != null) {
            for (int i13 = size; i13 < length; i13++) {
                objArr2[i13] = objArr[i13 - size];
            }
        }
        if (!TextUtils.isEmpty(str)) {
            sb2.append(" WHERE ");
            sb2.append(str);
        }
        String string = sb2.toString();
        Intrinsics.f(string, "StringBuilder().apply(builderAction).toString()");
        k kVarS = S(string);
        g6.a.f65409c.b(kVarS, objArr2);
        return kVarS.F();
    }

    public final boolean c(SQLiteDatabase sqLiteDatabase) {
        Intrinsics.g(sqLiteDatabase, "sqLiteDatabase");
        return Intrinsics.b(this.f12972a, sqLiteDatabase);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f12972a.close();
    }

    @Override // g6.g
    public Cursor f0(String query) {
        Intrinsics.g(query, "query");
        return X(new g6.a(query));
    }

    @Override // g6.g
    public String getPath() {
        return this.f12972a.getPath();
    }

    @Override // g6.g
    public boolean isOpen() {
        return this.f12972a.isOpen();
    }

    @Override // g6.g
    public boolean n0() {
        return this.f12972a.inTransaction();
    }

    @Override // g6.g
    @RequiresApi(api = 16)
    public boolean r0() {
        return g6.b.d(this.f12972a);
    }
}
