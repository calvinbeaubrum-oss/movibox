package com.cloud.tmc.miniapp.defaultimpl;

import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.node.IGetNodeSource;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.miniapp.ui.MiniShellFragment;
import kotlin.jvm.internal.Intrinsics;
import p010OooOooo.o0000;
import p010OooOooo.o0000oo;
import tb.d;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class GetNodeSourceImpl implements IGetNodeSource {
    @Override // com.cloud.tmc.kernel.node.IGetNodeSource
    public String getNodeSource(Node node) {
        Intrinsics.g(node, "node");
        try {
            if (node instanceof Page) {
                d pageContext = ((Page) node).getPageContext();
                if (pageContext instanceof o0000) {
                    return "normalPage";
                }
                if (pageContext instanceof o0000oo) {
                    return "h5MixedPage";
                }
                return pageContext instanceof MiniShellFragment ? "miniShellPage" : "otherPage";
            }
        } catch (Throwable th2) {
            TmcLogger.g("Tmc", th2.getMessage(), th2);
        }
        return "otherPage";
    }
}
