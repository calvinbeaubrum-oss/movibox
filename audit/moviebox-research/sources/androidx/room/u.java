package androidx.room;

import android.database.Cursor;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmField;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class u extends g6.h.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f12885g = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f12886c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f12887d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f12888e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f12889f;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(g6.g db2) {
            Intrinsics.g(db2, "db");
            Cursor cursorF0 = db2.f0("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
            try {
                boolean z11 = false;
                if (cursorF0.moveToFirst() && cursorF0.getInt(0) == 0) {
                    z11 = true;
                }
                CloseableKt.a(cursorF0, null);
                return z11;
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    CloseableKt.a(cursorF0, th2);
                    throw th3;
                }
            }
        }

        public final boolean b(g6.g db2) {
            Intrinsics.g(db2, "db");
            Cursor cursorF0 = db2.f0("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
            try {
                boolean z11 = false;
                if (cursorF0.moveToFirst() && cursorF0.getInt(0) != 0) {
                    z11 = true;
                }
                CloseableKt.a(cursorF0, null);
                return z11;
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    CloseableKt.a(cursorF0, th2);
                    throw th3;
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @JvmField
        public final int f12890a;

        public b(int i11) {
            this.f12890a = i11;
        }

        public abstract void a(g6.g gVar);

        public abstract void b(g6.g gVar);

        public abstract void c(g6.g gVar);

        public abstract void d(g6.g gVar);

        public abstract void e(g6.g gVar);

        public abstract void f(g6.g gVar);

        public abstract c g(g6.g gVar);
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @JvmField
        public final boolean f12891a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @JvmField
        public final String f12892b;

        public c(boolean z11, String str) {
            this.f12891a = z11;
            this.f12892b = str;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(f configuration, b delegate, String identityHash, String legacyHash) {
        super(delegate.f12890a);
        Intrinsics.g(configuration, "configuration");
        Intrinsics.g(delegate, "delegate");
        Intrinsics.g(identityHash, "identityHash");
        Intrinsics.g(legacyHash, "legacyHash");
        this.f12886c = configuration;
        this.f12887d = delegate;
        this.f12888e = identityHash;
        this.f12889f = legacyHash;
    }

    @Override // g6.h.a
    public void b(g6.g db2) {
        Intrinsics.g(db2, "db");
        super.b(db2);
    }

    @Override // g6.h.a
    public void d(g6.g db2) {
        Intrinsics.g(db2, "db");
        boolean zA = f12885g.a(db2);
        this.f12887d.a(db2);
        if (!zA) {
            c cVarG = this.f12887d.g(db2);
            if (!cVarG.f12891a) {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + cVarG.f12892b);
            }
        }
        j(db2);
        this.f12887d.c(db2);
    }

    @Override // g6.h.a
    public void e(g6.g db2, int i11, int i12) {
        Intrinsics.g(db2, "db");
        g(db2, i11, i12);
    }

    @Override // g6.h.a
    public void f(g6.g db2) {
        Intrinsics.g(db2, "db");
        super.f(db2);
        h(db2);
        this.f12887d.d(db2);
        this.f12886c = null;
    }

    @Override // g6.h.a
    public void g(g6.g db2, int i11, int i12) {
        List<d6.b> listD;
        Intrinsics.g(db2, "db");
        f fVar = this.f12886c;
        if (fVar == null || (listD = fVar.f12843d.d(i11, i12)) == null) {
            f fVar2 = this.f12886c;
            if (fVar2 != null && !fVar2.a(i11, i12)) {
                this.f12887d.b(db2);
                this.f12887d.a(db2);
                return;
            }
            throw new IllegalStateException("A migration from " + i11 + " to " + i12 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
        }
        this.f12887d.f(db2);
        Iterator<T> it = listD.iterator();
        while (it.hasNext()) {
            ((d6.b) it.next()).a(db2);
        }
        c cVarG = this.f12887d.g(db2);
        if (cVarG.f12891a) {
            this.f12887d.e(db2);
            j(db2);
        } else {
            throw new IllegalStateException("Migration didn't properly handle: " + cVarG.f12892b);
        }
    }

    public final void h(g6.g gVar) {
        if (!f12885g.b(gVar)) {
            c cVarG = this.f12887d.g(gVar);
            if (cVarG.f12891a) {
                this.f12887d.e(gVar);
                j(gVar);
                return;
            } else {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + cVarG.f12892b);
            }
        }
        Cursor cursorX = gVar.X(new g6.a("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
        try {
            String string = cursorX.moveToFirst() ? cursorX.getString(0) : null;
            CloseableKt.a(cursorX, null);
            if (Intrinsics.b(this.f12888e, string) || Intrinsics.b(this.f12889f, string)) {
                return;
            }
            throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: " + this.f12888e + ", found: " + string);
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                CloseableKt.a(cursorX, th2);
                throw th3;
            }
        }
    }

    public final void i(g6.g gVar) {
        gVar.E("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
    }

    public final void j(g6.g gVar) {
        i(gVar);
        gVar.E(t.a(this.f12888e));
    }
}
