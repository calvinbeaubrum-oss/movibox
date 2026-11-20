package com.cloud.tmc.integration.resource;

import android.app.Application;
import android.text.TextUtils;
import com.cloud.tmc.integration.utils.FileUtil;
import com.cloud.tmc.kernel.proxy.env.IApplicationContextGetter;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.resource.IImageResourceManager;
import com.cloud.tmc.kernel.utils.r;
import com.cloud.tmc.miniutils.util.h;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import tc.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class ImageResourceManager implements IImageResourceManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f30908a = new ConcurrentHashMap(64);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f30909b = new ConcurrentHashMap(64);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicInteger f30910c = new AtomicInteger(0);

    @Override // com.cloud.tmc.kernel.resource.IImageResourceManager
    public List<String> fuzzySearchByVUrl(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : this.f30908a.entrySet()) {
            String key = entry.getKey();
            if (key.startsWith(str) && key.contains(str2)) {
                arrayList.add(entry.getKey());
            }
        }
        return arrayList;
    }

    @Override // com.cloud.tmc.kernel.resource.IImageResourceManager
    public String generateVUrl(String str, String str2, String str3) {
        return generateVUrl(str, str2, str3, false);
    }

    @Override // com.cloud.tmc.kernel.resource.IImageResourceManager
    public String generateVUrl(String str, String str2, String str3, boolean z11) {
        String str4 = getVhost(str2) + "/" + h.b(str) + "/" + str3;
        put(str4, str);
        if (z11) {
            Application application = ((IApplicationContextGetter) a.a(IApplicationContextGetter.class)).getApplication();
            synchronized (ImageResourceManager.class) {
                int iAddAndGet = this.f30910c.addAndGet(1);
                ((KVStorageProxy) a.a(KVStorageProxy.class)).putInt(application, str2, "vUrlImgSize", iAddAndGet);
                ((KVStorageProxy) a.a(KVStorageProxy.class)).putString(application, str2, "vUrlImg_" + iAddAndGet, str4 + "->" + str);
            }
        }
        return str4;
    }

    @Override // com.cloud.tmc.kernel.resource.IImageResourceManager
    public String getImagePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = this.f30908a.get(str);
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        String strD = r.d(str);
        if (TextUtils.isEmpty(strD)) {
            return null;
        }
        String str3 = this.f30908a.get(strD);
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        return str3;
    }

    @Override // com.cloud.tmc.kernel.resource.IImageResourceManager
    public String getVhost(String str) {
        return FileUtil.U(str);
    }

    @Override // com.cloud.tmc.kernel.resource.IImageResourceManager
    public void init(String str) {
        Application application = ((IApplicationContextGetter) a.a(IApplicationContextGetter.class)).getApplication();
        int i11 = ((KVStorageProxy) a.a(KVStorageProxy.class)).getInt(application, str, "vUrlImgSize");
        this.f30910c.set(i11);
        for (int i12 = 1; i12 <= i11; i12++) {
            String string = ((KVStorageProxy) a.a(KVStorageProxy.class)).getString(application, str, "vUrlImg_" + i12);
            if (!TextUtils.isEmpty(string) && string != null) {
                String[] strArrSplit = string.split("->");
                if (strArrSplit.length == 2) {
                    this.f30908a.put(strArrSplit[0], strArrSplit[1]);
                    this.f30909b.put(strArrSplit[1], strArrSplit[0]);
                }
            }
        }
    }

    public void put(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f30908a.put(str, str2);
        this.f30909b.put(str2, str);
    }

    @Override // com.cloud.tmc.kernel.resource.IImageResourceManager
    public void removeByFilePath(String str) {
        if (!TextUtils.isEmpty(str) && this.f30909b.containsKey(str)) {
            this.f30908a.remove(this.f30909b.remove(str));
        }
    }

    @Override // com.cloud.tmc.kernel.resource.IImageResourceManager
    public void removeByVUrl(String str) {
        if (!TextUtils.isEmpty(str) && this.f30908a.containsKey(str)) {
            this.f30909b.remove(this.f30908a.remove(str));
        }
    }
}
