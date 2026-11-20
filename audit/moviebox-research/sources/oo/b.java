package oo;

import android.annotation.SuppressLint;
import android.content.Context;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SuppressLint({"StaticFieldLeak"})
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static File f72500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static File f72501c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Context f72502d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f72499a = new b();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static AtomicBoolean f72503e = new AtomicBoolean(false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Comparator<File> f72504f = new Comparator() { // from class: oo.a
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return b.c((File) obj, (File) obj2);
        }
    };

    public static final int c(File file, File file2) {
        return (int) (file2.lastModified() - file.lastModified());
    }

    public final boolean b(File file) {
        if (file == null || file.exists()) {
            return true;
        }
        return file.mkdir();
    }

    public final File d(String str) {
        if (f72501c == null) {
            Context context = f72502d;
            f72501c = context == null ? null : context.getCacheDir();
        }
        return new File(f72501c, str);
    }

    public final File e(String str) {
        b(f72500b);
        return new File(f72500b, str);
    }

    public final synchronized File[] f() {
        File file = f72500b;
        if (file == null) {
            return null;
        }
        File[] fileArrListFiles = file != null ? file.listFiles() : null;
        if (fileArrListFiles != null) {
            Arrays.sort(fileArrListFiles, f72504f);
        }
        return fileArrListFiles;
    }

    public final void g(Context context) {
        if (context != null && f72503e.compareAndSet(false, true)) {
            f72502d = context;
            f72500b = new File(context.getFilesDir(), "strategy");
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0072  */
    /* JADX WARN: Code duplicated, block: B:34:0x0073 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x0075  */
    /* JADX WARN: Code duplicated, block: B:36:0x0076 A[Catch: all -> 0x004f, TryCatch #6 {, blocks: (B:3:0x0001, B:7:0x000a, B:9:0x0010, B:10:0x002c, B:11:0x0038, B:12:0x004b, B:31:0x006b, B:44:0x00bd, B:47:0x00c2, B:38:0x007c, B:39:0x00af, B:36:0x0076, B:25:0x005e, B:27:0x0063, B:30:0x0068), top: B:64:0x0001, inners: #0, #5 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x007c A[Catch: all -> 0x004f, TryCatch #6 {, blocks: (B:3:0x0001, B:7:0x000a, B:9:0x0010, B:10:0x002c, B:11:0x0038, B:12:0x004b, B:31:0x006b, B:44:0x00bd, B:47:0x00c2, B:38:0x007c, B:39:0x00af, B:36:0x0076, B:25:0x005e, B:27:0x0063, B:30:0x0068), top: B:64:0x0001, inners: #0, #5 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00af A[Catch: all -> 0x004f, TRY_LEAVE, TryCatch #6 {, blocks: (B:3:0x0001, B:7:0x000a, B:9:0x0010, B:10:0x002c, B:11:0x0038, B:12:0x004b, B:31:0x006b, B:44:0x00bd, B:47:0x00c2, B:38:0x007c, B:39:0x00af, B:36:0x0076, B:25:0x005e, B:27:0x0063, B:30:0x0068), top: B:64:0x0001, inners: #0, #5 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00b8 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:52:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:38:0x007c, please report this as an issue */
    public final synchronized void h(Serializable serializable, File toFile) {
        File fileD;
        boolean z11;
        long jCurrentTimeMillis;
        Intrinsics.g(toFile, "toFile");
        if (serializable == null) {
            return;
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        FileOutputStream fileOutputStream = null;
        boolean zRenameTo = false;
        try {
            String string = UUID.randomUUID().toString();
            Intrinsics.f(string, "randomUUID().toString()");
            fileD = d(l.F(string, "-", "", false, 4, null));
            try {
                fileD.createNewFile();
                z11 = true;
                fileD.setReadable(true);
                FileOutputStream fileOutputStream2 = new FileOutputStream(fileD);
                try {
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(fileOutputStream2));
                    objectOutputStream.writeObject(serializable);
                    objectOutputStream.flush();
                    objectOutputStream.close();
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e11) {
                        e = e11;
                        fileOutputStream = fileOutputStream2;
                        e.printStackTrace();
                        if (fileOutputStream == null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e12) {
                                e12.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Exception e13) {
                    e = e13;
                    fileOutputStream = fileOutputStream2;
                    z11 = false;
                    e.printStackTrace();
                    if (fileOutputStream == null) {
                        jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                        if (z11) {
                            if (fileD != null) {
                                zRenameTo = fileD.renameTo(toFile);
                            }
                            if (zRenameTo) {
                                po.b.f73956a.g("persist end. file = " + toFile.getAbsoluteFile() + ", size = " + toFile.length() + ", cost= " + Long.valueOf(jCurrentTimeMillis));
                            } else {
                                po.b.f73956a.c("rename failed.");
                            }
                        }
                        if (z11) {
                        }
                        fileD.delete();
                    }
                    fileOutputStream.close();
                    jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
                    if (z11) {
                        if (fileD != null) {
                            zRenameTo = fileD.renameTo(toFile);
                        }
                        if (zRenameTo) {
                            po.b.f73956a.g("persist end. file = " + toFile.getAbsoluteFile() + ", size = " + toFile.length() + ", cost= " + Long.valueOf(jCurrentTimeMillis));
                        } else {
                            po.b.f73956a.c("rename failed.");
                        }
                    }
                    if (z11) {
                    }
                    try {
                        fileD.delete();
                    } catch (Exception e14) {
                        po.b.f73956a.e(e14);
                    }
                    throw th;
                }
            } catch (Exception e15) {
                e = e15;
            }
        } catch (Exception e16) {
            e = e16;
            fileD = null;
        }
        jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis2;
        if (z11) {
            if (fileD != null) {
                zRenameTo = fileD.renameTo(toFile);
            }
            if (zRenameTo) {
                po.b.f73956a.g("persist end. file = " + toFile.getAbsoluteFile() + ", size = " + toFile.length() + ", cost= " + Long.valueOf(jCurrentTimeMillis));
            } else {
                po.b.f73956a.c("rename failed.");
            }
        }
        if ((z11 || !zRenameTo) && fileD != null) {
            fileD.delete();
        }
    }

    public final synchronized void i(Serializable serializable, String filename) {
        Intrinsics.g(serializable, "serializable");
        Intrinsics.g(filename, "filename");
        h(serializable, e(filename));
    }

    public final synchronized void j() {
        try {
            File[] fileArrF = f();
            if (fileArrF == null) {
                return;
            }
            int length = fileArrF.length;
            int i11 = 1;
            int i12 = 0;
            while (i12 < length) {
                File file = fileArrF[i12];
                i12++;
                if (!file.isDirectory()) {
                    if (System.currentTimeMillis() - file.lastModified() > 259200000) {
                        po.b.f73956a.c(Intrinsics.p("delete expired file: ", file.getAbsoluteFile()));
                        file.delete();
                    } else {
                        String name = file.getName();
                        Intrinsics.f(name, "file.name");
                        if (l.L(name, "WIFI", false, 2, null)) {
                            if (i11 > 10) {
                                po.b.f73956a.c("delete file: " + file.getAbsoluteFile() + " because max file num is 10");
                                file.delete();
                            }
                            i11++;
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            po.b.f73956a.e(th2);
        }
    }

    public final synchronized <T> T k(File file) {
        T t11;
        Intrinsics.g(file, "file");
        FileInputStream fileInputStream = null;
        T t12 = null;
        if (!file.exists()) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(fileInputStream2));
                t12 = (T) objectInputStream.readObject();
                objectInputStream.close();
                long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                po.b.f73956a.b("restore end. file = " + file.getAbsoluteFile() + ", size = " + file.length() + ", cost = " + jCurrentTimeMillis2);
                fileInputStream2.close();
            } catch (Throwable th2) {
                th = th2;
                T t13 = t12;
                fileInputStream = fileInputStream2;
                t11 = t13;
                th.printStackTrace();
                po.b.f73956a.c(Intrinsics.p("restore file fail. file = ", file.getAbsoluteFile()));
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e11) {
                        e11.printStackTrace();
                        t12 = t11;
                    }
                }
                t12 = t11;
            }
        } catch (Throwable th3) {
            th = th3;
            t11 = null;
        }
        return t12;
    }

    public final synchronized <T> T l(String filename) {
        Intrinsics.g(filename, "filename");
        return (T) k(e(filename));
    }
}
