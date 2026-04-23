public class JokeClient {
    private ApiFacade facade;

    public JokeClient(ApiFacade facade) {
        this.facade = facade;
    }

    // Chuck Norris Jokes
    public String getRandomJoke() throws Exception {
        return facade.getAttributeValueFromJson("https://api.chucknorris.io/jokes/random", "value");
    }

    // Different API
    // Cat Facts
    public String getCatFact() throws Exception {
        return facade.getAttributeValueFromJson("https://catfact.ninja/fact", "fact");
    }

    public static void main(String[] args) {
        ApiFacade facade = new ApiFacadeImpl();
        JokeClient client = new JokeClient(facade);

        try {
            String fact = client.getCatFact();
            System.out.println(fact);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}