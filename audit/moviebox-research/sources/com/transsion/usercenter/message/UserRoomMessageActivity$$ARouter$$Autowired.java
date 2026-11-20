package com.transsion.usercenter.message;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class UserRoomMessageActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) com.alibaba.android.arouter.launcher.a.d().h(SerializationService.class);
        UserRoomMessageActivity userRoomMessageActivity = (UserRoomMessageActivity) obj;
        userRoomMessageActivity.f59465i = userRoomMessageActivity.getIntent().getExtras() == null ? userRoomMessageActivity.f59465i : userRoomMessageActivity.getIntent().getExtras().getString("msgType", userRoomMessageActivity.f59465i);
    }
}
