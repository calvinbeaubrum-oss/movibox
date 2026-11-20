package com.cloud.tmc.integration.resource;

import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.cloud.tmc.integration.utils.FileUtil;
import com.cloud.tmc.integration.utils.v;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.env.IApplicationContextGetter;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.kernel.resource.IFileResourceManager;
import com.cloud.tmc.kernel.utils.r;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import tc.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class FileResourceManager implements IFileResourceManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f30905a = new ConcurrentHashMap(64);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f30906b = new ConcurrentHashMap(64);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicInteger f30907c = new AtomicInteger(0);

    @Override // com.cloud.tmc.kernel.resource.IFileResourceManager
    public List<String> fuzzySearchByVUrl(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : this.f30905a.entrySet()) {
            String key = entry.getKey();
            if (key.startsWith(str) && key.contains(str2)) {
                arrayList.add(entry.getKey());
            }
        }
        return arrayList;
    }

    @Override // com.cloud.tmc.kernel.resource.IFileResourceManager
    public String generateVUrl(String str, String str2, String str3, String str4) {
        return generateVUrl(str, str2, str3, str4, false);
    }

    @Override // com.cloud.tmc.kernel.resource.IFileResourceManager
    public String generateVUrl(String str, String str2, String str3, String str4, boolean z11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getVhost(str2));
        if (!TextUtils.isEmpty(str4)) {
            if (!str4.startsWith("/")) {
                sb2.append("/");
            }
            sb2.append(str4);
        }
        sb2.append("/");
        sb2.append(str3);
        if (!v.f31133a.b(str2) && ("temp_data".equals(str4) || "local_data".equals(str4))) {
            TmcLogger.c("FileResourceManager", "generateVUrl " + sb2.toString());
            return sb2.toString();
        }
        String lowerCase = sb2.toString().toLowerCase();
        put(lowerCase, str);
        if (z11) {
            Application application = ((IApplicationContextGetter) a.a(IApplicationContextGetter.class)).getApplication();
            synchronized (FileResourceManager.class) {
                int iAddAndGet = this.f30907c.addAndGet(1);
                ((KVStorageProxy) a.a(KVStorageProxy.class)).putInt(application, str2, "vUrlFileSize", iAddAndGet);
                ((KVStorageProxy) a.a(KVStorageProxy.class)).putString(application, str2, "vUrlFile_" + iAddAndGet, lowerCase + "->" + str);
            }
        }
        return lowerCase;
    }

    @Override // com.cloud.tmc.kernel.resource.IFileResourceManager
    public String getFilePath(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        String strD = v.f31133a.d(str, str2);
        if (!TextUtils.isEmpty(strD)) {
            return strD;
        }
        String str3 = this.f30905a.get(str2.toLowerCase());
        if (!TextUtils.isEmpty(str3)) {
            return str3;
        }
        String strD2 = r.d(str2.toLowerCase());
        if (TextUtils.isEmpty(strD2)) {
            return null;
        }
        String str4 = this.f30905a.get(strD2);
        if (TextUtils.isEmpty(str4)) {
            return null;
        }
        return str4;
    }

    @Override // com.cloud.tmc.kernel.resource.IFileResourceManager
    public String getVhost(String str) {
        return FileUtil.U(str);
    }

    @Override // com.cloud.tmc.kernel.resource.IFileResourceManager
    public void init(String str) {
        Application application = ((IApplicationContextGetter) a.a(IApplicationContextGetter.class)).getApplication();
        int i11 = ((KVStorageProxy) a.a(KVStorageProxy.class)).getInt(application, str, "vUrlFileSize");
        this.f30907c.set(i11);
        for (int i12 = 1; i12 <= i11; i12++) {
            String string = ((KVStorageProxy) a.a(KVStorageProxy.class)).getString(application, str, "vUrlFile_" + i12);
            if (!TextUtils.isEmpty(string) && string != null) {
                String[] strArrSplit = string.split("->");
                if (strArrSplit.length == 2) {
                    this.f30905a.put(strArrSplit[0], strArrSplit[1]);
                    this.f30906b.put(strArrSplit[1], strArrSplit[0]);
                }
            }
        }
    }

    public void put(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f30905a.put(str, str2);
        this.f30906b.put(str2, str);
    }

    @Override // com.cloud.tmc.kernel.resource.IFileResourceManager
    public void removeByFilePath(String str) {
        if (!TextUtils.isEmpty(str) && this.f30906b.containsKey(str)) {
            this.f30905a.remove(this.f30906b.remove(str));
        }
    }

    @Override // com.cloud.tmc.kernel.resource.IFileResourceManager
    public void removeByVUrl(String str) {
        if (!TextUtils.isEmpty(str) && this.f30905a.containsKey(str)) {
            this.f30906b.remove(this.f30905a.remove(str));
        }
    }

    public String specifyVUrl(@NonNull String str, @NonNull String str2, @NonNull String str3, boolean z11) {
        if (!v.f31133a.b(str3) && (str.contains("temp_data") || str.contains("local_data"))) {
            return str;
        }
        String lowerCase = str.toLowerCase();
        put(lowerCase, str2);
        if (z11) {
            Application application = ((IApplicationContextGetter) a.a(IApplicationContextGetter.class)).getApplication();
            synchronized (FileResourceManager.class) {
                int iAddAndGet = this.f30907c.addAndGet(1);
                ((KVStorageProxy) a.a(KVStorageProxy.class)).putInt(application, str3, "vUrlFileSize", iAddAndGet);
                ((KVStorageProxy) a.a(KVStorageProxy.class)).putString(application, str3, "vUrlFile_" + iAddAndGet, lowerCase + "->" + str2);
            }
        }
        return lowerCase;
    }
}
