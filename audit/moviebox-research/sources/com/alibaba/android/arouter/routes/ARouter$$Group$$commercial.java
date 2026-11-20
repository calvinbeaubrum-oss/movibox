package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.transsion.commercialization.aha.AhaGameAllActivity;
import com.transsion.commercialization.pslink.PsLinkActivity;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$commercial implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put("/commercial/gamecenter", RouteMeta.build(routeType, AhaGameAllActivity.class, "/commercial/gamecenter", "commercial", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$commercial.1
            {
                put("fromTask", 0);
            }
        }, -1, Integer.MIN_VALUE));
        map.put("/commercial/playstore", RouteMeta.build(routeType, PsLinkActivity.class, "/commercial/playstore", "commercial", null, -1, Integer.MIN_VALUE));
    }
}
