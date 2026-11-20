package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.transsion.postdetail.provider.DownloadProvider;
import com.transsion.postdetail.ui.activity.LocalVideoDetailActivity;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$video implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/video/detail", RouteMeta.build(RouteType.ACTIVITY, LocalVideoDetailActivity.class, "/video/detail", "video", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$video.1
            {
                put("extra_resource_id", 8);
                put("extra_subject_id", 8);
                put("extra_is_series", 0);
                put("extra_name", 8);
                put("extra_url", 8);
                put("extra_width", 3);
                put("extra_post_id", 8);
                put("extra_height", 3);
                put("extra_position", 3);
                put("extra_parent_position", 3);
                put("extra_local_path", 8);
                put("extra_completed", 0);
                put("extra_page_from", 8);
                put("extra_proxy_url", 8);
            }
        }, -1, Integer.MIN_VALUE));
        map.put("/video/download", RouteMeta.build(RouteType.PROVIDER, DownloadProvider.class, "/video/download", "video", null, -1, Integer.MIN_VALUE));
    }
}
