package com.mbridge.msdk.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.v;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class MBFeedBackDialog extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Button f48621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Button f48622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LinearLayout f48623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f48624d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Button f48625e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextView f48626f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f48627g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f48628h;

    public MBFeedBackDialog(Context context, a aVar) {
        super(context);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        requestWindowFeature(1);
        View viewInflate = LayoutInflater.from(context).inflate(v.a(context, "mbridge_cm_feedbackview", TtmlNode.TAG_LAYOUT), (ViewGroup) null);
        setDialogWidthAndHeight(0.5f, 0.8f);
        this.f48624d = aVar;
        if (viewInflate != null) {
            setContentView(viewInflate);
            try {
                this.f48626f = (TextView) viewInflate.findViewById(v.a(context, "mbridge_video_common_alertview_titleview", "id"));
            } catch (Exception e11) {
                ad.a("MBAlertDialog", e11.getMessage());
            }
            try {
                this.f48623c = (LinearLayout) viewInflate.findViewById(v.a(context, "mbridge_video_common_alertview_contentview", "id"));
                this.f48622b = (Button) viewInflate.findViewById(v.a(context, "mbridge_video_common_alertview_confirm_button", "id"));
                this.f48621a = (Button) viewInflate.findViewById(v.a(context, "mbridge_video_common_alertview_cancel_button", "id"));
                this.f48625e = (Button) viewInflate.findViewById(v.a(context, "mbridge_video_common_alertview_private_action_button", "id"));
            } catch (Exception e12) {
                ad.a("MBAlertDialog", e12.getMessage());
            }
        }
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        Button button = this.f48621a;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.widget.dialog.MBFeedBackDialog.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (MBFeedBackDialog.this.f48624d != null) {
                        MBFeedBackDialog.this.f48624d.a();
                    }
                    MBFeedBackDialog.this.dismiss();
                }
            });
        }
        Button button2 = this.f48622b;
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.widget.dialog.MBFeedBackDialog.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (MBFeedBackDialog.this.f48624d != null) {
                        MBFeedBackDialog.this.f48624d.b();
                    }
                    MBFeedBackDialog.this.dismiss();
                }
            });
        }
        Button button3 = this.f48625e;
        if (button3 != null) {
            button3.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.widget.dialog.MBFeedBackDialog.3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MBFeedBackDialog.this.dismiss();
                    if (MBFeedBackDialog.this.f48624d != null) {
                        MBFeedBackDialog.this.f48624d.c();
                    }
                }
            });
        }
        setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.mbridge.msdk.widget.dialog.MBFeedBackDialog.4
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                if (MBFeedBackDialog.this.f48624d != null) {
                    MBFeedBackDialog.this.f48624d.b();
                }
            }
        });
    }

    public static boolean isScreenOrientationPortrait(Context context) {
        return context.getResources().getConfiguration().orientation == 1;
    }

    public void clear() {
        if (this.f48624d != null) {
            this.f48624d = null;
        }
    }

    public a getListener() {
        return this.f48624d;
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

    public void setCancelButtonClickable(boolean z11) {
        Button button = this.f48621a;
        if (button != null) {
            button.setClickable(z11);
            if (z11) {
                this.f48621a.setBackgroundResource(getContext().getResources().getIdentifier("mbridge_cm_feedback_choice_btn_bg_pressed", "drawable", c.m().g()));
                this.f48621a.setAlpha(1.0f);
            } else {
                this.f48621a.setBackgroundResource(getContext().getResources().getIdentifier("mbridge_cm_feedback_choice_btn_bg_pressed", "drawable", c.m().g()));
                this.f48621a.setAlpha(0.4f);
            }
        }
    }

    public void setCancelText(String str) {
        Button button = this.f48621a;
        if (button != null) {
            button.setText(str);
        }
    }

    public void setConfirmText(String str) {
    }

    public void setContent(ViewGroup viewGroup) {
        LinearLayout linearLayout = this.f48623c;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(viewGroup);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.leftMargin = ai.a(c.m().c(), 16.0f);
            layoutParams.rightMargin = ai.a(c.m().c(), 16.0f);
            layoutParams.topMargin = ai.a(c.m().c(), 3.0f);
            layoutParams.bottomMargin = ai.a(c.m().c(), 3.0f);
            this.f48623c.addView(viewGroup, layoutParams);
        }
    }

    public void setDialogWidthAndHeight(float f11, float f12) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        if (!isScreenOrientationPortrait(getContext())) {
            this.f48628h = displayMetrics.heightPixels;
            this.f48627g = displayMetrics.widthPixels;
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = (int) (this.f48627g * f11);
            attributes.height = -1;
            attributes.gravity = 17;
            getWindow().setAttributes(attributes);
            return;
        }
        this.f48628h = displayMetrics.widthPixels;
        this.f48627g = displayMetrics.heightPixels;
        WindowManager.LayoutParams attributes2 = getWindow().getAttributes();
        int i11 = (int) (this.f48627g * f12);
        attributes2.width = -1;
        attributes2.height = i11;
        attributes2.gravity = 80;
        getWindow().setAttributes(attributes2);
    }

    public void setListener(a aVar) {
        this.f48624d = aVar;
    }

    public void setPrivacyText(String str) {
        Button button = this.f48625e;
        if (button != null) {
            button.setText(str);
        }
    }

    public void setTitle(String str) {
        TextView textView = this.f48626f;
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
