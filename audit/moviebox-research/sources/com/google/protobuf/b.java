package com.google.protobuf;

import com.google.protobuf.n0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class b<MessageType extends n0> implements v0<MessageType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f41209a = p.b();

    public final MessageType c(MessageType messagetype) throws InvalidProtocolBufferException {
        if (messagetype == null || messagetype.isInitialized()) {
            return messagetype;
        }
        throw d(messagetype).asInvalidProtocolBufferException().setUnfinishedMessage(messagetype);
    }

    public final UninitializedMessageException d(MessageType messagetype) {
        return messagetype instanceof a ? ((a) messagetype).t() : new UninitializedMessageException(messagetype);
    }

    @Override // com.google.protobuf.v0
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public MessageType a(ByteString byteString, p pVar) throws InvalidProtocolBufferException {
        return (MessageType) c(f(byteString, pVar));
    }

    public MessageType f(ByteString byteString, p pVar) throws InvalidProtocolBufferException {
        j jVarNewCodedInput = byteString.newCodedInput();
        MessageType messagetypeB = b(jVarNewCodedInput, pVar);
        try {
            jVarNewCodedInput.a(0);
            return messagetypeB;
        } catch (InvalidProtocolBufferException e11) {
            throw e11.setUnfinishedMessage(messagetypeB);
        }
    }
}
