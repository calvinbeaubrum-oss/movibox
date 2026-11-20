package com.transsion.usercenter.profile.see;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.alibaba.android.arouter.launcher.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class ProfileSeeActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) a.d().h(SerializationService.class);
        ProfileSeeActivity profileSeeActivity = (ProfileSeeActivity) obj;
        profileSeeActivity.f59612i = profileSeeActivity.getIntent().getExtras() == null ? profileSeeActivity.f59612i : profileSeeActivity.getIntent().getExtras().getString("userId", profileSeeActivity.f59612i);
    }
}
