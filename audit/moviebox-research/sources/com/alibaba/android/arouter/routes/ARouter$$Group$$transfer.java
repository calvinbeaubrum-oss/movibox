package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.transsion.transfer.TransferProvider;
import com.transsion.transfer.impl.TransferStatusActivity;
import com.transsion.transfer.wifi.ui.WifiConnectActivity;
import com.transsion.transfer.wifi.ui.WifiCreateActivity;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class ARouter$$Group$$transfer implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put("/transfer/status", RouteMeta.build(routeType, TransferStatusActivity.class, "/transfer/status", "transfer", null, -1, Integer.MIN_VALUE));
        map.put("/transfer/transfer_provider", RouteMeta.build(RouteType.PROVIDER, TransferProvider.class, "/transfer/transfer_provider", "transfer", null, -1, Integer.MIN_VALUE));
        map.put("/transfer/wifi_connect", RouteMeta.build(routeType, WifiConnectActivity.class, "/transfer/wifi_connect", "transfer", null, -1, Integer.MIN_VALUE));
        map.put("/transfer/wifi_create", RouteMeta.build(routeType, WifiCreateActivity.class, "/transfer/wifi_create", "transfer", null, -1, Integer.MIN_VALUE));
    }
}
