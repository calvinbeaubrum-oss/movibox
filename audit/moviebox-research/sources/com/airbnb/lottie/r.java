package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.util.Base64;
import androidx.annotation.Nullable;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.applovin.exoplayer2.common.base.Ascii;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import okio.BufferedSource;
import okio.Okio;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, LottieTask<h>> f15319a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<s0> f15320b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f15321c = {80, 75, 3, 4};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte[] f15322d = {Ascii.US, -117, 8};

    public static LottieTask<h> A(final Context context, final ZipInputStream zipInputStream, @Nullable final String str) {
        return j(str, new Callable() { // from class: com.airbnb.lottie.i
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return r.C(context, zipInputStream, str);
            }
        }, new Runnable() { // from class: com.airbnb.lottie.j
            @Override // java.lang.Runnable
            public final void run() {
                g7.l.c(zipInputStream);
            }
        });
    }

    public static LottieTask<h> B(ZipInputStream zipInputStream, @Nullable String str) {
        return A(null, zipInputStream, str);
    }

    public static q0<h> C(@Nullable Context context, ZipInputStream zipInputStream, @Nullable String str) {
        return D(context, zipInputStream, str, true);
    }

    public static q0<h> D(@Nullable Context context, ZipInputStream zipInputStream, @Nullable String str, boolean z11) {
        try {
            return E(context, zipInputStream, str);
        } finally {
            if (z11) {
                g7.l.c(zipInputStream);
            }
        }
    }

    public static q0<h> E(Context context, ZipInputStream zipInputStream, @Nullable String str) {
        h hVarA;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        if (str == null) {
            hVarA = null;
        } else {
            try {
                hVarA = a7.f.b().a(str);
            } catch (IOException e11) {
                return new q0<>((Throwable) e11);
            }
        }
        if (hVarA != null) {
            return new q0<>(hVarA);
        }
        ZipEntry nextEntry = zipInputStream.getNextEntry();
        h hVarB = null;
        while (nextEntry != null) {
            String name = nextEntry.getName();
            if (name.contains("__MACOSX")) {
                zipInputStream.closeEntry();
            } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                zipInputStream.closeEntry();
            } else if (nextEntry.getName().contains(".json")) {
                hVarB = t(JsonReader.m(Okio.buffer(Okio.source(zipInputStream))), null, false).b();
            } else if (name.contains(".png") || name.contains(".webp") || name.contains(".jpg") || name.contains(".jpeg")) {
                String[] strArrSplit = name.split("/");
                map.put(strArrSplit[strArrSplit.length - 1], BitmapFactory.decodeStream(zipInputStream));
            } else if (name.contains(".ttf") || name.contains(".otf")) {
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
                        Typeface typefaceCreateFromFile = Typeface.createFromFile(file);
                        if (!file.delete()) {
                            g7.f.c("Failed to delete temp font file " + file.getAbsolutePath() + InstructionFileId.DOT);
                        }
                        map2.put(str3, typefaceCreateFromFile);
                    } catch (Throwable th2) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                        throw th2;
                    }
                } catch (Throwable th4) {
                    g7.f.d("Unable to save font " + str3 + " to the temporary file: " + str2 + ". ", th4);
                }
            } else {
                zipInputStream.closeEntry();
            }
            nextEntry = zipInputStream.getNextEntry();
        }
        if (hVarB == null) {
            return new q0<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
        }
        for (Map.Entry entry : map.entrySet()) {
            l0 l0VarK = k(hVarB, (String) entry.getKey());
            if (l0VarK != null) {
                l0VarK.g(g7.l.m((Bitmap) entry.getValue(), l0VarK.f(), l0VarK.d()));
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            boolean z11 = false;
            for (a7.b bVar : hVarB.g().values()) {
                if (bVar.a().equals(entry2.getKey())) {
                    bVar.e((Typeface) entry2.getValue());
                    z11 = true;
                }
            }
            if (!z11) {
                g7.f.c("Parsed font for " + ((String) entry2.getKey()) + " however it was not found in the animation.");
            }
        }
        if (map.isEmpty()) {
            Iterator<Map.Entry<String, l0>> it = hVarB.j().entrySet().iterator();
            while (it.hasNext()) {
                l0 value = it.next().getValue();
                if (value == null) {
                    return null;
                }
                String strC = value.c();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inScaled = true;
                options.inDensity = 160;
                if (strC.startsWith("data:") && strC.indexOf("base64,") > 0) {
                    try {
                        byte[] bArrDecode = Base64.decode(strC.substring(strC.indexOf(44) + 1), 0);
                        value.g(g7.l.m(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options), value.f(), value.d()));
                    } catch (IllegalArgumentException e12) {
                        g7.f.d("data URL did not have correct base64 format.", e12);
                        return null;
                    }
                }
            }
        }
        if (str != null) {
            a7.f.b().c(str, hVarB);
        }
        return new q0<>(hVarB);
    }

    public static Boolean F(BufferedSource bufferedSource) {
        return R(bufferedSource, f15322d);
    }

    public static boolean G(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static Boolean H(BufferedSource bufferedSource) {
        return R(bufferedSource, f15321c);
    }

    public static /* synthetic */ void I(String str, AtomicBoolean atomicBoolean, h hVar) {
        Map<String, LottieTask<h>> map = f15319a;
        map.remove(str);
        atomicBoolean.set(true);
        if (map.size() == 0) {
            S(true);
        }
    }

    public static /* synthetic */ void J(String str, AtomicBoolean atomicBoolean, Throwable th2) {
        Map<String, LottieTask<h>> map = f15319a;
        map.remove(str);
        atomicBoolean.set(true);
        if (map.size() == 0) {
            S(true);
        }
    }

    public static /* synthetic */ q0 N(WeakReference weakReference, Context context, int i11, String str) throws Exception {
        Context context2 = (Context) weakReference.get();
        if (context2 != null) {
            context = context2;
        }
        return x(context, i11, str);
    }

    public static /* synthetic */ q0 O(Context context, String str, String str2) throws Exception {
        q0<h> q0VarC = d.j(context).c(context, str, str2);
        if (str2 != null && q0VarC.b() != null) {
            a7.f.b().c(str2, q0VarC.b());
        }
        return q0VarC;
    }

    public static Boolean R(BufferedSource bufferedSource, byte[] bArr) {
        try {
            BufferedSource bufferedSourcePeek = bufferedSource.peek();
            for (byte b11 : bArr) {
                if (bufferedSourcePeek.readByte() != b11) {
                    return Boolean.FALSE;
                }
            }
            bufferedSourcePeek.close();
            return Boolean.TRUE;
        } catch (Exception e11) {
            g7.f.b("Failed to check zip file header", e11);
            return Boolean.FALSE;
        } catch (NoSuchMethodError unused) {
            return Boolean.FALSE;
        }
    }

    public static void S(boolean z11) {
        ArrayList arrayList = new ArrayList(f15320b);
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            ((s0) arrayList.get(i11)).a(z11);
        }
    }

    public static String T(Context context, int i11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("rawRes");
        sb2.append(G(context) ? "_night_" : "_day_");
        sb2.append(i11);
        return sb2.toString();
    }

    public static LottieTask<h> j(@Nullable final String str, Callable<q0<h>> callable, @Nullable Runnable runnable) {
        h hVarA = str == null ? null : a7.f.b().a(str);
        LottieTask<h> lottieTask = hVarA != null ? new LottieTask<>(hVarA) : null;
        if (str != null) {
            Map<String, LottieTask<h>> map = f15319a;
            if (map.containsKey(str)) {
                lottieTask = map.get(str);
            }
        }
        if (lottieTask != null) {
            if (runnable != null) {
                runnable.run();
            }
            return lottieTask;
        }
        LottieTask<h> lottieTask2 = new LottieTask<>(callable);
        if (str != null) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            lottieTask2.d(new m0() { // from class: com.airbnb.lottie.n
                @Override // com.airbnb.lottie.m0
                public final void onResult(Object obj) {
                    r.I(str, atomicBoolean, (h) obj);
                }
            });
            lottieTask2.c(new m0() { // from class: com.airbnb.lottie.o
                @Override // com.airbnb.lottie.m0
                public final void onResult(Object obj) {
                    r.J(str, atomicBoolean, (Throwable) obj);
                }
            });
            if (!atomicBoolean.get()) {
                Map<String, LottieTask<h>> map2 = f15319a;
                map2.put(str, lottieTask2);
                if (map2.size() == 1) {
                    S(false);
                }
            }
        }
        return lottieTask2;
    }

    @Nullable
    public static l0 k(h hVar, String str) {
        for (l0 l0Var : hVar.j().values()) {
            if (l0Var.c().equals(str)) {
                return l0Var;
            }
        }
        return null;
    }

    public static LottieTask<h> l(Context context, String str) {
        return m(context, str, "asset_" + str);
    }

    public static LottieTask<h> m(Context context, final String str, @Nullable final String str2) {
        final Context applicationContext = context.getApplicationContext();
        return j(str2, new Callable() { // from class: com.airbnb.lottie.p
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return r.o(applicationContext, str, str2);
            }
        }, null);
    }

    public static q0<h> n(Context context, String str) {
        return o(context, str, "asset_" + str);
    }

    public static q0<h> o(Context context, String str, @Nullable String str2) {
        h hVarA = str2 == null ? null : a7.f.b().a(str2);
        if (hVarA != null) {
            return new q0<>(hVarA);
        }
        try {
            BufferedSource bufferedSourceBuffer = Okio.buffer(Okio.source(context.getAssets().open(str)));
            if (H(bufferedSourceBuffer).booleanValue()) {
                return C(context, new ZipInputStream(bufferedSourceBuffer.inputStream()), str2);
            }
            return F(bufferedSourceBuffer).booleanValue() ? q(new GZIPInputStream(bufferedSourceBuffer.inputStream()), str2) : q(bufferedSourceBuffer.inputStream(), str2);
        } catch (IOException e11) {
            return new q0<>((Throwable) e11);
        }
    }

    public static LottieTask<h> p(final InputStream inputStream, @Nullable final String str) {
        return j(str, new Callable() { // from class: com.airbnb.lottie.l
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return r.q(inputStream, str);
            }
        }, new Runnable() { // from class: com.airbnb.lottie.m
            @Override // java.lang.Runnable
            public final void run() {
                g7.l.c(inputStream);
            }
        });
    }

    public static q0<h> q(InputStream inputStream, @Nullable String str) {
        return r(inputStream, str, true);
    }

    public static q0<h> r(InputStream inputStream, @Nullable String str, boolean z11) {
        return s(JsonReader.m(Okio.buffer(Okio.source(inputStream))), str, z11);
    }

    public static q0<h> s(JsonReader jsonReader, @Nullable String str, boolean z11) {
        return t(jsonReader, str, z11);
    }

    public static q0<h> t(JsonReader jsonReader, @Nullable String str, boolean z11) {
        try {
            h hVarA = str == null ? null : a7.f.b().a(str);
            if (hVarA != null) {
                return new q0<>(hVarA);
            }
            h hVarA2 = f7.w.a(jsonReader);
            if (str != null) {
                a7.f.b().c(str, hVarA2);
            }
            return new q0<>(hVarA2);
        } catch (Exception e11) {
            return new q0<>((Throwable) e11);
        } finally {
            if (z11) {
                g7.l.c(jsonReader);
            }
        }
    }

    public static LottieTask<h> u(Context context, int i11) {
        return v(context, i11, T(context, i11));
    }

    public static LottieTask<h> v(Context context, final int i11, @Nullable final String str) {
        final WeakReference weakReference = new WeakReference(context);
        final Context applicationContext = context.getApplicationContext();
        return j(str, new Callable() { // from class: com.airbnb.lottie.q
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return r.N(weakReference, applicationContext, i11, str);
            }
        }, null);
    }

    public static q0<h> w(Context context, int i11) {
        return x(context, i11, T(context, i11));
    }

    public static q0<h> x(Context context, int i11, @Nullable String str) {
        h hVarA = str == null ? null : a7.f.b().a(str);
        if (hVarA != null) {
            return new q0<>(hVarA);
        }
        try {
            BufferedSource bufferedSourceBuffer = Okio.buffer(Okio.source(context.getResources().openRawResource(i11)));
            if (H(bufferedSourceBuffer).booleanValue()) {
                return C(context, new ZipInputStream(bufferedSourceBuffer.inputStream()), str);
            }
            if (!F(bufferedSourceBuffer).booleanValue()) {
                return q(bufferedSourceBuffer.inputStream(), str);
            }
            try {
                return q(new GZIPInputStream(bufferedSourceBuffer.inputStream()), str);
            } catch (IOException e11) {
                return new q0<>((Throwable) e11);
            }
        } catch (Resources.NotFoundException e12) {
            return new q0<>((Throwable) e12);
        }
    }

    public static LottieTask<h> y(Context context, String str) {
        return z(context, str, "url_" + str);
    }

    public static LottieTask<h> z(final Context context, final String str, @Nullable final String str2) {
        return j(str2, new Callable() { // from class: com.airbnb.lottie.k
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return r.O(context, str, str2);
            }
        }, null);
    }
}
