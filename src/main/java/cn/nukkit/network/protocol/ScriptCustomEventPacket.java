package cn.nukkit.network.protocol;

import lombok.ToString;

@ToString
public class ScriptCustomEventPacket extends DataPacket { //TODO: this doesn't have handlers in either client or server in the game as of 1.8

    public static final byte NETWORK_ID = ProtocolInfo.SCRIPT_CUSTOM_EVENT_PACKET;

    public String eventName;
    public String eventData; //json data

    @Override
    public byte pid() {
        return NETWORK_ID;
    }

    @Override
    public void decode() {
        this.eventName = this.getString();
        this.eventData = this.getString();
    }

    @Override
    public void encode() {
        this.reset();
        this.putString(this.eventName);
        this.putString(this.eventData);
    }
}
