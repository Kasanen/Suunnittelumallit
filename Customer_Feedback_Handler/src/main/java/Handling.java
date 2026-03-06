public abstract class Handling {
    private Handling nextHandler;

    public void process(Message message) {
        if(nextHandler != null){
            nextHandler.process(message);
        }
    }
    public void setNextHandler(Handling nextHandler) {
        this.nextHandler = nextHandler;
    }
}
