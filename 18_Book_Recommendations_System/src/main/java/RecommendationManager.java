import java.util.HashMap;
import java.util.Map;

public class RecommendationManager {
    private static RecommendationManager instance; // Singleton
    private Map<String, Recommendation> recommendations;

    private RecommendationManager() {
        recommendations = new HashMap<>();
    }

    public static RecommendationManager getInstance() {
        if (instance == null) {
            instance = new RecommendationManager();
        }
        return instance;
    }

    public void addRecommendation(Recommendation recommendation) {
        recommendations.put(recommendation.getTargetAudience(), recommendation);
    }

    public Recommendation getRecommendation(String audience) {
        return recommendations.get(audience);
    }

    public Recommendation cloneRecommendation(String audience) {
        Recommendation original = getRecommendation(audience);
        if (original == null) {
            System.out.println("Recommendation not found for: " + audience);
            return null;
        }
        return original.clone();
    }

    public void removeRecommendation(String audience) {
        recommendations.remove(audience);
    }

    public void listAll() {
        if (recommendations.isEmpty()) {
            System.out.println("No recommendations available.");
            return;
        }
        for (Recommendation r : recommendations.values()) {
            System.out.println(r);
        }
    }
}