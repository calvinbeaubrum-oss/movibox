package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IProviderGroup;
import com.transsion.web.activity.ARouterPathReplaceService;
import com.transsion.web.api.WebPageIdentity;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Providers$$Web implements IProviderGroup {
    @Override // com.alibaba.android.arouter.facade.template.IProviderGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("com.alibaba.android.arouter.facade.service.PathReplaceService", RouteMeta.build(RouteType.PROVIDER, ARouterPathReplaceService.class, WebPageIdentity.REPLACE_SERVICE, "web", null, -1, Integer.MIN_VALUE));
    }
}
