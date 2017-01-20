package com.company;

public class Core {

    public static Node init() {

        Question qInit = new Question("vive na água");
        Animal baleia = new Animal("Baleia");
        Animal leao = new Animal("Leao");

        Node init = new Node(qInit);
        init.getRight().setObject(baleia);
        init.getLeft().setObject(leao);

        return init;
    }

    public static void start() {
        UIGameI userInt = new UIGame();
        Node nodeQuestions = init();

        while (userInt.askSomething(
                "Pense em um animal",
                new String[]{"Ok", "Não quero jogar"})) {

            Boolean loop = true;
            Node current = nodeQuestions;

            while (loop) {
                if (current.getObject() instanceof Question) {
                    String question = "O animal que você pensou " + current.getObject().toString() + "?";
                    if (userInt.askSomething(question, null)) {
                        current = current.getRight();
                    } else {
                        current = current.getLeft();
                    }
                }

                if (current.getObject() instanceof Animal) {
                    if (askCurrentIsRight(userInt, current)) {
                        userInt.saySomething("Acertei de novo!");
                    } else {
                        Animal oldAnimal = (Animal) current.getObject();
                        Object[] ret = askWhichAnimal(userInt, current);

                        current.setObject(ret[1]);
                        if (current.getRight() != null) {
                            current.getRight().setObject(ret[0]);
                        } else {
                            current.setRight(new Node(ret[0]));
                        }

                        if (current.getLeft() != null) {
                            current.getLeft().setObject(oldAnimal);
                        } else {
                            current.setLeft(new Node(oldAnimal));
                        }
                    }

                    loop = false;
                }
            }
        }
    }

    public static Boolean askCurrentIsRight(UIGameI userInt, Node current) {
        return userInt.askSomething(
                "O animal que você pensou é um(a) " +
                        current.getObject().toString() + "? ", null);
    }

    public static Object[] askWhichAnimal(UIGameI userInt, Node current) {
        String animal = userInt.askSomethingInput("Qual animal você pensou?");
        String description = userInt.askSomethingInput(
                "O animal que você pensou (" + animal + ") ... mas " + current.getObject().toString() + " não ");

        Animal nAnimal = new Animal(animal);
        Question nQuestion = new Question(description);

        return new Object[] {nAnimal, nQuestion};
    }
}
