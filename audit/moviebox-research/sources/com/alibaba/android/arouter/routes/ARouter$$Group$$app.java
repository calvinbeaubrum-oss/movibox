package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.mbridge.msdk.MBridgeConstans;
import com.transsion.subroom.push.PushProvider;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$app implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/app/push", RouteMeta.build(RouteType.PROVIDER, PushProvider.class, "/app/push", MBridgeConstans.DYNAMIC_VIEW_WX_APP, null, -1, Integer.MIN_VALUE));
    }
}
