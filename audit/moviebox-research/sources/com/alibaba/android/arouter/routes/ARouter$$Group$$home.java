package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.home.activity.FilterActivity;
import com.transsion.home.activity.MovieFilterActivity;
import com.transsion.home.activity.OperateActivity;
import com.transsion.home.category.CategoryActivity;
import com.transsion.home.category.PlayListActivity;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$home implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put("/home/category", RouteMeta.build(routeType, CategoryActivity.class, "/home/category", "home", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$home.1
            {
                put("categoryType", 8);
                put("showType", 8);
            }
        }, -1, Integer.MIN_VALUE));
        map.put("/home/filter", RouteMeta.build(routeType, FilterActivity.class, "/home/filter", "home", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$home.2
            {
                put("tabId", 3);
                put("tabCode", 8);
                put("filterType", 8);
            }
        }, -1, Integer.MIN_VALUE));
        map.put("/home/movieFilter", RouteMeta.build(routeType, MovieFilterActivity.class, "/home/moviefilter", "home", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$home.3
            {
                put("tabId", 3);
                put("showViewPager", 0);
                put("tabCode", 8);
                put("filterType", 8);
            }
        }, -1, Integer.MIN_VALUE));
        map.put("/home/operatePage", RouteMeta.build(routeType, OperateActivity.class, "/home/operatepage", "home", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$home.4
            {
                put("tabId", 3);
                put("tabCode", 8);
                put(CampaignEx.JSON_KEY_TITLE, 8);
            }
        }, -1, Integer.MIN_VALUE));
        map.put("/home/playlist", RouteMeta.build(routeType, PlayListActivity.class, "/home/playlist", "home", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$home.5
            {
                put("recType", 8);
                put("label", 8);
                put("category", 8);
            }
        }, -1, Integer.MIN_VALUE));
    }
}
