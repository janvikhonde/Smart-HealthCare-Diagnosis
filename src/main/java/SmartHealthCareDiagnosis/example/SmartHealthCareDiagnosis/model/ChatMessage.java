package SmartHealthCareDiagnosis.example.SmartHealthCareDiagnosis.model;

public class ChatMessage {
    private String message;
    private String sender; // "user" or "ai"
    private String timestamp;

    public ChatMessage() {}

    public ChatMessage(String message, String sender) {
        this.message = message;
        this.sender = sender;
        this.timestamp = java.time.LocalTime.now().toString();
    }

    // Getters and Setters
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getSender() { return sender; }
    public void setSender(String sender) { this.sender = sender; }

    public String getTimestamp() { return timestamp; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }
}