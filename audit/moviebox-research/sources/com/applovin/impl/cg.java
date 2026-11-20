package com.applovin.impl;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.core.view.ViewCompat;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.R;
import com.tn.lib.view.FlowLayout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class cg extends dc {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final ke f18186n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Context f18187o;

    public cg(ke keVar, Context context) {
        super(dc.c.DETAIL);
        this.f18186n = keVar;
        this.f18187o = context;
        this.f18405c = t();
        this.f18406d = s();
    }

    private SpannedString q() {
        if (!this.f18186n.y()) {
            return StringUtils.createListItemDetailSpannedString("Adapter Missing", FlowLayout.SPACING_AUTO);
        }
        if (TextUtils.isEmpty(this.f18186n.c())) {
            return StringUtils.createListItemDetailSpannedString("Adapter Found", ViewCompat.MEASURED_STATE_MASK);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(StringUtils.createListItemDetailSubSpannedString("ADAPTER  ", -7829368));
        spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSpannedString(this.f18186n.c(), ViewCompat.MEASURED_STATE_MASK));
        if (this.f18186n.z()) {
            spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSubSpannedString("  LATEST  ", Color.rgb(255, 127, 0)));
            spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSpannedString(this.f18186n.k(), ViewCompat.MEASURED_STATE_MASK));
        }
        return new SpannedString(spannableStringBuilder);
    }

    private SpannedString s() {
        if (!o()) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) u());
        spannableStringBuilder.append((CharSequence) new SpannableString("\n"));
        spannableStringBuilder.append((CharSequence) q());
        if (this.f18186n.q() == ke.a.INVALID_INTEGRATION) {
            spannableStringBuilder.append((CharSequence) new SpannableString("\n"));
            spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSpannedString("Invalid Integration", FlowLayout.SPACING_AUTO));
        }
        return new SpannedString(spannableStringBuilder);
    }

    private SpannedString t() {
        return StringUtils.createSpannedString(this.f18186n.g(), o() ? ViewCompat.MEASURED_STATE_MASK : -7829368, 18, 1);
    }

    private SpannedString u() {
        if (!this.f18186n.C()) {
            return StringUtils.createListItemDetailSpannedString("SDK Missing", FlowLayout.SPACING_AUTO);
        }
        if (!StringUtils.isValidString(this.f18186n.p())) {
            return StringUtils.createListItemDetailSpannedString(this.f18186n.y() ? "Retrieving SDK Version..." : "SDK Found", ViewCompat.MEASURED_STATE_MASK);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(StringUtils.createListItemDetailSubSpannedString("SDK\t\t\t\t\t  ", -7829368));
        spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSpannedString(this.f18186n.p(), ViewCompat.MEASURED_STATE_MASK));
        return new SpannedString(spannableStringBuilder);
    }

    @Override // com.applovin.impl.dc
    public int d() {
        return o() ? R.drawable.applovin_ic_disclosure_arrow : super.h();
    }

    @Override // com.applovin.impl.dc
    public int e() {
        return t3.a(R.color.applovin_sdk_disclosureButtonColor, this.f18187o);
    }

    @Override // com.applovin.impl.dc
    public int h() {
        int iH = this.f18186n.h();
        return iH > 0 ? iH : R.drawable.applovin_ic_mediation_placeholder;
    }

    @Override // com.applovin.impl.dc
    public boolean o() {
        return this.f18186n.q() != ke.a.MISSING;
    }

    public ke r() {
        return this.f18186n;
    }

    public String toString() {
        return "MediatedNetworkListItemViewModel{text=" + ((Object) this.f18405c) + ", detailText=" + ((Object) this.f18406d) + ", network=" + this.f18186n + "}";
    }
}
