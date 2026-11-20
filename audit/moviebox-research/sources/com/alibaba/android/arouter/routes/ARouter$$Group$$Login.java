package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.applovin.sdk.AppLovinEventTypes;
import com.transsnet.login.LoginProvider;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$Login implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/Login/Api", RouteMeta.build(RouteType.PROVIDER, LoginProvider.class, "/login/api", AppLovinEventTypes.USER_LOGGED_IN, null, -1, Integer.MIN_VALUE));
    }
}
