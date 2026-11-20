package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.transsion.videodetail.StreamDetailActivity;
import com.transsion.videodetail.music.ui.MusicDetailActivity;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$playvideo implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put("/playvideo/detail", RouteMeta.build(routeType, StreamDetailActivity.class, "/playvideo/detail", "playvideo", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$playvideo.1
            {
                put("is_music_liked_fragment", 0);
                put("resourceId", 8);
                put("ops", 8);
                put("yy_preload_id", 3);
                put("season", 3);
                put("isMusicFloatViewClick", 0);
                put("autoDownload", 0);
                put("episode", 3);
                put("id", 8);
                put("module_name", 8);
                put("autoPlay", 0);
            }
        }, -1, Integer.MIN_VALUE));
        map.put("/playvideo/music_detail", RouteMeta.build(routeType, MusicDetailActivity.class, "/playvideo/music_detail", "playvideo", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$playvideo.2
            {
                put("is_music_liked_fragment", 0);
                put("resourceId", 8);
                put("ops", 8);
                put("yy_preload_id", 3);
                put("season", 3);
                put("isMusicFloatViewClick", 0);
                put("autoDownload", 0);
                put("episode", 3);
                put("id", 8);
                put("module_name", 8);
                put("autoPlay", 0);
            }
        }, -1, Integer.MIN_VALUE));
    }
}
