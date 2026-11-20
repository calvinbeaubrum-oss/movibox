package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.transsion.edcation.history.EducationHistoryActivity;
import com.transsion.edcation.list.MyCourseListActivity;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class ARouter$$Group$$edu implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put("/edu/courseList", RouteMeta.build(routeType, MyCourseListActivity.class, "/edu/courselist", "edu", null, -1, Integer.MIN_VALUE));
        map.put("/edu/history", RouteMeta.build(routeType, EducationHistoryActivity.class, "/edu/history", "edu", null, -1, Integer.MIN_VALUE));
    }
}
