package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.transsion.room.activity.CreateRoomActivity;
import com.transsion.room.activity.HotRoomsActivity;
import com.transsion.room.activity.MyRoomActivity;
import com.transsion.room.activity.OthersRoomListActivity;
import com.transsion.room.activity.RoomDetailActivity;
import com.transsion.room.activity.RoomHomeActivity;
import com.transsion.room.activity.RoomListActivity;
import com.transsion.web.api.WebConstants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$room implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put("/room/create", RouteMeta.build(routeType, CreateRoomActivity.class, "/room/create", PlaceTypes.ROOM, null, -1, Integer.MIN_VALUE));
        map.put("/room/detail", RouteMeta.build(routeType, RoomDetailActivity.class, "/room/detail", PlaceTypes.ROOM, new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$room.1
            {
                put(WebConstants.FIELD_ITEM, 10);
                put("need_start_room_home", 0);
                put("id", 8);
            }
        }, -1, Integer.MIN_VALUE));
        map.put("/room/home", RouteMeta.build(routeType, RoomHomeActivity.class, "/room/home", PlaceTypes.ROOM, new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$room.2
            {
                put("ops", 8);
                put("post_id", 8);
            }
        }, -1, Integer.MIN_VALUE));
        map.put("/room/hot_room", RouteMeta.build(routeType, HotRoomsActivity.class, "/room/hot_room", PlaceTypes.ROOM, null, -1, Integer.MIN_VALUE));
        map.put("/room/list", RouteMeta.build(routeType, RoomListActivity.class, "/room/list", PlaceTypes.ROOM, new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$room.3
            {
                put("index", 3);
                put("is_select_room", 0);
            }
        }, -1, Integer.MIN_VALUE));
        map.put("/room/my", RouteMeta.build(routeType, MyRoomActivity.class, "/room/my", PlaceTypes.ROOM, null, -1, Integer.MIN_VALUE));
        map.put("/room/others_list", RouteMeta.build(routeType, OthersRoomListActivity.class, "/room/others_list", PlaceTypes.ROOM, new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$room.4
            {
                put("user_id", 8);
            }
        }, -1, Integer.MIN_VALUE));
    }
}
