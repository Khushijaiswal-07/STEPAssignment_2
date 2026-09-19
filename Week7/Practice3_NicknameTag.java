final class NameTag {
    private final String firstName;
    private final String lastName;

    public NameTag(String fullName) {
        String[] parts = fullName.split(" ", 2);

        firstName = parts[0];
        lastName = parts[1];
    }

    public String getNickname() {
        return firstName + " " + lastName.charAt(0) + ".";
    }
}

public class Practice3_NicknameTag {
    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Garcia");

        System.out.println("Nickname: " + tag.getNickname());
    }
}