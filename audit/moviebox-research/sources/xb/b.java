package xb;

import com.cloud.tmc.miniutils.util.j;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@SourceDebugExtension
public final class b {
    public static final boolean a(File file, boolean z11) {
        Intrinsics.g(file, "<this>");
        if (!file.exists()) {
            return true;
        }
        if (file.isDirectory()) {
            return z11 ? b(file) : file.delete();
        }
        return false;
    }

    public static final boolean b(File file) {
        Intrinsics.g(file, "<this>");
        return j.m(file);
    }

    public static final String c(File file) {
        Intrinsics.g(file, "<this>");
        return fd.a.b(FilesKt__UtilsKt.t(file), file.isDirectory());
    }

    public static final long d(File file) {
        Intrinsics.g(file, "<this>");
        return j.v(file);
    }

    public static final File[] e(File file, boolean z11, Function1<? super File, Boolean> function1) {
        File[] fileList;
        Intrinsics.g(file, "<this>");
        try {
            if (z11) {
                List<File> listC = j.C(file, z11);
                Intrinsics.f(listC, "listFilesInDir(this, isRecursive)");
                fileList = (File[]) listC.toArray(new File[0]);
            } else {
                fileList = file.listFiles();
            }
            if (function1 == null) {
                Intrinsics.f(fileList, "fileList");
                return fileList;
            }
            File[] fileArr = new File[0];
            Intrinsics.f(fileList, "fileList");
            for (File file2 : fileList) {
                Intrinsics.f(file2, "file");
                if (function1.invoke(file2).booleanValue()) {
                    fileArr = (File[]) ArraysKt___ArraysJvmKt.A(fileArr, file2);
                }
            }
            return fileArr;
        } catch (Throwable unused) {
            return new File[0];
        }
    }

    public static /* synthetic */ File[] f(File file, boolean z11, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        if ((i11 & 2) != 0) {
            function1 = null;
        }
        return e(file, z11, function1);
    }

    public static final boolean g(File file, File destFile, boolean z11, boolean z12) {
        Intrinsics.g(file, "<this>");
        Intrinsics.g(destFile, "destFile");
        boolean zP = FilesKt__UtilsKt.p(file, destFile, z11, null, 4, null);
        if (!z12) {
            FilesKt__UtilsKt.s(file);
        }
        return zP;
    }

    public static /* synthetic */ boolean h(File file, File file2, boolean z11, boolean z12, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = true;
        }
        if ((i11 & 4) != 0) {
            z12 = true;
        }
        return g(file, file2, z11, z12);
    }

    public static final void i(File file) {
        Intrinsics.g(file, "<this>");
        j.I(file);
    }

    public static final boolean j(File file, File newFile) {
        Intrinsics.g(file, "<this>");
        Intrinsics.g(newFile, "newFile");
        if (newFile.exists()) {
            return false;
        }
        return file.renameTo(newFile);
    }
}
