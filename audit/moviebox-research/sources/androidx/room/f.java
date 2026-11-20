package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    public final Context f12840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    public final String f12841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JvmField
    public final g6.h.c f12842c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @JvmField
    public final RoomDatabase.d f12843d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @JvmField
    public final List<RoomDatabase.b> f12844e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @JvmField
    public final boolean f12845f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @JvmField
    public final RoomDatabase.JournalMode f12846g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @JvmField
    public final Executor f12847h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @JvmField
    public final Executor f12848i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @JvmField
    public final Intent f12849j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @JvmField
    public final boolean f12850k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @JvmField
    public final boolean f12851l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Set<Integer> f12852m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @JvmField
    public final String f12853n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @JvmField
    public final File f12854o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @JvmField
    public final Callable<InputStream> f12855p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @JvmField
    public final List<Object> f12856q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @JvmField
    public final List<d6.a> f12857r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @JvmField
    public final boolean f12858s;

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"LambdaLast"})
    public f(Context context, String str, g6.h.c sqliteOpenHelperFactory, RoomDatabase.d migrationContainer, List<? extends RoomDatabase.b> list, boolean z11, RoomDatabase.JournalMode journalMode, Executor queryExecutor, Executor transactionExecutor, Intent intent, boolean z12, boolean z13, Set<Integer> set, String str2, File file, Callable<InputStream> callable, RoomDatabase.e eVar, List<? extends Object> typeConverters, List<? extends d6.a> autoMigrationSpecs) {
        Intrinsics.g(context, "context");
        Intrinsics.g(sqliteOpenHelperFactory, "sqliteOpenHelperFactory");
        Intrinsics.g(migrationContainer, "migrationContainer");
        Intrinsics.g(journalMode, "journalMode");
        Intrinsics.g(queryExecutor, "queryExecutor");
        Intrinsics.g(transactionExecutor, "transactionExecutor");
        Intrinsics.g(typeConverters, "typeConverters");
        Intrinsics.g(autoMigrationSpecs, "autoMigrationSpecs");
        this.f12840a = context;
        this.f12841b = str;
        this.f12842c = sqliteOpenHelperFactory;
        this.f12843d = migrationContainer;
        this.f12844e = list;
        this.f12845f = z11;
        this.f12846g = journalMode;
        this.f12847h = queryExecutor;
        this.f12848i = transactionExecutor;
        this.f12849j = intent;
        this.f12850k = z12;
        this.f12851l = z13;
        this.f12852m = set;
        this.f12853n = str2;
        this.f12854o = file;
        this.f12855p = callable;
        this.f12856q = typeConverters;
        this.f12857r = autoMigrationSpecs;
        this.f12858s = intent != null;
    }

    public boolean a(int i11, int i12) {
        if ((i11 > i12 && this.f12851l) || !this.f12850k) {
            return false;
        }
        Set<Integer> set = this.f12852m;
        return set == null || !set.contains(Integer.valueOf(i11));
    }
}
