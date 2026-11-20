package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.transsion.member.MemberActivity;
import com.transsion.member.MemberFragment;
import com.transsion.member.MemberProvider;
import com.transsion.member.history.PointsHistoryActivity;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$member implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put("/member/MemberActivity", RouteMeta.build(routeType, MemberActivity.class, "/member/memberactivity", "member", null, -1, Integer.MIN_VALUE));
        map.put("/member/MemberFragment", RouteMeta.build(RouteType.FRAGMENT, MemberFragment.class, "/member/memberfragment", "member", null, -1, Integer.MIN_VALUE));
        map.put("/member/MemberProvider", RouteMeta.build(RouteType.PROVIDER, MemberProvider.class, "/member/memberprovider", "member", null, -1, Integer.MIN_VALUE));
        map.put("/member/point_history", RouteMeta.build(routeType, PointsHistoryActivity.class, "/member/point_history", "member", null, -1, Integer.MIN_VALUE));
    }
}
