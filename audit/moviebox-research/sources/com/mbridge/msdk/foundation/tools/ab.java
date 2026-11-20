package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class ab extends k {
    public static String a(File file) {
        try {
            if (file.isFile()) {
                file.delete();
                return "";
            }
            if (!file.isDirectory()) {
                return "";
            }
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                for (File file2 : fileArrListFiles) {
                    a(file2);
                }
                file.delete();
                return "";
            }
            file.delete();
            return "";
        } catch (Exception e11) {
            return e11.getMessage();
        }
    }

    public static List<String> a(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                File file = new File(str + File.separator + "template_config.json");
                if (file.isFile() && file.exists()) {
                    String strB = b(file);
                    if (TextUtils.isEmpty(strB)) {
                        return arrayList;
                    }
                    try {
                        JSONArray jSONArray = new JSONArray(strB);
                        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i11);
                            if (jSONObject != null && str2.equals(jSONObject.optString("xml_type"))) {
                                arrayList.add(str + File.separator + jSONObject.optString("name"));
                                if (jSONObject.has("ext_template")) {
                                    jSONObject.put("folder_dir", str);
                                    arrayList.add(jSONObject.toString());
                                } else {
                                    continue;
                                }
                            }
                        }
                    } catch (JSONException e11) {
                        ad.b("SameFileTool", e11.getMessage());
                        return arrayList;
                    }
                    return arrayList;
                }
                arrayList.add(str);
            }
            return arrayList;
        } catch (Exception e12) {
            ad.b("SameFileTool", e12.getMessage());
        }
    }

    public static void a() {
        Runnable runnable = new Runnable() { // from class: com.mbridge.msdk.foundation.tools.ab.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    com.mbridge.msdk.c.g gVarB = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
                    if (gVarB == null) {
                        com.mbridge.msdk.c.h.a();
                        gVarB = com.mbridge.msdk.c.i.a();
                    }
                    ab.a(com.mbridge.msdk.foundation.same.b.e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_RES_MANAGER_DIR), gVarB.S());
                    ab.a(System.currentTimeMillis() - ((long) (gVarB.i() * 1000)));
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        e11.printStackTrace();
                    }
                }
            }
        };
        com.mbridge.msdk.foundation.controller.d.a();
        com.mbridge.msdk.foundation.same.f.b.b().execute(runnable);
    }

    public static void a(long j11) {
        try {
            for (File file : c(new File(com.mbridge.msdk.foundation.same.b.e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_RES_MANAGER_DIR)))) {
                if (file.lastModified() < j11 && file.exists() && file.isFile()) {
                    file.delete();
                }
            }
        } catch (Throwable th2) {
            ad.a("SameFileTool", th2.getMessage(), th2);
        }
    }

    public static void a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.mbridge.msdk.c.g gVarB = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
            if (gVarB == null) {
                com.mbridge.msdk.c.h.a();
                gVarB = com.mbridge.msdk.c.i.a();
            }
            long jCurrentTimeMillis = System.currentTimeMillis() - ((long) (gVarB.i() * 1000));
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles != null) {
                    for (File file2 : fileArrListFiles) {
                        if (file2.lastModified() + jCurrentTimeMillis < jCurrentTimeMillis2) {
                            a(file2);
                            try {
                                File file3 = new File(str + ".zip");
                                if (file3.exists() && file3.isFile()) {
                                    a(file3);
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
        } catch (Exception unused2) {
        }
    }

    public static /* synthetic */ void a(String str, int i11) {
        try {
            if (e(new File(str)) > i11 * 1048576) {
                e(str);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        } catch (Throwable unused) {
            ad.b("SameFileTool", "clean memory failed");
        }
    }

    public static boolean a(byte[] bArr, File file) throws Throwable {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                if (file.getParentFile() != null && !file.exists()) {
                    file.getParentFile().mkdirs();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(bArr);
                    try {
                        fileOutputStream2.close();
                        return true;
                    } catch (IOException e11) {
                        e11.printStackTrace();
                        return true;
                    }
                } catch (Exception e12) {
                    e = e12;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    if (fileOutputStream == null) {
                        return false;
                    }
                    try {
                        fileOutputStream.close();
                        return false;
                    } catch (IOException e13) {
                        e13.printStackTrace();
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e14) {
                            e14.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e15) {
            e = e15;
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0049  */
    /* JADX WARN: Code duplicated, block: B:30:0x004e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:39:0x0051 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static String b(File file) throws Throwable {
        StringBuffer stringBuffer;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        if (file == null) {
            return null;
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            try {
                try {
                    stringBuffer = new StringBuffer();
                    while (true) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            stringBuffer.append(line + "\n");
                        } catch (IOException e11) {
                            e = e11;
                            e.printStackTrace();
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException unused) {
                                }
                            }
                            if (stringBuffer != null) {
                                return stringBuffer.toString();
                            }
                            return null;
                        }
                    }
                } catch (IOException e12) {
                    e = e12;
                    stringBuffer = null;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (IOException e13) {
            e = e13;
            stringBuffer = null;
            bufferedReader = null;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            throw th;
        }
        bufferedReader.close();
        if (stringBuffer != null) {
            return stringBuffer.toString();
        }
        return null;
    }

    public static String b(String str, String str2) throws Throwable {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        if (str == null || str2 == null) {
            return "unzip srcFile or destDir is null ";
        }
        if (!str2.endsWith("/")) {
            str2 = str2 + "/";
        }
        File file = new File(str);
        if (!file.exists()) {
            return "unzip file not exists";
        }
        InputStream inputStream = null;
        try {
            try {
                ZipFile zipFile = new ZipFile(file);
                Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
                fileOutputStream2 = null;
                while (true) {
                    try {
                        String canonicalPath = "";
                        if (!enumerationEntries.hasMoreElements()) {
                            zipFile.close();
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e11) {
                                    e11.printStackTrace();
                                }
                            }
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException e12) {
                                    e12.printStackTrace();
                                }
                            }
                            return "";
                        }
                        ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                        if (zipEntryNextElement == null) {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e13) {
                                    e13.printStackTrace();
                                }
                            }
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException e14) {
                                    e14.printStackTrace();
                                }
                            }
                            return "unzip zipEntry is null";
                        }
                        String name = zipEntryNextElement.getName();
                        if (!TextUtils.isEmpty(name) && !name.startsWith("..") && !name.startsWith("../")) {
                            File file2 = new File(str2 + name);
                            try {
                                canonicalPath = file2.getCanonicalPath();
                            } catch (IOException unused) {
                            }
                            if (!TextUtils.isEmpty(canonicalPath) && canonicalPath.startsWith(str2) && !canonicalPath.startsWith("..") && !canonicalPath.startsWith("../")) {
                                if (zipEntryNextElement.isDirectory()) {
                                    file2.mkdirs();
                                } else {
                                    if (!file2.getParentFile().exists()) {
                                        file2.getParentFile().mkdirs();
                                    }
                                    FileOutputStream fileOutputStream3 = new FileOutputStream(file2);
                                    try {
                                        inputStream = zipFile.getInputStream(zipEntryNextElement);
                                        byte[] bArr = new byte[1024];
                                        while (true) {
                                            int i11 = inputStream.read(bArr, 0, 1024);
                                            if (i11 == -1) {
                                                break;
                                            }
                                            fileOutputStream3.write(bArr, 0, i11);
                                            fileOutputStream3.flush();
                                        }
                                        fileOutputStream2 = fileOutputStream3;
                                    } catch (IOException e15) {
                                        e = e15;
                                        fileOutputStream2 = fileOutputStream3;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        fileOutputStream = fileOutputStream3;
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException e16) {
                                                e16.printStackTrace();
                                            }
                                        }
                                        if (fileOutputStream == null) {
                                            throw th;
                                        }
                                        try {
                                            fileOutputStream.close();
                                            throw th;
                                        } catch (IOException e17) {
                                            e17.printStackTrace();
                                            throw th;
                                        }
                                    }
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e18) {
                                    e18.printStackTrace();
                                }
                            }
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException e19) {
                                    e19.printStackTrace();
                                }
                            }
                            return "unzip zipEntry canonicalPath is not available";
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e21) {
                                e21.printStackTrace();
                            }
                        }
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException e22) {
                                e22.printStackTrace();
                            }
                        }
                        return "unzip zipEntry name is not available";
                    } catch (IOException e23) {
                        e = e23;
                    }
                    if (MBridgeConstans.DEBUG) {
                        e.printStackTrace();
                    }
                    String message = e.getMessage();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e24) {
                            e24.printStackTrace();
                        }
                    }
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e25) {
                            e25.printStackTrace();
                        }
                    }
                    return message;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException e26) {
            e = e26;
            fileOutputStream2 = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }

    public static void b() {
        new Thread(new Runnable() { // from class: com.mbridge.msdk.foundation.tools.ab.2
            /* JADX WARN: Code duplicated, block: B:25:0x0049  */
            /* JADX WARN: Code duplicated, block: B:38:? A[RETURN, SYNTHETIC] */
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                        String strA = com.mbridge.msdk.foundation.same.b.e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_VC);
                        try {
                            File file = new File(strA);
                            if (file.exists() && file.isDirectory()) {
                                for (File file2 : ab.b(strA)) {
                                    if (file2.exists() && file2.isFile()) {
                                        file2.delete();
                                    }
                                }
                                return;
                            }
                            return;
                        } catch (Exception e11) {
                            e11.printStackTrace();
                            return;
                        }
                        if (MBridgeConstans.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e12) {
                    if (MBridgeConstans.DEBUG) {
                        e12.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public static File[] b(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return file.listFiles();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String c(String str) {
        return !TextUtils.isEmpty(str) ? SameMD5.getMD5(ao.b(str.trim())) : "";
    }

    private static ArrayList<File> c(File file) {
        ArrayList<File> arrayList = new ArrayList<>();
        for (File file2 : file.listFiles(new FileFilter() { // from class: com.mbridge.msdk.foundation.tools.ab.3
            @Override // java.io.FileFilter
            public final boolean accept(File file3) {
                return !file3.isHidden() || file3.isDirectory();
            }
        })) {
            if (file2.isDirectory()) {
                arrayList.addAll(c(file2));
            } else {
                arrayList.add(file2);
            }
        }
        return arrayList;
    }

    private static long d(File file) throws Exception {
        long jAvailable = 0;
        FileInputStream fileInputStream = null;
        try {
            try {
                try {
                    if (file.exists()) {
                        FileInputStream fileInputStream2 = new FileInputStream(file);
                        try {
                            jAvailable = fileInputStream2.available();
                            fileInputStream = fileInputStream2;
                        } catch (Exception e11) {
                            e = e11;
                            fileInputStream = fileInputStream2;
                            e.printStackTrace();
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            return jAvailable;
                        } catch (Throwable th2) {
                            th = th2;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e12) {
                                    e12.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } else {
                        file.createNewFile();
                        ad.b("获取文件大小", "文件不存在!");
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                } catch (Exception e13) {
                    e13.printStackTrace();
                }
            } catch (Exception e14) {
                e = e14;
            }
            return jAvailable;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static boolean d(String str) {
        if (com.mbridge.msdk.foundation.same.c.f.a(str)) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.isFile();
    }

    private static long e(File file) throws Exception {
        File[] fileArrListFiles = file.listFiles();
        long jE = 0;
        if (fileArrListFiles != null) {
            for (int i11 = 0; i11 < fileArrListFiles.length; i11++) {
                jE += fileArrListFiles[i11].isDirectory() ? e(fileArrListFiles[i11]) : d(fileArrListFiles[i11]);
            }
        }
        return jE;
    }

    private static void e(String str) {
        try {
            ArrayList<File> arrayListC = c(new File(str));
            Collections.sort(arrayListC, new Comparator<File>() { // from class: com.mbridge.msdk.foundation.tools.ab.4
                @Override // java.util.Comparator
                public final /* synthetic */ int compare(File file, File file2) {
                    long jLastModified = file.lastModified() - file2.lastModified();
                    if (jLastModified > 0) {
                        return 1;
                    }
                    return jLastModified == 0 ? 0 : -1;
                }

                @Override // java.util.Comparator
                public final boolean equals(Object obj) {
                    return true;
                }
            });
            int size = (arrayListC.size() - 1) / 2;
            for (int i11 = 0; i11 < size; i11++) {
                File file = arrayListC.get(i11);
                if (file.exists() && file.isFile()) {
                    file.delete();
                }
            }
        } catch (Exception unused) {
            ad.b("SameFileTool", "del memory failed");
        }
    }
}
