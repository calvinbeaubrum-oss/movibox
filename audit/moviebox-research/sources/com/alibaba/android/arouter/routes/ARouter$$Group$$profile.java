package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.google.android.gms.common.Scopes;
import com.transsion.usercenter.message.UserMessageActivity;
import com.transsion.usercenter.message.UserRoomMessageActivity;
import com.transsion.usercenter.message.detail.MessageDetailActivity;
import com.transsion.usercenter.profile.ProfileActivity;
import com.transsion.usercenter.profile.ProfileQRCodeActivity;
import com.transsion.usercenter.profile.see.ProfileSeeActivity;
import com.transsion.usercenter.setting.SettingActivity;
import com.transsion.usercenter.setting.SettingNoticeActivity;
import com.transsion.usercenter.setting.SettingWatchActivity;
import com.transsion.usercenter.setting.feedback.UserSettingFeedbackActivity;
import com.transsion.usercenter.setting.labelsfeedback.LabelsFeedbackActivity;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$profile implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put("/profile/message_detail", RouteMeta.build(routeType, MessageDetailActivity.class, "/profile/message_detail", Scopes.PROFILE, new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$profile.1
            {
                put("msg_create_time", 8);
                put("msg_nickname", 8);
                put("msg_content", 8);
            }
        }, -1, Integer.MIN_VALUE));
        map.put("/profile/qr_code", RouteMeta.build(routeType, ProfileQRCodeActivity.class, "/profile/qr_code", Scopes.PROFILE, null, -1, Integer.MIN_VALUE));
        map.put("/profile/see", RouteMeta.build(routeType, ProfileSeeActivity.class, "/profile/see", Scopes.PROFILE, new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$profile.2
            {
                put("userId", 8);
            }
        }, -1, Integer.MIN_VALUE));
        map.put("/profile/setting", RouteMeta.build(routeType, SettingActivity.class, "/profile/setting", Scopes.PROFILE, null, -1, Integer.MIN_VALUE));
        map.put("/profile/setting_notice", RouteMeta.build(routeType, SettingNoticeActivity.class, "/profile/setting_notice", Scopes.PROFILE, null, -1, Integer.MIN_VALUE));
        map.put("/profile/user_center", RouteMeta.build(routeType, ProfileActivity.class, "/profile/user_center", Scopes.PROFILE, new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$profile.3
            {
                put("userInfo", 9);
                put("userId", 8);
            }
        }, -1, Integer.MIN_VALUE));
        map.put("/profile/user_center_feedback", RouteMeta.build(routeType, UserSettingFeedbackActivity.class, "/profile/user_center_feedback", Scopes.PROFILE, null, -1, Integer.MIN_VALUE));
        map.put("/profile/user_center_labels_feedback", RouteMeta.build(routeType, LabelsFeedbackActivity.class, "/profile/user_center_labels_feedback", Scopes.PROFILE, null, -1, Integer.MIN_VALUE));
        map.put("/profile/user_message", RouteMeta.build(routeType, UserMessageActivity.class, "/profile/user_message", Scopes.PROFILE, null, -1, Integer.MIN_VALUE));
        map.put("/profile/user_room_message", RouteMeta.build(routeType, UserRoomMessageActivity.class, "/profile/user_room_message", Scopes.PROFILE, new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$profile.4
            {
                put("msgType", 8);
            }
        }, -1, Integer.MIN_VALUE));
        map.put("/profile/watch_option", RouteMeta.build(routeType, SettingWatchActivity.class, "/profile/watch_option", Scopes.PROFILE, null, -1, Integer.MIN_VALUE));
    }
}
