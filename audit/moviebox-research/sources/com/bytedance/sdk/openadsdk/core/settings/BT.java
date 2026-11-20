package com.bytedance.sdk.openadsdk.core.settings;

import android.content.SharedPreferences;
import android.os.SystemClock;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.utils.Cb;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class BT implements ExN {
    private sc WH;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final String f28481qr;
    private final ConcurrentHashMap<String, Object> zY = new ConcurrentHashMap<>();
    private final Object We = new Object();
    private final Object ExN = new Object();
    private final CountDownLatch TRI = new CountDownLatch(1);
    private Properties Qj = new Properties();
    private volatile boolean Ol = false;

    /* JADX INFO: compiled from: source.java */
    public class pFF implements ExN.sc {
        private final Map<String, Object> pFF = new HashMap();
        private final Object zY = new Object();

        public pFF() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.ExN.sc
        public ExN.sc sc(String str) {
            synchronized (this.zY) {
                this.pFF.put(str, this);
            }
            return this;
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.ExN.sc
        public ExN.sc sc(String str, float f11) {
            synchronized (this.zY) {
                this.pFF.put(str, Float.valueOf(f11));
            }
            return this;
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.ExN.sc
        public ExN.sc sc(String str, int i11) {
            synchronized (this.zY) {
                this.pFF.put(str, Integer.valueOf(i11));
            }
            return this;
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.ExN.sc
        public ExN.sc sc(String str, long j11) {
            synchronized (this.zY) {
                this.pFF.put(str, Long.valueOf(j11));
            }
            return this;
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.ExN.sc
        public ExN.sc sc(String str, String str2) {
            synchronized (this.zY) {
                this.pFF.put(str, str2);
            }
            return this;
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.ExN.sc
        public ExN.sc sc(String str, boolean z11) {
            synchronized (this.zY) {
                this.pFF.put(str, Boolean.valueOf(z11));
            }
            return this;
        }

        @Override // com.bytedance.sdk.openadsdk.core.settings.ExN.sc
        public void sc() {
            Object obj;
            Properties properties = new Properties();
            synchronized (this.zY) {
                try {
                    properties.putAll(BT.this.Qj);
                    boolean z11 = false;
                    for (Map.Entry<String, Object> entry : this.pFF.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        if (value == this || value == null) {
                            if (properties.containsKey(key)) {
                                properties.remove(key);
                                z11 = true;
                            }
                        } else if (!properties.containsKey(key) || (obj = properties.get(key)) == null || !obj.equals(value)) {
                            properties.put(key, String.valueOf(value));
                            z11 = true;
                        }
                    }
                    this.pFF.clear();
                    if (z11) {
                        BT.this.sc(properties);
                        BT.this.Qj = properties;
                        BT.this.zY.clear();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface sc {
        void pFF();

        void sc();
    }

    public BT(String str, sc scVar) {
        this.f28481qr = str;
        this.WH = scVar;
        Cb.sc(new com.bytedance.sdk.component.Qj.Qj("SetL_".concat(String.valueOf(str))) { // from class: com.bytedance.sdk.openadsdk.core.settings.BT.1
            @Override // java.lang.Runnable
            public void run() {
                BT.this.sc(false);
            }
        });
    }

    private void ExN() {
        if (this.Ol) {
            return;
        }
        try {
            SystemClock.elapsedRealtime();
            this.TRI.await(Cb.ExN() ? 4 : 8, TimeUnit.SECONDS);
        } catch (InterruptedException e11) {
            com.bytedance.sdk.component.utils.Tf.sc("SdkSettings.Prop", "awaitLoadedLocked: ", e11);
        }
    }

    private File TRI() {
        return new File(Xc.sc().getFilesDir(), this.f28481qr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(Properties properties) {
        synchronized (this.ExN) {
            File fileTRI = TRI();
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(fileTRI);
                    try {
                        properties.store(fileOutputStream2, (String) null);
                        fileTRI.getAbsolutePath();
                        com.bytedance.sdk.openadsdk.utils.UFX.sc(fileOutputStream2);
                    } catch (Exception e11) {
                        e = e11;
                        fileOutputStream = fileOutputStream2;
                        com.bytedance.sdk.component.utils.Tf.sc("SdkSettings.Prop", "saveToLocal: ", e);
                        if (fileOutputStream != null) {
                            com.bytedance.sdk.openadsdk.utils.UFX.sc(fileOutputStream);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            com.bytedance.sdk.openadsdk.utils.UFX.sc(fileOutputStream);
                        }
                        throw th;
                    }
                } catch (Exception e12) {
                    e = e12;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        dE.VZ();
    }

    public void We() {
        sc scVar = this.WH;
        if (scVar != null) {
            scVar.pFF();
        }
    }

    public boolean pFF() {
        return this.Ol;
    }

    public float sc(String str, float f11) {
        if (str != null && !str.isEmpty()) {
            ExN();
            try {
                return Float.parseFloat(this.Qj.getProperty(str, String.valueOf(f11)));
            } catch (NumberFormatException e11) {
                com.bytedance.sdk.component.utils.Tf.sc("SdkSettings.Prop", "", e11);
            }
        }
        return f11;
    }

    public int sc(String str, int i11) {
        if (str != null && !str.isEmpty()) {
            ExN();
            try {
                return Integer.parseInt(this.Qj.getProperty(str, String.valueOf(i11)));
            } catch (NumberFormatException e11) {
                com.bytedance.sdk.component.utils.Tf.sc("SdkSettings.Prop", "", e11);
            }
        }
        return i11;
    }

    public long sc(String str, long j11) {
        if (str != null && !str.isEmpty()) {
            ExN();
            try {
                return Long.parseLong(this.Qj.getProperty(str, String.valueOf(j11)));
            } catch (NumberFormatException e11) {
                com.bytedance.sdk.component.utils.Tf.sc("SdkSettings.Prop", "", e11);
            }
        }
        return j11;
    }

    public ExN.sc sc() {
        return new pFF();
    }

    public <T> T sc(String str, T t11, ExN.pFF<T> pff) {
        T tPFF;
        if (str != null && !str.isEmpty()) {
            if (this.zY.containsKey(str)) {
                try {
                    return (T) this.zY.get(str);
                } catch (Exception e11) {
                    com.bytedance.sdk.component.utils.Tf.sc("SdkSettings.Prop", "", e11);
                    return t11;
                }
            }
            ExN();
            String property = this.Qj.getProperty(str, null);
            if (property != null && pff != null && (tPFF = pff.pFF(property)) != null) {
                this.zY.put(str, tPFF);
                return tPFF;
            }
        }
        return t11;
    }

    public String sc(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return str2;
        }
        ExN();
        return this.Qj.getProperty(str, str2);
    }

    public void sc(boolean z11) {
        sc scVar;
        Object obj;
        synchronized (this.We) {
            try {
                if (!this.Ol || z11) {
                    File fileTRI = TRI();
                    if (fileTRI.exists()) {
                        Properties properties = new Properties();
                        FileInputStream fileInputStream = null;
                        try {
                            try {
                                FileInputStream fileInputStream2 = new FileInputStream(fileTRI);
                                try {
                                    properties.load(fileInputStream2);
                                    properties.size();
                                    new StringBuilder("items from ").append(fileTRI.getAbsolutePath());
                                    if (!properties.isEmpty()) {
                                        this.Qj = properties;
                                        this.zY.clear();
                                    }
                                    com.bytedance.sdk.openadsdk.utils.UFX.sc(fileInputStream2);
                                    obj = this.We;
                                } catch (OutOfMemoryError unused) {
                                    fileInputStream = fileInputStream2;
                                    try {
                                        com.bytedance.sdk.component.utils.TRI.zY(fileTRI);
                                    } catch (Throwable th2) {
                                        com.bytedance.sdk.component.utils.Tf.sc("SdkSettings.Prop", "delete: ", th2);
                                    }
                                    if (fileInputStream != null) {
                                        com.bytedance.sdk.openadsdk.utils.UFX.sc(fileInputStream);
                                    }
                                    obj = this.We;
                                } catch (Throwable th3) {
                                    th = th3;
                                    fileInputStream = fileInputStream2;
                                    com.bytedance.sdk.component.utils.Tf.sc("SdkSettings.Prop", "reload: ", th);
                                    if (fileInputStream != null) {
                                        com.bytedance.sdk.openadsdk.utils.UFX.sc(fileInputStream);
                                    }
                                    obj = this.We;
                                }
                            } catch (Throwable th4) {
                                if (fileInputStream != null) {
                                    com.bytedance.sdk.openadsdk.utils.UFX.sc(fileInputStream);
                                }
                                this.We.notifyAll();
                                throw th4;
                            }
                        } catch (OutOfMemoryError unused2) {
                        } catch (Throwable th5) {
                            th = th5;
                        }
                        obj.notifyAll();
                    } else if (com.bytedance.sdk.component.utils.Xc.sc(Xc.sc()) && "tt_sdk_settings.prop".equals(this.f28481qr)) {
                        try {
                            boolean z12 = false;
                            SharedPreferences sharedPreferences = Xc.sc().getSharedPreferences("tt_sdk_settings", 0);
                            if (!sharedPreferences.getAll().isEmpty()) {
                                ExN.sc scVarSc = sc();
                                for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
                                    String key = entry.getKey();
                                    Object value = entry.getValue();
                                    if (key != null && !key.isEmpty() && value != null) {
                                        scVarSc.sc(key, value.toString());
                                        z12 = true;
                                    }
                                }
                                if (z12) {
                                    scVarSc.sc();
                                }
                                sharedPreferences.edit().clear().commit();
                            }
                        } catch (Exception unused3) {
                        }
                    }
                    if (!this.Ol && (scVar = this.WH) != null) {
                        scVar.sc();
                    }
                    this.Ol = true;
                    this.TRI.countDown();
                }
            } catch (Throwable th6) {
                throw th6;
            }
        }
    }

    public boolean sc(String str, boolean z11) {
        if (str != null && !str.isEmpty()) {
            ExN();
            try {
                return Boolean.parseBoolean(this.Qj.getProperty(str, String.valueOf(z11)));
            } catch (Exception e11) {
                com.bytedance.sdk.component.utils.Tf.sc("SdkSettings.Prop", "", e11);
            }
        }
        return z11;
    }

    public void zY() {
        File fileTRI = TRI();
        if (fileTRI.exists()) {
            fileTRI.delete();
        }
    }
}
