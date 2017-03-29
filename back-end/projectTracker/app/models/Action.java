package models;

/**
 * Created by formation04 on 29/03/17.
 */
public enum Action {
    /**
     * INTRA_REGRESS : a regress occurring on a task in a single sprint,
     * INTA_REGRESS : a regress occurring on a task in two different sprints,
     * CORRECTION : correction of a task when its status change from anything to null,
     * WAIT : a task which is avalaible to be revised by the client.
     */
    INTRA_REGRESS,INTER_REGRESS,CORRECTION,WAIT;

}
