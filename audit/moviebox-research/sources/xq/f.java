package xq;

import java.io.File;
import java.util.HashSet;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f80673a = new f();

    public final void a(String directoryPath) {
        Intrinsics.g(directoryPath, "directoryPath");
        File file = new File(directoryPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        com.transsion.ad.a.b(com.transsion.ad.a.f50276a, f.class.getSimpleName() + " --> createDirectoryIfNotExists() --> 目标文件夹 创建成功 --> directoryPath = " + directoryPath, false, 2, null);
    }

    public final void b(File file, HashSet<String> set) {
        File[] fileArrListFiles;
        Intrinsics.g(file, "file");
        Intrinsics.g(set, "set");
        if (!file.isDirectory() || (fileArrListFiles = file.listFiles()) == null) {
            return;
        }
        if (!(fileArrListFiles.length == 0)) {
            for (File it : fileArrListFiles) {
                if (it.isDirectory()) {
                    f fVar = f80673a;
                    Intrinsics.f(it, "it");
                    fVar.b(it, set);
                } else if (it.isFile() && !set.contains(it.getPath())) {
                    it.delete();
                }
            }
        }
    }

    public final boolean c(String filePath) {
        Intrinsics.g(filePath, "filePath");
        return new File(filePath).exists();
    }
}
