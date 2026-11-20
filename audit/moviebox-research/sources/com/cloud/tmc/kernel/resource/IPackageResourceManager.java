package com.cloud.tmc.kernel.resource;

import java.util.List;
import java.util.Map;
import zb.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@c("com.cloud.tmc.integration.resource.PackageResourceManager")
public interface IPackageResourceManager {
    List<String> fuzzySearchByVUrl(String str, String str2);

    String generateVUrl(String str, String str2, String str3, String str4);

    String getFilePath(String str, String str2);

    Map<String, String> getFilePath2VUrlMap();

    Map<String, String> getVUrl2FilePathMap();

    String getVhost(String str);

    void removeByFilePath(String str);

    void removeByVUrl(String str);
}
