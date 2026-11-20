package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IProviderGroup;
import com.transsion.videodetail.provider.StreamDetailServiceImpl;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Providers$$VideoDetail implements IProviderGroup {
    @Override // com.alibaba.android.arouter.facade.template.IProviderGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("com.transsion.videodetail.api.IStreamDetailService", RouteMeta.build(RouteType.PROVIDER, StreamDetailServiceImpl.class, "/stream/details", "stream", null, -1, Integer.MIN_VALUE));
    }
}
