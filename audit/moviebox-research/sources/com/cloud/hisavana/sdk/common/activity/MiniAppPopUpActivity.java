package com.cloud.hisavana.sdk.common.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.cloud.hisavana.sdk.R$id;
import com.cloud.hisavana.sdk.R$layout;
import com.cloud.hisavana.sdk.common.bean.MiniAppInfo;
import com.cloud.hisavana.sdk.common.http.DownLoadRequest;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class MiniAppPopUpActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f29258c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MiniAppInfo f29259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f29260b = 1;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a();

        void b();

        void c();
    }

    private void S() {
        if (this.f29259a == null) {
            return;
        }
        DownLoadRequest.p(this.f29259a.getIconUrl(), null, 13, null, (ImageView) findViewById(R$id.icon));
        ((TextView) findViewById(R$id.name)).setText(this.f29259a.getName());
        ImageView imageView = (ImageView) findViewById(R$id.category_icon);
        if (TextUtils.isEmpty(this.f29259a.getCategoryIconUrl())) {
            imageView.setVisibility(8);
        } else {
            DownLoadRequest.p(this.f29259a.getCategoryIconUrl(), null, 13, null, imageView);
        }
        ((TextView) findViewById(R$id.category)).setText(this.f29259a.getCategory());
        ((TextView) findViewById(R$id.ratings)).setText(String.valueOf(this.f29259a.getRatings()));
        ((TextView) findViewById(R$id.users)).setText(Q(W(this.f29259a.getUsers())));
        ((TextView) findViewById(R$id.size)).setText(Q(R(this.f29259a.getSize())));
        ((TextView) findViewById(R$id.description)).setText(String.valueOf(this.f29259a.getDescription()));
        Button button = (Button) findViewById(R$id.action_button);
        button.setText(this.f29259a.getActionName());
        button.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.hisavana.sdk.common.activity.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f29368a.U(view);
            }
        });
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.cloud.hisavana.sdk.common.activity.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f29369a.Y(view);
            }
        };
        boolean z11 = this.f29260b == 1;
        ImageView imageView2 = (ImageView) findViewById(R$id.cancel_button);
        imageView2.setVisibility(z11 ? 0 : 8);
        imageView2.setOnClickListener(onClickListener);
        View viewFindViewById = findViewById(R$id.cancel_button_bottom);
        viewFindViewById.setVisibility(z11 ? 8 : 0);
        viewFindViewById.setOnClickListener(onClickListener);
        View viewFindViewById2 = findViewById(R$id.skip_button);
        viewFindViewById2.setVisibility(z11 ? 8 : 0);
        viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.hisavana.sdk.common.activity.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f29370a.Z(view);
            }
        });
    }

    public static void T(Context context, MiniAppInfo miniAppInfo, int i11, a aVar) {
        if (context == null || miniAppInfo == null) {
            return;
        }
        try {
            f29258c = aVar;
            Intent intent = new Intent(context, (Class<?>) MiniAppPopUpActivity.class);
            intent.addFlags(ASTNode.DEOP);
            Bundle bundle = new Bundle();
            bundle.putParcelable("mini_app_info_key", miniAppInfo);
            intent.putExtras(bundle);
            intent.putExtra(TtmlNode.TAG_STYLE, i11);
            context.startActivity(intent);
        } catch (Exception unused) {
            com.cloud.hisavana.sdk.z.a().e("MiniApp", "Failed to start mini app guide.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(View view) {
        a aVar = f29258c;
        if (aVar != null) {
            aVar.c();
            f29258c = null;
        }
        finish();
    }

    private void X() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        Parcelable parcelableExtra = intent.getParcelableExtra("mini_app_info_key");
        if (parcelableExtra instanceof MiniAppInfo) {
            this.f29259a = (MiniAppInfo) parcelableExtra;
            this.f29260b = intent.getIntExtra(TtmlNode.TAG_STYLE, 1);
        }
    }

    public final SpannableString Q(String str) {
        if (TextUtils.isEmpty(str)) {
            return new SpannableString("");
        }
        int iV = V(str);
        SpannableString spannableString = new SpannableString(str);
        try {
            spannableString.setSpan(new AbsoluteSizeSpan(com.cloud.sdk.commonutil.util.j.i(16.0f)), 0, iV, 33);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#0F1A2F")), 0, iV, 33);
            spannableString.setSpan(new AbsoluteSizeSpan(com.cloud.sdk.commonutil.util.j.i(12.0f)), iV, str.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#6F7682")), iV, str.length(), 33);
        } catch (Exception unused) {
        }
        return spannableString;
    }

    public final String R(long j11) {
        try {
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            decimalFormat.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.US));
            if (j11 > 1073741824) {
                return decimalFormat.format(j11 / 1.0737418E9f) + "GB";
            }
            return decimalFormat.format(Math.max(0.01d, j11 / 1048576.0f)) + "MB";
        } catch (Exception unused) {
            return "";
        }
    }

    public final int V(String str) {
        for (int i11 = 0; i11 < str.length(); i11++) {
            try {
                char cCharAt = str.charAt(i11);
                if (!Character.isDigit(cCharAt) && cCharAt != '.') {
                    return i11;
                }
            } catch (Exception unused) {
            }
        }
        return str.length();
    }

    public final String W(long j11) {
        try {
            DecimalFormat decimalFormat = new DecimalFormat("#.#");
            decimalFormat.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.US));
            if (j11 < 1000) {
                return String.valueOf(j11);
            }
            if (j11 < 1000000) {
                return decimalFormat.format(j11 / 1000.0f) + "K";
            }
            return decimalFormat.format(j11 / 1000000.0f) + "M";
        } catch (Exception unused) {
            return "";
        }
    }

    public final /* synthetic */ void Y(View view) {
        a aVar = f29258c;
        if (aVar != null) {
            aVar.b();
            f29258c = null;
        }
        finish();
    }

    public final /* synthetic */ void Z(View view) {
        a aVar = f29258c;
        if (aVar != null) {
            aVar.a();
            f29258c = null;
        }
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_mini_app_popup);
        X();
        S();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        a aVar = f29258c;
        if (aVar != null) {
            aVar.b();
            f29258c = null;
        }
        super.onDestroy();
    }
}
