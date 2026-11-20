package com.bigkoo.pickerview.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bigkoo.pickerview.R$id;
import com.bigkoo.pickerview.R$layout;
import com.bigkoo.pickerview.R$string;
import g8.c;
import java.text.ParseException;
import java.util.Calendar;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class a extends BasePickerView implements View.OnClickListener {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public b f25185q;

    public a(f8.a aVar) {
        super(aVar.C);
        this.f25169f = aVar;
        y(aVar.C);
    }

    public void A() {
        if (this.f25169f.f64716a != null) {
            try {
                this.f25169f.f64716a.a(b.f25186y.parse(this.f25185q.o()), this.f25176m);
            } catch (ParseException e11) {
                e11.printStackTrace();
            }
        }
    }

    public void B(Calendar calendar) {
        this.f25169f.f64722g = calendar;
        F();
    }

    public void C() {
        c cVar = this.f25169f.f64716a;
        if (cVar != null) {
            cVar.a(null, this.f25176m);
        }
    }

    public final void D() {
        b bVar = this.f25185q;
        f8.a aVar = this.f25169f;
        bVar.E(aVar.f64723h, aVar.f64724i);
        x();
    }

    public final void E() {
        this.f25185q.H(this.f25169f.f64725j);
        this.f25185q.x(this.f25169f.f64726k);
    }

    public final void F() {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = this.f25169f.f64722g;
        if (calendar2 == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i11 = calendar.get(1);
            i12 = calendar.get(2);
            i13 = calendar.get(5);
            i14 = calendar.get(11);
            i15 = calendar.get(12);
            i16 = calendar.get(13);
        } else {
            i11 = calendar2.get(1);
            i12 = this.f25169f.f64722g.get(2);
            i13 = this.f25169f.f64722g.get(5);
            i14 = this.f25169f.f64722g.get(11);
            i15 = this.f25169f.f64722g.get(12);
            i16 = this.f25169f.f64722g.get(13);
        }
        this.f25185q.D(i11, i12, i13, i14, i15, i16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            A();
        } else {
            C();
        }
        f();
    }

    @Override // com.bigkoo.pickerview.view.BasePickerView
    public boolean p() {
        return this.f25169f.T;
    }

    public final void x() {
        f8.a aVar = this.f25169f;
        Calendar calendar = aVar.f64723h;
        if (calendar == null || aVar.f64724i == null) {
            if (calendar != null) {
                aVar.f64722g = calendar;
                return;
            }
            Calendar calendar2 = aVar.f64724i;
            if (calendar2 != null) {
                aVar.f64722g = calendar2;
                return;
            }
            return;
        }
        Calendar calendar3 = aVar.f64722g;
        if (calendar3 == null || calendar3.getTimeInMillis() < this.f25169f.f64723h.getTimeInMillis() || this.f25169f.f64722g.getTimeInMillis() > this.f25169f.f64724i.getTimeInMillis()) {
            f8.a aVar2 = this.f25169f;
            aVar2.f64722g = aVar2.f64723h;
        }
    }

    public final void y(Context context) {
        s();
        o();
        n();
        this.f25169f.getClass();
        LayoutInflater.from(context).inflate(R$layout.pickerview_time, this.f25166b);
        TextView textView = (TextView) findViewById(R$id.tvTitle);
        TextView textView2 = (TextView) findViewById(R$id.btnSubmit);
        TextView textView3 = (TextView) findViewById(R$id.tv_ok);
        TextView textView4 = (TextView) findViewById(R$id.btnCancel);
        textView2.setTag("submit");
        textView3.setTag("submit");
        textView4.setTag("cancel");
        textView2.setOnClickListener(this);
        textView3.setOnClickListener(this);
        textView4.setOnClickListener(this);
        textView2.setText(TextUtils.isEmpty(this.f25169f.D) ? context.getResources().getString(R$string.pickerview_submit) : this.f25169f.D);
        textView4.setText(TextUtils.isEmpty(this.f25169f.E) ? context.getResources().getString(R$string.pickerview_cancel) : this.f25169f.E);
        textView.setText(TextUtils.isEmpty(this.f25169f.F) ? "" : this.f25169f.F);
        textView.setTextColor(this.f25169f.I);
        textView.setTextSize(this.f25169f.M);
        z((LinearLayout) findViewById(R$id.timepicker));
    }

    public final void z(LinearLayout linearLayout) {
        int i11;
        f8.a aVar = this.f25169f;
        this.f25185q = new b(linearLayout, aVar.f64721f, aVar.B, aVar.N);
        this.f25169f.getClass();
        this.f25185q.C(this.f25169f.f64728m);
        f8.a aVar2 = this.f25169f;
        int i12 = aVar2.f64725j;
        if (i12 != 0 && (i11 = aVar2.f64726k) != 0 && i12 <= i11) {
            E();
        }
        f8.a aVar3 = this.f25169f;
        Calendar calendar = aVar3.f64723h;
        if (calendar == null || aVar3.f64724i == null) {
            if (calendar == null) {
                Calendar calendar2 = aVar3.f64724i;
                if (calendar2 != null && calendar2.get(1) > 2100) {
                    throw new IllegalArgumentException("The endDate should not be later than 2100");
                }
                D();
            } else {
                if (calendar.get(1) < 1900) {
                    throw new IllegalArgumentException("The startDate can not as early as 1900");
                }
                D();
            }
        } else {
            if (calendar.getTimeInMillis() > this.f25169f.f64724i.getTimeInMillis()) {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
            D();
        }
        F();
        b bVar = this.f25185q;
        f8.a aVar4 = this.f25169f;
        bVar.y(aVar4.f64729n, aVar4.f64730o, aVar4.f64731p, aVar4.f64732q, aVar4.f64733r, aVar4.f64734s);
        b bVar2 = this.f25185q;
        f8.a aVar5 = this.f25169f;
        bVar2.M(aVar5.f64735t, aVar5.f64736u, aVar5.f64737v, aVar5.f64738w, aVar5.f64739x, aVar5.f64740y);
        u(this.f25169f.U);
        this.f25185q.s(this.f25169f.f64727l);
        this.f25185q.u(this.f25169f.Q);
        this.f25185q.w(this.f25169f.X);
        this.f25185q.A(this.f25169f.S);
        this.f25185q.L(this.f25169f.O);
        this.f25185q.J(this.f25169f.P);
        this.f25185q.p(this.f25169f.V);
    }
}
