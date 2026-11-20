package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.transsion.publish.PublishProvider;
import com.transsion.publish.ui.FilmReviewActivity;
import com.transsion.publish.ui.SelectLocationActivity;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$publish implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/publish/Api", RouteMeta.build(RouteType.PROVIDER, PublishProvider.class, "/publish/api", "publish", null, -1, Integer.MIN_VALUE));
        RouteType routeType = RouteType.ACTIVITY;
        map.put("/publish/activity/film_review", RouteMeta.build(routeType, FilmReviewActivity.class, "/publish/activity/film_review", "publish", null, -1, Integer.MIN_VALUE));
        map.put("/publish/location_list", RouteMeta.build(routeType, SelectLocationActivity.class, "/publish/location_list", "publish", null, -1, Integer.MIN_VALUE));
    }
}
