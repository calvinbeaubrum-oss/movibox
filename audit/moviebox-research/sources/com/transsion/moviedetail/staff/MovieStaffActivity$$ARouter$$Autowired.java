package com.transsion.moviedetail.staff;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class MovieStaffActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) com.alibaba.android.arouter.launcher.a.d().h(SerializationService.class);
        MovieStaffActivity movieStaffActivity = (MovieStaffActivity) obj;
        movieStaffActivity.f53726a = movieStaffActivity.getIntent().getExtras() == null ? movieStaffActivity.f53726a : movieStaffActivity.getIntent().getExtras().getString("id", movieStaffActivity.f53726a);
    }
}
