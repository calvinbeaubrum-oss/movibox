package jd;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.cloud.tmc.ad.R$id;
import com.cloud.tmc.ad.R$layout;
import com.cloud.tmc.ad.bean.AdClickBean;
import com.cloud.tmc.ad.bean.AdShowBean;
import com.cloud.tmc.ad.bean.AdStyleBean;
import com.cloud.tmc.ad.bean.DownUpPointBean;
import com.cloud.tmc.integration.utils.u;
import com.cloud.tmc.miniutils.util.w;
import com.cloud.tmc.miniutils.util.x;
import java.io.File;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.l;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class f extends b {
    public ia.a A;
    public ConstraintLayout B;
    public ImageView C;
    public ImageView D;
    public ImageView E;
    public ImageView F;
    public TextView G;
    public TextView H;
    public TextView I;
    public ImageView J;
    public float K;
    public float L;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f67992z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context, String triggerId, String mainImgUrl, String str, String str2, String str3, String str4, AdStyleBean styleBean, ia.a aVar) {
        float f11;
        ImageView imageView;
        TextView textView;
        TextView textView2;
        TextView textView3;
        super(context);
        Intrinsics.g(context, "context");
        Intrinsics.g(triggerId, "triggerId");
        Intrinsics.g(mainImgUrl, "mainImgUrl");
        Intrinsics.g(styleBean, "styleBean");
        this.f67992z = triggerId;
        this.A = aVar;
        try {
            j(R$layout.view_interstitial_json_all_styles);
            n(false);
            b(-1);
            this.B = (ConstraintLayout) findViewById(R$id.cl_content);
            this.C = (ImageView) findViewById(R$id.iv_main);
            this.D = (ImageView) findViewById(R$id.iv_ad);
            this.E = (ImageView) findViewById(R$id.iv_homepage);
            this.F = (ImageView) findViewById(R$id.iv_logo);
            this.J = (ImageView) findViewById(R$id.iv_close);
            this.G = (TextView) findViewById(R$id.tv_title);
            this.H = (TextView) findViewById(R$id.tv_content);
            this.I = (TextView) findViewById(R$id.tv_next);
            if (styleBean.getShowTitle() && !TextUtils.isEmpty(str2) && (textView3 = this.G) != null) {
                textView3.setVisibility(0);
                textView3.setText(str2);
                TextPaint paint = textView3.getPaint();
                if (paint != null) {
                    paint.setFakeBoldText(true);
                }
            }
            if (styleBean.getShowDescript() && !TextUtils.isEmpty(str3) && (textView2 = this.H) != null) {
                textView2.setVisibility(0);
                textView2.setText(str3);
            }
            if (styleBean.getShowButton() && !TextUtils.isEmpty(str4) && (textView = this.I) != null) {
                textView.setVisibility(0);
                textView.setText(str4);
            }
            if (styleBean.getShowLogo() && !TextUtils.isEmpty(str) && new File(str).exists() && (imageView = this.F) != null) {
                RequestOptions requestOptionsTransform = new RequestOptions().transform(new ja.b(x.a(8.0f), x.a(8.0f), x.a(8.0f), x.a(8.0f)));
                Intrinsics.f(requestOptionsTransform, "RequestOptions()\n       …                        )");
                imageView.setVisibility(0);
                Glide.with(context).load2(str).placeholder(Drawable.createFromPath(str)).apply((BaseRequestOptions<?>) requestOptionsTransform).into(imageView);
            }
            if (!TextUtils.isEmpty(mainImgUrl) && new File(mainImgUrl).exists()) {
                float f12 = l.u(mainImgUrl, "gif", false, 2, null) ? 1.0f : 8.0f;
                if (styleBean.getShowButton() || styleBean.getShowLogo() || styleBean.getShowTitle() || styleBean.getShowDescript()) {
                    f11 = 0.0f;
                } else {
                    f11 = l.u(mainImgUrl, "gif", false, 2, null) ? 1.0f : 8.0f;
                    ConstraintLayout.b bVar = new ConstraintLayout.b(-1, -2);
                    ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = 0;
                    ImageView imageView2 = this.C;
                    if (imageView2 != null) {
                        imageView2.setLayoutParams(bVar);
                    }
                }
                ImageView imageView3 = this.C;
                if (imageView3 != null) {
                    RequestOptions requestOptionsTransform2 = new RequestOptions().transform(new ja.b(x.a(f12), x.a(f12), x.a(f11), x.a(f11)));
                    Intrinsics.f(requestOptionsTransform2, "RequestOptions()\n       …                        )");
                    RequestOptions requestOptions = requestOptionsTransform2;
                    imageView3.setMaxHeight((int) (((double) w.b()) * 0.72d));
                    if (l.u(mainImgUrl, "gif", false, 2, null)) {
                        Intrinsics.f(Glide.with(context).asGif().placeholder(Drawable.createFromPath(mainImgUrl)).load2(mainImgUrl).apply((BaseRequestOptions<?>) requestOptions).into(imageView3), "{\n                      …                        }");
                    } else {
                        Intrinsics.f(Glide.with(context).load2(mainImgUrl).placeholder(Drawable.createFromPath(mainImgUrl)).apply((BaseRequestOptions<?>) requestOptions).into(imageView3), "{\n                      …                        }");
                    }
                }
            }
            ia.a aVar2 = this.A;
            if (aVar2 != null) {
                aVar2.b(triggerId, true);
            }
            u(this.D, this.E, this.J);
            ConstraintLayout constraintLayout = this.B;
            if (constraintLayout != null) {
                constraintLayout.setOnTouchListener(new View.OnTouchListener() { // from class: jd.e
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        return f.C(this.f67991a, view, motionEvent);
                    }
                });
            }
        } catch (Throwable unused) {
            ia.a aVar3 = this.A;
            if (aVar3 != null) {
                aVar3.b(this.f67992z, false);
            }
        }
    }

    public static final boolean C(f this$0, View view, MotionEvent motionEvent) {
        Intrinsics.g(this$0, "this$0");
        int action = motionEvent.getAction();
        if (action == 0) {
            this$0.K = motionEvent.getX();
            this$0.L = motionEvent.getY();
        } else if (action == 1 && motionEvent.getX() >= 0.0f && motionEvent.getX() <= view.getWidth() && motionEvent.getY() >= 0.0f && motionEvent.getY() <= view.getHeight()) {
            DownUpPointBean downUpPointBean = new DownUpPointBean(this$0.K, this$0.L, motionEvent.getX(), motionEvent.getY(), view.getHeight(), view.getWidth());
            ia.a aVar = this$0.A;
            if (aVar != null) {
                ia.a.C0707a.a(aVar, this$0.f67992z, downUpPointBean, null, 4, null);
            }
        }
        return true;
    }

    @Override // jd.b
    public int A() {
        ConstraintLayout constraintLayout = this.B;
        if (constraintLayout != null) {
            return constraintLayout.getWidth();
        }
        return 0;
    }

    @Override // OooO0o0.OooO0OO.OooO00o, android.view.View.OnClickListener
    public void onClick(View view) {
        ia.a aVar;
        Intrinsics.g(view, "view");
        if (u.a()) {
            return;
        }
        if (Intrinsics.b(view, this.D)) {
            ia.a aVar2 = this.A;
            if (aVar2 != null) {
                aVar2.e(this.f67992z);
                return;
            }
            return;
        }
        if (Intrinsics.b(view, this.E)) {
            ia.a aVar3 = this.A;
            if (aVar3 != null) {
                aVar3.d(this.f67992z);
                return;
            }
            return;
        }
        if (!Intrinsics.b(view, this.J) || (aVar = this.A) == null) {
            return;
        }
        String str = this.f67992z;
        AdClickBean adClickBean = new AdClickBean(0, 0L, null, 7, null);
        adClickBean.setShowTimes(this.f67981u);
        adClickBean.setShowDuration(System.currentTimeMillis() - adClickBean.getShowDuration());
        StringBuilder sb2 = new StringBuilder();
        ConstraintLayout constraintLayout = this.B;
        sb2.append(constraintLayout != null ? Integer.valueOf(constraintLayout.getWidth()) : null);
        sb2.append('*');
        ConstraintLayout constraintLayout2 = this.B;
        sb2.append(constraintLayout2 != null ? Integer.valueOf(constraintLayout2.getHeight()) : null);
        adClickBean.setShowArea(sb2.toString());
        Unit unit = Unit.f68710a;
        aVar.a(str, adClickBean);
    }

    @Override // jd.b
    public void w(AdShowBean adShowBean) {
        Intrinsics.g(adShowBean, "adShowBean");
        ia.a aVar = this.A;
        if (aVar != null) {
            aVar.c(this.f67992z, true, adShowBean);
        }
    }

    @Override // jd.b
    public int z() {
        ConstraintLayout constraintLayout = this.B;
        if (constraintLayout != null) {
            return constraintLayout.getHeight();
        }
        return 0;
    }
}
