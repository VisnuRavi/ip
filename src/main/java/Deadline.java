import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    public LocalDateTime deadline;

    public Deadline(String str) {
        super(str);//super must be 1st line..
        String[] split = str.split("/");
        if(split.length < 2) {
            throw new IllegalArgumentException();
        }
        this.task = split[0].trim();
        String trimmed = split[1].trim();
        String[] split1 = trimmed.split(" ");
        if(split1.length != 2) {
            throw new ArrayIndexOutOfBoundsException(" Enter date and time in this format yyyy-mm-dd hh:mm\n");
        }
        this.deadline = LocalDateTime.parse(split1[0].trim() + "T" + split1[1]);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " " + "(by: " +
                deadline.format(DateTimeFormatter.ofPattern("MMM d yyyy HH:mm")) + ")";
    }
}
