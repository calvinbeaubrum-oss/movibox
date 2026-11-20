package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.transsion.subroom.activity.MainActivity;
import com.transsion.subroom.activity.NotAvailableActivity;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$main implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put("/main/page_not_available", RouteMeta.build(routeType, NotAvailableActivity.class, "/main/page_not_available", "main", null, -1, Integer.MIN_VALUE));
        map.put("/main/tab", RouteMeta.build(routeType, MainActivity.class, "/main/tab", "main", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$main.1
            {
                put("topTab", 8);
                put("bottomTab", 8);
                put("tabIndex", 3);
                put("secondTabIndex", 3);
            }
        }, -1, Integer.MIN_VALUE));
    }
}
