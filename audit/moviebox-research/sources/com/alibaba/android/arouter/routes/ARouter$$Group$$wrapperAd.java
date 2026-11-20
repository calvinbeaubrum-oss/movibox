package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.transsion.wrapperad.WrapperAdProvider;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$wrapperAd implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/wrapperAd/WrapperAdProvider", RouteMeta.build(RouteType.PROVIDER, WrapperAdProvider.class, "/wrapperad/wrapperadprovider", "wrapperad", null, -1, Integer.MIN_VALUE));
    }
}
