package com.cloud.tmc.kernel.resource;

import java.util.List;
import zb.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@c("com.cloud.tmc.integration.resource.ImageResourceManager")
public interface IImageResourceManager {
    List<String> fuzzySearchByVUrl(String str, String str2);

    String generateVUrl(String str, String str2, String str3);

    String generateVUrl(String str, String str2, String str3, boolean z11);

    String getImagePath(String str);

    String getVhost(String str);

    void init(String str);

    void removeByFilePath(String str);

    void removeByVUrl(String str);
}
