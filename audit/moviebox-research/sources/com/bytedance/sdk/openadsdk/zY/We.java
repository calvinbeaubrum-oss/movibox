package com.bytedance.sdk.openadsdk.zY;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.sdk.component.utils.Sfl;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.utils.kX;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class We extends TTDislikeDialogAbstract {
    private String ExN;
    private sc We;

    /* JADX INFO: compiled from: source.java */
    public interface sc {
        void pFF();

        void sc();

        void sc(int i11, FilterWord filterWord);
    }

    public We(Context context, String str, List<FilterWord> list, String str2) {
        super(context, Sfl.TRI(context, "tt_dislikeDialog"), str2);
        this.f27284sc = str;
        this.pFF = list;
    }

    private void pFF() {
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.bytedance.sdk.openadsdk.zY.We.1
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (We.this.We != null) {
                    sc unused = We.this.We;
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.sdk.openadsdk.zY.We.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (We.this.We != null) {
                    We.this.We.pFF();
                }
            }
        });
    }

    private void sc() {
        Window window = getWindow();
        if (window == null || window.getAttributes() == null) {
            return;
        }
        window.getAttributes().windowAnimations = 0;
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract
    public ViewGroup.LayoutParams getLayoutParams() {
        return new ViewGroup.LayoutParams(kX.zY(getContext()) - 120, -2);
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract
    public View getLayoutView() {
        return new Ol(getContext(), this.zY, this.pFF);
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract, android.app.Dialog
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            setCanceledOnTouchOutside(true);
            setCancelable(true);
            sc();
            pFF();
            setMaterialMeta(this.f27284sc, this.pFF);
        } catch (Throwable unused) {
            dismiss();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zY.WH.pFF
    public void sc(int i11) {
        FilterWord filterWordPFF;
        if (WH.zY == i11) {
            dismiss();
            return;
        }
        if (WH.ExN == i11) {
            sc scVar = this.We;
            if (scVar != null) {
                scVar.sc();
                return;
            }
            return;
        }
        if (WH.pFF != i11 || (filterWordPFF = this.zY.pFF()) == null || WH.f28815sc.equals(filterWordPFF)) {
            return;
        }
        sc scVar2 = this.We;
        if (scVar2 != null) {
            try {
                scVar2.sc(0, filterWordPFF);
            } catch (Throwable unused) {
            }
        }
        dismiss();
    }

    public void sc(sc scVar) {
        this.We = scVar;
    }

    public void sc(String str) {
        this.ExN = str;
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
        } catch (WindowManager.BadTokenException unused) {
        }
    }
}
