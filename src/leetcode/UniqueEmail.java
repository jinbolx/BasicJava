package leetcode;

import java.util.HashSet;

public class UniqueEmail {

    public static void main(String[] args) {

    }

    public int numUniqueEmails(String[] emails) {
        if (emails == null || emails.length == 0) {
            return 0;
        }
        HashSet<String> set = new HashSet<>();
        for (String email : emails) {
            if (email.contains("@")) {
                String[] array = email.split("@");
                String start = array[0];
                String end = array[1];
                if (start.contains(".")) {
                    start = start.replace(".", "");
                }
                if (start.contains("+")) {
                    int plusIndex = start.indexOf("+");
                    start = start.substring(0, plusIndex);
                }
                set.add(start + end);
            }
        }
        return set.size();
    }
}
