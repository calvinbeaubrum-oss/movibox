package com.tn.lib.widget.toast.core;

import android.R;
import android.app.Application;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class e extends Toast implements aq.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f50027a;

    public e(Application application) {
        super(application);
    }

    @Override // aq.a
    public boolean a() {
        return false;
    }

    public TextView b(View view) {
        if (!(view instanceof TextView)) {
            if (view.findViewById(R.id.message) instanceof TextView) {
                return (TextView) view.findViewById(R.id.message);
            }
            throw new IllegalArgumentException("You must include a TextView with an ID value of android.R.id.message");
        }
        if (view.getId() == -1) {
            view.setId(R.id.message);
        } else if (view.getId() != 16908299) {
            throw new IllegalArgumentException("You must set the ID value of TextView to android.R.id.message");
        }
        return (TextView) view;
    }

    @Override // android.widget.Toast, aq.a
    public void setText(CharSequence charSequence) {
        super.setText(charSequence);
        TextView textView = this.f50027a;
        if (textView == null) {
            return;
        }
        textView.setText(charSequence);
    }

    @Override // android.widget.Toast, aq.a
    public void setView(View view) {
        super.setView(view);
        if (view == null) {
            this.f50027a = null;
        } else {
            this.f50027a = b(view);
        }
    }
}
