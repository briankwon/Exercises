package com.brian.designPattern.Command;

/**
 * 参考：http://www.cnblogs.com/yangecnu/p/Implement-undo-redo-function-using-command-pattern.html
 */
public class Main {
    private static CommandManager commandManager = new CommandManager();
    private static Document document = new Document();

    public static void main(String[] args) {
        document.text = "Hello";
        appendX(document);
        System.out.println(document.text);
        undoAppendX(document);
        System.out.println(document.text);
        redoAppendX(document);
        System.out.println(document.text);
    }

    public static void appendX(Document document) {
        Command appendXExecute = new AppendX(document);
        commandManager.executeCommand(appendXExecute);
    }

    public static void undoAppendX(Document document) {
        commandManager.undo();
    }

    public static void redoAppendX(Document document) {
        commandManager.redo();
    }
}
