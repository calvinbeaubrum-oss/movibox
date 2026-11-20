package com.vungle.warren.utility;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f62598a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f62599b = i.class.getSimpleName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<Class<?>> f62600c = Arrays.asList(LinkedHashSet.class, HashSet.class, HashMap.class, ArrayList.class, File.class);

    /* JADX INFO: compiled from: source.java */
    public class a implements b {
        @Override // com.vungle.warren.utility.i.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public q a(InputStream inputStream) throws IOException {
            return new q(inputStream, i.f62600c);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        ObjectInputStream a(InputStream inputStream) throws IOException, ClassNotFoundException;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void b(File file) throws IOException {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                return;
            }
            for (File file2 : fileArrListFiles) {
                b(file2);
            }
        }
        if (file.delete()) {
            return;
        }
        throw new FileNotFoundException("Failed to delete file: " + file);
    }

    public static void c(File file) {
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                Files.delete(file.toPath());
            } else if (!file.delete()) {
                Log.w(f62599b, "Cannot delete " + file.getName());
            }
        } catch (IOException e11) {
            Log.w(f62599b, "Cannot delete " + file.getName() + e11.getLocalizedMessage());
        }
    }

    public static boolean d(String str) {
        if (str != null) {
            return str.endsWith(".mp4");
        }
        return false;
    }

    public static void e(File file) {
    }

    @NonNull
    public static HashMap<String, String> f(@NonNull String str) throws Throwable {
        Object objG = g(new File(str));
        return objG instanceof HashMap ? (HashMap) objG : new HashMap<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x001f: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:11:0x001f */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.io.Closeable, java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r2v11, types: [com.vungle.warren.utility.i$b] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Nullable
    public static <T> T g(File file) throws Throwable {
        Closeable closeable;
        ObjectInputStream objectInputStreamA;
        ?? r11;
        ?? Exists = file.exists();
        Closeable closeable2 = null;
        try {
            if (Exists == 0) {
                return null;
            }
            try {
                Exists = new FileInputStream(file);
                try {
                    objectInputStreamA = f62598a.a(Exists);
                    try {
                        T t11 = (T) objectInputStreamA.readObject();
                        a(objectInputStreamA);
                        a(Exists);
                        return t11;
                    } catch (IOException e11) {
                        e = e11;
                        Log.e(f62599b, "IOIOException", e);
                        r11 = Exists;
                        a(objectInputStreamA);
                        a(r11);
                        try {
                            b(file);
                        } catch (IOException unused) {
                        }
                        return null;
                    } catch (ClassNotFoundException e12) {
                        e = e12;
                        Log.e(f62599b, "ClassNotFoundException", e);
                        r11 = Exists;
                        a(objectInputStreamA);
                        a(r11);
                        b(file);
                        return null;
                    } catch (Exception e13) {
                        e = e13;
                        Log.e(f62599b, "cannot read serializable", e);
                        r11 = Exists;
                        a(objectInputStreamA);
                        a(r11);
                        b(file);
                        return null;
                    }
                } catch (IOException e14) {
                    e = e14;
                    objectInputStreamA = null;
                } catch (ClassNotFoundException e15) {
                    e = e15;
                    objectInputStreamA = null;
                } catch (Exception e16) {
                    e = e16;
                    objectInputStreamA = null;
                } catch (Throwable th2) {
                    th = th2;
                    a(closeable2);
                    a(Exists);
                    throw th;
                }
            } catch (IOException e17) {
                e = e17;
                Exists = 0;
                objectInputStreamA = null;
            } catch (ClassNotFoundException e18) {
                e = e18;
                Exists = 0;
                objectInputStreamA = null;
            } catch (Exception e19) {
                e = e19;
                Exists = 0;
                objectInputStreamA = null;
            } catch (Throwable th3) {
                th = th3;
                Exists = 0;
            }
        } catch (Throwable th4) {
            th = th4;
            closeable2 = closeable;
        }
    }

    public static long h(@Nullable File file) {
        long jH = 0;
        if (file == null || !file.exists()) {
            return 0L;
        }
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                jH += h(file2);
            }
        }
        return jH;
    }

    public static void i(@NonNull String str, @NonNull HashMap<String, String> map) throws Throwable {
        File file = new File(str);
        if (map.isEmpty()) {
            return;
        }
        j(file, map);
    }

    public static void j(@NonNull File file, @Nullable Serializable serializable) throws Throwable {
        FileOutputStream fileOutputStream;
        if (file.exists()) {
            c(file);
        }
        if (serializable == null) {
            return;
        }
        ObjectOutputStream objectOutputStream = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(fileOutputStream);
                    try {
                        objectOutputStream2.writeObject(serializable);
                        objectOutputStream2.reset();
                        a(objectOutputStream2);
                    } catch (IOException e11) {
                        e = e11;
                        objectOutputStream = objectOutputStream2;
                        Log.e(f62599b, "IOIOException", e);
                        a(objectOutputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        objectOutputStream = objectOutputStream2;
                        a(objectOutputStream);
                        a(fileOutputStream);
                        throw th;
                    }
                } catch (IOException e12) {
                    e = e12;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException e13) {
            e = e13;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
        a(fileOutputStream);
    }
}
