package com.transsion.room.activity;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class RoomHomeActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) com.alibaba.android.arouter.launcher.a.d().h(SerializationService.class);
        RoomHomeActivity roomHomeActivity = (RoomHomeActivity) obj;
        roomHomeActivity.f57108i = roomHomeActivity.getIntent().getExtras() == null ? roomHomeActivity.f57108i : roomHomeActivity.getIntent().getExtras().getString("post_id", roomHomeActivity.f57108i);
        roomHomeActivity.f57109j = roomHomeActivity.getIntent().getExtras() == null ? roomHomeActivity.f57109j : roomHomeActivity.getIntent().getExtras().getString("ops", roomHomeActivity.f57109j);
    }
}
