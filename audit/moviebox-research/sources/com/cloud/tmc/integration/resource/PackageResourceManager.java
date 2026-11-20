package com.cloud.tmc.integration.resource;

import android.text.TextUtils;
import com.cloud.tmc.integration.utils.FileUtil;
import com.cloud.tmc.kernel.resource.IPackageResourceManager;
import com.cloud.tmc.kernel.utils.r;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tc.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class PackageResourceManager implements IPackageResourceManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f30911a = new ConcurrentHashMap(64);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f30912b = new ConcurrentHashMap(64);

    @Override // com.cloud.tmc.kernel.resource.IPackageResourceManager
    public List<String> fuzzySearchByVUrl(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : this.f30911a.entrySet()) {
            String key = entry.getKey();
            if (key.startsWith(str) && key.contains(str2)) {
                arrayList.add(entry.getKey());
            }
        }
        return arrayList;
    }

    @Override // com.cloud.tmc.kernel.resource.IPackageResourceManager
    public String generateVUrl(String str, String str2, String str3, String str4) {
        String str5 = getVhost(str2) + str4 + "/" + str3;
        put(str5, str);
        return str5;
    }

    @Override // com.cloud.tmc.kernel.resource.IPackageResourceManager
    public String getFilePath(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = this.f30911a.get(str2);
        if (!TextUtils.isEmpty(str3)) {
            return str3;
        }
        String strD = r.d(str2);
        if (TextUtils.isEmpty(strD)) {
            return null;
        }
        String str4 = this.f30911a.get(strD);
        if (!TextUtils.isEmpty(str4)) {
            return str4;
        }
        String filePath = ((ISubPackageResourceManager) a.a(ISubPackageResourceManager.class)).getFilePath(str, str2);
        if (TextUtils.isEmpty(filePath)) {
            return null;
        }
        return filePath;
    }

    @Override // com.cloud.tmc.kernel.resource.IPackageResourceManager
    public Map<String, String> getFilePath2VUrlMap() {
        return this.f30912b;
    }

    @Override // com.cloud.tmc.kernel.resource.IPackageResourceManager
    public Map<String, String> getVUrl2FilePathMap() {
        return this.f30911a;
    }

    @Override // com.cloud.tmc.kernel.resource.IPackageResourceManager
    public String getVhost(String str) {
        return FileUtil.U(str);
    }

    public void put(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f30911a.put(str, str2);
        this.f30912b.put(str2, str);
    }

    @Override // com.cloud.tmc.kernel.resource.IPackageResourceManager
    public void removeByFilePath(String str) {
        if (!TextUtils.isEmpty(str) && this.f30912b.containsKey(str)) {
            this.f30911a.remove(this.f30912b.remove(str));
        }
    }

    @Override // com.cloud.tmc.kernel.resource.IPackageResourceManager
    public void removeByVUrl(String str) {
        if (!TextUtils.isEmpty(str) && this.f30911a.containsKey(str)) {
            this.f30912b.remove(this.f30911a.remove(str));
        }
    }
}
