package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.transsnet.login.country.LoginSelectCountryActivity;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$loginapi implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/loginapi/select_country", RouteMeta.build(RouteType.ACTIVITY, LoginSelectCountryActivity.class, "/loginapi/select_country", "loginapi", null, -1, Integer.MIN_VALUE));
    }
}
