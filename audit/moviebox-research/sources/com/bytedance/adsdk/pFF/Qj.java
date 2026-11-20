package com.bytedance.adsdk.pFF;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.util.Base64;
import android.util.JsonReader;
import com.bytedance.adsdk.pFF.ExN.JPJ;
import com.bytedance.component.sdk.annotation.RawRes;
import com.bytedance.component.sdk.annotation.WorkerThread;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Qj {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static final Map<String, Ql<qr>> f26117sc = new HashMap();
    private static final Set<Object> pFF = new HashSet();
    private static final byte[] zY = {80, 75, 3, 4};

    public static Ql<qr> pFF(Context context, String str) {
        return pFF(context, str, "asset_".concat(String.valueOf(str)));
    }

    public static Ql<qr> pFF(Context context, final String str, final String str2) {
        final Context applicationContext = context.getApplicationContext();
        return sc(str2, new Callable<Tf<qr>>() { // from class: com.bytedance.adsdk.pFF.Qj.4
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
            public Tf<qr> call() throws Exception {
                return Qj.zY(applicationContext, str, str2);
            }
        });
    }

    @WorkerThread
    public static Tf<qr> pFF(Context context, @RawRes int i11) {
        return pFF(context, i11, zY(context, i11));
    }

    @WorkerThread
    public static Tf<qr> pFF(Context context, @RawRes int i11, String str) {
        try {
            return pFF(context.getResources().openRawResource(i11), zY(context, i11));
        } catch (Resources.NotFoundException e11) {
            return new Tf<>((Throwable) e11);
        }
    }

    @WorkerThread
    private static Tf<qr> pFF(Context context, ZipInputStream zipInputStream, String str) {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            qr qrVarSc = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().endsWith(".json")) {
                    qrVarSc = sc(new JsonReader(new InputStreamReader(zipInputStream)), (String) null, false).sc();
                } else if (name.endsWith(".png") || name.endsWith(".webp") || name.endsWith(".jpg") || name.endsWith(".jpeg")) {
                    if (name.contains("../")) {
                        zipInputStream.closeEntry();
                        nextEntry = zipInputStream.getNextEntry();
                    } else {
                        String[] strArrSplit = name.split("/");
                        map.put(strArrSplit[strArrSplit.length - 1], BitmapFactory.decodeStream(zipInputStream));
                    }
                } else if (!name.endsWith(".ttf") && !name.endsWith(".otf")) {
                    zipInputStream.closeEntry();
                } else if (name.contains("../")) {
                    zipInputStream.closeEntry();
                    nextEntry = zipInputStream.getNextEntry();
                } else {
                    String[] strArrSplit2 = name.split("/");
                    String str2 = strArrSplit2[strArrSplit2.length - 1];
                    String str3 = str2.split("\\.")[0];
                    File file = new File(context.getCacheDir(), str2);
                    new FileOutputStream(file);
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        try {
                            byte[] bArr = new byte[4096];
                            while (true) {
                                int i11 = zipInputStream.read(bArr);
                                if (i11 == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, i11);
                            }
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (Throwable th2) {
                            try {
                                throw th2;
                            } catch (Throwable th3) {
                                try {
                                    fileOutputStream.close();
                                } catch (Throwable th4) {
                                    th2.addSuppressed(th4);
                                }
                                throw th3;
                            }
                        }
                    } catch (Throwable unused) {
                    }
                    Typeface typefaceCreateFromFile = Typeface.createFromFile(file);
                    if (!file.delete()) {
                        file.getAbsolutePath();
                    }
                    map2.put(str3, typefaceCreateFromFile);
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (qrVarSc == null) {
                return new Tf<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : map.entrySet()) {
                WH whSc = sc(qrVarSc, (String) entry.getKey());
                if (whSc != null) {
                    whSc.sc(com.bytedance.adsdk.pFF.TRI.TRI.sc((Bitmap) entry.getValue(), whSc.sc(), whSc.pFF()));
                }
            }
            for (Map.Entry entry2 : map2.entrySet()) {
                boolean z11 = false;
                for (com.bytedance.adsdk.pFF.zY.zY zYVar : qrVarSc.BT().values()) {
                    if (zYVar.sc().equals(entry2.getKey())) {
                        zYVar.sc((Typeface) entry2.getValue());
                        z11 = true;
                    }
                }
                if (!z11) {
                }
            }
            if (map.isEmpty()) {
                Iterator<Map.Entry<String, WH>> it = qrVarSc.dE().entrySet().iterator();
                while (it.hasNext()) {
                    WH value = it.next().getValue();
                    if (value == null) {
                        return null;
                    }
                    String strOl = value.Ol();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inScaled = true;
                    options.inDensity = 160;
                    if (strOl.startsWith("data:") && strOl.indexOf("base64,") > 0) {
                        try {
                            byte[] bArrDecode = Base64.decode(strOl.substring(strOl.indexOf(44) + 1), 0);
                            value.sc(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options));
                        } catch (IllegalArgumentException unused2) {
                            return null;
                        }
                    }
                }
            }
            for (Map.Entry<String, WH> entry3 : qrVarSc.dE().entrySet()) {
                if (entry3.getValue().UFX() == null) {
                    return new Tf<>((Throwable) new IllegalStateException("There is no image for " + entry3.getValue().Ol()));
                }
            }
            if (str != null) {
                com.bytedance.adsdk.pFF.zY.ExN.sc().sc(str, qrVarSc);
            }
            return new Tf<>(qrVarSc);
        } catch (IOException e11) {
            return new Tf<>((Throwable) e11);
        }
    }

    @WorkerThread
    public static Tf<qr> pFF(InputStream inputStream, String str) {
        return sc(inputStream, str, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void pFF(boolean z11) {
        ArrayList arrayList = new ArrayList(pFF);
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            arrayList.get(i11);
        }
    }

    public static Ql<qr> sc(Context context, @RawRes int i11) {
        return sc(context, i11, zY(context, i11));
    }

    public static Ql<qr> sc(Context context, @RawRes final int i11, final String str) {
        final WeakReference weakReference = new WeakReference(context);
        final Context applicationContext = context.getApplicationContext();
        return sc(str, new Callable<Tf<qr>>() { // from class: com.bytedance.adsdk.pFF.Qj.5
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
            public Tf<qr> call() throws Exception {
                Context context2 = (Context) weakReference.get();
                if (context2 == null) {
                    context2 = applicationContext;
                }
                return Qj.pFF(context2, i11, str);
            }
        });
    }

    public static Ql<qr> sc(Context context, String str) {
        return sc(context, str, "url_".concat(String.valueOf(str)));
    }

    public static Ql<qr> sc(final Context context, final String str, final String str2) {
        return sc(str2, new Callable<Tf<qr>>() { // from class: com.bytedance.adsdk.pFF.Qj.1
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
            public Tf<qr> call() throws Exception {
                Tf<qr> tfSc = ExN.sc(context).sc(context, str, str2);
                if (str2 != null && tfSc.sc() != null) {
                    com.bytedance.adsdk.pFF.zY.ExN.sc().sc(str2, tfSc.sc());
                }
                return tfSc;
            }
        });
    }

    public static Ql<qr> sc(final InputStream inputStream, final String str) {
        return sc(str, new Callable<Tf<qr>>() { // from class: com.bytedance.adsdk.pFF.Qj.6
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
            public Tf<qr> call() throws Exception {
                return Qj.pFF(inputStream, str);
            }
        });
    }

    private static Ql<qr> sc(final String str, Callable<Tf<qr>> callable) {
        final qr qrVarSc = str == null ? null : com.bytedance.adsdk.pFF.zY.ExN.sc().sc(str);
        if (qrVarSc != null) {
            return new Ql<>(new Callable<Tf<qr>>() { // from class: com.bytedance.adsdk.pFF.Qj.7
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
                public Tf<qr> call() throws Exception {
                    return new Tf<>(qrVarSc);
                }
            });
        }
        if (str != null) {
            Map<String, Ql<qr>> map = f26117sc;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        Ql<qr> ql2 = new Ql<>(callable);
        if (str != null) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            ql2.sc(new UFX<qr>() { // from class: com.bytedance.adsdk.pFF.Qj.2
                @Override // com.bytedance.adsdk.pFF.UFX
                public void sc(qr qrVar) {
                    Qj.f26117sc.remove(str);
                    atomicBoolean.set(true);
                    if (Qj.f26117sc.size() == 0) {
                        Qj.pFF(true);
                    }
                }
            });
            ql2.zY(new UFX<Throwable>() { // from class: com.bytedance.adsdk.pFF.Qj.3
                @Override // com.bytedance.adsdk.pFF.UFX
                public void sc(Throwable th2) {
                    Qj.f26117sc.remove(str);
                    atomicBoolean.set(true);
                    if (Qj.f26117sc.size() == 0) {
                        Qj.pFF(true);
                    }
                }
            });
            if (!atomicBoolean.get()) {
                Map<String, Ql<qr>> map2 = f26117sc;
                map2.put(str, ql2);
                if (map2.size() == 1) {
                    pFF(false);
                }
            }
        }
        return ql2;
    }

    @WorkerThread
    public static Tf<qr> sc(Context context, ZipInputStream zipInputStream, String str) {
        try {
            return pFF(context, zipInputStream, str);
        } finally {
            com.bytedance.adsdk.pFF.TRI.TRI.sc(zipInputStream);
        }
    }

    @WorkerThread
    public static Tf<qr> sc(JsonReader jsonReader, String str) {
        return sc(jsonReader, str, true);
    }

    private static Tf<qr> sc(JsonReader jsonReader, String str, boolean z11) {
        try {
            qr qrVarSc = JPJ.sc(jsonReader);
            com.bytedance.adsdk.pFF.zY.ExN.sc().sc(str, qrVarSc);
            return new Tf<>(qrVarSc);
        } catch (Exception e11) {
            return new Tf<>((Throwable) e11);
        } finally {
            if (z11) {
                sc(jsonReader);
            }
        }
    }

    @WorkerThread
    private static Tf<qr> sc(InputStream inputStream, String str, boolean z11) {
        try {
            return sc(new JsonReader(new InputStreamReader(inputStream)), str);
        } finally {
            if (z11) {
                com.bytedance.adsdk.pFF.TRI.TRI.sc(inputStream);
            }
        }
    }

    private static WH sc(qr qrVar, String str) {
        for (WH wh2 : qrVar.dE().values()) {
            if (wh2.Ol().equals(str)) {
                return wh2;
            }
        }
        return null;
    }

    public static void sc(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e11) {
                throw e11;
            } catch (Exception unused) {
            }
        }
    }

    private static boolean sc(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    @WorkerThread
    public static Tf<qr> zY(Context context, String str) {
        return zY(context, str, "asset_".concat(String.valueOf(str)));
    }

    @WorkerThread
    public static Tf<qr> zY(Context context, String str, String str2) {
        try {
            if (!str.endsWith(".zip") && !str.endsWith(".lottie")) {
                return pFF(context.getAssets().open(str), str2);
            }
            return sc(context, new ZipInputStream(context.getAssets().open(str)), str2);
        } catch (IOException e11) {
            return new Tf<>((Throwable) e11);
        }
    }

    private static String zY(Context context, @RawRes int i11) {
        StringBuilder sb2 = new StringBuilder("rawRes");
        sb2.append(sc(context) ? "_night_" : "_day_");
        sb2.append(i11);
        return sb2.toString();
    }
}
