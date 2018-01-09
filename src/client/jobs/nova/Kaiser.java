package client.jobs.nova;

import client.Client;
import client.character.Char;
import client.character.skills.AttackInfo;
import client.jobs.Job;
import connection.InPacket;
import constants.JobConstants;

/**
 * Created on 12/14/2017.
 */
public class Kaiser extends Job {
    public Kaiser(Char chr) {
        super(chr);
    }

    @Override
    public void handleAttack(Client c, AttackInfo attackInfo) {

    }

    @Override
    public void handleSkill(Client c, InPacket inPacket) {

    }

    @Override
    public boolean isHandlerOfJob(short id) {
        return id == JobConstants.JobEnum.KAISER.getJobId() ||
                (id >= JobConstants.JobEnum.KAISER1.getJobId() && id <= JobConstants.JobEnum.KAISER4.getJobId());
    }
}
