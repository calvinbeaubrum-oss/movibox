package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IProviderGroup;
import com.transsion.postdetail.impl.PostDetailApiImpl;
import com.transsion.postdetail.provider.DownloadProvider;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Providers$$PostDetail implements IProviderGroup {
    @Override // com.alibaba.android.arouter.facade.template.IProviderGroup
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.PROVIDER;
        map.put("com.transsion.postdetailapi.IPostDetailApi", RouteMeta.build(routeType, PostDetailApiImpl.class, "/post/detailapi", "post", null, -1, Integer.MIN_VALUE));
        map.put("com.transsnet.downloader.provider.IDownloadProvider", RouteMeta.build(routeType, DownloadProvider.class, "/video/download", "video", null, -1, Integer.MIN_VALUE));
    }
}
