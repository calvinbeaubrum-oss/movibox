package bz;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.e0;
import androidx.lifecycle.t;
import androidx.lifecycle.u;
import com.blankj.utilcode.util.h;
import com.tn.lib.widget.R$color;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.R$string;
import com.transsion.usercenter.R$style;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b implements View.OnClickListener, t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f14523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f14524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f14525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f14526d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f14527f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.google.android.material.bottomsheet.b f14528g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f14529h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f14530i;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void onDialogSelect(int i11, String str);
    }

    public b(Activity activity, a aVar, String str) {
        this.f14523a = activity;
        this.f14527f = aVar;
        this.f14529h = str;
        a();
    }

    private void a() {
        View viewInflate = LayoutInflater.from(this.f14523a).inflate(R$layout.dialog_edit_gender, (ViewGroup) null);
        this.f14524b = (TextView) viewInflate.findViewById(R$id.tv_first);
        this.f14525c = (TextView) viewInflate.findViewById(R$id.tv_second);
        this.f14526d = (TextView) viewInflate.findViewById(R$id.tv_third);
        this.f14524b.setOnClickListener(this);
        this.f14525c.setOnClickListener(this);
        this.f14526d.setOnClickListener(this);
        com.google.android.material.bottomsheet.b bVar = new com.google.android.material.bottomsheet.b(this.f14523a, R$style.BottomDialog1);
        this.f14528g = bVar;
        bVar.getWindow().setWindowAnimations(R$style.bottom_dialog_animation);
        this.f14528g.setContentView(viewInflate);
    }

    public void b() {
        if (TextUtils.equals(this.f14529h, this.f14523a.getString(R$string.profile_female))) {
            this.f14524b.setTextColor(h.a(R$color.white));
            this.f14525c.setTextColor(h.a(R$color.text_03));
            this.f14526d.setTextColor(h.a(R$color.text_03));
        } else if (TextUtils.equals(this.f14529h, this.f14523a.getString(R$string.profile_male))) {
            this.f14525c.setTextColor(h.a(R$color.white));
            this.f14524b.setTextColor(h.a(R$color.text_03));
            this.f14526d.setTextColor(h.a(R$color.text_03));
        } else {
            this.f14526d.setTextColor(h.a(R$color.white));
            this.f14524b.setTextColor(h.a(R$color.text_03));
            this.f14525c.setTextColor(h.a(R$color.text_03));
        }
        this.f14524b.setText(R$string.profile_female);
        this.f14525c.setText(R$string.profile_male);
        this.f14526d.setText(R$string.profile_gender_other);
        this.f14528g.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R$id.tv_first) {
            a aVar = this.f14527f;
            if (aVar != null) {
                aVar.onDialogSelect(0, this.f14524b.getText().toString());
                this.f14528g.dismiss();
                return;
            }
            return;
        }
        if (id2 != R$id.tv_second) {
            if (id2 == R$id.tv_third) {
                this.f14527f.onDialogSelect(2, this.f14526d.getText().toString());
                this.f14528g.dismiss();
                return;
            }
            return;
        }
        a aVar2 = this.f14527f;
        if (aVar2 != null) {
            aVar2.onDialogSelect(1, this.f14525c.getText().toString());
            this.f14528g.dismiss();
        }
    }

    @e0(Lifecycle.Event.ON_ANY)
    public void onLifecycleChanged(u uVar, Lifecycle.Event event) {
    }

    @e0(Lifecycle.Event.ON_PAUSE)
    public void onPause(u uVar) {
        this.f14530i = false;
    }

    @e0(Lifecycle.Event.ON_RESUME)
    public void onResume(u uVar) {
        this.f14530i = true;
    }
}
