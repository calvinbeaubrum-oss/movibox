package com.bytedance.sdk.openadsdk.core.Tf.sc.sc;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.openadsdk.core.Tf.WH;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class We {
    public static Set<WH> sc(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        WH whSc;
        if (xmlPullParser == null) {
            return new HashSet();
        }
        HashSet hashSet = new HashSet();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if ("Verification".equals(xmlPullParser.getName())) {
                    String attributeValue = xmlPullParser.getAttributeValue(ExN.f28237qr, "vendor");
                    String strPFF = null;
                    String strPFF2 = null;
                    String strPFF3 = null;
                    while (true) {
                        if (xmlPullParser.getEventType() != 3 || !"Verification".equals(xmlPullParser.getName())) {
                            xmlPullParser.next();
                            if (xmlPullParser.getEventType() == 2) {
                                String name = xmlPullParser.getName();
                                name.hashCode();
                                switch (name) {
                                    case "Tracking":
                                        if (!"verificationNotExecuted".equals(xmlPullParser.getAttributeValue(ExN.f28237qr, NotificationCompat.CATEGORY_EVENT))) {
                                            break;
                                        } else {
                                            strPFF3 = ExN.pFF(xmlPullParser, "Tracking");
                                            break;
                                        }
                                        break;
                                    case "JavaScriptResource":
                                        if (!CampaignEx.KEY_OMID.equals(xmlPullParser.getAttributeValue(ExN.f28237qr, "apiFramework"))) {
                                            break;
                                        } else {
                                            strPFF = ExN.pFF(xmlPullParser, "JavaScriptResource");
                                            break;
                                        }
                                        break;
                                    case "VerificationParameters":
                                        strPFF2 = ExN.pFF(xmlPullParser, "VerificationParameters");
                                        break;
                                }
                            }
                        } else if (!TextUtils.isEmpty(strPFF) && (whSc = WH.sc(CampaignEx.KEY_OMID, strPFF, attributeValue, strPFF2, strPFF3)) != null) {
                            hashSet.add(whSc);
                        }
                    }
                } else {
                    ExN.sc(xmlPullParser);
                }
            }
        }
        return hashSet;
    }
}
