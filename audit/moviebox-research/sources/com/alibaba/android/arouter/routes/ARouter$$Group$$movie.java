package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.transsion.moviedetail.activity.MovieDetailActivity;
import com.transsion.moviedetail.provider.MovieDetailServiceImpl;
import com.transsion.moviedetail.staff.MovieStaffActivity;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$movie implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put("/movie/detail", RouteMeta.build(routeType, MovieDetailActivity.class, "/movie/detail", "movie", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$movie.1
            {
                put("resourceId", 8);
                put("ops", 8);
                put("subject_type", 3);
                put("yy_preload_id", 3);
                put("season", 3);
                put("autoDownload", 0);
                put("id", 8);
                put("module_name", 8);
                put("autoPlay", 0);
            }
        }, -1, Integer.MIN_VALUE));
        map.put("/movie/details", RouteMeta.build(RouteType.PROVIDER, MovieDetailServiceImpl.class, "/movie/details", "movie", null, -1, Integer.MIN_VALUE));
        map.put("/movie/staff", RouteMeta.build(routeType, MovieStaffActivity.class, "/movie/staff", "movie", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$movie.2
            {
                put("id", 8);
            }
        }, -1, Integer.MIN_VALUE));
    }
}
