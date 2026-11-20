package kotlin.io;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public class FilesKt__UtilsKt extends c {
    public static final boolean o(File file, File target, boolean z11, final Function2<? super File, ? super IOException, ? extends OnErrorAction> onError) {
        Intrinsics.g(file, "<this>");
        Intrinsics.g(target, "target");
        Intrinsics.g(onError, "onError");
        if (!file.exists()) {
            return onError.invoke(file, new NoSuchFileException(file, null, "The source file doesn't exist.", 2, null)) != OnErrorAction.TERMINATE;
        }
        try {
            for (File file2 : c.n(file).h(new Function2<File, IOException, Unit>() { // from class: kotlin.io.FilesKt__UtilsKt$copyRecursively$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(File file3, IOException iOException) throws TerminateException {
                    invoke2(file3, iOException);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(File f11, IOException e11) throws TerminateException {
                    Intrinsics.g(f11, "f");
                    Intrinsics.g(e11, "e");
                    if (onError.invoke(f11, e11) == OnErrorAction.TERMINATE) {
                        throw new TerminateException(f11);
                    }
                }
            })) {
                if (file2.exists()) {
                    File file3 = new File(target, x(file2, file));
                    if (file3.exists() && (!file2.isDirectory() || !file3.isDirectory())) {
                        if (z11) {
                            if (file3.isDirectory()) {
                                if (!s(file3)) {
                                }
                            } else if (!file3.delete()) {
                            }
                        }
                        if (onError.invoke(file3, new FileAlreadyExistsException(file2, file3, "The destination file already exists.")) == OnErrorAction.TERMINATE) {
                            return false;
                        }
                    }
                    if (file2.isDirectory()) {
                        file3.mkdirs();
                    } else if (r(file2, file3, z11, 0, 4, null).length() != file2.length() && onError.invoke(file2, new IOException("Source file wasn't copied completely, length of destination file differs.")) == OnErrorAction.TERMINATE) {
                        return false;
                    }
                } else if (onError.invoke(file2, new NoSuchFileException(file2, null, "The source file doesn't exist.", 2, null)) == OnErrorAction.TERMINATE) {
                    return false;
                }
            }
            return true;
        } catch (TerminateException unused) {
            return false;
        }
    }

    public static /* synthetic */ boolean p(File file, File file2, boolean z11, Function2 function2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        if ((i11 & 4) != 0) {
            function2 = new Function2() { // from class: kotlin.io.FilesKt__UtilsKt$copyRecursively$1
                @Override // kotlin.jvm.functions.Function2
                public final Void invoke(File file3, IOException exception) throws IOException {
                    Intrinsics.g(file3, "<anonymous parameter 0>");
                    Intrinsics.g(exception, "exception");
                    throw exception;
                }
            };
        }
        return o(file, file2, z11, function2);
    }

    public static final File q(File file, File target, boolean z11, int i11) throws FileSystemException {
        Intrinsics.g(file, "<this>");
        Intrinsics.g(target, "target");
        if (!file.exists()) {
            throw new NoSuchFileException(file, null, "The source file doesn't exist.", 2, null);
        }
        if (target.exists()) {
            if (!z11) {
                throw new FileAlreadyExistsException(file, target, "The destination file already exists.");
            }
            if (!target.delete()) {
                throw new FileAlreadyExistsException(file, target, "Tried to overwrite the destination, but failed to delete it.");
            }
        }
        if (!file.isDirectory()) {
            File parentFile = target.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(target);
                try {
                    ByteStreamsKt.a(fileInputStream, fileOutputStream, i11);
                    CloseableKt.a(fileOutputStream, null);
                    CloseableKt.a(fileInputStream, null);
                } catch (Throwable th2) {
                    try {
                        throw th2;
                    } catch (Throwable th3) {
                        CloseableKt.a(fileOutputStream, th2);
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                try {
                    throw th4;
                } catch (Throwable th5) {
                    CloseableKt.a(fileInputStream, th4);
                    throw th5;
                }
            }
        } else if (!target.mkdirs()) {
            throw new FileSystemException(file, target, "Failed to create target directory.");
        }
        return target;
    }

    public static /* synthetic */ File r(File file, File file2, boolean z11, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            z11 = false;
        }
        if ((i12 & 4) != 0) {
            i11 = 8192;
        }
        return q(file, file2, z11, i11);
    }

    public static boolean s(File file) {
        Intrinsics.g(file, "<this>");
        while (true) {
            boolean z11 = true;
            for (File file2 : c.m(file)) {
                if (file2.delete() || !file2.exists()) {
                    if (z11) {
                    }
                }
                z11 = false;
            }
            return z11;
        }
    }

    public static String t(File file) {
        Intrinsics.g(file, "<this>");
        String name = file.getName();
        Intrinsics.f(name, "getName(...)");
        return StringsKt__StringsKt.O0(name, '.', "");
    }

    public static String u(File file) {
        Intrinsics.g(file, "<this>");
        String name = file.getName();
        Intrinsics.f(name, "getName(...)");
        return StringsKt__StringsKt.X0(name, InstructionFileId.DOT, null, 2, null);
    }

    public static final List<File> v(List<? extends File> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (File file : list) {
            String name = file.getName();
            if (!Intrinsics.b(name, InstructionFileId.DOT)) {
                if (!Intrinsics.b(name, "..")) {
                    arrayList.add(file);
                } else if (arrayList.isEmpty() || Intrinsics.b(((File) CollectionsKt___CollectionsKt.q0(arrayList)).getName(), "..")) {
                    arrayList.add(file);
                } else {
                    arrayList.remove(arrayList.size() - 1);
                }
            }
        }
        return arrayList;
    }

    public static final FilePathComponents w(FilePathComponents filePathComponents) {
        return new FilePathComponents(filePathComponents.a(), v(filePathComponents.b()));
    }

    public static final String x(File file, File base) {
        Intrinsics.g(file, "<this>");
        Intrinsics.g(base, "base");
        String strY = y(file, base);
        if (strY != null) {
            return strY;
        }
        throw new IllegalArgumentException("this and base files have different roots: " + file + " and " + base + '.');
    }

    public static final String y(File file, File file2) {
        FilePathComponents filePathComponentsW = w(b.b(file));
        FilePathComponents filePathComponentsW2 = w(b.b(file2));
        if (!Intrinsics.b(filePathComponentsW.a(), filePathComponentsW2.a())) {
            return null;
        }
        int iC = filePathComponentsW2.c();
        int iC2 = filePathComponentsW.c();
        int iMin = Math.min(iC2, iC);
        int i11 = 0;
        while (i11 < iMin && Intrinsics.b(filePathComponentsW.b().get(i11), filePathComponentsW2.b().get(i11))) {
            i11++;
        }
        StringBuilder sb2 = new StringBuilder();
        int i12 = iC - 1;
        if (i11 <= i12) {
            while (!Intrinsics.b(filePathComponentsW2.b().get(i12).getName(), "..")) {
                sb2.append("..");
                if (i12 != i11) {
                    sb2.append(File.separatorChar);
                }
                if (i12 != i11) {
                    i12--;
                }
            }
            return null;
        }
        if (i11 < iC2) {
            if (i11 < iC) {
                sb2.append(File.separatorChar);
            }
            List listZ = CollectionsKt___CollectionsKt.Z(filePathComponentsW.b(), i11);
            String separator = File.separator;
            Intrinsics.f(separator, "separator");
            CollectionsKt___CollectionsKt.m0(listZ, sb2, separator, null, null, 0, null, null, 124, null);
        }
        return sb2.toString();
    }
}
