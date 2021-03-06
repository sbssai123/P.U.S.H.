package Group;

import java.util.List;

/**
 * Class to represent a Group. Has a Group Name and Members.
 */

public class Group {
    private String groupName;
    private List<Member> members;

    //todo is this necessary? or should i have it defaulted to empty
    public Group(String g, List<Member> m) {
        this.groupName = g;
        this.members = m;
    }

    public void setGroupName(String s) {
        this.groupName = s;
    }

    public void addMember(Member m) {
        this.members.add(m);
    }

    public String getGroupName() {
        return this.groupName;
    }

    public List<Member> getMembers() {
        return this.members;
    }
}
