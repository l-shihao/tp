package seedu.duke.commands;


import seedu.duke.project.Stat;

import java.util.ArrayList;

/**
 * Move a task from inbox to a folder. // For v1 at least.
 */
public class MoveCommand extends Command {

    public static final String COMMAND_WORD = "move";
    private int[] targetIndex;

    private String folderType;

    public MoveCommand(int[] targetIndex, String folderType) {
        this.targetIndex = targetIndex;
        this.folderType = folderType.toUpperCase(); //enum is all in uppercase.

    }

    @Override
    public void execute() {
        Stat stat = Stat.valueOf(folderType);
        var inbox = this.GTDLists.get("inbox");
        for (int i : targetIndex) {
            var thought = inbox.get(i - 1);
            System.out.println("Moving " + thought + " to " + stat);
            thought.setStatus(stat);
        }
    }
}
