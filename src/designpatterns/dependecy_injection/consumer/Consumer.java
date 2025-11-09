package designpatterns.dependecy_injection.consumer;

public interface Consumer {

    void processMessages(String msg, String rec);
}