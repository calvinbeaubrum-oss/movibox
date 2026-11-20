package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.transsion.postdetail.shorttv.ShortTVFavoriteActivity;
import com.transsion.postdetail.shorttv.ShortTvListActivity;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$shorts implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put("/shorts/detail", RouteMeta.build(routeType, ShortTvListActivity.class, "/shorts/detail", "shorts", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$shorts.1
            {
                put("ms", 4);
                put("ep", 3);
                put("id", 8);
                put("historyFist", 0);
                put("item_object", 9);
            }
        }, -1, Integer.MIN_VALUE));
        map.put("/shorts/favorite", RouteMeta.build(routeType, ShortTVFavoriteActivity.class, "/shorts/favorite", "shorts", null, -1, Integer.MIN_VALUE));
    }
}
