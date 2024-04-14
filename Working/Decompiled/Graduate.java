package Working.Decompiled;

public class Graduate extends Student {
    private String researchTopic;

    public Graduate(String firstName, String lastName, int studentId, String researchTopic) {
        super(firstName, lastName, studentId);
        this.researchTopic = researchTopic;
    }

    // Additional methods or attributes specific to Graduate students go here

    public String getResearchTopic() {
        return researchTopic;
    }

    public void setResearchTopic(String researchTopic) {
        this.researchTopic = researchTopic;
    }

    @Override
    public String toString() {
        return super.toString() + " | Research Topic: " + getResearchTopic();
    }
}
