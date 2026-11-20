package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.applovin.sdk.AppLovinEventTypes;
import com.transsion.search.activity.SearchManagerActivity;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$search implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/search/activity/search_manager", RouteMeta.build(RouteType.ACTIVITY, SearchManagerActivity.class, "/search/activity/search_manager", AppLovinEventTypes.USER_EXECUTED_SEARCH, new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$search.1
            {
                put("back_exit", 0);
                put("keyword", 8);
                put("type", 3);
            }
        }, -1, Integer.MIN_VALUE));
    }
}
