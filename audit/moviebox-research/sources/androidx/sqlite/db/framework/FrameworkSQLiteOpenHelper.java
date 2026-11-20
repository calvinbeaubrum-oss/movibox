package androidx.sqlite.db.framework;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;
import androidx.annotation.RequiresApi;
import g6.g;
import g6.h;
import java.io.File;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
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
public final class FrameworkSQLiteOpenHelper implements h {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f12973i = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f12974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h.a f12976c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f12977d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f12978f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy<OpenHelper> f12979g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f12980h;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class OpenHelper extends SQLiteOpenHelper {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final a f12981i = new a(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f12982a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b f12983b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final h.a f12984c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f12985d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f12986f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final h6.a f12987g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f12988h;

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class CallbackException extends RuntimeException {
            private final CallbackName callbackName;
            private final Throwable cause;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CallbackException(CallbackName callbackName, Throwable cause) {
                super(cause);
                Intrinsics.g(callbackName, "callbackName");
                Intrinsics.g(cause, "cause");
                this.callbackName = callbackName;
                this.cause = cause;
            }

            public final CallbackName getCallbackName() {
                return this.callbackName;
            }

            @Override // java.lang.Throwable
            public Throwable getCause() {
                return this.cause;
            }
        }

        /* JADX INFO: compiled from: source.java */
        /* JADX INFO: loaded from: classes2.dex */
        @Metadata
        public enum CallbackName {
            ON_CONFIGURE,
            ON_CREATE,
            ON_UPGRADE,
            ON_DOWNGRADE,
            ON_OPEN
        }

        /* JADX INFO: compiled from: source.java */
        /* JADX INFO: loaded from: classes2.dex */
        @Metadata
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final FrameworkSQLiteDatabase a(b refHolder, SQLiteDatabase sqLiteDatabase) {
                Intrinsics.g(refHolder, "refHolder");
                Intrinsics.g(sqLiteDatabase, "sqLiteDatabase");
                FrameworkSQLiteDatabase frameworkSQLiteDatabaseA = refHolder.a();
                if (frameworkSQLiteDatabaseA != null && frameworkSQLiteDatabaseA.c(sqLiteDatabase)) {
                    return frameworkSQLiteDatabaseA;
                }
                FrameworkSQLiteDatabase frameworkSQLiteDatabase = new FrameworkSQLiteDatabase(sqLiteDatabase);
                refHolder.b(frameworkSQLiteDatabase);
                return frameworkSQLiteDatabase;
            }
        }

        /* JADX INFO: compiled from: source.java */
        /* JADX INFO: loaded from: classes2.dex */
        @Metadata
        public /* synthetic */ class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f12989a;

