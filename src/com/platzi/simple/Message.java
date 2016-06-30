package com.platzi.simple;

import com.platzi.simple.constants.Messages;

/**
 * Create a custom message by arguments program entry
 */
public class Message {
    private final boolean isInitProgramByArgs;
    private String output;
    private String[] args;

    public Message(String[] args) {
        byte numArgs = (byte) args.length;
        this.args = args;
        this.isInitProgramByArgs = numArgs > 0;
    }
    
    public static void main(String[] args){
        Message message = new Message(args);
        message.setMessageByArguments();
        System.out.println(message.getOutput());
    }

    public void setMessageByArguments() {
        try {
            if (this.isInitProgramByArgs) {
                this.setOutput(this.printFirstArgument(this.args));

            } else {
                this.setOutput(this.sayHello());
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            this.setOutput(Messages.NOARGSERROR.getValue());
        }
    }

    public String printFirstArgument(String[] args) {
        return Messages.TITLENUMARGS.getValue() +
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
