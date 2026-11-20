package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IProviderGroup;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.downloader.core.thread.DownloadBaseRunnable;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Providers$$Downloader implements IProviderGroup {
    @Override // com.alibaba.android.arouter.facade.template.IProviderGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("com.transsion.downloadapi.IDownloadApiProvider", RouteMeta.build(RouteType.PROVIDER, DownloadManagerApi.class, "/download/provider", DownloadBaseRunnable.TAG, null, -1, Integer.MIN_VALUE));
    }
}
