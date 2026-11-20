package pl.droidsonroids.relinker;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class a implements b.a {

    /* JADX INFO: renamed from: pl.droidsonroids.relinker.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0805a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ZipFile f73939a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ZipEntry f73940b;

        public C0805a(ZipFile zipFile, ZipEntry zipEntry) {
            this.f73939a = zipFile;
            this.f73940b = zipEntry;
        }
    }

    @Override // pl.droidsonroids.relinker.b.a
    public void a(Context context, String[] strArr, String str, File file, ReLinkerInstance reLinkerInstance) throws Throwable {
        String[] strArrE;
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        C0805a c0805a = null;
        Closeable closeable = null;
        try {
            C0805a c0805aD = d(context, strArr, str, reLinkerInstance);
            try {
                if (c0805aD == null) {
                    try {
                        strArrE = e(context, str);
                    } catch (Exception e11) {
                        strArrE = new String[]{e11.toString()};
                    }
                    throw new MissingLibraryException(str, strArr, strArrE);
                }
                int i11 = 0;
                while (true) {
                    int i12 = i11 + 1;
                    if (i11 >= 5) {
                        reLinkerInstance.h("FATAL! Couldn't extract the library from the APK!");
                        try {
                            ZipFile zipFile = c0805aD.f73939a;
                            if (zipFile != null) {
                                zipFile.close();
                                return;
                            }
                            return;
                        } catch (IOException unused) {
                            return;
                        }
                    }
                    reLinkerInstance.i("Found %s! Extracting...", str);
                    try {
                        if (file.exists() || file.createNewFile()) {
                            try {
                                inputStream = c0805aD.f73939a.getInputStream(c0805aD.f73940b);
                                try {
                                    fileOutputStream = new FileOutputStream(file);
                                    try {
                                        long jC = c(inputStream, fileOutputStream);
                                        fileOutputStream.getFD().sync();
                                        if (jC == file.length()) {
                                            b(inputStream);
                                            b(fileOutputStream);
                                            file.setReadable(true, false);
                                            file.setExecutable(true, false);
                                            file.setWritable(true);
                                            try {
                                                ZipFile zipFile2 = c0805aD.f73939a;
                                                if (zipFile2 != null) {
                                                    zipFile2.close();
                                                    return;
                                                }
                                                return;
                                            } catch (IOException unused2) {
                                                return;
                                            }
                                        }
                                        b(inputStream);
                                        b(fileOutputStream);
                                    } catch (FileNotFoundException unused3) {
                                        b(inputStream);
                                    } catch (IOException unused4) {
                                        b(inputStream);
                                    } catch (Throwable th2) {
                                        th = th2;
                                        closeable = inputStream;
                                        b(closeable);
                                        b(fileOutputStream);
                                        throw th;
                                    }
                                } catch (FileNotFoundException unused5) {
                                    fileOutputStream = null;
                                } catch (IOException unused6) {
                                    fileOutputStream = null;
                                } catch (Throwable th3) {
                                    th = th3;
                                    fileOutputStream = null;
                                }
                            } catch (FileNotFoundException unused7) {
                                inputStream = null;
                                fileOutputStream = null;
                            } catch (IOException unused8) {
                                inputStream = null;
                                fileOutputStream = null;
                            } catch (Throwable th4) {
                                th = th4;
                                fileOutputStream = null;
                            }
                        }
                    } catch (IOException unused9) {
                    }
                    i11 = i12;
                }
            } catch (Throwable th5) {
                th = th5;
                c0805a = c0805aD;
                if (c0805a != null) {
                    try {
                        ZipFile zipFile3 = c0805a.f73939a;
                        if (zipFile3 != null) {
                            zipFile3.close();
                        }
                    } catch (IOException unused10) {
                    }
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public final void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public final long c(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        long j11 = 0;
        while (true) {
            int i11 = inputStream.read(bArr);
            if (i11 == -1) {
                outputStream.flush();
                return j11;
            }
            outputStream.write(bArr, 0, i11);
            j11 += (long) i11;
        }
    }

    public final C0805a d(Context context, String[] strArr, String str, ReLinkerInstance reLinkerInstance) {
        String[] strArrF = f(context);
        int length = strArrF.length;
        char c11 = 0;
        int i11 = 0;
        while (true) {
            ZipFile zipFile = null;
            if (i11 >= length) {
                return null;
            }
            String str2 = strArrF[i11];
            int i12 = 0;
            while (true) {
                int i13 = i12 + 1;
                if (i12 >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str2), 1);
                    break;
                } catch (IOException unused) {
                    i12 = i13;
                }
            }
            if (zipFile != null) {
                int i14 = 0;
                while (true) {
                    int i15 = i14 + 1;
                    if (i14 >= 5) {
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException unused2) {
                            break;
                        }
                    }
                    int length2 = strArr.length;
                    int i16 = 0;
                    while (i16 < length2) {
                        String str3 = strArr[i16];
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("lib");
                        char c12 = File.separatorChar;
                        sb2.append(c12);
                        sb2.append(str3);
                        sb2.append(c12);
                        sb2.append(str);
                        String string = sb2.toString();
                        Object[] objArr = new Object[2];
                        objArr[c11] = string;
                        objArr[1] = str2;
                        reLinkerInstance.i("Looking for %s in APK %s...", objArr);
                        ZipEntry entry = zipFile.getEntry(string);
                        if (entry != null) {
                            return new C0805a(zipFile, entry);
                        }
                        i16++;
                        c11 = 0;
                    }
                    i14 = i15;
                    c11 = 0;
                }
            }
            i11++;
            c11 = 0;
        }
    }

    public final String[] e(Context context, String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("lib");
        char c11 = File.separatorChar;
        sb2.append(c11);
        sb2.append("([^\\");
        sb2.append(c11);
        sb2.append("]*)");
        sb2.append(c11);
        sb2.append(str);
        Pattern patternCompile = Pattern.compile(sb2.toString());
        HashSet hashSet = new HashSet();
        for (String str2 : f(context)) {
            try {
                Enumeration<? extends ZipEntry> enumerationEntries = new ZipFile(new File(str2), 1).entries();
                while (enumerationEntries.hasMoreElements()) {
                    Matcher matcher = patternCompile.matcher(enumerationEntries.nextElement().getName());
                    if (matcher.matches()) {
                        hashSet.add(matcher.group(1));
                    }
                }
            } catch (IOException unused) {
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    public final String[] f(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String[] strArr = applicationInfo.splitSourceDirs;
        if (strArr == null || strArr.length == 0) {
            return new String[]{applicationInfo.sourceDir};
        }
        String[] strArr2 = new String[strArr.length + 1];
        strArr2[0] = applicationInfo.sourceDir;
        System.arraycopy(strArr, 0, strArr2, 1, strArr.length);
        return strArr2;
    }
}
