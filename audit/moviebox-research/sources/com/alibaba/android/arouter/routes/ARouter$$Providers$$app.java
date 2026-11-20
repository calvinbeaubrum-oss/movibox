package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IProviderGroup;
import com.mbridge.msdk.MBridgeConstans;
import com.transsion.subroom.provider.NetworkProvider;
import com.transsion.subroom.push.PushProvider;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Providers$$app implements IProviderGroup {
    @Override // com.alibaba.android.arouter.facade.template.IProviderGroup
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.PROVIDER;
        map.put("com.transsion.push.api.IPushProvider", RouteMeta.build(routeType, PushProvider.class, "/app/push", MBridgeConstans.DYNAMIC_VIEW_WX_APP, null, -1, Integer.MIN_VALUE));
        map.put("com.tn.lib.logger.INetworkProvider", RouteMeta.build(routeType, NetworkProvider.class, "/Log/network", "Log", null, -1, Integer.MIN_VALUE));
    }
}
