package com.transsion.room.activity;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class RoomListActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) com.alibaba.android.arouter.launcher.a.d().h(SerializationService.class);
        RoomListActivity roomListActivity = (RoomListActivity) obj;
        roomListActivity.f57110i = roomListActivity.getIntent().getBooleanExtra("is_select_room", roomListActivity.f57110i);
        roomListActivity.f57111j = roomListActivity.getIntent().getIntExtra("index", roomListActivity.f57111j);
    }
}
