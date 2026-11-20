package com.bytedance.sdk.openadsdk.multipro;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.component.utils.Xc;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY {
    private static final AtomicBoolean pFF = new AtomicBoolean(false);

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static boolean f28655sc = true;

    private static String pFF() {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredField", String.class);
            declaredMethod2.setAccessible(true);
            Class cls = (Class) declaredMethod.invoke(null, "android.webkit.WebViewFactory");
            return (String) ((Field) declaredMethod2.invoke(cls, "sDataDirectorySuffix")).get(cls);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:65:0x0091 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x0087 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:79:? A[SYNTHETIC] */
    private static void pFF(Context context) throws Throwable {
        RandomAccessFile randomAccessFile;
        FileChannel channel;
        Throwable th2;
        String strPFF = pFF();
        File file = new File(context.getDir(TextUtils.isEmpty(strPFF) ? "webview" : "webview_".concat(String.valueOf(strPFF)), 0).getPath(), "webview_data.lock");
        file.getAbsolutePath();
        if (!file.exists()) {
            return;
        }
        FileChannel fileChannel = null;
        FileLock fileLockTryLock = null;
        fileChannel = null;
        fileChannel = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                try {
                    channel = randomAccessFile.getChannel();
                    if (channel != null) {
                        try {
                            fileLockTryLock = channel.tryLock();
                        } catch (Exception unused) {
                            fileChannel = channel;
                            sc(file);
                            if (fileChannel != null) {
                                try {
                                    fileChannel.close();
                                } catch (Throwable th3) {
                                    th3.getMessage();
                                }
                            }
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                    return;
                                } catch (Throwable th4) {
                                    th4.getMessage();
                                    return;
                                }
                            }
                            return;
                        } catch (Throwable th5) {
                            th2 = th5;
                            if (channel != null) {
                                try {
                                    channel.close();
                                } catch (Throwable th6) {
                                    th6.getMessage();
                                }
                            }
                            if (randomAccessFile == null) {
                                throw th2;
                            }
                            try {
                                randomAccessFile.close();
                                throw th2;
                            } catch (Throwable th7) {
                                th7.getMessage();
                                throw th2;
                            }
                        }
                    }
                    if (fileLockTryLock != null) {
                        fileLockTryLock.close();
                    } else {
                        sc(file);
                    }
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (Throwable th8) {
                            th8.getMessage();
                        }
                    }
                    try {
                        randomAccessFile.close();
                    } catch (Throwable th9) {
                        th9.getMessage();
                    }
                } catch (Exception unused2) {
                }
            } catch (Throwable th10) {
                th = th10;
                channel = fileChannel;
                th2 = th;
                if (channel != null) {
                    channel.close();
                }
                if (randomAccessFile == null) {
                    throw th2;
                }
                randomAccessFile.close();
                throw th2;
            }
        } catch (Exception unused3) {
            randomAccessFile = null;
        } catch (Throwable th11) {
            th = th11;
            randomAccessFile = null;
            channel = null;
            th2 = th;
            if (channel != null) {
                channel.close();
            }
            if (randomAccessFile == null) {
                throw th2;
            }
            randomAccessFile.close();
            throw th2;
        }
    }

    public static void sc() {
        f28655sc = false;
    }

    public static void sc(Context context) {
        if (context != null && f28655sc && pFF.compareAndSet(false, true)) {
            try {
                if (Build.VERSION.SDK_INT >= 28) {
                    if (Xc.sc(context)) {
                        pFF(context);
                        return;
                    }
                    String strPFF = Xc.pFF(context);
                    try {
                        if (TextUtils.isEmpty(strPFF)) {
                            strPFF = context.getPackageName() + Process.myPid();
                        }
                        WebView.setDataDirectorySuffix(strPFF);
                    } catch (IllegalStateException unused) {
                        sc(strPFF);
                    } catch (Exception unused2) {
                    }
                }
            } catch (Throwable th2) {
                Tf.pFF(th2.getMessage());
            }
        }
    }

    private static void sc(File file) {
        sc(file, file.exists() ? file.delete() : false);
    }

    private static void sc(File file, boolean z11) {
        if (!z11 || file.exists()) {
            return;
        }
        try {
            file.createNewFile();
        } catch (IOException e11) {
            Tf.sc("TTAD.TTMultiInitHelper", e11.getMessage());
        }
    }

    private static void sc(String str) {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredField", String.class);
            declaredMethod2.setAccessible(true);
            Class cls = (Class) declaredMethod.invoke(null, "android.webkit.WebViewFactory");
            Field field = (Field) declaredMethod2.invoke(cls, "sDataDirectorySuffix");
            field.setAccessible(true);
            if (TextUtils.isEmpty((String) field.get(cls))) {
                field.set(cls, str);
            }
        } catch (Throwable unused) {
        }
    }
}
