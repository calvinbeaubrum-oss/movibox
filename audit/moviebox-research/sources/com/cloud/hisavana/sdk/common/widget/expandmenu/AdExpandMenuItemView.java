package com.cloud.hisavana.sdk.common.widget.expandmenu;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.cloud.hisavana.sdk.R$drawable;
import com.cloud.hisavana.sdk.R$id;
import com.cloud.hisavana.sdk.R$layout;
import com.cloud.hisavana.sdk.R$string;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class AdExpandMenuItemView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f29543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f29544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f29545c;

    /* JADX INFO: compiled from: source.java */
    public enum Type {
        PERSONALISE_CLOSE,
        ADVERTISER_INFO,
        COPY_LINK
    }

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f29546a;

        static {
            int[] iArr = new int[Type.values().length];
            f29546a = iArr;
            try {
                iArr[Type.PERSONALISE_CLOSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29546a[Type.ADVERTISER_INFO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f29546a[Type.COPY_LINK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public AdExpandMenuItemView(Context context) {
        this(context, null, 0);
    }

    public AdExpandMenuItemView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdExpandMenuItemView(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        LayoutInflater.from(context).inflate(R$layout.ad_expand_menu_item_layout, this);
        a();
    }

    public final void a() {
        this.f29543a = (ImageView) findViewById(R$id.left_image_view);
        this.f29544b = (TextView) findViewById(R$id.message_text_view);
        this.f29545c = (ImageView) findViewById(R$id.right_image_view);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int color;
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || action == 3) {
                color = -1;
            }
            return super.onTouchEvent(motionEvent);
        }
        color = Color.parseColor("#F7F7F8");
        setBackgroundColor(color);
        return super.onTouchEvent(motionEvent);
    }

    public void setData(Type type) {
        TextView textView;
        int i11;
        if (this.f29543a == null || this.f29544b == null || this.f29545c == null) {
            return;
        }
        int i12 = a.f29546a[type.ordinal()];
        if (i12 == 1) {
            this.f29543a.setImageResource(R$drawable.heart);
            textView = this.f29544b;
            i11 = R$string.interstitial_close;
        } else {
            if (i12 != 2) {
                if (i12 != 3) {
                    return;
                }
                this.f29543a.setImageResource(R$drawable.link);
                this.f29544b.setText(R$string.copy_link);
                this.f29545c.setVisibility(8);
                return;
            }
            this.f29543a.setImageResource(R$drawable.info);
            textView = this.f29544b;
            i11 = R$string.about_the_advertiser;
        }
        textView.setText(i11);
        this.f29545c.setVisibility(0);
    }
}
