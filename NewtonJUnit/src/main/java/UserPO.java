package main.java;
/**
 * Persistant object used to retrive data from USER table.
 */
public class UserPO  {


    private Integer id;
    private String roleId;

    public UserPO() {

    }

    public UserPO(Integer id, String roleId) {
        super();
        this.id = id;
        this.roleId = roleId;
    }


    public boolean equals(Object o) {
        if (o instanceof UserPO) {
            UserPO p = (UserPO) o;
            if ((p.getId() == null) || (getId() == null)) {
                return false;
            }
            return p.getId().equals(getId());
        }
        return false;
    }



    /**
     * get userID of the user
     *
     * @return int
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * set userID of the user
     *
     * @param userID
     *            The int to set
     */
    public void setId(Integer userID) {
        this.id = userID;
    }


    /**
     * @return TA/TSR/Customer (1/11/71)
     */
    public String getRoleId() {
        return this.roleId;
    }

    /**
     * @param roleId
     *            The roleId to set.
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }


}
