package com.applovin.impl;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import com.applovin.sdk.R;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class v6 extends dc {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final w6 f23763n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Context f23764o;

    public v6(w6 w6Var, Context context) {
        super(dc.c.DETAIL);
        this.f23763n = w6Var;
        this.f23764o = context;
        this.f18405c = r();
        this.f18406d = q();
    }

    private SpannedString q() {
        return new SpannedString("Displayed " + yp.a(this.f23763n.b(), true));
    }

    private SpannedString r() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.f23763n.c());
        spannableStringBuilder.append((CharSequence) " - ");
        spannableStringBuilder.append((CharSequence) this.f23763n.d());
        return new SpannedString(spannableStringBuilder);
    }

    @Override // com.applovin.impl.dc
    public int d() {
        return o() ? R.drawable.applovin_ic_disclosure_arrow : super.h();
    }

    @Override // com.applovin.impl.dc
    public int e() {
        return t3.a(R.color.applovin_sdk_disclosureButtonColor, this.f23764o);
    }

    @Override // com.applovin.impl.dc
    public boolean o() {
        return true;
    }
}
