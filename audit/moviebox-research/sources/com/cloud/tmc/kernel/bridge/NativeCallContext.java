package com.cloud.tmc.kernel.bridge;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import androidx.annotation.Nullable;
import com.cloud.tmc.kernel.node.Node;
import com.google.gson.JsonObject;
import java.util.concurrent.atomic.AtomicLong;
import zc.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class NativeCallContext<T extends Node> implements Parcelable {
    public static final String FROM_WORKER = "fromWorker";
    private String callbackId;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f31140id;
    private String name;
    private T node;
    private JsonObject params;

    @Nullable
    private String pluginId;
    private i render;
    private String source;
    private static final AtomicLong sCounter = new AtomicLong(Process.myPid());
    public static final Parcelable.Creator<NativeCallContext> CREATOR = new a();

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator<NativeCallContext> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public NativeCallContext createFromParcel(Parcel parcel) {
            return new NativeCallContext(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public NativeCallContext[] newArray(int i11) {
            return new NativeCallContext[i11];
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f31141a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public JsonObject f31142b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Node f31143c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public i f31144d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f31145e = "native_" + System.currentTimeMillis();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f31146f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f31147g;

        public NativeCallContext a() {
            return new NativeCallContext(this, null);
        }

        public b b(String str) {
            this.f31147g = str;
            return this;
        }

        public b c(String str) {
            this.f31145e = str;
            return this;
        }

        public b d(String str) {
            this.f31141a = str;
            return this;
        }

        public b e(Node node) {
            this.f31143c = node;
            return this;
        }

        public b f(JsonObject jsonObject) {
            this.f31142b = jsonObject;
            return this;
        }

        public b g(i iVar) {
            this.f31144d = iVar;
            return this;
        }
    }

    public NativeCallContext() {
    }

    public NativeCallContext(Parcel parcel) {
    }

    private NativeCallContext(b bVar) {
        this.render = bVar.f31144d;
        this.name = bVar.f31141a;
        this.params = bVar.f31142b;
        this.node = (T) bVar.f31143c;
        this.f31140id = bVar.f31145e;
        this.source = bVar.f31146f;
        this.callbackId = bVar.f31147g;
    }

    public /* synthetic */ NativeCallContext(b bVar, a aVar) {
        this(bVar);
    }

    public static b newBuilder(String str) {
        return new b().d(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCallbackId() {
        return this.callbackId;
    }

    public String getId() {
        return this.f31140id;
    }

    public String getName() {
        return this.name;
    }

    public T getNode() {
        return this.node;
    }

    public JsonObject getParams() {
        return this.params;
    }

    public i getRender() {
        return this.render;
    }

    public String getSource() {
        return this.source;
    }

    public void setId(String str) {
        this.f31140id = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNode(T t11) {
        this.node = t11;
    }

    public void setParams(JsonObject jsonObject) {
        this.params = jsonObject;
    }

    public void setRender(i iVar) {
        this.render = iVar;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("NativeCallContext{name=");
        sb2.append(this.name);
        sb2.append(", params=");
        sb2.append(this.params);
        sb2.append(", id=");
        sb2.append(this.f31140id);
        if (this.pluginId != null) {
            sb2.append(", pluginId=");
            sb2.append(this.pluginId);
        }
        sb2.append("}");
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
    }
}
