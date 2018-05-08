package net.swordie.ms.client.life.movement;


import net.swordie.ms.connection.InPacket;
import net.swordie.ms.connection.OutPacket;
import net.swordie.ms.util.Position;

/**
 * Created on 1/2/2018.
 * These classes + children/parents are basically the same as Mushy, credits to @MaxCloud.
 */
public class Movement1 extends MovementBase {
    public Movement1(InPacket inPacket, byte command) {
        super();
        this.command = command;

        short x = inPacket.decodeShort();
        short y = inPacket.decodeShort();
        position = new Position(x, y);

        short xv = inPacket.decodeShort();
        short yv = inPacket.decodeShort();
        vPosition = new Position(xv, yv);

        fh = inPacket.decodeShort();

        if (command == 15 || command == 17) {
            footStart = inPacket.decodeShort();
        }

        short xoffset = inPacket.decodeShort();
        short yoffset = inPacket.decodeShort();
        offset = new Position(xoffset, yoffset);

        moveAction = inPacket.decodeByte();
        elapse = inPacket.decodeShort();
        forcedStop = inPacket.decodeByte();
    }

    @Override
    public void encode(OutPacket outPacket) {
        outPacket.encodeByte(getCommand());
        outPacket.encodePosition(getPosition());
        outPacket.encodePosition(getVPosition());
        outPacket.encodeShort(getFh());
        if (getCommand() == 15 || getCommand() == 17) {
            outPacket.encodeShort(getFootStart());
        }
        outPacket.encodePosition(getOffset());
        outPacket.encodeByte(getMoveAction());
        outPacket.encodeShort(getDuration());
        outPacket.encodeByte(getForcedStop());
    }
}