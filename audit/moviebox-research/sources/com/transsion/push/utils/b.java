package com.transsion.push.utils;

import com.transsion.push.bean.PushConfigHelper;
import java.util.HashSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class b implements nu.a {
    @Override // nu.a
    public HashSet a() {
        HashSet hashSet = new HashSet();
        hashSet.add("sa_dauupupup_config");
        hashSet.add("push_remind_notification_time");
        hashSet.add("push_permanent_ui_ab_config");
        hashSet.add(PushConfigHelper.PUSH_PIC_TYPE_CONFIG_KEY);
        hashSet.add("sa_toolbar_notice");
        hashSet.add("sa_notification_refresh");
        return hashSet;
    }
}
