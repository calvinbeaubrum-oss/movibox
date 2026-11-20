package androidx.room;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public abstract class SharedSQLiteStatement {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f12807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f12808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f12809c;

    public SharedSQLiteStatement(RoomDatabase database) {
        Intrinsics.g(database, "database");
        this.f12807a = database;
        this.f12808b = new AtomicBoolean(false);
        this.f12809c = LazyKt__LazyJVMKt.b(new Function0<g6.k>() { // from class: androidx.room.SharedSQLiteStatement$stmt$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final g6.k invoke() {
                return this.this$0.d();
            }
        });
    }

    public g6.k b() {
        c();
        return g(this.f12808b.compareAndSet(false, true));
    }

    public void c() {
        this.f12807a.c();
    }

    public final g6.k d() {
        return this.f12807a.f(e());
    }

    public abstract String e();

    public final g6.k f() {
        return (g6.k) this.f12809c.getValue();
    }

    public final g6.k g(boolean z11) {
        return z11 ? f() : d();
    }

    public void h(g6.k statement) {
        Intrinsics.g(statement, "statement");
        if (statement == f()) {
            this.f12808b.set(false);
        }
    }
}
