package com.mbridge.msdk.video.module;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.mbridge.msdk.click.a;
import com.mbridge.msdk.click.i;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.o;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.mbsignalcommon.mraid.b;
import com.mbridge.msdk.video.signal.h;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public abstract class MBridgeH5EndCardViewDiff extends MBridgeBaseView implements i, b, h {
    public String unitId;

    public MBridgeH5EndCardViewDiff(Context context) {
        super(context);
    }

    public MBridgeH5EndCardViewDiff(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void open(String str) {
        try {
            String clickURL = this.f47791b.getClickURL();
            if (!TextUtils.isEmpty(str)) {
                this.f47791b.setClickURL(str);
                reportOpen(str);
            }
            a aVar = new a(getContext(), this.unitId);
            aVar.a(this);
            aVar.a(this.f47791b);
            this.f47791b.setClickURL(clickURL);
            this.f47794e.a(WebSocketProtocol.PAYLOAD_SHORT, "");
        } catch (Exception e11) {
            ad.b(MBridgeBaseView.TAG, e11.getMessage());
        }
    }

    public void reportOpen(String str) {
        CampaignEx mraidCampaign = getMraidCampaign();
        if (mraidCampaign != null) {
            new o(getContext()).a(mraidCampaign.getRequestId(), mraidCampaign.getRequestIdNotice(), mraidCampaign.getId(), this.unitId, str, this.f47791b.isBidCampaign());
        }
    }
}
