package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.transsion.postdetail.comment.ui.CommentListActivity;
import com.transsion.postdetail.impl.PostDetailApiImpl;
import com.transsion.postdetail.ui.activity.PostDetailActivity;
import com.transsion.postdetail.ui.activity.PostDetailVideoActivity;
import com.transsion.web.api.WebConstants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$post implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put("/post/detail", RouteMeta.build(routeType, PostDetailActivity.class, "/post/detail", "post", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$post.1
            {
                put("video_load_more", 0);
                put("tab_id", 3);
                put(WebConstants.PAGE_FROM, 8);
                put("need_back_to_room", 0);
                put("media_type", 8);
                put("item_type", 8);
                put("from_comment", 0);
                put("id", 8);
                put("rec_ops", 8);
                put("comment_id", 8);
                put("item_object", 9);
            }
        }, -1, Integer.MIN_VALUE));
        map.put("/post/detailVideo", RouteMeta.build(routeType, PostDetailVideoActivity.class, "/post/detailvideo", "post", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$post.2
            {
                put("video_load_more", 0);
                put("is_build_in", 0);
                put("tab_id", 3);
                put(WebConstants.PAGE_FROM, 8);
                put("media_type", 8);
                put("item_type", 8);
                put("from_comment", 0);
                put("id", 8);
                put("rec_ops", 8);
                put("item_object", 9);
            }
        }, -1, Integer.MIN_VALUE));
        map.put("/post/detailapi", RouteMeta.build(RouteType.PROVIDER, PostDetailApiImpl.class, "/post/detailapi", "post", null, -1, Integer.MIN_VALUE));
        map.put("/post/my_comment", RouteMeta.build(routeType, CommentListActivity.class, "/post/my_comment", "post", null, -1, Integer.MIN_VALUE));
    }
}
