package com.bykv.vk.openvk.sc.sc.pFF.sc.sc;

import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.openvk.sc.sc.sc.zY.zY;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import o8.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc implements w8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f26057a = "video_reward_full";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f26058b = "video_brand";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f26059c = "video_splash";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f26060d = "video_default";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f26061e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f26062f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f26063g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f26064h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f26065i = null;

    public static void d(File[] fileArr, int i11, Set<String> set) {
        if (i11 >= 0 && fileArr != null) {
            try {
                if (fileArr.length > i11) {
                    List listAsList = Arrays.asList(fileArr);
                    Collections.sort(listAsList, new Comparator<File>() { // from class: com.bykv.vk.openvk.sc.sc.pFF.sc.sc.sc.1
                        @Override // java.util.Comparator
                        /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
                        public int compare(File file, File file2) {
                            long jLastModified = file2.lastModified() - file.lastModified();
                            if (jLastModified == 0) {
                                return 0;
                            }
                            return jLastModified < 0 ? -1 : 1;
                        }
                    });
                    while (i11 < listAsList.size()) {
                        File file = (File) listAsList.get(i11);
                        if (set != null && !set.contains(file.getAbsolutePath())) {
                            ((File) listAsList.get(i11)).delete();
                        }
                        i11++;
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // w8.a
    public synchronized void We() {
        try {
            List<w8.b> listB = b();
            if (Build.VERSION.SDK_INT >= 23) {
                Set<String> setC = null;
                for (w8.b bVar : listB) {
                    File[] fileArrB = bVar.b();
                    if (fileArrB != null && fileArrB.length >= bVar.a()) {
                        if (setC == null) {
                            setC = c();
                        }
                        int iA = bVar.a() - 2;
                        if (iA < 0) {
                            iA = 0;
                        }
                        d(bVar.b(), iA, setC);
                    }
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public String a() {
        if (this.f26063g == null) {
            this.f26063g = this.f26061e + File.separator + this.f26058b;
            File file = new File(this.f26063g);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.f26063g;
    }

    public final List<w8.b> b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new w8.b(new File(sc()).listFiles(), j8.a.h()));
        arrayList.add(new w8.b(new File(pFF()).listFiles(), j8.a.c()));
        arrayList.add(new w8.b(new File(a()).listFiles(), j8.a.b()));
        arrayList.add(new w8.b(new File(zY()).listFiles(), j8.a.a()));
        return arrayList;
    }

    public final Set<String> c() {
        HashSet hashSet = new HashSet();
        for (n8.a aVar : n8.a.f71768f.values()) {
            if (aVar != null && aVar.a() != null) {
                zY zYVarA = aVar.a();
                hashSet.add(k8.a.a(zYVarA.pFF(), zYVarA.SR()).getAbsolutePath());
                hashSet.add(k8.a.d(zYVarA.pFF(), zYVarA.SR()).getAbsolutePath());
            }
        }
        for (o8.a aVar2 : c.f72391a.values()) {
            if (aVar2 != null && aVar2.i() != null) {
                zY zYVarI = aVar2.i();
                hashSet.add(k8.a.a(zYVarI.pFF(), zYVarI.SR()).getAbsolutePath());
                hashSet.add(k8.a.d(zYVarI.pFF(), zYVarI.SR()).getAbsolutePath());
            }
        }
        return hashSet;
    }

    @Override // w8.a
    public long pFF(zY zYVar) {
        if (TextUtils.isEmpty(zYVar.pFF()) || TextUtils.isEmpty(zYVar.SR())) {
            return 0L;
        }
        return k8.a.b(zYVar.pFF(), zYVar.SR());
    }

    @Override // w8.a
    public String pFF() {
        if (this.f26064h == null) {
            this.f26064h = this.f26061e + File.separator + this.f26059c;
            File file = new File(this.f26064h);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.f26064h;
    }

    @Override // w8.a
    public String sc() {
        if (this.f26062f == null) {
            this.f26062f = this.f26061e + File.separator + this.f26057a;
            File file = new File(this.f26062f);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.f26062f;
    }

    @Override // w8.a
    public void sc(String str) {
        this.f26061e = str;
    }

    @Override // w8.a
    public boolean sc(zY zYVar) {
        if (TextUtils.isEmpty(zYVar.pFF()) || TextUtils.isEmpty(zYVar.SR())) {
            return false;
        }
        return new File(zYVar.pFF(), zYVar.SR()).exists();
    }

    @Override // w8.a
    public String zY() {
        if (this.f26065i == null) {
            this.f26065i = this.f26061e + File.separator + this.f26060d;
            File file = new File(this.f26065i);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.f26065i;
    }
}
