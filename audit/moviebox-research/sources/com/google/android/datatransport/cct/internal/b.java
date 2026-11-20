package com.google.android.datatransport.cct.internal;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b extends ClientInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ClientInfo.ClientType f32558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final eg.a f32559b;

    /* JADX INFO: renamed from: com.google.android.datatransport.cct.internal.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0353b extends ClientInfo.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ClientInfo.ClientType f32560a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public eg.a f32561b;

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.a
        public ClientInfo a() {
            return new b(this.f32560a, this.f32561b);
        }

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.a
        public ClientInfo.a b(@Nullable eg.a aVar) {
            this.f32561b = aVar;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.a
        public ClientInfo.a c(@Nullable ClientInfo.ClientType clientType) {
            this.f32560a = clientType;
            return this;
        }
    }

    public b(@Nullable ClientInfo.ClientType clientType, @Nullable eg.a aVar) {
        this.f32558a = clientType;
        this.f32559b = aVar;
    }

    @Override // com.google.android.datatransport.cct.internal.ClientInfo
    @Nullable
    public eg.a b() {
        return this.f32559b;
    }

    @Override // com.google.android.datatransport.cct.internal.ClientInfo
    @Nullable
    public ClientInfo.ClientType c() {
        return this.f32558a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClientInfo)) {
            return false;
        }
        ClientInfo clientInfo = (ClientInfo) obj;
        ClientInfo.ClientType clientType = this.f32558a;
        if (clientType != null ? clientType.equals(clientInfo.c()) : clientInfo.c() == null) {
            eg.a aVar = this.f32559b;
            if (aVar == null) {
                if (clientInfo.b() == null) {
                    return true;
                }
            } else if (aVar.equals(clientInfo.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        ClientInfo.ClientType clientType = this.f32558a;
        int iHashCode = ((clientType == null ? 0 : clientType.hashCode()) ^ 1000003) * 1000003;
        eg.a aVar = this.f32559b;
        return iHashCode ^ (aVar != null ? aVar.hashCode() : 0);
    }

    public String toString() {
        return "ClientInfo{clientType=" + this.f32558a + ", androidClientInfo=" + this.f32559b + "}";
    }
}
