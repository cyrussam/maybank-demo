package es.cyrus.dev.restexample;

class MyData {

    private long userId;
    private long id;
    private String title;   
    private String body;   

    // Required for JSON deserialization
    MyData() {
    }

    public MyData(String message) {
        this.body = message;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long UserId) {
        this.userId = UserId;
    }

    public long getId() {
        return id;
    }

    public void setId(long Id) {
        this.id = Id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String Title) {
        this.title = Title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String Body) {
        this.body = Body;
    }
}
