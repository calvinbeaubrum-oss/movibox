package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.transsion.videodetail.provider.StreamDetailServiceImpl;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class ARouter$$Group$$stream implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/stream/details", RouteMeta.build(RouteType.PROVIDER, StreamDetailServiceImpl.class, "/stream/details", "stream", null, -1, Integer.MIN_VALUE));
    }
}
