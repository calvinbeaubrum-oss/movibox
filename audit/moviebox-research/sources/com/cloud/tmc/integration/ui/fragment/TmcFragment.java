package com.cloud.tmc.integration.ui.fragment;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.cloud.tmc.integration.chain.page.PageChainContext;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.Page;
import tb.d;
import vb.b;
import vb.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class TmcFragment extends Fragment implements d, c, b, vb.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public Page f30954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public App f30955b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PageChainContext f30956c = new PageChainContext();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ExitType f30957d = ExitType.BACK;

    /* JADX INFO: compiled from: source.java */
    public enum ExitType {
        BACK(0, "返回"),
        REFRESH(1, "刷新"),
        CLOSE_APP(2, "关闭小程序"),
        PRIVACY_REFUSE(3, "隐私拒绝"),
        NEW_PAGE_ENTER(4, "新页面进入"),
        BACK_CLEAR_PRE_PAGE(5, "退出并清除上一页");

        int code;
        String des;

        ExitType(int i11, String str) {
            this.code = i11;
            this.des = str;
        }

        public int getCode() {
            return this.code;
        }

        public String getDes() {
            return this.des;
        }
    }

    public abstract Boolean g0();

    @Override // tb.d
    @Nullable
    public /* bridge */ /* synthetic */ Activity getActivity() {
        return super.getActivity();
    }

    @Nullable
    public Page h0() {
        return this.f30954a;
    }

    public void i0(ExitType exitType) {
        this.f30957d = exitType;
    }

    public abstract void j0(@NonNull Page page);
}
