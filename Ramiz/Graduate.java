public class Graduate extends Student{
    private String researchTopic;

    public Graduate(String firstName, String lastName, int studentId, String researchTopic) {
        super(firstName, lastName, studentId);  // Properly include the studentId in the superclass constructor.
        this.researchTopic = researchTopic;
    }
    public String getResearchTopic() {
        return researchTopic;
    }
    public void setResearchTopic(String researchTopic) {
        if (researchTopic == null || researchTopic.isEmpty()) {
            throw new IllegalArgumentException("Research topic cannot be empty.");
        }
        this.researchTopic = researchTopic;
    }
    public String toString() {
        return super.toString() + " | Research Topic: " + getResearchTopic();
    }
}
