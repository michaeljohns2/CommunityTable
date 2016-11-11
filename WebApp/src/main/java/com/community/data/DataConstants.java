package com.community.data;

/**
 * Created by mjohns on 11/5/16.
 * Used by data instance and test classes alike.
 */
public interface DataConstants {

    //#################################################################################################################
    // CONNECTION
    //#################################################################################################################
    String DB_NAME = "CommunityTables";
    int DB_PORT = 27017;

    //#################################################################################################################
    // EMAIL
    //#################################################################################################################
    String EMAIL_COLLECTION = "emailCollection";
    String EMAIL_FIELD = "emailAddress";
    String EMAIL_HASH = "emailHash";
}
