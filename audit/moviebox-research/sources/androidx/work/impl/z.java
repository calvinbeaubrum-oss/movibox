package androidx.work.impl;

import android.content.Context;
import android.os.Build;
import androidx.annotation.RequiresApi;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.JvmStatic;
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
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f13566a = new z();

    @JvmStatic
    public static final void d(Context context) {
        Intrinsics.g(context, "context");
        z zVar = f13566a;
        File fileB = zVar.b(context);
        if (Build.VERSION.SDK_INT < 23 || !fileB.exists()) {
            return;
        }
        androidx.work.j.e().a(a0.f13348a, "Migrating WorkDatabase to the no-backup directory");
        for (Map.Entry<File, File> entry : zVar.e(context).entrySet()) {
            File key = entry.getKey();
            File value = entry.getValue();
            if (key.exists()) {
                if (value.exists()) {
                    androidx.work.j.e().k(a0.f13348a, "Over-writing contents of " + value);
                }
                androidx.work.j.e().a(a0.f13348a, key.renameTo(value) ? "Migrated " + key + "to " + value : "Renaming " + key + " to " + value + " failed");
            }
        }
    }

    public final File a(Context context) {
        Intrinsics.g(context, "context");
        return Build.VERSION.SDK_INT < 23 ? b(context) : c(context);
    }

    public final File b(Context context) {
        Intrinsics.g(context, "context");
        File databasePath = context.getDatabasePath("androidx.work.workdb");
        Intrinsics.f(databasePath, "context.getDatabasePath(WORK_DATABASE_NAME)");
        return databasePath;
    }

    @RequiresApi(23)
    public final File c(Context context) {
        return new File(a.f13347a.a(context), "androidx.work.workdb");
    }

    public final Map<File, File> e(Context context) {
        Intrinsics.g(context, "context");
        if (Build.VERSION.SDK_INT < 23) {
            return kotlin.collections.s.h();
        }
        File fileB = b(context);
        File fileA = a(context);
        String[] strArr = a0.f13349b;
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.a.d(kotlin.collections.r.e(strArr.length), 16));
        for (String str : strArr) {
            Pair pairA = TuplesKt.a(new File(fileB.getPath() + str), new File(fileA.getPath() + str));
            linkedHashMap.put(pairA.getFirst(), pairA.getSecond());
        }
        return kotlin.collections.s.o(linkedHashMap, TuplesKt.a(fileB, fileA));
    }
}
