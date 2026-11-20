package com.transsion.usercenter.profile;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.transsnet.loginapi.bean.UserInfo;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class ProfileActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) com.alibaba.android.arouter.launcher.a.d().h(SerializationService.class);
        ProfileActivity profileActivity = (ProfileActivity) obj;
        profileActivity.f59513i = (UserInfo) profileActivity.getIntent().getSerializableExtra("userInfo");
        profileActivity.f59514j = profileActivity.getIntent().getExtras() == null ? profileActivity.f59514j : profileActivity.getIntent().getExtras().getString("userId", profileActivity.f59514j);
    }
}
