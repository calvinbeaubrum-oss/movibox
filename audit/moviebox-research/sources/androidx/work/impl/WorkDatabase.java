package androidx.work.impl;

import android.content.Context;
import androidx.room.RoomDatabase;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
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
public abstract class WorkDatabase extends RoomDatabase {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final a f13327p = new a(null);

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static final g6.h c(Context context, g6.h.b configuration) {
            Intrinsics.g(context, "$context");
            Intrinsics.g(configuration, "configuration");
            g6.h.b.a aVarA = g6.h.b.f65419f.a(context);
            aVarA.d(configuration.f65421b).c(configuration.f65422c).e(true).a(true);
            return new androidx.sqlite.db.framework.d().a(aVarA.b());
        }

        @JvmStatic
        public final WorkDatabase b(final Context context, Executor queryExecutor, boolean z11) {
            Intrinsics.g(context, "context");
            Intrinsics.g(queryExecutor, "queryExecutor");
            return (WorkDatabase) (z11 ? androidx.room.r.c(context, WorkDatabase.class).c() : androidx.room.r.a(context, WorkDatabase.class, "androidx.work.workdb").f(new g6.h.c() { // from class: androidx.work.impl.x
                @Override // g6.h.c
                public final g6.h a(g6.h.b bVar) {
                    return WorkDatabase.a.c(context, bVar);
                }
            })).g(queryExecutor).a(c.f13413a).b(i.f13467c).b(new r(context, 2, 3)).b(j.f13470c).b(k.f13471c).b(new r(context, 5, 6)).b(l.f13472c).b(m.f13473c).b(n.f13474c).b(new f0(context)).b(new r(context, 10, 11)).b(f.f13434c).b(g.f13453c).b(h.f13459c).e().d();
        }
    }

    @JvmStatic
    public static final WorkDatabase G(Context context, Executor executor, boolean z11) {
        return f13327p.b(context, executor, z11);
    }

    public abstract s6.b H();

    public abstract s6.e I();

    public abstract s6.g J();

    public abstract s6.j K();

    public abstract s6.o L();

    public abstract s6.r M();

    public abstract s6.v N();

    public abstract s6.z O();
}
