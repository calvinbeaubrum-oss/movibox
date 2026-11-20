package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.Properties;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class HJN implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static volatile boolean f28732sc;
    private final Thread.UncaughtExceptionHandler pFF = Thread.getDefaultUncaughtExceptionHandler();
    private String zY;

    private HJN() {
        Thread.setDefaultUncaughtExceptionHandler(this);
        pFF();
    }

    private void pFF() {
        Context contextSc = com.bytedance.sdk.openadsdk.core.Xc.sc();
        if (contextSc == null) {
            return;
        }
        try {
            File file = new File(contextSc.getFilesDir(), "TTCache");
            file.mkdirs();
            this.zY = file.getPath();
        } catch (Throwable unused) {
        }
    }

    public static HJN sc() {
        return new HJN();
    }

    /* JADX WARN: Code duplicated, block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:78:0x00fc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:84:0x010f A[DONT_GENERATE, EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x0103 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:95:0x0116 A[DONT_GENERATE, EXC_TOP_SPLITTER, SYNTHETIC] */
    private void sc(Thread thread, Throwable th2) {
        FileOutputStream fileOutputStream;
        int i11;
        boolean z11;
        FileInputStream fileInputStream = null;
        fileOutputStream = null;
        fileOutputStream = null;
        FileOutputStream fileOutputStream2 = null;
        FileInputStream fileInputStream2 = null;
        fileInputStream = null;
        try {
            if (TextUtils.isEmpty(this.zY)) {
                pFF();
            }
            if (TextUtils.isEmpty(this.zY)) {
                return;
            }
            File file = new File(this.zY, "tt_crash_count.properties");
            if (!file.exists() || !file.isFile() || !file.canRead()) {
                Properties properties = new Properties();
                properties.setProperty("crash_count", "1");
                properties.setProperty("crash_last_time", String.valueOf(System.currentTimeMillis()));
                fileOutputStream = new FileOutputStream(file);
                try {
                    properties.store(fileOutputStream, "tt_crash_info");
                    com.bytedance.sdk.component.utils.Tf.sc("TTCrashHandler", "==first");
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Throwable unused) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable unused2) {
                            return;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        com.bytedance.sdk.component.utils.Tf.sc("TTCrashHandler", "crash count error", th);
                        if (fileOutputStream != null) {
                            try {
                                return;
                            } catch (Throwable unused3) {
                                return;
                            }
                        }
                        return;
                    } finally {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable unused4) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable unused5) {
                            }
                        }
                    }
                }
            }
            Properties properties2 = new Properties();
            FileInputStream fileInputStream3 = new FileInputStream(file);
            try {
                properties2.load(fileInputStream3);
                String property = properties2.getProperty("crash_count", "0");
                String property2 = properties2.getProperty("crash_last_time", "0");
                int iIntValue = Integer.valueOf(property).intValue();
                long jLongValue = Long.valueOf(property2).longValue();
                int i12 = 0;
                if (System.currentTimeMillis() - jLongValue < 300000) {
                    i11 = iIntValue + 1;
                    z11 = false;
                } else {
                    i11 = 1;
                    z11 = true;
                }
                boolean z12 = i11 >= 3;
                if (!z12) {
                    i12 = i11;
                }
                com.bytedance.sdk.component.utils.Tf.sc("TTCrashHandler", "==" + i12 + ", " + z12 + ", " + z11);
                if (z12) {
                    try {
                        file.delete();
                    } catch (Throwable unused6) {
                    }
                } else {
                    properties2.setProperty("crash_count", String.valueOf(i12));
                    if (z11) {
                        properties2.setProperty("crash_last_time", String.valueOf(System.currentTimeMillis()));
                    }
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        properties2.store(fileOutputStream, "tt_crash_info");
                        fileOutputStream2 = fileOutputStream;
                    } catch (Throwable th4) {
                        th = th4;
                        fileInputStream = fileInputStream3;
                        com.bytedance.sdk.component.utils.Tf.sc("TTCrashHandler", "crash count error", th);
                        if (fileOutputStream != null) {
                            return;
                        } else {
                            return;
                        }
                    }
                }
                if (z12) {
                    zY();
                }
                fileOutputStream = fileOutputStream2;
                fileInputStream2 = fileInputStream3;
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = fileOutputStream2;
            }
        } catch (Throwable th6) {
            th = th6;
            fileOutputStream = null;
        }
    }

    private void zY() {
        try {
            Method methodSc = com.bytedance.sdk.component.utils.JPJ.sc("com.bytedance.sdk.openadsdk.TTC2Proxy", "a", Context.class);
            if (methodSc != null) {
                methodSc.invoke(null, com.bytedance.sdk.openadsdk.core.Xc.sc());
            }
        } catch (Throwable unused) {
        }
        try {
            Method methodSc2 = com.bytedance.sdk.component.utils.JPJ.sc("com.bytedance.sdk.openadsdk.TTC3Proxy", "a", Context.class);
            if (methodSc2 != null) {
                methodSc2.invoke(null, com.bytedance.sdk.openadsdk.core.Xc.sc());
            }
        } catch (Throwable unused2) {
        }
        try {
            com.bytedance.sdk.openadsdk.core.settings.dE.ef().sc();
        } catch (Throwable unused3) {
        }
        try {
            com.bytedance.sdk.component.adexpress.sc.pFF.pFF.pFF();
        } catch (Throwable unused4) {
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th2) {
        f28732sc = true;
        com.bytedance.sdk.component.Qj.TRI.sc(false);
        try {
            StringWriter stringWriter = new StringWriter();
            th2.printStackTrace(new PrintWriter(stringWriter));
            String string = stringWriter.toString();
            if (string != null && string.contains(AdSlot.class.getPackage().getName())) {
                sc(thread, th2);
            }
        } catch (Throwable unused) {
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.pFF;
        if (uncaughtExceptionHandler == null || uncaughtExceptionHandler == this) {
            return;
        }
        uncaughtExceptionHandler.uncaughtException(thread, th2);
    }
}
