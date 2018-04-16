package com.brian.designPattern.Command;

public class AppendX implements Command {
    private Document document;
    private String previousText;

    AppendX(Document document) {
        this.document = document;
        this.previousText = this.document.text;
    }

    @Override
    public void execute() {
        document.text = document.text + "X";
    }

    @Override
    public void undoExecute() {
        document.text = previousText;
    }
}
