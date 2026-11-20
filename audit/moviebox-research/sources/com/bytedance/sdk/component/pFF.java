package com.bytedance.sdk.component;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import androidx.annotation.RequiresApi;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF {
    private static sc Ql = null;
    private static ArrayMap<File, pFF> Tf = null;
    private static ArrayMap<String, File> UFX = null;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static boolean f26918sc = false;
    private volatile boolean ExN;
    private final File Ol;
    private long Qj;
    private int TRI;
    private final File WH;
    private Properties We;
    private final Object pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private long f26919qr;
    private final Object zY;

    /* JADX INFO: renamed from: com.bytedance.sdk.component.pFF$pFF, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0260pFF {
        boolean ExN;
        volatile boolean We;
        final Properties pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        final long f26923sc;
        final CountDownLatch zY;

        private C0260pFF(long j11, Properties properties) {
            this.zY = new CountDownLatch(1);
            this.We = false;
            this.ExN = false;
            this.f26923sc = j11;
            this.pFF = properties;
        }

        public void sc(boolean z11, boolean z12) {
            this.ExN = z11;
            this.We = z12;
            this.zY.countDown();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface sc {
        ExecutorService getExecutorService();
    }

    /* JADX INFO: compiled from: source.java */
    public class zY implements SharedPreferences.Editor {
        private final Object pFF = new Object();
        private final Map<String, Object> zY = new HashMap();
        private boolean We = false;

        public zY() {
        }

        private C0260pFF pFF() {
            Properties properties;
            long j11;
            Object obj;
            boolean z11;
            synchronized (pFF.this.pFF) {
                try {
                    if (pFF.this.TRI > 0) {
                        Properties properties2 = new Properties();
                        properties2.putAll(pFF.this.We);
                        pFF.this.We = properties2;
                    }
                    properties = pFF.this.We;
                    pFF.ExN(pFF.this);
                    synchronized (this.pFF) {
                        try {
                            boolean z12 = false;
                            if (this.We) {
                                if (properties.isEmpty()) {
                                    z11 = false;
                                } else {
                                    properties.clear();
                                    z11 = true;
                                }
                                this.We = false;
                                z12 = z11;
                            }
                            for (Map.Entry<String, Object> entry : this.zY.entrySet()) {
                                String key = entry.getKey();
                                Object value = entry.getValue();
                                if (value == this || value == null) {
                                    if (properties.containsKey(key)) {
                                        properties.remove(key);
                                        z12 = true;
                                    }
                                } else if (!properties.containsKey(key) || (obj = properties.get(key)) == null || !obj.equals(String.valueOf(value))) {
                                    properties.put(key, String.valueOf(value));
                                    z12 = true;
                                }
                            }
                            this.zY.clear();
                            if (z12) {
                                pFF.TRI(pFF.this);
                            }
                            j11 = pFF.this.f26919qr;
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
            return new C0260pFF(j11, properties);
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            pFF.this.sc(pFF(), false);
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            long jCurrentTimeMillis = pFF.f26918sc ? System.currentTimeMillis() : 0L;
            C0260pFF c0260pFFPFF = pFF();
            pFF.this.sc(c0260pFFPFF, true);
            try {
                c0260pFFPFF.zY.await();
                return c0260pFFPFF.We;
            } catch (InterruptedException unused) {
            } finally {
                if (pFF.f26918sc) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(pFF.this.Ol.getName());
                    sb2.append(":");
                    sb2.append(c0260pFFPFF.f26923sc);
                    sb2.append(" committed after ");
                    sb2.append(System.currentTimeMillis() - jCurrentTimeMillis);
                    sb2.append(" ms");
                }
            }
        }

        @Override // android.content.SharedPreferences.Editor
        public /* synthetic */ SharedPreferences.Editor putStringSet(String str, Set set) {
            return sc(str, (Set<String>) set);
        }

        @Override // android.content.SharedPreferences.Editor
        /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
        public zY clear() {
            synchronized (this.pFF) {
                this.We = true;
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
        public zY remove(String str) {
            synchronized (this.pFF) {
                this.zY.put(str, this);
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
        public zY putFloat(String str, float f11) {
            synchronized (this.pFF) {
                this.zY.put(str, Float.valueOf(f11));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
        public zY putInt(String str, int i11) {
            synchronized (this.pFF) {
                this.zY.put(str, Integer.valueOf(i11));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
        public zY putLong(String str, long j11) {
            synchronized (this.pFF) {
                this.zY.put(str, Long.valueOf(j11));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
        public zY putString(String str, String str2) {
            synchronized (this.pFF) {
                this.zY.put(str, str2);
            }
            return this;
        }

        public zY sc(String str, Set<String> set) {
            synchronized (this.pFF) {
                this.zY.put(str, set == null ? null : new HashSet(set));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
        public zY putBoolean(String str, boolean z11) {
            synchronized (this.pFF) {
                this.zY.put(str, Boolean.valueOf(z11));
            }
            return this;
        }
    }

    private pFF(File file) {
        Object obj = new Object();
        this.pFF = obj;
        this.zY = new Object();
        this.We = new Properties();
        this.ExN = false;
        this.TRI = 0;
        this.Ol = file;
        this.WH = sc(file);
        synchronized (obj) {
            this.ExN = false;
        }
        sc scVar = Ql;
        if (scVar == null || scVar.getExecutorService() == null) {
            new Thread("TTPropHelper") { // from class: com.bytedance.sdk.component.pFF.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    pFF.this.sc();
                }
            }.start();
        } else {
            Ql.getExecutorService().execute(new Runnable() { // from class: com.bytedance.sdk.component.pFF.2
                @Override // java.lang.Runnable
                public void run() {
                    pFF.this.sc();
                }
            });
        }
    }

    public static /* synthetic */ int ExN(pFF pff) {
        int i11 = pff.TRI;
        pff.TRI = i11 + 1;
        return i11;
    }

    public static /* synthetic */ int Ol(pFF pff) {
        int i11 = pff.TRI;
        pff.TRI = i11 - 1;
        return i11;
    }

    public static /* synthetic */ long TRI(pFF pff) {
        long j11 = pff.f26919qr;
        pff.f26919qr = 1 + j11;
        return j11;
    }

    private void We() {
        while (!this.ExN) {
            try {
                this.pFF.wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:117:0x0103 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:80:0x0117 A[Catch: all -> 0x011c, TryCatch #9 {all -> 0x011c, blocks: (B:38:0x008f, B:39:0x0091, B:78:0x0113, B:80:0x0117, B:84:0x0120, B:86:0x0129, B:88:0x0131, B:90:0x013d, B:99:0x0180, B:100:0x0181, B:58:0x00dd, B:77:0x0112, B:62:0x00e3, B:76:0x0109, B:98:0x017f, B:97:0x0176), top: B:123:0x008f, inners: #1, #10 }] */
    /* JADX WARN: Code duplicated, block: B:83:0x011e  */
    /* JADX WARN: Code duplicated, block: B:86:0x0129 A[Catch: all -> 0x011c, TryCatch #9 {all -> 0x011c, blocks: (B:38:0x008f, B:39:0x0091, B:78:0x0113, B:80:0x0117, B:84:0x0120, B:86:0x0129, B:88:0x0131, B:90:0x013d, B:99:0x0180, B:100:0x0181, B:58:0x00dd, B:77:0x0112, B:62:0x00e3, B:76:0x0109, B:98:0x017f, B:97:0x0176), top: B:123:0x008f, inners: #1, #10 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x012f  */
    /* JADX WARN: Code duplicated, block: B:90:0x013d A[Catch: all -> 0x011c, TRY_LEAVE, TryCatch #9 {all -> 0x011c, blocks: (B:38:0x008f, B:39:0x0091, B:78:0x0113, B:80:0x0117, B:84:0x0120, B:86:0x0129, B:88:0x0131, B:90:0x013d, B:99:0x0180, B:100:0x0181, B:58:0x00dd, B:77:0x0112, B:62:0x00e3, B:76:0x0109, B:98:0x017f, B:97:0x0176), top: B:123:0x008f, inners: #1, #10 }] */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003f, code lost:
    
        if (r0 == false) goto L23;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r11v32 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void pFF(C0260pFF c0260pFF, boolean z11) {
        long jCurrentTimeMillis;
        long jCurrentTimeMillis2;
        Throwable th2;
        long jCurrentTimeMillis3;
        ?? r11;
        FileOutputStream fileOutputStream;
        long jCurrentTimeMillis4;
        long jCurrentTimeMillis5;
        long jCurrentTimeMillis6 = f26918sc ? System.currentTimeMillis() : 0L;
        boolean zExists = this.Ol.exists();
        if (f26918sc) {
            jCurrentTimeMillis = System.currentTimeMillis();
            jCurrentTimeMillis2 = jCurrentTimeMillis;
        } else {
            jCurrentTimeMillis = 0;
            jCurrentTimeMillis2 = 0;
        }
        if (zExists) {
            if (this.Qj < c0260pFF.f26923sc) {
                if (!z11) {
                    synchronized (this.pFF) {
                        boolean z12 = this.f26919qr == c0260pFF.f26923sc;
                    }
                }
                boolean zExists2 = this.WH.exists();
                if (f26918sc) {
                    jCurrentTimeMillis2 = System.currentTimeMillis();
                }
                if (zExists2) {
                    this.Ol.delete();
                } else if (!this.Ol.renameTo(this.WH)) {
                    Log.e("TTPropHelper", "Couldn't rename file " + this.Ol + " to backup file " + this.WH);
                    c0260pFF.sc(false, false);
                    return;
                }
            }
            c0260pFF.sc(false, true);
            return;
        }
        try {
            synchronized (this.zY) {
                Object obj = null;
                String str = null;
                FileOutputStream fileOutputStream2 = null;
                try {
                    try {
                        FileOutputStream fileOutputStream3 = new FileOutputStream(this.Ol);
                        try {
                            try {
                                jCurrentTimeMillis3 = f26918sc ? System.currentTimeMillis() : 0L;
                                try {
                                    c0260pFF.pFF.store(fileOutputStream3, (String) null);
                                    if (f26918sc) {
                                        new StringBuilder("save: ").append(c0260pFF.pFF);
                                        StringBuilder sb2 = new StringBuilder("saveToLocal: save to");
                                        sb2.append(this.Ol.getAbsolutePath());
                                        sb2.append("success");
                                        str = "success";
                                    }
                                    try {
                                        fileOutputStream3.close();
                                        obj = str;
                                    } catch (Throwable th3) {
                                        String message = th3.getMessage();
                                        Log.w("TTPropHelper", message);
                                        obj = message;
                                    }
                                } catch (Exception e11) {
                                    e = e11;
                                    fileOutputStream = fileOutputStream3;
                                    Log.e("TTPropHelper", "saveToLocal: ", e);
                                    c0260pFF.sc(false, false);
                                    obj = fileOutputStream;
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                            obj = fileOutputStream;
                                        } catch (Throwable th4) {
                                            Log.w("TTPropHelper", th4.getMessage());
                                            obj = fileOutputStream;
                                        }
                                    }
                                }
                            } catch (Throwable th5) {
                                th2 = th5;
                                r11 = fileOutputStream3;
                                if (r11 == 0) {
                                    throw th2;
                                }
                                try {
                                    r11.close();
                                    throw th2;
                                } catch (Throwable th6) {
                                    Log.w("TTPropHelper", th6.getMessage());
                                    throw th2;
                                }
                            }
                        } catch (Exception e12) {
                            e = e12;
                            fileOutputStream2 = fileOutputStream3;
                            jCurrentTimeMillis3 = 0;
                            fileOutputStream = fileOutputStream2;
                            Log.e("TTPropHelper", "saveToLocal: ", e);
                            c0260pFF.sc(false, false);
                            obj = fileOutputStream;
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                                obj = fileOutputStream;
                            }
                            if (f26918sc) {
                                jCurrentTimeMillis4 = System.currentTimeMillis();
                            } else {
                                jCurrentTimeMillis4 = 0;
                            }
                            this.WH.delete();
                            if (f26918sc) {
                                jCurrentTimeMillis5 = System.currentTimeMillis();
                            } else {
                                jCurrentTimeMillis5 = 0;
                            }
                            this.Qj = c0260pFF.f26923sc;
                            c0260pFF.sc(true, true);
                            if (f26918sc) {
                                StringBuilder sb3 = new StringBuilder("write: ");
                                sb3.append(jCurrentTimeMillis - jCurrentTimeMillis6);
                                sb3.append("/");
                                sb3.append(jCurrentTimeMillis2 - jCurrentTimeMillis6);
                                sb3.append("/");
                                sb3.append(jCurrentTimeMillis3 - jCurrentTimeMillis6);
                                sb3.append("/");
                                sb3.append(jCurrentTimeMillis4 - jCurrentTimeMillis6);
                                sb3.append("/");
                                sb3.append(jCurrentTimeMillis5 - jCurrentTimeMillis6);
                            }
                        }
                    } catch (Throwable th7) {
                        th2 = th7;
                        r11 = obj;
                    }
                } catch (Exception e13) {
                    e = e13;
                }
            }
            if (f26918sc) {
                jCurrentTimeMillis4 = System.currentTimeMillis();
            } else {
                jCurrentTimeMillis4 = 0;
            }
            this.WH.delete();
            if (f26918sc) {
                jCurrentTimeMillis5 = System.currentTimeMillis();
            } else {
                jCurrentTimeMillis5 = 0;
            }
            this.Qj = c0260pFF.f26923sc;
            c0260pFF.sc(true, true);
            if (f26918sc) {
                StringBuilder sb4 = new StringBuilder("write: ");
                sb4.append(jCurrentTimeMillis - jCurrentTimeMillis6);
                sb4.append("/");
                sb4.append(jCurrentTimeMillis2 - jCurrentTimeMillis6);
                sb4.append("/");
                sb4.append(jCurrentTimeMillis3 - jCurrentTimeMillis6);
                sb4.append("/");
                sb4.append(jCurrentTimeMillis4 - jCurrentTimeMillis6);
                sb4.append("/");
                sb4.append(jCurrentTimeMillis5 - jCurrentTimeMillis6);
            }
        } catch (Throwable th8) {
            Log.w("TTPropHelper", "writeToFile: Got exception:", th8);
            if (this.Ol.exists() && !this.Ol.delete()) {
                Log.e("TTPropHelper", "Couldn't clean up partially-written file " + this.Ol);
            }
            c0260pFF.sc(false, false);
        }
    }

    @RequiresApi(api = 19)
    public static pFF sc(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "tt_prop";
        }
        synchronized (pFF.class) {
            try {
                if (UFX == null) {
                    UFX = new ArrayMap<>();
                }
                File file = UFX.get(str);
                if (file == null) {
                    file = new File(context.getFilesDir(), str);
                    UFX.put(str, file);
                }
                if (Tf == null) {
                    Tf = new ArrayMap<>();
                }
                pFF pff = Tf.get(file);
                if (pff != null) {
                    return pff;
                }
                pFF pff2 = new pFF(file);
                Tf.put(file, pff2);
                return pff2;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static File sc(File file) {
        return new File(file.getPath() + ".bak");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(final C0260pFF c0260pFF, final boolean z11) {
        boolean z12;
        Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.component.pFF.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (pFF.this.zY) {
                    try {
                        pFF.this.pFF(c0260pFF, z11);
                    } catch (OutOfMemoryError unused) {
                    }
                }
                synchronized (pFF.this.pFF) {
                    pFF.Ol(pFF.this);
                }
            }
        };
        if (z11) {
            synchronized (this.pFF) {
                z12 = this.TRI == 1;
            }
            if (z12) {
                runnable.run();
                return;
            }
        }
        com.bytedance.sdk.component.zY.sc(runnable, true ^ z11);
    }

    public static void sc(sc scVar) {
        Ql = scVar;
    }

    public zY pFF() {
        return new zY();
    }

    public float sc(String str, float f11) {
        float f12;
        if (TextUtils.isEmpty(str)) {
            return f11;
        }
        synchronized (this.pFF) {
            try {
                try {
                    We();
                    f12 = Float.parseFloat(this.We.getProperty(str, String.valueOf(f11)));
                } catch (NumberFormatException e11) {
                    Log.e("TTPropHelper", e11.getMessage());
                    return f11;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return f12;
    }

    public int sc(String str, int i11) {
        int i12;
        if (TextUtils.isEmpty(str)) {
            return i11;
        }
        synchronized (this.pFF) {
            try {
                try {
                    We();
                    i12 = Integer.parseInt(this.We.getProperty(str, String.valueOf(i11)));
                } catch (NumberFormatException e11) {
                    Log.e("TTPropHelper", e11.getMessage());
                    return i11;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return i12;
    }

    public long sc(String str, long j11) {
        long j12;
        if (TextUtils.isEmpty(str)) {
            return j11;
        }
        synchronized (this.pFF) {
            try {
                try {
                    We();
                    j12 = Long.parseLong(this.We.getProperty(str, String.valueOf(j11)));
                } catch (NumberFormatException e11) {
                    Log.e("TTPropHelper", e11.getMessage());
                    return j11;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return j12;
    }

    public String sc(String str, String str2) {
        String property;
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        synchronized (this.pFF) {
            We();
            property = this.We.getProperty(str, str2);
        }
        return property;
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00b4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x00bc A[Catch: all -> 0x00bf, TryCatch #5 {all -> 0x00bf, blocks: (B:47:0x00b6, B:49:0x00bc, B:52:0x00c1, B:53:0x00c9), top: B:68:0x00b6 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x00b6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public void sc() {
        FileInputStream fileInputStream;
        Throwable th2;
        synchronized (this.pFF) {
            try {
                if (this.ExN) {
                    return;
                }
                if (this.WH.exists()) {
                    this.Ol.delete();
                    this.WH.renameTo(this.Ol);
                }
                if (f26918sc) {
                    StringBuilder sb2 = new StringBuilder("reload: ");
                    sb2.append(this.Ol.getAbsolutePath());
                    sb2.append(", exist? ");
                    sb2.append(this.Ol.exists());
                }
                Properties properties = null;
                if (this.Ol.exists()) {
                    Properties properties2 = new Properties();
                    try {
                        try {
                            fileInputStream = new FileInputStream(this.Ol);
                            try {
                                properties2.load(fileInputStream);
                                if (f26918sc) {
                                    StringBuilder sb3 = new StringBuilder("reload: find ");
                                    sb3.append(properties2.size());
                                    sb3.append(" ,items from ");
                                    sb3.append(this.Ol.getAbsolutePath());
                                }
                                fileInputStream.close();
                            } catch (Throwable th3) {
                                th2 = th3;
                                try {
                                    Log.e("TTPropHelper", "reload: ", th2);
                                    if (fileInputStream != null) {
                                        fileInputStream.close();
                                    }
                                    properties = properties2;
                                    synchronized (this.pFF) {
                                        if (properties != null) {
                                            try {
                                                if (!properties.isEmpty()) {
                                                    this.We = properties;
                                                }
                                            } catch (Throwable th4) {
                                                throw th4;
                                            }
                                        }
                                        this.ExN = true;
                                        this.pFF.notifyAll();
                                    }
                                } catch (Throwable th5) {
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (Throwable th6) {
                                            Log.w("TTPropHelper", th6.getMessage());
                                        }
                                    }
                                    throw th5;
                                }
                            }
                        } catch (Throwable th7) {
                            Log.w("TTPropHelper", th7.getMessage());
                        }
                    } catch (Throwable th8) {
                        fileInputStream = null;
                        th2 = th8;
                    }
                    properties = properties2;
                }
                synchronized (this.pFF) {
                    if (properties != null) {
                        if (!properties.isEmpty()) {
                            this.We = properties;
                        }
                    }
                    this.ExN = true;
                    this.pFF.notifyAll();
                }
            } catch (Throwable th9) {
                throw th9;
            }
        }
    }

    public boolean sc(String str) {
        boolean zContainsKey;
        synchronized (this.pFF) {
            try {
                try {
                    We();
                    zContainsKey = this.We.containsKey(str);
                } catch (NumberFormatException e11) {
                    Log.e("TTPropHelper", e11.getMessage());
                    return false;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return zContainsKey;
    }

    public boolean sc(String str, boolean z11) {
        boolean z12;
        if (TextUtils.isEmpty(str)) {
            return z11;
        }
        synchronized (this.pFF) {
            try {
                try {
                    We();
                    z12 = Boolean.parseBoolean(this.We.getProperty(str, String.valueOf(z11)));
                } catch (NumberFormatException e11) {
                    Log.e("TTPropHelper", e11.getMessage());
                    return z11;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return z12;
    }
}
