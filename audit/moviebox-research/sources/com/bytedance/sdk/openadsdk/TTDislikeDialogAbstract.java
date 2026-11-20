package com.bytedance.sdk.openadsdk;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.zY.WH;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class TTDislikeDialogAbstract extends Dialog implements WH.pFF {
    private String ExN;
    private View We;
    protected List<FilterWord> pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected String f27284sc;
    protected final WH zY;

    public TTDislikeDialogAbstract(@NonNull Context context) {
        super(context);
        WH wh2 = new WH();
        this.zY = wh2;
        wh2.sc(this);
    }

    public TTDislikeDialogAbstract(@NonNull Context context, int i11, String str) {
        super(context, i11);
        this.ExN = str;
        WH wh2 = new WH();
        this.zY = wh2;
        wh2.sc(this);
    }

    public void destroy() {
        WH wh2 = this.zY;
        if (wh2 != null) {
            wh2.sc();
        }
    }

    public WH getDislikeManager() {
        return this.zY;
    }

    public abstract ViewGroup.LayoutParams getLayoutParams();

    public abstract View getLayoutView();

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View layoutView = getLayoutView();
        this.We = layoutView;
        if (layoutView == null) {
            Tf.pFF("getLayoutView,layout  may be abnormal, please check");
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        View view = this.We;
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -1);
        }
        setContentView(view, layoutParams);
    }

    public void onSuggestionSubmit(String str) {
        WH wh2 = this.zY;
        if (wh2 != null) {
            wh2.zY(str);
        }
    }

    public void setMaterialMeta(String str, List<FilterWord> list) {
        this.f27284sc = str;
        this.pFF = list;
        this.zY.sc(str);
        this.zY.sc(this.pFF);
    }
}
