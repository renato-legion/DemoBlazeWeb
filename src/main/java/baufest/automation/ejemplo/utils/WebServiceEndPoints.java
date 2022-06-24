package baufest.automation.ejemplo.utils;

public enum WebServiceEndPoints {

    URL_SECURITY_LOGIN("/login"),
    API_HISTORICAL_INBOX("/inbox/search/filterHistorical?page=0&size=4&sortBy=FLAG_SUPERVISOR&direction=DESCENDING"),
    API_ASSIGNEE_MASIVE_TASK("/bpm-tasks/assignee-masive-task");

    private final String url;


    WebServiceEndPoints(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

}
