package w9;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.bean.VastClick;
import com.cloud.hisavana.sdk.common.bean.VastData;
import com.cloud.hisavana.sdk.common.bean.VastIcon;
import com.cloud.hisavana.sdk.common.bean.VastMedia;
import com.cloud.hisavana.sdk.common.bean.VastTracking;
import com.cloud.hisavana.sdk.common.bean.VideoMask;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.ByteArrayInputStream;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f79346a = new a(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public final void a(String str, String str2, VastData vastData) {
            VastTracking vastTrack;
            if (str != null) {
                switch (str.hashCode()) {
                    case -1638835128:
                        if (str.equals(CampaignEx.JSON_NATIVE_VIDEO_MIDPOINT)) {
                            vastTrack = vastData != null ? vastData.getVastTrack() : null;
                            if (vastTrack != null) {
                                vastTrack.setMidpoint(str2);
                                break;
                            }
                        }
                        break;
                    case -1337830390:
                        if (str.equals("thirdQuartile")) {
                            vastTrack = vastData != null ? vastData.getVastTrack() : null;
                            if (vastTrack != null) {
                                vastTrack.setThirdQuarter(str2);
                                break;
                            }
                        }
                        break;
                    case -599445191:
                        if (str.equals(CampaignEx.JSON_NATIVE_VIDEO_COMPLETE)) {
                            vastTrack = vastData != null ? vastData.getVastTrack() : null;
                            if (vastTrack != null) {
                                vastTrack.setComplete(str2);
                                break;
                            }
                        }
                        break;
                    case 109757538:
                        if (str.equals("start")) {
                            vastTrack = vastData != null ? vastData.getVastTrack() : null;
                            if (vastTrack != null) {
                                vastTrack.setStartTrack(str2);
                                break;
                            }
                        }
                        break;
                    case 560220243:
                        if (str.equals("firstQuartile")) {
                            vastTrack = vastData != null ? vastData.getVastTrack() : null;
                            if (vastTrack != null) {
                                vastTrack.setQuarter(str2);
                                break;
                            }
                        }
                        break;
                }
            }
        }

        public final void b(VastData vastData, Node node) {
            NodeList childNodes;
            int length;
            if (node == null || (length = (childNodes = node.getChildNodes()).getLength()) < 0) {
                return;
            }
            int i11 = 0;
            while (true) {
                Node nodeItem = childNodes.item(i11);
                if (nodeItem != null && nodeItem.getNodeType() == 1) {
                    String nodeName = nodeItem.getNodeName();
                    if (nodeName == null) {
                        nodeName = "";
                    } else {
                        Intrinsics.f(nodeName, "item.nodeName ?: \"\"");
                    }
                    if (Intrinsics.b(nodeName, "InLine")) {
                        b0.f79346a.i(vastData, nodeItem);
                    }
                }
                if (i11 == length) {
                    return;
                } else {
                    i11++;
                }
            }
        }

        public final void c(VastData vastData, Node node) {
            Node namedItem;
            Node namedItem2;
            NamedNodeMap attributes = node.getAttributes();
            String nodeValue = null;
            String strP = p((attributes == null || (namedItem2 = attributes.getNamedItem("id")) == null) ? null : namedItem2.getNodeValue());
            NamedNodeMap attributes2 = node.getAttributes();
            if (attributes2 != null && (namedItem = attributes2.getNamedItem("skipoffset")) != null) {
                nodeValue = namedItem.getNodeValue();
            }
            String strP2 = p(nodeValue);
            if (vastData != null) {
                vastData.setSkipOffSet(Integer.valueOf(y.a(strP2)));
            }
            if (vastData != null) {
                if (TextUtils.isEmpty(strP) && (strP = vastData.getId()) == null) {
                    strP = "";
                }
                vastData.setId(strP);
            }
            NodeList childNodes = node.getChildNodes();
            int length = childNodes.getLength();
            if (length < 0) {
                return;
            }
            int i11 = 0;
            while (true) {
                Node nodeItem = childNodes.item(i11);
                if (nodeItem != null && nodeItem.getNodeType() == 1) {
                    String nodeName = nodeItem.getNodeName();
                    if (nodeName == null) {
                        nodeName = "";
                    }
                    if (Intrinsics.b(nodeName, "Linear")) {
                        j(vastData, nodeItem);
                    }
                }
                if (i11 == length) {
                    return;
                } else {
                    i11++;
                }
            }
        }

        public final void d(VastData vastData, Node node) {
            NodeList childNodes = node.getChildNodes();
            int length = childNodes.getLength();
            if (length < 0) {
                return;
            }
            int i11 = 0;
            while (true) {
                Node nodeItem = childNodes.item(i11);
                if (nodeItem != null && nodeItem.getNodeType() == 1) {
                    String nodeName = nodeItem.getNodeName();
                    if (nodeName == null) {
                        nodeName = "";
                    }
                    if (Intrinsics.b(nodeName, "Creative")) {
                        c(vastData, nodeItem);
                    }
                }
                if (i11 == length) {
                    return;
                } else {
                    i11++;
                }
            }
        }

        public final void e(VastData vastData, Node node) {
            Node namedItem;
            NodeList childNodes = node.getChildNodes();
            try {
                int length = childNodes.getLength();
                if (length < 0) {
                    return;
                }
                int i11 = 0;
                while (true) {
                    Node nodeItem = childNodes.item(i11);
                    if (nodeItem != null && nodeItem.getNodeType() == 1) {
                        String nodeName = nodeItem.getNodeName();
                        if (nodeName == null) {
                            nodeName = "";
                        }
                        if (Intrinsics.b(nodeName, "CreativeExtension")) {
                            NamedNodeMap attributes = nodeItem.getAttributes();
                            String strP = p((attributes == null || (namedItem = attributes.getNamedItem("type")) == null) ? null : namedItem.getNodeValue());
                            if (Intrinsics.b("cover", strP)) {
                                if (vastData != null) {
                                    Node firstChild = nodeItem.getFirstChild();
                                    vastData.setVideoMask(new VideoMask(p(firstChild != null ? firstChild.getNodeValue() : null)));
                                }
                            } else if (Intrinsics.b("buttonText", strP) && vastData != null) {
                                Node firstChild2 = nodeItem.getFirstChild();
                                vastData.setButtonTxt(p(firstChild2 != null ? firstChild2.getNodeValue() : null));
                            }
                        }
                    }
                    if (i11 == length) {
                        return;
                    } else {
                        i11++;
                    }
                }
            } catch (Exception e11) {
                com.cloud.hisavana.sdk.z.a().e("VastDomParseUtil", "parseExtensions " + Log.getStackTraceString(e11));
            }
        }

        public final void f(VastData vastData, Node node) {
            Node namedItem;
            Node namedItem2;
            Node namedItem3;
            Node namedItem4;
            Node namedItem5;
            Node namedItem6;
            Node namedItem7;
            String str = "0";
            VastIcon vastIcon = new VastIcon(null, null, null, null, null, null, null, null, null, null, 1023, null);
            if (vastData != null) {
                vastData.setIcon(vastIcon);
            }
            NamedNodeMap attributes = node.getAttributes();
            vastIcon.setProgram((attributes == null || (namedItem7 = attributes.getNamedItem("program")) == null) ? null : namedItem7.getNodeValue());
            try {
                NamedNodeMap attributes2 = node.getAttributes();
                String nodeValue = (attributes2 == null || (namedItem6 = attributes2.getNamedItem("width")) == null) ? null : namedItem6.getNodeValue();
                if (nodeValue == null) {
                    nodeValue = "0";
                }
                vastIcon.setWidth(Integer.valueOf(Integer.parseInt(nodeValue)));
            } catch (Exception e11) {
                com.cloud.hisavana.sdk.z.a().e("VastDomParseUtil", "parseIcon " + Log.getStackTraceString(e11));
            }
            try {
                NamedNodeMap attributes3 = node.getAttributes();
                String nodeValue2 = (attributes3 == null || (namedItem5 = attributes3.getNamedItem("height")) == null) ? null : namedItem5.getNodeValue();
                if (nodeValue2 == null) {
                    nodeValue2 = "0";
                }
                vastIcon.setHeight(Integer.valueOf(Integer.parseInt(nodeValue2)));
            } catch (Exception e12) {
                com.cloud.hisavana.sdk.z.a().e("VastDomParseUtil", "parseIcon " + Log.getStackTraceString(e12));
            }
            try {
                NamedNodeMap attributes4 = node.getAttributes();
                String nodeValue3 = (attributes4 == null || (namedItem4 = attributes4.getNamedItem("xPosition")) == null) ? null : namedItem4.getNodeValue();
                if (nodeValue3 == null) {
                    nodeValue3 = "0";
                }
                vastIcon.setXPosition(Integer.valueOf(Integer.parseInt(nodeValue3)));
            } catch (Exception e13) {
                com.cloud.hisavana.sdk.z.a().e("VastDomParseUtil", "parseIcon " + Log.getStackTraceString(e13));
            }
            try {
                NamedNodeMap attributes5 = node.getAttributes();
                String nodeValue4 = (attributes5 == null || (namedItem3 = attributes5.getNamedItem("yPosition")) == null) ? null : namedItem3.getNodeValue();
                if (nodeValue4 != null) {
                    str = nodeValue4;
                }
                vastIcon.setYPosition(Integer.valueOf(Integer.parseInt(str)));
            } catch (Exception e14) {
                com.cloud.hisavana.sdk.z.a().e("VastDomParseUtil", "parseIcon " + Log.getStackTraceString(e14));
            }
            NamedNodeMap attributes6 = node.getAttributes();
            vastIcon.setOffset((attributes6 == null || (namedItem2 = attributes6.getNamedItem("offset")) == null) ? null : namedItem2.getNodeValue());
            NamedNodeMap attributes7 = node.getAttributes();
            vastIcon.setDuration(Integer.valueOf(y.a((attributes7 == null || (namedItem = attributes7.getNamedItem("program")) == null) ? null : namedItem.getNodeValue())));
            NodeList childNodes = node.getChildNodes();
            int length = childNodes.getLength();
            if (length < 0) {
                return;
            }
            int i11 = 0;
            while (true) {
                Node nodeItem = childNodes.item(i11);
                if (nodeItem != null && nodeItem.getNodeType() == 1) {
                    String nodeName = nodeItem.getNodeName();
                    if (nodeName == null) {
                        nodeName = "";
                    }
                    if (Intrinsics.b(nodeName, "IconClicks")) {
                        g(vastData, nodeItem);
                    } else if (Intrinsics.b(nodeName, "StaticResource")) {
                        Node firstChild = nodeItem.getFirstChild();
                        vastIcon.setIconResource(p(firstChild != null ? firstChild.getNodeValue() : null));
                    }
                }
                if (i11 == length) {
                    return;
                } else {
                    i11++;
                }
            }
        }

        public final void g(VastData vastData, Node node) {
            VastIcon icon;
            List<String> iconClickTracking;
            NodeList childNodes = node.getChildNodes();
            int length = childNodes.getLength();
            if (length < 0) {
                return;
            }
            int i11 = 0;
            while (true) {
                Node nodeItem = childNodes.item(i11);
                if (nodeItem != null && nodeItem.getNodeType() == 1) {
                    String nodeName = nodeItem.getNodeName();
                    if (nodeName == null) {
                        nodeName = "";
                    }
                    if (Intrinsics.b(nodeName, "IconClickThrough")) {
                        VastIcon icon2 = vastData != null ? vastData.getIcon() : null;
                        if (icon2 != null) {
                            Node firstChild = nodeItem.getFirstChild();
                            icon2.setIconClick(p(firstChild != null ? firstChild.getNodeValue() : null));
                        }
                    } else if (Intrinsics.b(nodeName, "IconClickTracking")) {
                        Node firstChild2 = nodeItem.getFirstChild();
                        String strP = p(firstChild2 != null ? firstChild2.getNodeValue() : null);
                        if (strP != null && vastData != null && (icon = vastData.getIcon()) != null && (iconClickTracking = icon.getIconClickTracking()) != null) {
                            iconClickTracking.add(strP);
                        }
                    }
                }
                if (i11 == length) {
                    return;
                } else {
                    i11++;
                }
            }
        }

        public final void h(VastData vastData, Node node) {
            NodeList childNodes = node.getChildNodes();
            int length = childNodes.getLength();
            if (length < 0) {
                return;
            }
            int i11 = 0;
            while (true) {
                Node nodeItem = childNodes.item(i11);
                if (nodeItem != null && nodeItem.getNodeType() == 1) {
                    String nodeName = nodeItem.getNodeName();
                    if (nodeName == null) {
                        nodeName = "";
                    }
                    if (Intrinsics.b(nodeName, "Icon")) {
                        f(vastData, nodeItem);
                    }
                }
                if (i11 == length) {
                    return;
                } else {
                    i11++;
                }
            }
        }

        public final void i(VastData vastData, Node node) {
            List<String> impression;
            NodeList childNodes = node.getChildNodes();
            int length = childNodes.getLength();
            if (length < 0) {
                return;
            }
            int i11 = 0;
            while (true) {
                Node nodeItem = childNodes.item(i11);
                if (nodeItem != null && nodeItem.getNodeType() == 1) {
                    String nodeName = nodeItem.getNodeName();
                    if (nodeName == null) {
                        nodeName = "";
                    }
                    int iHashCode = nodeName.hashCode();
                    if (iHashCode != -1692490108) {
                        if (iHashCode != -56677412) {
                            if (iHashCode != 501930965) {
                                if (iHashCode == 2114088489 && nodeName.equals("Impression")) {
                                    Node firstChild = nodeItem.getFirstChild();
                                    String strP = p(firstChild != null ? firstChild.getNodeValue() : null);
                                    if (strP != null && vastData != null && (impression = vastData.getImpression()) != null) {
                                        impression.add(strP);
                                    }
                                }
                            } else if (nodeName.equals("AdTitle") && vastData != null) {
                                Node firstChild2 = nodeItem.getFirstChild();
                                vastData.setTitle(p(firstChild2 != null ? firstChild2.getNodeValue() : null));
                            }
                        } else if (nodeName.equals("Description") && vastData != null) {
                            Node firstChild3 = nodeItem.getFirstChild();
                            vastData.setDescription(p(firstChild3 != null ? firstChild3.getNodeValue() : null));
                        }
                    } else if (nodeName.equals("Creatives")) {
                        d(vastData, nodeItem);
                    }
                }
                if (i11 == length) {
                    return;
                } else {
                    i11++;
                }
            }
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public final void j(VastData vastData, Node node) {
            NodeList childNodes = node.getChildNodes();
            int length = childNodes.getLength();
            if (length < 0) {
                return;
            }
            int i11 = 0;
            while (true) {
                Node nodeItem = childNodes.item(i11);
                if (nodeItem != null && nodeItem.getNodeType() == 1) {
                    String nodeName = nodeItem.getNodeName();
                    if (nodeName == null) {
                        nodeName = "";
                    }
                    switch (nodeName.hashCode()) {
                        case -2049897434:
                            if (nodeName.equals("VideoClicks")) {
                                n(vastData, nodeItem);
                            }
                            break;
                        case -1927368268:
                            if (nodeName.equals("Duration")) {
                                Node firstChild = nodeItem.getFirstChild();
                                String strP = p(firstChild != null ? firstChild.getNodeValue() : null);
                                if (vastData != null) {
                                    vastData.setDuration(Integer.valueOf(y.a(strP)));
                                }
                            }
                            break;
                        case -385055469:
                            if (nodeName.equals("MediaFiles")) {
                                k(vastData, nodeItem);
                            }
                            break;
                        case -371923645:
                            if (nodeName.equals("CreativeExtensions")) {
                                e(vastData, nodeItem);
                            }
                            break;
                        case 70476538:
                            if (nodeName.equals("Icons")) {
                                h(vastData, nodeItem);
                            }
                            break;
                        case 611554000:
                            if (nodeName.equals("TrackingEvents")) {
                                l(vastData, nodeItem);
                            }
                            break;
                    }
                }
                if (i11 == length) {
                    return;
                } else {
                    i11++;
                }
            }
        }

        public final void k(VastData vastData, Node node) {
            Node namedItem;
            Node namedItem2;
            String type;
            VastMedia mainAd;
            VastMedia mainAd2;
            Node namedItem3;
            Node namedItem4;
            NodeList childNodes = node.getChildNodes();
            try {
                int length = childNodes.getLength();
                if (length < 0) {
                    return;
                }
                int i11 = 0;
                while (true) {
                    Node nodeItem = childNodes.item(i11);
                    if (nodeItem != null && nodeItem.getNodeType() == 1) {
                        String nodeName = nodeItem.getNodeName();
                        if (nodeName == null) {
                            nodeName = "";
                        }
                        if (Intrinsics.b(nodeName, "MediaFile")) {
                            if (vastData != null) {
                                vastData.setMainAd(new VastMedia(null, null, null, 0, 0, 31, null));
                            }
                            String nodeValue = null;
                            VastMedia mainAd3 = vastData != null ? vastData.getMainAd() : null;
                            if (mainAd3 != null) {
                                Node firstChild = nodeItem.getFirstChild();
                                mainAd3.setMediaResource(p(firstChild != null ? firstChild.getNodeValue() : null));
                            }
                            VastMedia mainAd4 = vastData != null ? vastData.getMainAd() : null;
                            if (mainAd4 != null) {
                                NamedNodeMap attributes = nodeItem.getAttributes();
                                mainAd4.setDelivery(p((attributes == null || (namedItem = attributes.getNamedItem("delivery")) == null) ? null : namedItem.getNodeValue()));
                            }
                            VastMedia mainAd5 = vastData != null ? vastData.getMainAd() : null;
                            if (mainAd5 != null) {
                                NamedNodeMap attributes2 = nodeItem.getAttributes();
                                mainAd5.setType(p((attributes2 == null || (namedItem2 = attributes2.getNamedItem("type")) == null) ? null : namedItem2.getNodeValue()));
                            }
                            if (vastData != null) {
                                VastMedia mainAd6 = vastData.getMainAd();
                                vastData.setVideoType((mainAd6 == null || (type = mainAd6.getType()) == null) ? null : Boolean.valueOf(kotlin.text.l.L(type, "video", false, 2, null)));
                            }
                            String str = "0";
                            if (vastData != null) {
                                try {
                                    mainAd = vastData.getMainAd();
                                } catch (Exception e11) {
                                    com.cloud.hisavana.sdk.z.a().e("VastDomParseUtil", "parseMediaFiles width " + Log.getStackTraceString(e11));
                                }
                            } else {
                                mainAd = null;
                            }
                            if (mainAd != null) {
                                NamedNodeMap attributes3 = nodeItem.getAttributes();
                                String strP = p((attributes3 == null || (namedItem4 = attributes3.getNamedItem("width")) == null) ? null : namedItem4.getNodeValue());
                                if (strP == null) {
                                    strP = "0";
                                }
                                mainAd.setWidth(Integer.parseInt(strP));
                            }
                            if (vastData != null) {
                                try {
                                    mainAd2 = vastData.getMainAd();
                                } catch (Exception e12) {
                                    com.cloud.hisavana.sdk.z.a().e("VastDomParseUtil", "parseMediaFiles height " + Log.getStackTraceString(e12));
                                }
                            } else {
                                mainAd2 = null;
                            }
                            if (mainAd2 != null) {
                                NamedNodeMap attributes4 = nodeItem.getAttributes();
                                if (attributes4 != null && (namedItem3 = attributes4.getNamedItem("height")) != null) {
                                    nodeValue = namedItem3.getNodeValue();
                                }
                                String strP2 = p(nodeValue);
                                if (strP2 != null) {
                                    str = strP2;
                                }
                                mainAd2.setHeight(Integer.parseInt(str));
                            }
                        }
                    }
                    if (i11 == length) {
                        return;
                    } else {
                        i11++;
                    }
                }
            } catch (Exception e13) {
                com.cloud.hisavana.sdk.z.a().e("VastDomParseUtil", "parseMediaFiles " + Log.getStackTraceString(e13));
            }
        }

        public final void l(VastData vastData, Node node) {
            Node namedItem;
            if (vastData != null) {
                vastData.setVastTrack(new VastTracking(null, null, null, null, null, 31, null));
            }
            NodeList childNodes = node.getChildNodes();
            int length = childNodes.getLength();
            if (length < 0) {
                return;
            }
            int i11 = 0;
            while (true) {
                Node nodeItem = childNodes.item(i11);
                if (nodeItem != null && nodeItem.getNodeType() == 1) {
                    String nodeName = nodeItem.getNodeName();
                    if (nodeName == null) {
                        nodeName = "";
                    }
                    if (Intrinsics.b(nodeName, "Tracking")) {
                        NamedNodeMap attributes = nodeItem.getAttributes();
                        String strP = p((attributes == null || (namedItem = attributes.getNamedItem(NotificationCompat.CATEGORY_EVENT)) == null) ? null : namedItem.getNodeValue());
                        Node firstChild = nodeItem.getFirstChild();
                        String nodeValue = firstChild != null ? firstChild.getNodeValue() : null;
                        if (nodeValue == null) {
                            nodeValue = "";
                        }
                        String strP2 = p(nodeValue);
                        a(strP, strP2 != null ? strP2 : "", vastData);
                    }
                }
                if (i11 == length) {
                    return;
                } else {
                    i11++;
                }
            }
        }

        public final VastData m(String data, AdsDTO adsDTO) {
            Intrinsics.g(data, "data");
            if (!TextUtils.isEmpty(data) && adsDTO != null) {
                AthenaTracker.l0(adsDTO, null, 1, "");
                DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
                Intrinsics.f(documentBuilderFactoryNewInstance, "newInstance()");
                VastData vastData = new VastData(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131071, null);
                try {
                    try {
                        byte[] bytes = o(kotlin.text.l.F(data, "&", "&amp;", false, 4, null)).getBytes(Charsets.f69091b);
                        Intrinsics.f(bytes, "getBytes(...)");
                        Element documentElement = documentBuilderFactoryNewInstance.newDocumentBuilder().parse(new ByteArrayInputStream(bytes)).getDocumentElement();
                        if (!TextUtils.equals("VAST", documentElement.getTagName())) {
                            return vastData;
                        }
                        vastData.setVersion(b0.f79346a.p(documentElement.getAttribute("version")));
                        NodeList childNodes = documentElement.getChildNodes();
                        int length = childNodes.getLength();
                        if (length >= 0) {
                            int i11 = 0;
                            while (true) {
                                Node nodeItem = childNodes.item(i11);
                                if (nodeItem != null && nodeItem.getNodeType() == 1) {
                                    String nodeName = nodeItem.getNodeName();
                                    if (nodeName == null) {
                                        nodeName = "";
                                    } else {
                                        Intrinsics.f(nodeName, "item.nodeName ?: \"\"");
                                    }
                                    if (Intrinsics.b(nodeName, "Ad")) {
                                        b0.f79346a.b(vastData, nodeItem);
                                    }
                                }
                                if (i11 == length) {
                                    break;
                                }
                                i11++;
                            }
                        }
                        com.cloud.hisavana.sdk.z.a().d("VastDomParseUtil", "parseVast " + vastData);
                        return vastData;
                    } catch (Exception e11) {
                        e = e11;
                        com.cloud.hisavana.sdk.z.a().e("VastDomParseUtil", Log.getStackTraceString(e));
                        return null;
                    }
                } catch (Exception e12) {
                    e = e12;
                }
            }
            return null;
        }

        public final void n(VastData vastData, Node node) {
            VastClick vastClick = new VastClick(null, null, 3, null);
            if (vastData != null) {
                vastData.setVastClick(vastClick);
            }
            NodeList childNodes = node.getChildNodes();
            int length = childNodes.getLength();
            if (length < 0) {
                return;
            }
            int i11 = 0;
            while (true) {
                Node nodeItem = childNodes.item(i11);
                if (nodeItem != null && nodeItem.getNodeType() == 1) {
                    String nodeName = nodeItem.getNodeName();
                    if (nodeName == null) {
                        nodeName = "";
                    }
                    if (Intrinsics.b(nodeName, "ClickThrough")) {
                        Node firstChild = nodeItem.getFirstChild();
                        vastClick.setVideoClick(p(firstChild != null ? firstChild.getNodeValue() : null));
                    } else if (Intrinsics.b(nodeName, "ClickTracking")) {
                        Node firstChild2 = nodeItem.getFirstChild();
                        String strP = p(firstChild2 != null ? firstChild2.getNodeValue() : null);
                        if (strP != null) {
                            vastClick.getClickTrack().add(strP);
                        }
                    }
                }
                if (i11 == length) {
                    return;
                } else {
                    i11++;
                }
            }
        }

        public final String o(String str) {
            return str != null ? kotlin.text.l.F(kotlin.text.l.F(str, "\\", "", false, 4, null), "\\\"", "\"", false, 4, null) : "";
        }

        public final String p(String str) {
            String strF;
            String strF2;
            if (str == null || (strF = kotlin.text.l.F(str, "<![CDATA[", "", false, 4, null)) == null || (strF2 = kotlin.text.l.F(strF, "]]>", "", false, 4, null)) == null) {
                return null;
            }
            return kotlin.text.l.F(strF2, "&amp;", "&", false, 4, null);
        }
    }
}
