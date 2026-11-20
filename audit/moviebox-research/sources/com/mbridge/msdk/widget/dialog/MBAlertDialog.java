package com.mbridge.msdk.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.al;
import com.mbridge.msdk.foundation.tools.v;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class MBAlertDialog extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Button f48612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Button f48613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f48614c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f48615d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TextView f48616e;

    public MBAlertDialog(Context context, final a aVar) {
        super(context);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        requestWindowFeature(1);
        View viewInflate = LayoutInflater.from(context).inflate(v.a(context, "mbridge_cm_alertview", TtmlNode.TAG_LAYOUT), (ViewGroup) null);
        this.f48615d = aVar;
        if (viewInflate != null) {
            setContentView(viewInflate);
            try {
                this.f48616e = (TextView) viewInflate.findViewById(v.a(context, "mbridge_video_common_alertview_titleview", "id"));
            } catch (Exception e11) {
                ad.a("MBAlertDialog", e11.getMessage());
            }
            try {
                this.f48614c = (TextView) viewInflate.findViewById(v.a(context, "mbridge_video_common_alertview_contentview", "id"));
                this.f48613b = (Button) viewInflate.findViewById(v.a(context, "mbridge_video_common_alertview_confirm_button", "id"));
                this.f48612a = (Button) viewInflate.findViewById(v.a(context, "mbridge_video_common_alertview_cancel_button", "id"));
            } catch (Exception e12) {
                ad.a("MBAlertDialog", e12.getMessage());
            }
        }
        Button button = this.f48612a;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.widget.dialog.MBAlertDialog.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a();
                    }
                    MBAlertDialog.this.cancel();
                    MBAlertDialog.this.clear();
                }
            });
        }
        Button button2 = this.f48613b;
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.widget.dialog.MBAlertDialog.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.b();
                    }
                    MBAlertDialog.this.cancel();
                    MBAlertDialog.this.clear();
                }
            });
        }
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    private void a(String str, String str2, String str3, String str4) {
        setTitle(str);
        setContent(str2);
        setConfirmText(str3);
        setCancelText(str4);
    }

    public void clear() {
        if (this.f48615d != null) {
            this.f48615d = null;
        }
    }

    public a getListener() {
        return this.f48615d;
    }

    public void hideNavigationBar(Window window) {
        if (window != null) {
            window.setFlags(1024, 1024);
            int i11 = Build.VERSION.SDK_INT;
            window.addFlags(67108864);
            window.getDecorView().setSystemUiVisibility(InputDeviceCompat.SOURCE_TOUCHSCREEN);
            if (i11 >= 28) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                window.setAttributes(attributes);
            }
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(-1, -1);
            window.setGravity(17);
        }
    }

    public void makeDownloadAlert(String str) {
    }

    public void makeIVAlertView(int i11, String str) {
        try {
            String string = al.a(getContext(), "MBridge_ConfirmTitle" + str, "").toString();
            String string2 = al.a(getContext(), "MBridge_ConfirmContent" + str, "").toString();
            String string3 = al.a(getContext(), "MBridge_CancelText" + str, "").toString();
            String string4 = al.a(getContext(), "MBridge_ConfirmText" + str, "").toString();
            if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2) && TextUtils.isEmpty(string3) && TextUtils.isEmpty(string4)) {
                String language = Locale.getDefault().getLanguage();
                if (TextUtils.isEmpty(language) || !language.equals("zh")) {
                    setTitle(i11 == com.mbridge.msdk.foundation.same.a.G ? "Confirm" : "Tips");
                    setContent(i11 == com.mbridge.msdk.foundation.same.a.G ? "If you choose to continue, you will receive a reward after the end. Confirm closed?" : "If you choose to continue, you will receive a reward after the end. Whether to continue?");
                    setConfirmText(i11 == com.mbridge.msdk.foundation.same.a.G ? "Close" : "Cancel");
                    setCancelText("Continue");
                } else {
                    setTitle(i11 == com.mbridge.msdk.foundation.same.a.G ? "确认关闭？" : "提示");
                    setContent(i11 == com.mbridge.msdk.foundation.same.a.G ? "如果你选择继续，结束后将会获得奖励。确认关闭吗？" : "如果你选择继续，结束后将会获得奖励。是否继续？");
                    setConfirmText(i11 == com.mbridge.msdk.foundation.same.a.G ? "确认关闭" : "取消");
                    setCancelText("继续");
                }
            } else {
                a(string, string2, string3, string4);
            }
        } catch (Exception e11) {
            ad.a("MBAlertDialog", e11.getMessage());
        }
    }

    public void makeInsAlert(String str) {
    }

    public void makePlayableAlertView() {
        g gVarB = h.a().b(c.m().k());
        if (gVarB != null) {
            a(gVarB.w(), gVarB.u(), gVarB.v(), gVarB.s());
            return;
        }
        String language = Locale.getDefault().getLanguage();
        if (TextUtils.isEmpty(language) || !language.equals("zh")) {
            setTitle("Confirm to close? ");
            setContent("You will not be rewarded after closing the window");
            setConfirmText("Close it");
            setCancelText("Continue");
            return;
        }
        setTitle("确认关闭？");
        setContent("关闭后您将不会获得任何奖励噢~ ");
        setConfirmText("确认关闭");
        setCancelText("继续试玩");
    }

    public void makeRVAlertView(String str) {
        try {
            String string = al.a(getContext(), "MBridge_ConfirmTitle" + str, "").toString();
            String string2 = al.a(getContext(), "MBridge_ConfirmContent" + str, "").toString();
            String string3 = al.a(getContext(), "MBridge_CancelText" + str, "").toString();
            String string4 = al.a(getContext(), "MBridge_ConfirmText" + str, "").toString();
            g gVarB = h.a().b(c.m().k());
            if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2) && TextUtils.isEmpty(string3) && TextUtils.isEmpty(string4)) {
                if (gVarB != null) {
                    a(gVarB.w(), gVarB.u(), gVarB.v(), gVarB.t());
                    return;
                }
                String language = Locale.getDefault().getLanguage();
                if (TextUtils.isEmpty(language) || !language.equals("zh")) {
                    setTitle("Confirm to close? ");
                    setContent("You will not be rewarded after closing the window");
                    setConfirmText("Close it");
                    setCancelText("Continue");
                    return;
                }
                setTitle("确认关闭？");
                setContent("关闭后您将不会获得任何奖励噢~ ");
                setConfirmText("确认关闭");
                setCancelText("继续观看");
                return;
            }
            String language2 = Locale.getDefault().getLanguage();
            if (TextUtils.isEmpty(string)) {
                if (gVarB != null) {
                    string = gVarB.w();
                } else if (TextUtils.isEmpty(language2) || !language2.equals("zh")) {
                    setTitle("Confirm to close? ");
                } else {
                    setTitle("确认关闭？");
                }
            }
            if (TextUtils.isEmpty(string2)) {
                if (gVarB != null) {
                    string2 = gVarB.u();
                } else if (TextUtils.isEmpty(language2) || !language2.equals("zh")) {
                    setContent("You will not be rewarded after closing the window");
                } else {
                    setContent("关闭后您将不会获得任何奖励噢~ ");
                }
            }
            if (TextUtils.isEmpty(string4)) {
                if (gVarB != null) {
                    string4 = gVarB.v();
                } else if (TextUtils.isEmpty(language2) || !language2.equals("zh")) {
                    setConfirmText("Close it");
                } else {
                    setConfirmText("确认关闭");
                }
            }
            if (TextUtils.isEmpty(string3)) {
                if (gVarB != null) {
                    string3 = gVarB.t();
                } else if (TextUtils.isEmpty(language2) || !language2.equals("zh")) {
                    setCancelText("Continue");
                } else {
                    setCancelText("继续观看");
                }
            }
            a(string, string2, string4, string3);
        } catch (Exception e11) {
            ad.a("MBAlertDialog", e11.getMessage());
        }
    }

    public void onlyShow() {
        super.show();
    }

    public void setCancelText(String str) {
        Button button = this.f48612a;
        if (button != null) {
            button.setText(str);
        }
    }

    public void setConfirmText(String str) {
        Button button = this.f48613b;
        if (button != null) {
            button.setText(str);
        }
    }

    public void setContent(String str) {
        TextView textView = this.f48614c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setTitle(String str) {
        TextView textView = this.f48616e;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        try {
            getWindow().setFlags(8, 8);
            super.show();
            hideNavigationBar(getWindow());
            getWindow().clearFlags(8);
        } catch (Exception e11) {
            ad.b("MBAlertDialog", e11.getMessage());
            super.show();
        }
    }
}
