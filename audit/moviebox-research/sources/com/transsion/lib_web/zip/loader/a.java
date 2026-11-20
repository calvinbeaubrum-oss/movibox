package com.transsion.lib_web.zip.loader;

import android.content.Context;
import android.webkit.WebResourceResponse;
import com.blankj.utilcode.util.k;
import hu.h;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.l;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class a implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f53082b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f53083c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashSet<String> f53084d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f53085e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f53086f;

    public a(Context context, String originUrl) {
        Intrinsics.g(context, "context");
        Intrinsics.g(originUrl, "originUrl");
        this.f53082b = context;
        this.f53083c = originUrl;
        this.f53084d = new HashSet<>();
    }

    /* JADX WARN: Code duplicated, block: B:35:0x009d  */
    @Override // com.transsion.lib_web.zip.loader.c
    public WebResourceResponse a(String str, Map<String, String> headers) {
        Object next;
        String absolutePath;
        File fileG;
        Object next2;
        Intrinsics.g(headers, "headers");
        if (str != null && !Intrinsics.b(str, "yy://__QUEUE_MESSAGE__")) {
            if (f(str)) {
                try {
                    File[] fileArrListFiles = com.transsion.lib_web.zip.b.f53072a.d(this.f53082b).listFiles();
                    if (fileArrListFiles != null) {
                        ArrayList arrayList = new ArrayList();
                        for (File file : fileArrListFiles) {
                            String name = file.getName();
                            Intrinsics.f(name, "it.name");
                            String strB = k.b(b.a(this.f53083c));
                            Intrinsics.f(strB, "encryptMD5ToString(originUrl.getBaseUrl())");
                            if (l.L(name, strB, false, 2, null)) {
                                arrayList.add(file);
                            }
                        }
                        Iterator it = arrayList.iterator();
                        if (it.hasNext()) {
                            next2 = it.next();
                            if (it.hasNext()) {
                                long jLastModified = ((File) next2).lastModified();
                                do {
                                    Object next3 = it.next();
                                    long jLastModified2 = ((File) next3).lastModified();
                                    if (jLastModified < jLastModified2) {
                                        next2 = next3;
                                        jLastModified = jLastModified2;
                                    }
                                } while (it.hasNext());
                            }
                        } else {
                            next2 = null;
                        }
                        File file2 = (File) next2;
                        if (file2 != null) {
                            h();
                            fileG = g(file2, "index.html");
                        } else {
                            fileG = null;
                        }
                    } else {
                        fileG = null;
                    }
                } catch (Exception unused) {
                }
                absolutePath = fileG != null ? fileG.getAbsolutePath() : null;
                if (absolutePath != null) {
                    absolutePath.length();
                }
            } else {
                String name2 = new File(str).getName();
                try {
                    Iterator<T> it2 = this.f53084d.iterator();
                    do {
                        if (!it2.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it2.next();
                    } while (!new File(((String) next) + name2).exists());
                    String str2 = (String) next;
                    absolutePath = str2 != null ? str2 + name2 : null;
                } catch (Exception unused2) {
                }
            }
            if (absolutePath == null) {
                return null;
            }
            try {
                String strB2 = ku.b.f69642a.b(absolutePath);
                FileInputStream fileInputStream = new FileInputStream(new File(absolutePath));
                h.f66795a.a(b() + " --> interceptRequest() --> local file  -->  \nurl = " + str + "  \nnewPath = " + absolutePath + "  \nmimeType = " + strB2);
                return new WebResourceResponse(strB2, "", 200, "OK", c.f53087a.a(), fileInputStream);
            } catch (FileNotFoundException e11) {
                e11.printStackTrace();
            }
        }
        return null;
    }

    public final String b() {
        String simpleName = a.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final void c(File file, HashSet<String> hashSet) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            ArrayList<File> arrayList = new ArrayList();
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    arrayList.add(file2);
                }
            }
            for (File it : arrayList) {
                hashSet.add(it.getAbsolutePath() + File.separator);
                Intrinsics.f(it, "it");
                c(it, hashSet);
            }
        }
    }

    public final boolean d() {
        return this.f53085e;
    }

    public final String e() {
        return this.f53086f;
    }

    public final boolean f(String str) {
        if (str == null) {
            return false;
        }
        try {
            return Intrinsics.b(this.f53083c, str) || (StringsKt__StringsKt.Q(str, "?", false, 2, null) && Intrinsics.b(StringsKt__StringsKt.E0(str, new String[]{"?"}, false, 0, 6, null).get(0), this.f53083c));
        } catch (Exception unused) {
            return false;
        }
    }

    public final File g(File file, String str) {
        File[] fileArrListFiles;
        if (file.exists() && str != null && str.length() != 0 && (fileArrListFiles = file.listFiles()) != null) {
            for (File it : fileArrListFiles) {
                if (it.isDirectory()) {
                    Intrinsics.f(it, "it");
                    it = g(it, str);
                } else if (!Intrinsics.b(it.getName(), str)) {
                    it = null;
                }
                if (it != null) {
                    return it;
                }
            }
        }
        return null;
    }

    public final void h() {
        c(com.transsion.lib_web.zip.b.f53072a.d(this.f53082b), this.f53084d);
    }
}
