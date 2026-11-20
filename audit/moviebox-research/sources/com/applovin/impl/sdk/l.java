package com.applovin.impl.sdk;

import android.content.Context;
import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.applovin.impl.ca;
import com.applovin.impl.jn;
import com.applovin.impl.la;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sj;
import com.applovin.impl.tm;
import com.applovin.impl.u2;
import com.applovin.impl.yl;
import com.applovin.impl.yp;
import com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final j f22647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final n f22648c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f22646a = "FileManager";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f22649d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Set f22650e = new HashSet();

    public l(j jVar) {
        this.f22647b = jVar;
        this.f22648c = jVar.J();
    }

    private long a() {
        long jLongValue = ((Long) this.f22647b.a(sj.W0)).longValue();
        if (jLongValue >= 0) {
            return jLongValue;
        }
        return -1L;
    }

    private long a(long j11) {
        return j11 / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
    }

    private long a(Context context) {
        long jA = a();
        boolean z11 = jA != -1;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        List listC = this.f22647b.c(sj.f22919b1);
        long length = 0;
        for (File file : c(context)) {
            if (z11 && !listC.contains(file.getName()) && !b(file) && seconds - TimeUnit.MILLISECONDS.toSeconds(file.lastModified()) > jA) {
                if (n.a()) {
                    this.f22648c.a("FileManager", "File " + file.getName() + " has expired, removing...");
                }
                if (f(file)) {
                    this.f22647b.D().c(ca.f18153j);
                }
            }
            length += file.length();
        }
        return length;
    }

    private File a(String str, boolean z11, Context context) {
        if (!StringUtils.isValidString(str)) {
            if (n.a()) {
                this.f22648c.a("FileManager", "Nothing to look up, skipping...");
            }
            return null;
        }
        if (n.a()) {
            this.f22648c.a("FileManager", "Looking up cached resource: " + str);
        }
        String strReplace = str.contains(RewardPlus.ICON) ? str.replace("/", "_").replace(InstructionFileId.DOT, "_") : str;
        File fileD = d(context);
        File file = new File(fileD, strReplace);
        if (yp.a(sj.f22974i1, this.f22647b)) {
            boolean z12 = file.length() == 0;
            boolean zEquals = str.equals(".nomedia");
            if (file.exists() && z12 && !zEquals) {
                this.f22647b.E().a(la.K, "removeEmptyCachedResource", (Map) CollectionUtils.hashMap(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, file.getAbsolutePath()));
                f(file);
            }
        }
        if (z11) {
            try {
                fileD.mkdirs();
            } catch (Throwable th2) {
                if (n.a()) {
                    this.f22648c.a("FileManager", "Unable to make cache directory at " + fileD, th2);
                }
                this.f22647b.E().a("FileManager", "createCacheDir", th2);
                return null;
            }
        }
        return file;
    }

    private void a(long j11, Context context) {
        long jIntValue = ((Integer) this.f22647b.a(sj.X0)).intValue();
        if (jIntValue == -1) {
            if (n.a()) {
                this.f22648c.a("FileManager", "Cache has no maximum size set; skipping drop...");
            }
        } else if (a(j11) <= jIntValue) {
            if (n.a()) {
                this.f22648c.a("FileManager", "Cache is present but under size limit; not dropping...");
            }
        } else {
            if (n.a()) {
                this.f22648c.a("FileManager", "Cache has exceeded maximum size; dropping...");
            }
            Iterator it = c(context).iterator();
            while (it.hasNext()) {
                f((File) it.next());
            }
            this.f22647b.D().c(ca.f18154k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.applovin.impl.sdk.ad.b bVar, Context context) {
        ArrayList arrayList = new ArrayList(bVar.i());
        arrayList.add(bVar.s0());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            f(a(((Uri) it.next()).getLastPathSegment(), context));
        }
    }

    private boolean a(File file, String str, List list, boolean z11, u2 u2Var) throws Throwable {
        InputStream inputStreamA;
        if (a(file)) {
            if (n.a()) {
                this.f22648c.a("FileManager", "File exists for " + str);
            }
            if (u2Var == null) {
                return true;
            }
            u2Var.a(file.length());
            return true;
        }
        if (((Boolean) this.f22647b.a(sj.F)).booleanValue()) {
            try {
                InputStream inputStreamA2 = a(str, list, z11, u2Var);
                try {
                    boolean zA = a(inputStreamA2, file);
                    if (inputStreamA2 != null) {
                        inputStreamA2.close();
                    }
                    return zA;
                } catch (Throwable th2) {
                    if (inputStreamA2 != null) {
                        try {
                            inputStreamA2.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                this.f22648c.a("FileManager", th4);
                this.f22647b.E().a("FileManager", "loadAndCacheResource", th4);
                return false;
            }
        }
        try {
            inputStreamA = a(str, list, z11, u2Var);
            try {
                boolean zA2 = a(inputStreamA, file);
                yp.a(inputStreamA, this.f22647b);
                return zA2;
            } catch (Throwable th5) {
                th = th5;
                yp.a(inputStreamA, this.f22647b);
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            inputStreamA = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(com.applovin.impl.sdk.ad.b bVar, Context context) {
        f(a(bVar.s0().getLastPathSegment(), context));
    }

    private boolean b(File file) {
        boolean zContains;
        String absolutePath = file.getAbsolutePath();
        synchronized (this.f22649d) {
            zContains = this.f22650e.contains(absolutePath);
        }
        return zContains;
    }

    private List c(Context context) {
        File[] fileArrListFiles;
        File fileD = d(context);
        return (!fileD.isDirectory() || (fileArrListFiles = fileD.listFiles()) == null) ? Collections.emptyList() : Arrays.asList(fileArrListFiles);
    }

    private void c(File file) {
        String absolutePath = file.getAbsolutePath();
        synchronized (this.f22649d) {
            boolean zAdd = this.f22650e.add(absolutePath);
            while (!zAdd) {
                try {
                    this.f22649d.wait();
                    zAdd = this.f22650e.add(absolutePath);
                } catch (InterruptedException e11) {
                    if (n.a()) {
                        this.f22648c.a("FileManager", "Lock '" + absolutePath + "' interrupted", e11);
                    }
                    throw new RuntimeException(e11);
                }
            }
        }
    }

    private File d(Context context) {
        return new File(context.getFilesDir(), CampaignEx.JSON_KEY_AD_AL);
    }

    private boolean d(File file) {
        if (file == null) {
            return false;
        }
        String absolutePath = file.getAbsolutePath();
        synchronized (this.f22649d) {
            try {
                if (this.f22650e.contains(absolutePath)) {
                    return false;
                }
                c(file);
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private boolean f(File file) {
        if (n.a()) {
            this.f22648c.a("FileManager", "Removing file " + file.getName() + " from filesystem...");
        }
        try {
            c(file);
            boolean zDelete = file.delete();
            if (!zDelete) {
                this.f22647b.E().a(la.K, "removeFile", (Map) CollectionUtils.hashMap(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, file.getAbsolutePath()));
            }
            g(file);
            return zDelete;
        } catch (Throwable th2) {
            try {
                if (n.a()) {
                    this.f22648c.a("FileManager", "Failed to remove file " + file.getName() + " from filesystem!", th2);
                }
                this.f22647b.E().a("FileManager", "removeFile", th2);
                return false;
            } finally {
                g(file);
            }
        }
    }

    private void g(File file) {
        String absolutePath = file.getAbsolutePath();
        synchronized (this.f22649d) {
            try {
                if (!this.f22650e.remove(absolutePath)) {
                    this.f22647b.E().a(la.K, "unlockFile", (Map) CollectionUtils.hashMap(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, absolutePath));
                }
                this.f22649d.notifyAll();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public File a(String str, Context context) {
        return a(str, true, context);
    }

    public InputStream a(String str, List list, boolean z11, u2 u2Var) {
        HttpURLConnection httpURLConnection;
        if (z11 && !yp.a(str, list)) {
            if (n.a()) {
                this.f22648c.a("FileManager", "Domain is not whitelisted, skipping precache for url: " + str);
            }
            return null;
        }
        if (((Boolean) this.f22647b.a(sj.f22952f3)).booleanValue() && !str.contains(AgentPageJsBridge.HTTPS)) {
            if (n.a()) {
                this.f22648c.k("FileManager", "Plaintext HTTP operation requested; upgrading to HTTPS due to universal SSL setting...");
            }
            str = str.replace("http://", AgentPageJsBridge.HTTPS);
        }
        if (n.a()) {
            this.f22648c.a("FileManager", "Loading " + str + "...");
        }
        try {
            httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
            try {
                httpURLConnection.setConnectTimeout(((Integer) this.f22647b.a(sj.f22937d3)).intValue());
                httpURLConnection.setReadTimeout(((Integer) this.f22647b.a(sj.f22944e3)).intValue());
                httpURLConnection.setDefaultUseCaches(true);
                httpURLConnection.setUseCaches(true);
                httpURLConnection.setAllowUserInteraction(false);
                httpURLConnection.setInstanceFollowRedirects(true);
                int responseCode = httpURLConnection.getResponseCode();
                u2Var.a(responseCode);
                this.f22647b.E().a("loadResource", str, responseCode);
                if (responseCode >= 200 && responseCode < 300) {
                    if (n.a()) {
                        this.f22648c.a("FileManager", "Opened stream to resource " + str);
                    }
                    InputStream inputStream = httpURLConnection.getInputStream();
                    if (((Boolean) this.f22647b.a(sj.C3)).booleanValue()) {
                        yp.a(httpURLConnection, this.f22647b);
                    }
                    return inputStream;
                }
                if (((Boolean) this.f22647b.a(sj.C3)).booleanValue()) {
                    yp.a(httpURLConnection, this.f22647b);
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                try {
                    if (n.a()) {
                        this.f22648c.a("FileManager", "Error loading " + str, th);
                    }
                    this.f22647b.E().a("FileManager", "loadResource", th, CollectionUtils.hashMap("url", str));
                    u2Var.a(th);
                    return null;
                } finally {
                    if (((Boolean) this.f22647b.a(sj.C3)).booleanValue()) {
                        yp.a(httpURLConnection, this.f22647b);
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
        }
    }

    public String a(Context context, String str, String str2, List list, boolean z11, u2 u2Var) {
        return a(context, str, str2, list, z11, false, u2Var);
    }

    public String a(Context context, String str, String str2, List list, boolean z11, boolean z12, u2 u2Var) {
        if (!StringUtils.isValidString(str)) {
            if (n.a()) {
                this.f22648c.a("FileManager", "Nothing to cache, skipping...");
            }
            this.f22647b.E().a(la.K, "cacheResource");
            return null;
        }
        String strA = yp.a(Uri.parse(str), str2, this.f22647b);
        File fileA = a(strA, context);
        if (!a(fileA, str, list, z11, u2Var)) {
            return null;
        }
        if (n.a()) {
            this.f22648c.a("FileManager", "Caching succeeded for file " + strA);
        }
        return z12 ? Uri.fromFile(fileA).toString() : strA;
    }

    public String a(InputStream inputStream) throws IOException {
        if (((Boolean) this.f22647b.a(sj.F)).booleanValue()) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i11 = inputStream.read(bArr, 0, 8192);
                        if (i11 < 0) {
                            String string = byteArrayOutputStream.toString("UTF-8");
                            byteArrayOutputStream.close();
                            return string;
                        }
                        byteArrayOutputStream.write(bArr, 0, i11);
                        this.f22648c.a("FileManager", th);
                        this.f22647b.E().a("FileManager", "readInputStreamAsString", th);
                        return null;
                    }
                } catch (Throwable th2) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                this.f22648c.a("FileManager", th4);
                this.f22647b.E().a("FileManager", "readInputStreamAsString", th4);
                return null;
            }
        }
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        byte[] bArr2 = new byte[8192];
        while (true) {
            int i12 = inputStream.read(bArr2, 0, 8192);
            if (i12 < 0) {
                return byteArrayOutputStream2.toString("UTF-8");
            }
            try {
                byteArrayOutputStream2.write(bArr2, 0, i12);
            } catch (Throwable th5) {
                yp.a(byteArrayOutputStream2, this.f22647b);
                this.f22647b.E().a("FileManager", "readInputStreamAsString", th5);
                return null;
            }
        }
    }

    public void a(File file, String str) {
        if (n.a()) {
            this.f22648c.a("FileManager", "Removing file " + file.getName() + " for source " + str + InstructionFileId.DOT);
        }
        try {
            if (file.delete()) {
                return;
            }
            this.f22647b.E().a(la.K, str, (Map) CollectionUtils.hashMap(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, file.getAbsolutePath()));
        } catch (Throwable th2) {
            if (n.a()) {
                this.f22648c.a("FileManager", "Failed to remove file " + file.getName() + " from filesystem after failed operation.", th2);
            }
            this.f22647b.E().a("FileManager", str, th2);
        }
    }

    public boolean a(File file) {
        if (!yp.a(sj.f22998l1, this.f22647b)) {
            return (file == null || !file.exists() || file.isDirectory()) ? false : true;
        }
        if (file == null) {
            return false;
        }
        yp.a();
        c(file);
        boolean z11 = file.exists() && !file.isDirectory();
        g(file);
        return z11;
    }

    public boolean a(File file, String str, List list, u2 u2Var) {
        return a(file, str, list, true, u2Var);
    }

    public boolean a(InputStream inputStream, File file) {
        if (file == null) {
            return false;
        }
        if (n.a()) {
            this.f22648c.a("FileManager", "Caching " + file.getAbsolutePath() + "...");
        }
        if (!a(inputStream, file, false)) {
            if (n.a()) {
                this.f22648c.b("FileManager", "Unable to cache " + file.getAbsolutePath());
            }
            return false;
        }
        if (!n.a()) {
            return true;
        }
        this.f22648c.a("FileManager", "Caching completed for " + file);
        return true;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x00ec */
    /* JADX WARN: Code duplicated, block: B:106:0x01c7 A[Catch: all -> 0x01cd, TRY_LEAVE, TryCatch #5 {all -> 0x01cd, blocks: (B:104:0x01c1, B:106:0x01c7), top: B:129:0x01c1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(InputStream inputStream, File file, boolean z11) throws Throwable {
        boolean z12;
        boolean z13;
        boolean z14;
        Throwable th2;
        if (n.a()) {
            this.f22648c.a("FileManager", "Writing resource to filesystem: " + file.getName());
        }
        boolean z15 = true;
        if (((Boolean) this.f22647b.a(sj.F)).booleanValue()) {
            c(file);
            if (yp.a(sj.f23006m1, this.f22647b) && !z11 && file.exists()) {
                if (n.a()) {
                    this.f22648c.a("FileManager", "Overwrite not allowed for local resource: " + file.getName() + " - aborting write.");
                }
                this.f22647b.E().a(la.K, "cacheResourceOverwriteAttempted", (Map) CollectionUtils.hashMap(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, file.getAbsolutePath()));
                return true;
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                int i11 = 8192;
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i12 = inputStream.read(bArr, 0, i11);
                        if (i12 < 0) {
                            fileOutputStream.close();
                            g(file);
                            return true;
                        }
                        try {
                            fileOutputStream.write(bArr, 0, i12);
                            i11 = 8192;
                        } catch (Throwable th3) {
                            if (n.a()) {
                                this.f22648c.a("FileManager", "Failed to write next buffer to file", th3);
                            }
                            try {
                                this.f22647b.E().a("FileManager", "writeResourceStream", th3);
                                try {
                                    fileOutputStream.close();
                                    a(file, "removeFileAfterCacheFail");
                                    g(file);
                                    return false;
                                } catch (Throwable th4) {
                                    th = th4;
                                    z14 = true;
                                }
                            } catch (Throwable th5) {
                                th2 = th5;
                                z14 = true;
                                try {
                                    fileOutputStream.close();
                                    throw th2;
                                } catch (Throwable th6) {
                                    th2.addSuppressed(th6);
                                    throw th2;
                                }
                            }
                        }
                        try {
                            if (n.a()) {
                                this.f22648c.a("FileManager", "Unknown failure to write file.", th);
                            }
                            this.f22648c.a("FileManager", th);
                            try {
                                this.f22647b.E().a("FileManager", "writeResource", th);
                                a(file, "removeFileAfterCacheFail");
                                g(file);
                                return false;
                            } catch (Throwable th7) {
                                th = th7;
                                if (z15) {
                                    a(file, "removeFileAfterCacheFail");
                                }
                                g(file);
                                throw th;
                            }
                        } catch (Throwable th8) {
                            th = th8;
                            z15 = z14;
                        }
                    }
                } catch (Throwable th9) {
                    th2 = th9;
                    z14 = false;
                    fileOutputStream.close();
                    throw th2;
                }
            } catch (Throwable th10) {
                th = th10;
                z14 = false;
            }
        } else {
            FileOutputStream fileOutputStream2 = null;
            try {
                c(file);
                if (yp.a(sj.f23006m1, this.f22647b) && !z11 && file.exists()) {
                    if (n.a()) {
                        this.f22648c.a("FileManager", "Overwrite not allowed for local resource: " + file.getName() + " - aborting write.");
                    }
                    this.f22647b.E().a(la.K, "cacheResourceOverwriteAttempted", (Map) CollectionUtils.hashMap(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, file.getAbsolutePath()));
                    yp.a((Closeable) null, this.f22647b);
                    g(file);
                    return true;
                }
                FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                try {
                    byte[] bArr2 = new byte[8192];
                    while (true) {
                        int i13 = inputStream.read(bArr2, 0, 8192);
                        if (i13 < 0) {
                            yp.a(fileOutputStream3, this.f22647b);
                            g(file);
                            return true;
                        }
                        try {
                            fileOutputStream3.write(bArr2, 0, i13);
                        } catch (Throwable th11) {
                            if (n.a()) {
                                this.f22648c.a("FileManager", "Failed to write next buffer to file", th11);
                            }
                            try {
                                this.f22647b.E().a("FileManager", "writeResourceStream", th11);
                                yp.a(fileOutputStream3, this.f22647b);
                                a(file, "removeFileAfterCacheFail");
                                g(file);
                                return false;
                            } catch (Throwable th12) {
                                th = th12;
                                z12 = true;
                                fileOutputStream2 = fileOutputStream3;
                                try {
                                    if (n.a()) {
                                        this.f22648c.a("FileManager", "Unknown failure to write file.", th);
                                    }
                                    try {
                                        this.f22647b.E().a("FileManager", "writeResource", th);
                                        yp.a(fileOutputStream2, this.f22647b);
                                        a(file, "removeFileAfterCacheFail");
                                        g(file);
                                        return false;
                                    } catch (Throwable th13) {
                                        th = th13;
                                        z13 = true;
                                        yp.a(fileOutputStream2, this.f22647b);
                                        if (z13) {
                                            a(file, "removeFileAfterCacheFail");
                                        }
                                        g(file);
                                        throw th;
                                    }
                                } catch (Throwable th14) {
                                    th = th14;
                                    z13 = z12;
                                }
                            }
                        }
                    }
                } catch (Throwable th15) {
                    th = th15;
                    z12 = false;
                    fileOutputStream2 = fileOutputStream3;
                    if (n.a()) {
                        this.f22648c.a("FileManager", "Unknown failure to write file.", th);
                    }
                    this.f22647b.E().a("FileManager", "writeResource", th);
                    yp.a(fileOutputStream2, this.f22647b);
                    a(file, "removeFileAfterCacheFail");
                    g(file);
                    return false;
                }
            } catch (Throwable th16) {
                th = th16;
                z12 = false;
            }
        }
    }

    public void b(Context context) {
        if (this.f22647b.x0()) {
            if (n.a()) {
                this.f22648c.a("FileManager", "Compacting cache...");
            }
            a(a(context), context);
        }
    }

    public boolean b(String str, Context context) {
        return a(a(str, false, context));
    }

    public void c(final com.applovin.impl.sdk.ad.b bVar, final Context context) {
        this.f22647b.j0().a((yl) new jn(this.f22647b, false, "removeCachedResourcesForAd", new Runnable() { // from class: com.applovin.impl.sdk.h1
            @Override // java.lang.Runnable
            public final void run() {
                this.f22544a.a(bVar, context);
            }
        }), tm.b.CACHING);
    }

    public boolean c(String str, Context context) {
        boolean z11 = false;
        File fileA = a(str, false, context);
        if (!d(fileA)) {
            return false;
        }
        if (fileA.exists() && !fileA.isDirectory()) {
            z11 = true;
        }
        g(fileA);
        return z11;
    }

    public void d(final com.applovin.impl.sdk.ad.b bVar, final Context context) {
        this.f22647b.j0().a((yl) new jn(this.f22647b, false, "removeCachedVideoResourceForAd", new Runnable() { // from class: com.applovin.impl.sdk.g1
            @Override // java.lang.Runnable
            public final void run() {
                this.f22534a.b(bVar, context);
            }
        }), tm.b.CACHING);
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [boolean, java.io.Closeable] */
    public String e(File file) throws Throwable {
        Throwable th2;
        InputStream fileInputStream;
        IOException e11;
        FileNotFoundException e12;
        if (file == null) {
            return null;
        }
        if (n.a()) {
            this.f22648c.a("FileManager", "Reading resource from filesystem: " + file.getName());
        }
        ?? BooleanValue = ((Boolean) this.f22647b.a(sj.F)).booleanValue();
        boolean z11 = false;
        boolean z12 = true;
        try {
            try {
                try {
                    try {
                        if (BooleanValue != 0) {
                            try {
                                try {
                                    FileInputStream fileInputStream2 = new FileInputStream(file);
                                    try {
                                        c(file);
                                        String strA = a(fileInputStream2);
                                        z11 = strA == null;
                                        fileInputStream2.close();
                                        if (z11 && ((Boolean) this.f22647b.a(sj.f22958g1)).booleanValue()) {
                                            a(file, "removeFileAfterReadFail");
                                        }
                                        g(file);
                                        return strA;
                                    } catch (Throwable th3) {
                                        try {
                                            fileInputStream2.close();
                                        } catch (Throwable th4) {
                                            th3.addSuppressed(th4);
                                        }
                                        throw th3;
                                    }
                                } catch (FileNotFoundException e13) {
                                    if (n.a()) {
                                        this.f22648c.d("FileManager", "File not found. " + e13);
                                    }
                                    this.f22648c.a("FileManager", e13);
                                    this.f22647b.E().a("FileManager", "readFileNotFound", e13);
                                    if (0 != 0 && ((Boolean) this.f22647b.a(sj.f22958g1)).booleanValue()) {
                                        a(file, "removeFileAfterReadFail");
                                    }
                                    g(file);
                                    return null;
                                }
                            } catch (IOException e14) {
                                if (n.a()) {
                                    this.f22648c.a("FileManager", "Failed to read file: " + file.getName() + e14);
                                }
                                this.f22648c.a("FileManager", e14);
                                this.f22647b.E().a("FileManager", "readFileIO", e14);
                                if (((Boolean) this.f22647b.a(sj.f22958g1)).booleanValue()) {
                                    a(file, "removeFileAfterReadFail");
                                }
                                g(file);
                                return null;
                            } catch (Throwable th5) {
                                if (n.a()) {
                                    this.f22648c.a("FileManager", "Unknown failure to read file.", th5);
                                }
                                this.f22648c.a("FileManager", th5);
                                this.f22647b.E().a("FileManager", "readFile", th5);
                                if (((Boolean) this.f22647b.a(sj.f22958g1)).booleanValue()) {
                                    a(file, "removeFileAfterReadFail");
                                }
                                g(file);
                                return null;
                            }
                        }
                        try {
                            c(file);
                            fileInputStream = new FileInputStream(file);
                            try {
                                String strA2 = a(fileInputStream);
                                z11 = strA2 == null;
                                yp.a(fileInputStream, this.f22647b);
                                if (z11 && ((Boolean) this.f22647b.a(sj.f22958g1)).booleanValue()) {
                                    a(file, "removeFileAfterReadFail");
                                }
                                g(file);
                                return strA2;
                            } catch (FileNotFoundException e15) {
                                e12 = e15;
                                if (n.a()) {
                                    this.f22648c.d("FileManager", "File not found. " + e12);
                                }
                                this.f22647b.E().a("FileManager", "readFileNotFound", e12);
                                yp.a(fileInputStream, this.f22647b);
                                g(file);
                                return null;
                            } catch (IOException e16) {
                                e11 = e16;
                                if (n.a()) {
                                    this.f22648c.a("FileManager", "Failed to read file: " + file.getName() + e11);
                                }
                                this.f22647b.E().a("FileManager", "readFileIO", e11);
                                yp.a(fileInputStream, this.f22647b);
                                if (((Boolean) this.f22647b.a(sj.f22958g1)).booleanValue()) {
                                    a(file, "removeFileAfterReadFail");
                                }
                                g(file);
                                return null;
                            } catch (Throwable th6) {
                                th2 = th6;
                                if (n.a()) {
                                    this.f22648c.a("FileManager", "Unknown failure to read file.", th2);
                                }
                                this.f22647b.E().a("FileManager", "readFile", th2);
                                yp.a(fileInputStream, this.f22647b);
                                if (((Boolean) this.f22647b.a(sj.f22958g1)).booleanValue()) {
                                    a(file, "removeFileAfterReadFail");
                                }
                                g(file);
                                return null;
                            }
                        } catch (FileNotFoundException e17) {
                            e12 = e17;
                            fileInputStream = null;
                        } catch (IOException e18) {
                            e11 = e18;
                            fileInputStream = null;
                        } catch (Throwable th7) {
                            th2 = th7;
                            fileInputStream = null;
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        yp.a((Closeable) BooleanValue, this.f22647b);
                        if (z11 && ((Boolean) this.f22647b.a(sj.f22958g1)).booleanValue()) {
                            a(file, "removeFileAfterReadFail");
                        }
                        g(file);
                        throw th;
                    }
                } catch (Throwable th9) {
                    th = th9;
                    z11 = true;
                    yp.a((Closeable) BooleanValue, this.f22647b);
                    if (z11) {
                        a(file, "removeFileAfterReadFail");
                    }
                    g(file);
                    throw th;
                }
            } catch (Throwable th10) {
                th = th10;
                z12 = false;
                if (z12 && ((Boolean) this.f22647b.a(sj.f22958g1)).booleanValue()) {
                    a(file, "removeFileAfterReadFail");
                }
                g(file);
                throw th;
            }
        } catch (Throwable th11) {
            th = th11;
            if (z12) {
                a(file, "removeFileAfterReadFail");
            }
            g(file);
            throw th;
        }
    }

    public void e(Context context) {
        try {
            a(".nomedia", context);
            File file = new File(d(context), ".nomedia");
            if (a(file)) {
                return;
            }
            if (n.a()) {
                this.f22648c.a("FileManager", "Creating .nomedia file at " + file.getAbsolutePath());
            }
            if (file.createNewFile()) {
                return;
            }
            if (n.a()) {
                this.f22648c.b("FileManager", "Failed to create .nomedia file");
            }
            this.f22647b.E().a(la.K, "createNoMediaFile");
        } catch (IOException e11) {
            if (n.a()) {
                this.f22648c.a("FileManager", "Failed to create .nomedia file", e11);
            }
        }
    }
}
