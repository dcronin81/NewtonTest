package main.java;
public class UserUtil {

    public boolean isNewtonUser(UserPO user) {
        String userRoleId = user.getRoleId();
        if (Constants.ROLE_TYPE_1.equals(userRoleId) || Constants.ROLE_TYPE_2.equals(userRoleId)) {
            return true;
        } else {
            return false;
        }
    }




    /**
     * Role 1 can see all<br/>
     * 2 can see 3-7<br/>
     * ====================================<br/>
     * 3 can see 3-7<br/>
     * 4 user can see 4-6<br/>
     * 6  can't see anyone<br/>
     * 
     * 7 has ACCESS_ABSTAIN for 3-7
     * 
     * Any user can see themselves
     *
     * Please see Constants class for a list of role ids
     *
     * @param me
     * @param her
     * @return int value Constants.ACCESS_GRANTED/ACCESS_ABSTAIN/ACCESS_DENIED
     */
    public int canISeeHer(UserPO me, UserPO her) {
        Integer myId = me.getId();
        String myRoleId = me.getRoleId();

        Integer herId = her.getId();
        String herRoleId = her.getRoleId();

        if (myId.equals(herId)) {
            return Constants.ACCESS_GRANTED;
        }

        int roleSufficient = Constants.ACCESS_DENIED;

        if(Constants.ROLE_TYPE_1.equals(myRoleId)) {

            roleSufficient = Constants.ACCESS_GRANTED;

        } else if (Constants.ROLE_TYPE_2.equals(myRoleId)) {
            if(isNewtonUser(her)) {
                roleSufficient = Constants.ACCESS_DENIED;
            } else {
                roleSufficient = Constants.ACCESS_GRANTED;
            }

        } else if (Constants.ROLE_TYPE_7.equals(myRoleId)) {
            if(isNewtonUser(her)) {
                roleSufficient = Constants.ACCESS_DENIED;
            } else {
                roleSufficient = Constants.ACCESS_ABSTAIN;
            }

        } else if(Constants.ROLE_TYPE_3.equals(myRoleId)) {
            if(isNewtonUser(her)) {
                roleSufficient = Constants.ACCESS_DENIED;
            } else {
                roleSufficient = Constants.ACCESS_GRANTED;
            }

        } else if(Constants.ROLE_TYPE_4.equals(myRoleId)) {

            if (Constants.ROLE_TYPE_4.equals(herRoleId) || Constants.ROLE_TYPE_5.equals(herRoleId)
                    || Constants.ROLE_TYPE_6.equals(herRoleId)) {

                roleSufficient = Constants.ACCESS_GRANTED;

            } else {

                roleSufficient = Constants.ACCESS_DENIED;
            }

        }

        return roleSufficient;
    }



}
