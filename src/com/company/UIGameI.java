package com.company;

public interface UIGameI {

    public void saySomething(String something);

    public boolean askSomething(String something, Object[] options);

    public String askSomethingInput(String something);
}
