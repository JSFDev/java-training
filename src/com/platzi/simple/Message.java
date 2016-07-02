package com.platzi.simple;

import com.platzi.simple.constants.Messages;

/**
 * Create a custom message by arguments program entry
 */
public class Message {
    private final boolean isInitProgramByArgs;
    private String output;
    private String[] args = new String[4];

    public Message(String[] args) throws ArrayIndexOutOfBoundsException {
        byte numArgs = (byte) args.length;
        this.isInitProgramByArgs = numArgs > 0;
        this.args = args;
    }

    public static void main(String[] args) {
        try {
            Message message = new Message(args);
            message.setMessageByArguments();
            System.out.print(message.getOutput());

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.print(Messages.NOARGSERROR.getValue());
        }
    }

    public void setMessageByArguments() {
        if (this.isInitProgramByArgs) {
            this.setOutput(this.printFirstArgument(this.args));

        } else {
            this.setOutput(this.sayHello());
        }
    }

    public String printFirstArgument(String[] args) {
        return Messages.TITLENUMARGS.getValue() + this.args.length +
                Messages.FIRST.getValue() +
                Messages.ARGS.getValue() + args[0];
    }

    public String sayHello() {
        return Messages.getRandomGreet().getValue();
    }

    public String getOutput() {
        return this.output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}
