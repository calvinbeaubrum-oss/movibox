package com.cloud.tmc.kernel.extension;

import com.cloud.tmc.kernel.node.Node;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface e {
    jc.a a(String str);

    List<c> b(Node node, Class<? extends c> cls);

    void c(Node node);

    void d(Node node);

    f e();

    BridgeExtension f(String str);

    BridgeExtension g(Node node, String str) throws IllegalAccessException, InstantiationException;
}
