package com.transsion.room.activity;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class OthersRoomListActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) com.alibaba.android.arouter.launcher.a.d().h(SerializationService.class);
        OthersRoomListActivity othersRoomListActivity = (OthersRoomListActivity) obj;
        othersRoomListActivity.f57103i = othersRoomListActivity.getIntent().getExtras() == null ? othersRoomListActivity.f57103i : othersRoomListActivity.getIntent().getExtras().getString("user_id", othersRoomListActivity.f57103i);
    }
}
