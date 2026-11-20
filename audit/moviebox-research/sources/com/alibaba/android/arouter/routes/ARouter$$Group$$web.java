package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.transsion.web.activity.ARouterPathReplaceService;
import com.transsion.web.activity.WebActivity;
import com.transsion.web.api.WebConstants;
import com.transsion.web.api.WebPageIdentity;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$web implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(WebPageIdentity.REPLACE_SERVICE, RouteMeta.build(RouteType.PROVIDER, ARouterPathReplaceService.class, WebPageIdentity.REPLACE_SERVICE, "web", null, -1, Integer.MIN_VALUE));
        map.put(WebPageIdentity.WEB_VIEW, RouteMeta.build(RouteType.ACTIVITY, WebActivity.class, WebPageIdentity.WEB_VIEW, "web", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$web.1
            {
                put(WebConstants.FIELD_LOAD_URL_ONLY, 0);
                put(WebConstants.PAGE_FROM, 8);
                put(WebConstants.FIELD_DEEPLINK, 8);
                put("url", 8);
            }
        }, -1, Integer.MIN_VALUE));
    }
}
