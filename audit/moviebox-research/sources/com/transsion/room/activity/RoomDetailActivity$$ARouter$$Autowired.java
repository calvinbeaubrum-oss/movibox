package com.transsion.room.activity;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.transsion.moviedetailapi.bean.RoomItem;
import com.transsion.web.api.WebConstants;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class RoomDetailActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) com.alibaba.android.arouter.launcher.a.d().h(SerializationService.class);
        RoomDetailActivity roomDetailActivity = (RoomDetailActivity) obj;
        roomDetailActivity.f57104i = (RoomItem) roomDetailActivity.getIntent().getParcelableExtra(WebConstants.FIELD_ITEM);
        roomDetailActivity.f57105j = roomDetailActivity.getIntent().getExtras() == null ? roomDetailActivity.f57105j : roomDetailActivity.getIntent().getExtras().getString("id", roomDetailActivity.f57105j);
        roomDetailActivity.f57106k = roomDetailActivity.getIntent().getBooleanExtra("need_start_room_home", roomDetailActivity.f57106k);
    }
}