            static {
                int[] iArr = new int[CallbackName.values().length];
                try {
                    iArr[CallbackName.ON_CONFIGURE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[CallbackName.ON_CREATE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[CallbackName.ON_UPGRADE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[CallbackName.ON_DOWNGRADE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[CallbackName.ON_OPEN.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                f12989a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenHelper(Context context, String str, final b dbRef, final h.a callback, boolean z11) {
            super(context, str, null, callback.f65418a, new DatabaseErrorHandler() { // from class: androidx.sqlite.db.framework.c
                @Override // android.database.DatabaseErrorHandler
                public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
                    FrameworkSQLiteOpenHelper.OpenHelper.b(callback, dbRef, sQLiteDatabase);
                }
            });
            Intrinsics.g(context, "context");
            Intrinsics.g(dbRef, "dbRef");
            Intrinsics.g(callback, "callback");
            this.f12982a = context;
            this.f12983b = dbRef;
            this.f12984c = callback;
            this.f12985d = z11;
            if (str == null) {
                str = UUID.randomUUID().toString();
                Intrinsics.f(str, "randomUUID().toString()");
            }
            this.f12987g = new h6.a(str, context.getCacheDir(), false);
        }

        public static final void b(h.a callback, b dbRef, SQLiteDatabase dbObj) {
            Intrinsics.g(callback, "$callback");
            Intrinsics.g(dbRef, "$dbRef");
            a aVar = f12981i;
            Intrinsics.f(dbObj, "dbObj");
            callback.c(aVar.a(dbRef, dbObj));
        }

        public final g c(boolean z11) {
            try {
                this.f12987g.b((this.f12988h || getDatabaseName() == null) ? false : true);
                this.f12986f = false;
                SQLiteDatabase sQLiteDatabaseG = g(z11);
                if (!this.f12986f) {
                    return d(sQLiteDatabaseG);
                }
                close();
                return c(z11);
            } finally {
                this.f12987g.d();
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public void close() {
            try {
                h6.a.c(this.f12987g, false, 1, null);
                super.close();
                this.f12983b.b(null);
                this.f12988h = false;
            } finally {
                this.f12987g.d();
            }
        }

        public final FrameworkSQLiteDatabase d(SQLiteDatabase sqLiteDatabase) {
            Intrinsics.g(sqLiteDatabase, "sqLiteDatabase");
            return f12981i.a(this.f12983b, sqLiteDatabase);
        }

        public final SQLiteDatabase e(boolean z11) {
            if (z11) {
                SQLiteDatabase writableDatabase = super.getWritableDatabase();
                Intrinsics.f(writableDatabase, "{\n                super.…eDatabase()\n            }");
                return writableDatabase;
            }
            SQLiteDatabase readableDatabase = super.getReadableDatabase();
            Intrinsics.f(readableDatabase, "{\n                super.…eDatabase()\n            }");
            return readableDatabase;
        }

        public final SQLiteDatabase g(boolean z11) throws Throwable {
            File parentFile;
            String databaseName = getDatabaseName();
            boolean z12 = this.f12988h;
            if (databaseName != null && !z12 && (parentFile = this.f12982a.getDatabasePath(databaseName).getParentFile()) != null) {
                parentFile.mkdirs();
                if (!parentFile.isDirectory()) {
                    Log.w("SupportSQLite", "Invalid database parent file, not a directory: " + parentFile);
                }
            }
            try {
                return e(z11);
            } catch (Throwable unused) {
                super.close();
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException unused2) {
                }
                try {
                    return e(z11);
                } catch (Throwable th2) {
                    super.close();
                    if (th2 instanceof CallbackException) {
                        CallbackException callbackException = th2;
                        Throwable cause = callbackException.getCause();
                        int i11 = b.f12989a[callbackException.getCallbackName().ordinal()];
                        if (i11 == 1 || i11 == 2 || i11 == 3 || i11 == 4 || !(cause instanceof SQLiteException)) {
                            throw cause;
                        }
                    } else if (!(th2 instanceof SQLiteException) || databaseName == null || !this.f12985d) {
                        throw th2;
                    }
                    this.f12982a.deleteDatabase(databaseName);
                    try {
                        return e(z11);
                    } catch (CallbackException e11) {
                        throw e11.getCause();
                    }
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase db2) {
            Intrinsics.g(db2, "db");
            if (!this.f12986f && this.f12984c.f65418a != db2.getVersion()) {
                db2.setMaxSqlCacheSize(1);
            }
            try {
                this.f12984c.b(d(db2));
            } catch (Throwable th2) {
                throw new CallbackException(CallbackName.ON_CONFIGURE, th2);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            Intrinsics.g(sqLiteDatabase, "sqLiteDatabase");
            try {
                this.f12984c.d(d(sqLiteDatabase));
            } catch (Throwable th2) {
                throw new CallbackException(CallbackName.ON_CREATE, th2);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase db2, int i11, int i12) {
            Intrinsics.g(db2, "db");
            this.f12986f = true;
            try {
                this.f12984c.e(d(db2), i11, i12);
            } catch (Throwable th2) {
                throw new CallbackException(CallbackName.ON_DOWNGRADE, th2);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase db2) {
            Intrinsics.g(db2, "db");
            if (!this.f12986f) {
                try {
                    this.f12984c.f(d(db2));
                } catch (Throwable th2) {
                    throw new CallbackException(CallbackName.ON_OPEN, th2);
                }
            }
            this.f12988h = true;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i11, int i12) {
            Intrinsics.g(sqLiteDatabase, "sqLiteDatabase");
            this.f12986f = true;
            try {
                this.f12984c.g(d(sqLiteDatabase), i11, i12);
            } catch (Throwable th2) {
                throw new CallbackException(CallbackName.ON_UPGRADE, th2);
            }
        }
    }

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

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public FrameworkSQLiteDatabase f12990a;

        public b(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
            this.f12990a = frameworkSQLiteDatabase;
        }

        public final FrameworkSQLiteDatabase a() {
            return this.f12990a;
        }

        public final void b(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
            this.f12990a = frameworkSQLiteDatabase;
        }
    }

    @JvmOverloads
    public FrameworkSQLiteOpenHelper(Context context, String str, h.a callback, boolean z11, boolean z12) {
        Intrinsics.g(context, "context");
        Intrinsics.g(callback, "callback");
        this.f12974a = context;
        this.f12975b = str;
        this.f12976c = callback;
        this.f12977d = z11;
        this.f12978f = z12;
        this.f12979g = LazyKt__LazyJVMKt.b(new Function0<OpenHelper>() { // from class: androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$lazyDelegate$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrameworkSQLiteOpenHelper.OpenHelper invoke() {
                FrameworkSQLiteOpenHelper.OpenHelper openHelper;
                if (Build.VERSION.SDK_INT < 23 || this.this$0.f12975b == null || !this.this$0.f12977d) {
                    openHelper = new FrameworkSQLiteOpenHelper.OpenHelper(this.this$0.f12974a, this.this$0.f12975b, new FrameworkSQLiteOpenHelper.b(null), this.this$0.f12976c, this.this$0.f12978f);
                } else {
                    openHelper = new FrameworkSQLiteOpenHelper.OpenHelper(this.this$0.f12974a, new File(g6.d.a(this.this$0.f12974a), this.this$0.f12975b).getAbsolutePath(), new FrameworkSQLiteOpenHelper.b(null), this.this$0.f12976c, this.this$0.f12978f);
                }
                g6.b.f(openHelper, this.this$0.f12980h);
                return openHelper;
            }
        });
    }

    @Override // g6.h, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f12979g.isInitialized()) {
            h().close();
        }
    }

    @Override // g6.h
    public String getDatabaseName() {
        return this.f12975b;
    }

    @Override // g6.h
    public g getWritableDatabase() {
        return h().c(true);
    }

    public final OpenHelper h() {
        return this.f12979g.getValue();
    }

    @Override // g6.h
    @RequiresApi(api = 16)
    public void setWriteAheadLoggingEnabled(boolean z11) {
        if (this.f12979g.isInitialized()) {
            g6.b.f(h(), z11);
        }
        this.f12980h = z11;
    }
}
