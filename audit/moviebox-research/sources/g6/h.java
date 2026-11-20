package g6;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.l;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface h extends Closeable {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static abstract class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C0683a f65417b = new C0683a(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @JvmField
        public final int f65418a;

        /* JADX INFO: renamed from: g6.h$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class C0683a {
            public C0683a() {
            }

            public /* synthetic */ C0683a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public a(int i11) {
            this.f65418a = i11;
        }

        public final void a(String str) {
            if (l.v(str, ":memory:", true)) {
                return;
            }
            int length = str.length() - 1;
            int i11 = 0;
            boolean z11 = false;
            while (i11 <= length) {
                boolean z12 = Intrinsics.i(str.charAt(!z11 ? i11 : length), 32) <= 0;
                if (z11) {
                    if (!z12) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z12) {
                    i11++;
                } else {
                    z11 = true;
                }
            }
            if (str.subSequence(i11, length + 1).toString().length() == 0) {
                return;
            }
            Log.w("SupportSQLite", "deleting the database file: " + str);
            try {
                g6.b.c(new File(str));
            } catch (Exception e11) {
                Log.w("SupportSQLite", "delete failed: ", e11);
            }
        }

        public void b(g db2) {
            Intrinsics.g(db2, "db");
        }

        public void c(g db2) {
            Intrinsics.g(db2, "db");
            Log.e("SupportSQLite", "Corruption reported by sqlite on database: " + db2 + ".path");
            if (!db2.isOpen()) {
                String path = db2.getPath();
                if (path != null) {
                    a(path);
                    return;
                }
                return;
            }
            List<Pair<String, String>> listD = null;
            try {
                try {
                    listD = db2.D();
                } catch (SQLiteException unused) {
                }
                try {
                    db2.close();
                } catch (IOException unused2) {
                }
                if (listD != null) {
                    return;
                }
            } finally {
                if (listD != null) {
                    Iterator<T> it = listD.iterator();
                    while (it.hasNext()) {
                        Object obj = ((Pair) it.next()).second;
                        Intrinsics.f(obj, "p.second");
                        a((String) obj);
                    }
                } else {
                    String path2 = db2.getPath();
                    if (path2 != null) {
                        a(path2);
                    }
                }
            }
        }

        public abstract void d(g gVar);

        public abstract void e(g gVar, int i11, int i12);

        public void f(g db2) {
            Intrinsics.g(db2, "db");
        }

        public abstract void g(g gVar, int i11, int i12);
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final C0684b f65419f = new C0684b(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @JvmField
        public final Context f65420a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @JvmField
        public final String f65421b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @JvmField
        public final a f65422c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @JvmField
        public final boolean f65423d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @JvmField
        public final boolean f65424e;

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Context f65425a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f65426b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public a f65427c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f65428d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public boolean f65429e;

            public a(Context context) {
                Intrinsics.g(context, "context");
                this.f65425a = context;
            }

            public a a(boolean z11) {
                this.f65429e = z11;
                return this;
            }

            public b b() {
                String str;
                a aVar = this.f65427c;
                if (aVar == null) {
                    throw new IllegalArgumentException("Must set a callback to create the configuration.".toString());
                }
                if (this.f65428d && ((str = this.f65426b) == null || str.length() == 0)) {
                    throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.".toString());
                }
                return new b(this.f65425a, this.f65426b, aVar, this.f65428d, this.f65429e);
            }

            public a c(a callback) {
                Intrinsics.g(callback, "callback");
                this.f65427c = callback;
                return this;
            }

            public a d(String str) {
                this.f65426b = str;
                return this;
            }

            public a e(boolean z11) {
                this.f65428d = z11;
                return this;
            }
        }

        /* JADX INFO: renamed from: g6.h$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class C0684b {
            public C0684b() {
            }

            public /* synthetic */ C0684b(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            public final a a(Context context) {
                Intrinsics.g(context, "context");
                return new a(context);
            }
        }

        public b(Context context, String str, a callback, boolean z11, boolean z12) {
            Intrinsics.g(context, "context");
            Intrinsics.g(callback, "callback");
            this.f65420a = context;
            this.f65421b = str;
            this.f65422c = callback;
            this.f65423d = z11;
            this.f65424e = z12;
        }

        @JvmStatic
        public static final a a(Context context) {
            return f65419f.a(context);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface c {
        h a(b bVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    String getDatabaseName();

    g getWritableDatabase();

    @RequiresApi(api = 16)
    void setWriteAheadLoggingEnabled(boolean z11);
}
